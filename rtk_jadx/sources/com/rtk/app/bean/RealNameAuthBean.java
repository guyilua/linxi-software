package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class RealNameAuthBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String id_num;
        private int is_authenticated;
        private String real_name;
        private String tips;

        public String getId_num() {
            return this.id_num;
        }

        public int getIs_authenticated() {
            return this.is_authenticated;
        }

        public String getReal_name() {
            return this.real_name;
        }

        public String getTips() {
            return this.tips;
        }

        public boolean isAuthenticated() {
            return this.is_authenticated == 1;
        }

        public void setId_num(String str) {
            this.id_num = str;
        }

        public void setIs_authenticated(int i) {
            this.is_authenticated = i;
        }

        public void setReal_name(String str) {
            this.real_name = str;
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
