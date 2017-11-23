package com.edge.edge_centerseekbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.SeekBar;

/**
 * Created by kim on 2017. 5. 4..
 */

public class CenterSeekBar extends SeekBar {

    private Rect rect;
    private Paint paint;
    private int seekbar_height;
    private int bacgroundColor;
    private int progressColor;

    public CenterSeekBar(Context context) {
        super(context);

    }

    public CenterSeekBar(Context context, AttributeSet attrs) {

        super(context, attrs);
        rect = new Rect();
        paint = new Paint();
        seekbar_height = 6;
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CenterSeekBar);
        try {
            bacgroundColor = ta.getColor(R.styleable.CenterSeekBar_seekbar_backgroundtint, ContextCompat.getColor(context, R.color.colorPrimaryDark));
            progressColor = ta.getColor(R.styleable.CenterSeekBar_seekbar_progresstint, ContextCompat.getColor(context, R.color.colorPrimary));
        } finally {
            ta.recycle();
        }

    }

    public CenterSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        //시크바 패딩값을 가져온다
        int padding = getPaddingLeft()!=0?getPaddingLeft():getPaddingRight();
        //시크바 백그라운드를 그린다.
            rect.set(0 + padding,
                    (getHeight() / 2) - (seekbar_height/2),
                    getWidth()- padding,
                    (getHeight() / 2) + (seekbar_height/2));
            paint.setColor(bacgroundColor);
            canvas.drawRect(rect, paint);

        //시크바 프로그래스가 중간보다 클 때
        if (this.getProgress() > getMax()/2) {
            rect.set(getWidth()/ 2,
                    (getHeight() / 2) - (seekbar_height/2),
                    (getWidth()/2)+((getProgress()-(getMax()/2))*( (getWidth()-padding-getThumbOffset())/2))/(getMax()/2),
                    getHeight() / 2 + (seekbar_height/2));

            paint.setColor(progressColor);
            canvas.drawRect(rect, paint);

        }
        //시크바 프로그래스가 중간일때
        if (this.getProgress()==getMax()/2){
            rect.set(0,0,0,0);
            paint.setColor(progressColor);
            canvas.drawRect(rect,paint);
        }

        //시크바 프로그래스가 중간보다 작을때
       if (this.getProgress() < getMax()/2) {
            rect.set((getWidth()/2)+((getProgress()-(getMax()/2))*( (getWidth()-padding-getThumbOffset())/2))/(getMax()/2),
                    (getHeight() / 2) - (seekbar_height/2),
                    getWidth() / 2,
                    getHeight() / 2 + (seekbar_height/2));
            paint.setColor(progressColor);
            canvas.drawRect(rect, paint);

        }

        super.onDraw(canvas);
    }
}