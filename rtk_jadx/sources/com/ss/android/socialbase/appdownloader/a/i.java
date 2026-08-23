package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class i extends a {
    private String d;
    private String e;

    public i(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str, String str2, String str3) {
        super(context, aVar, str);
        this.d = str2;
        this.e = str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a3  */
    @Override // com.ss.android.socialbase.appdownloader.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.content.Intent b() {
        /*
            r10 = this;
            com.ss.android.socialbase.downloader.g.a r0 = r10.b
            java.lang.String r1 = "s"
            java.lang.String r0 = r0.c(r1)
            com.ss.android.socialbase.downloader.g.a r1 = r10.b
            java.lang.String r2 = "ak"
            java.lang.String r1 = r1.c(r2)
            java.lang.String r1 = com.ss.android.socialbase.appdownloader.f.c.a(r1, r0)
            com.ss.android.socialbase.downloader.g.a r2 = r10.b
            java.lang.String r3 = "am"
            java.lang.String r2 = r2.c(r3)
            java.lang.String r2 = com.ss.android.socialbase.appdownloader.f.c.a(r2, r0)
            com.ss.android.socialbase.downloader.g.a r3 = r10.b
            java.lang.String r4 = "an"
            java.lang.String r3 = r3.c(r4)
            java.lang.String r3 = com.ss.android.socialbase.appdownloader.f.c.a(r3, r0)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            r5 = 0
            if (r4 != 0) goto Ld2
            java.lang.String r4 = ","
            java.lang.String[] r6 = r3.split(r4)
            int r6 = r6.length
            r7 = 2
            if (r6 == r7) goto L3f
            goto Ld2
        L3f:
            java.lang.String[] r3 = r3.split(r4)
            com.ss.android.socialbase.downloader.g.a r6 = r10.b
            java.lang.String r8 = "al"
            java.lang.String r6 = r6.c(r8)
            java.lang.String r6 = com.ss.android.socialbase.appdownloader.f.c.a(r6, r0)
            com.ss.android.socialbase.downloader.g.a r8 = r10.b
            java.lang.String r9 = "ao"
            java.lang.String r8 = r8.c(r9)
            java.lang.String r0 = com.ss.android.socialbase.appdownloader.f.c.a(r8, r0)
            boolean r8 = android.text.TextUtils.isEmpty(r0)
            if (r8 != 0) goto Ld2
            java.lang.String[] r8 = r0.split(r4)
            int r8 = r8.length
            if (r8 == r7) goto L69
            goto Ld2
        L69:
            java.lang.String[] r0 = r0.split(r4)
            com.ss.android.socialbase.downloader.g.a r4 = r10.b
            java.lang.String r7 = "download_dir"
            org.json.JSONObject r4 = r4.d(r7)
            r7 = 1
            r8 = 0
            if (r4 == 0) goto Lac
            java.lang.String r5 = "dir_name"
            java.lang.String r4 = r4.optString(r5)
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L98
            java.lang.String r5 = "%s"
            boolean r5 = r4.contains(r5)
            if (r5 == 0) goto L98
            java.lang.Object[] r5 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L98
            java.lang.String r9 = r10.e     // Catch: java.lang.Throwable -> L98
            r5[r8] = r9     // Catch: java.lang.Throwable -> L98
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch: java.lang.Throwable -> L98
            goto L9a
        L98:
            java.lang.String r4 = r10.e
        L9a:
            r5 = r4
            int r4 = r5.length()
            r9 = 255(0xff, float:3.57E-43)
            if (r4 <= r9) goto Lac
            int r4 = r5.length()
            int r4 = r4 - r9
            java.lang.String r5 = r6.substring(r4)
        Lac:
            android.content.Intent r4 = new android.content.Intent
            r4.<init>(r1)
            r1 = r0[r8]
            r0 = r0[r7]
            r4.putExtra(r1, r0)
            java.lang.String r0 = r10.d
            r4.putExtra(r2, r0)
            r4.putExtra(r6, r5)
            r0 = r3[r8]
            r1 = r3[r7]
            int r1 = java.lang.Integer.parseInt(r1)
            r4.putExtra(r0, r1)
            r0 = 268468224(0x10008000, float:2.5342157E-29)
            r4.addFlags(r0)
            return r4
        Ld2:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.a.i.b():android.content.Intent");
    }
}
