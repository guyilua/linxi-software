package com.rtk.app.custom;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import com.rtk.app.tool.c0;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SwipeBackLayout extends FrameLayout {
    private static final String m = SwipeBackLayout.class.getSimpleName();
    private View a;
    private int b;

    /* renamed from: c, reason: collision with root package name */
    private int f172c;
    private int d;
    private int e;
    private Scroller f;
    private int g;
    private boolean h;
    private boolean i;
    private Drawable j;
    private Activity k;
    private List<ViewPager> l;

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b(List<ViewPager> list, ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewPager) {
                list.add((ViewPager) childAt);
            } else if (childAt instanceof ViewGroup) {
                b(list, (ViewGroup) childAt);
            }
        }
    }

    private ViewPager c(List<ViewPager> list, MotionEvent motionEvent) {
        if (list != null && list.size() != 0) {
            Rect rect = new Rect();
            Iterator<ViewPager> it = list.iterator();
            if (it.hasNext()) {
                ViewPager next = it.next();
                next.getHitRect(rect);
                return next;
            }
        }
        return null;
    }

    private void d() {
        int scrollX = this.a.getScrollX();
        this.f.startScroll(this.a.getScrollX(), 0, -scrollX, 0, Math.abs(scrollX));
        postInvalidate();
    }

    private void e() {
        this.f.startScroll(this.a.getScrollX(), 0, (-(this.g + this.a.getScrollX())) + 1, 0, 10);
        postInvalidate();
    }

    private void setContentView(View view) {
        this.a = (View) view.getParent();
    }

    public void a(Activity activity) {
        this.k = activity;
        TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{R.attr.windowBackground});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
        viewGroup2.setBackgroundResource(resourceId);
        viewGroup.removeView(viewGroup2);
        addView(viewGroup2);
        setContentView(viewGroup2);
        viewGroup.addView(this);
    }

    @Override // android.view.View
    public void computeScroll() {
        try {
            if (this.f.computeScrollOffset()) {
                this.a.scrollTo(this.f.getCurrX(), this.f.getCurrY());
                postInvalidate();
                if (this.f.isFinished() && this.i) {
                    c0.u(m, " 销毁 computeScroll" + System.currentTimeMillis());
                    this.k.finish();
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        View view;
        super.dispatchDraw(canvas);
        if (this.j == null || (view = this.a) == null) {
            return;
        }
        int left = view.getLeft() - this.j.getIntrinsicWidth();
        this.j.setBounds(left, this.a.getTop(), this.j.getIntrinsicWidth() + left, this.a.getBottom());
        this.j.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewPager c2 = c(this.l, motionEvent);
        if (!MyHorizontalScrollView.b && (c2 == null || c2.getCurrentItem() == 0)) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 2 && ((int) motionEvent.getRawX()) - this.f172c > this.b && Math.abs(((int) motionEvent.getRawY()) - this.d) < this.b) {
                    return true;
                }
            } else {
                int rawX = (int) motionEvent.getRawX();
                this.e = rawX;
                this.f172c = rawX;
                this.d = (int) motionEvent.getRawY();
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.g = getWidth();
            b(this.l, this);
            Log.i(m, "ViewPager size = " + this.l.size());
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1) {
            this.h = false;
            if (this.a.getScrollX() <= (-this.g) / 6) {
                c0.u(m, " 销毁 抬手动作" + System.currentTimeMillis());
                this.i = true;
                e();
            } else {
                d();
                this.i = false;
            }
        } else if (action == 2) {
            int rawX = (int) motionEvent.getRawX();
            int i = this.e - rawX;
            this.e = rawX;
            if (rawX - this.f172c > this.b && Math.abs(((int) motionEvent.getRawY()) - this.d) < this.b) {
                this.h = true;
            }
            if (rawX - this.f172c >= 0 && this.h) {
                this.a.scrollBy(i, 0);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = new LinkedList();
        this.b = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f = new Scroller(context);
        this.j = getResources().getDrawable(com.rtk.app.R.drawable.shadow_left);
    }
}
