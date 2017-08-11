package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF mRectF = new RectF();

    public Practice8DrawArcView(Context context) {
        super(context);
        initPaint();
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度）
        // useCenter 表示是否连接到圆心，如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形
        //  canvas.drawArc(rect, 55, 85, true, mPaint);
        // Notice:上面的55表示从55角度开始，85并不是表示结束的角度，而是弧形划过的角度，这点很重要
        //Notice : 如果绘制的下个弧形需要有间隔，需要把之前的值相加，在加上所需间隙

        // 练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        mRectF.left = getWidth() / 2 - 300;
        mRectF.top = getHeight() / 2 - 300;
        mRectF.right = getWidth() / 2 + 300;
        mRectF.bottom = getHeight() / 2 + 300;

        //顺时针绘制
        canvas.drawArc(mRectF, 0, 180, true, mPaint);

        //逆时针为负角度  270 的位置变了
        canvas.drawArc(mRectF, -100, 90, true, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(mRectF, 190, 45, false, mPaint);

//        canvas.drawArc(mRectF,100,100,true,mPaint);
//        canvas.drawArc(mRectF,190,45,false,mPaint);
    }
}
