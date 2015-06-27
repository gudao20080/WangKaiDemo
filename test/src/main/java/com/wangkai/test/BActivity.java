package com.wangkai.test;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class BActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        findViewById(R.id.tv_B_A).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                finishActivity(200);
//                finish();
//                finishActivity(100);
//                finishActivityFromChild(BActivity.this, 100);
                setResult(100);
                finish();

            }
        });
    }


}
