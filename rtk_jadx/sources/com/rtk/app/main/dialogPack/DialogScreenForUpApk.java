package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.adapter.w2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogScreenForUpApk extends o {
    private com.rtk.app.tool.s k;
    private w2 l;
    private w2 m;
    private w2 n;
    private ViewHolder o;
    public String p;
    public String q;
    public String r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private List<String> x;
    private List<String> y;
    private List<String> z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder {

        @BindView
        ImageView dialogScreenClose;

        @BindView
        TextView dialogScreenEnsure;

        @BindView
        GridView dialogScreenLanguage;

        @BindView
        GridView dialogScreenSize;

        @BindView
        GridView dialogScreenType;

        ViewHolder(DialogScreenForUpApk dialogScreenForUpApk, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.dialogScreenClose = (ImageView) butterknife.c.a.c(view, R.id.dialog_screen_for_up_apk_close, "field 'dialogScreenClose'", ImageView.class);
            viewHolder.dialogScreenSize = (GridView) butterknife.c.a.c(view, R.id.dialog_screen_for_up_apk_size, "field 'dialogScreenSize'", GridView.class);
            viewHolder.dialogScreenLanguage = (GridView) butterknife.c.a.c(view, R.id.dialog_screen_for_up_apk_language, "field 'dialogScreenLanguage'", GridView.class);
            viewHolder.dialogScreenType = (GridView) butterknife.c.a.c(view, R.id.dialog_screen_for_up_apk_type, "field 'dialogScreenType'", GridView.class);
            viewHolder.dialogScreenEnsure = (TextView) butterknife.c.a.c(view, R.id.dialog_screen_for_up_apk_ensure, "field 'dialogScreenEnsure'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.dialogScreenClose = null;
                viewHolder.dialogScreenSize = null;
                viewHolder.dialogScreenLanguage = null;
                viewHolder.dialogScreenType = null;
                viewHolder.dialogScreenEnsure = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DialogScreenForUpApk.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DialogScreenForUpApk dialogScreenForUpApk = DialogScreenForUpApk.this;
            dialogScreenForUpApk.v = dialogScreenForUpApk.t;
            DialogScreenForUpApk dialogScreenForUpApk2 = DialogScreenForUpApk.this;
            dialogScreenForUpApk2.u = dialogScreenForUpApk2.s;
            com.rtk.app.tool.s sVar = DialogScreenForUpApk.this.k;
            DialogScreenForUpApk dialogScreenForUpApk3 = DialogScreenForUpApk.this;
            sVar.a(dialogScreenForUpApk3.p, dialogScreenForUpApk3.q, dialogScreenForUpApk3.r);
            com.rtk.app.tool.c0.u("DialogScreenForUpApk", "size--->>>" + DialogScreenForUpApk.this.p + "   language---->" + DialogScreenForUpApk.this.q + "     type---> " + DialogScreenForUpApk.this.r);
            DialogScreenForUpApk.this.dismiss();
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
            DialogScreenForUpApk.this.s = i;
            DialogScreenForUpApk.this.l.e(DialogScreenForUpApk.this.s);
            switch (i) {
                case 0:
                    DialogScreenForUpApk.this.p = "";
                    return;
                case 1:
                    DialogScreenForUpApk.this.p = "0-50";
                    return;
                case 2:
                    DialogScreenForUpApk.this.p = "50-100";
                    return;
                case 3:
                    DialogScreenForUpApk.this.p = "100-150";
                    return;
                case 4:
                    DialogScreenForUpApk.this.p = "150-200";
                    return;
                case 5:
                    DialogScreenForUpApk.this.p = "200-300";
                    return;
                case 6:
                    DialogScreenForUpApk.this.p = "300-500";
                    return;
                case 7:
                    DialogScreenForUpApk.this.p = "500-1024";
                    return;
                case 8:
                    DialogScreenForUpApk.this.p = "1024-10240";
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
            DialogScreenForUpApk.this.t = i;
            DialogScreenForUpApk.this.m.e(DialogScreenForUpApk.this.t);
            if (i != 0) {
                DialogScreenForUpApk.this.q = i + "";
                return;
            }
            DialogScreenForUpApk.this.q = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class e extends com.rtk.app.custom.AutoListView.b {
        e() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            view.setSelected(true);
            DialogScreenForUpApk.this.w = i;
            DialogScreenForUpApk.this.n.e(DialogScreenForUpApk.this.w);
            if (i == 1) {
                DialogScreenForUpApk.this.r = "0";
            } else if (i != 2) {
                DialogScreenForUpApk.this.r = "";
            } else {
                DialogScreenForUpApk.this.r = "1";
            }
        }
    }

    public DialogScreenForUpApk(Context context, com.rtk.app.tool.s sVar) {
        super(context);
        this.p = "";
        this.q = "";
        this.r = "";
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.k = sVar;
        i(R.layout.dialog_screen_for_up_apk, 17);
        C();
        B();
    }

    private void C() {
        this.o = new ViewHolder(this, getWindow().getDecorView());
        ArrayList arrayList = new ArrayList();
        this.x = arrayList;
        arrayList.add("全部");
        this.x.add("0-50M");
        this.x.add("50-100M");
        this.x.add("100-150M");
        this.x.add("150-200M");
        this.x.add("200-300M");
        this.x.add("300-500M");
        this.x.add("500M-1G");
        this.x.add("1G以上");
        w2 w2Var = new w2(getContext(), this.x, this.u);
        this.l = w2Var;
        this.o.dialogScreenSize.setAdapter((ListAdapter) w2Var);
        ArrayList arrayList2 = new ArrayList();
        this.y = arrayList2;
        arrayList2.add("全部");
        this.y.add("中文");
        this.y.add("英文");
        this.y.add("其他");
        w2 w2Var2 = new w2(getContext(), this.y, this.v);
        this.m = w2Var2;
        this.o.dialogScreenLanguage.setAdapter((ListAdapter) w2Var2);
        ArrayList arrayList3 = new ArrayList();
        this.z = arrayList3;
        arrayList3.add("全部");
        this.z.add("游戏");
        this.z.add("软件");
        w2 w2Var3 = new w2(getContext(), this.z, this.w);
        this.n = w2Var3;
        this.o.dialogScreenType.setAdapter((ListAdapter) w2Var3);
        com.rtk.app.tool.t.P1(this.o.dialogScreenEnsure, getContext());
    }

    public void B() {
        this.o.dialogScreenClose.setOnClickListener(new a());
        this.o.dialogScreenEnsure.setOnClickListener(new b());
        this.o.dialogScreenSize.setOnItemClickListener(new c());
        this.o.dialogScreenLanguage.setOnItemClickListener(new d());
        this.o.dialogScreenType.setOnItemClickListener(new e());
    }

    public void D() {
        this.l.e(this.u);
        this.m.e(this.v);
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
