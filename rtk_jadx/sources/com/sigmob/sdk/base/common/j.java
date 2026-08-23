package com.sigmob.sdk.base.common;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.logger.SigmobLog;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class j {
    protected String a;
    protected Context b;

    /* renamed from: c, reason: collision with root package name */
    protected RelativeLayout f388c;
    protected k d;
    protected g e;
    private ImageView f;
    private RelativeLayout g;
    private WindowInsets h;
    private WeakReference<Activity> i;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(Activity activity, String str, k kVar) {
        this.b = activity.getApplicationContext();
        this.i = new WeakReference<>(activity);
        this.a = str;
        this.d = kVar;
        this.f388c = new RelativeLayout(this.b);
    }

    private void a() {
        ViewGroup viewGroup;
        View childAt;
        Activity c2 = com.sigmob.sdk.b.c();
        ViewGroup m = m();
        if (c2 == null || m == null || (viewGroup = (ViewGroup) c2.getWindow().findViewById(R.id.content)) == null || (childAt = viewGroup.getChildAt(0)) == null) {
            return;
        }
        com.sigmob.sdk.base.blurkit.a.a(this.b);
        Bitmap a = com.sigmob.sdk.base.blurkit.a.a().a(childAt, 25);
        if (this.f == null) {
            this.f = new ImageView(this.b);
        }
        this.f.setImageBitmap(a);
    }

    public void a(int i, int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Context context, int i, Bundle bundle) {
        g gVar;
        if (bundle != null) {
            try {
                if (bundle.getBoolean(com.sigmob.sdk.base.k.x, false)) {
                    int i2 = context.getResources().getDisplayMetrics().widthPixels;
                    int i3 = context.getResources().getDisplayMetrics().heightPixels;
                    if (i == 6) {
                        int min = (Math.min(i2, i3) * 85) / 100;
                        gVar = new g((min * 16) / 9, min);
                    } else {
                        int min2 = (Math.min(i2, i3) * 85) / 100;
                        gVar = new g(min2, (min2 * 16) / 9);
                    }
                    this.e = gVar;
                    this.g = new RelativeLayout(context);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.e.a(), this.e.b());
                    layoutParams.addRule(13);
                    this.g.setLayoutParams(layoutParams);
                    this.f388c.removeAllViews();
                    this.f388c.addView(this.g);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public abstract void a(Configuration configuration);

    public abstract void a(Bundle bundle);

    public void a(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        Activity n = n();
        if (n == null || Build.VERSION.SDK_INT < 20) {
            return;
        }
        n.getWindow().getDecorView().setOnApplyWindowInsetsListener(onApplyWindowInsetsListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        String str2 = this.a;
        if (str2 != null) {
            BaseBroadcastReceiver.a(this.b, str2, str);
        } else {
            SigmobLog.w("Tried to broadcast a video event without a broadcast identifier to send to.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, int i) {
        String str2 = this.a;
        if (str2 != null) {
            BaseBroadcastReceiver.a(this.b, str2, str, i);
        } else {
            SigmobLog.w("Tried to broadcast a video event without a broadcast identifier to send to.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, Map<String, Object> map) {
        String str2 = this.a;
        if (str2 != null) {
            BaseBroadcastReceiver.a(this.b, str2, map, str, 0);
        } else {
            SigmobLog.w("Tried to broadcast a video event without a broadcast identifier to send to.");
        }
    }

    public void b() {
        WindowManager.LayoutParams attributes = n().getWindow().getAttributes();
        attributes.dimAmount = com.sigmob.sdk.base.blurkit.c.d;
        n().getWindow().setAttributes(attributes);
    }

    public void c() {
        try {
            a();
            ImageView imageView = this.f;
            if (imageView != null) {
                this.f388c.addView(imageView, 0, new ViewGroup.LayoutParams(-1, -1));
            }
        } catch (Throwable unused) {
        }
    }

    public void d() {
        try {
            ImageView imageView = this.f;
            if (imageView != null) {
                com.sigmob.sdk.base.utils.f.a(imageView);
                this.f = null;
            }
        } catch (Throwable unused) {
        }
    }

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public void h() {
        Activity n;
        this.d = null;
        this.h = null;
        if (Build.VERSION.SDK_INT >= 23 && (n = n()) != null) {
            n.getWindow().getDecorView().setOnApplyWindowInsetsListener(null);
        }
        RelativeLayout relativeLayout = this.f388c;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
    }

    public abstract void i();

    public boolean j() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public k k() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context l() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewGroup m() {
        RelativeLayout relativeLayout = this.g;
        return relativeLayout != null ? relativeLayout : this.f388c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Activity n() {
        Activity c2 = com.sigmob.sdk.base.utils.f.c(this.f388c);
        if (c2 != null) {
            return c2;
        }
        WeakReference<Activity> weakReference = this.i;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public abstract void o();
}
