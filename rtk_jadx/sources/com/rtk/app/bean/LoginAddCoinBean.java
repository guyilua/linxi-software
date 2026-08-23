package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class LoginAddCoinBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private int isShow;
        private String tips;

        public int getIsShow() {
            return this.isShow;
        }

        public String getTips() {
            return this.tips;
        }

        public void setIsShow(int i) {
            this.isShow = i;
        }

        public void setTips(String str) {
            this.tips = str;
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
