package com.sigmob.sdk.newInterstitial;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.utils.ResourceUtil;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f extends RelativeLayout {
    private View a;

    public f(Context context) {
        super(context);
    }

    public void a(int i) {
        this.a = RelativeLayout.inflate(getContext(), i, this);
    }

    public SigAdInfoView getAdInfView() {
        View view = this.a;
        if (view != null) {
            return (SigAdInfoView) view.findViewById(ResourceUtil.getId(getContext(), "sig_app_info"));
        }
        return null;
    }

    public Button getCTAButton() {
        View view = this.a;
        if (view != null) {
            return (Button) view.findViewById(ResourceUtil.getId(getContext(), "sig_cta_button"));
        }
        return null;
    }

    public NewInterstitialHeaderView getHeaderView() {
        View view = this.a;
        if (view != null) {
            return (NewInterstitialHeaderView) view.findViewById(ResourceUtil.getId(getContext(), "sig_ad_header"));
        }
        return null;
    }

    public ViewGroup getMainAdContainer() {
        View view = this.a;
        if (view != null) {
            return (ViewGroup) view.findViewById(ResourceUtil.getId(getContext(), "sig_ad_container"));
        }
        return null;
    }
}
