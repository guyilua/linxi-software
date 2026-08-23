package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GoodsReplyRecodeActivity_ViewBinding implements Unbinder {
    private GoodsReplyRecodeActivity b;

    @UiThread
    public GoodsReplyRecodeActivity_ViewBinding(GoodsReplyRecodeActivity goodsReplyRecodeActivity, View view) {
        this.b = goodsReplyRecodeActivity;
        goodsReplyRecodeActivity.goodsReplyRecodeTopBack = (TextView) butterknife.c.a.c(view, R.id.goods_reply_recode_top_back, "field 'goodsReplyRecodeTopBack'", TextView.class);
        goodsReplyRecodeActivity.goodsReplyRecodeTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.goods_reply_recode_top_layout, "field 'goodsReplyRecodeTopLayout'", LinearLayout.class);
        goodsReplyRecodeActivity.goodsReplyRecodeListView = (AutoListView) butterknife.c.a.c(view, R.id.goods_reply_recode_listView, "field 'goodsReplyRecodeListView'", AutoListView.class);
        goodsReplyRecodeActivity.goodsReplyRecodeParent = (LinearLayout) butterknife.c.a.c(view, R.id.goods_reply_recode_parent, "field 'goodsReplyRecodeParent'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        GoodsReplyRecodeActivity goodsReplyRecodeActivity = this.b;
        if (goodsReplyRecodeActivity != null) {
            this.b = null;
            goodsReplyRecodeActivity.goodsReplyRecodeTopBack = null;
            goodsReplyRecodeActivity.goodsReplyRecodeTopLayout = null;
            goodsReplyRecodeActivity.goodsReplyRecodeListView = null;
            goodsReplyRecodeActivity.goodsReplyRecodeParent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
