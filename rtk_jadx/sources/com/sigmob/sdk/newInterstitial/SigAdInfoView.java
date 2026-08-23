package com.sigmob.sdk.newInterstitial;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.ResourceUtil;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SigAdInfoView extends RelativeLayout {
    private ImageView a;
    private TextView b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f626c;
    private SigAdPrivacyInfoView d;
    private boolean e;

    public SigAdInfoView(Context context) {
        super(context);
        this.e = false;
        a(context);
    }

    public SigAdInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = false;
        this.e = attributeSet.getAttributeBooleanValue(null, "sig_isSmall", false);
        a(context);
    }

    public SigAdInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = false;
        a(context);
    }

    private void a(Context context) {
        View inflate = RelativeLayout.inflate(context, ResourceUtil.getLayoutId(context, this.e ? "sig_ad_app_info_small_layout" : "sig_ad_app_info_layout"), this);
        this.a = (ImageView) inflate.findViewById(ResourceUtil.getId(context, "sig_app_icon"));
        this.b = (TextView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_title"));
        this.f626c = (TextView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_desc"));
        this.d = (SigAdPrivacyInfoView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_privacy_info"));
    }

    public SigAdPrivacyInfoView getAdPrivacyInfo() {
        return this.d;
    }

    public void setAppInfoView(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            com.sigmob.sdk.base.common.h.a().load(str).into(this.a);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.b.setText(str2);
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        this.f626c.setText(str3);
    }
}
