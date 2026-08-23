package com.sigmob.sdk.base.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class m extends RelativeLayout {
    int a;
    private final ImageView b;

    /* renamed from: c, reason: collision with root package name */
    private final TextView f476c;
    private final TextView d;
    private final int e;
    private TextView f;
    private TextView g;
    private t h;
    private m i;
    private int j;
    private boolean k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private LinearLayout q;
    private BaseAdUnit r;

    public m(Context context, BaseAdUnit baseAdUnit, String str, String str2, float f, String str3, int i, int i2, String str4, int i3, int i4, int i5, int i6, int i7, float f2) {
        super(context);
        this.i = null;
        this.j = 0;
        this.a = Dips.asIntPixels(f2, context);
        this.m = Dips.asIntPixels(10.0f, context);
        this.r = baseAdUnit;
        this.j = i;
        this.e = i2;
        TextView textView = new TextView(context);
        this.d = textView;
        textView.setText(str);
        textView.setTextSize(1, 16.0f);
        textView.setTextColor(-16777216);
        textView.setSingleLine();
        textView.setTypeface(Typeface.defaultFromStyle(0));
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(16);
        textView.setId(ClientMetadata.generateViewId());
        textView.setPadding(this.m / 6, 0, 0, 0);
        this.l = i5;
        TextView textView2 = new TextView(context);
        this.f476c = textView2;
        textView2.setId(ClientMetadata.generateViewId());
        textView2.setTextSize(1, 14.0f);
        textView2.setTextColor(i4);
        textView2.setGravity(17);
        textView.setSingleLine();
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setText(str2);
        int asIntPixels = Dips.asIntPixels(5.0f, context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i3);
        gradientDrawable.setCornerRadius(asIntPixels * 6);
        CircleImageView circleImageView = new CircleImageView(context);
        this.b = circleImageView;
        circleImageView.setScaleType(ImageView.ScaleType.FIT_START);
        circleImageView.setId(ClientMetadata.generateViewId());
        circleImageView.b = false;
        float f3 = asIntPixels * 2;
        circleImageView.a = f3;
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 16) {
            textView2.setBackground(gradientDrawable);
        } else {
            textView2.setBackgroundDrawable(gradientDrawable);
        }
        textView2.setId(ClientMetadata.generateViewId());
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(f3);
        gradientDrawable2.setColor(i6);
        gradientDrawable2.setAlpha(i7);
        if (i8 >= 16) {
            setBackground(gradientDrawable2);
        } else {
            setBackgroundDrawable(gradientDrawable2);
        }
        this.i = this;
        if (i2 == 1) {
            a(context, f);
        } else {
            a(context, str3);
        }
        if (baseAdUnit.getMaterial() != null && baseAdUnit.getMaterial().ad_privacy != null) {
            a(context);
        }
        setupUILayout(context);
        circleImageView.setVisibility(4);
        a(str4);
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int i = this.j;
        if (i == 1) {
            e();
        } else if (i == 2 || i != 3) {
            h();
        } else {
            f();
        }
    }

    private void d() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("scaleX", 0.3f, 0.5f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.3f, 0.5f, 1.0f));
        ofPropertyValuesHolder.setInterpolator(new Interpolator() { // from class: com.sigmob.sdk.base.views.m.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                SigmobLog.e("input: " + f);
                return (float) ((Math.pow(2.0d, (-10.0f) * f) * Math.sin(((f - 0.13333334f) * 6.283185307179586d) / 0.4000000059604645d)) + 1.0d);
            }
        });
        f();
        ofPropertyValuesHolder.setDuration(2000L);
        ofPropertyValuesHolder.start();
    }

    @SuppressLint({"ObjectAnimatorBinding"})
    private void e() {
        Keyframe ofFloat = Keyframe.ofFloat(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
        Keyframe ofFloat2 = Keyframe.ofFloat(0.5f, 0.95f);
        Keyframe ofFloat3 = Keyframe.ofFloat(0.6f, 0.9f);
        Keyframe ofFloat4 = Keyframe.ofFloat(0.7f, 1.0f);
        Keyframe ofFloat5 = Keyframe.ofFloat(0.8f, 0.95f);
        Keyframe ofFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe("scaleX", ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6), PropertyValuesHolder.ofKeyframe("scaleY", ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6));
        ofPropertyValuesHolder.setDuration(1000L);
        f();
        this.p = true;
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.sigmob.sdk.base.views.m.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                m.this.o = false;
                m.this.p = false;
                m.this.i.clearAnimation();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                m.this.o = false;
                m.this.p = false;
                m.this.i.clearAnimation();
            }
        });
        ofPropertyValuesHolder.start();
    }

    private void f() {
        this.n = true;
        super.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        super.setVisibility(4);
    }

    private void h() {
        SigmobLog.d("startDownToUpAnimator");
        TranslateAnimation translateAnimation = new TranslateAnimation(2, com.sigmob.sdk.base.blurkit.c.d, 2, com.sigmob.sdk.base.blurkit.c.d, 2, 1.0f, 2, com.sigmob.sdk.base.blurkit.c.d);
        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setDuration(500L);
        f();
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.sigmob.sdk.base.views.m.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                m.this.o = false;
                m.this.i.clearAnimation();
                SigmobLog.d("startDownToUpAnimator end");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.i.startAnimation(translateAnimation);
    }

    private void i() {
        SigmobLog.d("startUpToDownAnimator");
        TranslateAnimation translateAnimation = new TranslateAnimation(2, com.sigmob.sdk.base.blurkit.c.d, 2, com.sigmob.sdk.base.blurkit.c.d, 2, com.sigmob.sdk.base.blurkit.c.d, 2, 1.0f);
        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setDuration(500L);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.sigmob.sdk.base.views.m.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                m.this.o = true;
                m.this.i.clearAnimation();
                m.this.g();
                SigmobLog.d("startUpToDownAnimator end");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.i.startAnimation(translateAnimation);
    }

    private void setupUILayout(Context context) {
        int asIntPixels = Dips.asIntPixels(60.0f, context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(asIntPixels, asIntPixels);
        layoutParams.addRule(15);
        int i = this.m;
        layoutParams.setMargins(i, i / 4, 0, 0);
        this.b.setId(ClientMetadata.generateViewId());
        addView(this.b, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, (int) (asIntPixels / 1.8f));
        layoutParams2.setMargins(0, 0, this.m, 0);
        layoutParams2.addRule(15);
        layoutParams2.addRule(11);
        TextView textView = this.f476c;
        int i2 = this.m;
        textView.setPadding(i2, 0, i2, 0);
        addView(this.f476c, layoutParams2);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(this.m / 2, 0, 0, 0);
        layoutParams3.addRule(15);
        layoutParams3.addRule(1, this.b.getId());
        layoutParams3.addRule(0, this.f476c.getId());
        addView(linearLayout, layoutParams3);
        linearLayout.addView(this.d, new RelativeLayout.LayoutParams(-2, -2));
        if (this.f != null) {
            RelativeLayout relativeLayout = new RelativeLayout(context);
            relativeLayout.addView(this.f, new RelativeLayout.LayoutParams(-2, -2));
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(1, this.f.getId());
            layoutParams4.addRule(6, this.f.getId());
            layoutParams4.addRule(8, this.f.getId());
            relativeLayout.addView(this.h, layoutParams4);
            linearLayout.addView(relativeLayout, new RelativeLayout.LayoutParams(-2, -2));
        } else if (this.g != null) {
            linearLayout.addView(this.g, new RelativeLayout.LayoutParams(-2, -2));
        }
        if (this.q != null) {
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams5.addRule(8, this.b.getId());
            linearLayout.addView(this.q, layoutParams5);
        }
    }

    public void a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.q = linearLayout;
        linearLayout.setOrientation(0);
        this.q.setId(ClientMetadata.generateViewId());
        int asIntPixels = Dips.asIntPixels(2.0f, context);
        String[] strArr = {"名称", "版本", "开发者", "权限", "隐私协议", "介绍"};
        for (int i = 0; i < 6; i++) {
            TextView textView = new TextView(context);
            textView.setTextSize(1, 8.0f);
            textView.setText(strArr[i]);
            textView.setTextColor(-7829368);
            textView.setAlpha(0.7f);
            textView.getPaint().setAntiAlias(true);
            textView.getPaint().setFlags(8);
            int i2 = asIntPixels / 2;
            textView.setPadding(i2, 0, i2, 0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, asIntPixels, 0);
            this.q.addView(textView, layoutParams);
        }
    }

    public void a(Context context, float f) {
        TextView textView = new TextView(context);
        this.f = textView;
        textView.setTextSize(1, 14.0f);
        this.f.setId(ClientMetadata.generateViewId());
        this.f.setGravity(17);
        this.f.setTextColor(-7829368);
        if (f > com.sigmob.sdk.base.blurkit.c.d) {
            this.f.setText(String.format("%.1f", Float.valueOf(f)));
        }
        this.h = new t(context, f);
    }

    public void a(Context context, String str) {
        TextView textView = new TextView(context);
        this.g = textView;
        textView.setId(ClientMetadata.generateViewId());
        this.g.setTextColor(-7829368);
        this.g.setSingleLine();
        this.g.setGravity(17);
        this.g.setTextSize(1, 14.0f);
        this.g.setEllipsize(TextUtils.TruncateAt.END);
        this.g.setText(str);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.sigmob.sdk.base.common.h.a().getBitmap(str, new ImageManager.BitmapLoadedListener() { // from class: com.sigmob.sdk.base.views.m.5
            public void onBitmapLoadFailed() {
            }

            public void onBitmapLoaded(Bitmap bitmap) {
                m.this.b.setImageBitmap(bitmap);
                m.this.b.setVisibility(0);
                if (m.this.k) {
                    m.this.c();
                }
            }
        });
    }

    public boolean a() {
        return this.n;
    }

    public boolean b() {
        return this.o;
    }

    public LinearLayout getFourElementsLayout() {
        return this.q;
    }

    @Override // android.view.View
    public int getVisibility() {
        return super.getVisibility();
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.l == 1) {
            this.f476c.setOnTouchListener(onTouchListener);
        } else {
            super.setOnTouchListener(onTouchListener);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 8) {
            super.setVisibility(i);
            this.k = false;
            return;
        }
        if (i == 0) {
            this.k = true;
            if (this.i.getAnimation() == null && !this.p && this.b.getVisibility() == 0) {
                c();
                return;
            }
            return;
        }
        if (i != 4) {
            super.setVisibility(i);
        } else {
            if (this.i.getAnimation() != null) {
                return;
            }
            i();
        }
    }
}
