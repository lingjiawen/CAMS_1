package com.lei.main.system.course.dao;

import com.lei.main.comm.dao.BaseDao;
import com.lei.main.comm.dao.page.DataStore;
import com.lei.main.system.course.bean.Course;
import com.lei.main.system.systemManager.bean.SchoolBuilding;
import com.lei.main.system.systemManager.bean.TeachBuilding;
import com.lei.main.system.systemManager.bean.User;

import java.util.List;
import java.util.Map;

public interface CourseDao extends BaseDao {

    Course getCourseInfoById(String id);

    Object getAttendCourse(String id);

    List getTodayCourseList(String id);

    DataStore getCourseListByName(Map<String,String> map);

    Boolean saveCourseInfo(Course course);

    List getCourseGroupList(String id);

    List<User> getCourseGroupUserList(String cid, String gid);

    List<TeachBuilding> getSchoolTeachBuildingList(String id);

    Boolean saveTeachBuilding(TeachBuilding teachBuilding);

    TeachBuilding getTeachBuildingByName(String id, String name);

    Boolean saveSchoolBuilding(SchoolBuilding schoolBuilding);
}
