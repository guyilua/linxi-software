package com.rtk.app.main.HomeCommunityPack;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SearchHistoryViewHolder_ViewBinding implements Unbinder {
    private SearchHistoryViewHolder b;

    @UiThread
    public SearchHistoryViewHolder_ViewBinding(SearchHistoryViewHolder searchHistoryViewHolder, View view) {
        this.b = searchHistoryViewHolder;
        searchHistoryViewHolder.searchHistoryListView = (ListView) butterknife.c.a.c(view, R.id.search_history_listView, "field 'searchHistoryListView'", ListView.class);
        searchHistoryViewHolder.searchHistoryTabClear = (TextView) butterknife.c.a.c(view, R.id.search_history_clear, "field 'searchHistoryTabClear'", TextView.class);
    }

    @CallSuper
    public void a() {
        SearchHistoryViewHolder searchHistoryViewHolder = this.b;
        if (searchHistoryViewHolder != null) {
            this.b = null;
            searchHistoryViewHolder.searchHistoryListView = null;
            searchHistoryViewHolder.searchHistoryTabClear = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
