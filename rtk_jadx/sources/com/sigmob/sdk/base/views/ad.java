package com.sigmob.sdk.base.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.ResourceUtil;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ad extends RelativeLayout {
    public static final int a = 1;
    public static final int b = 2;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f447c;
    private TextView d;
    private TextView e;
    private AnimatorSet f;
    private ObjectAnimator g;
    private ObjectAnimator h;
    private View i;
    private boolean j;

    public ad(Context context) {
        super(context);
        a(context);
    }

    public ad(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ad(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        View.inflate(context, b(context), this);
        this.f447c = (ImageView) findViewById(ResourceUtil.getId(context, "sig_shakeImageView"));
        this.d = (TextView) findViewById(ResourceUtil.getId(context, "sig_shakeTitleView"));
        this.e = (TextView) findViewById(ResourceUtil.getId(context, "sig_shakeDescView"));
        this.i = findViewById(ResourceUtil.getId(context, "sig_shake_view"));
        c();
        b();
    }

    private int b(Context context) {
        return ResourceUtil.getLayoutId(context, "sig_shake_view_layout");
    }

    private void b() {
        int i = this.f447c.getLayoutParams().height;
        this.f447c.setPivotX(this.f447c.getLayoutParams().width);
        this.f447c.setPivotY(i * 0.8f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f447c, com.sigmob.sdk.base.common.a.F, com.sigmob.sdk.base.blurkit.c.d, 18.0f, com.sigmob.sdk.base.blurkit.c.d, -18.0f, com.sigmob.sdk.base.blurkit.c.d, 18.0f, com.sigmob.sdk.base.blurkit.c.d, -18.0f, com.sigmob.sdk.base.blurkit.c.d, 18.0f, com.sigmob.sdk.base.blurkit.c.d);
        this.g = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.g.addListener(new Animator.AnimatorListener() { // from class: com.sigmob.sdk.base.views.ad.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.sigmob.sdk.base.views.ad.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ad.this.j) {
                            return;
                        }
                        ad.this.g.start();
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
        this.g.setDuration(1500L);
    }

    private void c() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.i, "translationY", com.sigmob.sdk.base.blurkit.c.d, 30.0f, com.sigmob.sdk.base.blurkit.c.d, -30.0f, com.sigmob.sdk.base.blurkit.c.d);
        this.h = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.h.setRepeatCount(2);
        this.h.setDuration(400L);
    }

    void a() {
        this.h.start();
    }

    public void a(int i) {
        ObjectAnimator objectAnimator;
        if (i != 1) {
            this.j = true;
            this.g.cancel();
            objectAnimator = this.h;
        } else {
            objectAnimator = this.g;
        }
        objectAnimator.start();
    }
}
