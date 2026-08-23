package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.gromore.R;
import com.ss.android.downloadlib.addownload.compliance.d;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.g.m;
import com.ss.android.downloadlib.guide.install.ClipImageView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a extends Dialog {
    private TextView a;
    private TextView b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f736c;
    private TextView d;
    private TextView e;
    private TextView f;
    private ClipImageView g;
    private LinearLayout h;
    private Activity i;
    private final long j;
    private long k;
    private final com.ss.android.downloadlib.addownload.b.b l;

    public a(@NonNull Activity activity, long j) {
        super(activity);
        this.i = activity;
        this.j = j;
        this.l = c.a().get(Long.valueOf(j));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.ss.android.socialbase.appdownloader.c.a(this.i);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.l == null) {
            dismiss();
            return;
        }
        requestWindowFeature(1);
        setContentView(R.layout.ttdownloader_dialog_appinfo);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.drawable.ttdownloader_bg_transparent);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.k = this.l.b;
        a();
        g.b("lp_app_dialog_show", this.k);
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                g.a("lp_app_dialog_cancel", a.this.k);
            }
        });
    }

    private void a() {
        this.a = (TextView) findViewById(R.id.tv_app_name);
        this.b = (TextView) findViewById(R.id.tv_app_version);
        this.f736c = (TextView) findViewById(R.id.tv_app_developer);
        this.d = (TextView) findViewById(R.id.tv_app_detail);
        this.e = (TextView) findViewById(R.id.tv_app_privacy);
        this.f = (TextView) findViewById(R.id.tv_give_up);
        this.g = (ClipImageView) findViewById(R.id.iv_app_icon);
        this.h = (LinearLayout) findViewById(R.id.ll_download);
        this.a.setText(m.a(this.l.e, "--"));
        this.b.setText("版本号：" + m.a(this.l.f, "--"));
        this.f736c.setText("开发者：" + m.a(this.l.g, "应用信息正在完善中"));
        this.g.setRoundRadius(m.a(k.a(), 8.0f));
        this.g.setBackgroundColor(Color.parseColor("#EBEBEB"));
        d.a().a(this.j, new d.a() { // from class: com.ss.android.downloadlib.addownload.compliance.a.2
            @Override // com.ss.android.downloadlib.addownload.compliance.d.a
            public void a(Bitmap bitmap) {
                if (bitmap != null) {
                    a.this.g.setImageBitmap(bitmap);
                } else {
                    g.a(8, a.this.k);
                }
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.a().a(a.this.i);
                AppDetailInfoActivity.a(a.this.i, a.this.j);
                g.a("lp_app_dialog_click_detail", a.this.k);
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.a().a(a.this.i);
                AppPrivacyPolicyActivity.a(a.this.i, a.this.j);
                g.a("lp_app_dialog_click_privacy", a.this.k);
            }
        });
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dismiss();
                g.a("lp_app_dialog_click_giveup", a.this.k);
            }
        });
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.a("lp_app_dialog_click_download", a.this.k);
                b.a().b(a.this.k);
                a.this.dismiss();
            }
        });
    }
}
