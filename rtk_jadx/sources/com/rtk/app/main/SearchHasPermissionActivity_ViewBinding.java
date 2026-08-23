package com.rtk.app.main;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;
import com.rtk.app.custom.BaseViewPager;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SearchHasPermissionActivity_ViewBinding implements Unbinder {
    private SearchHasPermissionActivity b;

    @UiThread
    public SearchHasPermissionActivity_ViewBinding(SearchHasPermissionActivity searchHasPermissionActivity, View view) {
        this.b = searchHasPermissionActivity;
        searchHasPermissionActivity.searchHasPermissionBack = (TextView) butterknife.c.a.c(view, R.id.search_has_permission_back, "field 'searchHasPermissionBack'", TextView.class);
        searchHasPermissionActivity.searchHasPermissionSearchEdit = (EditText) butterknife.c.a.c(view, R.id.search_has_permission_searchEdit, "field 'searchHasPermissionSearchEdit'", EditText.class);
        searchHasPermissionActivity.searchHasPermissionSearchBtu = (ImageView) butterknife.c.a.c(view, R.id.search_has_permission_searchBtu, "field 'searchHasPermissionSearchBtu'", ImageView.class);
        searchHasPermissionActivity.searchHasPermissionTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.search_has_permission_top_layout, "field 'searchHasPermissionTopLayout'", LinearLayout.class);
        searchHasPermissionActivity.searchHasPermissionTabLayout = (TabLayout) butterknife.c.a.c(view, R.id.search_has_permission_tabLayout, "field 'searchHasPermissionTabLayout'", TabLayout.class);
        searchHasPermissionActivity.searchHasPermissionViewPager = (BaseViewPager) butterknife.c.a.c(view, R.id.search_has_permission_viewPager, "field 'searchHasPermissionViewPager'", BaseViewPager.class);
    }

    @CallSuper
    public void a() {
        SearchHasPermissionActivity searchHasPermissionActivity = this.b;
        if (searchHasPermissionActivity != null) {
            this.b = null;
            searchHasPermissionActivity.searchHasPermissionBack = null;
            searchHasPermissionActivity.searchHasPermissionSearchEdit = null;
            searchHasPermissionActivity.searchHasPermissionSearchBtu = null;
            searchHasPermissionActivity.searchHasPermissionTopLayout = null;
            searchHasPermissionActivity.searchHasPermissionTabLayout = null;
            searchHasPermissionActivity.searchHasPermissionViewPager = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
