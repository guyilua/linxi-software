package com.rtk.app.main.family;

import com.rtk.app.bean.FamilyCreateCheckBean;
import com.rtk.app.bean.FamilyCreateCheckTipsBean;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: FamilyUtil.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class j1 {
    public static boolean a(FamilyCreateCheckTipsBean.DataBean dataBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(dataBean.getCheckApplyFamily());
        arrayList.add(dataBean.getCheckCoin());
        arrayList.add(dataBean.getCheckFamily());
        arrayList.add(dataBean.getCheckLevel());
        arrayList.add(dataBean.getCheckRealNameAuth());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            FamilyCreateCheckBean familyCreateCheckBean = (FamilyCreateCheckBean) it.next();
            if (familyCreateCheckBean != null && familyCreateCheckBean.getIs_ok() != 1) {
                return false;
            }
        }
        return true;
    }
}
