package com.umeng.analytics.pro;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;

/* compiled from: UMDBCreater.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
class c extends ContextWrapper {
    private String a;

    public c(Context context, String str) {
        super(context);
        this.a = str;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        File file = new File(this.a + str);
        if (!file.getParentFile().exists() && !file.getParentFile().isDirectory()) {
            file.getParentFile().mkdirs();
        }
        return file;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return SQLiteDatabase.openDatabase(getDatabasePath(str).getAbsolutePath(), cursorFactory, 268435472);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        return SQLiteDatabase.openDatabase(getDatabasePath(str).getAbsolutePath(), cursorFactory, 268435472);
    }
}
