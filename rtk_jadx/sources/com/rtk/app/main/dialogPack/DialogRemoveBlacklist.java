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
public class DialogRemoveBlacklist extends o implements h.j {
    private Context k;
    private String l;
    private com.rtk.app.tool.j m;
    private String n;

    @BindView
    TextView removeBlacklistCancel;

    @BindView
    TextView removeBlacklistEnsure;

    @BindView
    TextView removeBlacklistTip;

    public DialogRemoveBlacklist(Context context, String str, String str2, String str3, com.rtk.app.tool.j jVar) {
        super(context);
        this.l = str2;
        this.k = context;
        this.m = jVar;
        this.n = str;
        i(R.layout.dialog_remove_blacklist_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        this.removeBlacklistTip.setText("将" + str3 + "从黑名单中移除");
        p();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.f.a(this.k, "已从黑名单中移除", f.a.f);
        this.m.m(j.a.NO);
        dismiss();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.k, "移除黑名单失败", f.a.f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_remove_blacklist_cancel /* 2131297348 */:
                dismiss();
                return;
            case R.id.dialog_remove_blacklist_ensure /* 2131297349 */:
                if (TextUtils.isEmpty(this.n)) {
                    HashMap hashMap = new HashMap();
                    Context context = this.k;
                    hashMap.put("channel", com.rtk.app.tool.y.m(context, context.getPackageName()));
                    hashMap.put("version", com.rtk.app.tool.y.i(this.k));
                    hashMap.put(ak.aj, com.rtk.app.tool.y.g());
                    hashMap.put("phone_model", com.rtk.app.tool.y.T());
                    hashMap.put("black_uid", this.l);
                    hashMap.put("uid", com.rtk.app.tool.y.K() + "");
                    hashMap.put("token", com.rtk.app.tool.y.H());
                    hashMap.put("key", com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.k, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "black_uid=" + this.l))));
                    Context context2 = this.k;
                    StringBuilder sb = new StringBuilder();
                    sb.append(com.rtk.app.tool.y.e);
                    sb.append("user/blacklist/cancel");
                    com.rtk.app.tool.o.h.j(context2, this, sb.toString(), 1, hashMap);
                    return;
                }
                HashMap<String, String> l = com.rtk.app.tool.y.l();
                l.put("family_id", this.n);
                l.put("suid", this.l);
                l.put("key", com.rtk.app.tool.t.L(l));
                com.rtk.app.tool.o.h.j(this.k, this, com.rtk.app.tool.y.e + "family/user/blacklist-cancel", 1, l);
                return;
            default:
                return;
        }
    }

    public void p() {
        this.removeBlacklistTip.setOnClickListener(this);
        this.removeBlacklistCancel.setOnClickListener(this);
        this.removeBlacklistEnsure.setOnClickListener(this);
    }
}
