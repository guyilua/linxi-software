package com.rtk.app.bean;

import com.google.gson.a.c;
import java.io.Serializable;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class WXPayOrderBean implements Serializable {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String appId;
        private String nonceStr;

        @c("package")
        private String packageX;
        private String partnerId;
        private String paySign;
        private String prepayId;
        private String signType;
        private String timeStamp;

        public String getAppId() {
            return this.appId;
        }

        public String getNonceStr() {
            return this.nonceStr;
        }

        public String getPackageX() {
            return this.packageX;
        }

        public String getPartnerId() {
            return this.partnerId;
        }

        public String getPaySign() {
            return this.paySign;
        }

        public String getPrepayId() {
            return this.prepayId;
        }

        public String getSignType() {
            return this.signType;
        }

        public String getTimeStamp() {
            return this.timeStamp;
        }

        public void setAppId(String str) {
            this.appId = str;
        }

        public void setNonceStr(String str) {
            this.nonceStr = str;
        }

        public void setPackageX(String str) {
            this.packageX = str;
        }

        public void setPartnerId(String str) {
            this.partnerId = str;
        }

        public void setPaySign(String str) {
            this.paySign = str;
        }

        public void setPrepayId(String str) {
            this.prepayId = str;
        }

        public void setSignType(String str) {
            this.signType = str;
        }

        public void setTimeStamp(String str) {
            this.timeStamp = str;
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
