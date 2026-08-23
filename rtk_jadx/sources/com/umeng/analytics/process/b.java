package com.umeng.analytics.process;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.umeng.analytics.pro.h;
import java.io.File;

/* compiled from: UMProcessDBCreater.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
class b extends SQLiteOpenHelper {
    b(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a(Context context, String str) {
        String b = b(context, str);
        a.h.equals(str);
        return new b(context, b, null, 1);
    }

    public static String b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = a.h;
        }
        String str2 = h.b(context) + "subprocess/";
        if (a.h.equals(str)) {
            str2 = h.b(context);
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return String.format(str2 + a.e, str);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("create table if not exists __et_p(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __pn TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    public static String a(Context context) {
        return h.b(context) + "subprocess/";
    }
}
