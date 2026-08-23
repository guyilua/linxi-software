package com.rtk.app.base;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.base.BaseRecyclerViewAdapter;
import com.rtk.app.tool.DownLoadTool.x;
import com.rtk.app.tool.DownLoadTool.y;
import com.rtk.app.tool.s;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class BaseRecyclerViewAdapter extends RecyclerView.Adapter {
    private boolean a = false;
    protected List<y> b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public boolean f150c = false;
    public s d = null;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    protected class EmptyViewHolder extends RecyclerView.ViewHolder {

        @BindView
        ProgressBar postDetailsRecyclerviewItemEmptyViewProgressBar;

        @BindView
        TextView postDetailsRecyclerviewItemEmptyViewTV;

        public EmptyViewHolder(BaseRecyclerViewAdapter baseRecyclerViewAdapter, View view) {
            super(view);
            ButterKnife.b(this, view);
        }

        public void b(Boolean bool) {
            if (bool.booleanValue()) {
                this.postDetailsRecyclerviewItemEmptyViewTV.setVisibility(0);
                this.postDetailsRecyclerviewItemEmptyViewProgressBar.setVisibility(8);
            } else {
                this.postDetailsRecyclerviewItemEmptyViewTV.setVisibility(8);
                this.postDetailsRecyclerviewItemEmptyViewProgressBar.setVisibility(0);
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class EmptyViewHolder_ViewBinding implements Unbinder {
        private EmptyViewHolder b;

        @UiThread
        public EmptyViewHolder_ViewBinding(EmptyViewHolder emptyViewHolder, View view) {
            this.b = emptyViewHolder;
            emptyViewHolder.postDetailsRecyclerviewItemEmptyViewProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.post_details_recyclerview_item_empty_view_progressBar, "field 'postDetailsRecyclerviewItemEmptyViewProgressBar'", ProgressBar.class);
            emptyViewHolder.postDetailsRecyclerviewItemEmptyViewTV = (TextView) butterknife.c.a.c(view, R.id.post_details_recyclerview_item_empty_view_TV, "field 'postDetailsRecyclerviewItemEmptyViewTV'", TextView.class);
        }

        @CallSuper
        public void a() {
            EmptyViewHolder emptyViewHolder = this.b;
            if (emptyViewHolder != null) {
                this.b = null;
                emptyViewHolder.postDetailsRecyclerviewItemEmptyViewProgressBar = null;
                emptyViewHolder.postDetailsRecyclerviewItemEmptyViewTV = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class RecyclerViewFootViewHolder extends RecyclerView.ViewHolder {
        View a;
        s b;

        @BindView
        public TextView loodingFootviewNoData;

        @BindView
        public ProgressBar loodingFootviewProgressbar;

        @BindView
        public TextView loodingFootviewRetry;

        @BindView
        public TextView loodingFootviewTv;

        public RecyclerViewFootViewHolder(View view) {
            super(view);
            ButterKnife.b(this, view);
            this.a = view;
            b();
        }

        private void b() {
            this.loodingFootviewRetry.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.base.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseRecyclerViewAdapter.RecyclerViewFootViewHolder.this.e(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void e(View view) {
            if (this.b != null) {
                j();
                this.b.a(new String[0]);
            }
        }

        private void h() {
            this.loodingFootviewRetry.setVisibility(8);
            this.loodingFootviewNoData.setVisibility(8);
            this.loodingFootviewProgressbar.setVisibility(8);
            this.loodingFootviewTv.setText("亲，我是有底的~");
            this.loodingFootviewTv.setVisibility(0);
        }

        private void i(s sVar) {
            this.loodingFootviewRetry.setVisibility(0);
            this.loodingFootviewNoData.setVisibility(8);
            this.loodingFootviewProgressbar.setVisibility(8);
            this.loodingFootviewTv.setVisibility(8);
            this.b = sVar;
        }

        private void j() {
            this.loodingFootviewRetry.setVisibility(8);
            this.loodingFootviewNoData.setVisibility(8);
            this.loodingFootviewProgressbar.setVisibility(0);
            this.loodingFootviewTv.setText("加载中...");
            this.loodingFootviewTv.setVisibility(0);
        }

        private void k() {
            this.loodingFootviewNoData.setVisibility(0);
            this.loodingFootviewProgressbar.setVisibility(8);
            this.loodingFootviewTv.setVisibility(8);
            this.loodingFootviewRetry.setVisibility(8);
        }

        public void f(Boolean bool, int i, boolean z, s sVar) {
            if (!bool.booleanValue()) {
                j();
                return;
            }
            if (z) {
                i(sVar);
            } else if (i == 0) {
                k();
            } else {
                h();
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class RecyclerViewFootViewHolder_ViewBinding implements Unbinder {
        private RecyclerViewFootViewHolder b;

        @UiThread
        public RecyclerViewFootViewHolder_ViewBinding(RecyclerViewFootViewHolder recyclerViewFootViewHolder, View view) {
            this.b = recyclerViewFootViewHolder;
            recyclerViewFootViewHolder.loodingFootviewTv = (TextView) butterknife.c.a.c(view, R.id.looding_footview_tv, "field 'loodingFootviewTv'", TextView.class);
            recyclerViewFootViewHolder.loodingFootviewNoData = (TextView) butterknife.c.a.c(view, R.id.looding_footView_no_data, "field 'loodingFootviewNoData'", TextView.class);
            recyclerViewFootViewHolder.loodingFootviewRetry = (TextView) butterknife.c.a.c(view, R.id.looding_footView_retry, "field 'loodingFootviewRetry'", TextView.class);
            recyclerViewFootViewHolder.loodingFootviewProgressbar = (ProgressBar) butterknife.c.a.c(view, R.id.looding_footview_progressbar, "field 'loodingFootviewProgressbar'", ProgressBar.class);
        }

        @CallSuper
        public void a() {
            RecyclerViewFootViewHolder recyclerViewFootViewHolder = this.b;
            if (recyclerViewFootViewHolder != null) {
                this.b = null;
                recyclerViewFootViewHolder.loodingFootviewTv = null;
                recyclerViewFootViewHolder.loodingFootviewNoData = null;
                recyclerViewFootViewHolder.loodingFootviewRetry = null;
                recyclerViewFootViewHolder.loodingFootviewProgressbar = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public s f() {
        return this.d;
    }

    public boolean g() {
        return this.a;
    }

    public boolean h() {
        return this.f150c;
    }

    public void i() {
        for (int i = 0; i < this.b.size(); i++) {
            if (this.b.get(i) != null) {
                x.c().m(this.b.get(i));
            }
        }
        this.b.clear();
    }

    public void j(boolean z) {
        this.a = z;
    }

    public void k(boolean z, s sVar) {
        this.f150c = z;
        this.d = sVar;
        if (z) {
            notifyDataSetChanged();
        }
    }
}
