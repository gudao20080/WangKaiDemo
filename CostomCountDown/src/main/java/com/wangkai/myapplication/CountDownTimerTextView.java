package com.wangkai.myapplication;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

/**
 * 倒时计的类
 * User: WangKai(123940232@qq.com)
 * 2014-12-24 16:01
 */
public class CountDownTimerTextView extends TextView {
    public CountDownTimerTextView(Context context) {
        super(context);
    }

    public CountDownTimerTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }



    class CustomCountDownTimer extends CountDownTimer {

        CustomCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {

            String s = String.format("%02d : %02d : %02d", TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
            setText(s);
        }

        @Override
        public void onFinish() {
            setText("00 ：00 ：00");
            if (null != onCountDownFinishListener) {
                onCountDownFinishListener.onCountDownFinish();
            }
        }
    }

    interface OnCountDownFinishListener{
        public void onCountDownFinish();
    }

    private OnCountDownFinishListener onCountDownFinishListener;


    public void setOnCountDownFinishListener(OnCountDownFinishListener onCountDownFinishListener) {
        this.onCountDownFinishListener = onCountDownFinishListener;
    }

    public void start(long millisenconds) {
        CustomCountDownTimer countDownTimer = new CustomCountDownTimer(millisenconds, 1000);
        countDownTimer.start();
    }


}
