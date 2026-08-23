package com.sigmob.sdk.base.common;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.czhj.sdk.common.Database.SQLiteBuider;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.db.a;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class z {
    private static HashMap<String, z> d = new HashMap<>();
    public int a;
    public int b;

    /* renamed from: c, reason: collision with root package name */
    public String f398c;

    public static synchronized z a(String str) {
        synchronized (z.class) {
            Cursor cursor = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            z zVar = d.get(str);
            if (zVar == null) {
                zVar = new z();
                zVar.f398c = str;
                try {
                    cursor = com.sigmob.sdk.base.db.a.a().getReadableDatabase().rawQuery("select * from adload_ready_event where adslot_id = '" + str + "' group by adslot_id", null);
                    a(zVar, cursor);
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
                d.put(str, zVar);
            }
            return zVar;
        }
    }

    public static HashMap<String, z> a() {
        return d;
    }

    private static void a(z zVar, Cursor cursor) {
        if (cursor == null || !cursor.moveToFirst()) {
            return;
        }
        do {
            zVar.a = cursor.getInt(cursor.getColumnIndexOrThrow("media_request_count"));
            zVar.b = cursor.getInt(cursor.getColumnIndexOrThrow("media_ready_count"));
        } while (cursor.moveToNext());
    }

    public static void a(final String str, z zVar) {
        if (TextUtils.isEmpty(str) || zVar == null) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = com.sigmob.sdk.base.db.a.a().getWritableDatabase();
            SQLiteBuider.Insert.Builder builder = new SQLiteBuider.Insert.Builder();
            builder.setTableName(com.sigmob.sdk.base.db.a.h);
            HashMap hashMap = new HashMap();
            hashMap.put("adslot_id", str);
            hashMap.put("media_request_count", Integer.valueOf(zVar.a));
            hashMap.put("media_ready_count", Integer.valueOf(zVar.b));
            builder.setColumnValues(hashMap);
            com.sigmob.sdk.base.db.a.a().a(writableDatabase, builder.build(), new a.InterfaceC0034a() { // from class: com.sigmob.sdk.base.common.z.1
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
            com.sigmob.sdk.base.db.a.a().getWritableDatabase().delete(com.sigmob.sdk.base.db.a.h, "adslot_id=?", new String[]{str});
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    public static void c() {
        try {
            Cursor rawQuery = com.sigmob.sdk.base.db.a.a().getReadableDatabase().rawQuery("select * from adload_ready_event", null);
            if (rawQuery == null || !rawQuery.moveToFirst()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            do {
                z zVar = new z();
                zVar.f398c = rawQuery.getString(rawQuery.getColumnIndexOrThrow("adslot_id"));
                zVar.a = rawQuery.getInt(rawQuery.getColumnIndexOrThrow("media_request_count"));
                zVar.b = rawQuery.getInt(rawQuery.getColumnIndexOrThrow("media_ready_count"));
                arrayList.add(zVar);
                d.put(zVar.f398c, zVar);
            } while (rawQuery.moveToNext());
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    public void b() {
        if (TextUtils.isEmpty(this.f398c)) {
            return;
        }
        this.a = 0;
        this.b = 0;
        b(this.f398c);
    }
}
