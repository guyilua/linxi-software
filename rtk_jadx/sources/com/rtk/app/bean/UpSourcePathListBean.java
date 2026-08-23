package com.rtk.app.bean;

import java.io.Serializable;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpSourcePathListBean implements Serializable {
    private String apkKey;
    private int apkType;
    private int is_prompt;
    private int prompt_id;
    private String prompt_message;
    private String url;

    public String getApkKey() {
        return this.apkKey;
    }

    public int getApkType() {
        return this.apkType;
    }

    public int getIs_prompt() {
        return this.is_prompt;
    }

    public int getPrompt_id() {
        return this.prompt_id;
    }

    public String getPrompt_message() {
        return this.prompt_message;
    }

    public String getUrl() {
        return this.url;
    }

    public void setApkKey(String str) {
        this.apkKey = str;
    }

    public void setApkType(int i) {
        this.apkType = i;
    }

    public void setIs_prompt(int i) {
        this.is_prompt = i;
    }

    public void setPrompt_id(int i) {
        this.prompt_id = i;
    }

    public void setPrompt_message(String str) {
        this.prompt_message = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
