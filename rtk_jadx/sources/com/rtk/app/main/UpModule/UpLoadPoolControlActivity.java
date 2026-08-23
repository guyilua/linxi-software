package com.rtk.app.main.UpModule;

import android.R;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.adapter.UpLoadPoolControlAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.main.MyApplication;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpLoadPoolControlActivity extends BaseActivity {
    public UpLoadPoolControlAdapter q;
    private View r;
    private List<com.rtk.app.tool.g.g> s = new ArrayList();
    public Handler t = new a();

    @BindView
    ListView upLoadPoolControlListView;

    @BindView
    TextView upLoadPoolControlTopBack;

    @BindView
    LinearLayout upLoadPoolControlTopLayout;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().g(UpLoadPoolControlActivity.this.q.f);
            UpLoadPoolControlActivity.this.s.clear();
            UpLoadPoolControlActivity.this.s.addAll(com.rtk.app.tool.g.f.e(MyApplication.b()).c());
            UpLoadPoolControlActivity.this.q.notifyDataSetChanged();
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.upLoadPoolControlTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void M() {
        com.rtk.app.tool.c0.u("UpLoadPoolControlActivity", "刷新线程时间");
        this.t.sendEmptyMessage(1);
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        com.rtk.app.tool.c0.r("UpLoadPoolControlActivity", "finish");
        com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().g(this.q.f);
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        this.r = LayoutInflater.from(this.f147c).inflate(com.rtk.app.R.layout.up_load_pool_control_empty_view_layout, (ViewGroup) null);
        this.q = new UpLoadPoolControlAdapter(this.f147c, this.s);
        com.rtk.app.tool.t.h(this.r, this.upLoadPoolControlListView);
        this.upLoadPoolControlListView.setAdapter((ListAdapter) this.q);
        ((TextView) this.r.findViewById(com.rtk.app.R.id.up_load_listview_empty_layout_btu)).setOnClickListener(this);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        List<com.rtk.app.tool.g.g> b = com.rtk.app.tool.g.f.e(this.f147c).b();
        com.rtk.app.tool.c0.u("UpLoadPoolControlActivity", "  长度   " + b.size());
        for (com.rtk.app.tool.g.g gVar : b) {
            com.rtk.app.tool.c0.u("UpLoadPoolControlActivity", "上传名" + gVar.c() + "  md5  " + gVar.n() + "  _id" + gVar.E());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131300967) {
            com.rtk.app.tool.t.e2(this.f147c, view);
        } else {
            if (id != 2131300978) {
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
        setContentView(com.rtk.app.R.layout.activity_up_load_pool_control);
        ButterKnife.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onPause() {
        super.onPause();
        com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().g(this.q.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        this.s.clear();
        this.s.addAll(com.rtk.app.tool.g.f.e(MyApplication.b()).c());
        this.q.notifyDataSetChanged();
    }
}
