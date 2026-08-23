package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ae;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.downloader.s;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f {
    private boolean A;
    private int C;
    private boolean D;
    private String E;
    private boolean G;
    private boolean H;
    private boolean I;
    private int L;
    private x N;
    private n O;
    private com.ss.android.socialbase.appdownloader.c.e P;
    private IDownloadFileUriProvider Q;
    private r R;
    private boolean S;
    private ae T;
    private boolean U;
    private JSONObject V;
    private String W;
    private int Y;
    private long Z;
    private Activity a;
    private int aa;
    private boolean ab;
    private String ad;
    private String af;
    private int[] ag;
    private Context b;

    /* renamed from: c, reason: collision with root package name */
    private String f814c;
    private List<String> d;
    private String e;
    private String f;
    private String g;
    private List<com.ss.android.socialbase.downloader.model.c> h;
    private IDownloadListener m;
    private IDownloadListener n;
    private String o;
    private boolean q;
    private com.ss.android.socialbase.downloader.downloader.g r;
    private com.ss.android.socialbase.downloader.downloader.h s;
    private s t;
    private com.ss.android.socialbase.downloader.notification.a u;
    private boolean v;
    private boolean w;
    private String x;
    private String y;
    private long z;
    private boolean i = true;
    private boolean j = false;
    private boolean k = true;
    private boolean l = false;
    private String p = AdBaseConstants.MIME_APK;
    private int B = 5;
    private boolean F = true;
    private EnqueueType J = EnqueueType.ENQUEUE_NONE;
    private int K = 150;
    private boolean M = true;
    private List<m> X = new ArrayList();
    private boolean ac = true;
    private boolean ae = true;

    public f(@NonNull Context context, @NonNull String str) {
        this.b = context.getApplicationContext();
        this.f814c = str;
    }

    public boolean A() {
        return this.D;
    }

    public String B() {
        return this.E;
    }

    public boolean C() {
        return this.F;
    }

    public boolean D() {
        return this.G;
    }

    public s E() {
        return this.t;
    }

    public int F() {
        return this.K;
    }

    public int G() {
        return this.L;
    }

    public boolean H() {
        return this.H;
    }

    public boolean I() {
        return this.I;
    }

    public boolean J() {
        return this.M;
    }

    public boolean K() {
        return this.S;
    }

    public EnqueueType L() {
        return this.J;
    }

    public boolean M() {
        return this.A;
    }

    public String N() {
        return this.f;
    }

    public x O() {
        return this.N;
    }

    public n P() {
        return this.O;
    }

    public com.ss.android.socialbase.appdownloader.c.e Q() {
        return this.P;
    }

    public IDownloadFileUriProvider R() {
        return this.Q;
    }

    public ae S() {
        return this.T;
    }

    public List<m> T() {
        return this.X;
    }

    public String U() {
        return this.ad;
    }

    public boolean V() {
        return this.U;
    }

    public int W() {
        return this.Y;
    }

    public long X() {
        return this.Z;
    }

    public boolean Y() {
        return this.ae;
    }

    public String Z() {
        return this.af;
    }

    public Activity a() {
        return this.a;
    }

    public int[] aa() {
        return this.ag;
    }

    public boolean ab() {
        return this.ab;
    }

    public boolean ac() {
        return this.ac;
    }

    public String ad() {
        return this.W;
    }

    public List<String> ae() {
        return this.d;
    }

    public r af() {
        return this.R;
    }

    public JSONObject ag() {
        return this.V;
    }

    public Context b() {
        return this.b;
    }

    public String c() {
        return this.f814c;
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return this.g;
    }

    public List<com.ss.android.socialbase.downloader.model.c> f() {
        return this.h;
    }

    public boolean g() {
        return this.i;
    }

    public boolean h() {
        return this.j;
    }

    public boolean i() {
        return this.k;
    }

    public boolean j() {
        return this.l;
    }

    public IDownloadListener k() {
        return this.m;
    }

    public IDownloadListener l() {
        return this.n;
    }

    public String m() {
        return this.o;
    }

    public String n() {
        return this.p;
    }

    public boolean o() {
        return this.q;
    }

    public com.ss.android.socialbase.downloader.notification.a p() {
        return this.u;
    }

    public com.ss.android.socialbase.downloader.downloader.h q() {
        return this.s;
    }

    public com.ss.android.socialbase.downloader.downloader.g r() {
        return this.r;
    }

    public boolean s() {
        return this.v;
    }

    public boolean t() {
        return this.w;
    }

    public int u() {
        return this.aa;
    }

    public String v() {
        return this.x;
    }

    public String w() {
        return this.y;
    }

    public long x() {
        return this.z;
    }

    public int y() {
        return this.B;
    }

    public int z() {
        return this.C;
    }

    public void a(int i) {
        this.aa = i;
    }

    public f b(String str) {
        this.f = str;
        return this;
    }

    public f c(@NonNull String str) {
        this.g = str;
        return this;
    }

    public f d(String str) {
        this.ad = str;
        return this;
    }

    public f e(String str) {
        this.o = str;
        return this;
    }

    public f f(String str) {
        this.p = str;
        return this;
    }

    public f g(String str) {
        this.x = str;
        return this;
    }

    public f h(String str) {
        this.y = str;
        return this;
    }

    public f i(String str) {
        this.E = str;
        return this;
    }

    public f j(boolean z) {
        this.G = z;
        return this;
    }

    public f k(boolean z) {
        this.H = z;
        return this;
    }

    public f l(boolean z) {
        this.I = z;
        return this;
    }

    public f m(boolean z) {
        this.M = z;
        return this;
    }

    public f n(boolean z) {
        this.A = z;
        return this;
    }

    public f o(boolean z) {
        this.ab = z;
        return this;
    }

    public f p(boolean z) {
        this.ac = z;
        return this;
    }

    public f a(String str) {
        this.e = str;
        return this;
    }

    public f b(boolean z) {
        this.j = z;
        return this;
    }

    public f c(boolean z) {
        this.l = z;
        return this;
    }

    public f d(boolean z) {
        this.q = z;
        return this;
    }

    public f e(boolean z) {
        this.v = z;
        return this;
    }

    public f f(boolean z) {
        this.w = z;
        return this;
    }

    public f g(boolean z) {
        this.D = z;
        return this;
    }

    public f h(boolean z) {
        this.S = z;
        return this;
    }

    public f i(boolean z) {
        this.F = z;
        return this;
    }

    public f j(String str) {
        this.af = str;
        return this;
    }

    public f k(String str) {
        this.W = str;
        return this;
    }

    public f a(List<com.ss.android.socialbase.downloader.model.c> list) {
        this.h = list;
        return this;
    }

    public f b(int i) {
        this.B = i;
        return this;
    }

    public f c(int i) {
        this.C = i;
        return this;
    }

    public f d(int i) {
        this.K = i;
        return this;
    }

    public f e(int i) {
        this.L = i;
        return this;
    }

    public f f(int i) {
        this.Y = i;
        return this;
    }

    public f a(boolean z) {
        this.i = z;
        return this;
    }

    public f b(List<String> list) {
        this.d = list;
        return this;
    }

    public f a(IDownloadListener iDownloadListener) {
        this.m = iDownloadListener;
        return this;
    }

    public f a(long j) {
        this.z = j;
        return this;
    }

    public f a(EnqueueType enqueueType) {
        this.J = enqueueType;
        return this;
    }

    public f a(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.Q = iDownloadFileUriProvider;
        return this;
    }

    public f a(r rVar) {
        this.R = rVar;
        return this;
    }

    public f a(JSONObject jSONObject) {
        this.V = jSONObject;
        return this;
    }

    public f a(m mVar) {
        synchronized (this.X) {
            if (mVar != null) {
                if (!this.X.contains(mVar)) {
                    this.X.add(mVar);
                    return this;
                }
            }
            return this;
        }
    }
}
