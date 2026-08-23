package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.logger.SigmobLog;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b extends RelativeLayout {
    private static float d = 8.0f;
    private static final float e = 1.0f;
    private final int a;
    private ImageView b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f462c;

    public b(Context context, int i) {
        super(context);
        this.a = i;
        ImageView imageView = new ImageView(context);
        this.b = imageView;
        imageView.setId(ClientMetadata.generateViewId());
        TextView textView = new TextView(context);
        this.f462c = textView;
        textView.setTextColor(Color.parseColor("#B9B9B9"));
        this.f462c.setTextSize(1, 12.0f);
        int dipsToIntPixels = Dips.dipsToIntPixels(5.0f, getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, Dips.dipsToIntPixels(16.0f, context));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, Dips.dipsToIntPixels(16.0f, context));
        this.f462c.setGravity(17);
        this.b.setScaleType(ImageView.ScaleType.FIT_START);
        this.b.setAdjustViewBounds(true);
        this.b.setMaxWidth(Dips.dipsToIntPixels(40.0f, context));
        this.b.setMinimumWidth(Dips.dipsToIntPixels(16.0f, context));
        if (i == 1) {
            layoutParams2.addRule(9);
            layoutParams2.addRule(12);
            int i2 = dipsToIntPixels * 2;
            layoutParams2.setMargins(dipsToIntPixels, 0, 0, i2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, dipsToIntPixels, i2);
        } else {
            layoutParams.setMargins(dipsToIntPixels, 0, 0, 0);
            layoutParams.addRule(9);
            layoutParams.addRule(12);
            layoutParams2.setMargins(0, 0, 0, 0);
            layoutParams2.addRule(1, this.b.getId());
            layoutParams2.addRule(8, this.b.getId());
        }
        this.b.setBackgroundColor(Color.alpha(0));
        addView(this.b, layoutParams);
        addView(this.f462c, layoutParams2);
    }

    public void a(Bitmap bitmap) {
        if (bitmap != null) {
            this.b.setImageBitmap(bitmap);
        }
    }

    public void a(String str) {
        com.sigmob.sdk.base.common.h.a().getBitmap(str, new ImageManager.BitmapLoadedListener() { // from class: com.sigmob.sdk.base.views.b.1
            public void onBitmapLoadFailed() {
            }

            public void onBitmapLoaded(Bitmap bitmap) {
                int dipsToIntPixels = Dips.dipsToIntPixels(3.0f, b.this.getContext());
                if (bitmap != null) {
                    if (b.this.a != 1 && bitmap.getWidth() > bitmap.getHeight() * 1.5f) {
                        ((RelativeLayout.LayoutParams) b.this.b.getLayoutParams()).setMargins((-dipsToIntPixels) * (bitmap.getWidth() / bitmap.getHeight()), 0, 0, 0);
                    }
                    b.this.b.setImageBitmap(bitmap);
                }
            }
        });
    }

    public void b(String str) {
        try {
            this.f462c.setText(str);
        } catch (Throwable th) {
            SigmobLog.e("showAdText error", th);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }
}
