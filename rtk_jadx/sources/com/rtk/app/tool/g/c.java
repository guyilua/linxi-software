package com.rtk.app.tool.g;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.bean.DownListBean;
import com.rtk.app.tool.DownLoadTool.p;
import com.rtk.app.tool.DownLoadTool.q;
import com.rtk.app.tool.c0;
import java.util.List;

/* compiled from: DownLoadApkDBDao.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static c f302c;
    private Context a;
    private Gson b = new GsonBuilder().enableComplexMapKeySerialization().create();

    private c(Context context) {
        this.a = context.getApplicationContext();
    }

    private SQLiteDatabase d() {
        try {
            return new b(this.a).getReadableDatabase();
        } catch (Exception e) {
            c0.u("DownLoadApkDBDao", "下载数据库异常" + e);
            return null;
        }
    }

    public static c e(Context context) {
        if (f302c == null) {
            synchronized (c.class) {
                if (f302c == null) {
                    f302c = new c(context);
                }
            }
        }
        return f302c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        if (r0 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void a(int r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            android.database.sqlite.SQLiteDatabase r0 = r7.d()     // Catch: java.lang.Throwable -> L44
            com.rtk.app.tool.DownLoadTool.x r1 = com.rtk.app.tool.DownLoadTool.x.c()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            r1.i(r8)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            java.lang.String r1 = "download_info"
            java.lang.String r2 = "game_id=?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            r4 = 0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            r5.<init>()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            r5.append(r8)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            java.lang.String r6 = ""
            r5.append(r6)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            r3[r4] = r5     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            r0.delete(r1, r2, r3)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            com.rtk.app.tool.DownLoadTool.q.f(r8)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            if (r0 == 0) goto L3c
        L2f:
            r0.close()     // Catch: java.lang.Throwable -> L44
            goto L3c
        L33:
            r8 = move-exception
            goto L3e
        L35:
            r8 = move-exception
            r8.printStackTrace()     // Catch: java.lang.Throwable -> L33
            if (r0 == 0) goto L3c
            goto L2f
        L3c:
            monitor-exit(r7)
            return
        L3e:
            if (r0 == 0) goto L43
            r0.close()     // Catch: java.lang.Throwable -> L44
        L43:
            throw r8     // Catch: java.lang.Throwable -> L44
        L44:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.c.a(int):void");
    }

    public synchronized List<p> b() {
        SQLiteDatabase d = d();
        Cursor cursor = null;
        try {
            try {
                cursor = d.rawQuery("select game_id, app_name, app_state, app_size, current_size, url, package_name, icon_url, app_save_path, app_data_size, signaturesmd5, is_apk,version_code, zip_app_version, apkType, apkKey, installation from download_info ", new String[0]);
                while (cursor.moveToNext()) {
                    String string = cursor.getString(5);
                    int i = cursor.getInt(14);
                    String string2 = cursor.getString(15);
                    DownListBean downListBean = new DownListBean(string);
                    downListBean.setApkType(i);
                    downListBean.setApkKey(string2);
                    q.a(new p(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getLong(3), cursor.getLong(4), downListBean, cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getLong(9), cursor.getString(10), cursor.getInt(11), cursor.getInt(12), cursor.getString(13), cursor.getString(16)));
                }
            } catch (SQLiteConstraintException e) {
                c0.s("DownLoadApkDBDao", "数据库读取异常" + e);
                if (d != null) {
                    d.close();
                }
                if (cursor != null) {
                }
                return q.e();
            }
        } finally {
            if (d != null) {
                d.close();
            }
            if (cursor != null) {
                cursor.close();
            }
        }
        return q.e();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00e9, code lost:
    
        if (r3 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.util.List<com.rtk.app.tool.DownLoadTool.p> c(int r29, int r30) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.c.c(int, int):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00fc, code lost:
    
        if (r0 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void f(com.rtk.app.tool.DownLoadTool.p r13) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.c.f(com.rtk.app.tool.DownLoadTool.p):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
    
        if (r0 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void g(int r5, java.lang.String r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.database.sqlite.SQLiteDatabase r0 = r4.d()     // Catch: java.lang.Throwable -> L44
            java.lang.String r1 = "update download_info set zip_app_version=?  where game_id=?"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            r3 = 0
            r2[r3] = r6     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            r6 = 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            r2[r6] = r5     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            r0.execSQL(r1, r2)     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            if (r0 == 0) goto L3c
        L19:
            r0.close()     // Catch: java.lang.Throwable -> L44
            goto L3c
        L1d:
            r5 = move-exception
            goto L3e
        L1f:
            r5 = move-exception
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L1d
            java.lang.String r6 = "TAG"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1d
            r1.<init>()     // Catch: java.lang.Throwable -> L1d
            java.lang.String r2 = "setZipApkForGameId: 下载管理DAO数据更新异常"
            r1.append(r2)     // Catch: java.lang.Throwable -> L1d
            r1.append(r5)     // Catch: java.lang.Throwable -> L1d
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Throwable -> L1d
            android.util.Log.i(r6, r5)     // Catch: java.lang.Throwable -> L1d
            if (r0 == 0) goto L3c
            goto L19
        L3c:
            monitor-exit(r4)
            return
        L3e:
            if (r0 == 0) goto L43
            r0.close()     // Catch: java.lang.Throwable -> L44
        L43:
            throw r5     // Catch: java.lang.Throwable -> L44
        L44:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.c.g(int, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005c, code lost:
    
        if (r0 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void h(int r5, int r6, java.lang.String r7, long r8, long r10, long r12, int r14) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.database.sqlite.SQLiteDatabase r0 = r4.d()     // Catch: java.lang.Throwable -> L67
            java.lang.String r1 = "update download_info set app_state=? ,current_size=? ,app_size=? ,app_data_size=? ,version_code=?  where game_id=? and url=?"
            r2 = 7
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r3 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r2[r3] = r6     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r6 = 1
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r2[r6] = r8     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r6 = 2
            java.lang.Long r8 = java.lang.Long.valueOf(r10)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r2[r6] = r8     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r6 = 3
            java.lang.Long r8 = java.lang.Long.valueOf(r12)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r2[r6] = r8     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r6 = 4
            java.lang.Integer r8 = java.lang.Integer.valueOf(r14)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r2[r6] = r8     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r6 = 5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r2[r6] = r5     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r5 = 6
            r2[r5] = r7     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r0.execSQL(r1, r2)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            if (r0 == 0) goto L5f
        L3c:
            r0.close()     // Catch: java.lang.Throwable -> L67
            goto L5f
        L40:
            r5 = move-exception
            goto L61
        L42:
            r5 = move-exception
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L40
            java.lang.String r6 = "DownLoadApkDBDao"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L40
            r7.<init>()     // Catch: java.lang.Throwable -> L40
            java.lang.String r8 = "updateInfo: 下载管理DAO数据更新异常"
            r7.append(r8)     // Catch: java.lang.Throwable -> L40
            r7.append(r5)     // Catch: java.lang.Throwable -> L40
            java.lang.String r5 = r7.toString()     // Catch: java.lang.Throwable -> L40
            com.rtk.app.tool.c0.s(r6, r5)     // Catch: java.lang.Throwable -> L40
            if (r0 == 0) goto L5f
            goto L3c
        L5f:
            monitor-exit(r4)
            return
        L61:
            if (r0 == 0) goto L66
            r0.close()     // Catch: java.lang.Throwable -> L67
        L66:
            throw r5     // Catch: java.lang.Throwable -> L67
        L67:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.c.h(int, int, java.lang.String, long, long, long, int):void");
    }

    public void i(int i, int i2) {
        SQLiteDatabase d = d();
        try {
            try {
                d.execSQL("update download_info set app_state=? where game_id=?", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                if (d == null) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.i("TAG", "updataState: 下载管理DAO数据更新异常" + e);
                if (d == null) {
                    return;
                }
            }
            d.close();
        } catch (Throwable th) {
            if (d != null) {
                d.close();
            }
            throw th;
        }
    }

    public void j(int i, int i2) {
        SQLiteDatabase d = d();
        try {
            try {
                d.execSQL("update download_info set app_state=? where app_state=?", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
                if (d == null) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.i("TAG", "updataState: 下载管理DAO数据更新异常" + e);
                if (d == null) {
                    return;
                }
            }
            d.close();
        } catch (Throwable th) {
            if (d != null) {
                d.close();
            }
            throw th;
        }
    }
}
