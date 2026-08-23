package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpApkBean {
    private String apkJsonData;
    private String apkKey;
    private int apkSecTrans;
    private int apkType;
    private String apkmd5;
    private int code;
    private String md5;
    private String otherVersion;
    private String packageName;
    private String permission;
    private String sdkVersion;
    private String sha1;
    private String sha256;
    private String sourceLogo;
    private String sourcePath;
    private double sourceSize;
    private String targetVersion;
    private String versionCode;
    private String versionName;
    private String zipKey;
    private int zipSecTrans;
    private int zipType;

    public UpApkBean(String str) {
        this.sha256 = "";
        this.sha1 = "";
        this.md5 = "";
        this.apkmd5 = "";
        this.sourceLogo = "";
        this.permission = "";
        this.targetVersion = "";
        this.sdkVersion = "";
        this.versionName = "";
        this.versionCode = "";
        this.otherVersion = "";
        this.packageName = "";
        this.sourcePath = "";
        this.apkKey = "";
        this.zipKey = "";
        this.packageName = str;
    }

    public String getApkKey() {
        return this.apkKey;
    }

    public int getApkSecTrans() {
        return this.apkSecTrans;
    }

    public int getApkType() {
        return this.apkType;
    }

    public String getApkmd5() {
        return this.apkmd5;
    }

    public int getCode() {
        return this.code;
    }

    public String getJsonData() {
        return this.apkJsonData;
    }

    public String getMd5() {
        String str = this.md5;
        return str == null ? "" : str;
    }

    public String getOtherVersion() {
        String str = this.otherVersion;
        return str == null ? "" : str;
    }

    public String getPackageName() {
        String str = this.packageName;
        return str == null ? "null" : str;
    }

    public String getPermission() {
        String str = this.permission;
        return str == null ? "" : str;
    }

    public String getSdkVersion() {
        String str = this.sdkVersion;
        return str == null ? "" : str;
    }

    public String getSha1() {
        String str = this.sha1;
        return str == null ? "" : str;
    }

    public String getSha256() {
        String str = this.sha256;
        return str == null ? "" : str;
    }

    public String getSourceLogo() {
        String str = this.sourceLogo;
        return str == null ? "" : str;
    }

    public String getSourcePath() {
        String str = this.sourcePath;
        return str == null ? "" : str;
    }

    public double getSourceSize() {
        return this.sourceSize;
    }

    public String getTargetVersion() {
        String str = this.targetVersion;
        return str == null ? "" : str;
    }

    public String getVersionCode() {
        String str = this.versionCode;
        return str == null ? "" : str;
    }

    public String getVersionName() {
        String str = this.versionName;
        return str == null ? "" : str;
    }

    public String getZipKey() {
        return this.zipKey;
    }

    public int getZipSecTrans() {
        return this.zipSecTrans;
    }

    public int getZipType() {
        return this.zipType;
    }

    public void setApkKey(String str) {
        this.apkKey = str;
    }

    public void setApkSecTrans(int i) {
        this.apkSecTrans = i;
    }

    public void setApkType(int i) {
        this.apkType = i;
    }

    public void setApkmd5(String str) {
        this.apkmd5 = str;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setJsonData(String str) {
        this.apkJsonData = str;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setOtherVersion(String str) {
        this.otherVersion = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPermission(String str) {
        this.permission = str;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public void setSha1(String str) {
        this.sha1 = str;
    }

    public void setSha256(String str) {
        this.sha256 = str;
    }

    public void setSourceLogo(String str) {
        this.sourceLogo = str;
    }

    public void setSourcePath(String str) {
        this.sourcePath = str;
    }

    public void setSourceSize(double d) {
        this.sourceSize = d;
    }

    public void setTargetVersion(String str) {
        this.targetVersion = str;
    }

    public void setVersionCode(String str) {
        this.versionCode = str;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    public void setZipKey(String str) {
        this.zipKey = str;
    }

    public void setZipSecTrans(int i) {
        this.zipSecTrans = i;
    }

    public void setZipType(int i) {
        this.zipType = i;
    }

    public UpApkBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, double d, String str12, String str13, int i, String str14, int i2, int i3, String str15, int i4, String str16) {
        this.sha256 = "";
        this.sha1 = "";
        this.md5 = "";
        this.apkmd5 = "";
        this.sourceLogo = "";
        this.permission = "";
        this.targetVersion = "";
        this.sdkVersion = "";
        this.versionName = "";
        this.versionCode = "";
        this.otherVersion = "";
        this.packageName = "";
        this.sourcePath = "";
        this.apkKey = "";
        this.zipKey = "";
        this.sha256 = str2;
        this.sha1 = str3;
        this.md5 = str12;
        this.sourceSize = d;
        this.sourceLogo = str;
        this.permission = str4;
        this.targetVersion = str5;
        this.sdkVersion = str6;
        this.versionName = str10;
        this.versionCode = str7;
        this.otherVersion = str8;
        this.packageName = str9;
        this.sourcePath = str11;
        this.apkmd5 = str13;
        this.apkType = i;
        this.apkKey = str14;
        this.apkSecTrans = i2;
        this.zipType = i3;
        this.zipKey = str15;
        this.zipSecTrans = i4;
        this.apkJsonData = str16;
    }
}
