package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AuditResultBean {
    private int code;
    private DataDTO data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataDTO {
        private int state;

        public int getState() {
            return this.state;
        }

        public void setState(int i) {
            this.state = i;
        }
    }

    public int getCode() {
        return this.code;
    }

    public DataDTO getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(DataDTO dataDTO) {
        this.data = dataDTO;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
