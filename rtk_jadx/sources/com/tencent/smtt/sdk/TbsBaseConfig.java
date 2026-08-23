package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class TbsBaseConfig {
    public static final String TAG = "TbsBaseConfig";
    Map<String, String> a;
    private Context b;

    private static File a(Context context, String str) {
        l.a();
        File s = l.s(context);
        if (s == null) {
            return null;
        }
        File file = new File(s, str);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void clear() {
        this.a.clear();
        commit();
    }

    public synchronized void commit() {
        writeTbsDownloadInfo();
    }

    public abstract String getConfigFileName();

    public void init(Context context) {
        this.a = new HashMap();
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        if (applicationContext == null) {
            this.b = context;
        }
        refreshSyncMap(context);
    }

    public synchronized void refreshSyncMap(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        File a;
        try {
            a = a(this.b, getConfigFileName());
        } catch (Throwable th2) {
            bufferedInputStream = null;
            th = th2;
        }
        if (a == null) {
            return;
        }
        this.a.clear();
        bufferedInputStream = new BufferedInputStream(new FileInputStream(a));
        try {
            Properties properties = new Properties();
            properties.load(bufferedInputStream);
            for (String str : properties.stringPropertyNames()) {
                this.a.put(str, properties.getProperty(str));
            }
            try {
                bufferedInputStream.close();
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                th.printStackTrace();
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                    }
                }
            } finally {
            }
        }
    }

    public synchronized void writeTbsDownloadInfo() {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        File a;
        Properties properties;
        TbsLog.i(TAG, "writeTbsDownloadInfo #1");
        BufferedInputStream bufferedInputStream = null;
        try {
            a = a(this.b, getConfigFileName());
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream = null;
        }
        if (a == null) {
            return;
        }
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(a));
        try {
            properties = new Properties();
            properties.load(bufferedInputStream2);
            properties.clear();
            for (String str : this.a.keySet()) {
                String str2 = this.a.get(str);
                properties.setProperty(str, "" + ((Object) str2));
                TbsLog.i(TAG, "writeTbsDownloadInfo key is " + str + " value is " + ((Object) str2));
            }
            this.a.clear();
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(a));
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
        try {
            properties.store(bufferedOutputStream, (String) null);
            try {
                bufferedInputStream2.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                bufferedOutputStream.close();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = bufferedInputStream2;
            try {
                th.printStackTrace();
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e4) {
                        e = e4;
                        e.printStackTrace();
                    }
                }
            } finally {
            }
        }
    }
}
