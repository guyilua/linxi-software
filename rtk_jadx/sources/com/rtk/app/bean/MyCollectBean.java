package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyCollectBean {
    private int code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private int collect_time;
        private Object data_package_size;
        private int game_id;
        private String game_intro;
        private int game_level;
        private String game_logo;
        private String game_name;
        private String game_type;
        private int game_updated;
        private String game_version;
        private String install_package_size;
        private String package_name;
        private int version_code;

        public int getCollect_time() {
            return this.collect_time;
        }

        public Object getData_package_size() {
            return this.data_package_size;
        }

        public int getGame_id() {
            return this.game_id;
        }

        public String getGame_intro() {
            return this.game_intro;
        }

        public int getGame_level() {
            return this.game_level;
        }

        public String getGame_logo() {
            return this.game_logo;
        }

        public String getGame_name() {
            return this.game_name;
        }

        public String getGame_type() {
            return this.game_type;
        }

        public int getGame_updated() {
            return this.game_updated;
        }

        public String getGame_version() {
            return this.game_version;
        }

        public String getInstall_package_size() {
            return this.install_package_size;
        }

        public String getPackage_name() {
            return this.package_name;
        }

        public int getVersion_code() {
            return this.version_code;
        }

        public void setCollect_time(int i) {
            this.collect_time = i;
        }

        public void setData_package_size(Object obj) {
            this.data_package_size = obj;
        }

        public void setGame_id(int i) {
            this.game_id = i;
        }

        public void setGame_intro(String str) {
            this.game_intro = str;
        }

        public void setGame_level(int i) {
            this.game_level = i;
        }

        public void setGame_logo(String str) {
            this.game_logo = str;
        }

        public void setGame_name(String str) {
            this.game_name = str;
        }

        public void setGame_type(String str) {
            this.game_type = str;
        }

        public void setGame_updated(int i) {
            this.game_updated = i;
        }

        public void setGame_version(String str) {
            this.game_version = str;
        }

        public void setInstall_package_size(String str) {
            this.install_package_size = str;
        }

        public void setPackage_name(String str) {
            this.package_name = str;
        }

        public void setVersion_code(int i) {
            this.version_code = i;
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
