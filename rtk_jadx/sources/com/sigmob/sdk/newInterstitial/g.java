package com.sigmob.sdk.newInterstitial;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.sigmob.sdk.base.views.s;
import com.sigmob.sdk.base.views.w;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class g extends RelativeLayout {
    private ImageView a;
    private ImageView b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f633c;
    private TextView d;
    private Button e;
    private ImageView f;
    private SigAdPrivacyInfoView g;
    private w h;
    private View i;

    public g(Context context) {
        super(context);
        a(context);
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        View inflate = RelativeLayout.inflate(context, ResourceUtil.getLayoutId(context, "sig_new_interstitial_endcard_layout"), this);
        this.i = inflate.findViewById(ResourceUtil.getId(context, "sig_ad_rl_close"));
        ImageView imageView = (ImageView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_close"));
        this.a = imageView;
        if (imageView != null) {
            imageView.setImageBitmap(s.CLOSE_OLD.a());
        }
        this.b = (ImageView) inflate.findViewById(ResourceUtil.getId(context, "sig_app_icon"));
        this.f633c = (TextView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_title"));
        this.d = (TextView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_desc"));
        this.e = (Button) inflate.findViewById(ResourceUtil.getId(context, "sig_cta_button"));
        this.f = (ImageView) inflate.findViewById(ResourceUtil.getId(context, "sig_endCard_image"));
        this.g = (SigAdPrivacyInfoView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_privacy_info"));
    }

    public void a(View.OnClickListener onClickListener) {
        if (this.h == null) {
            Context context = getContext();
            w wVar = new w(context);
            this.h = wVar;
            wVar.setText("反馈");
            this.h.setOnClickListener(onClickListener);
            this.h.setId(ClientMetadata.generateViewId());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(45.0f, context), Dips.dipsToIntPixels(30.0f, context));
            layoutParams.addRule(0, this.i.getId());
            layoutParams.addRule(8, this.i.getId());
            ViewParent parent = this.i.getParent();
            if (parent != null) {
                ((ViewGroup) parent).addView(this.h, layoutParams);
            }
        }
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        if (!TextUtils.isEmpty(str)) {
            com.sigmob.sdk.base.common.h.a().load(str).into(this.b);
        }
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            com.sigmob.sdk.base.common.h.a().getBitmap(str, new ImageManager.BitmapLoadedListener() { // from class: com.sigmob.sdk.newInterstitial.g.1
                public void onBitmapLoadFailed() {
                }

                public void onBitmapLoaded(Bitmap bitmap) {
                    if (bitmap != null) {
                        com.sigmob.sdk.base.blurkit.a.a(g.this.getContext());
                        Bitmap a = com.sigmob.sdk.base.blurkit.a.a().a(bitmap.copy(bitmap.getConfig(), true), 25);
                        if (a != null) {
                            g.this.f.setImageBitmap(a);
                        }
                    }
                }
            });
        }
        if (!TextUtils.isEmpty(str3)) {
            this.f633c.setText(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            this.d.setText(str4);
        }
        if (TextUtils.isEmpty(str5)) {
            return;
        }
        this.e.setText(str5);
    }

    public SigAdPrivacyInfoView getAdPrivacyInfo() {
        return this.g;
    }

    public Button getCTAButton() {
        return this.e;
    }

    public View getCloseButton() {
        return this.a;
    }
}
