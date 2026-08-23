package com.umeng.analytics.process;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.umeng.analytics.process.DBFileTraversalUtil;
import com.umeng.analytics.process.a;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UMProcessDBHelper {
    private static UMProcessDBHelper mInstance;
    private Context mContext;
    private FileLockUtil mFileLock = new FileLockUtil();
    private InsertEventCallback ekvCallBack = new InsertEventCallback();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class InsertEventCallback implements FileLockCallback {
        private InsertEventCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str.startsWith(com.umeng.analytics.process.a.f1068c)) {
                str = str.replaceFirst(com.umeng.analytics.process.a.f1068c, "");
            }
            UMProcessDBHelper.this.insertEvents(str.replace(com.umeng.analytics.process.a.d, ""), (JSONArray) obj);
            return true;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private class ProcessToMainCallback implements FileLockCallback {
        private ProcessToMainCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str.startsWith(com.umeng.analytics.process.a.f1068c)) {
                str = str.replaceFirst(com.umeng.analytics.process.a.f1068c, "");
            }
            UMProcessDBHelper.this.processToMain(str.replace(com.umeng.analytics.process.a.d, ""));
            return true;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements Serializable {
        int a;
        String b;

        /* renamed from: c, reason: collision with root package name */
        String f1067c;
        String d;
        int e;
        String f;
        String g;
        String h;

        private a() {
        }
    }

    private UMProcessDBHelper() {
    }

    private List<a> datasAdapter(String str, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                a aVar = new a();
                aVar.f1067c = jSONObject.optString("id");
                aVar.g = UMUtils.getAppVersionName(this.mContext);
                aVar.h = UMUtils.getAppVersionCode(this.mContext);
                aVar.b = jSONObject.optString("__i");
                aVar.e = jSONObject.optInt("__t");
                aVar.f = str;
                if (jSONObject.has("ds")) {
                    jSONObject.remove("ds");
                }
                jSONObject.put("ds", getDataSource());
                jSONObject.remove("__i");
                jSONObject.remove("__t");
                aVar.d = com.umeng.common.a.a().a(jSONObject.toString());
                jSONObject.remove("ds");
                arrayList.add(aVar);
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    private boolean dbIsExists(String str) {
        try {
            return new File(b.b(this.mContext, str)).exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    private int getDataSource() {
        return 0;
    }

    public static UMProcessDBHelper getInstance(Context context) {
        if (mInstance == null) {
            synchronized (UMProcessDBHelper.class) {
                if (mInstance == null) {
                    mInstance = new UMProcessDBHelper(context);
                }
            }
        }
        UMProcessDBHelper uMProcessDBHelper = mInstance;
        uMProcessDBHelper.mContext = context;
        return uMProcessDBHelper;
    }

    private boolean insertEvents_(String str, List<a> list) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return true;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase a2 = c.a(this.mContext).a(str);
            try {
                try {
                    a2.beginTransaction();
                    for (a aVar : list) {
                        try {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("__i", aVar.b);
                            contentValues.put("__e", aVar.f1067c);
                            contentValues.put("__t", Integer.valueOf(aVar.e));
                            contentValues.put(a.InterfaceC0126a.f, aVar.f);
                            contentValues.put("__av", aVar.g);
                            contentValues.put("__vc", aVar.h);
                            contentValues.put("__s", aVar.d);
                            a2.insert(a.InterfaceC0126a.a, null, contentValues);
                        } catch (Exception unused) {
                        }
                    }
                    a2.setTransactionSuccessful();
                    if (a2 != null) {
                        try {
                            a2.endTransaction();
                        } catch (Throwable unused2) {
                        }
                    }
                    c.a(this.mContext).b(str);
                    return true;
                } catch (Throwable th) {
                    th = th;
                    sQLiteDatabase = a2;
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Throwable unused3) {
                        }
                    }
                    c.a(this.mContext).b(str);
                    throw th;
                }
            } catch (Exception unused4) {
                sQLiteDatabase = a2;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused5) {
                    }
                }
                c.a(this.mContext).b(str);
                return false;
            }
        } catch (Exception unused6) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean processIsService(Context context) {
        return context.getPackageManager().getServiceInfo(new ComponentName(context, this.mContext.getClass()), 0) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processToMain(String str) {
        if (dbIsExists(str)) {
            List<a> readEventByProcess = readEventByProcess(str);
            if (!readEventByProcess.isEmpty() && insertEvents_(com.umeng.analytics.process.a.h, readEventByProcess)) {
                deleteEventDatas(str, null, readEventByProcess);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0093, code lost:
    
        if (r2 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00ae, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ac, code lost:
    
        if (r2 != null) goto L28;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c4 A[Catch: Exception -> 0x00c7, TRY_LEAVE, TryCatch #4 {Exception -> 0x00c7, blocks: (B:38:0x00bf, B:32:0x00c4), top: B:37:0x00bf }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.umeng.analytics.process.UMProcessDBHelper$1] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<com.umeng.analytics.process.UMProcessDBHelper.a> readEventByProcess(java.lang.String r13) {
        /*
            r12 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.content.Context r2 = r12.mContext     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
            com.umeng.analytics.process.c r2 = com.umeng.analytics.process.c.a(r2)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
            android.database.sqlite.SQLiteDatabase r2 = r2.a(r13)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
            r2.beginTransaction()     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L98
            java.lang.String r4 = "__et_p"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r3 = r2
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L98
            if (r3 == 0) goto L8e
        L22:
            boolean r4 = r3.moveToNext()     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            if (r4 == 0) goto L8e
            com.umeng.analytics.process.UMProcessDBHelper$a r4 = new com.umeng.analytics.process.UMProcessDBHelper$a     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            r4.<init>()     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            r5 = 0
            int r5 = r3.getInt(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            r4.a = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            java.lang.String r5 = "__i"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            r4.b = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            java.lang.String r5 = "__e"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            r4.f1067c = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            java.lang.String r5 = "__s"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            r4.d = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            java.lang.String r5 = "__t"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            int r5 = r3.getInt(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            r4.e = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            java.lang.String r5 = "__pn"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            r4.f = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            java.lang.String r5 = "__av"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            r4.g = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            java.lang.String r5 = "__vc"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            r4.h = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            r0.add(r4)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            goto L22
        L8c:
            r1 = move-exception
            goto La4
        L8e:
            if (r3 == 0) goto L93
            r3.close()     // Catch: java.lang.Exception -> Lb1
        L93:
            if (r2 == 0) goto Lb1
            goto Lae
        L96:
            r0 = move-exception
            goto Lbd
        L98:
            r3 = move-exception
            r11 = r3
            r3 = r1
            r1 = r11
            goto La4
        L9d:
            r0 = move-exception
            r2 = r1
            goto Lbd
        La0:
            r2 = move-exception
            r3 = r1
            r1 = r2
            r2 = r3
        La4:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> Lbb
            if (r3 == 0) goto Lac
            r3.close()     // Catch: java.lang.Exception -> Lb1
        Lac:
            if (r2 == 0) goto Lb1
        Lae:
            r2.endTransaction()     // Catch: java.lang.Exception -> Lb1
        Lb1:
            android.content.Context r1 = r12.mContext
            com.umeng.analytics.process.c r1 = com.umeng.analytics.process.c.a(r1)
            r1.b(r13)
            return r0
        Lbb:
            r0 = move-exception
            r1 = r3
        Lbd:
            if (r1 == 0) goto Lc2
            r1.close()     // Catch: java.lang.Exception -> Lc7
        Lc2:
            if (r2 == 0) goto Lc7
            r2.endTransaction()     // Catch: java.lang.Exception -> Lc7
        Lc7:
            android.content.Context r1 = r12.mContext
            com.umeng.analytics.process.c r1 = com.umeng.analytics.process.c.a(r1)
            r1.b(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.readEventByProcess(java.lang.String):java.util.List");
    }

    public void createDBByProcess(String str) {
        try {
            c.a(this.mContext).a(str);
            c.a(this.mContext).b(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteEventDatas(String str, String str2, List<a> list) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            sQLiteDatabase = c.a(this.mContext).a(str);
            try {
                sQLiteDatabase.beginTransaction();
                int size = list.size();
                if (list == null || size <= 0) {
                    sQLiteDatabase.delete(a.InterfaceC0126a.a, null, null);
                } else {
                    for (int i = 0; i < size; i++) {
                        sQLiteDatabase.execSQL("delete from __et_p where rowid=" + list.get(i).a);
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            } catch (Exception unused) {
                sQLiteDatabase2 = sQLiteDatabase;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.endTransaction();
                }
                c.a(this.mContext).b(str);
            } catch (Throwable th2) {
                th = th2;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
                c.a(this.mContext).b(str);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            sQLiteDatabase = null;
            th = th3;
        }
        c.a(this.mContext).b(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x004e, code lost:
    
        com.umeng.analytics.process.c.a(r7.mContext).b(com.umeng.analytics.process.a.h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0057, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004b, code lost:
    
        r1.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
    
        if (r1 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0035, code lost:
    
        if (r1 != null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void deleteMainProcessEventDatasByIds(java.util.List<java.lang.Integer> r8) {
        /*
            r7 = this;
            java.lang.String r0 = "_main_"
            r1 = 0
            android.content.Context r2 = r7.mContext     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            com.umeng.analytics.process.c r2 = com.umeng.analytics.process.c.a(r2)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            android.database.sqlite.SQLiteDatabase r1 = r2.a(r0)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            java.util.Iterator r8 = r8.iterator()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
        L14:
            boolean r2 = r8.hasNext()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            if (r2 == 0) goto L32
            java.lang.Object r2 = r8.next()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            java.lang.String r3 = "__et_p"
            java.lang.String r4 = "id=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            r6 = 0
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            r5[r6] = r2     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            r1.delete(r3, r4, r5)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            goto L14
        L32:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            if (r1 == 0) goto L4e
            goto L4b
        L38:
            r8 = move-exception
            if (r1 == 0) goto L3e
            r1.endTransaction()
        L3e:
            android.content.Context r1 = r7.mContext
            com.umeng.analytics.process.c r1 = com.umeng.analytics.process.c.a(r1)
            r1.b(r0)
            throw r8
        L48:
            if (r1 == 0) goto L4e
        L4b:
            r1.endTransaction()
        L4e:
            android.content.Context r8 = r7.mContext
            com.umeng.analytics.process.c r8 = com.umeng.analytics.process.c.a(r8)
            r8.b(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.deleteMainProcessEventDatasByIds(java.util.List):void");
    }

    public void insertEvents(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            insertEvents_(str, datasAdapter(str, jSONArray));
        }
    }

    public void insertEventsInSubProcess(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            File file = new File(b.b(this.mContext, str));
            if (file.exists()) {
                this.mFileLock.doFileOperateion(file, this.ekvCallBack, jSONArray);
            } else {
                insertEvents(str, jSONArray);
            }
        }
    }

    public void processDBToMain() {
        try {
            DBFileTraversalUtil.traverseDBFiles(b.a(this.mContext), new ProcessToMainCallback(), new DBFileTraversalUtil.a() { // from class: com.umeng.analytics.process.UMProcessDBHelper.1
                @Override // com.umeng.analytics.process.DBFileTraversalUtil.a
                public void a() {
                    if (AnalyticsConstants.SUB_PROCESS_EVENT) {
                        UMWorkDispatch.sendEvent(UMProcessDBHelper.this.mContext, UMProcessDBDatasSender.UM_PROCESS_CONSTRUCTMESSAGE, UMProcessDBDatasSender.getInstance(UMProcessDBHelper.this.mContext), null);
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x018b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject readMainEvents(long r20, java.util.List<java.lang.Integer> r22) {
        /*
            Method dump skipped, instructions count: 408
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.readMainEvents(long, java.util.List):org.json.JSONObject");
    }

    public JSONObject readVersionInfoFromColumId(Integer num) {
        SQLiteDatabase sQLiteDatabase;
        JSONObject jSONObject;
        Cursor cursor = null;
        r3 = null;
        JSONObject jSONObject2 = null;
        cursor = null;
        cursor = null;
        cursor = null;
        try {
            sQLiteDatabase = c.a(this.mContext).a(com.umeng.analytics.process.a.h);
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    Cursor query = sQLiteDatabase.query(a.InterfaceC0126a.a, null, "rowid=?", new String[]{String.valueOf(num)}, null, null, null);
                    if (query != null) {
                        try {
                            try {
                                if (query.moveToNext()) {
                                    jSONObject = new JSONObject();
                                    try {
                                        String string = query.getString(query.getColumnIndex("__av"));
                                        String string2 = query.getString(query.getColumnIndex("__vc"));
                                        if (!TextUtils.isEmpty(string)) {
                                            jSONObject.put("__av", string);
                                        }
                                        if (!TextUtils.isEmpty(string2)) {
                                            jSONObject.put("__vc", string2);
                                        }
                                        jSONObject2 = jSONObject;
                                    } catch (Exception e) {
                                        e = e;
                                        cursor = query;
                                        e.printStackTrace();
                                        if (cursor != null) {
                                            try {
                                                cursor.close();
                                            } catch (Exception unused) {
                                                c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                                                return jSONObject;
                                            }
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.endTransaction();
                                        }
                                        c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                                        return jSONObject;
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                cursor = query;
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception unused2) {
                                        c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                                        throw th;
                                    }
                                }
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.endTransaction();
                                }
                                c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                                throw th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            jSONObject = null;
                        }
                    }
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Exception unused3) {
                        }
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                    c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                    return jSONObject2;
                } catch (Exception e3) {
                    e = e3;
                    jSONObject = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e4) {
            e = e4;
            sQLiteDatabase = null;
            jSONObject = null;
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = null;
        }
    }

    private UMProcessDBHelper(Context context) {
        com.umeng.common.a.a().a(context);
    }
}
