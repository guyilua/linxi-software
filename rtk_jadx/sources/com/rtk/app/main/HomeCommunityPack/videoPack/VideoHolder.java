package com.rtk.app.main.HomeCommunityPack.videoPack;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.c;
import com.bumptech.glide.i;
import com.rtk.app.main.MyApplication;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.t;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.TxVideoPlayerController;
import com.xiao.nicevideoplayer.VideoBean;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class VideoHolder implements View.OnClickListener {
    private TxVideoPlayerController a;
    private VideoBean b;

    /* renamed from: c, reason: collision with root package name */
    private View f200c;

    @BindView
    public ImageView postCreatVideoMute;

    @BindView
    public FrameLayout postCreateVideoFragmentLayout;

    @BindView
    public NiceVideoPlayer postCreateVideoNiceVideo;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements TxVideoPlayerController.CallBack {
        a(VideoHolder videoHolder) {
        }

        public void callBack() {
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c0.u("VideoHolder", "视频地址" + VideoHolder.this.b.getVideoUrl());
            t.y((Activity) MyApplication.b(), VideoHolder.this.b);
        }
    }

    public VideoHolder(View view, VideoBean videoBean) {
        ButterKnife.b(this, view);
        this.b = videoBean;
        this.f200c = view;
        b();
        TxVideoPlayerController txVideoPlayerController = new TxVideoPlayerController(MyApplication.b(), new a(this));
        this.a = txVideoPlayerController;
        this.postCreateVideoNiceVideo.setController(txVideoPlayerController);
        this.a.setTitle(videoBean.getTitle());
        this.a.imageView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        i q = c.t(MyApplication.b()).q(videoBean.getImageUrl());
        q.a(t.O());
        q.l(this.a.imageView());
        this.postCreateVideoNiceVideo.setUp(videoBean.getVideoUrl(), (Map) null);
        this.a.mFullScreen.setOnClickListener(new b());
        this.postCreatVideoMute.setSelected(false);
    }

    private void b() {
        this.postCreateVideoFragmentLayout.setOnClickListener(this);
        this.postCreatVideoMute.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        view.getId();
    }
}
