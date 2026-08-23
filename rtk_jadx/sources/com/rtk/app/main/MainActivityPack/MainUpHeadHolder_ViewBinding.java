package com.rtk.app.main.MainActivityPack;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.MarkedImageView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MainUpHeadHolder_ViewBinding implements Unbinder {
    private MainUpHeadHolder b;

    @UiThread
    public MainUpHeadHolder_ViewBinding(MainUpHeadHolder mainUpHeadHolder, View view) {
        this.b = mainUpHeadHolder;
        mainUpHeadHolder.mainHeadIcon = (ImageView) butterknife.c.a.c(view, R.id.main_head_icon, "field 'mainHeadIcon'", ImageView.class);
        mainUpHeadHolder.mainHeadIconUpdataNum = (TextView) butterknife.c.a.c(view, R.id.main_head_icon_updataNum, "field 'mainHeadIconUpdataNum'", TextView.class);
        mainUpHeadHolder.mainSearchTv = (TextView) butterknife.c.a.c(view, R.id.main_search_tv, "field 'mainSearchTv'", TextView.class);
        mainUpHeadHolder.mainDownloadImg = (MarkedImageView) butterknife.c.a.c(view, R.id.main_download_img, "field 'mainDownloadImg'", MarkedImageView.class);
    }

    @CallSuper
    public void a() {
        MainUpHeadHolder mainUpHeadHolder = this.b;
        if (mainUpHeadHolder != null) {
            this.b = null;
            mainUpHeadHolder.mainHeadIcon = null;
            mainUpHeadHolder.mainHeadIconUpdataNum = null;
            mainUpHeadHolder.mainSearchTv = null;
            mainUpHeadHolder.mainDownloadImg = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
