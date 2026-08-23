package com.rtk.app.bean;

import java.io.Serializable;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class OtherImformationBean implements Serializable {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean implements Serializable {
        private int age;
        private String birthday;
        private String close_days;
        private String close_reason;
        private String close_time;
        private String coin;
        private String collectNum;
        private String commentNum;
        private String contribute;
        private String email;
        private String experience;
        private String face;
        private String fans;
        private String followed;
        private String follows;
        private int gameNum;
        private String hd_face;
        private int isBlackList;
        private String level;
        private List<String> medal;
        private MyMedalListBean medalList;
        private String nickname;
        private String notename;
        private List<PhotoWallBean> photoWall;
        private String postCollectNum;
        private String posts;
        private String postsNum;
        private String qq;
        private int replyMeNum;
        private String replyNum;
        private String rtkUid;
        private String sex;
        private String signature;
        private int status;
        private String uid;
        private String upCollectNum;
        private String upNum;
        private List<PostTitleBean> user_title;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class PhotoWallBean implements Serializable {
            private String edittime;
            private String id;
            private String pic;
            private String showed;
            private String thumPic;
            private String type;
            private String uid;

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

        public int getAge() {
            return this.age;
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

        public String getFollowed() {
            return this.followed;
        }

        public String getFollows() {
            return this.follows;
        }

        public int getGameNum() {
            return this.gameNum;
        }

        public String getHd_face() {
            return this.hd_face;
        }

        public int getIsBlackList() {
            return this.isBlackList;
        }

        public String getLevel() {
            return this.level;
        }

        public List<String> getMedal() {
            return this.medal;
        }

        public MyMedalListBean getMedalList() {
            return this.medalList;
        }

        public String getNickname() {
            return this.nickname;
        }

        public String getNotename() {
            return this.notename;
        }

        public List<PhotoWallBean> getPhotoWall() {
            return this.photoWall;
        }

        public String getPostCollectNum() {
            return this.postCollectNum;
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

        public int getStatus() {
            return this.status;
        }

        public String getUid() {
            return this.uid;
        }

        public String getUpCollectNum() {
            return this.upCollectNum;
        }

        public String getUpNum() {
            return this.upNum;
        }

        public List<PostTitleBean> getUser_title() {
            return this.user_title;
        }

        public void setAge(int i) {
            this.age = i;
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

        public void setFollowed(String str) {
            this.followed = str;
        }

        public void setFollows(String str) {
            this.follows = str;
        }

        public void setGameNum(int i) {
            this.gameNum = i;
        }

        public void setHd_face(String str) {
            this.hd_face = str;
        }

        public void setIsBlackList(int i) {
            this.isBlackList = i;
        }

        public void setLevel(String str) {
            this.level = str;
        }

        public void setMedal(List<String> list) {
            this.medal = list;
        }

        public void setMedalList(MyMedalListBean myMedalListBean) {
            this.medalList = myMedalListBean;
        }

        public void setNickname(String str) {
            this.nickname = str;
        }

        public void setNotename(String str) {
            this.notename = str;
        }

        public void setPhotoWall(List<PhotoWallBean> list) {
            this.photoWall = list;
        }

        public void setPostCollectNum(String str) {
            this.postCollectNum = str;
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

        public void setStatus(int i) {
            this.status = i;
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
