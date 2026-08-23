package com.rtk.app.main.UpModule;

import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpGameSelectFragment_ViewBinding implements Unbinder {
    private UpGameSelectFragment b;

    @UiThread
    public UpGameSelectFragment_ViewBinding(UpGameSelectFragment upGameSelectFragment, View view) {
        this.b = upGameSelectFragment;
        upGameSelectFragment.fragmentUpGameSelectSearch = (EditText) butterknife.c.a.c(view, R.id.fragment_up_game_select_search, "field 'fragmentUpGameSelectSearch'", EditText.class);
        upGameSelectFragment.fragmentUpGameSelectSearchBtu = (TextView) butterknife.c.a.c(view, R.id.fragment_up_game_select_search_btu, "field 'fragmentUpGameSelectSearchBtu'", TextView.class);
        upGameSelectFragment.fragmentUpGameSelectListView = (ListView) butterknife.c.a.c(view, R.id.fragment_up_game_select_listView, "field 'fragmentUpGameSelectListView'", ListView.class);
    }

    @CallSuper
    public void a() {
        UpGameSelectFragment upGameSelectFragment = this.b;
        if (upGameSelectFragment != null) {
            this.b = null;
            upGameSelectFragment.fragmentUpGameSelectSearch = null;
            upGameSelectFragment.fragmentUpGameSelectSearchBtu = null;
            upGameSelectFragment.fragmentUpGameSelectListView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
