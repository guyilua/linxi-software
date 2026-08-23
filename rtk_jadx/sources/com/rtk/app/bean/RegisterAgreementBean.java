package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class RegisterAgreementBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String registerAgreement;

        public String getRegisterAgreement() {
            return this.registerAgreement;
        }

        public void setRegisterAgreement(String str) {
            this.registerAgreement = str;
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
