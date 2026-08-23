package com.rtk.app.main.Home5Activity;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyCollectFragmentForGame_ViewBinding implements Unbinder {
    private MyCollectFragmentForGame b;

    @UiThread
    public MyCollectFragmentForGame_ViewBinding(MyCollectFragmentForGame myCollectFragmentForGame, View view) {
        this.b = myCollectFragmentForGame;
        myCollectFragmentForGame.fragementForListviewListview = (AutoListView) butterknife.c.a.c(view, R.id.fragement_for_listview_listview, "field 'fragementForListviewListview'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        MyCollectFragmentForGame myCollectFragmentForGame = this.b;
        if (myCollectFragmentForGame != null) {
            this.b = null;
            myCollectFragmentForGame.fragementForListviewListview = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
