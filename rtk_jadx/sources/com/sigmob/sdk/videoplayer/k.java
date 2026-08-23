package com.sigmob.sdk.videoplayer;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class k extends j implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
    private static final String f = "VideoPlayerMediaSystem";
    public MediaPlayer e;
    private boolean g;

    public k(i iVar) {
        super(iVar);
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public void a() {
        Handler handler = this.b;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.sigmob.sdk.videoplayer.k.6
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayer mediaPlayer = k.this.e;
                if (mediaPlayer == null) {
                    return;
                }
                mediaPlayer.start();
            }
        });
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public void a(final float f2) {
        Handler handler = this.b;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.sigmob.sdk.videoplayer.k.10
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayer mediaPlayer = k.this.e;
                if (mediaPlayer == null) {
                    return;
                }
                float f3 = f2;
                mediaPlayer.setVolume(f3, f3);
            }
        });
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public void a(final long j) {
        Handler handler = this.b;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.sigmob.sdk.videoplayer.k.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MediaPlayer mediaPlayer = k.this.e;
                    if (mediaPlayer == null) {
                        return;
                    }
                    mediaPlayer.seekTo((int) j);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public void a(Surface surface) {
        MediaPlayer mediaPlayer = this.e;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.setSurface(surface);
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public void a(boolean z) {
        MediaPlayer mediaPlayer = this.e;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.setLooping(z);
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public void b() {
        c();
        this.g = true;
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public void b(float f2) {
        MediaPlayer mediaPlayer = this.e;
        if (mediaPlayer != null && Build.VERSION.SDK_INT >= 23) {
            PlaybackParams playbackParams = mediaPlayer.getPlaybackParams();
            playbackParams.setSpeed(f2);
            this.e.setPlaybackParams(playbackParams);
        }
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public void c() {
        MediaPlayer mediaPlayer;
        if (this.g && (mediaPlayer = this.e) != null && this.a != null) {
            this.g = false;
            mediaPlayer.setSurface(new Surface(this.a));
            return;
        }
        f();
        this.f682c = new Handler();
        Handler iOHandler = ThreadPoolFactory.BackgroundThreadPool.getInstance().getIOHandler();
        this.b = iOHandler;
        iOHandler.post(new Runnable() { // from class: com.sigmob.sdk.videoplayer.k.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h videoPlayerDataSource = k.this.d.getVideoPlayerDataSource();
                    k.this.e = new MediaPlayer();
                    k.this.e.setAudioStreamType(3);
                    k.this.e.setLooping(videoPlayerDataSource.e);
                    k kVar = k.this;
                    kVar.e.setOnPreparedListener(kVar);
                    k kVar2 = k.this;
                    kVar2.e.setOnCompletionListener(kVar2);
                    k kVar3 = k.this;
                    kVar3.e.setOnBufferingUpdateListener(kVar3);
                    k.this.e.setScreenOnWhilePlaying(true);
                    k kVar4 = k.this;
                    kVar4.e.setOnSeekCompleteListener(kVar4);
                    k kVar5 = k.this;
                    kVar5.e.setOnErrorListener(kVar5);
                    k kVar6 = k.this;
                    kVar6.e.setOnInfoListener(kVar6);
                    k kVar7 = k.this;
                    kVar7.e.setOnVideoSizeChangedListener(kVar7);
                    MediaPlayer.class.getDeclaredMethod("setDataSource", String.class, Map.class).invoke(k.this.e, videoPlayerDataSource.a().toString(), videoPlayerDataSource.d);
                    k.this.e.prepareAsync();
                    k kVar8 = k.this;
                    if (kVar8.a != null) {
                        kVar8.g = false;
                        k.this.e.setSurface(new Surface(k.this.a));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    k.this.f682c.post(new Runnable() { // from class: com.sigmob.sdk.videoplayer.k.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i iVar = k.this.d;
                            if (iVar != null) {
                                iVar.a(0, 0);
                            }
                        }
                    });
                }
            }
        });
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public void d() {
        Handler handler = this.b;
        if (handler == null || this.e == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.sigmob.sdk.videoplayer.k.7
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayer mediaPlayer = k.this.e;
                if (mediaPlayer == null) {
                    return;
                }
                mediaPlayer.pause();
            }
        });
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public boolean e() {
        MediaPlayer mediaPlayer = this.e;
        if (mediaPlayer == null) {
            return false;
        }
        return mediaPlayer.isPlaying();
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public void f() {
        final MediaPlayer mediaPlayer;
        Handler handler = this.b;
        if (handler == null || (mediaPlayer = this.e) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.sigmob.sdk.videoplayer.k.9
            @Override // java.lang.Runnable
            public void run() {
                mediaPlayer.setSurface(null);
                mediaPlayer.release();
                k.this.b = null;
            }
        });
        this.e = null;
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public long g() {
        if (this.e != null) {
            return r0.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public int h() {
        MediaPlayer mediaPlayer = this.e;
        if (mediaPlayer == null) {
            return 0;
        }
        mediaPlayer.getVideoWidth();
        return 0;
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public int i() {
        MediaPlayer mediaPlayer = this.e;
        if (mediaPlayer == null) {
            return 0;
        }
        mediaPlayer.getVideoHeight();
        return 0;
    }

    @Override // com.sigmob.sdk.videoplayer.j
    public long j() {
        if (this.e != null) {
            return r0.getDuration();
        }
        return 0L;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, final int i) {
        Handler handler = this.f682c;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.sigmob.sdk.videoplayer.k.13
            @Override // java.lang.Runnable
            public void run() {
                i iVar = k.this.d;
                if (iVar == null) {
                    return;
                }
                iVar.setBufferProgress(i);
            }
        });
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        Handler handler = this.f682c;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.sigmob.sdk.videoplayer.k.12
            @Override // java.lang.Runnable
            public void run() {
                i iVar = k.this.d;
                if (iVar == null) {
                    return;
                }
                iVar.p();
            }
        });
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, final int i, final int i2) {
        Handler handler = this.f682c;
        if (handler == null) {
            return false;
        }
        handler.post(new Runnable() { // from class: com.sigmob.sdk.videoplayer.k.3
            @Override // java.lang.Runnable
            public void run() {
                i iVar = k.this.d;
                if (iVar == null) {
                    return;
                }
                iVar.a(i, i2);
            }
        });
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, final int i, final int i2) {
        Handler handler = this.f682c;
        if (handler != null && this.d != null) {
            handler.post(new Runnable() { // from class: com.sigmob.sdk.videoplayer.k.4
                @Override // java.lang.Runnable
                public void run() {
                    i iVar = k.this.d;
                    if (iVar == null) {
                        return;
                    }
                    iVar.b(i, i2);
                }
            });
        }
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Handler handler = this.f682c;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.sigmob.sdk.videoplayer.k.11
            @Override // java.lang.Runnable
            public void run() {
                i iVar = k.this.d;
                if (iVar == null) {
                    return;
                }
                iVar.o();
            }
        });
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        Handler handler = this.f682c;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.sigmob.sdk.videoplayer.k.2
            @Override // java.lang.Runnable
            public void run() {
                i iVar = k.this.d;
                if (iVar == null) {
                    return;
                }
                iVar.q();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        i iVar = this.d;
        if (iVar == null) {
            return;
        }
        SurfaceTexture surfaceTexture2 = this.a;
        if (surfaceTexture2 != null) {
            iVar.setSurfaceTexture(surfaceTexture2);
        } else {
            this.a = surfaceTexture;
            c();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, final int i, final int i2) {
        Handler handler = this.f682c;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.sigmob.sdk.videoplayer.k.5
            @Override // java.lang.Runnable
            public void run() {
                i iVar = k.this.d;
                if (iVar == null) {
                    return;
                }
                iVar.c(i, i2);
            }
        });
    }
}
