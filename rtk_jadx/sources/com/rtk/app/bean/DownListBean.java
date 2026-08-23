package com.rtk.app.bean;

import java.io.Serializable;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DownListBean implements Serializable {
    private String apkKey;
    private int apkType;
    private boolean isApk;
    private int is_prompt;
    private int need_share;
    private String prompt_id;
    private String prompt_message;
    private String url;
    private String zipKey;
    private int zipType;

    public DownListBean(String str) {
        this.apkType = 0;
        this.isApk = true;
        this.url = str;
    }

    public String getApkKey() {
        return this.apkKey;
    }

    public int getApkType() {
        return this.apkType;
    }

    public int getIs_prompt() {
        return this.is_prompt;
    }

    public int getNeed_share() {
        return this.need_share;
    }

    public String getPrompt_id() {
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

    public void setApkKey(String str) {
        this.apkKey = str;
    }

    public void setApkType(int i) {
        this.apkType = i;
    }

    public void setIs_prompt(int i) {
        this.is_prompt = i;
    }

    public void setNeed_share(int i) {
        this.need_share = i;
    }

    public void setPrompt_id(String str) {
        this.prompt_id = str;
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

    public String toString() {
        return "DownListBean{url='" + this.url + "', need_share=" + this.need_share + ", prompt_id='" + this.prompt_id + "', is_prompt=" + this.is_prompt + ", prompt_message='" + this.prompt_message + "', apkType=" + this.apkType + ", apkKey='" + this.apkKey + "', zipType=" + this.zipType + ", zipKey='" + this.zipKey + "', isApk=" + this.isApk + '}';
    }

    public DownListBean(UpDataPathListBean upDataPathListBean) {
        this.apkType = 0;
        this.isApk = true;
        this.isApk = true;
        this.zipType = upDataPathListBean.getZipType();
        this.zipKey = upDataPathListBean.getZipKey();
        this.is_prompt = upDataPathListBean.getIs_prompt();
        this.prompt_message = upDataPathListBean.getPrompt_message();
        this.url = upDataPathListBean.getUrl();
        this.prompt_id = upDataPathListBean.getPrompt_id() + "";
    }

    public DownListBean(UpSourcePathListBean upSourcePathListBean) {
        this.apkType = 0;
        this.isApk = true;
        this.isApk = true;
        this.apkType = upSourcePathListBean.getApkType();
        this.apkKey = upSourcePathListBean.getApkKey();
        this.is_prompt = upSourcePathListBean.getIs_prompt();
        this.prompt_message = upSourcePathListBean.getPrompt_message();
        this.url = upSourcePathListBean.getUrl();
        this.prompt_id = upSourcePathListBean.getPrompt_id() + "";
    }
}
