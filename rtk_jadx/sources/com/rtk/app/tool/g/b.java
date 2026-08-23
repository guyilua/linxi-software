package com.rtk.app.tool.g;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.rtk.app.tool.c0;

/* compiled from: DBHelper.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b extends SQLiteOpenHelper {
    private static int a = 12;

    public b(Context context) {
        super(context, "RTKDownLoadDb.db", (SQLiteDatabase.CursorFactory) null, a);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table download_info ( _id integer PRIMARY KEY AUTOINCREMENT,game_id integer, app_name char,app_state integer,app_size integer, current_size integer,url char unique,icon_url char,version_code integer,zip_app_version char,app_save_path char not null,app_data_size long,signaturesmd5 char,is_apk integer,package_name char,installation char,apkType integer, apkKey char )");
        c0.u("DBHelper", "下载数据库创建");
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table upload_apk_info ( _id integer PRIMARY KEY AUTOINCREMENT,apk_name char, md5 char unique, path char unique,size char,up_server_file_name char,load_in_background integer, up_load_state integer, all_total integer,current_index integer,edit_name char, type integer, tag char, tag_title char, characteristic char, description char, list_imgs char, list_thumb char, img_path_head char, publish_post integer,viewPermissions integer,sourceLogo char,sha256 char,sha1 char,permission char,targetVersion char,sdkVersion char,versionCode char,otherVersion char,packageName char,versionName char,sourcePath char,sourceSize double,isApk integer,zipPath char,zipMd5 char unique,zipServePath char,up_load_zip_state integer, current_zip_index integer,all_zip_total integer,zipSize double,zipSaveName char,apkmd5 char,apkType integer,apkKey char, apkSecTrans integer,zipType integer,zipKey char, zipSecTrans integer,familyId char,setDownloadCoins integer,apkJsonData char )");
        c0.u("DBHelper", "上传数据库创建");
    }

    public void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table teen_mode_info ( _id integer PRIMARY KEY AUTOINCREMENT,data long unique,openTime long unique, endTime long,used long)");
        c0.u("DBHelper", "青少年模式数据库创建");
    }

    public void d(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("alter table download_info add installation char  ");
        e(sQLiteDatabase);
    }

    public void e(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("alter table upload_apk_info add apkJsonData char  ");
    }

    public void f(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("alter table download_info add zip_app_version char  ");
        g(sQLiteDatabase);
    }

    public void g(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists  upload_apk_info ( _id integer PRIMARY KEY AUTOINCREMENT,apk_name char, md5 char unique, path char unique,size char,up_server_file_name char,load_in_background integer, up_load_state integer, all_total integer,current_index integer,edit_name char, type integer, tag char, tag_title char, characteristic char, description char, list_imgs char, list_thumb char, img_path_head char, publish_post integer,sourceLogo char,sha256 char,sha1 char,permission char,targetVersion char,sdkVersion char,versionCode char,otherVersion char,packageName char,versionName char,sourcePath char,sourceSize double)");
        h(sQLiteDatabase);
    }

    public void h(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("alter table upload_apk_info add viewPermissions integer  ");
        i(sQLiteDatabase);
    }

    public void i(SQLiteDatabase sQLiteDatabase) {
        c0.u("DBHelper", "增加字段");
        sQLiteDatabase.execSQL("alter table upload_apk_info add isApk integer");
        sQLiteDatabase.execSQL("alter table upload_apk_info add zipPath char ");
        sQLiteDatabase.execSQL("alter table upload_apk_info add zipMd5 char");
        sQLiteDatabase.execSQL("alter table upload_apk_info add zipServePath char ");
        sQLiteDatabase.execSQL("alter table upload_apk_info add up_load_zip_state int ");
        sQLiteDatabase.execSQL("alter table upload_apk_info add current_zip_index int ");
        sQLiteDatabase.execSQL("alter table upload_apk_info add zipSize char ");
        sQLiteDatabase.execSQL("alter table upload_apk_info add zipSaveName char ");
        sQLiteDatabase.execSQL("alter table upload_apk_info add all_zip_total integer ");
        j(sQLiteDatabase);
    }

    public void j(SQLiteDatabase sQLiteDatabase) {
        c0.u("DBHelper", "青少年模式数据库创建");
        c(sQLiteDatabase);
        k(sQLiteDatabase);
    }

    public void k(SQLiteDatabase sQLiteDatabase) {
        c0.u("DBHelper", "追加apkmd5");
        sQLiteDatabase.execSQL("alter table upload_apk_info add apkmd5 char");
        l(sQLiteDatabase);
    }

    public void l(SQLiteDatabase sQLiteDatabase) {
        c0.u("DBHelper", "追加新的数据库值");
        sQLiteDatabase.execSQL("alter table upload_apk_info add apkType integer");
        sQLiteDatabase.execSQL("alter table upload_apk_info add apkKey char");
        sQLiteDatabase.execSQL("alter table upload_apk_info add apkSecTrans integer");
        sQLiteDatabase.execSQL("alter table upload_apk_info add zipType integer");
        sQLiteDatabase.execSQL("alter table upload_apk_info add zipKey char");
        sQLiteDatabase.execSQL("alter table upload_apk_info add zipSecTrans integer");
        m(sQLiteDatabase);
    }

    public void m(SQLiteDatabase sQLiteDatabase) {
        c0.u("DBHelper", "追加新的数据库值");
        sQLiteDatabase.execSQL("alter table download_info add apkType integer");
        sQLiteDatabase.execSQL("alter table download_info add apkKey char");
        n(sQLiteDatabase);
    }

    public void n(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("alter table upload_apk_info add familyId char  ");
        sQLiteDatabase.execSQL("alter table upload_apk_info add setDownloadCoins integer  ");
        d(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase);
        a(sQLiteDatabase);
        c(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        switch (i) {
            case 1:
                f(sQLiteDatabase);
                return;
            case 2:
                g(sQLiteDatabase);
                return;
            case 3:
                h(sQLiteDatabase);
                return;
            case 4:
                i(sQLiteDatabase);
                return;
            case 5:
                j(sQLiteDatabase);
                return;
            case 6:
                k(sQLiteDatabase);
                return;
            case 7:
                l(sQLiteDatabase);
                return;
            case 8:
                m(sQLiteDatabase);
                return;
            case 9:
                n(sQLiteDatabase);
                return;
            case 10:
                d(sQLiteDatabase);
                return;
            case 11:
                e(sQLiteDatabase);
                return;
            default:
                return;
        }
    }
}
