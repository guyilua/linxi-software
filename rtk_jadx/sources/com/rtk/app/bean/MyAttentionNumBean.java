package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyAttentionNumBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private int momentsPost;
        private int momentsUp;
        private int num;

        public int getMomentsPost() {
            return this.momentsPost;
        }

        public int getMomentsUp() {
            return this.momentsUp;
        }

        public int getNum() {
            return this.num;
        }

        public void setMomentsPost(int i) {
            this.momentsPost = i;
        }

        public void setMomentsUp(int i) {
            this.momentsUp = i;
        }

        public void setNum(int i) {
            this.num = i;
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
