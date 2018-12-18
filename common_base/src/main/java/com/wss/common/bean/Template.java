package com.wss.common.bean;

import com.wss.common.base.BaseActivity;
import com.wss.common.base.bean.BaseBean;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/**
 * Describe：可跳转的模板
 * Created by 吴天强 on 2018/11/13.
 */
@Getter
@Setter
public class Template extends BaseBean {

    private String title;
    private int res;
    private String describe;
    private Class clazz;
    private String url;//模块外跳转链接
    private int type;//0.本模块内Activity跳转 1.业务模块跳转 2.应用外跳转[WebView]
    private Map<String, ?> params;//其他附加参数

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Map<String, ?> getParams() {
        return params;
    }

    public void setParams(Map<String, ?> params) {
        this.params = params;
    }

    public Template(String title, int res, String url, int type, String describe) {
        this.title = title;
        this.res = res;
        this.url = url;
        this.type = type;
        this.describe = describe;
    }

    public Template(String title, int res, Class<? extends BaseActivity> clazz) {
        this(title, res, clazz, "");
    }

    public Template(String title, int res, Class<? extends BaseActivity> clazz, String describe) {
        this.title = title;
        this.res = res;
        this.clazz = clazz;
        this.describe = describe;
    }

}
