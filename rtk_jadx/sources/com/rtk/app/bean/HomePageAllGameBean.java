package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomePageAllGameBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private List<com.rtk.app.bean.DataBean> boutique;
        private int displayMinigame;
        private List<com.rtk.app.bean.DataBean> hot;
        private List<com.rtk.app.bean.DataBean> latest;
        private List<com.rtk.app.bean.DataBean> speed;

        public List<com.rtk.app.bean.DataBean> getBoutique() {
            return this.boutique;
        }

        public int getDisplayMinigame() {
            return this.displayMinigame;
        }

        public List<com.rtk.app.bean.DataBean> getHot() {
            return this.hot;
        }

        public List<com.rtk.app.bean.DataBean> getLatest() {
            return this.latest;
        }

        public List<com.rtk.app.bean.DataBean> getSpeed() {
            return this.speed;
        }

        public void setBoutique(List<com.rtk.app.bean.DataBean> list) {
            this.boutique = list;
        }

        public void setDisplayMinigame(int i) {
            this.displayMinigame = i;
        }

        public void setHot(List<com.rtk.app.bean.DataBean> list) {
            this.hot = list;
        }

        public void setLatest(List<com.rtk.app.bean.DataBean> list) {
            this.latest = list;
        }

        public void setSpeed(List<com.rtk.app.bean.DataBean> list) {
            this.speed = list;
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
