package com.lei.main.system.systemManager.dao.impl;

import com.lei.main.comm.dao.jdbc.BaseDaoImpl;
import com.lei.main.system.systemManager.bean.TeachBuilding;
import com.lei.main.system.systemManager.bean.School;
import com.lei.main.system.systemManager.dao.DictionaryDao;
import com.lei.util.TableName;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("dictionaryDao")
public class DictionaryDaoImpl extends BaseDaoImpl implements DictionaryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Map<String, School> getSchoolDictionaryItems() {
        Map map = new HashMap();
        String sql = "select * from "+ TableName.School;
        List<School> list = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(School.class).list();
        for (School school : list) {
            map.put(school.getId().toString(), school);
        }
        return map;
    }

    @Override
    public Map<String, TeachBuilding> getTeachBuildingDictionaryItems() {
        Map map = new HashMap();
        String sql = "select * from "+ TableName.TeachBuilding;
        List<TeachBuilding> list = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(TeachBuilding.class).list();
        for (TeachBuilding teachBuilding : list) {
            map.put(teachBuilding.getName(), teachBuilding);
        }
        return map;
    }
}
