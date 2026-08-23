package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostUpAndRewardListBean {
    private int code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String addtime;
        private String coin;
        private String face;
        private String focused;
        private String id;
        private String mid;
        private String nickname;
        private String pid;
        private String type;
        private String uid;

        public String getAddtime() {
            return this.addtime;
        }

        public String getCoin() {
            return this.coin;
        }

        public String getFace() {
            return this.face;
        }

        public String getFocused() {
            return this.focused;
        }

        public String getId() {
            return this.id;
        }

        public String getMid() {
            return this.mid;
        }

        public String getNickname() {
            return this.nickname;
        }

        public String getPid() {
            return this.pid;
        }

        public String getType() {
            return this.type;
        }

        public String getUid() {
            return this.uid;
        }

        public void setAddtime(String str) {
            this.addtime = str;
        }

        public void setCoin(String str) {
            this.coin = str;
        }

        public void setFace(String str) {
            this.face = str;
        }

        public void setFocused(String str) {
            this.focused = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setMid(String str) {
            this.mid = str;
        }

        public void setNickname(String str) {
            this.nickname = str;
        }

        public void setPid(String str) {
            this.pid = str;
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
