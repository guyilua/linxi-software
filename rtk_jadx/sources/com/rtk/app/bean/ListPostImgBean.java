package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ListPostImgBean {
    private String height;
    private String pic;
    private String thumb;
    private String width;

    public int getHeight() {
        try {
            return Integer.parseInt(this.height);
        } catch (Exception unused) {
            return 0;
        }
    }

    public String getPic() {
        return this.pic;
    }

    public String getThumb() {
        return this.thumb;
    }

    public int getWidth() {
        try {
            return Integer.parseInt(this.width);
        } catch (Exception unused) {
            return 0;
        }
    }

    public void setPic(String str) {
        this.pic = str;
    }
}
