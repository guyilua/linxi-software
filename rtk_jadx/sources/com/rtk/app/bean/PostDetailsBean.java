package com.rtk.app.bean;

import com.rtk.app.bean.UpApkListBean;
import com.rtk.app.tool.c0;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostDetailsBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String addtime;
        protected int alloweDel;
        protected String clickNum;
        protected String coinNum;
        private String commentNum;
        private String content;
        protected String display_mode;
        private String edittime;
        private String face;
        private FamilyBean family;
        private int focused;
        private String id;
        private String isBoutique;
        protected int isModerator;
        private String isTop;
        protected List<LikeListBean> likeList;
        protected String likeNum;
        private int likes;
        protected List<com.rtk.app.bean.DataBean> list_post_game;
        protected List<ListPostImgBean> list_post_img;
        protected List<ListPostPostBean> list_post_post;
        protected List<UpApkListBean.DataBean> list_post_upfile;
        protected List<ListPostUserBean> list_post_user;
        protected List<ListPostVideoBean> list_post_video;
        private String mid;
        protected int moduleAdmin;
        private String msg;
        private String msg3;
        private String name;
        private String nocomment;
        protected String oldContent;
        protected int ownerNum;
        private List<String> pic;
        protected List<PostTitleBean> post_title;
        protected PostsBaseBean postsBase;
        protected List<RewardListBean> rewardList;
        protected String rewardNum;
        private int state;
        private int state3;
        private String tag;
        private List<TagsBean> tags;
        private String title;
        private String uid;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class LikeListBean {
            private String face;
            private String id;
            private String nickname;
            private String uid;

            public String getFace() {
                return this.face;
            }

            public String getId() {
                return this.id;
            }

            public void setFace(String str) {
                this.face = str;
            }

            public void setId(String str) {
                this.id = str;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class PostsBaseBean {
            protected int age;
            private String face;
            protected MyMedalListBean medalList;
            private String nickname;
            protected String sex;
            private List<PostTitleBean> user_title;

            public int getAge() {
                return this.age;
            }

            public String getFace() {
                return this.face;
            }

            public MyMedalListBean getMedalList() {
                return this.medalList;
            }

            public String getNickname() {
                return c0.q(this.nickname) ? "没有昵称" : this.nickname;
            }

            public String getSex() {
                return this.sex;
            }

            public List<PostTitleBean> getUser_title() {
                return this.user_title;
            }

            public void setFace(String str) {
                this.face = str;
            }

            public void setNickname(String str) {
                this.nickname = str;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class RewardListBean {
            private String coin;
            private String face;

            public String getCoin() {
                return this.coin;
            }

            public String getFace() {
                return this.face;
            }

            public void setCoin(String str) {
                this.coin = str;
            }

            public void setFace(String str) {
                this.face = str;
            }
        }

        public String getAddtime() {
            return this.addtime;
        }

        public int getAlloweDel() {
            return this.alloweDel;
        }

        public String getClickNum() {
            return this.clickNum;
        }

        public String getCoinNum() {
            return this.coinNum;
        }

        public String getCommentNum() {
            return this.commentNum;
        }

        public String getContent() {
            return this.content;
        }

        public String getDisplay_mode() {
            return this.display_mode;
        }

        public String getEdittime() {
            return this.edittime;
        }

        public String getFace() {
            return this.face;
        }

        public FamilyBean getFamily() {
            return this.family;
        }

        public int getFocused() {
            return this.focused;
        }

        public String getId() {
            return this.id;
        }

        public String getIsBoutique() {
            return this.isBoutique;
        }

        public int getIsModerator() {
            return this.isModerator;
        }

        public String getIsTop() {
            return this.isTop;
        }

        public List<LikeListBean> getLikeList() {
            return this.likeList;
        }

        public String getLikeNum() {
            return this.likeNum;
        }

        public int getLikes() {
            return this.likes;
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

        public String getMid() {
            return this.mid;
        }

        public int getModuleAdmin() {
            return this.moduleAdmin;
        }

        public String getMsg() {
            return this.msg;
        }

        public String getMsg3() {
            return this.msg3;
        }

        public String getName() {
            return this.name;
        }

        public String getNocomment() {
            return this.nocomment;
        }

        public String getOldContent() {
            return this.oldContent;
        }

        public int getOwnerNum() {
            return this.ownerNum;
        }

        public List<String> getPic() {
            return this.pic;
        }

        public List<PostTitleBean> getPost_title() {
            return this.post_title;
        }

        public PostsBaseBean getPostsBase() {
            return this.postsBase;
        }

        public List<RewardListBean> getRewardList() {
            return this.rewardList;
        }

        public String getRewardNum() {
            return this.rewardNum;
        }

        public int getState() {
            return this.state;
        }

        public int getState3() {
            return this.state3;
        }

        public String getTag() {
            return this.tag;
        }

        public List<TagsBean> getTags() {
            return this.tags;
        }

        public String getTitle() {
            return this.title;
        }

        public String getUid() {
            return this.uid;
        }

        public void setAddtime(String str) {
            this.addtime = str;
        }

        public void setCommentNum(String str) {
            this.commentNum = str;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setEdittime(String str) {
            this.edittime = str;
        }

        public void setFace(String str) {
            this.face = str;
        }

        public void setFamily(FamilyBean familyBean) {
            this.family = familyBean;
        }

        public void setFocused(int i) {
            this.focused = i;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setIsBoutique(String str) {
            this.isBoutique = str;
        }

        public void setIsTop(String str) {
            this.isTop = str;
        }

        public void setLikes(int i) {
            this.likes = i;
        }

        public void setMid(String str) {
            this.mid = str;
        }

        public void setMsg(String str) {
            this.msg = str;
        }

        public void setMsg3(String str) {
            this.msg3 = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setNocomment(String str) {
            this.nocomment = str;
        }

        public void setPic(List<String> list) {
            this.pic = list;
        }

        public void setState(int i) {
            this.state = i;
        }

        public void setState3(int i) {
            this.state3 = i;
        }

        public void setTag(String str) {
            this.tag = str;
        }

        public void setTags(List<TagsBean> list) {
            this.tags = list;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setUid(String str) {
            this.uid = str;
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
