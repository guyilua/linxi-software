package com.sigmob.sdk.nativead;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.sigmob.sdk.base.views.CircleImageView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class l extends RelativeLayout {
    private TextView a;
    private TextView b;

    /* renamed from: c, reason: collision with root package name */
    private ViewGroup f614c;
    private CircleImageView d;

    public l(Context context) {
        super(context);
        View.inflate(context, getLayoutId(), this);
        this.a = (TextView) findViewById(ResourceUtil.getId(getContext(), "sig_app_name"));
        this.b = (TextView) findViewById(ResourceUtil.getId(getContext(), "sig_app_cta"));
        this.f614c = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_app_icon"));
        CircleImageView circleImageView = new CircleImageView(context);
        this.d = circleImageView;
        circleImageView.setCircle(false);
        this.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f614c.addView(this.d, new ViewGroup.LayoutParams(-1, -1));
    }

    private int getLayoutId() {
        return ResourceUtil.getLayoutId(getContext(), "sig_app_layout");
    }

    public void a(String str, String str2, String str3) {
        this.a.setText(str2);
        this.b.setText(str3);
        ImageManager.with(getContext()).load(str).into(this.d);
    }

    public View getCtaView() {
        return this.b;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
    }
}
