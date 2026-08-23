package com.rtk.app.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;
import com.rtk.app.custom.MarkedImageView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TagListActivity_ViewBinding implements Unbinder {
    private TagListActivity b;

    @UiThread
    public TagListActivity_ViewBinding(TagListActivity tagListActivity, View view) {
        this.b = tagListActivity;
        tagListActivity.tagListTopTitle = (TextView) butterknife.c.a.c(view, R.id.tag_list_top_title, "field 'tagListTopTitle'", TextView.class);
        tagListActivity.tagListTopDownload = (MarkedImageView) butterknife.c.a.c(view, R.id.tag_list_top_download, "field 'tagListTopDownload'", MarkedImageView.class);
        tagListActivity.tagListTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.tag_list_top_layout, "field 'tagListTopLayout'", LinearLayout.class);
        tagListActivity.tagListViewHelp = (TextView) butterknife.c.a.c(view, R.id.tag_list_view_help, "field 'tagListViewHelp'", TextView.class);
        tagListActivity.tagListTablayout = (TabLayout) butterknife.c.a.c(view, R.id.tag_list_tablayout, "field 'tagListTablayout'", TabLayout.class);
        tagListActivity.tagListViewPager = (ViewPager) butterknife.c.a.c(view, R.id.tag_list_viewPager, "field 'tagListViewPager'", ViewPager.class);
        tagListActivity.tagListTablayoutTabLayout = (LinearLayout) butterknife.c.a.c(view, R.id.tag_list_tablayout_tabLayout, "field 'tagListTablayoutTabLayout'", LinearLayout.class);
        tagListActivity.tagListScreen = (TextView) butterknife.c.a.c(view, R.id.tag_list_screen, "field 'tagListScreen'", TextView.class);
    }

    @CallSuper
    public void a() {
        TagListActivity tagListActivity = this.b;
        if (tagListActivity != null) {
            this.b = null;
            tagListActivity.tagListTopTitle = null;
            tagListActivity.tagListTopDownload = null;
            tagListActivity.tagListTopLayout = null;
            tagListActivity.tagListViewHelp = null;
            tagListActivity.tagListTablayout = null;
            tagListActivity.tagListViewPager = null;
            tagListActivity.tagListTablayoutTabLayout = null;
            tagListActivity.tagListScreen = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
