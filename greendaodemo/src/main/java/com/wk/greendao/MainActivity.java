package com.wk.greendao;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wk.greendao.bean.DaoMaster;
import com.wk.greendao.bean.DaoSession;
import com.wk.greendao.bean.User;
import com.wk.greendao.bean.UserDao;

import java.util.List;


public class MainActivity extends Activity {
    private EditText sessionEt, nameEt, ageEt;
    private TextView resultTv;
    private Button addBtn, deleteBtn, queryBtn, changBtn;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private UserDao userDao;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "greenDao_db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        userDao = daoSession.getUserDao();

//        String columnName = userDao.Properties.SessionId.columnName;
    }

    public void initViews() {
        sessionEt = (EditText) findViewById(R.id.et_session_id);
        nameEt = (EditText) findViewById(R.id.et_name);
        ageEt = (EditText) findViewById(R.id.et_age);
        resultTv = (TextView) findViewById(R.id.tv_result);

        addBtn = (Button) findViewById(R.id.btn_add);
        deleteBtn = (Button) findViewById(R.id.btn_delete);
        changBtn = (Button) findViewById(R.id.btn_change);
        queryBtn = (Button) findViewById(R.id.btn_query);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = getUser();
                add(user);
                showToast("add");

            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = getUser();
                delete(user);
                showToast("delete");

            }
        });

        changBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = getUser();
                change(user);
                showToast("change");

            }
        });
        queryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                query();
                showToast("query");

            }
        });
    }

    public User getUser() {
        String sessionId = sessionEt.getText().toString();
        String name = nameEt.getText().toString();
        String age = ageEt.getText().toString();

        User user = new User(sessionId, name, age);
        return user;
    }

    ;

    public void add(User user) {
        userDao.insert(user);
//        resultTv.setText(user.toString());
        query();
    }

    public void query() {
        List<User> users = userDao.loadAll();
        int size = users.size();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            builder.append(users.get(i).toString() + "\n");
        }
        resultTv.setText(builder.toString());
    }

    public void change(User user) {
        userDao.update(user);
        query();
    }

    public void delete(User user) {
        userDao.delete(user);
        query();
    }

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();;
    }


}
