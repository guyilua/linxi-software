package com.rtk.app.main.dialogPack;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.GsonBuilder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.bean.UpApkDetailsBean;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForUpCommand extends o implements h.j {

    @BindView
    TextView dialogForCommandTitle;

    @BindView
    RoundedImageView dialogForCommandUpLogo;

    @BindView
    LinearLayout dialogForCommandUpLv;

    @BindView
    TextView dialogForCommandUpName;

    @BindView
    RelativeLayout dialogForCommandUpParent;

    @BindView
    TextView dialogForCommandUpSize;

    @BindView
    TextView dialogForCommandUpVersion;

    @BindView
    ImageView dialogForUpCommandClose;

    @BindView
    LinearLayout dialogForUpCommandLv;
    private Activity k;
    private String l;
    private UpApkDetailsBean m;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements com.rtk.app.tool.s {
        a() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            DialogForUpCommand.this.q(1);
        }
    }

    public DialogForUpCommand(Activity activity, String str) {
        super(activity);
        this.k = activity;
        List<String> d = com.rtk.app.tool.c0.d(str, "-");
        d.get(0);
        this.l = d.get(1);
        i(R.layout.dialog_for_up_command_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        q(1);
        l(this.dialogForUpCommandLv, this.dialogForCommandTitle);
        setCanceledOnTouchOutside(false);
        this.dialogForUpCommandClose.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i) {
        String sb;
        if (i != 1) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("up/detail");
            sb2.append(com.rtk.app.tool.y.u(this.k));
            sb2.append("&di=");
            sb2.append(com.rtk.app.tool.y.r(this.k));
            sb2.append("&sid=");
            sb2.append(this.l);
            sb2.append("&uid=");
            sb2.append(com.rtk.app.tool.y.K());
            sb2.append("&token=");
            sb2.append(com.rtk.app.tool.y.H());
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.k, "sid=" + this.l, "di=" + com.rtk.app.tool.y.r(this.k)))));
            sb = sb2.toString();
        }
        com.rtk.app.tool.o.h.l(this.k, this, i, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i != 1) {
            return;
        }
        k();
        UpApkDetailsBean upApkDetailsBean = (UpApkDetailsBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, UpApkDetailsBean.class);
        this.m = upApkDetailsBean;
        this.dialogForCommandUpName.setText(upApkDetailsBean.getData().getVarName());
        com.rtk.app.tool.t.c(this.k, this.m.getData().getSourceLogo(), this.dialogForCommandUpLogo, new boolean[0]);
        this.dialogForCommandUpSize.setText(this.m.getData().getSourceSize());
        this.dialogForCommandUpVersion.setText(this.m.getData().getVersionName());
        r();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        n(str, new a());
        com.rtk.app.tool.f.a(this.k, str, f.a.f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131297263) {
            com.rtk.app.tool.t.X0(this.k, new ApkInfo(this.m.getData()));
            dismiss();
        } else {
            dismiss();
        }
    }

    public void r() {
        this.dialogForCommandUpParent.setOnClickListener(this);
    }
}
