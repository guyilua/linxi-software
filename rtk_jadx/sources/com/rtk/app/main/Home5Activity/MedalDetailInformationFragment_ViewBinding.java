package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MedalDetailInformationFragment_ViewBinding implements Unbinder {
    private MedalDetailInformationFragment b;

    @UiThread
    public MedalDetailInformationFragment_ViewBinding(MedalDetailInformationFragment medalDetailInformationFragment, View view) {
        this.b = medalDetailInformationFragment;
        medalDetailInformationFragment.medalDetailItemImg = (ImageView) butterknife.c.a.c(view, R.id.medal_detail_item_img, "field 'medalDetailItemImg'", ImageView.class);
        medalDetailInformationFragment.medalDetailItemName = (TextView) butterknife.c.a.c(view, R.id.medal_detail_item_name, "field 'medalDetailItemName'", TextView.class);
        medalDetailInformationFragment.medalDetailItemDegree = (TextView) butterknife.c.a.c(view, R.id.medal_detail_item_degree, "field 'medalDetailItemDegree'", TextView.class);
        medalDetailInformationFragment.medalDetailItemTime = (TextView) butterknife.c.a.c(view, R.id.medal_detail_item_time, "field 'medalDetailItemTime'", TextView.class);
        medalDetailInformationFragment.medalDetailItemNeed = (TextView) butterknife.c.a.c(view, R.id.medal_detail_item_need, "field 'medalDetailItemNeed'", TextView.class);
    }

    @CallSuper
    public void a() {
        MedalDetailInformationFragment medalDetailInformationFragment = this.b;
        if (medalDetailInformationFragment != null) {
            this.b = null;
            medalDetailInformationFragment.medalDetailItemImg = null;
            medalDetailInformationFragment.medalDetailItemName = null;
            medalDetailInformationFragment.medalDetailItemDegree = null;
            medalDetailInformationFragment.medalDetailItemTime = null;
            medalDetailInformationFragment.medalDetailItemNeed = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
