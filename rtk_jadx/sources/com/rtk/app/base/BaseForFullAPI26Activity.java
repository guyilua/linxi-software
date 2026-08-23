package com.rtk.app.base;

import android.R;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.GsonBuilder;
import com.rtk.app.custom.SwipeBackActivity;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.dialogPack.DialogForInstallPermission;
import com.rtk.app.main.dialogPack.DialogPermision;
import com.rtk.app.tool.DownLoadTool.n;
import com.rtk.app.tool.DownLoadTool.x;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class BaseForFullAPI26Activity extends SwipeBackActivity implements View.OnClickListener, f {
    protected n b;

    /* renamed from: c, reason: collision with root package name */
    public BaseForFullAPI26Activity f148c;
    private ViewGroup e;
    private View f;
    private ViewGroup h;
    private ViewGroup i;
    private s j;
    protected boolean d = false;
    private List<Integer> g = new ArrayList();
    private boolean k = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BaseForFullAPI26Activity.this.j != null) {
                BaseForFullAPI26Activity.this.j.a(new String[0]);
            }
            BaseForFullAPI26Activity.this.A();
            BaseForFullAPI26Activity.this.e.addView(BaseForFullAPI26Activity.this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        ViewGroup viewGroup = this.h;
        if (viewGroup != null) {
            this.e.removeView(viewGroup);
        }
        View view = this.f;
        if (view != null) {
            this.e.removeView(view);
        }
        ViewGroup viewGroup2 = this.i;
        if (viewGroup2 != null) {
            this.e.removeView(viewGroup2);
        }
    }

    private void D(s sVar) {
        try {
            if (this.k) {
                return;
            }
            this.j = sVar;
            A();
            this.e.addView(this.h);
            this.h.getChildAt(2).setOnClickListener(new a());
        } catch (Exception unused) {
        }
    }

    private void v() {
        initData();
        initView();
        initListener();
        t.V1(this.f148c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z(View view) {
        s sVar = this.j;
        if (sVar != null) {
            sVar.a(new String[0]);
        }
        A();
        this.e.addView(this.f);
    }

    public void B() {
        for (int i = 0; i < this.e.getChildCount(); i++) {
            if (this.g.contains(Integer.valueOf(this.e.getChildAt(i).getId()))) {
                this.e.getChildAt(i).setVisibility(0);
            }
        }
        this.k = true;
        A();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void C(ViewGroup viewGroup, View view) {
        this.k = false;
        A();
        if (viewGroup == null) {
            this.e = (ViewGroup) ((ViewGroup) getWindow().getDecorView().findViewById(R.id.content)).getChildAt(0);
        } else {
            this.e = viewGroup;
        }
        for (int i = 0; i < this.e.getChildCount(); i++) {
            if (this.e.getChildAt(i).getId() != view.getId() && this.e.getChildAt(i).getVisibility() == 0) {
                this.e.getChildAt(i).setVisibility(8);
                this.g.add(Integer.valueOf(this.e.getChildAt(i).getId()));
            }
        }
        if (this.f == null) {
            this.f = LayoutInflater.from(this.f148c).inflate(com.rtk.app.R.layout.auto_max_footview_load_layout, (ViewGroup) null);
        }
        this.f.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (this.h == null) {
            this.h = (ViewGroup) LayoutInflater.from(this.f148c).inflate(com.rtk.app.R.layout.auto_no_interner_layout, (ViewGroup) null);
        }
        this.h.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (this.i == null) {
            this.i = (ViewGroup) LayoutInflater.from(this.f148c).inflate(com.rtk.app.R.layout.auto_src_dissmiss_layout, (ViewGroup) null);
        }
        this.i.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.e.addView(this.f);
    }

    public void E(String str, s sVar) {
        if (str.equals(y.E)) {
            c0.u("BaseForFullAPI26Activity", "确定是没网络");
            D(sVar);
            return;
        }
        try {
            if (this.k) {
                return;
            }
            this.j = sVar;
            A();
            this.e.addView(this.i);
            ((TextView) this.i.getChildAt(1)).setText(t.O1(str));
            this.i.getChildAt(2).setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.base.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseForFullAPI26Activity.this.z(view);
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
        com.rtk.app.tool.c.c();
        super/*android.app.Activity*/.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(i, i2, intent);
        c0.u("BaseForFullAPI26Activity", "BaseActivity   onActivityResult  被执行" + i + "      " + i2);
        if (i == 999 && w()) {
            v();
        }
        if (i2 != 100023) {
            return;
        }
        intent.getBooleanExtra("isLoginSuccer", false);
        this.d = intent.getBooleanExtra("isLoginOpen", false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        overridePendingTransition(com.rtk.app.R.anim.push_left_in, com.rtk.app.R.anim.push_left_out);
        StringBuilder sb = new StringBuilder();
        sb.append("当前api版本号");
        int i = Build.VERSION.SDK_INT;
        sb.append(i);
        c0.u("BaseForFullAPI26Activity", sb.toString());
        if (i == 26) {
            c0.u("BaseForFullAPI26Activity", "当前是8.0系统");
            if (y.F()) {
                setTheme(com.rtk.app.R.style.fullTheme_day);
            } else {
                setTheme(com.rtk.app.R.style.fullTheme_night);
            }
        } else {
            c0.u("BaseForFullAPI26Activity", "当前不是8.0系统");
            if (y.F()) {
                setTheme(com.rtk.app.R.style.AppTheme_day);
            } else {
                setTheme(com.rtk.app.R.style.AppTheme_night);
            }
        }
        super.onCreate(bundle);
        this.f148c = this;
        new GsonBuilder().enableComplexMapKeySerialization().create();
    }

    protected void onDestroy() {
        try {
            super.onDestroy();
            if (this.b != null) {
                x.c().n(this.b);
            }
        } catch (Exception unused) {
        }
    }

    protected void onNewIntent(Intent intent) {
        super/*androidx.fragment.app.FragmentActivity*/.onNewIntent(intent);
        x();
        if (w()) {
            v();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.custom.SwipeBackActivity
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this.f148c);
    }

    protected void onPostCreate(@Nullable Bundle bundle) {
        super.onPostCreate(bundle);
        x();
        if (w()) {
            v();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super/*androidx.fragment.app.FragmentActivity*/.onRequestPermissionsResult(i, strArr, iArr);
        c0.u("BaseForFullAPI26Activity", "存储权限requestCode" + i + "     " + iArr.length);
        if (i != 10000) {
            return;
        }
        for (int i2 : iArr) {
            if (i2 != 0) {
                new DialogPermision(MyApplication.b(), t.U(this)).show();
                return;
            }
        }
        v();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onResume() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - 600 <= DialogForInstallPermission.l) {
            new DialogForInstallPermission(this.f148c).show();
        }
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        MyApplication.f(this.f148c);
        MobclickAgent.onResume(this.f148c);
        if (this.d) {
            this.d = false;
            finish();
        }
        if (com.rtk.app.tool.g.e.c().i() && !com.rtk.app.tool.g.e.c().g(this)) {
            com.rtk.app.tool.g.d.c(this.f148c).e(com.rtk.app.c.d.b(), currentTimeMillis, (currentTimeMillis - com.rtk.app.tool.g.e.c().b()) + com.rtk.app.tool.g.e.c().d());
            com.rtk.app.tool.g.e.c().a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.custom.SwipeBackActivity
    public void onStart() {
        super.onStart();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onWindowFocusChanged(boolean z) {
        super/*android.app.Activity*/.onWindowFocusChanged(z);
        if (z) {
            t.G(this.f148c);
        }
    }

    protected boolean w() {
        return true;
    }

    protected abstract void x();
}
