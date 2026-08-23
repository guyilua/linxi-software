package com.rtk.app.tool.b0;

import android.text.TextUtils;
import android.widget.TextView;
import com.rtk.app.bean.MyAttentionBean;
import com.rtk.app.bean.OtherImformationBean;
import com.rtk.app.bean.UpApkDetailsBean;
import com.rtk.app.bean.UserRankBean;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.g.h;
import com.rtk.app.tool.t;

/* compiled from: MyUserSubject.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a implements c {
    private TextView a;
    private TextView b;

    /* renamed from: c, reason: collision with root package name */
    private int f298c;
    private h d;

    public a(String str, String str2, TextView textView, h hVar) {
        this.a = textView;
        this.d = hVar;
        this.f298c = Integer.parseInt(str);
        Object tag = textView.getTag();
        if (tag != null) {
            h hVar2 = (h) tag;
            if (hVar2.b() != null) {
                b.b().c(hVar2.b());
            }
        }
        hVar.g(this);
        t.H1(textView, str2);
        textView.setTag(hVar);
    }

    @Override // com.rtk.app.tool.b0.c
    public void a(int i, int i2) {
        if (i == this.f298c) {
            t.H1(this.a, i2 + "");
            h hVar = (h) this.a.getTag();
            this.d = hVar;
            MyAttentionBean.DataBean a = hVar.a();
            OtherImformationBean.DataBean c2 = this.d.c();
            UpApkDetailsBean.DataBean d = this.d.d();
            UserRankBean.DataBean e = this.d.e();
            if (a != null) {
                a.setFollowed(i2 + "");
                if (TextUtils.isEmpty(a.getNotename())) {
                    this.b.setVisibility(8);
                } else {
                    this.b.setVisibility(0);
                    this.b.setText("备注：" + a.getNotename());
                }
            }
            if (c2 != null) {
                c2.setFollowed(i2 + "");
            }
            if (d != null) {
                d.setFollowed(i2);
            }
            c0.u("MyUserSubject", "修改关注状态");
            if (e != null) {
                e.setFollowed(i2);
                c0.u("MyUserSubject", "修改关注状态成功");
                if (this.b == null) {
                    return;
                }
                if (TextUtils.isEmpty(e.getNotename())) {
                    this.b.setVisibility(8);
                    return;
                }
                this.b.setVisibility(0);
                this.b.setText("备注：" + e.getNotename());
            }
        }
    }

    public a(String str, String str2, TextView textView, TextView textView2, h hVar) {
        this(str, str2, textView, hVar);
        this.b = textView2;
    }
}
