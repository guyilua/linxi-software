package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f extends View {
    private Path a;
    private Path b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f466c;

    public f(Context context) {
        super(context);
        this.a = new Path();
        this.b = new Path();
        Paint paint = new Paint();
        this.f466c = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f466c.setColor(-1);
        this.f466c.setAntiAlias(true);
        this.f466c.setAlpha(153);
        a();
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sigmob.sdk.base.views.f.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                f.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                f.this.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        int width = getWidth();
        int width2 = getWidth();
        if (width <= 0 || width2 <= 0) {
            return;
        }
        int min = Math.min(width, width2);
        this.f466c.reset();
        this.a.reset();
        this.b.reset();
        this.f466c.setStrokeWidth(Dips.dipsToIntPixels(1.0f, getContext()));
        float f = width / 2.0f;
        float f2 = width2 / 2.0f;
        int i = min / 2;
        this.a.addCircle(f, f2, i - Dips.dipsToIntPixels(1.0f, getContext()), Path.Direction.CCW);
        this.b.addCircle(f, f2, i - Dips.dipsToIntPixels(10.0f, getContext()), Path.Direction.CCW);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f466c.setColor(-16777216);
        this.f466c.setAlpha(102);
        this.f466c.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.a, this.f466c);
        this.f466c.setColor(-1);
        this.f466c.setAlpha(76);
        this.f466c.setStyle(Paint.Style.STROKE);
        canvas.drawPath(this.a, this.f466c);
        this.f466c.setAlpha(127);
        canvas.drawPath(this.b, this.f466c);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        b();
    }
}
