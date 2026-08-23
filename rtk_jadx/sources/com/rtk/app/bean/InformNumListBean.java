package com.rtk.app.bean;

import java.io.Serializable;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class InformNumListBean implements Serializable {
    private int allUnreadNum;
    private int systemUnreadNum;
    private int userUnreadNum;

    public int getAllUnreadNum() {
        return this.allUnreadNum;
    }

    public int getSystemUnreadNum() {
        return this.systemUnreadNum;
    }

    public int getUserUnreadNum() {
        return this.userUnreadNum;
    }

    public void setAllUnreadNum(int i) {
        this.allUnreadNum = i;
    }

    public void setSystemUnreadNum(int i) {
        this.systemUnreadNum = i;
    }

    public void setUserUnreadNum(int i) {
        this.userUnreadNum = i;
    }
}
