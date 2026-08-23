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
import com.google.gson.GsonBuilder;
import com.rtk.app.adapter.PostGameListAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.DataBean;
import com.rtk.app.bean.GameListBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostSelectGameActivity extends BaseActivity implements h.j {

    @BindView
    TextView postSelectGameBack;

    @BindView
    AutoListView postSelectGameListView;

    @BindView
    TextView postSelectGameSearchBtu;

    @BindView
    EditText postSelectGameSearchEdit;

    @BindView
    TextView postSelectGameTips;

    @BindView
    LinearLayout postSelectGameTopLayout;
    private String q;
    private int r = 1;
    private PostGameListAdapter s;
    private List<DataBean> t;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements AutoListView.c {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            PostSelectGameActivity.this.r = 1;
            if (com.rtk.app.tool.c0.q(PostSelectGameActivity.this.q)) {
                PostSelectGameActivity.this.O(1);
            } else {
                PostSelectGameActivity.this.O(1);
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.b {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.b
        public void a() {
            if (com.rtk.app.tool.c0.q(PostSelectGameActivity.this.q)) {
                PostSelectGameActivity.this.O(1);
            } else {
                PostSelectGameActivity.this.O(1);
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements AdapterView.OnItemClickListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("game", new ApkInfo((DataBean) PostSelectGameActivity.this.t.get(i - 1)));
            intent.putExtras(bundle);
            PostSelectGameActivity.this.setResult(1001, intent);
            PostSelectGameActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q(String[] strArr) {
        O(1);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.postSelectGameTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void O(int... iArr) {
        String sb;
        if (this.r == 1) {
            G(null, this.postSelectGameTopLayout);
        }
        int I = com.rtk.app.tool.y.I(this.f147c);
        if (com.rtk.app.tool.c0.q(this.q)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("member/collectList");
            sb2.append(com.rtk.app.tool.y.u(this.f147c));
            sb2.append("&uid=");
            sb2.append(I);
            sb2.append("&page=");
            sb2.append(this.r);
            sb2.append("&token=");
            sb2.append(com.rtk.app.tool.y.G(this.f147c));
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uid=" + I))));
            sb = sb2.toString();
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("game/gamelist");
            sb3.append(com.rtk.app.tool.y.u(this.f147c));
            sb3.append("&games_type=");
            sb3.append(com.rtk.app.tool.y.t(this.f147c));
            sb3.append("&search_words=");
            sb3.append(this.q);
            sb3.append("&page=");
            sb3.append(this.r);
            sb3.append("&key=");
            sb3.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "games_type=" + com.rtk.app.tool.y.t(this.f147c)))));
            sb = sb3.toString();
            this.postSelectGameTips.setVisibility(8);
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(sb));
        com.rtk.app.tool.c0.u("PostSelectGameActivity", "插入游戏搜索" + sb);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        F();
        this.postSelectGameListView.k();
        GameListBean gameListBean = (GameListBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, GameListBean.class);
        if (gameListBean.getCode() != 0 || gameListBean.getData() == null) {
            return;
        }
        if (this.r == 1) {
            this.t.clear();
        }
        this.r++;
        this.t.addAll(gameListBean.getData());
        this.s.notifyDataSetChanged();
        this.postSelectGameListView.setResultSize(gameListBean.getData().size());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.postSelectGameListView.f();
        if (this.r == 1) {
            I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.HomeCommunityPack.a0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    PostSelectGameActivity.this.Q(strArr);
                }
            });
        }
        com.rtk.app.tool.f.a(this.f147c, str, i2);
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        this.t = new ArrayList();
        PostGameListAdapter postGameListAdapter = new PostGameListAdapter(this.f147c, this.t);
        this.s = postGameListAdapter;
        this.postSelectGameListView.setAdapter((ListAdapter) postGameListAdapter);
        O(1);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.postSelectGameListView.setOnRefreshListener(new a());
        this.postSelectGameListView.setOnLoadListener(new b());
        this.postSelectGameListView.setOnItemClickListener(new c());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131299893) {
            com.rtk.app.tool.c.a(this.f147c);
        } else {
            if (id != 2131299895) {
                return;
            }
            this.t.clear();
            this.q = this.postSelectGameSearchEdit.getText().toString().trim();
            this.r = 1;
            O(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_post_select_game);
        ButterKnife.a(this);
    }
}
