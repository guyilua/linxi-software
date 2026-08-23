package com.rtk.app.bean;

import java.io.Serializable;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpDataPathListBean implements Serializable {
    private int is_prompt;
    private int prompt_id;
    private String prompt_message;
    private String url;
    private String zipKey;
    private int zipType;

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

    public String getZipKey() {
        return this.zipKey;
    }

    public int getZipType() {
        return this.zipType;
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

    public void setZipKey(String str) {
        this.zipKey = str;
    }

    public void setZipType(int i) {
        this.zipType = i;
    }
}
