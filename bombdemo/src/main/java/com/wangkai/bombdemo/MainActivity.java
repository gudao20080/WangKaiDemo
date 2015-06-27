package com.wangkai.bombdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.wangkai.bombdemo.bean.Person;
import com.wangkai.bombdemo.common.Constant;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.DeleteListener;
import cn.bmob.v3.listener.GetListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;


public class MainActivity extends Activity implements View.OnClickListener{
    private final String TAG = getClass().getSimpleName();
    private Button addBtn, deleteBtn, changeBtn, queryBtn;
    private String savedId;
    private TextView resultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this, Constant.bomb_application_id);
        initViews();


    }

    public void initViews() {
        addBtn = (Button) findViewById(R.id.btn_add);
        deleteBtn = (Button) findViewById(R.id.btn_delete);
        changeBtn = (Button) findViewById(R.id.btn_change);
        queryBtn = (Button) findViewById(R.id.btn_query);
        resultTv = (TextView) findViewById(R.id.tv_result);

        addBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
        changeBtn.setOnClickListener(this);
        queryBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_add:
                add();
                break;
            case R.id.btn_delete:
                delete();
                break;
            case R.id.btn_change:
                change();
                break;
            case R.id.btn_query:
                query();
                break;

        }
    }

    public void add() {
        final Person p2 = new Person();
        p2.setName("lucky");
        p2.setAddress("北京海淀");
        p2.save(this, new SaveListener() {
            @Override
            public void onSuccess() {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this, "添加数据成功，返回objectId为：" + p2.getObjectId(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, p2.getObjectId());
                savedId = p2.getObjectId();

            }

            @Override
            public void onFailure(int code, String msg) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this, "创建数据失败：" + msg, Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void delete(){

        Person p2 = new Person();
        p2.setObjectId(savedId);
        p2.delete(this, new DeleteListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int code, String msg) {
                Toast.makeText(MainActivity.this, "删除失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void change(){
//更新Person表里面id为6b6c11c537的数据，address内容更新为“北京朝阳”
        final Person p2 = new Person();
        p2.setAddress("北京朝阳");
        p2.update(this, savedId, new UpdateListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(MainActivity.this, "更新成功：" + p2.getUpdatedAt(), Toast.LENGTH_SHORT).show();
                resultTv.setText(p2.getUpdatedAt() + "\n " + p2.toString());
            }
            @Override
            public void onFailure(int code, String msg) {
                Toast.makeText(MainActivity.this, "更新失败：" + msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void query() {
        BmobQuery<Person> bmobQuery = new BmobQuery<>();
        bmobQuery.getObject(this, savedId, new GetListener<Person>() {
            @Override
            public void onSuccess(Person person) {
                resultTv.setText(person.toString());
            }

            @Override
            public void onFailure(int i, String s) {

            }
        });
    }

}
