package com.rtk.app.main.dialogPack;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.rtk.app.tool.ApkInfo;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DilalogLibao extends Dialog implements View.OnClickListener {
    private Context a;
    private String b;

    /* renamed from: c, reason: collision with root package name */
    private ViewHolder f251c;
    private ApkInfo d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder {

        @BindView
        TextView dialogLibaoClose;

        @BindView
        TextView dialogLibaoCopyBtu;

        @BindView
        TextView dialogLibaoGoToDetails;

        @BindView
        TextView dialogLibaoNumTV;

        @BindView
        TextView dialogLibaoTopLayout;

        ViewHolder(DilalogLibao dilalogLibao, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.dialogLibaoTopLayout = (TextView) butterknife.c.a.c(view, R.id.dialog_libao_top_layout, "field 'dialogLibaoTopLayout'", TextView.class);
            viewHolder.dialogLibaoNumTV = (TextView) butterknife.c.a.c(view, R.id.dialog_libao_numTV, "field 'dialogLibaoNumTV'", TextView.class);
            viewHolder.dialogLibaoCopyBtu = (TextView) butterknife.c.a.c(view, R.id.dialog_libao_copyBtu, "field 'dialogLibaoCopyBtu'", TextView.class);
            viewHolder.dialogLibaoClose = (TextView) butterknife.c.a.c(view, R.id.dialog_libao_close, "field 'dialogLibaoClose'", TextView.class);
            viewHolder.dialogLibaoGoToDetails = (TextView) butterknife.c.a.c(view, R.id.dialog_libao_goToDetails, "field 'dialogLibaoGoToDetails'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.dialogLibaoTopLayout = null;
                viewHolder.dialogLibaoNumTV = null;
                viewHolder.dialogLibaoCopyBtu = null;
                viewHolder.dialogLibaoClose = null;
                viewHolder.dialogLibaoGoToDetails = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public DilalogLibao(@NonNull Context context, String str, ApkInfo apkInfo) {
        super(context);
        this.a = context;
        this.b = str;
        this.d = apkInfo;
        b();
        a();
        setCanceledOnTouchOutside(true);
        c(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
    }

    private void a() {
        this.f251c.dialogLibaoCopyBtu.setOnClickListener(this);
        this.f251c.dialogLibaoClose.setOnClickListener(this);
        this.f251c.dialogLibaoGoToDetails.setOnClickListener(this);
    }

    private void b() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_libao, (ViewGroup) null);
        setContentView(inflate);
        ViewHolder viewHolder = new ViewHolder(this, inflate);
        this.f251c = viewHolder;
        viewHolder.dialogLibaoNumTV.setText(this.b);
        com.rtk.app.tool.t.J1(this.a, this.f251c.dialogLibaoTopLayout);
    }

    public void c(float f, float f2) {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = (int) f;
        attributes.y = (int) f2;
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_libao_close /* 2131297293 */:
                dismiss();
                return;
            case R.id.dialog_libao_copyBtu /* 2131297294 */:
                com.rtk.app.tool.t.I1(getContext(), this.b);
                dismiss();
                return;
            case R.id.dialog_libao_goToDetails /* 2131297295 */:
                com.rtk.app.tool.t.e0(this.a, this.d);
                dismiss();
                return;
            default:
                return;
        }
    }
}
