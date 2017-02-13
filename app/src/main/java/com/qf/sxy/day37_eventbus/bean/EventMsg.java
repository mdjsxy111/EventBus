package com.qf.sxy.day37_eventbus.bean;

/**
 * Created by sxy on 2016/11/15.
 *
 * 消息事件
 */
public class EventMsg {

    private String msg;

    public EventMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
