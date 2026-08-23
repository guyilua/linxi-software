package com.rtk.app.bean;

import java.io.Serializable;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyBean implements Serializable {
    private int family_id;
    private String family_log;
    private String family_name;

    public int getFamily_id() {
        return this.family_id;
    }

    public String getFamily_log() {
        return this.family_log;
    }

    public String getFamily_name() {
        return this.family_name;
    }

    public void setFamily_id(int i) {
        this.family_id = i;
    }

    public void setFamily_log(String str) {
        this.family_log = str;
    }

    public void setFamily_name(String str) {
        this.family_name = str;
    }
}
