package com.rtk.app.main;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.zhy.view.flowlayout.TagFlowLayout;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SearchActivity_ViewBinding implements Unbinder {
    private SearchActivity b;

    @UiThread
    public SearchActivity_ViewBinding(SearchActivity searchActivity, View view) {
        this.b = searchActivity;
        searchActivity.searchTopTitle = (TextView) butterknife.c.a.c(view, R.id.search_top_title, "field 'searchTopTitle'", TextView.class);
        searchActivity.searchEdt = (EditText) butterknife.c.a.c(view, R.id.search_edt, "field 'searchEdt'", EditText.class);
        searchActivity.tagListTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.tag_list_top_layout, "field 'tagListTopLayout'", LinearLayout.class);
        searchActivity.searchListView = (AutoListView) butterknife.c.a.c(view, R.id.search_listView, "field 'searchListView'", AutoListView.class);
        searchActivity.searchBtu = (TextView) butterknife.c.a.c(view, R.id.search_Btu, "field 'searchBtu'", TextView.class);
        searchActivity.searchFlowlayout = (TagFlowLayout) butterknife.c.a.c(view, R.id.search_flowlayout, "field 'searchFlowlayout'", TagFlowLayout.class);
        searchActivity.searchClear = (TextView) butterknife.c.a.c(view, R.id.search_clear, "field 'searchClear'", TextView.class);
        searchActivity.searchHistory = (LinearLayout) butterknife.c.a.c(view, R.id.search_history, "field 'searchHistory'", LinearLayout.class);
        searchActivity.searchListViewEmpty = (LinearLayout) butterknife.c.a.c(view, R.id.search_listView_empty, "field 'searchListViewEmpty'", LinearLayout.class);
        searchActivity.searchHotFlowlayout = (TagFlowLayout) butterknife.c.a.c(view, R.id.search_hot_flowlayout, "field 'searchHotFlowlayout'", TagFlowLayout.class);
        searchActivity.hotSearchLayout = (LinearLayout) butterknife.c.a.c(view, R.id.hot_search_layout, "field 'hotSearchLayout'", LinearLayout.class);
        searchActivity.searchFlowlayoutTitle = (LinearLayout) butterknife.c.a.c(view, R.id.search_flowlayout_title, "field 'searchFlowlayoutTitle'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        SearchActivity searchActivity = this.b;
        if (searchActivity != null) {
            this.b = null;
            searchActivity.searchTopTitle = null;
            searchActivity.searchEdt = null;
            searchActivity.tagListTopLayout = null;
            searchActivity.searchListView = null;
            searchActivity.searchBtu = null;
            searchActivity.searchFlowlayout = null;
            searchActivity.searchClear = null;
            searchActivity.searchHistory = null;
            searchActivity.searchListViewEmpty = null;
            searchActivity.searchHotFlowlayout = null;
            searchActivity.hotSearchLayout = null;
            searchActivity.searchFlowlayoutTitle = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
