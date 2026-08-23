package com.rtk.app.base;

import android.R;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.custom.SwipeBackActivity;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.dialogPack.DialogForInstallPermission;
import com.rtk.app.main.dialogPack.DialogPermision;
import com.rtk.app.main.dialogPack.DialogPhoto;
import com.rtk.app.tool.DownLoadTool.n;
import com.rtk.app.tool.DownLoadTool.x;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.m;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class BaseActivity extends SwipeBackActivity implements View.OnClickListener, f {
    protected n b;

    /* renamed from: c, reason: collision with root package name */
    public BaseActivity f147c;
    public DialogPhoto d;
    public Uri e;
    public Uri f;
    public Gson g;
    private ViewGroup j;
    private View k;
    private ViewGroup m;
    private ViewGroup n;
    private s o;
    protected boolean h = false;
    protected boolean i = false;
    private List<Integer> l = new ArrayList();
    private boolean p = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BaseActivity.this.o != null) {
                BaseActivity.this.o.a(new String[0]);
            }
            BaseActivity.this.E();
            BaseActivity.this.j.addView(BaseActivity.this.k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C(View view) {
        s sVar = this.o;
        if (sVar != null) {
            sVar.a(new String[0]);
        }
        E();
        this.j.addView(this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        ViewGroup viewGroup = this.m;
        if (viewGroup != null) {
            this.j.removeView(viewGroup);
        }
        View view = this.k;
        if (view != null) {
            this.j.removeView(view);
        }
        ViewGroup viewGroup2 = this.n;
        if (viewGroup2 != null) {
            this.j.removeView(viewGroup2);
        }
    }

    private void H(s sVar) {
        try {
            if (this.p) {
                return;
            }
            this.o = sVar;
            E();
            this.j.addView(this.m);
            this.m.getChildAt(2).setOnClickListener(new a());
        } catch (Exception unused) {
        }
    }

    private void y() {
        initData();
        initView();
        initListener();
        if (q()) {
            return;
        }
        t.V1(this.f147c);
    }

    protected abstract void A();

    /* renamed from: D */
    public void S() {
    }

    public void F() {
        for (int i = 0; i < this.j.getChildCount(); i++) {
            if (this.l.contains(Integer.valueOf(this.j.getChildAt(i).getId()))) {
                this.j.getChildAt(i).setVisibility(0);
            }
        }
        List<View> x = x();
        if (x != null) {
            Iterator<View> it = x.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
        }
        this.p = true;
        E();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void G(ViewGroup viewGroup, View view) {
        this.p = false;
        E();
        if (viewGroup == null) {
            this.j = (ViewGroup) ((ViewGroup) getWindow().getDecorView().findViewById(R.id.content)).getChildAt(0);
        } else {
            this.j = viewGroup;
        }
        for (int i = 0; i < this.j.getChildCount(); i++) {
            if (this.j.getChildAt(i).getId() != view.getId() && this.j.getChildAt(i).getVisibility() == 0) {
                this.j.getChildAt(i).setVisibility(8);
                this.l.add(Integer.valueOf(this.j.getChildAt(i).getId()));
            }
        }
        if (this.k == null) {
            this.k = LayoutInflater.from(this.f147c).inflate(com.rtk.app.R.layout.auto_max_footview_load_layout, (ViewGroup) null);
        }
        this.k.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (this.m == null) {
            this.m = (ViewGroup) LayoutInflater.from(this.f147c).inflate(com.rtk.app.R.layout.auto_no_interner_layout, (ViewGroup) null);
        }
        this.m.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (this.n == null) {
            this.n = (ViewGroup) LayoutInflater.from(this.f147c).inflate(com.rtk.app.R.layout.auto_src_dissmiss_layout, (ViewGroup) null);
        }
        this.n.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.j.addView(this.k);
    }

    public void I(String str, s sVar) {
        if (str.equals(y.E)) {
            c0.u("BaseActivity", "确定是没网络");
            H(sVar);
            return;
        }
        try {
            if (this.p) {
                return;
            }
            this.o = sVar;
            E();
            this.j.addView(this.n);
            ((TextView) this.n.getChildAt(1)).setText(t.O1(str));
            this.n.getChildAt(2).setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.base.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseActivity.this.C(view);
                }
            });
        } catch (Exception unused) {
        }
    }

    public void J() {
        DialogPhoto dialogPhoto = this.d;
        if (dialogPhoto != null) {
            dialogPhoto.dismiss();
        }
        this.f = m.a(this.f147c);
        this.e = m.d(this.f147c);
    }

    public void K() {
        DialogPhoto dialogPhoto = this.d;
        if (dialogPhoto != null) {
            dialogPhoto.dismiss();
        }
        this.f = m.a(this.f147c);
        m.e(this.f147c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
        com.rtk.app.tool.c.c();
        super/*android.app.Activity*/.finish();
        try {
            if (this.b != null) {
                x.c().n(this.b);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(i, i2, intent);
        c0.u("BaseActivity", "BaseActivity   onActivityResult  被执行" + i + "      " + i2);
        if (i == 999 && z()) {
            y();
        }
        if (i2 != 100023) {
            return;
        }
        this.h = intent.getBooleanExtra("isLoginSuccer", false);
        this.i = intent.getBooleanExtra("isLoginOpen", false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        overridePendingTransition(com.rtk.app.R.anim.push_left_in, com.rtk.app.R.anim.push_left_out);
        if (y.F()) {
            setTheme(com.rtk.app.R.style.AppTheme_day);
        } else {
            setTheme(com.rtk.app.R.style.AppTheme_night);
        }
        if (q()) {
            com.gyf.immersionbar.h e0 = com.gyf.immersionbar.h.e0(this);
            e0.n(true);
            e0.b0();
            e0.C();
        }
        super.onCreate(bundle);
        this.f147c = this;
        this.g = new GsonBuilder().enableComplexMapKeySerialization().create();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super/*androidx.fragment.app.FragmentActivity*/.onNewIntent(intent);
        A();
        if (z()) {
            y();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.custom.SwipeBackActivity
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this.f147c);
    }

    protected void onPostCreate(@Nullable Bundle bundle) {
        super.onPostCreate(bundle);
        A();
        if (z()) {
            y();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super/*androidx.fragment.app.FragmentActivity*/.onRequestPermissionsResult(i, strArr, iArr);
        c0.u("BaseActivity", "存储权限requestCode" + i + "     " + iArr.length);
        if (i != 10000) {
            return;
        }
        for (int i2 : iArr) {
            if (i2 != 0) {
                new DialogPermision(MyApplication.b(), t.U(this)).show();
                return;
            }
        }
        y();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onResume() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - 600 <= DialogForInstallPermission.l) {
            new DialogForInstallPermission(this.f147c).show();
        }
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        MyApplication.f(this.f147c);
        MobclickAgent.onResume(this.f147c);
        if (this.i) {
            this.i = false;
        }
        if (com.rtk.app.tool.g.e.c().i() && !com.rtk.app.tool.g.e.c().g(this)) {
            com.rtk.app.tool.g.d.c(this.f147c).e(com.rtk.app.c.d.b(), currentTimeMillis, (currentTimeMillis - com.rtk.app.tool.g.e.c().b()) + com.rtk.app.tool.g.e.c().d());
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
            t.G(this.f147c);
        }
    }

    public int v() {
        Resources resources = getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelOffset(identifier);
        }
        return 0;
    }

    public <T> T w(String str, Class<T> cls) {
        return (T) this.g.fromJson(str, cls);
    }

    protected List<View> x() {
        return null;
    }

    protected boolean z() {
        return true;
    }
}
