package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.tool.j;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogAddBlacklist extends o implements h.j {

    @BindView
    TextView addBlacklistCancel;

    @BindView
    TextView addBlacklistEnsure;
    private final String k;
    private final String l;

    @BindView
    View layout;
    private Context m;

    @BindView
    TextView msg;
    private String n;
    private com.rtk.app.tool.j o;

    @BindView
    TextView title;

    public DialogAddBlacklist(Context context, String str, String str2, String str3, com.rtk.app.tool.j jVar) {
        super(context);
        this.n = str3;
        this.m = context;
        this.o = jVar;
        this.k = str;
        this.l = str2;
        i(R.layout.dialog_add_blacklist_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        p();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.f.a(this.m, "已加入黑名单", f.a.f);
        dismiss();
        this.o.m(j.a.YES);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.m, str, f.a.f);
        dismiss();
        this.o.m(j.a.NO);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_add_blacklist_cancel /* 2131297110 */:
                dismiss();
                return;
            case R.id.dialog_add_blacklist_ensure /* 2131297111 */:
                if (TextUtils.isEmpty(this.k)) {
                    HashMap hashMap = new HashMap();
                    Context context = this.m;
                    hashMap.put("channel", com.rtk.app.tool.y.m(context, context.getPackageName()));
                    hashMap.put("version", com.rtk.app.tool.y.i(this.m));
                    hashMap.put(ak.aj, com.rtk.app.tool.y.g());
                    hashMap.put("phone_model", com.rtk.app.tool.y.T());
                    hashMap.put("black_uid", this.n);
                    hashMap.put("uid", com.rtk.app.tool.y.K() + "");
                    hashMap.put("token", com.rtk.app.tool.y.H());
                    hashMap.put("key", com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.m, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "black_uid=" + this.n))));
                    Context context2 = this.m;
                    StringBuilder sb = new StringBuilder();
                    sb.append(com.rtk.app.tool.y.e);
                    sb.append("user/blacklist/add");
                    com.rtk.app.tool.o.h.j(context2, this, sb.toString(), 1, hashMap);
                    return;
                }
                HashMap<String, String> l = com.rtk.app.tool.y.l();
                l.put("family_id", this.k);
                l.put("suid", this.n);
                l.put("key", com.rtk.app.tool.t.L(l));
                com.rtk.app.tool.o.h.j(this.m, this, com.rtk.app.tool.y.e + "family/user/blacklist-add", 1, l);
                return;
            default:
                return;
        }
    }

    public void p() {
        this.addBlacklistEnsure.setOnClickListener(this);
        this.addBlacklistCancel.setOnClickListener(this);
        if (TextUtils.isEmpty(this.k)) {
            return;
        }
        this.layout.setVisibility(8);
        this.msg.setText("是否将" + this.l + "加入家族黑名单？加入后" + this.l + "将无法申请加入您的家族。");
    }
}
