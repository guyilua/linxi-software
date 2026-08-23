package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home5ImfromationBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private AdminBean admin;
        private int age;
        private AuthorityBean authority;
        private String birthday;
        private String coin;
        private String collectNum;
        private String commentNum;
        private String contribute;
        private long created;
        private String experience;
        private String face;
        private String face_new;
        private String fans;
        private String follows;
        private int gameNum;
        private InformNumListBean informNumList;
        private String level;
        private String levelNum;
        private List<String> medal;
        private MyMedalListBean medalList;
        private String myUpNum;
        private String nickname;
        private String nickname_new;
        private List<PhotoWallBean> photoWall;
        private String posts;
        private String postsNum;
        private QqLoginBean qqLogin;
        private int replyMeNum;
        private String replyNum;
        private String rtkUid;
        private String sex;
        private String signature;
        private String signature_new;
        private String status;
        private String uid;
        private String upCollectNum;
        private String upNum;
        private List<PostTitleBean> user_title;
        private WxLoginBean wxLogin;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class PhotoWallBean {
            private String check_status;
            private String edittime;
            private String id;
            private String pic;
            private String showed;
            private String thumPic;
            private String type;
            private String uid;

            public String getCheck_status() {
                return this.check_status;
            }

            public String getEdittime() {
                return this.edittime;
            }

            public String getId() {
                return this.id;
            }

            public String getPic() {
                return this.pic;
            }

            public String getShowed() {
                return this.showed;
            }

            public String getThumPic() {
                return this.thumPic;
            }

            public String getType() {
                return this.type;
            }

            public String getUid() {
                return this.uid;
            }

            public void setCheck_status(String str) {
                this.check_status = str;
            }

            public void setEdittime(String str) {
                this.edittime = str;
            }

            public void setId(String str) {
                this.id = str;
            }

            public void setPic(String str) {
                this.pic = str;
            }

            public void setShowed(String str) {
                this.showed = str;
            }

            public void setThumPic(String str) {
                this.thumPic = str;
            }

            public void setType(String str) {
                this.type = str;
            }

            public void setUid(String str) {
                this.uid = str;
            }
        }

        public AdminBean getAdmin() {
            return this.admin;
        }

        public int getAge() {
            return this.age;
        }

        public AuthorityBean getAuthority() {
            return this.authority;
        }

        public String getBirthday() {
            return this.birthday;
        }

        public String getCoin() {
            return this.coin;
        }

        public String getCollectNum() {
            return this.collectNum;
        }

        public String getCommentNum() {
            return this.commentNum;
        }

        public String getContribute() {
            return this.contribute;
        }

        public long getCreated() {
            return this.created;
        }

        public String getExperience() {
            return this.experience;
        }

        public String getFace() {
            return this.face;
        }

        public String getFace_new() {
            return this.face_new;
        }

        public String getFans() {
            return this.fans;
        }

        public String getFollows() {
            return this.follows;
        }

        public int getGameNum() {
            return this.gameNum;
        }

        public InformNumListBean getInformNumList() {
            return this.informNumList;
        }

        public String getLevel() {
            return this.level;
        }

        public String getLevelNum() {
            return this.levelNum;
        }

        public List<String> getMedal() {
            return this.medal;
        }

        public MyMedalListBean getMedalList() {
            return this.medalList;
        }

        public String getMyUpNum() {
            return this.myUpNum;
        }

        public String getNickname() {
            return this.nickname;
        }

        public String getNickname_new() {
            return this.nickname_new;
        }

        public List<PhotoWallBean> getPhotoWall() {
            return this.photoWall;
        }

        public String getPosts() {
            return this.posts;
        }

        public String getPostsNum() {
            return this.postsNum;
        }

        public QqLoginBean getQqLogin() {
            return this.qqLogin;
        }

        public int getReplyMeNum() {
            return this.replyMeNum;
        }

        public String getReplyNum() {
            return this.replyNum;
        }

        public String getRtkUid() {
            return this.rtkUid;
        }

        public String getSex() {
            return this.sex;
        }

        public String getSignature() {
            return this.signature;
        }

        public String getSignature_new() {
            return this.signature_new;
        }

        public String getStatus() {
            return this.status;
        }

        public String getUid() {
            return this.uid;
        }

        public String getUpCollectNum() {
            return this.upCollectNum;
        }

        public int getUpNum() {
            try {
                return Integer.parseInt(this.upNum);
            } catch (Exception unused) {
                return 0;
            }
        }

        public List<PostTitleBean> getUser_title() {
            return this.user_title;
        }

        public WxLoginBean getWxLogin() {
            return this.wxLogin;
        }

        public void setAdmin(AdminBean adminBean) {
            this.admin = adminBean;
        }

        public void setAge(int i) {
            this.age = i;
        }

        public void setAuthority(AuthorityBean authorityBean) {
            this.authority = authorityBean;
        }

        public void setBirthday(String str) {
            this.birthday = str;
        }

        public void setCoin(String str) {
            this.coin = str;
        }

        public void setCollectNum(String str) {
            this.collectNum = str;
        }

        public void setCommentNum(String str) {
            this.commentNum = str;
        }

        public void setContribute(String str) {
            this.contribute = str;
        }

        public void setCreated(long j) {
            this.created = j;
        }

        public void setExperience(String str) {
            this.experience = str;
        }

        public void setFace(String str) {
            this.face = str;
        }

        public void setFace_new(String str) {
            this.face_new = str;
        }

        public void setFans(String str) {
            this.fans = str;
        }

        public void setFollows(String str) {
            this.follows = str;
        }

        public void setGameNum(int i) {
            this.gameNum = i;
        }

        public void setInformNumList(InformNumListBean informNumListBean) {
            this.informNumList = informNumListBean;
        }

        public void setLevel(String str) {
            this.level = str;
        }

        public void setLevelNum(String str) {
            this.levelNum = str;
        }

        public void setMedal(List<String> list) {
            this.medal = list;
        }

        public void setMedalList(MyMedalListBean myMedalListBean) {
            this.medalList = myMedalListBean;
        }

        public void setMyUpNum(String str) {
            this.myUpNum = str;
        }

        public void setNickname(String str) {
            this.nickname = str;
        }

        public void setNickname_new(String str) {
            this.nickname_new = str;
        }

        public void setPhotoWall(List<PhotoWallBean> list) {
            this.photoWall = list;
        }

        public void setPosts(String str) {
            this.posts = str;
        }

        public void setPostsNum(String str) {
            this.postsNum = str;
        }

        public void setQqLogin(QqLoginBean qqLoginBean) {
            this.qqLogin = qqLoginBean;
        }

        public void setReplyMeNum(int i) {
            this.replyMeNum = i;
        }

        public void setReplyNum(String str) {
            this.replyNum = str;
        }

        public void setRtkUid(String str) {
            this.rtkUid = str;
        }

        public void setSex(String str) {
            this.sex = str;
        }

        public void setSignature(String str) {
            this.signature = str;
        }

        public void setSignature_new(String str) {
            this.signature_new = str;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public void setUid(String str) {
            this.uid = str;
        }

        public void setUpCollectNum(String str) {
            this.upCollectNum = str;
        }

        public void setUpNum(String str) {
            this.upNum = str;
        }

        public void setUser_title(List<PostTitleBean> list) {
            this.user_title = list;
        }

        public void setWxLogin(WxLoginBean wxLoginBean) {
            this.wxLogin = wxLoginBean;
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
