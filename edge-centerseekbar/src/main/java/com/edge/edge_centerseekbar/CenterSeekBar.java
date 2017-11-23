package com.edge.edge_centerseekbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
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
    private float seekbar_height;
    private int backgroundColor;
    private int progressColor;
    private int thumbColor;

    public CenterSeekBar(Context context) {
        super(context);
    }

    public CenterSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context,attrs);
    }

    public CenterSeekBar(Context context,Builder builder){
        super(context);
        rect = new Rect();
        paint = new Paint();
        this.seekbar_height = builder.seekbar_height;
        this.thumbColor = ContextCompat.getColor(context,builder.thumbColor);
        this.backgroundColor = ContextCompat.getColor(context,builder.backgroundColor);
        this.progressColor = ContextCompat.getColor(context,builder.progressColor);
        getProgressDrawable().setAlpha(0);
        getThumb().setColorFilter(thumbColor, PorterDuff.Mode.SRC_ATOP);
    }

    public CenterSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    public static class Builder {
        Context context;
         float seekbar_height;
         int backgroundColor;
         int progressColor;
         int thumbColor;
         public Builder with(Context context){
             this.context = context;
             return this;
         }
         public Builder setBackgroundColor(int backgroundColor){
             this.backgroundColor = backgroundColor;
             return this;
         }
         public Builder setProgressColor(int progressColor){
             this.progressColor =progressColor;
             return this;
         }
         public Builder setThumbColor(int thumbColor){
             this.thumbColor = thumbColor;
             return this;
         }
         public Builder setHeight(float seekbar_height){
             this.seekbar_height = seekbar_height;
             return this;
         }
         public CenterSeekBar build(){
             return new CenterSeekBar(context,this);
         }
    }
    public void initAttrs(Context context, AttributeSet attrs){
        rect = new Rect();
        paint = new Paint();
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CenterSeekBar);
        try {
            backgroundColor = ta.getColor(R.styleable.CenterSeekBar_seekbar_backgroundtint, ContextCompat.getColor(context, R.color.colorPrimaryDark));
            progressColor = ta.getColor(R.styleable.CenterSeekBar_seekbar_progresstint, ContextCompat.getColor(context, R.color.colorPrimary));
            thumbColor = ta.getColor(R.styleable.CenterSeekBar_seekbar_thumbtint,ContextCompat.getColor(context,R.color.colorPrimaryDark));
            seekbar_height = ta.getDimension(R.styleable.CenterSeekBar_seekbar_height,6f);
        } finally {
            ta.recycle();
        }
        getProgressDrawable().setAlpha(0);
        getThumb().setColorFilter(thumbColor, PorterDuff.Mode.SRC_ATOP);
    }
    @Override
    protected synchronized void onDraw(Canvas canvas) {
        //시크바 패딩값을 가져온다
        int padding = getPaddingLeft()!=0?getPaddingLeft():getPaddingRight();
        //시크바 백그라운드를 그린다.
            rect.set(0 + padding,
                    (getHeight() / 2) - ((int)seekbar_height/2),
                    getWidth()- padding,
                    (getHeight() / 2) + ((int)seekbar_height/2));
            paint.setColor(backgroundColor);
            canvas.drawRect(rect, paint);

        //시크바 프로그래스가 중간보다 클 때
        if (this.getProgress() > getMax()/2) {
            rect.set(getWidth()/ 2,
                    (getHeight() / 2) - ((int)seekbar_height/2),
                    (getWidth()/2)+((getProgress()-(getMax()/2))*( (getWidth()-padding-getThumbOffset())/2))/(getMax()/2),
                    getHeight() / 2 + ((int)seekbar_height/2));

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
                    (getHeight() / 2) - ((int)seekbar_height/2),
                    getWidth() / 2,
                    getHeight() / 2 + ((int)seekbar_height/2));
            paint.setColor(progressColor);
            canvas.drawRect(rect, paint);

        }

        super.onDraw(canvas);
    }
}