package com.rtk.app.bean;

import com.rtk.app.tool.ApkInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ListHisUpBean {
    private List<ApkInfo> upBeanList = new ArrayList();

    public List<ApkInfo> getUpBeanList() {
        return this.upBeanList;
    }

    public void setUpBeanList(List<ApkInfo> list) {
        this.upBeanList = list;
    }
}
