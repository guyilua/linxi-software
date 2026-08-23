package com.rtk.app.main;

import android.R;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
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
public class SearchHasPermissionActivity extends BaseActivity {
    private String q;
    private SearchPermissionGameFragment s;

    @BindView
    TextView searchHasPermissionBack;

    @BindView
    ImageView searchHasPermissionSearchBtu;

    @BindView
    EditText searchHasPermissionSearchEdit;

    @BindView
    TabLayout searchHasPermissionTabLayout;

    @BindView
    LinearLayout searchHasPermissionTopLayout;

    @BindView
    BaseViewPager searchHasPermissionViewPager;
    private SearchPermissionPostFragment t;
    private SearchPermissionUserFragment u;
    private SearchPermissionUpFragment v;
    private MyFragmentAdapter y;
    private int r = 1;
    private List<BaseFragment> w = new ArrayList();
    private List<String> x = new ArrayList();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements TextView.OnEditorActionListener {
        a() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            SearchHasPermissionActivity.this.L();
            return true;
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.searchHasPermissionTopLayout, this.searchHasPermissionTabLayout, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L() {
        String trim = this.searchHasPermissionSearchEdit.getText().toString().trim();
        this.q = trim;
        this.s.C(trim);
        if (this.r == 1) {
            this.t.D(this.q);
            this.v.y(this.q);
        }
        this.u.B(this.q);
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        if (this.r == 1) {
            this.t.n();
            this.v.n();
        }
        this.s.n();
        this.u.n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        this.q = extras.getString("searchStr", "");
        this.r = extras.getInt("searchPermission", 1);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.searchHasPermissionSearchEdit.setOnEditorActionListener(new a());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.searchHasPermissionSearchEdit.setText(this.q);
        this.x.add("游戏");
        if (this.r == 1) {
            this.x.add("UP资源");
            this.x.add("帖子");
        }
        this.x.add("用户");
        this.s = new SearchPermissionGameFragment();
        Bundle bundle = new Bundle();
        bundle.putString("searchStr", this.q);
        this.s.setArguments(bundle);
        this.w.add(this.s);
        if (this.r == 1) {
            this.v = new SearchPermissionUpFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putString("searchStr", this.q);
            this.v.setArguments(bundle2);
            this.w.add(this.v);
            this.t = new SearchPermissionPostFragment();
            Bundle bundle3 = new Bundle();
            bundle3.putString("searchStr", this.q);
            this.t.setArguments(bundle3);
            this.w.add(this.t);
        }
        this.u = new SearchPermissionUserFragment();
        Bundle bundle4 = new Bundle();
        bundle4.putString("searchStr", this.q);
        this.u.setArguments(bundle4);
        this.w.add(this.u);
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this.w, this.x);
        this.y = myFragmentAdapter;
        this.searchHasPermissionViewPager.setAdapter(myFragmentAdapter);
        this.searchHasPermissionTabLayout.setupWithViewPager(this.searchHasPermissionViewPager, true);
        this.searchHasPermissionViewPager.setOffscreenPageLimit(4);
        com.rtk.app.tool.c0.u("SearchHasPermissionActivity", "搜索");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131300096) {
            finish();
        } else {
            if (id != 2131300100) {
                return;
            }
            L();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_search_has_permission);
        ButterKnife.a(this);
    }
}
