package com.tencent.smtt.utils;

import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class LogFileUtils {
    private static OutputStream a;

    public static void closeOutputStream(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                Log.e("LOG_FILE", "Couldn't close stream!", e);
            }
        }
    }

    public static byte[] createHeaderText(String str, String str2) {
        try {
            byte[] encryptKey = encryptKey(str, str2);
            String format = String.format("%03d", Integer.valueOf(encryptKey.length));
            byte[] bArr = new byte[encryptKey.length + 3];
            bArr[0] = (byte) format.charAt(0);
            bArr[1] = (byte) format.charAt(1);
            bArr[2] = (byte) format.charAt(2);
            System.arraycopy(encryptKey, 0, bArr, 3, encryptKey.length);
            return bArr;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String createKey() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static byte[] encrypt(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher cipher = Cipher.getInstance("RC4");
            cipher.init(1, new SecretKeySpec(str.getBytes("UTF-8"), "RC4"));
            return cipher.update(bytes);
        } catch (Throwable th) {
            Log.e("LOG_FILE", "encrypt exception:" + th.getMessage());
            return null;
        }
    }

    public static byte[] encryptKey(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher cipher = Cipher.getInstance("RC4");
            cipher.init(1, new SecretKeySpec(str.getBytes("UTF-8"), "RC4"));
            return cipher.update(bytes);
        } catch (Throwable th) {
            Log.e("LOG_FILE", "encrypt exception:" + th.getMessage());
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0069, code lost:
    
        if (r6 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006b, code lost:
    
        r6.flush();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0071, code lost:
    
        if (r6 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized void writeDataToStorage(java.io.File r6, java.lang.String r7, byte[] r8, java.lang.String r9, boolean r10) {
        /*
            java.lang.Class<com.tencent.smtt.utils.LogFileUtils> r0 = com.tencent.smtt.utils.LogFileUtils.class
            monitor-enter(r0)
            byte[] r7 = encrypt(r7, r9)     // Catch: java.lang.Throwable -> L76
            r1 = 0
            if (r7 == 0) goto Lc
            r9 = r1
            goto Ld
        Lc:
            r7 = r1
        Ld:
            java.io.File r1 = r6.getParentFile()     // Catch: java.lang.Throwable -> L6f
            r1.mkdirs()     // Catch: java.lang.Throwable -> L6f
            boolean r1 = r6.isFile()     // Catch: java.lang.Throwable -> L6f
            if (r1 == 0) goto L31
            boolean r1 = r6.exists()     // Catch: java.lang.Throwable -> L6f
            if (r1 == 0) goto L31
            long r1 = r6.length()     // Catch: java.lang.Throwable -> L6f
            r3 = 2097152(0x200000, double:1.036131E-317)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L31
            r6.delete()     // Catch: java.lang.Throwable -> L6f
            r6.createNewFile()     // Catch: java.lang.Throwable -> L6f
        L31:
            java.io.OutputStream r1 = com.tencent.smtt.utils.LogFileUtils.a     // Catch: java.lang.Throwable -> L6f
            if (r1 != 0) goto L41
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L6f
            r1.<init>(r6, r10)     // Catch: java.lang.Throwable -> L6f
            java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L6f
            r6.<init>(r1)     // Catch: java.lang.Throwable -> L6f
            com.tencent.smtt.utils.LogFileUtils.a = r6     // Catch: java.lang.Throwable -> L6f
        L41:
            if (r9 == 0) goto L4d
            java.io.OutputStream r6 = com.tencent.smtt.utils.LogFileUtils.a     // Catch: java.lang.Throwable -> L6f
            byte[] r7 = r9.getBytes()     // Catch: java.lang.Throwable -> L6f
            r6.write(r7)     // Catch: java.lang.Throwable -> L6f
            goto L67
        L4d:
            java.io.OutputStream r6 = com.tencent.smtt.utils.LogFileUtils.a     // Catch: java.lang.Throwable -> L6f
            r6.write(r8)     // Catch: java.lang.Throwable -> L6f
            java.io.OutputStream r6 = com.tencent.smtt.utils.LogFileUtils.a     // Catch: java.lang.Throwable -> L6f
            r6.write(r7)     // Catch: java.lang.Throwable -> L6f
            java.io.OutputStream r6 = com.tencent.smtt.utils.LogFileUtils.a     // Catch: java.lang.Throwable -> L6f
            r7 = 2
            byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L6f
            r8 = 0
            r9 = 10
            r7[r8] = r9     // Catch: java.lang.Throwable -> L6f
            r8 = 1
            r7[r8] = r9     // Catch: java.lang.Throwable -> L6f
            r6.write(r7)     // Catch: java.lang.Throwable -> L6f
        L67:
            java.io.OutputStream r6 = com.tencent.smtt.utils.LogFileUtils.a     // Catch: java.lang.Throwable -> L76
            if (r6 == 0) goto L74
        L6b:
            r6.flush()     // Catch: java.lang.Throwable -> L74
            goto L74
        L6f:
            java.io.OutputStream r6 = com.tencent.smtt.utils.LogFileUtils.a     // Catch: java.lang.Throwable -> L76
            if (r6 == 0) goto L74
            goto L6b
        L74:
            monitor-exit(r0)
            return
        L76:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.LogFileUtils.writeDataToStorage(java.io.File, java.lang.String, byte[], java.lang.String, boolean):void");
    }
}
