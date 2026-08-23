package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostImageBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private int id;
        private String pic;
        private String thum;

        public int getId() {
            return this.id;
        }

        public String getPic() {
            return this.pic;
        }

        public String getThum() {
            return this.thum;
        }

        public void setId(int i) {
            this.id = i;
        }

        public void setPic(String str) {
            this.pic = str;
        }

        public void setThum(String str) {
            this.thum = str;
        }

        public String toString() {
            return "[img]" + getThum() + "[/img]";
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
