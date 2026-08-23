package com.rtk.app.adapter;

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
import com.rtk.app.R;
import com.rtk.app.base.BaseRecyclerViewAdapter;
import com.rtk.app.bean.HomeMyContributeBean;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home5MyIntegralAdapter extends BaseRecyclerViewAdapter {
    private Context e;
    private List<HomeMyContributeBean.DataBean> f;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class NormalHolder extends RecyclerView.ViewHolder {

        @BindView
        TextView myIntegralItemAddNum;

        @BindView
        TextView myIntegralItemAddTime;

        @BindView
        TextView myIntegralItemAddType;

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
            normalHolder.myIntegralItemAddType = (TextView) butterknife.c.a.c(view, R.id.my_integral_item_add_type, "field 'myIntegralItemAddType'", TextView.class);
            normalHolder.myIntegralItemAddTime = (TextView) butterknife.c.a.c(view, R.id.my_integral_item_add_time, "field 'myIntegralItemAddTime'", TextView.class);
            normalHolder.myIntegralItemAddNum = (TextView) butterknife.c.a.c(view, R.id.my_integral_item_addNum, "field 'myIntegralItemAddNum'", TextView.class);
        }

        @CallSuper
        public void a() {
            NormalHolder normalHolder = this.b;
            if (normalHolder != null) {
                this.b = null;
                normalHolder.myIntegralItemAddType = null;
                normalHolder.myIntegralItemAddTime = null;
                normalHolder.myIntegralItemAddNum = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public Home5MyIntegralAdapter(Context context, List<HomeMyContributeBean.DataBean> list) {
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
        if (getItemViewType(i) != 1) {
            BaseRecyclerViewAdapter.RecyclerViewFootViewHolder recyclerViewFootViewHolder = (BaseRecyclerViewAdapter.RecyclerViewFootViewHolder) viewHolder;
            Boolean valueOf = Boolean.valueOf(g());
            List<HomeMyContributeBean.DataBean> list = this.f;
            recyclerViewFootViewHolder.f(valueOf, list == null ? 0 : list.size(), h(), f());
            return;
        }
        NormalHolder normalHolder = (NormalHolder) viewHolder;
        normalHolder.myIntegralItemAddNum.setText(this.f.get(i).getContribute());
        normalHolder.myIntegralItemAddTime.setText(com.rtk.app.tool.c0.f(Long.parseLong(this.f.get(i).getAddtime())));
        normalHolder.myIntegralItemAddType.setText(this.f.get(i).getType());
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != 1) {
            return new BaseRecyclerViewAdapter.RecyclerViewFootViewHolder(LayoutInflater.from(this.e).inflate(R.layout.looding_footview, viewGroup, false));
        }
        return new NormalHolder(LayoutInflater.from(this.e).inflate(R.layout.home5_my_integral_item_layout, viewGroup, false));
    }
}
