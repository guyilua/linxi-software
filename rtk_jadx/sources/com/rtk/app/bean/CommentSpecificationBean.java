package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CommentSpecificationBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String commentSpecification;

        public String getCommentSpecification() {
            return this.commentSpecification;
        }

        public void setCommentSpecification(String str) {
            this.commentSpecification = str;
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
