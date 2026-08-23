package com.sigmob.sdk.archives.utils;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class c {
    private c() {
    }

    public static long a(InputStream inputStream, OutputStream outputStream) {
        return a(inputStream, outputStream, 8024);
    }

    public static long a(InputStream inputStream, OutputStream outputStream, int i) {
        byte[] bArr = new byte[i];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }
}
