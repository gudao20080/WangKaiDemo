package com.wangkai.listviewpropertytest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private ListView listView;
    private Button addBtn;
    private List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addBtn = (Button) findViewById(R.id.btn_add);
        listView = (ListView) findViewById(R.id.lv);
        data = getData();
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, data);
        listView.setAdapter(adapter);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.add("100");
                adapter.notifyDataSetChanged();
            }
        });

    }


    public List<String> getData() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            list.add(String.valueOf(i));
        }
        return list;
    }



    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }
}
