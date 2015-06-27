package com.wangkai.wkdemo.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * User: WangKai(123940232@qq.com)
 * 2014-12-19 15:49
 */
@DatabaseTable(tableName = "tb_user")       //如果不指定表名，则默认用类名做为表名
public class User {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "name")
    private  String name;
    @DatabaseField(columnName = "desc")
    private  String desc;

    //必须要有一个空的构造函数
    public User() {
    }

    public User(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public User(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
