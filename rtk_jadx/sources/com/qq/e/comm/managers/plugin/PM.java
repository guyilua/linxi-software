package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PM {
    public static final int CALL_START_BY_DEV = 1;
    private static final Map<Class<?>, String> s = new b();
    private final Context b;

    /* renamed from: c, reason: collision with root package name */
    private String f20c;
    private File d;
    private volatile int e;
    private DexClassLoader f;
    private RandomAccessFile g;
    private boolean h;
    private final f i;
    private volatile POFactory j;
    private int k;
    private int l;
    private Future<Boolean> m;
    private boolean o;
    private String p;
    private JSONObject q;
    private int r;
    final ExecutorService a = Executors.newSingleThreadExecutor();
    private boolean n = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements Callable<Boolean> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() {
            long currentTimeMillis = System.currentTimeMillis();
            h.b(PM.this.b);
            PM.f(PM.this);
            if (!PM.this.h) {
                PM pm = PM.this;
                pm.h = pm.tryLockUpdate();
            }
            if (PM.k(PM.this)) {
                PM.this.l = (int) (System.currentTimeMillis() - currentTimeMillis);
                PM.l(PM.this);
            }
            PM.this.k = (int) (System.currentTimeMillis() - currentTimeMillis);
            return Boolean.TRUE;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class b extends HashMap<Class<?>, String> {
        b() {
            put(POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
        }
    }

    public PM(Context context, f fVar) {
        this.b = context.getApplicationContext();
        this.i = fVar;
        com.qq.e.comm.managers.plugin.b.a(context);
        j();
    }

    private JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            int pluginVersion = getPluginVersion();
            if (pluginVersion > 10000) {
                jSONObject.put("vas", this.p);
            }
            jSONObject.put("pv", pluginVersion);
            jSONObject.put("sig", this.f20c);
            jSONObject.put("appId", com.qq.e.comm.managers.a.b().a());
            jSONObject.put("pn", com.qq.e.comm.managers.plugin.b.a(this.b));
            jSONObject.put("ict", this.k);
            jSONObject.put("mup", this.h);
            jSONObject.put("ifg", this.r);
            jSONObject.put("pct", this.l);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    static void f(PM pm) {
        SharedPreferences sharedPreferences = pm.b.getSharedPreferences("start_crash", 0);
        if (sharedPreferences.getInt("crash_count", 0) >= 2) {
            pm.o = true;
            sharedPreferences.edit().remove("crash_count").commit();
            GDTLogger.e("加载本地插件");
        }
    }

    private boolean g() {
        if (!this.h) {
            return false;
        }
        try {
            this.r = 1;
            Context context = this.b;
            com.qq.e.comm.managers.plugin.b.b(context, h.k(context), h.l(this.b));
            this.f20c = Sig.ASSET_PLUGIN_SIG;
            this.d = h.k(this.b);
            this.e = SDKStatus.getBuildInPluginVersion();
            return true;
        } catch (Throwable th) {
            GDTLogger.e("插件初始化失败 ");
            com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
            return false;
        }
    }

    private boolean h() {
        if (this.o) {
            return false;
        }
        if (this.h) {
            g gVar = new g(h.i(this.b), h.j(this.b));
            if (gVar.b(this.b, false)) {
                this.r = 3;
                h.c(this.b);
                GDTLogger.d("NextExist,Updated=" + gVar.c(h.k(this.b), h.l(this.b), this.b));
            }
        }
        g gVar2 = new g(h.k(this.b), h.l(this.b));
        if (!gVar2.b(this.b, true)) {
            return false;
        }
        if (gVar2.d() < SDKStatus.getBuildInPluginVersion()) {
            GDTLogger.d("last updated plugin version =" + this.e + ";asset plugin version=" + SDKStatus.getBuildInPluginVersion());
            return false;
        }
        if (this.r == 0) {
            this.r = 2;
        }
        this.f20c = gVar2.a();
        this.e = gVar2.d();
        this.d = h.k(this.b);
        this.p = gVar2.c();
        this.n = true;
        return true;
    }

    private void j() {
        this.n = false;
        this.m = this.a.submit(new a());
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0028, code lost:
    
        if (r5.g() != false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static boolean k(com.qq.e.comm.managers.plugin.PM r5) {
        /*
            java.lang.String r0 = "TimeStap_AFTER_PLUGIN_INIT:"
            java.util.Objects.requireNonNull(r5)
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L32
            r2.<init>()     // Catch: java.lang.Throwable -> L32
            java.lang.String r3 = "TimeStap_BEFORE_PLUGIN_INIT:"
            r2.append(r3)     // Catch: java.lang.Throwable -> L32
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L32
            r2.append(r3)     // Catch: java.lang.Throwable -> L32
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L32
            com.qq.e.comm.util.GDTLogger.d(r2)     // Catch: java.lang.Throwable -> L32
            boolean r2 = r5.h()     // Catch: java.lang.Throwable -> L32
            if (r2 != 0) goto L2a
            boolean r5 = r5.g()     // Catch: java.lang.Throwable -> L32
            if (r5 == 0) goto L2c
        L2a:
            r5 = 1
            r1 = 1
        L2c:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            goto L44
        L32:
            r5 = move-exception
            java.lang.String r2 = "插件加载出现异常"
            com.qq.e.comm.util.GDTLogger.e(r2, r5)     // Catch: java.lang.Throwable -> L56
            java.lang.String r2 = r5.getMessage()     // Catch: java.lang.Throwable -> L56
            com.qq.e.comm.managers.plugin.a.a(r5, r2)     // Catch: java.lang.Throwable -> L56
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
        L44:
            r5.append(r0)
            long r2 = java.lang.System.currentTimeMillis()
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            com.qq.e.comm.util.GDTLogger.d(r5)
            return r1
        L56:
            r5 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            long r2 = java.lang.System.currentTimeMillis()
            r1.append(r2)
            java.lang.String r0 = r1.toString()
            com.qq.e.comm.util.GDTLogger.d(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.plugin.PM.k(com.qq.e.comm.managers.plugin.PM):boolean");
    }

    static void l(PM pm) {
        Objects.requireNonNull(pm);
        StringBuilder sb = new StringBuilder();
        sb.append("PluginFile:\t");
        File file = pm.d;
        sb.append(file == null ? "null" : file.getAbsolutePath());
        GDTLogger.d(sb.toString());
        if (pm.f20c == null || pm.d == null) {
            pm.f = null;
            return;
        }
        try {
            pm.f = new DexClassLoader(pm.d.getAbsolutePath(), h.g(pm.b).getAbsolutePath(), null, pm.getClass().getClassLoader());
            f fVar = pm.i;
            if (fVar != null) {
                fVar.a();
            }
        } catch (Throwable th) {
            GDTLogger.e("插件ClassLoader构造发生异常", th);
            f fVar2 = pm.i;
            if (fVar2 != null) {
                fVar2.b();
            }
            com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
        }
    }

    public <T> T getFactory(Class<T> cls) {
        Future<Boolean> future = this.m;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        GDTLogger.d("GetFactoryInstaceforInterface:" + cls);
        ClassLoader classLoader = Sig.ASSET_PLUGIN_SIG == null ? PM.class.getClassLoader() : this.f;
        StringBuilder sb = new StringBuilder();
        sb.append("PluginClassLoader is parent");
        sb.append(PM.class.getClassLoader() == classLoader);
        GDTLogger.d(sb.toString());
        if (classLoader == null) {
            throw new e("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + cls);
        }
        try {
            String str = s.get(cls);
            if (TextUtils.isEmpty(str)) {
                throw new e("factory  implemention name is not specified for interface:" + cls.getName());
            }
            Class<?> loadClass = classLoader.loadClass(str);
            T cast = cls.cast(loadClass.getDeclaredMethod("getInstance", Context.class, JSONObject.class).invoke(loadClass, this.b, c()));
            GDTLogger.d("ServiceDelegateFactory =" + cast);
            return cast;
        } catch (Throwable th) {
            throw new e("Fail to getfactory implement instance for interface:" + cls.getName(), th);
        }
    }

    public POFactory getPOFactory() {
        return getPOFactory(true, false);
    }

    public POFactory getPOFactory(boolean z, boolean z2) {
        if (this.j == null) {
            synchronized (this) {
                if (this.j == null) {
                    try {
                        this.j = (POFactory) getFactory(POFactory.class);
                    } catch (e e) {
                        if (!this.n) {
                            throw e;
                        }
                        GDTLogger.e("插件加载错误，回退到内置版本");
                        this.o = true;
                        this.n = false;
                        this.m = this.a.submit(new a());
                        this.j = (POFactory) getFactory(POFactory.class);
                    }
                }
            }
        }
        if (z && this.j != null) {
            this.j.start(z2 ? getStartCaller(0) : getStartCaller(2));
        }
        return this.j;
    }

    public int getPluginVersion() {
        Future<Boolean> future = this.m;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return this.e;
    }

    public JSONObject getStartCaller(int i) {
        if (this.q == null) {
            this.q = new JSONObject();
        }
        try {
            this.q.put("scr", i);
        } catch (JSONException unused) {
        }
        return this.q;
    }

    public boolean tryLockUpdate() {
        try {
            File h = h.h(this.b);
            if (!h.exists()) {
                h.createNewFile();
                h.e("lock", h);
            }
            if (!h.exists()) {
                return false;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(h, "rw");
            this.g = randomAccessFile;
            if (randomAccessFile.getChannel().tryLock() == null) {
                return false;
            }
            this.g.writeByte(37);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
