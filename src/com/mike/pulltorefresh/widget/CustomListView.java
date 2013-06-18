package com.mike.pulltorefresh.widget;

import android.widget.ListView;

public class CustomListView extends ListView {
	public CustomListView(android.content.Context context, android.util.AttributeSet attrs) {
		super(context, attrs);
	}

    /**
     * 设置不滚�?
     */
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}
}