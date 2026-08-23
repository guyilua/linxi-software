package com.sigmob.sdk.downloader.core;

import java.io.File;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class a {
    public static final String f = "";
    public static final File g = new File("");

    public boolean a(a aVar) {
        if (!i().equals(aVar.i()) || i().equals("") || l().equals(g)) {
            return false;
        }
        if (k().equals(aVar.k())) {
            return true;
        }
        if (!l().equals(aVar.l())) {
            return false;
        }
        String d = d();
        String d2 = aVar.d();
        return (d2 == null || d == null || !d2.equals(d)) ? false : true;
    }

    public abstract int c();

    public abstract String d();

    public abstract String i();

    protected abstract File k();

    public abstract File l();
}
