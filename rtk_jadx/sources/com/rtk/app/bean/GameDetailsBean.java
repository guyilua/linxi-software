package com.rtk.app.bean;

import java.io.Serializable;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GameDetailsBean implements Serializable {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class DataBean implements Serializable {
        private String OtherPackage;
        private String SignaturesMD5;
        private int already_collected;
        private AuthorBean author;
        private int coment_total;
        private ContactQQBean contact_QQ;
        private List<DownListBean> downlist;
        private String exists_ad;
        private String game_charge_type;
        private String game_downloads;
        private String game_en_name;
        private int game_id;
        private String game_install_bag_info;
        private String game_intro;
        private String game_language;
        private String game_level;
        private String game_logo;
        private String game_name;
        private String game_note;
        private List<String> game_pic_list;
        private String game_profile;
        private String game_rebate;
        private List<GameTagListBean> game_tag_list;
        private List<GameTestListBean> game_test_list;
        private String game_type;
        private String game_updated;
        private String game_vendor;
        private String game_vendor_id;
        private String game_version;
        private int has_giftbag;
        private int has_news;
        private String install_comment;
        private InstallationBean installation;
        private int is_apk;
        private String need_google;
        private String need_network;
        private String need_share;
        private String other_info;
        private List<OtherVersionBean> other_version;
        private String package_name;
        private String package_size;
        private String provider;
        private List<RecomGameBean> recom_game;
        private String system_requirements;
        private int version_code;
        private List<VipListBean> vip_list;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public class AuthorBean implements Serializable {
            private String face_2;
            private String id;
            private int mark;
            private String nickname;
            private String open_url;

            public AuthorBean() {
            }

            public String getFace_2() {
                return this.face_2;
            }

            public String getId() {
                return this.id;
            }

            public int getMark() {
                return this.mark;
            }

            public String getNickname() {
                return this.nickname;
            }

            public String getOpen_url() {
                return this.open_url;
            }

            public void setFace_2(String str) {
                this.face_2 = str;
            }

            public void setId(String str) {
                this.id = str;
            }

            public void setMark(int i) {
                this.mark = i;
            }

            public void setNickname(String str) {
                this.nickname = str;
            }

            public void setOpen_url(String str) {
                this.open_url = str;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public class ContactQQBean implements Serializable {
            private String QDKF;
            private String QDKF_url;
            private String QQ;
            private String QQ_show;
            private String QQgroup;
            private String QQgroup_key;
            private String is_QQ_show;

            public ContactQQBean() {
            }

            public String getIs_QQ_show() {
                return this.is_QQ_show;
            }

            public String getQDKF() {
                return this.QDKF;
            }

            public String getQDKF_url() {
                return this.QDKF_url;
            }

            public String getQQ() {
                return this.QQ;
            }

            public String getQQ_show() {
                return this.QQ_show;
            }

            public String getQQgroup() {
                return this.QQgroup;
            }

            public String getQQgroup_key() {
                return this.QQgroup_key;
            }

            public void setIs_QQ_show(String str) {
                this.is_QQ_show = str;
            }

            public void setQDKF(String str) {
                this.QDKF = str;
            }

            public void setQDKF_url(String str) {
                this.QDKF_url = str;
            }

            public void setQQ(String str) {
                this.QQ = str;
            }

            public void setQQ_show(String str) {
                this.QQ_show = str;
            }

            public void setQQgroup(String str) {
                this.QQgroup = str;
            }

            public void setQQgroup_key(String str) {
                this.QQgroup_key = str;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public class GameTagListBean implements Serializable {
            private String tag_id;
            private String tag_name;
            private int tag_type;

            public GameTagListBean() {
            }

            public String getTag_id() {
                return this.tag_id;
            }

            public String getTag_name() {
                return this.tag_name;
            }

            public int getTag_type() {
                return this.tag_type;
            }

            public void setTag_id(String str) {
                this.tag_id = str;
            }

            public void setTag_name(String str) {
                this.tag_name = str;
            }

            public void setTag_type(int i) {
                this.tag_type = i;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public class GameTestListBean implements Serializable {
            private int start_time;
            private String tag;
            private String title;

            public GameTestListBean() {
            }

            public int getStart_time() {
                return this.start_time;
            }

            public String getTag() {
                return this.tag;
            }

            public String getTitle() {
                return this.title;
            }

            public void setStart_time(int i) {
                this.start_time = i;
            }

            public void setTag(String str) {
                this.tag = str;
            }

            public void setTitle(String str) {
                this.title = str;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public class OtherVersionBean implements Serializable {
            private String OtherPackage;
            private String SignaturesMD5;
            private List<DownListBean> downlist;
            private int game_id;
            private String game_intro;
            private int game_level;
            private String game_logo;
            private String game_name;
            private String game_type;
            private int game_updated;
            private String game_version;
            private int is_apk;
            private String package_name;
            private String package_size;
            private int version_code;

            public OtherVersionBean() {
            }

            public List<DownListBean> getDownlist() {
                return this.downlist;
            }

            public int getGame_id() {
                return this.game_id;
            }

            public String getGame_intro() {
                return this.game_intro;
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

            public int getIs_apk() {
                return this.is_apk;
            }

            public String getOtherPackage() {
                return this.OtherPackage;
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

            public int getVersion_code() {
                return this.version_code;
            }

            public void setDownlist(List<DownListBean> list) {
                this.downlist = list;
            }

            public void setGame_id(int i) {
                this.game_id = i;
            }

            public void setGame_intro(String str) {
                this.game_intro = str;
            }

            public void setGame_level(int i) {
                this.game_level = i;
            }

            public void setGame_logo(String str) {
                this.game_logo = str;
            }

            public void setGame_name(String str) {
                this.game_name = str;
            }

            public void setGame_type(String str) {
                this.game_type = str;
            }

            public void setGame_updated(int i) {
                this.game_updated = i;
            }

            public void setGame_version(String str) {
                this.game_version = str;
            }

            public void setIs_apk(int i) {
                this.is_apk = i;
            }

            public void setOtherPackage(String str) {
                this.OtherPackage = str;
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

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public class RecomGameBean implements Serializable {
            private String OtherPackage;
            private String SignaturesMD5;
            private int game_id;
            private String game_intro;
            private int game_level;
            private String game_logo;
            private String game_name;
            private String game_type;
            private int game_updated;
            private String game_version;
            private int is_apk;
            private String package_name;
            private String package_size;
            private int version_code;

            public RecomGameBean() {
            }

            public int getGame_id() {
                return this.game_id;
            }

            public String getGame_intro() {
                return this.game_intro;
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

            public int getIs_apk() {
                return this.is_apk;
            }

            public String getOtherPackage() {
                return this.OtherPackage;
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

            public int getVersion_code() {
                return this.version_code;
            }

            public void setGame_id(int i) {
                this.game_id = i;
            }

            public void setGame_intro(String str) {
                this.game_intro = str;
            }

            public void setGame_level(int i) {
                this.game_level = i;
            }

            public void setGame_logo(String str) {
                this.game_logo = str;
            }

            public void setGame_name(String str) {
                this.game_name = str;
            }

            public void setGame_type(String str) {
                this.game_type = str;
            }

            public void setGame_updated(int i) {
                this.game_updated = i;
            }

            public void setGame_version(String str) {
                this.game_version = str;
            }

            public void setIs_apk(int i) {
                this.is_apk = i;
            }

            public void setOtherPackage(String str) {
                this.OtherPackage = str;
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

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public class VipListBean implements Serializable {
            private String level;
            private String value;

            public VipListBean() {
            }

            public String getLevel() {
                return this.level;
            }

            public String getValue() {
                return this.value;
            }

            public void setLevel(String str) {
                this.level = str;
            }

            public void setValue(String str) {
                this.value = str;
            }
        }

        public DataBean() {
        }

        public int getAlready_collected() {
            return this.already_collected;
        }

        public AuthorBean getAuthor() {
            return this.author;
        }

        public int getComent_total() {
            return this.coment_total;
        }

        public ContactQQBean getContact_QQ() {
            return this.contact_QQ;
        }

        public List<DownListBean> getDownlist() {
            return this.downlist;
        }

        public String getExists_ad() {
            return this.exists_ad;
        }

        public String getGame_charge_type() {
            return this.game_charge_type;
        }

        public String getGame_downloads() {
            return this.game_downloads;
        }

        public String getGame_en_name() {
            return this.game_en_name;
        }

        public int getGame_id() {
            return this.game_id;
        }

        public String getGame_install_bag_info() {
            return this.game_install_bag_info;
        }

        public String getGame_intro() {
            return this.game_intro;
        }

        public String getGame_language() {
            return this.game_language;
        }

        public String getGame_level() {
            return this.game_level;
        }

        public String getGame_logo() {
            return this.game_logo;
        }

        public String getGame_name() {
            return this.game_name;
        }

        public String getGame_note() {
            return this.game_note;
        }

        public List<String> getGame_pic_list() {
            return this.game_pic_list;
        }

        public String getGame_profile() {
            return this.game_profile;
        }

        public String getGame_rebate() {
            return this.game_rebate;
        }

        public List<GameTagListBean> getGame_tag_list() {
            return this.game_tag_list;
        }

        public List<GameTestListBean> getGame_test_list() {
            return this.game_test_list;
        }

        public String getGame_type() {
            return this.game_type;
        }

        public String getGame_updated() {
            return this.game_updated;
        }

        public String getGame_vendor() {
            return this.game_vendor;
        }

        public String getGame_vendor_id() {
            return this.game_vendor_id;
        }

        public String getGame_version() {
            return this.game_version;
        }

        public int getHas_giftbag() {
            return this.has_giftbag;
        }

        public int getHas_news() {
            return this.has_news;
        }

        public String getInstall_comment() {
            return this.install_comment;
        }

        public InstallationBean getInstallation() {
            return this.installation;
        }

        public int getIs_apk() {
            return this.is_apk;
        }

        public String getNeed_google() {
            return this.need_google;
        }

        public String getNeed_network() {
            return this.need_network;
        }

        public String getNeed_share() {
            return this.need_share;
        }

        public String getOtherPackage() {
            return this.OtherPackage;
        }

        public String getOther_info() {
            return this.other_info;
        }

        public List<OtherVersionBean> getOther_version() {
            return this.other_version;
        }

        public String getPackage_name() {
            return this.package_name;
        }

        public String getPackage_size() {
            return this.package_size;
        }

        public String getProvider() {
            return this.provider;
        }

        public List<RecomGameBean> getRecom_game() {
            return this.recom_game;
        }

        public String getSignaturesMD5() {
            return this.SignaturesMD5;
        }

        public String getSystem_requirements() {
            return this.system_requirements;
        }

        public int getVersion_code() {
            return this.version_code;
        }

        public List<VipListBean> getVip_list() {
            return this.vip_list;
        }

        public void setAlready_collected(int i) {
            this.already_collected = i;
        }

        public void setAuthor(AuthorBean authorBean) {
            this.author = authorBean;
        }

        public void setComent_total(int i) {
            this.coment_total = i;
        }

        public void setContact_QQ(ContactQQBean contactQQBean) {
            this.contact_QQ = contactQQBean;
        }

        public void setDownlist(List<DownListBean> list) {
            this.downlist = list;
        }

        public void setExists_ad(String str) {
            this.exists_ad = str;
        }

        public void setGame_charge_type(String str) {
            this.game_charge_type = str;
        }

        public void setGame_downloads(String str) {
            this.game_downloads = str;
        }

        public void setGame_en_name(String str) {
            this.game_en_name = str;
        }

        public void setGame_id(int i) {
            this.game_id = i;
        }

        public void setGame_install_bag_info(String str) {
            this.game_install_bag_info = str;
        }

        public void setGame_intro(String str) {
            this.game_intro = str;
        }

        public void setGame_language(String str) {
            this.game_language = str;
        }

        public void setGame_level(String str) {
            this.game_level = str;
        }

        public void setGame_logo(String str) {
            this.game_logo = str;
        }

        public void setGame_name(String str) {
            this.game_name = str;
        }

        public void setGame_note(String str) {
            this.game_note = str;
        }

        public void setGame_pic_list(List<String> list) {
            this.game_pic_list = list;
        }

        public void setGame_profile(String str) {
            this.game_profile = str;
        }

        public void setGame_rebate(String str) {
            this.game_rebate = str;
        }

        public void setGame_tag_list(List<GameTagListBean> list) {
            this.game_tag_list = list;
        }

        public void setGame_test_list(List<GameTestListBean> list) {
            this.game_test_list = list;
        }

        public void setGame_type(String str) {
            this.game_type = str;
        }

        public void setGame_updated(String str) {
            this.game_updated = str;
        }

        public void setGame_vendor(String str) {
            this.game_vendor = str;
        }

        public void setGame_vendor_id(String str) {
            this.game_vendor_id = str;
        }

        public void setGame_version(String str) {
            this.game_version = str;
        }

        public void setHas_giftbag(int i) {
            this.has_giftbag = i;
        }

        public void setHas_news(int i) {
            this.has_news = i;
        }

        public void setInstall_comment(String str) {
            this.install_comment = str;
        }

        public void setInstallation(InstallationBean installationBean) {
            this.installation = installationBean;
        }

        public void setIs_apk(int i) {
            this.is_apk = i;
        }

        public void setNeed_google(String str) {
            this.need_google = str;
        }

        public void setNeed_network(String str) {
            this.need_network = str;
        }

        public void setNeed_share(String str) {
            this.need_share = str;
        }

        public void setOtherPackage(String str) {
            this.OtherPackage = str;
        }

        public void setOther_info(String str) {
            this.other_info = str;
        }

        public void setOther_version(List<OtherVersionBean> list) {
            this.other_version = list;
        }

        public void setPackage_name(String str) {
            this.package_name = str;
        }

        public void setPackage_size(String str) {
            this.package_size = str;
        }

        public void setProvider(String str) {
            this.provider = str;
        }

        public void setRecom_game(List<RecomGameBean> list) {
            this.recom_game = list;
        }

        public void setSignaturesMD5(String str) {
            this.SignaturesMD5 = str;
        }

        public void setSystem_requirements(String str) {
            this.system_requirements = str;
        }

        public void setVersion_code(int i) {
            this.version_code = i;
        }

        public void setVip_list(List<VipListBean> list) {
            this.vip_list = list;
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
