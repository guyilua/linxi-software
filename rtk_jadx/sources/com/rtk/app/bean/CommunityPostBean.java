package com.rtk.app.bean;

import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.rtk.app.bean.FamilyInfoBean;
import java.io.Serializable;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CommunityPostBean implements Serializable {
    private int code;
    private List<DataBean> data;
    private String msg;

    @Keep
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean implements Serializable {
        private String addtime;
        private String before;
        private String commentNum;
        private String content;
        private FamilyInfoBean.DataBean family;
        private String focusNum;
        private String levelCommentNum;
        private String likeNum;
        private List<ListPostVideoBean> list_post_video;
        private String mid;
        private String oldContent;
        private OwnerBean owner;
        private List<String> pic;
        private String pid;
        private List<PostTitleBean> post_title;
        private String realClickNum;
        private int state;
        private int state3;
        private String tag;
        private List<TagsBean> tags;
        private String title;
        private String uid;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class OwnerBean implements Serializable {
            private int age;
            private String area;
            private String birthday;
            private String channel_num;
            private String city;
            private String client_id;
            private String close_days;
            private String close_reason;
            private String close_time;
            private String coin;
            private String collectNum;
            private String commentNum;
            private String contribute;
            private String created;
            private String dev_lock;
            private String dev_status;
            private String developer;
            private String device_id;
            private String device_name;
            private String district;
            private String email;
            private String experience;
            private String expire;
            private String face;
            private String face_1;
            private String face_2;
            private String face_3;
            private String fans;
            private String follows;
            private String force_close;
            private String group_id;
            private String id;
            private String last_client;
            private String last_ip;
            private String last_time;
            private String level;
            private String levelicon;
            private String lock_msg;
            private List<String> medal;
            private String mobile;
            private String nickname;
            private String openid;
            private String password;
            private String permission;
            private List<PhotoWallBean> photoWall;
            private String posts;
            private String postsNum;
            private String province;
            private String qq;
            private String replyNum;
            private List<RolesBean> roles;
            private String sex;
            private String signature;
            private String status;
            private String token;
            private String uid;
            private String unionid;
            private String webchat;

            @Keep
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

            /* loaded from: /tmp/rtk_apk/classes3.dex */
            public static class RolesBean implements Serializable {
                private String id;
                private String name;

                public String getId() {
                    return this.id;
                }

                public String getName() {
                    return this.name;
                }

                public void setId(String str) {
                    this.id = str;
                }

                public void setName(String str) {
                    this.name = str;
                }
            }

            public int getAge() {
                return this.age;
            }

            public String getArea() {
                return this.area;
            }

            public String getBirthday() {
                return this.birthday;
            }

            public String getChannel_num() {
                return this.channel_num;
            }

            public String getCity() {
                return this.city;
            }

            public String getClient_id() {
                return this.client_id;
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

            public String getCreated() {
                return this.created;
            }

            public String getDev_lock() {
                return this.dev_lock;
            }

            public String getDev_status() {
                return this.dev_status;
            }

            public String getDeveloper() {
                return this.developer;
            }

            public String getDevice_id() {
                return this.device_id;
            }

            public String getDevice_name() {
                return this.device_name;
            }

            public String getDistrict() {
                return this.district;
            }

            public String getEmail() {
                return this.email;
            }

            public String getExperience() {
                return this.experience;
            }

            public String getExpire() {
                return this.expire;
            }

            public String getFace() {
                return this.face;
            }

            public String getFace_1() {
                return this.face_1;
            }

            public String getFace_2() {
                return this.face_2;
            }

            public String getFace_3() {
                return this.face_3;
            }

            public String getFans() {
                return this.fans;
            }

            public String getFollows() {
                return this.follows;
            }

            public String getForce_close() {
                return this.force_close;
            }

            public String getGroup_id() {
                return this.group_id;
            }

            public String getId() {
                return this.id;
            }

            public String getLast_client() {
                return this.last_client;
            }

            public String getLast_ip() {
                return this.last_ip;
            }

            public String getLast_time() {
                return this.last_time;
            }

            public String getLevel() {
                return this.level;
            }

            public String getLevelicon() {
                return this.levelicon;
            }

            public String getLock_msg() {
                return this.lock_msg;
            }

            public List<String> getMedal() {
                return this.medal;
            }

            public String getMobile() {
                return this.mobile;
            }

            public String getNickname() {
                return this.nickname;
            }

            public String getOpenid() {
                return this.openid;
            }

            public String getPassword() {
                return this.password;
            }

            public String getPermission() {
                return this.permission;
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

            public String getProvince() {
                return this.province;
            }

            public String getQq() {
                return this.qq;
            }

            public String getReplyNum() {
                return this.replyNum;
            }

            public List<RolesBean> getRoles() {
                return this.roles;
            }

            public String getSex() {
                return this.sex;
            }

            public String getSignature() {
                return this.signature;
            }

            public String getStatus() {
                return this.status;
            }

            public String getToken() {
                return this.token;
            }

            public String getUid() {
                return this.uid;
            }

            public String getUnionid() {
                return this.unionid;
            }

            public String getWebchat() {
                return this.webchat;
            }

            public void setAge(int i) {
                this.age = i;
            }

            public void setArea(String str) {
                this.area = str;
            }

            public void setBirthday(String str) {
                this.birthday = str;
            }

            public void setChannel_num(String str) {
                this.channel_num = str;
            }

            public void setCity(String str) {
                this.city = str;
            }

            public void setClient_id(String str) {
                this.client_id = str;
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

            public void setCreated(String str) {
                this.created = str;
            }

            public void setDev_lock(String str) {
                this.dev_lock = str;
            }

            public void setDev_status(String str) {
                this.dev_status = str;
            }

            public void setDeveloper(String str) {
                this.developer = str;
            }

            public void setDevice_id(String str) {
                this.device_id = str;
            }

            public void setDevice_name(String str) {
                this.device_name = str;
            }

            public void setDistrict(String str) {
                this.district = str;
            }

            public void setEmail(String str) {
                this.email = str;
            }

            public void setExperience(String str) {
                this.experience = str;
            }

            public void setExpire(String str) {
                this.expire = str;
            }

            public void setFace(String str) {
                this.face = str;
            }

            public void setFace_1(String str) {
                this.face_1 = str;
            }

            public void setFace_2(String str) {
                this.face_2 = str;
            }

            public void setFace_3(String str) {
                this.face_3 = str;
            }

            public void setFans(String str) {
                this.fans = str;
            }

            public void setFollows(String str) {
                this.follows = str;
            }

            public void setForce_close(String str) {
                this.force_close = str;
            }

            public void setGroup_id(String str) {
                this.group_id = str;
            }

            public void setId(String str) {
                this.id = str;
            }

            public void setLast_client(String str) {
                this.last_client = str;
            }

            public void setLast_ip(String str) {
                this.last_ip = str;
            }

            public void setLast_time(String str) {
                this.last_time = str;
            }

            public void setLevel(String str) {
                this.level = str;
            }

            public void setLevelicon(String str) {
                this.levelicon = str;
            }

            public void setLock_msg(String str) {
                this.lock_msg = str;
            }

            public void setMedal(List<String> list) {
                this.medal = list;
            }

            public void setMobile(String str) {
                this.mobile = str;
            }

            public void setNickname(String str) {
                this.nickname = str;
            }

            public void setOpenid(String str) {
                this.openid = str;
            }

            public void setPassword(String str) {
                this.password = str;
            }

            public void setPermission(String str) {
                this.permission = str;
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

            public void setProvince(String str) {
                this.province = str;
            }

            public void setQq(String str) {
                this.qq = str;
            }

            public void setReplyNum(String str) {
                this.replyNum = str;
            }

            public void setRoles(List<RolesBean> list) {
                this.roles = list;
            }

            public void setSex(String str) {
                this.sex = str;
            }

            public void setSignature(String str) {
                this.signature = str;
            }

            public void setStatus(String str) {
                this.status = str;
            }

            public void setToken(String str) {
                this.token = str;
            }

            public void setUid(String str) {
                this.uid = str;
            }

            public void setUnionid(String str) {
                this.unionid = str;
            }

            public void setWebchat(String str) {
                this.webchat = str;
            }
        }

        public String getAddtime() {
            return this.addtime;
        }

        public String getBefore() {
            return this.before;
        }

        public String getClickNum() {
            return this.realClickNum;
        }

        public String getCommentNum() {
            return this.commentNum;
        }

        public String getContent() {
            return this.content;
        }

        public FamilyInfoBean.DataBean getFamily() {
            return this.family;
        }

        public String getFocusNum() {
            return this.focusNum;
        }

        public String getLevelCommentNum() {
            return this.levelCommentNum;
        }

        public String getLikeNum() {
            return this.likeNum;
        }

        public List<ListPostVideoBean> getList_post_video() {
            return this.list_post_video;
        }

        public String getMid() {
            return this.mid;
        }

        public String getOldContent() {
            return this.oldContent;
        }

        public OwnerBean getOwner() {
            return this.owner;
        }

        public List<String> getPic() {
            return this.pic;
        }

        public String getPid() {
            return this.pid;
        }

        public List<PostTitleBean> getPost_title() {
            return this.post_title;
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

        public boolean isFamilyPost() {
            FamilyInfoBean.DataBean dataBean = this.family;
            return (dataBean == null || TextUtils.isEmpty(dataBean.getFamily_id()) || TextUtils.equals("0", this.family.getFamily_id())) ? false : true;
        }

        public void setAddtime(String str) {
            this.addtime = str;
        }

        public void setBefore(String str) {
            this.before = str;
        }

        public void setClickNum(String str) {
            this.realClickNum = str;
        }

        public void setCommentNum(String str) {
            this.commentNum = str;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setFocusNum(String str) {
            this.focusNum = str;
        }

        public void setLevelCommentNum(String str) {
            this.levelCommentNum = str;
        }

        public void setLikeNum(String str) {
            this.likeNum = str;
        }

        public void setList_post_video(List<ListPostVideoBean> list) {
            this.list_post_video = list;
        }

        public void setMid(String str) {
            this.mid = str;
        }

        public void setOldContent(String str) {
            this.oldContent = str;
        }

        public void setOwner(OwnerBean ownerBean) {
            this.owner = ownerBean;
        }

        public void setPic(List<String> list) {
            this.pic = list;
        }

        public void setPid(String str) {
            this.pid = str;
        }

        public void setPost_title(List<PostTitleBean> list) {
            this.post_title = list;
        }

        public void setState(int i) {
            this.state = i;
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

        @NonNull
        public String toString() {
            return "[post=" + getPid() + "]" + getTitle() + "[/post]";
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
