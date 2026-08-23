package com.sigmob.sdk.base.common;

import android.text.TextUtils;
import android.util.Log;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.windad.WindAdRequest;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e implements h.b {
    private final List<BaseAdUnit> b;

    /* renamed from: c, reason: collision with root package name */
    private final h.b f382c;
    private LoadAdRequest d;
    private String a = "AdListCacheManger";
    private List<BaseAdUnit> e = new ArrayList();

    public e(List<BaseAdUnit> list, h.b bVar, LoadAdRequest loadAdRequest) {
        this.b = list;
        this.f382c = bVar;
        this.d = loadAdRequest;
    }

    @Override // com.sigmob.sdk.base.common.h.b
    public void a(BaseAdUnit baseAdUnit) {
        h.b bVar = this.f382c;
        if (bVar != null) {
            bVar.a(baseAdUnit);
        }
    }

    @Override // com.sigmob.sdk.base.common.h.b
    public void a(BaseAdUnit baseAdUnit, String str) {
        if (baseAdUnit != this.b.get(0)) {
            com.sigmob.sdk.base.network.g.a(baseAdUnit, TextUtils.isEmpty(str) ? a.B : a.C);
            ae.a(PointCategory.LOADEND, TextUtils.isEmpty(str) ? "1" : "0", baseAdUnit, (WindAdRequest) null, this.d, (ae.a) null);
            return;
        }
        h.b bVar = this.f382c;
        if (bVar != null) {
            bVar.a(this.b.get(0), str);
        }
        Log.d(this.a, "--------loadEnd--------" + this.e.size());
    }

    public boolean a(boolean z) {
        List<BaseAdUnit> list = this.b;
        if (list != null) {
            if (z) {
                BaseAdUnit baseAdUnit = list.get(0);
                if (baseAdUnit.getPlayMode() == 2) {
                    this.e.add(baseAdUnit);
                    h.g().a(baseAdUnit, this);
                }
            } else {
                for (int i = 0; i < this.b.size(); i++) {
                    BaseAdUnit baseAdUnit2 = this.b.get(i);
                    if (baseAdUnit2.getPlayMode() != 2) {
                        this.e.add(baseAdUnit2);
                        baseAdUnit2.setCatchVideo(true);
                        h.g().a(baseAdUnit2, this);
                    }
                }
            }
            Log.d(this.a, "--------cache--------" + this.e.size());
        }
        return this.e.size() > 0;
    }
}
