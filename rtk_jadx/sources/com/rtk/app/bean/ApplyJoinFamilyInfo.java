package com.rtk.app.bean;

import com.rtk.app.bean.FamilyInfoBean;
import java.io.Serializable;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ApplyJoinFamilyInfo implements Serializable {
    private int code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean extends FamilyInfoBean.DataBean implements Serializable {
        private String coin;
        private String face;
        private String id;
        private String msg;
        private String nickname;
        private String reason;
        private String status;
        private String statusText;
        private String uid;
        private List<PostTitleBean> user_title;

        public String getCoin() {
            return this.coin;
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

        public String getReason() {
            return this.reason;
        }

        public String getStatus() {
            return this.status;
        }

        public String getStatusText() {
            return this.statusText;
        }

        public String getUid() {
            return this.uid;
        }

        public List<PostTitleBean> getUser_title() {
            return this.user_title;
        }

        public void setCoin(String str) {
            this.coin = str;
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

        public void setReason(String str) {
            this.reason = str;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public void setStatusText(String str) {
            this.statusText = str;
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

    public String toString() {
        return "ApplyJoinFamilyInfo{code=" + this.code + ", msg='" + this.msg + "', data=" + this.data + '}';
    }
}
