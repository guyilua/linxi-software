package com.sigmob.sdk.base.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.Build;
import android.util.Log;
import com.czhj.sdk.common.Database.SQLiteBuider;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.utils.e;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a extends SQLiteOpenHelper {
    public static final String a = "ads";
    public static final String b = "file_reference";

    /* renamed from: c, reason: collision with root package name */
    public static final String f400c = "trigger_insert";
    public static final String d = "trigger_delete";
    public static final String e = "tracks";
    public static final String f = "adload_event";
    public static final String g = "adload_cache_event";
    public static final String h = "adload_ready_event";
    public static final String i = "wind.db";
    public static final long j = -2;
    public static final long k = -1;
    private static final int l = 11;
    private static String m = "CREATE TABLE ads ( endcard_md5 text  ,video_md5 text  ,ad blob  ,ad_source_channel text  ,ad_type integer  ,create_time integer  ,crid text  ,load_id text  ,adTrackersMap blob  ,adslot_id text  ,camp_id text  ,request_id text , primary key ( crid ,adslot_id) ); \n";
    private static String n = "CREATE TRIGGER trigger_insert after insert on ads begin insert or replace into file_reference (crid,adslot_id,video_md5,endcard_md5) values(new.crid,new.adslot_id,new.video_md5,new.endcard_md5) ; end; \n";
    private static String o = "CREATE TRIGGER trigger_delete after delete on ads begin delete from file_reference where crid = old.crid  and adslot_id == old.adslot_id; end;\n";
    private static String p = "CREATE TABLE file_reference ( endcard_md5 blob  ,video_md5 blob  ,crid text  ,adslot_id text  , primary key ( crid ,adslot_id ) );\n";
    private static String q = "CREATE TABLE tracks ( id integer primary key AUTOINCREMENT ,retryNum integer   ,source text   ,event text   ,request_id text   ,url text   ,timestamp integer   );\n";
    private static String r = "CREATE TABLE adload_event ( id integer primary key AUTOINCREMENT , adslot_id text  , error_code integer ,timestamp integer  );\n";
    private static String s = "CREATE TABLE adload_cache_event (  adslot_id text primary key, media_request_count integer ,media_ready_count integer ,pre_req_time integer , req_interval_time integer ,req_pool_size integer); \n";
    private static String t = "CREATE TABLE adload_ready_event (  adslot_id text primary key, media_request_count integer ,media_ready_count integer ); \n";
    private static final long u = -6;
    private static final long v = -5;
    private static final long w = -4;
    private static final long x = 0;
    private static a y;
    private static SQLiteDatabase z;

    /* renamed from: com.sigmob.sdk.base.db.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface InterfaceC0034a {
        void a();

        void a(Throwable th);
    }

    private a(Context context) {
        super(context, i, (SQLiteDatabase.CursorFactory) null, 11);
    }

    private static long a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            return u;
        }
        if (!sQLiteDatabase.isOpen()) {
            return v;
        }
        if (sQLiteDatabase.isReadOnly()) {
            return w;
        }
        return 0L;
    }

    public static a a() {
        return y;
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            if (y == null) {
                y = new a(context);
            }
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        sQLiteDatabase.execSQL("alter table " + str2 + " drop column " + str);
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        sQLiteDatabase.execSQL("alter table " + str3 + " add " + str + " " + str2);
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS file_reference");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tracks");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS adload_event");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS adload_cache_event");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS adload_ready_event");
        sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS trigger_insert");
        sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS trigger_delete");
        e.i();
        onCreate(sQLiteDatabase);
    }

    public void a(SQLiteDatabase sQLiteDatabase, SQLiteBuider.Insert insert, InterfaceC0034a interfaceC0034a) {
        sQLiteDatabase.beginTransaction();
        boolean z2 = true;
        try {
            SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(insert.getSql());
            for (int i2 = 1; i2 <= insert.getColumns().size(); i2++) {
                Object obj = insert.getValues().get((String) insert.getColumns().get(i2 - 1));
                if (obj != null) {
                    if (obj instanceof String) {
                        compileStatement.bindString(i2, (String) obj);
                    } else if (obj instanceof Double) {
                        compileStatement.bindDouble(i2, ((Double) obj).doubleValue());
                    } else if (obj instanceof Number) {
                        compileStatement.bindLong(i2, ((Number) obj).longValue());
                    } else if (obj instanceof byte[]) {
                        compileStatement.bindBlob(i2, (byte[]) obj);
                    }
                }
                compileStatement.bindNull(i2);
            }
            compileStatement.execute();
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Throwable th) {
            try {
                SigmobLog.e(th.getMessage());
                if (interfaceC0034a != null) {
                    interfaceC0034a.a(th);
                }
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th2) {
                    SigmobLog.e(th2.getMessage());
                    if (interfaceC0034a != null) {
                        interfaceC0034a.a(th2);
                    }
                }
                z2 = false;
            } finally {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th3) {
                    SigmobLog.e(th3.getMessage());
                    if (interfaceC0034a != null) {
                        interfaceC0034a.a(th3);
                    }
                }
            }
        }
        if (!z2 || interfaceC0034a == null) {
            return;
        }
        interfaceC0034a.a();
    }

    public void a(SQLiteDatabase sQLiteDatabase, String str, InterfaceC0034a interfaceC0034a) {
        sQLiteDatabase.beginTransaction();
        boolean z2 = false;
        try {
            sQLiteDatabase.execSQL(str, new Object[0]);
            sQLiteDatabase.setTransactionSuccessful();
            z2 = true;
        } finally {
            try {
                if (z2) {
                    return;
                } else {
                    return;
                }
            } finally {
            }
        }
        if (z2 || interfaceC0034a == null) {
            return;
        }
        interfaceC0034a.a();
    }

    public void b() {
        b(getWritableDatabase());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(r);
        sQLiteDatabase.execSQL(s);
        sQLiteDatabase.execSQL(t);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Log.w(a.class.getName(), "Downgrading database from version " + i2 + " to " + i3 + ", which will destroy all old data");
        b(sQLiteDatabase);
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
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Log.w(a.class.getName(), "Upgrading database from version " + i2 + " to " + i3 + ", which will destroy all old data");
        b(sQLiteDatabase);
    }
}
