package com.sunshine.cl.meidebi.utils;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;

/**
 * Created by Administrator on 2016/10/21.
 */
public class FABScrollBehavior extends FloatingActionButton.Behavior {

    Interpolator interpolator = new FastOutSlowInInterpolator();//用于定制动画
    boolean isAnimationOut = false;

    public FABScrollBehavior(Context context, AttributeSet attributeSet) {
        super();
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        //确保是竖直状态的滚动
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        if (dyConsumed > 0 && !isAnimationOut && child.getVisibility() == View.VISIBLE) {
            animatorOut(child);
        } else if (dyConsumed < 0 && child.getVisibility() != View.VISIBLE) {
            animatorIn(child);
        }
    }

    public void animatorOut(FloatingActionButton button) {
        ViewCompat.animate(button).translationY(button.getHeight() + getMarginButton(button)).setInterpolator(interpolator)
                .setListener(new ViewPropertyAnimatorListener() {
                    @Override
                    public void onAnimationStart(View view) {
                        FABScrollBehavior.this.isAnimationOut = true;
                    }

                    @Override
                    public void onAnimationEnd(View view) {
                        FABScrollBehavior.this.isAnimationOut = false;
                    }

                    @Override
                    public void onAnimationCancel(View view) {
                        FABScrollBehavior.this.isAnimationOut = false;
                        view.setVisibility(View.GONE);
                    }
                }).start();
    }

    public void animatorIn(FloatingActionButton button) {
        ViewCompat.animate(button).translationY(0).setInterpolator(interpolator).withLayer()
                .setListener(null).start();
    }

    public int getMarginButton(View v) {
        int marginBottom = 0;
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginBottom = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        return marginBottom;

    }
}

