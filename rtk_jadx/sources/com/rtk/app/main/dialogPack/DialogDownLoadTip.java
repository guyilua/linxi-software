package com.rtk.app.main.dialogPack;

import android.app.Dialog;
import android.content.Context;
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
import com.rtk.app.main.MyApplication;
import com.rtk.app.tool.ApkInfo;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogDownLoadTip extends Dialog implements View.OnClickListener {
    private Context a;
    private com.rtk.app.tool.DownLoadTool.p b;

    /* renamed from: c, reason: collision with root package name */
    private Window f237c;
    private ViewHolder d;
    private String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ViewHolder {

        @BindView
        TextView dialogDownloadTipLayout;

        @BindView
        TextView toDownloadCancle;

        @BindView
        TextView toDownloadHint;

        @BindView
        TextView toDownloadOk;

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
            viewHolder.toDownloadHint = (TextView) butterknife.c.a.c(view, R.id.to_download_hint, "field 'toDownloadHint'", TextView.class);
            viewHolder.toDownloadOk = (TextView) butterknife.c.a.c(view, R.id.to_download_ok, "field 'toDownloadOk'", TextView.class);
            viewHolder.toDownloadCancle = (TextView) butterknife.c.a.c(view, R.id.to_download_cancle, "field 'toDownloadCancle'", TextView.class);
            viewHolder.dialogDownloadTipLayout = (TextView) butterknife.c.a.c(view, R.id.dialog_download_tip_layout, "field 'dialogDownloadTipLayout'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.toDownloadHint = null;
                viewHolder.toDownloadOk = null;
                viewHolder.toDownloadCancle = null;
                viewHolder.dialogDownloadTipLayout = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public DialogDownLoadTip(@NonNull Context context, com.rtk.app.tool.DownLoadTool.p pVar, String str) {
        super(context);
        this.a = context;
        this.b = pVar;
        this.e = str;
        b();
        a();
    }

    private void a() {
        this.d.toDownloadOk.setOnClickListener(this);
        this.d.toDownloadCancle.setOnClickListener(this);
    }

    private void b() {
        setContentView(R.layout.dialog_download_tip);
        c(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
        setCanceledOnTouchOutside(true);
        this.d = new ViewHolder(getWindow().getDecorView());
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        this.d.toDownloadHint.setText(this.e);
        com.rtk.app.tool.t.J1(this.a, this.d.dialogDownloadTipLayout);
    }

    public void c(float f, float f2) {
        Window window = getWindow();
        this.f237c = window;
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = (int) f;
        attributes.y = (int) f2;
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -2;
        this.f237c.setAttributes(attributes);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131300427) {
            dismiss();
        } else {
            if (id != 2131300429) {
                return;
            }
            if (this.b.j() < 10000000) {
                com.rtk.app.tool.t.e0(MyApplication.b(), new ApkInfo(this.b));
            } else {
                com.rtk.app.tool.t.X0(MyApplication.b(), new ApkInfo(this.b));
            }
            dismiss();
        }
    }
}
