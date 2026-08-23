package com.rtk.app.bean;

import java.io.Serializable;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UserUpSetCoinCheckBean implements Serializable {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean implements Serializable {
        private int maxCoin;
        private int minCoin;

        public int getMaxCoin() {
            return this.maxCoin;
        }

        public int getMinCoin() {
            return this.minCoin;
        }

        public void setMaxCoin(int i) {
            this.maxCoin = i;
        }

        public void setMinCoin(int i) {
            this.minCoin = i;
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
