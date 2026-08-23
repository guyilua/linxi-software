package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UserRankBean {
    private int code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        public AdminBean admin;
        private int age;
        private String allclock;
        private String allclockday;
        private String allclockmsg;
        private String allclocktime;
        private String birthday;
        private String close_days;
        private String close_reason;
        private String close_time;
        private String coin;
        private String collectNum;
        private String commentNum;
        private String content;
        private String contribute;
        private String email;
        private String experience;
        private String face;
        private String fans;
        protected int followed;
        private String follows;
        private int gameNum;
        private String gamelock;
        private String gamelockday;
        private String gamelockmsg;
        private String gamelocktime;
        private String hd_face;
        private String level;
        private String levelNum;
        private List<?> list_post_video;
        private List<?> medal;
        protected MyMedalListBean medalList;
        private String moderator;
        private String myUpNum;
        protected String nickname;
        private String notename;
        private List<?> photoWall;
        private List<?> pic;
        private String postcclock;
        private String postcclockday;
        private String postcclockmsg;
        private String postcclocktime;
        private String postclock;
        private String postclockday;
        private Object postclockmsg;
        private String postclocktime;
        private String posts;
        private String postsNum;
        private String qq;
        private QqLoginBean qqLogin;
        private int replyMeNum;
        private String replyNum;
        private String role;
        private String sex;
        private String signature;
        private int status;
        protected String uid;
        private String upAdmin;
        private String upCollectNum;
        private String upNum;
        private String upcclock;
        private String upcclockday;
        private String upcclockmsg;
        private String upcclocktime;
        private String upclock;
        private String upclockday;
        private Object upclockmsg;
        private String upclocktime;
        private List<PostTitleBean> user_title;
        private WxLoginBean wxLogin;
        private String zhicheng;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class AdminBean {
            private int admin;
            private int bbsAdmin;
            private String bbs_admin;
            private int commentadmin;
            private String leader;
            private int upAdmin;
            private String up_admin;
            private int userAdmin;

            public int getAdmin() {
                return this.admin;
            }

            public int getBbsAdmin() {
                return this.bbsAdmin;
            }

            public String getBbs_admin() {
                return this.bbs_admin;
            }

            public int getCommentadmin() {
                return this.commentadmin;
            }

            public String getLeader() {
                return this.leader;
            }

            public int getUpAdmin() {
                return this.upAdmin;
            }

            public String getUp_admin() {
                return this.up_admin;
            }

            public int getUserAdmin() {
                return this.userAdmin;
            }

            public void setAdmin(int i) {
                this.admin = i;
            }

            public void setBbsAdmin(int i) {
                this.bbsAdmin = i;
            }

            public void setBbs_admin(String str) {
                this.bbs_admin = str;
            }

            public void setCommentadmin(int i) {
                this.commentadmin = i;
            }

            public void setLeader(String str) {
                this.leader = str;
            }

            public void setUpAdmin(int i) {
                this.upAdmin = i;
            }

            public void setUp_admin(String str) {
                this.up_admin = str;
            }

            public void setUserAdmin(int i) {
                this.userAdmin = i;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class QqLoginBean {
            private String openid;
            private String q_face;
            private String q_nickname;

            public String getOpenid() {
                return this.openid;
            }

            public String getQ_face() {
                return this.q_face;
            }

            public String getQ_nickname() {
                return this.q_nickname;
            }

            public void setOpenid(String str) {
                this.openid = str;
            }

            public void setQ_face(String str) {
                this.q_face = str;
            }

            public void setQ_nickname(String str) {
                this.q_nickname = str;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class WxLoginBean {
            private String unionid;
            private String w_face;
            private String w_nickname;

            public String getUnionid() {
                return this.unionid;
            }

            public String getW_face() {
                return this.w_face;
            }

            public String getW_nickname() {
                return this.w_nickname;
            }

            public void setUnionid(String str) {
                this.unionid = str;
            }

            public void setW_face(String str) {
                this.w_face = str;
            }

            public void setW_nickname(String str) {
                this.w_nickname = str;
            }
        }

        public AdminBean getAdmin() {
            return this.admin;
        }

        public int getAge() {
            return this.age;
        }

        public String getAllclock() {
            return this.allclock;
        }

        public String getAllclockday() {
            return this.allclockday;
        }

        public String getAllclockmsg() {
            return this.allclockmsg;
        }

        public String getAllclocktime() {
            return this.allclocktime;
        }

        public String getBirthday() {
            return this.birthday;
        }

        public String getClose_days() {
            return this.close_days;
        }

        public String getClose_reason() {
            return this.close_reason;
        }

        public String getClose_time() {
            return this.close_time;
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

        public String getContent() {
            return this.content;
        }

        public String getContribute() {
            return this.contribute;
        }

        public String getEmail() {
            return this.email;
        }

        public String getExperience() {
            return this.experience;
        }

        public String getFace() {
            return this.face;
        }

        public String getFans() {
            return this.fans;
        }

        public int getFollowed() {
            return this.followed;
        }

        public String getFollows() {
            return this.follows;
        }

        public int getGameNum() {
            return this.gameNum;
        }

        public String getGamelock() {
            return this.gamelock;
        }

        public String getGamelockday() {
            return this.gamelockday;
        }

        public String getGamelockmsg() {
            return this.gamelockmsg;
        }

        public String getGamelocktime() {
            return this.gamelocktime;
        }

        public String getHd_face() {
            return this.hd_face;
        }

        public String getLevel() {
            return this.level;
        }

        public String getLevelNum() {
            return this.levelNum;
        }

        public List<?> getList_post_video() {
            return this.list_post_video;
        }

        public List<?> getMedal() {
            return this.medal;
        }

        public MyMedalListBean getMedalList() {
            return this.medalList;
        }

        public String getModerator() {
            return this.moderator;
        }

        public String getMyUpNum() {
            return this.myUpNum;
        }

        public String getNickname() {
            return this.nickname;
        }

        public String getNotename() {
            return this.notename;
        }

        public List<?> getPhotoWall() {
            return this.photoWall;
        }

        public List<?> getPic() {
            return this.pic;
        }

        public String getPostcclock() {
            return this.postcclock;
        }

        public String getPostcclockday() {
            return this.postcclockday;
        }

        public String getPostcclockmsg() {
            return this.postcclockmsg;
        }

        public String getPostcclocktime() {
            return this.postcclocktime;
        }

        public String getPostclock() {
            return this.postclock;
        }

        public String getPostclockday() {
            return this.postclockday;
        }

        public Object getPostclockmsg() {
            return this.postclockmsg;
        }

        public String getPostclocktime() {
            return this.postclocktime;
        }

        public String getPosts() {
            return this.posts;
        }

        public String getPostsNum() {
            return this.postsNum;
        }

        public String getQq() {
            return this.qq;
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

        public String getRole() {
            return this.role;
        }

        public String getSex() {
            return this.sex;
        }

        public String getSignature() {
            return this.signature;
        }

        public int getStatus() {
            return this.status;
        }

        public String getUid() {
            return this.uid;
        }

        public String getUpAdmin() {
            return this.upAdmin;
        }

        public String getUpCollectNum() {
            return this.upCollectNum;
        }

        public String getUpNum() {
            return this.upNum;
        }

        public String getUpcclock() {
            return this.upcclock;
        }

        public String getUpcclockday() {
            return this.upcclockday;
        }

        public String getUpcclockmsg() {
            return this.upcclockmsg;
        }

        public String getUpcclocktime() {
            return this.upcclocktime;
        }

        public String getUpclock() {
            return this.upclock;
        }

        public String getUpclockday() {
            return this.upclockday;
        }

        public Object getUpclockmsg() {
            return this.upclockmsg;
        }

        public String getUpclocktime() {
            return this.upclocktime;
        }

        public List<PostTitleBean> getUser_title() {
            return this.user_title;
        }

        public WxLoginBean getWxLogin() {
            return this.wxLogin;
        }

        public String getZhicheng() {
            return this.zhicheng;
        }

        public void setAdmin(AdminBean adminBean) {
            this.admin = adminBean;
        }

        public void setAge(int i) {
            this.age = i;
        }

        public void setAllclock(String str) {
            this.allclock = str;
        }

        public void setAllclockday(String str) {
            this.allclockday = str;
        }

        public void setAllclockmsg(String str) {
            this.allclockmsg = str;
        }

        public void setAllclocktime(String str) {
            this.allclocktime = str;
        }

        public void setBirthday(String str) {
            this.birthday = str;
        }

        public void setClose_days(String str) {
            this.close_days = str;
        }

        public void setClose_reason(String str) {
            this.close_reason = str;
        }

        public void setClose_time(String str) {
            this.close_time = str;
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

        public void setContent(String str) {
            this.content = str;
        }

        public void setContribute(String str) {
            this.contribute = str;
        }

        public void setEmail(String str) {
            this.email = str;
        }

        public void setExperience(String str) {
            this.experience = str;
        }

        public void setFace(String str) {
            this.face = str;
        }

        public void setFans(String str) {
            this.fans = str;
        }

        public void setFollowed(int i) {
            this.followed = i;
        }

        public void setFollows(String str) {
            this.follows = str;
        }

        public void setGameNum(int i) {
            this.gameNum = i;
        }

        public void setGamelock(String str) {
            this.gamelock = str;
        }

        public void setGamelockday(String str) {
            this.gamelockday = str;
        }

        public void setGamelockmsg(String str) {
            this.gamelockmsg = str;
        }

        public void setGamelocktime(String str) {
            this.gamelocktime = str;
        }

        public void setHd_face(String str) {
            this.hd_face = str;
        }

        public void setLevel(String str) {
            this.level = str;
        }

        public void setLevelNum(String str) {
            this.levelNum = str;
        }

        public void setList_post_video(List<?> list) {
            this.list_post_video = list;
        }

        public void setMedal(List<?> list) {
            this.medal = list;
        }

        public void setMedalList(MyMedalListBean myMedalListBean) {
            this.medalList = myMedalListBean;
        }

        public void setModerator(String str) {
            this.moderator = str;
        }

        public void setMyUpNum(String str) {
            this.myUpNum = str;
        }

        public void setNickname(String str) {
            this.nickname = str;
        }

        public void setNotename(String str) {
            this.notename = str;
        }

        public void setPhotoWall(List<?> list) {
            this.photoWall = list;
        }

        public void setPic(List<?> list) {
            this.pic = list;
        }

        public void setPostcclock(String str) {
            this.postcclock = str;
        }

        public void setPostcclockday(String str) {
            this.postcclockday = str;
        }

        public void setPostcclockmsg(String str) {
            this.postcclockmsg = str;
        }

        public void setPostcclocktime(String str) {
            this.postcclocktime = str;
        }

        public void setPostclock(String str) {
            this.postclock = str;
        }

        public void setPostclockday(String str) {
            this.postclockday = str;
        }

        public void setPostclockmsg(Object obj) {
            this.postclockmsg = obj;
        }

        public void setPostclocktime(String str) {
            this.postclocktime = str;
        }

        public void setPosts(String str) {
            this.posts = str;
        }

        public void setPostsNum(String str) {
            this.postsNum = str;
        }

        public void setQq(String str) {
            this.qq = str;
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

        public void setRole(String str) {
            this.role = str;
        }

        public void setSex(String str) {
            this.sex = str;
        }

        public void setSignature(String str) {
            this.signature = str;
        }

        public void setStatus(int i) {
            this.status = i;
        }

        public void setUid(String str) {
            this.uid = str;
        }

        public void setUpAdmin(String str) {
            this.upAdmin = str;
        }

        public void setUpCollectNum(String str) {
            this.upCollectNum = str;
        }

        public void setUpNum(String str) {
            this.upNum = str;
        }

        public void setUpcclock(String str) {
            this.upcclock = str;
        }

        public void setUpcclockday(String str) {
            this.upcclockday = str;
        }

        public void setUpcclockmsg(String str) {
            this.upcclockmsg = str;
        }

        public void setUpcclocktime(String str) {
            this.upcclocktime = str;
        }

        public void setUpclock(String str) {
            this.upclock = str;
        }

        public void setUpclockday(String str) {
            this.upclockday = str;
        }

        public void setUpclockmsg(Object obj) {
            this.upclockmsg = obj;
        }

        public void setUpclocktime(String str) {
            this.upclocktime = str;
        }

        public void setUser_title(List<PostTitleBean> list) {
            this.user_title = list;
        }

        public void setWxLogin(WxLoginBean wxLoginBean) {
            this.wxLogin = wxLoginBean;
        }

        public void setZhicheng(String str) {
            this.zhicheng = str;
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
