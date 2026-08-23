package com.qq.e.comm.managers.plugin;

import android.text.TextUtils;
import android.util.Base64;
import com.qq.e.comm.util.GDTLogger;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class c {

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f21c = {82, com.sigmob.sdk.archives.tar.e.Q, 65, 47, 69, 67, 66, 47, 80, 75, 67, com.sigmob.sdk.archives.tar.e.Q, com.sigmob.sdk.archives.tar.e.I, 80, 97, 100, 100, 105, 110, com.sigmob.sdk.archives.tar.e.T};
    private PublicKey a;
    private final boolean b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class b {
        public static final c a = new c();
    }

    private c() {
        boolean z;
        try {
            this.a = a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKta2b5Vw5YkWHCAj4rJCwS227\r/35FZ29e4I6pS2B8zSq2RgBpXUuMg7oZF1Qt3x0iyg8PeyblyNeCRB6gIMehFThe\r1Y7m1FaQyaZp+CJYOTLM4/THKp9UndrEgJ/5a83vP1375YCV2lMvWARrNlBep4RN\rnESUJhQz58Gr/F39TwIDAQAB");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        this.b = z;
    }

    private PublicKey a(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NullPointerException unused) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("公钥非法");
        }
    }

    public boolean a(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (!this.b) {
            return true;
        }
        if (this.a != null) {
            byte[] decode = Base64.decode(str, 0);
            try {
                Cipher cipher = Cipher.getInstance(new String(f21c, "UTF-8"));
                cipher.init(2, this.a);
                str3 = new String(cipher.doFinal(decode), "UTF-8").trim();
            } catch (Throwable unused) {
                GDTLogger.d("ErrorWhileVerifySigNature");
            }
            boolean equals = str2.equals(str3);
            GDTLogger.d("Verify Result" + equals + "src=" + str2 + " & target=" + str3);
            return equals;
        }
        str3 = null;
        boolean equals2 = str2.equals(str3);
        GDTLogger.d("Verify Result" + equals2 + "src=" + str2 + " & target=" + str3);
        return equals2;
    }

    public boolean a(String str, File file) {
        String str2;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.exists()) {
            FileInputStream fileInputStream = null;
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[f.a.d];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    str2 = d.a(messageDigest.digest());
                    try {
                        fileInputStream2.close();
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    str2 = "";
                    return a(str, str2);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused5) {
            } catch (Throwable th2) {
                th = th2;
            }
            return a(str, str2);
        }
        str2 = "";
        return a(str, str2);
    }
}
