package com.coolstar.activityshowhide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by jiguangxing on 2016/3/22.
 */
public class FourActivity extends AppCompatActivity {
    CommonViewHolder viewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        viewHolder = new CommonViewHolder(findViewById(R.id.commpanel));
        viewHolder.setTvTitle("FourActivity");
        viewHolder.setBtnClickListener(standListener,singleListener,clearListener,instanceListener);
    }
    private View.OnClickListener standListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(FourActivity.this,SecondActivity.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener singleListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(FourActivity.this,SecondActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    };
    private View.OnClickListener clearListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(FourActivity.this,SecondActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    };
    private View.OnClickListener instanceListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(FourActivity.this,SecondActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        }
    };
}
