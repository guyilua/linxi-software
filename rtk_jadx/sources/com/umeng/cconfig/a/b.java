package com.umeng.cconfig.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    private static SQLiteOpenHelper f1073c;
    private static Context d;
    public SQLiteDatabase a;
    private AtomicInteger b;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class a {
        private static final b a = new b(0);
    }

    private b() {
        this.b = new AtomicInteger();
    }

    /* synthetic */ b(byte b) {
        this();
    }

    public static b a(Context context) {
        if (d == null && context != null) {
            Context applicationContext = context.getApplicationContext();
            d = applicationContext;
            f1073c = com.umeng.cconfig.a.a.a(applicationContext);
        }
        return a.a;
    }

    public final synchronized SQLiteDatabase a() {
        if (this.b.incrementAndGet() == 1) {
            this.a = f1073c.getWritableDatabase();
        }
        return this.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0041, code lost:
    
        if (r7 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = 1
            r6.a()     // Catch: java.lang.Throwable -> L3f android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            android.database.sqlite.SQLiteDatabase r2 = r6.a     // Catch: java.lang.Throwable -> L3f android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            r2.beginTransaction()     // Catch: java.lang.Throwable -> L3f android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3f android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            java.lang.String r3 = "update  __cc set __a=\"1\" where __ts=\""
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L3f android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            r2.append(r7)     // Catch: java.lang.Throwable -> L3f android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            java.lang.String r7 = "\""
            r2.append(r7)     // Catch: java.lang.Throwable -> L3f android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            java.lang.String r7 = r2.toString()     // Catch: java.lang.Throwable -> L3f android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            java.lang.String r2 = "jessie"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L3f android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            java.lang.String r4 = "[DbManager] updateCloudConfigByTimestamp："
            java.lang.String r5 = java.lang.String.valueOf(r7)     // Catch: java.lang.Throwable -> L3f android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            java.lang.String r4 = r4.concat(r5)     // Catch: java.lang.Throwable -> L3f android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            r3[r0] = r4     // Catch: java.lang.Throwable -> L3f android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            com.umeng.commonsdk.statistics.common.ULog.i(r2, r3)     // Catch: java.lang.Throwable -> L3f android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            android.database.sqlite.SQLiteDatabase r2 = r6.a     // Catch: java.lang.Throwable -> L3f android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            r2.execSQL(r7)     // Catch: java.lang.Throwable -> L3f android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            android.database.sqlite.SQLiteDatabase r7 = r6.a     // Catch: java.lang.Throwable -> L3f android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            r7.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L3f android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            android.database.sqlite.SQLiteDatabase r7 = r6.a     // Catch: java.lang.Throwable -> L46
            if (r7 == 0) goto L46
            goto L43
        L3f:
            android.database.sqlite.SQLiteDatabase r7 = r6.a     // Catch: java.lang.Throwable -> L46
            if (r7 == 0) goto L46
        L43:
            r7.endTransaction()     // Catch: java.lang.Throwable -> L46
        L46:
            r6.b()
            r0 = 1
            goto L59
        L4b:
            r7 = move-exception
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L5a
            android.database.sqlite.SQLiteDatabase r7 = r6.a     // Catch: java.lang.Throwable -> L56
            if (r7 == 0) goto L56
            r7.endTransaction()     // Catch: java.lang.Throwable -> L56
        L56:
            r6.b()
        L59:
            return r0
        L5a:
            r7 = move-exception
            android.database.sqlite.SQLiteDatabase r0 = r6.a     // Catch: java.lang.Throwable -> L64
            if (r0 == 0) goto L64
            android.database.sqlite.SQLiteDatabase r0 = r6.a     // Catch: java.lang.Throwable -> L64
            r0.endTransaction()     // Catch: java.lang.Throwable -> L64
        L64:
            r6.b()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.cconfig.a.b.a(java.lang.String):boolean");
    }

    public final synchronized void b() {
        try {
            if (this.b.decrementAndGet() == 0) {
                this.a.close();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0100, code lost:
    
        if (r13 == null) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.cconfig.a.b.b(java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00aa, code lost:
    
        if (r1 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a1, code lost:
    
        if (r1 == null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.umeng.cconfig.b.d c() {
        /*
            r11 = this;
            com.umeng.cconfig.b.d r0 = new com.umeng.cconfig.b.d
            r0.<init>()
            r11.a()     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            android.database.sqlite.SQLiteDatabase r1 = r11.a     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            java.lang.String r1 = "select *  from __cc where __a=\"1\" group by __ts"
            android.database.sqlite.SQLiteDatabase r2 = r11.a     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            r3 = 0
            android.database.Cursor r1 = r2.rawQuery(r1, r3)     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            if (r1 == 0) goto L95
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            if (r2 == 0) goto L95
            java.lang.String r2 = "__ts"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            java.lang.String r3 = "__c"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            java.lang.String r4 = "__a"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            java.lang.String r4 = r1.getString(r4)     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            java.lang.String r5 = "id"
            int r5 = r1.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            java.lang.String r1 = r1.getString(r5)     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            r5.<init>()     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            java.lang.String r6 = "timeStamp = %s, content = %s, active = %s, id = %s"
            r7 = 4
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            r8 = 0
            r7[r8] = r2     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            r9 = 1
            r7[r9] = r3     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            r10 = 2
            r7[r10] = r4     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            r10 = 3
            r7[r10] = r1     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            java.lang.String r1 = java.lang.String.format(r6, r7)     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            r5.append(r1)     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            java.lang.String r1 = "\n"
            r5.append(r1)     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            java.lang.String r1 = r5.toString()     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            java.lang.String r5 = "jessie"
            java.lang.Object[] r6 = new java.lang.Object[r9]     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            java.lang.String r7 = "[DbManager] selectRecentActiveOne"
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            java.lang.String r1 = r7.concat(r1)     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            r6[r8] = r1     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            com.umeng.commonsdk.statistics.common.ULog.i(r5, r6)     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            com.umeng.cconfig.b.d r1 = new com.umeng.cconfig.b.d     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            r1.<init>()     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            r1.a = r2     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            r1.b = r3     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            r1.f1077c = r4     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            android.database.sqlite.SQLiteDatabase r0 = r11.a     // Catch: java.lang.Throwable -> L91
            if (r0 == 0) goto L91
            r0.endTransaction()     // Catch: java.lang.Throwable -> L91
        L91:
            r11.b()
            return r1
        L95:
            android.database.sqlite.SQLiteDatabase r1 = r11.a     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L9f android.database.sqlite.SQLiteDatabaseCorruptException -> La4
            android.database.sqlite.SQLiteDatabase r1 = r11.a     // Catch: java.lang.Throwable -> Laf
            if (r1 == 0) goto Laf
            goto Lac
        L9f:
            android.database.sqlite.SQLiteDatabase r1 = r11.a     // Catch: java.lang.Throwable -> Laf
            if (r1 == 0) goto Laf
            goto Lac
        La4:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> Lb3
            android.database.sqlite.SQLiteDatabase r1 = r11.a     // Catch: java.lang.Throwable -> Laf
            if (r1 == 0) goto Laf
        Lac:
            r1.endTransaction()     // Catch: java.lang.Throwable -> Laf
        Laf:
            r11.b()
            return r0
        Lb3:
            r0 = move-exception
            android.database.sqlite.SQLiteDatabase r1 = r11.a     // Catch: java.lang.Throwable -> Lbd
            if (r1 == 0) goto Lbd
            android.database.sqlite.SQLiteDatabase r1 = r11.a     // Catch: java.lang.Throwable -> Lbd
            r1.endTransaction()     // Catch: java.lang.Throwable -> Lbd
        Lbd:
            r11.b()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.cconfig.a.b.c():com.umeng.cconfig.b.d");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ba, code lost:
    
        if (r0 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b1, code lost:
    
        if (r0 == null) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d() {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r8.a()     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            android.database.sqlite.SQLiteDatabase r2 = r8.a     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            r2.beginTransaction()     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            java.lang.String r2 = "select *  from __cc where __a=\"0\" order by __ts asc"
            android.database.sqlite.SQLiteDatabase r3 = r8.a     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            r4 = 0
            android.database.Cursor r2 = r3.rawQuery(r2, r4)     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            if (r2 == 0) goto L2d
        L19:
            boolean r3 = r2.moveToNext()     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            if (r3 == 0) goto L2d
            java.lang.String r3 = "__ts"
            int r3 = r2.getColumnIndex(r3)     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            java.lang.String r3 = r2.getString(r3)     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            r0.add(r3)     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            goto L19
        L2d:
            java.lang.String r2 = "delete from __cc where "
            int r3 = r0.size()     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            int r3 = r3 + (-5)
            java.lang.String r4 = ""
            if (r3 <= 0) goto Laa
            r5 = 0
        L3a:
            if (r5 >= r3) goto L7d
            int r6 = r3 + (-1)
            java.lang.String r7 = "__ts=\""
            if (r5 == r6) goto L60
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            r6.<init>()     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            r6.append(r4)     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            r6.append(r7)     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            java.lang.Object r4 = r0.get(r5)     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            r6.append(r4)     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            java.lang.String r4 = "\" or "
            r6.append(r4)     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
        L5b:
            java.lang.String r4 = r6.toString()     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            goto L7a
        L60:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            r6.<init>()     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            r6.append(r4)     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            r6.append(r7)     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            java.lang.Object r4 = r0.get(r5)     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            r6.append(r4)     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            java.lang.String r4 = "\""
            r6.append(r4)     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            goto L5b
        L7a:
            int r5 = r5 + 1
            goto L3a
        L7d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            r0.<init>()     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            r0.append(r2)     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            r0.append(r4)     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            java.lang.String r2 = "jessie"
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            java.lang.String r4 = "[DbManager] deleteExtraCloudConfigInfo: "
            java.lang.String r5 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            java.lang.String r4 = r4.concat(r5)     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            r3[r1] = r4     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            com.umeng.commonsdk.statistics.common.ULog.i(r2, r3)     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            android.database.sqlite.SQLiteDatabase r2 = r8.a     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            r2.execSQL(r0)     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            android.database.sqlite.SQLiteDatabase r0 = r8.a     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> Laf android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4
        Laa:
            android.database.sqlite.SQLiteDatabase r0 = r8.a     // Catch: java.lang.Throwable -> Lbf
            if (r0 == 0) goto Lbf
            goto Lbc
        Laf:
            android.database.sqlite.SQLiteDatabase r0 = r8.a     // Catch: java.lang.Throwable -> Lbf
            if (r0 == 0) goto Lbf
            goto Lbc
        Lb4:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> Lc3
            android.database.sqlite.SQLiteDatabase r0 = r8.a     // Catch: java.lang.Throwable -> Lbf
            if (r0 == 0) goto Lbf
        Lbc:
            r0.endTransaction()     // Catch: java.lang.Throwable -> Lbf
        Lbf:
            r8.b()
            return r1
        Lc3:
            r0 = move-exception
            android.database.sqlite.SQLiteDatabase r1 = r8.a     // Catch: java.lang.Throwable -> Lcd
            if (r1 == 0) goto Lcd
            android.database.sqlite.SQLiteDatabase r1 = r8.a     // Catch: java.lang.Throwable -> Lcd
            r1.endTransaction()     // Catch: java.lang.Throwable -> Lcd
        Lcd:
            r8.b()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.cconfig.a.b.d():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0087, code lost:
    
        r1 = r12.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0089, code lost:
    
        if (r1 == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x008b, code lost:
    
        r1.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0092, code lost:
    
        r12.a.setTransactionSuccessful();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0097, code lost:
    
        r1 = r12.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0099, code lost:
    
        if (r1 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a9, code lost:
    
        r1.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009e, code lost:
    
        if (r1 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a7, code lost:
    
        if (r1 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0016, code lost:
    
        if (r1 != null) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001c, code lost:
    
        if (r1.moveToNext() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        r2 = r1.getString(r1.getColumnIndex("__ts"));
        r3 = r1.getString(r1.getColumnIndex(com.umeng.analytics.pro.e.d.a.d));
        r4 = r1.getString(r1.getColumnIndex("__a"));
        com.umeng.commonsdk.statistics.common.ULog.i("jessie", "[DbManager] getLastestConfigInfo".concat(java.lang.String.valueOf(java.lang.String.format("timeStamp = %s, content = %s, active = %s, id = %s", r2, r3, r4, r1.getString(r1.getColumnIndex("id"))) + com.umeng.umcrash.UMCustomLogInfoBuilder.LINE_SEP)));
        r0.a = r2;
        r0.b = r3;
        r0.f1077c = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0085, code lost:
    
        if (r2 == null) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.umeng.cconfig.b.d e() {
        /*
            r12 = this;
            com.umeng.cconfig.b.d r0 = new com.umeng.cconfig.b.d
            r0.<init>()
            r12.a()     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            android.database.sqlite.SQLiteDatabase r1 = r12.a     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            java.lang.String r1 = "select *  from __cc order by __ts desc"
            android.database.sqlite.SQLiteDatabase r2 = r12.a     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            r3 = 0
            android.database.Cursor r1 = r2.rawQuery(r1, r3)     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            if (r1 == 0) goto L92
        L18:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            if (r2 == 0) goto L92
            java.lang.String r2 = "__ts"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            java.lang.String r3 = "__c"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            java.lang.String r4 = "__a"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            java.lang.String r4 = r1.getString(r4)     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            java.lang.String r5 = "id"
            int r5 = r1.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            java.lang.String r5 = r1.getString(r5)     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            r6.<init>()     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            java.lang.String r7 = "timeStamp = %s, content = %s, active = %s, id = %s"
            r8 = 4
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            r9 = 0
            r8[r9] = r2     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            r10 = 1
            r8[r10] = r3     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            r11 = 2
            r8[r11] = r4     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            r11 = 3
            r8[r11] = r5     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            java.lang.String r5 = java.lang.String.format(r7, r8)     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            r6.append(r5)     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            java.lang.String r5 = "\n"
            r6.append(r5)     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            java.lang.String r6 = "jessie"
            java.lang.Object[] r7 = new java.lang.Object[r10]     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            java.lang.String r8 = "[DbManager] getLastestConfigInfo"
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            java.lang.String r5 = r8.concat(r5)     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            r7[r9] = r5     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            com.umeng.commonsdk.statistics.common.ULog.i(r6, r7)     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            r0.a = r2     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            r0.b = r3     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            r0.f1077c = r4     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            if (r2 == 0) goto L18
            android.database.sqlite.SQLiteDatabase r1 = r12.a     // Catch: java.lang.Throwable -> L8e
            if (r1 == 0) goto L8e
            r1.endTransaction()     // Catch: java.lang.Throwable -> L8e
        L8e:
            r12.b()
            return r0
        L92:
            android.database.sqlite.SQLiteDatabase r1 = r12.a     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L9c android.database.sqlite.SQLiteDatabaseCorruptException -> La1
            android.database.sqlite.SQLiteDatabase r1 = r12.a     // Catch: java.lang.Throwable -> Lac
            if (r1 == 0) goto Lac
            goto La9
        L9c:
            android.database.sqlite.SQLiteDatabase r1 = r12.a     // Catch: java.lang.Throwable -> Lac
            if (r1 == 0) goto Lac
            goto La9
        La1:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> Lb0
            android.database.sqlite.SQLiteDatabase r1 = r12.a     // Catch: java.lang.Throwable -> Lac
            if (r1 == 0) goto Lac
        La9:
            r1.endTransaction()     // Catch: java.lang.Throwable -> Lac
        Lac:
            r12.b()
            return r0
        Lb0:
            r0 = move-exception
            android.database.sqlite.SQLiteDatabase r1 = r12.a     // Catch: java.lang.Throwable -> Lba
            if (r1 == 0) goto Lba
            android.database.sqlite.SQLiteDatabase r1 = r12.a     // Catch: java.lang.Throwable -> Lba
            r1.endTransaction()     // Catch: java.lang.Throwable -> Lba
        Lba:
            r12.b()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.cconfig.a.b.e():com.umeng.cconfig.b.d");
    }
}
