package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HotSearchBean {
    private int code;
    private List<String> data;
    private String msg;

    public int getCode() {
        return this.code;
    }

    public List<String> getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(List<String> list) {
        this.data = list;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
