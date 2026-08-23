package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.commonsdk.config.FieldManager;

/* compiled from: OaidTracking.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class h extends a {
    public static final String a = "umeng_sp_oaid";
    public static final String b = "key_umeng_sp_oaid";

    /* renamed from: c, reason: collision with root package name */
    public static final String f1108c = "key_umeng_sp_oaid_required_time";
    private static final String d = "oaid";
    private Context e;

    public h(Context context) {
        super(d);
        this.e = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        if (!FieldManager.allow(com.umeng.commonsdk.utils.b.G)) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = this.e.getSharedPreferences(a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getString(b, "");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
