package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ProtocolOfUpBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String about;
        private String id;
        private String msg;

        public String getAbout() {
            return this.about;
        }

        public String getId() {
            return this.id;
        }

        public String getMsg() {
            return this.msg;
        }

        public void setAbout(String str) {
            this.about = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setMsg(String str) {
            this.msg = str;
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
