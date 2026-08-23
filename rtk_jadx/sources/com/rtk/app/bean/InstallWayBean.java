package com.rtk.app.bean;

import java.io.Serializable;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class InstallWayBean implements Serializable {
    private int is_prompt;
    private List<String> packageName;
    private int prompt_id;
    private String prompt_message;
    private String prompt_window;
    private int way;

    public int getIs_prompt() {
        return this.is_prompt;
    }

    public List<String> getPackageName() {
        return this.packageName;
    }

    public int getPrompt_id() {
        return this.prompt_id;
    }

    public String getPrompt_message() {
        return this.prompt_message;
    }

    public String getPrompt_window() {
        return this.prompt_window;
    }

    public int getWay() {
        return this.way;
    }

    public void setIs_prompt(int i) {
        this.is_prompt = i;
    }

    public void setPackageName(List<String> list) {
        this.packageName = list;
    }

    public void setPrompt_id(int i) {
        this.prompt_id = i;
    }

    public void setPrompt_message(String str) {
        this.prompt_message = str;
    }

    public void setWay(int i) {
        this.way = i;
    }

    public String toString() {
        return "InstallWayBean{way=" + this.way + ", is_prompt=" + this.is_prompt + ", prompt_id=" + this.prompt_id + ", prompt_message='" + this.prompt_message + "', packageName=" + this.packageName + '}';
    }
}
