package com.wss.module.main.bean;

import com.wss.common.base.bean.BaseBean;

import lombok.Getter;
import lombok.Setter;

/**
 * Describe：聊天信息
 * Created by 吴天强 on 2018/10/30.
 */
@Getter
@Setter
public class IMMessage extends BaseBean {

    public static final int TYPE_SEND = 0;
    public static final int TYPE_FROM = 1;

    private String name;//姓名
    private int icon;//头像
    private int type;//消息类型 0 发送 1接受
    private String msg;//消息内容
    private String date;//消息时间

    public static int getTypeSend() {
        return TYPE_SEND;
    }

    public static int getTypeFrom() {
        return TYPE_FROM;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public IMMessage(String name, int icon, int type, String msg) {
        this.name = name;
        this.icon = icon;
        this.type = type;
        this.msg = msg;
    }
}
