package com.rtk.app.main.family;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.base.BaseRecyclerViewAdapter;
import com.rtk.app.bean.FamilyCoinDetailBean;
import com.rtk.app.main.dialogPack.FamilyCoinDetailDialog;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyCoinDetailListAdapter extends BaseRecyclerViewAdapter {
    private List<FamilyCoinDetailBean.DataBean> e;
    private Context f;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ViewHolder extends RecyclerView.ViewHolder {
        View a;

        @BindView
        TextView coin;

        @BindView
        RoundedImageView face;

        @BindView
        TextView name;

        @BindView
        TextView time;

        ViewHolder(View view) {
            super(view);
            ButterKnife.b(this, view);
            this.a = view;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.face = (RoundedImageView) butterknife.c.a.c(view, R.id.face, "field 'face'", RoundedImageView.class);
            viewHolder.name = (TextView) butterknife.c.a.c(view, R.id.name, "field 'name'", TextView.class);
            viewHolder.coin = (TextView) butterknife.c.a.c(view, R.id.coin, "field 'coin'", TextView.class);
            viewHolder.time = (TextView) butterknife.c.a.c(view, 2131300418, "field 'time'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.face = null;
                viewHolder.name = null;
                viewHolder.coin = null;
                viewHolder.time = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements View.OnClickListener {
        final /* synthetic */ FamilyCoinDetailBean.DataBean a;

        a(FamilyCoinDetailBean.DataBean dataBean) {
            this.a = dataBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new FamilyCoinDetailDialog(FamilyCoinDetailListAdapter.this.f, this.a).show();
        }
    }

    public FamilyCoinDetailListAdapter(List<FamilyCoinDetailBean.DataBean> list, Context context) {
        this.e = list;
        this.f = context;
    }

    public int getItemCount() {
        if (this.e.size() == 0) {
            return 1;
        }
        return this.e.size() + 1;
    }

    public int getItemViewType(int i) {
        return (i == getItemCount() - 1 || getItemCount() == 1) ? 0 : 1;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        try {
            int i2 = 0;
            if (getItemViewType(i) != 0) {
                ViewHolder viewHolder2 = (ViewHolder) viewHolder;
                FamilyCoinDetailBean.DataBean dataBean = this.e.get(i);
                String transaction_coin = dataBean.getTransaction_coin();
                viewHolder2.coin.setTextColor(transaction_coin.contains("-") ? -65536 : -16711936);
                viewHolder2.coin.setText(transaction_coin);
                viewHolder2.name.setText(dataBean.getTransaction_type().getName());
                com.rtk.app.tool.t.c(this.f, dataBean.getTransaction_user().getFace(), viewHolder2.face, new boolean[0]);
                viewHolder2.time.setText(dataBean.getTransaction_time());
                viewHolder2.a.setOnClickListener(new a(dataBean));
                return;
            }
            BaseRecyclerViewAdapter.RecyclerViewFootViewHolder recyclerViewFootViewHolder = (BaseRecyclerViewAdapter.RecyclerViewFootViewHolder) viewHolder;
            Boolean valueOf = Boolean.valueOf(g());
            List<FamilyCoinDetailBean.DataBean> list = this.e;
            if (list != null) {
                i2 = list.size();
            }
            recyclerViewFootViewHolder.f(valueOf, i2, h(), f());
        } catch (Exception e) {
            com.rtk.app.tool.c0.u("CommunityFragmentPostListAdapter", "异常" + e.toString());
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != 0) {
            return new ViewHolder(LayoutInflater.from(this.f).inflate(R.layout.family_coin_detail_list_item_layout, (ViewGroup) null));
        }
        return new BaseRecyclerViewAdapter.RecyclerViewFootViewHolder(LayoutInflater.from(this.f).inflate(R.layout.looding_footview, viewGroup, false));
    }
}
