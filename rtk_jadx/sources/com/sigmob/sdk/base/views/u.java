package com.sigmob.sdk.base.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.czhj.sdk.logger.SigmobLog;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class u extends ImageView {
    private static final int a = 1000;
    private int b;

    /* renamed from: c, reason: collision with root package name */
    private Movie f486c;
    private long d;
    private int e;
    private float f;
    private float g;
    private float h;
    private float i;
    private int j;
    private int k;
    private boolean l;
    private volatile boolean m;

    public u(Context context) {
        this(context, null);
    }

    public u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public u(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 0;
        this.l = true;
        this.m = false;
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
    }

    private void a(Canvas canvas) {
        this.f486c.setTime(this.e);
        canvas.save();
        canvas.scale(this.h, this.i);
        this.f486c.draw(canvas, this.f / this.h, this.g / this.i);
        canvas.restore();
    }

    @SuppressLint({"NewApi"})
    private void b() {
        if (this.l) {
            if (Build.VERSION.SDK_INT >= 16) {
                postInvalidateOnAnimation();
            } else {
                invalidate();
            }
        }
    }

    private void c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.d == 0) {
            this.d = uptimeMillis;
        }
        int duration = this.f486c.duration();
        if (duration == 0) {
            duration = 1000;
        }
        this.e = (int) ((uptimeMillis - this.d) % duration);
    }

    private byte[] getGiftBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream openRawResource = getResources().openRawResource(this.b);
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        while (true) {
            try {
                try {
                    int read = openRawResource.read(bArr, 0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (Throwable th) {
                    try {
                        SigmobLog.e(th.getMessage());
                        if (openRawResource != null) {
                            openRawResource.close();
                        }
                    } catch (Throwable th2) {
                        if (openRawResource != null) {
                            try {
                                openRawResource.close();
                            } catch (Throwable th3) {
                                SigmobLog.e(th3.getMessage());
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                SigmobLog.e(th4.getMessage());
            }
        }
        byteArrayOutputStream.flush();
        if (openRawResource != null) {
            openRawResource.close();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public boolean a() {
        return this.m;
    }

    public Movie getMovie() {
        return this.f486c;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f486c == null) {
            super.onDraw(canvas);
            return;
        }
        c();
        a(canvas);
        b();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f = (getWidth() - this.j) / 2.0f;
        this.g = (getHeight() - this.k) / 2.0f;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        Movie movie = this.f486c;
        if (movie == null) {
            super.onMeasure(i, i2);
            return;
        }
        int width = movie.width();
        int height = this.f486c.height();
        int size = View.MeasureSpec.getSize(i);
        this.h = 1.0f / (width / size);
        this.i = 1.0f / (height / View.MeasureSpec.getSize(i2));
        this.j = size;
        int size2 = View.MeasureSpec.getSize(i2);
        this.k = size2;
        setMeasuredDimension(this.j, size2);
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        this.l = i == 1;
        b();
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        this.l = i == 0;
        b();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.l = i == 0;
        b();
    }

    public void setMovie(Movie movie) {
        this.f486c = movie;
        requestLayout();
    }

    public void setMovieResource(int i) {
        this.b = i;
        byte[] giftBytes = getGiftBytes();
        this.f486c = Movie.decodeByteArray(giftBytes, 0, giftBytes.length);
        requestLayout();
    }

    public void setMovieTime(int i) {
        this.e = i;
        invalidate();
    }

    public void setPaused(boolean z) {
        this.m = z;
        if (!z) {
            this.d = SystemClock.uptimeMillis() - this.e;
        }
        invalidate();
    }
}
