package com.rtk.app.main.UpModule;

import android.R;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.adapter.MyFragmentAdapter;
import com.rtk.app.base.BaseActivity;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpSearchToMoreTypeActivity extends BaseActivity {

    @BindView
    TabLayout activityUpSearchToMoreTypeTab;

    @BindView
    TextView activityUpSearchToMoreTypeTopBack;

    @BindView
    LinearLayout activityUpSearchToMoreTypeTopLayout;

    @BindView
    EditText activityUpSearchToMoreTypeTopSearch;

    @BindView
    TextView activityUpSearchToMoreTypeTopSubmit;

    @BindView
    ViewPager activityUpSearchToMoreTypeViewpager;
    private List<String> q = new ArrayList();
    private List<UpApkSearchListFragment> r = new ArrayList();
    private List<String> s = new ArrayList();
    protected String t = "";
    private MyFragmentAdapter u;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements TextView.OnEditorActionListener {
        a() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            UpSearchToMoreTypeActivity.this.N();
            return true;
        }
    }

    private void M() {
        for (int i = 0; i < this.r.size(); i++) {
            this.r.get(i).n();
        }
        this.q.clear();
        this.r.clear();
        this.s.clear();
        this.q.add("热度");
        this.q.add("最新");
        this.q.add("热门");
        this.s.add("recommonds");
        this.s.add("new");
        this.s.add("hot");
        for (int i2 = 0; i2 < this.q.size(); i2++) {
            UpApkSearchListFragment upApkSearchListFragment = new UpApkSearchListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("model", this.s.get(i2));
            bundle.putString("searchWord", this.t);
            upApkSearchListFragment.setArguments(bundle);
            this.r.add(upApkSearchListFragment);
        }
        this.u.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        String trim = this.activityUpSearchToMoreTypeTopSearch.getText().toString().trim();
        this.t = trim;
        if (com.rtk.app.tool.c0.q(trim)) {
            com.rtk.app.tool.f.a(this.f147c, "请输入搜索内容", f.a.f);
            return;
        }
        for (int i = 0; i < this.r.size(); i++) {
            this.r.get(i).q = this.t;
            this.r.get(i).p = 1;
            try {
                this.r.get(i).y();
            } catch (Exception e) {
                com.rtk.app.tool.c0.u("UpSearchToMoreTypeActivity", "异常" + e);
            }
        }
        String d = com.rtk.app.tool.v.d(this.f147c, "searchUpHistoryVALUE");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(com.rtk.app.tool.c0.d(d, "\\|\\|"));
        arrayList.remove(this.t);
        arrayList.add(0, this.t);
        com.rtk.app.tool.t.D1(this.f147c, arrayList);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.activityUpSearchToMoreTypeTopLayout, this.activityUpSearchToMoreTypeTab, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        for (int i = 0; i < this.r.size(); i++) {
            this.r.get(i).n();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        String string = getIntent().getExtras().getString("history");
        this.t = string;
        this.activityUpSearchToMoreTypeTopSearch.setText(string);
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this.r, this.q);
        this.u = myFragmentAdapter;
        this.activityUpSearchToMoreTypeViewpager.setAdapter(myFragmentAdapter);
        this.activityUpSearchToMoreTypeTab.setupWithViewPager(this.activityUpSearchToMoreTypeViewpager, true);
        this.activityUpSearchToMoreTypeViewpager.setOffscreenPageLimit(3);
        M();
        com.rtk.app.tool.c0.u("UpSearchToMoreTypeActivity", "  保存的内容  " + com.rtk.app.tool.v.d(this.f147c, "searchUpHistoryVALUE"));
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.activityUpSearchToMoreTypeTopSearch.setOnEditorActionListener(new a());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131296404) {
            finish();
        } else {
            if (id != 2131296407) {
                return;
            }
            N();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_up_search_to_more_type);
        ButterKnife.a(this);
    }
}
