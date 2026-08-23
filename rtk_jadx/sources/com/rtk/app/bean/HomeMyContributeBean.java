package com.rtk.app.bean;

import androidx.annotation.Keep;
import java.util.List;

@Keep
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeMyContributeBean {
    private int code;
    private List<DataBean> data;
    private String msg;

    @Keep
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String addtime;
        private String coin;
        private String contribute;
        private String days;
        private String deleted;
        private String description;
        private String experience;
        private String id;
        private String manger;
        private String mid;
        private String month;
        private String nickname;
        private String pid;
        private String score;
        private String shareId;
        private String sid;
        private String subType;
        private String type;
        private String uid;

        public String getAddtime() {
            return this.addtime;
        }

        public String getCoin() {
            return this.coin;
        }

        public String getContribute() {
            return this.contribute;
        }

        public String getDays() {
            return this.days;
        }

        public String getDeleted() {
            return this.deleted;
        }

        public String getDescription() {
            return this.description;
        }

        public String getExperience() {
            return this.experience;
        }

        public String getId() {
            return this.id;
        }

        public String getManger() {
            return this.manger;
        }

        public String getMid() {
            return this.mid;
        }

        public String getMonth() {
            return this.month;
        }

        public String getNickname() {
            return this.nickname;
        }

        public String getPid() {
            return this.pid;
        }

        public String getScore() {
            return this.score;
        }

        public String getShareId() {
            return this.shareId;
        }

        public String getSid() {
            return this.sid;
        }

        public String getSubType() {
            return this.subType;
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

        public void setContribute(String str) {
            this.contribute = str;
        }

        public void setDays(String str) {
            this.days = str;
        }

        public void setDeleted(String str) {
            this.deleted = str;
        }

        public void setDescription(String str) {
            this.description = str;
        }

        public void setExperience(String str) {
            this.experience = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setManger(String str) {
            this.manger = str;
        }

        public void setMid(String str) {
            this.mid = str;
        }

        public void setMonth(String str) {
            this.month = str;
        }

        public void setNickname(String str) {
            this.nickname = str;
        }

        public void setPid(String str) {
            this.pid = str;
        }

        public void setScore(String str) {
            this.score = str;
        }

        public void setShareId(String str) {
            this.shareId = str;
        }

        public void setSid(String str) {
            this.sid = str;
        }

        public void setSubType(String str) {
            this.subType = str;
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
