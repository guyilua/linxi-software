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
import com.rtk.app.bean.Home5MyLevelBean;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home5MyLevelAdapter extends BaseRecyclerViewAdapter {
    private Context e;
    private List<Home5MyLevelBean.DataBean> f;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class NormalHolder extends RecyclerView.ViewHolder {

        @BindView
        TextView home5MyLevelItemNum;

        @BindView
        TextView home5MyLevelItemReason;

        @BindView
        TextView home5MyLevelItemTime;

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
            normalHolder.home5MyLevelItemReason = (TextView) butterknife.c.a.c(view, R.id.home5_my_level_item_reason, "field 'home5MyLevelItemReason'", TextView.class);
            normalHolder.home5MyLevelItemTime = (TextView) butterknife.c.a.c(view, R.id.home5_my_level_item_time, "field 'home5MyLevelItemTime'", TextView.class);
            normalHolder.home5MyLevelItemNum = (TextView) butterknife.c.a.c(view, R.id.home5_my_level_item_num, "field 'home5MyLevelItemNum'", TextView.class);
        }

        @CallSuper
        public void a() {
            NormalHolder normalHolder = this.b;
            if (normalHolder != null) {
                this.b = null;
                normalHolder.home5MyLevelItemReason = null;
                normalHolder.home5MyLevelItemTime = null;
                normalHolder.home5MyLevelItemNum = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public Home5MyLevelAdapter(Context context, List<Home5MyLevelBean.DataBean> list) {
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
            List<Home5MyLevelBean.DataBean> list = this.f;
            recyclerViewFootViewHolder.f(valueOf, list == null ? 0 : list.size(), h(), f());
            return;
        }
        NormalHolder normalHolder = (NormalHolder) viewHolder;
        normalHolder.home5MyLevelItemNum.setText(this.f.get(i).getExperience());
        normalHolder.home5MyLevelItemTime.setText(com.rtk.app.tool.c0.f(Long.parseLong(this.f.get(i).getAddtime())));
        normalHolder.home5MyLevelItemReason.setText(this.f.get(i).getType());
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != 1) {
            return new BaseRecyclerViewAdapter.RecyclerViewFootViewHolder(LayoutInflater.from(this.e).inflate(R.layout.looding_footview, viewGroup, false));
        }
        return new NormalHolder(LayoutInflater.from(this.e).inflate(R.layout.home5_my_level_item_layout, viewGroup, false));
    }
}
