package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.adapter.w2;
import com.rtk.app.custom.GridViewForScrollView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogScreenForClassifyUpApk extends o {

    @BindView
    ImageView dialogScreenForClassifyUpApkClose;

    @BindView
    TextView dialogScreenForClassifyUpApkEnsure;

    @BindView
    GridViewForScrollView dialogScreenForClassifyUpApkLanguage;

    @BindView
    GridViewForScrollView dialogScreenForClassifyUpApkSize;
    private com.rtk.app.tool.s k;
    private w2 l;
    private w2 m;
    public String n;
    public String o;
    public String p;
    private int q;
    private int r;
    private int s;
    private int t;
    private List<String> u;
    private List<String> v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DialogScreenForClassifyUpApk.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DialogScreenForClassifyUpApk dialogScreenForClassifyUpApk = DialogScreenForClassifyUpApk.this;
            dialogScreenForClassifyUpApk.t = dialogScreenForClassifyUpApk.r;
            DialogScreenForClassifyUpApk dialogScreenForClassifyUpApk2 = DialogScreenForClassifyUpApk.this;
            dialogScreenForClassifyUpApk2.s = dialogScreenForClassifyUpApk2.q;
            com.rtk.app.tool.s sVar = DialogScreenForClassifyUpApk.this.k;
            DialogScreenForClassifyUpApk dialogScreenForClassifyUpApk3 = DialogScreenForClassifyUpApk.this;
            sVar.a(dialogScreenForClassifyUpApk3.n, dialogScreenForClassifyUpApk3.o, dialogScreenForClassifyUpApk3.p);
            com.rtk.app.tool.c0.u("DialogScreenForClassifyUpApk", "size--->>>" + DialogScreenForClassifyUpApk.this.n + "   language---->" + DialogScreenForClassifyUpApk.this.o + "     type---> " + DialogScreenForClassifyUpApk.this.p);
            DialogScreenForClassifyUpApk.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class c extends com.rtk.app.custom.AutoListView.b {
        c() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            view.setSelected(true);
            DialogScreenForClassifyUpApk.this.q = i;
            DialogScreenForClassifyUpApk.this.l.e(DialogScreenForClassifyUpApk.this.q);
            switch (i) {
                case 0:
                    DialogScreenForClassifyUpApk.this.n = "";
                    return;
                case 1:
                    DialogScreenForClassifyUpApk.this.n = "0-50";
                    return;
                case 2:
                    DialogScreenForClassifyUpApk.this.n = "50-100";
                    return;
                case 3:
                    DialogScreenForClassifyUpApk.this.n = "100-150";
                    return;
                case 4:
                    DialogScreenForClassifyUpApk.this.n = "150-200";
                    return;
                case 5:
                    DialogScreenForClassifyUpApk.this.n = "200-300";
                    return;
                case 6:
                    DialogScreenForClassifyUpApk.this.n = "300-500";
                    return;
                case 7:
                    DialogScreenForClassifyUpApk.this.n = "500-1024";
                    return;
                case 8:
                    DialogScreenForClassifyUpApk.this.n = "1024-10240";
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class d extends com.rtk.app.custom.AutoListView.b {
        d() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            view.setSelected(true);
            DialogScreenForClassifyUpApk.this.r = i;
            DialogScreenForClassifyUpApk.this.m.e(DialogScreenForClassifyUpApk.this.r);
            if (i != 0) {
                DialogScreenForClassifyUpApk.this.o = i + "";
                return;
            }
            DialogScreenForClassifyUpApk.this.o = "";
        }
    }

    public DialogScreenForClassifyUpApk(Context context, com.rtk.app.tool.s sVar) {
        super(context);
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.k = sVar;
        i(R.layout.dialog_screen_for_classify_up_apk, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        z();
        y();
    }

    private void z() {
        ArrayList arrayList = new ArrayList();
        this.u = arrayList;
        arrayList.add("全部");
        this.u.add("0-50M");
        this.u.add("50-100M");
        this.u.add("100-150M");
        this.u.add("150-200M");
        this.u.add("200-300M");
        this.u.add("300-500M");
        this.u.add("500M-1G");
        this.u.add("1G以上");
        w2 w2Var = new w2(getContext(), this.u, this.s);
        this.l = w2Var;
        this.dialogScreenForClassifyUpApkSize.setAdapter((ListAdapter) w2Var);
        ArrayList arrayList2 = new ArrayList();
        this.v = arrayList2;
        arrayList2.add("全部");
        this.v.add("中文");
        this.v.add("英文");
        this.v.add("其他");
        w2 w2Var2 = new w2(getContext(), this.v, this.t);
        this.m = w2Var2;
        this.dialogScreenForClassifyUpApkLanguage.setAdapter((ListAdapter) w2Var2);
        com.rtk.app.tool.t.P1(this.dialogScreenForClassifyUpApkEnsure, getContext());
    }

    public void A() {
        this.l.e(this.s);
        this.m.e(this.t);
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void y() {
        this.dialogScreenForClassifyUpApkClose.setOnClickListener(new a());
        this.dialogScreenForClassifyUpApkEnsure.setOnClickListener(new b());
        this.dialogScreenForClassifyUpApkSize.setOnItemClickListener(new c());
        this.dialogScreenForClassifyUpApkLanguage.setOnItemClickListener(new d());
    }
}
