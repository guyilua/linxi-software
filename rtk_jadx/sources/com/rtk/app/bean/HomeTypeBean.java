package com.rtk.app.bean;

import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeTypeBean {
    private int code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String icon;
        private String id;
        private String methods;
        private String pid;
        private String title;
        private Map<String, String> type;

        public String getIcon() {
            return this.icon;
        }

        public String getId() {
            return this.id;
        }

        public String getMethods() {
            return this.methods;
        }

        public String getPid() {
            return this.pid;
        }

        public String getTitle() {
            return this.title;
        }

        public Map<String, String> getType() {
            return this.type;
        }

        public void setIcon(String str) {
            this.icon = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setMethods(String str) {
            this.methods = str;
        }

        public void setPid(String str) {
            this.pid = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setType(Map<String, String> map) {
            this.type = map;
        }
    }

    public int getCode() {
        return this.code;
    }

    public List<DataBean> getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(List<DataBean> list) {
        this.data = list;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
