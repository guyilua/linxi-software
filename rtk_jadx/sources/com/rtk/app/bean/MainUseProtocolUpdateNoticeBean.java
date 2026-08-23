package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MainUseProtocolUpdateNoticeBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private AgreementBean agreement;
        private AgreementPrivacyBean agreement_privacy;
        private AnnouncementBean announcement;
        private CheckupdatesBean checkupdates;
        private SignBean sign;
        private String uploadUrl;
        private String videoUploadUrl;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class AgreementBean {
            private String agreement_desc;
            private String agreement_id;
            private String agreement_switch;

            public String getAgreement_desc() {
                return this.agreement_desc;
            }

            public String getAgreement_id() {
                return this.agreement_id;
            }

            public String getAgreement_switch() {
                return this.agreement_switch;
            }

            public void setAgreement_desc(String str) {
                this.agreement_desc = str;
            }

            public void setAgreement_id(String str) {
                this.agreement_id = str;
            }

            public void setAgreement_switch(String str) {
                this.agreement_switch = str;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class AgreementPrivacyBean {
            private String agreement_id;
            private String agreement_switch;

            public String getAgreement_id() {
                return this.agreement_id;
            }

            public String getAgreement_switch() {
                return this.agreement_switch;
            }

            public void setAgreement_id(String str) {
                this.agreement_id = str;
            }

            public void setAgreement_switch(String str) {
                this.agreement_switch = str;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class AnnouncementBean {
            private String ad_desc;
            private String ad_id;
            private String is_ad;

            public String getAd_desc() {
                return this.ad_desc;
            }

            public String getAd_id() {
                return this.ad_id;
            }

            public String getIs_ad() {
                return this.is_ad;
            }

            public void setAd_desc(String str) {
                this.ad_desc = str;
            }

            public void setAd_id(String str) {
                this.ad_id = str;
            }

            public void setIs_ad(String str) {
                this.is_ad = str;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class CheckupdatesBean {
            private String download_url;
            private String force_update;
            private String is_update;
            private String update_content;
            private String updatesUrl;
            private String updatesWay;
            private int versioncode;

            public String getDownload_url() {
                return this.download_url;
            }

            public String getForce_update() {
                return this.force_update;
            }

            public String getIs_update() {
                return this.is_update;
            }

            public String getUpdate_content() {
                return this.update_content;
            }

            public String getUpdatesUrl() {
                return this.updatesUrl;
            }

            public String getUpdatesWay() {
                return this.updatesWay;
            }

            public int getVersioncode() {
                return this.versioncode;
            }

            public void setDownload_url(String str) {
                this.download_url = str;
            }

            public void setForce_update(String str) {
                this.force_update = str;
            }

            public void setIs_update(String str) {
                this.is_update = str;
            }

            public void setUpdate_content(String str) {
                this.update_content = str;
            }

            public void setUpdatesUrl(String str) {
                this.updatesUrl = str;
            }

            public void setUpdatesWay(String str) {
                this.updatesWay = str;
            }

            public void setVersioncode(int i) {
                this.versioncode = i;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class SignBean {
            private String is_signature;
            private String signature_msg;
            private String signature_url;
            private String signature_val;

            public String getIs_signature() {
                return this.is_signature;
            }

            public String getSignature_msg() {
                return this.signature_msg;
            }

            public String getSignature_url() {
                return this.signature_url;
            }

            public String getSignature_val() {
                return this.signature_val;
            }

            public void setIs_signature(String str) {
                this.is_signature = str;
            }

            public void setSignature_msg(String str) {
                this.signature_msg = str;
            }

            public void setSignature_url(String str) {
                this.signature_url = str;
            }

            public void setSignature_val(String str) {
                this.signature_val = str;
            }
        }

        public AgreementBean getAgreement() {
            return this.agreement;
        }

        public AgreementPrivacyBean getAgreement_privacy() {
            return this.agreement_privacy;
        }

        public AnnouncementBean getAnnouncement() {
            return this.announcement;
        }

        public CheckupdatesBean getCheckupdates() {
            return this.checkupdates;
        }

        public SignBean getSign() {
            return this.sign;
        }

        public String getUploadUrl() {
            return this.uploadUrl;
        }

        public String getVideoUploadUrl() {
            return this.videoUploadUrl;
        }

        public void setAgreement(AgreementBean agreementBean) {
            this.agreement = agreementBean;
        }

        public void setAgreement_privacy(AgreementPrivacyBean agreementPrivacyBean) {
            this.agreement_privacy = agreementPrivacyBean;
        }

        public void setAnnouncement(AnnouncementBean announcementBean) {
            this.announcement = announcementBean;
        }

        public void setCheckupdates(CheckupdatesBean checkupdatesBean) {
            this.checkupdates = checkupdatesBean;
        }

        public void setSign(SignBean signBean) {
            this.sign = signBean;
        }

        public void setUploadUrl(String str) {
            this.uploadUrl = str;
        }

        public void setVideoUploadUrl(String str) {
            this.videoUploadUrl = str;
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
