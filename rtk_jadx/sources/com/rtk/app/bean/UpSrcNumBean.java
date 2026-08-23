package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpSrcNumBean {
    private Integer code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private Integer todayhits;
        private String yearhits;

        public Integer getTodayhits() {
            return this.todayhits;
        }

        public String getYearhits() {
            return this.yearhits;
        }

        public void setTodayhits(Integer num) {
            this.todayhits = num;
        }

        public void setYearhits(String str) {
            this.yearhits = str;
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
