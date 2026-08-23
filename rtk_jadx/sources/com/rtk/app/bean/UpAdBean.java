package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpAdBean {
    private int code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String desc;
        private String pic;
        private int sid;
        private String tags;
        private String title;

        public String getDesc() {
            return this.desc;
        }

        public String getPic() {
            return this.pic;
        }

        public int getSid() {
            return this.sid;
        }

        public String getTags() {
            return this.tags;
        }

        public String getTitle() {
            return this.title;
        }

        public void setDesc(String str) {
            this.desc = str;
        }

        public void setPic(String str) {
            this.pic = str;
        }

        public void setSid(int i) {
            this.sid = i;
        }

        public void setTags(String str) {
            this.tags = str;
        }

        public void setTitle(String str) {
            this.title = str;
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
