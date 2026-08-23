package com.rtk.app.bean;

import java.io.Serializable;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MedalDetailBean implements Serializable {
    private Integer code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean implements Serializable {
        private String addtime;
        private String desc;
        private Integer get;
        private String id;
        private String num;
        private String pic;
        private String pid;
        private String title;

        public String getAddtime() {
            return this.addtime;
        }

        public String getDesc() {
            return this.desc;
        }

        public Integer getGet() {
            return this.get;
        }

        public String getId() {
            return this.id;
        }

        public String getNum() {
            return this.num;
        }

        public String getPic() {
            return this.pic;
        }

        public String getPid() {
            return this.pid;
        }

        public String getTitle() {
            return this.title;
        }

        public void setAddtime(String str) {
            this.addtime = str;
        }

        public void setDesc(String str) {
            this.desc = str;
        }

        public void setGet(Integer num) {
            this.get = num;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setNum(String str) {
            this.num = str;
        }

        public void setPic(String str) {
            this.pic = str;
        }

        public void setPid(String str) {
            this.pid = str;
        }

        public void setTitle(String str) {
            this.title = str;
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
