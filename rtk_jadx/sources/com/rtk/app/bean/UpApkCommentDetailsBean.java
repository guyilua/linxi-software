package com.rtk.app.bean;

import com.rtk.app.bean.UpApkDetailsBean;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpApkCommentDetailsBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String client;
        private int cmtid;
        private String content;
        private int du;
        private int floor;
        private String hisFace;
        private int hisFloor;
        private String hisName;
        private String hisUid;
        private int is_admin;
        private int isdu;
        private int isuu;
        private List<String> pic;
        private List<ReplyBean> reply;
        private int reply_id;
        private int root_reply_id;
        private UpApkDetailsBean.DataBean sourceInfo;
        private int star;
        private String time;
        private String u_face;
        private String u_name;
        private int uid;
        private int uu;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class ReplyBean {
            private String client;
            private int cmtid;
            private String content;
            private int du;
            private int floor;
            private String hisFace;
            private int hisFloor;
            private String hisName;
            private String hisUid;
            private int is_admin;
            private int is_owner;
            private int isdu;
            private int isuu;
            private List<String> pic;
            private List<?> reply;
            private int reply_id;
            private int root_reply_id;
            private int star;
            private String time;
            private String u_face;
            private String u_name;
            private int uid;
            private int uu;

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

            public String getHisFace() {
                return this.hisFace;
            }

            public int getHisFloor() {
                return this.hisFloor;
            }

            public String getHisName() {
                return this.hisName;
            }

            public String getHisUid() {
                return this.hisUid;
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

            public int getIsuu() {
                return this.isuu;
            }

            public List<String> getPic() {
                return this.pic;
            }

            public List<?> getReply() {
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

            public void setContent(String str) {
                this.content = str;
            }

            public void setDu(int i) {
                this.du = i;
            }

            public void setFloor(int i) {
                this.floor = i;
            }

            public void setHisFace(String str) {
                this.hisFace = str;
            }

            public void setHisFloor(int i) {
                this.hisFloor = i;
            }

            public void setHisName(String str) {
                this.hisName = str;
            }

            public void setHisUid(String str) {
                this.hisUid = str;
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

            public void setIsuu(int i) {
                this.isuu = i;
            }

            public void setPic(List<String> list) {
                this.pic = list;
            }

            public void setReply(List<?> list) {
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

        public String getHisFace() {
            return this.hisFace;
        }

        public int getHisFloor() {
            return this.hisFloor;
        }

        public String getHisName() {
            return this.hisName;
        }

        public String getHisUid() {
            return this.hisUid;
        }

        public int getIs_admin() {
            return this.is_admin;
        }

        public int getIsdu() {
            return this.isdu;
        }

        public int getIsuu() {
            return this.isuu;
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

        public UpApkDetailsBean.DataBean getSourceInfo() {
            return this.sourceInfo;
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

        public void setHisFace(String str) {
            this.hisFace = str;
        }

        public void setHisFloor(int i) {
            this.hisFloor = i;
        }

        public void setHisName(String str) {
            this.hisName = str;
        }

        public void setHisUid(String str) {
            this.hisUid = str;
        }

        public void setIs_admin(int i) {
            this.is_admin = i;
        }

        public void setIsdu(int i) {
            this.isdu = i;
        }

        public void setIsuu(int i) {
            this.isuu = i;
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

        public void setSourceInfo(UpApkDetailsBean.DataBean dataBean) {
            this.sourceInfo = dataBean;
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
    }

    public int getCode() {
        return this.code;
    }

    public DataBean getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
