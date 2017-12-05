package com.example.cloud.sheep2;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by cloud on 2017/11/30.
 */
public class Skill extends RealmObject {

    @PrimaryKey
    private int id;
    private String skill;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }
    public void setSkill(String skill) {
        this.skill = skill;
    }
}
