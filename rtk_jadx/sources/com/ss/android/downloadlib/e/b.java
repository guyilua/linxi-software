package com.ss.android.downloadlib.e;

import android.text.TextUtils;
import androidx.annotation.NonNull;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a<T> {
        T b();
    }

    public static <T> T a(boolean z, String str, @NonNull a<T> aVar) {
        try {
            return aVar.b();
        } catch (Throwable th) {
            if (!(th instanceof com.ss.android.downloadlib.e.a)) {
                c.a().a(z, th, str);
                if (TextUtils.isEmpty(str)) {
                    throw th;
                }
                return null;
            }
            throw th;
        }
    }

    public static <T> T a(a<T> aVar) {
        return (T) a(true, null, aVar);
    }

    public static void a(final Runnable runnable) {
        a(new a<Void>() { // from class: com.ss.android.downloadlib.e.b.1
            @Override // com.ss.android.downloadlib.e.b.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void b() {
                runnable.run();
                return null;
            }
        });
    }
}
