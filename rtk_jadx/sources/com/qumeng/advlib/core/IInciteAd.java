package com.qumeng.advlib.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.annotation.Keep;
import com.qumeng.advlib.ui.front.InciteVideoListener;

@Keep
/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface IInciteAd {
    void ReportBootstrapFeature(int[] iArr);

    void doWhenReflect(Activity activity);

    void onActivityResultRef(int i, int i2, Intent intent);

    void onDestroyRef(Activity activity);

    boolean onKeyEvent(int i, KeyEvent keyEvent);

    void onPauseRef(Activity activity);

    void onResumeRef(Activity activity);

    void onStartRef(Activity activity);

    void onStopRef(Activity activity);

    void showInciteVideo(Context context, ICliBundle iCliBundle, Bundle bundle, InciteVideoListener inciteVideoListener);

    void whenPermDialogReturns(int i, String[] strArr, int[] iArr);
}
