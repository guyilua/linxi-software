package com.rtk.app.main.Home5Activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.adapter.MyAttentionSearchAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.MyAttentionBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.custom.NoOOMEditText;
import com.rtk.app.msgBean.EventMessage;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyAttentionActivity extends BaseActivity implements h.j {

    @BindView
    AutoListView myAttentionListview;

    @BindView
    TextView myAttentionTopBack;

    @BindView
    LinearLayout myAttentionTopLayout;
    ViewHolder q;
    private List<MyAttentionBean.DataBean> r;
    private String t;
    private MyAttentionSearchAdapter u;
    private int s = 1;
    private String v = "";
    private boolean w = false;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ViewHolder {

        @BindView
        NoOOMEditText noOOMEditText;

        ViewHolder(View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.noOOMEditText = (NoOOMEditText) butterknife.c.a.c(view, R.id.add_attention_edv, "field 'noOOMEditText'", NoOOMEditText.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
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
            int headerViewsCount = MyAttentionActivity.this.myAttentionListview.getHeaderViewsCount();
            MyAttentionActivity myAttentionActivity = MyAttentionActivity.this;
            com.rtk.app.tool.t.B0(myAttentionActivity.f147c, ((MyAttentionBean.DataBean) myAttentionActivity.r.get(i - headerViewsCount)).getFans());
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            MyAttentionActivity.this.v = editable.toString().replaceAll("&", "").trim();
            MyAttentionActivity.this.s = 1;
            MyAttentionActivity.this.O(1);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q(String[] strArr) {
        O(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S() {
        this.s = 1;
        O(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U() {
        O(1);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.myAttentionTopLayout, null, null, null);
    }

    public void O(int... iArr) {
        String sb;
        if (iArr[0] != 1) {
            sb = "";
        } else if (TextUtils.isEmpty(this.v)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/followsList");
            sb2.append(com.rtk.app.tool.y.u(this.f147c));
            sb2.append("&uid=");
            sb2.append(this.t);
            sb2.append("&page=");
            sb2.append(this.s);
            sb2.append("&limit=");
            sb2.append(this.myAttentionListview.getPageSize());
            sb2.append("&fans=");
            sb2.append(com.rtk.app.tool.y.K());
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uid=" + this.t, "fans=" + com.rtk.app.tool.y.K()))));
            sb = sb2.toString();
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("members/userSearch");
            sb3.append(com.rtk.app.tool.y.u(this.f147c));
            sb3.append("&uname=");
            sb3.append(this.v);
            sb3.append("&page=");
            sb3.append(this.s);
            sb3.append("&issub=1&limit=");
            sb3.append(this.myAttentionListview.getPageSize());
            sb3.append("&uid=");
            sb3.append(com.rtk.app.tool.y.K());
            sb3.append("&key=");
            sb3.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uname=" + this.v))));
            sb = sb3.toString();
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(sb));
        com.rtk.app.tool.c0.u("MyAttentionActivity", "我的关注" + com.rtk.app.tool.y.d + sb);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        F();
        this.myAttentionListview.k();
        com.rtk.app.tool.c0.u("MyAttentionActivity", i + "  我的关注列表  " + str);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        MyAttentionBean myAttentionBean = (MyAttentionBean) create.fromJson(str, MyAttentionBean.class);
        if (this.s == 1) {
            this.r.clear();
        }
        this.r.addAll(myAttentionBean.getData());
        this.u.notifyDataSetChanged();
        this.myAttentionListview.setResultSize(myAttentionBean.getData().size());
        this.s++;
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        MyAttentionSearchAdapter myAttentionSearchAdapter = this.u;
        if (myAttentionSearchAdapter != null) {
            myAttentionSearchAdapter.b();
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (this.s == 1) {
            I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.Home5Activity.d0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    MyAttentionActivity.this.Q(strArr);
                }
            });
        }
        this.myAttentionListview.f();
        com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        this.t = getIntent().getExtras().getString("uid");
        this.r = new ArrayList();
        this.myAttentionListview.setPageSize(20);
        O(1);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.myAttentionListview.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.Home5Activity.b0
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                MyAttentionActivity.this.S();
            }
        });
        this.myAttentionListview.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.Home5Activity.c0
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                MyAttentionActivity.this.U();
            }
        });
        this.myAttentionListview.setOnItemClickListener(new a());
        this.q.noOOMEditText.addTextChangedListener(new b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initView() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.search_head, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        this.q = viewHolder;
        viewHolder.noOOMEditText.setBackgroundResource(R.drawable.shape_line_border_white_silid_5dp);
        this.myAttentionListview.addHeaderView(inflate);
        MyAttentionSearchAdapter myAttentionSearchAdapter = new MyAttentionSearchAdapter(this.f147c, this.r);
        this.u = myAttentionSearchAdapter;
        this.myAttentionListview.setAdapter((ListAdapter) myAttentionSearchAdapter);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131299406) {
            com.rtk.app.tool.c.b(this.f147c, AddAttentionActivity.class, null);
        } else {
            if (id != 2131299408) {
                return;
            }
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_my_attention_post);
        ButterKnife.a(this);
        G(null, this.myAttentionTopLayout);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.w) {
            org.greenrobot.eventbus.c.c().q(this);
            this.w = false;
        }
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onReceiveMsg(EventMessage eventMessage) {
        MyAttentionBean.DataBean dataBean = null;
        int i = 0;
        while (true) {
            if (i >= this.r.size()) {
                i = -1;
                break;
            }
            dataBean = this.r.get(i);
            if (TextUtils.equals(dataBean.getFans(), eventMessage.uid)) {
                break;
            } else {
                i++;
            }
        }
        if (dataBean == null || i == -1) {
            return;
        }
        this.r.get(i).setNotename(eventMessage.mark);
        com.rtk.app.tool.b0.b.b().e(Integer.parseInt(this.r.get(i).getFans()), Integer.parseInt(dataBean.getFollowed()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onStart() {
        super.onStart();
        if (this.w) {
            return;
        }
        org.greenrobot.eventbus.c.c().o(this);
        this.w = true;
    }
}
