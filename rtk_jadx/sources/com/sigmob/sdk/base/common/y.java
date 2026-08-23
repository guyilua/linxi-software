package com.sigmob.sdk.base.common;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.czhj.sdk.common.Database.SQLiteBuider;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.db.a;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class y {
    private static HashMap<String, y> h = new HashMap<>();
    public int a;
    public int b;

    /* renamed from: c, reason: collision with root package name */
    public long f397c;
    public int d = 0;
    public int e = 30;
    public int f;
    public long g;

    public static synchronized y a(String str) {
        synchronized (y.class) {
            Cursor cursor = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            y yVar = h.get(str);
            if (yVar == null) {
                yVar = new y();
                try {
                    cursor = com.sigmob.sdk.base.db.a.a().getReadableDatabase().rawQuery("select * from adload_cache_event where adslot_id = '" + str + "' group by adslot_id", null);
                    a(yVar, cursor);
                } catch (Throwable th) {
                    try {
                        SigmobLog.e(th.getMessage());
                        if (cursor != null && !cursor.isClosed()) {
                        }
                    } finally {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                    }
                }
                h.put(str, yVar);
            }
            return yVar;
        }
    }

    private static void a(y yVar, Cursor cursor) {
        if (cursor == null || !cursor.moveToFirst()) {
            return;
        }
        do {
            yVar.a = cursor.getInt(cursor.getColumnIndexOrThrow("media_request_count"));
            yVar.b = cursor.getInt(cursor.getColumnIndexOrThrow("media_ready_count"));
            long j = cursor.getLong(cursor.getColumnIndexOrThrow("pre_req_time"));
            yVar.f397c = j;
            yVar.g = j;
            yVar.d = cursor.getInt(cursor.getColumnIndexOrThrow("req_interval_time"));
            yVar.e = cursor.getInt(cursor.getColumnIndexOrThrow("req_pool_size"));
        } while (cursor.moveToNext());
    }

    public static void a(final String str, y yVar) {
        if (TextUtils.isEmpty(str) || yVar == null) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = com.sigmob.sdk.base.db.a.a().getWritableDatabase();
            SQLiteBuider.Insert.Builder builder = new SQLiteBuider.Insert.Builder();
            builder.setTableName(com.sigmob.sdk.base.db.a.g);
            HashMap hashMap = new HashMap();
            hashMap.put("adslot_id", str);
            hashMap.put("media_request_count", Integer.valueOf(yVar.a));
            hashMap.put("media_ready_count", Integer.valueOf(yVar.b));
            hashMap.put("pre_req_time", Long.valueOf(yVar.f397c));
            hashMap.put("req_interval_time", Integer.valueOf(yVar.d));
            hashMap.put("req_pool_size", Integer.valueOf(yVar.e));
            builder.setColumnValues(hashMap);
            com.sigmob.sdk.base.db.a.a().a(writableDatabase, builder.build(), new a.InterfaceC0034a() { // from class: com.sigmob.sdk.base.common.y.1
                @Override // com.sigmob.sdk.base.db.a.InterfaceC0034a
                public void a() {
                    SigmobLog.d(str + " insert load cache event " + str + " onSuccess: ");
                }

                @Override // com.sigmob.sdk.base.db.a.InterfaceC0034a
                public void a(Throwable th) {
                    SigmobLog.e(str + " insert  load cache event " + str + " onFailed: ", th);
                }
            });
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    private void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            com.sigmob.sdk.base.db.a.a().getWritableDatabase().delete(com.sigmob.sdk.base.db.a.g, "adslot_id=?", new String[]{str});
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }
}
