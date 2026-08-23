package com.sigmob.sdk.downloader.core.breakpoint;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e extends SQLiteOpenHelper {
    static final String a = "taskFileDirty";
    private static final String b = "sig_breakpoint.db";

    /* renamed from: c, reason: collision with root package name */
    private static final int f500c = 3;
    private static final String d = "FileDownloadResponseFilename";
    private static final String e = "breakpoint";
    private static final String f = "block";

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private interface a {
        public static final String a = "CREATE TABLE IF NOT EXISTS breakpoint( id INTEGER PRIMARY KEY, url VARCHAR NOT NULL, etag VARCHAR, parent_path VARCHAR NOT NULL, filename VARCHAR, task_only_parent_path TINYINT(1) DEFAULT 0, chunked TINYINT(1) DEFAULT 0)";
        public static final String b = "CREATE TABLE IF NOT EXISTS block( id INTEGER PRIMARY KEY AUTOINCREMENT, breakpoint_id INTEGER, block_index INTEGER, start_offset INTEGER, content_length INTEGER, current_offset INTEGER)";

        /* renamed from: c, reason: collision with root package name */
        public static final String f501c = "CREATE TABLE IF NOT EXISTS FileDownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)";
        public static final String d = "CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)";
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private interface b {
        public static final String a = "CREATE TABLE IF NOT EXISTS FileDownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)";
        public static final String b = "CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)";
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private interface c {
        public static final String a = "SELECT * FROM taskFileDirty";
        public static final String b = "SELECT * FROM breakpoint";

        /* renamed from: c, reason: collision with root package name */
        public static final String f502c = "SELECT * FROM block";
        public static final String d = "SELECT * FROM FileDownloadResponseFilename";
        public static final String e = "SELECT filename FROM FileDownloadResponseFilename WHERE url = ?";
        public static final String f = "SELECT id FROM breakpoint WHERE id = ? LIMIT 1";
    }

    public e(Context context) {
        super(context, b, (SQLiteDatabase.CursorFactory) null, 3);
    }

    private static ContentValues a(int i, int i2, com.sigmob.sdk.downloader.core.breakpoint.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(f.h, Integer.valueOf(i));
        contentValues.put(f.i, Integer.valueOf(i2));
        contentValues.put(f.j, Long.valueOf(aVar.b()));
        contentValues.put(f.k, Long.valueOf(aVar.d()));
        contentValues.put(f.l, Long.valueOf(aVar.a()));
        return contentValues;
    }

    private static ContentValues c(com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(cVar.a));
        contentValues.put("url", cVar.l());
        contentValues.put(f.f503c, cVar.k());
        contentValues.put(f.d, cVar.b.getAbsolutePath());
        contentValues.put("filename", cVar.m());
        contentValues.put(f.f, Integer.valueOf(cVar.d() ? 1 : 0));
        contentValues.put("chunked", Integer.valueOf(cVar.b() ? 1 : 0));
        return contentValues;
    }

    public List<Integer> a() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery(c.a, null);
            while (cursor.moveToNext()) {
                arrayList.add(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("id"))));
            }
            return arrayList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public void a(int i) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("id", Integer.valueOf(i));
        writableDatabase.insert(a, null, contentValues);
    }

    public void a(com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        int g = cVar.g();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        for (int i = 0; i < g; i++) {
            com.sigmob.sdk.downloader.core.breakpoint.a b2 = cVar.b(i);
            if (writableDatabase.insert(f, null, a(cVar.a, i, b2)) == -1) {
                throw new com.sigmob.sdk.downloader.core.exception.h("insert block " + b2 + " failed!");
            }
        }
        if (writableDatabase.insert(e, null, c(cVar)) != -1) {
            return;
        }
        throw new com.sigmob.sdk.downloader.core.exception.h("insert info " + cVar + " failed!");
    }

    public void a(com.sigmob.sdk.downloader.core.breakpoint.c cVar, int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(f.l, Long.valueOf(j));
        getWritableDatabase().update(f, contentValues, "breakpoint_id = ? AND block_index = ?", new String[]{Integer.toString(cVar.a), Integer.toString(i)});
    }

    public void a(String str, String str2) {
        Cursor rawQuery;
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("url", str);
        contentValues.put("filename", str2);
        synchronized (str.intern()) {
            Cursor cursor = null;
            try {
                rawQuery = writableDatabase.rawQuery(c.e, new String[]{str});
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (!rawQuery.moveToFirst()) {
                    writableDatabase.insert(d, null, contentValues);
                } else if (!str2.equals(rawQuery.getString(rawQuery.getColumnIndex("filename")))) {
                    writableDatabase.replace(d, null, contentValues);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = rawQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    public SparseArray<com.sigmob.sdk.downloader.core.breakpoint.c> b() {
        Cursor cursor;
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Cursor cursor2 = null;
        try {
            Cursor rawQuery = writableDatabase.rawQuery(c.b, null);
            while (rawQuery.moveToNext()) {
                try {
                    arrayList.add(new d(rawQuery));
                } catch (Throwable th) {
                    th = th;
                    cursor = cursor2;
                    cursor2 = rawQuery;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            cursor2 = writableDatabase.rawQuery(c.f502c, null);
            while (cursor2.moveToNext()) {
                arrayList2.add(new com.sigmob.sdk.downloader.core.breakpoint.b(cursor2));
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            if (cursor2 != null) {
                cursor2.close();
            }
            SparseArray<com.sigmob.sdk.downloader.core.breakpoint.c> sparseArray = new SparseArray<>();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                com.sigmob.sdk.downloader.core.breakpoint.c h = ((d) it.next()).h();
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    com.sigmob.sdk.downloader.core.breakpoint.b bVar = (com.sigmob.sdk.downloader.core.breakpoint.b) it2.next();
                    if (bVar.a() == h.a) {
                        h.a(bVar.e());
                        it2.remove();
                    }
                }
                sparseArray.put(h.a, h);
            }
            return sparseArray;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    public void b(int i) {
        getWritableDatabase().delete(a, "id = ?", new String[]{String.valueOf(i)});
    }

    public void b(com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery(c.f, new String[]{Integer.toString(cVar.a)});
            if (cursor.moveToNext()) {
                c(cVar.a);
                a(cVar);
                writableDatabase.setTransactionSuccessful();
                if (cursor != null) {
                    cursor.close();
                }
                writableDatabase.endTransaction();
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            writableDatabase.endTransaction();
        }
    }

    public HashMap<String, String> c() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        HashMap<String, String> hashMap = new HashMap<>();
        Cursor cursor = null;
        try {
            cursor = writableDatabase.rawQuery(c.d, null);
            while (cursor.moveToNext()) {
                int columnIndex = cursor.getColumnIndex("url");
                String str = "";
                String string = columnIndex >= 0 ? cursor.getString(columnIndex) : "";
                int columnIndex2 = cursor.getColumnIndex("filename");
                if (columnIndex2 >= 0) {
                    str = cursor.getString(columnIndex2);
                }
                hashMap.put(string, str);
            }
            return hashMap;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public void c(int i) {
        getWritableDatabase().delete(e, "id = ?", new String[]{String.valueOf(i)});
        d(i);
    }

    public void d(int i) {
        getWritableDatabase().delete(f, "breakpoint_id = ?", new String[]{String.valueOf(i)});
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(a.a);
        sQLiteDatabase.execSQL(a.b);
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS FileDownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        if (Build.VERSION.SDK_INT >= 16) {
            setWriteAheadLoggingEnabled(true);
        } else {
            sQLiteDatabase.enableWriteAheadLogging();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 1 && i2 == 2) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS FileDownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)");
        }
        if (i <= 2) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)");
        }
    }
}
