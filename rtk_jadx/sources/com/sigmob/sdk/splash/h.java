package com.sigmob.sdk.splash;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class h extends d {
    private final com.sigmob.sdk.base.views.c b;

    /* renamed from: c, reason: collision with root package name */
    private final BaseAdUnit f645c;

    public h(Context context, BaseAdUnit baseAdUnit) {
        super(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        com.sigmob.sdk.base.views.c cVar = new com.sigmob.sdk.base.views.c(context);
        this.b = cVar;
        setBackgroundColor(-16777216);
        this.f645c = baseAdUnit;
        addView(cVar, layoutParams);
    }

    @Override // com.sigmob.sdk.splash.d
    public void a() {
        super.setVisibility(0);
        SigmobLog.i("video showAd");
        this.b.setVisibility(0);
        this.b.d();
    }

    @Override // com.sigmob.sdk.splash.d
    public boolean a(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null || baseAdUnit.getSplashFilePath() == null) {
            SigmobLog.e("adUnit or splashFilePath is null");
            return false;
        }
        String splashFilePath = baseAdUnit.getSplashFilePath();
        this.b.a(0, 0);
        this.b.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.sigmob.sdk.splash.h.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                h.this.a = mediaPlayer.getDuration() / 1000;
                mediaPlayer.setVolume(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
                mediaPlayer.start();
                BaseBroadcastReceiver.a(h.this.getContext(), h.this.f645c.getUuid(), IntentActions.ACTION_INTERSTITIAL_SHOW);
                SigmobLog.i("video onPrepared");
            }
        });
        this.b.setVideoPath(splashFilePath);
        return true;
    }

    @Override // com.sigmob.sdk.splash.d
    public void b() {
        this.b.a();
    }

    @Override // com.sigmob.sdk.splash.d
    public void c() {
        this.b.b();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 8) {
            try {
                if (this.b != null) {
                    SigmobLog.i("video GONE");
                    this.b.c();
                    removeAllViews();
                }
            } catch (Throwable th) {
                SigmobLog.e("set splash ad video content error: " + th.getMessage());
            }
        }
        super.setVisibility(i);
    }
}
