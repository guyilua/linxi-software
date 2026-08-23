package com.rtk.app.bean;

import java.io.Serializable;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyCreateCheckBean implements Serializable {
    private Object data;
    private String desc;
    private int is_ok;
    private String tips;

    public Object getData() {
        return this.data;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getIs_ok() {
        return this.is_ok;
    }

    public String getTips() {
        return this.tips;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setIs_ok(int i) {
        this.is_ok = i;
    }

    public void setTips(String str) {
        this.tips = str;
    }
}
