package com.rtk.app.tool.g;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import com.rtk.app.tool.c0;

/* compiled from: TeenModeDBDao.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d {
    private static d b;
    private Context a;

    public d(Context context) {
        this.a = context.getApplicationContext();
    }

    private SQLiteDatabase a() {
        try {
            return new b(this.a).getReadableDatabase();
        } catch (Exception e) {
            c0.u("TeenModeDBDao", "青少年数据库异常" + e);
            return null;
        }
    }

    public static d c(Context context) {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d(context);
                }
            }
        }
        return b;
    }

    public synchronized e b(long j) {
        e eVar;
        e eVar2;
        SQLiteDatabase a = a();
        Cursor cursor = null;
        eVar2 = null;
        cursor = null;
        try {
            try {
                Cursor rawQuery = a.rawQuery("select _id, openTime, endTime, used from teen_mode_info where data=?", new String[]{j + ""});
                try {
                    try {
                        if (rawQuery.moveToNext()) {
                            eVar = new e(rawQuery.getInt(0), j, rawQuery.getLong(1), rawQuery.getLong(3));
                            try {
                                c0.u("TeenModeDBDao", "青少年模式 获取data：" + j + " used" + rawQuery.getLong(3));
                                eVar2 = eVar;
                            } catch (SQLiteConstraintException e) {
                                e = e;
                                cursor = rawQuery;
                                c0.s("TeenModeDBDao", "青少年模式数据库读取异常" + e);
                                if (a != null) {
                                    a.close();
                                }
                                if (cursor != null) {
                                    cursor.close();
                                }
                                eVar2 = eVar;
                                return eVar2;
                            }
                        }
                        if (a != null) {
                            a.close();
                        }
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = rawQuery;
                        if (a != null) {
                            a.close();
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (SQLiteConstraintException e2) {
                    e = e2;
                    eVar = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteConstraintException e3) {
            e = e3;
            eVar = null;
        }
        return eVar2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
    
        if (r0 == null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized int d(long r5, long r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "TeenModeDBDao"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L56
            r1.<init>()     // Catch: java.lang.Throwable -> L56
            java.lang.String r2 = "insertStartInfo data:"
            r1.append(r2)     // Catch: java.lang.Throwable -> L56
            r1.append(r5)     // Catch: java.lang.Throwable -> L56
            java.lang.String r2 = " openTime:"
            r1.append(r2)     // Catch: java.lang.Throwable -> L56
            r1.append(r7)     // Catch: java.lang.Throwable -> L56
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L56
            com.rtk.app.tool.c0.r(r0, r1)     // Catch: java.lang.Throwable -> L56
            android.database.sqlite.SQLiteDatabase r0 = r4.a()     // Catch: java.lang.Throwable -> L56
            r1 = 0
            java.lang.String r2 = "insert into teen_mode_info (data,openTime) values (?,?)"
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41 android.database.sqlite.SQLiteConstraintException -> L48
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41 android.database.sqlite.SQLiteConstraintException -> L48
            r3[r1] = r5     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41 android.database.sqlite.SQLiteConstraintException -> L48
            r5 = 1
            java.lang.Long r6 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41 android.database.sqlite.SQLiteConstraintException -> L48
            r3[r5] = r6     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41 android.database.sqlite.SQLiteConstraintException -> L48
            r0.execSQL(r2, r3)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41 android.database.sqlite.SQLiteConstraintException -> L48
            if (r0 == 0) goto L4e
        L3b:
            r0.close()     // Catch: java.lang.Throwable -> L56
            goto L4e
        L3f:
            r5 = move-exception
            goto L50
        L41:
            r5 = move-exception
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L3f
            if (r0 == 0) goto L4e
            goto L3b
        L48:
            r0.close()     // Catch: java.lang.Throwable -> L3f
            if (r0 == 0) goto L4e
            goto L3b
        L4e:
            monitor-exit(r4)
            return r1
        L50:
            if (r0 == 0) goto L55
            r0.close()     // Catch: java.lang.Throwable -> L56
        L55:
            throw r5     // Catch: java.lang.Throwable -> L56
        L56:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.d.d(long, long):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0069, code lost:
    
        if (r0 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void e(long r5, long r7, long r9) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.database.sqlite.SQLiteDatabase r0 = r4.a()     // Catch: java.lang.Throwable -> L74
            java.lang.String r1 = "update teen_mode_info set endTime=?,used=? where data=?"
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r3 = 0
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r2[r3] = r7     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r7 = 1
            java.lang.Long r8 = java.lang.Long.valueOf(r9)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r2[r7] = r8     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r7 = 2
            java.lang.Long r8 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r2[r7] = r8     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r0.execSQL(r1, r2)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            java.lang.String r7 = "TeenModeDBDao"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r8.<init>()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            java.lang.String r1 = "青少年模式 update:"
            r8.append(r1)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r8.append(r9)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            java.lang.String r1 = " data:"
            r8.append(r1)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r8.append(r5)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            java.lang.String r5 = r8.toString()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            com.rtk.app.tool.c0.u(r7, r5)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            com.rtk.app.tool.g.e r5 = com.rtk.app.tool.g.e.c()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r5.p(r9)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            if (r0 == 0) goto L6c
        L49:
            r0.close()     // Catch: java.lang.Throwable -> L74
            goto L6c
        L4d:
            r5 = move-exception
            goto L6e
        L4f:
            r5 = move-exception
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L4d
            java.lang.String r6 = "TAG"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4d
            r7.<init>()     // Catch: java.lang.Throwable -> L4d
            java.lang.String r8 = "updataInfos: 下载管理DAO数据更新异常"
            r7.append(r8)     // Catch: java.lang.Throwable -> L4d
            r7.append(r5)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r5 = r7.toString()     // Catch: java.lang.Throwable -> L4d
            android.util.Log.i(r6, r5)     // Catch: java.lang.Throwable -> L4d
            if (r0 == 0) goto L6c
            goto L49
        L6c:
            monitor-exit(r4)
            return
        L6e:
            if (r0 == 0) goto L73
            r0.close()     // Catch: java.lang.Throwable -> L74
        L73:
            throw r5     // Catch: java.lang.Throwable -> L74
        L74:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.d.e(long, long, long):void");
    }
}
