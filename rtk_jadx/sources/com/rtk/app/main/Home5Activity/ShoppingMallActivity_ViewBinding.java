package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ShoppingMallActivity_ViewBinding implements Unbinder {
    private ShoppingMallActivity b;

    @UiThread
    public ShoppingMallActivity_ViewBinding(ShoppingMallActivity shoppingMallActivity, View view) {
        this.b = shoppingMallActivity;
        shoppingMallActivity.shoppingMallTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.shopping_mall_top_layout, "field 'shoppingMallTopLayout'", LinearLayout.class);
        shoppingMallActivity.shoppingMallTopBack = (TextView) butterknife.c.a.c(view, R.id.shopping_mall_top_back, "field 'shoppingMallTopBack'", TextView.class);
        shoppingMallActivity.shoppingMallRecyclerView = (RecyclerView) butterknife.c.a.c(view, R.id.shopping_mall_recycler_view, "field 'shoppingMallRecyclerView'", RecyclerView.class);
        shoppingMallActivity.shoppingMallSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.shopping_mall_swipe_refresh, "field 'shoppingMallSwipeRefresh'", SwipeRefreshLayout.class);
        shoppingMallActivity.shoppingMallSwipeRefreshParent = (LinearLayout) butterknife.c.a.c(view, R.id.shopping_mall_swipe_refresh_parent, "field 'shoppingMallSwipeRefreshParent'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        ShoppingMallActivity shoppingMallActivity = this.b;
        if (shoppingMallActivity != null) {
            this.b = null;
            shoppingMallActivity.shoppingMallTopLayout = null;
            shoppingMallActivity.shoppingMallTopBack = null;
            shoppingMallActivity.shoppingMallRecyclerView = null;
            shoppingMallActivity.shoppingMallSwipeRefresh = null;
            shoppingMallActivity.shoppingMallSwipeRefreshParent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
