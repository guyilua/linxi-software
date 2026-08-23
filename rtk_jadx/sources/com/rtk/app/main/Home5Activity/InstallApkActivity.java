package com.rtk.app.main.Home5Activity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.adapter.InstallApkListViewAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.ApkBean;
import com.rtk.app.main.MyApplication;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class InstallApkActivity extends BaseActivity {

    @BindView
    ImageView installApkEmpty;

    @BindView
    LinearLayout installApkEmpty1;

    @BindView
    TextView installApkEmptyPath;

    @BindView
    LinearLayout installApkLayout;

    @BindView
    ListView installApkListView;

    @BindView
    TextView installApkTopBack;

    @BindView
    LinearLayout installApkTopLayout;
    private Context q;
    private List<ApkBean> r;
    private InstallApkListViewAdapter s;
    private Handler t = new a();
    private com.rtk.app.tool.k u;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                String str = (String) message.obj;
                InstallApkActivity.this.installApkEmptyPath.setText("正在扫描:" + str);
                return;
            }
            com.rtk.app.tool.c0.u("InstallApkActivity", "安装包管理  handler 我被执行了" + InstallApkActivity.this.r.size());
            InstallApkActivity.this.r.addAll((Collection) message.obj);
            InstallApkActivity.this.s.notifyDataSetChanged();
            InstallApkActivity installApkActivity = InstallApkActivity.this;
            installApkActivity.installApkListView.setEmptyView(installApkActivity.installApkEmpty1);
            InstallApkActivity.this.installApkLayout.setVisibility(8);
            InstallApkActivity.this.installApkEmpty1.setVisibility(8);
            if (InstallApkActivity.this.r.size() == 0) {
                InstallApkActivity.this.installApkEmpty1.setVisibility(0);
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements com.rtk.app.tool.s {
        b() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            InstallApkActivity.this.r.clear();
            InstallApkActivity.this.s.notifyDataSetChanged();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements AdapterView.OnItemLongClickListener {

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        class a implements com.rtk.app.tool.s {
            a() {
            }

            @Override // com.rtk.app.tool.s
            public void a(String... strArr) {
                InstallApkActivity.this.r.remove(Integer.parseInt(strArr[0]));
                InstallApkActivity.this.s.notifyDataSetChanged();
            }
        }

        c() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            new com.rtk.app.main.dialogPack.r(MyApplication.b(), ((ApkBean) InstallApkActivity.this.r.get(i)).getPath(), i, new a()).show();
            return true;
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.q, this.installApkTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        try {
            this.u.cancel(true);
            this.u.d(true);
        } catch (Exception unused) {
        }
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        this.r = new ArrayList();
        com.rtk.app.tool.k kVar = new com.rtk.app.tool.k((Activity) this.q, this.t);
        this.u = kVar;
        kVar.execute(new String[0]);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.installApkListView.setOnItemLongClickListener(new c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initView() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, com.rtk.app.R.anim.rotate_loading);
        loadAnimation.setInterpolator(new LinearInterpolator());
        this.installApkEmpty.startAnimation(loadAnimation);
        this.installApkListView.setEmptyView(this.installApkLayout);
        InstallApkListViewAdapter installApkListViewAdapter = new InstallApkListViewAdapter(this.q, this.r);
        this.s = installApkListViewAdapter;
        this.installApkListView.setAdapter((ListAdapter) installApkListViewAdapter);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131298231) {
            new com.rtk.app.main.dialogPack.q(MyApplication.b(), this.r, new b()).show();
        } else {
            if (id != 2131298237) {
                return;
            }
            com.rtk.app.tool.c.a((Activity) this.q);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_install_apk);
        ButterKnife.a(this);
        this.q = this;
    }

    @Override // com.rtk.app.base.BaseActivity
    protected boolean z() {
        return com.rtk.app.tool.r.b(this.q);
    }
}
