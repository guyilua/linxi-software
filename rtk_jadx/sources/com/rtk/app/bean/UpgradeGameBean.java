package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpgradeGameBean {
    private int code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private int game_id;
        private String game_version;
        private String package_name;
        private int version_code;

        public int getGame_id() {
            return this.game_id;
        }

        public String getGame_version() {
            return this.game_version;
        }

        public String getPackage_name() {
            return this.package_name;
        }

        public int getVersion_code() {
            return this.version_code;
        }

        public void setGame_id(int i) {
            this.game_id = i;
        }

        public void setGame_version(String str) {
            this.game_version = str;
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
