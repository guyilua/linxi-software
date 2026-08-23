package com.rtk.app.main.UpModule;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpApkListMyAttentionFragment_ViewBinding implements Unbinder {
    private UpApkListMyAttentionFragment b;

    @UiThread
    public UpApkListMyAttentionFragment_ViewBinding(UpApkListMyAttentionFragment upApkListMyAttentionFragment, View view) {
        this.b = upApkListMyAttentionFragment;
        upApkListMyAttentionFragment.fragementForListviewListview = (AutoListView) butterknife.c.a.c(view, R.id.fragement_for_listview_listview, "field 'fragementForListviewListview'", AutoListView.class);
        upApkListMyAttentionFragment.fragementForListviewParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.fragement_for_listview_parent_layout, "field 'fragementForListviewParentLayout'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        UpApkListMyAttentionFragment upApkListMyAttentionFragment = this.b;
        if (upApkListMyAttentionFragment != null) {
            this.b = null;
            upApkListMyAttentionFragment.fragementForListviewListview = null;
            upApkListMyAttentionFragment.fragementForListviewParentLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
