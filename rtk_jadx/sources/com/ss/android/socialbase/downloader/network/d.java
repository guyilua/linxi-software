package com.ss.android.socialbase.downloader.network;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class d {
    private final double a;
    private final int b;

    /* renamed from: c, reason: collision with root package name */
    private double f908c = -1.0d;
    private int d;

    public d(double d) {
        this.a = d;
        this.b = d == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d);
    }

    public void a(double d) {
        double d2 = 1.0d - this.a;
        int i = this.d;
        if (i > this.b) {
            this.f908c = Math.exp((d2 * Math.log(this.f908c)) + (this.a * Math.log(d)));
        } else if (i > 0) {
            double d3 = (d2 * i) / (i + 1.0d);
            this.f908c = Math.exp((d3 * Math.log(this.f908c)) + ((1.0d - d3) * Math.log(d)));
        } else {
            this.f908c = d;
        }
        this.d++;
    }

    public double a() {
        return this.f908c;
    }
}
