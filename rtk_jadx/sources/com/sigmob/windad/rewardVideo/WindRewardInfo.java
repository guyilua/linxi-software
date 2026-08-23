package com.sigmob.windad.rewardVideo;

import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class WindRewardInfo {
    private final boolean a;
    private HashMap<String, String> b;

    public WindRewardInfo(boolean z) {
        this.a = z;
    }

    public WindRewardInfo(boolean z, HashMap<String, String> hashMap) {
        this.a = z;
        this.b = hashMap;
    }

    public HashMap<String, String> getOptions() {
        return this.b;
    }

    public boolean isReward() {
        return this.a;
    }

    public void setOptions(HashMap<String, String> hashMap) {
        this.b = hashMap;
    }

    public String toString() {
        return "WindRewardInfo{isReward=" + this.a + ", options=" + this.b + '}';
    }
}
