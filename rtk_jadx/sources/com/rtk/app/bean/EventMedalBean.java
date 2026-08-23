package com.rtk.app.bean;

import java.io.Serializable;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class EventMedalBean implements Serializable {
    private String addtime;
    private String desc;
    private int get;
    private String id;
    private String last;
    private String pic;
    private String title;

    public String getAddtime() {
        return this.addtime;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getGet() {
        return this.get;
    }

    public String getId() {
        return this.id;
    }

    public String getLast() {
        return this.last;
    }

    public String getPic() {
        return this.pic;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAddtime(String str) {
        this.addtime = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setGet(int i) {
        this.get = i;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLast(String str) {
        this.last = str;
    }

    public void setPic(String str) {
        this.pic = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
