package com.rtk.app.custom.RichEditText.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.rtk.app.R;
import com.rtk.app.main.MyApplication;
import com.rtk.app.tool.c0;

/* compiled from: ImageTool.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c {
    public static Bitmap a(Bitmap bitmap, String str) {
        Bitmap decodeResource;
        try {
            Resources resources = MyApplication.b().getResources();
            float f = resources.getDisplayMetrics().density;
            Bitmap.Config config = bitmap.getConfig();
            if (config == null) {
                config = Bitmap.Config.ARGB_8888;
            }
            bitmap = bitmap.copy(config, true);
            Canvas canvas = new Canvas(bitmap);
            if (str.equals("gif")) {
                decodeResource = BitmapFactory.decodeResource(resources, R.mipmap.icon_gif_tag);
            } else {
                decodeResource = BitmapFactory.decodeResource(resources, R.mipmap.icon_video_tag);
            }
            if (decodeResource != null) {
                canvas.drawBitmap(decodeResource, bitmap.getWidth() - decodeResource.getWidth(), bitmap.getHeight() - decodeResource.getHeight(), (Paint) null);
            }
        } catch (Exception unused) {
        }
        return bitmap;
    }

    public static Bitmap b(Bitmap bitmap, int i, int i2, String... strArr) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        if (strArr.length == 0) {
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        }
        return a(Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true), strArr[0]);
    }

    public static Bitmap c(Bitmap bitmap, int i, String... strArr) {
        int height = (bitmap.getHeight() * i) / bitmap.getWidth();
        c0.u("ImageTool", "高度" + height);
        return b(bitmap, i, height, strArr);
    }
}
