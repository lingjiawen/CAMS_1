package com.lei.main.system.attendance.service.impl;

import com.lei.main.comm.dao.redis.RedisUtil;
import com.lei.main.comm.util.Constant;
import com.lei.main.system.attendance.bean.Attendance;
import com.lei.main.system.attendance.bean.Member;
import com.lei.main.system.attendance.bean.TempCourse;
import com.lei.main.system.attendance.dao.AttendanceDao;
import com.lei.main.system.attendance.service.AttendanceService;
import com.lei.main.system.course.bean.Course;
import com.lei.main.system.systemManager.bean.TeachBuilding;
import com.lei.main.system.systemManager.bean.User;
import com.lei.main.system.systemManager.service.UserManager;
import com.lei.util.DateUtils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service("attendanceService")
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceDao attendanceDao;
    @Autowired
    private UserManager userManager;

    @Autowired
    private RedisUtil redisUtil;

    private String apikey = "********************";

    private static String URI_SEND_SMS = "https://sms.yunpian.com/v2/sms/single_send.json";

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
            String[] s = c.getClassroom().split("-");
            TeachBuilding building = Constant.DTeachBuilding.get(s[0]);
            c.setIsAttend(3);
            TempCourse temp = new TempCourse(c, building, 20);
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

    @Override
    public String sendSmsCode(String phone, String name, String course) {
        int inf=-1;
        String text="您好，"+name+"同学，您的课程："+course+"开始了，该上课啦！";
        Map < String, String > params = new HashMap< String, String >();
        params.put("apikey", apikey);
        params.put("text", text);
        params.put("mobile", phone);
        return post(URI_SEND_SMS, params);
    }

    /**
     * 基于HttpClient 4.3的通用POST方法
     *
     * @param url       提交的URL
     * @param paramsMap 提交<参数，值>Map
     * @return 提交响应
     */

    private String post(String url, Map < String, String > paramsMap) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost method = new HttpPost(url);
            if (paramsMap != null) {
                List < NameValuePair > paramList = new ArrayList<NameValuePair >();
                for (Map.Entry < String, String > param: paramsMap.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(param.getKey(),
                            param.getValue());
                    paramList.add(pair);
                }
                method.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
            }
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity, "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }

}
