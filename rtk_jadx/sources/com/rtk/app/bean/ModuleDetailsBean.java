package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ModuleDetailsBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String closed;
        private String description;
        private String edittime;
        private String forceNum;
        private String id;
        private String introduction;
        private String logo;
        private String mid;
        private List<String> moderator;
        private List<ModeratorListBean> moderatorList;
        private String name;
        private String postsNum;
        private String roles;
        private String sequence;
        private List<TagsBean> tags;
        private List<TypeBean> type;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class ModeratorListBean {
            private String face;
            private String nickname;
            private String uid;

            public String getFace() {
                return this.face;
            }

            public String getNickname() {
                return this.nickname;
            }

            public String getUid() {
                return this.uid;
            }

            public void setFace(String str) {
                this.face = str;
            }

            public void setNickname(String str) {
                this.nickname = str;
            }

            public void setUid(String str) {
                this.uid = str;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class TypeBean {
            private String id;

            public String getId() {
                return this.id;
            }

            public void setId(String str) {
                this.id = str;
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

        public List<String> getModerator() {
            return this.moderator;
        }

        public List<ModeratorListBean> getModeratorList() {
            return this.moderatorList;
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

        public List<TagsBean> getTags() {
            return this.tags;
        }

        public List<TypeBean> getType() {
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

        public void setModerator(List<String> list) {
            this.moderator = list;
        }

        public void setModeratorList(List<ModeratorListBean> list) {
            this.moderatorList = list;
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

        public void setTags(List<TagsBean> list) {
            this.tags = list;
        }

        public void setType(List<TypeBean> list) {
            this.type = list;
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
