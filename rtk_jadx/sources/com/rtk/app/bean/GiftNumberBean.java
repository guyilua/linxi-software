package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GiftNumberBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String receive_code;
        private String take_out_code;

        public String getReceive_code() {
            return this.receive_code;
        }

        public String getTake_out_code() {
            return this.take_out_code;
        }

        public void setReceive_code(String str) {
            this.receive_code = str;
        }

        public void setTake_out_code(String str) {
            this.take_out_code = str;
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
