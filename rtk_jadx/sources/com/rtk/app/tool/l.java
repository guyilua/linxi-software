package com.rtk.app.tool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.rtk.app.R;

/* compiled from: GlideImageLoader.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class l extends com.youth.banner.e.a {
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ImageView c(Context context) {
        return (ImageView) LayoutInflater.from(context).inflate(R.layout.just_image_view, (ViewGroup) null);
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(Context context, Object obj, ImageView imageView) {
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        t.c(context, (String) obj, imageView, new boolean[0]);
    }
}
