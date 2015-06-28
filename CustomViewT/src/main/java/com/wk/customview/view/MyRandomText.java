package com.wk.customview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.wk.customview.R;

/**
 * Created by Administrator on 2015/6/28.
 */
public class MyRandomText extends View {
    private TextPaint mTextPaint;
    private int mColor;
    private float mTextSize;
    private String mText;
    private Rect mRect;
    private Paint mPaint;

    public MyRandomText(Context context) {
        super(context);
    }

    public MyRandomText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.YELLOW);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyRandomText);
//        mColor = typedArray.getColor(R.attr.textColor, Color.RED);
//        mTextSize = typedArray.getDimension(R.attr.textSize, 30);
//        mText = typedArray.getString(R.attr.text);

        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {

        }
        mTextPaint.setColor(mColor);
        mTextPaint.setTextSize(mTextSize);
        mRect = new Rect();
        mTextPaint.getTextBounds(mText, 0, mText.length(), mRect);
    }

    public MyRandomText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(0, 0 , getMeasuredWidth(), getMeasuredHeight(), mPaint);
        canvas.drawText(mText, getWidth()/2 - mRect.width()/2, getHeight()/2 + mRect.height()/2, mTextPaint);


    }
}
