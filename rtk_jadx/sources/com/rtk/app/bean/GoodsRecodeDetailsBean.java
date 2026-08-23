package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GoodsRecodeDetailsBean {
    private Integer code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String addtime;
        private String coin;
        private String delMsg;
        private String delTime;
        private String gid;
        private String gift_name;
        private List<String> gift_pic;
        private String gift_type;
        private String id;
        private String msg;
        private String num;
        private String show;
        private String tname;
        private String uid;

        public long getAddtime() {
            try {
                return Long.parseLong(this.addtime);
            } catch (Exception unused) {
                return 0L;
            }
        }

        public String getCoin() {
            return this.coin;
        }

        public String getDelMsg() {
            return this.delMsg;
        }

        public String getDelTime() {
            return this.delTime;
        }

        public String getGid() {
            return this.gid;
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

        public String getMsg() {
            return this.msg;
        }

        public String getNum() {
            return this.num;
        }

        public String getShow() {
            return this.show;
        }

        public String getTname() {
            return this.tname;
        }

        public String getUid() {
            return this.uid;
        }

        public void setAddtime(String str) {
            this.addtime = str;
        }

        public void setCoin(String str) {
            this.coin = str;
        }

        public void setDelMsg(String str) {
            this.delMsg = str;
        }

        public void setDelTime(String str) {
            this.delTime = str;
        }

        public void setGid(String str) {
            this.gid = str;
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

        public void setMsg(String str) {
            this.msg = str;
        }

        public void setNum(String str) {
            this.num = str;
        }

        public void setShow(String str) {
            this.show = str;
        }

        public void setTname(String str) {
            this.tname = str;
        }

        public void setUid(String str) {
            this.uid = str;
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
