package com.lei.main.system.attendance.service.impl;

import com.lei.main.comm.dao.redis.RedisUtil;
import com.lei.main.comm.util.Constant;
import com.lei.main.system.attendance.bean.Attendance;
import com.lei.main.system.attendance.bean.Member;
import com.lei.main.system.attendance.bean.TempCourse;
import com.lei.main.system.attendance.dao.AttendanceDao;
import com.lei.main.system.attendance.service.AttendanceService;
import com.lei.main.system.course.bean.Course;
import com.lei.main.system.systemManager.bean.User;
import com.lei.main.system.systemManager.service.UserManager;
import com.lei.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Transactional
@Service("attendanceService")
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceDao attendanceDao;
    @Autowired
    private UserManager userManager;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Attendance getAttendanceById(String id) {
        return attendanceDao.getAttendanceById(id);
    }

    @Override
    public Attendance getAttendanceById(String uid, String cid) {
        return attendanceDao.getAttendanceById(uid, cid);
    }

    @Override
    public Boolean saveAttendanceInfo(Attendance attendance) {
        return attendanceDao.saveAttendanceInfo(attendance);
    }

    @Override
    public TempCourse getTempCourse(String id) {
        return (TempCourse)redisUtil.getHashItem(Constant.courseSet, id);
    }

    @Override
    public Member getCourseMemberById(String cid, String uid) {
        return (Member)redisUtil.getHashItem(Constant.userPre + cid, uid);
    }

    @Override
    public Map<String, Member> getCourseMemberList(String cid) {
        //redisUtil.expire(Constant.userPre + cid, overTime, TimeUnit.MINUTES);//设置群组过期时间
        return  (Map<String, Member>)redisUtil.getHash(Constant.userPre + cid);
    }

    @Override
    public void saveCourseMember(String cid, Member m) throws Exception {
        redisUtil.setHashItem(Constant.userPre + cid, m.getId().toString(), m);
    }

    @Override
    public void updateCourseWeek() throws Exception {
        attendanceDao.cancelCurrentWeek();
        attendanceDao.addCourseWeek(1);
        attendanceDao.updateCourseStatusWeek();
    }

    @Override
    public void updateCourseDay() throws Exception {
        int day = DateUtils.dayOfWeek() - 1;
        attendanceDao.cancelCurrentDay();
        attendanceDao.updateCourseStatusDay(day);
    }

    @Override
    public void updateCourseStart() throws Exception {
        List<Course> list = attendanceDao.getWillStartCourse();
        for (int i = 0; i < list.size(); i++) {
            Course c = list.get(i);
            String key = c.getId().toString();
            c.setIsAttend(3);
            TempCourse temp = new TempCourse(c, 20);
            redisUtil.setHashItem(Constant.courseSet, key, temp);
        }
    }

    @Override
    public List<Course> getStartCourse() {
        return attendanceDao.getStartCourse();
    }

    @Override
    public void updateCourseEnd() throws Exception {
        List<Course> list = attendanceDao.getHadEndCourse();
        for (Course c : list) {
            String key = c.getId().toString();
            Map<String, Member> members = getCourseMemberList(key);
            List<Attendance> users = attendanceDao.getCourseUserList(key);
            for (Attendance a : users) {
                String uid = a.getUserId().toString();
                User user = userManager.getUserById(uid);
                Member m = members.get(uid);
                if (m == null) {//登记学生上课情况
                    user.registerTimes();
                    a.registerTimes();
                } else {
                    user.registerTimes(m);
                    a.registerTimes(m);
                }
            }
            c.setIsAttend(2);
            redisUtil.deleteHashItem(Constant.courseSet, key);
            redisUtil.delete(Constant.userPre + key);
        }
    }

}
