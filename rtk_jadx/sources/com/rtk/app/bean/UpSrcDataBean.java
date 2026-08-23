package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpSrcDataBean {
    private int code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String addtime;
        private String day;
        private String score;
        private String sid;

        public String getAddtime() {
            return this.addtime;
        }

        public String getDay() {
            return this.day;
        }

        public String getScore() {
            return this.score;
        }

        public String getSid() {
            return this.sid;
        }

        public void setAddtime(String str) {
            this.addtime = str;
        }

        public void setDay(String str) {
            this.day = str;
        }

        public void setScore(String str) {
            this.score = str;
        }

        public void setSid(String str) {
            this.sid = str;
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
