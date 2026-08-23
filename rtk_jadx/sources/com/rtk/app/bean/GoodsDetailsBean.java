package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GoodsDetailsBean {
    private Integer code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String addtime;
        private String applyNum;
        private String availableNum;
        private String coin;
        private List<ContactBean> contact;
        private String gift_msg;
        private String gift_name;
        private List<String> gift_pic;
        private String gift_type;
        private String id;
        private String monthNum;
        private String num;
        private String online;
        private String usercoin;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class ContactBean {
            private String display;
            private String tags;
            private String type;

            public String getDisplay() {
                return this.display;
            }

            public String getTags() {
                return this.tags;
            }

            public String getType() {
                return this.type;
            }

            public void setDisplay(String str) {
                this.display = str;
            }

            public void setTags(String str) {
                this.tags = str;
            }

            public void setType(String str) {
                this.type = str;
            }
        }

        public String getAddtime() {
            return this.addtime;
        }

        public String getAvailableNum() {
            return this.availableNum;
        }

        public String getCoin() {
            return this.coin;
        }

        public List<ContactBean> getContact() {
            return this.contact;
        }

        public String getGift_msg() {
            return this.gift_msg;
        }

        public String getGift_name() {
            return this.gift_name;
        }

        public List<String> getGift_pic() {
            return this.gift_pic;
        }

        public String getGift_type() {
            return this.gift_type;
        }

        public String getId() {
            return this.id;
        }

        public String getMonthNum() {
            return this.monthNum;
        }

        public int getNum() {
            try {
                return Integer.parseInt(this.num);
            } catch (Exception unused) {
                return 0;
            }
        }

        public String getOnline() {
            return this.online;
        }

        public String getUsercoin() {
            return this.usercoin;
        }

        public void setAddtime(String str) {
            this.addtime = str;
        }

        public void setCoin(String str) {
            this.coin = str;
        }

        public void setContact(List<ContactBean> list) {
            this.contact = list;
        }

        public void setGift_msg(String str) {
            this.gift_msg = str;
        }

        public void setGift_name(String str) {
            this.gift_name = str;
        }

        public void setGift_pic(List<String> list) {
            this.gift_pic = list;
        }

        public void setGift_type(String str) {
            this.gift_type = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setNum(String str) {
            this.num = str;
        }

        public void setOnline(String str) {
            this.online = str;
        }

        public void setUsercoin(String str) {
            this.usercoin = str;
        }
    }

    public Integer getCode() {
        return this.code;
    }

    public DataBean getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
