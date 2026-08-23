package com.rtk.app.custom;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SquareImageView extends AppCompatImageView {
    public SquareImageView(Context context) {
        super(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onMeasure(int i, int i2) {
        super/*android.widget.ImageView*/.onMeasure(i, i);
    }

    public SquareImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SquareImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
