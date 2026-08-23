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
import com.rtk.app.bean.GameDetailsBean;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GameDetailsVipAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f58c;
    private List<GameDetailsBean.DataBean.VipListBean> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        TextView gameDetailsItem1VipItemPrice;

        @BindView
        TextView gameDetailsItem1VipItemRange;

        ViewHolder(GameDetailsVipAdapter gameDetailsVipAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.gameDetailsItem1VipItemRange = (TextView) butterknife.c.a.c(view, R.id.game_details_item1_vip_item_range, "field 'gameDetailsItem1VipItemRange'", TextView.class);
            viewHolder.gameDetailsItem1VipItemPrice = (TextView) butterknife.c.a.c(view, R.id.game_details_item1_vip_item_price, "field 'gameDetailsItem1VipItemPrice'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.gameDetailsItem1VipItemRange = null;
                viewHolder.gameDetailsItem1VipItemPrice = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public GameDetailsVipAdapter(Context context, List<GameDetailsBean.DataBean.VipListBean> list) {
        super(list);
        this.f58c = context;
        this.d = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f58c).inflate(R.layout.game_details_item1_vip_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(this, view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.gameDetailsItem1VipItemRange.setText(this.d.get(i).getLevel());
        viewHolder.gameDetailsItem1VipItemPrice.setText(this.d.get(i).getValue());
        if (i % 2 == 0) {
            view.setBackgroundColor(this.f58c.getResources().getColor(R.color.wideLine));
        } else {
            view.setBackgroundColor(this.f58c.getResources().getColor(R.color.transparency));
        }
        return view;
    }
}
