package com.sigmob.sdk.mraid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.Preconditions;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a extends FrameLayout {
    static final float a = 30.0f;
    static final float b = 50.0f;

    /* renamed from: c, reason: collision with root package name */
    static final float f556c = 8.0f;
    private final int d;
    private b e;
    private final StateListDrawable f;
    private EnumC0047a g;
    private final int h;
    private final int i;
    private final int j;
    private boolean k;
    private final Rect l;
    private final Rect m;
    private final Rect n;
    private final Rect o;
    private boolean p;
    private c q;

    /* renamed from: com.sigmob.sdk.mraid.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum EnumC0047a {
        TOP_LEFT(51),
        TOP_CENTER(49),
        TOP_RIGHT(53),
        CENTER(17),
        BOTTOM_LEFT(83),
        BOTTOM_CENTER(81),
        BOTTOM_RIGHT(85);

        private final int h;

        EnumC0047a(int i2) {
            this.h = i2;
        }

        int a() {
            return this.h;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface b {
        void a();
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private final class c implements Runnable {
        private c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.setClosePressed(false);
        }
    }

    public a(Context context) {
        this(context, null, 0);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = new Rect();
        this.m = new Rect();
        this.n = new Rect();
        this.o = new Rect();
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f = stateListDrawable;
        this.g = EnumC0047a.TOP_RIGHT;
        stateListDrawable.setState(FrameLayout.EMPTY_STATE_SET);
        stateListDrawable.setCallback(this);
        this.d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.h = Dips.asIntPixels(b, context);
        this.i = Dips.asIntPixels(a, context);
        this.j = Dips.asIntPixels(8.0f, context);
        setWillNotDraw(false);
        this.p = true;
    }

    private void a(EnumC0047a enumC0047a, int i, Rect rect, Rect rect2) {
        Gravity.apply(enumC0047a.a(), i, i, rect, rect2);
    }

    private void b(EnumC0047a enumC0047a, Rect rect, Rect rect2) {
        a(enumC0047a, this.i, rect, rect2);
    }

    private void c() {
        playSoundEffect(0);
        b bVar = this.e;
        if (bVar != null) {
            bVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClosePressed(boolean z) {
        if (z == b()) {
            return;
        }
        this.f.setState(z ? FrameLayout.SELECTED_STATE_SET : FrameLayout.EMPTY_STATE_SET);
        invalidate(this.m);
    }

    public void a(EnumC0047a enumC0047a, Rect rect, Rect rect2) {
        a(enumC0047a, this.h, rect, rect2);
    }

    boolean a() {
        return this.p || this.f.isVisible();
    }

    boolean a(int i, int i2, int i3) {
        Rect rect = this.m;
        return i >= rect.left - i3 && i2 >= rect.top - i3 && i < rect.right + i3 && i2 < rect.bottom + i3;
    }

    boolean b() {
        return this.f.getState() == FrameLayout.SELECTED_STATE_SET;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.k) {
            this.k = false;
            this.l.set(0, 0, getWidth(), getHeight());
            a(this.g, this.l, this.m);
            this.o.set(this.m);
            Rect rect = this.o;
            int i = this.j;
            rect.inset(i, i);
            b(this.g, this.o, this.n);
            this.f.setBounds(this.n);
        }
        if (this.f.isVisible()) {
            this.f.draw(canvas);
        }
    }

    Rect getCloseBounds() {
        return this.m;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        return a((int) motionEvent.getX(), (int) motionEvent.getY(), 0);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.k = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!a((int) motionEvent.getX(), (int) motionEvent.getY(), this.d) || !a()) {
            setClosePressed(false);
            super.onTouchEvent(motionEvent);
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            setClosePressed(true);
        } else if (action != 1) {
            if (action == 3) {
                setClosePressed(false);
            }
        } else if (b()) {
            if (this.q == null) {
                this.q = new c();
            }
            postDelayed(this.q, ViewConfiguration.getPressedStateDuration());
            c();
        }
        return true;
    }

    public void setCloseAlwaysInteractable(boolean z) {
        this.p = z;
    }

    void setCloseBoundChanged(boolean z) {
        this.k = z;
    }

    void setCloseBounds(Rect rect) {
        this.m.set(rect);
    }

    public void setClosePosition(EnumC0047a enumC0047a) {
        Preconditions.checkNotNull(enumC0047a);
        this.g = enumC0047a;
        this.k = true;
        invalidate();
    }

    public void setCloseVisible(boolean z) {
        if (this.f.setVisible(z, false)) {
            invalidate(this.m);
        }
    }

    public void setOnCloseListener(b bVar) {
        this.e = bVar;
    }
}
