package com.sigmob.sdk.base;

import android.content.SharedPreferences;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmobPrivacy;
import com.sigmob.sdk.base.mta.PointType;
import com.sigmob.windad.consent.WindAdConsentInformation;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f {
    private static f e;
    private int b;
    private int d;
    private boolean f;
    private int g;
    private Boolean h;
    private boolean a = true;

    /* renamed from: c, reason: collision with root package name */
    private boolean f402c = true;

    private f() {
        try {
            this.b = com.sigmob.sdk.base.utils.g.a().getInt("age_restricted_status", 0);
        } catch (Throwable unused) {
        }
        try {
            this.d = com.sigmob.sdk.base.utils.g.a().getInt("user_age", 0);
        } catch (Throwable unused2) {
        }
        try {
            this.g = com.sigmob.sdk.base.utils.g.a().getInt("consent_status", 0);
        } catch (Throwable unused3) {
        }
        try {
            this.f = com.sigmob.sdk.base.utils.g.a().getBoolean("gdpr_region", false);
        } catch (Throwable unused4) {
        }
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (e == null) {
                synchronized (f.class) {
                    e = new f();
                }
            }
            fVar = e;
        }
        return fVar;
    }

    private void a(int i) {
        PointEntitySigmobPrivacy pointEntitySigmobPrivacy = new PointEntitySigmobPrivacy();
        pointEntitySigmobPrivacy.setAge(String.valueOf(i));
        pointEntitySigmobPrivacy.setAc_type(PointType.GDPR_CONSENT);
        pointEntitySigmobPrivacy.setSub_category("coppa");
        pointEntitySigmobPrivacy.setCategory(PointCategory.PRIVACY);
        pointEntitySigmobPrivacy.commit();
    }

    private void a(boolean z) {
        PointEntitySigmobPrivacy pointEntitySigmobPrivacy = new PointEntitySigmobPrivacy();
        pointEntitySigmobPrivacy.setAc_type(PointType.GDPR_CONSENT);
        pointEntitySigmobPrivacy.setSub_category(PointCategory.ADULT);
        pointEntitySigmobPrivacy.setCategory(PointCategory.PRIVACY);
        pointEntitySigmobPrivacy.setIs_minor(z ? "0" : "1");
        pointEntitySigmobPrivacy.commit();
    }

    private void b(int i) {
        PointEntitySigmobPrivacy pointEntitySigmobPrivacy = new PointEntitySigmobPrivacy();
        pointEntitySigmobPrivacy.setAge_restricted(String.valueOf(i));
        pointEntitySigmobPrivacy.setAc_type(PointType.GDPR_CONSENT);
        pointEntitySigmobPrivacy.setSub_category("coppa");
        pointEntitySigmobPrivacy.setCategory(PointCategory.PRIVACY);
        pointEntitySigmobPrivacy.commit();
    }

    private void b(boolean z) {
        PointEntitySigmobPrivacy pointEntitySigmobPrivacy = new PointEntitySigmobPrivacy();
        pointEntitySigmobPrivacy.setAc_type(PointType.GDPR_CONSENT);
        pointEntitySigmobPrivacy.setSub_category(PointCategory.PERSONALIZED);
        pointEntitySigmobPrivacy.setCategory(PointCategory.PRIVACY);
        pointEntitySigmobPrivacy.setIs_unpersonalized(z ? "0" : "1");
        pointEntitySigmobPrivacy.commit();
    }

    private void j() {
        PointEntitySigmobPrivacy pointEntitySigmobPrivacy = new PointEntitySigmobPrivacy();
        pointEntitySigmobPrivacy.setUser_consent(String.valueOf(g()));
        String str = "1";
        pointEntitySigmobPrivacy.setGdpr_region(h() ? "1" : "0");
        try {
            if (!WindAdConsentInformation.getInstance(com.sigmob.sdk.b.e()).isRequestLocationInEeaOrUnknown()) {
                str = "0";
            }
            pointEntitySigmobPrivacy.setGdpr_dialog_region(str);
        } catch (Throwable unused) {
        }
        pointEntitySigmobPrivacy.setSub_category(PointCategory.CONSENT);
        pointEntitySigmobPrivacy.setCategory("gdpr");
        pointEntitySigmobPrivacy.setAc_type(PointType.GDPR_CONSENT);
        pointEntitySigmobPrivacy.commit();
    }

    public void a(int i, boolean z) {
        this.d = i;
        SharedPreferences.Editor edit = com.sigmob.sdk.base.utils.g.a().edit();
        edit.putInt("user_age", this.d);
        edit.apply();
        if (z) {
            a(i);
        }
    }

    public void a(Boolean bool) {
        if (bool != null) {
            SharedPreferences.Editor edit = com.sigmob.sdk.base.utils.g.a().edit();
            edit.putBoolean("gdpr_region", bool.booleanValue());
            edit.apply();
            this.f = bool.booleanValue();
        }
        if (i()) {
            j();
            b(this.f402c);
            a(this.a);
            b(this.b);
            a(this.d);
        }
    }

    public void a(boolean z, boolean z2) {
        SigmobLog.i("PrivacyManager -> setAdult " + z);
        this.a = z;
        if (z2) {
            a(z);
        }
    }

    public int b() {
        return this.d;
    }

    public void b(int i, boolean z) {
        this.b = i;
        SharedPreferences.Editor edit = com.sigmob.sdk.base.utils.g.a().edit();
        edit.putInt("age_restricted_status", this.b);
        edit.apply();
        if (z) {
            b(i);
        }
    }

    public void b(boolean z, boolean z2) {
        if (this.h == null) {
            this.h = Boolean.valueOf(z);
        }
        SigmobLog.i("PrivacyManager -> setPersonalized " + z);
        this.f402c = z;
        if (z2) {
            b(z);
        }
    }

    public int c() {
        return this.b;
    }

    public void c(int i, boolean z) {
        this.g = i;
        SharedPreferences.Editor edit = com.sigmob.sdk.base.utils.g.a().edit();
        edit.putInt("consent_status", i);
        edit.apply();
        if (z) {
            j();
        }
    }

    public boolean d() {
        return this.a;
    }

    public boolean e() {
        return this.f402c;
    }

    public boolean f() {
        Boolean bool = this.h;
        return bool == null || bool.booleanValue() != this.f402c;
    }

    public int g() {
        return this.g;
    }

    public boolean h() {
        return this.f;
    }

    public boolean i() {
        return (g() == 1) || !h();
    }
}
