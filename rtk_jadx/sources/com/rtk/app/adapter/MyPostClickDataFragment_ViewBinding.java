package com.rtk.app.adapter;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyPostClickDataFragment_ViewBinding implements Unbinder {
    private MyPostClickDataFragment b;

    @UiThread
    public MyPostClickDataFragment_ViewBinding(MyPostClickDataFragment myPostClickDataFragment, View view) {
        this.b = myPostClickDataFragment;
        myPostClickDataFragment.fragmentForListviewListview = (AutoListView) butterknife.c.a.c(view, R.id.fragement_for_listview_listview, "field 'fragmentForListviewListview'", AutoListView.class);
        myPostClickDataFragment.fragmentForListviewParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.fragement_for_listview_parent_layout, "field 'fragmentForListviewParentLayout'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        MyPostClickDataFragment myPostClickDataFragment = this.b;
        if (myPostClickDataFragment != null) {
            this.b = null;
            myPostClickDataFragment.fragmentForListviewListview = null;
            myPostClickDataFragment.fragmentForListviewParentLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
