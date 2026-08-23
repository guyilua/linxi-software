package com.sigmob.sdk.nativead;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.sigmob.sdk.base.common.al;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.views.ak;
import com.sigmob.sdk.base.views.an;
import com.sigmob.sdk.base.views.au;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class u extends RelativeLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    private static com.sigmob.sdk.base.views.v i;
    private static al.a j;
    private final int a;
    private com.sigmob.sdk.base.views.v b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f619c;
    private al.a d;
    private boolean e;
    private ClickCommon f;
    private b g;
    private boolean h;
    private int k;
    private int l;
    private boolean m;
    private Boolean n;
    private String title;

    public u(Context context) {
        super(context);
        this.e = false;
        this.n = null;
        this.k = Dips.dipsToIntPixels(100.0f, context);
        this.l = Dips.dipsToIntPixels(60.0f, context);
        this.a = Dips.dipsToIntPixels(5.0f, getContext());
    }

    private void a(int i2) {
        this.b = new au(getContext());
        this.title = "扭动或点击前往";
        al.a aVar = new al.a(getContext(), new al.b() { // from class: com.sigmob.sdk.nativead.u.1
            @Override // com.sigmob.sdk.base.common.al.b
            public void a() {
            }

            @Override // com.sigmob.sdk.base.common.al.b
            public void a(float f) {
            }

            @Override // com.sigmob.sdk.base.common.al.b
            public void a(Map<String, Number> map) {
                if (map == null || u.this.e) {
                    return;
                }
                u.this.e = true;
                Number number = map.get("turn_x");
                Number number2 = map.get("turn_y");
                Number number3 = map.get("turn_z");
                Number number4 = map.get("turn_time");
                if (number != null) {
                    u.this.f.turn_x = String.valueOf(number.intValue());
                }
                if (number2 != null) {
                    u.this.f.turn_y = String.valueOf(number2.intValue());
                }
                if (number3 != null) {
                    u.this.f.turn_z = String.valueOf(number3.intValue());
                }
                u.this.f.turn_time = String.valueOf(number4);
                u.this.b.postDelayed(new Runnable() { // from class: com.sigmob.sdk.nativead.u.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        u.this.f.sld = "5";
                        u.this.e();
                    }
                }, 400L);
            }
        }, al.c.WRING);
        this.d = aVar;
        aVar.c(i2);
    }

    private void b(int i2) {
        this.b = new com.sigmob.sdk.base.views.ac(getContext());
        this.title = "摇一摇或点击前往";
        al.a aVar = new al.a(getContext(), new al.b() { // from class: com.sigmob.sdk.nativead.u.2
            @Override // com.sigmob.sdk.base.common.al.b
            public void a() {
            }

            @Override // com.sigmob.sdk.base.common.al.b
            public void a(float f) {
            }

            @Override // com.sigmob.sdk.base.common.al.b
            public void a(Map<String, Number> map) {
                Number number = map.get("x_max_acc");
                Number number2 = map.get("y_max_acc");
                Number number3 = map.get("z_max_acc");
                if (number != null && u.this.f != null) {
                    u.this.f.x_max_acc = String.valueOf(number.intValue());
                }
                if (number2 != null && u.this.f != null) {
                    u.this.f.y_max_acc = String.valueOf(number2.intValue());
                }
                if (number3 != null && u.this.f != null) {
                    u.this.f.z_max_acc = String.valueOf(number3.intValue());
                }
                u.this.b.postDelayed(new Runnable() { // from class: com.sigmob.sdk.nativead.u.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (u.this.e) {
                            return;
                        }
                        u.this.f.sld = "2";
                        u.this.e();
                    }
                }, 400L);
            }
        }, al.c.SHAKE);
        this.d = aVar;
        aVar.c(i2);
    }

    private void c(int i2) {
        this.b = new ak(getContext());
        this.title = "前倾或点击前往";
        al.a aVar = new al.a(getContext(), new al.b() { // from class: com.sigmob.sdk.nativead.u.3
            @Override // com.sigmob.sdk.base.common.al.b
            public void a() {
            }

            @Override // com.sigmob.sdk.base.common.al.b
            public void a(float f) {
                if (u.this.b instanceof ak) {
                    ((ak) u.this.b).a(f);
                }
            }

            @Override // com.sigmob.sdk.base.common.al.b
            public void a(Map<String, Number> map) {
                if (map == null || u.this.e) {
                    return;
                }
                u.this.e = true;
                Number number = map.get("turn_x");
                Number number2 = map.get("turn_y");
                Number number3 = map.get("turn_z");
                Number number4 = map.get("turn_time");
                if (number != null) {
                    u.this.f.turn_x = String.valueOf(number.intValue());
                }
                if (number2 != null) {
                    u.this.f.turn_y = String.valueOf(number2.intValue());
                }
                if (number3 != null) {
                    u.this.f.turn_z = String.valueOf(number3.intValue());
                }
                u.this.f.turn_time = String.valueOf(number4);
                u.this.b.postDelayed(new Runnable() { // from class: com.sigmob.sdk.nativead.u.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        u.this.f.sld = "5";
                        u.this.e();
                    }
                }, 400L);
            }
        }, al.c.SLOPE);
        this.d = aVar;
        aVar.c(i2);
    }

    private void d() {
        this.m = true;
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    private void d(int i2) {
        this.b = new an(getContext());
        this.title = "晃动或点击前往";
        al.a aVar = new al.a(getContext(), new al.b() { // from class: com.sigmob.sdk.nativead.u.4
            @Override // com.sigmob.sdk.base.common.al.b
            public void a() {
            }

            @Override // com.sigmob.sdk.base.common.al.b
            public void a(float f) {
                if (u.this.b instanceof an) {
                    ((an) u.this.b).a(f);
                }
            }

            @Override // com.sigmob.sdk.base.common.al.b
            public void a(Map<String, Number> map) {
                if (map == null || u.this.e) {
                    return;
                }
                u.this.e = true;
                Number number = map.get("x_max_acc");
                Number number2 = map.get("y_max_acc");
                Number number3 = map.get("z_max_acc");
                if (number != null && u.this.f != null) {
                    u.this.f.x_max_acc = String.valueOf(number.intValue());
                }
                if (number2 != null && u.this.f != null) {
                    u.this.f.y_max_acc = String.valueOf(number2.intValue());
                }
                if (number3 != null && u.this.f != null) {
                    u.this.f.z_max_acc = String.valueOf(number3.intValue());
                }
                u.this.b.postDelayed(new Runnable() { // from class: com.sigmob.sdk.nativead.u.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        u.this.f.sld = "2";
                        u.this.e();
                    }
                }, 400L);
            }
        }, al.c.SWING);
        this.d = aVar;
        aVar.c(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        b bVar = this.g;
        if (bVar != null) {
            bVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        if (this.h && this.b.getVisibility() == 0) {
            com.sigmob.sdk.base.views.v vVar = i;
            if (vVar != null && vVar != this.b) {
                vVar.b();
                i = null;
            }
            al.a aVar = j;
            if (aVar != null && aVar != this.d) {
                aVar.b();
                j = null;
            }
            this.e = false;
            if (this.d != null && this.h && com.sigmob.sdk.base.utils.f.b(this)) {
                al.a aVar2 = j;
                al.a aVar3 = this.d;
                if (aVar2 != aVar3) {
                    j = aVar3;
                    aVar3.a();
                }
                com.sigmob.sdk.base.views.v vVar2 = this.b;
                if (vVar2 == null || vVar2 == i || vVar2.getVisibility() != 0) {
                    return;
                }
                com.sigmob.sdk.base.views.v vVar3 = this.b;
                i = vVar3;
                vVar3.a();
            }
        }
    }

    public boolean a(int i2, int i3, ClickCommon clickCommon) {
        this.f = clickCommon;
        switch (i2) {
            case 138731:
                d(i3);
                break;
            case 138733:
                c(i3);
                break;
            case 138757:
                b(i3);
                break;
            case 138758:
                a(i3);
                break;
        }
        if (this.b == null) {
            return false;
        }
        this.f.widget_id = i2;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.b.setId(ClientMetadata.generateViewId());
        addView(this.b, layoutParams);
        TextView textView = new TextView(getContext());
        this.f619c = textView;
        textView.setText(this.title);
        this.f619c.setTextSize(2, 15.0f);
        this.f619c.setTextColor(-1);
        this.f619c.setTypeface(Typeface.DEFAULT_BOLD);
        this.f619c.setId(ClientMetadata.generateViewId());
        return true;
    }

    public void b() {
        com.sigmob.sdk.base.views.v vVar = this.b;
        if (vVar != null) {
            vVar.b();
        }
        al.a aVar = this.d;
        if (aVar != null) {
            aVar.b();
        }
        com.sigmob.sdk.base.views.v vVar2 = i;
        if (vVar2 != null && vVar2 == this.b) {
            i = null;
        }
        al.a aVar2 = j;
        if (aVar2 == null || aVar2 != this.d) {
            return;
        }
        j = null;
    }

    public void c() {
        com.sigmob.sdk.base.views.v vVar = i;
        if (vVar != null && vVar == this.b) {
            i = null;
        }
        al.a aVar = j;
        if (aVar != null && aVar == this.d) {
            j = null;
        }
        com.sigmob.sdk.base.views.v vVar2 = this.b;
        if (vVar2 != null) {
            vVar2.b();
            com.sigmob.sdk.base.utils.f.a(this.b);
            this.b = null;
        }
        TextView textView = this.f619c;
        if (textView != null) {
            com.sigmob.sdk.base.utils.f.a(textView);
            this.f619c = null;
        }
        al.a aVar2 = this.d;
        if (aVar2 != null) {
            aVar2.c();
            this.d = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.h = true;
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.h = false;
        this.m = false;
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
        b();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        TextView textView;
        if (this.m) {
            this.m = false;
            int min = Math.min(getWidth(), getHeight());
            com.sigmob.sdk.base.utils.f.a(this.f619c);
            if (min < this.l) {
                com.sigmob.sdk.base.views.v vVar = this.b;
                if (vVar != null) {
                    vVar.b();
                    this.b.setVisibility(4);
                }
                al.a aVar = this.d;
                if (aVar != null) {
                    aVar.b();
                }
                this.n = Boolean.FALSE;
                return;
            }
            com.sigmob.sdk.base.views.v vVar2 = this.b;
            if (vVar2 != null) {
                ViewGroup.LayoutParams layoutParams = vVar2.getLayoutParams();
                if (layoutParams != null && layoutParams.width != min) {
                    layoutParams.width = min;
                    layoutParams.height = min;
                    this.b.setLayoutParams(layoutParams);
                }
                Boolean bool = this.n;
                if (bool != null && !bool.booleanValue()) {
                    this.b.a();
                    this.b.setVisibility(0);
                    al.a aVar2 = this.d;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                }
                if (min < this.k) {
                    return;
                }
                int[] iArr = new int[2];
                int[] iArr2 = new int[2];
                getLocationOnScreen(iArr2);
                this.b.getLocationOnScreen(iArr);
                int top = getTop() + min + (iArr[1] - iArr2[1]);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup == null || (textView = this.f619c) == null) {
                    return;
                }
                com.sigmob.sdk.base.utils.f.a(textView);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 1;
                layoutParams2.setMargins(0, top + this.a, 0, 0);
                viewGroup.addView(this.f619c, layoutParams2);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.m = true;
    }

    public void setMotionActionListener(b bVar) {
        this.g = bVar;
    }
}
