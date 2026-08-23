package com.rtk.app.bean;

import com.rtk.app.tool.c0;
import java.io.Serializable;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpApkListBean implements Serializable {
    private int code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean implements Serializable {
        private String addtime;
        private String clickNum;
        private String coinNum;
        private String dataPath;
        private String dataSize;
        private String downNum;
        private String face;
        private FamilyBean family;
        private int id;
        private InstallationBean installation;
        private String isshow;
        private String isshow3;
        private String md5;
        private String msg;
        private int needCoin;
        private String nickname;
        private String notename;
        private String packageName;
        private String showmsg;
        private String showmsg3;
        private String sourceLogo;
        private String sourceName;
        private String sourceSize;
        private String status;
        private String status3;
        private String todayClickNum;
        private int todayDown;
        private String uid;
        private List<UpDataPathListBean> upDataPathList;
        private List<UpSourcePathListBean> upSourcePathList;
        private String varName;
        private int versionCode;
        private String versionName;
        private String viewPermissions;

        public String getAddtime() {
            return this.addtime;
        }

        public String getClickNum() {
            return this.clickNum;
        }

        public String getCoinNum() {
            return this.coinNum;
        }

        public String getDataPath() {
            return this.dataPath;
        }

        public String getDataSize() {
            return this.dataSize;
        }

        public String getDownNum() {
            return this.downNum;
        }

        public String getFace() {
            return this.face;
        }

        public FamilyBean getFamily() {
            return this.family;
        }

        public int getId() {
            return this.id;
        }

        public InstallationBean getInstallation() {
            return this.installation;
        }

        public String getIsshow() {
            return this.isshow;
        }

        public String getIsshow3() {
            return this.isshow3;
        }

        public String getMd5() {
            return this.md5;
        }

        public String getMsg() {
            return this.msg;
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

        public String getPackageName() {
            return this.packageName;
        }

        public String getShowmsg() {
            return this.showmsg;
        }

        public String getShowmsg3() {
            return this.showmsg3;
        }

        public String getSourceLogo() {
            return c0.q(this.sourceLogo) ? "" : this.sourceLogo;
        }

        public String getSourceName() {
            return this.sourceName;
        }

        public String getSourceSize() {
            return this.sourceSize;
        }

        public String getStatus() {
            return c0.q(this.status) ? "1" : this.status;
        }

        public String getStatus3() {
            return c0.q(this.status3) ? "1" : this.status3;
        }

        public String getTodayClickNum() {
            return this.todayClickNum;
        }

        public int getTodayDown() {
            return this.todayDown;
        }

        public String getUid() {
            return this.uid;
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

        public int getViewPermissions() {
            try {
                return Integer.parseInt(this.viewPermissions);
            } catch (Exception unused) {
                return 0;
            }
        }

        public boolean isFamily() {
            FamilyBean familyBean = this.family;
            return (familyBean == null || familyBean.getFamily_id() == 0) ? false : true;
        }

        public boolean isZip() {
            return (getUpDataPathList() == null || getUpDataPathList().isEmpty() || c0.q(getUpDataPathList().get(0).getUrl())) ? false : true;
        }

        public void setAddtime(String str) {
            this.addtime = str;
        }

        public void setFace(String str) {
            this.face = str;
        }

        public void setFamily(FamilyBean familyBean) {
            this.family = familyBean;
        }

        public void setId(int i) {
            this.id = i;
        }

        public void setInstallation(InstallationBean installationBean) {
            this.installation = installationBean;
        }

        public void setMd5(String str) {
            this.md5 = str;
        }

        public void setMsg(String str) {
            this.msg = str;
        }

        public void setNeedCoin(int i) {
            this.needCoin = i;
        }

        public void setNickname(String str) {
            this.nickname = str;
        }

        public void setPackageName(String str) {
            this.packageName = str;
        }

        public void setSourceLogo(String str) {
            this.sourceLogo = str;
        }

        public void setSourceSize(String str) {
            this.sourceSize = str;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public void setUid(String str) {
            this.uid = str;
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
