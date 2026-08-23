package com.rtk.app.main.OtherImfomationPack;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class OtherCollectFragmentForGame_ViewBinding implements Unbinder {
    private OtherCollectFragmentForGame b;

    @UiThread
    public OtherCollectFragmentForGame_ViewBinding(OtherCollectFragmentForGame otherCollectFragmentForGame, View view) {
        this.b = otherCollectFragmentForGame;
        otherCollectFragmentForGame.fragementForListviewListview = (AutoListView) butterknife.c.a.c(view, R.id.fragement_for_listview_listview, "field 'fragementForListviewListview'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        OtherCollectFragmentForGame otherCollectFragmentForGame = this.b;
        if (otherCollectFragmentForGame != null) {
            this.b = null;
            otherCollectFragmentForGame.fragementForListviewListview = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
