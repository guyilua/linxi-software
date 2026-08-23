package com.rtk.app.main.family;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.NoOOMEditText;
import com.rtk.app.custom.YcRecyclerView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyPostSearchActivity_ViewBinding implements Unbinder {
    private FamilyPostSearchActivity b;

    @UiThread
    public FamilyPostSearchActivity_ViewBinding(FamilyPostSearchActivity familyPostSearchActivity, View view) {
        this.b = familyPostSearchActivity;
        familyPostSearchActivity.fragmentForRecyclerviewLayoutListView = (YcRecyclerView) butterknife.c.a.c(view, R.id.fragment_for_recyclerview_layout_listView, "field 'fragmentForRecyclerviewLayoutListView'", YcRecyclerView.class);
        familyPostSearchActivity.fragmentForRecyclerviewParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.fragment_for_recyclerview_parent_layout, "field 'fragmentForRecyclerviewParentLayout'", LinearLayout.class);
        familyPostSearchActivity.fragmentMyGoldLayoutSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.fragment_my_gold_layout_swipeRefresh, "field 'fragmentMyGoldLayoutSwipeRefresh'", SwipeRefreshLayout.class);
        familyPostSearchActivity.noOOMEditText = (NoOOMEditText) butterknife.c.a.c(view, R.id.add_attention_edv, "field 'noOOMEditText'", NoOOMEditText.class);
    }

    @CallSuper
    public void a() {
        FamilyPostSearchActivity familyPostSearchActivity = this.b;
        if (familyPostSearchActivity != null) {
            this.b = null;
            familyPostSearchActivity.fragmentForRecyclerviewLayoutListView = null;
            familyPostSearchActivity.fragmentForRecyclerviewParentLayout = null;
            familyPostSearchActivity.fragmentMyGoldLayoutSwipeRefresh = null;
            familyPostSearchActivity.noOOMEditText = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
