package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* compiled from: EventBlackList.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a extends EventList {
    private d a;
    private Object b;

    public a(String str, String str2) {
        super(str, str2);
        this.b = new Object();
    }

    @Override // com.umeng.analytics.filter.EventList
    protected void eventListChange() {
        if (TextUtils.isEmpty(this.mEventList)) {
            return;
        }
        synchronized (this.b) {
            this.a = null;
            this.a = new d(false, this.mEventList);
        }
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean a;
        if (TextUtils.isEmpty(this.mEventList)) {
            return false;
        }
        synchronized (this.b) {
            if (this.a == null) {
                this.a = new d(false, this.mEventList);
            }
            a = this.a.a(str);
        }
        return a;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z) {
        AnalyticsConfig.CLEAR_EKV_BL = z;
    }
}
