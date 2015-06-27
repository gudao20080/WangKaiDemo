package com.wk.materialnewfeaturedemo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private Button mShowSnackBarBtn, mTabLayout, mAppbarLayout;
    private LinearLayout mLyaout;
    private TextInputLayout mTextInputLayout;
    private FloatingActionButton mFab, mFab_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar ab = getSupportActionBar();           //设置Actionbar左边的图标
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setBackgroundDrawable(getResources().getDrawable(R.mipmap.ic_launcher));

        mLyaout = (LinearLayout) findViewById(R.id.cl);
        mTextInputLayout = (TextInputLayout) findViewById(R.id.til);
        mShowSnackBarBtn = (Button) findViewById(R.id.btn_show_snack_bar);
        mAppbarLayout = (Button) findViewById(R.id.btn_appBarLayout);
        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mFab_b = (FloatingActionButton) findViewById(R.id.fab_b);
        mTabLayout = (Button) findViewById(R.id.btn_tabLayout);
        initSnackbar();
        initTextInputLayout();
        initFloatActionButton();
        initTabLayout();
        initAppBarLayout();

    }

    private void initTabLayout() {
        mTabLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TabLayoutActivity.class);
                startActivity(intent);
            }
        });
    }

    public void initSnackbar() {
        mShowSnackBarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Snackbar.make(mCoordinatorLayout, "示例 snackbar", Snackbar.LENGTH_LONG)
//                    .setAction("点击", new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//
//                        }
//                    }).show();
                View contentView = findViewById(android.R.id.content);

                Snackbar snackbar = Snackbar.make(mTabLayout, "Demo", Snackbar.LENGTH_LONG);
                Snackbar.SnackbarLayout snackbarView = (Snackbar.SnackbarLayout) snackbar.getView();
                snackbarView.setBackgroundColor(Color.RED);
//                snackbarView.getActionView()
                Class<? extends Snackbar.SnackbarLayout> snackbarViewClass = snackbarView.getClass();
                snackbar.setAction("点击按钮", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "按钮被点击了", Toast.LENGTH_SHORT).show();
                    }
                });

                snackbar.setActionTextColor(Color.GREEN);



                snackbar.show();
            }
        });
    }



    public void initTextInputLayout() {

        mTextInputLayout.setHint("password");
        SpannableString msp = new SpannableString("password");
//        msp.setSpan(new BackgroundColorSpan(Color.BLUE), 1, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //设置背景色为青色
//        mTextInputLayout.setHint(msp);
        EditText editText = mTextInputLayout.getEditText();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() > 6){
                    mTextInputLayout.setErrorEnabled(false);

                }else {
                    mTextInputLayout.setError("输入长度错误");
                    mTextInputLayout.setErrorEnabled(true);

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    public void initFloatActionButton() {
        mFab.setRippleColor(Color.RED);         //设置FloatActionButton底部颜色
        mFab_b.setRippleColor(Color.BLUE);
//        mFab.setBackgroundTintList(ColorStateList.valueOf(Color.GRAY));
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Fab is Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        mFab_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Fab is Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initAppBarLayout() {

        mAppbarLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AppBarActivity.class);
                startActivity(intent);
            }
        });

    }


}
