package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.config.FieldManager;

/* compiled from: UTDIdTracker.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class j extends a {
    private static final String a = "utdid";
    private Context b;

    public j(Context context) {
        super(a);
        this.b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            if (FieldManager.allow(com.umeng.commonsdk.utils.b.u)) {
                return (String) Class.forName("com.ut.device.UTDevice").getMethod("getUtdid", Context.class).invoke(null, this.b);
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
