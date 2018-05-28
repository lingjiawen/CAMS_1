package com.lei.main.system.course.action;

import com.lei.main.comm.bean.Message;
import com.lei.main.comm.dao.page.DataStore;
import com.lei.main.comm.util.Common;
import com.lei.main.comm.util.Constant;
import com.lei.main.system.attendance.bean.Attendance;
import com.lei.main.system.attendance.bean.Member;
import com.lei.main.system.attendance.service.AttendanceService;
import com.lei.main.system.course.bean.Course;
import com.lei.main.system.course.bean.TempUser;
import com.lei.main.system.course.service.CourseService;
import com.lei.main.system.group.service.GroupService;
import com.lei.main.system.systemManager.bean.SchoolBuilding;
import com.lei.main.system.systemManager.bean.TeachBuilding;
import com.lei.main.system.systemManager.bean.User;
import com.lei.main.system.systemManager.service.DictionaryManager;
import com.mangofactory.swagger.annotations.ApiIgnore;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private DictionaryManager dictionaryManager;

    @ApiOperation(value = "根据id获取课程信息", notes ="0失败，1成功")
    @RequestMapping(value = "getCourseById.do", method = RequestMethod.POST)
    @ResponseBody
    public Message<Course> getCourseById(@ApiParam("课程编号")@RequestParam String id) {
        Course course = courseService.getCourseInfoById(id);
        return Common.messageBox(course);
    }

    @ApiOperation(value = "获取当前进行的课程", notes ="0失败，1成功")
    @RequestMapping(value = "getAttendCourse.do", method = RequestMethod.POST)
    @ResponseBody
    public Message<Object> getAttendCourse(HttpServletRequest request) {
        User user = Common.getCurrentUser(request);
        Object course = courseService.getAttendCourse(user.getUserId().toString());
        return Common.messageBox(course);
    }

    @ApiOperation(value = "根据id获取今日课程信息", notes ="0失败，1成功")
    @RequestMapping(value = "getTodayCourseById.do", method = RequestMethod.POST)
    @ResponseBody
    public Message<List> getTodayCourseList(HttpServletRequest request) {
        User user = Common.getCurrentUser(request);
        List list = courseService.getTodayCourseList(user.getUserId().toString());
        return Common.messageBox(list);
    }

    @ApiOperation(value = "根据名称查找课程", notes ="无")
    @RequestMapping(value = "getCourseListByName.do", method = RequestMethod.POST)
    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "课程名", paramType = "query", dataType = "String")})
    @ResponseBody
    public DataStore getCourseListByName(@ApiIgnore String name,
                                         @ApiParam("页码")@RequestParam String page,
                                         @ApiParam("显示条数")@RequestParam String rows) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", name);
        params.put("page", page);
        params.put("rows", rows);
        DataStore data = courseService.getCourseListByName(params);
        return data;
    }

    @ApiOperation(value = "根据学校查找教学楼", notes ="无")
    @RequestMapping(value = "getSchoolTeachBuildingList.do", method = RequestMethod.POST)
    @ResponseBody
    public Message<List> getSchoolTeachBuildingList(HttpServletRequest request) {
        User user = Common.getCurrentUser(request);
        List<TeachBuilding> list = courseService.getSchoolTeachBuildingList(user.getSchool());
        return Common.messageBox(list);
    }

    @ApiOperation(value = "修改或新建课程信息", notes ="填编号为修改，不填为新建；0失败，1成功，2上课期间无法修改，3自动加入课程失败请手动加入")
    @RequestMapping(value = "saveCourseInfo.do", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "课程编号", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "name", value = "课程名", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "week", value = "上课周数，','分割", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "current", value = "当前周", paramType = "query", dataType = "Long", required = true),
            @ApiImplicitParam(name = "day", value = "上课星期，','分割", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "period", value = "上课节数", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "startTime", value = "开始时间", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "endTime", value = "结束时间", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "remainderTimes", value = "剩余次数", paramType = "query", dataType = "Long", required = true),
            @ApiImplicitParam(name = "totalTimes", value = "总次数", paramType = "query", dataType = "Long", required = true),
            @ApiImplicitParam(name = "remark", value = "备注", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "classroom", value = "课室，'-'分隔，如'A1-201'", paramType = "query", dataType = "String")})
    @ResponseBody
    public Message<String> saveCourseInfo(HttpServletRequest request, @ApiIgnore Course course) {
        Boolean rs = false;
        String s = course.getWeek();//修改week格式
        if (!s.substring(0,1).equals(",")) {
            s = "," + s;
        }
        if (!s.substring(s.length() - 1).equals(",")) {
            s = s + ",";
        }
        course.setWeek(s);
        s = course.getDay();//修改day格式
        if (!s.substring(0,1).equals(",")) {
            s = "," + s;
        }
        if (!s.substring(s.length() - 1).equals(",")) {
            s = s + ",";
        }
        course.setDay(s);
        if (course.getId() != null) {
            Course c = courseService.getCourseInfoById(course.getId().toString());
            if (c != null) {
                if (c.getIsAttend() == 3)  {
                    return Common.messageBox("2", "上课期间，无法修改");
                }
                c.setCourseBaseInfo(course);
                rs = courseService.saveCourseInfo(c);
            } else {
                course.setId(null);
            }
        }
        if (course.getId() == null) {
            course.setCourseDefaultValue();
            rs = courseService.saveCourseInfo(course);
            if (rs) {
                User user = Common.getCurrentUser(request);
                Attendance attendance = new Attendance(user.getUserId(), course.getId());
                rs = attendanceService.saveAttendanceInfo(attendance);
                if (!rs) {
                    return Common.messageBox("3", "自动加入课程失败，请稍后手动加入");
                }
            }
        }
        if (rs) {
            return Common.messageBox(Common.success);
        } else {
            return Common.messageBox(Common.failed);
        }
    }

    @ApiOperation(value = "学生加入课程", notes ="0失败，1成功，2已加入，3课程不存在")
    @RequestMapping(value = "joinCourseById.do", method = RequestMethod.POST)
    @ResponseBody
    public Message<String> joinCourseById(HttpServletRequest request, @ApiParam("课程编号")@RequestParam Integer courseId) {
        User user = Common.getCurrentUser(request);
        Course c = courseService.getCourseInfoById(courseId.toString());
        if (c == null) {
            return Common.messageBox("3", "课程不存在");
        }
        Attendance attendance = attendanceService.getAttendanceById(user.getUserId().toString(), courseId.toString());
        if (attendance != null) {
            if (attendance.getIsQuit() == 0) {
                return Common.messageBox("2", "已加入课程");
            }
        }
        attendance = new Attendance(user.getUserId(), courseId);
        Boolean rs = attendanceService.saveAttendanceInfo(attendance);
        if (rs) {
            return Common.messageBox(Common.success);
        } else {
            return Common.messageBox(Common.failed);
        }
    }

    @ApiOperation(value = "获取课程出勤情况", notes ="0失败，1成功")
    @RequestMapping(value = "getCourseAttendInfo.do", method = RequestMethod.POST)
    @ResponseBody
    public Message<List> getCourseAttendInfo(@ApiParam("群组编号")@RequestParam String gid,
                                             @ApiParam("课程编号")@RequestParam String cid) {
        List l = new ArrayList();
        List<User> list = courseService.getCourseGroupUserList(cid, gid);
        for (User o : list) {
            TempUser t = new TempUser(o);
            Member m = attendanceService.getCourseMemberById(cid, o.getUserId().toString());
            if (m == null) {//是否签到
                t.setIsAttend(0);
            } else {
                t.setIsAttend(m.getIsAttend());
            }
            try {
                l.add(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Common.messageBox(l);
    }

    @ApiOperation(value = "修改或新增教学楼", notes ="0失败，1成功，2未填学校编号")
    @RequestMapping(value = "saveTeachBuilding.do", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "学校编号", paramType = "query", dataType = "Long", required = true),
            @ApiImplicitParam(name = "name", value = "教学楼名", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "lng", value = "经度", paramType = "query", dataType = "Double", required = true),
            @ApiImplicitParam(name = "lat", value = "纬度", paramType = "query", dataType = "Double", required = true)})
    @ResponseBody
    public Message<String> saveTeachBuilding(@ApiIgnore TeachBuilding building) {
        if (building.getId() == null) {
            return Common.messageBox("2", "未填写学校编号");
        }
        TeachBuilding b = courseService.getTeachBuildingByName(building.getId().toString(), building.getName());
        Boolean rs = false;
        if (b != null) {
            building.setId(b.getId());
            rs = courseService.saveTeachBuilding(building);
        } else {
            SchoolBuilding sb = new SchoolBuilding();
            sb.setSchoolId(building.getId());//学校编号
            building.setId(null);
            rs = courseService.saveTeachBuilding(building);
            sb.setBuildingId(building.getId());//教学楼编号
            courseService.saveSchoolBuilding(sb);
        }

        if (rs) {
            Constant.DTeachBuilding = dictionaryManager.getTeachBuildingDictionaryItems();
            return Common.messageBox(Common.success);
        } else {
            return Common.messageBox(Common.failed);
        }
    }

    /*@ApiOperation(value = "学生加入群组的所有课程", notes ="0失败，1成功，2群组不存在，3不在群组中")
    @RequestMapping(value = "joinGroupCourse.do", method = RequestMethod.POST)
    @ResponseBody
    public Message<String> joinGroupCourse(HttpServletRequest request, @ApiParam("群组编号")@RequestParam String gid) {
        User user = Common.getCurrentUser(request);
        Group group = groupService.getGroupById(gid);
        if (group == null) {
            return Common.messageBox("2", "群组不存在");
        }
        GroupUser groupUser = groupService.getGroupUserById(gid, user.getUserId().toString());
        if (groupUser == null) {
            return Common.messageBox("3", "您不在该群组中");
        }
        List<Map> list = groupService.getGroupCourseList(gid);
        for (Map m: list) {
            Integer id = (Integer)m.get("course_id");
            joinCourseById(request, id);
        }
        return Common.messageBox(Common.success);
    }*/
}
