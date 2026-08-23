package com.rtk.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.base.BaseRecyclerViewAdapter;
import com.rtk.app.bean.GoodsListBean;
import com.rtk.app.bean.MallCoinBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.main.Home5Activity.GoodsDetailsActivity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ShoppingMallAdapter extends BaseRecyclerViewAdapter {
    private List<GoodsListBean.DataBean> e;
    private Context f;
    private MallCoinBean g;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    protected static class ShoppingMallHolder extends RecyclerView.ViewHolder {
        private View a;

        @BindView
        ImageView shoppingMallItemImg;

        @BindView
        TextView shoppingMallItemName;

        @BindView
        TextView shoppingMallItemPrice;

        public ShoppingMallHolder(@NonNull View view) {
            super(view);
            ButterKnife.b(this, view);
            this.a = view;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ShoppingMallHolder_ViewBinding implements Unbinder {
        private ShoppingMallHolder b;

        @UiThread
        public ShoppingMallHolder_ViewBinding(ShoppingMallHolder shoppingMallHolder, View view) {
            this.b = shoppingMallHolder;
            shoppingMallHolder.shoppingMallItemImg = (ImageView) butterknife.c.a.c(view, R.id.shopping_mall_item_img, "field 'shoppingMallItemImg'", ImageView.class);
            shoppingMallHolder.shoppingMallItemName = (TextView) butterknife.c.a.c(view, R.id.shopping_mall_item_name, "field 'shoppingMallItemName'", TextView.class);
            shoppingMallHolder.shoppingMallItemPrice = (TextView) butterknife.c.a.c(view, R.id.shopping_mall_item_price, "field 'shoppingMallItemPrice'", TextView.class);
        }

        @CallSuper
        public void a() {
            ShoppingMallHolder shoppingMallHolder = this.b;
            if (shoppingMallHolder != null) {
                this.b = null;
                shoppingMallHolder.shoppingMallItemImg = null;
                shoppingMallHolder.shoppingMallItemName = null;
                shoppingMallHolder.shoppingMallItemPrice = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    protected static class ShoppingMallTopHolder extends RecyclerView.ViewHolder {

        @BindView
        CustomTextView shoppingMallTopCoins;

        @BindView
        TextView shoppingMallTopTips;

        public ShoppingMallTopHolder(@NonNull View view) {
            super(view);
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ShoppingMallTopHolder_ViewBinding implements Unbinder {
        private ShoppingMallTopHolder b;

        @UiThread
        public ShoppingMallTopHolder_ViewBinding(ShoppingMallTopHolder shoppingMallTopHolder, View view) {
            this.b = shoppingMallTopHolder;
            shoppingMallTopHolder.shoppingMallTopTips = (TextView) butterknife.c.a.c(view, R.id.shopping_mall_top_tips, "field 'shoppingMallTopTips'", TextView.class);
            shoppingMallTopHolder.shoppingMallTopCoins = (CustomTextView) butterknife.c.a.c(view, R.id.shopping_mall_top_coins, "field 'shoppingMallTopCoins'", CustomTextView.class);
        }

        @CallSuper
        public void a() {
            ShoppingMallTopHolder shoppingMallTopHolder = this.b;
            if (shoppingMallTopHolder != null) {
                this.b = null;
                shoppingMallTopHolder.shoppingMallTopTips = null;
                shoppingMallTopHolder.shoppingMallTopCoins = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = (String) view.getTag();
            Bundle bundle = new Bundle();
            bundle.putString("gid", str);
            com.rtk.app.tool.c.b((Activity) ShoppingMallAdapter.this.f, GoodsDetailsActivity.class, bundle);
        }
    }

    public ShoppingMallAdapter(Context context, List<GoodsListBean.DataBean> list) {
        this.e = new ArrayList();
        this.f = context;
        this.e = list;
    }

    public int getItemCount() {
        return this.e.size() + 1;
    }

    public int getItemViewType(int i) {
        return i != 0 ? 1 : 0;
    }

    public void m(MallCoinBean mallCoinBean) {
        this.g = mallCoinBean;
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        List<GoodsListBean.DataBean> list;
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            MallCoinBean mallCoinBean = this.g;
            if (mallCoinBean == null) {
                return;
            }
            ((ShoppingMallTopHolder) viewHolder).shoppingMallTopCoins.setText(mallCoinBean.getData().getCoin());
            return;
        }
        if (itemViewType != 1 || (list = this.e) == null || list.size() == 0) {
            return;
        }
        int i2 = i - 1;
        ShoppingMallHolder shoppingMallHolder = (ShoppingMallHolder) viewHolder;
        shoppingMallHolder.shoppingMallItemName.setText("" + this.e.get(i2).getGift_name());
        shoppingMallHolder.shoppingMallItemPrice.setText("" + this.e.get(i2).getCoin());
        com.rtk.app.tool.t.c(this.f, this.e.get(i2).getGift_pic().get(0), shoppingMallHolder.shoppingMallItemImg, new boolean[0]);
        shoppingMallHolder.a.setTag(this.e.get(i2).getId());
        shoppingMallHolder.a.setOnClickListener(new a());
    }

    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder shoppingMallTopHolder;
        if (i == 0) {
            shoppingMallTopHolder = new ShoppingMallTopHolder(LayoutInflater.from(this.f).inflate(R.layout.shopping_mall_top_layout, viewGroup, false));
        } else {
            if (i != 1) {
                return null;
            }
            shoppingMallTopHolder = new ShoppingMallHolder(LayoutInflater.from(this.f).inflate(R.layout.shopping_mall_item_layout, viewGroup, false));
        }
        return shoppingMallTopHolder;
    }
}
