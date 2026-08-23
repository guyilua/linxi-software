package com.rtk.app.custom.TestPost;

import androidx.annotation.Keep;
import com.rtk.app.bean.UpApkListBean;
import java.util.List;

@Keep
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TestPostBean {
    private int code;
    private List<DataBean> data;
    private String msg;

    @Keep
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String client;
        private int cmtid;
        private int du;
        private int floor;
        private int is_admin;
        private int is_owner;
        private int isdu;
        private List<com.rtk.app.bean.DataBean> list_post_game;
        private List<ListPostImgBean> list_post_img;
        private List<ListPostPostBean> list_post_post;
        private List<UpApkListBean.DataBean> list_post_upfile;
        private List<ListPostUserBean> list_post_user;
        private List<ReplyBean> reply;
        private int replyNum;
        private int reply_id;
        private int root_reply_id;
        private String time;
        private String u_face;
        private String u_name;
        private int uid;
        private int uu;

        @Keep
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class ListPostImgBean {
            private int img_height;
            private String img_path;
            private int img_width;

            public int getImg_height() {
                return this.img_height;
            }

            public String getImg_path() {
                return this.img_path;
            }

            public int getImg_width() {
                return this.img_width;
            }

            public void setImg_height(int i) {
                this.img_height = i;
            }

            public void setImg_path(String str) {
                this.img_path = str;
            }

            public void setImg_width(int i) {
                this.img_width = i;
            }
        }

        @Keep
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class ListPostPostBean {
            private int pid;
            private String title;

            public int getPid() {
                return this.pid;
            }

            public String getTitle() {
                return this.title;
            }

            public void setPid(int i) {
                this.pid = i;
            }

            public void setTitle(String str) {
                this.title = str;
            }
        }

        @Keep
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class ListPostUserBean {
            private int uid;
            private String user_nickname;

            public int getUid() {
                return this.uid;
            }

            public String getUser_nickname() {
                return this.user_nickname;
            }

            public void setUid(int i) {
                this.uid = i;
            }

            public void setUser_nickname(String str) {
                this.user_nickname = str;
            }
        }

        @Keep
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class ReplyBean {
            private String client;
            private int cmtid;
            private String content;
            private int du;
            private int floor;
            private int is_admin;
            private int reply_id;
            private int root_reply_id;
            private int star;
            private String time;
            private String u_face;
            private String u_name;
            private int uid;
            private int uu;
            private String varName;

            public String getClient() {
                return this.client;
            }

            public int getCmtid() {
                return this.cmtid;
            }

            public String getContent() {
                return this.content;
            }

            public int getDu() {
                return this.du;
            }

            public int getFloor() {
                return this.floor;
            }

            public int getIs_admin() {
                return this.is_admin;
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

            public String getTime() {
                return this.time;
            }

            public String getU_face() {
                return this.u_face;
            }

            public String getU_name() {
                return this.u_name;
            }

            public int getUid() {
                return this.uid;
            }

            public int getUu() {
                return this.uu;
            }

            public String getVarName() {
                return this.varName;
            }

            public void setClient(String str) {
                this.client = str;
            }

            public void setCmtid(int i) {
                this.cmtid = i;
            }

            public void setContent(String str) {
                this.content = str;
            }

            public void setDu(int i) {
                this.du = i;
            }

            public void setFloor(int i) {
                this.floor = i;
            }

            public void setIs_admin(int i) {
                this.is_admin = i;
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

            public void setTime(String str) {
                this.time = str;
            }

            public void setU_face(String str) {
                this.u_face = str;
            }

            public void setU_name(String str) {
                this.u_name = str;
            }

            public void setUid(int i) {
                this.uid = i;
            }

            public void setUu(int i) {
                this.uu = i;
            }

            public void setVarName(String str) {
                this.varName = str;
            }
        }

        public String getClient() {
            return this.client;
        }

        public int getCmtid() {
            return this.cmtid;
        }

        public int getDu() {
            return this.du;
        }

        public int getFloor() {
            return this.floor;
        }

        public int getIs_admin() {
            return this.is_admin;
        }

        public int getIs_owner() {
            return this.is_owner;
        }

        public int getIsdu() {
            return this.isdu;
        }

        public List<com.rtk.app.bean.DataBean> getList_post_game() {
            return this.list_post_game;
        }

        public List<ListPostImgBean> getList_post_img() {
            return this.list_post_img;
        }

        public List<ListPostPostBean> getList_post_post() {
            return this.list_post_post;
        }

        public List<UpApkListBean.DataBean> getList_post_upfile() {
            return this.list_post_upfile;
        }

        public List<ListPostUserBean> getList_post_user() {
            return this.list_post_user;
        }

        public List<ReplyBean> getReply() {
            return this.reply;
        }

        public int getReplyNum() {
            return this.replyNum;
        }

        public int getReply_id() {
            return this.reply_id;
        }

        public int getRoot_reply_id() {
            return this.root_reply_id;
        }

        public String getTime() {
            return this.time;
        }

        public String getU_face() {
            return this.u_face;
        }

        public String getU_name() {
            return this.u_name;
        }

        public int getUid() {
            return this.uid;
        }

        public int getUu() {
            return this.uu;
        }

        public void setClient(String str) {
            this.client = str;
        }

        public void setCmtid(int i) {
            this.cmtid = i;
        }

        public void setDu(int i) {
            this.du = i;
        }

        public void setFloor(int i) {
            this.floor = i;
        }

        public void setIs_admin(int i) {
            this.is_admin = i;
        }

        public void setIs_owner(int i) {
            this.is_owner = i;
        }

        public void setIsdu(int i) {
            this.isdu = i;
        }

        public void setList_post_game(List<com.rtk.app.bean.DataBean> list) {
            this.list_post_game = list;
        }

        public void setList_post_img(List<ListPostImgBean> list) {
            this.list_post_img = list;
        }

        public void setList_post_post(List<ListPostPostBean> list) {
            this.list_post_post = list;
        }

        public void setList_post_upfile(List<UpApkListBean.DataBean> list) {
            this.list_post_upfile = list;
        }

        public void setList_post_user(List<ListPostUserBean> list) {
            this.list_post_user = list;
        }

        public void setReply(List<ReplyBean> list) {
            this.reply = list;
        }

        public void setReplyNum(int i) {
            this.replyNum = i;
        }

        public void setReply_id(int i) {
            this.reply_id = i;
        }

        public void setRoot_reply_id(int i) {
            this.root_reply_id = i;
        }

        public void setTime(String str) {
            this.time = str;
        }

        public void setU_face(String str) {
            this.u_face = str;
        }

        public void setU_name(String str) {
            this.u_name = str;
        }

        public void setUid(int i) {
            this.uid = i;
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
