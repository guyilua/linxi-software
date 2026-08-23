package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CommunityModoTypeBean {
    private String type;
    private String typeName;

    public CommunityModoTypeBean(String str, String str2) {
        this.type = str;
        this.typeName = str2;
    }

    public String getType() {
        return this.type;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setTypeName(String str) {
        this.typeName = str;
    }

    public String toString() {
        return getTypeName();
    }
}
