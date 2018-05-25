package com.lei.main.system.systemManager.dao;

import com.lei.main.comm.dao.BaseDao;
import com.lei.main.system.systemManager.bean.TeachBuilding;
import com.lei.main.system.systemManager.bean.School;

import java.util.Map;

public interface DictionaryDao extends BaseDao {

    Map<String,School> getSchoolDictionaryItems();

    Map<String,TeachBuilding> getTeachBuildingDictionaryItems();
}
