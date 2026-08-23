package com.sigmob.sdk.newInterstitial;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.sigmob.sdk.base.views.s;
import com.sigmob.sdk.base.views.w;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class NewInterstitialHeaderView extends RelativeLayout {
    private ImageView a;
    private TextView b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f625c;
    private int d;
    private Runnable e;
    private w f;
    private boolean g;
    private View h;
    private a i;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a();

        void b();
    }

    public NewInterstitialHeaderView(Context context) {
        super(context);
        a(context);
    }

    public NewInterstitialHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public NewInterstitialHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        View inflate = RelativeLayout.inflate(context, ResourceUtil.getLayoutId(context, "sig_new_interstitial_header_layout"), this);
        this.a = (ImageView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_close"));
        this.h = inflate.findViewById(ResourceUtil.getId(context, "sig_ad_rl_root"));
        ImageView imageView = this.a;
        if (imageView != null) {
            imageView.setImageBitmap(s.CLOSE_OLD.a());
        }
        this.f625c = (ImageView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_sound"));
        TextView textView = (TextView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_timer"));
        this.b = textView;
        textView.setClickable(false);
        this.e = new Runnable() { // from class: com.sigmob.sdk.newInterstitial.NewInterstitialHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (NewInterstitialHeaderView.this.d > 0) {
                    NewInterstitialHeaderView.this.b.setText(String.valueOf(NewInterstitialHeaderView.b(NewInterstitialHeaderView.this)));
                    NewInterstitialHeaderView.this.b.postDelayed(NewInterstitialHeaderView.this.e, 1000L);
                    return;
                }
                if (NewInterstitialHeaderView.this.g) {
                    if (NewInterstitialHeaderView.this.i != null) {
                        NewInterstitialHeaderView.this.i.a();
                    }
                    NewInterstitialHeaderView.this.b.setVisibility(8);
                    NewInterstitialHeaderView.this.a.setVisibility(0);
                } else {
                    if (NewInterstitialHeaderView.this.i != null) {
                        NewInterstitialHeaderView.this.i.b();
                    }
                    NewInterstitialHeaderView.this.b.setClickable(true);
                    NewInterstitialHeaderView.this.b.setText("   跳过   ");
                }
                NewInterstitialHeaderView.this.removeCallbacks(this);
            }
        };
    }

    static /* synthetic */ int b(NewInterstitialHeaderView newInterstitialHeaderView) {
        int i = newInterstitialHeaderView.d;
        newInterstitialHeaderView.d = i - 1;
        return i;
    }

    public void hideSoundIcon() {
        this.f625c.setVisibility(8);
    }

    public void setAdHeaderViewStateListener(a aVar) {
        this.i = aVar;
    }

    public void setCloseClickListener(View.OnClickListener onClickListener) {
        this.a.setOnClickListener(onClickListener);
    }

    public void setSkipClickListener(View.OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
    }

    public void setSoundClickListener(View.OnClickListener onClickListener) {
        this.f625c.setOnClickListener(onClickListener);
    }

    public void setSoundStatus(boolean z) {
        ImageView imageView;
        Context context;
        String str;
        if (z) {
            imageView = this.f625c;
            context = getContext();
            str = "sig_image_video_mute";
        } else {
            imageView = this.f625c;
            context = getContext();
            str = "sig_image_video_unmute";
        }
        imageView.setImageResource(ResourceUtil.getDrawableId(context, str));
    }

    public void showCloseView() {
        this.a.setVisibility(0);
    }

    public void showFeedback(boolean z, View.OnClickListener onClickListener) {
        if (this.f == null) {
            Context context = getContext();
            w wVar = new w(context);
            this.f = wVar;
            wVar.setText("反馈");
            this.f.setOnClickListener(onClickListener);
            this.f.setId(ClientMetadata.generateViewId());
            int dipsToIntPixels = Dips.dipsToIntPixels(5.0f, context);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(45.0f, context), Dips.dipsToIntPixels(30.0f, context));
            if (z) {
                layoutParams.addRule(9);
                ((RelativeLayout.LayoutParams) this.f625c.getLayoutParams()).addRule(1, this.f.getId());
                layoutParams.setMargins(dipsToIntPixels, 0, 0, 0);
            } else {
                layoutParams.addRule(0, this.h.getId());
                layoutParams.setMargins(0, 0, dipsToIntPixels, 0);
            }
            layoutParams.addRule(4, this.h.getId());
            ViewParent parent = this.h.getParent();
            if (parent != null) {
                ((ViewGroup) parent).addView(this.f, layoutParams);
            }
        }
    }

    public void showSoundIcon() {
        this.f625c.setVisibility(0);
    }

    public void startAdTimer(int i, boolean z) {
        this.g = z;
        if (i > 0) {
            this.b.setVisibility(0);
            this.b.setText(String.valueOf(i));
            this.d = i - 1;
            this.b.setClickable(false);
            this.b.postDelayed(this.e, 1000L);
            return;
        }
        if (z) {
            showCloseView();
            a aVar = this.i;
            if (aVar != null) {
                aVar.a();
            }
            this.b.setVisibility(8);
            return;
        }
        a aVar2 = this.i;
        if (aVar2 != null) {
            aVar2.b();
        }
        this.b.setClickable(true);
        this.b.setText("   跳过   ");
    }
}
