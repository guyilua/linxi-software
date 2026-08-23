package com.rtk.app.tool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* compiled from: ImageTool.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class m {
    public static Uri a(Context context) {
        File file = new File(context.getExternalCacheDir(), "rtk_head_icon.jpg");
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Uri fromFile = Uri.fromFile(file);
        if (Build.VERSION.SDK_INT < 24) {
            return fromFile;
        }
        return FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
    }

    public static Uri b(Context context, File file) {
        Uri fromFile = Uri.fromFile(file);
        if (Build.VERSION.SDK_INT < 24) {
            return fromFile;
        }
        return FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
    }

    public static void c(Activity activity, Uri uri, Uri uri2, int i, int i2, int i3, int i4, int i5) {
        Intent intent = new Intent();
        intent.setAction("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        List<ResolveInfo> queryIntentActivities = activity.getPackageManager().queryIntentActivities(intent, 65536);
        if (queryIntentActivities.size() == 0) {
            return;
        }
        Iterator<ResolveInfo> it = queryIntentActivities.iterator();
        while (it.hasNext()) {
            activity.grantUriPermission(it.next().activityInfo.packageName, uri2, 2);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", i);
        intent.putExtra("aspectY", i2);
        intent.putExtra("outputX", i3);
        intent.putExtra("outputY", i4);
        intent.putExtra("scale", true);
        intent.putExtra("output", uri2);
        intent.putExtra("return-data", false);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true);
        intent.putExtra("scaleUpIfNeeded", true);
        activity.startActivityForResult(intent, i5);
    }

    public static Uri d(Context context) {
        File file = new File(context.getExternalCacheDir() + "", "rtk_head_icon.jpg");
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Uri fromFile = Uri.fromFile(file);
        if (Build.VERSION.SDK_INT >= 24) {
            fromFile = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
        }
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", fromFile);
        ((Activity) context).startActivityForResult(intent, 111);
        return fromFile;
    }

    public static void e(Context context) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        ((Activity) context).startActivityForResult(intent, 112);
    }
}
