package com.qq.e.comm.managers.plugin;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {
    private static volatile String a;

    public static synchronized String a(Context context) {
        ActivityManager.RunningAppProcessInfo next;
        synchronized (b.class) {
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                a = Application.getProcessName();
                return a;
            }
            int myPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (it.hasNext()) {
                    try {
                        next = it.next();
                    } catch (Exception unused) {
                    }
                    if (next.pid == myPid) {
                        a = next.processName;
                        return a;
                    }
                    continue;
                }
            }
            return null;
        }
    }

    public static synchronized String a(String str) {
        synchronized (b.class) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String str2 = a;
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            boolean endsWith = str2.endsWith("_");
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(endsWith ? "" : "_");
            String str3 = null;
            try {
                String str4 = new String(str2);
                try {
                    str3 = d.a(MessageDigest.getInstance("MD5").digest(str4.getBytes("UTF-8")));
                } catch (Exception unused) {
                    str3 = str4;
                }
            } catch (Exception unused2) {
            }
            sb.append(str3);
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context, File file, File file2) {
        InputStream inputStream;
        String str;
        FileOutputStream fileOutputStream;
        AssetManager assets = context.getAssets();
        FileOutputStream fileOutputStream2 = null;
        try {
            h.a();
            String[] list = assets.list("gdt_plugin");
            if (Arrays.binarySearch(list, "gdtadv2.jar") < 0) {
                if (list != null && list.length > 0) {
                    str = TextUtils.join(",", list);
                    String str2 = "Asset Error " + str;
                    GDTLogger.e(str2);
                    throw new Exception(str2);
                }
                str = "no asset";
                String str22 = "Asset Error " + str;
                GDTLogger.e(str22);
                throw new Exception(str22);
            }
            String str3 = "gdt_plugin" + File.separator + "gdtadv2.jar";
            String str4 = Sig.ASSET_PLUGIN_SIG;
            if (str4 == null) {
                str4 = "";
            }
            h.c(context);
            h.e(SDKStatus.getBuildInPluginVersion() + "#####" + str4, file2);
            boolean z = true;
            if (TextUtils.isEmpty(CustomPkgConstants.getAssetPluginXorKey())) {
                z = h.a(assets.open(str3), file);
                inputStream = null;
            } else {
                inputStream = assets.open(str3);
                try {
                    if (!file.canWrite()) {
                        file.setWritable(true);
                    }
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    byte[] bytes = CustomPkgConstants.getAssetPluginXorKey().getBytes(Charset.forName("UTF-8"));
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    int length = bytes.length;
                    int i = 0;
                    int i2 = 0;
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        int i3 = 0;
                        while (i3 < read) {
                            int i4 = i2 + 1;
                            if (i2 >= 64) {
                                bArr[i3] = (byte) (bytes[i % length] ^ bArr[i3]);
                                i++;
                            }
                            i3++;
                            i2 = i4;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream2 = fileOutputStream;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    try {
                        GDTLogger.e("插件加载失败", th);
                        throw th;
                    } finally {
                        c(inputStream);
                        c(fileOutputStream2);
                    }
                }
            }
            if (z) {
                z = h.f(file, context);
            }
            if (!z) {
                throw new Exception("Plugin prepare failed");
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    private static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
