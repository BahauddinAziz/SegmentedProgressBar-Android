package com.example.progressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

//Customised ProgressBar


public class SegmentedProgressBar extends View {

//    Color Data Members
    private static final int DEFAULT_COLOR =  Color.parseColor("#c7c7c7");
    private int NEW_COLOR = 0;
    private int SEGMENT_COLOR = 0;

//    Data Members Declaration
    private RectF rect;
    private float gap;
    private int sectionCount = 7;
    private float uwidth;
    private int progress =-1;
    private Paint BarPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    //    Required Constructors
    public SegmentedProgressBar(Context context) {
        super(context);
        init(null);
    }

    public SegmentedProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public SegmentedProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public SegmentedProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }


//    Custom Functions

//Initialization Function
    private void init(@Nullable AttributeSet set ) {
        BarPaint.setColor(NEW_COLOR != 0 ? NEW_COLOR : DEFAULT_COLOR);
    }

//    Sets Progress' segment's Unit width
    private void setUnitWidth(float width){
        gap = 20;
        uwidth = (width - (gap * sectionCount)) / sectionCount ;
    }

//    Set the number of segments in the ProgressBar
    public void setBarSections(int i) {
        this.sectionCount = i;
    }

//    Set segmented progress bar with the numbers of segments
    public void setProgressBar(int i){
        rect = new RectF( i* (uwidth + gap) ,0, (i+1) * (uwidth) + i*gap ,15);
    }

//    Set Background color of the Bar
    public void setBackgroundColor(String hexColorCode){
        NEW_COLOR = Color.parseColor(hexColorCode);
    }

//    Set Segment's Color
    public void setProgressColor(String hexColorCode){
        SEGMENT_COLOR = Color.parseColor(hexColorCode);
    }

//    setProgress functions

//    with no parameters
    public void setProgress(){
        progress++;
        invalidate();
    }
//    with parameter
    public void setProgress(int i){
        progress += i;
        invalidate();
    }

//    Updates the progress on the Bar
    public void updateProgress(int i){
        if(i <= progress){
            BarPaint.setColor(SEGMENT_COLOR);
        }else{
            BarPaint.setColor( NEW_COLOR != 0 ? NEW_COLOR : DEFAULT_COLOR);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setUnitWidth(getWidth());

    for(int i = 0; i< sectionCount; i++){
        setProgressBar(i);
        updateProgress(i);

        canvas.drawRoundRect(rect,20,20,BarPaint);
    }
    }


}

