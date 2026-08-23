package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class c extends AsyncTask<Void, Void, a> {
    private String a;
    private String b;

    /* renamed from: c, reason: collision with root package name */
    private OAuthListener f921c;
    private int d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class a {
        public OAuthErrCode a;
        public String b;

        /* renamed from: c, reason: collision with root package name */
        public int f922c;

        a() {
        }
    }

    public c(String str, OAuthListener oAuthListener) {
        this.a = str;
        this.f921c = oAuthListener;
        this.b = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x00b5. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:29:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0168 A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected com.tencent.mm.opensdk.diffdev.a.c.a doInBackground(java.lang.Void[] r14) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.diffdev.a.c.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(a aVar) {
        a aVar2 = aVar;
        this.f921c.onAuthFinish(aVar2.a, aVar2.b);
    }
}
