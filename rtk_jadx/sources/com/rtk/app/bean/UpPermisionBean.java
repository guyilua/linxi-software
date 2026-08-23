package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpPermisionBean {
    private Integer code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String permissionMsg;

        public String getPermissionMsg() {
            return this.permissionMsg;
        }

        public void setPermissionMsg(String str) {
            this.permissionMsg = str;
        }
    }

    public Integer getCode() {
        return this.code;
    }

    public DataBean getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
