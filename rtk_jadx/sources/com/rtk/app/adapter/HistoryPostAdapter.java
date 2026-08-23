package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.adapter.HistoryPostAdapter;
import com.rtk.app.bean.ListHisPostBean;
import com.rtk.app.main.dialogPack.DialogForEnSure;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HistoryPostAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private ListHisPostBean f67c;
    private Context d;
    private HisUpHolder e;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class HisUpHolder {
        private View a;
        private ListHisPostBean.HisPostBean b;

        @BindView
        TextView hisClickTime;

        @BindView
        TextView hisTitle;

        HisUpHolder(View view) {
            ButterKnife.b(this, view);
            this.a = view;
            a();
        }

        private void a() {
            this.a.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.w0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HistoryPostAdapter.HisUpHolder.this.c(view);
                }
            });
            this.a.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.rtk.app.adapter.u0
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return HistoryPostAdapter.HisUpHolder.this.e(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void c(View view) {
            com.rtk.app.tool.t.J0(HistoryPostAdapter.this.d, this.b.getPostId());
            com.rtk.app.main.Home5Activity.ClickHistory.f.r(HistoryPostAdapter.this.d, this.b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean e(View view) {
            new DialogForEnSure(HistoryPostAdapter.this.d, "删除该浏览记录？", new com.rtk.app.tool.s() { // from class: com.rtk.app.adapter.v0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    HistoryPostAdapter.HisUpHolder.this.g(strArr);
                }
            }).show();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void g(String[] strArr) {
            com.rtk.app.main.Home5Activity.ClickHistory.f.j(HistoryPostAdapter.this.d, this.b);
            HistoryPostAdapter.this.f67c.getListBean().remove(this.b);
            HistoryPostAdapter.this.notifyDataSetChanged();
        }

        protected void h(ListHisPostBean.HisPostBean hisPostBean) {
            this.b = hisPostBean;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class HisUpHolder_ViewBinding implements Unbinder {
        private HisUpHolder b;

        @UiThread
        public HisUpHolder_ViewBinding(HisUpHolder hisUpHolder, View view) {
            this.b = hisUpHolder;
            hisUpHolder.hisTitle = (TextView) butterknife.c.a.c(view, R.id.history_post_item_title, "field 'hisTitle'", TextView.class);
            hisUpHolder.hisClickTime = (TextView) butterknife.c.a.c(view, R.id.history_post_item_click_time, "field 'hisClickTime'", TextView.class);
        }

        @CallSuper
        public void a() {
            HisUpHolder hisUpHolder = this.b;
            if (hisUpHolder != null) {
                this.b = null;
                hisUpHolder.hisTitle = null;
                hisUpHolder.hisClickTime = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public HistoryPostAdapter(Context context, ListHisPostBean listHisPostBean) {
        super(listHisPostBean.getListBean());
        this.d = context;
        this.f67c = listHisPostBean;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.d).inflate(R.layout.history_post_layout, (ViewGroup) null);
            HisUpHolder hisUpHolder = new HisUpHolder(view);
            this.e = hisUpHolder;
            view.setTag(hisUpHolder);
        } else {
            this.e = (HisUpHolder) view.getTag();
        }
        this.e.h(this.f67c.getListBean().get(i));
        this.e.hisTitle.setText(this.f67c.getListBean().get(i).getTitle());
        this.e.hisClickTime.setText(com.rtk.app.tool.c0.m(this.f67c.getListBean().get(i).getClickTime()));
        return view;
    }
}
