package com.wkp.fasterxmltest;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Company {

    private String name;

    //java属性headquarters序列化到json字段的名称为HQ
    @JsonProperty("HQ")
    private String headquarters;

    private Department[] departments;

    //在序列化与反序列化时，忽略birthDate属性
    @JsonIgnore
    private Date birthDate;

    public Date getBirthDate() {
        return birthDate;
    }

    @JsonCreator
    public Company(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public Department[] getDepartments() {
        return departments;
    }

    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

}
