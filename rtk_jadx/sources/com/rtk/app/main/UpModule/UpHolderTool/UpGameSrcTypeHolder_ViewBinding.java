package com.rtk.app.main.UpModule.UpHolderTool;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpGameSrcTypeHolder_ViewBinding implements Unbinder {
    private UpGameSrcTypeHolder b;

    @UiThread
    public UpGameSrcTypeHolder_ViewBinding(UpGameSrcTypeHolder upGameSrcTypeHolder, View view) {
        this.b = upGameSrcTypeHolder;
        upGameSrcTypeHolder.upGameSrcApkTypeGame = (RadioButton) butterknife.c.a.c(view, R.id.up_game_src_apkType_game, "field 'upGameSrcApkTypeGame'", RadioButton.class);
        upGameSrcTypeHolder.upGameSrcApkTypeSoft = (RadioButton) butterknife.c.a.c(view, R.id.up_game_src_apkTypeSoft, "field 'upGameSrcApkTypeSoft'", RadioButton.class);
        upGameSrcTypeHolder.upGameSrcApkType = (RadioGroup) butterknife.c.a.c(view, R.id.up_game_src_apkType, "field 'upGameSrcApkType'", RadioGroup.class);
        upGameSrcTypeHolder.upGameSrcApkTags = (Spinner) butterknife.c.a.c(view, R.id.up_game_src_apkTags, "field 'upGameSrcApkTags'", Spinner.class);
    }

    @CallSuper
    public void a() {
        UpGameSrcTypeHolder upGameSrcTypeHolder = this.b;
        if (upGameSrcTypeHolder != null) {
            this.b = null;
            upGameSrcTypeHolder.upGameSrcApkTypeGame = null;
            upGameSrcTypeHolder.upGameSrcApkTypeSoft = null;
            upGameSrcTypeHolder.upGameSrcApkType = null;
            upGameSrcTypeHolder.upGameSrcApkTags = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
