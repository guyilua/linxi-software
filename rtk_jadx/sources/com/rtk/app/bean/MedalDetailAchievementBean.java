package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MedalDetailAchievementBean {
    private Integer code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String addtime;
        private String desc;
        private Integer get;
        private String id;
        private String last;
        private String pic;
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

        public String getLast() {
            return this.last;
        }

        public String getPic() {
            return this.pic;
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

        public void setLast(String str) {
            this.last = str;
        }

        public void setPic(String str) {
            this.pic = str;
        }

        public void setTitle(String str) {
            this.title = str;
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
