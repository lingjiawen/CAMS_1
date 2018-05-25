package com.lei.main.comm.bean;

import com.lei.main.system.systemManager.bean.User;

public class DictionaryEntity extends Entity {

    private String id;
    private String name;

    public DictionaryEntity() {}

    public DictionaryEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public DictionaryEntity(User g) {
        this.id = g.getUserId().toString();
        this.name = g.getUserName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
