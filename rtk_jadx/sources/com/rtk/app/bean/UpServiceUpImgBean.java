package com.rtk.app.bean;

import androidx.annotation.NonNull;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpServiceUpImgBean {
    private int code;
    private String msg;
    private PathBean path;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class PathBean {
        private String pic;
        private String thumb;
        private String url;

        public String getPic() {
            return this.pic;
        }

        public String getThumb() {
            return this.thumb;
        }

        public String getUrl() {
            return this.url;
        }

        public void setPic(String str) {
            this.pic = str;
        }

        public void setThumb(String str) {
            this.thumb = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public PathBean getPath() {
        return this.path;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setPath(PathBean pathBean) {
        this.path = pathBean;
    }

    @NonNull
    public String toString() {
        return "[img]" + getPath().getUrl() + getPath().getThumb() + "[/img]";
    }
}
