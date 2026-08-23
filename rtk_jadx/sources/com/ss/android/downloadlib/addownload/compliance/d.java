package com.ss.android.downloadlib.addownload.compliance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.g.c;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.network.i;
import java.io.BufferedInputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d extends com.ss.android.socialbase.downloader.i.h<Long, Bitmap> {
    private final Map<Long, SoftReference<a>> a;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a(Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class b {
        private static d a = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(int i, int i2, BitmapFactory.Options options) {
        int i3 = options.outWidth;
        if (i3 > i || options.outHeight > i2) {
            return Math.min(Math.round(i3 / i), Math.round(options.outHeight / i2));
        }
        return 1;
    }

    private d() {
        super(8, 8);
        this.a = new HashMap();
    }

    public static d a() {
        return b.a;
    }

    public void a(long j, @NonNull a aVar) {
        if (get(Long.valueOf(j)) != null) {
            aVar.a(get(Long.valueOf(j)));
        } else {
            this.a.put(Long.valueOf(j), new SoftReference<>(aVar));
        }
    }

    public void a(final long j, final long j2, final String str) {
        if (get(Long.valueOf(j)) != null) {
            SoftReference<a> remove = this.a.remove(Long.valueOf(j));
            if (remove == null || remove.get() == null) {
                return;
            }
            remove.get().a(get(Long.valueOf(j)));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            g.a(12, j2);
        } else {
            com.ss.android.downloadlib.g.c.a((c.a<Object, R>) new c.a<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.d.2
                @Override // com.ss.android.downloadlib.g.c.a
                public Object a(Object obj) {
                    BufferedInputStream bufferedInputStream;
                    Throwable th;
                    i a2;
                    try {
                        a2 = com.ss.android.socialbase.downloader.downloader.c.a(true, 0, str, null);
                    } catch (Exception e) {
                        e = e;
                        bufferedInputStream = null;
                    } catch (Throwable th2) {
                        bufferedInputStream = null;
                        th = th2;
                        com.ss.android.socialbase.downloader.i.f.a(bufferedInputStream);
                        throw th;
                    }
                    if (a2 == null) {
                        com.ss.android.socialbase.downloader.i.f.a(null);
                        return null;
                    }
                    bufferedInputStream = new BufferedInputStream(a2.a());
                    try {
                        try {
                            bufferedInputStream.mark(bufferedInputStream.available());
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            BitmapFactory.decodeStream(bufferedInputStream, null, options);
                            int i = options.outWidth;
                            int i2 = options.outHeight;
                            int a3 = m.a(k.a(), 60.0f);
                            options.inSampleSize = d.b(a3, a3, options);
                            options.inJustDecodeBounds = false;
                            bufferedInputStream.reset();
                            Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.putOpt("ttdownloader_type", "load_bitmap");
                                jSONObject.putOpt("bm_original_w", Integer.valueOf(i));
                                jSONObject.putOpt("bm_original_h", Integer.valueOf(i2));
                                jSONObject.putOpt("bm_bytes", Integer.valueOf(decodeStream == null ? -1 : decodeStream.getByteCount()));
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            com.ss.android.downloadlib.d.a.a().a("ttd_pref_monitor", jSONObject, j2);
                            d.this.put(Long.valueOf(j), decodeStream);
                            com.ss.android.socialbase.downloader.i.f.a(bufferedInputStream);
                        } catch (Exception e3) {
                            e = e3;
                            com.ss.android.downloadlib.e.c.a().a(e, "BitmapCache loadBitmap");
                            com.ss.android.socialbase.downloader.i.f.a(bufferedInputStream);
                            return null;
                        }
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        com.ss.android.socialbase.downloader.i.f.a(bufferedInputStream);
                        throw th;
                    }
                }
            }, (Object) null).a(new c.a<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.d.1
                @Override // com.ss.android.downloadlib.g.c.a
                public Object a(Object obj) {
                    SoftReference softReference = (SoftReference) d.this.a.remove(Long.valueOf(j));
                    if (softReference == null || softReference.get() == null) {
                        return null;
                    }
                    ((a) softReference.get()).a(d.this.get(Long.valueOf(j)));
                    return null;
                }
            }).a();
        }
    }
}
