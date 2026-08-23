package com.sigmob.sdk.videocache.sourcestorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sigmob.sdk.videocache.o;
import com.sigmob.sdk.videocache.v;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class a extends SQLiteOpenHelper implements c {
    private static final String a = "SourceInfo";
    private static final String b = "_id";

    /* renamed from: c, reason: collision with root package name */
    private static final String f673c = "url";
    private static final String d = "length";
    private static final String e = "mime";
    private static final String[] f = {"_id", "url", d, e};
    private static final String g = "CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);";

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        o.a(context);
    }

    private ContentValues a(v vVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", vVar.a);
        contentValues.put(d, Long.valueOf(vVar.b));
        contentValues.put(e, vVar.f674c);
        return contentValues;
    }

    private v a(Cursor cursor) {
        return new v(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow(d)), cursor.getString(cursor.getColumnIndexOrThrow(e)));
    }

    @Override // com.sigmob.sdk.videocache.sourcestorage.c
    public v a(String str) {
        Throwable th;
        Cursor cursor;
        o.a(str);
        v vVar = null;
        try {
            cursor = getReadableDatabase().query(a, f, "url=?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        vVar = a(cursor);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return vVar;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    @Override // com.sigmob.sdk.videocache.sourcestorage.c
    public void a() {
        close();
    }

    @Override // com.sigmob.sdk.videocache.sourcestorage.c
    public void a(String str, v vVar) {
        o.a(str, vVar);
        boolean z = a(str) != null;
        ContentValues a2 = a(vVar);
        if (z) {
            getWritableDatabase().update(a, a2, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert(a, null, a2);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        o.a(sQLiteDatabase);
        sQLiteDatabase.execSQL(g);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }
}
