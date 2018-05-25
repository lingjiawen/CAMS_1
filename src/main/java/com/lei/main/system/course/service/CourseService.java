package com.lei.main.system.course.service;

import com.lei.main.comm.dao.page.DataStore;
import com.lei.main.system.course.bean.Course;
import com.lei.main.system.systemManager.bean.SchoolBuilding;
import com.lei.main.system.systemManager.bean.TeachBuilding;

import java.util.List;
import java.util.Map;

public interface CourseService {
    Course getCourseInfoById(String id);

    Object getAttendCourse(String id);

    DataStore getCourseListByName(Map<String,String> map);

    List getTodayCourseList(String id);

    Boolean saveCourseInfo(Course course);

    List getCourseGroupList(String id);

    List getCourseGroupUserList(String cid, String gid);

    List<TeachBuilding> getSchoolTeachBuildingList(String id);

    Boolean saveTeachBuilding(TeachBuilding teachBuilding);

    TeachBuilding getTeachBuildingByName(String id, String name);

    Boolean saveSchoolBuilding(SchoolBuilding schoolBuilding);
}
