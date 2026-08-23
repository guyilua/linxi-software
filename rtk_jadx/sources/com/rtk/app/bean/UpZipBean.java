package com.rtk.app.bean;

import java.io.Serializable;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpZipBean implements Serializable {
    private Integer code;
    private String dataPath;
    private double dataSize;
    private String zipKey = "";
    private int zipSecTrans;
    private int zipType;
    private String zipmd5;

    public Integer getCode() {
        return this.code;
    }

    public String getDataPath() {
        return this.dataPath;
    }

    public double getDataSize() {
        return this.dataSize;
    }

    public String getZipKey() {
        return this.zipKey;
    }

    public int getZipSecTrans() {
        return this.zipSecTrans;
    }

    public int getZipType() {
        return this.zipType;
    }

    public String getZipmd5() {
        return this.zipmd5;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public void setDataPath(String str) {
        this.dataPath = str;
    }

    public void setDataSize(double d) {
        this.dataSize = d;
    }

    public void setZipKey(String str) {
        this.zipKey = str;
    }

    public void setZipSecTrans(int i) {
        this.zipSecTrans = i;
    }

    public void setZipType(int i) {
        this.zipType = i;
    }

    public void setZipmd5(String str) {
        this.zipmd5 = str;
    }
}
