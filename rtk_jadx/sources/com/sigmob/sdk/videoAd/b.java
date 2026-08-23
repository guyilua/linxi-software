package com.sigmob.sdk.videoAd;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.widget.VideoView;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import java.lang.reflect.Field;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b extends VideoView {
    private static final int b = 1;

    /* renamed from: c, reason: collision with root package name */
    private static final int f651c = Integer.MIN_VALUE;
    protected final MediaMetadataRetriever a;
    private int d;
    private int e;

    public b(Context context) {
        super(context);
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
        this.a = new MediaMetadataRetriever();
    }

    private void a(MediaPlayer mediaPlayer, Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i < 19 || i >= 28) {
            return;
        }
        try {
            Class<?> cls = Class.forName("android.media.MediaTimeProvider");
            Class<?> cls2 = Class.forName("android.media.SubtitleController");
            Class<?> cls3 = Class.forName("android.media.SubtitleController$Anchor");
            Object newInstance = cls2.getConstructor(Context.class, cls, Class.forName("android.media.SubtitleController$Listener")).newInstance(context, null, null);
            Field declaredField = cls2.getDeclaredField("mHandler");
            declaredField.setAccessible(true);
            declaredField.set(newInstance, new Handler());
            declaredField.setAccessible(false);
            mediaPlayer.getClass().getMethod("setSubtitleAnchor", cls2, cls3).invoke(mediaPlayer, newInstance, null);
        } catch (Throwable th) {
            SigmobLog.e("setSubtitleController error: ", th);
        }
    }

    private void b() {
        try {
            setOnClickListener(null);
            setOnCompletionListener(null);
            setOnErrorListener(null);
            setOnPreparedListener(null);
            Field declaredField = View.class.getDeclaredField("mContext");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                declaredField.set(this, null);
            }
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    public void a() {
        SigmobLog.d("BaseVideoView onDestroy() called");
        suspend();
        stopPlayback();
        com.sigmob.sdk.base.utils.f.a(this);
        b();
        super.destroyDrawingCache();
    }

    public void a(int i, int i2) {
        this.d = i;
        this.e = i2;
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        int defaultSize = VideoView.getDefaultSize(0, i);
        int defaultSize2 = VideoView.getDefaultSize(0, i2);
        int i3 = this.e;
        int i4 = this.d;
        if (defaultSize2 > defaultSize) {
            if (i3 <= i4) {
                defaultSize2 = (int) (defaultSize * (i3 / i4));
            }
        } else if (i3 > i4) {
            defaultSize = (int) (defaultSize2 * (i4 / i3));
        }
        int i5 = this.e;
        if (i5 != this.d) {
            setMeasuredDimension(defaultSize, defaultSize2);
        } else if (i5 == -1) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        } else {
            super.onMeasure(i, i2);
        }
    }

    public void setVolume(float f) {
        try {
            Field declaredField = Class.forName("android.widget.VideoView").getDeclaredField("mMediaPlayer");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                ((MediaPlayer) declaredField.get(this)).setVolume(f, f);
            }
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }
}
