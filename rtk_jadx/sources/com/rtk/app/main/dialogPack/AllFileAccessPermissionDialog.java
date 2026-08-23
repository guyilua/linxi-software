package com.rtk.app.main.dialogPack;

import android.app.Activity;
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

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AllFileAccessPermissionDialog extends Dialog implements View.OnClickListener {
    public static String f;
    private Window a;
    private ViewHolder b;

    /* renamed from: c, reason: collision with root package name */
    private Context f234c;
    private boolean d;
    private a e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder {

        @BindView
        TextView dialogPermissionCancel;

        @BindView
        TextView dialogPermissionEnsure;

        @BindView
        TextView dialogPermissionTips;

        ViewHolder(AllFileAccessPermissionDialog allFileAccessPermissionDialog, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.dialogPermissionTips = (TextView) butterknife.c.a.c(view, R.id.dialog_permission_tips, "field 'dialogPermissionTips'", TextView.class);
            viewHolder.dialogPermissionEnsure = (TextView) butterknife.c.a.c(view, R.id.dialog_permission_ensure, "field 'dialogPermissionEnsure'", TextView.class);
            viewHolder.dialogPermissionCancel = (TextView) butterknife.c.a.c(view, R.id.dialog_permission_cancel, "field 'dialogPermissionCancel'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.dialogPermissionTips = null;
                viewHolder.dialogPermissionEnsure = null;
                viewHolder.dialogPermissionCancel = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a(AllFileAccessPermissionDialog allFileAccessPermissionDialog);

        void b(AllFileAccessPermissionDialog allFileAccessPermissionDialog);
    }

    public AllFileAccessPermissionDialog(@NonNull Context context, String str) {
        super(context);
        this.d = false;
        this.f234c = context;
        f = str;
        b();
        a();
        c();
    }

    private void a() {
        this.b.dialogPermissionCancel.setOnClickListener(this);
        this.b.dialogPermissionEnsure.setOnClickListener(this);
    }

    private void b() {
        setContentView(R.layout.dialog_permision);
        f(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
        setCanceledOnTouchOutside(false);
        this.b = new ViewHolder(this, getWindow().getDecorView());
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }

    private void c() {
        this.b.dialogPermissionTips.setText(f);
    }

    public void d(a aVar) {
        this.e = aVar;
    }

    public void e() {
        this.d = true;
    }

    public void f(float f2, float f3) {
        Window window = getWindow();
        this.a = window;
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = (int) f2;
        attributes.y = (int) f3;
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -2;
        this.a.setAttributes(attributes);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_permission_cancel /* 2131297325 */:
                dismiss();
                a aVar = this.e;
                if (aVar != null) {
                    aVar.b(this);
                }
                if (this.d) {
                    ((Activity) this.f234c).finish();
                    return;
                }
                return;
            case R.id.dialog_permission_ensure /* 2131297326 */:
                com.rtk.app.tool.r.f(this.f234c);
                a aVar2 = this.e;
                if (aVar2 != null) {
                    aVar2.a(this);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
