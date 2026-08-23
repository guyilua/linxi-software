package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.gromore.R;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AppDetailInfoActivity extends Activity {
    private ImageView a;
    private TextView b;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout f734c;
    private RecyclerView d;
    private long e;
    private long f;
    private List<Pair<String, String>> g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a extends RecyclerView.Adapter<Object> {
        private a() {
        }
    }

    private void b() {
        this.a = (ImageView) findViewById(R.id.iv_detail_back);
        this.b = (TextView) findViewById(R.id.tv_empty);
        this.d = findViewById(R.id.permission_list);
        this.f734c = (LinearLayout) findViewById(R.id.ll_download);
        if (this.g.isEmpty()) {
            this.d.setVisibility(8);
            this.b.setVisibility(0);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(1);
            this.d.setLayoutManager(linearLayoutManager);
            this.d.setAdapter(new a());
        }
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.a("lp_app_detail_click_close", AppDetailInfoActivity.this.f);
                AppDetailInfoActivity.this.finish();
            }
        });
        this.f734c.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.a("lp_app_detail_click_download", AppDetailInfoActivity.this.f);
                b.a().b(AppDetailInfoActivity.this.f);
                com.ss.android.socialbase.appdownloader.c.a((Activity) AppDetailInfoActivity.this);
                com.ss.android.socialbase.appdownloader.c.a(b.a().b());
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        g.a("lp_app_detail_click_close", this.f);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ttdownloader_activity_app_detail_info);
        if (a()) {
            b();
        } else {
            com.ss.android.socialbase.appdownloader.c.a((Activity) this);
        }
    }

    public static void a(Activity activity, long j) {
        Intent intent = new Intent(activity, (Class<?>) AppDetailInfoActivity.class);
        intent.putExtra("app_info_id", j);
        activity.startActivity(intent);
    }

    private boolean a() {
        this.e = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.b.b a2 = c.a().a(this.e);
        if (a2 == null) {
            return false;
        }
        this.f = a2.b;
        this.g = a2.h;
        return true;
    }
}
