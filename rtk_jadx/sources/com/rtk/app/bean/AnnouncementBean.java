package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AnnouncementBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String ad_desc;
        private String ad_id;
        private String is_ad;

        public String getAd_desc() {
            return this.ad_desc;
        }

        public String getAd_id() {
            return this.ad_id;
        }

        public String getIs_ad() {
            return this.is_ad;
        }

        public void setAd_desc(String str) {
            this.ad_desc = str;
        }

        public void setAd_id(String str) {
            this.ad_id = str;
        }

        public void setIs_ad(String str) {
            this.is_ad = str;
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
