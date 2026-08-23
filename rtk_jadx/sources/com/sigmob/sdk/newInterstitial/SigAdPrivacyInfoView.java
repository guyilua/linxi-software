package com.sigmob.sdk.newInterstitial;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.ResourceUtil;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SigAdPrivacyInfoView extends LinearLayout {
    private ImageView a;
    private View b;

    /* renamed from: c, reason: collision with root package name */
    private View f627c;
    private LinearLayout d;
    private TextView e;

    public SigAdPrivacyInfoView(Context context) {
        super(context);
        a(context);
    }

    public SigAdPrivacyInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public SigAdPrivacyInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        View inflate = LinearLayout.inflate(context, ResourceUtil.getLayoutId(context, "sig_ad_privacy_layout"), this);
        this.a = (ImageView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_privacy_ad_logo"));
        this.b = inflate.findViewById(ResourceUtil.getId(context, "sig_ad_privacy_view"));
        this.f627c = inflate.findViewById(ResourceUtil.getId(context, "sig_ad_privacy_ll"));
        this.e = (TextView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_privacy_ad_text"));
    }

    public void a(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            com.sigmob.sdk.base.common.h.a().load(str).into(this.a);
        }
        this.b.setVisibility(z ? 0 : 8);
    }

    public TextView getPrivacyAdText() {
        return this.e;
    }

    public View getPrivacyLl() {
        return this.f627c;
    }
}
