package com.rtk.app.bean;

import java.io.Serializable;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CheckUser implements Serializable {
    private String check_face;
    private String check_nickname;
    private String check_reason;
    private String check_time;
    private String check_uid;

    public String getCheck_face() {
        return this.check_face;
    }

    public String getCheck_nickname() {
        return this.check_nickname;
    }

    public String getCheck_reason() {
        return this.check_reason;
    }

    public String getCheck_time() {
        return this.check_time;
    }

    public String getCheck_uid() {
        return this.check_uid;
    }

    public void setCheck_face(String str) {
        this.check_face = str;
    }

    public void setCheck_nickname(String str) {
        this.check_nickname = str;
    }

    public void setCheck_reason(String str) {
        this.check_reason = str;
    }

    public void setCheck_time(String str) {
        this.check_time = str;
    }

    public void setCheck_uid(String str) {
        this.check_uid = str;
    }
}
