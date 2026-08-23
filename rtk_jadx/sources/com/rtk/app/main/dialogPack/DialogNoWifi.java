package com.rtk.app.main.dialogPack;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogNoWifi extends Dialog implements View.OnClickListener {
    private Window a;
    private ViewHolder b;

    /* renamed from: c, reason: collision with root package name */
    private Context f241c;
    private com.rtk.app.tool.s d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder {

        @BindView
        TextView dialogNoWifiExit;

        @BindView
        TextView dialogNoWifiLayout;

        @BindView
        TextView dialogNoWifiOk;

        @BindView
        CheckBox dialog_no_wifi_check;

        ViewHolder(DialogNoWifi dialogNoWifi, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.dialogNoWifiExit = (TextView) butterknife.c.a.c(view, R.id.dialog_no_wifi_exit, "field 'dialogNoWifiExit'", TextView.class);
            viewHolder.dialog_no_wifi_check = (CheckBox) butterknife.c.a.c(view, R.id.dialog_no_wifi_check, "field 'dialog_no_wifi_check'", CheckBox.class);
            viewHolder.dialogNoWifiOk = (TextView) butterknife.c.a.c(view, R.id.dialog_no_wifi_ok, "field 'dialogNoWifiOk'", TextView.class);
            viewHolder.dialogNoWifiLayout = (TextView) butterknife.c.a.c(view, R.id.dialog_no_wifi_layout, "field 'dialogNoWifiLayout'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.dialogNoWifiExit = null;
                viewHolder.dialog_no_wifi_check = null;
                viewHolder.dialogNoWifiOk = null;
                viewHolder.dialogNoWifiLayout = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public DialogNoWifi(@NonNull Context context, com.rtk.app.tool.s sVar) {
        super(context);
        this.f241c = context;
        this.d = sVar;
        b();
        a();
    }

    private void a() {
        this.b.dialogNoWifiExit.setOnClickListener(this);
        this.b.dialogNoWifiOk.setOnClickListener(this);
    }

    private void b() {
        setContentView(R.layout.dialog_no_wifi);
        c(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
        setCanceledOnTouchOutside(false);
        this.b = new ViewHolder(this, getWindow().getDecorView());
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        com.rtk.app.tool.t.J1(this.f241c, this.b.dialogNoWifiLayout);
    }

    public void c(float f, float f2) {
        Window window = getWindow();
        this.a = window;
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = (int) f;
        attributes.y = (int) f2;
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -2;
        this.a.setAttributes(attributes);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131297308) {
            dismiss();
        } else {
            if (id != 2131297310) {
                return;
            }
            this.d.a(new String[0]);
            com.rtk.app.tool.v.e(this.f241c, "settingNoWifiVALUE", Boolean.valueOf(!this.b.dialog_no_wifi_check.isChecked()));
            dismiss();
        }
    }
}
