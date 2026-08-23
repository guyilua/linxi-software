package com.rtk.app.bean;

import androidx.annotation.NonNull;
import java.io.Serializable;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyAttentionBean implements Serializable {
    private int code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean implements Serializable {
        private String face;
        private String fans;
        private String fansNum;
        private String followed;
        private String nickname;
        private String notename;
        private String rtkUid;

        public String getFace() {
            return this.face;
        }

        public String getFans() {
            return this.fans;
        }

        public String getFansNum() {
            return this.fansNum;
        }

        public String getFollowed() {
            return this.followed;
        }

        public String getNickname() {
            return this.nickname;
        }

        public String getNotename() {
            return this.notename;
        }

        public String getRtkUid() {
            return this.rtkUid;
        }

        public void setFace(String str) {
            this.face = str;
        }

        public void setFans(String str) {
            this.fans = str;
        }

        public void setFansNum(String str) {
            this.fansNum = str;
        }

        public void setFollowed(String str) {
            this.followed = str;
        }

        public void setNickname(String str) {
            this.nickname = str;
        }

        public void setNotename(String str) {
            this.notename = str;
        }

        public void setRtkUid(String str) {
            this.rtkUid = str;
        }

        @NonNull
        public String toString() {
            return "[user=" + getFans() + "]" + getNickname() + "[/user]";
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
