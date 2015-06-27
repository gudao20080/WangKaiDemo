package com.wk.propertyanimationdemo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
    private final String TAG = "MainActivity";

    private Button mValueAnimBtn, mObjectAnimationBtn, mMultiAnimationBtn, mAnimInXMLBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mValueAnimBtn = (Button) findViewById(R.id.btn_value_animation);
        mObjectAnimationBtn = (Button) findViewById(R.id.btn_object_animation);
        mMultiAnimationBtn = (Button) findViewById(R.id.btn_multi_animation);
        mAnimInXMLBtn = (Button) findViewById(R.id.btn_animation_in_XML);

        initValueAnimation();
        initObjectAnimation();
        initMultiAnimations();
        initXMLAnimation();
    }


    public void initValueAnimation() {
        final ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 5);
        //        final ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1f);
        valueAnimator.setDuration(300);
        valueAnimator.setRepeatCount(2);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
//                float value = (float) animation.getAnimatedValue();
                int value = (int) animation.getAnimatedValue();
                Log.d(TAG, "value: " + value);
            }
        });


        mValueAnimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueAnimator.start();
            }
        });
    }

    public void initObjectAnimation() {


        mObjectAnimationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(v, "alpha", 1f, 0f, 1f);
                objectAnimator.setDuration(2000);
                ObjectAnimator animator = ObjectAnimator.ofFloat(mObjectAnimationBtn, "rotation", 0f, 360f);
                animator.setDuration(5000);
                animator.start();
            }
        });

    }

    public void initMultiAnimations() {

        mMultiAnimationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator moveIn = ObjectAnimator.ofFloat(v, "translationX", -500f, 0f);
                ObjectAnimator rotate = ObjectAnimator.ofFloat(v, "rotation", 0f, 360f);
                ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(v, "alpha", 1f, 0f, 1f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(moveIn).before(rotate).after(fadeInOut).after(2000);
                animatorSet.setDuration(2000);
                //设置监听
//                animatorSet.addListener(new Animator.AnimatorListener() {
//                    @Override
//                    public void onAnimationStart(Animator animation) {
//
//                    }
//
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//
//                    }
//
//                    @Override
//                    public void onAnimationCancel(Animator animation) {
//
//                    }
//
//                    @Override
//                    public void onAnimationRepeat(Animator animation) {
//
//                    }
//                });

                //监听单个动画事件
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationCancel(Animator animation) {
                        super.onAnimationCancel(animation);
                    }
                });

                animatorSet.start();


            }
        });


    }

    /*从XML中设置和加载属性动画*/
    public void initXMLAnimation() {
        mAnimInXMLBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Animator animator = AnimatorInflater.loadAnimator(MainActivity.this, R.animator.trans);
                Animator animator = AnimatorInflater.loadAnimator(MainActivity.this, R.animator.obj_anims);

                animator.setTarget(v);
                animator.start();
            }
        });




    }


}
