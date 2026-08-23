package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.czhj.sdk.common.utils.Dips;
import com.sigmob.sdk.base.models.BaseAdUnit;
import java.lang.ref.WeakReference;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class w extends View {
    private Paint a;
    private RectF b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f487c;
    private int d;
    private int e;
    private WeakReference<BaseAdUnit> f;
    private String g;

    public w(Context context) {
        super(context);
        this.g = "";
        a(context);
    }

    public w(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = "";
        a(context);
    }

    public w(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = "";
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.a == null) {
            Paint paint = new Paint();
            this.a = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.a.setColor(-1);
            int asIntPixels = Dips.asIntPixels(1.0f, getContext());
            this.e = asIntPixels;
            this.a.setStrokeWidth(asIntPixels);
            this.a.setAlpha(127);
            Paint paint2 = new Paint();
            this.f487c = paint2;
            paint2.setColor(-1);
            this.f487c.setStyle(Paint.Style.FILL);
            this.f487c.setTextSize(TypedValue.applyDimension(2, 12.0f, getResources().getDisplayMetrics()));
            this.d = Dips.asIntPixels(10.0f, getContext());
        }
        int i = this.e;
        this.b = new RectF(i, i, getWidth() - this.e, getHeight() - this.e);
    }

    private void a(Context context) {
        com.sigmob.sdk.base.utils.f.a(this, new Runnable() { // from class: com.sigmob.sdk.base.views.w.1
            @Override // java.lang.Runnable
            public void run() {
                w.this.a();
            }
        });
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = this.a;
        if (paint != null) {
            paint.setStyle(Paint.Style.FILL);
            this.a.setColor(-16777216);
            this.a.setAlpha(102);
            RectF rectF = this.b;
            float f = rectF.right;
            canvas.drawRoundRect(rectF, f / 2.0f, f / 2.0f, this.a);
            this.a.setStyle(Paint.Style.STROKE);
            this.a.setColor(-1);
            this.a.setAlpha(76);
            RectF rectF2 = this.b;
            float f2 = rectF2.right;
            canvas.drawRoundRect(rectF2, f2 / 2.0f, f2 / 2.0f, this.a);
            canvas.drawText(this.g, (getWidth() - this.f487c.measureText(this.g)) / 2.0f, ((this.b.bottom / 2.0f) + ((this.f487c.getFontMetrics().bottom - this.f487c.getFontMetrics().top) / 2.0f)) - this.f487c.getFontMetrics().bottom, this.f487c);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a();
    }

    public void setText(String str) {
        this.g = str;
        invalidate();
    }
}
