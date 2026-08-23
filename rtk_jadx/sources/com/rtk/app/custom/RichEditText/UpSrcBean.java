package com.rtk.app.custom.RichEditText;

import androidx.annotation.Keep;

@Keep
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpSrcBean {
    private String upSrcId;
    private String upSrcName;

    public UpSrcBean(String str, String str2) {
        this.upSrcId = str;
        this.upSrcName = str2;
    }

    public String getUpSrcName() {
        return this.upSrcName;
    }

    public void setUpSrcName(String str) {
        this.upSrcName = str;
    }

    public String toString() {
        return "[upfile=" + this.upSrcId + "]" + this.upSrcName + "[/upfile]";
    }
}
