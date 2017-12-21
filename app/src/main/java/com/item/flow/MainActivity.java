package com.item.flow;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.item.flow.db.User;
import com.item.flow.db.User_Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i= 0;i < 50;i++){
            User u = new User(i + "","text" + i , "110");
            u.save();
        }
        User user = new User(3 +"","wuzongjie","1102");
        user.save();


        // 同步执行操作
        List<User> userList = SQLite.select()
                .from(User.class)
                .where(User_Table.phone.eq("110")).queryList();
        for (User user1 : userList){
            Log.d("jiejie", "size"  + user1.toString());
        }
        // 异步执行操作
        SQLite.select()
                .from(User.class)
                .async().queryListResultCallback(new QueryTransaction.QueryResultListCallback<User>() {
                    @Override
                    public void onListQueryResult(QueryTransaction transaction, @NonNull List<User> tResult) {
                        Log.d("jiejie","-----------------");

                    }
                });

        // LIMIT + OFFSET (分页)
      List<User> userList1=  SQLite.select()
                .from(User.class)
                .limit(5)
                .offset(0)
                .queryList();
        for (User user1 : userList1){
            Log.d("jiejie", "------"  + user1.toString());
        }

        List<User> userList2=  SQLite.select()
                .from(User.class)
                .limit(5)
                .offset(5)
                .queryList();
        for (User user1 : userList2){
            Log.d("jiejie", "------"  + user1.toString());
        }
    }
}
