package com.rtk.app.bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ListHisUserBean {
    List<HisUserBean> listBean = new ArrayList();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class HisUserBean {
        private long clickTime;
        private String face;
        private String fans;
        private String follows;
        private String nickname;
        private String notename;
        private String rtkUid;
        private String uid;

        public HisUserBean(OtherImformationBean otherImformationBean) {
            this.uid = otherImformationBean.getData().getUid();
            this.face = otherImformationBean.getData().getFace();
            this.fans = otherImformationBean.getData().getFans();
            this.nickname = otherImformationBean.getData().getNickname();
            this.follows = otherImformationBean.getData().getFollows();
            this.notename = otherImformationBean.getData().getNotename();
        }

        public long getClickTime() {
            return this.clickTime;
        }

        public String getFace() {
            return this.face;
        }

        public String getFans() {
            return this.fans;
        }

        public String getFollows() {
            return this.follows;
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

        public String getUid() {
            return this.uid;
        }

        public void setClickTime(long j) {
            this.clickTime = j;
        }

        public void setFace(String str) {
            this.face = str;
        }

        public void setFans(String str) {
            this.fans = str;
        }

        public void setFollows(String str) {
            this.follows = str;
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

        public void setUid(String str) {
            this.uid = str;
        }
    }

    public List<HisUserBean> getListBean() {
        return this.listBean;
    }

    public void setListBean(List<HisUserBean> list) {
        this.listBean = list;
    }
}
