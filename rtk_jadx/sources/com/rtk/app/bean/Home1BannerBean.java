package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home1BannerBean {
    private int code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String game_id;
        private String image_url;
        private String title;

        public String getGame_id() {
            return this.game_id;
        }

        public String getImage_url() {
            return this.image_url;
        }

        public String getTitle() {
            return this.title;
        }

        public void setGame_id(String str) {
            this.game_id = str;
        }

        public void setImage_url(String str) {
            this.image_url = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }
    }

    public int getCode() {
        return this.code;
    }

    public List<DataBean> getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(List<DataBean> list) {
        this.data = list;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
