package com.qumeng.advlib.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.sigmob.sdk.downloader.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e {
    private static boolean a = true;
    private static String b;

    /* renamed from: c, reason: collision with root package name */
    private static int f26c;

    public static String a(InputStream inputStream, int i, int i2) {
        int read;
        if (inputStream == null) {
            Log.e("byteMD5", "byteMD5 cannot proceed null!");
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            try {
                if (i2 == -1) {
                    while (true) {
                        int read2 = inputStream.read(bArr);
                        if (read2 <= -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read2);
                    }
                } else {
                    while (i2 > 0) {
                        if (i2 < 1024) {
                            read = inputStream.read(bArr, 0, i2);
                        } else {
                            read = inputStream.read(bArr);
                        }
                        messageDigest.update(bArr, 0, read);
                        i2 -= read;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static long b(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[f.a.f548c];
        long j = 0;
        int i = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j;
            }
            while (i < 512) {
                bArr[i] = (byte) (bArr[i] - 1);
                i++;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }

    public static String c(Context context) {
        try {
            return (String) c.g("android.app.ActivityThread").b("currentProcessName").c();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String d(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(Context context) {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager == null ? null : packageManager.getPackageInfo(context.getPackageName(), 0);
                if (packageInfo != null) {
                    String str = packageInfo.versionName;
                    if (str == null) {
                        str = "";
                    }
                    b = str;
                    return str;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return "";
    }

    public static String a(String str, String str2) {
        Throwable th;
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                if (str2 != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Content-Type", "application/json");
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(str2.getBytes());
                    outputStream.close();
                } else {
                    httpURLConnection.setRequestMethod("GET");
                }
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    try {
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        }
                        String sb2 = sb.toString();
                        try {
                            bufferedReader2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return sb2;
                    } catch (Throwable th2) {
                        bufferedReader = bufferedReader2;
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            throw th;
                        }
                        throw th;
                    }
                }
                throw new IOException("Unexpected response code: " + responseCode);
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
        }
    }

    public static long a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[f.a.f548c];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }

    public static String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        boolean z = false;
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!z) {
                sb.append('?');
                z = true;
            } else if (z) {
                sb.append('&');
            }
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null && value != null) {
                sb.append(key);
                sb.append('=');
                try {
                    sb.append(URLEncoder.encode(value, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    sb.append("none");
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    public static int a(Context context) {
        int i = f26c;
        if (i > 0) {
            return i;
        }
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager == null ? null : packageManager.getPackageInfo(context.getPackageName(), 0);
                if (packageInfo != null) {
                    int i2 = packageInfo.versionCode;
                    f26c = i2;
                    return i2;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return 0;
    }

    public static boolean a() {
        try {
            Class.forName("androidx.appcompat.app.AppCompatActivity");
            return a;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void a(boolean z) {
        a = z;
    }
}
