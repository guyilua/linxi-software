package com.sigmob.sdk.nativead;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.ResourceUtil;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class k extends RelativeLayout {
    private TextView a;
    private TextView b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f613c;
    private TextView d;
    private TextView e;
    private TextView f;

    public k(Context context) {
        super(context);
        View.inflate(context, getLayoutId(), this);
        this.a = (TextView) findViewById(ResourceUtil.getId(getContext(), "sig_app_info_name"));
        this.f613c = (TextView) findViewById(ResourceUtil.getId(getContext(), "sig_app_info_ver"));
        this.d = (TextView) findViewById(ResourceUtil.getId(getContext(), "sig_app_info_dev"));
        this.e = (TextView) findViewById(ResourceUtil.getId(getContext(), "sig_app_info_privacy"));
        this.f = (TextView) findViewById(ResourceUtil.getId(getContext(), "sig_app_info_permissions"));
        this.b = (TextView) findViewById(ResourceUtil.getId(getContext(), "sig_app_info_product"));
        this.f613c.getPaint().setFlags(8);
        this.f613c.getPaint().setAntiAlias(true);
        this.a.getPaint().setFlags(8);
        this.a.getPaint().setAntiAlias(true);
        this.d.getPaint().setFlags(8);
        this.d.getPaint().setAntiAlias(true);
        this.e.getPaint().setFlags(8);
        this.e.getPaint().setAntiAlias(true);
        this.f.getPaint().setFlags(8);
        this.f.getPaint().setAntiAlias(true);
        this.b.getPaint().setFlags(8);
        this.b.getPaint().setAntiAlias(true);
    }

    private int getLayoutId() {
        return ResourceUtil.getLayoutId(getContext(), "sig_app_info_layout");
    }

    public void a(String str, String str2) {
    }
}
