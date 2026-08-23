package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SearchPermissionBean {
    private Integer code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private Integer searchPermision;

        public Integer getSearchPermision() {
            return this.searchPermision;
        }

        public void setSearchPermision(Integer num) {
            this.searchPermision = num;
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
