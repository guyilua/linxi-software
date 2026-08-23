package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GoodsListBean {
    private Integer code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String addtime;
        private String coin;
        private String gift_msg;
        private String gift_name;
        private List<String> gift_pic;
        private String gift_type;
        private String id;
        private String num;

        public String getAddtime() {
            return this.addtime;
        }

        public String getCoin() {
            return this.coin;
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

        public String getNum() {
            return this.num;
        }

        public void setAddtime(String str) {
            this.addtime = str;
        }

        public void setCoin(String str) {
            this.coin = str;
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
    }

    public Integer getCode() {
        return this.code;
    }

    public List<DataBean> getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public void setData(List<DataBean> list) {
        this.data = list;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
