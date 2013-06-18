package com.mike.pulltorefresh.widget;

import android.view.MotionEvent;
import android.widget.GridView;

public class CustomGridView extends GridView
{
	public CustomGridView(android.content.Context context,
			android.util.AttributeSet attrs)
	{
		super(context, attrs);
	}

    /**
     * 设置不滚�?
     */
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);

	}

	public boolean dispatchTouchEvent(MotionEvent ev) { 
		// TODO Auto-generated method stub 
		if(ev.getAction() == MotionEvent.ACTION_MOVE){ 
			return true;//禁止Gridview进行滑动 
		} 
		return super.dispatchTouchEvent(ev); 
		} 
}