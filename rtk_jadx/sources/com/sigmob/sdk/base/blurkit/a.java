package com.sigmob.sdk.base.blurkit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    private static final float a = 1.0f;
    private static a b;

    /* renamed from: c, reason: collision with root package name */
    private static RenderScript f349c;

    private Bitmap a(Bitmap bitmap, float f) {
        Bitmap createBitmap = Bitmap.createBitmap((int) (bitmap.getWidth() * f), (int) (bitmap.getHeight() * f), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix = new Matrix();
        matrix.preScale(f, f);
        canvas.setMatrix(matrix);
        canvas.drawBitmap(bitmap, c.d, c.d, (Paint) null);
        return createBitmap;
    }

    private Bitmap a(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    private Bitmap a(View view, float f) {
        Bitmap createBitmap = Bitmap.createBitmap((int) (view.getWidth() * f), (int) (view.getHeight() * f), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix = new Matrix();
        matrix.preScale(f, f);
        canvas.setMatrix(matrix);
        view.draw(canvas);
        return createBitmap;
    }

    public static a a() {
        a aVar = b;
        if (aVar != null) {
            return aVar;
        }
        throw new RuntimeException("BlurKit not initialized!");
    }

    public static void a(Context context) {
        if (b != null) {
            return;
        }
        b = new a();
        f349c = RenderScript.create(context.getApplicationContext());
    }

    public Bitmap a(Bitmap bitmap, int i) {
        try {
            Allocation createFromBitmap = Allocation.createFromBitmap(f349c, bitmap);
            Allocation createTyped = Allocation.createTyped(f349c, createFromBitmap.getType());
            if (Build.VERSION.SDK_INT >= 17) {
                RenderScript renderScript = f349c;
                ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
                create.setRadius(i);
                create.setInput(createFromBitmap);
                create.forEach(createTyped);
            }
            createTyped.copyTo(bitmap);
        } catch (Throwable unused) {
        }
        return bitmap;
    }

    public Bitmap a(Bitmap bitmap, int i, float f) {
        return a(a(bitmap, f), i);
    }

    public Bitmap a(View view, int i) {
        return a(a(view), i);
    }

    public Bitmap a(View view, int i, float f) {
        return a(a(view, f), i);
    }
}
