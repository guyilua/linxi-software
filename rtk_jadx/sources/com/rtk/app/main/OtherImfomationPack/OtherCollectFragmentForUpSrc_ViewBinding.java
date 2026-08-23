package com.rtk.app.main.OtherImfomationPack;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class OtherCollectFragmentForUpSrc_ViewBinding implements Unbinder {
    private OtherCollectFragmentForUpSrc b;

    @UiThread
    public OtherCollectFragmentForUpSrc_ViewBinding(OtherCollectFragmentForUpSrc otherCollectFragmentForUpSrc, View view) {
        this.b = otherCollectFragmentForUpSrc;
        otherCollectFragmentForUpSrc.fragementForListviewListview = (AutoListView) butterknife.c.a.c(view, R.id.fragement_for_listview_listview, "field 'fragementForListviewListview'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        OtherCollectFragmentForUpSrc otherCollectFragmentForUpSrc = this.b;
        if (otherCollectFragmentForUpSrc != null) {
            this.b = null;
            otherCollectFragmentForUpSrc.fragementForListviewListview = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
