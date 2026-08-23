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
public class DialogGameMd5Different extends Dialog implements View.OnClickListener {
    private Context a;
    private com.rtk.app.tool.DownLoadTool.p b;

    /* renamed from: c, reason: collision with root package name */
    private Window f239c;
    private ViewHolder d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder {

        @BindView
        ImageView dialogGameMd5DifferentClose;

        @BindView
        TextView dialogGameMd5DifferentInstall;

        @BindView
        TextView dialogGameMd5DifferentTip;

        @BindView
        LinearLayout dialogGameMd5DifferentTopLayout;

        @BindView
        TextView dialogGameMd5DifferentUnInstall;

        ViewHolder(DialogGameMd5Different dialogGameMd5Different, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.dialogGameMd5DifferentTip = (TextView) butterknife.c.a.c(view, R.id.dialog_game_md5_different_tip, "field 'dialogGameMd5DifferentTip'", TextView.class);
            viewHolder.dialogGameMd5DifferentClose = (ImageView) butterknife.c.a.c(view, R.id.dialog_game_md5_different_close, "field 'dialogGameMd5DifferentClose'", ImageView.class);
            viewHolder.dialogGameMd5DifferentTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.dialog_game_md5_different_top_layout, "field 'dialogGameMd5DifferentTopLayout'", LinearLayout.class);
            viewHolder.dialogGameMd5DifferentUnInstall = (TextView) butterknife.c.a.c(view, R.id.dialog_game_md5_different_unInstall, "field 'dialogGameMd5DifferentUnInstall'", TextView.class);
            viewHolder.dialogGameMd5DifferentInstall = (TextView) butterknife.c.a.c(view, R.id.dialog_game_md5_different_install, "field 'dialogGameMd5DifferentInstall'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.dialogGameMd5DifferentTip = null;
                viewHolder.dialogGameMd5DifferentClose = null;
                viewHolder.dialogGameMd5DifferentTopLayout = null;
                viewHolder.dialogGameMd5DifferentUnInstall = null;
                viewHolder.dialogGameMd5DifferentInstall = null;
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
            if (str.equals(DialogGameMd5Different.this.b.n())) {
                com.rtk.app.tool.t.m1(DialogGameMd5Different.this.a, DialogGameMd5Different.this.b);
            }
        }
    }

    public DialogGameMd5Different(@NonNull Context context, com.rtk.app.tool.DownLoadTool.p pVar) {
        super(context);
        this.a = context;
        this.b = pVar;
        d();
        c();
    }

    private void c() {
        this.d.dialogGameMd5DifferentClose.setOnClickListener(this);
        this.d.dialogGameMd5DifferentUnInstall.setOnClickListener(this);
        this.d.dialogGameMd5DifferentInstall.setOnClickListener(this);
    }

    private void d() {
        setContentView(R.layout.dialog_game_md5_different);
        e(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
        setCanceledOnTouchOutside(true);
        this.d = new ViewHolder(this, getWindow().getDecorView());
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        this.d.dialogGameMd5DifferentTopLayout.setBackgroundColor(this.a.getResources().getColor(com.rtk.app.tool.t.F(this.a, new boolean[0])));
        this.d.dialogGameMd5DifferentTip.setText("提示（" + this.b.c() + "）");
    }

    public void e(float f, float f2) {
        Window window = getWindow();
        this.f239c = window;
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = (int) f;
        attributes.y = (int) f2;
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -2;
        this.f239c.setAttributes(attributes);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_game_md5_different_close /* 2131297281 */:
                dismiss();
                return;
            case R.id.dialog_game_md5_different_install /* 2131297282 */:
                dismiss();
                return;
            case R.id.dialog_game_md5_different_tip /* 2131297283 */:
            case R.id.dialog_game_md5_different_top_layout /* 2131297284 */:
            default:
                return;
            case R.id.dialog_game_md5_different_unInstall /* 2131297285 */:
                com.rtk.app.tool.t.g2(this.a, this.b.n());
                MyUnOrInStallApkBrodcastReceiver.a = new a();
                dismiss();
                return;
        }
    }
}
