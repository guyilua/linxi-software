package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SurvivalPathBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String data;
        private String data2;
        private String upload;
        private String videoUpload;

        public String getData() {
            return this.data;
        }

        public String getData2() {
            return this.data2;
        }

        public String getUpload() {
            return this.upload;
        }

        public String getVideoUpload() {
            return this.videoUpload;
        }

        public void setData(String str) {
            this.data = str;
        }

        public void setData2(String str) {
            this.data2 = str;
        }

        public void setUpload(String str) {
            this.upload = str;
        }

        public void setVideoUpload(String str) {
            this.videoUpload = str;
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
