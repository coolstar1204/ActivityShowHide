package com.coolstar.activityshowhide;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.media.audiofx.BassBoost;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

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
                try{
                    wndMgr.removeView(floatView);
                }catch (Throwable e){

                }
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
            if(Build.VERSION.SDK_INT>Build.VERSION_CODES.LOLLIPOP_MR1){
                if(Settings.canDrawOverlays(appContext)){
                    Log.e("FloatingWindow","addView------------");
                    wndMgr.addView(floatView,mDeskLrcLayoutParams);
                }else{
                    Toast.makeText(appContext,"无权限，不能显示桌面浮动按钮",Toast.LENGTH_SHORT).show();
                }
            }else{
                wndMgr.addView(floatView,mDeskLrcLayoutParams);
            }
        }
    }
}
