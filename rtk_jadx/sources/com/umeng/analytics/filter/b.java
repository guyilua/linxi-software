package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* compiled from: EventWhiteList.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b extends EventList {
    private d a;
    private Object b;

    public b(String str, String str2) {
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
            this.a = new d(true, this.mEventList);
        }
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean a;
        if (TextUtils.isEmpty(this.mEventList)) {
            return true;
        }
        synchronized (this.b) {
            if (this.a == null) {
                this.a = new d(true, this.mEventList);
            }
            a = this.a.a(str);
        }
        return a;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z) {
        AnalyticsConfig.CLEAR_EKV_WL = z;
    }
}
