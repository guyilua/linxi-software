package com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsHolderClass;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.X5WebView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class WebViewHolder_ViewBinding implements Unbinder {
    private WebViewHolder b;

    @UiThread
    public WebViewHolder_ViewBinding(WebViewHolder webViewHolder, View view) {
        this.b = webViewHolder;
        webViewHolder.postDetailsRecyclerviewItemWebview = (X5WebView) butterknife.c.a.c(view, R.id.post_details_recyclerview_item_webview, "field 'postDetailsRecyclerviewItemWebview'", X5WebView.class);
    }

    @CallSuper
    public void a() {
        WebViewHolder webViewHolder = this.b;
        if (webViewHolder != null) {
            this.b = null;
            webViewHolder.postDetailsRecyclerviewItemWebview = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
