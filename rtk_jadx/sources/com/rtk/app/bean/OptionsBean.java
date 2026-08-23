package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class OptionsBean {
    private int coin;
    private String displayText;
    private boolean isChecked;
    private int rcoin;
    private double rmb;

    public int getCoin() {
        return this.coin;
    }

    public String getDisplayText() {
        return this.displayText;
    }

    public int getRcoin() {
        return this.rcoin;
    }

    public double getRmb() {
        return this.rmb;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }

    public void setCoin(int i) {
        this.coin = i;
    }

    public void setDisplayText(String str) {
        this.displayText = str;
    }

    public void setRcoin(int i) {
        this.rcoin = i;
    }

    public void setRmb(double d) {
        this.rmb = d;
    }
}
