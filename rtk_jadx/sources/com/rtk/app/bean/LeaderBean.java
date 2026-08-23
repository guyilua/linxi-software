package com.rtk.app.bean;

import java.io.Serializable;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class LeaderBean implements Serializable {
    private int defaultFace = -1;
    private String face;
    private int id;
    private String nickname;

    public int getDefaultFace() {
        return this.defaultFace;
    }

    public String getFace() {
        return this.face;
    }

    public int getId() {
        return this.id;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setDefaultFace(int i) {
        this.defaultFace = i;
    }

    public void setFace(String str) {
        this.face = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }
}
