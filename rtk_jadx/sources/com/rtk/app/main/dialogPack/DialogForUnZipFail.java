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
public class DialogForUnZipFail extends o {
    private Context k;
    private com.rtk.app.tool.s l;
    private String m;
    private ViewHolder n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ViewHolder {

        @BindView
        TextView dialogForUnZipFailBtuCancel;

        @BindView
        TextView dialogForUnZipFailBtuEnsure;

        @BindView
        TextView dialogForUnZipFailHelp;

        @BindView
        TextView dialogForUnZipFailTips;

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
            viewHolder.dialogForUnZipFailTips = (TextView) butterknife.c.a.c(view, R.id.dialog_for_un_zip_fail_tips, "field 'dialogForUnZipFailTips'", TextView.class);
            viewHolder.dialogForUnZipFailBtuCancel = (TextView) butterknife.c.a.c(view, R.id.dialog_for_un_zip_fail_btuCancel, "field 'dialogForUnZipFailBtuCancel'", TextView.class);
            viewHolder.dialogForUnZipFailBtuEnsure = (TextView) butterknife.c.a.c(view, R.id.dialog_for_un_zip_fail_btuEnsure, "field 'dialogForUnZipFailBtuEnsure'", TextView.class);
            viewHolder.dialogForUnZipFailHelp = (TextView) butterknife.c.a.c(view, R.id.dialog_for_un_zip_fail_help, "field 'dialogForUnZipFailHelp'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.dialogForUnZipFailTips = null;
                viewHolder.dialogForUnZipFailBtuCancel = null;
                viewHolder.dialogForUnZipFailBtuEnsure = null;
                viewHolder.dialogForUnZipFailHelp = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public DialogForUnZipFail(Context context, String str, com.rtk.app.tool.s sVar) {
        super(context);
        this.k = context;
        this.m = str;
        this.l = sVar;
        i(R.layout.dialog_for_un_zip_fail_layout, 17);
        p();
        q();
    }

    private void p() {
        ViewHolder viewHolder = new ViewHolder(getWindow().getDecorView());
        this.n = viewHolder;
        viewHolder.dialogForUnZipFailTips.setText(this.m);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_for_un_zip_fail_btuEnsure /* 2131297259 */:
                com.rtk.app.tool.s sVar = this.l;
                if (sVar != null) {
                    sVar.a(new String[0]);
                    break;
                }
                break;
            case R.id.dialog_for_un_zip_fail_help /* 2131297260 */:
                com.rtk.app.tool.t.f1(this.k, "members/sourceZipErrorHelp");
                break;
        }
        dismiss();
    }

    public void q() {
        this.n.dialogForUnZipFailBtuEnsure.setOnClickListener(this);
        this.n.dialogForUnZipFailBtuCancel.setOnClickListener(this);
        this.n.dialogForUnZipFailHelp.setOnClickListener(this);
    }
}
