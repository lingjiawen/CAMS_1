package com.lei.main.system.systemManager.bean;

import com.lei.util.TableName;
import com.wordnik.swagger.annotations.ApiModel;

import javax.persistence.*;

@ApiModel("学校")
@Entity
@Table(name= TableName.School)
public class School {

    private Integer id;
    private String name;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
