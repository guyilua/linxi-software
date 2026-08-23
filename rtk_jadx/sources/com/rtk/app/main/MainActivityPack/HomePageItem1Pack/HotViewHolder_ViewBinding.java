package com.rtk.app.main.MainActivityPack.HomePageItem1Pack;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HotViewHolder_ViewBinding implements Unbinder {
    private HotViewHolder b;

    @UiThread
    public HotViewHolder_ViewBinding(HotViewHolder hotViewHolder, View view) {
        this.b = hotViewHolder;
        hotViewHolder.homePageItem1FragmentHotItem14 = (LinearLayout) butterknife.c.a.c(view, R.id.home_page_item1_fragment_hot_item_1_4, "field 'homePageItem1FragmentHotItem14'", LinearLayout.class);
        hotViewHolder.homePageItem1FragmentHotItem58 = (LinearLayout) butterknife.c.a.c(view, R.id.home_page_item1_fragment_hot_item_5_8, "field 'homePageItem1FragmentHotItem58'", LinearLayout.class);
        hotViewHolder.homePageItem1FragmentHotItemTitle = (TextView) butterknife.c.a.c(view, R.id.home_page_item1_fragment_hot_item_title, "field 'homePageItem1FragmentHotItemTitle'", TextView.class);
        hotViewHolder.homePageItem1FragmentHotItemMore = (TextView) butterknife.c.a.c(view, R.id.home_page_item1_fragment_hot_item_more, "field 'homePageItem1FragmentHotItemMore'", TextView.class);
    }

    @CallSuper
    public void a() {
        HotViewHolder hotViewHolder = this.b;
        if (hotViewHolder != null) {
            this.b = null;
            hotViewHolder.homePageItem1FragmentHotItem14 = null;
            hotViewHolder.homePageItem1FragmentHotItem58 = null;
            hotViewHolder.homePageItem1FragmentHotItemTitle = null;
            hotViewHolder.homePageItem1FragmentHotItemMore = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
