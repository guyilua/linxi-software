package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyCommentItemBean {
    private int code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private int cmtid;
        private String content;
        private String data_package_size;
        private int du;
        private int game_id;
        private String game_intro;
        private int game_level;
        private String game_logo;
        private String game_name;
        private String game_type;
        private int game_updated;
        private String game_version;
        private int install_comment;
        private String install_package_size;
        private String package_name;
        private List<String> pic;
        private int reply_id;
        private int root_reply_id;
        private int star;
        private String t_name;
        private String tcontent;
        private int time;
        private String u_face;
        private String u_name;
        private String ucontent;
        private int uu;

        public int getCmtid() {
            return this.cmtid;
        }

        public String getContent() {
            return this.content;
        }

        public String getData_package_size() {
            return this.data_package_size;
        }

        public int getDu() {
            return this.du;
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

        public int getInstall_comment() {
            return this.install_comment;
        }

        public String getInstall_package_size() {
            return this.install_package_size;
        }

        public String getPackage_name() {
            return this.package_name;
        }

        public List<String> getPic() {
            return this.pic;
        }

        public int getReply_id() {
            return this.reply_id;
        }

        public int getRoot_reply_id() {
            return this.root_reply_id;
        }

        public int getStar() {
            return this.star;
        }

        public String getT_name() {
            return this.t_name;
        }

        public String getTcontent() {
            return this.tcontent;
        }

        public int getTime() {
            return this.time;
        }

        public String getU_face() {
            return this.u_face;
        }

        public String getU_name() {
            return this.u_name;
        }

        public String getUcontent() {
            return this.ucontent;
        }

        public int getUu() {
            return this.uu;
        }

        public void setCmtid(int i) {
            this.cmtid = i;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setData_package_size(String str) {
            this.data_package_size = str;
        }

        public void setDu(int i) {
            this.du = i;
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

        public void setInstall_comment(int i) {
            this.install_comment = i;
        }

        public void setInstall_package_size(String str) {
            this.install_package_size = str;
        }

        public void setPackage_name(String str) {
            this.package_name = str;
        }

        public void setPic(List<String> list) {
            this.pic = list;
        }

        public void setReply_id(int i) {
            this.reply_id = i;
        }

        public void setRoot_reply_id(int i) {
            this.root_reply_id = i;
        }

        public void setStar(int i) {
            this.star = i;
        }

        public void setT_name(String str) {
            this.t_name = str;
        }

        public void setTcontent(String str) {
            this.tcontent = str;
        }

        public void setTime(int i) {
            this.time = i;
        }

        public void setU_face(String str) {
            this.u_face = str;
        }

        public void setU_name(String str) {
            this.u_name = str;
        }

        public void setUcontent(String str) {
            this.ucontent = str;
        }

        public void setUu(int i) {
            this.uu = i;
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
