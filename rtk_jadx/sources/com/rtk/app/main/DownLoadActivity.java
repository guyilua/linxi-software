package com.rtk.app.main;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.adapter.DownLoadAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.tool.ApkInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DownLoadActivity extends BaseActivity {

    @BindView
    TextView downLoadBackBackTV;

    @BindView
    LinearLayout downLoadBackLayout;

    @BindView
    TextView downLoadDeleteAll;

    @BindView
    ListView downLoadList;
    private Context q;
    private DownLoadAdapter r;
    private List<com.rtk.app.tool.DownLoadTool.p> s = new ArrayList();
    private Handler t = new a();
    private TextView u;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                DownLoadActivity.this.s.clear();
                DownLoadActivity.this.s.addAll(com.rtk.app.tool.g.c.e(DownLoadActivity.this.q).c(com.rtk.app.tool.DownLoadTool.q.b, com.rtk.app.tool.DownLoadTool.q.f));
                DownLoadActivity.this.r.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b extends com.rtk.app.custom.AutoListView.b {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            ApkInfo apkInfo = new ApkInfo((com.rtk.app.tool.DownLoadTool.p) DownLoadActivity.this.s.get((DownLoadActivity.this.s.size() - i) - 1));
            if (apkInfo.getGameId() <= 10000000) {
                com.rtk.app.tool.t.e0(DownLoadActivity.this.q, apkInfo);
            } else {
                com.rtk.app.tool.t.X0(DownLoadActivity.this.f147c, apkInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(View view) {
        com.rtk.app.tool.c.b((Activity) this.q, SearchActivity.class, null);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean R(AdapterView adapterView, View view, int i, long j) {
        new com.rtk.app.main.dialogPack.p(this.q, this.s.get((this.s.size() - i) - 1), this.t, 0, new List[0]).show();
        return true;
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.q, this.downLoadBackLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        this.r.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int i = extras.getInt("openPage", 0);
            int i2 = extras.getInt("gameId", 0);
            com.rtk.app.tool.c0.u("DownLoadActivity", "我被执行了initData" + i2);
            if (i == 2) {
                com.rtk.app.tool.p.a(this.f147c).d(i2);
            }
        }
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.u.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.main.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownLoadActivity.this.P(view);
            }
        });
        this.downLoadList.setOnItemClickListener(new b());
        this.downLoadList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.rtk.app.main.i
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
                return DownLoadActivity.this.R(adapterView, view, i, j);
            }
        });
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.s.addAll(com.rtk.app.tool.g.c.e(this.q).c(com.rtk.app.tool.DownLoadTool.q.b, com.rtk.app.tool.DownLoadTool.q.f));
        this.r = new DownLoadAdapter(this.q, this.s, this.t);
        View inflate = LayoutInflater.from(this.q).inflate(com.rtk.app.R.layout.down_load_listview_empty_layout, (ViewGroup) null);
        this.u = (TextView) inflate.findViewById(com.rtk.app.R.id.up_load_listview_empty_layout_btu);
        com.rtk.app.tool.t.h(inflate, this.downLoadList);
        this.downLoadList.setAdapter((ListAdapter) this.r);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131297402) {
            com.rtk.app.tool.c.a((Activity) this.q);
        } else {
            if (id != 2131297404) {
                return;
            }
            com.rtk.app.main.dialogPack.p pVar = new com.rtk.app.main.dialogPack.p(this.q, null, this.t, 0, this.s);
            if (this.s.size() > 0) {
                pVar.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_down_load);
        ButterKnife.a(this);
        this.q = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int i = extras.getInt("openPage", 0);
            int i2 = extras.getInt("gameId", 0);
            com.rtk.app.tool.c0.u("DownLoadActivity", "我被执行了" + i2 + "page  " + i);
            if (i == 2) {
                com.rtk.app.tool.p.a(this.f147c).d(i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        this.t.sendEmptyMessage(1);
    }
}
