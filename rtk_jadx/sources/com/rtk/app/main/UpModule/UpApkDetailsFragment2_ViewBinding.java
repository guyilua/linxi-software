package com.rtk.app.main.UpModule;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.YcRecyclerView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpApkDetailsFragment2_ViewBinding implements Unbinder {
    private UpApkDetailsFragment2 b;

    @UiThread
    public UpApkDetailsFragment2_ViewBinding(UpApkDetailsFragment2 upApkDetailsFragment2, View view) {
        this.b = upApkDetailsFragment2;
        upApkDetailsFragment2.upApkDetailsFragment2Newest = (RadioButton) butterknife.c.a.c(view, R.id.up_apk_details_fragment2_newest, "field 'upApkDetailsFragment2Newest'", RadioButton.class);
        upApkDetailsFragment2.upApkDetailsFragment2Hot = (RadioButton) butterknife.c.a.c(view, R.id.up_apk_details_fragment2_hot, "field 'upApkDetailsFragment2Hot'", RadioButton.class);
        upApkDetailsFragment2.upApkDetailsFragment2SortLv = (LinearLayout) butterknife.c.a.c(view, R.id.up_apk_details_fragment2_sortLv, "field 'upApkDetailsFragment2SortLv'", LinearLayout.class);
        upApkDetailsFragment2.upApkDetailsFragment2RecyclerView = (YcRecyclerView) butterknife.c.a.c(view, R.id.up_apk_details_fragment2_listView, "field 'upApkDetailsFragment2RecyclerView'", YcRecyclerView.class);
        upApkDetailsFragment2.upApkDetailsFragment2CommentBtu = (TextView) butterknife.c.a.c(view, R.id.up_apk_details_fragment2_commentBtu, "field 'upApkDetailsFragment2CommentBtu'", TextView.class);
        upApkDetailsFragment2.upApkDetailsFragment2Refresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.up_apk_details_fragment2_refresh, "field 'upApkDetailsFragment2Refresh'", SwipeRefreshLayout.class);
        upApkDetailsFragment2.upApkDetailsFragment2Sort = (RadioGroup) butterknife.c.a.c(view, R.id.up_apk_details_fragment2_sort, "field 'upApkDetailsFragment2Sort'", RadioGroup.class);
    }

    @CallSuper
    public void a() {
        UpApkDetailsFragment2 upApkDetailsFragment2 = this.b;
        if (upApkDetailsFragment2 != null) {
            this.b = null;
            upApkDetailsFragment2.upApkDetailsFragment2Newest = null;
            upApkDetailsFragment2.upApkDetailsFragment2Hot = null;
            upApkDetailsFragment2.upApkDetailsFragment2SortLv = null;
            upApkDetailsFragment2.upApkDetailsFragment2RecyclerView = null;
            upApkDetailsFragment2.upApkDetailsFragment2CommentBtu = null;
            upApkDetailsFragment2.upApkDetailsFragment2Refresh = null;
            upApkDetailsFragment2.upApkDetailsFragment2Sort = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
