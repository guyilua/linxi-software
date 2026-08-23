package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.GDTLogger;
import com.sigmob.sdk.downloader.f;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class h {
    private static String a = b.a("e_qq_com_plugin");
    private static String b = b.a("e_qq_com_dex");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        return "gdt_plugin";
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(File file, File file2, Context context, boolean z) {
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.renameTo(file2)) {
            if (z) {
                return f(file2, context);
            }
            return true;
        }
        try {
            boolean a2 = a(new FileInputStream(file), file2);
            if (!z) {
                return a2;
            }
            if (a2) {
                return f(file2, context);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(InputStream inputStream, File file) {
        if (inputStream == null || file == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                GDTLogger.e("parent dir not exists " + parentFile.getAbsolutePath());
                return false;
            }
            if (!file.canWrite()) {
                file.setWritable(true);
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[f.a.d];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        a(inputStream);
                        a(fileOutputStream2);
                        return true;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                try {
                    GDTLogger.e("Exception while copy from InputStream to File", th);
                    throw th;
                } finally {
                    a(inputStream);
                    a(fileOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.BufferedReader] */
    public static String b(File file) {
        Throwable th;
        ?? r1 = 0;
        if (file != null) {
            try {
                if (file.exists()) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            }
                            String sb2 = sb.toString();
                            try {
                                bufferedReader.close();
                            } catch (Exception unused) {
                                GDTLogger.d("Exception while close bufferreader");
                            }
                            return sb2;
                        } catch (IOException e) {
                            throw e;
                        }
                    } catch (IOException e2) {
                        throw e2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (r1 != 0) {
                            try {
                                r1.close();
                            } catch (Exception unused2) {
                                GDTLogger.d("Exception while close bufferreader");
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                r1 = file;
                th = th3;
            }
        }
        return null;
    }

    public static void b(Context context) {
        try {
            File file = new File(context.getDir(a, 0), "stub_ver");
            if (TextUtils.equals(b(file), SDKStatus.getSDKVersion())) {
                return;
            }
            e(SDKStatus.getSDKVersion(), file);
            c(context);
        } catch (Throwable th) {
            GDTLogger.w(th.getMessage(), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Context context) {
        try {
            File dir = context.getDir(a, 0);
            if (new File(dir, "disdoat").exists()) {
                return;
            }
            d(context.getDir(b, 0), false);
            d(new File(dir, "oat"), false);
        } catch (Throwable th) {
            GDTLogger.w(th.getMessage(), th);
        }
    }

    private static void d(File file, boolean z) {
        File[] listFiles;
        if (file == null || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                d(file2, true);
            } else {
                file2.delete();
            }
        }
        if (z) {
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(String str, File file) {
        if (file == null) {
            throw new IOException("Target File Can not be null in StringUtil.writeTo");
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        OutputStreamWriter outputStreamWriter = null;
        try {
            OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            try {
                outputStreamWriter2.write(str);
                a(outputStreamWriter2);
            } catch (Throwable th) {
                th = th;
                outputStreamWriter = outputStreamWriter2;
                a(outputStreamWriter);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(File file, Context context) {
        if (Build.VERSION.SDK_INT < 34 || context == null || context.getApplicationInfo() == null || context.getApplicationInfo().targetSdkVersion < 34) {
            return true;
        }
        return file.setReadOnly();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File g(Context context) {
        return context.getDir(b, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File h(Context context) {
        return new File(context.getDir(a, 0), "update_lc");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File i(Context context) {
        return new File(context.getDir(a, 0), "gdt_plugin.next");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File j(Context context) {
        return new File(context.getDir(a, 0), "gdt_plugin.next.sig");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File k(Context context) {
        return new File(context.getDir(a, 0), "gdt_plugin.jar");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File l(Context context) {
        return new File(context.getDir(a, 0), "gdt_plugin.jar.sig");
    }
}
