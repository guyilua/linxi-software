package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.smtt.export.external.DexLoader;

/* compiled from: TbsVideoView.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
class q extends FrameLayout implements MediaPlayer.OnErrorListener {
    private Object a;
    private s b;

    /* renamed from: c, reason: collision with root package name */
    private VideoView f967c;
    private Context d;
    private String e;

    public q(Context context) {
        super(context.getApplicationContext());
        this.d = null;
        this.d = context;
    }

    private void b(Bundle bundle, Object obj) {
        boolean z;
        a();
        if (b()) {
            bundle.putInt("callMode", bundle.getInt("callMode"));
            z = this.b.a(this.a, bundle, this, obj);
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        VideoView videoView = this.f967c;
        if (videoView != null) {
            videoView.stopPlayback();
        }
        if (this.f967c == null) {
            this.f967c = new VideoView(getContext());
        }
        String string = bundle.getString("videoUrl");
        this.e = string;
        this.f967c.setVideoURI(Uri.parse(string));
        this.f967c.setOnErrorListener(this);
        Intent intent = new Intent("com.tencent.smtt.tbs.video.PLAY");
        intent.addFlags(268435456);
        Context applicationContext = getContext().getApplicationContext();
        intent.setPackage(applicationContext.getPackageName());
        applicationContext.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Bundle bundle, Object obj) {
        b(bundle, obj);
    }

    public void c() {
        if (b()) {
            this.b.a(this.a);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        try {
            Context context = this.d;
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            }
            Context context2 = getContext();
            if (context2 != null) {
                Toast.makeText(context2, "播放失败，请选择其它播放器播放", 1).show();
                Context applicationContext = context2.getApplicationContext();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(268435456);
                intent.setDataAndType(Uri.parse(this.e), "video/*");
                applicationContext.startActivity(intent);
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        setBackgroundColor(-16777216);
        if (this.b == null) {
            d.a(true).a(getContext().getApplicationContext(), false, false);
            r a = d.a(true).a();
            DexLoader b = a != null ? a.b() : null;
            if (b != null && QbSdk.canLoadVideo(getContext())) {
                this.b = new s(b);
            }
        }
        s sVar = this.b;
        if (sVar == null || this.a != null) {
            return;
        }
        this.a = sVar.a(getContext().getApplicationContext());
    }

    public void a(Activity activity) {
        VideoView videoView;
        if (b() || (videoView = this.f967c) == null) {
            return;
        }
        if (videoView.getParent() == null) {
            Window window = activity.getWindow();
            FrameLayout frameLayout = (FrameLayout) window.getDecorView();
            window.addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            window.addFlags(128);
            frameLayout.setBackgroundColor(-16777216);
            MediaController mediaController = new MediaController(activity);
            mediaController.setMediaPlayer(this.f967c);
            this.f967c.setMediaController(mediaController);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            frameLayout.addView(this.f967c, layoutParams);
        }
        if (Build.VERSION.SDK_INT >= 8) {
            this.f967c.start();
        }
    }

    public boolean b() {
        return (this.b == null || this.a == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Activity activity, int i) {
        VideoView videoView;
        VideoView videoView2;
        if (i == 3 && !b() && (videoView2 = this.f967c) != null) {
            videoView2.pause();
        }
        if (i == 4) {
            this.d = null;
            if (!b() && (videoView = this.f967c) != null) {
                videoView.stopPlayback();
                this.f967c = null;
            }
        }
        if (i == 2 && !b()) {
            this.d = activity;
            a(activity);
        }
        if (b()) {
            this.b.a(this.a, activity, i);
        }
    }
}
