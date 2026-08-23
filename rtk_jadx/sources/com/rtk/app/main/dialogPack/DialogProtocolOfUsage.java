package com.rtk.app.main.dialogPack;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
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
import com.mob.MobSDK;
import com.mob.OperationCallback;
import com.rtk.app.R;
import com.rtk.app.bean.MainUseProtocolUpdateNoticeBean;
import com.rtk.app.main.Home5Activity.PrivacyOfUsageActivity;
import com.rtk.app.main.Home5Activity.ProtocolOfUsageActivity;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogProtocolOfUsage extends Dialog implements View.OnClickListener {
    private Window a;
    private ViewHolder b;

    /* renamed from: c, reason: collision with root package name */
    private Context f248c;
    private MainUseProtocolUpdateNoticeBean.DataBean.AgreementPrivacyBean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder {

        @BindView
        TextView dialogProtocolOfUsageCancel;

        @BindView
        TextView dialogProtocolOfUsageEnsure;

        @BindView
        LinearLayout dialogProtocolOfUsageTopLv;

        @BindView
        TextView dialogProtocolOfUsageTv;

        ViewHolder(DialogProtocolOfUsage dialogProtocolOfUsage, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.dialogProtocolOfUsageTopLv = (LinearLayout) butterknife.c.a.c(view, R.id.dialog_protocol_of_usage_top_lv, "field 'dialogProtocolOfUsageTopLv'", LinearLayout.class);
            viewHolder.dialogProtocolOfUsageTv = (TextView) butterknife.c.a.c(view, R.id.dialog_protocol_of_usage_tv, "field 'dialogProtocolOfUsageTv'", TextView.class);
            viewHolder.dialogProtocolOfUsageCancel = (TextView) butterknife.c.a.c(view, R.id.dialog_protocol_of_usage_cancel, "field 'dialogProtocolOfUsageCancel'", TextView.class);
            viewHolder.dialogProtocolOfUsageEnsure = (TextView) butterknife.c.a.c(view, R.id.dialog_protocol_of_usage_ensure, "field 'dialogProtocolOfUsageEnsure'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.dialogProtocolOfUsageTopLv = null;
                viewHolder.dialogProtocolOfUsageTv = null;
                viewHolder.dialogProtocolOfUsageCancel = null;
                viewHolder.dialogProtocolOfUsageEnsure = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a extends ClickableSpan {
        a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            com.rtk.app.tool.c.b((Activity) DialogProtocolOfUsage.this.f248c, ProtocolOfUsageActivity.class, null);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(DialogProtocolOfUsage.this.f248c.getResources().getColor(R.color.theme1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b extends ClickableSpan {
        b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            com.rtk.app.tool.c.b((Activity) DialogProtocolOfUsage.this.f248c, PrivacyOfUsageActivity.class, null);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(DialogProtocolOfUsage.this.f248c.getResources().getColor(R.color.theme1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class c extends OperationCallback<Void> {
        c(DialogProtocolOfUsage dialogProtocolOfUsage) {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onComplete(Void r2) {
            com.rtk.app.tool.c0.u("DialogProtocolOfUsage", "隐私协议授权结果提交：成功");
        }

        public void onFailure(Throwable th) {
            com.rtk.app.tool.c0.u("DialogProtocolOfUsage", "隐私协议授权结果提交：失败");
        }
    }

    public DialogProtocolOfUsage(@NonNull Context context, MainUseProtocolUpdateNoticeBean.DataBean.AgreementPrivacyBean agreementPrivacyBean) {
        super(context);
        this.f248c = context;
        this.d = agreementPrivacyBean;
        d();
        c();
        b();
    }

    private void b() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("\t\t\t\t欢迎使用软天空App！为了保障您的权益，在使用本产品和服务前，请您认真阅读《用户服务协议》和《隐私政策》全部条款，如您同意，请点击“同意”开始接受我们的服务。");
        spannableStringBuilder.setSpan(new a(), 41, 49, 33);
        spannableStringBuilder.setSpan(new b(), 50, 56, 33);
        this.b.dialogProtocolOfUsageTv.setText(spannableStringBuilder);
        this.b.dialogProtocolOfUsageTv.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void c() {
        this.b.dialogProtocolOfUsageCancel.setOnClickListener(this);
        this.b.dialogProtocolOfUsageEnsure.setOnClickListener(this);
    }

    private void d() {
        setContentView(R.layout.dialog_protocol_of_usage);
        f(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        this.b = new ViewHolder(this, getWindow().getDecorView());
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        com.rtk.app.tool.t.J1(this.f248c, this.b.dialogProtocolOfUsageTopLv);
    }

    private void e(boolean z) {
        MobSDK.submitPolicyGrantResult(z, new c(this));
    }

    public void f(float f, float f2) {
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
            case R.id.dialog_protocol_of_usage_cancel /* 2131297340 */:
                ((Activity) this.f248c).finish();
                return;
            case R.id.dialog_protocol_of_usage_ensure /* 2131297341 */:
                com.rtk.app.tool.v.e(this.f248c, "AgreePrivacyOfUsageValue" + this.d.getAgreement_id(), Boolean.TRUE);
                e(true);
                dismiss();
                return;
            default:
                return;
        }
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.d.getAgreement_switch().equals("1")) {
            if (com.rtk.app.tool.v.a(this.f248c, "AgreePrivacyOfUsageValue" + this.d.getAgreement_id())) {
                return;
            }
            super.show();
        }
    }
}
