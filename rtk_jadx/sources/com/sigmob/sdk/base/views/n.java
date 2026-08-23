package com.sigmob.sdk.base.views;

import com.czhj.sdk.common.utils.Preconditions;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class n implements Serializable {
    private static final List<String> a = Arrays.asList("image/jpeg", "image/png", "image/bmp", "image/gif");
    private static final List<String> b = Arrays.asList("application/x-javascript");
    private static final long serialVersionUID = 0;

    /* renamed from: c, reason: collision with root package name */
    private final String f477c;
    private final b d;
    private final a e;
    private final int f;
    private final int g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.sigmob.sdk.base.views.n$1, reason: invalid class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.IFRAME_RESOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.HTML_RESOURCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.STATIC_RESOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.NATIVE_RESOURCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.URL_RESOURCE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum a {
        NONE,
        IMAGE,
        JAVASCRIPT
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum b {
        STATIC_RESOURCE,
        HTML_RESOURCE,
        IFRAME_RESOURCE,
        NATIVE_RESOURCE,
        URL_RESOURCE
    }

    public n(String str, b bVar, a aVar, int i, int i2) {
        Preconditions.NoThrow.checkNotNull(str);
        Preconditions.NoThrow.checkNotNull(bVar);
        Preconditions.NoThrow.checkNotNull(aVar);
        this.f477c = str;
        this.d = bVar;
        this.e = aVar;
        this.f = i;
        this.g = i2;
    }

    public String a() {
        return this.f477c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        if (r0 != 5) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            int[] r0 = com.sigmob.sdk.base.views.n.AnonymousClass1.a
            com.sigmob.sdk.base.views.n$b r1 = r5.d
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 1
            java.lang.String r2 = "CreativeType.JAVASCRIPT"
            java.lang.String r3 = "CreativeType.IMAGE"
            r4 = 0
            if (r0 == r1) goto L39
            r1 = 2
            if (r0 == r1) goto L39
            r1 = 3
            if (r0 == r1) goto L1f
            r1 = 4
            if (r0 == r1) goto L39
            r1 = 5
            if (r0 == r1) goto L39
            goto L52
        L1f:
            com.sigmob.sdk.base.views.n$a r0 = com.sigmob.sdk.base.views.n.a.IMAGE
            com.sigmob.sdk.base.views.n$a r1 = r5.e
            if (r0 != r1) goto L30
            com.czhj.sdk.logger.SigmobLog.d(r3)
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L2f
            return r7
        L2f:
            return r6
        L30:
            com.sigmob.sdk.base.views.n$a r6 = com.sigmob.sdk.base.views.n.a.JAVASCRIPT
            if (r6 != r1) goto L38
            com.czhj.sdk.logger.SigmobLog.d(r2)
            return r7
        L38:
            return r4
        L39:
            com.sigmob.sdk.base.views.n$a r0 = com.sigmob.sdk.base.views.n.a.IMAGE
            com.sigmob.sdk.base.views.n$a r1 = r5.e
            if (r0 != r1) goto L4a
            com.czhj.sdk.logger.SigmobLog.d(r3)
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L49
            return r6
        L49:
            return r4
        L4a:
            com.sigmob.sdk.base.views.n$a r6 = com.sigmob.sdk.base.views.n.a.JAVASCRIPT
            if (r6 != r1) goto L52
            com.czhj.sdk.logger.SigmobLog.d(r2)
            return r7
        L52:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.views.n.a(java.lang.String, java.lang.String):java.lang.String");
    }

    public void a(o oVar) {
        StringBuilder sb;
        String str;
        String str2;
        String str3;
        Preconditions.NoThrow.checkNotNull(oVar);
        int i = AnonymousClass1.a[this.d.ordinal()];
        if (i == 1) {
            sb = new StringBuilder();
            sb.append("<iframe frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" style=\"border: 0px; margin: 0px;\" width=\"");
            sb.append(this.f);
            sb.append("\" height=\"");
            sb.append(this.g);
            sb.append("\" src=\"");
            sb.append(this.f477c);
            str = "\"></iframe>";
        } else {
            if (i == 2) {
                str2 = this.f477c;
                oVar.a(str2);
            }
            if (i != 3) {
                if (i != 4) {
                    if (i != 5) {
                        return;
                    }
                } else if (!this.f477c.toLowerCase().startsWith("file://")) {
                    str3 = "file://" + this.f477c;
                    oVar.loadUrl(str3);
                    return;
                }
                str3 = this.f477c;
                oVar.loadUrl(str3);
                return;
            }
            a aVar = this.e;
            if (aVar == a.IMAGE) {
                sb = new StringBuilder();
                sb.append("<html><head></head><body style=\"margin:0;padding:0\"><img src=\"");
                sb.append(this.f477c);
                str = "\" width=\"100%\" style=\"max-width:100%;max-height:100%;\" /></body></html>";
            } else {
                if (aVar != a.JAVASCRIPT) {
                    return;
                }
                sb = new StringBuilder();
                sb.append("<script src=\"");
                sb.append(this.f477c);
                str = "\"></script>";
            }
        }
        sb.append(str);
        str2 = sb.toString();
        oVar.a(str2);
    }

    public b b() {
        return this.d;
    }

    public a c() {
        return this.e;
    }
}
