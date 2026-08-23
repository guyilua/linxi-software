package com.sigmob.sdk.archives;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d {
    public static final String a = "ar";
    public static final String b = "cpio";

    /* renamed from: c, reason: collision with root package name */
    public static final String f342c = "dump";
    public static final String d = "jar";
    public static final String e = "zip";
    private static final String f = "tar";

    public c a(InputStream inputStream) {
        if (inputStream == null) {
            throw new IllegalArgumentException("Stream must not be null.");
        }
        if (!inputStream.markSupported()) {
            throw new IllegalArgumentException("Mark is not supported.");
        }
        byte[] bArr = new byte[12];
        inputStream.mark(12);
        try {
            inputStream.read(bArr);
            inputStream.reset();
            inputStream.mark(32);
            inputStream.read(new byte[32]);
            inputStream.reset();
            byte[] bArr2 = new byte[512];
            inputStream.mark(512);
            int read = inputStream.read(bArr2);
            inputStream.reset();
            if (com.sigmob.sdk.archives.tar.b.a(bArr2, read)) {
                return new com.sigmob.sdk.archives.tar.b(inputStream);
            }
            new com.sigmob.sdk.archives.tar.b(new ByteArrayInputStream(bArr2)).a();
            return new com.sigmob.sdk.archives.tar.b(inputStream);
        } catch (IOException e2) {
            throw new b("Could not use reset and mark operations.", e2);
        }
    }

    public c a(String str, InputStream inputStream) {
        if (str == null) {
            throw new IllegalArgumentException("Archivername must not be null.");
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("InputStream must not be null.");
        }
        if (f.equalsIgnoreCase(str)) {
            return new com.sigmob.sdk.archives.tar.b(inputStream);
        }
        throw new b("Archiver: " + str + " not found.");
    }
}
