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
public class DialogForService extends o {
    private ViewHolder k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ViewHolder {

        @BindView
        TextView dialogForServiceEnsure;

        @BindView
        TextView dialogForServiceTc1;

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
            viewHolder.dialogForServiceTc1 = (TextView) butterknife.c.a.c(view, R.id.dialog_for_service_tc1, "field 'dialogForServiceTc1'", TextView.class);
            viewHolder.dialogForServiceEnsure = (TextView) butterknife.c.a.c(view, R.id.dialog_for_service_ensure, "field 'dialogForServiceEnsure'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.dialogForServiceTc1 = null;
                viewHolder.dialogForServiceEnsure = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public DialogForService(Context context) {
        super(context);
        i(R.layout.dialog_for_service_layout, 17);
        this.k = new ViewHolder(getWindow().getDecorView());
        p();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131297253) {
            return;
        }
        dismiss();
    }

    public void p() {
        this.k.dialogForServiceEnsure.setOnClickListener(this);
    }
}
