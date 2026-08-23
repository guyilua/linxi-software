package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d extends RelativeLayout {
    private final int a;
    private final int b;

    /* renamed from: c, reason: collision with root package name */
    private final int f464c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private Button i;
    private Button j;
    private int k;
    private TextView l;
    private com.sigmob.sdk.videoAd.e m;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a();

        void b();
    }

    public d(Context context, com.sigmob.sdk.videoAd.e eVar) {
        super(context);
        this.m = null;
        this.m = eVar;
        this.a = Dips.dipsToIntPixels(10.0f, context);
        int dipsToIntPixels = Dips.dipsToIntPixels(16.0f, context);
        this.b = dipsToIntPixels;
        this.f464c = Dips.dipsToIntPixels(227.0f, context);
        this.f = (int) ((r1 * 16.0f) / 9.0d);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(25.0f, context);
        this.d = dipsToIntPixels2;
        this.h = Dips.dipsToIntPixels(25.0f, context);
        this.e = Dips.dipsToIntPixels(100.0f, context);
        this.g = dipsToIntPixels2 + dipsToIntPixels;
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        e(context);
    }

    private TextView a(Context context) {
        TextView textView = new TextView(context);
        textView.setText(this.m.a());
        textView.setTextColor(-16777216);
        textView.setTextSize(2, 18.0f);
        textView.setGravity(17);
        return textView;
    }

    private TextView b(Context context) {
        TextView textView = new TextView(context);
        this.l = textView;
        textView.setTextColor(-16777216);
        this.l.setTextSize(2, 14.0f);
        this.l.setGravity(17);
        return this.l;
    }

    private Button c(Context context) {
        Button button = new Button(context);
        button.setText(this.m.c());
        button.setTextColor(Color.parseColor("#ff999999"));
        button.setBackgroundColor(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, this.b / 2, 0, 0);
        button.setGravity(17);
        button.setTextSize(2, 14.0f);
        button.setLayoutParams(layoutParams);
        return button;
    }

    private Button d(Context context) {
        Button button = new Button(context);
        button.setText(this.m.d());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.g);
        int i = this.a;
        layoutParams.setMargins(i * 5, i * 2, i * 5, 0);
        button.setLayoutParams(layoutParams);
        button.setTextColor(-1);
        button.setBackgroundColor(0);
        button.setTextSize(2, 16.0f);
        ab.a(button, r.a, this.g / 2, Color.parseColor("#66000000"), 0, 0, 0);
        return button;
    }

    private void e(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.d);
        int i = this.b;
        layoutParams.setMargins(i, this.a * 2, i, 0);
        linearLayout.addView(a(context), layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.h);
        int i2 = this.b;
        layoutParams2.setMargins(i2, this.a, i2, 0);
        linearLayout.addView(b(context), layoutParams2);
        ab.a(linearLayout, Color.parseColor("#FFFFFF"), this.a, Color.parseColor("#66000000"), 0, 0, 0);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.f, this.f464c);
        int i3 = this.b;
        layoutParams3.setMargins(i3, 0, i3, 0);
        layoutParams3.addRule(13);
        relativeLayout.setLayoutParams(layoutParams3);
        relativeLayout.addView(linearLayout, new RelativeLayout.LayoutParams(-1, -1));
        Button d = d(context);
        this.j = d;
        linearLayout.addView(d);
        Button c2 = c(context);
        this.i = c2;
        linearLayout.addView(c2);
        linearLayout.setGravity(17);
        addView(relativeLayout);
    }

    public void setDialogListener(final a aVar) {
        Button button = this.i;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.base.views.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    aVar.a();
                }
            });
        }
        Button button2 = this.j;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.base.views.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    aVar.b();
                }
            });
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setduration(int i) {
        this.k = i;
        TextView textView = this.l;
        if (textView != null) {
            textView.setText(this.m.b().replace("_SEC_", String.valueOf(this.k)));
        }
    }
}
