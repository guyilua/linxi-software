package com.tencent.smtt.utils;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/* compiled from: TbsConfigFile.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class o {
    private static o e;
    private Context b;

    /* renamed from: c, reason: collision with root package name */
    private File f989c = null;
    public boolean a = false;
    private boolean d = false;
    private File f = null;

    private o(Context context) {
        this.b = null;
        this.b = context.getApplicationContext();
        b();
    }

    public static synchronized o a(Context context) {
        o oVar;
        synchronized (o.class) {
            if (e == null) {
                e = new o(context);
            }
            oVar = e;
        }
        return oVar;
    }

    private File d() {
        try {
            if (this.f989c == null) {
                File file = new File(this.b.getDir("tbs", 0), "core_private");
                this.f989c = file;
                if (file == null || !file.isDirectory()) {
                    return null;
                }
            }
            File file2 = new File(this.f989c, "debug.conf");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            return file2;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public synchronized void b() {
        BufferedInputStream bufferedInputStream = null;
        try {
            if (this.f == null) {
                this.f = d();
            }
        } catch (Throwable th) {
            th = th;
        }
        if (this.f == null) {
            return;
        }
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(this.f));
        try {
            Properties properties = new Properties();
            properties.load(bufferedInputStream2);
            String property = properties.getProperty("setting_forceUseSystemWebview", "");
            if (!"".equals(property)) {
                this.a = Boolean.parseBoolean(property);
            }
            try {
                bufferedInputStream2.close();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = bufferedInputStream2;
            try {
                th.printStackTrace();
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                    }
                }
            } finally {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c() {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        File d;
        BufferedOutputStream bufferedOutputStream2 = null;
        Object[] objArr = 0;
        try {
            try {
                d = d();
            } catch (Throwable th2) {
                bufferedInputStream = null;
                th = th2;
                bufferedOutputStream = null;
            }
            if (d == null) {
                try {
                    (objArr == true ? 1 : 0).close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    bufferedOutputStream2.close();
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            bufferedInputStream = new BufferedInputStream(new FileInputStream(d));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream);
                properties.setProperty("setting_forceUseSystemWebview", Boolean.toString(this.a));
                properties.setProperty("result_systemWebviewForceUsed", Boolean.toString(this.d));
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(d));
                try {
                    properties.store(bufferedOutputStream, (String) null);
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    bufferedOutputStream.close();
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        th.printStackTrace();
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                        bufferedOutputStream.close();
                    } finally {
                    }
                }
            } catch (Throwable th4) {
                bufferedOutputStream = null;
                th = th4;
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public static synchronized o a() {
        o oVar;
        synchronized (o.class) {
            oVar = e;
        }
        return oVar;
    }

    public void a(boolean z) {
        this.d = z;
        c();
    }
}
