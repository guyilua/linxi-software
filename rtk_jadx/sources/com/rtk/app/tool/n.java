package com.rtk.app.tool;

import com.umeng.analytics.pro.bz;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MD5.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class n {
    public static String a(MessageDigest messageDigest) {
        StringBuilder sb = new StringBuilder();
        for (byte b : messageDigest.digest()) {
            sb.append(Integer.toHexString((b >> 4) & 15));
            sb.append(Integer.toHexString(b & bz.m));
        }
        return sb.toString();
    }

    public static String b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return a(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final String c(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i = 0;
            for (byte b : digest) {
                int i2 = i + 1;
                cArr2[i] = cArr[(b >>> 4) & 15];
                i = i2 + 1;
                cArr2[i2] = cArr[b & bz.m];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }
}
