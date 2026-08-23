package com.rtk.app.tool.g;

import com.rtk.app.bean.UpApkBean;
import com.rtk.app.tool.c0;

/* compiled from: UpLoadApkInfo.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class g {
    int A;
    double B;
    String C;
    String D;
    int E;
    int a;
    String b;

    /* renamed from: c, reason: collision with root package name */
    String f305c;
    String d;
    String e;
    int f;
    int g;
    int h;
    int i;
    String j;
    String k;
    int l;
    String m;
    String n;
    String o;
    String p;
    String q;
    String r;
    String s;
    int t;
    UpApkBean u;
    String v;
    String w;
    String x;
    int y;
    int z;

    public g(int i, String str, String str2, String str3, String str4, int i2, int i3, int i4, int i5, String str5, int i6, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i7, String str13, int i8, int i9, String str14, String str15, String str16, int i10, int i11, double d, String str17, int i12, String str18, UpApkBean upApkBean, String str19, int i13) {
        this.f305c = "";
        this.w = "";
        this.D = "0";
        this.E = 0;
        this.a = i;
        this.C = str17;
        this.w = str15;
        this.A = i12;
        this.x = str16;
        this.y = i10;
        this.z = i11;
        this.B = d;
        this.b = str;
        this.v = str14;
        this.f305c = str2;
        this.d = str3;
        this.e = str4;
        this.g = i3;
        this.f = i2;
        this.h = i4;
        this.i = i5;
        this.j = str5;
        this.l = i6;
        this.m = str6;
        this.n = str7;
        this.o = str8;
        this.p = str9;
        this.q = str10;
        this.r = str11;
        this.s = str12;
        this.k = str13;
        this.t = i8;
        this.u = upApkBean;
        this.D = str19;
        this.E = i13;
    }

    public String A() {
        return this.C;
    }

    public String B() {
        return this.x;
    }

    public double C() {
        return this.B;
    }

    public String D() {
        return this.v;
    }

    public int E() {
        return this.a;
    }

    public void F(int i) {
        this.h = i;
    }

    public void G(int i) {
        this.A = i;
    }

    public void H(int i) {
        this.i = i;
    }

    public void I(int i) {
        this.z = i;
    }

    public void J(UpApkBean upApkBean) {
        this.u = upApkBean;
    }

    public void K(int i) {
        this.g = i;
    }

    public void L(int i) {
        this.y = i;
    }

    public void M(String str) {
        this.k = str;
    }

    public void N(double d) {
        this.B = d;
    }

    public int a() {
        return this.h;
    }

    public int b() {
        return this.A;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.o;
    }

    public int e() {
        int i = this.i;
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public int f() {
        return this.z;
    }

    public String g() {
        return this.p;
    }

    public String h() {
        return this.j;
    }

    public String i() {
        return this.D;
    }

    public String j() {
        return this.s;
    }

    public String k() {
        return this.q;
    }

    public String l() {
        return this.r;
    }

    public int m() {
        return this.f;
    }

    public String n() {
        return c0.q(this.f305c) ? "" : this.f305c;
    }

    public String o() {
        return this.d;
    }

    public int p() {
        return this.E;
    }

    public String q() {
        return this.e;
    }

    public String r() {
        return this.m;
    }

    public int s() {
        return this.l;
    }

    public UpApkBean t() {
        return this.u;
    }

    public String toString() {
        return "UpLoadApkInfo{, apk_name='" + this.b + "', md5='" + this.f305c + "', path='" + this.d + "', size='" + this.e + "', load_in_background=" + this.f + ", up_load_state=" + this.g + ", all_total=" + this.h + ", current_index=" + this.i + ", up_server_file_name='" + this.k + "', type=" + this.l + ", tag='" + this.m + "', tag_title='" + this.n + "', characteristic='" + this.o + "', zip_path='" + this.v + "', zipMd5='" + this.w + "', zipServePath='" + this.x + "', up_load_zip_state=" + this.y + ", current_zip_index=" + this.z + ", all_zip_total=" + this.A + ", zipSize='" + this.B + "', zipSaveName='" + this.C + "'}";
    }

    public int u() {
        return this.g;
    }

    public int v() {
        return this.y;
    }

    public String w() {
        return this.k;
    }

    public int x() {
        return this.t;
    }

    public int y() {
        return this.a + 1000000;
    }

    public String z() {
        return c0.q(this.w) ? "" : this.w;
    }
}
