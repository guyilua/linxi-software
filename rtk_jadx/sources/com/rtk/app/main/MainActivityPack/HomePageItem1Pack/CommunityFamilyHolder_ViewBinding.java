package com.rtk.app.main.MainActivityPack.HomePageItem1Pack;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CommunityFamilyHolder_ViewBinding implements Unbinder {
    private CommunityFamilyHolder b;

    @UiThread
    public CommunityFamilyHolder_ViewBinding(CommunityFamilyHolder communityFamilyHolder, View view) {
        this.b = communityFamilyHolder;
        communityFamilyHolder.myFamily = (ImageView) butterknife.c.a.c(view, R.id.my_family, "field 'myFamily'", ImageView.class);
        communityFamilyHolder.searchFamily = (ImageView) butterknife.c.a.c(view, R.id.search_family, "field 'searchFamily'", ImageView.class);
        communityFamilyHolder.newFamily = (ImageView) butterknife.c.a.c(view, R.id.new_family, "field 'newFamily'", ImageView.class);
        communityFamilyHolder.hotFamily = (ImageView) butterknife.c.a.c(view, R.id.hot_family, "field 'hotFamily'", ImageView.class);
        communityFamilyHolder.createFamily = (TextView) butterknife.c.a.c(view, R.id.create_family, "field 'createFamily'", TextView.class);
    }

    @CallSuper
    public void a() {
        CommunityFamilyHolder communityFamilyHolder = this.b;
        if (communityFamilyHolder != null) {
            this.b = null;
            communityFamilyHolder.myFamily = null;
            communityFamilyHolder.searchFamily = null;
            communityFamilyHolder.newFamily = null;
            communityFamilyHolder.hotFamily = null;
            communityFamilyHolder.createFamily = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
