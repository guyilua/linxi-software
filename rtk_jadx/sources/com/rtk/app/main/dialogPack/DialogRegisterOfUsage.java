package com.rtk.app.main.dialogPack;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.bean.RegisterAgreementBean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogRegisterOfUsage extends Dialog implements View.OnClickListener {
    private Window a;
    private ViewHolder b;

    /* renamed from: c, reason: collision with root package name */
    private Context f249c;
    private RegisterAgreementBean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder {

        @BindView
        TextView dialogRegisterOfUsageCancel;

        @BindView
        TextView dialogRegisterOfUsageEnsure;

        @BindView
        LinearLayout dialogRegisterOfUsageTopLv;

        @BindView
        TextView dialogRegisterOfUsageTv;

        ViewHolder(DialogRegisterOfUsage dialogRegisterOfUsage, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.dialogRegisterOfUsageTopLv = (LinearLayout) butterknife.c.a.c(view, R.id.dialog_register_of_usage_top_lv, "field 'dialogRegisterOfUsageTopLv'", LinearLayout.class);
            viewHolder.dialogRegisterOfUsageTv = (TextView) butterknife.c.a.c(view, R.id.dialog_register_of_usage_tv, "field 'dialogRegisterOfUsageTv'", TextView.class);
            viewHolder.dialogRegisterOfUsageCancel = (TextView) butterknife.c.a.c(view, R.id.dialog_register_of_usage_cancel, "field 'dialogRegisterOfUsageCancel'", TextView.class);
            viewHolder.dialogRegisterOfUsageEnsure = (TextView) butterknife.c.a.c(view, R.id.dialog_register_of_usage_ensure, "field 'dialogRegisterOfUsageEnsure'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.dialogRegisterOfUsageTopLv = null;
                viewHolder.dialogRegisterOfUsageTv = null;
                viewHolder.dialogRegisterOfUsageCancel = null;
                viewHolder.dialogRegisterOfUsageEnsure = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public DialogRegisterOfUsage(@NonNull Context context, RegisterAgreementBean registerAgreementBean) {
        super(context);
        this.f249c = context;
        this.d = registerAgreementBean;
        c();
        b();
        a();
    }

    private void a() {
        this.b.dialogRegisterOfUsageTv.setText(Html.fromHtml(this.d.getData().getRegisterAgreement()));
    }

    private void b() {
        this.b.dialogRegisterOfUsageCancel.setOnClickListener(this);
        this.b.dialogRegisterOfUsageEnsure.setOnClickListener(this);
    }

    private void c() {
        setContentView(R.layout.dialog_register_of_usage);
        d(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
        setCanceledOnTouchOutside(false);
        this.b = new ViewHolder(this, getWindow().getDecorView());
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        com.rtk.app.tool.t.J1(this.f249c, this.b.dialogRegisterOfUsageTopLv);
    }

    public void d(float f, float f2) {
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
        switch (view.getId()) {
            case R.id.dialog_register_of_usage_cancel /* 2131297344 */:
                ((Activity) this.f249c).finish();
                return;
            case R.id.dialog_register_of_usage_ensure /* 2131297345 */:
                dismiss();
                return;
            default:
                return;
        }
    }
}
