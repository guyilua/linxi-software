package com.rtk.app.main.dialogPack;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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
public class DialogScreen extends Dialog {
    private Window a;
    private com.rtk.app.tool.s b;

    /* renamed from: c, reason: collision with root package name */
    private ViewHolder f250c;
    public String d;
    public String e;
    private int f;
    private int g;
    private int h;
    private int i;
    private List<String> j;
    private List<String> k;
    private w2 l;
    private w2 m;

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

        ViewHolder(DialogScreen dialogScreen, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.dialogScreenClose = (ImageView) butterknife.c.a.c(view, R.id.dialog_screen_close, "field 'dialogScreenClose'", ImageView.class);
            viewHolder.dialogScreenSize = (GridView) butterknife.c.a.c(view, R.id.dialog_screen_size, "field 'dialogScreenSize'", GridView.class);
            viewHolder.dialogScreenLanguage = (GridView) butterknife.c.a.c(view, R.id.dialog_screen_language, "field 'dialogScreenLanguage'", GridView.class);
            viewHolder.dialogScreenEnsure = (TextView) butterknife.c.a.c(view, R.id.dialog_screen_ensure, "field 'dialogScreenEnsure'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.dialogScreenClose = null;
                viewHolder.dialogScreenSize = null;
                viewHolder.dialogScreenLanguage = null;
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
            DialogScreen.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DialogScreen dialogScreen = DialogScreen.this;
            dialogScreen.i = dialogScreen.g;
            DialogScreen dialogScreen2 = DialogScreen.this;
            dialogScreen2.h = dialogScreen2.f;
            com.rtk.app.tool.s sVar = DialogScreen.this.b;
            DialogScreen dialogScreen3 = DialogScreen.this;
            sVar.a(dialogScreen3.d, dialogScreen3.e);
            com.rtk.app.tool.c0.u("DialogScreen", "size--->>>" + DialogScreen.this.d + "   language---->" + DialogScreen.this.e);
            DialogScreen.this.dismiss();
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
            DialogScreen.this.f = i;
            DialogScreen.this.l.e(DialogScreen.this.f);
            switch (i) {
                case 0:
                    DialogScreen.this.d = "";
                    return;
                case 1:
                    DialogScreen.this.d = "0-50";
                    return;
                case 2:
                    DialogScreen.this.d = "50-100";
                    return;
                case 3:
                    DialogScreen.this.d = "100-150";
                    return;
                case 4:
                    DialogScreen.this.d = "150-200";
                    return;
                case 5:
                    DialogScreen.this.d = "200-300";
                    return;
                case 6:
                    DialogScreen.this.d = "300-500";
                    return;
                case 7:
                    DialogScreen.this.d = "500-1024";
                    return;
                case 8:
                    DialogScreen.this.d = "1024-10240";
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
            DialogScreen.this.g = i;
            DialogScreen.this.m.e(DialogScreen.this.g);
            if (i != 0) {
                DialogScreen.this.e = i + "";
                return;
            }
            DialogScreen.this.e = "";
        }
    }

    public DialogScreen(Context context, com.rtk.app.tool.s sVar) {
        super(context);
        this.a = null;
        this.d = "";
        this.e = "";
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.b = sVar;
    }

    private void j() {
        this.f250c.dialogScreenClose.setOnClickListener(new a());
        this.f250c.dialogScreenEnsure.setOnClickListener(new b());
        this.f250c.dialogScreenSize.setOnItemClickListener(new c());
        this.f250c.dialogScreenLanguage.setOnItemClickListener(new d());
    }

    private void k() {
        this.f250c = new ViewHolder(this, getWindow().getDecorView());
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        arrayList.add("全部");
        this.j.add("0-50M");
        this.j.add("50-100M");
        this.j.add("100-150M");
        this.j.add("150-200M");
        this.j.add("200-300M");
        this.j.add("300-500M");
        this.j.add("500M-1G");
        this.j.add("1G以上");
        w2 w2Var = new w2(getContext(), this.j, this.h);
        this.l = w2Var;
        this.f250c.dialogScreenSize.setAdapter((ListAdapter) w2Var);
        ArrayList arrayList2 = new ArrayList();
        this.k = arrayList2;
        arrayList2.add("全部");
        this.k.add("中文");
        this.k.add("英文");
        this.k.add("其他");
        w2 w2Var2 = new w2(getContext(), this.k, this.i);
        this.m = w2Var2;
        this.f250c.dialogScreenLanguage.setAdapter((ListAdapter) w2Var2);
        com.rtk.app.tool.t.P1(this.f250c.dialogScreenEnsure, getContext());
    }

    public void l(float f, float f2) {
        setContentView(R.layout.dialog_screen);
        n(f, f2);
        setCanceledOnTouchOutside(true);
        k();
        j();
    }

    public void m() {
        this.l.e(this.h);
        this.m.e(this.i);
        show();
    }

    public void n(float f, float f2) {
        Window window = getWindow();
        this.a = window;
        window.setWindowAnimations(R.style.dialog_anim_style);
        WindowManager.LayoutParams attributes = this.a.getAttributes();
        attributes.x = (int) f;
        attributes.y = (int) f2;
        attributes.gravity = 48;
        attributes.width = -1;
        attributes.height = -2;
        this.a.setAttributes(attributes);
    }
}
