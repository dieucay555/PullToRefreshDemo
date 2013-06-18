/*
 * Copyright (C) 2012 The Founder Mobile Media Technology Android EPaper Project
 * 
 * Founder Mobile Media PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.mike.pulltorefresh.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * 能够兼容ViewPager的ScrollView 
 * @Description: 解决了ViewPager在ScrollView中的滑动反弹问题 
 * @author yanghui
 * @createDate 2012-11-12
 * @version v0.1
 */
public class CustomScrollView extends ScrollView {
    // 滑动距离及坐�? 
    private float xDistance, yDistance, xLast, yLast;  

    public CustomScrollView(Context context, AttributeSet attrs) {  
        super(context, attrs);  
    }  

    @Override  
    public boolean onInterceptTouchEvent(MotionEvent ev) {  
        switch (ev.getAction()) {  
            case MotionEvent.ACTION_DOWN:  
                xDistance = yDistance = 0f;  
                xLast = ev.getX();  
                yLast = ev.getY();  
                break;  
            case MotionEvent.ACTION_MOVE:  
                final float curX = ev.getX();  
                final float curY = ev.getY();  

                xDistance += Math.abs(curX - xLast);  
                yDistance += Math.abs(curY - yLast);  
                xLast = curX;  
                yLast = curY;  

                if(xDistance > yDistance){  
                    return false;  
                }    
        }  

        return super.onInterceptTouchEvent(ev);  
    }  
}
