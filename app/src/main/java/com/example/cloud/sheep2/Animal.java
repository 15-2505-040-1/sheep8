package com.example.cloud.sheep2;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by cloud on 2017/12/17.
 */

public class Animal extends RealmObject {
    @PrimaryKey
    private long id;
    private String type;
    private String name;
    private String detail;
    private boolean bo;

    public boolean isBo() {
        return bo;
    }

    public void setBo(boolean bo) {
        this.bo = bo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



}
