package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

/* compiled from: TbsCommonConfig.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class n {

    /* renamed from: c, reason: collision with root package name */
    private static n f988c;
    private Context a;
    private File b = null;
    private String d = "http://log.tbs.qq.com/ajax?c=pu&v=2&k=";
    private String e = "http://log.tbs.qq.com/ajax?c=pu&tk=";
    private String f = "http://wup.imtt.qq.com:8080";
    private String g = "http://log.tbs.qq.com/ajax?c=dl&k=";
    private String h = "http://cfg.imtt.qq.com/tbs?v=2&mk=";
    private String i = "http://log.tbs.qq.com/ajax?c=ul&v=2&k=";
    private String j = "http://mqqad.html5.qq.com/adjs";
    private String k = "http://log.tbs.qq.com/ajax?c=ucfu&k=";

    @TargetApi(11)
    private n(Context context) {
        this.a = null;
        TbsLog.w("TbsCommonConfig", "TbsCommonConfig constructing...");
        this.a = context.getApplicationContext();
        g();
    }

    public static synchronized n a(Context context) {
        n nVar;
        synchronized (n.class) {
            if (f988c == null) {
                f988c = new n(context);
            }
            nVar = f988c;
        }
        return nVar;
    }

    private synchronized void g() {
        File h;
        BufferedInputStream bufferedInputStream = null;
        try {
            h = h();
        } catch (Throwable th) {
            th = th;
        }
        if (h == null) {
            TbsLog.e("TbsCommonConfig", "Config file is null, default values will be applied");
            return;
        }
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(h));
        try {
            Properties properties = new Properties();
            properties.load(bufferedInputStream2);
            String property = properties.getProperty("pv_post_url", "");
            if (!"".equals(property)) {
                this.d = property;
            }
            String property2 = properties.getProperty("wup_proxy_domain", "");
            if (!"".equals(property2)) {
                this.f = property2;
            }
            String property3 = properties.getProperty("tbs_download_stat_post_url", "");
            if (!"".equals(property3)) {
                this.g = property3;
            }
            String property4 = properties.getProperty("tbs_downloader_post_url", "");
            if (!"".equals(property4)) {
                this.h = property4;
            }
            String property5 = properties.getProperty("tbs_log_post_url", "");
            if (!"".equals(property5)) {
                this.i = property5;
            }
            String property6 = properties.getProperty("tips_url", "");
            if (!"".equals(property6)) {
                this.j = property6;
            }
            String property7 = properties.getProperty("tbs_cmd_post_url", "");
            if (!"".equals(property7)) {
                this.k = property7;
            }
            String property8 = properties.getProperty("pv_post_url_tk", "");
            if (!"".equals(property8)) {
                this.e = property8;
            }
            try {
                bufferedInputStream2.close();
            } catch (IOException e) {
                e = e;
                e.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = bufferedInputStream2;
            try {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                TbsLog.e("TbsCommonConfig", "exceptions occurred1:" + stringWriter.toString());
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                    }
                }
            } finally {
            }
        }
    }

    private File h() {
        File file = null;
        try {
            if (this.b == null) {
                File file2 = new File(f.a(this.a, 5));
                this.b = file2;
                if (file2 == null || !file2.isDirectory()) {
                    return null;
                }
            }
            File file3 = new File(this.b, "tbsnet.conf");
            if (!file3.exists()) {
                TbsLog.e("TbsCommonConfig", "Get file(" + file3.getCanonicalPath() + ") failed!");
                return null;
            }
            try {
                TbsLog.w("TbsCommonConfig", "pathc:" + file3.getCanonicalPath());
                return file3;
            } catch (Throwable th) {
                th = th;
                file = file3;
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                TbsLog.e("TbsCommonConfig", "exceptions occurred2:" + stringWriter.toString());
                return file;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.g;
    }

    public String d() {
        return this.h;
    }

    public String e() {
        return this.i;
    }

    public String f() {
        return this.e;
    }

    public static synchronized n a() {
        n nVar;
        synchronized (n.class) {
            nVar = f988c;
        }
        return nVar;
    }
}
