package com.wk.dialogdemo;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private Button mAlertBtn, mFrgBtn, mCustomBtn, mProgressBtn;
    private Handler mHandler;
    private static int DIALOG_PROGRESS = 110;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if(msg.what == DIALOG_PROGRESS){
                    progressDialog.setProgress(msg.arg1);
                    if (msg.arg1 == 100) {
                        progressDialog.setMessage("已下载完成");
                        Toast.makeText(MainActivity.this, "下载完成", Toast.LENGTH_SHORT).show();
                    }
                }

                return false;
            }
        });

        mAlertBtn = (Button) findViewById(R.id.btn_alert_dialog);
        mCustomBtn = (Button) findViewById(R.id.btn_custom_dialog);
        mAlertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAldetDialog();
            }
        });
        mFrgBtn = (Button) findViewById(R.id.btn_fragment_dialog);
        mProgressBtn = (Button) findViewById(R.id.btn_progress_dialog);
        mFrgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment pre = getSupportFragmentManager().findFragmentByTag("dialog");
                if (null != pre) {
                    transaction.remove(pre);
                }
                transaction.addToBackStack(null);
                transaction.commit();
                MyFragmentDialog dialog = new MyFragmentDialog();

                dialog.show(getSupportFragmentManager(), "dialog");
            }
        });
        mCustomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });
        mProgressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressDialog();
            }
        });
    }

    private void  showAldetDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("aaaaa");
//        builder.setIcon(R.mipmap.ic_launcher);
        builder.setNegativeButton("设为头像" ,null);
        builder.setPositiveButton("Positive", null);
        builder.setNeutralButton("Neutral", null);
        builder.setMessage("AAAA \n BBB");
        AlertDialog alertDialog = builder.create();
        Window window = alertDialog.getWindow();
        window.setWindowAnimations(R.style.dialogAnim);
        alertDialog.show();

        Set<String> nas = new HashSet<>();

    }

    private void showCustomDialog() {
        CustomDialogFragment fragment = new CustomDialogFragment();
        fragment.show(getSupportFragmentManager(), "CustomDialogFragment");

    }


    ProgressDialog progressDialog;
    private void showProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("图片下载");
        progressDialog.setIcon(R.mipmap.ic_launcher);

//        TextView tv = new TextView(this);     //自定义标题View
//        tv.setText("自定义的标题View");
//        progressDialog.setCustomTitle(tv);

        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);   //水平
//        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);  //圆形
        progressDialog.setMessage("正在下载我的靓照");
        progressDialog.setCancelable(true);  //能否被取消
// 主要是在进行一些无法确定操作时间的任务时作为提示。而“明确”(true)就是根据你的进度可以设置现在的进度值。
        progressDialog.setIndeterminate(false);// 主要是在进行一些无法确定操作时间的任务时作为提示。而“明确”(true)就是根据你的进度可以设置现在的进度值。

        Window window = progressDialog.getWindow();
        window.setWindowAnimations(R.style.dialogAnim);
        progressDialog.show();

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(50);
                        Message msg = mHandler.obtainMessage();
                        msg.what = DIALOG_PROGRESS;
                        msg.arg1 = i;
                        mHandler.sendMessage(msg);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
