package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class WechatH5PayBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String h5_url;

        public String getH5Url() {
            return this.h5_url;
        }

        public void setH5Url(String str) {
            this.h5_url = this.h5_url;
        }
    }

    public int getCode() {
        return this.code;
    }

    public DataBean getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
