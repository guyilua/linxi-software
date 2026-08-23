package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MedalListBean {
    private Integer code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private List<AchievementBean> achievement;
        private List<EventMedalBean> eventMedal;

        public List<AchievementBean> getAchievement() {
            return this.achievement;
        }

        public List<EventMedalBean> getEventMedal() {
            return this.eventMedal;
        }

        public void setAchievement(List<AchievementBean> list) {
            this.achievement = list;
        }

        public void setEventMedal(List<EventMedalBean> list) {
            this.eventMedal = list;
        }
    }

    public Integer getCode() {
        return this.code;
    }

    public DataBean getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
