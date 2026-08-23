package com.rtk.app.main.HomeCommunityPack;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.xiao.nicevideoplayer.NiceVideoPlayer;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class VideoDetailsActivity_ViewBinding implements Unbinder {
    private VideoDetailsActivity b;

    @UiThread
    public VideoDetailsActivity_ViewBinding(VideoDetailsActivity videoDetailsActivity, View view) {
        this.b = videoDetailsActivity;
        videoDetailsActivity.niceVideoPlayer = (NiceVideoPlayer) butterknife.c.a.c(view, R.id.video_details_nice_video, "field 'niceVideoPlayer'", NiceVideoPlayer.class);
    }

    @CallSuper
    public void a() {
        VideoDetailsActivity videoDetailsActivity = this.b;
        if (videoDetailsActivity != null) {
            this.b = null;
            videoDetailsActivity.niceVideoPlayer = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
