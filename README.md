# MyDBFlowDemo
DBFlow的简单使用

## DBFlow
### https://github.com/Raizlabs/DBFlow
### https://yumenokanata.gitbooks.io/dbflow-tutorials/content/index.html

### 第一：添加依赖
annotationProcessor "com.github.Raizlabs.DBFlow:dbflow-processor:${dbflow_version}"
compile "com.github.Raizlabs.DBFlow:dbflow-core:${dbflow_version}"
compile "com.github.Raizlabs.DBFlow:dbflow:${dbflow_version}"

### 第二：创建一个Application
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(new FlowConfig.Builder(this).build());
    }
}

### 第三：建立数据库
@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
public class AppDatabase {
    // 数据库的名称
    public static final String NAME = "AppDatabase";
    // 数据库的版本号
    public static final int VERSION = 1;
}

### 第四：建立Table
@Table(database = AppDatabase.class)
public class User extends BaseModel{
    // 主键
    @Column
    @PrimaryKey
    private String id;
    @Column  // column 表示一栏一列
    private String name; // 自己需要存贮的字段
    ...

### 添加数据
for (int i= 0;i < 50;i++){
    User u = new User(i + "","text" + i , "110");
    u.save();
}
### 同步查询
// 同步执行操作
List<User> userList = SQLite.select()
        .from(User.class)
        .where(User_Table.phone.eq("110")).queryList();
for (User user1 : userList){
    Log.d("jiejie", "size"  + user1.toString());
}
### 分页查询
  // LIMIT + OFFSET (分页)
  List<User> userList1=  SQLite.select()
            .from(User.class)
            .limit(5)
            .offset(0)
            .queryList();
    for (User user1 : userList1){
        Log.d("jiejie", "------"  + user1.toString());
    }
