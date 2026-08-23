package com.rtk.app.bean;

import java.io.Serializable;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyCountPendingBean implements Serializable {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String postsCommentCount;
        private String postsCount;
        private String upCommentCount;
        private String upCount;

        public String getPostsCommentCount() {
            return this.postsCommentCount;
        }

        public String getPostsCount() {
            return this.postsCount;
        }

        public String getUpCommentCount() {
            return this.upCommentCount;
        }

        public String getUpCount() {
            return this.upCount;
        }

        public void setPostsCommentCount(String str) {
            this.postsCommentCount = str;
        }

        public void setPostsCount(String str) {
            this.postsCount = str;
        }

        public void setUpCommentCount(String str) {
            this.upCommentCount = str;
        }

        public void setUpCount(String str) {
            this.upCount = str;
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
