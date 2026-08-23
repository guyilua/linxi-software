package com.rtk.app.bean;

import java.io.Serializable;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class BoundQQorWechatBean implements Serializable {
    private String quickLoginType_Head = "";
    private String quickLoginType_content = "";
    private String quickLoginName_Head = "";
    private String quickLoginName_content = "";
    private String quickLoginIcon_Head = "";
    private String quickLoginIcon_content = "";

    public String getQuickLoginIcon_Head() {
        return this.quickLoginIcon_Head;
    }

    public String getQuickLoginIcon_content() {
        return this.quickLoginIcon_content;
    }

    public String getQuickLoginName_Head() {
        return this.quickLoginName_Head;
    }

    public String getQuickLoginName_content() {
        return this.quickLoginName_content;
    }

    public String getQuickLoginType_Head() {
        return this.quickLoginType_Head;
    }

    public String getQuickLoginType_content() {
        return this.quickLoginType_content;
    }

    public void setQuickLoginIcon_Head(String str) {
        this.quickLoginIcon_Head = str;
    }

    public void setQuickLoginIcon_content(String str) {
        this.quickLoginIcon_content = str;
    }

    public void setQuickLoginName_Head(String str) {
        this.quickLoginName_Head = str;
    }

    public void setQuickLoginName_content(String str) {
        this.quickLoginName_content = str;
    }

    public void setQuickLoginType_Head(String str) {
        this.quickLoginType_Head = str;
    }

    public void setQuickLoginType_content(String str) {
        this.quickLoginType_content = str;
    }
}
