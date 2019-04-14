package com.elewa.grandtask.util;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
/**
 * disable of recyclerVIew
 *
 * @author Ahmed M Elewa
 */
public class RecyclerViewDisabler implements RecyclerView.OnItemTouchListener {

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        return true;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}