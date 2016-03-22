package com.coolstar.activityshowhide;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * Created by jiguangxing on 2016/3/22.
 */
public class FloatingWindow {

    private static View floatView;

    public static void changeView(final Context appContext, boolean isActivityShowing) {
        WindowManager wndMgr = (WindowManager) appContext.getSystemService(Service.WINDOW_SERVICE);
        if(isActivityShowing){
            if(floatView!=null){
                Log.e("FloatingWindow","removeView------------");
                wndMgr.removeView(floatView);
                floatView = null;
            }
        }else{
            if(floatView==null) {
                final LayoutInflater inflater = LayoutInflater.from(appContext);
                floatView = inflater.inflate(R.layout.window_floating, null);
            }
            WindowManager.LayoutParams mDeskLrcLayoutParams = new WindowManager.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            mDeskLrcLayoutParams.type = WindowManager.LayoutParams.TYPE_PHONE;
            mDeskLrcLayoutParams.format =  PixelFormat.TRANSPARENT;
            mDeskLrcLayoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
            mDeskLrcLayoutParams.gravity = Gravity.LEFT | Gravity.TOP;
            mDeskLrcLayoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
            mDeskLrcLayoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
            mDeskLrcLayoutParams.x = 320;
            mDeskLrcLayoutParams.y = 620;
            Log.e("FloatingWindow","addView------------");
            wndMgr.addView(floatView,mDeskLrcLayoutParams);
        }
    }
}
