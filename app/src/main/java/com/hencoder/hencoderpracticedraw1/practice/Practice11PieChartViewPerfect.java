package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.R;

public class Practice11PieChartViewPerfect extends View {
    private Paint mPaint = new Paint();
    private Paint mLinePaint = new Paint();
    private Paint mTextPaint = new Paint();
    private String[] versions = {"Froyo", "GB", "IC S", "JB", "KitKat", "L", "M"};
    private int[] mAngleIntArr = {3, 8, 9, 60, 90, 135, 55};

    @ColorInt
    private int[] mColorIntArr;

    private RectF mRectF = new RectF();
    private RectF mRedRectF = new RectF();


    public Practice11PieChartViewPerfect(Context context) {
        super(context);
        initValue();
    }

    public Practice11PieChartViewPerfect(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initValue();
    }

    public Practice11PieChartViewPerfect(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initValue();
    }

    private void initValue() {
        mColorIntArr = new int[]{
                getResources().getColor(R.color.p_3),
                getResources().getColor(R.color.p_4),
                getResources().getColor(R.color.p_5),
                getResources().getColor(R.color.p_6),
                getResources().getColor(R.color.p_2),
                getResources().getColor(R.color.p_1),
                getResources().getColor(R.color.colorAccent),
        };

        mPaint.setStyle(Paint.Style.FILL);

        mLinePaint.setStyle(Paint.Style.STROKE);
        mLinePaint.setStrokeWidth(3);
        mLinePaint.setColor(getResources().getColor(R.color.p_4));

        mTextPaint.setStyle(Paint.Style.STROKE);
        mTextPaint.setColor(Color.WHITE);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        //画布平移到中间来绘制
        canvas.translate(getWidth() / 2, getHeight() / 2);

        mRectF.left = -300;
        mRectF.top = -300;
        mRectF.right = 300;
        mRectF.bottom = 300;

        mRedRectF.left = -320;
        mRedRectF.top = -320;
        mRedRectF.right = 280;
        mRedRectF.bottom = 280;


        int arcSpaceWidth = 2;
        int startAngle = 0;
        for (int i = 0; i < mAngleIntArr.length; i++) {
            mPaint.setColor(mColorIntArr[i]);
            String version = versions[i];
            int lineAngle = startAngle + arcSpaceWidth / 2 + mAngleIntArr[i] / 2;

            //绘制弧
            canvas.drawArc(i == 5 ? mRedRectF : mRectF,
                    startAngle + arcSpaceWidth, mAngleIntArr[i] - arcSpaceWidth, true, mPaint);
            startAngle = startAngle + mAngleIntArr[i];


            //画斜线
            float pointX = (float) (Math.cos(lineAngle * Math.PI / 180) * 300.0);
            float pointY = (float) (Math.sin(lineAngle * Math.PI / 180) * 300.0);
            float lineX = (float) (Math.cos(lineAngle * Math.PI / 180) * 350.0);
            float lineY = (float) (Math.sin(lineAngle * Math.PI / 180) * 350.0);


            if (i == 5) {
                canvas.translate(-20, -20);
                canvas.drawLine(pointX, pointY, lineX, lineY, mLinePaint);
                canvas.translate(20, 20);
            } else {
                canvas.drawLine(pointX, pointY, lineX, lineY, mLinePaint);
            }

            // 绘制text画直线和文本
            Rect textRect = getTextRect(version, mTextPaint);
            if (lineX < 0) {
                if (i == 5) {
                    canvas.translate(-20, -20);
                    canvas.drawLine(lineX, lineY, -400, lineY, mLinePaint);
                    canvas.drawText(version, -420 - textRect.width(), lineY + textRect.height() / 2, mTextPaint);
                    canvas.translate(20, 20);
                } else {
                    canvas.drawLine(lineX, lineY, -400, lineY, mLinePaint);
                    canvas.drawText(version, -420 - textRect.width(), lineY + textRect.height() / 2, mTextPaint);

                }
            } else {
                canvas.drawLine(lineX, lineY, 400, lineY, mLinePaint);
                canvas.drawText(version, 420, lineY + textRect.height() / 2, mTextPaint);
            }
        }
    }

    public Rect getTextRect(String deviceName, Paint paint) {

        Rect mBound = new Rect();
        paint.getTextBounds(deviceName, 0, deviceName.length(), mBound);

        return mBound;
    }

}
