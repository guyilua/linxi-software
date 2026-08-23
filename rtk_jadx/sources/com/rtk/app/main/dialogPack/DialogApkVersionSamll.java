package com.rtk.app.main.dialogPack;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.tool.MyUnOrInStallApkBrodcastReceiver;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogApkVersionSamll extends Dialog implements View.OnClickListener {
    private Context a;
    private com.rtk.app.tool.DownLoadTool.p b;

    /* renamed from: c, reason: collision with root package name */
    private Window f236c;
    private ViewHolder d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ViewHolder {

        @BindView
        ImageView dialogApkVersionSamllClose;

        @BindView
        TextView dialogApkVersionSamllInstall;

        @BindView
        TextView dialogApkVersionSamllTips;

        @BindView
        LinearLayout dialogApkVersionSamllTopLayout;

        @BindView
        TextView dialogApkVersionSamllUnInstall;

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
            viewHolder.dialogApkVersionSamllTips = (TextView) butterknife.c.a.c(view, R.id.dialog_apk_version_samll_tips, "field 'dialogApkVersionSamllTips'", TextView.class);
            viewHolder.dialogApkVersionSamllClose = (ImageView) butterknife.c.a.c(view, R.id.dialog_apk_version_samll_close, "field 'dialogApkVersionSamllClose'", ImageView.class);
            viewHolder.dialogApkVersionSamllUnInstall = (TextView) butterknife.c.a.c(view, R.id.dialog_apk_version_samll_unInstall, "field 'dialogApkVersionSamllUnInstall'", TextView.class);
            viewHolder.dialogApkVersionSamllInstall = (TextView) butterknife.c.a.c(view, R.id.dialog_apk_version_samll_install, "field 'dialogApkVersionSamllInstall'", TextView.class);
            viewHolder.dialogApkVersionSamllTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.dialog_apk_version_samll_top_layout, "field 'dialogApkVersionSamllTopLayout'", LinearLayout.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.dialogApkVersionSamllTips = null;
                viewHolder.dialogApkVersionSamllClose = null;
                viewHolder.dialogApkVersionSamllUnInstall = null;
                viewHolder.dialogApkVersionSamllInstall = null;
                viewHolder.dialogApkVersionSamllTopLayout = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements MyUnOrInStallApkBrodcastReceiver.a {
        a() {
        }

        @Override // com.rtk.app.tool.MyUnOrInStallApkBrodcastReceiver.a
        public void a(String str) {
            if (str.equals(DialogApkVersionSamll.this.b.n())) {
                com.rtk.app.tool.t.m1(DialogApkVersionSamll.this.a, DialogApkVersionSamll.this.b);
            }
        }
    }

    public DialogApkVersionSamll(@NonNull Context context, com.rtk.app.tool.DownLoadTool.p pVar) {
        super(context);
        this.a = context;
        this.b = pVar;
        d();
        c();
    }

    private void c() {
        this.d.dialogApkVersionSamllClose.setOnClickListener(this);
        this.d.dialogApkVersionSamllUnInstall.setOnClickListener(this);
        this.d.dialogApkVersionSamllInstall.setOnClickListener(this);
    }

    private void d() {
        setContentView(R.layout.dialog_apk_version_samll);
        e(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
        setCanceledOnTouchOutside(true);
        this.d = new ViewHolder(getWindow().getDecorView());
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        this.d.dialogApkVersionSamllTopLayout.setBackgroundColor(this.a.getResources().getColor(com.rtk.app.tool.t.F(this.a, new boolean[0])));
        this.d.dialogApkVersionSamllTips.setText("提示（" + this.b.c() + "）");
    }

    public void e(float f, float f2) {
        Window window = getWindow();
        this.f236c = window;
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = (int) f;
        attributes.y = (int) f2;
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -2;
        this.f236c.setAttributes(attributes);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_apk_version_samll_close /* 2131297115 */:
                dismiss();
                return;
            case R.id.dialog_apk_version_samll_install /* 2131297116 */:
                com.rtk.app.tool.t.n1(this.a, this.b.e());
                dismiss();
                return;
            case R.id.dialog_apk_version_samll_tips /* 2131297117 */:
            case R.id.dialog_apk_version_samll_top_layout /* 2131297118 */:
            default:
                return;
            case R.id.dialog_apk_version_samll_unInstall /* 2131297119 */:
                com.rtk.app.tool.t.g2(this.a, this.b.n());
                MyUnOrInStallApkBrodcastReceiver.a = new a();
                dismiss();
                return;
        }
    }
}
