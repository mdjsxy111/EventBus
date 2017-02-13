package com.qf.sxy.day37_eventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.qf.sxy.day37_eventbus.bean.EventMsg;

import org.greenrobot.eventbus.EventBus;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    //点击按钮发送消息
    public void MyClick(View view) {
        //在主线程发送消息
       // EventBus.getDefault().post(new EventMsg("许中真扣"));

        //在子线程发送消息
        new MyThread().start();
    }

    public class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            EventBus.getDefault().post(new EventMsg("许中真扣"));
        }
    }
}
