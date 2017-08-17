package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class Practice10HistogramView extends View {
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();

    private int startX, startY, endY = 550;
    private int spaceWidth = 20;

    private int mRectWidth = 90;

    private String[] mStrArray = {"Froyo", "GB", "ICS", "JB", "KitKat", "L", "M"};


    public Practice10HistogramView(Context context) {
        super(context);
        initValue();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initValue();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initValue();
    }

    private void initValue() {
        startX = 85;
        startY = 40;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        drawLines(canvas);
        drawHistogram(canvas);
    }

    /**
     * 绘制坐标系
     */
    private void drawLines(Canvas canvas) {
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        //加上startX，算出实际所需长度
        int countLength = 7 * mRectWidth + 7 * spaceWidth + startX;

        mPath.moveTo(startX, startY);
        //第一条线x不变，y值增加
        mPath.lineTo(startX, endY);
        mPath.lineTo(countLength, endY);
        canvas.drawPath(mPath, mPaint);
    }

    //int s = 85+spaceWidth;
    private void drawHistogram(Canvas canvas) {
        for (int i = 0; i < 7; i++) {
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.GREEN);
            // 每个直方图开始的纵坐标
            float startY = new Random().nextFloat() * 300;
            float start = i == 0 ? startX + spaceWidth : startX + (i + 1) * spaceWidth + i * mRectWidth;

             canvas.drawRect(start, startY, start + mRectWidth, endY, mPaint);
            //canvas.drawRect(s, startY, s+mRectWidth, endY, mPaint);
            //s = s + mRectWidth + spaceWidth;

            mPaint.setColor(Color.WHITE);
            //这里的text需要测量，在进行绘制
            mPaint.setTextSize(12);
            canvas.drawText(mStrArray[i], start + 45, endY + 20, mPaint);
        }
    }
}
