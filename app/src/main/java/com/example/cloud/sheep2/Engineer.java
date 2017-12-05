package com.example.cloud.sheep2;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by cloud on 2017/11/30.
 */
public class Engineer extends RealmObject {

    @PrimaryKey
    private int id;
    private int level;
    private String name;
    private String businessTitle;
    private RealmList<Skill> skills;
    private Date createDateTime;
    private Date updateDateTime;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessTitle() {
        return businessTitle;
    }
    public void setBusinessTitle(String businessTitle) {
        this.businessTitle = businessTitle;
    }

    public RealmList<Skill> getSkills() {
        return skills;
    }
    public void setSkills(RealmList<Skill> skills) {
        this.skills = skills;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }
    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }
    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
}