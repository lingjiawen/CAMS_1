package com.lei.main.system.attendance.action;

import com.lei.main.comm.bean.Message;
import com.lei.main.comm.util.Common;
import com.lei.main.system.attendance.bean.Member;
import com.lei.main.system.attendance.bean.TempCourse;
import com.lei.main.system.attendance.service.AttendanceService;
import com.lei.main.system.course.service.CourseService;
import com.lei.main.system.group.service.GroupService;
import com.lei.util.DateUtils;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping(value="/attendance")
public class AttendanceController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    /**
     * 考察课堂迟到情况
     * @param cid 课程编号
     * @throws InterruptedException
     */
    @Async
    public void attendance(String cid) {
        TempCourse t = attendanceService.getTempCourse(cid);
        if (t == null) {
            return;
        }
        Map<String, Member> map = attendanceService.getCourseMemberList(cid);
        for (Member m : map.values()) {
            //todo
            if (!t.judgePosition(m.getLng(), m.getLat())) {
                m.setStatus(1);//迟到
                try {
                    attendanceService.saveCourseMember(cid, m);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //pushNotice(m.getId().toString());//通知提醒
            }
        }
        //System.out.println(Thread.currentThread().getName());
    }

    @ApiOperation(value = "记录用户位置", notes ="0失败，1成功，2课程未开始，3课程已结束,4不在上课范围内")
    @RequestMapping(value = "recordPosition.do", method = RequestMethod.POST)
    @ResponseBody
    public Message<String> recordPosition(HttpServletRequest request,
                                  @ApiParam("课程编号")@RequestParam String cid,
                                  @ApiParam("经度")@RequestParam Double lng,
                                  @ApiParam("纬度")@RequestParam Double lat) {
        Integer uid = Common.getCurrentUser(request).getUserId();
        TempCourse t = attendanceService.getTempCourse(cid);
        if (t == null) {
            return Common.messageBox("2", "所选课程还未开始");
        }
        Time t1 = t.getEndTime();
        Date t2 = null;
        try {
            t2 = DateUtils.parseTime(DateUtils.currentTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (t1.before(t2)) {
            return Common.messageBox("3", "课程已结束");
        }
        Member m;
        Boolean rs = false;
        if (t.judgePosition(lng, lat)) {//是否正确签到
            m = new Member(uid, lng, lat, 1);
            rs = true;
        } else {
            m = new Member(uid, lng, lat, 0);
        }
        try {
            attendanceService.saveCourseMember(cid, m);
        } catch (Exception e) {
            e.printStackTrace();
            return Common.messageBox(Common.failed);
        }
        if (rs) {
            return Common.messageBox(Common.success);
        } else {
            return Common.messageBox("4", "未处于上课范围内");
        }
    }

    private void pushNotice(String id) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(id+"迟到啦？！！");
    }

}
