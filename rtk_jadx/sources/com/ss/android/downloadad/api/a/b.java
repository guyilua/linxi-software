package com.ss.android.downloadad.api.a;

import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.k;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b implements a {
    private int A;
    private long B;
    private long C;
    private long D;
    private int E;
    private int F;
    private String G;
    private boolean H;
    private String I;
    private boolean J;
    private boolean K;
    private boolean L;
    private String M;
    private String N;
    private boolean O;
    private boolean P;
    private int Q;

    @AdBaseConstants.FunnelType
    private int R;
    private long S;
    private long T;
    private boolean U;
    private boolean V;
    private String W;
    private boolean X;
    private boolean Y;
    private boolean Z;
    protected boolean a;
    private long aa;
    private transient boolean ab;
    private boolean ac;
    private boolean ad;
    private boolean ae;
    private boolean af;
    private boolean ag;
    private boolean ah;
    private String ai;
    private long aj;
    protected boolean b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f708c;
    public final AtomicBoolean d;
    public final AtomicBoolean e;
    private long f;
    private long g;
    private String h;
    private int i;
    private String j;
    private String k;
    private String l;
    private String m;
    private int n;
    private int o;
    private int p;
    private int q;
    private String r;
    private String s;
    private String t;
    private boolean u;
    private long v;
    private JSONObject w;
    private int x;
    private boolean y;
    private int z;

    private b() {
        this.i = 1;
        this.u = true;
        this.y = false;
        this.z = 0;
        this.A = 0;
        this.H = false;
        this.J = false;
        this.K = true;
        this.L = true;
        this.a = true;
        this.b = true;
        this.f708c = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
        this.e = new AtomicBoolean(false);
        this.R = 1;
        this.U = true;
        this.aa = -1L;
    }

    public synchronized void A() {
        this.A++;
    }

    public long B() {
        long j = this.B;
        return j == 0 ? this.v : j;
    }

    public long C() {
        return this.C;
    }

    public int D() {
        return this.E;
    }

    public int E() {
        return this.F;
    }

    public String F() {
        return this.G;
    }

    public int G() {
        return this.i;
    }

    public long H() {
        return this.v;
    }

    public int I() {
        return this.q;
    }

    public String J() {
        return this.r;
    }

    public int K() {
        return this.Q;
    }

    public boolean L() {
        return this.y;
    }

    public long M() {
        return this.aa;
    }

    public String N() {
        return this.s;
    }

    public int O() {
        return this.o;
    }

    public String P() {
        return this.W;
    }

    public boolean Q() {
        return this.Y;
    }

    public boolean R() {
        return this.P;
    }

    public boolean S() {
        return this.Z;
    }

    public long T() {
        return this.S;
    }

    public long U() {
        return this.T;
    }

    public boolean V() {
        return this.H;
    }

    public String W() {
        return this.I;
    }

    public boolean X() {
        return this.J;
    }

    public boolean Y() {
        return this.ab;
    }

    public boolean Z() {
        return this.ac;
    }

    public void a(int i) {
        this.z = i;
    }

    public boolean aa() {
        return this.ae;
    }

    public boolean ab() {
        return this.ad;
    }

    public boolean ac() {
        return this.af;
    }

    public boolean ad() {
        return this.ag;
    }

    public boolean ae() {
        return this.ah;
    }

    public String af() {
        return this.ai;
    }

    public long ag() {
        return this.aj;
    }

    public JSONObject ah() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mId", this.f);
            jSONObject.put("mExtValue", this.g);
            jSONObject.put("mLogExtra", this.h);
            jSONObject.put("mDownloadStatus", this.i);
            jSONObject.put("mPackageName", this.j);
            jSONObject.put("mIsAd", this.u);
            jSONObject.put("mTimeStamp", this.v);
            jSONObject.put("mExtras", this.w);
            jSONObject.put("mVersionCode", this.q);
            jSONObject.put("mVersionName", this.r);
            jSONObject.put("mDownloadId", this.x);
            jSONObject.put("mIsV3Event", this.O);
            jSONObject.put("mScene", this.Q);
            jSONObject.put("mEventTag", this.M);
            jSONObject.put("mEventRefer", this.N);
            jSONObject.put("mDownloadUrl", this.k);
            jSONObject.put("mEnableBackDialog", this.y);
            jSONObject.put("hasSendInstallFinish", this.f708c.get());
            jSONObject.put("hasSendDownloadFailedFinally", this.d.get());
            jSONObject.put("hasDoRebootMarketInstallFinishCheck", this.e.get());
            jSONObject.put("mLastFailedErrCode", this.F);
            jSONObject.put("mLastFailedErrMsg", this.G);
            jSONObject.put("mOpenUrl", this.l);
            jSONObject.put("mLinkMode", this.o);
            jSONObject.put("mDownloadMode", this.p);
            jSONObject.put("mModelType", this.n);
            jSONObject.put("mAppName", this.s);
            jSONObject.put("mAppIcon", this.t);
            jSONObject.put("mDownloadFailedTimes", this.z);
            long j = this.B;
            if (j == 0) {
                j = this.v;
            }
            jSONObject.put("mRecentDownloadResumeTime", j);
            jSONObject.put("mClickPauseTimes", this.A);
            jSONObject.put("mJumpInstallTime", this.C);
            jSONObject.put("mCancelInstallTime", this.D);
            jSONObject.put("mLastFailedResumeCount", this.E);
            jSONObject.put("mIsUpdateDownload", this.H);
            jSONObject.put("mOriginMimeType", this.I);
            jSONObject.put("mIsPatchApplyHandled", this.J);
            jSONObject.put("downloadFinishReason", this.W);
            jSONObject.put("clickDownloadTime", this.S);
            jSONObject.put("clickDownloadSize", this.T);
            jSONObject.put("installAfterCleanSpace", this.P);
            jSONObject.put("funnelType", this.R);
            jSONObject.put("webUrl", this.m);
            jSONObject.put("enableShowComplianceDialog", this.U);
            jSONObject.put("isAutoDownloadOnCardShow", this.V);
            int i = 1;
            jSONObject.put("enable_new_activity", this.K ? 1 : 0);
            jSONObject.put("enable_pause", this.L ? 1 : 0);
            jSONObject.put("enable_ah", this.a ? 1 : 0);
            if (!this.b) {
                i = 0;
            }
            jSONObject.put("enable_am", i);
            jSONObject.putOpt("intent_jump_browser_success", Boolean.valueOf(this.ah));
            jSONObject.put("task_key", this.ai);
            jSONObject.putOpt("market_install_finish_check_start_timestamp", Long.valueOf(this.aj));
        } catch (Exception e) {
            k.u().a(e, "NativeDownloadModel toJson");
        }
        return jSONObject;
    }

    public AdDownloadModel ai() {
        return new AdDownloadModel.Builder().setAdId(this.f).setExtraValue(this.g).setLogExtra(this.h).setPackageName(this.j).setExtra(this.w).setIsAd(this.u).setVersionCode(this.q).setVersionName(this.r).setDownloadUrl(this.k).setModelType(this.n).setMimeType(this.I).setAppName(this.s).setAppIcon(this.t).setTaskKey(this.ai).setDeepLink(new DeepLink(this.l, this.m, null)).build();
    }

    public AdDownloadEventConfig aj() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag(this.M).setRefer(this.N).setIsEnableV3Event(this.O).build();
    }

    public AdDownloadController ak() {
        return new AdDownloadController.Builder().setIsEnableBackDialog(this.y).setLinkMode(this.o).setDownloadMode(this.p).setEnableShowComplianceDialog(this.U).setEnableAH(this.a).setEnableAM(this.b).build();
    }

    public void b(int i) {
        this.A = i;
    }

    public void c(long j) {
        this.D = j;
    }

    public void d(int i) {
        this.F = i;
    }

    public void e(long j) {
        this.g = j;
    }

    public void f(long j) {
        if (j > 0) {
            this.v = j;
        }
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject g() {
        return this.w;
    }

    public void h(int i) {
        this.Q = i;
    }

    public void i(int i) {
        this.R = i;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String j() {
        return this.M;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject k() {
        return null;
    }

    public void k(String str) {
        this.t = str;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public long l() {
        return this.g;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean m() {
        return this.O;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public List<String> n() {
        return null;
    }

    public void n(boolean z) {
        this.af = z;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public Object o() {
        return null;
    }

    public void o(boolean z) {
        this.ag = z;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject p() {
        return null;
    }

    public void p(boolean z) {
        this.U = z;
    }

    public void q(boolean z) {
        this.V = z;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject r() {
        return null;
    }

    public void r(boolean z) {
        this.K = z;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int s() {
        return this.x;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int t() {
        return -1;
    }

    public void t(boolean z) {
        this.a = z;
    }

    public void u(boolean z) {
        this.b = z;
    }

    public void v(boolean z) {
        this.ah = z;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadController w() {
        return ak();
    }

    public int x() {
        return this.z;
    }

    public synchronized void y() {
        this.z++;
    }

    public int z() {
        return this.A;
    }

    public void a(long j) {
        this.B = j;
    }

    public void b(long j) {
        this.C = j;
    }

    public void c(int i) {
        this.E = i;
    }

    public void d(long j) {
        this.f = j;
    }

    public void e(int i) {
        this.i = i;
    }

    public void f(int i) {
        this.q = i;
    }

    public void g(int i) {
        this.x = i;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int h() {
        return this.R;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String i() {
        return this.N;
    }

    public void j(String str) {
        this.s = str;
    }

    public void k(int i) {
        this.p = i;
    }

    public void l(int i) {
        this.n = i;
    }

    public void m(String str) {
        this.I = str;
    }

    public void n(String str) {
        this.ai = str;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean q() {
        return this.K;
    }

    public void s(boolean z) {
        this.L = z;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadModel u() {
        return ai();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadEventConfig v() {
        return aj();
    }

    public void a(String str) {
        this.G = str;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public long b() {
        return this.f;
    }

    public void c(String str) {
        this.h = str;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String d() {
        return this.h;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String e() {
        return this.j;
    }

    public void f(String str) {
        this.M = str;
    }

    public void g(String str) {
        this.N = str;
    }

    public void h(String str) {
        this.k = str;
    }

    public void i(String str) {
        this.l = str;
    }

    public void j(int i) {
        this.o = i;
    }

    public void k(boolean z) {
        this.ac = z;
    }

    public void l(String str) {
        this.W = str;
    }

    public void m(boolean z) {
        this.ad = z;
    }

    public void a(boolean z) {
        this.u = z;
    }

    public void b(String str) {
        this.j = str;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean c() {
        return this.u;
    }

    public void d(String str) {
        this.r = str;
    }

    public void e(String str) {
        this.m = str;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String f() {
        return this.l;
    }

    public void g(long j) {
        this.aa = j;
    }

    public void h(long j) {
        this.S = j;
    }

    public void i(long j) {
        this.T = j;
    }

    public void j(boolean z) {
        this.ab = z;
    }

    public void l(boolean z) {
        this.ae = z;
    }

    public void a(JSONObject jSONObject) {
        this.w = jSONObject;
    }

    public void b(boolean z) {
        this.O = z;
    }

    public void c(boolean z) {
        this.y = z;
    }

    public void d(boolean z) {
        this.X = z;
    }

    public void e(boolean z) {
        this.Y = z;
    }

    public void f(boolean z) {
        this.P = z;
    }

    public void g(boolean z) {
        this.Z = z;
    }

    public void h(boolean z) {
        this.H = z;
    }

    public void i(boolean z) {
        this.J = z;
    }

    public void j(long j) {
        this.aj = j;
    }

    public static b b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        try {
            bVar.d(com.ss.android.download.api.c.b.a(jSONObject, "mId"));
            bVar.e(com.ss.android.download.api.c.b.a(jSONObject, "mExtValue"));
            bVar.c(jSONObject.optString("mLogExtra"));
            bVar.e(jSONObject.optInt("mDownloadStatus"));
            bVar.b(jSONObject.optString("mPackageName"));
            boolean z = true;
            bVar.a(jSONObject.optBoolean("mIsAd", true));
            bVar.f(com.ss.android.download.api.c.b.a(jSONObject, "mTimeStamp"));
            bVar.f(jSONObject.optInt("mVersionCode"));
            bVar.d(jSONObject.optString("mVersionName"));
            bVar.g(jSONObject.optInt("mDownloadId"));
            bVar.b(jSONObject.optBoolean("mIsV3Event"));
            bVar.h(jSONObject.optInt("mScene"));
            bVar.f(jSONObject.optString("mEventTag"));
            bVar.g(jSONObject.optString("mEventRefer"));
            bVar.h(jSONObject.optString("mDownloadUrl"));
            bVar.c(jSONObject.optBoolean("mEnableBackDialog"));
            bVar.f708c.set(jSONObject.optBoolean("hasSendInstallFinish"));
            bVar.d.set(jSONObject.optBoolean("hasSendDownloadFailedFinally"));
            bVar.e.set(jSONObject.optBoolean("hasDoRebootMarketInstallFinishCheck"));
            bVar.d(jSONObject.optInt("mLastFailedErrCode"));
            bVar.a(jSONObject.optString("mLastFailedErrMsg"));
            bVar.i(jSONObject.optString("mOpenUrl"));
            bVar.j(jSONObject.optInt("mLinkMode"));
            bVar.k(jSONObject.optInt("mDownloadMode"));
            bVar.l(jSONObject.optInt("mModelType"));
            bVar.j(jSONObject.optString("mAppName"));
            bVar.k(jSONObject.optString("mAppIcon"));
            bVar.a(jSONObject.optInt("mDownloadFailedTimes", 0));
            bVar.a(com.ss.android.download.api.c.b.a(jSONObject, "mRecentDownloadResumeTime"));
            bVar.b(jSONObject.optInt("mClickPauseTimes"));
            bVar.b(com.ss.android.download.api.c.b.a(jSONObject, "mJumpInstallTime"));
            bVar.c(com.ss.android.download.api.c.b.a(jSONObject, "mCancelInstallTime"));
            bVar.c(jSONObject.optInt("mLastFailedResumeCount"));
            bVar.l(jSONObject.optString("downloadFinishReason"));
            bVar.i(jSONObject.optLong("clickDownloadSize"));
            bVar.h(jSONObject.optLong("clickDownloadTime"));
            bVar.h(jSONObject.optBoolean("mIsUpdateDownload"));
            bVar.m(jSONObject.optString("mOriginMimeType"));
            bVar.i(jSONObject.optBoolean("mIsPatchApplyHandled"));
            bVar.f(jSONObject.optBoolean("installAfterCleanSpace"));
            bVar.i(jSONObject.optInt("funnelType", 1));
            bVar.e(jSONObject.optString("webUrl"));
            bVar.p(jSONObject.optBoolean("enableShowComplianceDialog", true));
            bVar.q(jSONObject.optBoolean("isAutoDownloadOnCardShow"));
            bVar.r(jSONObject.optInt("enable_new_activity", 1) == 1);
            bVar.s(jSONObject.optInt("enable_pause", 1) == 1);
            bVar.t(jSONObject.optInt("enable_ah", 1) == 1);
            if (jSONObject.optInt("enable_am", 1) != 1) {
                z = false;
            }
            bVar.u(z);
            bVar.a(jSONObject.optJSONObject("mExtras"));
            bVar.v(jSONObject.optBoolean("intent_jump_browser_success"));
            bVar.n(jSONObject.optString("task_key"));
            bVar.j(jSONObject.optLong("market_install_finish_check_start_timestamp"));
        } catch (Exception e) {
            k.u().a(e, "NativeDownloadModel fromJson");
        }
        return bVar;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String a() {
        return this.k;
    }

    public b(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        this(downloadModel, downloadEventConfig, downloadController, 0);
    }

    public b(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, int i) {
        this.i = 1;
        this.u = true;
        this.y = false;
        this.z = 0;
        this.A = 0;
        this.H = false;
        this.J = false;
        this.K = true;
        this.L = true;
        this.a = true;
        this.b = true;
        this.f708c = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
        this.e = new AtomicBoolean(false);
        this.R = 1;
        this.U = true;
        this.aa = -1L;
        this.f = downloadModel.getId();
        this.g = downloadModel.getExtraValue();
        this.h = downloadModel.getLogExtra();
        this.j = downloadModel.getPackageName();
        this.w = downloadModel.getExtra();
        this.u = downloadModel.isAd();
        this.q = downloadModel.getVersionCode();
        this.r = downloadModel.getVersionName();
        this.k = downloadModel.getDownloadUrl();
        if (downloadModel.getDeepLink() != null) {
            this.l = downloadModel.getDeepLink().getOpenUrl();
            this.m = downloadModel.getDeepLink().getWebUrl();
        }
        this.n = downloadModel.getModelType();
        this.s = downloadModel.getName();
        this.t = downloadModel.getAppIcon();
        this.I = downloadModel.getMimeType();
        this.M = downloadEventConfig.getClickButtonTag();
        this.N = downloadEventConfig.getRefer();
        this.O = downloadEventConfig.isEnableV3Event();
        this.y = downloadController.isEnableBackDialog();
        this.o = downloadController.getLinkMode();
        this.p = downloadController.getDownloadMode();
        this.U = downloadController.enableShowComplianceDialog();
        this.V = downloadController.isAutoDownloadOnCardShow();
        this.K = downloadController.enableNewActivity();
        this.a = downloadController.enableAH();
        this.b = downloadController.enableAM();
        this.x = i;
        long currentTimeMillis = System.currentTimeMillis();
        this.v = currentTimeMillis;
        this.B = currentTimeMillis;
        this.J = downloadModel.shouldDownloadWithPatchApply();
        if (downloadModel instanceof AdDownloadModel) {
            this.ai = ((AdDownloadModel) downloadModel).getTaskKey();
        }
    }
}
