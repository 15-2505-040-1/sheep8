package com.example.cloud.sheep2;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by cloud on 2017/12/14.
 */

public class Item extends RealmObject {
    @PrimaryKey
    private long id;
    private int num;
    private static boolean bo;
    private String name;
    private String detail;
    private String k;

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public static boolean isBo() {
        return bo;
    }

    public void setBo(boolean bo) {
        this.bo = bo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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


}
