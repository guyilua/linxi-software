package com.rtk.app.custom.AutoListView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.rtk.app.R;
import com.rtk.app.tool.c0;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AutoListView extends ListView implements AbsListView.OnScrollListener {
    private int A;
    private c B;
    private b C;
    private TextView D;
    private int E;
    int F;
    int G;
    private a H;
    private int a;
    private LayoutInflater b;

    /* renamed from: c, reason: collision with root package name */
    private View f152c;
    private View d;
    private TextView e;
    private TextView f;
    private ImageView g;
    private ProgressBar h;
    private RelativeLayout i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private ProgressBar n;
    private RotateAnimation o;
    private RotateAnimation p;
    private com.rtk.app.a.a q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a(AbsListView absListView, int i);
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface b {
        void a();
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface c {
        void onRefresh();
    }

    public AutoListView(Context context) {
        super(context);
        this.t = -1;
        this.y = true;
        this.A = 10;
        this.E = -1;
        c(context);
    }

    private void a(AbsListView absListView, int i, int i2) {
        int i3;
        Log.d("AutoListView", "ifNeedLoad... start");
        Log.d("AutoListView", "loadEnable=" + this.y);
        if (this.y) {
            Log.d("AutoListView", "scrollState=" + this.t);
            if (this.s + i != i2) {
                return;
            }
            View childAt = absListView.getChildAt(getChildCount() - 1);
            if ((childAt == null || childAt.getBottom() != absListView.getHeight()) && (i3 = this.E) != -1 && i3 < this.A) {
                Log.d("AutoListView", "滑动到底部");
                return;
            }
            if (!this.x && !this.z) {
                this.x = true;
                h();
            }
            Log.d("AutoListView", "ifNeedLoad... end");
        }
    }

    private void b() {
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.custom.AutoListView.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AutoListView.this.e(view);
            }
        });
    }

    private void c(Context context) {
        RotateAnimation rotateAnimation = new RotateAnimation(com.sigmob.sdk.base.blurkit.c.d, -180.0f, 1, 0.5f, 1, 0.5f);
        this.o = rotateAnimation;
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.o.setDuration(100L);
        this.o.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, com.sigmob.sdk.base.blurkit.c.d, 1, 0.5f, 1, 0.5f);
        this.p = rotateAnimation2;
        rotateAnimation2.setInterpolator(new LinearInterpolator());
        this.p.setDuration(100L);
        this.p.setFillAfter(true);
        LayoutInflater from = LayoutInflater.from(context);
        this.b = from;
        View inflate = from.inflate(R.layout.autolistview_footer, (ViewGroup) null);
        this.d = inflate;
        this.l = (TextView) inflate.findViewById(R.id.loadFull);
        this.k = (TextView) this.d.findViewById(R.id.noData);
        this.m = (TextView) this.d.findViewById(R.id.more);
        this.D = (TextView) this.d.findViewById(R.id.try_again);
        this.n = (ProgressBar) this.d.findViewById(R.id.loading);
        this.j = (TextView) this.d.findViewById(R.id.click_load);
        View inflate2 = this.b.inflate(R.layout.auto_pull_to_refresh_header, (ViewGroup) null);
        this.f152c = inflate2;
        this.g = (ImageView) inflate2.findViewById(R.id.arrow);
        this.e = (TextView) this.f152c.findViewById(R.id.tip);
        this.f = (TextView) this.f152c.findViewById(R.id.lastUpdate);
        this.h = (ProgressBar) this.f152c.findViewById(R.id.refreshing);
        this.i = (RelativeLayout) this.f152c.findViewById(R.id.pull_head_lv);
        this.u = this.f152c.getPaddingTop();
        g(this.f152c);
        int measuredHeight = this.f152c.getMeasuredHeight();
        this.v = measuredHeight;
        m(-measuredHeight);
        addHeaderView(this.f152c);
        addFooterView(this.d);
        setOnScrollListener(this);
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(View view) {
        this.l.setVisibility(8);
        this.n.setVisibility(0);
        this.m.setVisibility(0);
        this.k.setVisibility(8);
        this.j.setVisibility(8);
        this.D.setVisibility(8);
        this.y = true;
        this.C.a();
    }

    private void g(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i = layoutParams.height;
        if (i > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, WXVideoFileObject.FILE_SIZE_LIMIT);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    private void h() {
        c0.u("AutoListView", "我被执行了 onLoadListener.onLoadMore加载中  " + this);
        if (this.C != null) {
            this.l.setVisibility(8);
            this.n.setVisibility(0);
            this.m.setVisibility(0);
            this.k.setVisibility(8);
            this.j.setVisibility(8);
            this.D.setVisibility(8);
            this.y = true;
            this.C.a();
        }
    }

    private void i() {
        c cVar = this.B;
        if (cVar != null) {
            cVar.onRefresh();
            this.i.setVisibility(0);
        }
    }

    private void l() {
        Log.d("AutoListView", "refreshHeaderViewByState--state=" + this.a);
        int i = this.a;
        if (i == 0) {
            m(-this.v);
            this.e.setText(R.string.pull_to_refresh);
            this.h.setVisibility(8);
            this.g.clearAnimation();
            this.g.setImageResource(R.drawable.pull_to_refresh_arrow);
            return;
        }
        if (i == 1) {
            this.g.setVisibility(0);
            this.e.setVisibility(0);
            this.f.setVisibility(0);
            this.h.setVisibility(8);
            this.e.setText(R.string.pull_to_refresh);
            this.g.clearAnimation();
            this.g.setAnimation(this.p);
            return;
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
            m(this.u);
            this.h.setVisibility(0);
            this.g.clearAnimation();
            this.g.setVisibility(8);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
            return;
        }
        this.g.setVisibility(0);
        this.e.setVisibility(0);
        this.f.setVisibility(0);
        this.h.setVisibility(8);
        this.e.setText(R.string.pull_to_refresh);
        this.e.setText(R.string.release_to_refresh);
        this.g.clearAnimation();
        this.g.setAnimation(this.o);
    }

    private void m(int i) {
        View view = this.f152c;
        view.setPadding(view.getPaddingLeft(), i, this.f152c.getPaddingRight(), this.f152c.getPaddingBottom());
        this.f152c.invalidate();
    }

    private void n(MotionEvent motionEvent) {
        if (this.w) {
            int y = ((int) motionEvent.getY()) - this.r;
            int i = y - this.v;
            com.rtk.app.a.a aVar = this.q;
            if (aVar != null) {
                if (y < 30) {
                    aVar.b();
                } else {
                    aVar.a();
                }
            }
            int i2 = this.a;
            if (i2 == 0) {
                if (y > 0) {
                    this.a = 1;
                    l();
                    return;
                }
                return;
            }
            if (i2 == 1) {
                m(i);
                if (y <= this.v + 20 || this.t != 1) {
                    return;
                }
                this.a = 2;
                l();
                return;
            }
            if (i2 != 2) {
                return;
            }
            m(i);
            if (y > 0 && y < this.v + 20) {
                this.a = 1;
                l();
            } else if (y <= 0) {
                this.a = 0;
                l();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Log.d("AutoListView", "dispatchTouchEvent--" + getParent());
        return super.dispatchTouchEvent(motionEvent);
    }

    public void f() {
        this.x = false;
        this.i.setVisibility(8);
        this.l.setVisibility(8);
        this.n.setVisibility(8);
        this.m.setVisibility(8);
        this.k.setVisibility(8);
        this.j.setVisibility(8);
        this.D.setVisibility(0);
    }

    public int getPageSize() {
        return this.A;
    }

    public void j(String str) {
        this.f.setText(getContext().getString(R.string.lastUpdateTime, com.rtk.app.custom.AutoListView.c.a()));
        this.a = 0;
        l();
    }

    public void k() {
        j(com.rtk.app.custom.AutoListView.c.a());
        this.x = false;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Log.d("AutoListView", "onScroll--scrollState--" + this.t);
        Log.d("AutoListView", "firstVisibleItem=" + i + ",visibleItemCount=" + i2 + ",totalItemCount=" + i3);
        this.s = i;
        this.F = i2;
        this.G = i3;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.t = i;
        Log.d("AutoListView", "onScrollStateChanged--scrollState--" + i);
        a(absListView, this.F, this.G);
        a aVar = this.H;
        if (aVar != null) {
            aVar.a(absListView, i);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        n(motionEvent);
                    } else if (action != 3) {
                        if (action == 8) {
                            Log.d("AutoListView", "ACTION_SCROLL");
                        }
                    }
                }
                Log.d("AutoListView", "ACTION_UP");
                int i = this.a;
                if (i == 1) {
                    this.a = 0;
                    l();
                } else if (i == 2) {
                    this.a = 3;
                    l();
                    i();
                }
                this.w = false;
                a(this, this.F, this.G);
            } else if (this.s == 0) {
                this.w = true;
                this.r = (int) motionEvent.getY();
                motionEvent.getX();
            }
        } catch (Exception unused) {
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAutoListViewForCoordinatorLayoutListener(com.rtk.app.a.a aVar) {
        this.q = aVar;
    }

    public void setLoadEnable(boolean z) {
    }

    public void setMyScrollStateChanged(a aVar) {
        this.H = aVar;
    }

    public void setOnLoadListener(b bVar) {
        this.y = true;
        this.C = bVar;
    }

    public void setOnRefreshListener(c cVar) {
        this.B = cVar;
    }

    public void setPageSize(int i) {
        this.A = i;
    }

    public void setResultSize(int i) {
        this.D.setVisibility(8);
        int count = (getCount() - getHeaderViewsCount()) - getFooterViewsCount();
        this.E = i;
        if (i == 0) {
            this.z = true;
            this.n.setVisibility(8);
            this.m.setVisibility(8);
            this.j.setVisibility(8);
            if (count == 0) {
                this.k.setVisibility(0);
                this.l.setVisibility(8);
                return;
            } else {
                this.l.setVisibility(0);
                this.k.setVisibility(8);
                return;
            }
        }
        if (i > 0 && i < this.A) {
            this.z = true;
            this.l.setVisibility(0);
            this.n.setVisibility(8);
            this.m.setVisibility(8);
            this.k.setVisibility(8);
            this.j.setVisibility(8);
            return;
        }
        if (i >= this.A) {
            this.z = false;
            this.l.setVisibility(8);
            this.n.setVisibility(8);
            this.j.setVisibility(0);
            this.j.setText("");
            this.m.setVisibility(8);
            this.k.setVisibility(8);
        }
    }

    public AutoListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.t = -1;
        this.y = true;
        this.A = 10;
        this.E = -1;
        c(context);
    }

    public AutoListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.t = -1;
        this.y = true;
        this.A = 10;
        this.E = -1;
        c(context);
    }
}
