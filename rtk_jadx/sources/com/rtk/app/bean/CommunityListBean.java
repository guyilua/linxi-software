package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CommunityListBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private BaseInfoBean baseInfo;
        private List<TopBean> top;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class BaseInfoBean {
            private String closed;
            private String description;
            private String edittime;
            private String focused;
            private String forceNum;
            private String id;
            private String introduction;
            private String logo;
            private String mid;
            private int moduleAdmin;
            private String name;
            private String postsNum;
            private String roles;
            private String sequence;
            private int sign;
            private List<TagsBean> tagsList;
            private String type;

            /* loaded from: /tmp/rtk_apk/classes3.dex */
            public static class ModeratorBean {
                private String coin;
                private String contribute;
                private String experience;
                private String face;
                private String fans;
                private String follows;
                private String id;
                private List<String> medal;
                private String nickname;
                private String posts;

                public String getCoin() {
                    return this.coin;
                }

                public String getContribute() {
                    return this.contribute;
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

                public String getFollows() {
                    return this.follows;
                }

                public String getId() {
                    return this.id;
                }

                public List<String> getMedal() {
                    return this.medal;
                }

                public String getNickname() {
                    return this.nickname;
                }

                public String getPosts() {
                    return this.posts;
                }

                public void setCoin(String str) {
                    this.coin = str;
                }

                public void setContribute(String str) {
                    this.contribute = str;
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

                public void setFollows(String str) {
                    this.follows = str;
                }

                public void setId(String str) {
                    this.id = str;
                }

                public void setMedal(List<String> list) {
                    this.medal = list;
                }

                public void setNickname(String str) {
                    this.nickname = str;
                }

                public void setPosts(String str) {
                    this.posts = str;
                }
            }

            public String getClosed() {
                return this.closed;
            }

            public String getDescription() {
                return this.description;
            }

            public String getEdittime() {
                return this.edittime;
            }

            public String getFocused() {
                return this.focused;
            }

            public String getForceNum() {
                return this.forceNum;
            }

            public String getId() {
                return this.id;
            }

            public String getIntroduction() {
                return this.introduction;
            }

            public String getLogo() {
                return this.logo;
            }

            public String getMid() {
                return this.mid;
            }

            public int getModuleAdmin() {
                return this.moduleAdmin;
            }

            public String getName() {
                return this.name;
            }

            public String getPostsNum() {
                return this.postsNum;
            }

            public String getRoles() {
                return this.roles;
            }

            public String getSequence() {
                return this.sequence;
            }

            public int getSign() {
                return this.sign;
            }

            public List<TagsBean> getTagsList() {
                return this.tagsList;
            }

            public String getType() {
                return this.type;
            }

            public void setClosed(String str) {
                this.closed = str;
            }

            public void setDescription(String str) {
                this.description = str;
            }

            public void setEdittime(String str) {
                this.edittime = str;
            }

            public void setFocused(String str) {
                this.focused = str;
            }

            public void setForceNum(String str) {
                this.forceNum = str;
            }

            public void setId(String str) {
                this.id = str;
            }

            public void setIntroduction(String str) {
                this.introduction = str;
            }

            public void setLogo(String str) {
                this.logo = str;
            }

            public void setMid(String str) {
                this.mid = str;
            }

            public void setModuleAdmin(int i) {
                this.moduleAdmin = i;
            }

            public void setName(String str) {
                this.name = str;
            }

            public void setPostsNum(String str) {
                this.postsNum = str;
            }

            public void setRoles(String str) {
                this.roles = str;
            }

            public void setSequence(String str) {
                this.sequence = str;
            }

            public void setSign(int i) {
                this.sign = i;
            }

            public void setTagsList(List<TagsBean> list) {
                this.tagsList = list;
            }

            public void setType(String str) {
                this.type = str;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class TopBean {
            private String addtime;
            private String clickNum;
            private String closed;
            private String commentNum;
            private String content;
            private String deviceName;
            private String edittime;
            private String focusNum;
            private String gameIds;
            private String id;
            private String likeNum;
            private String mid;
            private OwnerBean owner;
            private String postIds;
            private List<PostTitleBean> post_title;
            private String rewardNum;
            private String tags;
            private String title;
            private String type;
            private String uid;
            private String upfileIds;

            /* loaded from: /tmp/rtk_apk/classes3.dex */
            public static class OwnerBean {
                private String area;
                private String birthday;
                private String channel_num;
                private String city;
                private String client_id;
                private String close_days;
                private String close_reason;
                private String close_time;
                private String coin;
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
                private String lock_msg;
                private List<String> medal;
                private String mobile;
                private String nickname;
                private String openid;
                private String password;
                private String permission;
                private String posts;
                private String province;
                private String qq;
                private List<RolesBean> roles;
                private String sex;
                private String signature;
                private String status;
                private String uid;
                private String unionid;
                private String webchat;

                /* loaded from: /tmp/rtk_apk/classes3.dex */
                public static class RolesBean {
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

                public String getPosts() {
                    return this.posts;
                }

                public String getProvince() {
                    return this.province;
                }

                public String getQq() {
                    return this.qq;
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

                public String getUid() {
                    return this.uid;
                }

                public String getUnionid() {
                    return this.unionid;
                }

                public String getWebchat() {
                    return this.webchat;
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

                public void setPosts(String str) {
                    this.posts = str;
                }

                public void setProvince(String str) {
                    this.province = str;
                }

                public void setQq(String str) {
                    this.qq = str;
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

            public String getClickNum() {
                return this.clickNum;
            }

            public String getClosed() {
                return this.closed;
            }

            public String getCommentNum() {
                return this.commentNum;
            }

            public String getContent() {
                return this.content;
            }

            public String getDeviceName() {
                return this.deviceName;
            }

            public String getEdittime() {
                return this.edittime;
            }

            public String getFocusNum() {
                return this.focusNum;
            }

            public String getGameIds() {
                return this.gameIds;
            }

            public String getId() {
                return this.id;
            }

            public String getLikeNum() {
                return this.likeNum;
            }

            public String getMid() {
                return this.mid;
            }

            public OwnerBean getOwner() {
                return this.owner;
            }

            public String getPostIds() {
                return this.postIds;
            }

            public List<PostTitleBean> getPost_title() {
                return this.post_title;
            }

            public String getRewardNum() {
                return this.rewardNum;
            }

            public String getTags() {
                return this.tags;
            }

            public String getTitle() {
                return this.title;
            }

            public String getType() {
                return this.type;
            }

            public String getUid() {
                return this.uid;
            }

            public String getUpfileIds() {
                return this.upfileIds;
            }

            public void setAddtime(String str) {
                this.addtime = str;
            }

            public void setClickNum(String str) {
                this.clickNum = str;
            }

            public void setClosed(String str) {
                this.closed = str;
            }

            public void setCommentNum(String str) {
                this.commentNum = str;
            }

            public void setContent(String str) {
                this.content = str;
            }

            public void setDeviceName(String str) {
                this.deviceName = str;
            }

            public void setEdittime(String str) {
                this.edittime = str;
            }

            public void setFocusNum(String str) {
                this.focusNum = str;
            }

            public void setGameIds(String str) {
                this.gameIds = str;
            }

            public void setId(String str) {
                this.id = str;
            }

            public void setLikeNum(String str) {
                this.likeNum = str;
            }

            public void setMid(String str) {
                this.mid = str;
            }

            public void setOwner(OwnerBean ownerBean) {
                this.owner = ownerBean;
            }

            public void setPostIds(String str) {
                this.postIds = str;
            }

            public void setPost_title(List<PostTitleBean> list) {
                this.post_title = list;
            }

            public void setRewardNum(String str) {
                this.rewardNum = str;
            }

            public void setTags(String str) {
                this.tags = str;
            }

            public void setTitle(String str) {
                this.title = str;
            }

            public void setType(String str) {
                this.type = str;
            }

            public void setUid(String str) {
                this.uid = str;
            }

            public void setUpfileIds(String str) {
                this.upfileIds = str;
            }
        }

        public BaseInfoBean getBaseInfo() {
            return this.baseInfo;
        }

        public List<TopBean> getTop() {
            return this.top;
        }

        public void setBaseInfo(BaseInfoBean baseInfoBean) {
            this.baseInfo = baseInfoBean;
        }

        public void setTop(List<TopBean> list) {
            this.top = list;
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
