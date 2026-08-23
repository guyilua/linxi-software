package com.rtk.app.main.Home5Activity;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyCollectFragmentForUp_ViewBinding implements Unbinder {
    private MyCollectFragmentForUp b;

    @UiThread
    public MyCollectFragmentForUp_ViewBinding(MyCollectFragmentForUp myCollectFragmentForUp, View view) {
        this.b = myCollectFragmentForUp;
        myCollectFragmentForUp.fragementForListviewListview = (AutoListView) butterknife.c.a.c(view, R.id.fragement_for_listview_listview, "field 'fragementForListviewListview'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        MyCollectFragmentForUp myCollectFragmentForUp = this.b;
        if (myCollectFragmentForUp != null) {
            this.b = null;
            myCollectFragmentForUp.fragementForListviewListview = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
