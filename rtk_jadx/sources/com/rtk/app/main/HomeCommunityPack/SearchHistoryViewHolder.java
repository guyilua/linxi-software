package com.rtk.app.main.HomeCommunityPack;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.adapter.b3;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SearchHistoryViewHolder {
    private View a;
    private Context b;

    /* renamed from: c, reason: collision with root package name */
    private String f199c;
    private AdapterView.OnItemClickListener d;
    private List<String> e = new ArrayList();
    private b3 f;

    @BindView
    ListView searchHistoryListView;

    @BindView
    TextView searchHistoryTabClear;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.rtk.app.tool.v.h(SearchHistoryViewHolder.this.b, SearchHistoryViewHolder.this.f199c, "");
            SearchHistoryViewHolder.this.e.clear();
            SearchHistoryViewHolder.this.f.notifyDataSetChanged();
        }
    }

    public SearchHistoryViewHolder(Context context, View view, String str, AdapterView.OnItemClickListener onItemClickListener) {
        this.a = view;
        this.b = context;
        this.f199c = str;
        this.d = onItemClickListener;
        ButterKnife.b(this, view);
        g();
        h();
    }

    private void g() {
        this.e.clear();
        this.e.addAll(f());
        this.f = new b3(this.e, this.b);
        com.rtk.app.tool.c0.u("SearchHistoryViewHolder", "当前搜索记录适配器尺寸" + this.e.size());
        this.searchHistoryListView.setAdapter((ListAdapter) this.f);
    }

    private void h() {
        this.searchHistoryListView.setOnItemClickListener(this.d);
        this.searchHistoryTabClear.setOnClickListener(new a());
    }

    public void e(String str) {
        String d = com.rtk.app.tool.v.d(this.b, this.f199c);
        List<String> f = f();
        if (!f.contains(str)) {
            com.rtk.app.tool.v.h(this.b, this.f199c, d + "|" + str);
        } else {
            f.remove(str);
            f.add(str);
            String str2 = "";
            for (int i = 0; i < f.size(); i++) {
                str2 = i != f.size() - 1 ? str2 + f.get(i) + "|" : str2 + f.get(i);
            }
            com.rtk.app.tool.v.h(this.b, this.f199c, str2);
        }
        i();
    }

    public List<String> f() {
        return com.rtk.app.tool.c0.d(com.rtk.app.tool.v.d(this.b, this.f199c), "\\|");
    }

    public void i() {
        this.e.clear();
        this.e.addAll(f());
        this.f.notifyDataSetChanged();
    }
}
