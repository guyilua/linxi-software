package com.sigmob.sdk.base.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.common.utils.ReflectionUtil;
import com.czhj.sdk.logger.SigmobLog;
import java.io.File;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class o extends g {
    private static float b = 10.0f;

    /* renamed from: c, reason: collision with root package name */
    private static final float f480c = 1.0f;
    private final com.sigmob.sdk.base.views.b a;
    private a d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a(MotionEvent motionEvent, MotionEvent motionEvent2);
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements View.OnTouchListener {
        MotionEvent a;

        /* renamed from: c, reason: collision with root package name */
        private boolean f481c;

        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f481c = true;
                this.a = MotionEvent.obtain(motionEvent);
            } else {
                if (action != 1 || !this.f481c) {
                    return false;
                }
                this.f481c = false;
                if (o.this.d != null) {
                    o.this.d.a(this.a, motionEvent);
                }
            }
            return false;
        }
    }

    private o(Context context, String str, boolean z, boolean z2) {
        super(context);
        j();
        try {
            ReflectionUtil.MethodBuilder methodBuilder = new ReflectionUtil.MethodBuilder(getSettings(), new String(Base64.decode(com.sigmob.sdk.base.k.C, 2)));
            methodBuilder.addParam(Boolean.TYPE, Boolean.TRUE);
            methodBuilder.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ReflectionUtil.MethodBuilder methodBuilder2 = new ReflectionUtil.MethodBuilder(getSettings(), new String(Base64.decode(com.sigmob.sdk.base.k.E, 2)));
            methodBuilder2.addParam(Boolean.TYPE, Boolean.TRUE);
            methodBuilder2.execute();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        a(true);
        setBackgroundColor(0);
        if (z) {
            ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            com.sigmob.sdk.base.views.b bVar = new com.sigmob.sdk.base.views.b(getContext().getApplicationContext(), 1);
            this.a = bVar;
            bVar.a(str);
            bVar.b(com.sigmob.sdk.base.g.h());
            addView(bVar, layoutParams);
        } else {
            this.a = null;
        }
        setOnTouchListener(new b());
    }

    public static o a(Context context, String str, boolean z, boolean z2) {
        Preconditions.NoThrow.checkNotNull(context);
        return new o(context, str, z, z2);
    }

    private void j() {
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        getSettings().setSupportZoom(false);
        setScrollBarStyle(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        File b2 = com.sigmob.sdk.base.utils.e.b(str, Md5Util.md5(str) + ".html");
        if (b2 == null || TextUtils.isEmpty(b2.getAbsolutePath())) {
            loadDataWithBaseURL(Networking.getBaseUrlScheme() + "://localhost/", str, "text/html", "utf-8", null);
            return;
        }
        loadUrl("file://" + b2.getAbsolutePath());
    }

    @Override // com.sigmob.sdk.base.views.g, android.webkit.WebView
    public void destroy() {
        SigmobLog.d("CreativeWebView destroy() callSigmobLog.d( \"CreativeWebView destroy() called\");ed");
        super.destroy();
        removeAllViews();
    }

    public void setLogoClickListener(View.OnClickListener onClickListener) {
        com.sigmob.sdk.base.views.b bVar = this.a;
        if (bVar != null) {
            bVar.setOnClickListener(onClickListener);
        }
    }

    public void setWebViewClickListener(a aVar) {
        this.d = aVar;
    }
}
