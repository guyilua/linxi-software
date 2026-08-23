package com.tencent.smtt.sdk.b.a;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.ValueCallback;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: TBSActivityPicker.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c extends Dialog {
    static WeakReference<ValueCallback<String>> a = null;
    private static float l = -1.0f;
    private ListView b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f957c;
    private Button d;
    private Button e;
    private String f;
    private a g;
    private String h;
    private String i;
    private Intent j;
    private SharedPreferences k;

    public c(Context context, String str, Intent intent, ValueCallback<String> valueCallback, String str2, String str3) {
        super(context, R.style.Theme.Dialog);
        this.h = "*/*";
        this.k = null;
        this.i = str3;
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        if ((queryIntentActivities == null || queryIntentActivities.size() == 0) && com.tencent.smtt.sdk.a.c.b(context)) {
            QbSdk.isDefaultDialog = true;
        }
        if ("com.tencent.rtxlite".equalsIgnoreCase(context.getApplicationContext().getPackageName()) && (queryIntentActivities == null || (queryIntentActivities != null && queryIntentActivities.size() == 0))) {
            QbSdk.isDefaultDialog = true;
        }
        b(context.getApplicationContext());
        this.f = str;
        this.j = intent;
        a = new WeakReference<>(valueCallback);
        this.k = context.getSharedPreferences("tbs_file_open_dialog_config", 0);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.h = str2;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        b();
    }

    private void c() {
        a aVar = this.g;
        a aVar2 = new a(getContext(), this.j, new b(getContext(), d.a("application_icon"), "QQ浏览器", TbsConfig.APP_QB), aVar != null ? aVar.a() : null, this, this.b, a.get());
        this.g = aVar2;
        this.b.setAdapter((ListAdapter) aVar2);
    }

    public void a(String str) {
        SharedPreferences sharedPreferences = this.k;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("key_tbs_picked_default_browser_" + this.h, str).commit();
        }
    }

    public void b() {
        setContentView(a(getContext()));
        c();
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.smtt.sdk.b.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b a2 = c.this.g.a();
                if (a2 == null || a2.b() == null) {
                    return;
                }
                Intent intent = c.this.j;
                Context context = c.this.getContext();
                String str = a2.b().activityInfo.packageName;
                intent.setPackage(str);
                if (TbsConfig.APP_QB.equals(str)) {
                    intent.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getPackageName());
                    intent.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, GlobalSetting.NATIVE_EXPRESS_AD);
                }
                if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && Build.VERSION.SDK_INT >= 24) {
                    intent.addFlags(1);
                }
                if (!TextUtils.isEmpty(c.this.i)) {
                    intent.putExtra("big_brother_source_key", c.this.i);
                }
                context.startActivity(intent);
                if (c.a.get() != null) {
                    c.a.get().onReceiveValue("always");
                }
                c.this.a(str);
                c.this.dismiss();
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.smtt.sdk.b.a.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b a2 = c.this.g.a();
                if (a2 == null || a2.b() == null) {
                    return;
                }
                Intent intent = c.this.j;
                Context context = c.this.getContext();
                String str = a2.b().activityInfo.packageName;
                intent.setPackage(str);
                if (TbsConfig.APP_QB.equals(str)) {
                    intent.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getPackageName());
                    intent.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, GlobalSetting.NATIVE_EXPRESS_AD);
                }
                if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && Build.VERSION.SDK_INT >= 24) {
                    intent.addFlags(1);
                }
                if (!TextUtils.isEmpty(c.this.i)) {
                    intent.putExtra("big_brother_source_key", c.this.i);
                }
                context.startActivity(intent);
                if (c.a.get() != null) {
                    c.a.get().onReceiveValue("once");
                }
                c.this.dismiss();
            }
        });
    }

    public String a() {
        SharedPreferences sharedPreferences = this.k;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString("key_tbs_picked_default_browser_" + this.h, null);
    }

    private View a(Context context) {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.dimAmount = 0.5f;
        getWindow().setAttributes(attributes);
        FrameLayout frameLayout = new FrameLayout(context);
        LinearLayout linearLayout = new LinearLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a(280.0f), -1);
        layoutParams.gravity = 17;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundColor(-1);
        linearLayout.setOrientation(1);
        this.f957c = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, a(65.0f));
        layoutParams2.weight = com.sigmob.sdk.base.blurkit.c.d;
        this.f957c.setGravity(16);
        this.f957c.setLayoutParams(layoutParams2);
        this.f957c.setPadding(a(18.0f), 0, 0, 0);
        this.f957c.setTextColor(Color.rgb(69, 192, 26));
        this.f957c.setTextSize(1, 18.0f);
        this.f957c.setText(this.f);
        linearLayout.addView(this.f957c);
        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 1);
        layoutParams3.weight = com.sigmob.sdk.base.blurkit.c.d;
        imageView.setLayoutParams(layoutParams3);
        imageView.setBackgroundColor(Color.argb(61, 0, 0, 0));
        linearLayout.addView(imageView);
        this.b = new ListView(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams4.weight = 1.0f;
        layoutParams4.gravity = 16;
        this.b.setLayoutParams(layoutParams4);
        this.b.setDivider(new ColorDrawable(Color.argb(41, 0, 0, 0)));
        this.b.setDividerHeight(1);
        linearLayout.addView(this.b);
        ImageView imageView2 = new ImageView(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, 1);
        layoutParams5.weight = com.sigmob.sdk.base.blurkit.c.d;
        imageView2.setLayoutParams(layoutParams5);
        imageView2.setBackgroundColor(Color.argb(61, 0, 0, 0));
        linearLayout.addView(imageView2);
        LinearLayout linearLayout2 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams6.weight = com.sigmob.sdk.base.blurkit.c.d;
        linearLayout2.setLayoutParams(layoutParams6);
        linearLayout2.setOrientation(0);
        linearLayout2.setContentDescription("x5_tbs_activity_picker_btn_container");
        this.d = new Button(context);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, a(49.0f));
        layoutParams7.weight = 1.0f;
        this.d.setLayoutParams(layoutParams7);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, new ColorDrawable(Color.argb(41, 0, 0, 0)));
        stateListDrawable.addState(new int[]{-16842919}, new ColorDrawable(0));
        this.d.setBackgroundDrawable(stateListDrawable);
        this.d.setText(d.b("x5_tbs_wechat_activity_picker_label_always"));
        this.d.setTextColor(Color.rgb(29, 29, 29));
        this.d.setTextSize(1, 17.0f);
        linearLayout2.addView(this.d);
        ImageView imageView3 = new ImageView(context);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(1, -1);
        layoutParams8.weight = com.sigmob.sdk.base.blurkit.c.d;
        imageView3.setLayoutParams(layoutParams8);
        imageView3.setBackgroundColor(Color.rgb(TbsListener.ErrorCode.INCR_UPDATE_FAIL, TbsListener.ErrorCode.INCR_UPDATE_FAIL, TbsListener.ErrorCode.INCR_UPDATE_FAIL));
        linearLayout2.addView(imageView3);
        this.e = new Button(context);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, a(49.0f));
        layoutParams9.weight = 1.0f;
        this.e.setLayoutParams(layoutParams9);
        StateListDrawable stateListDrawable2 = new StateListDrawable();
        stateListDrawable2.addState(new int[]{R.attr.state_pressed}, new ColorDrawable(Color.argb(41, 0, 0, 0)));
        stateListDrawable2.addState(new int[]{-16842919}, new ColorDrawable(0));
        this.e.setBackgroundDrawable(stateListDrawable2);
        this.e.setText(d.b("x5_tbs_wechat_activity_picker_label_once"));
        this.e.setTextColor(Color.rgb(29, 29, 29));
        this.e.setTextSize(1, 17.0f);
        linearLayout2.addView(this.e);
        linearLayout.addView(linearLayout2);
        frameLayout.addView(linearLayout);
        return frameLayout;
    }

    private void b(Context context) {
        if (l < com.sigmob.sdk.base.blurkit.c.d) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            l = displayMetrics.density;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        Button button = this.e;
        if (button != null) {
            button.setEnabled(z);
        }
        Button button2 = this.d;
        if (button2 != null) {
            button2.setEnabled(z);
        }
    }

    public int a(float f) {
        return (int) ((f * l) + 0.5f);
    }
}
