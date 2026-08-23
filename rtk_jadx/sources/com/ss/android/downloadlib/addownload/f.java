package com.ss.android.downloadlib.addownload;

import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadModel;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f {
    private final ConcurrentHashMap<String, String> a;
    private final ConcurrentHashMap<String, String> b;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        private static f a = new f();
    }

    public static f a() {
        return a.a;
    }

    private String c(String str) {
        try {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String lastPathSegment = parse.getLastPathSegment();
            if (!TextUtils.equals(BaseConstants.SCHEME_HTTPS, scheme) || !lastPathSegment.endsWith(".apk")) {
                return null;
            }
            this.a.put(str, lastPathSegment);
            return lastPathSegment;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void b(String str) {
        Iterator<Map.Entry<String, String>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (TextUtils.equals(next.getValue(), str)) {
                it.remove();
                this.a.remove(next.getKey());
            }
        }
    }

    private f() {
        this.a = new ConcurrentHashMap<>();
        this.b = new ConcurrentHashMap<>();
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || this.b.containsKey(str2)) {
            return;
        }
        this.b.put(str2, str);
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str) || this.b.isEmpty() || !this.b.containsKey(str)) {
            return null;
        }
        String c2 = c(str);
        if (this.a.containsValue(c2)) {
            for (Map.Entry<String, String> entry : this.a.entrySet()) {
                if (TextUtils.equals(entry.getValue(), c2)) {
                    String str2 = this.b.get(entry.getKey());
                    this.b.put(str, str2);
                    if (!this.a.containsKey(str)) {
                        this.a.put(str, c2);
                    }
                    return str2;
                }
            }
        }
        return this.b.get(str);
    }

    public String a(DownloadModel downloadModel) {
        String c2 = c(downloadModel.getDownloadUrl());
        if (c2 == null || TextUtils.isEmpty(c2)) {
            return null;
        }
        String e = com.ss.android.socialbase.downloader.i.f.e(c2 + downloadModel.getPackageName());
        this.b.put(downloadModel.getDownloadUrl(), e);
        return e;
    }
}
