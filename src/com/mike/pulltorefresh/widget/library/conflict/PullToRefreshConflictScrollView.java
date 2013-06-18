package com.mike.pulltorefresh.widget.library.conflict;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.mike.pulltorefresh.widget.library.PullToRefreshCustomScrollView;

public class PullToRefreshConflictScrollView extends PullToRefreshCustomScrollView {

	public PullToRefreshConflictScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public PullToRefreshConflictScrollView(
			Context context,
			com.mike.pulltorefresh.widget.library.PullToRefreshBase.Mode mode,
			com.mike.pulltorefresh.widget.library.PullToRefreshBase.AnimationStyle style) {
		super(context, mode, style);
		// TODO Auto-generated constructor stub
	}

	public PullToRefreshConflictScrollView(
			Context context,
			com.mike.pulltorefresh.widget.library.PullToRefreshBase.Mode mode) {
		super(context, mode);
		// TODO Auto-generated constructor stub
	}

	public PullToRefreshConflictScrollView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	private float xDistance, yDistance, xLast, yLast;

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

			if (xDistance > yDistance) {
				return false;
			}
		}
		// return false;
		return super.onInterceptTouchEvent(ev);
	}
}
