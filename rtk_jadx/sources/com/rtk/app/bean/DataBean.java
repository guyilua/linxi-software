package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DataBean {
    private String SignaturesMD5;
    private List<DownListBean> downlist;
    private int game_id;
    private int game_level;
    private String game_logo;
    private String game_name;
    private String game_type;
    private int game_updated;
    private String game_version;
    private InstallationBean installation;
    private int is_apk;
    private String langues;
    private String need_share;
    private String package_name;
    private String package_size;
    private List<String> tag_name;
    private int version_code;

    public List<DownListBean> getDownlist() {
        return this.downlist;
    }

    public int getGame_id() {
        return this.game_id;
    }

    public int getGame_level() {
        return this.game_level;
    }

    public String getGame_logo() {
        return this.game_logo;
    }

    public String getGame_name() {
        return this.game_name;
    }

    public String getGame_type() {
        return this.game_type;
    }

    public int getGame_updated() {
        return this.game_updated;
    }

    public String getGame_version() {
        return this.game_version;
    }

    public InstallationBean getInstallation() {
        return this.installation;
    }

    public int getIs_apk() {
        return this.is_apk;
    }

    public String getLangues() {
        return this.langues;
    }

    public String getNeed_share() {
        return this.need_share;
    }

    public String getPackage_name() {
        return this.package_name;
    }

    public String getPackage_size() {
        return this.package_size;
    }

    public String getSignaturesMD5() {
        return this.SignaturesMD5;
    }

    public List<String> getTag_name() {
        return this.tag_name;
    }

    public int getVersion_code() {
        return this.version_code;
    }

    public void setDownlist(List<DownListBean> list) {
        this.downlist = list;
    }

    public void setGame_id(int i) {
        this.game_id = i;
    }

    public void setGame_logo(String str) {
        this.game_logo = str;
    }

    public void setGame_name(String str) {
        this.game_name = str;
    }

    public void setInstallation(InstallationBean installationBean) {
        this.installation = installationBean;
    }

    public void setIs_apk(int i) {
        this.is_apk = i;
    }

    public void setPackage_name(String str) {
        this.package_name = str;
    }

    public void setPackage_size(String str) {
        this.package_size = str;
    }

    public void setSignaturesMD5(String str) {
        this.SignaturesMD5 = str;
    }

    public void setVersion_code(int i) {
        this.version_code = i;
    }
}
