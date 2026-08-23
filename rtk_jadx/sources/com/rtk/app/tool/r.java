package com.rtk.app.tool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.qq.e.comm.constants.BiddingLossReason;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.dialogPack.AllFileAccessPermissionDialog;
import com.rtk.app.main.dialogPack.DialogPermision;
import com.rtk.app.main.family.PermissionSettings;

/* compiled from: PermissionTool.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class r {
    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        DialogPermision.e = t.E(context);
        int checkSelfPermission = ContextCompat.checkSelfPermission(context, "android.permission.CAMERA");
        int checkSelfPermission2 = ContextCompat.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (checkSelfPermission == 0 && checkSelfPermission2 == 0) {
            return true;
        }
        ActivityCompat.requestPermissions((Activity) context, new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"}, BiddingLossReason.OTHER);
        return false;
    }

    public static boolean b(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            DialogPermision.e = t.U(context);
            if (ContextCompat.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                try {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 10000);
                    return false;
                } catch (ClassCastException unused) {
                    ActivityCompat.requestPermissions((Activity) MyApplication.b(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 10000);
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean c(Context context) {
        boolean z = (e(context) && d(context)) ? false : true;
        if (z) {
            context.startActivity(new Intent(context, (Class<?>) PermissionSettings.class));
        }
        return z;
    }

    public static boolean d(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return context.getPackageManager().canRequestPackageInstalls();
        }
        return true;
    }

    public static boolean e(Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Environment.isExternalStorageManager();
        }
        return true;
    }

    public static void f(Context context) {
        ((Activity) context).startActivityForResult(new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION").setData(Uri.parse("package:" + context.getPackageName())), 118);
    }

    public static void g(Context context) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        if (Build.VERSION.SDK_INT >= 26) {
            intent.setAction("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
        } else {
            intent.setAction("android.settings.SECURITY_SETTINGS");
        }
        context.startActivity(intent);
    }

    public static AllFileAccessPermissionDialog h(Context context) {
        if (e(context)) {
            return null;
        }
        AllFileAccessPermissionDialog allFileAccessPermissionDialog = new AllFileAccessPermissionDialog(context, "此功能需要管理所有文件权限，请去设置授权，好让软天空继续为您服务。");
        allFileAccessPermissionDialog.show();
        return allFileAccessPermissionDialog;
    }
}
