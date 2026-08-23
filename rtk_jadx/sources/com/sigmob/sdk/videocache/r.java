package com.sigmob.sdk.videocache;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.czhj.sdk.logger.SigmobLog;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class r {
    static final int a = 8192;
    static final int b = 16;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    private static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b2)));
        }
        return stringBuffer.toString();
    }

    static String a(byte[] bArr, int i) {
        int min = Math.min(16, Math.max(i, 0));
        String arrays = Arrays.toString(Arrays.copyOfRange(bArr, 0, min));
        if (min >= i) {
            return arrays;
        }
        return arrays.substring(0, arrays.length() - 1) + ", ...]";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                SigmobLog.e("Error closing resource", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(byte[] bArr, long j, int i) {
        o.a(bArr, "Buffer must be not null!");
        o.a(j >= 0, "Data offset must be positive!");
        o.a(i >= 0 && i <= bArr.length, "Length must be in range [0..buffer.length]");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error encoding url", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error decoding url", e);
        }
    }

    public static String d(String str) {
        try {
            return a(MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }
}
