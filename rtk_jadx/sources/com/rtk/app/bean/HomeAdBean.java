package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeAdBean {
    private int code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private int ad_id;
        private String ad_image;
        private int ad_status;
        private String ad_title;

        public int getAd_id() {
            return this.ad_id;
        }

        public String getAd_image() {
            return this.ad_image;
        }

        public int getAd_status() {
            return this.ad_status;
        }

        public String getAd_title() {
            return this.ad_title;
        }

        public void setAd_id(int i) {
            this.ad_id = i;
        }

        public void setAd_image(String str) {
            this.ad_image = str;
        }

        public void setAd_status(int i) {
            this.ad_status = i;
        }

        public void setAd_title(String str) {
            this.ad_title = str;
        }
    }

    public int getCode() {
        return this.code;
    }

    public List<DataBean> getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(List<DataBean> list) {
        this.data = list;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
