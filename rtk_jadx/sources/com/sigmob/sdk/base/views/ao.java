package com.sigmob.sdk.base.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ao extends LinearLayout {
    private TextView a;
    private TextView b;

    public ao(Context context) {
        super(context);
        a();
    }

    public ao(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ao(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        TextView textView = new TextView(getContext());
        this.a = textView;
        textView.setId(View.generateViewId());
        this.b = new TextView(getContext());
        setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.a.setTextColor(-1);
        this.a.setSingleLine();
        this.a.setGravity(17);
        this.a.setTextSize(2, 20.0f);
        this.b.setSingleLine();
        this.b.setTextColor(-1);
        this.b.setGravity(17);
        this.b.setTextSize(2, 14.0f);
        addView(this.a, layoutParams);
        addView(this.b, new LinearLayout.LayoutParams(-1, -2));
    }

    public void setDescription(String str) {
        this.b.setText(str);
    }

    public void setTitle(String str) {
        this.a.setText(str);
    }
}
