package com.example.administrator.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private final String TAG = getClass().getSimpleName();
    private RecyclerView recyclerView;
    private List<String> list;
    private RecyclerView.Adapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv_recyclerView);


        list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("item  "+ i);
        }

        adapter = new MyAdapter(this, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager
            .VERTICAL, false));
        recyclerView.addItemDecoration(new ItemDivider(this, R.drawable.divider_line));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {              //如何判断是否滑动到达尾部或顶部
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int firstCompletelyVisibleItemPosition = layoutManager.findFirstCompletelyVisibleItemPosition();
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
                int lastCompletelyVisibleItemPosition = layoutManager.findLastCompletelyVisibleItemPosition();
                int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();

                Log.d(TAG, " " + firstCompletelyVisibleItemPosition + ": " + firstVisibleItemPosition
                    + ": " + lastCompletelyVisibleItemPosition + ": " + lastVisibleItemPosition);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }






}
