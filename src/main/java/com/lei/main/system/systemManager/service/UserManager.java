package com.lei.main.system.systemManager.service;

import com.lei.main.system.systemManager.bean.School;
import com.lei.main.system.systemManager.bean.User;

import java.util.List;
import java.util.Map;


public interface UserManager {
    
    /**保存用户信息
     * @param user
     * @throws Exception
     */
    Boolean saveUser(User user);

    /**通过id获取User
     * @param id
     * @return
     * @throws Exception
     */
    User getUserById(String id);

    User getUserByPhone(String phone);

    User getUserByUserName(String name);

    Boolean saveSchool(School school);

}
