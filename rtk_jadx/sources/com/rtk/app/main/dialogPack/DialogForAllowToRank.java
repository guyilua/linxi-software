package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.bean.ResponseDataBean;
import com.rtk.app.bean.UpApkDetailsBean;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForAllowToRank extends o implements h.j {

    @BindView
    TextView dialogForAllowToRankDownLoad;

    @BindView
    TextView dialogForAllowToRankReword;
    private final DialogForAllowToRankReason k;
    private String l;
    private String m;
    private Context n;
    private int o;
    private UpApkDetailsBean p;
    private String q;
    private String r;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements com.rtk.app.tool.s {
        a() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            DialogForAllowToRank.this.l = strArr[0];
            DialogForAllowToRank.this.m = strArr[1];
            DialogForAllowToRank.this.q = "0";
            DialogForAllowToRank.this.t(1);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements com.rtk.app.tool.s {
        b() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            DialogForAllowToRank.this.l = strArr[0];
            DialogForAllowToRank.this.m = strArr[1];
            DialogForAllowToRank.this.r = "0";
            DialogForAllowToRank.this.t(2);
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        com.rtk.app.tool.c0.u("DialogForAllowToRank", "设置是否排行成功  " + str);
        if (i == 1) {
            com.rtk.app.tool.f.a(this.n, ((ResponseDataBean) create.fromJson(str, ResponseDataBean.class)).getMsg(), f.a.f);
            if (this.p.getData().getDown_close().equals("1")) {
                this.p.getData().setDown_close("0");
            } else {
                this.p.getData().setDown_close("1");
            }
            this.k.dismiss();
            dismiss();
            return;
        }
        if (i != 2) {
            return;
        }
        com.rtk.app.tool.f.a(this.n, ((ResponseDataBean) create.fromJson(str, ResponseDataBean.class)).getMsg(), f.a.f);
        if (this.p.getData().getReward_close().equals("1")) {
            this.p.getData().setReward_close("0");
        } else {
            this.p.getData().setReward_close("1");
        }
        this.k.dismiss();
        dismiss();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.n, str, f.a.f);
        com.rtk.app.tool.c0.u("DialogForAllowToRank", "设置是否排行失败  " + str + "   mark:" + i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131297134) {
            if (this.p.getData().getDown_close().equals("0")) {
                this.m = "";
                this.q = "1";
                t(1);
                return;
            } else {
                this.k.p(new a());
                this.k.show();
                return;
            }
        }
        if (id != 2131297148) {
            return;
        }
        com.rtk.app.tool.c0.u("DialogForAllowToRank", "打赏状态   " + this.p.getData().getReward_close());
        if (this.p.getData().getReward_close().equals("0")) {
            this.m = "";
            this.r = "1";
            t(2);
        } else {
            this.k.p(new b());
            this.k.show();
        }
    }

    public void t(int i) {
        String sb;
        if (i == 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/setRankingDisplay");
            sb2.append(com.rtk.app.tool.y.u(this.n));
            sb2.append("&uid=");
            sb2.append(com.rtk.app.tool.y.K());
            sb2.append("&token=");
            sb2.append(com.rtk.app.tool.y.H());
            sb2.append("&sid=");
            sb2.append(this.o);
            sb2.append("&tags=0&close=");
            sb2.append(this.q);
            sb2.append("&days=");
            sb2.append(this.l);
            sb2.append("&reason=");
            sb2.append(this.m);
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.n, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "sid=" + this.o))));
            sb = sb2.toString();
        } else if (i != 2) {
            sb = "";
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("members/setRankingDisplay");
            sb3.append(com.rtk.app.tool.y.u(this.n));
            sb3.append("&uid=");
            sb3.append(com.rtk.app.tool.y.K());
            sb3.append("&token=");
            sb3.append(com.rtk.app.tool.y.H());
            sb3.append("&sid=");
            sb3.append(this.o);
            sb3.append("&tags=1&close=");
            sb3.append(this.r);
            sb3.append("&days=");
            sb3.append(this.l);
            sb3.append("&reason=");
            sb3.append(this.m);
            sb3.append("&key=");
            sb3.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.n, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "sid=" + this.o))));
            sb = sb3.toString();
        }
        com.rtk.app.tool.c0.u("DialogForAllowToRank", "地址  " + com.rtk.app.tool.y.d + sb);
        com.rtk.app.tool.o.h.l(this.n, this, i, com.rtk.app.tool.o.h.h(new String[0]).a(sb));
    }
}
