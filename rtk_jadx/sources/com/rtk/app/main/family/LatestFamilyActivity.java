package com.rtk.app.main.family;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.bean.FamilyInfoBean;
import com.rtk.app.bean.FamilyListBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.custom.NoOOMEditText;
import com.rtk.app.main.family.HotFamilyActivity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class LatestFamilyActivity extends FamilyBaseActivity {

    @BindView
    View applyJoinList;

    @BindView
    AutoListView autoListView;

    @BindView
    View backLayout;
    HotFamilyActivity.ViewHolder r;
    FamilyListAdapter t;
    private String v;
    List<FamilyInfoBean.DataBean> s = new ArrayList();
    private int u = 1;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ViewHolder {

        @BindView
        NoOOMEditText noOOMEditText;
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            viewHolder.noOOMEditText = (NoOOMEditText) butterknife.c.a.c(view, R.id.add_attention_edv, "field 'noOOMEditText'", NoOOMEditText.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                viewHolder.noOOMEditText = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            Intent intent = new Intent((Context) LatestFamilyActivity.this, (Class<?>) FamilyInfoActivity.class);
            LatestFamilyActivity latestFamilyActivity = LatestFamilyActivity.this;
            intent.putExtra("family_id", latestFamilyActivity.s.get(i - latestFamilyActivity.autoListView.getHeaderViewsCount()).getFamily_id());
            LatestFamilyActivity.this.startActivity(intent);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            LatestFamilyActivity.this.v = editable.toString().replaceAll("&", "").trim();
            LatestFamilyActivity.this.u = 1;
            LatestFamilyActivity.this.P(new int[0]);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R(String[] strArr) {
        P(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T() {
        this.u = 1;
        P(1);
        this.autoListView.setLoadEnable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V() {
        P(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void P(int... iArr) {
        String sb;
        if (TextUtils.isEmpty(this.v)) {
            sb = "family/list" + com.rtk.app.tool.y.u(this) + "&page=" + this.u + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this, new String[0])));
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("family/search");
            sb2.append(com.rtk.app.tool.y.u(this));
            sb2.append("&keyword=");
            sb2.append(this.v);
            sb2.append("&page=");
            sb2.append(this.u);
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this, "keyword=" + this.v))));
            sb = sb2.toString();
        }
        com.rtk.app.tool.o.h.l(this, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb));
        com.rtk.app.tool.c0.u("latestFamilyActivity", "url:" + com.rtk.app.tool.y.e + sb);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        F();
        this.autoListView.k();
        FamilyListBean familyListBean = (FamilyListBean) this.g.fromJson(str, FamilyListBean.class);
        com.rtk.app.tool.c0.r("latestFamilyActivity", "onSuccess,str=" + familyListBean);
        if (this.u == 1) {
            this.s.clear();
        }
        List<FamilyInfoBean.DataBean> data = familyListBean.getData();
        this.s.addAll(data);
        this.t.notifyDataSetChanged();
        this.autoListView.setResultSize(data.size());
        this.u++;
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        FamilyListAdapter familyListAdapter = this.t;
        if (familyListAdapter != null) {
            familyListAdapter.b();
        }
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.r("latestFamilyActivity", "onError,str=" + str + ",code=" + i);
        if (this.u == 1) {
            I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.family.l0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    LatestFamilyActivity.this.R(strArr);
                }
            });
        }
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initData() {
        P(1);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initListener() {
        this.autoListView.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.family.k0
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                LatestFamilyActivity.this.T();
            }
        });
        this.autoListView.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.family.j0
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                LatestFamilyActivity.this.V();
            }
        });
        this.autoListView.setOnItemClickListener(new a());
        this.r.noOOMEditText.addTextChangedListener(new b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initView() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.search_head, (ViewGroup) null);
        this.r = new HotFamilyActivity.ViewHolder(inflate);
        this.autoListView.addHeaderView(inflate);
        FamilyListAdapter familyListAdapter = new FamilyListAdapter(this, this.s);
        this.t = familyListAdapter;
        this.autoListView.setAdapter((ListAdapter) familyListAdapter);
        this.r.noOOMEditText.setBackgroundResource(R.drawable.shape_line_border_white_silid_5dp);
        this.r.noOOMEditText.setHint("搜索家族名称");
        this.applyJoinList.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131296522) {
            return;
        }
        if (com.rtk.app.tool.y.x(this)) {
            com.rtk.app.tool.c.b(this, MyApplyFamilyListActivity.class, null);
        } else {
            com.rtk.app.tool.t.w0(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_latest_family);
        ButterKnife.a(this);
        G(null, this.backLayout);
    }
}
