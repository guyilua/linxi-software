package com.rtk.app.bean;

import android.text.TextUtils;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AdminBean {
    private int admin;
    private int bbsAdmin;
    private int commentadmin;
    private String familyBBSAmin;
    private String familyLead;
    private String familySecondLead;
    private String familyUPAmin;
    private int upAdmin;
    private int upAgainAdmin;
    private int userAdmin;
    private int userFaceAdmin;
    private int userNicknameAdmin;
    private int userPhotoAdmin;
    private int userSignatureAdmin;

    public boolean familyLeader(String str) {
        return str.equals(this.familyLead);
    }

    public boolean familySecondLeader(String str) {
        return str.equals(this.familySecondLead);
    }

    public int getAdmin() {
        return this.admin;
    }

    public int getBbsAdmin() {
        return this.bbsAdmin;
    }

    public int getCommentadmin() {
        return this.commentadmin;
    }

    public String getFamilyBBSAmin() {
        return this.familyBBSAmin;
    }

    public String getFamilyLead() {
        return this.familyLead;
    }

    public String getFamilySecondLead() {
        return this.familySecondLead;
    }

    public String getFamilyUPAmin() {
        return this.familyUPAmin;
    }

    public int getUpAdmin() {
        return this.upAdmin;
    }

    public int getUpAgainAdmin() {
        return this.upAgainAdmin;
    }

    public int getUserAdmin() {
        return this.userAdmin;
    }

    public int getUserFaceAdmin() {
        return this.userFaceAdmin;
    }

    public int getUserNicknameAdmin() {
        return this.userNicknameAdmin;
    }

    public int getUserPhotoAdmin() {
        return this.userPhotoAdmin;
    }

    public int getUserSignatureAdmin() {
        return this.userSignatureAdmin;
    }

    public boolean hasFamilyBBSAdmin(String str) {
        return str.equals(this.familyLead) || str.equals(this.familySecondLead) || str.equals(this.familyBBSAmin);
    }

    public boolean hasFamilyUpAdmin(String str) {
        return str.equals(this.familyLead) || str.equals(this.familySecondLead) || str.equals(this.familyUPAmin);
    }

    public boolean hasSomeFamilyUpAdmin() {
        return (TextUtils.isEmpty(this.familyLead) && TextUtils.isEmpty(this.familySecondLead) && TextUtils.isEmpty(this.familyUPAmin)) ? false : true;
    }

    public void setAdmin(int i) {
        this.admin = i;
    }

    public void setBbsAdmin(int i) {
        this.bbsAdmin = i;
    }

    public void setCommentadmin(int i) {
        this.commentadmin = i;
    }

    public void setFamilyBBSAmin(String str) {
        this.familyBBSAmin = str;
    }

    public void setFamilyLead(String str) {
        this.familyLead = str;
    }

    public void setFamilySecondLead(String str) {
        this.familySecondLead = str;
    }

    public void setFamilyUPAmin(String str) {
        this.familyUPAmin = str;
    }

    public void setUpAdmin(int i) {
        this.upAdmin = i;
    }

    public void setUpAgainAdmin(int i) {
        this.upAgainAdmin = i;
    }

    public void setUserAdmin(int i) {
        this.userAdmin = i;
    }

    public void setUserFaceAdmin(int i) {
        this.userFaceAdmin = i;
    }

    public void setUserNicknameAdmin(int i) {
        this.userNicknameAdmin = i;
    }

    public void setUserPhotoAdmin(int i) {
        this.userPhotoAdmin = i;
    }

    public void setUserSignatureAdmin(int i) {
        this.userSignatureAdmin = i;
    }
}
