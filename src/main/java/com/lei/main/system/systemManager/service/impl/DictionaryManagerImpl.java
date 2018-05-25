package com.lei.main.system.systemManager.service.impl;

import com.lei.main.system.systemManager.bean.TeachBuilding;
import com.lei.main.system.systemManager.bean.School;
import com.lei.main.system.systemManager.dao.DictionaryDao;
import com.lei.main.system.systemManager.service.DictionaryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Transactional
@Service("dictionaryManager")
public class DictionaryManagerImpl implements DictionaryManager {

    @Autowired
    private DictionaryDao dictionaryDao;

    @Override
    public Map<String, School> getSchoolDictionaryItems() {
        return dictionaryDao.getSchoolDictionaryItems();
    }

    @Override
    public Map<String, TeachBuilding> getTeachBuildingDictionaryItems() {
        return dictionaryDao.getTeachBuildingDictionaryItems();
    }
}
