package com.rtk.app.bean;

import com.rtk.app.tool.ApkInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ListHisGameBean {
    List<HisGameBean> listBean = new ArrayList();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class HisGameBean {
        private ApkInfo apkInfo;
        private long clickTime;

        public HisGameBean(ApkInfo apkInfo) {
            this.apkInfo = apkInfo;
        }

        public ApkInfo getApkInfo() {
            return this.apkInfo;
        }

        public long getClickTime() {
            return this.clickTime;
        }

        public void setApkInfo(ApkInfo apkInfo) {
            this.apkInfo = apkInfo;
        }

        public void setClickTime(long j) {
            this.clickTime = j;
        }
    }

    public List<HisGameBean> getListBean() {
        return this.listBean;
    }

    public void setListBean(List<HisGameBean> list) {
        this.listBean = list;
    }
}
