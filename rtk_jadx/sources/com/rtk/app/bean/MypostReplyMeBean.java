package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MypostReplyMeBean {
    private int code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String addtime;
        private String before;
        private String content;
        private String face;
        private String id;
        private String mid;
        private String moduleName;
        private String nickname;
        private List<?> pic;
        private String postContent;
        private String postId;
        private String postTitle;
        private String reply;
        private int replyType;
        private String root_reply_id;
        private String uid;

        public String getAddtime() {
            return this.addtime;
        }

        public String getBefore() {
            return this.before;
        }

        public String getContent() {
            return this.content;
        }

        public String getFace() {
            return this.face;
        }

        public String getId() {
            return this.id;
        }

        public String getMid() {
            return this.mid;
        }

        public String getModuleName() {
            return this.moduleName;
        }

        public String getNickname() {
            return this.nickname;
        }

        public List<?> getPic() {
            return this.pic;
        }

        public String getPostContent() {
            return this.postContent;
        }

        public String getPostId() {
            return this.postId;
        }

        public String getPostTitle() {
            return this.postTitle;
        }

        public String getReply() {
            return this.reply;
        }

        public int getReplyType() {
            return this.replyType;
        }

        public String getRoot_reply_id() {
            return this.root_reply_id;
        }

        public String getUid() {
            return this.uid;
        }

        public void setAddtime(String str) {
            this.addtime = str;
        }

        public void setBefore(String str) {
            this.before = str;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setFace(String str) {
            this.face = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setMid(String str) {
            this.mid = str;
        }

        public void setModuleName(String str) {
            this.moduleName = str;
        }

        public void setNickname(String str) {
            this.nickname = str;
        }

        public void setPic(List<?> list) {
            this.pic = list;
        }

        public void setPostContent(String str) {
            this.postContent = str;
        }

        public void setPostId(String str) {
            this.postId = str;
        }

        public void setPostTitle(String str) {
            this.postTitle = str;
        }

        public void setReply(String str) {
            this.reply = str;
        }

        public void setReplyType(int i) {
            this.replyType = i;
        }

        public void setRoot_reply_id(String str) {
            this.root_reply_id = str;
        }

        public void setUid(String str) {
            this.uid = str;
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
