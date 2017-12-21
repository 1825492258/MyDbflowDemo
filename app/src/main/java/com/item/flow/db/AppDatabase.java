package com.item.flow.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by Jie on 2017/12/21.
 * 创建数据库
 */
@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
public class AppDatabase {
    // 数据库的名称
    public static final String NAME = "AppDatabase";
    // 数据库的版本号
    public static final int VERSION = 1;
}
