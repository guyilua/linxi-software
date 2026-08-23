package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostCommentUpBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private int cmtid;
        private int du;
        private int isdu;

        public int getCmtid() {
            return this.cmtid;
        }

        public int getDu() {
            return this.du;
        }

        public int getIsdu() {
            return this.isdu;
        }

        public void setCmtid(int i) {
            this.cmtid = i;
        }

        public void setDu(int i) {
            this.du = i;
        }

        public void setIsdu(int i) {
            this.isdu = i;
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
