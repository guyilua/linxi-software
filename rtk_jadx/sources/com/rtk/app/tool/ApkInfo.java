package com.rtk.app.tool;

import androidx.annotation.Keep;
import com.rtk.app.bean.DataBean;
import com.rtk.app.bean.DownListBean;
import com.rtk.app.bean.FamilyUpAuditListBean;
import com.rtk.app.bean.GameDetailsBean;
import com.rtk.app.bean.InstallationBean;
import com.rtk.app.bean.MyUpApkCommentBean;
import com.rtk.app.bean.UpApkDetailsBean;
import com.rtk.app.bean.UpApkListBean;
import com.rtk.app.bean.UpAuditAgainListBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Keep
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ApkInfo implements Serializable {
    private static final String TAG = "ApkInfo";
    private String SignaturesMD5;
    private String apkSize;
    private String appName;
    private long clickTime;
    private List<DownListBean> downlist;
    private int gameId;
    private String icon_url;
    private InstallationBean installation;
    private int isApk;
    private int needCoin;
    private String need_share;
    private String packageName;
    private String package_size;
    private int upGameId;
    private String versionName;
    private int version_code;

    public ApkInfo(int i, String str, String str2, String str3, String str4, String str5, int i2, int i3, List<DownListBean> list) {
        this.apkSize = "";
        this.versionName = "";
        this.gameId = i;
        this.appName = str;
        this.packageName = str2;
        this.icon_url = str3;
        this.package_size = str4;
        this.SignaturesMD5 = str5;
        this.isApk = i2;
        this.version_code = i3;
        if (list != null) {
            this.downlist = list;
        }
    }

    public String getApkSize() {
        return this.apkSize;
    }

    public String getAppName() {
        return this.appName;
    }

    public long getClickTime() {
        return this.clickTime;
    }

    public List<DownListBean> getDownlist() {
        return this.downlist;
    }

    public int getGameId() {
        return this.gameId;
    }

    public String getIcon_url() {
        return c0.q(this.icon_url) ? "" : this.icon_url;
    }

    public InstallationBean getInstallation() {
        return this.installation;
    }

    public int getIsApk() {
        return this.isApk;
    }

    public int getNeedCoin() {
        return this.needCoin;
    }

    public String getNeed_share() {
        return this.need_share;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPackage_size() {
        return this.package_size;
    }

    public String getSignaturesMD5() {
        return this.SignaturesMD5;
    }

    public int getUpGameId() {
        int i = this.gameId;
        return i > 10000000 ? i - 10000000 : i;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public int getVersion_code() {
        return this.version_code;
    }

    public void setApkSize(String str) {
        this.apkSize = str;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setClickTime(long j) {
        this.clickTime = j;
    }

    public void setDownlist(List<DownListBean> list) {
        this.downlist = list;
    }

    public void setGameId(int i) {
        this.gameId = i;
    }

    public void setIcon_url(String str) {
        this.icon_url = str;
    }

    public void setInstallation(InstallationBean installationBean) {
        this.installation = installationBean;
    }

    public void setIsApk(int i) {
        this.isApk = i;
    }

    public void setNeedCoin(int i) {
        this.needCoin = i;
    }

    public void setNeed_share(String str) {
        this.need_share = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPackage_size(String str) {
        this.package_size = str;
    }

    public void setSignaturesMD5(String str) {
        this.SignaturesMD5 = str;
    }

    public void setUpGameId(int i) {
        this.upGameId = i;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    public void setVersion_code(int i) {
        this.version_code = i;
    }

    public String toString() {
        return "ApkInfo{gameId=" + this.gameId + ", appName='" + this.appName + "', packageName='" + this.packageName + "', icon_url='" + this.icon_url + "', package_size='" + this.package_size + "', SignaturesMD5='" + this.SignaturesMD5 + "', version_code=" + this.version_code + ", isApk=" + this.isApk + '}';
    }

    public ApkInfo(com.rtk.app.tool.DownLoadTool.p pVar) {
        this.apkSize = "";
        this.versionName = "";
        this.gameId = pVar.j();
        this.appName = pVar.c();
        this.packageName = pVar.n();
        this.icon_url = pVar.k();
        this.package_size = pVar.d() + "";
        this.SignaturesMD5 = pVar.o();
        this.isApk = pVar.m();
        this.version_code = pVar.s();
        this.downlist = pVar.g();
        this.installation = pVar.l();
        c0.u(TAG, "method2 downList.size" + this.downlist.size());
    }

    public ApkInfo(DataBean dataBean) {
        this.apkSize = "";
        this.versionName = "";
        this.gameId = dataBean.getGame_id();
        this.appName = dataBean.getGame_name();
        this.packageName = dataBean.getPackage_name();
        this.icon_url = dataBean.getGame_logo();
        this.package_size = dataBean.getPackage_size() + "";
        this.SignaturesMD5 = dataBean.getSignaturesMD5();
        this.isApk = dataBean.getIs_apk();
        this.version_code = dataBean.getVersion_code();
        this.need_share = dataBean.getNeed_share();
        this.installation = dataBean.getInstallation();
        if (dataBean.getDownlist() == null) {
            c0.s(TAG, "dataBean.getDownList() is null");
        } else {
            this.downlist = dataBean.getDownlist();
        }
    }

    public ApkInfo(GameDetailsBean.DataBean dataBean) {
        this.apkSize = "";
        this.versionName = "";
        this.gameId = dataBean.getGame_id();
        this.appName = dataBean.getGame_name();
        this.packageName = dataBean.getPackage_name();
        this.icon_url = dataBean.getGame_logo();
        this.package_size = dataBean.getPackage_size() + "";
        this.SignaturesMD5 = dataBean.getSignaturesMD5();
        this.isApk = dataBean.getIs_apk();
        this.version_code = dataBean.getVersion_code();
        this.need_share = dataBean.getNeed_share();
        this.downlist = dataBean.getDownlist();
        c0.u(TAG, "method4 downList.size" + this.downlist.size());
        this.installation = dataBean.getInstallation();
    }

    public ApkInfo(UpApkListBean.DataBean dataBean) {
        this.apkSize = "";
        this.versionName = "";
        this.gameId = dataBean.getId() + 10000000;
        this.upGameId = dataBean.getId();
        this.appName = dataBean.getVarName();
        this.packageName = dataBean.getPackageName();
        this.icon_url = dataBean.getSourceLogo();
        this.package_size = dataBean.getSourceSize();
        this.SignaturesMD5 = dataBean.getMd5();
        this.version_code = dataBean.getVersionCode();
        this.installation = dataBean.getInstallation();
        this.downlist = new ArrayList();
        this.needCoin = dataBean.getNeedCoin();
        int i = 0;
        if (dataBean.isZip()) {
            while (i < dataBean.getUpDataPathList().size()) {
                this.downlist.add(new DownListBean(dataBean.getUpDataPathList().get(i)));
                i++;
            }
        } else if (dataBean.getUpSourcePathList() != null) {
            while (i < dataBean.getUpSourcePathList().size()) {
                this.downlist.add(new DownListBean(dataBean.getUpSourcePathList().get(i)));
                i++;
            }
        }
        c0.u(TAG, "method5 downList.size" + this.downlist.size());
    }

    public ApkInfo(UpAuditAgainListBean.DataDTO dataDTO) {
        this.apkSize = "";
        this.versionName = "";
        this.gameId = dataDTO.getId() + 10000000;
        this.upGameId = dataDTO.getId();
        this.appName = dataDTO.getVarName();
        this.packageName = dataDTO.getPackageName();
        this.icon_url = dataDTO.getSourceLogo();
        this.package_size = dataDTO.getSourceSize();
        this.SignaturesMD5 = dataDTO.getMd5();
        this.installation = dataDTO.getInstallation();
        this.downlist = new ArrayList();
        if (dataDTO.getUpSourcePathList() != null) {
            for (int i = 0; i < dataDTO.getUpSourcePathList().size(); i++) {
                this.downlist.add(new DownListBean(dataDTO.getUpSourcePathList().get(i)));
            }
        }
        c0.u(TAG, "method7 downList.size" + this.downlist.size());
    }

    public ApkInfo(FamilyUpAuditListBean.DataDTO dataDTO) {
        this.apkSize = "";
        this.versionName = "";
        this.gameId = dataDTO.getId() + 10000000;
        this.upGameId = dataDTO.getId();
        this.appName = dataDTO.getVarName();
        this.packageName = dataDTO.getPackageName();
        this.icon_url = dataDTO.getSourceLogo();
        this.package_size = dataDTO.getSourceSize();
        this.SignaturesMD5 = dataDTO.getMd5();
        this.installation = dataDTO.getInstallation();
        this.downlist = new ArrayList();
        if (dataDTO.getUpSourcePathList() != null) {
            for (int i = 0; i < dataDTO.getUpSourcePathList().size(); i++) {
                this.downlist.add(new DownListBean(dataDTO.getUpSourcePathList().get(i)));
            }
        }
        c0.u(TAG, "method7 downList.size" + this.downlist.size());
    }

    public ApkInfo(MyUpApkCommentBean.DataBean dataBean) {
        this.apkSize = "";
        this.versionName = "";
        this.gameId = dataBean.getUsid() + 10000000;
        this.upGameId = dataBean.getUsid();
        this.appName = dataBean.getVarName();
        this.icon_url = dataBean.getSourceLogo();
        this.packageName = dataBean.getPackageName();
        this.downlist = new ArrayList();
        this.installation = dataBean.getInstallation();
        int i = 0;
        if (dataBean.isZip()) {
            if (dataBean.getUpDataPathList() == null) {
                return;
            }
            while (i < dataBean.getUpDataPathList().size()) {
                this.downlist.add(new DownListBean(dataBean.getUpDataPathList().get(i)));
                i++;
            }
        } else {
            if (dataBean.getUpSourcePathList() == null) {
                return;
            }
            while (i < dataBean.getUpSourcePathList().size()) {
                this.downlist.add(new DownListBean(dataBean.getUpSourcePathList().get(i)));
                i++;
            }
        }
        c0.u(TAG, "method7 downList.size" + this.downlist.size());
    }

    public ApkInfo(UpApkDetailsBean.DataBean dataBean) {
        this.apkSize = "";
        this.versionName = "";
        this.gameId = dataBean.getId() + 10000000;
        this.upGameId = dataBean.getId();
        this.appName = dataBean.getVarName();
        this.icon_url = dataBean.getSourceLogo();
        this.packageName = dataBean.getPackageName();
        this.installation = dataBean.getInstallation();
        this.downlist = new ArrayList();
        int i = 0;
        if (dataBean.isZip()) {
            while (i < dataBean.getUpDataPathList().size()) {
                this.downlist.add(new DownListBean(dataBean.getUpDataPathList().get(i)));
                i++;
            }
        } else {
            while (i < dataBean.getUpSourcePathList().size()) {
                this.downlist.add(new DownListBean(dataBean.getUpSourcePathList().get(i)));
                i++;
            }
        }
        c0.u(TAG, "method6 downList.size" + this.downlist.size());
    }
}
