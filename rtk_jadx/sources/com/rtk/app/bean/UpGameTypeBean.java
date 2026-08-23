package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpGameTypeBean {
    private int code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String id;
        private String title;
        private String type;

        public String getId() {
            return this.id;
        }

        public String getTitle() {
            return this.title;
        }

        public String getType() {
            return this.type;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setType(String str) {
            this.type = str;
        }

        public String toString() {
            return this.title;
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
