package com.rtk.app.main.HomeCommunityPack;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;
import com.xiao.nicevideoplayer.TxVideoPlayerController;
import com.xiao.nicevideoplayer.VideoBean;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class VideoDetailsActivity extends AppCompatActivity {
    private TxVideoPlayerController a;
    private VideoBean b;

    @BindView
    NiceVideoPlayer niceVideoPlayer;

    public void onBackPressed() {
        if (NiceVideoPlayerManager.instance().onBackPressd()) {
            return;
        }
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        setContentView(R.layout.activity_video_details);
        ButterKnife.a(this);
        this.b = getIntent().getExtras().getSerializable("videoBean");
        com.rtk.app.tool.c0.u("VideoDetailsActivity", " 视频地址   " + this.b.getVideoUrl());
        TxVideoPlayerController txVideoPlayerController = new TxVideoPlayerController(this, (TxVideoPlayerController.CallBack) null);
        this.a = txVideoPlayerController;
        this.niceVideoPlayer.setController(txVideoPlayerController);
        this.a.setTitle(this.b.getTitle());
        this.a.imageView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        com.bumptech.glide.i q = com.bumptech.glide.c.u(this).q(this.b.getImageUrl());
        q.a(com.rtk.app.tool.t.O());
        q.l(this.a.imageView());
        this.niceVideoPlayer.setUp(this.b.getVideoUrl(), (Map) null);
    }

    protected void onStop() {
        super.onStop();
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }
}
