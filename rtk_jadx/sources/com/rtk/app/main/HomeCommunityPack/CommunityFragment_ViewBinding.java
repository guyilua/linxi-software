package com.rtk.app.main.HomeCommunityPack;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.YcRecyclerView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CommunityFragment_ViewBinding implements Unbinder {
    private CommunityFragment b;

    @UiThread
    public CommunityFragment_ViewBinding(CommunityFragment communityFragment, View view) {
        this.b = communityFragment;
        communityFragment.communityFragmentRecycler = (YcRecyclerView) butterknife.c.a.c(view, R.id.community_fragment_recycler, "field 'communityFragmentRecycler'", YcRecyclerView.class);
    }

    @CallSuper
    public void a() {
        CommunityFragment communityFragment = this.b;
        if (communityFragment != null) {
            this.b = null;
            communityFragment.communityFragmentRecycler = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
