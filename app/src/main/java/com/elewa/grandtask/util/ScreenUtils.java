package com.elewa.grandtask.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;

/**
 * Get screen size
 *
 * @author Ahmed M Elewa
 */

public class ScreenUtils {

    // Constructors

    //Default constructor.
    private ScreenUtils() {
    }

    // Public static methods
    /*
     * Returns int screen width size.
     */
    public static int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

}