package com.rtk.app.main.dialogPack;

import android.app.Dialog;
import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.bean.DownListBean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogDownLoadTipForInstall extends Dialog implements View.OnClickListener {
    private Context a;
    private DownListBean b;

    /* renamed from: c, reason: collision with root package name */
    private Window f238c;
    private ViewHolder d;
    private com.rtk.app.tool.s e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ViewHolder {

        @BindView
        TextView dialogDownloadForInstallDetails;

        @BindView
        TextView dialogDownloadForInstallEnsure;

        @BindView
        TextView dialogDownloadForInstallTipHint;

        @BindView
        TextView dialogDownloadForInstallTipLayout;

        ViewHolder(View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.dialogDownloadForInstallTipLayout = (TextView) butterknife.c.a.c(view, R.id.dialog_download_for_install_tip_layout, "field 'dialogDownloadForInstallTipLayout'", TextView.class);
            viewHolder.dialogDownloadForInstallTipHint = (TextView) butterknife.c.a.c(view, R.id.dialog_download_for_install_tip_hint, "field 'dialogDownloadForInstallTipHint'", TextView.class);
            viewHolder.dialogDownloadForInstallDetails = (TextView) butterknife.c.a.c(view, R.id.dialog_download_for_install_details, "field 'dialogDownloadForInstallDetails'", TextView.class);
            viewHolder.dialogDownloadForInstallEnsure = (TextView) butterknife.c.a.c(view, R.id.dialog_download_for_install_ensure, "field 'dialogDownloadForInstallEnsure'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.dialogDownloadForInstallTipLayout = null;
                viewHolder.dialogDownloadForInstallTipHint = null;
                viewHolder.dialogDownloadForInstallDetails = null;
                viewHolder.dialogDownloadForInstallEnsure = null;
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
        public void onClick(View view) {
            com.rtk.app.tool.t.p0(DialogDownLoadTipForInstall.this.a, DialogDownLoadTipForInstall.this.b.getPrompt_id());
            DialogDownLoadTipForInstall.this.dismiss();
        }
    }

    public DialogDownLoadTipForInstall(@NonNull Context context, DownListBean downListBean, com.rtk.app.tool.s sVar) {
        super(context);
        this.a = context;
        this.b = downListBean;
        this.e = sVar;
        d();
        c();
    }

    private void c() {
        this.d.dialogDownloadForInstallEnsure.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.main.dialogPack.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogDownLoadTipForInstall.this.f(view);
            }
        });
        this.d.dialogDownloadForInstallDetails.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.main.dialogPack.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogDownLoadTipForInstall.this.h(view);
            }
        });
    }

    private void d() {
        setContentView(R.layout.dialog_download_for_install_tip);
        i(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
        setCanceledOnTouchOutside(true);
        this.d = new ViewHolder(getWindow().getDecorView());
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        com.rtk.app.tool.c0.u("DialogDownLoadTipForInstall", "下载提示" + this.b.getPrompt_message());
        if (!com.rtk.app.tool.c0.q(this.b.getPrompt_message())) {
            this.d.dialogDownloadForInstallTipHint.setText(this.b.getPrompt_message());
        }
        SpannableString spannableString = new SpannableString("查看详情");
        spannableString.setSpan(new a(), 0, spannableString.length(), 17);
        this.d.dialogDownloadForInstallTipHint.append(spannableString);
        this.d.dialogDownloadForInstallTipHint.setMovementMethod(LinkMovementMethod.getInstance());
        com.rtk.app.tool.t.J1(this.a, this.d.dialogDownloadForInstallTipLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(View view) {
        this.e.a(new String[0]);
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(View view) {
        com.rtk.app.tool.t.p0(this.a, this.b.getPrompt_id());
        dismiss();
    }

    public void i(float f, float f2) {
        Window window = getWindow();
        this.f238c = window;
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = (int) f;
        attributes.y = (int) f2;
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -2;
        this.f238c.setAttributes(attributes);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
