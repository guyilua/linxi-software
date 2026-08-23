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
import com.rtk.app.main.MyApplication;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyDialogNotice extends Dialog implements View.OnClickListener {
    private int a;
    private Window b;

    /* renamed from: c, reason: collision with root package name */
    private ViewHolder f253c;
    private Context d;
    private String e;
    private MainUseProtocolUpdateNoticeBean.DataBean.AnnouncementBean f;

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

        @BindView
        TextView title;

        ViewHolder(FamilyDialogNotice familyDialogNotice, View view) {
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
            viewHolder.title = (TextView) butterknife.c.a.c(view, 2131300422, "field 'title'", TextView.class);
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
                viewHolder.title = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public FamilyDialogNotice(@NonNull Context context, String str, MainUseProtocolUpdateNoticeBean.DataBean.AnnouncementBean announcementBean) {
        super(context);
        this.d = context;
        this.f = announcementBean;
        this.e = str;
        this.a = com.rtk.app.tool.v.b(context, a());
        String a = a();
        int i = this.a + 1;
        this.a = i;
        com.rtk.app.tool.v.f(context, a, i);
        d();
        c();
        e();
    }

    private void c() {
        this.f253c.dialogNoticeCancel.setOnClickListener(this);
        this.f253c.dialogNoticeEnsure.setOnClickListener(this);
    }

    private void d() {
        setContentView(R.layout.dialog_notice);
        f(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
        setCanceledOnTouchOutside(false);
        this.f253c = new ViewHolder(this, getWindow().getDecorView());
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        if (this.a >= 6) {
            this.f253c.dialogNoticeCheckBox.setChecked(true);
        }
    }

    private void e() {
        this.f253c.dialogNoticeContent.setText(this.f.getAd_desc());
        this.f253c.title.setText("家族公告");
    }

    public String a() {
        return this.e + "_" + this.f.getAd_id();
    }

    public String b() {
        return this.e + "_AdVISIBLE_" + this.f.getAd_id();
    }

    public void f(float f, float f2) {
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
        } else {
            if (id != 2131297314) {
                return;
            }
            if (this.f253c.dialogNoticeCheckBox.isChecked()) {
                com.rtk.app.tool.v.e(this.d, b(), Boolean.TRUE);
            }
            dismiss();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        if (!this.f.getIs_ad().equals("1") || MyApplication.c().contains(a()) || com.rtk.app.tool.v.a(this.d, b())) {
            return;
        }
        super.show();
        MyApplication.c().add(a());
    }
}
