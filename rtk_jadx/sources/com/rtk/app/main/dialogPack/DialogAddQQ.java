package com.rtk.app.main.dialogPack;

import android.app.Activity;
import android.app.Dialog;
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
import com.rtk.app.bean.GameDetailsBean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogAddQQ extends Dialog implements View.OnClickListener {
    private Window a;
    private ViewHolder b;

    /* renamed from: c, reason: collision with root package name */
    private Activity f235c;
    private GameDetailsBean.DataBean.ContactQQBean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder {

        @BindView
        TextView dialogAddQqOk;

        @BindView
        TextView dialogAddQqTips;

        ViewHolder(DialogAddQQ dialogAddQQ, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.dialogAddQqTips = (TextView) butterknife.c.a.c(view, R.id.dialog_add_qq_tips, "field 'dialogAddQqTips'", TextView.class);
            viewHolder.dialogAddQqOk = (TextView) butterknife.c.a.c(view, R.id.dialog_add_qq_ok, "field 'dialogAddQqOk'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.dialogAddQqTips = null;
                viewHolder.dialogAddQqOk = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public DialogAddQQ(@NonNull Activity activity, GameDetailsBean.DataBean.ContactQQBean contactQQBean) {
        super(activity);
        this.f235c = activity;
        this.d = contactQQBean;
        b();
        a();
    }

    private void a() {
        this.b.dialogAddQqOk.setOnClickListener(this);
    }

    private void b() {
        setContentView(R.layout.dialog_add_qq);
        c(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
        setCanceledOnTouchOutside(true);
        this.b = new ViewHolder(this, getWindow().getDecorView());
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        if (!com.rtk.app.tool.c0.q(this.d.getQQ_show())) {
            this.b.dialogAddQqTips.setText(this.d.getQQ_show());
        }
        com.rtk.app.tool.t.P1(this.b.dialogAddQqOk, this.f235c);
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
        if (view.getId() != 2131297112) {
            return;
        }
        if (!com.rtk.app.tool.c0.q(this.d.getQDKF_url())) {
            com.rtk.app.tool.t.q(this.f235c, this.d.getQDKF_url());
        } else if (!com.rtk.app.tool.c0.q(this.d.getQDKF())) {
            com.rtk.app.tool.t.p(this.f235c, this.d.getQDKF());
        } else if (!com.rtk.app.tool.c0.q(this.d.getQQ())) {
            com.rtk.app.tool.t.k(this.f235c, this.d.getQQ(), this.d.getQQ_show());
            return;
        }
        if (!com.rtk.app.tool.c0.q(this.d.getQQgroup())) {
            com.rtk.app.tool.t.j(this.f235c, this.d.getQQgroup_key());
        } else {
            dismiss();
        }
    }
}
