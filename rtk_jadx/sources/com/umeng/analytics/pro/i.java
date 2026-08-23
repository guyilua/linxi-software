package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.e;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: UMStoreManager.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class i {
    public static final int a = 2049;
    public static final int b = 2050;

    /* renamed from: c, reason: collision with root package name */
    private static final int f1052c = 1000;
    private static Context d = null;
    private static String e = null;
    private static final String f = "umeng+";
    private static final String g = "ek__id";
    private static final String h = "ek_key";
    private List<String> i;
    private List<Integer> j;
    private String k;
    private List<String> l;

    /* compiled from: UMStoreManager.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum a {
        AUTOPAGE,
        PAGE,
        BEGIN,
        END,
        NEWSESSION,
        INSTANTSESSIONBEGIN
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UMStoreManager.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class b {
        private static final i a = new i();

        private b() {
        }
    }

    public static i a(Context context) {
        i iVar = b.a;
        if (d == null && context != null) {
            d = context.getApplicationContext();
            iVar.k();
        }
        return iVar;
    }

    private void k() {
        synchronized (this) {
            l();
            this.i.clear();
            this.l.clear();
            this.j.clear();
        }
    }

    private void l() {
        try {
            if (TextUtils.isEmpty(e)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(d, g);
                if (TextUtils.isEmpty(multiProcessSP)) {
                    multiProcessSP = PreferenceWrapper.getDefault(d).getString(g, null);
                    if (TextUtils.isEmpty(multiProcessSP)) {
                        multiProcessSP = UMUtils.genId();
                    }
                    if (!TextUtils.isEmpty(multiProcessSP)) {
                        UMUtils.setMultiProcessSP(d, g, multiProcessSP);
                    }
                }
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    String substring = multiProcessSP.substring(1, 9);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < substring.length(); i++) {
                        char charAt = substring.charAt(i);
                        if (Character.isDigit(charAt)) {
                            if (Integer.parseInt(Character.toString(charAt)) == 0) {
                                sb.append(0);
                            } else {
                                sb.append(10 - Integer.parseInt(Character.toString(charAt)));
                            }
                        } else {
                            sb.append(charAt);
                        }
                    }
                    e = sb.toString();
                }
                if (TextUtils.isEmpty(e)) {
                    return;
                }
                e += new StringBuilder(e).reverse().toString();
                String multiProcessSP2 = UMUtils.getMultiProcessSP(d, h);
                if (TextUtils.isEmpty(multiProcessSP2)) {
                    UMUtils.setMultiProcessSP(d, h, c(f));
                } else {
                    if (f.equals(d(multiProcessSP2))) {
                        return;
                    }
                    b(true, false);
                    a(true, false);
                    h();
                    i();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void b() {
        this.l.clear();
    }

    public boolean c() {
        return this.l.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006a, code lost:
    
        if (r0 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006f, code lost:
    
        r0.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0081, code lost:
    
        if (r0 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006d, code lost:
    
        if (r0 != null) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d() {
        /*
            r7 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            com.umeng.analytics.pro.u r1 = com.umeng.analytics.pro.u.a()     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            java.lang.String r1 = r1.c()     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            if (r2 == 0) goto L2b
            if (r0 == 0) goto L21
            r0.endTransaction()     // Catch: java.lang.Throwable -> L21
        L21:
            android.content.Context r0 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            return
        L2b:
            r2 = 2
            java.lang.String r3 = ""
            java.lang.String r4 = "-1"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            r4 = 0
        L35:
            if (r4 >= r2) goto L67
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            r5.<init>()     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            java.lang.String r6 = "update __et set __i=\""
            r5.append(r6)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            r5.append(r1)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            java.lang.String r6 = "\" where "
            r5.append(r6)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            java.lang.String r6 = "__i"
            r5.append(r6)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            java.lang.String r6 = "=\""
            r5.append(r6)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            r6 = r3[r4]     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            r5.append(r6)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            java.lang.String r6 = "\""
            r5.append(r6)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            r0.execSQL(r5)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            int r4 = r4 + 1
            goto L35
        L67:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            if (r0 == 0) goto L72
            goto L6f
        L6d:
            if (r0 == 0) goto L72
        L6f:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L72
        L72:
            android.content.Context r0 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto L84
        L7c:
            android.content.Context r1 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L85
            com.umeng.analytics.pro.h.a(r1)     // Catch: java.lang.Throwable -> L85
            if (r0 == 0) goto L72
            goto L6f
        L84:
            return
        L85:
            r1 = move-exception
            if (r0 == 0) goto L8b
            r0.endTransaction()     // Catch: java.lang.Throwable -> L8b
        L8b:
            android.content.Context r0 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.d():void");
    }

    public boolean e() {
        return this.i.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a1, code lost:
    
        if (r2 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0087, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0085, code lost:
    
        if (r2 != null) goto L56;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject f() {
        /*
            r14 = this;
            java.lang.String r0 = "__vc"
            java.lang.String r1 = "__av"
            java.util.List<java.lang.String> r2 = r14.l
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 == 0) goto Le
            return r3
        Le:
            android.content.Context r2 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteDatabaseCorruptException -> L95
            com.umeng.analytics.pro.g r2 = com.umeng.analytics.pro.g.a(r2)     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteDatabaseCorruptException -> L95
            android.database.sqlite.SQLiteDatabase r2 = r2.a()     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteDatabaseCorruptException -> L95
            r2.beginTransaction()     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            java.util.List<java.lang.String> r4 = r14.l     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            java.lang.String r6 = "__is"
            r7 = 0
            java.lang.String r8 = "__ii=? "
            r9 = 1
            java.lang.String[] r9 = new java.lang.String[r9]     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            r9[r5] = r4     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r4 = r14
            r5 = r6
            r6 = r2
            android.database.Cursor r4 = r4.a(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            if (r4 == 0) goto L5d
            boolean r5 = r4.moveToNext()     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            if (r5 == 0) goto L5d
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r5.<init>()     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            int r3 = r4.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r3 = r4.getString(r3)     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            int r6 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r6 = r4.getString(r6)     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r5.put(r1, r3)     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r5.put(r0, r6)     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r3 = r5
        L5d:
            r2.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            if (r4 == 0) goto L65
            r4.close()
        L65:
            if (r2 == 0) goto L6a
            r2.endTransaction()     // Catch: java.lang.Throwable -> L6a
        L6a:
            android.content.Context r0 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto La4
        L74:
            r5 = r3
        L75:
            r3 = r4
            goto L80
        L77:
            r5 = r3
        L78:
            r3 = r4
            goto L97
        L7a:
            r5 = r3
            goto L80
        L7c:
            r5 = r3
            goto L97
        L7e:
            r2 = r3
            r5 = r2
        L80:
            if (r3 == 0) goto L85
            r3.close()
        L85:
            if (r2 == 0) goto L8a
        L87:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L8a
        L8a:
            android.content.Context r0 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            r3 = r5
            goto La4
        L95:
            r2 = r3
            r5 = r2
        L97:
            android.content.Context r0 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> La5
            com.umeng.analytics.pro.h.a(r0)     // Catch: java.lang.Throwable -> La5
            if (r3 == 0) goto La1
            r3.close()
        La1:
            if (r2 == 0) goto L8a
            goto L87
        La4:
            return r3
        La5:
            r0 = move-exception
            if (r3 == 0) goto Lab
            r3.close()
        Lab:
            if (r2 == 0) goto Lb0
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lb0
        Lb0:
            android.content.Context r1 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)
            r1.b()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.f():org.json.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a1, code lost:
    
        if (r2 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0087, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0085, code lost:
    
        if (r2 != null) goto L56;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject g() {
        /*
            r14 = this;
            java.lang.String r0 = "__vc"
            java.lang.String r1 = "__av"
            java.util.List<java.lang.String> r2 = r14.i
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 == 0) goto Le
            return r3
        Le:
            android.content.Context r2 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteDatabaseCorruptException -> L95
            com.umeng.analytics.pro.g r2 = com.umeng.analytics.pro.g.a(r2)     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteDatabaseCorruptException -> L95
            android.database.sqlite.SQLiteDatabase r2 = r2.a()     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteDatabaseCorruptException -> L95
            r2.beginTransaction()     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            java.util.List<java.lang.String> r4 = r14.i     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            java.lang.String r6 = "__sd"
            r7 = 0
            java.lang.String r8 = "__ii=? "
            r9 = 1
            java.lang.String[] r9 = new java.lang.String[r9]     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            r9[r5] = r4     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r4 = r14
            r5 = r6
            r6 = r2
            android.database.Cursor r4 = r4.a(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7c
            if (r4 == 0) goto L5d
            boolean r5 = r4.moveToNext()     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            if (r5 == 0) goto L5d
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r5.<init>()     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            int r3 = r4.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r3 = r4.getString(r3)     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            int r6 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r6 = r4.getString(r6)     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r5.put(r1, r3)     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r5.put(r0, r6)     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r3 = r5
        L5d:
            r2.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            if (r4 == 0) goto L65
            r4.close()
        L65:
            if (r2 == 0) goto L6a
            r2.endTransaction()     // Catch: java.lang.Throwable -> L6a
        L6a:
            android.content.Context r0 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto La4
        L74:
            r5 = r3
        L75:
            r3 = r4
            goto L80
        L77:
            r5 = r3
        L78:
            r3 = r4
            goto L97
        L7a:
            r5 = r3
            goto L80
        L7c:
            r5 = r3
            goto L97
        L7e:
            r2 = r3
            r5 = r2
        L80:
            if (r3 == 0) goto L85
            r3.close()
        L85:
            if (r2 == 0) goto L8a
        L87:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L8a
        L8a:
            android.content.Context r0 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            r3 = r5
            goto La4
        L95:
            r2 = r3
            r5 = r2
        L97:
            android.content.Context r0 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> La5
            com.umeng.analytics.pro.h.a(r0)     // Catch: java.lang.Throwable -> La5
            if (r3 == 0) goto La1
            r3.close()
        La1:
            if (r2 == 0) goto L8a
            goto L87
        La4:
            return r3
        La5:
            r0 = move-exception
            if (r3 == 0) goto Lab
            r3.close()
        Lab:
            if (r2 == 0) goto Lb0
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lb0
        Lb0:
            android.content.Context r1 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)
            r1.b()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.g():org.json.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
    
        if (r0 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
    
        if (r0 != null) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            java.util.List<java.lang.Integer> r1 = r4.j     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            if (r1 <= 0) goto L3c
            r1 = 0
        L17:
            java.util.List<java.lang.Integer> r2 = r4.j     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            if (r1 >= r2) goto L3c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            r2.<init>()     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            java.lang.String r3 = "delete from __et where rowid="
            r2.append(r3)     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            java.util.List<java.lang.Integer> r3 = r4.j     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            r2.append(r3)     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            r0.execSQL(r2)     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            int r1 = r1 + 1
            goto L17
        L3c:
            java.util.List<java.lang.Integer> r1 = r4.j     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            r1.clear()     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            if (r0 == 0) goto L4c
            goto L49
        L47:
            if (r0 == 0) goto L4c
        L49:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L4c
        L4c:
            android.content.Context r0 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto L5e
        L56:
            android.content.Context r1 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L5f
            com.umeng.analytics.pro.h.a(r1)     // Catch: java.lang.Throwable -> L5f
            if (r0 == 0) goto L4c
            goto L49
        L5e:
            return
        L5f:
            r1 = move-exception
            if (r0 == 0) goto L65
            r0.endTransaction()     // Catch: java.lang.Throwable -> L65
        L65:
            android.content.Context r0 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.h():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        if (r0 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0019, code lost:
    
        if (r0 != null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i() {
        /*
            r2 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L19 android.database.sqlite.SQLiteDatabaseCorruptException -> L28
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L19 android.database.sqlite.SQLiteDatabaseCorruptException -> L28
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L19 android.database.sqlite.SQLiteDatabaseCorruptException -> L28
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L19 android.database.sqlite.SQLiteDatabaseCorruptException -> L28
            java.lang.String r1 = "delete from __er"
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L19 android.database.sqlite.SQLiteDatabaseCorruptException -> L28
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L19 android.database.sqlite.SQLiteDatabaseCorruptException -> L28
            if (r0 == 0) goto L1e
            goto L1b
        L19:
            if (r0 == 0) goto L1e
        L1b:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L1e
        L1e:
            android.content.Context r0 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto L30
        L28:
            android.content.Context r1 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L31
            com.umeng.analytics.pro.h.a(r1)     // Catch: java.lang.Throwable -> L31
            if (r0 == 0) goto L1e
            goto L1b
        L30:
            return
        L31:
            r1 = move-exception
            if (r0 == 0) goto L37
            r0.endTransaction()     // Catch: java.lang.Throwable -> L37
        L37:
            android.content.Context r0 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.i():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0066, code lost:
    
        if (r1 == null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0051, code lost:
    
        if (r1 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void j() {
        /*
            r5 = this;
            java.lang.String r0 = "\""
            java.lang.String r1 = r5.k
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 0
            if (r1 != 0) goto L79
            android.content.Context r1 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L50 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L50 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L50 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            r3.<init>()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            java.lang.String r4 = "delete from __er where __i=\""
            r3.append(r4)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            java.lang.String r4 = r5.k     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            r3.append(r4)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            r3.append(r0)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            r1.execSQL(r3)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            r3.<init>()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            java.lang.String r4 = "delete from __et where __i=\""
            r3.append(r4)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            java.lang.String r4 = r5.k     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            r3.append(r4)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            r3.append(r0)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            r1.execSQL(r0)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            if (r1 == 0) goto L56
            goto L53
        L50:
            r1 = r2
        L51:
            if (r1 == 0) goto L56
        L53:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L56
        L56:
            android.content.Context r0 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto L79
        L60:
            r1 = r2
        L61:
            android.content.Context r0 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L69
            com.umeng.analytics.pro.h.a(r0)     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L56
            goto L53
        L69:
            r0 = move-exception
            if (r1 == 0) goto L6f
            r1.endTransaction()     // Catch: java.lang.Throwable -> L6f
        L6f:
            android.content.Context r1 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)
            r1.b()
            throw r0
        L79:
            r5.k = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.j():void");
    }

    private i() {
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = null;
        this.l = new ArrayList();
    }

    private void b(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long longValue = ((Long) jSONObject.get("__e")).longValue();
            JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("__pp");
            String str2 = "";
            String c2 = (optJSONObject == null || optJSONObject.length() <= 0) ? "" : c(optJSONObject.toString());
            if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                str2 = c(optJSONObject2.toString());
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("__ii", str);
            contentValues.put("__e", String.valueOf(longValue));
            contentValues.put("__sp", c2);
            contentValues.put("__pp", str2);
            contentValues.put("__av", UMGlobalContext.getInstance(d).getAppVersion());
            contentValues.put("__vc", UMUtils.getAppVersionCode(d));
            sQLiteDatabase.insert(e.c.a, null, contentValues);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c(java.lang.String r20, org.json.JSONObject r21, android.database.sqlite.SQLiteDatabase r22) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.c(java.lang.String, org.json.JSONObject, android.database.sqlite.SQLiteDatabase):void");
    }

    private Cursor a(String str, SQLiteDatabase sQLiteDatabase, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        if (sQLiteDatabase == null) {
            return null;
        }
        try {
            if (sQLiteDatabase.isOpen()) {
                return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a() {
        this.i.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ae, code lost:
    
        if (r2 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x009c, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009a, code lost:
    
        if (r2 == null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(org.json.JSONArray r11) {
        /*
            r10 = this;
            java.lang.String r0 = "__t"
            java.lang.String r1 = "__i"
            r2 = 0
            android.content.Context r3 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L9a android.database.sqlite.SQLiteDatabaseCorruptException -> La9
            com.umeng.analytics.pro.g r3 = com.umeng.analytics.pro.g.a(r3)     // Catch: java.lang.Throwable -> L9a android.database.sqlite.SQLiteDatabaseCorruptException -> La9
            android.database.sqlite.SQLiteDatabase r3 = r3.a()     // Catch: java.lang.Throwable -> L9a android.database.sqlite.SQLiteDatabaseCorruptException -> La9
            r3.beginTransaction()     // Catch: java.lang.Throwable -> L96 android.database.sqlite.SQLiteDatabaseCorruptException -> L98
            r4 = 0
        L13:
            int r5 = r11.length()     // Catch: java.lang.Throwable -> L96 android.database.sqlite.SQLiteDatabaseCorruptException -> L98
            if (r4 >= r5) goto L8d
            org.json.JSONObject r5 = r11.getJSONObject(r4)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            r6.<init>()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            java.lang.String r7 = r5.optString(r1)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            java.lang.String r9 = "-1"
            if (r8 != 0) goto L34
            boolean r8 = r9.equals(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            if (r8 == 0) goto L43
        L34:
            com.umeng.analytics.pro.u r7 = com.umeng.analytics.pro.u.a()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            java.lang.String r7 = r7.b()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            if (r8 == 0) goto L43
            r7 = r9
        L43:
            r6.put(r1, r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            java.lang.String r7 = "__e"
            java.lang.String r8 = "id"
            java.lang.String r8 = r5.optString(r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            r6.put(r7, r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            int r7 = r5.optInt(r0)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            r6.put(r0, r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            java.lang.String r7 = "__av"
            android.content.Context r8 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            r6.put(r7, r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            java.lang.String r7 = "__vc"
            android.content.Context r8 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            r6.put(r7, r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            r5.remove(r1)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            r5.remove(r0)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            java.lang.String r7 = "__s"
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            java.lang.String r5 = r10.c(r5)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            r6.put(r7, r5)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            java.lang.String r5 = "__et"
            r3.insert(r5, r2, r6)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
        L8a:
            int r4 = r4 + 1
            goto L13
        L8d:
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L96 android.database.sqlite.SQLiteDatabaseCorruptException -> L98
            if (r3 == 0) goto L9f
            r3.endTransaction()     // Catch: java.lang.Throwable -> L9f
            goto L9f
        L96:
            r2 = r3
            goto L9a
        L98:
            r2 = r3
            goto La9
        L9a:
            if (r2 == 0) goto L9f
        L9c:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L9f
        L9f:
            android.content.Context r11 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r11 = com.umeng.analytics.pro.g.a(r11)
            r11.b()
            goto Lb1
        La9:
            android.content.Context r11 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> Lb2
            com.umeng.analytics.pro.h.a(r11)     // Catch: java.lang.Throwable -> Lb2
            if (r2 == 0) goto L9f
            goto L9c
        Lb1:
            return
        Lb2:
            r11 = move-exception
            if (r2 == 0) goto Lb8
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lb8
        Lb8:
            android.content.Context r0 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(org.json.JSONArray):void");
    }

    public String d(String str) {
        try {
            return TextUtils.isEmpty(e) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), e.getBytes()));
        } catch (Exception unused) {
            if (Build.VERSION.SDK_INT >= 29 && !TextUtils.isEmpty(str)) {
                try {
                    new JSONObject(str);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> UMStoreManager decrypt failed, return origin data.");
                    return str;
                } catch (Throwable unused2) {
                    return null;
                }
            }
            return null;
        }
    }

    public JSONObject b(boolean z) {
        JSONObject jSONObject = new JSONObject();
        b(jSONObject, z);
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0077, code lost:
    
        if (r1 != null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0098, code lost:
    
        com.umeng.analytics.pro.g.a(com.umeng.analytics.pro.i.d).b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a1, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0095, code lost:
    
        r1.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0093, code lost:
    
        if (r1 != null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0085, code lost:
    
        if (r1 != null) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(org.json.JSONObject r13, java.lang.String r14) {
        /*
            r12 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L88
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L88
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L88
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            boolean r2 = android.text.TextUtils.isEmpty(r14)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            if (r2 != 0) goto L2a
            java.lang.String r3 = "__er"
            r5 = 0
            java.lang.String r6 = "__i=? "
            r2 = 1
            java.lang.String[] r7 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            r2 = 0
            r7[r2] = r14     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r2 = r12
            r4 = r1
            android.database.Cursor r14 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            goto L39
        L2a:
            java.lang.String r3 = "__er"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r2 = r12
            r4 = r1
            android.database.Cursor r14 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
        L39:
            r0 = r14
            if (r0 == 0) goto L6f
            org.json.JSONArray r14 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            r14.<init>()     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
        L41:
            boolean r2 = r0.moveToNext()     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            if (r2 == 0) goto L64
            java.lang.String r2 = "__a"
            int r2 = r0.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            java.lang.String r2 = r0.getString(r2)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            if (r3 != 0) goto L41
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            java.lang.String r2 = r12.d(r2)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            r14.put(r3)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            goto L41
        L64:
            int r2 = r14.length()     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            if (r2 <= 0) goto L6f
            java.lang.String r2 = "error"
            r13.put(r2, r14)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
        L6f:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            if (r0 == 0) goto L77
            r0.close()
        L77:
            if (r1 == 0) goto L98
            goto L95
        L7a:
            r1 = r0
        L7b:
            android.content.Context r13 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> La2
            com.umeng.analytics.pro.h.a(r13)     // Catch: java.lang.Throwable -> La2
            if (r0 == 0) goto L85
            r0.close()
        L85:
            if (r1 == 0) goto L98
            goto L95
        L88:
            r1 = r0
        L89:
            android.content.Context r13 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> La2
            com.umeng.analytics.pro.h.a(r13)     // Catch: java.lang.Throwable -> La2
            if (r0 == 0) goto L93
            r0.close()
        L93:
            if (r1 == 0) goto L98
        L95:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L98
        L98:
            android.content.Context r13 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r13 = com.umeng.analytics.pro.g.a(r13)
            r13.b()
            return
        La2:
            r13 = move-exception
            if (r0 == 0) goto La8
            r0.close()
        La8:
            if (r1 == 0) goto Lad
            r1.endTransaction()     // Catch: java.lang.Throwable -> Lad
        Lad:
            android.content.Context r14 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r14 = com.umeng.analytics.pro.g.a(r14)
            r14.b()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.b(org.json.JSONObject, java.lang.String):void");
    }

    public String c(String str) {
        try {
            return TextUtils.isEmpty(e) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), e.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006c, code lost:
    
        if (r0 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005a, code lost:
    
        r0.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0058, code lost:
    
        if (r0 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.String r5, java.lang.String r6, int r7) {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteDatabaseCorruptException -> L67
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteDatabaseCorruptException -> L67
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteDatabaseCorruptException -> L67
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            r2.<init>()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            java.lang.String r3 = "__i"
            r2.put(r3, r5)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            java.lang.String r5 = r4.c(r6)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            if (r6 != 0) goto L4b
            java.lang.String r6 = "__a"
            r2.put(r6, r5)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            java.lang.String r5 = "__t"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            java.lang.String r5 = "__av"
            android.content.Context r6 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r6)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            java.lang.String r5 = "__vc"
            android.content.Context r6 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r6)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            java.lang.String r5 = "__er"
            r1.insert(r5, r0, r2)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
        L4b:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteDatabaseCorruptException -> L56
            if (r1 == 0) goto L5d
            r1.endTransaction()     // Catch: java.lang.Throwable -> L5d
            goto L5d
        L54:
            r0 = r1
            goto L58
        L56:
            r0 = r1
            goto L67
        L58:
            if (r0 == 0) goto L5d
        L5a:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L5d
        L5d:
            android.content.Context r5 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r5 = com.umeng.analytics.pro.g.a(r5)
            r5.b()
            goto L6f
        L67:
            android.content.Context r5 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L71
            com.umeng.analytics.pro.h.a(r5)     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L5d
            goto L5a
        L6f:
            r5 = 0
            return r5
        L71:
            r5 = move-exception
            if (r0 == 0) goto L77
            r0.endTransaction()     // Catch: java.lang.Throwable -> L77
        L77:
            android.content.Context r6 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r6 = com.umeng.analytics.pro.g.a(r6)
            r6.b()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(java.lang.String, java.lang.String, int):boolean");
    }

    private JSONArray b(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null && optJSONObject.optLong("duration") > 0) {
                jSONArray2.put(optJSONObject);
            }
        }
        return jSONArray2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00e6, code lost:
    
        if (r1 != null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00e8, code lost:
    
        r1.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d7, code lost:
    
        if (r1 != null) goto L65;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r13v0, types: [org.json.JSONObject] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String b(org.json.JSONObject r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.b(org.json.JSONObject, boolean):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x009b, code lost:
    
        if (r2 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0089, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0087, code lost:
    
        if (r2 == null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.String r7, org.json.JSONObject r8, com.umeng.analytics.pro.i.a r9) {
        /*
            r6 = this;
            java.lang.String r0 = "__e"
            r1 = 0
            if (r8 != 0) goto L6
            return r1
        L6:
            r2 = 0
            android.content.Context r3 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            com.umeng.analytics.pro.g r3 = com.umeng.analytics.pro.g.a(r3)     // Catch: java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            android.database.sqlite.SQLiteDatabase r3 = r3.a()     // Catch: java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            r3.beginTransaction()     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            com.umeng.analytics.pro.i$a r4 = com.umeng.analytics.pro.i.a.BEGIN     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            if (r9 != r4) goto L4f
            java.lang.Object r8 = r8.opt(r0)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            java.lang.Long r8 = (java.lang.Long) r8     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            long r8 = r8.longValue()     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            r4.<init>()     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            java.lang.String r5 = "__ii"
            r4.put(r5, r7)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            java.lang.String r7 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            r4.put(r0, r7)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            java.lang.String r7 = "__av"
            android.content.Context r8 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r8)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            r4.put(r7, r8)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            java.lang.String r7 = "__vc"
            android.content.Context r8 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r8)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            r4.put(r7, r8)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            java.lang.String r7 = "__sd"
            r3.insert(r7, r2, r4)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            goto L7a
        L4f:
            com.umeng.analytics.pro.i$a r0 = com.umeng.analytics.pro.i.a.INSTANTSESSIONBEGIN     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            if (r9 != r0) goto L57
            r6.b(r7, r8, r3)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            goto L7a
        L57:
            com.umeng.analytics.pro.i$a r0 = com.umeng.analytics.pro.i.a.END     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            if (r9 != r0) goto L5f
            r6.a(r7, r8, r3)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            goto L7a
        L5f:
            com.umeng.analytics.pro.i$a r0 = com.umeng.analytics.pro.i.a.PAGE     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            if (r9 != r0) goto L69
            java.lang.String r9 = "__a"
            r6.a(r7, r8, r3, r9)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            goto L7a
        L69:
            com.umeng.analytics.pro.i$a r0 = com.umeng.analytics.pro.i.a.AUTOPAGE     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            if (r9 != r0) goto L73
            java.lang.String r9 = "__b"
            r6.a(r7, r8, r3, r9)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            goto L7a
        L73:
            com.umeng.analytics.pro.i$a r0 = com.umeng.analytics.pro.i.a.NEWSESSION     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            if (r9 != r0) goto L7a
            r6.c(r7, r8, r3)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
        L7a:
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            if (r3 == 0) goto L8c
            r3.endTransaction()     // Catch: java.lang.Throwable -> L8c
            goto L8c
        L83:
            r2 = r3
            goto L87
        L85:
            r2 = r3
            goto L96
        L87:
            if (r2 == 0) goto L8c
        L89:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L8c
        L8c:
            android.content.Context r7 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r7 = com.umeng.analytics.pro.g.a(r7)
            r7.b()
            goto L9e
        L96:
            android.content.Context r7 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L9f
            com.umeng.analytics.pro.h.a(r7)     // Catch: java.lang.Throwable -> L9f
            if (r2 == 0) goto L8c
            goto L89
        L9e:
            return r1
        L9f:
            r7 = move-exception
            if (r2 == 0) goto La5
            r2.endTransaction()     // Catch: java.lang.Throwable -> La5
        La5:
            android.content.Context r8 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r8 = com.umeng.analytics.pro.g.a(r8)
            r8.b()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(java.lang.String, org.json.JSONObject, com.umeng.analytics.pro.i$a):boolean");
    }

    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long longValue = ((Long) jSONObject.opt(e.d.a.g)).longValue();
            long j = 0;
            Object opt = jSONObject.opt(e.d.a.h);
            if (opt != null && (opt instanceof Long)) {
                j = ((Long) opt).longValue();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("__pp");
            String str2 = "";
            String c2 = (optJSONObject == null || optJSONObject.length() <= 0) ? "" : c(optJSONObject.toString());
            if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                str2 = c(optJSONObject2.toString());
            }
            sQLiteDatabase.execSQL("update __sd set __f=\"" + longValue + "\", " + e.d.a.h + "=\"" + j + "\", __sp=\"" + c2 + "\", __pp=\"" + str2 + "\" where __ii=\"" + str + "\"");
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0067, code lost:
    
        if (r0 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:
    
        if (r0 != null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(boolean r3, boolean r4) {
        /*
            r2 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            if (r4 == 0) goto L18
            if (r3 == 0) goto L4d
            java.lang.String r3 = "delete from __sd"
            r0.execSQL(r3)     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            goto L4d
        L18:
            java.util.List<java.lang.String> r3 = r2.i     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            if (r3 <= 0) goto L4d
            r3 = 0
        L21:
            java.util.List<java.lang.String> r4 = r2.i     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            int r4 = r4.size()     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            if (r3 >= r4) goto L4d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            r4.<init>()     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            java.lang.String r1 = "delete from __sd where __ii=\""
            r4.append(r1)     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            java.util.List<java.lang.String> r1 = r2.i     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            r4.append(r1)     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            java.lang.String r1 = "\""
            r4.append(r1)     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            int r3 = r3 + 1
            goto L21
        L4d:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            if (r0 == 0) goto L58
            goto L55
        L53:
            if (r0 == 0) goto L58
        L55:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L58
        L58:
            android.content.Context r3 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r3 = com.umeng.analytics.pro.g.a(r3)
            r3.b()
            goto L6a
        L62:
            android.content.Context r3 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L6b
            com.umeng.analytics.pro.h.a(r3)     // Catch: java.lang.Throwable -> L6b
            if (r0 == 0) goto L58
            goto L55
        L6a:
            return
        L6b:
            r3 = move-exception
            if (r0 == 0) goto L71
            r0.endTransaction()     // Catch: java.lang.Throwable -> L71
        L71:
            android.content.Context r4 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r4 = com.umeng.analytics.pro.g.a(r4)
            r4.b()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.b(boolean, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003c, code lost:
    
        if (r4 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005f, code lost:
    
        r4.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005d, code lost:
    
        if (r4 != null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long a(java.lang.String r16) {
        /*
            r15 = this;
            java.lang.String r0 = "__f"
            r1 = 0
            r2 = 0
            android.content.Context r4 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L57
            com.umeng.analytics.pro.g r4 = com.umeng.analytics.pro.g.a(r4)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L57
            android.database.sqlite.SQLiteDatabase r4 = r4.a()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L57
            r4.beginTransaction()     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L58
            java.lang.String[] r8 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L58
            java.lang.String r6 = "__sd"
            java.lang.String r9 = "__ii=? "
            r5 = 1
            java.lang.String[] r10 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L58
            r5 = 0
            r10[r5] = r16     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L58
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r5 = r15
            r7 = r4
            android.database.Cursor r1 = r5.a(r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L58
            if (r1 == 0) goto L37
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L58
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L58
            long r2 = r1.getLong(r0)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L58
        L37:
            if (r1 == 0) goto L3c
            r1.close()     // Catch: java.lang.Exception -> L62
        L3c:
            if (r4 == 0) goto L62
            goto L5f
        L3f:
            r0 = move-exception
            goto L43
        L41:
            r0 = move-exception
            r4 = r1
        L43:
            if (r1 == 0) goto L48
            r1.close()     // Catch: java.lang.Exception -> L4d
        L48:
            if (r4 == 0) goto L4d
            r4.endTransaction()     // Catch: java.lang.Exception -> L4d
        L4d:
            android.content.Context r1 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)
            r1.b()
            throw r0
        L57:
            r4 = r1
        L58:
            if (r1 == 0) goto L5d
            r1.close()     // Catch: java.lang.Exception -> L62
        L5d:
            if (r4 == 0) goto L62
        L5f:
            r4.endTransaction()     // Catch: java.lang.Exception -> L62
        L62:
            android.content.Context r0 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(java.lang.String):long");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
    
        if (r0 == null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
    
        if (r0 != null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L33 android.database.sqlite.SQLiteDatabaseCorruptException -> L42
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L33 android.database.sqlite.SQLiteDatabaseCorruptException -> L42
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L33 android.database.sqlite.SQLiteDatabaseCorruptException -> L42
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L33 android.database.sqlite.SQLiteDatabaseCorruptException -> L42
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L33 android.database.sqlite.SQLiteDatabaseCorruptException -> L42
            if (r1 != 0) goto L2d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L33 android.database.sqlite.SQLiteDatabaseCorruptException -> L42
            r1.<init>()     // Catch: java.lang.Throwable -> L33 android.database.sqlite.SQLiteDatabaseCorruptException -> L42
            java.lang.String r2 = "delete from __is where __ii=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L33 android.database.sqlite.SQLiteDatabaseCorruptException -> L42
            r1.append(r4)     // Catch: java.lang.Throwable -> L33 android.database.sqlite.SQLiteDatabaseCorruptException -> L42
            java.lang.String r4 = "\""
            r1.append(r4)     // Catch: java.lang.Throwable -> L33 android.database.sqlite.SQLiteDatabaseCorruptException -> L42
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L33 android.database.sqlite.SQLiteDatabaseCorruptException -> L42
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L33 android.database.sqlite.SQLiteDatabaseCorruptException -> L42
        L2d:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L33 android.database.sqlite.SQLiteDatabaseCorruptException -> L42
            if (r0 == 0) goto L38
            goto L35
        L33:
            if (r0 == 0) goto L38
        L35:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L38
        L38:
            android.content.Context r4 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r4 = com.umeng.analytics.pro.g.a(r4)
            r4.b()
            goto L4a
        L42:
            android.content.Context r4 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L4b
            com.umeng.analytics.pro.h.a(r4)     // Catch: java.lang.Throwable -> L4b
            if (r0 == 0) goto L38
            goto L35
        L4a:
            return
        L4b:
            r4 = move-exception
            if (r0 == 0) goto L51
            r0.endTransaction()     // Catch: java.lang.Throwable -> L51
        L51:
            android.content.Context r0 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.b(java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0077 A[Catch: all -> 0x0069, TryCatch #2 {all -> 0x0069, blocks: (B:52:0x0056, B:54:0x005c, B:15:0x006c, B:17:0x0077, B:18:0x007c, B:26:0x008b, B:29:0x0091, B:31:0x0097, B:38:0x009d, B:40:0x00ab, B:33:0x009a), top: B:51:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0056 A[EXC_TOP_SPLITTER, LOOP:1: B:51:0x0056->B:54:0x005c, LOOP_START, PHI: r14
      0x0056: PHI (r14v2 java.lang.String) = (r14v7 java.lang.String), (r14v3 java.lang.String) binds: [B:14:0x0054, B:54:0x005c] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(java.lang.String r18, org.json.JSONObject r19, android.database.sqlite.SQLiteDatabase r20, java.lang.String r21) {
        /*
            r17 = this;
            r10 = r17
            r11 = r18
            r0 = r19
            r12 = r21
            java.lang.String r13 = "=\""
            java.lang.String r1 = "__b"
            java.lang.String r2 = "__a"
            r14 = 0
            boolean r3 = r2.equals(r12)     // Catch: java.lang.Throwable -> Le2
            if (r3 == 0) goto L25
            org.json.JSONArray r0 = r0.optJSONArray(r2)     // Catch: java.lang.Throwable -> Le2
            if (r0 == 0) goto L24
            int r1 = r0.length()     // Catch: java.lang.Throwable -> Le2
            if (r1 > 0) goto L22
            goto L24
        L22:
            r15 = r0
            goto L39
        L24:
            return
        L25:
            boolean r2 = r1.equals(r12)     // Catch: java.lang.Throwable -> Le2
            if (r2 == 0) goto L38
            org.json.JSONArray r0 = r0.optJSONArray(r1)     // Catch: java.lang.Throwable -> Le2
            if (r0 == 0) goto L37
            int r1 = r0.length()     // Catch: java.lang.Throwable -> Le2
            if (r1 > 0) goto L22
        L37:
            return
        L38:
            r15 = r14
        L39:
            r0 = 1
            java.lang.String[] r3 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> Le2
            r16 = 0
            r3[r16] = r12     // Catch: java.lang.Throwable -> Le2
            java.lang.String r1 = "__sd"
            java.lang.String r4 = "__ii=? "
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> Le2
            r5[r16] = r11     // Catch: java.lang.Throwable -> Le2
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r0 = r17
            r2 = r20
            android.database.Cursor r0 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> Le2
            if (r0 == 0) goto L6c
        L56:
            boolean r1 = r0.moveToNext()     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L6c
            int r1 = r0.getColumnIndex(r12)     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = r0.getString(r1)     // Catch: java.lang.Throwable -> L69
            java.lang.String r14 = r10.d(r1)     // Catch: java.lang.Throwable -> L69
            goto L56
        L69:
            r14 = r0
            goto Le3
        L6c:
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L69
            r1.<init>()     // Catch: java.lang.Throwable -> L69
            boolean r2 = android.text.TextUtils.isEmpty(r14)     // Catch: java.lang.Throwable -> L69
            if (r2 != 0) goto L7c
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L69
            r1.<init>(r14)     // Catch: java.lang.Throwable -> L69
        L7c:
            int r2 = r1.length()     // Catch: java.lang.Throwable -> L69
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r2 <= r3) goto L8a
            if (r0 == 0) goto L89
            r0.close()
        L89:
            return
        L8a:
            r2 = 0
        L8b:
            int r3 = r15.length()     // Catch: java.lang.Throwable -> L69
            if (r2 >= r3) goto L9d
            org.json.JSONObject r3 = r15.getJSONObject(r2)     // Catch: java.lang.Throwable -> L69 org.json.JSONException -> L9a
            if (r3 == 0) goto L9a
            r1.put(r3)     // Catch: java.lang.Throwable -> L69
        L9a:
            int r2 = r2 + 1
            goto L8b
        L9d:
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = r10.c(r1)     // Catch: java.lang.Throwable -> L69
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L69
            if (r2 != 0) goto Ldc
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L69
            r2.<init>()     // Catch: java.lang.Throwable -> L69
            java.lang.String r3 = "update __sd set "
            r2.append(r3)     // Catch: java.lang.Throwable -> L69
            r2.append(r12)     // Catch: java.lang.Throwable -> L69
            r2.append(r13)     // Catch: java.lang.Throwable -> L69
            r2.append(r1)     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = "\" where "
            r2.append(r1)     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = "__ii"
            r2.append(r1)     // Catch: java.lang.Throwable -> L69
            r2.append(r13)     // Catch: java.lang.Throwable -> L69
            r2.append(r11)     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = "\""
            r2.append(r1)     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L69
            r2 = r20
            r2.execSQL(r1)     // Catch: java.lang.Throwable -> L69
        Ldc:
            if (r0 == 0) goto Le8
            r0.close()
            goto Le8
        Le2:
        Le3:
            if (r14 == 0) goto Le8
            r14.close()
        Le8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(java.lang.String, org.json.JSONObject, android.database.sqlite.SQLiteDatabase, java.lang.String):void");
    }

    public JSONObject a(boolean z) {
        a();
        this.j.clear();
        JSONObject jSONObject = new JSONObject();
        if (!z) {
            a(jSONObject, z);
            b(jSONObject, (String) null);
            a(jSONObject, (String) null);
        } else {
            String a2 = a(jSONObject, z);
            if (!TextUtils.isEmpty(a2)) {
                b(jSONObject, a2);
                a(jSONObject, a2);
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x0190, code lost:
    
        if (r1 != null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0182, code lost:
    
        if (r1 != null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0174, code lost:
    
        if (r1 != null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0192, code lost:
    
        r1.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0195, code lost:
    
        com.umeng.analytics.pro.g.a(com.umeng.analytics.pro.i.d).b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x019e, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(org.json.JSONObject r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(org.json.JSONObject, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0211, code lost:
    
        if (r12 != null) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0238, code lost:
    
        com.umeng.analytics.pro.g.a(com.umeng.analytics.pro.i.d).b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0241, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0235, code lost:
    
        r12.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0233, code lost:
    
        if (r12 == null) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0224, code lost:
    
        if (r12 == null) goto L120;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0221  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String a(org.json.JSONObject r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 599
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(org.json.JSONObject, boolean):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0066, code lost:
    
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0056, code lost:
    
        if (r0 != null) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r6, boolean r7) {
        /*
            r5 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            if (r7 == 0) goto L18
            if (r6 == 0) goto L53
            java.lang.String r6 = "delete from __is"
            r0.execSQL(r6)     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            goto L53
        L18:
            java.util.List<java.lang.String> r6 = r5.l     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            r7 = 0
            if (r6 <= 0) goto L4c
            r1 = 0
        L22:
            if (r7 >= r6) goto L4b
            java.util.List<java.lang.String> r2 = r5.l     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            java.lang.Object r2 = r2.get(r7)     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            if (r2 != 0) goto L2f
            r1 = 1
        L2f:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            r3.<init>()     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            java.lang.String r4 = "delete from __is where __ii=\""
            r3.append(r4)     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            r3.append(r2)     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            java.lang.String r2 = "\""
            r3.append(r2)     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            r0.execSQL(r2)     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            int r7 = r7 + 1
            goto L22
        L4b:
            r7 = r1
        L4c:
            if (r7 == 0) goto L53
            java.lang.String r6 = "delete from __is where __ii is null"
            r0.execSQL(r6)     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
        L53:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            if (r0 == 0) goto L6b
            goto L68
        L59:
            android.content.Context r6 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L75
            com.umeng.analytics.pro.h.a(r6)     // Catch: java.lang.Throwable -> L75
            if (r0 == 0) goto L6b
            goto L68
        L61:
            android.content.Context r6 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L75
            com.umeng.analytics.pro.h.a(r6)     // Catch: java.lang.Throwable -> L75
            if (r0 == 0) goto L6b
        L68:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L6b
        L6b:
            android.content.Context r6 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r6 = com.umeng.analytics.pro.g.a(r6)
            r6.b()
            return
        L75:
            r6 = move-exception
            if (r0 == 0) goto L7b
            r0.endTransaction()     // Catch: java.lang.Throwable -> L7b
        L7b:
            android.content.Context r7 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r7 = com.umeng.analytics.pro.g.a(r7)
            r7.b()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(boolean, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x007a, code lost:
    
        if (r0 == null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0066, code lost:
    
        if (r0 != null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r4 = "\""
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            if (r1 != 0) goto L60
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            r1.<init>()     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            java.lang.String r2 = "delete from __er where __i=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            r1.append(r5)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            r1.append(r4)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            r1.<init>()     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            java.lang.String r2 = "delete from __et where __i=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            r1.append(r5)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            r1.append(r4)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            java.util.List<java.lang.Integer> r1 = r3.j     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            r1.clear()     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            r1.<init>()     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            java.lang.String r2 = "delete from __sd where __ii=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            r1.append(r5)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            r1.append(r4)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
        L60:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            if (r0 == 0) goto L6b
            goto L68
        L66:
            if (r0 == 0) goto L6b
        L68:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L6b
        L6b:
            android.content.Context r4 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r4 = com.umeng.analytics.pro.g.a(r4)
            r4.b()
            goto L7d
        L75:
            android.content.Context r4 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L7e
            com.umeng.analytics.pro.h.a(r4)     // Catch: java.lang.Throwable -> L7e
            if (r0 == 0) goto L6b
            goto L68
        L7d:
            return
        L7e:
            r4 = move-exception
            if (r0 == 0) goto L84
            r0.endTransaction()     // Catch: java.lang.Throwable -> L84
        L84:
            android.content.Context r5 = com.umeng.analytics.pro.i.d
            com.umeng.analytics.pro.g r5 = com.umeng.analytics.pro.g.a(r5)
            r5.b()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(boolean, java.lang.String):void");
    }
}
