package com.coolstar.activityshowhide;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by jiguangxing on 2016/3/22.
 */
public class CommonViewHolder {
    TextView tvTitle;
    TextView tvLog;
    View btnStand,btnSingle,btnClear,btnInstance;

    public CommonViewHolder(View parentView) {
        tvTitle = (TextView)parentView.findViewById(R.id.activityname);
        tvLog = (TextView)parentView.findViewById(R.id.tasks);
        btnStand = parentView.findViewById(R.id.standbtn);
        btnSingle = parentView.findViewById(R.id.singlebtn);
        btnClear = parentView.findViewById(R.id.clearbtn);
        btnInstance = parentView.findViewById(R.id.instancebtn);
    }

    public void setBtnClickListener(View.OnClickListener standListener,View.OnClickListener singleListener,View.OnClickListener clearListener,View.OnClickListener instanceListener){
        btnStand.setOnClickListener(standListener);
        btnSingle.setOnClickListener(singleListener);
        btnClear.setOnClickListener(clearListener);
        btnInstance.setOnClickListener(instanceListener);
    }

    public void setTvTitle(String title){
        tvTitle.setText(title);
        tvLog.setText(getTaskList());
    }

    public void addLog(String log){
        tvLog.append(log);
    }

    public void clearLog(){
        tvLog.setText("");
    }

    public String getTaskList(){
        if(tvLog!=null){
            Context context = tvLog.getContext();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Service.ACTIVITY_SERVICE);
            List<ActivityManager.RunningTaskInfo> tasks = activityManager.getRunningTasks(1);
            if(tasks!=null&&tasks.size()>0){
                ActivityManager.RunningTaskInfo taskInfo = tasks.get(0);
               return taskInfo.baseActivity.getShortClassName()+"\n"+taskInfo.numActivities+"\n"+taskInfo.topActivity.getShortClassName();
            }
//            if(Build.VERSION.SDK_INT>Build.VERSION_CODES.KITKAT_WATCH){
//                List<ActivityManager.AppTask> appTasks = activityManager.getAppTasks();
//                if(appTasks!=null){
//                    for (int i = 0; i < appTasks.size(); i++) {
//                        ActivityManager.AppTask item = appTasks.get(i);
//                        item.getTaskInfo().;
//                    }
//                }
//            }
        }
        return "";
    }
}
