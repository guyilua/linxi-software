package com.rtk.app.main.UpModule;

import android.R;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.adapter.UpApkListAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.UpApkListBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.main.HomeCommunityPack.SearchHistoryViewHolder;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Level;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpSrcSearchActivity extends BaseActivity implements h.j {

    @BindView
    View history;
    private int q = 1;
    private List<UpApkListBean.DataBean> r = new ArrayList();
    private UpApkListAdapter s;
    private String t;
    private SearchHistoryViewHolder u;

    @BindView
    AutoListView upSrcSearchListview;

    @BindView
    LinearLayout upSrcSearchParent;

    @BindView
    TextView upSrcSearchTopBack;

    @BindView
    LinearLayout upSrcSearchTopLayout;

    @BindView
    EditText upSrcSearchTopSearch;

    @BindView
    TextView upSrcSearchTopSubmit;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            UpSrcSearchActivity.this.t = ((TextView) view).getText().toString();
            UpSrcSearchActivity upSrcSearchActivity = UpSrcSearchActivity.this;
            upSrcSearchActivity.upSrcSearchTopSearch.setText(upSrcSearchActivity.t);
            UpSrcSearchActivity.this.q = 1;
            UpSrcSearchActivity.this.R(1);
            UpSrcSearchActivity.this.u.i();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.rtk.app.tool.c0.u("UpSrcSearchActivity", "弹出search");
            UpSrcSearchActivity.this.upSrcSearchTopSearch.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) UpSrcSearchActivity.this.f147c.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(UpSrcSearchActivity.this.upSrcSearchTopSearch, 0);
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.toString().length() == 0) {
                UpSrcSearchActivity.this.S(true);
                UpSrcSearchActivity.this.u.i();
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
    class d extends com.rtk.app.custom.AutoListView.b {
        d() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            UpSrcSearchActivity upSrcSearchActivity = UpSrcSearchActivity.this;
            com.rtk.app.tool.t.X0(upSrcSearchActivity.f147c, new ApkInfo((UpApkListBean.DataBean) upSrcSearchActivity.r.get(i - 1)));
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class e implements TextView.OnEditorActionListener {
        e() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            UpSrcSearchActivity upSrcSearchActivity = UpSrcSearchActivity.this;
            upSrcSearchActivity.t = upSrcSearchActivity.upSrcSearchTopSearch.getText().toString().trim();
            UpSrcSearchActivity.this.q = 1;
            if (!com.rtk.app.tool.c0.q(UpSrcSearchActivity.this.t)) {
                UpSrcSearchActivity upSrcSearchActivity2 = UpSrcSearchActivity.this;
                upSrcSearchActivity2.G(null, upSrcSearchActivity2.upSrcSearchTopLayout);
                UpSrcSearchActivity.this.R(1);
            } else {
                com.rtk.app.tool.f.a(UpSrcSearchActivity.this.f147c, "请输入搜索内容", f.a.f);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(boolean z) {
        this.upSrcSearchParent.removeView(this.upSrcSearchListview);
        this.upSrcSearchParent.removeView(this.history);
        if (z) {
            this.upSrcSearchParent.addView(this.history);
        } else {
            this.upSrcSearchParent.addView(this.upSrcSearchListview);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U(String[] strArr) {
        R(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W() {
        R(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Y() {
        this.q = 1;
        R(1);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.upSrcSearchTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void R(int... iArr) {
        String str;
        S(false);
        com.rtk.app.tool.t.l1(this.f147c);
        if (this.q == 1) {
            this.u.e(this.t);
            G(null, this.upSrcSearchTopLayout);
        }
        if (iArr[0] != 1) {
            str = "";
        } else {
            str = "up/list" + com.rtk.app.tool.y.u(this.f147c) + "&page=" + this.q + "&limit=10&searchWord=" + this.t + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, new String[0])));
            com.rtk.app.tool.o.h.l(this.f147c, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(str));
        }
        com.rtk.app.tool.c0.u("UpSrcSearchActivity", "up资源搜索:" + com.rtk.app.tool.y.e + str);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        F();
        this.upSrcSearchListview.k();
        com.rtk.app.tool.c0.a("UpSrcSearchActivity", "请求成功   UP列表  " + str, 4, new Level[0]);
        if (i != 1) {
            return;
        }
        UpApkListBean upApkListBean = (UpApkListBean) this.g.fromJson(str, UpApkListBean.class);
        if (upApkListBean.getCode() == 0 && upApkListBean.getData() != null) {
            if (this.q == 1) {
                this.r.clear();
            }
            this.r.addAll(upApkListBean.getData());
            this.s.notifyDataSetChanged();
            this.upSrcSearchListview.setResultSize(upApkListBean.getData().size());
        }
        this.q++;
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        this.s.b();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (this.q == 1) {
            I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.UpModule.h1
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    UpSrcSearchActivity.this.U(strArr);
                }
            });
        }
        this.upSrcSearchListview.f();
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.upSrcSearchTopSearch.addTextChangedListener(new c());
        this.upSrcSearchListview.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.UpModule.f1
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                UpSrcSearchActivity.this.W();
            }
        });
        this.upSrcSearchListview.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.UpModule.g1
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                UpSrcSearchActivity.this.Y();
            }
        });
        this.upSrcSearchListview.setOnItemClickListener(new d());
        this.upSrcSearchTopSearch.setOnEditorActionListener(new e());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.u = new SearchHistoryViewHolder(this.f147c, this.history, com.rtk.app.tool.v.g, new a());
        S(true);
        this.upSrcSearchTopSearch.post(new b());
        UpApkListAdapter upApkListAdapter = new UpApkListAdapter(this.f147c, this.r);
        this.s = upApkListAdapter;
        this.upSrcSearchListview.setAdapter((ListAdapter) upApkListAdapter);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131301049) {
            finish();
            return;
        }
        if (id != 2131301052) {
            return;
        }
        this.q = 1;
        String trim = this.upSrcSearchTopSearch.getText().toString().trim();
        this.t = trim;
        String replaceAll = trim.replaceAll("&", "");
        this.t = replaceAll;
        if (!com.rtk.app.tool.c0.q(replaceAll)) {
            R(1);
        } else {
            com.rtk.app.tool.f.a(this.f147c, "请输入搜索内容", f.a.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_up_src_search);
        ButterKnife.a(this);
    }
}
