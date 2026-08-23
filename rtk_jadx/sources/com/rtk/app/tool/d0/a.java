package com.rtk.app.tool.d0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.tool.h;
import com.rtk.app.tool.t;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/* compiled from: ImageUtil.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    public static Bitmap a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
        return BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, null);
    }

    public static RoundedImageView b(Context context, String str) {
        RoundedImageView roundedImageView = new RoundedImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(h.a(45.0f, context), h.a(45.0f, context));
        layoutParams.rightMargin = 20;
        roundedImageView.setLayoutParams(layoutParams);
        roundedImageView.setAdjustViewBounds(true);
        roundedImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (TextUtils.isEmpty(str)) {
            roundedImageView.setImageResource(R.mipmap.icon_up_picture);
        } else {
            roundedImageView.setOval(true);
            t.c(context, str, roundedImageView, new boolean[0]);
        }
        return roundedImageView;
    }
}
