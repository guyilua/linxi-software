package com.rtk.app.tool.g;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.rtk.app.bean.UpApkBean;
import com.rtk.app.tool.c0;

/* compiled from: UpLoadApkDBDao.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f {
    private static f b = null;

    /* renamed from: c, reason: collision with root package name */
    private static String f304c = "_id,apk_name,md5,path,size,load_in_background,up_load_state,all_total,current_index,edit_name,type,tag,tag_title,characteristic,description,list_imgs,list_thumb,img_path_head,publish_post,up_server_file_name, viewPermissions,isApk,zipPath,zipMd5,zipServePath,up_load_zip_state,current_zip_index,zipSize,zipSaveName,all_zip_total,sourceLogo,sha256,sha1,permission,targetVersion,sdkVersion,versionCode,otherVersion,packageName,versionName,sourcePath,sourceSize,apkMd5,apkType,apkKey,apkSecTrans,zipType,zipKey,zipSecTrans,familyId,setDownloadCoins,apkJsonData ";
    private Context a;

    public f(Context context) {
        this.a = context.getApplicationContext();
    }

    private g a(Cursor cursor) {
        return new g(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getInt(5), cursor.getInt(6), cursor.getInt(7), cursor.getInt(8), cursor.getString(9), cursor.getInt(10), cursor.getString(11), cursor.getString(12), cursor.getString(13), cursor.getString(14), cursor.getString(15), cursor.getString(16), cursor.getString(17), cursor.getInt(18), cursor.getString(19), cursor.getInt(20), cursor.getInt(21), cursor.getString(22), cursor.getString(23), cursor.getString(24), cursor.getInt(25), cursor.getInt(26), cursor.getDouble(27), cursor.getString(28), cursor.getInt(29), cursor.getString(30), new UpApkBean(cursor.getString(30), cursor.getString(31), cursor.getString(32), cursor.getString(33), cursor.getString(34), cursor.getString(35), cursor.getString(36), cursor.getString(37), cursor.getString(38), cursor.getString(39), cursor.getString(40), cursor.getDouble(41), cursor.getString(2), cursor.getString(42), cursor.getInt(43), cursor.getString(44), cursor.getInt(45), cursor.getInt(46), cursor.getString(47), cursor.getInt(48), cursor.getString(51)), cursor.getString(49), cursor.getInt(50));
    }

    public static f e(Context context) {
        if (b == null) {
            b = new f(context);
        }
        return b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0065, code lost:
    
        if (r0 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void A(com.rtk.app.bean.UpZipBean r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            android.database.sqlite.SQLiteDatabase r0 = r6.d()     // Catch: java.lang.Throwable -> L70
            java.lang.String r1 = "update upload_apk_info set zipServePath=?,zipSize=?, zipType = ?, zipKey = ? ,zipSecTrans = ? where zipMd5=?"
            r2 = 6
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r3 = 0
            java.lang.String r4 = r7.getDataPath()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r2[r3] = r4     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r3 = 1
            double r4 = r7.getDataSize()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            java.lang.Double r4 = java.lang.Double.valueOf(r4)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r2[r3] = r4     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r3 = 2
            int r4 = r7.getZipType()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r2[r3] = r4     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r3 = 3
            java.lang.String r4 = r7.getZipKey()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r2[r3] = r4     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r3 = 4
            int r4 = r7.getZipSecTrans()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r2[r3] = r4     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r3 = 5
            java.lang.String r7 = r7.getZipmd5()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r2[r3] = r7     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r0.execSQL(r1, r2)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            if (r0 == 0) goto L68
        L45:
            r0.close()     // Catch: java.lang.Throwable -> L70
            goto L68
        L49:
            r7 = move-exception
            goto L6a
        L4b:
            r7 = move-exception
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L49
            java.lang.String r1 = "TAG"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L49
            r2.<init>()     // Catch: java.lang.Throwable -> L49
            java.lang.String r3 = "setUpApkToBack: 设置到后台传输  状态  异常"
            r2.append(r3)     // Catch: java.lang.Throwable -> L49
            r2.append(r7)     // Catch: java.lang.Throwable -> L49
            java.lang.String r7 = r2.toString()     // Catch: java.lang.Throwable -> L49
            android.util.Log.i(r1, r7)     // Catch: java.lang.Throwable -> L49
            if (r0 == 0) goto L68
            goto L45
        L68:
            monitor-exit(r6)
            return
        L6a:
            if (r0 == 0) goto L6f
            r0.close()     // Catch: java.lang.Throwable -> L70
        L6f:
            throw r7     // Catch: java.lang.Throwable -> L70
        L70:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.f.A(com.rtk.app.bean.UpZipBean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0061, code lost:
    
        if (r1 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.util.List<com.rtk.app.tool.g.g> b() {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L71
            r0.<init>()     // Catch: java.lang.Throwable -> L71
            android.database.sqlite.SQLiteDatabase r1 = r7.d()     // Catch: java.lang.Throwable -> L71
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L43 android.database.sqlite.SQLiteConstraintException -> L45
            r3.<init>()     // Catch: java.lang.Throwable -> L43 android.database.sqlite.SQLiteConstraintException -> L45
            java.lang.String r4 = "select "
            r3.append(r4)     // Catch: java.lang.Throwable -> L43 android.database.sqlite.SQLiteConstraintException -> L45
            java.lang.String r4 = com.rtk.app.tool.g.f.f304c     // Catch: java.lang.Throwable -> L43 android.database.sqlite.SQLiteConstraintException -> L45
            r3.append(r4)     // Catch: java.lang.Throwable -> L43 android.database.sqlite.SQLiteConstraintException -> L45
            java.lang.String r4 = "   from upload_apk_info "
            r3.append(r4)     // Catch: java.lang.Throwable -> L43 android.database.sqlite.SQLiteConstraintException -> L45
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L43 android.database.sqlite.SQLiteConstraintException -> L45
            r4 = 0
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L43 android.database.sqlite.SQLiteConstraintException -> L45
            android.database.Cursor r2 = r1.rawQuery(r3, r4)     // Catch: java.lang.Throwable -> L43 android.database.sqlite.SQLiteConstraintException -> L45
        L2a:
            boolean r3 = r2.moveToNext()     // Catch: java.lang.Throwable -> L43 android.database.sqlite.SQLiteConstraintException -> L45
            if (r3 == 0) goto L38
            com.rtk.app.tool.g.g r3 = r7.a(r2)     // Catch: java.lang.Throwable -> L43 android.database.sqlite.SQLiteConstraintException -> L45
            r0.add(r3)     // Catch: java.lang.Throwable -> L43 android.database.sqlite.SQLiteConstraintException -> L45
            goto L2a
        L38:
            if (r2 == 0) goto L3d
            r2.close()     // Catch: java.lang.Throwable -> L71
        L3d:
            if (r1 == 0) goto L64
        L3f:
            r1.close()     // Catch: java.lang.Throwable -> L71
            goto L64
        L43:
            r0 = move-exception
            goto L66
        L45:
            r3 = move-exception
            java.lang.String r4 = "UpLoadApkDBDao"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L43
            r5.<init>()     // Catch: java.lang.Throwable -> L43
            java.lang.String r6 = "数据库上传数据库getAllUpLoadApkInfo读取异常"
            r5.append(r6)     // Catch: java.lang.Throwable -> L43
            r5.append(r3)     // Catch: java.lang.Throwable -> L43
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> L43
            com.rtk.app.tool.c0.u(r4, r3)     // Catch: java.lang.Throwable -> L43
            if (r2 == 0) goto L61
            r2.close()     // Catch: java.lang.Throwable -> L71
        L61:
            if (r1 == 0) goto L64
            goto L3f
        L64:
            monitor-exit(r7)
            return r0
        L66:
            if (r2 == 0) goto L6b
            r2.close()     // Catch: java.lang.Throwable -> L71
        L6b:
            if (r1 == 0) goto L70
            r1.close()     // Catch: java.lang.Throwable -> L71
        L70:
            throw r0     // Catch: java.lang.Throwable -> L71
        L71:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.f.b():java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x007b, code lost:
    
        if (r1 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.util.List<com.rtk.app.tool.g.g> c() {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L8b
            r0.<init>()     // Catch: java.lang.Throwable -> L8b
            android.database.sqlite.SQLiteDatabase r1 = r7.d()     // Catch: java.lang.Throwable -> L8b
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteConstraintException -> L5f
            r3.<init>()     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteConstraintException -> L5f
            java.lang.String r4 = "select "
            r3.append(r4)     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteConstraintException -> L5f
            java.lang.String r4 = com.rtk.app.tool.g.f.f304c     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteConstraintException -> L5f
            r3.append(r4)     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteConstraintException -> L5f
            java.lang.String r4 = "   from upload_apk_info where load_in_background=1"
            r3.append(r4)     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteConstraintException -> L5f
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteConstraintException -> L5f
            r4 = 0
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteConstraintException -> L5f
            android.database.Cursor r2 = r1.rawQuery(r3, r4)     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteConstraintException -> L5f
        L2a:
            boolean r3 = r2.moveToNext()     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteConstraintException -> L5f
            if (r3 == 0) goto L52
            com.rtk.app.tool.g.g r3 = r7.a(r2)     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteConstraintException -> L5f
            java.lang.String r4 = "UpLoadApkDBDao"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteConstraintException -> L5f
            r5.<init>()     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteConstraintException -> L5f
            java.lang.String r6 = "获取所有在后台上传getAllUpLoadApkInfoOnBack() apk"
            r5.append(r6)     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteConstraintException -> L5f
            java.lang.String r6 = r3.toString()     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteConstraintException -> L5f
            r5.append(r6)     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteConstraintException -> L5f
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteConstraintException -> L5f
            com.rtk.app.tool.c0.u(r4, r5)     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteConstraintException -> L5f
            r0.add(r3)     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteConstraintException -> L5f
            goto L2a
        L52:
            if (r2 == 0) goto L57
            r2.close()     // Catch: java.lang.Throwable -> L8b
        L57:
            if (r1 == 0) goto L7e
        L59:
            r1.close()     // Catch: java.lang.Throwable -> L8b
            goto L7e
        L5d:
            r0 = move-exception
            goto L80
        L5f:
            r3 = move-exception
            java.lang.String r4 = "UpLoadApkDBDao"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5d
            r5.<init>()     // Catch: java.lang.Throwable -> L5d
            java.lang.String r6 = "获取所有在后台上传getAllUpLoadApkInfoOnBack() apk读取异常"
            r5.append(r6)     // Catch: java.lang.Throwable -> L5d
            r5.append(r3)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> L5d
            com.rtk.app.tool.c0.u(r4, r3)     // Catch: java.lang.Throwable -> L5d
            if (r2 == 0) goto L7b
            r2.close()     // Catch: java.lang.Throwable -> L8b
        L7b:
            if (r1 == 0) goto L7e
            goto L59
        L7e:
            monitor-exit(r7)
            return r0
        L80:
            if (r2 == 0) goto L85
            r2.close()     // Catch: java.lang.Throwable -> L8b
        L85:
            if (r1 == 0) goto L8a
            r1.close()     // Catch: java.lang.Throwable -> L8b
        L8a:
            throw r0     // Catch: java.lang.Throwable -> L8b
        L8b:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.f.c():java.util.List");
    }

    public SQLiteDatabase d() {
        try {
            return new b(this.a).getReadableDatabase();
        } catch (Exception e) {
            c0.u("UpLoadApkDBDao", "上传数据库异常" + e);
            return null;
        }
    }

    public synchronized UpApkBean f(String str) {
        g i = i(str);
        if (i == null) {
            i = k(str);
        }
        if (i == null) {
            return null;
        }
        return i.t();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a2, code lost:
    
        if (r0 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a6, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005d, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005b, code lost:
    
        if (r0 != null) goto L23;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00aa A[Catch: all -> 0x00b3, TRY_ENTER, TryCatch #2 {, blocks: (B:3:0x0001, B:10:0x0042, B:12:0x0047, B:20:0x007b, B:22:0x0080, B:28:0x009f, B:32:0x005d, B:35:0x0058, B:40:0x00aa, B:42:0x00af, B:43:0x00b2), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00af A[Catch: all -> 0x00b3, TryCatch #2 {, blocks: (B:3:0x0001, B:10:0x0042, B:12:0x0047, B:20:0x007b, B:22:0x0080, B:28:0x009f, B:32:0x005d, B:35:0x0058, B:40:0x00aa, B:42:0x00af, B:43:0x00b2), top: B:2:0x0001 }] */
    /* JADX WARN: Type inference failed for: r8v0, types: [int] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v7, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.rtk.app.tool.g.g g(int r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            android.database.sqlite.SQLiteDatabase r0 = r7.d()     // Catch: java.lang.Throwable -> Lb3
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L55 android.database.CursorIndexOutOfBoundsException -> L61 android.database.sqlite.SQLiteConstraintException -> L85
            r2.<init>()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L55 android.database.CursorIndexOutOfBoundsException -> L61 android.database.sqlite.SQLiteConstraintException -> L85
            java.lang.String r3 = "select "
            r2.append(r3)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L55 android.database.CursorIndexOutOfBoundsException -> L61 android.database.sqlite.SQLiteConstraintException -> L85
            java.lang.String r3 = com.rtk.app.tool.g.f.f304c     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L55 android.database.CursorIndexOutOfBoundsException -> L61 android.database.sqlite.SQLiteConstraintException -> L85
            r2.append(r3)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L55 android.database.CursorIndexOutOfBoundsException -> L61 android.database.sqlite.SQLiteConstraintException -> L85
            java.lang.String r3 = "from upload_apk_info  where _id=?"
            r2.append(r3)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L55 android.database.CursorIndexOutOfBoundsException -> L61 android.database.sqlite.SQLiteConstraintException -> L85
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L55 android.database.CursorIndexOutOfBoundsException -> L61 android.database.sqlite.SQLiteConstraintException -> L85
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L55 android.database.CursorIndexOutOfBoundsException -> L61 android.database.sqlite.SQLiteConstraintException -> L85
            r4 = 0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L55 android.database.CursorIndexOutOfBoundsException -> L61 android.database.sqlite.SQLiteConstraintException -> L85
            r5.<init>()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L55 android.database.CursorIndexOutOfBoundsException -> L61 android.database.sqlite.SQLiteConstraintException -> L85
            r5.append(r8)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L55 android.database.CursorIndexOutOfBoundsException -> L61 android.database.sqlite.SQLiteConstraintException -> L85
            java.lang.String r8 = ""
            r5.append(r8)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L55 android.database.CursorIndexOutOfBoundsException -> L61 android.database.sqlite.SQLiteConstraintException -> L85
            java.lang.String r8 = r5.toString()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L55 android.database.CursorIndexOutOfBoundsException -> L61 android.database.sqlite.SQLiteConstraintException -> L85
            r3[r4] = r8     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L55 android.database.CursorIndexOutOfBoundsException -> L61 android.database.sqlite.SQLiteConstraintException -> L85
            android.database.Cursor r8 = r0.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L55 android.database.CursorIndexOutOfBoundsException -> L61 android.database.sqlite.SQLiteConstraintException -> L85
            r8.moveToFirst()     // Catch: android.database.CursorIndexOutOfBoundsException -> L4c android.database.sqlite.SQLiteConstraintException -> L4e java.lang.Exception -> L56 java.lang.Throwable -> La7
            com.rtk.app.tool.g.g r1 = r7.a(r8)     // Catch: android.database.CursorIndexOutOfBoundsException -> L4c android.database.sqlite.SQLiteConstraintException -> L4e java.lang.Exception -> L56 java.lang.Throwable -> La7
            if (r8 == 0) goto L45
            r8.close()     // Catch: java.lang.Throwable -> Lb3
        L45:
            if (r0 == 0) goto L4a
            r0.close()     // Catch: java.lang.Throwable -> Lb3
        L4a:
            monitor-exit(r7)
            return r1
        L4c:
            r2 = move-exception
            goto L63
        L4e:
            r2 = move-exception
            goto L87
        L50:
            r8 = move-exception
            r6 = r1
            r1 = r8
            r8 = r6
            goto La8
        L55:
            r8 = r1
        L56:
            if (r8 == 0) goto L5b
            r8.close()     // Catch: java.lang.Throwable -> Lb3
        L5b:
            if (r0 == 0) goto La5
        L5d:
            r0.close()     // Catch: java.lang.Throwable -> Lb3
            goto La5
        L61:
            r2 = move-exception
            r8 = r1
        L63:
            java.lang.String r3 = "UpLoadApkDBDao"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La7
            r4.<init>()     // Catch: java.lang.Throwable -> La7
            java.lang.String r5 = "数据库上传数据库getUpLoadApkInfoForApkId读取异常  数据改为空 "
            r4.append(r5)     // Catch: java.lang.Throwable -> La7
            r4.append(r2)     // Catch: java.lang.Throwable -> La7
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Throwable -> La7
            com.rtk.app.tool.c0.u(r3, r2)     // Catch: java.lang.Throwable -> La7
            if (r8 == 0) goto L7e
            r8.close()     // Catch: java.lang.Throwable -> Lb3
        L7e:
            if (r0 == 0) goto L83
            r0.close()     // Catch: java.lang.Throwable -> Lb3
        L83:
            monitor-exit(r7)
            return r1
        L85:
            r2 = move-exception
            r8 = r1
        L87:
            java.lang.String r3 = "UpLoadApkDBDao"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La7
            r4.<init>()     // Catch: java.lang.Throwable -> La7
            java.lang.String r5 = "数据库上传数据库getUpLoadApkInfoForApkId读取异常"
            r4.append(r5)     // Catch: java.lang.Throwable -> La7
            r4.append(r2)     // Catch: java.lang.Throwable -> La7
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Throwable -> La7
            com.rtk.app.tool.c0.u(r3, r2)     // Catch: java.lang.Throwable -> La7
            if (r8 == 0) goto La2
            r8.close()     // Catch: java.lang.Throwable -> Lb3
        La2:
            if (r0 == 0) goto La5
            goto L5d
        La5:
            monitor-exit(r7)
            return r1
        La7:
            r1 = move-exception
        La8:
            if (r8 == 0) goto Lad
            r8.close()     // Catch: java.lang.Throwable -> Lb3
        Lad:
            if (r0 == 0) goto Lb2
            r0.close()     // Catch: java.lang.Throwable -> Lb3
        Lb2:
            throw r1     // Catch: java.lang.Throwable -> Lb3
        Lb3:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.f.g(int):com.rtk.app.tool.g.g");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0091, code lost:
    
        if (r0 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0095, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004c, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x004a, code lost:
    
        if (r0 != null) goto L23;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0099 A[Catch: all -> 0x00a2, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:10:0x0031, B:12:0x0036, B:20:0x006a, B:22:0x006f, B:28:0x008e, B:32:0x004c, B:35:0x0047, B:40:0x0099, B:42:0x009e, B:43:0x00a1), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009e A[Catch: all -> 0x00a2, TryCatch #0 {, blocks: (B:3:0x0001, B:10:0x0031, B:12:0x0036, B:20:0x006a, B:22:0x006f, B:28:0x008e, B:32:0x004c, B:35:0x0047, B:40:0x0099, B:42:0x009e, B:43:0x00a1), top: B:2:0x0001 }] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v7, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.rtk.app.tool.g.g h(java.lang.String r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            android.database.sqlite.SQLiteDatabase r0 = r7.d()     // Catch: java.lang.Throwable -> La2
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L44 android.database.CursorIndexOutOfBoundsException -> L50 android.database.sqlite.SQLiteConstraintException -> L74
            r2.<init>()     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L44 android.database.CursorIndexOutOfBoundsException -> L50 android.database.sqlite.SQLiteConstraintException -> L74
            java.lang.String r3 = "select "
            r2.append(r3)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L44 android.database.CursorIndexOutOfBoundsException -> L50 android.database.sqlite.SQLiteConstraintException -> L74
            java.lang.String r3 = com.rtk.app.tool.g.f.f304c     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L44 android.database.CursorIndexOutOfBoundsException -> L50 android.database.sqlite.SQLiteConstraintException -> L74
            r2.append(r3)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L44 android.database.CursorIndexOutOfBoundsException -> L50 android.database.sqlite.SQLiteConstraintException -> L74
            java.lang.String r3 = "from upload_apk_info  where path=?"
            r2.append(r3)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L44 android.database.CursorIndexOutOfBoundsException -> L50 android.database.sqlite.SQLiteConstraintException -> L74
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L44 android.database.CursorIndexOutOfBoundsException -> L50 android.database.sqlite.SQLiteConstraintException -> L74
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L44 android.database.CursorIndexOutOfBoundsException -> L50 android.database.sqlite.SQLiteConstraintException -> L74
            r4 = 0
            r3[r4] = r8     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L44 android.database.CursorIndexOutOfBoundsException -> L50 android.database.sqlite.SQLiteConstraintException -> L74
            android.database.Cursor r8 = r0.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L44 android.database.CursorIndexOutOfBoundsException -> L50 android.database.sqlite.SQLiteConstraintException -> L74
            r8.moveToFirst()     // Catch: android.database.CursorIndexOutOfBoundsException -> L3b android.database.sqlite.SQLiteConstraintException -> L3d java.lang.Exception -> L45 java.lang.Throwable -> L96
            com.rtk.app.tool.g.g r1 = r7.a(r8)     // Catch: android.database.CursorIndexOutOfBoundsException -> L3b android.database.sqlite.SQLiteConstraintException -> L3d java.lang.Exception -> L45 java.lang.Throwable -> L96
            if (r8 == 0) goto L34
            r8.close()     // Catch: java.lang.Throwable -> La2
        L34:
            if (r0 == 0) goto L39
            r0.close()     // Catch: java.lang.Throwable -> La2
        L39:
            monitor-exit(r7)
            return r1
        L3b:
            r2 = move-exception
            goto L52
        L3d:
            r2 = move-exception
            goto L76
        L3f:
            r8 = move-exception
            r6 = r1
            r1 = r8
            r8 = r6
            goto L97
        L44:
            r8 = r1
        L45:
            if (r8 == 0) goto L4a
            r8.close()     // Catch: java.lang.Throwable -> La2
        L4a:
            if (r0 == 0) goto L94
        L4c:
            r0.close()     // Catch: java.lang.Throwable -> La2
            goto L94
        L50:
            r2 = move-exception
            r8 = r1
        L52:
            java.lang.String r3 = "UpLoadApkDBDao"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L96
            r4.<init>()     // Catch: java.lang.Throwable -> L96
            java.lang.String r5 = "数据库上传数据库getUpLoadApkInfoForApkPath读取异常  数据改为空 "
            r4.append(r5)     // Catch: java.lang.Throwable -> L96
            r4.append(r2)     // Catch: java.lang.Throwable -> L96
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Throwable -> L96
            com.rtk.app.tool.c0.u(r3, r2)     // Catch: java.lang.Throwable -> L96
            if (r8 == 0) goto L6d
            r8.close()     // Catch: java.lang.Throwable -> La2
        L6d:
            if (r0 == 0) goto L72
            r0.close()     // Catch: java.lang.Throwable -> La2
        L72:
            monitor-exit(r7)
            return r1
        L74:
            r2 = move-exception
            r8 = r1
        L76:
            java.lang.String r3 = "UpLoadApkDBDao"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L96
            r4.<init>()     // Catch: java.lang.Throwable -> L96
            java.lang.String r5 = "数据库上传数据库getUpLoadApkInfoForApkPath读取异常"
            r4.append(r5)     // Catch: java.lang.Throwable -> L96
            r4.append(r2)     // Catch: java.lang.Throwable -> L96
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Throwable -> L96
            com.rtk.app.tool.c0.u(r3, r2)     // Catch: java.lang.Throwable -> L96
            if (r8 == 0) goto L91
            r8.close()     // Catch: java.lang.Throwable -> La2
        L91:
            if (r0 == 0) goto L94
            goto L4c
        L94:
            monitor-exit(r7)
            return r1
        L96:
            r1 = move-exception
        L97:
            if (r8 == 0) goto L9c
            r8.close()     // Catch: java.lang.Throwable -> La2
        L9c:
            if (r0 == 0) goto La1
            r0.close()     // Catch: java.lang.Throwable -> La2
        La1:
            throw r1     // Catch: java.lang.Throwable -> La2
        La2:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.f.h(java.lang.String):com.rtk.app.tool.g.g");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0089, code lost:
    
        if (r0 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ad, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0065, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a9, code lost:
    
        if (r0 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0063, code lost:
    
        if (r0 != null) goto L27;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b1 A[Catch: all -> 0x00ba, TRY_ENTER, TryCatch #5 {, blocks: (B:3:0x0001, B:10:0x0031, B:12:0x0036, B:33:0x0060, B:24:0x0065, B:20:0x0086, B:28:0x00a6, B:38:0x00b1, B:40:0x00b6, B:41:0x00b9), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b6 A[Catch: all -> 0x00ba, TryCatch #5 {, blocks: (B:3:0x0001, B:10:0x0031, B:12:0x0036, B:33:0x0060, B:24:0x0065, B:20:0x0086, B:28:0x00a6, B:38:0x00b1, B:40:0x00b6, B:41:0x00b9), top: B:2:0x0001 }] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v7, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.rtk.app.tool.g.g i(java.lang.String r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            android.database.sqlite.SQLiteDatabase r0 = r7.d()     // Catch: java.lang.Throwable -> Lba
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46 android.database.CursorIndexOutOfBoundsException -> L69 android.database.sqlite.SQLiteConstraintException -> L8c
            r2.<init>()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46 android.database.CursorIndexOutOfBoundsException -> L69 android.database.sqlite.SQLiteConstraintException -> L8c
            java.lang.String r3 = "select "
            r2.append(r3)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46 android.database.CursorIndexOutOfBoundsException -> L69 android.database.sqlite.SQLiteConstraintException -> L8c
            java.lang.String r3 = com.rtk.app.tool.g.f.f304c     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46 android.database.CursorIndexOutOfBoundsException -> L69 android.database.sqlite.SQLiteConstraintException -> L8c
            r2.append(r3)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46 android.database.CursorIndexOutOfBoundsException -> L69 android.database.sqlite.SQLiteConstraintException -> L8c
            java.lang.String r3 = "  from upload_apk_info  where md5=?"
            r2.append(r3)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46 android.database.CursorIndexOutOfBoundsException -> L69 android.database.sqlite.SQLiteConstraintException -> L8c
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46 android.database.CursorIndexOutOfBoundsException -> L69 android.database.sqlite.SQLiteConstraintException -> L8c
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46 android.database.CursorIndexOutOfBoundsException -> L69 android.database.sqlite.SQLiteConstraintException -> L8c
            r4 = 0
            r3[r4] = r8     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46 android.database.CursorIndexOutOfBoundsException -> L69 android.database.sqlite.SQLiteConstraintException -> L8c
            android.database.Cursor r8 = r0.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46 android.database.CursorIndexOutOfBoundsException -> L69 android.database.sqlite.SQLiteConstraintException -> L8c
            r8.moveToFirst()     // Catch: java.lang.Exception -> L3b android.database.CursorIndexOutOfBoundsException -> L3d android.database.sqlite.SQLiteConstraintException -> L3f java.lang.Throwable -> Lae
            com.rtk.app.tool.g.g r1 = r7.a(r8)     // Catch: java.lang.Exception -> L3b android.database.CursorIndexOutOfBoundsException -> L3d android.database.sqlite.SQLiteConstraintException -> L3f java.lang.Throwable -> Lae
            if (r8 == 0) goto L34
            r8.close()     // Catch: java.lang.Throwable -> Lba
        L34:
            if (r0 == 0) goto L39
            r0.close()     // Catch: java.lang.Throwable -> Lba
        L39:
            monitor-exit(r7)
            return r1
        L3b:
            r2 = move-exception
            goto L48
        L3d:
            r2 = move-exception
            goto L6b
        L3f:
            r2 = move-exception
            goto L8e
        L41:
            r8 = move-exception
            r6 = r1
            r1 = r8
            r8 = r6
            goto Laf
        L46:
            r2 = move-exception
            r8 = r1
        L48:
            java.lang.String r3 = "UpLoadApkDBDao"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lae
            r4.<init>()     // Catch: java.lang.Throwable -> Lae
            java.lang.String r5 = "上传数据库的未知异常"
            r4.append(r5)     // Catch: java.lang.Throwable -> Lae
            r4.append(r2)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Throwable -> Lae
            com.rtk.app.tool.c0.s(r3, r2)     // Catch: java.lang.Throwable -> Lae
            if (r8 == 0) goto L63
            r8.close()     // Catch: java.lang.Throwable -> Lba
        L63:
            if (r0 == 0) goto Lac
        L65:
            r0.close()     // Catch: java.lang.Throwable -> Lba
            goto Lac
        L69:
            r2 = move-exception
            r8 = r1
        L6b:
            java.lang.String r3 = "UpLoadApkDBDao"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lae
            r4.<init>()     // Catch: java.lang.Throwable -> Lae
            java.lang.String r5 = "数据库上传数据库getUpLoadApkInfoForMd5读取异常"
            r4.append(r5)     // Catch: java.lang.Throwable -> Lae
            r4.append(r2)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> Lae
            com.rtk.app.tool.c0.s(r3, r4)     // Catch: java.lang.Throwable -> Lae
            r2.printStackTrace()     // Catch: java.lang.Throwable -> Lae
            if (r8 == 0) goto L89
            r8.close()     // Catch: java.lang.Throwable -> Lba
        L89:
            if (r0 == 0) goto Lac
            goto L65
        L8c:
            r2 = move-exception
            r8 = r1
        L8e:
            java.lang.String r3 = "UpLoadApkDBDao"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lae
            r4.<init>()     // Catch: java.lang.Throwable -> Lae
            java.lang.String r5 = "数据库上传数据库getUpLoadApkInfoForMd5读取异常"
            r4.append(r5)     // Catch: java.lang.Throwable -> Lae
            r4.append(r2)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Throwable -> Lae
            com.rtk.app.tool.c0.s(r3, r2)     // Catch: java.lang.Throwable -> Lae
            if (r8 == 0) goto La9
            r8.close()     // Catch: java.lang.Throwable -> Lba
        La9:
            if (r0 == 0) goto Lac
            goto L65
        Lac:
            monitor-exit(r7)
            return r1
        Lae:
            r1 = move-exception
        Laf:
            if (r8 == 0) goto Lb4
            r8.close()     // Catch: java.lang.Throwable -> Lba
        Lb4:
            if (r0 == 0) goto Lb9
            r0.close()     // Catch: java.lang.Throwable -> Lba
        Lb9:
            throw r1     // Catch: java.lang.Throwable -> Lba
        Lba:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.f.i(java.lang.String):com.rtk.app.tool.g.g");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x007c, code lost:
    
        if (r2 != null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x009d, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x009a, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0098, code lost:
    
        if (r2 != null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0060, code lost:
    
        if (r2 != null) goto L38;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a7  */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.rtk.app.tool.g.g j(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "数据库上传数据库getUpLoadApkInfoForZipMd5读取异常"
            java.lang.String r1 = "UpLoadApkDBDao"
            android.database.sqlite.SQLiteDatabase r2 = r7.d()
            r3 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45 android.database.CursorIndexOutOfBoundsException -> L63 android.database.sqlite.SQLiteConstraintException -> L7f
            r4.<init>()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45 android.database.CursorIndexOutOfBoundsException -> L63 android.database.sqlite.SQLiteConstraintException -> L7f
            java.lang.String r5 = "select "
            r4.append(r5)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45 android.database.CursorIndexOutOfBoundsException -> L63 android.database.sqlite.SQLiteConstraintException -> L7f
            java.lang.String r5 = com.rtk.app.tool.g.f.f304c     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45 android.database.CursorIndexOutOfBoundsException -> L63 android.database.sqlite.SQLiteConstraintException -> L7f
            r4.append(r5)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45 android.database.CursorIndexOutOfBoundsException -> L63 android.database.sqlite.SQLiteConstraintException -> L7f
            java.lang.String r5 = "  from upload_apk_info  where zipMd5=?"
            r4.append(r5)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45 android.database.CursorIndexOutOfBoundsException -> L63 android.database.sqlite.SQLiteConstraintException -> L7f
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45 android.database.CursorIndexOutOfBoundsException -> L63 android.database.sqlite.SQLiteConstraintException -> L7f
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45 android.database.CursorIndexOutOfBoundsException -> L63 android.database.sqlite.SQLiteConstraintException -> L7f
            r6 = 0
            r5[r6] = r8     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45 android.database.CursorIndexOutOfBoundsException -> L63 android.database.sqlite.SQLiteConstraintException -> L7f
            android.database.Cursor r8 = r2.rawQuery(r4, r5)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45 android.database.CursorIndexOutOfBoundsException -> L63 android.database.sqlite.SQLiteConstraintException -> L7f
            r8.moveToFirst()     // Catch: java.lang.Exception -> L3d android.database.CursorIndexOutOfBoundsException -> L3f android.database.sqlite.SQLiteConstraintException -> L41 java.lang.Throwable -> L9e
            com.rtk.app.tool.g.g r0 = r7.a(r8)     // Catch: java.lang.Exception -> L3d android.database.CursorIndexOutOfBoundsException -> L3f android.database.sqlite.SQLiteConstraintException -> L41 java.lang.Throwable -> L9e
            if (r8 == 0) goto L37
            r8.close()
        L37:
            if (r2 == 0) goto L3c
            r2.close()
        L3c:
            return r0
        L3d:
            r0 = move-exception
            goto L47
        L3f:
            r4 = move-exception
            goto L65
        L41:
            r4 = move-exception
            goto L81
        L43:
            r0 = move-exception
            goto La0
        L45:
            r0 = move-exception
            r8 = r3
        L47:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9e
            r4.<init>()     // Catch: java.lang.Throwable -> L9e
            java.lang.String r5 = "上传数据库的未知异常"
            r4.append(r5)     // Catch: java.lang.Throwable -> L9e
            r4.append(r0)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L9e
            com.rtk.app.tool.c0.u(r1, r0)     // Catch: java.lang.Throwable -> L9e
            if (r8 == 0) goto L60
            r8.close()
        L60:
            if (r2 == 0) goto L9d
            goto L9a
        L63:
            r4 = move-exception
            r8 = r3
        L65:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9e
            r5.<init>()     // Catch: java.lang.Throwable -> L9e
            r5.append(r0)     // Catch: java.lang.Throwable -> L9e
            r5.append(r4)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L9e
            com.rtk.app.tool.c0.u(r1, r0)     // Catch: java.lang.Throwable -> L9e
            if (r8 == 0) goto L7c
            r8.close()
        L7c:
            if (r2 == 0) goto L9d
            goto L9a
        L7f:
            r4 = move-exception
            r8 = r3
        L81:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9e
            r5.<init>()     // Catch: java.lang.Throwable -> L9e
            r5.append(r0)     // Catch: java.lang.Throwable -> L9e
            r5.append(r4)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L9e
            com.rtk.app.tool.c0.u(r1, r0)     // Catch: java.lang.Throwable -> L9e
            if (r8 == 0) goto L98
            r8.close()
        L98:
            if (r2 == 0) goto L9d
        L9a:
            r2.close()
        L9d:
            return r3
        L9e:
            r0 = move-exception
            r3 = r8
        La0:
            if (r3 == 0) goto La5
            r3.close()
        La5:
            if (r2 == 0) goto Laa
            r2.close()
        Laa:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.f.j(java.lang.String):com.rtk.app.tool.g.g");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0086, code lost:
    
        if (r0 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00aa, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0065, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a6, code lost:
    
        if (r0 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0063, code lost:
    
        if (r0 != null) goto L27;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ae A[Catch: all -> 0x00b7, TRY_ENTER, TryCatch #4 {, blocks: (B:3:0x0001, B:10:0x0031, B:12:0x0036, B:33:0x0060, B:24:0x0065, B:20:0x0083, B:28:0x00a3, B:38:0x00ae, B:40:0x00b3, B:41:0x00b6), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b3 A[Catch: all -> 0x00b7, TryCatch #4 {, blocks: (B:3:0x0001, B:10:0x0031, B:12:0x0036, B:33:0x0060, B:24:0x0065, B:20:0x0083, B:28:0x00a3, B:38:0x00ae, B:40:0x00b3, B:41:0x00b6), top: B:2:0x0001 }] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v7, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.rtk.app.tool.g.g k(java.lang.String r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            android.database.sqlite.SQLiteDatabase r0 = r7.d()     // Catch: java.lang.Throwable -> Lb7
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46 android.database.CursorIndexOutOfBoundsException -> L69 android.database.sqlite.SQLiteConstraintException -> L89
            r2.<init>()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46 android.database.CursorIndexOutOfBoundsException -> L69 android.database.sqlite.SQLiteConstraintException -> L89
            java.lang.String r3 = "select "
            r2.append(r3)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46 android.database.CursorIndexOutOfBoundsException -> L69 android.database.sqlite.SQLiteConstraintException -> L89
            java.lang.String r3 = com.rtk.app.tool.g.f.f304c     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46 android.database.CursorIndexOutOfBoundsException -> L69 android.database.sqlite.SQLiteConstraintException -> L89
            r2.append(r3)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46 android.database.CursorIndexOutOfBoundsException -> L69 android.database.sqlite.SQLiteConstraintException -> L89
            java.lang.String r3 = "  from upload_apk_info  where zipMd5=?"
            r2.append(r3)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46 android.database.CursorIndexOutOfBoundsException -> L69 android.database.sqlite.SQLiteConstraintException -> L89
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46 android.database.CursorIndexOutOfBoundsException -> L69 android.database.sqlite.SQLiteConstraintException -> L89
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46 android.database.CursorIndexOutOfBoundsException -> L69 android.database.sqlite.SQLiteConstraintException -> L89
            r4 = 0
            r3[r4] = r8     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46 android.database.CursorIndexOutOfBoundsException -> L69 android.database.sqlite.SQLiteConstraintException -> L89
            android.database.Cursor r8 = r0.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46 android.database.CursorIndexOutOfBoundsException -> L69 android.database.sqlite.SQLiteConstraintException -> L89
            r8.moveToFirst()     // Catch: java.lang.Exception -> L3b android.database.CursorIndexOutOfBoundsException -> L3d android.database.sqlite.SQLiteConstraintException -> L3f java.lang.Throwable -> Lab
            com.rtk.app.tool.g.g r1 = r7.a(r8)     // Catch: java.lang.Exception -> L3b android.database.CursorIndexOutOfBoundsException -> L3d android.database.sqlite.SQLiteConstraintException -> L3f java.lang.Throwable -> Lab
            if (r8 == 0) goto L34
            r8.close()     // Catch: java.lang.Throwable -> Lb7
        L34:
            if (r0 == 0) goto L39
            r0.close()     // Catch: java.lang.Throwable -> Lb7
        L39:
            monitor-exit(r7)
            return r1
        L3b:
            r2 = move-exception
            goto L48
        L3d:
            r2 = move-exception
            goto L6b
        L3f:
            r2 = move-exception
            goto L8b
        L41:
            r8 = move-exception
            r6 = r1
            r1 = r8
            r8 = r6
            goto Lac
        L46:
            r2 = move-exception
            r8 = r1
        L48:
            java.lang.String r3 = "UpLoadApkDBDao"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lab
            r4.<init>()     // Catch: java.lang.Throwable -> Lab
            java.lang.String r5 = "上传数据库的未知异常"
            r4.append(r5)     // Catch: java.lang.Throwable -> Lab
            r4.append(r2)     // Catch: java.lang.Throwable -> Lab
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Throwable -> Lab
            com.rtk.app.tool.c0.u(r3, r2)     // Catch: java.lang.Throwable -> Lab
            if (r8 == 0) goto L63
            r8.close()     // Catch: java.lang.Throwable -> Lb7
        L63:
            if (r0 == 0) goto La9
        L65:
            r0.close()     // Catch: java.lang.Throwable -> Lb7
            goto La9
        L69:
            r2 = move-exception
            r8 = r1
        L6b:
            java.lang.String r3 = "UpLoadApkDBDao"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lab
            r4.<init>()     // Catch: java.lang.Throwable -> Lab
            java.lang.String r5 = "数据库上传数据库getUpLoadApkInfoForMd5读取异常"
            r4.append(r5)     // Catch: java.lang.Throwable -> Lab
            r4.append(r2)     // Catch: java.lang.Throwable -> Lab
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Throwable -> Lab
            com.rtk.app.tool.c0.u(r3, r2)     // Catch: java.lang.Throwable -> Lab
            if (r8 == 0) goto L86
            r8.close()     // Catch: java.lang.Throwable -> Lb7
        L86:
            if (r0 == 0) goto La9
            goto L65
        L89:
            r2 = move-exception
            r8 = r1
        L8b:
            java.lang.String r3 = "UpLoadApkDBDao"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lab
            r4.<init>()     // Catch: java.lang.Throwable -> Lab
            java.lang.String r5 = "数据库上传数据库getUpLoadApkInfoForMd5读取异常"
            r4.append(r5)     // Catch: java.lang.Throwable -> Lab
            r4.append(r2)     // Catch: java.lang.Throwable -> Lab
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Throwable -> Lab
            com.rtk.app.tool.c0.u(r3, r2)     // Catch: java.lang.Throwable -> Lab
            if (r8 == 0) goto La6
            r8.close()     // Catch: java.lang.Throwable -> Lb7
        La6:
            if (r0 == 0) goto La9
            goto L65
        La9:
            monitor-exit(r7)
            return r1
        Lab:
            r1 = move-exception
        Lac:
            if (r8 == 0) goto Lb1
            r8.close()     // Catch: java.lang.Throwable -> Lb7
        Lb1:
            if (r0 == 0) goto Lb6
            r0.close()     // Catch: java.lang.Throwable -> Lb7
        Lb6:
            throw r1     // Catch: java.lang.Throwable -> Lb7
        Lb7:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.f.k(java.lang.String):com.rtk.app.tool.g.g");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:
    
        if (r0 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void l(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.database.sqlite.SQLiteDatabase r0 = r4.d()     // Catch: java.lang.Throwable -> L47
            java.lang.String r1 = "insert into upload_apk_info (apk_name,md5,path,size,up_server_file_name,zipPath) values (?,?,?,?,?,?)"
            r2 = 6
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27 android.database.sqlite.SQLiteConstraintException -> L2e
            r3 = 0
            r2[r3] = r5     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27 android.database.sqlite.SQLiteConstraintException -> L2e
            r5 = 1
            r2[r5] = r6     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27 android.database.sqlite.SQLiteConstraintException -> L2e
            r5 = 2
            r2[r5] = r7     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27 android.database.sqlite.SQLiteConstraintException -> L2e
            r5 = 3
            r2[r5] = r8     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27 android.database.sqlite.SQLiteConstraintException -> L2e
            r5 = 4
            r2[r5] = r9     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27 android.database.sqlite.SQLiteConstraintException -> L2e
            r5 = 5
            r2[r5] = r10     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27 android.database.sqlite.SQLiteConstraintException -> L2e
            r0.execSQL(r1, r2)     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27 android.database.sqlite.SQLiteConstraintException -> L2e
            if (r0 == 0) goto L3f
        L21:
            r0.close()     // Catch: java.lang.Throwable -> L47
            goto L3f
        L25:
            r5 = move-exception
            goto L41
        L27:
            r5 = move-exception
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L25
            if (r0 == 0) goto L3f
            goto L21
        L2e:
            r0.close()     // Catch: java.lang.Throwable -> L25
            android.content.Context r5 = com.rtk.app.main.MyApplication.b()     // Catch: java.lang.Throwable -> L25
            java.lang.String r6 = "已经在上传队列中了"
            r7 = 2000(0x7d0, float:2.803E-42)
            com.rtk.app.tool.f.a(r5, r6, r7)     // Catch: java.lang.Throwable -> L25
            if (r0 == 0) goto L3f
            goto L21
        L3f:
            monitor-exit(r4)
            return
        L41:
            if (r0 == 0) goto L46
            r0.close()     // Catch: java.lang.Throwable -> L47
        L46:
            throw r5     // Catch: java.lang.Throwable -> L47
        L47:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.f.l(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
    
        if (r0 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void m(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.database.sqlite.SQLiteDatabase r0 = r4.d()     // Catch: java.lang.Throwable -> L52
            java.lang.String r1 = "insert into upload_apk_info (apk_name,md5,path,size,up_server_file_name,zipPath,zipMd5,zipSize,zipSaveName) values (?,?,?,?,?,?,?,?,?)"
            r2 = 9
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32 android.database.sqlite.SQLiteConstraintException -> L39
            r3 = 0
            r2[r3] = r5     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32 android.database.sqlite.SQLiteConstraintException -> L39
            r5 = 1
            r2[r5] = r6     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32 android.database.sqlite.SQLiteConstraintException -> L39
            r5 = 2
            r2[r5] = r7     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32 android.database.sqlite.SQLiteConstraintException -> L39
            r5 = 3
            r2[r5] = r8     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32 android.database.sqlite.SQLiteConstraintException -> L39
            r5 = 4
            r2[r5] = r9     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32 android.database.sqlite.SQLiteConstraintException -> L39
            r5 = 5
            r2[r5] = r13     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32 android.database.sqlite.SQLiteConstraintException -> L39
            r5 = 6
            r2[r5] = r10     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32 android.database.sqlite.SQLiteConstraintException -> L39
            r5 = 7
            r2[r5] = r11     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32 android.database.sqlite.SQLiteConstraintException -> L39
            r5 = 8
            r2[r5] = r12     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32 android.database.sqlite.SQLiteConstraintException -> L39
            r0.execSQL(r1, r2)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32 android.database.sqlite.SQLiteConstraintException -> L39
            if (r0 == 0) goto L4a
        L2c:
            r0.close()     // Catch: java.lang.Throwable -> L52
            goto L4a
        L30:
            r5 = move-exception
            goto L4c
        L32:
            r5 = move-exception
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto L4a
            goto L2c
        L39:
            r0.close()     // Catch: java.lang.Throwable -> L30
            android.content.Context r5 = com.rtk.app.main.MyApplication.b()     // Catch: java.lang.Throwable -> L30
            java.lang.String r6 = "已经在上传队列中了"
            r7 = 2000(0x7d0, float:2.803E-42)
            com.rtk.app.tool.f.a(r5, r6, r7)     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto L4a
            goto L2c
        L4a:
            monitor-exit(r4)
            return
        L4c:
            if (r0 == 0) goto L51
            r0.close()     // Catch: java.lang.Throwable -> L52
        L51:
            throw r5     // Catch: java.lang.Throwable -> L52
        L52:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.f.m(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0034, code lost:
    
        if (r0 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void n(java.lang.String r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            android.database.sqlite.SQLiteDatabase r0 = r5.d()     // Catch: java.lang.Throwable -> L3f
            java.lang.String r1 = "upload_apk_info"
            java.lang.String r2 = "md5=?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a
            r4 = 0
            r3[r4] = r6     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a
            r0.delete(r1, r2, r3)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a
            if (r0 == 0) goto L37
        L14:
            r0.close()     // Catch: java.lang.Throwable -> L3f
            goto L37
        L18:
            r6 = move-exception
            goto L39
        L1a:
            r6 = move-exception
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L18
            java.lang.String r1 = "TAG"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L18
            r2.<init>()     // Catch: java.lang.Throwable -> L18
            java.lang.String r3 = "删除指定上传apk数据库失败 状态  异常"
            r2.append(r3)     // Catch: java.lang.Throwable -> L18
            r2.append(r6)     // Catch: java.lang.Throwable -> L18
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L18
            android.util.Log.i(r1, r6)     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L37
            goto L14
        L37:
            monitor-exit(r5)
            return
        L39:
            if (r0 == 0) goto L3e
            r0.close()     // Catch: java.lang.Throwable -> L3f
        L3e:
            throw r6     // Catch: java.lang.Throwable -> L3f
        L3f:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.f.n(java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0034, code lost:
    
        if (r0 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void o(java.lang.String r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            android.database.sqlite.SQLiteDatabase r0 = r5.d()     // Catch: java.lang.Throwable -> L3f
            java.lang.String r1 = "upload_apk_info"
            java.lang.String r2 = "zipMd5=?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a
            r4 = 0
            r3[r4] = r6     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a
            r0.delete(r1, r2, r3)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a
            if (r0 == 0) goto L37
        L14:
            r0.close()     // Catch: java.lang.Throwable -> L3f
            goto L37
        L18:
            r6 = move-exception
            goto L39
        L1a:
            r6 = move-exception
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L18
            java.lang.String r1 = "TAG"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L18
            r2.<init>()     // Catch: java.lang.Throwable -> L18
            java.lang.String r3 = "删除指定上传apk数据库失败 状态  异常"
            r2.append(r3)     // Catch: java.lang.Throwable -> L18
            r2.append(r6)     // Catch: java.lang.Throwable -> L18
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L18
            android.util.Log.i(r1, r6)     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L37
            goto L14
        L37:
            monitor-exit(r5)
            return
        L39:
            if (r0 == 0) goto L3e
            r0.close()     // Catch: java.lang.Throwable -> L3f
        L3e:
            throw r6     // Catch: java.lang.Throwable -> L3f
        L3f:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.f.o(java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0070, code lost:
    
        if (r1 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void p(java.lang.String r6, java.lang.String r7, int r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, int r16, int r17, java.lang.String r18, int r19) {
        /*
            r5 = this;
            monitor-enter(r5)
            android.database.sqlite.SQLiteDatabase r1 = r5.d()     // Catch: java.lang.Throwable -> L7b
            java.lang.String r0 = "update upload_apk_info set edit_name=?,type=?,tag=?,tag_title=?,characteristic=?,description=?,list_imgs=?,list_thumb=?,img_path_head=?,publish_post=?,viewPermissions=?,familyId=?,setDownloadCoins=?   where path=?"
            r2 = 14
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r3 = 0
            r2[r3] = r7     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r3 = 1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r2[r3] = r4     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r3 = 2
            r2[r3] = r9     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r3 = 3
            r2[r3] = r10     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r3 = 4
            r2[r3] = r11     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r3 = 5
            r2[r3] = r12     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r3 = 6
            r2[r3] = r13     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r3 = 7
            r2[r3] = r14     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r3 = 8
            r2[r3] = r15     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r3 = 9
            java.lang.Integer r4 = java.lang.Integer.valueOf(r16)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r2[r3] = r4     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r3 = 10
            java.lang.Integer r4 = java.lang.Integer.valueOf(r17)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r2[r3] = r4     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r3 = 11
            r2[r3] = r18     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r3 = 12
            java.lang.Integer r4 = java.lang.Integer.valueOf(r19)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r2[r3] = r4     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r3 = 13
            r2[r3] = r6     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r1.execSQL(r0, r2)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            if (r1 == 0) goto L73
        L50:
            r1.close()     // Catch: java.lang.Throwable -> L7b
            goto L73
        L54:
            r0 = move-exception
            goto L75
        L56:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L54
            java.lang.String r2 = "TAG"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L54
            r3.<init>()     // Catch: java.lang.Throwable -> L54
            java.lang.String r4 = "savePublishUpApkInfo: 上传数据库数据更新进度异常"
            r3.append(r4)     // Catch: java.lang.Throwable -> L54
            r3.append(r0)     // Catch: java.lang.Throwable -> L54
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L54
            android.util.Log.i(r2, r0)     // Catch: java.lang.Throwable -> L54
            if (r1 == 0) goto L73
            goto L50
        L73:
            monitor-exit(r5)
            return
        L75:
            if (r1 == 0) goto L7a
            r1.close()     // Catch: java.lang.Throwable -> L7b
        L7a:
            throw r0     // Catch: java.lang.Throwable -> L7b
        L7b:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.f.p(java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, java.lang.String, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00e0, code lost:
    
        if (r0 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void q(java.lang.String r7, com.rtk.app.bean.UpApkBean r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            android.database.sqlite.SQLiteDatabase r0 = r6.d()     // Catch: java.lang.Throwable -> Leb
            java.lang.String r1 = "update upload_apk_info set sourceLogo=?,sha256=?,sha1=?,permission=?,targetVersion=?,sdkVersion=?,versionCode=?,otherVersion=?,packageName=?,versionName=?,sourcePath=?,sourceSize=?,apkmd5=?,apkType=?,apkKey=?,apkSecTrans=?,zipType=?,zipKey=?,zipSecTrans=?,apkJsonData=?  where md5=?"
            r2 = 21
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r3 = 0
            java.lang.String r4 = r8.getSourceLogo()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r3 = 1
            java.lang.String r4 = r8.getSha256()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r3 = 2
            java.lang.String r4 = r8.getSha1()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r3 = 3
            java.lang.String r4 = r8.getPermission()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r3 = 4
            java.lang.String r4 = r8.getTargetVersion()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r3 = 5
            java.lang.String r4 = r8.getSdkVersion()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r3 = 6
            java.lang.String r4 = r8.getVersionCode()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r3 = 7
            java.lang.String r4 = r8.getOtherVersion()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r3 = 8
            java.lang.String r4 = r8.getPackageName()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r3 = 9
            java.lang.String r4 = r8.getVersionName()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r3 = 10
            java.lang.String r4 = r8.getSourcePath()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r3 = 11
            double r4 = r8.getSourceSize()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            java.lang.Double r4 = java.lang.Double.valueOf(r4)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r3 = 12
            java.lang.String r4 = r8.getApkmd5()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r3 = 13
            int r4 = r8.getApkType()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r3 = 14
            java.lang.String r4 = r8.getApkKey()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r3 = 15
            int r4 = r8.getApkSecTrans()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r3 = 16
            int r4 = r8.getZipType()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r3 = 17
            java.lang.String r4 = r8.getZipKey()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r3 = 18
            int r4 = r8.getZipSecTrans()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r3 = 19
            java.lang.String r8 = r8.getJsonData()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r2[r3] = r8     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r8 = 20
            r2[r8] = r7     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r0.execSQL(r1, r2)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            if (r0 == 0) goto Le3
        Lc0:
            r0.close()     // Catch: java.lang.Throwable -> Leb
            goto Le3
        Lc4:
            r7 = move-exception
            goto Le5
        Lc6:
            r7 = move-exception
            r7.printStackTrace()     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r8 = "TAG"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc4
            r1.<init>()     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r2 = "savePublishUpApkInfo: 上传数据库数据更新进度异常"
            r1.append(r2)     // Catch: java.lang.Throwable -> Lc4
            r1.append(r7)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r7 = r1.toString()     // Catch: java.lang.Throwable -> Lc4
            android.util.Log.i(r8, r7)     // Catch: java.lang.Throwable -> Lc4
            if (r0 == 0) goto Le3
            goto Lc0
        Le3:
            monitor-exit(r6)
            return
        Le5:
            if (r0 == 0) goto Lea
            r0.close()     // Catch: java.lang.Throwable -> Leb
        Lea:
            throw r7     // Catch: java.lang.Throwable -> Leb
        Leb:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.f.q(java.lang.String, com.rtk.app.bean.UpApkBean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
    
        if (r0 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void r(java.lang.String r5, int r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.database.sqlite.SQLiteDatabase r0 = r4.d()     // Catch: java.lang.Throwable -> L44
            java.lang.String r1 = "update upload_apk_info set up_load_state=?  where md5=?"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            r3 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            r2[r3] = r6     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            r6 = 1
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
            java.lang.String r2 = "setUpApkState: 设置暂停  状态  异常"
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
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.f.r(java.lang.String, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
    
        if (r0 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void s(java.lang.String r5, int r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.database.sqlite.SQLiteDatabase r0 = r4.d()     // Catch: java.lang.Throwable -> L44
            java.lang.String r1 = "update upload_apk_info set load_in_background=?  where md5=?"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            r3 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            r2[r3] = r6     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            r6 = 1
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
            java.lang.String r2 = "setUpApkToBack: 设置到后台传输  状态  异常"
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
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.f.s(java.lang.String, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
    
        if (r0 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void t(java.lang.String r5, int r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.database.sqlite.SQLiteDatabase r0 = r4.d()     // Catch: java.lang.Throwable -> L44
            java.lang.String r1 = "update upload_apk_info set up_load_zip_state =?  where zipMd5=?"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            r3 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            r2[r3] = r6     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            r6 = 1
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
            java.lang.String r2 = "setUpZipState: 设置暂停  状态  异常"
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
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.f.t(java.lang.String, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
    
        if (r0 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void u(java.lang.String r5, int r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.database.sqlite.SQLiteDatabase r0 = r4.d()     // Catch: java.lang.Throwable -> L44
            java.lang.String r1 = "update upload_apk_info set load_in_background=?  where zipMd5=?"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            r3 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            r2[r3] = r6     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            r6 = 1
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
            java.lang.String r2 = "setUpApkToBack: 设置到后台传输  状态  异常"
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
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.f.u(java.lang.String, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
    
        if (r0 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void v(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.database.sqlite.SQLiteDatabase r0 = r4.d()     // Catch: java.lang.Throwable -> L40
            java.lang.String r1 = "update upload_apk_info set up_server_file_name=?  where md5=?"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1b
            r3 = 0
            r2[r3] = r5     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1b
            r5 = 1
            r2[r5] = r6     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1b
            r0.execSQL(r1, r2)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1b
            if (r0 == 0) goto L38
        L15:
            r0.close()     // Catch: java.lang.Throwable -> L40
            goto L38
        L19:
            r5 = move-exception
            goto L3a
        L1b:
            r5 = move-exception
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L19
            java.lang.String r6 = "TAG"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L19
            r1.<init>()     // Catch: java.lang.Throwable -> L19
            java.lang.String r2 = "setUpApkToBack: 设置到后台传输  状态  异常"
            r1.append(r2)     // Catch: java.lang.Throwable -> L19
            r1.append(r5)     // Catch: java.lang.Throwable -> L19
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Throwable -> L19
            android.util.Log.i(r6, r5)     // Catch: java.lang.Throwable -> L19
            if (r0 == 0) goto L38
            goto L15
        L38:
            monitor-exit(r4)
            return
        L3a:
            if (r0 == 0) goto L3f
            r0.close()     // Catch: java.lang.Throwable -> L40
        L3f:
            throw r5     // Catch: java.lang.Throwable -> L40
        L40:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.f.v(java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0056, code lost:
    
        if (r0 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void w(java.lang.String r5, int r6, int r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.database.sqlite.SQLiteDatabase r0 = r4.d()     // Catch: java.lang.Throwable -> L61
            java.lang.String r1 = "UP_TAG "
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            r2.<init>()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            java.lang.String r3 = "更新数据库第N片"
            r2.append(r3)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            r2.append(r6)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            com.rtk.app.tool.c0.r(r1, r2)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            java.lang.String r1 = "update upload_apk_info set all_total=? ,current_index=?  where md5=?"
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            r3 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            r2[r3] = r7     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            r7 = 1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            r2[r7] = r6     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            r6 = 2
            r2[r6] = r5     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            r0.execSQL(r1, r2)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            if (r0 == 0) goto L59
        L36:
            r0.close()     // Catch: java.lang.Throwable -> L61
            goto L59
        L3a:
            r5 = move-exception
            goto L5b
        L3c:
            r5 = move-exception
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L3a
            java.lang.String r6 = "TAG"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3a
            r7.<init>()     // Catch: java.lang.Throwable -> L3a
            java.lang.String r1 = "updateProgressUpApkInfo: 上传数据库数据更新进度异常"
            r7.append(r1)     // Catch: java.lang.Throwable -> L3a
            r7.append(r5)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r5 = r7.toString()     // Catch: java.lang.Throwable -> L3a
            android.util.Log.i(r6, r5)     // Catch: java.lang.Throwable -> L3a
            if (r0 == 0) goto L59
            goto L36
        L59:
            monitor-exit(r4)
            return
        L5b:
            if (r0 == 0) goto L60
            r0.close()     // Catch: java.lang.Throwable -> L61
        L60:
            throw r5     // Catch: java.lang.Throwable -> L61
        L61:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.f.w(java.lang.String, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
    
        if (r0 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void x(java.lang.String r5, int r6, int r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.database.sqlite.SQLiteDatabase r0 = r4.d()     // Catch: java.lang.Throwable -> L48
            java.lang.String r1 = "update upload_apk_info set all_zip_total=? ,current_zip_index=?  where zipMd5=?"
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            r3 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            r2[r3] = r7     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            r7 = 1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            r2[r7] = r6     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            r6 = 2
            r2[r6] = r5     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            r0.execSQL(r1, r2)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            if (r0 == 0) goto L40
        L20:
            r0.close()     // Catch: java.lang.Throwable -> L48
            goto L40
        L24:
            r5 = move-exception
            goto L42
        L26:
            r5 = move-exception
            java.lang.String r6 = "TAG"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L24
            r7.<init>()     // Catch: java.lang.Throwable -> L24
            java.lang.String r1 = "updateProgressUpApkInfo: 上传数据库数据更新进度异常"
            r7.append(r1)     // Catch: java.lang.Throwable -> L24
            r7.append(r5)     // Catch: java.lang.Throwable -> L24
            java.lang.String r5 = r7.toString()     // Catch: java.lang.Throwable -> L24
            android.util.Log.i(r6, r5)     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto L40
            goto L20
        L40:
            monitor-exit(r4)
            return
        L42:
            if (r0 == 0) goto L47
            r0.close()     // Catch: java.lang.Throwable -> L48
        L47:
            throw r5     // Catch: java.lang.Throwable -> L48
        L48:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.f.x(java.lang.String, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
    
        if (r7 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void y(java.lang.String r4, int r5, int r6, java.lang.String r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            android.database.sqlite.SQLiteDatabase r7 = r3.d()     // Catch: java.lang.Throwable -> L4b
            java.lang.String r0 = "update upload_apk_info set all_zip_total=? ,current_zip_index=?  where zipMd5=?"
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            r2 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            r1[r2] = r6     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            r6 = 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            r1[r6] = r5     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            r5 = 2
            r1[r5] = r4     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            r7.execSQL(r0, r1)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            if (r7 == 0) goto L43
        L20:
            r7.close()     // Catch: java.lang.Throwable -> L4b
            goto L43
        L24:
            r4 = move-exception
            goto L45
        L26:
            r4 = move-exception
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L24
            java.lang.String r5 = "TAG"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L24
            r6.<init>()     // Catch: java.lang.Throwable -> L24
            java.lang.String r0 = "updateProgressUpApkInfo: 上传数据库数据更新进度异常"
            r6.append(r0)     // Catch: java.lang.Throwable -> L24
            r6.append(r4)     // Catch: java.lang.Throwable -> L24
            java.lang.String r4 = r6.toString()     // Catch: java.lang.Throwable -> L24
            android.util.Log.i(r5, r4)     // Catch: java.lang.Throwable -> L24
            if (r7 == 0) goto L43
            goto L20
        L43:
            monitor-exit(r3)
            return
        L45:
            if (r7 == 0) goto L4a
            r7.close()     // Catch: java.lang.Throwable -> L4b
        L4a:
            throw r4     // Catch: java.lang.Throwable -> L4b
        L4b:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.f.y(java.lang.String, int, int, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
    
        if (r0 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void z(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.database.sqlite.SQLiteDatabase r0 = r4.d()     // Catch: java.lang.Throwable -> L40
            java.lang.String r1 = "update upload_apk_info set zipSaveName=?  where zipMd5=?"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1b
            r3 = 0
            r2[r3] = r6     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1b
            r6 = 1
            r2[r6] = r5     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1b
            r0.execSQL(r1, r2)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1b
            if (r0 == 0) goto L38
        L15:
            r0.close()     // Catch: java.lang.Throwable -> L40
            goto L38
        L19:
            r5 = move-exception
            goto L3a
        L1b:
            r5 = move-exception
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L19
            java.lang.String r6 = "TAG"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L19
            r1.<init>()     // Catch: java.lang.Throwable -> L19
            java.lang.String r2 = "setUpApkToBack: 设置到后台传输  状态  异常"
            r1.append(r2)     // Catch: java.lang.Throwable -> L19
            r1.append(r5)     // Catch: java.lang.Throwable -> L19
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Throwable -> L19
            android.util.Log.i(r6, r5)     // Catch: java.lang.Throwable -> L19
            if (r0 == 0) goto L38
            goto L15
        L38:
            monitor-exit(r4)
            return
        L3a:
            if (r0 == 0) goto L3f
            r0.close()     // Catch: java.lang.Throwable -> L40
        L3f:
            throw r5     // Catch: java.lang.Throwable -> L40
        L40:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.g.f.z(java.lang.String, java.lang.String):void");
    }
}
