package com.sigmob.sdk.videoAd;

import android.content.Context;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.wire.Wire;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.config.SigmobDialogSetting;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.models.rtb.RvAdSetting;
import com.sigmob.sdk.base.views.n;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.uc.crashsdk.export.LogType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a extends com.sigmob.sdk.base.common.i implements Serializable {
    protected static final long serialVersionUID = 2;
    protected i k;
    protected i l;
    private int t;
    private int w;
    private boolean x;
    protected float n = 1.0f;
    protected int o = -1000;
    protected int p = 100;
    protected boolean q = false;
    private int s = -1;
    private boolean u = false;
    private e v = null;
    private final List<f> r = new ArrayList();
    protected boolean m = false;

    private a() {
    }

    private void c(boolean z) {
        this.m = z;
    }

    public static a f(BaseAdUnit baseAdUnit) {
        a aVar = new a();
        aVar.c(baseAdUnit.getAd_type() == 1);
        aVar.d(baseAdUnit.getMaterial().video_reciprocal_millisecond.intValue());
        aVar.b(baseAdUnit.getMaterial().creative_type.intValue() != com.sigmob.sdk.base.common.m.CreativeTypeVideo_transparent_html.a());
        RvAdSetting rvAdSetting = baseAdUnit.getRvAdSetting();
        SigmobDialogSetting u = com.sigmob.sdk.base.l.a().u();
        aVar.a(u != null ? new e((String) Wire.get(u.title, ""), (String) Wire.get(u.body_text, ""), (String) Wire.get(u.cancel_button_text, ""), (String) Wire.get(u.close_button_text, "")) : new e(com.sigmob.sdk.base.g.l(), com.sigmob.sdk.base.g.k(), com.sigmob.sdk.base.g.n(), com.sigmob.sdk.base.g.m()));
        if (rvAdSetting != null) {
            aVar.a(rvAdSetting.enable_exit_on_video_close.booleanValue());
            aVar.a(rvAdSetting.finished.floatValue());
            aVar.c(rvAdSetting.end_time.intValue());
        }
        aVar.b(baseAdUnit);
        return aVar;
    }

    public static i g(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null) {
            return null;
        }
        MaterialMeta material = baseAdUnit.getMaterial();
        return new i(LogType.UNEXP_OTHER, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, baseAdUnit.getInteractionType(), material.landing_page, material.deeplink_url, new com.sigmob.sdk.base.views.n(baseAdUnit.resourcePath(), baseAdUnit.getCreativeResourceType(), material.click_type.intValue() == 2 ? n.a.IMAGE : n.a.JAVASCRIPT, 720, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT));
    }

    public void a(float f) {
        this.n = f;
    }

    public void a(Context context, int i) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    public void a(Context context, int i, int i2, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    @Override // com.sigmob.sdk.base.common.i
    public void a(Context context, int i, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    public void a(e eVar) {
        this.v = eVar;
    }

    @Override // com.sigmob.sdk.base.common.i
    public void a(String str) {
        this.h = str;
    }

    public void a(boolean z) {
        this.u = z;
    }

    public void a(boolean z, int i, int i2, BaseAdUnit baseAdUnit) {
    }

    public int b(int i) {
        int i2 = this.w;
        return (i2 == 0 || i2 * 1000 > i) ? i : i2 * 1000;
    }

    @Override // com.sigmob.sdk.base.common.i
    public String b() {
        return this.h;
    }

    public void b(Context context, int i) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    public void b(Context context, int i, int i2, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    @Override // com.sigmob.sdk.base.common.i
    public void b(Context context, int i, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    public void b(boolean z) {
        this.q = z;
    }

    public void c(int i) {
        this.w = i;
    }

    public void c(Context context, int i, int i2, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    @Override // com.sigmob.sdk.base.common.i
    public void c(String str) {
        if (str != null) {
            this.e = str;
        }
    }

    @Override // com.sigmob.sdk.base.common.i
    public String d() {
        return this.e;
    }

    public void d(int i) {
        if (i != 0) {
            this.o = i;
        }
    }

    @Override // com.sigmob.sdk.base.common.i
    public void d(String str) {
        if (str != null) {
            this.f = str;
        }
    }

    public int e(int i) {
        return (int) (i * (this.p / 100.0f));
    }

    @Override // com.sigmob.sdk.base.common.i
    public String e() {
        return this.f;
    }

    @Override // com.sigmob.sdk.base.common.i
    public void e(String str) {
        if (str != null) {
            this.g = str;
        }
    }

    @Override // com.sigmob.sdk.base.common.i
    public String f() {
        return this.g;
    }

    public void f(int i) {
        this.s = i;
    }

    public int l() {
        return this.w;
    }

    public boolean m() {
        return this.u;
    }

    public float n() {
        return this.n;
    }

    public int o() {
        return this.o;
    }

    public boolean p() {
        return this.q;
    }

    public e q() {
        return this.v;
    }

    public int r() {
        return 0;
    }

    public boolean s() {
        return this.m;
    }

    public int t() {
        return this.s;
    }
}
