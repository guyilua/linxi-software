package com.ss.android.socialbase.downloader.h;

import com.ss.android.socialbase.downloader.downloader.j;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.i;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b implements Runnable {
    private static final String a = b.class.getSimpleName();
    private com.ss.android.socialbase.downloader.model.b b;

    /* renamed from: c, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.model.b f868c;
    private com.ss.android.socialbase.downloader.downloader.e d;
    private final DownloadTask e;
    private DownloadInfo f;
    private final f g;
    private i h;
    private j i;
    private volatile boolean j;
    private volatile boolean k;
    private boolean l;

    public b(com.ss.android.socialbase.downloader.model.b bVar, DownloadTask downloadTask, f fVar) {
        this.l = false;
        this.f868c = bVar;
        this.e = downloadTask;
        if (downloadTask != null) {
            this.f = downloadTask.getDownloadInfo();
        }
        this.g = fVar;
        this.i = com.ss.android.socialbase.downloader.downloader.c.y();
        this.f868c.a(this);
    }

    private String c() {
        return this.f.getConnectionUrl();
    }

    private void d() {
        i iVar = this.h;
        if (iVar != null) {
            iVar.d();
            this.h = null;
        }
    }

    private boolean e() {
        return this.j || this.k;
    }

    public void a(long j, long j2) {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.d;
        if (eVar == null) {
            return;
        }
        eVar.a(j, j2);
    }

    public void b() {
        this.k = true;
        com.ss.android.socialbase.downloader.downloader.e eVar = this.d;
        if (eVar != null) {
            eVar.c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0017, code lost:
    
        r3.b.a(false);
     */
    @Override // java.lang.Runnable
    @android.annotation.SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            r3 = this;
            r0 = 10
            android.os.Process.setThreadPriority(r0)
            com.ss.android.socialbase.downloader.model.b r0 = r3.f868c
            r3.b = r0
        L9:
            r0 = 0
            com.ss.android.socialbase.downloader.model.b r1 = r3.b     // Catch: java.lang.Throwable -> L5b
            r1.a(r3)     // Catch: java.lang.Throwable -> L5b
            com.ss.android.socialbase.downloader.model.b r1 = r3.b     // Catch: java.lang.Throwable -> L5b
            boolean r1 = r3.a(r1)     // Catch: java.lang.Throwable -> L5b
            if (r1 != 0) goto L1d
            com.ss.android.socialbase.downloader.model.b r1 = r3.b     // Catch: java.lang.Throwable -> L5b
            r1.a(r0)     // Catch: java.lang.Throwable -> L5b
            goto L4b
        L1d:
            com.ss.android.socialbase.downloader.model.b r1 = r3.b     // Catch: java.lang.Throwable -> L5b
            r1.a(r0)     // Catch: java.lang.Throwable -> L5b
            boolean r1 = r3.e()     // Catch: java.lang.Throwable -> L5b
            if (r1 != 0) goto L4b
            com.ss.android.socialbase.downloader.h.f r1 = r3.g     // Catch: java.lang.Throwable -> L5b
            com.ss.android.socialbase.downloader.model.b r2 = r3.b     // Catch: java.lang.Throwable -> L5b
            int r2 = r2.s()     // Catch: java.lang.Throwable -> L5b
            com.ss.android.socialbase.downloader.model.b r1 = r1.a(r2)     // Catch: java.lang.Throwable -> L5b
            r3.b = r1     // Catch: java.lang.Throwable -> L5b
            boolean r1 = r3.e()     // Catch: java.lang.Throwable -> L5b
            if (r1 != 0) goto L4b
            com.ss.android.socialbase.downloader.model.b r1 = r3.b     // Catch: java.lang.Throwable -> L5b
            if (r1 == 0) goto L4b
            r1 = 50
            java.lang.Thread.sleep(r1)     // Catch: java.lang.Throwable -> L46
            goto L9
        L46:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L5b
            goto L9
        L4b:
            com.ss.android.socialbase.downloader.model.b r1 = r3.b
            if (r1 == 0) goto L52
            r1.a(r0)
        L52:
            r3.d()
            com.ss.android.socialbase.downloader.h.f r0 = r3.g
            r0.a(r3)
            return
        L5b:
            r1 = move-exception
            com.ss.android.socialbase.downloader.model.b r2 = r3.b
            if (r2 == 0) goto L63
            r2.a(r0)
        L63:
            r3.d()
            com.ss.android.socialbase.downloader.h.f r0 = r3.g
            r0.a(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.h.b.run():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0254 A[Catch: all -> 0x029f, TryCatch #16 {all -> 0x029f, blocks: (B:73:0x01d2, B:75:0x01dc, B:129:0x01e2, B:77:0x01eb, B:79:0x01f3, B:110:0x01f9, B:82:0x0204, B:84:0x0208, B:86:0x0210, B:88:0x0221, B:90:0x0247, B:92:0x024d, B:93:0x025a, B:95:0x0262, B:100:0x0254, B:103:0x022e, B:105:0x023a, B:114:0x026d, B:116:0x0275, B:118:0x027d, B:120:0x0285, B:122:0x028d, B:125:0x0296, B:139:0x01b4, B:144:0x01be, B:149:0x01c5), top: B:72:0x01d2, inners: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01d8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x00fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0195 A[Catch: all -> 0x01ae, BaseException -> 0x01b0, TRY_LEAVE, TryCatch #0 {BaseException -> 0x01b0, blocks: (B:56:0x0140, B:58:0x0147, B:62:0x0153, B:63:0x0159, B:165:0x0178, B:166:0x0186, B:180:0x0191, B:182:0x0195, B:193:0x01aa, B:194:0x01ad), top: B:31:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:196:? A[Catch: all -> 0x01ae, BaseException -> 0x01b0, SYNTHETIC, TRY_LEAVE, TryCatch #0 {BaseException -> 0x01b0, blocks: (B:56:0x0140, B:58:0x0147, B:62:0x0153, B:63:0x0159, B:165:0x0178, B:166:0x0186, B:180:0x0191, B:182:0x0195, B:193:0x01aa, B:194:0x01ad), top: B:31:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ff A[Catch: all -> 0x01b2, BaseException -> 0x01ce, TRY_ENTER, TryCatch #3 {BaseException -> 0x01ce, blocks: (B:23:0x004f, B:25:0x0059, B:28:0x0064, B:47:0x00f5, B:49:0x00ff, B:51:0x0103, B:53:0x0131, B:200:0x00db), top: B:22:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01dc A[Catch: all -> 0x029f, TRY_ENTER, TryCatch #16 {all -> 0x029f, blocks: (B:73:0x01d2, B:75:0x01dc, B:129:0x01e2, B:77:0x01eb, B:79:0x01f3, B:110:0x01f9, B:82:0x0204, B:84:0x0208, B:86:0x0210, B:88:0x0221, B:90:0x0247, B:92:0x024d, B:93:0x025a, B:95:0x0262, B:100:0x0254, B:103:0x022e, B:105:0x023a, B:114:0x026d, B:116:0x0275, B:118:0x027d, B:120:0x0285, B:122:0x028d, B:125:0x0296, B:139:0x01b4, B:144:0x01be, B:149:0x01c5), top: B:72:0x01d2, inners: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x024d A[Catch: all -> 0x029f, TryCatch #16 {all -> 0x029f, blocks: (B:73:0x01d2, B:75:0x01dc, B:129:0x01e2, B:77:0x01eb, B:79:0x01f3, B:110:0x01f9, B:82:0x0204, B:84:0x0208, B:86:0x0210, B:88:0x0221, B:90:0x0247, B:92:0x024d, B:93:0x025a, B:95:0x0262, B:100:0x0254, B:103:0x022e, B:105:0x023a, B:114:0x026d, B:116:0x0275, B:118:0x027d, B:120:0x0285, B:122:0x028d, B:125:0x0296, B:139:0x01b4, B:144:0x01be, B:149:0x01c5), top: B:72:0x01d2, inners: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0262 A[Catch: all -> 0x029f, TRY_ENTER, TRY_LEAVE, TryCatch #16 {all -> 0x029f, blocks: (B:73:0x01d2, B:75:0x01dc, B:129:0x01e2, B:77:0x01eb, B:79:0x01f3, B:110:0x01f9, B:82:0x0204, B:84:0x0208, B:86:0x0210, B:88:0x0221, B:90:0x0247, B:92:0x024d, B:93:0x025a, B:95:0x0262, B:100:0x0254, B:103:0x022e, B:105:0x023a, B:114:0x026d, B:116:0x0275, B:118:0x027d, B:120:0x0285, B:122:0x028d, B:125:0x0296, B:139:0x01b4, B:144:0x01be, B:149:0x01c5), top: B:72:0x01d2, inners: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x025e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a(com.ss.android.socialbase.downloader.model.b r31) {
        /*
            Method dump skipped, instructions count: 676
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.h.b.a(com.ss.android.socialbase.downloader.model.b):boolean");
    }

    public b(com.ss.android.socialbase.downloader.model.b bVar, DownloadTask downloadTask, i iVar, f fVar) {
        this(bVar, downloadTask, fVar);
        this.h = iVar;
    }

    private void a(com.ss.android.socialbase.downloader.model.b bVar, long j) {
        com.ss.android.socialbase.downloader.model.b e = bVar.d() ? bVar.e() : bVar;
        if (e != null) {
            if (e.h()) {
                this.i.a(e.k(), e.b(), j);
            }
            e.b(j);
            this.i.a(e.k(), e.s(), e.b(), j);
            return;
        }
        if (bVar.d()) {
            this.i.a(bVar.k(), bVar.s(), j);
        }
    }

    public void a() {
        this.j = true;
        com.ss.android.socialbase.downloader.downloader.e eVar = this.d;
        if (eVar != null) {
            eVar.b();
        }
    }
}
