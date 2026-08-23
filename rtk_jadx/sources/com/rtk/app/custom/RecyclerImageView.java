package com.rtk.app.custom;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.rtk.app.tool.c0;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class RecyclerImageView extends AppCompatImageView {
    public RecyclerImageView(Context context) {
        super(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachedFromWindow() {
        super/*android.widget.ImageView*/.onDetachedFromWindow();
        setImageDrawable((Drawable) null);
        c0.u("RecyclerImageView", "图片置空");
    }

    public RecyclerImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RecyclerImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
