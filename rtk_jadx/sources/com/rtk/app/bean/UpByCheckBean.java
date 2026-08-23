package com.rtk.app.bean;

import com.rtk.app.tool.c0;
import java.io.Serializable;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpByCheckBean implements Serializable {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private int isBuy;
        private String tips;
        private List<DownListBean> upDataPathList;
        private List<DownListBean> upSourcePathList;

        public int getIsBuy() {
            return this.isBuy;
        }

        public String getTips() {
            return this.tips;
        }

        public List<DownListBean> getUpDataPathList() {
            return this.upDataPathList;
        }

        public List<DownListBean> getUpSourcePathList() {
            return this.upSourcePathList;
        }

        public boolean isZip() {
            List<DownListBean> list = this.upDataPathList;
            return (list == null || list.isEmpty() || c0.q(this.upDataPathList.get(0).getUrl())) ? false : true;
        }

        public void setIsBuy(int i) {
            this.isBuy = i;
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
