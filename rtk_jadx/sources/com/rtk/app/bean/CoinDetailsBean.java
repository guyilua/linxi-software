package com.rtk.app.bean;

import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CoinDetailsBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String addtime;
        private String description;
        private Map<String, String> extra;
        private String manger;
        private String mid;
        private String msgType;
        private String nickname;
        private String pid;
        private String sid;

        public String getAddtime() {
            return this.addtime;
        }

        public String getDescription() {
            return this.description;
        }

        public Map<String, String> getExtra() {
            return this.extra;
        }

        public String getManger() {
            return this.manger;
        }

        public String getMid() {
            return this.mid;
        }

        public String getMsgType() {
            return this.msgType;
        }

        public String getNickname() {
            return this.nickname;
        }

        public String getPid() {
            return this.pid;
        }

        public String getSid() {
            return this.sid;
        }

        public void setAddtime(String str) {
            this.addtime = str;
        }

        public void setDescription(String str) {
            this.description = str;
        }

        public void setExtra(Map<String, String> map) {
            this.extra = map;
        }

        public void setManger(String str) {
            this.manger = str;
        }

        public void setMid(String str) {
            this.mid = str;
        }

        public void setMsgType(String str) {
            this.msgType = str;
        }

        public void setNickname(String str) {
            this.nickname = str;
        }

        public void setPid(String str) {
            this.pid = str;
        }

        public void setSid(String str) {
            this.sid = str;
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
