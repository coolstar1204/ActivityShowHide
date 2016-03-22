package com.coolstar.activityshowhide;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by jiguangxing on 2016/3/22.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        this.registerActivityLifecycleCallbacks(callbacks);
    }

    @Override
    public void onTerminate() {
        this.unregisterActivityLifecycleCallbacks(callbacks);
        super.onTerminate();
    }

    public static boolean isActivityShowing = false;
    public static int activityShowingCount;

    private Application.ActivityLifecycleCallbacks callbacks = new ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

        }

        @Override
        public void onActivityStarted(Activity activity) {
            activityShowingCount++;
            changeActivityFlag(activityShowingCount>0);
            Log.e("FloatingWindow",activity.getClass().getSimpleName()+"-->onActivityStarted-->"+activityShowingCount);
        }

        @Override
        public void onActivityResumed(Activity activity) {
            Log.e("FloatingWindow",activity.getClass().getSimpleName()+"-->onActivityResumed");
        }

        @Override
        public void onActivityPaused(Activity activity) {
            Log.e("FloatingWindow",activity.getClass().getSimpleName()+"-->onActivityPaused");
        }

        @Override
        public void onActivityStopped(Activity activity) {
            activityShowingCount--;
            changeActivityFlag(activityShowingCount>0);
            Log.e("FloatingWindow",activity.getClass().getSimpleName()+"-->onActivityStopped-->"+activityShowingCount);
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {

        }
    };

    public  void changeActivityFlag(boolean isShowing){
        if(isActivityShowing==isShowing){
            return;
        }
        isActivityShowing = isShowing;
        FloatingWindow.changeView(this,isActivityShowing);
    }
}
