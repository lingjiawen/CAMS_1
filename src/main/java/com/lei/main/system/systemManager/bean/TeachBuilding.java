package com.lei.main.system.systemManager.bean;

import com.lei.util.TableName;
import com.wordnik.swagger.annotations.ApiModel;

import javax.persistence.*;

@ApiModel("教学楼")
@Entity
@Table(name= TableName.TeachBuilding)
public class TeachBuilding {

    private Integer id;
    private String name;
    private Double lng;
    private Double lat;

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
    @Column(name="lng")
    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
    @Column(name="lat")
    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}
