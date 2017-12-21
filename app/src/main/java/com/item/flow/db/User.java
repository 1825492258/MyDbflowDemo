package com.item.flow.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Jie on 2017/12/21.
 * 创建Model
 * 必须继承BaseModel，BaseModel包含了基本的数据库操作（save,delete,update,insert,exists）
 */
@Table(database = AppDatabase.class)
public class User extends BaseModel{
    // 主键
    @Column
    @PrimaryKey
    private String id;
    @Column  // column 表示一栏一列
    private String name; // 自己需要存贮的字段
    @Column
    private String phone;
    @Column
    private String desc;
    @Column
    private int sex = 0;
    public User(){}
    public User(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", desc='" + desc + '\'' +
                ", sex=" + sex +
                '}';
    }
}
