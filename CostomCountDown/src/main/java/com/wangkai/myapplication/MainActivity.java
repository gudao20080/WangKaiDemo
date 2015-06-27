package com.wangkai.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private CountDownTimerTextView countDownTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countDownTextView = (CountDownTimerTextView) findViewById(R.id.count_down_view);
        countDownTextView.setOnCountDownFinishListener(new CountDownTimerTextView.OnCountDownFinishListener() {
            @Override
            public void onCountDownFinish() {
                Toast.makeText(MainActivity.this, "倒计时完成", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        countDownTextView.start(600 * 1000);
    }
}
