package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GoodsReplyRecodeBean {
    private Integer code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String addtime;
        private String delMsg;
        private String gift_name;
        private String id;
        private String show;

        public long getAddtime() {
            try {
                return Long.parseLong(this.addtime);
            } catch (Exception unused) {
                return 0L;
            }
        }

        public String getDelMsg() {
            return this.delMsg;
        }

        public String getGift_name() {
            return this.gift_name;
        }

        public String getId() {
            return this.id;
        }

        public String getShow() {
            return this.show;
        }

        public void setAddtime(String str) {
            this.addtime = str;
        }

        public void setDelMsg(String str) {
            this.delMsg = str;
        }

        public void setGift_name(String str) {
            this.gift_name = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setShow(String str) {
            this.show = str;
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
