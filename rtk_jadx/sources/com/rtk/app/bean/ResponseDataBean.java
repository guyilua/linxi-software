package com.rtk.app.bean;

import java.io.Serializable;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ResponseDataBean implements Serializable {
    private int code;
    private Object data;
    private String msg;

    public int getCode() {
        return this.code;
    }

    public Object getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
