package com.rtk.app.main.HomeCommunityPack;

import android.R;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.adapter.MyFragmentAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.custom.BaseViewPager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SearchPostOrUserActivity extends BaseActivity {
    private SearchPostFragment q;
    private SearchUserFragment r;
    private List<BaseFragment> s;

    @BindView
    TextView searchPostOrUserBack;

    @BindView
    ImageView searchPostOrUserSearchBtu;

    @BindView
    EditText searchPostOrUserSearchEdit;

    @BindView
    TabLayout searchPostOrUserTabLayout;

    @BindView
    LinearLayout searchPostOrUserTopLayout;

    @BindView
    BaseViewPager searchPostOrUserViewPager;
    private List<String> t;
    private MyFragmentAdapter u;
    public String v;
    private String w;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchPostOrUserActivity.this.searchPostOrUserSearchEdit.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) SearchPostOrUserActivity.this.f147c.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(SearchPostOrUserActivity.this.searchPostOrUserSearchEdit, 0);
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.toString().length() == 0) {
                SearchPostOrUserActivity.this.v = editable.toString();
                SearchPostOrUserActivity.this.q.F(true);
                SearchPostOrUserActivity.this.r.C(true);
                SearchPostOrUserActivity.this.q.G("");
                SearchPostOrUserActivity.this.r.D("");
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements TextView.OnEditorActionListener {
        c() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            SearchPostOrUserActivity.this.O();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        this.v = this.searchPostOrUserSearchEdit.getText().toString().trim();
        String d = com.rtk.app.tool.v.d(this.f147c, com.rtk.app.tool.v.e);
        if (!com.rtk.app.tool.c0.d(d, "\\|").contains(this.v)) {
            com.rtk.app.tool.v.h(this.f147c, com.rtk.app.tool.v.e, d + "|" + this.v);
        }
        com.rtk.app.tool.c0.u("SearchPostOrUserActivity", "当前所保存的搜索记录" + d);
        this.q.D(this.v);
        this.r.B(this.v);
        com.rtk.app.tool.t.l1(this.f147c);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.searchPostOrUserTopLayout, this.searchPostOrUserTabLayout, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void P(String str) {
        this.v = str;
        this.searchPostOrUserSearchEdit.setText(str);
        this.q.D(str);
        this.r.B(str);
        com.rtk.app.tool.t.l1(this.f147c);
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        for (int i = 0; i < this.s.size(); i++) {
            this.s.get(i).n();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        this.w = getIntent().getExtras().getString("mid", null);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.searchPostOrUserSearchEdit.addTextChangedListener(new b());
        this.searchPostOrUserSearchEdit.setOnEditorActionListener(new c());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.searchPostOrUserSearchEdit.post(new a());
        this.q = new SearchPostFragment();
        this.r = new SearchUserFragment();
        ArrayList arrayList = new ArrayList();
        this.s = arrayList;
        arrayList.add(this.q);
        this.s.add(this.r);
        ArrayList arrayList2 = new ArrayList();
        this.t = arrayList2;
        arrayList2.add("帖子");
        this.t.add("用户");
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this.s, this.t);
        this.u = myFragmentAdapter;
        this.searchPostOrUserViewPager.setAdapter(myFragmentAdapter);
        this.searchPostOrUserTabLayout.setupWithViewPager(this.searchPostOrUserViewPager, true);
        this.q.E(this.w);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.rtk.app.R.id.search_post_or_user_back /* 2131300119 */:
                finish();
                return;
            case com.rtk.app.R.id.search_post_or_user_searchBtu /* 2131300120 */:
                O();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_search_post_or_user);
        ButterKnife.a(this);
    }
}
