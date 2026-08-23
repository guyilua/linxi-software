package com.rtk.app.bean;

import java.io.Serializable;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeCommunityBean implements Serializable {
    private int code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean implements Serializable {
        private String closed;
        private String description;
        private String edittime;
        private String forceNum;
        private String id;
        private String logo;
        private String moderator;
        private String name;
        private String postsNum;
        private List<?> roles;
        private String sequence;
        private String showed;
        private List<TagsBean> tags;
        private String type;

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

        public String getLogo() {
            return this.logo;
        }

        public String getModerator() {
            return this.moderator;
        }

        public String getName() {
            return this.name;
        }

        public String getPostsNum() {
            return this.postsNum;
        }

        public List<?> getRoles() {
            return this.roles;
        }

        public String getSequence() {
            return this.sequence;
        }

        public String getShowed() {
            return this.showed;
        }

        public List<TagsBean> getTags() {
            return this.tags;
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

        public void setForceNum(String str) {
            this.forceNum = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setLogo(String str) {
            this.logo = str;
        }

        public void setModerator(String str) {
            this.moderator = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPostsNum(String str) {
            this.postsNum = str;
        }

        public void setRoles(List<?> list) {
            this.roles = list;
        }

        public void setSequence(String str) {
            this.sequence = str;
        }

        public void setShowed(String str) {
            this.showed = str;
        }

        public void setTags(List<TagsBean> list) {
            this.tags = list;
        }

        public void setType(String str) {
            this.type = str;
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
