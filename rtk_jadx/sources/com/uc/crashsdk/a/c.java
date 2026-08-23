package com.uc.crashsdk.a;

import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: ProGuard */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c {
    static final /* synthetic */ boolean a = true;
    private static String b = "";

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, true, false);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, true, true);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        return a(bArr, bArr2, z, true);
    }

    private static boolean b(File file, String str, String str2) {
        try {
            byte[] a2 = a(file);
            if (a2 != null && a2.length != 0) {
                return a(a2, str, str2);
            }
            return false;
        } catch (Exception e) {
            g.a(e);
            return false;
        }
    }

    private static byte[] a(byte[] bArr, byte[] bArr2, boolean z, boolean z2) {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(z ? 1 : 2, secretKeySpec, ivParameterSpec);
        if (!z) {
            return cipher.doFinal(bArr);
        }
        if (!z2) {
            bArr = a(bArr);
        }
        return cipher.doFinal(bArr);
    }

    private static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 16];
        int length = bArr.length;
        bArr2[0] = (byte) ((length >> 0) & 255);
        bArr2[1] = (byte) ((length >> 8) & 255);
        bArr2[2] = (byte) ((length >> 16) & 255);
        bArr2[3] = (byte) ((length >> 24) & 255);
        for (int i = 4; i < 16; i++) {
            bArr2[i] = 0;
        }
        System.arraycopy(bArr, 0, bArr2, 16, bArr.length);
        return bArr2;
    }

    public static byte[] a() {
        return new byte[]{com.sigmob.sdk.archives.tar.e.H, 25, 6, com.sigmob.sdk.archives.tar.e.O};
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.ByteArrayOutputStream, java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] a(java.lang.String r7, byte[] r8) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L89
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L89
            java.net.URLConnection r7 = r1.openConnection()     // Catch: java.lang.Throwable -> L89
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch: java.lang.Throwable -> L89
            r1 = 5000(0x1388, float:7.006E-42)
            r7.setConnectTimeout(r1)     // Catch: java.lang.Throwable -> L87
            r7.setReadTimeout(r1)     // Catch: java.lang.Throwable -> L87
            r1 = 1
            r7.setDoInput(r1)     // Catch: java.lang.Throwable -> L87
            r7.setDoOutput(r1)     // Catch: java.lang.Throwable -> L87
            java.lang.String r1 = "POST"
            r7.setRequestMethod(r1)     // Catch: java.lang.Throwable -> L87
            r1 = 0
            r7.setUseCaches(r1)     // Catch: java.lang.Throwable -> L87
            java.lang.String r2 = "Content-Type"
            java.lang.String r3 = "application/x-www-form-urlencoded"
            r7.setRequestProperty(r2, r3)     // Catch: java.lang.Throwable -> L87
            java.lang.String r2 = "Content-Length"
            int r3 = r8.length     // Catch: java.lang.Throwable -> L87
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L87
            r7.setRequestProperty(r2, r3)     // Catch: java.lang.Throwable -> L87
            java.io.OutputStream r2 = r7.getOutputStream()     // Catch: java.lang.Throwable -> L87
            r2.write(r8)     // Catch: java.lang.Throwable -> L84
            int r8 = r7.getResponseCode()     // Catch: java.lang.Throwable -> L84
            r3 = 200(0xc8, float:2.8E-43)
            if (r8 == r3) goto L53
            com.uc.crashsdk.a.g.a(r2)
            com.uc.crashsdk.a.g.a(r0)
            com.uc.crashsdk.a.g.a(r0)
            if (r7 == 0) goto L52
            r7.disconnect()     // Catch: java.lang.Throwable -> L52
        L52:
            return r0
        L53:
            java.io.InputStream r8 = r7.getInputStream()     // Catch: java.lang.Throwable -> L84
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L82
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L82
            int r5 = r8.available()     // Catch: java.lang.Throwable -> L82
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L82
        L64:
            int r5 = r8.read(r3)     // Catch: java.lang.Throwable -> L8d
            r6 = -1
            if (r5 == r6) goto L6f
            r4.write(r3, r1, r5)     // Catch: java.lang.Throwable -> L8d
            goto L64
        L6f:
            byte[] r0 = r4.toByteArray()     // Catch: java.lang.Throwable -> L8d
            com.uc.crashsdk.a.g.a(r2)
            com.uc.crashsdk.a.g.a(r8)
            com.uc.crashsdk.a.g.a(r4)
            if (r7 == 0) goto L81
            r7.disconnect()     // Catch: java.lang.Throwable -> L81
        L81:
            return r0
        L82:
            r4 = r0
            goto L8d
        L84:
            r8 = r0
            r4 = r8
            goto L8d
        L87:
            r8 = r0
            goto L8b
        L89:
            r7 = r0
            r8 = r7
        L8b:
            r2 = r8
            r4 = r2
        L8d:
            com.uc.crashsdk.a.g.a(r2)
            com.uc.crashsdk.a.g.a(r8)
            com.uc.crashsdk.a.g.a(r4)
            if (r7 == 0) goto L9b
            r7.disconnect()     // Catch: java.lang.Throwable -> L9b
        L9b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.c.a(java.lang.String, byte[]):byte[]");
    }

    public static void a(byte[] bArr, int i, byte[] bArr2) {
        if (!a && bArr2.length != 4) {
            throw new AssertionError();
        }
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2 + i] = bArr2[i2];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v6 */
    private static byte[] a(File file) {
        FileInputStream fileInputStream;
        byte[] bArr;
        int length;
        BufferedInputStream bufferedInputStream;
        ?? r1 = 0;
        byte[] bArr2 = null;
        r1 = null;
        Closeable closeable = null;
        r1 = 0;
        try {
            if (!file.isFile()) {
                return null;
            }
            try {
                length = (int) file.length();
                fileInputStream = new FileInputStream(file);
                try {
                    bufferedInputStream = new BufferedInputStream(fileInputStream);
                } catch (Exception e) {
                    e = e;
                    bArr = null;
                }
            } catch (Exception e2) {
                e = e2;
                bArr = null;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                bArr2 = new byte[length];
                int i = 0;
                while (i < length) {
                    int read = bufferedInputStream.read(bArr2, i, length - i);
                    if (-1 == read) {
                        break;
                    }
                    i += read;
                }
                g.a(bufferedInputStream);
                g.a(fileInputStream);
                r1 = bArr2;
            } catch (Exception e3) {
                e = e3;
                byte[] bArr3 = bArr2;
                closeable = bufferedInputStream;
                bArr = bArr3;
                g.b(e);
                g.a(closeable);
                g.a(fileInputStream);
                r1 = bArr;
                return r1;
            } catch (Throwable th2) {
                th = th2;
                r1 = bufferedInputStream;
                g.a((Closeable) r1);
                g.a(fileInputStream);
                throw th;
            }
            return r1;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static boolean a(File file, String str, String str2) {
        for (int i = 0; i < 2; i++) {
            if (b(file, str, str2)) {
                return true;
            }
            a.a("crashsdk", "upload try again: " + str);
        }
        return false;
    }

    private static boolean a(byte[] bArr, String str, String str2) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        ByteArrayOutputStream byteArrayOutputStream;
        a.a("Uploading to " + str2);
        OutputStream outputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            try {
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(BaseConstants.Time.MINUTE);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                StringBuilder sb = new StringBuilder();
                sb.append("------------izQ290kHh6g3Yn2IeyJCoc\r\n");
                sb.append("Content-Disposition: form-data; name=\"file\";");
                sb.append(" filename=\"");
                sb.append(str);
                sb.append("\"\r\n");
                sb.append("Content-Type: application/octet-stream\r\n");
                sb.append("\r\n");
                int length = sb.length() + 40 + bArr.length;
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=----------izQ290kHh6g3Yn2IeyJCoc");
                httpURLConnection.setRequestProperty(com.sigmob.sdk.downloader.core.c.j, "form-data; name=\"file\"; filename=" + str);
                httpURLConnection.setRequestProperty(com.sigmob.sdk.downloader.core.c.e, String.valueOf(length));
                OutputStream outputStream2 = httpURLConnection.getOutputStream();
                try {
                    outputStream2.write(sb.toString().getBytes());
                    outputStream2.write(bArr);
                    outputStream2.write("\r\n------------izQ290kHh6g3Yn2IeyJCoc--\r\n".getBytes());
                    int responseCode = httpURLConnection.getResponseCode();
                    a.a("crashsdk", "Response code: " + responseCode);
                    if (responseCode != 200) {
                        g.a(outputStream2);
                        g.a((Closeable) null);
                        g.a((Closeable) null);
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable unused) {
                            }
                        }
                        return false;
                    }
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byte[] bArr2 = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                        byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
                        while (true) {
                            try {
                                int read = inputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            } catch (Throwable th) {
                                th = th;
                                outputStream = outputStream2;
                                try {
                                    g.b(th);
                                    if (httpURLConnection != null) {
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    return false;
                                } finally {
                                    g.a(outputStream);
                                    g.a(inputStream);
                                    g.a(byteArrayOutputStream);
                                    if (httpURLConnection != null) {
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (Throwable unused3) {
                                        }
                                    }
                                }
                            }
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (byteArray != null) {
                            a.a("crashsdk", "Log upload response: " + new String(byteArray));
                            g.a(outputStream2);
                            g.a(inputStream);
                            g.a(byteArrayOutputStream);
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Throwable unused4) {
                                }
                            }
                            return true;
                        }
                        g.a(outputStream2);
                        g.a(inputStream);
                        g.a(byteArrayOutputStream);
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable unused5) {
                            }
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    byteArrayOutputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            httpURLConnection = null;
            byteArrayOutputStream = null;
        }
    }
}
