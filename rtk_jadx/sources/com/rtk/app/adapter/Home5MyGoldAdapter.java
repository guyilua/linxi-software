package com.rtk.app.adapter;

import android.content.Context;
import android.content.res.Resources;
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
import com.rtk.app.R;
import com.rtk.app.base.BaseRecyclerViewAdapter;
import com.rtk.app.bean.Home5MyGoldBean;
import com.rtk.app.main.dialogPack.CoinDialog;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home5MyGoldAdapter extends BaseRecyclerViewAdapter {
    private Context e;
    private List<Home5MyGoldBean.DataBean.ListBean> f;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class NormalHolder extends RecyclerView.ViewHolder {

        @BindView
        TextView myGoldItemAddNum;

        @BindView
        TextView myGoldItemAddTime;

        @BindView
        TextView myGoldItemAddType;

        NormalHolder(View view) {
            super(view);
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class NormalHolder_ViewBinding implements Unbinder {
        private NormalHolder b;

        @UiThread
        public NormalHolder_ViewBinding(NormalHolder normalHolder, View view) {
            this.b = normalHolder;
            normalHolder.myGoldItemAddType = (TextView) butterknife.c.a.c(view, R.id.my_gold_item_add_type, "field 'myGoldItemAddType'", TextView.class);
            normalHolder.myGoldItemAddTime = (TextView) butterknife.c.a.c(view, R.id.my_gold_item_add_time, "field 'myGoldItemAddTime'", TextView.class);
            normalHolder.myGoldItemAddNum = (TextView) butterknife.c.a.c(view, R.id.my_gold_item_addNum, "field 'myGoldItemAddNum'", TextView.class);
        }

        @CallSuper
        public void a() {
            NormalHolder normalHolder = this.b;
            if (normalHolder != null) {
                this.b = null;
                normalHolder.myGoldItemAddType = null;
                normalHolder.myGoldItemAddTime = null;
                normalHolder.myGoldItemAddNum = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements View.OnClickListener {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new CoinDialog(Home5MyGoldAdapter.this.e, ((Home5MyGoldBean.DataBean.ListBean) Home5MyGoldAdapter.this.f.get(this.a)).getId(), Integer.parseInt(((Home5MyGoldBean.DataBean.ListBean) Home5MyGoldAdapter.this.f.get(this.a)).getCoin().replace("+", ""))).show();
        }
    }

    public Home5MyGoldAdapter(Context context, List<Home5MyGoldBean.DataBean.ListBean> list) {
        this.e = context;
        this.f = list;
    }

    public int getItemCount() {
        return this.f.size() + 1;
    }

    public int getItemViewType(int i) {
        return i == getItemCount() - 1 ? 2 : 1;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Resources resources;
        int i2;
        if (getItemViewType(i) != 1) {
            BaseRecyclerViewAdapter.RecyclerViewFootViewHolder recyclerViewFootViewHolder = (BaseRecyclerViewAdapter.RecyclerViewFootViewHolder) viewHolder;
            Boolean valueOf = Boolean.valueOf(g());
            List<Home5MyGoldBean.DataBean.ListBean> list = this.f;
            recyclerViewFootViewHolder.f(valueOf, list == null ? 0 : list.size(), h(), f());
            return;
        }
        NormalHolder normalHolder = (NormalHolder) viewHolder;
        TextView textView = normalHolder.myGoldItemAddNum;
        if (this.f.get(i).getCoin().contains("-")) {
            resources = this.e.getResources();
            i2 = R.color.theme26;
        } else {
            resources = this.e.getResources();
            i2 = R.color.theme12;
        }
        textView.setTextColor(resources.getColor(i2));
        normalHolder.myGoldItemAddNum.setText(this.f.get(i).getCoin());
        normalHolder.myGoldItemAddTime.setText(com.rtk.app.tool.c0.f(Long.parseLong(this.f.get(i).getAddtime())));
        normalHolder.myGoldItemAddType.setText(this.f.get(i).getType());
        ((RecyclerView.ViewHolder) normalHolder).itemView.setOnClickListener(new a(i));
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != 1) {
            return new BaseRecyclerViewAdapter.RecyclerViewFootViewHolder(LayoutInflater.from(this.e).inflate(R.layout.looding_footview, viewGroup, false));
        }
        return new NormalHolder(LayoutInflater.from(this.e).inflate(R.layout.home5_my_gold_item_layout, viewGroup, false));
    }
}
