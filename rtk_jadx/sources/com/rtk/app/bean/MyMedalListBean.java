package com.rtk.app.bean;

import java.io.Serializable;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyMedalListBean implements Serializable {
    private List<AchievementBean> achievement;
    private List<EventMedalBean> eventMedal;

    public List<AchievementBean> getAchievement() {
        return this.achievement;
    }

    public List<EventMedalBean> getEventMedal() {
        return this.eventMedal;
    }
}
