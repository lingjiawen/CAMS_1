package com.lei.main.system.course.bean;

import com.lei.main.comm.bean.Entity;
import com.lei.main.system.systemManager.bean.User;

public class TempUser extends Entity {

    private Integer id;
    private String name;
    private Integer isAttend;

    public TempUser() {}

    public TempUser(User user) {
        this.id = user.getUserId();
        this.name = user.getUserName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsAttend() {
        return isAttend;
    }

    public void setIsAttend(Integer isAttend) {
        this.isAttend = isAttend;
    }
}
