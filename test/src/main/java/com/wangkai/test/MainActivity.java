package com.wangkai.test;

import android.app.ActivityManager;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.wangkai.test.view.MyGridView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private MyGridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_desc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "heheeheh", Toast.LENGTH_SHORT).show();
            }
        });

        mGridView = (MyGridView) findViewById(R.id.gridView);

        SelectMarkAdapter adapter = new SelectMarkAdapter(this, getDatas(), null);
        mGridView.setAdapter(adapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.findViewById(R.id.tv_desc).setSelected(true);
            }
        });

    }

    private List<String> getDatas() {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int r = new Random().nextInt(15) + 1;
            datas.add("富二代的爷dddddddddddddddads".substring(0, r));
        }

        return datas;
    }


}
