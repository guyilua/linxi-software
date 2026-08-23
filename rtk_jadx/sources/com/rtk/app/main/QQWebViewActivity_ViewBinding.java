package com.rtk.app.main;

import android.view.View;
import android.webkit.WebView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class QQWebViewActivity_ViewBinding implements Unbinder {
    private QQWebViewActivity b;

    @UiThread
    public QQWebViewActivity_ViewBinding(QQWebViewActivity qQWebViewActivity, View view) {
        this.b = qQWebViewActivity;
        qQWebViewActivity.qqwebview = (WebView) butterknife.c.a.c(view, R.id.qqwebview, "field 'qqwebview'", WebView.class);
    }

    @CallSuper
    public void a() {
        QQWebViewActivity qQWebViewActivity = this.b;
        if (qQWebViewActivity != null) {
            this.b = null;
            qQWebViewActivity.qqwebview = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
