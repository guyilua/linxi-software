package com.ss.android.downloadlib.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.ss.android.downloadlib.a.a.c;
import com.ss.android.downloadlib.addownload.k;
import com.umeng.analytics.pro.ak;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    private static String d = "";
    private static String e = "";
    private static String f = "";
    private static volatile a g;
    public c a;
    private Context k;
    private boolean h = true;
    private boolean i = false;
    private volatile boolean j = false;
    private final List<Pair<b, d>> l = new ArrayList();
    public final List<Object> b = new ArrayList();
    private final ServiceConnection m = new ServiceConnection() { // from class: com.ss.android.downloadlib.a.a.a.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (a.this.f713c) {
                a.this.a(false);
                a.this.a = c.a.a(iBinder);
                a.this.c();
                Iterator<Object> it = a.this.b.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (a.this.f713c) {
                a.this.a(false);
                a aVar = a.this;
                aVar.a = null;
                Iterator<Object> it = aVar.b.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    };
    private String n = "";

    /* renamed from: c, reason: collision with root package name */
    public final Object f713c = new Object();

    private a() {
    }

    public static a a() {
        if (g == null) {
            synchronized (a.class) {
                if (g == null) {
                    g = new a();
                }
            }
        }
        return g;
    }

    public void b() {
        if (this.a != null) {
            this.k.unbindService(this.m);
            this.a = null;
        }
        this.b.clear();
        this.l.clear();
    }

    public void c() {
        for (Pair<b, d> pair : this.l) {
            try {
                this.a.a((b) pair.first, (d) pair.second);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        this.l.clear();
    }

    public boolean d() {
        return this.j;
    }

    public boolean a(Context context, boolean z) {
        if (TextUtils.isEmpty(d)) {
            JSONObject j = k.j();
            String optString = j.optString(ak.aB);
            d = com.ss.android.socialbase.appdownloader.f.c.a(j.optString("q"), optString);
            e = com.ss.android.socialbase.appdownloader.f.c.a(j.optString(ak.aG), optString);
            f = com.ss.android.socialbase.appdownloader.f.c.a(j.optString("w"), optString);
        }
        this.i = z;
        if (context == null) {
            return true;
        }
        this.k = context.getApplicationContext();
        if (TextUtils.isEmpty(f)) {
            f = this.k.getPackageName();
        }
        if (this.a != null || d()) {
            return true;
        }
        return this.k.bindService(a(context), this.m, 33);
    }

    public Intent a(Context context) {
        Intent intent = new Intent();
        intent.setAction(d);
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            return null;
        }
        Iterator<ResolveInfo> it = queryIntentServices.iterator();
        while (it.hasNext()) {
            ServiceInfo serviceInfo = it.next().serviceInfo;
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if (e.equals(str)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    public void a(b bVar, d dVar) {
        synchronized (this.f713c) {
            bVar.e = f;
            if (TextUtils.isEmpty(bVar.f)) {
                bVar.f = this.n;
            }
            c cVar = this.a;
            if (cVar != null) {
                try {
                    cVar.a(bVar, dVar);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            } else if (d() || a(this.k, this.i)) {
                this.l.add(Pair.create(bVar, dVar));
            }
        }
    }

    public void a(boolean z) {
        this.j = z;
    }
}
