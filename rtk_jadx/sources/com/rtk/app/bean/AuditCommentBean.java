package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AuditCommentBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private int state;
        private int state3;

        public int getState() {
            return this.state;
        }

        public int getState3() {
            return this.state3;
        }

        public void setState(int i) {
            this.state = i;
        }

        public void setState3(int i) {
            this.state3 = i;
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
