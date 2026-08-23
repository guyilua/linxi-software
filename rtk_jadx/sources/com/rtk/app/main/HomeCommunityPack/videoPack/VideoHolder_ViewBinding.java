package com.rtk.app.main.HomeCommunityPack.videoPack;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.c.a;
import com.rtk.app.R;
import com.xiao.nicevideoplayer.NiceVideoPlayer;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class VideoHolder_ViewBinding implements Unbinder {
    private VideoHolder b;

    @UiThread
    public VideoHolder_ViewBinding(VideoHolder videoHolder, View view) {
        this.b = videoHolder;
        videoHolder.postCreateVideoNiceVideo = (NiceVideoPlayer) a.c(view, R.id.post_create_video_nice_video, "field 'postCreateVideoNiceVideo'", NiceVideoPlayer.class);
        videoHolder.postCreateVideoFragmentLayout = (FrameLayout) a.c(view, R.id.test_post_crate_video_layout_video_fragment_layout, "field 'postCreateVideoFragmentLayout'", FrameLayout.class);
        videoHolder.postCreatVideoMute = (ImageView) a.c(view, R.id.post_create_video_mute, "field 'postCreatVideoMute'", ImageView.class);
    }

    @CallSuper
    public void a() {
        VideoHolder videoHolder = this.b;
        if (videoHolder != null) {
            this.b = null;
            videoHolder.postCreateVideoNiceVideo = null;
            videoHolder.postCreateVideoFragmentLayout = null;
            videoHolder.postCreatVideoMute = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
