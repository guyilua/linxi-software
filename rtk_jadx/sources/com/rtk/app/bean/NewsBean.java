package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class NewsBean {
    private int code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private long addtime;
        private String cate_id;
        private String description;
        private String edit_user;
        private long edittime;
        private String game_id;
        private String game_name;
        private String id;
        private String is_del;
        private String new_title;
        private List<?> thum;

        public long getAddtime() {
            return this.addtime;
        }

        public String getCate_id() {
            return this.cate_id;
        }

        public String getDescription() {
            return this.description;
        }

        public String getEdit_user() {
            return this.edit_user;
        }

        public long getEdittime() {
            return this.edittime;
        }

        public String getGame_id() {
            return this.game_id;
        }

        public String getGame_name() {
            return this.game_name;
        }

        public String getId() {
            return this.id;
        }

        public String getIs_del() {
            return this.is_del;
        }

        public String getNew_title() {
            return this.new_title;
        }

        public List<?> getThum() {
            return this.thum;
        }

        public void setAddtime(long j) {
            this.addtime = j;
        }

        public void setCate_id(String str) {
            this.cate_id = str;
        }

        public void setDescription(String str) {
            this.description = str;
        }

        public void setEdit_user(String str) {
            this.edit_user = str;
        }

        public void setEdittime(long j) {
            this.edittime = j;
        }

        public void setGame_id(String str) {
            this.game_id = str;
        }

        public void setGame_name(String str) {
            this.game_name = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setIs_del(String str) {
            this.is_del = str;
        }

        public void setNew_title(String str) {
            this.new_title = str;
        }

        public void setThum(List<?> list) {
            this.thum = list;
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
