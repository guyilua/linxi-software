package com.rtk.app.bean;

import java.io.Serializable;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyCreateCheckTipsBean implements Serializable {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean implements Serializable {
        private FamilyCreateCheckBean checkApplyFamily;
        private FamilyCreateCheckBean checkCoin;
        private FamilyCreateCheckBean checkFamily;
        private FamilyCreateCheckBean checkLevel;
        private FamilyCreateCheckBean checkRealNameAuth;
        private String createDesc;
        private String createTips;

        public FamilyCreateCheckBean getCheckApplyFamily() {
            return this.checkApplyFamily;
        }

        public FamilyCreateCheckBean getCheckCoin() {
            return this.checkCoin;
        }

        public FamilyCreateCheckBean getCheckFamily() {
            return this.checkFamily;
        }

        public FamilyCreateCheckBean getCheckLevel() {
            return this.checkLevel;
        }

        public FamilyCreateCheckBean getCheckRealNameAuth() {
            return this.checkRealNameAuth;
        }

        public String getCreateDesc() {
            return this.createDesc;
        }

        public String getCreateTips() {
            return this.createTips;
        }

        public void setCheckApplyFamily(FamilyCreateCheckBean familyCreateCheckBean) {
            this.checkApplyFamily = familyCreateCheckBean;
        }

        public void setCheckCoin(FamilyCreateCheckBean familyCreateCheckBean) {
            this.checkCoin = familyCreateCheckBean;
        }

        public void setCheckFamily(FamilyCreateCheckBean familyCreateCheckBean) {
            this.checkFamily = familyCreateCheckBean;
        }

        public void setCheckLevel(FamilyCreateCheckBean familyCreateCheckBean) {
            this.checkLevel = familyCreateCheckBean;
        }

        public void setCheckRealNameAuth(FamilyCreateCheckBean familyCreateCheckBean) {
            this.checkRealNameAuth = familyCreateCheckBean;
        }

        public void setCreateDesc(String str) {
            this.createDesc = str;
        }

        public void setCreateTips(String str) {
            this.createTips = str;
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
