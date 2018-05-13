package com.lei.main.system.attendance.service;

import com.lei.main.system.attendance.bean.Attendance;
import com.lei.main.system.attendance.bean.Member;
import com.lei.main.system.attendance.bean.TempCourse;
import com.lei.main.system.course.bean.Course;

import java.util.List;
import java.util.Map;

public interface AttendanceService {

    Attendance getAttendanceById(String id);

    Attendance getAttendanceById(String uid, String cid);

    Boolean saveAttendanceInfo(Attendance attendance);

    TempCourse getTempCourse(String id);

    Member getCourseMemberById(String cid, String uid);

    Map<String, Member> getCourseMemberList(String cid);

    void saveCourseMember(String cid, Member m) throws Exception;

    void updateCourseWeek() throws Exception;

    void updateCourseDay() throws Exception;

    void updateCourseStart() throws Exception;

    List<Course> getStartCourse();

    void updateCourseEnd() throws Exception;

}
