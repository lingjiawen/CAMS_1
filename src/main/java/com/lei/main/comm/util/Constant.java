package com.lei.main.comm.util;

import com.lei.main.system.systemManager.bean.City;
import com.lei.main.system.systemManager.bean.TeachBuilding;
import com.lei.main.system.systemManager.bean.School;

import java.util.HashMap;
import java.util.Map;


public class Constant {
    public static final String courseSet = "courses";
    public static final String groupPre = "g";
    public static final String userPre = "u";

    public static final String schemaPattern = "KK";
    public static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
    public static final String sqlDateFormat = "yyyy-mm-dd HH24:mi:ss";

    public static Map<String,School> DSchool = new HashMap<String,School>();//学校
    public static Map<String,TeachBuilding> DTeachBuilding = new HashMap<String,TeachBuilding>();//教学楼
    public static Map<String,City> DCity = new HashMap<String,City>();//城市
}