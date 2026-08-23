package com.ss.android.socialbase.appdownloader.e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.network.i;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c {
    private static int a = 8;
    private static volatile c b;

    /* renamed from: c, reason: collision with root package name */
    private a<Integer, Bitmap> f811c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a<K, T> extends LinkedHashMap<K, T> {
        final int a;

        public a(int i, int i2) {
            super(i2, 0.75f, true);
            this.a = i;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<K, T> entry) {
            return size() > this.a;
        }
    }

    private c() {
        this.f811c = null;
        int i = a;
        this.f811c = new a<>(i, i / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteArrayOutputStream b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        while (true) {
            int read = inputStream.read(bArr);
            if (read >= 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream;
            }
        }
    }

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    public Bitmap a(int i) {
        return this.f811c.get(Integer.valueOf(i));
    }

    public void a(final int i, final String str) {
        if (TextUtils.isEmpty(str) || a(i) != null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.m().submit(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.e.c.1
            @Override // java.lang.Runnable
            public void run() {
                ByteArrayOutputStream byteArrayOutputStream;
                ByteArrayInputStream byteArrayInputStream;
                Closeable closeable;
                Throwable th;
                InputStream inputStream;
                ByteArrayInputStream byteArrayInputStream2;
                Exception e;
                try {
                    try {
                        i a2 = com.ss.android.socialbase.downloader.downloader.c.a(true, 0, str, null);
                        if (a2 == null) {
                            f.a(null, null, null, null);
                            return;
                        }
                        inputStream = a2.a();
                        try {
                            byteArrayOutputStream = c.b(inputStream);
                            try {
                                byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                                try {
                                    byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                                    try {
                                        BitmapFactory.Options options = new BitmapFactory.Options();
                                        options.inJustDecodeBounds = true;
                                        BitmapFactory.decodeStream(byteArrayInputStream, null, options);
                                        int a3 = com.ss.android.socialbase.appdownloader.c.a(com.ss.android.socialbase.downloader.downloader.c.O(), 44.0f);
                                        options.inSampleSize = c.a(a3, a3, options);
                                        options.inJustDecodeBounds = false;
                                        c.this.f811c.put(Integer.valueOf(i), BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                                        f.a(inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2);
                                    } catch (Exception e2) {
                                        e = e2;
                                        e.printStackTrace();
                                        f.a(inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2);
                                    }
                                } catch (Exception e3) {
                                    byteArrayInputStream2 = null;
                                    e = e3;
                                } catch (Throwable th2) {
                                    closeable = null;
                                    th = th2;
                                    f.a(inputStream, byteArrayOutputStream, byteArrayInputStream, closeable);
                                    throw th;
                                }
                            } catch (Exception e4) {
                                byteArrayInputStream2 = null;
                                e = e4;
                                byteArrayInputStream = null;
                            } catch (Throwable th3) {
                                closeable = null;
                                th = th3;
                                byteArrayInputStream = null;
                            }
                        } catch (Exception e5) {
                            byteArrayInputStream = null;
                            byteArrayInputStream2 = null;
                            e = e5;
                            byteArrayOutputStream = null;
                        } catch (Throwable th4) {
                            byteArrayInputStream = null;
                            closeable = null;
                            th = th4;
                            byteArrayOutputStream = null;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Exception e6) {
                    byteArrayOutputStream = null;
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    e = e6;
                    inputStream = null;
                } catch (Throwable th6) {
                    byteArrayOutputStream = null;
                    byteArrayInputStream = null;
                    closeable = null;
                    th = th6;
                    inputStream = null;
                }
            }
        });
    }

    public static int a(int i, int i2, BitmapFactory.Options options) {
        int i3 = options.outWidth;
        if (i3 > i || options.outHeight > i2) {
            return Math.min(Math.round(i3 / i), Math.round(options.outHeight / i2));
        }
        return 1;
    }
}
