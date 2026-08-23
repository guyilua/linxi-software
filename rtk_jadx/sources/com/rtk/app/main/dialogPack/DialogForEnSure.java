package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForEnSure extends o {
    private com.rtk.app.tool.s k;
    private String l;
    private ViewHolder m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ViewHolder {

        @BindView
        TextView dialogForEnsureBtuCancel;

        @BindView
        TextView dialogForEnsureBtuEnsure;

        @BindView
        TextView dialogForEnsureTips;

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
            viewHolder.dialogForEnsureTips = (TextView) butterknife.c.a.c(view, R.id.dialog_for_ensure_tips, "field 'dialogForEnsureTips'", TextView.class);
            viewHolder.dialogForEnsureBtuCancel = (TextView) butterknife.c.a.c(view, R.id.dialog_for_ensure_btuCancel, "field 'dialogForEnsureBtuCancel'", TextView.class);
            viewHolder.dialogForEnsureBtuEnsure = (TextView) butterknife.c.a.c(view, R.id.dialog_for_ensure_btuEnsure, "field 'dialogForEnsureBtuEnsure'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.dialogForEnsureTips = null;
                viewHolder.dialogForEnsureBtuCancel = null;
                viewHolder.dialogForEnsureBtuEnsure = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public DialogForEnSure(Context context, String str, com.rtk.app.tool.s sVar) {
        super(context);
        this.l = str;
        this.k = sVar;
        i(R.layout.dialog_for_ensure_layout, 17);
        p();
        q();
    }

    private void p() {
        ViewHolder viewHolder = new ViewHolder(getWindow().getDecorView());
        this.m = viewHolder;
        viewHolder.dialogForEnsureTips.setText(this.l);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.rtk.app.tool.s sVar;
        if (view.getId() == 2131297200 && (sVar = this.k) != null) {
            sVar.a(new String[0]);
        }
        dismiss();
    }

    public void q() {
        this.m.dialogForEnsureBtuEnsure.setOnClickListener(this);
        this.m.dialogForEnsureBtuCancel.setOnClickListener(this);
    }
}
