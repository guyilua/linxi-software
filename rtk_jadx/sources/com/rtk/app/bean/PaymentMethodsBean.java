package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PaymentMethodsBean {
    private int enabled;
    private String id;
    private int isBrowser;
    private String name;
    private String url;

    public int getEnabled() {
        return this.enabled;
    }

    public String getId() {
        return this.id;
    }

    public int getIsBrowser() {
        return this.isBrowser;
    }

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isEnabled() {
        return this.enabled == 1;
    }

    public void setEnabled(int i) {
        this.enabled = i;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }
}
