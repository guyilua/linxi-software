package com.sigmob.sdk.base.common;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.ao;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.AndroidMarket;
import com.sigmob.windad.WindAds;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.EnumSet;
import java.util.Iterator;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class an {
    private static final b a = new b() { // from class: com.sigmob.sdk.base.common.an.1
        @Override // com.sigmob.sdk.base.common.an.b
        public void a(String str, am amVar) {
        }

        @Override // com.sigmob.sdk.base.common.an.b
        public void b(String str, am amVar) {
        }
    };
    private static final c b = new c() { // from class: com.sigmob.sdk.base.common.an.2
        @Override // com.sigmob.sdk.base.common.an.c
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.an.c
        public void b() {
        }

        @Override // com.sigmob.sdk.base.common.an.c
        public void c() {
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private final EnumSet<am> f372c;
    private final b d;
    private final b e;
    private final c f;
    private final BaseAdUnit g;
    private final boolean h;
    private boolean i;
    private boolean j;
    private boolean k;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        private EnumSet<am> a = EnumSet.of(am.NOOP);
        private b b = an.a;

        /* renamed from: c, reason: collision with root package name */
        private b f377c = an.a;
        private c d = an.b;
        private boolean e = false;
        private boolean f = false;
        private BaseAdUnit g;

        public a a(am amVar, am... amVarArr) {
            this.a = EnumSet.of(amVar, amVarArr);
            return this;
        }

        public a a(b bVar) {
            this.b = bVar;
            return this;
        }

        public a a(c cVar) {
            this.d = cVar;
            return this;
        }

        public a a(BaseAdUnit baseAdUnit) {
            this.g = baseAdUnit;
            return this;
        }

        public a a(boolean z) {
            this.e = z;
            return this;
        }

        public an a() {
            return new an(this.a, this.b, this.f377c, this.d, this.e, this.g, this.f);
        }

        public a b(b bVar) {
            this.f377c = bVar;
            return this;
        }

        public a b(boolean z) {
            this.f = z;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface b {
        void a(String str, am amVar);

        void b(String str, am amVar);
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface c {
        void a();

        void b();

        void c();
    }

    private an(EnumSet<am> enumSet, b bVar, b bVar2, c cVar, boolean z, BaseAdUnit baseAdUnit, boolean z2) {
        this.f372c = EnumSet.copyOf((EnumSet) enumSet);
        this.d = bVar;
        this.e = bVar2;
        this.f = cVar;
        this.h = z;
        this.g = baseAdUnit;
        this.i = false;
        this.j = false;
        this.k = z2;
    }

    private void a(String str, am amVar, String str2, Throwable th) {
        Preconditions.NoThrow.checkNotNull(str2);
        if (amVar == null) {
            amVar = am.NOOP;
        }
        SigmobLog.d(str2, th);
        this.d.b(str, amVar);
    }

    private boolean b(final Context context, String str) {
        am amVar = am.NOOP;
        Iterator it = this.f372c.iterator();
        final String str2 = null;
        while (it.hasNext()) {
            final am amVar2 = (am) it.next();
            String a2 = amVar2.a(this.g);
            if (!TextUtils.isEmpty(str) && this.g.getInteractionType() != 7) {
                a2 = str;
            }
            if (!TextUtils.isEmpty(a2)) {
                str2 = this.g.getMacroCommon().macroProcess(a2);
                try {
                    final Uri parse = Uri.parse(str2);
                    AndroidMarket androidMarket = this.g.getAndroidMarket();
                    if (amVar2 != am.FOLLOW_DEEP_LINK || !parse.getScheme().equalsIgnoreCase(BaseConstants.SCHEME_MARKET) || androidMarket == null || TextUtils.isEmpty(androidMarket.market_url)) {
                        if (amVar2.a(parse, this.g.getInteractionType())) {
                            if (!this.k && am.OPEN_WITH_BROWSER == amVar2) {
                                ao.a(str2, new ao.a() { // from class: com.sigmob.sdk.base.common.an.3
                                    @Override // com.sigmob.sdk.base.common.ao.a
                                    public void a(final String str3) {
                                        final am amVar3 = amVar2;
                                        if (!str3.toLowerCase().startsWith("http")) {
                                            amVar3 = am.FOLLOW_DEEP_LINK;
                                        }
                                        try {
                                            amVar3.a(context, Uri.parse(str3), this, an.this.g);
                                            WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.base.common.an.3.1
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    try {
                                                        an.this.d.a(str3, amVar3);
                                                    } catch (Throwable unused) {
                                                    }
                                                }
                                            });
                                        } catch (Exception unused) {
                                            WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.base.common.an.3.2
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    try {
                                                        an.this.d.b(str3, amVar3);
                                                    } catch (Throwable unused2) {
                                                    }
                                                }
                                            });
                                        }
                                    }

                                    @Override // com.sigmob.sdk.base.common.ao.a
                                    public void a(String str3, Throwable th) {
                                        try {
                                            amVar2.a(context, parse, this, an.this.g);
                                            WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.base.common.an.3.3
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    try {
                                                        b bVar = an.this.d;
                                                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                                        bVar.a(str2, amVar2);
                                                    } catch (Throwable unused) {
                                                    }
                                                }
                                            });
                                        } catch (Exception unused) {
                                            WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.base.common.an.3.4
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    try {
                                                        b bVar = an.this.d;
                                                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                                        bVar.b(str2, amVar2);
                                                    } catch (Throwable unused2) {
                                                    }
                                                }
                                            });
                                        }
                                    }
                                });
                                return true;
                            }
                            amVar2.a(context, parse, this, this.g);
                            WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.base.common.an.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    an.this.d.a(str2, amVar2);
                                }
                            });
                            return true;
                        }
                    }
                } catch (Throwable unused) {
                    this.d.b(str2, amVar2);
                }
            }
        }
        try {
            a(str2, amVar, "Link ignored. Unable to handle url: ", null);
            return false;
        } catch (Throwable th) {
            SigmobLog.e("handleResolvedUrl eroor", th);
            return false;
        }
    }

    c a() {
        return this.f;
    }

    public void a(Context context, String str) {
        Preconditions.NoThrow.checkNotNull(context);
        b(context, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.h;
    }
}
