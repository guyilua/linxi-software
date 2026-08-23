package com.rtk.app.bean;

import com.rtk.app.tool.c0;
import java.io.Serializable;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpApkDetailsBean implements Serializable {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean implements Serializable {
        private String addtime;
        private String apkmd5;
        private String coinNum;
        private int collected;
        private String commentNum;
        private String dataPath;
        private String dataSize;
        private String deviceName;
        private String downNum;
        private String down_close;
        private String edittime;
        private String face;
        private FamilyBean family;
        private int followed;
        private int id;
        private InstallationBean installation;
        private String ipAddress;
        private int isBuy;
        private String isshow;
        private int isshow2;
        private String lang;
        private String listType;
        private String md5;
        private String msg;
        private String msg2;
        private String msg3;
        private int needCoin;
        private String nickname;
        private String notename;
        private String otherVersion;
        private String packageName;
        private List<RewardListBean> rewardList;
        private String rewardNum;
        private String reward_close;
        private String sdkVersion;
        private String sha1;
        private String sha256;
        private String showmsg;
        private String showmsg2;
        private String sourceCharacteristic;
        private String sourceDescription;
        private String sourceLang;
        private String sourceLogo;
        private String sourceName;
        private String sourcePath;
        private List<String> sourcePic;
        private String sourceSize;
        private List<?> sourceThumb;
        private String sourceVersion;
        private String status;
        private int status2;
        private int status3;
        private String statusName;
        private String tags;
        private String tagsName;
        private String targetVersion;
        private String type;
        private String typeName;
        private String uid;
        private List<UpDataPathListBean> upDataPathList;
        private List<UpSourcePathListBean> upSourcePathList;
        private String varName;
        private int versionCode;
        private String versionName;
        private String viewPermissions;
        private String zipmd5;

        public String getAddtime() {
            return this.addtime;
        }

        public String getApkmd5() {
            return this.apkmd5;
        }

        public String getCoinNum() {
            return this.coinNum;
        }

        public int getCollected() {
            return this.collected;
        }

        public String getCommentNum() {
            return this.commentNum;
        }

        public String getDataPath() {
            return this.dataPath;
        }

        public String getDataSize() {
            return this.dataSize;
        }

        public String getDeviceName() {
            return this.deviceName;
        }

        public String getDownNum() {
            return this.downNum;
        }

        public String getDown_close() {
            return this.down_close;
        }

        public String getEdittime() {
            return this.edittime;
        }

        public String getFace() {
            return this.face;
        }

        public FamilyBean getFamily() {
            return this.family;
        }

        public int getFollowed() {
            return this.followed;
        }

        public int getId() {
            return this.id;
        }

        public InstallationBean getInstallation() {
            return this.installation;
        }

        public String getIpAddress() {
            return this.ipAddress;
        }

        public int getIsBuy() {
            return this.isBuy;
        }

        public String getIsshow() {
            return this.isshow;
        }

        public int getIsshow2() {
            return this.isshow2;
        }

        public String getLang() {
            return this.lang;
        }

        public String getListType() {
            return this.listType;
        }

        public String getMd5() {
            return this.md5;
        }

        public String getMsg() {
            return this.msg;
        }

        public String getMsg2() {
            return this.msg2;
        }

        public String getMsg3() {
            return this.msg3;
        }

        public int getNeedCoin() {
            return this.needCoin;
        }

        public String getNickname() {
            return this.nickname;
        }

        public String getNotename() {
            return this.notename;
        }

        public String getOtherVersion() {
            return this.otherVersion;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public List<RewardListBean> getRewardList() {
            return this.rewardList;
        }

        public String getRewardNum() {
            return this.rewardNum;
        }

        public String getReward_close() {
            return this.reward_close;
        }

        public String getSdkVersion() {
            return this.sdkVersion;
        }

        public String getSha1() {
            return this.sha1;
        }

        public String getSha256() {
            return this.sha256;
        }

        public String getShowmsg() {
            return this.showmsg;
        }

        public String getShowmsg2() {
            return this.showmsg2;
        }

        public String getSourceCharacteristic() {
            return this.sourceCharacteristic;
        }

        public String getSourceDescription() {
            return this.sourceDescription;
        }

        public String getSourceLang() {
            return this.sourceLang;
        }

        public String getSourceLogo() {
            return this.sourceLogo;
        }

        public String getSourceName() {
            return this.sourceName;
        }

        public String getSourcePath() {
            return this.sourcePath;
        }

        public List<String> getSourcePic() {
            return this.sourcePic;
        }

        public String getSourceSize() {
            return this.sourceSize;
        }

        public List<?> getSourceThumb() {
            return this.sourceThumb;
        }

        public String getSourceVersion() {
            return this.sourceVersion;
        }

        public String getStatus() {
            return this.status;
        }

        public int getStatus2() {
            return this.status2;
        }

        public int getStatus3() {
            return this.status3;
        }

        public String getStatusName() {
            return this.statusName;
        }

        public String getTags() {
            return this.tags;
        }

        public String getTagsName() {
            return this.tagsName;
        }

        public String getTargetVersion() {
            return this.targetVersion;
        }

        public String getType() {
            return this.type;
        }

        public String getTypeName() {
            return this.typeName;
        }

        public int getUid() {
            try {
                return Integer.parseInt(this.uid);
            } catch (Exception unused) {
                return 0;
            }
        }

        public List<UpDataPathListBean> getUpDataPathList() {
            return this.upDataPathList;
        }

        public List<UpSourcePathListBean> getUpSourcePathList() {
            return this.upSourcePathList;
        }

        public String getVarName() {
            return this.varName;
        }

        public int getVersionCode() {
            return this.versionCode;
        }

        public String getVersionName() {
            return this.versionName;
        }

        public String getViewPermissions() {
            return this.viewPermissions;
        }

        public String getZipmd5() {
            return this.zipmd5;
        }

        public boolean isBuy() {
            return this.isBuy == 1;
        }

        public boolean isZip() {
            return (getUpDataPathList() == null || getUpDataPathList().size() <= 0 || c0.q(getUpDataPathList().get(0).getUrl())) ? false : true;
        }

        public void setAddtime(String str) {
            this.addtime = str;
        }

        public void setApkmd5(String str) {
            this.apkmd5 = str;
        }

        public void setCoinNum(String str) {
            this.coinNum = str;
        }

        public void setCollected(int i) {
            this.collected = i;
        }

        public void setCommentNum(String str) {
            this.commentNum = str;
        }

        public void setDataPath(String str) {
            this.dataPath = str;
        }

        public void setDataSize(String str) {
            this.dataSize = str;
        }

        public void setDeviceName(String str) {
            this.deviceName = str;
        }

        public void setDownNum(String str) {
            this.downNum = str;
        }

        public void setDown_close(String str) {
            this.down_close = str;
        }

        public void setEdittime(String str) {
            this.edittime = str;
        }

        public void setFace(String str) {
            this.face = str;
        }

        public void setFamily(FamilyBean familyBean) {
            this.family = familyBean;
        }

        public void setFollowed(int i) {
            this.followed = i;
        }

        public void setId(int i) {
            this.id = i;
        }

        public void setInstallation(InstallationBean installationBean) {
            this.installation = installationBean;
        }

        public void setIpAddress(String str) {
            this.ipAddress = str;
        }

        public void setIsBuy(int i) {
            this.isBuy = i;
        }

        public void setIsshow(String str) {
            this.isshow = str;
        }

        public void setIsshow2(int i) {
            this.isshow2 = i;
        }

        public void setLang(String str) {
            this.lang = str;
        }

        public void setListType(String str) {
            this.listType = str;
        }

        public void setMd5(String str) {
            this.md5 = str;
        }

        public void setMsg(String str) {
            this.msg = str;
        }

        public void setMsg2(String str) {
            this.msg2 = str;
        }

        public void setMsg3(String str) {
            this.msg3 = str;
        }

        public void setNeedCoin(int i) {
            this.needCoin = i;
        }

        public void setNickname(String str) {
            this.nickname = str;
        }

        public void setNotename(String str) {
            this.notename = str;
        }

        public void setOtherVersion(String str) {
            this.otherVersion = str;
        }

        public void setPackageName(String str) {
            this.packageName = str;
        }

        public void setRewardList(List<RewardListBean> list) {
            this.rewardList = list;
        }

        public void setRewardNum(String str) {
            this.rewardNum = str;
        }

        public void setReward_close(String str) {
            this.reward_close = str;
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

        public void setShowmsg(String str) {
            this.showmsg = str;
        }

        public void setShowmsg2(String str) {
            this.showmsg2 = str;
        }

        public void setSourceCharacteristic(String str) {
            this.sourceCharacteristic = str;
        }

        public void setSourceDescription(String str) {
            this.sourceDescription = str;
        }

        public void setSourceLang(String str) {
            this.sourceLang = str;
        }

        public void setSourceLogo(String str) {
            this.sourceLogo = str;
        }

        public void setSourceName(String str) {
            this.sourceName = str;
        }

        public void setSourcePath(String str) {
            this.sourcePath = str;
        }

        public void setSourcePic(List<String> list) {
            this.sourcePic = list;
        }

        public void setSourceSize(String str) {
            this.sourceSize = str;
        }

        public void setSourceThumb(List<?> list) {
            this.sourceThumb = list;
        }

        public void setSourceVersion(String str) {
            this.sourceVersion = str;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public void setStatus2(int i) {
            this.status2 = i;
        }

        public void setStatus3(int i) {
            this.status3 = i;
        }

        public void setStatusName(String str) {
            this.statusName = str;
        }

        public void setTags(String str) {
            this.tags = str;
        }

        public void setTagsName(String str) {
            this.tagsName = str;
        }

        public void setTargetVersion(String str) {
            this.targetVersion = str;
        }

        public void setType(String str) {
            this.type = str;
        }

        public void setTypeName(String str) {
            this.typeName = str;
        }

        public void setUid(String str) {
            this.uid = str;
        }

        public void setUpDataPathList(List<UpDataPathListBean> list) {
            this.upDataPathList = list;
        }

        public void setUpSourcePathList(List<UpSourcePathListBean> list) {
            this.upSourcePathList = list;
        }

        public void setVarName(String str) {
            this.varName = str;
        }

        public void setVersionCode(int i) {
            this.versionCode = i;
        }

        public void setVersionName(String str) {
            this.versionName = str;
        }

        public void setViewPermissions(String str) {
            this.viewPermissions = str;
        }

        public void setZipmd5(String str) {
            this.zipmd5 = str;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class RewardListBean implements Serializable {
        private String coin;
        private String face;
        private String uid;

        public String getCoin() {
            return this.coin;
        }

        public String getFace() {
            return this.face;
        }

        public String getUid() {
            return this.uid;
        }

        public void setCoin(String str) {
            this.coin = str;
        }

        public void setFace(String str) {
            this.face = str;
        }

        public void setUid(String str) {
            this.uid = str;
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
