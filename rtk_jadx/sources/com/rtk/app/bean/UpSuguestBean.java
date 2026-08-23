package com.rtk.app.bean;

import com.rtk.app.tool.c0;
import java.io.Serializable;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpSuguestBean implements Serializable {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean implements Serializable {
        private String desc;
        private String id;
        private String isSuguest;

        public String getDesc() {
            return this.desc;
        }

        public String getId() {
            return c0.q(this.id) ? "" : this.id;
        }

        public String getIsSuguest() {
            return this.isSuguest;
        }

        public void setDesc(String str) {
            this.desc = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setIsSuguest(String str) {
            this.isSuguest = str;
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
