package com.lei.main.system.systemManager.service;

import com.lei.main.system.systemManager.bean.TeachBuilding;
import com.lei.main.system.systemManager.bean.School;

import java.util.Map;

public interface DictionaryManager {

    Map<String,School> getSchoolDictionaryItems();

    Map<String,TeachBuilding> getTeachBuildingDictionaryItems();
}
