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
import com.rtk.app.custom.MarkedImageView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpAuditSearchActivity extends BaseActivity {
    private List<String> q = new ArrayList();
    private List<UpAuditSearchFragment> r = new ArrayList();

    @BindView
    TabLayout upAuditSearchTab;

    @BindView
    TextView upAuditSearchTopBack;

    @BindView
    LinearLayout upAuditSearchTopLayout;

    @BindView
    MarkedImageView upAuditSearchTopMyUpLoading;

    @BindView
    EditText upAuditSearchTopSearch;

    @BindView
    ViewPager upAuditSearchViewpager;

    @BindView
    TextView upSrcAuditTopSubmit;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements TextView.OnEditorActionListener {
        a() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            UpAuditSearchActivity.this.L();
            return true;
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.upAuditSearchTopLayout, this.upAuditSearchTab, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L() {
        int i = 0;
        if (this.r.size() == 0) {
            this.q.add("待审核");
            this.q.add("不通过");
            this.q.add("已通过");
            this.q.add("已下架");
            this.q.add("全部");
            int i2 = 0;
            while (i2 < this.q.size()) {
                UpAuditSearchFragment upAuditSearchFragment = new UpAuditSearchFragment();
                Bundle bundle = new Bundle();
                StringBuilder sb = new StringBuilder();
                i2++;
                sb.append(i2 % 5);
                sb.append("");
                bundle.putString("status", sb.toString());
                upAuditSearchFragment.setArguments(bundle);
                this.r.add(upAuditSearchFragment);
            }
            this.b = new com.rtk.app.tool.DownLoadTool.n(this.upAuditSearchTopMyUpLoading);
            com.rtk.app.tool.DownLoadTool.x.c().b(this.b);
            MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this.r, this.q);
            this.upAuditSearchTab.setupWithViewPager(this.upAuditSearchViewpager, true);
            this.upAuditSearchViewpager.setAdapter(myFragmentAdapter);
        }
        String trim = this.upAuditSearchTopSearch.getText().toString().trim();
        if (com.rtk.app.tool.c0.q(trim)) {
            return;
        }
        while (i < this.r.size()) {
            UpAuditSearchFragment upAuditSearchFragment2 = this.r.get(i);
            i++;
            upAuditSearchFragment2.C(trim, i);
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        for (UpAuditSearchFragment upAuditSearchFragment : this.r) {
            com.rtk.app.tool.c0.u("UpAuditSearchActivity", "开始回收");
            upAuditSearchFragment.n();
        }
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.upAuditSearchTopSearch.setOnEditorActionListener(new a());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        com.rtk.app.tool.t.B1(this.upAuditSearchTopSearch, this.f147c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131300709) {
            finish();
        } else {
            if (id != 2131300714) {
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
        setContentView(com.rtk.app.R.layout.activity_up_audit_search);
        ButterKnife.a(this);
    }
}
