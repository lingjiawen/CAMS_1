package com.lei.main.system.systemManager.bean;

import com.lei.util.TableName;
import com.wordnik.swagger.annotations.ApiModel;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@ApiModel("学校教学楼")
@Entity
@Table(name= TableName.SchoolBuilding)
public class SchoolBuilding {

    private Integer id;
    private Integer schoolId;
    private Integer buildingId;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name="school_id")
    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }
    @Column(name="building_id")
    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }
}
