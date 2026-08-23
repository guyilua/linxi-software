package com.rtk.app.main.comment.express;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PanelLayout extends LinearLayout {
    private boolean a;
    private boolean b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f229c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup.LayoutParams layoutParams = PanelLayout.this.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, b.c(PanelLayout.this.getContext()));
            } else {
                layoutParams.height = b.c(PanelLayout.this.getContext());
            }
            PanelLayout.this.setLayoutParams(layoutParams);
        }
    }

    public PanelLayout(Context context) {
        super(context);
        this.a = false;
        this.b = true;
        this.f229c = false;
        a();
    }

    private void a() {
        b();
    }

    @TargetApi(3)
    public void b() {
        if (isInEditMode() || getHeight() == b.c(getContext())) {
            return;
        }
        post(new a());
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.a) {
            setVisibility(8);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, WXVideoFileObject.FILE_SIZE_LIMIT);
            i2 = View.MeasureSpec.makeMeasureSpec(0, WXVideoFileObject.FILE_SIZE_LIMIT);
            i = makeMeasureSpec;
        }
        super.onMeasure(i, i2);
    }

    public void setIsHide(boolean z) {
        this.a = z;
    }

    public void setIsKeyboardShowing(boolean z) {
        this.f229c = z;
    }

    public void setIsShow(boolean z) {
        this.b = z;
        if (z) {
            super.setVisibility(0);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 0) {
            this.a = false;
        }
        if (i == getVisibility()) {
            return;
        }
        if (this.f229c && i == 0) {
            return;
        }
        super.setVisibility(i);
    }

    public PanelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
        this.b = true;
        this.f229c = false;
        a();
    }

    @TargetApi(11)
    public PanelLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = false;
        this.b = true;
        this.f229c = false;
        a();
    }
}
