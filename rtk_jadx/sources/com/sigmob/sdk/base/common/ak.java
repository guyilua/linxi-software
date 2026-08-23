package com.sigmob.sdk.base.common;

import android.text.TextUtils;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.windad.WindAdRequest;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ak {
    private String a;
    private String b;

    /* renamed from: c, reason: collision with root package name */
    private String f368c;
    private String d;
    private String e = "5";
    private WindAdRequest f;
    private LoadAdRequest g;
    private ae.a h;
    private BaseAdUnit i;

    private ak() {
    }

    public static ak a(String str) {
        ak akVar = new ak();
        akVar.a = str;
        return akVar;
    }

    public ak a(ae.a aVar) {
        this.h = aVar;
        return this;
    }

    public ak a(BaseAdUnit baseAdUnit) {
        this.i = baseAdUnit;
        return this;
    }

    public ak a(LoadAdRequest loadAdRequest) {
        this.g = loadAdRequest;
        return this;
    }

    public ak a(WindAdRequest windAdRequest) {
        this.f = windAdRequest;
        return this;
    }

    public void a() {
        PointEntitySigmob pointEntitySigmob = new PointEntitySigmob();
        pointEntitySigmob.setAc_type(this.e);
        pointEntitySigmob.setCategory(this.a);
        pointEntitySigmob.setSub_category(this.b);
        if (!TextUtils.isEmpty(this.f368c)) {
            pointEntitySigmob.setAdtype(this.f368c);
        }
        ae.a(this.a, this.b, pointEntitySigmob, this.f);
        ae.a(this.a, this.b, pointEntitySigmob, this.g);
        ae.a(this.a, this.b, this.i, pointEntitySigmob);
        ae.a aVar = this.h;
        if (aVar != null) {
            aVar.a(pointEntitySigmob);
        }
        ae.a(pointEntitySigmob);
        pointEntitySigmob.commit();
    }

    public ak b(String str) {
        this.f368c = str;
        return this;
    }

    public ak c(String str) {
        this.f368c = this.f368c;
        return this;
    }

    public ak d(String str) {
        this.b = str;
        return this;
    }

    public ak e(String str) {
        this.d = str;
        return this;
    }
}
