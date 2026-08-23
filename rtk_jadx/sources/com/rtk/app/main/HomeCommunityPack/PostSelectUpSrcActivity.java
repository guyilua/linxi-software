package com.rtk.app.main.HomeCommunityPack;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.adapter.PostUpSrcSelectAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.UpApkListBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Level;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostSelectUpSrcActivity extends BaseActivity implements h.j {

    @BindView
    AutoListView postSelectUpSrcListView;

    @BindView
    TextView postSelectUpSrcSearchBtu;

    @BindView
    EditText postSelectUpSrcSearchEdit;

    @BindView
    TextView postSelectUpSrcTips;

    @BindView
    TextView postSelectUpSrcTopBack;

    @BindView
    LinearLayout postSelectUpSrcTopLayout;
    private String r;
    private PostUpSrcSelectAdapter t;
    private int q = 1;
    private List<UpApkListBean.DataBean> s = new ArrayList();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements AutoListView.c {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            PostSelectUpSrcActivity.this.q = 1;
            PostSelectUpSrcActivity postSelectUpSrcActivity = PostSelectUpSrcActivity.this;
            postSelectUpSrcActivity.r = postSelectUpSrcActivity.postSelectUpSrcSearchEdit.getText().toString().trim();
            PostSelectUpSrcActivity postSelectUpSrcActivity2 = PostSelectUpSrcActivity.this;
            postSelectUpSrcActivity2.postSelectUpSrcTips.setVisibility(com.rtk.app.tool.c0.q(postSelectUpSrcActivity2.r) ? 0 : 8);
            if (com.rtk.app.tool.c0.q(PostSelectUpSrcActivity.this.r)) {
                PostSelectUpSrcActivity.this.P(1);
            } else {
                PostSelectUpSrcActivity.this.P(2);
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.b {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.b
        public void a() {
            PostSelectUpSrcActivity postSelectUpSrcActivity = PostSelectUpSrcActivity.this;
            postSelectUpSrcActivity.postSelectUpSrcTips.setVisibility(com.rtk.app.tool.c0.q(postSelectUpSrcActivity.r) ? 0 : 8);
            if (com.rtk.app.tool.c0.q(PostSelectUpSrcActivity.this.r)) {
                PostSelectUpSrcActivity.this.P(1);
            } else {
                PostSelectUpSrcActivity.this.P(2);
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c extends com.rtk.app.custom.AutoListView.b {
        c() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("upSrc", new ApkInfo((UpApkListBean.DataBean) PostSelectUpSrcActivity.this.s.get(i - 1)));
            intent.putExtras(bundle);
            PostSelectUpSrcActivity.this.setResult(1002, intent);
            PostSelectUpSrcActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R(String[] strArr) {
        if (com.rtk.app.tool.c0.q(this.r)) {
            P(1);
        } else {
            P(2);
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.postSelectUpSrcTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void P(int... iArr) {
        if (this.q == 1) {
            G(null, this.postSelectUpSrcTopLayout);
        }
        int i = iArr[0];
        String str = "";
        if (i == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("members/mySourceList");
            sb.append(com.rtk.app.tool.y.u(this.f147c));
            sb.append("&uid=");
            sb.append(com.rtk.app.tool.y.K());
            sb.append("&token=");
            sb.append(com.rtk.app.tool.y.H());
            sb.append("&page=");
            sb.append(this.q);
            sb.append("&limit=10&issub=1&key=");
            sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
            str = sb.toString();
        } else if (i == 2) {
            String K = com.rtk.app.tool.y.K();
            String H = com.rtk.app.tool.y.H();
            if (!com.rtk.app.tool.c0.q(K) && !com.rtk.app.tool.c0.q(H)) {
                str = "&uid=" + K + "&token=" + H;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("up/search");
            sb2.append(com.rtk.app.tool.y.u(this.f147c));
            sb2.append("&model=new&page=");
            sb2.append(this.q);
            sb2.append("&search_words=");
            sb2.append(this.r);
            sb2.append(str);
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "model=new", "search_words=" + this.r))));
            com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb2.toString()));
            return;
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(str));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        F();
        this.postSelectUpSrcListView.k();
        com.rtk.app.tool.c0.a("PostSelectUpSrcActivity", "请求成功   选择UP资源列表  " + com.rtk.app.c.a.b(str), 4, new Level[0]);
        if (i == 1 || i == 2) {
            UpApkListBean upApkListBean = (UpApkListBean) this.g.fromJson(str, UpApkListBean.class);
            if (upApkListBean.getCode() != 0 || upApkListBean.getData() == null) {
                return;
            }
            if (this.q == 1) {
                this.s.clear();
            }
            this.q++;
            this.s.addAll(upApkListBean.getData());
            this.t.notifyDataSetChanged();
            this.postSelectUpSrcListView.setResultSize(upApkListBean.getData().size());
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (this.q == 1) {
            I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.HomeCommunityPack.f0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    PostSelectUpSrcActivity.this.R(strArr);
                }
            });
        }
        this.postSelectUpSrcListView.f();
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.postSelectUpSrcListView.setOnRefreshListener(new a());
        this.postSelectUpSrcListView.setOnLoadListener(new b());
        this.postSelectUpSrcListView.setOnItemClickListener(new c());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        PostUpSrcSelectAdapter postUpSrcSelectAdapter = new PostUpSrcSelectAdapter(this.f147c, this.s);
        this.t = postUpSrcSelectAdapter;
        this.postSelectUpSrcListView.setAdapter((ListAdapter) postUpSrcSelectAdapter);
        P(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != 2131299907) {
            if (id == 2131299910) {
                finish();
                return;
            } else {
                if (id != 2131299912) {
                    return;
                }
                com.rtk.app.tool.t.e2(this.f147c, view);
                return;
            }
        }
        String trim = this.postSelectUpSrcSearchEdit.getText().toString().trim();
        this.r = trim;
        this.postSelectUpSrcTips.setVisibility(com.rtk.app.tool.c0.q(trim) ? 0 : 8);
        this.q = 1;
        this.postSelectUpSrcListView.setVisibility(0);
        if (com.rtk.app.tool.c0.q(this.r)) {
            com.rtk.app.tool.f.a(this.f147c, "请输入搜索内容", f.a.f);
        } else {
            P(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_post_select_up_src);
        ButterKnife.a(this);
    }
}
