package com.rtk.app.bean;

import com.rtk.app.bean.GameDetailsBean;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CommentDetailsBean {
    private int code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private int cmtid;
        private String content;
        private int du;
        private GameDetailsBean.DataBean gameInfo;
        private int is_admin;
        private int level;
        private String phone_model;
        private List<String> pic;
        private List<ReplyBean> reply;
        private int reply_id;
        private int root_reply_id;
        private int star;
        private int time;
        private String u_face;
        private String u_name;
        private int uid;
        private int uu;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public class ReplyBean {
            private int cmtid;
            private String content;
            private int du;
            private int floor;
            private int hisFloor;
            private String hisName;
            private int is_admin;
            private int level;
            private String phone_model;
            private int reply_id;
            private int root_reply_id;
            private int star;
            private int time;
            private String u_face;
            private String u_name;
            private int uid;
            private int uu;

            public ReplyBean() {
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

            public int getHisFloor() {
                return this.hisFloor;
            }

            public String getHisName() {
                return this.hisName;
            }

            public int getIs_admin() {
                return this.is_admin;
            }

            public int getLevel() {
                return this.level;
            }

            public String getPhone_model() {
                return this.phone_model;
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

            public int getTime() {
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

            public void setHisFloor(int i) {
                this.hisFloor = i;
            }

            public void setHisName(String str) {
                this.hisName = str;
            }

            public void setIs_admin(int i) {
                this.is_admin = i;
            }

            public void setLevel(int i) {
                this.level = i;
            }

            public void setPhone_model(String str) {
                this.phone_model = str;
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

            public void setTime(int i) {
                this.time = i;
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

        public int getCmtid() {
            return this.cmtid;
        }

        public String getContent() {
            return this.content;
        }

        public int getDu() {
            return this.du;
        }

        public GameDetailsBean.DataBean getGameInfo() {
            return this.gameInfo;
        }

        public int getIs_admin() {
            return this.is_admin;
        }

        public int getLevel() {
            return this.level;
        }

        public String getPhone_model() {
            return this.phone_model;
        }

        public List<String> getPic() {
            return this.pic;
        }

        public List<ReplyBean> getReply() {
            return this.reply;
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

        public int getTime() {
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

        public void setCmtid(int i) {
            this.cmtid = i;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setDu(int i) {
            this.du = i;
        }

        public void setGameInfo(GameDetailsBean.DataBean dataBean) {
            this.gameInfo = dataBean;
        }

        public void setIs_admin(int i) {
            this.is_admin = i;
        }

        public void setLevel(int i) {
            this.level = i;
        }

        public void setPic(List<String> list) {
            this.pic = list;
        }

        public void setReply(List<ReplyBean> list) {
            this.reply = list;
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

        public void setTime(int i) {
            this.time = i;
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
