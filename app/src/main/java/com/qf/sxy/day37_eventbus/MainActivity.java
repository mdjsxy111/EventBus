package com.qf.sxy.day37_eventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.qf.sxy.day37_eventbus.bean.EventMsg;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //注册EventBus
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //解除注册
        EventBus.getDefault().unregister(this);
    }

    /**
     * 在Ui线程执行
     * 不管发送消息在那个线程  都在主线程接收
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(EventMsg msg){

        Log.e("AAA","====onEventMainThread====="+msg.getMsg()+"=="+Thread.currentThread().getName());

    }

    /**
     * 默认方式
     *
     * 在那个线程发送  就在那个线程接收
     */
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onEvent(EventMsg msg){
        Log.e("AAA","====onEvent====="+msg.getMsg()+"=="+Thread.currentThread().getName());

    }

    /**
     * 在后台执行
     *
     * 在主线程发送  开启新的子线程接收
     * 在子线程发送  在当前子线程接收
     */
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEventBackGround(EventMsg msg){
        Log.e("AAA","====onEventBackGround====="+msg.getMsg()+"=="+Thread.currentThread().getName());
    }

    /**
     * 强制在后台执行
     *
     * 不管那个线程  都会开启新的线程接收
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onEventAsync(EventMsg msg){
        Log.e("AAA","====onEventAsync====="+msg.getMsg()+"=="+Thread.currentThread().getName());
    }

    public void MyClick(View view) {
        startActivity(new Intent(MainActivity.this,Main2Activity.class));
    }
}
