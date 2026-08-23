package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpDataRTKBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String ad_desc;
        private String ad_id;
        private String description;
        private String down_url;
        private String id;
        private String is_ad;
        private int is_update;
        private String low_version;
        private int version;

        public String getAd_desc() {
            return this.ad_desc;
        }

        public String getAd_id() {
            return this.ad_id;
        }

        public String getDescription() {
            return this.description;
        }

        public String getDown_url() {
            return this.down_url;
        }

        public String getId() {
            return this.id;
        }

        public String getIs_ad() {
            return this.is_ad;
        }

        public int getIs_update() {
            return this.is_update;
        }

        public String getLow_version() {
            return this.low_version;
        }

        public int getVersion() {
            return this.version;
        }

        public void setAd_desc(String str) {
            this.ad_desc = str;
        }

        public void setAd_id(String str) {
            this.ad_id = str;
        }

        public void setDescription(String str) {
            this.description = str;
        }

        public void setDown_url(String str) {
            this.down_url = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setIs_ad(String str) {
            this.is_ad = str;
        }

        public void setIs_update(int i) {
            this.is_update = i;
        }

        public void setLow_version(String str) {
            this.low_version = str;
        }

        public void setVersion(int i) {
            this.version = i;
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
