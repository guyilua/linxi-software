package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class BlacklistListBean {
    private int code;
    private List<DataDTO> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataDTO {
        private String face;
        private String hdFace;
        private boolean isBlacklist = true;
        private String nickname;
        private String uid;

        public String getFace() {
            return this.face;
        }

        public String getHdFace() {
            return this.hdFace;
        }

        public String getNickname() {
            return this.nickname;
        }

        public String getUid() {
            return this.uid;
        }

        public boolean isBlacklist() {
            return this.isBlacklist;
        }

        public void setBlacklist(boolean z) {
            this.isBlacklist = z;
        }

        public void setFace(String str) {
            this.face = str;
        }

        public void setHdFace(String str) {
            this.hdFace = str;
        }

        public void setNickname(String str) {
            this.nickname = str;
        }

        public void setUid(String str) {
            this.uid = str;
        }
    }

    public int getCode() {
        return this.code;
    }

    public List<DataDTO> getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(List<DataDTO> list) {
        this.data = list;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
