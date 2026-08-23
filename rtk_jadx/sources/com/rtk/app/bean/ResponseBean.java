package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ResponseBean {
    private String data;
    private String iv;
    private boolean validation = true;

    public String getData() {
        return this.data;
    }

    public String getIv() {
        return this.iv;
    }

    public boolean isValidation() {
        return this.validation;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setIv(String str) {
        this.iv = str;
    }

    public void setValidation(boolean z) {
        this.validation = z;
    }
}
