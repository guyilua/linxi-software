package com.rtk.app.bean;

import com.rtk.app.bean.PostDetailsBean;
import com.rtk.app.bean.UpApkListBean;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostCommentDetailsBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String client;
        private int cmtid;
        private List<CommentBean> comment;
        private int commentNum;
        private String content;
        private String display_mode;
        private int du;
        private int floor;
        private int isModerator;
        private int is_admin;
        private int is_owner;
        private int isdu;
        private List<com.rtk.app.bean.DataBean> list_post_game;
        private List<ListPostImgBean> list_post_img;
        private List<ListPostPostBean> list_post_post;
        private List<UpApkListBean.DataBean> list_post_upfile;
        private List<ListPostUserBean> list_post_user;
        private List<ListPostVideoBean> list_post_video;
        private MyMedalListBean medalList;
        private String nocomment;
        private List<String> pic;
        private PostDetailsBean.DataBean postsInfo;
        private int reply_id;
        private int root_reply_id;
        private int star;
        private String time;
        private String u_face;
        private String u_name;
        private int uid;
        private int uu;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class CommentBean {
            private String client;
            private int cmtid;
            private String content;
            private String display_mode = "";
            private int du;
            private int floor;
            private String hisFace;
            private int hisFloor;
            private String hisName;
            private String hisUid;
            private int is_admin;
            private int is_owner;
            private List<com.rtk.app.bean.DataBean> list_post_game;
            private List<ListPostImgBean> list_post_img;
            private List<ListPostPostBean> list_post_post;
            private List<UpApkListBean.DataBean> list_post_upfile;
            private List<ListPostUserBean> list_post_user;
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

            public String getDisplay_mode() {
                return this.display_mode;
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

            public void setDisplay_mode(String str) {
                this.display_mode = str;
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

        public List<CommentBean> getComment() {
            return this.comment;
        }

        public int getCommentNum() {
            return this.commentNum;
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

        public int getIsModerator() {
            return this.isModerator;
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

        public List<ListPostVideoBean> getList_post_video() {
            return this.list_post_video;
        }

        public MyMedalListBean getMedalList() {
            return this.medalList;
        }

        public String getNocomment() {
            return this.nocomment;
        }

        public List<String> getPic() {
            return this.pic;
        }

        public PostDetailsBean.DataBean getPostsInfo() {
            return this.postsInfo;
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

        public void setComment(List<CommentBean> list) {
            this.comment = list;
        }

        public void setCommentNum(int i) {
            this.commentNum = i;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setDisplay_mode(String str) {
            this.display_mode = str;
        }

        public void setDu(int i) {
            this.du = i;
        }

        public void setFloor(int i) {
            this.floor = i;
        }

        public void setIsModerator(int i) {
            this.isModerator = i;
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

        public void setList_post_video(List<ListPostVideoBean> list) {
            this.list_post_video = list;
        }

        public void setMedalList(MyMedalListBean myMedalListBean) {
            this.medalList = myMedalListBean;
        }

        public void setNocomment(String str) {
            this.nocomment = str;
        }

        public void setPic(List<String> list) {
            this.pic = list;
        }

        public void setPostsInfo(PostDetailsBean.DataBean dataBean) {
            this.postsInfo = dataBean;
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
