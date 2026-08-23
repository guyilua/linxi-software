package com.rtk.app.main.HomeCommunityPack;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpProgressVideoIntroActivity_ViewBinding implements Unbinder {
    private UpProgressVideoIntroActivity b;

    @UiThread
    public UpProgressVideoIntroActivity_ViewBinding(UpProgressVideoIntroActivity upProgressVideoIntroActivity, View view) {
        this.b = upProgressVideoIntroActivity;
        upProgressVideoIntroActivity.upVideoIntroBack = (TextView) butterknife.c.a.c(view, R.id.up_video_intro_back, "field 'upVideoIntroBack'", TextView.class);
        upProgressVideoIntroActivity.upVideoIntroTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_video_intro_top_layout, "field 'upVideoIntroTopLayout'", LinearLayout.class);
        upProgressVideoIntroActivity.upVideoIntroImage = (ImageView) butterknife.c.a.c(view, R.id.up_video_intro_image, "field 'upVideoIntroImage'", ImageView.class);
        upProgressVideoIntroActivity.upVideoSelectorSeekTime = (SeekBar) butterknife.c.a.c(view, R.id.up_video_selector_seek_time, "field 'upVideoSelectorSeekTime'", SeekBar.class);
        upProgressVideoIntroActivity.upVideoIntroVideoName = (EditText) butterknife.c.a.c(view, R.id.up_video_intro_video_name, "field 'upVideoIntroVideoName'", EditText.class);
        upProgressVideoIntroActivity.upVideoSelectorEnsure = (TextView) butterknife.c.a.c(view, R.id.up_video_selector_ensure, "field 'upVideoSelectorEnsure'", TextView.class);
    }

    @CallSuper
    public void a() {
        UpProgressVideoIntroActivity upProgressVideoIntroActivity = this.b;
        if (upProgressVideoIntroActivity != null) {
            this.b = null;
            upProgressVideoIntroActivity.upVideoIntroBack = null;
            upProgressVideoIntroActivity.upVideoIntroTopLayout = null;
            upProgressVideoIntroActivity.upVideoIntroImage = null;
            upProgressVideoIntroActivity.upVideoSelectorSeekTime = null;
            upProgressVideoIntroActivity.upVideoIntroVideoName = null;
            upProgressVideoIntroActivity.upVideoSelectorEnsure = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
