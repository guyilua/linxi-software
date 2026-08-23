package com.sigmob.sdk.videocache;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class f {
    private static final Pattern d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final Pattern e = Pattern.compile("GET /(.*) HTTP");
    public final String a;
    public final long b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f661c;

    public f(String str) {
        o.a(str);
        long a = a(str);
        this.b = Math.max(0L, a);
        this.f661c = a >= 0;
        this.a = b(str);
    }

    private long a(String str) {
        Matcher matcher = d.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    public static f a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return new f(sb.toString());
            }
            sb.append(readLine);
            sb.append('\n');
        }
    }

    private String b(String str) {
        Matcher matcher = e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.b + ", partial=" + this.f661c + ", uri='" + this.a + "'}";
    }
}
