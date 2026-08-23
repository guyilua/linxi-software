package com.sigmob.sdk.nativead;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ac {
    private ViewGroup a;
    private ab b;

    /* renamed from: c, reason: collision with root package name */
    private ab f605c;
    private long d;

    public ac(ViewGroup viewGroup, ab abVar, ab abVar2, long j) {
        this.a = viewGroup;
        this.b = abVar;
        this.f605c = abVar2;
        this.d = j;
    }

    public void a() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "x", this.b.a(), this.f605c.a());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.a, "y", this.b.b(), this.f605c.b());
        ValueAnimator ofInt = ValueAnimator.ofInt(this.b.c(), this.f605c.c());
        ValueAnimator ofInt2 = ValueAnimator.ofInt(this.b.d(), this.f605c.d());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.nativead.ac.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = ac.this.a.getLayoutParams();
                layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ac.this.a.setLayoutParams(layoutParams);
            }
        });
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.nativead.ac.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = ac.this.a.getLayoutParams();
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ac.this.a.setLayoutParams(layoutParams);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofInt, ofInt2);
        animatorSet.setDuration(this.d);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.start();
    }
}
