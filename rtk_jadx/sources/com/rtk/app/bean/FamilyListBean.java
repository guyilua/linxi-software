package com.rtk.app.bean;

import com.rtk.app.bean.FamilyInfoBean;
import java.io.Serializable;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyListBean implements Serializable {
    private int code;
    private List<FamilyInfoBean.DataBean> data;
    private String msg;

    public int getCode() {
        return this.code;
    }

    public List<FamilyInfoBean.DataBean> getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(List<FamilyInfoBean.DataBean> list) {
        this.data = list;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String toString() {
        return "FamilyListBean{code=" + this.code + ", msg='" + this.msg + "', data=" + this.data + '}';
    }
}
