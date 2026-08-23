package com.rtk.app.bean;

import java.io.Serializable;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DownLoadBean implements Serializable {
    private int code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String name;
        private int need_share;
        private String url;

        public String getName() {
            return this.name;
        }

        public int getNeed_share() {
            return this.need_share;
        }

        public String getUrl() {
            return this.url;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setNeed_share(int i) {
            this.need_share = i;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    public int getCode() {
        return this.code;
    }

    public List<DataBean> getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(List<DataBean> list) {
        this.data = list;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
