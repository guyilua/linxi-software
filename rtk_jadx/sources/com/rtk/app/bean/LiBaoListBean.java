package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class LiBaoListBean {
    private int code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String OtherPackage;
        private int game_id;
        private String game_logo;
        private String game_name;
        private String game_package_name;
        private String gift_content;
        private String gift_description;
        private int gift_id;
        private int gift_status;
        private double gift_surplus_percent;
        private String gift_title;
        private int need_install_game;
        private String receive_code;

        public int getGame_id() {
            return this.game_id;
        }

        public String getGame_logo() {
            return this.game_logo;
        }

        public String getGame_name() {
            return this.game_name;
        }

        public String getGame_package_name() {
            return this.game_package_name;
        }

        public String getGift_content() {
            return this.gift_content;
        }

        public String getGift_description() {
            return this.gift_description;
        }

        public int getGift_id() {
            return this.gift_id;
        }

        public int getGift_status() {
            return this.gift_status;
        }

        public double getGift_surplus_percent() {
            return this.gift_surplus_percent;
        }

        public String getGift_title() {
            return this.gift_title;
        }

        public int getNeed_install_game() {
            return this.need_install_game;
        }

        public String getOtherPackage() {
            return this.OtherPackage;
        }

        public void setGame_id(int i) {
            this.game_id = i;
        }

        public void setGame_logo(String str) {
            this.game_logo = str;
        }

        public void setGame_name(String str) {
            this.game_name = str;
        }

        public void setGame_package_name(String str) {
            this.game_package_name = str;
        }

        public void setGift_content(String str) {
            this.gift_content = str;
        }

        public void setGift_description(String str) {
            this.gift_description = str;
        }

        public void setGift_id(int i) {
            this.gift_id = i;
        }

        public void setGift_status(int i) {
            this.gift_status = i;
        }

        public void setGift_surplus_percent(double d) {
            this.gift_surplus_percent = d;
        }

        public void setGift_title(String str) {
            this.gift_title = str;
        }

        public void setNeed_install_game(int i) {
            this.need_install_game = i;
        }

        public void setOtherPackage(String str) {
            this.OtherPackage = str;
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
