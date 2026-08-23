package com.sigmob.sdk.base.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class i extends FrameLayout {
    private static float a = 0.0f;
    private static final int b = 1700;

    /* renamed from: c, reason: collision with root package name */
    private j f473c;
    private j d;
    private j e;

    public i(Context context) {
        super(context);
        a();
    }

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public i(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        a = Dips.dipsToIntPixels(6.0f, getContext());
        j jVar = new j(getContext());
        this.f473c = jVar;
        addView(jVar, new ViewGroup.LayoutParams(-1, -1));
        j jVar2 = new j(getContext());
        this.d = jVar2;
        addView(jVar2, new ViewGroup.LayoutParams(-1, -1));
        j jVar3 = new j(getContext());
        this.e = jVar3;
        jVar3.a(true);
        addView(this.e, new ViewGroup.LayoutParams(-1, -1));
        a(this.f473c, 0);
        a(this.d, 566);
    }

    public void a(final j jVar, int i) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(jVar, "translationY", com.sigmob.sdk.base.blurkit.c.d, Dips.dipsToIntPixels(-30.0f, getContext()));
        ofFloat.setDuration(1700L);
        long j = i;
        ofFloat.setStartDelay(j);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(jVar, "alpha", 1.0f, 0.1f);
        ofFloat2.setDuration(1700L);
        ofFloat2.setStartDelay(j);
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(a, Dips.dipsToIntPixels(1.0f, getContext()));
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.base.views.i.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                jVar.setLineWidth(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat3.setDuration(1360L);
        ofFloat3.setStartDelay(j + 340);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.sigmob.sdk.base.views.i.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animator.start();
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
}
