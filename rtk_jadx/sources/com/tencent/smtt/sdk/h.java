package com.tencent.smtt.sdk;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

/* compiled from: SqliteDataManager.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class h {
    public static final String a = CookieManager.LOGTAG;
    static File b;

    public static File a(Context context) {
        if (b == null && context != null) {
            b = new File(context.getDir("webview", 0), "Cookies");
        }
        if (b == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("/data/data/");
            sb.append(context.getPackageName());
            String str = File.separator;
            sb.append(str);
            sb.append("app_webview");
            sb.append(str);
            sb.append("Cookies");
            b = new File(sb.toString());
        }
        return b;
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        com.tencent.smtt.utils.f.a(a(context), false);
        return true;
    }

    public static SQLiteDatabase c(Context context) {
        File a2;
        SQLiteDatabase sQLiteDatabase = null;
        if (context == null || (a2 = a(context)) == null) {
            return null;
        }
        try {
            sQLiteDatabase = SQLiteDatabase.openDatabase(a2.getAbsolutePath(), null, 0);
        } catch (Exception unused) {
        }
        if (sQLiteDatabase == null) {
            TbsLog.i(a, "dbPath is not exist!");
        }
        return sQLiteDatabase;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
    
        if (r1.moveToFirst() != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
    
        if (r1.getString(0).equals("version") == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
    
        if (r1.moveToNext() != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        r0 = java.lang.Integer.parseInt(r1.getString(1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0054, code lost:
    
        if (r4.isOpen() != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0068, code lost:
    
        if (r4.isOpen() != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int d(android.content.Context r4) {
        /*
            java.lang.System.currentTimeMillis()
            r0 = 0
            r1 = 0
            android.database.sqlite.SQLiteDatabase r4 = c(r4)     // Catch: java.lang.Throwable -> L5c
            if (r4 != 0) goto L18
            r0 = -1
            if (r4 == 0) goto L17
            boolean r1 = r4.isOpen()
            if (r1 == 0) goto L17
            r4.close()
        L17:
            return r0
        L18:
            java.lang.String r2 = "select * from meta"
            android.database.Cursor r1 = r4.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L5a
            int r2 = r1.getCount()     // Catch: java.lang.Throwable -> L5a
            r1.getColumnCount()     // Catch: java.lang.Throwable -> L5a
            if (r2 <= 0) goto L49
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L5a
            if (r2 == 0) goto L49
        L2d:
            java.lang.String r2 = r1.getString(r0)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r3 = "version"
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Throwable -> L5a
            if (r2 == 0) goto L43
            r2 = 1
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> L5a
            int r0 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Throwable -> L5a
            goto L49
        L43:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L5a
            if (r2 != 0) goto L2d
        L49:
            if (r1 == 0) goto L4e
            r1.close()
        L4e:
            if (r4 == 0) goto L6b
            boolean r1 = r4.isOpen()
            if (r1 == 0) goto L6b
        L56:
            r4.close()
            goto L6b
        L5a:
            goto L5d
        L5c:
            r4 = r1
        L5d:
            if (r1 == 0) goto L62
            r1.close()
        L62:
            if (r4 == 0) goto L6b
            boolean r1 = r4.isOpen()
            if (r1 == 0) goto L6b
            goto L56
        L6b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.h.d(android.content.Context):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0028, code lost:
    
        if (r0.moveToNext() != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
    
        if (r0 == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        if (r4 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        if (r4.isOpen() == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0044, code lost:
    
        if (r4.isOpen() != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
    
        if (r0.moveToFirst() != false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
    
        r2 = r0.getString(1);
        r0.getString(4);
        r1.add(r2);
        a(r4, r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList<java.lang.String> a(android.database.sqlite.SQLiteDatabase r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r2 = "select * from sqlite_master where type='table'"
            android.database.Cursor r0 = r4.rawQuery(r2, r0)     // Catch: java.lang.Throwable -> L38
            boolean r2 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L38
            if (r2 == 0) goto L2a
        L15:
            r2 = 1
            java.lang.String r2 = r0.getString(r2)     // Catch: java.lang.Throwable -> L38
            r3 = 4
            r0.getString(r3)     // Catch: java.lang.Throwable -> L38
            r1.add(r2)     // Catch: java.lang.Throwable -> L38
            a(r4, r2)     // Catch: java.lang.Throwable -> L38
            boolean r2 = r0.moveToNext()     // Catch: java.lang.Throwable -> L38
            if (r2 != 0) goto L15
        L2a:
            if (r0 == 0) goto L2f
            r0.close()
        L2f:
            if (r4 == 0) goto L49
            boolean r0 = r4.isOpen()
            if (r0 == 0) goto L49
            goto L46
        L38:
            if (r0 == 0) goto L3e
            r0.close()
        L3e:
            if (r4 == 0) goto L49
            boolean r0 = r4.isOpen()
            if (r0 == 0) goto L49
        L46:
            r4.close()
        L49:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.h.a(android.database.sqlite.SQLiteDatabase):java.util.ArrayList");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0061, code lost:
    
        r1.append(com.umeng.umcrash.UMCustomLogInfoBuilder.LINE_SEP);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0068, code lost:
    
        if (r4.moveToNext() != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x004a, code lost:
    
        if (r4.moveToFirst() != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x004c, code lost:
    
        r1.append(com.umeng.umcrash.UMCustomLogInfoBuilder.LINE_SEP);
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0050, code lost:
    
        if (r5 >= r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0056, code lost:
    
        r1.append(r4.getString(r5));
        r1.append(",");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String a(android.database.sqlite.SQLiteDatabase r4, java.lang.String r5) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "select * from "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r0 = 0
            android.database.Cursor r4 = r4.rawQuery(r5, r0)
            int r5 = r4.getCount()
            int r0 = r4.getColumnCount()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "raws:"
            r2.append(r3)
            r2.append(r5)
            java.lang.String r3 = ",columns:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = "\n"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            if (r5 <= 0) goto L6a
            boolean r5 = r4.moveToFirst()
            if (r5 == 0) goto L6a
        L4c:
            r1.append(r3)
            r5 = 0
        L50:
            if (r5 >= r0) goto L61
            java.lang.String r2 = r4.getString(r5)     // Catch: java.lang.Exception -> L5e
            r1.append(r2)
            java.lang.String r2 = ","
            r1.append(r2)
        L5e:
            int r5 = r5 + 1
            goto L50
        L61:
            r1.append(r3)
            boolean r5 = r4.moveToNext()
            if (r5 != 0) goto L4c
        L6a:
            java.lang.String r4 = r1.toString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.h.a(android.database.sqlite.SQLiteDatabase, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x003b, code lost:
    
        if (r3.moveToFirst() != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
    
        r4 = r3.getString(r3.getColumnIndex("host_key"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0049, code lost:
    
        if (r10 != com.tencent.smtt.sdk.CookieManager.a.MODE_KEYS) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004b, code lost:
    
        r5 = r11.length;
        r6 = false;
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004e, code lost:
    
        if (r7 >= r5) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0056, code lost:
    
        if (r4.equals(r11[r7]) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
    
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0058, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005d, code lost:
    
        if (r6 != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ad, code lost:
    
        if (r3.moveToNext() != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0060, code lost:
    
        r2.put(r4, r3.getString(r3.getColumnIndex("value")) + ";" + r3.getString(r3.getColumnIndex("name")) + ";" + r3.getInt(r3.getColumnIndex("expires_utc")) + ";" + r3.getInt(r3.getColumnIndex("priority")));
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00e6, code lost:
    
        if (r0.isOpen() != false) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.content.Context r9, com.tencent.smtt.sdk.CookieManager.a r10, java.lang.String r11, boolean r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.h.a(android.content.Context, com.tencent.smtt.sdk.CookieManager$a, java.lang.String, boolean, boolean):void");
    }
}
