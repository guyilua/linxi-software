package com.rtk.app.bean;

import com.rtk.app.bean.UpApkListBean;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostDetailsCommentBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private List<ReplyListBean> replyList;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class ReplyListBean {
            private int cmtid;
            private String content;
            private String display_mode;
            private int du;
            private int floor;
            private int is_owner;
            private int isdu;
            private List<com.rtk.app.bean.DataBean> list_post_game;
            private List<ListPostImgBean> list_post_img;
            private List<ListPostPostBean> list_post_post;
            private List<UpApkListBean.DataBean> list_post_upfile;
            private List<ListPostUserBean> list_post_user;
            private MyMedalListBean medalList;
            private int page = 0;
            private List<ReplyBean> reply;
            private int replyNum;
            private String time;
            private String u_face;
            private String u_name;
            private int uid;
            private List<PostTitleBean> user_title;

            public int getCmtid() {
                return this.cmtid;
            }

            public String getContent() {
                return this.content;
            }

            public String getDisplay_mode() {
                return this.display_mode;
            }

            public int getDu() {
                return this.du;
            }

            public int getFloor() {
                return this.floor;
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

            public MyMedalListBean getMedalList() {
                return this.medalList;
            }

            public int getPage() {
                return this.page;
            }

            public List<ReplyBean> getReply() {
                return this.reply;
            }

            public int getReplyNum() {
                return this.replyNum;
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

            public List<PostTitleBean> getUser_title() {
                return this.user_title;
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

            public void setIs_owner(int i) {
                this.is_owner = i;
            }

            public void setIsdu(int i) {
                this.isdu = i;
            }

            public void setPage(int i) {
                this.page = i;
            }

            public void setReplyNum(int i) {
                this.replyNum = i;
            }

            public void setTime(String str) {
                this.time = str;
            }

            public void setU_name(String str) {
                this.u_name = str;
            }

            public void setUid(int i) {
                this.uid = i;
            }

            public void setUser_title(List<PostTitleBean> list) {
                this.user_title = list;
            }
        }

        public List<ReplyListBean> getReplyList() {
            return this.replyList;
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
