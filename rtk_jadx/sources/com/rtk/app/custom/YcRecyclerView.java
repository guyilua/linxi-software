package com.rtk.app.custom;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.t;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class YcRecyclerView extends RecyclerView {
    private boolean a;
    private boolean b;

    /* renamed from: c, reason: collision with root package name */
    private b f173c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a extends RecyclerView.OnScrollListener {
        a() {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int i3;
            super.onScrolled(recyclerView, i, i2);
            GridLayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                i3 = layoutManager.findLastVisibleItemPosition();
            } else if (layoutManager instanceof LinearLayoutManager) {
                i3 = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
                staggeredGridLayoutManager.findLastVisibleItemPositions(iArr);
                i3 = t.v(iArr);
            } else {
                i3 = -1;
            }
            if (i3 != recyclerView.getLayoutManager().getItemCount() - 1 || YcRecyclerView.this.f173c == null) {
                return;
            }
            if (!YcRecyclerView.this.a || (YcRecyclerView.this.a && YcRecyclerView.this.b)) {
                YcRecyclerView.this.f173c.a();
                c0.u("YcRecyclerView", "YcRecyclerView加载中");
                YcRecyclerView.this.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d, 0));
            }
            YcRecyclerView.this.a = true;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface b {
        void a();
    }

    public YcRecyclerView(Context context) {
        super(context);
        this.a = true;
        this.b = false;
        e(context);
    }

    private void e(Context context) {
        addOnScrollListener(new a());
    }

    public void setIsEnd(boolean z) {
        this.a = z;
    }

    public void setRecyclerViewOnTheDownListener(b bVar) {
        this.f173c = bVar;
    }

    public void setRefreshing(boolean z) {
        this.a = z;
    }

    public YcRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
        this.b = false;
        e(context);
    }

    public YcRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = true;
        this.b = false;
        e(context);
    }
}
