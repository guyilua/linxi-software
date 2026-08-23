package com.rtk.app.main.dialogPack;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.bean.MainUseProtocolUpdateNoticeBean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogNotice extends Dialog implements View.OnClickListener {
    private int a;
    private Window b;

    /* renamed from: c, reason: collision with root package name */
    private ViewHolder f242c;
    private Context d;
    private MainUseProtocolUpdateNoticeBean.DataBean.AnnouncementBean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder {

        @BindView
        ImageView dialogNoticeCancel;

        @BindView
        CheckBox dialogNoticeCheckBox;

        @BindView
        TextView dialogNoticeContent;

        @BindView
        TextView dialogNoticeEnsure;

        ViewHolder(DialogNotice dialogNotice, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.dialogNoticeCancel = (ImageView) butterknife.c.a.c(view, R.id.dialog_notice_cancel, "field 'dialogNoticeCancel'", ImageView.class);
            viewHolder.dialogNoticeContent = (TextView) butterknife.c.a.c(view, R.id.dialog_notice_content, "field 'dialogNoticeContent'", TextView.class);
            viewHolder.dialogNoticeCheckBox = (CheckBox) butterknife.c.a.c(view, R.id.dialog_notice_checkBox, "field 'dialogNoticeCheckBox'", CheckBox.class);
            viewHolder.dialogNoticeEnsure = (TextView) butterknife.c.a.c(view, R.id.dialog_notice_ensure, "field 'dialogNoticeEnsure'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.dialogNoticeCancel = null;
                viewHolder.dialogNoticeContent = null;
                viewHolder.dialogNoticeCheckBox = null;
                viewHolder.dialogNoticeEnsure = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public DialogNotice(@NonNull Context context, MainUseProtocolUpdateNoticeBean.DataBean.AnnouncementBean announcementBean) {
        super(context);
        this.d = context;
        this.e = announcementBean;
        this.a = com.rtk.app.tool.v.b(context, announcementBean.getAd_id());
        String ad_id = announcementBean.getAd_id();
        int i = this.a + 1;
        this.a = i;
        com.rtk.app.tool.v.f(context, ad_id, i);
        b();
        a();
        c();
    }

    private void a() {
        this.f242c.dialogNoticeCancel.setOnClickListener(this);
        this.f242c.dialogNoticeEnsure.setOnClickListener(this);
    }

    private void b() {
        setContentView(R.layout.dialog_notice);
        d(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
        setCanceledOnTouchOutside(false);
        this.f242c = new ViewHolder(this, getWindow().getDecorView());
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        if (this.a >= 6) {
            this.f242c.dialogNoticeCheckBox.setChecked(true);
        }
    }

    private void c() {
        this.f242c.dialogNoticeContent.setText(this.e.getAd_desc());
    }

    public void d(float f, float f2) {
        Window window = getWindow();
        this.b = window;
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = (int) f;
        attributes.y = (int) f2;
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -2;
        this.b.setAttributes(attributes);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131297311) {
            dismiss();
            return;
        }
        if (id != 2131297314) {
            return;
        }
        if (this.f242c.dialogNoticeCheckBox.isChecked()) {
            com.rtk.app.tool.v.e(this.d, "AdVISIBLE" + this.e.getAd_id(), Boolean.TRUE);
        }
        dismiss();
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.e.getIs_ad().equals("1")) {
            if (com.rtk.app.tool.v.a(this.d, "AdVISIBLE" + this.e.getAd_id())) {
                return;
            }
            super.show();
        }
    }
}
