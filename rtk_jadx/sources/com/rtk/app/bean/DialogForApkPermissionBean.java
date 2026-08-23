package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForApkPermissionBean {
    private Integer code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String english;
        private String msg;
        private String name;

        public String getEnglish() {
            return this.english;
        }

        public String getMsg() {
            return this.msg;
        }

        public String getName() {
            return this.name;
        }

        public void setEnglish(String str) {
            this.english = str;
        }

        public void setMsg(String str) {
            this.msg = str;
        }

        public void setName(String str) {
            this.name = str;
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
