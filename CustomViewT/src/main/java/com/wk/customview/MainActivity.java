package com.wk.customview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {
    @InjectView(R.id.btn_my_text_view)
    Button btnMyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swiprefresh);
        ButterKnife.inject(this);


    }

    @OnClick(R.id.btn_round_bitmap)
    public void goRoundActivity() {
        Intent intent = new Intent(this, RoundBitmapActivity.class);
        startActivity(intent);
//        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

    }

    @OnClick(R.id.btn_touch_view)
    public void goTouchViewActivity() {
        Intent intent = new Intent(this, TouchViewActivity.class);
        startActivity(intent);

    }

    @OnClick(R.id.btn_my_text_view)
    public void goMyTextViewActivity() {
        Intent intent = new Intent(this, MyTextViewActivity.class);
        startActivity(intent);

    }


}
