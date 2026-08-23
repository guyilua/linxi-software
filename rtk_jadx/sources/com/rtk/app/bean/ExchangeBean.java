package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ExchangeBean {
    private int isCustom;
    private List<OptionsBean> options;
    private String ratio;

    public int getIsCustom() {
        return this.isCustom;
    }

    public List<OptionsBean> getOptions() {
        return this.options;
    }

    public String getRatio() {
        return this.ratio;
    }

    public boolean isCustom() {
        return this.isCustom == 1;
    }

    public void setIsCustom(int i) {
        this.isCustom = i;
    }

    public void setOptions(List<OptionsBean> list) {
        this.options = list;
    }

    public void setRatio(String str) {
        this.ratio = str;
    }
}
