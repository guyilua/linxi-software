package com.rtk.app.tool.DownLoadTool;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.rtk.app.bean.DownListBean;
import com.rtk.app.bean.InstallationBean;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.c0;
import io.reactivex.annotations.NonNull;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DownLoadInfo.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class p {
    private int a;
    private int b;

    /* renamed from: c, reason: collision with root package name */
    private String f285c;
    private int d;
    private long e;
    private long f;
    private String g;
    private String h;
    private String i;
    private long j;
    private String k;
    private int l;
    private int m;
    private String n;
    private int o;
    private List<DownListBean> p;
    private InstallationBean q;
    private Gson r;

    public p(ApkInfo apkInfo, int i) {
        this.d = 0;
        this.e = 0L;
        this.f = 0L;
        this.p = new ArrayList();
        this.r = new GsonBuilder().enableComplexMapKeySerialization().create();
        this.a = apkInfo.getGameId();
        this.f285c = apkInfo.getAppName();
        this.g = apkInfo.getPackageName();
        this.h = apkInfo.getIcon_url();
        this.l = apkInfo.getIsApk();
        this.k = apkInfo.getSignaturesMD5();
        this.m = apkInfo.getVersion_code();
        this.d = i;
        this.p.addAll(apkInfo.getDownlist());
        this.q = apkInfo.getInstallation();
    }

    public void A(int i) {
        this.l = i;
    }

    public void B(long j) {
        this.e = j;
    }

    public void C(String str) {
        this.n = str;
    }

    public String a() {
        List<DownListBean> list = this.p;
        if (list == null || list.size() <= 0) {
            return "";
        }
        if (r().contains("apk")) {
            return this.p.get(0).getApkKey();
        }
        return this.p.get(0).getZipKey();
    }

    public int b() {
        List<DownListBean> list = this.p;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        if (r().contains("apk")) {
            return this.p.get(0).getApkType();
        }
        return this.p.get(0).getZipType();
    }

    public String c() {
        return this.f285c;
    }

    public long d() {
        return this.j;
    }

    public String e() {
        return this.i;
    }

    public long f() {
        return this.f;
    }

    public List<DownListBean> g() {
        return this.p;
    }

    public int h() {
        return this.d;
    }

    public int i() {
        return this.o;
    }

    public int j() {
        return this.a;
    }

    public String k() {
        return this.h;
    }

    public InstallationBean l() {
        return this.q;
    }

    public int m() {
        return this.l;
    }

    public String n() {
        return this.g;
    }

    public String o() {
        return this.k;
    }

    public long p() {
        return this.e;
    }

    public int q() {
        int i = this.a;
        return i > 10000000 ? i - 10000000 : this.b;
    }

    public String r() {
        List<DownListBean> list = this.p;
        return (list == null || list.size() <= 0) ? "http://rtkapi2.ruansky.net/" : this.p.get(0).getUrl();
    }

    public int s() {
        return this.m;
    }

    public String t() {
        return this.n;
    }

    public String toString() {
        return "DownLoadInfo{gameId=" + this.a + ", appName='" + this.f285c + "', downLoadState=" + this.d + ", tatol=" + this.e + ", current=" + this.f + ", packageName='" + this.g + "', icon_url='" + this.h + "', app_save_path='" + this.i + "', app_data_size=" + this.j + ", SignaturesMD5='" + this.k + "', isApk=" + this.l + ", version_code=" + this.m + ", zipApkPath='" + this.n + "', downloadNum=" + this.o + ", downlist=" + this.p + '}';
    }

    public void u() {
        List<DownListBean> list = this.p;
        if (list == null || list.size() <= 1) {
            return;
        }
        this.p.remove(0);
    }

    public void v(long j) {
        this.j = j;
    }

    public void w(String str) {
        this.i = str;
    }

    public void x(long j) {
        this.f = j;
    }

    public void y(int i) {
        this.d = i;
    }

    public void z(int i) {
        this.o = i;
    }

    public p(int i, @NonNull String str, String str2, String str3, int i2, String str4, int i3, int i4) {
        this.d = 0;
        this.e = 0L;
        this.f = 0L;
        this.p = new ArrayList();
        this.r = new GsonBuilder().enableComplexMapKeySerialization().create();
        this.a = i;
        this.g = str;
        this.f285c = str2;
        this.d = i2;
        this.h = str4;
        this.l = i3;
        this.m = i4;
        ArrayList arrayList = new ArrayList();
        DownListBean downListBean = new DownListBean(str3);
        this.q = new InstallationBean();
        arrayList.add(downListBean);
        this.p = arrayList;
    }

    public p(int i, String str, int i2, long j, long j2, DownListBean downListBean, @NonNull String str2, String str3, String str4, long j3, String str5, int i3, int i4, String str6, String str7) {
        this.d = 0;
        this.e = 0L;
        this.f = 0L;
        this.p = new ArrayList();
        this.r = new GsonBuilder().enableComplexMapKeySerialization().create();
        this.a = i;
        this.f285c = str;
        this.d = i2;
        this.e = j;
        this.f = j2;
        this.g = str2;
        this.h = str3;
        this.i = str4;
        this.j = j3;
        this.k = str5;
        this.l = i3;
        this.m = i4;
        this.n = str6;
        this.p.add(downListBean);
        if (TextUtils.isEmpty(str7)) {
            return;
        }
        c0.u("EXC", "" + str7);
        InstallationBean installationBean = null;
        try {
            installationBean = (InstallationBean) this.r.fromJson(str7, InstallationBean.class);
        } catch (JsonSyntaxException e) {
            c0.s("DownLoadInfo", "" + e.getMessage());
        }
        if (installationBean == null) {
            return;
        }
        this.q = installationBean;
    }
}
