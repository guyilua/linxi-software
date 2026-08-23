package com.sigmob.sdk.base.views;

import android.content.Context;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.logger.SigmobLog;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class af extends RelativeLayout {
    int a;
    boolean b;

    /* renamed from: c, reason: collision with root package name */
    private final w f449c;
    private final w d;
    private int e;

    public af(Context context) {
        super(context);
        this.a = 0;
        this.b = false;
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.f449c = new w(context);
        w wVar = new w(context);
        this.d = wVar;
        setLayoutParams(layoutParams);
        int i = this.a;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i);
        layoutParams2.addRule(9);
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams2.addRule(20);
        }
        wVar.setId(ClientMetadata.generateViewId());
        addView(wVar, layoutParams2);
    }

    public void a(int i) {
        this.e = i;
        if (!this.b) {
            if (i > 0) {
                this.d.setText(String.valueOf(i));
            }
        } else if (i > 0) {
            this.f449c.setText(com.sigmob.sdk.base.g.d(Integer.valueOf(i)));
            if (this.f449c.getVisibility() != 0) {
                this.f449c.setVisibility(0);
            }
        }
    }

    public boolean a() {
        return this.b;
    }

    public void b() {
        if (this.b) {
            return;
        }
        this.b = true;
        SigmobLog.d("show skip widget");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.a);
        this.f449c.setVisibility(0);
        this.d.setVisibility(8);
        w wVar = this.f449c;
        int i = this.a;
        wVar.setPadding((int) (i / 3.0f), 0, (int) (i / 3.0f), 0);
        int i2 = this.e;
        if (i2 > 0) {
            this.f449c.setText(com.sigmob.sdk.base.g.d(Integer.valueOf(i2)));
        } else {
            this.f449c.setText(com.sigmob.sdk.base.g.i());
        }
        addView(this.f449c, layoutParams);
    }

    public int getTime() {
        return this.e;
    }
}
