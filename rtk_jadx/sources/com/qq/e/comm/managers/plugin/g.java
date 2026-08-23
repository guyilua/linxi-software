package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.qq.e.comm.managers.plugin.c;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class g {
    private final File a;
    private final File b;

    /* renamed from: c, reason: collision with root package name */
    private String f22c;
    private int d;
    private String e;

    public g(File file, File file2) {
        this.a = file;
        this.b = file2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.f22c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Context context, boolean z) {
        int i;
        try {
            if (this.b.exists() && this.a.exists()) {
                String b = h.b(this.b);
                this.e = b;
                if (TextUtils.isEmpty(b)) {
                    return false;
                }
                String[] split = this.e.split("#####");
                if (split.length == 2) {
                    String str = split[1];
                    try {
                        i = Integer.parseInt(split[0]);
                    } catch (Throwable unused) {
                        i = 0;
                    }
                    if (c.b.a.a(str, this.a)) {
                        this.f22c = str;
                        this.d = i;
                        if (Build.VERSION.SDK_INT < 34 || context == null || context.getApplicationInfo() == null || context.getApplicationInfo().targetSdkVersion < 34 || !z) {
                            return true;
                        }
                        if (!this.a.canWrite() && !this.a.canExecute()) {
                            return this.a.canRead();
                        }
                        return this.a.setReadOnly();
                    }
                }
            }
            return false;
        } catch (Throwable unused2) {
            GDTLogger.d("Exception while checking plugin");
            return false;
        }
    }

    public String c() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(File file, File file2, Context context) {
        if (file.equals(this.a) || h.a(this.a, file, context, true)) {
            return file2.equals(this.b) || h.a(this.b, file2, context, false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.d;
    }
}
