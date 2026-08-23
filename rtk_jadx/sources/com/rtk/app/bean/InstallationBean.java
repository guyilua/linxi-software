package com.rtk.app.bean;

import java.io.Serializable;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class InstallationBean implements Serializable {
    private List<InstallWayBean> installWay;
    private String tips;

    public List<InstallWayBean> getInstallWay() {
        return this.installWay;
    }

    public String getTips() {
        return this.tips;
    }

    public boolean isOnlyWay2() {
        List<InstallWayBean> list = this.installWay;
        return list != null && list.size() == 1 && this.installWay.get(0).getWay() == 2;
    }

    public void setInstallWay(List<InstallWayBean> list) {
        this.installWay = list;
    }

    public void setTips(String str) {
        this.tips = str;
    }

    public String toString() {
        return "InstallationBean{installWay=" + this.installWay + ", tips='" + this.tips + "'}";
    }
}
