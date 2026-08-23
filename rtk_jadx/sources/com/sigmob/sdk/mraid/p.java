package com.sigmob.sdk.mraid;

import android.content.Context;
import android.os.Build;
import android.view.View;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class p extends com.sigmob.sdk.base.views.g {
    private static final int a = 1;
    private a b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f572c;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a(boolean z);
    }

    public p(Context context) {
        super(context);
        if (Build.VERSION.SDK_INT <= 22) {
            this.f572c = getVisibility() == 0;
        }
    }

    private void setMraidViewable(boolean z) {
        if (this.f572c == z) {
            return;
        }
        this.f572c = z;
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    @Override // com.sigmob.sdk.base.views.g, android.webkit.WebView
    public void destroy() {
        super.destroy();
        this.b = null;
    }

    public boolean j() {
        return this.f572c;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            return;
        }
        setMraidViewable(false);
    }

    public void setVisibilityChangedListener(a aVar) {
        this.b = aVar;
    }
}
