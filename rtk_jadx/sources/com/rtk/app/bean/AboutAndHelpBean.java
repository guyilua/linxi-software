package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AboutAndHelpBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class BeianBean {
        String beianUrl;
        String forTheRecord;

        public String getBeianUrl() {
            return this.beianUrl;
        }

        public String getForTheRecord() {
            return this.forTheRecord;
        }

        public void setBeianUrl(String str) {
            this.beianUrl = str;
        }

        public void setForTheRecord(String str) {
            this.forTheRecord = str;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private BeianBean beian;
        private String id;
        private String ruansky_url;
        private String serve_descrip;
        private String serve_email;
        private List<String> serve_group;
        private List<String> serve_group_key;
        private String serve_qdkf;
        private String serve_qq;
        private String serve_wechat;

        public BeianBean getBeian() {
            return this.beian;
        }

        public String getId() {
            return this.id;
        }

        public String getRuansky_url() {
            return this.ruansky_url;
        }

        public String getServe_descrip() {
            return this.serve_descrip;
        }

        public String getServe_email() {
            return this.serve_email;
        }

        public List<String> getServe_group() {
            return this.serve_group;
        }

        public List<String> getServe_group_key() {
            return this.serve_group_key;
        }

        public String getServe_qdkf() {
            return this.serve_qdkf;
        }

        public String getServe_qq() {
            return this.serve_qq;
        }

        public String getServe_wechat() {
            return this.serve_wechat;
        }

        public void setBeian(BeianBean beianBean) {
            this.beian = beianBean;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setRuansky_url(String str) {
            this.ruansky_url = str;
        }

        public void setServe_descrip(String str) {
            this.serve_descrip = str;
        }

        public void setServe_email(String str) {
            this.serve_email = str;
        }

        public void setServe_group(List<String> list) {
            this.serve_group = list;
        }

        public void setServe_group_key(List<String> list) {
            this.serve_group_key = list;
        }

        public void setServe_qdkf(String str) {
            this.serve_qdkf = str;
        }

        public void setServe_qq(String str) {
            this.serve_qq = str;
        }

        public void setServe_wechat(String str) {
            this.serve_wechat = str;
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
