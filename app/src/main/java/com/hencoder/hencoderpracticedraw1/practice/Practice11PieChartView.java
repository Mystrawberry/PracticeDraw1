package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.R;

public class Practice11PieChartView extends View {
    private Paint mPaint = new Paint();
    private Paint mLinePaint = new Paint();
    private Paint mTextPaint = new Paint();

    private int mDiameter = 500;

    private int[] mAngleIntArr = {3, 8, 9, 60, 90, 135, 55};
    private Path mPath = new Path();

    @ColorInt
    private int[] mColorIntArr;

    private RectF mRectF = new RectF();
    private RectF mRedRectF = new RectF();


    public Practice11PieChartView(Context context) {
        super(context);
        initValue();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initValue();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

        mRectF.left = 100;
        mRectF.top = 100;
        mRectF.right = 100 + mDiameter;
        mRectF.bottom = 100 + mDiameter;

        mRedRectF.left = 80;
        mRedRectF.top = 80;
        mRedRectF.right = 80 + mDiameter;
        mRedRectF.bottom = 80 + mDiameter;


        int arcSpaceWidth = 2;
        int startAngle = 0;
        for (int i = 0; i < mAngleIntArr.length; i++) {
            mPaint.setColor(mColorIntArr[i]);
            //起始角度5，弧形划过的角度2，下一个从9开始 2+5+2,  9 6  15
            canvas.drawArc(i == 5 ? mRedRectF : mRectF, startAngle + arcSpaceWidth, mAngleIntArr[i] - arcSpaceWidth, true, mPaint);
            startAngle = startAngle + mAngleIntArr[i];

            // 绘制线条
            //int linex =

//            mPath.moveTo();


            //绘制text


        }
    }

    //半径：r
    // 角度：a0
//        x1 = x0 + r * cos(ao * 3.14 /180 )
//        y1 = y0 + r * sin(ao * 3.14 /180 )
}
