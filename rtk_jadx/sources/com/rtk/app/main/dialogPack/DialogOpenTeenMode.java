package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogOpenTeenMode extends o {
    private TeenModeViewHolder k;
    private com.rtk.app.base.h l;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class TeenModeViewHolder {

        @BindView
        TextView OKTv;

        @BindView
        TextView cancelTv;

        @BindView
        EditText password1Ev;

        @BindView
        EditText password2Ev;

        @BindView
        EditText timeEv;

        TeenModeViewHolder(View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class TeenModeViewHolder_ViewBinding implements Unbinder {
        private TeenModeViewHolder b;

        @UiThread
        public TeenModeViewHolder_ViewBinding(TeenModeViewHolder teenModeViewHolder, View view) {
            this.b = teenModeViewHolder;
            teenModeViewHolder.OKTv = (TextView) butterknife.c.a.c(view, R.id.dialog_open_teen_mode_ok, "field 'OKTv'", TextView.class);
            teenModeViewHolder.cancelTv = (TextView) butterknife.c.a.c(view, R.id.dialog_open_teen_mode_cancel, "field 'cancelTv'", TextView.class);
            teenModeViewHolder.timeEv = (EditText) butterknife.c.a.c(view, R.id.dialog_open_teen_mode_time, "field 'timeEv'", EditText.class);
            teenModeViewHolder.password1Ev = (EditText) butterknife.c.a.c(view, R.id.dialog_open_teen_mode_password1, "field 'password1Ev'", EditText.class);
            teenModeViewHolder.password2Ev = (EditText) butterknife.c.a.c(view, R.id.dialog_open_teen_mode_password2, "field 'password2Ev'", EditText.class);
        }

        @CallSuper
        public void a() {
            TeenModeViewHolder teenModeViewHolder = this.b;
            if (teenModeViewHolder != null) {
                this.b = null;
                teenModeViewHolder.OKTv = null;
                teenModeViewHolder.cancelTv = null;
                teenModeViewHolder.timeEv = null;
                teenModeViewHolder.password1Ev = null;
                teenModeViewHolder.password2Ev = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public DialogOpenTeenMode(Context context, com.rtk.app.base.h hVar) {
        super(context);
        i(R.layout.dialog_open_teen_mode_layout, 17);
        this.k = new TeenModeViewHolder(getWindow().getDecorView());
        setCancelable(false);
        this.l = hVar;
        p();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_open_teen_mode_cancel /* 2131297316 */:
                this.l.a(new String[0]);
                dismiss();
                return;
            case R.id.dialog_open_teen_mode_ok /* 2131297317 */:
                String obj = this.k.password1Ev.getText().toString();
                String obj2 = this.k.password2Ev.getText().toString();
                if (!com.rtk.app.tool.c0.q(obj) && !com.rtk.app.tool.c0.q(obj2)) {
                    if (obj.length() < 4) {
                        com.rtk.app.tool.f.a(getContext(), "密码长度需要大于4", 5000);
                        return;
                    }
                    if (!obj.equals(obj2)) {
                        com.rtk.app.tool.f.a(getContext(), "您两次输入的密码不相同，请重新输入", 5000);
                        return;
                    }
                    String trim = this.k.timeEv.getText().toString().trim();
                    if (com.rtk.app.tool.c0.q(trim)) {
                        com.rtk.app.tool.f.a(getContext(), "请输入时间", 5000);
                        return;
                    } else {
                        this.l.b(obj, trim);
                        dismiss();
                        return;
                    }
                }
                com.rtk.app.tool.f.a(getContext(), "请输入密码", 5000);
                return;
            default:
                return;
        }
    }

    public void p() {
        this.k.cancelTv.setOnClickListener(this);
        this.k.OKTv.setOnClickListener(this);
    }
}
