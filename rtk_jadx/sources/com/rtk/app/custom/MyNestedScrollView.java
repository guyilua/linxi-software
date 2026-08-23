package com.rtk.app.custom;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.annotation.RestrictTo;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.core.widget.EdgeEffectCompat;
import com.sigmob.sdk.downloader.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import java.util.ArrayList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyNestedScrollView extends FrameLayout implements NestedScrollingParent, NestedScrollingChild2, ScrollingView {
    private static final a A = new a();
    private static final int[] B = {R.attr.fillViewport};
    private long a;
    private final Rect b;

    /* renamed from: c, reason: collision with root package name */
    private OverScroller f163c;
    private EdgeEffect d;
    private EdgeEffect e;
    private int f;
    private boolean g;
    private boolean h;
    private View i;
    private boolean j;
    private VelocityTracker k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private int q;
    private final int[] r;
    private final int[] s;
    private int t;
    private int u;
    private c v;
    private final NestedScrollingParentHelper w;
    private final NestedScrollingChildHelper x;
    private float y;
    private b z;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class a extends AccessibilityDelegateCompat {
        a() {
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            MyNestedScrollView myNestedScrollView = (MyNestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(myNestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(myNestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(myNestedScrollView.getScrollY());
            AccessibilityRecordCompat.setMaxScrollX(accessibilityEvent, myNestedScrollView.getScrollX());
            AccessibilityRecordCompat.setMaxScrollY(accessibilityEvent, myNestedScrollView.getScrollRange());
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int scrollRange;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            MyNestedScrollView myNestedScrollView = (MyNestedScrollView) view;
            accessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
            if (!myNestedScrollView.isEnabled() || (scrollRange = myNestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            accessibilityNodeInfoCompat.setScrollable(true);
            if (myNestedScrollView.getScrollY() > 0) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
            if (myNestedScrollView.getScrollY() < scrollRange) {
                accessibilityNodeInfoCompat.addAction(f.a.f548c);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            MyNestedScrollView myNestedScrollView = (MyNestedScrollView) view;
            if (!myNestedScrollView.isEnabled()) {
                return false;
            }
            if (i == 4096) {
                int min = Math.min(myNestedScrollView.getScrollY() + ((myNestedScrollView.getHeight() - myNestedScrollView.getPaddingBottom()) - myNestedScrollView.getPaddingTop()), myNestedScrollView.getScrollRange());
                if (min == myNestedScrollView.getScrollY()) {
                    return false;
                }
                myNestedScrollView.B(0, min);
                return true;
            }
            if (i != 8192) {
                return false;
            }
            int max = Math.max(myNestedScrollView.getScrollY() - ((myNestedScrollView.getHeight() - myNestedScrollView.getPaddingBottom()) - myNestedScrollView.getPaddingTop()), 0);
            if (max == myNestedScrollView.getScrollY()) {
                return false;
            }
            myNestedScrollView.B(0, max);
            return true;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface b {
        void a(MyNestedScrollView myNestedScrollView, int i, int i2, int i3, int i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class c extends View.BaseSavedState {
        public static final Parcelable.Creator<c> CREATOR = new a();
        public int a;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        static class a implements Parcelable.Creator<c> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i) {
                return new c[i];
            }
        }

        c(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }

        c(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
        }
    }

    public MyNestedScrollView(Context context) {
        this(context, null);
    }

    private boolean b() {
        View childAt = getChildAt(0);
        if (childAt != null) {
            return getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom();
        }
        return false;
    }

    private static int c(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        return i2 + i > i3 ? i3 - i2 : i;
    }

    private void e(int i) {
        if (i != 0) {
            if (this.m) {
                A(0, i);
            } else {
                scrollBy(0, i);
            }
        }
    }

    private void f() {
        this.j = false;
        w();
        stopNestedScroll(0);
        EdgeEffect edgeEffect = this.d;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.e.onRelease();
        }
    }

    private void g() {
        if (getOverScrollMode() != 2) {
            if (this.d == null) {
                Context context = getContext();
                this.d = new EdgeEffect(context);
                this.e = new EdgeEffect(context);
                return;
            }
            return;
        }
        this.d = null;
        this.e = null;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.y == com.sigmob.sdk.base.blurkit.c.d) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                this.y = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.y;
    }

    private View i(boolean z, int i, int i2) {
        ArrayList focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = (View) focusables.get(i3);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i < bottom && top < i2) {
                boolean z3 = i < top && bottom < i2;
                if (view == null) {
                    view = view2;
                    z2 = z3;
                } else {
                    boolean z4 = (z && top < view.getTop()) || (!z && bottom > view.getBottom());
                    if (z2) {
                        if (z3) {
                            if (!z4) {
                            }
                            view = view2;
                        }
                    } else if (z3) {
                        view = view2;
                        z2 = true;
                    } else {
                        if (!z4) {
                        }
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    private void k(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        float f = i;
        if (dispatchNestedPreFling(com.sigmob.sdk.base.blurkit.c.d, f)) {
            return;
        }
        dispatchNestedFling(com.sigmob.sdk.base.blurkit.c.d, f, z);
        j(i);
    }

    private boolean m(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i >= childAt.getLeft() && i < childAt.getRight();
    }

    private void n() {
        VelocityTracker velocityTracker = this.k;
        if (velocityTracker == null) {
            this.k = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void o() {
        this.f163c = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(WXMediaMessage.NATIVE_GAME__THUMB_LIMIT);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.n = viewConfiguration.getScaledTouchSlop();
        this.o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void p() {
        if (this.k == null) {
            this.k = VelocityTracker.obtain();
        }
    }

    private boolean q(View view) {
        return !s(view, 0, getHeight());
    }

    private static boolean r(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && r((View) parent, view2);
    }

    private boolean s(View view, int i, int i2) {
        view.getDrawingRect(this.b);
        offsetDescendantRectToMyCoords(view, this.b);
        return this.b.bottom + i >= getScrollY() && this.b.top - i <= getScrollY() + i2;
    }

    private void t(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.q) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f = (int) motionEvent.getY(i);
            this.q = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.k;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void w() {
        VelocityTracker velocityTracker = this.k;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.k = null;
        }
    }

    private boolean x(int i, int i2, int i3) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = height + scrollY;
        boolean z = false;
        boolean z2 = i == 33;
        View i5 = i(z2, i2, i3);
        if (i5 == null) {
            i5 = this;
        }
        if (i2 < scrollY || i3 > i4) {
            e(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (i5 != findFocus()) {
            i5.requestFocus(i);
        }
        return z;
    }

    private void y(View view) {
        view.getDrawingRect(this.b);
        offsetDescendantRectToMyCoords(view, this.b);
        int d = d(this.b);
        if (d != 0) {
            scrollBy(0, d);
        }
    }

    private boolean z(Rect rect, boolean z) {
        int d = d(rect);
        boolean z2 = d != 0;
        if (z2) {
            if (z) {
                scrollBy(0, d);
            } else {
                A(0, d);
            }
        }
        return z2;
    }

    public final void A(int i, int i2) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.a > 250) {
            int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
            int scrollY = getScrollY();
            this.f163c.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i2 + scrollY, max)) - scrollY);
            ViewCompat.postInvalidateOnAnimation(this);
        } else {
            if (!this.f163c.isFinished()) {
                this.f163c.abortAnimation();
            }
            scrollBy(i, i2);
        }
        this.a = AnimationUtils.currentAnimationTimeMillis();
    }

    public final void B(int i, int i2) {
        A(i - getScrollX(), i2 - getScrollY());
    }

    public boolean a(int i) {
        int bottom;
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus != null && s(findNextFocus, maxScrollAmount, getHeight())) {
            findNextFocus.getDrawingRect(this.b);
            offsetDescendantRectToMyCoords(findNextFocus, this.b);
            e(d(this.b));
            findNextFocus.requestFocus(i);
        } else {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0 && (bottom = getChildAt(0).getBottom() - ((getScrollY() + getHeight()) - getPaddingBottom())) < maxScrollAmount) {
                maxScrollAmount = bottom;
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            e(maxScrollAmount);
        }
        if (findFocus == null || !findFocus.isFocused() || !q(findFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.View
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f163c.computeScrollOffset()) {
            this.f163c.getCurrX();
            int currY = this.f163c.getCurrY();
            int i = currY - this.u;
            if (dispatchNestedPreScroll(0, i, this.s, null, 1)) {
                i -= this.s[1];
            }
            int i2 = i;
            if (i2 != 0) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                u(0, i2, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
                int scrollY2 = getScrollY() - scrollY;
                if (!dispatchNestedScroll(0, scrollY2, 0, i2 - scrollY2, null, 1)) {
                    int overScrollMode = getOverScrollMode();
                    if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                        g();
                        if (currY <= 0 && scrollY > 0) {
                            this.d.onAbsorb((int) this.f163c.getCurrVelocity());
                        } else if (currY >= scrollRange && scrollY < scrollRange) {
                            this.e.onAbsorb((int) this.f163c.getCurrVelocity());
                        }
                    }
                }
            }
            this.u = currY;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
        if (hasNestedScrollingParent(1)) {
            stopNestedScroll(1);
        }
        this.u = 0;
    }

    @Override // android.view.View
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    protected int d(Rect rect) {
        int i;
        int i2;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i3 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i3 -= verticalFadingEdgeLength;
        }
        int i4 = rect.bottom;
        if (i4 > i3 && rect.top > scrollY) {
            if (rect.height() > height) {
                i2 = rect.top - scrollY;
            } else {
                i2 = rect.bottom - i3;
            }
            return Math.min(i2 + 0, getChildAt(0).getBottom() - i3);
        }
        if (rect.top >= scrollY || i4 >= i3) {
            return 0;
        }
        if (rect.height() > height) {
            i = 0 - (i3 - rect.bottom);
        } else {
            i = 0 - (scrollY - rect.top);
        }
        return Math.max(i, -getScrollY());
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || h(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.x.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.x.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.x.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.x.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.d != null) {
            int scrollY = getScrollY();
            if (!this.d.isFinished()) {
                int save = canvas.save();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate(getPaddingLeft(), Math.min(0, scrollY));
                this.d.setSize(width, getHeight());
                if (this.d.draw(canvas)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                canvas.restoreToCount(save);
            }
            if (this.e.isFinished()) {
                return;
            }
            int save2 = canvas.save();
            int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = getHeight();
            canvas.translate((-width2) + getPaddingLeft(), Math.max(getScrollRange(), scrollY) + height);
            canvas.rotate(180.0f, width2, com.sigmob.sdk.base.blurkit.c.d);
            this.e.setSize(width2, height);
            if (this.e.draw(canvas)) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
            canvas.restoreToCount(save2);
        }
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return com.sigmob.sdk.base.blurkit.c.d;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.w.getNestedScrollAxes();
    }

    int getScrollRange() {
        if (getChildCount() > 0) {
            return Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
        }
        return 0;
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return com.sigmob.sdk.base.blurkit.c.d;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public boolean h(KeyEvent keyEvent) {
        this.b.setEmpty();
        if (!b()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            return (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) ? false : true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19) {
            if (!keyEvent.isAltPressed()) {
                return a(33);
            }
            return l(33);
        }
        if (keyCode == 20) {
            if (!keyEvent.isAltPressed()) {
                return a(130);
            }
            return l(130);
        }
        if (keyCode != 62) {
            return false;
        }
        v(keyEvent.isShiftPressed() ? 33 : 130);
        return false;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.x.hasNestedScrollingParent();
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.x.isNestedScrollingEnabled();
    }

    public void j(int i) {
        if (getChildCount() > 0) {
            startNestedScroll(2, 1);
            this.f163c.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            this.u = getScrollY();
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public boolean l(int i) {
        int childCount;
        boolean z = i == 130;
        int height = getHeight();
        Rect rect = this.b;
        rect.top = 0;
        rect.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            this.b.bottom = getChildAt(childCount - 1).getBottom() + getPaddingBottom();
            Rect rect2 = this.b;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.b;
        return x(i, rect3.top, rect3.bottom);
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i, int i2) {
        view.measure(FrameLayout.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(FrameLayout.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.h = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.j) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != com.sigmob.sdk.base.blurkit.c.d) {
                int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i = scrollY - verticalScrollFactorCompat;
                if (i < 0) {
                    scrollRange = 0;
                } else if (i <= scrollRange) {
                    scrollRange = i;
                }
                if (scrollRange != scrollY) {
                    super.scrollTo(getScrollX(), scrollRange);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.j) {
            return true;
        }
        int i = action & 255;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    int i2 = this.q;
                    if (i2 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i2);
                        if (findPointerIndex == -1) {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i2 + " in onInterceptTouchEvent");
                        } else {
                            int y = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y - this.f) > this.n && (2 & getNestedScrollAxes()) == 0) {
                                this.j = true;
                                this.f = y;
                                p();
                                this.k.addMovement(motionEvent);
                                this.t = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i != 3) {
                    if (i == 6) {
                        t(motionEvent);
                    }
                }
            }
            this.j = false;
            this.q = -1;
            w();
            if (this.f163c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
            stopNestedScroll(0);
        } else {
            int y2 = (int) motionEvent.getY();
            if (!m((int) motionEvent.getX(), y2)) {
                this.j = false;
                w();
            } else {
                this.f = y2;
                this.q = motionEvent.getPointerId(0);
                n();
                this.k.addMovement(motionEvent);
                this.f163c.computeScrollOffset();
                this.j = false;
                startNestedScroll(2, 0);
            }
        }
        return this.j;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.g = false;
        View view = this.i;
        if (view != null && r(view, this)) {
            y(this.i);
        }
        this.i = null;
        if (!this.h) {
            if (this.v != null) {
                scrollTo(getScrollX(), this.v.a);
                this.v = null;
            }
            int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > max) {
                scrollTo(getScrollX(), max);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.h = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.l && View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(FrameLayout.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), View.MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), WXVideoFileObject.FILE_SIZE_LIMIT));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        k((int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        dispatchNestedPreScroll(i, i2, iArr, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.w.onNestedScrollAccepted(view, view2, i);
        startNestedScroll(2);
    }

    @Override // android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        View findNextFocusFromRect;
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        if (rect == null) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, null, i);
        } else {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        }
        if (findNextFocusFromRect == null || q(findNextFocusFromRect)) {
            return false;
        }
        return findNextFocusFromRect.requestFocus(i, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        this.v = cVar;
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.a = getScrollY();
        return cVar;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        b bVar = this.z;
        if (bVar != null) {
            bVar.a(this, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus == null || this == findFocus || !s(findFocus, 0, i4)) {
            return;
        }
        findFocus.getDrawingRect(this.b);
        offsetDescendantRectToMyCoords(findFocus, this.b);
        e(d(this.b));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        this.w.onStopNestedScroll(view);
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        p();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.t = 0;
        }
        obtain.offsetLocation(com.sigmob.sdk.base.blurkit.c.d, this.t);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.k;
                velocityTracker.computeCurrentVelocity(1000, this.p);
                int yVelocity = (int) velocityTracker.getYVelocity(this.q);
                if (Math.abs(yVelocity) > this.o) {
                    k(-yVelocity);
                } else if (this.f163c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                this.q = -1;
                f();
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.q);
                if (findPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.q + " in onTouchEvent");
                } else {
                    int y = (int) motionEvent.getY(findPointerIndex);
                    int i = this.f - y;
                    if (dispatchNestedPreScroll(0, i, this.s, this.r, 0)) {
                        i -= this.s[1];
                        obtain.offsetLocation(com.sigmob.sdk.base.blurkit.c.d, this.r[1]);
                        this.t += this.r[1];
                    }
                    if (!this.j && Math.abs(i) > this.n) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.j = true;
                        if (i > 0) {
                            i -= this.n;
                        } else {
                            i += this.n;
                        }
                    }
                    int i2 = i;
                    if (this.j) {
                        this.f = y - this.r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = getOverScrollMode();
                        boolean z = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                        if (u(0, i2, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !hasNestedScrollingParent(0)) {
                            this.k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (dispatchNestedScroll(0, scrollY2, 0, i2 - scrollY2, this.r, 0)) {
                            this.f = this.f - this.r[1];
                            obtain.offsetLocation(com.sigmob.sdk.base.blurkit.c.d, r1[1]);
                            this.t += this.r[1];
                        } else if (z) {
                            g();
                            int i3 = scrollY + i2;
                            if (i3 < 0) {
                                EdgeEffectCompat.onPull(this.d, i2 / getHeight(), motionEvent.getX(findPointerIndex) / getWidth());
                                if (!this.e.isFinished()) {
                                    this.e.onRelease();
                                }
                            } else if (i3 > scrollRange) {
                                EdgeEffectCompat.onPull(this.e, i2 / getHeight(), 1.0f - (motionEvent.getX(findPointerIndex) / getWidth()));
                                if (!this.d.isFinished()) {
                                    this.d.onRelease();
                                }
                            }
                            EdgeEffect edgeEffect = this.d;
                            if (edgeEffect != null && (!edgeEffect.isFinished() || !this.e.isFinished())) {
                                ViewCompat.postInvalidateOnAnimation(this);
                            }
                        }
                    }
                }
            } else if (actionMasked == 3) {
                if (this.j && getChildCount() > 0 && this.f163c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                this.q = -1;
                f();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f = (int) motionEvent.getY(actionIndex);
                this.q = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                t(motionEvent);
                this.f = (int) motionEvent.getY(motionEvent.findPointerIndex(this.q));
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            boolean z2 = !this.f163c.isFinished();
            this.j = z2;
            if (z2 && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f163c.isFinished()) {
                this.f163c.abortAnimation();
            }
            this.f = (int) motionEvent.getY();
            this.q = motionEvent.getPointerId(0);
            startNestedScroll(2, 0);
        }
        VelocityTracker velocityTracker2 = this.k;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.g) {
            y(view2);
        } else {
            this.i = view2;
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return z(rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            w();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.g = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int c2 = c(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int c3 = c(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (c2 == getScrollX() && c3 == getScrollY()) {
                return;
            }
            super.scrollTo(c2, c3);
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.l) {
            this.l = z;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.x.setNestedScrollingEnabled(z);
    }

    public void setOnScrollChangeListener(b bVar) {
        this.z = bVar;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.m = z;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return this.x.startNestedScroll(i);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        this.x.stopNestedScroll();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0083 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean u(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21) {
        /*
            r12 = this;
            r0 = r12
            int r1 = r12.getOverScrollMode()
            int r2 = r12.computeHorizontalScrollRange()
            int r3 = r12.computeHorizontalScrollExtent()
            r4 = 0
            r5 = 1
            if (r2 <= r3) goto L13
            r2 = 1
            goto L14
        L13:
            r2 = 0
        L14:
            int r3 = r12.computeVerticalScrollRange()
            int r6 = r12.computeVerticalScrollExtent()
            if (r3 <= r6) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = 0
        L21:
            if (r1 == 0) goto L2a
            if (r1 != r5) goto L28
            if (r2 == 0) goto L28
            goto L2a
        L28:
            r2 = 0
            goto L2b
        L2a:
            r2 = 1
        L2b:
            if (r1 == 0) goto L34
            if (r1 != r5) goto L32
            if (r3 == 0) goto L32
            goto L34
        L32:
            r1 = 0
            goto L35
        L34:
            r1 = 1
        L35:
            int r3 = r15 + r13
            if (r2 != 0) goto L3b
            r2 = 0
            goto L3d
        L3b:
            r2 = r19
        L3d:
            int r6 = r16 + r14
            if (r1 != 0) goto L43
            r1 = 0
            goto L45
        L43:
            r1 = r20
        L45:
            int r7 = -r2
            int r2 = r2 + r17
            int r8 = -r1
            int r1 = r1 + r18
            if (r3 <= r2) goto L50
            r3 = r2
        L4e:
            r2 = 1
            goto L55
        L50:
            if (r3 >= r7) goto L54
            r3 = r7
            goto L4e
        L54:
            r2 = 0
        L55:
            if (r6 <= r1) goto L5a
            r6 = r1
        L58:
            r1 = 1
            goto L5f
        L5a:
            if (r6 >= r8) goto L5e
            r6 = r8
            goto L58
        L5e:
            r1 = 0
        L5f:
            if (r1 == 0) goto L7e
            boolean r7 = r12.hasNestedScrollingParent(r5)
            if (r7 != 0) goto L7e
            android.widget.OverScroller r7 = r0.f163c
            r8 = 0
            r9 = 0
            r10 = 0
            int r11 = r12.getScrollRange()
            r13 = r7
            r14 = r3
            r15 = r6
            r16 = r8
            r17 = r9
            r18 = r10
            r19 = r11
            r13.springBack(r14, r15, r16, r17, r18, r19)
        L7e:
            r12.onOverScrolled(r3, r6, r2, r1)
            if (r2 != 0) goto L85
            if (r1 == 0) goto L86
        L85:
            r4 = 1
        L86:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.custom.MyNestedScrollView.u(int, int, int, int, int, int, int, int, boolean):boolean");
    }

    public boolean v(int i) {
        boolean z = i == 130;
        int height = getHeight();
        if (z) {
            this.b.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                if (this.b.top + height > childAt.getBottom()) {
                    this.b.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.b.top = getScrollY() - height;
            Rect rect = this.b;
            if (rect.top < 0) {
                rect.top = 0;
            }
        }
        Rect rect2 = this.b;
        int i2 = rect2.top;
        int i3 = height + i2;
        rect2.bottom = i3;
        return x(i, i2, i3);
    }

    public MyNestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.x.dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return this.x.dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
    }

    public boolean hasNestedScrollingParent(int i) {
        return this.x.hasNestedScrollingParent(i);
    }

    public boolean startNestedScroll(int i, int i2) {
        return this.x.startNestedScroll(i, i2);
    }

    public void stopNestedScroll(int i) {
        this.x.stopNestedScroll(i);
    }

    public MyNestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new Rect();
        this.g = true;
        this.h = false;
        this.i = null;
        this.j = false;
        this.m = true;
        this.q = -1;
        this.r = new int[2];
        this.s = new int[2];
        o();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, B, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.w = new NestedScrollingParentHelper(this);
        this.x = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate(this, A);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        if (getChildCount() <= 0) {
            super.addView(view, i);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
