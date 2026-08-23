package com.rtk.app.bean;

import com.rtk.app.tool.c0;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AuthorityBean {
    private int commentLevel;
    private int imageLevel;
    private String noZipAuthorityShow;
    private int postLevel;
    private int publishPost;
    private int replyLevel;
    private int upLevel;
    private int uploadVideo;
    private int videoDuration;
    private int videoZoneUpload;
    private int zipAuthority;

    public int getCommentLevel() {
        return this.commentLevel;
    }

    public int getImageLevel() {
        return this.imageLevel;
    }

    public String getNoZipAuthorityShow() {
        return c0.q(this.noZipAuthorityShow) ? "等级不足，没有发布权限" : this.noZipAuthorityShow;
    }

    public int getPostLevel() {
        return this.postLevel;
    }

    public int getPublishPost() {
        return this.publishPost;
    }

    public int getReplyLevel() {
        return this.replyLevel;
    }

    public int getUpLevel() {
        return this.upLevel;
    }

    public int getUploadVideo() {
        return this.uploadVideo;
    }

    public int getVideoDuration() {
        return this.videoDuration;
    }

    public int getVideoZoneUpload() {
        return this.videoZoneUpload;
    }

    public int getZipAuthority() {
        int i = this.zipAuthority;
        if (i == 0 || i > 2) {
            return 0;
        }
        return i;
    }

    public void setCommentLevel(int i) {
        this.commentLevel = i;
    }

    public void setImageLevel(int i) {
        this.imageLevel = i;
    }

    public void setNoZipAuthorityShow(String str) {
        this.noZipAuthorityShow = str;
    }

    public void setPostLevel(int i) {
        this.postLevel = i;
    }

    public void setPublishPost(int i) {
        this.publishPost = i;
    }

    public void setReplyLevel(int i) {
        this.replyLevel = i;
    }

    public void setUpLevel(int i) {
        this.upLevel = i;
    }

    public void setUploadVideo(int i) {
        this.uploadVideo = i;
    }

    public void setVideoDuration(int i) {
        this.videoDuration = i;
    }

    public void setVideoZoneUpload(int i) {
        this.videoZoneUpload = i;
    }

    public void setZipAuthority(int i) {
        this.zipAuthority = i;
    }
}
