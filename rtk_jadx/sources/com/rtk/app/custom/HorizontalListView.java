package com.rtk.app.custom;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HorizontalListView extends AdapterView<ListAdapter> {
    protected ListAdapter a;
    private int b;

    /* renamed from: c, reason: collision with root package name */
    private int f159c;
    protected int d;
    protected int e;
    private int f;
    private int g;
    protected Scroller h;
    private GestureDetector i;
    private Queue<View> j;
    private AdapterView.OnItemSelectedListener k;
    private AdapterView.OnItemClickListener l;
    private AdapterView.OnItemLongClickListener m;
    private boolean n;
    private DataSetObserver o;
    private GestureDetector.OnGestureListener p;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends DataSetObserver {
        a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            synchronized (HorizontalListView.this) {
                HorizontalListView.this.n = true;
            }
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            HorizontalListView.this.p();
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HorizontalListView.this.requestLayout();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c extends GestureDetector.SimpleOnGestureListener {
        c() {
        }

        private boolean a(MotionEvent motionEvent, View view) {
            Rect rect = new Rect();
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int width = view.getWidth() + i;
            int i2 = iArr[1];
            rect.set(i, i2, width, view.getHeight() + i2);
            return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return HorizontalListView.this.l(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return HorizontalListView.this.m(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            int childCount = HorizontalListView.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = HorizontalListView.this.getChildAt(i);
                if (a(motionEvent, childAt)) {
                    if (HorizontalListView.this.m != null) {
                        AdapterView.OnItemLongClickListener onItemLongClickListener = HorizontalListView.this.m;
                        HorizontalListView horizontalListView = HorizontalListView.this;
                        int i2 = horizontalListView.b + 1 + i;
                        HorizontalListView horizontalListView2 = HorizontalListView.this;
                        onItemLongClickListener.onItemLongClick(horizontalListView, childAt, i2, horizontalListView2.a.getItemId(horizontalListView2.b + 1 + i));
                        return;
                    }
                    return;
                }
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            HorizontalListView horizontalListView;
            synchronized (HorizontalListView.this) {
                horizontalListView = HorizontalListView.this;
                horizontalListView.e += (int) f;
            }
            horizontalListView.requestLayout();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            int i = 0;
            while (true) {
                if (i >= HorizontalListView.this.getChildCount()) {
                    break;
                }
                View childAt = HorizontalListView.this.getChildAt(i);
                if (a(motionEvent, childAt)) {
                    if (HorizontalListView.this.l != null) {
                        AdapterView.OnItemClickListener onItemClickListener = HorizontalListView.this.l;
                        HorizontalListView horizontalListView = HorizontalListView.this;
                        int i2 = horizontalListView.b + 1 + i;
                        HorizontalListView horizontalListView2 = HorizontalListView.this;
                        onItemClickListener.onItemClick(horizontalListView, childAt, i2, horizontalListView2.a.getItemId(horizontalListView2.b + 1 + i));
                    }
                    if (HorizontalListView.this.k != null) {
                        AdapterView.OnItemSelectedListener onItemSelectedListener = HorizontalListView.this.k;
                        HorizontalListView horizontalListView3 = HorizontalListView.this;
                        int i3 = horizontalListView3.b + 1 + i;
                        HorizontalListView horizontalListView4 = HorizontalListView.this;
                        onItemSelectedListener.onItemSelected(horizontalListView3, childAt, i3, horizontalListView4.a.getItemId(horizontalListView4.b + 1 + i));
                    }
                } else {
                    i++;
                }
            }
            return true;
        }
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = -1;
        this.f159c = 0;
        this.f = Integer.MAX_VALUE;
        this.g = 0;
        this.j = new LinkedList();
        this.n = false;
        this.o = new a();
        this.p = new c();
        k();
    }

    private void g(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        addViewInLayout(view, i, layoutParams, true);
        view.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
    }

    private void h(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        j(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        i(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void i(int i, int i2) {
        int i3;
        while (i + i2 > 0 && (i3 = this.b) >= 0) {
            View view = this.a.getView(i3, this.j.poll(), this);
            g(view, 0);
            i -= view.getMeasuredWidth();
            this.b--;
            this.g -= view.getMeasuredWidth();
        }
    }

    private void j(int i, int i2) {
        while (i + i2 < getWidth() && this.f159c < this.a.getCount()) {
            View view = this.a.getView(this.f159c, this.j.poll(), this);
            g(view, -1);
            i += view.getMeasuredWidth();
            if (this.f159c == this.a.getCount() - 1) {
                this.f = (this.d + i) - getWidth();
            }
            if (this.f < 0) {
                this.f = 0;
            }
            this.f159c++;
        }
    }

    private synchronized void k() {
        this.b = -1;
        this.f159c = 0;
        this.g = 0;
        this.d = 0;
        this.e = 0;
        this.f = Integer.MAX_VALUE;
        this.h = new Scroller(getContext());
        this.i = new GestureDetector(getContext(), this.p);
    }

    private void n(int i) {
        if (getChildCount() > 0) {
            int i2 = this.g + i;
            this.g = i2;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += measuredWidth + childAt.getPaddingRight();
            }
        }
    }

    private void o(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.g += childAt.getMeasuredWidth();
            this.j.offer(childAt);
            removeViewInLayout(childAt);
            this.b++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.j.offer(childAt2);
            removeViewInLayout(childAt2);
            this.f159c--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void p() {
        k();
        removeAllViewsInLayout();
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.i.onTouchEvent(motionEvent) | super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        return null;
    }

    protected boolean l(MotionEvent motionEvent) {
        this.h.forceFinished(true);
        return true;
    }

    protected boolean m(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.h.fling(this.e, 0, (int) (-f), 0, 0, this.f, 0, 0);
        }
        requestLayout();
        return true;
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.a == null) {
            return;
        }
        if (this.n) {
            int i5 = this.d;
            k();
            removeAllViewsInLayout();
            this.e = i5;
            this.n = false;
        }
        if (this.h.computeScrollOffset()) {
            this.e = this.h.getCurrX();
        }
        if (this.e <= 0) {
            this.e = 0;
            this.h.forceFinished(true);
        }
        int i6 = this.e;
        int i7 = this.f;
        if (i6 >= i7) {
            this.e = i7;
            this.h.forceFinished(true);
        }
        int i8 = this.d - this.e;
        o(i8);
        h(i8);
        n(i8);
        this.d = this.e;
        if (!this.h.isFinished()) {
            post(new b());
        }
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.l = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.m = onItemLongClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.k = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
    }

    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.a;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        ListAdapter listAdapter2 = this.a;
        if (listAdapter2 != null) {
            listAdapter2.unregisterDataSetObserver(this.o);
        }
        this.a = listAdapter;
        listAdapter.registerDataSetObserver(this.o);
        p();
    }
}
