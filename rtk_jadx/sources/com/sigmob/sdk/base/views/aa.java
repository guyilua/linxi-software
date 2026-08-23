package com.sigmob.sdk.base.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.czhj.sdk.common.utils.Dips;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.TbsMediaPlayer;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class aa extends View {
    private Paint a;
    private Paint b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f442c;
    private Paint d;
    private String description;
    private Paint e;
    private RectF f;
    private RectF g;
    private RectF h;
    private Path i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private Handler p;
    private int q;
    private int r;
    private String title;

    public aa(Context context) {
        super(context);
        this.p = new Handler(Looper.getMainLooper());
        this.q = Color.parseColor("#FF5A57");
        c();
    }

    public aa(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.p = new Handler(Looper.getMainLooper());
        this.q = Color.parseColor("#FF5A57");
        c();
    }

    public aa(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.p = new Handler(Looper.getMainLooper());
        this.q = Color.parseColor("#FF5A57");
        c();
    }

    private Animator a(final RectF rectF, final Paint paint, int i, int i2) {
        AnimatorSet animatorSet = new AnimatorSet();
        final RectF rectF2 = new RectF(rectF.left, rectF.top, rectF.right, rectF.bottom);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(com.sigmob.sdk.base.blurkit.c.d, Dips.dipsToIntPixels(20.0f, getContext()));
        long j = i2;
        ofFloat.setStartDelay(j);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.base.views.aa.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                aa.this.a(rectF2, rectF, ((Float) valueAnimator.getAnimatedValue()).floatValue());
                aa.this.invalidate();
            }
        });
        ValueAnimator ofInt = ValueAnimator.ofInt(255, 0);
        ofInt.setStartDelay(j);
        ofInt.setDuration(i * 0.8f);
        ofInt.setInterpolator(new AccelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.base.views.aa.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                paint.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                aa.this.invalidate();
            }
        });
        animatorSet.playTogether(ofFloat, ofInt);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RectF rectF, RectF rectF2, float f) {
        rectF2.left = rectF.left - f;
        rectF2.top = rectF.top - f;
        rectF2.right = rectF.right + f;
        rectF2.bottom = rectF.bottom + f;
    }

    private void c() {
        this.r = Dips.dipsToIntPixels(2.0f, getContext());
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setStyle(Paint.Style.FILL);
        this.a.setStrokeWidth(this.r);
        this.a.setColor(-1);
        this.n = Dips.dipsToIntPixels(20.0f, getContext());
        this.b = new Paint(this.a);
        Paint paint2 = new Paint(this.a);
        this.f442c = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f442c.setColor(this.q);
        Paint paint3 = new Paint(1);
        this.d = paint3;
        paint3.setColor(-1);
        this.d.setTypeface(Typeface.DEFAULT);
        this.d.setTextSize(TypedValue.applyDimension(2, 20.0f, getResources().getDisplayMetrics()));
        Paint paint4 = new Paint(1);
        this.e = paint4;
        paint4.setColor(-1);
        this.e.setAlpha(127);
        this.e.setStyle(Paint.Style.FILL);
        this.i = new Path();
        this.f = new RectF();
        this.g = new RectF();
        this.h = new RectF();
    }

    private void d() {
        this.i.reset();
        this.i.moveTo(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
        this.i.lineTo(com.sigmob.sdk.base.blurkit.c.d, this.o);
        Path path = this.i;
        float f = this.o;
        path.lineTo(f / 2.0f, f / 2.0f);
        this.i.close();
    }

    public void a() {
        Animator a = a(this.f, this.a, 1000, 0);
        Animator a2 = a(this.g, this.b, TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_BAD_INTERLEAVING, TbsListener.ErrorCode.INFO_CODE_BASE);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(a, a2);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.sigmob.sdk.base.views.aa.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(final Animator animator) {
                aa.this.p.postDelayed(new Runnable() { // from class: com.sigmob.sdk.base.views.aa.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        animator.start();
                    }
                }, 300L);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        animatorSet.start();
    }

    public void a(String str, String str2) {
        this.title = str;
        this.description = str2;
        invalidate();
    }

    public void b() {
        this.f.set(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d, getWidth(), getHeight());
        this.g.set(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d, getWidth(), getHeight());
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Handler handler = this.p;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.f;
        canvas.drawRoundRect(rectF, rectF.height() / 2.0f, this.f.height() / 2.0f, this.a);
        RectF rectF2 = this.g;
        canvas.drawRoundRect(rectF2, rectF2.height() / 2.0f, this.g.height() / 2.0f, this.b);
        RectF rectF3 = this.h;
        canvas.drawRoundRect(rectF3, rectF3.height() / 2.0f, this.h.height() / 2.0f, this.f442c);
        float width = (getWidth() / 2) + (this.l / 2.0f) + (this.r * 2);
        if (!TextUtils.isEmpty(this.title)) {
            float width2 = (getWidth() / 2) - (this.l / 2.0f);
            canvas.drawText(this.title, width2, ((getHeight() / 2) - (this.m / 2.0f)) - this.d.ascent(), this.d);
            width = width2 + this.d.measureText(this.title) + (this.r * 2);
        }
        float height = (getHeight() / 2) - (this.o / 2.0f);
        canvas.save();
        canvas.translate(width, height);
        canvas.drawPath(this.i, this.e);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i;
        float f2 = f / 4.0f;
        this.j = f2;
        float f3 = i2;
        float f4 = f3 / 3.0f;
        this.k = f4;
        this.f.set(f2 / 2.0f, f4 / 2.0f, f - (f2 / 2.0f), f3 - (f4 / 2.0f));
        RectF rectF = this.g;
        float f5 = this.j;
        float f6 = this.k;
        rectF.set(f5 / 2.0f, f6 / 2.0f, f - (f5 / 2.0f), f3 - (f6 / 2.0f));
        RectF rectF2 = this.h;
        float f7 = this.j;
        float f8 = this.k;
        rectF2.set(f7 / 2.0f, f8 / 2.0f, f - (f7 / 2.0f), f3 - (f8 / 2.0f));
        if (!TextUtils.isEmpty(this.title)) {
            int i5 = 5;
            while (true) {
                if (i5 >= this.title.length()) {
                    break;
                }
                float measureText = this.d.measureText(this.title, 0, i5);
                RectF rectF3 = this.f;
                if (measureText > (rectF3.right - rectF3.left) - (this.n * 4.0f)) {
                    this.title = this.title.substring(0, i5 - 2) + "...";
                    break;
                }
                i5++;
            }
            this.l = this.d.measureText(this.title);
            this.m = this.d.descent() - this.d.ascent();
        }
        this.o = this.m * 0.6f;
        d();
        a();
    }

    public void setButtonColor(int i) {
        this.q = i;
    }
}
