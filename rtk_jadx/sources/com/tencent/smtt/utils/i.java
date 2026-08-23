package com.tencent.smtt.utils;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.Security;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;

/* compiled from: PostEncryption.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class i {
    private static final char[] a = "0123456789abcdef".toCharArray();
    private static i b;

    /* renamed from: c, reason: collision with root package name */
    private String f986c;
    private String d;
    private String e;

    private i() {
        int nextInt = new Random().nextInt(89999999) + 10000000;
        int nextInt2 = new Random().nextInt(89999999) + 10000000;
        this.e = String.valueOf(nextInt);
        this.f986c = this.e + String.valueOf(nextInt2);
    }

    public static synchronized i a() {
        i iVar;
        synchronized (i.class) {
            if (b == null) {
                b = new i();
            }
            iVar = b;
        }
        return iVar;
    }

    public void b() {
        Security.addProvider((Provider) Class.forName("com.android.org.bouncycastle.jce.provider.BouncyCastleProvider", true, ClassLoader.getSystemClassLoader()).newInstance());
    }

    public String c() {
        if (this.d == null) {
            byte[] bytes = this.f986c.getBytes();
            Cipher cipher = null;
            try {
                try {
                    cipher = Cipher.getInstance("RSA/ECB/NoPadding");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception unused) {
                b();
                cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            }
            cipher.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0))));
            this.d = b(cipher.doFinal(bytes));
        }
        return this.d;
    }

    public String a(String str) {
        Cipher cipher;
        byte[] bytes = str.getBytes();
        try {
            try {
                cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            } catch (Exception unused) {
                b();
                cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            }
        } catch (Exception e) {
            e.printStackTrace();
            cipher = null;
        }
        cipher.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0))));
        return b(cipher.doFinal(bytes));
    }

    private String b(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = a;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    public byte[] a(byte[] bArr) {
        return com.tencent.smtt.sdk.a.a.a(this.e.getBytes(), bArr, 1);
    }
}
