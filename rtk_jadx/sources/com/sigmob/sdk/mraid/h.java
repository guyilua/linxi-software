package com.sigmob.sdk.mraid;

import android.view.View;
import android.widget.FrameLayout;
import com.czhj.sdk.common.utils.Dips;
import com.sigmob.sdk.base.common.aa;
import com.sigmob.sdk.base.views.v;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class h extends j {

    /* renamed from: c, reason: collision with root package name */
    private int f565c;
    private v d;
    private aa.a e;
    private com.sigmob.sdk.mraid2.i f;

    /* JADX WARN: Removed duplicated region for block: B:10:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h(android.content.Context r4, final java.lang.String r5, int r6) {
        /*
            r3 = this;
            r3.<init>(r5)
            r3.f565c = r6
            r0 = 3
            r1 = 1
            if (r6 == 0) goto L61
            if (r6 == r1) goto L49
            r2 = 2
            if (r6 == r2) goto L2e
            if (r6 == r0) goto L16
            java.lang.String r4 = "MMotionView type is not support"
            com.czhj.sdk.logger.SigmobLog.e(r4)
            goto L7b
        L16:
            com.sigmob.sdk.base.views.an r6 = new com.sigmob.sdk.base.views.an
            r6.<init>(r4)
            r3.d = r6
            com.sigmob.sdk.base.common.aa$c r4 = new com.sigmob.sdk.base.common.aa$c
            android.content.Context r6 = com.sigmob.sdk.b.e()
            com.sigmob.sdk.mraid.h$4 r2 = new com.sigmob.sdk.mraid.h$4
            r2.<init>()
            com.sigmob.sdk.base.common.aa$d r5 = com.sigmob.sdk.base.common.aa.d.SWING
            r4.<init>(r6, r2, r5)
            goto L45
        L2e:
            com.sigmob.sdk.base.views.ak r6 = new com.sigmob.sdk.base.views.ak
            r6.<init>(r4)
            r3.d = r6
            com.sigmob.sdk.base.common.aa$c r4 = new com.sigmob.sdk.base.common.aa$c
            android.content.Context r6 = com.sigmob.sdk.b.e()
            com.sigmob.sdk.mraid.h$3 r2 = new com.sigmob.sdk.mraid.h$3
            r2.<init>()
            com.sigmob.sdk.base.common.aa$d r5 = com.sigmob.sdk.base.common.aa.d.SLOPE
            r4.<init>(r6, r2, r5)
        L45:
            r4.c(r1)
            goto L79
        L49:
            com.sigmob.sdk.base.views.au r6 = new com.sigmob.sdk.base.views.au
            r6.<init>(r4)
            r3.d = r6
            com.sigmob.sdk.base.common.aa$c r4 = new com.sigmob.sdk.base.common.aa$c
            android.content.Context r6 = com.sigmob.sdk.b.e()
            com.sigmob.sdk.mraid.h$2 r1 = new com.sigmob.sdk.mraid.h$2
            r1.<init>()
            com.sigmob.sdk.base.common.aa$d r5 = com.sigmob.sdk.base.common.aa.d.WRING
            r4.<init>(r6, r1, r5)
            goto L79
        L61:
            com.sigmob.sdk.base.views.ac r6 = new com.sigmob.sdk.base.views.ac
            r6.<init>(r4)
            r3.d = r6
            com.sigmob.sdk.base.common.aa$e r4 = new com.sigmob.sdk.base.common.aa$e
            android.content.Context r6 = com.sigmob.sdk.b.e()
            com.sigmob.sdk.mraid.h$1 r2 = new com.sigmob.sdk.mraid.h$1
            r2.<init>()
            r4.<init>(r6, r2)
            r4.c(r1)
        L79:
            r3.e = r4
        L7b:
            com.sigmob.sdk.base.views.v r4 = r3.d
            if (r4 == 0) goto L82
            r4.a()
        L82:
            com.sigmob.sdk.base.common.aa$a r4 = r3.e
            r4.a(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.mraid.h.<init>(android.content.Context, java.lang.String, int):void");
    }

    public h(String str) {
        super(str);
    }

    public void a() {
        aa.a aVar = this.e;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void a(int i) {
        aa.a aVar = this.e;
        if (aVar != null) {
            if (i == 0) {
                i = 3;
            } else if (i == 2) {
                i = 1;
            } else if (i == 1) {
                i = 2;
            }
            aVar.a(i);
        }
    }

    public void a(com.sigmob.sdk.mraid2.i iVar) {
        this.f = iVar;
    }

    public void a(JSONObject jSONObject) {
        if (this.d != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("frame");
            int optDouble = (int) optJSONObject.optDouble("x", 0.0d);
            int optDouble2 = (int) optJSONObject.optDouble("y", 0.0d);
            int optDouble3 = (int) optJSONObject.optDouble("w", -1.0d);
            int optDouble4 = (int) optJSONObject.optDouble("h", -1.0d);
            if (optDouble3 > 0) {
                optDouble3 = Dips.dipsToIntPixels(optDouble3, com.sigmob.sdk.b.e());
            }
            if (optDouble4 > 0) {
                optDouble4 = Dips.dipsToIntPixels(optDouble4, com.sigmob.sdk.b.e());
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(optDouble3, optDouble4);
            this.d.setX(Dips.dipsToIntPixels(optDouble, com.sigmob.sdk.b.e()));
            this.d.setY(Dips.dipsToIntPixels(optDouble2, com.sigmob.sdk.b.e()));
            this.d.setLayoutParams(layoutParams);
            this.d.requestLayout();
        }
    }

    public void a(boolean z) {
        v vVar = this.d;
        if (vVar != null) {
            if (z) {
                vVar.setVisibility(4);
                this.e.b();
            } else {
                vVar.setVisibility(0);
                this.e.a();
            }
        }
    }

    @Override // com.sigmob.sdk.mraid.j
    public View b() {
        return this.d;
    }

    public void b(int i) {
        aa.a aVar = this.e;
        if (aVar != null) {
            aVar.b(i);
        }
    }

    @Override // com.sigmob.sdk.mraid.j
    public void c() {
        v vVar = this.d;
        if (vVar != null) {
            com.sigmob.sdk.base.utils.f.a(vVar);
            this.d = null;
        }
        aa.a aVar = this.e;
        if (aVar != null) {
            aVar.c();
        }
    }
}
