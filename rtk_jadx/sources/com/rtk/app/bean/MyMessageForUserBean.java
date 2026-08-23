package com.rtk.app.bean;

import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyMessageForUserBean {
    private int code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String coin;
        private String edittime;
        private Map<String, String> extra;
        private String face;
        private String id;
        private String msg;
        private String nickname;
        private String opened;
        private String sid;
        private String title;
        private String type;
        private String uid;

        public String getCoin() {
            return this.coin;
        }

        public String getEdittime() {
            return this.edittime;
        }

        public Map<String, String> getExtra() {
            return this.extra;
        }

        public String getFace() {
            return this.face;
        }

        public String getId() {
            return this.id;
        }

        public String getMsg() {
            return this.msg;
        }

        public String getNickname() {
            return this.nickname;
        }

        public String getOpened() {
            return this.opened;
        }

        public String getSid() {
            return this.sid;
        }

        public String getTitle() {
            return this.title;
        }

        public String getType() {
            return this.type;
        }

        public String getUid() {
            return this.uid;
        }

        public void setCoin(String str) {
            this.coin = str;
        }

        public void setEdittime(String str) {
            this.edittime = str;
        }

        public void setFace(String str) {
            this.face = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setMsg(String str) {
            this.msg = str;
        }

        public void setNickname(String str) {
            this.nickname = str;
        }

        public void setOpened(String str) {
            this.opened = str;
        }

        public void setSid(String str) {
            this.sid = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setType(String str) {
            this.type = str;
        }

        public void setUid(String str) {
            this.uid = str;
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
