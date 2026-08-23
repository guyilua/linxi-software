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
public class TeenModeTipDialog extends o {
    private TeenModeTipViewHolder k;
    private com.rtk.app.base.h l;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class TeenModeTipViewHolder {

        @BindView
        TextView backTv;

        @BindView
        TextView openButton;

        TeenModeTipViewHolder(TeenModeTipDialog teenModeTipDialog, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class TeenModeTipViewHolder_ViewBinding implements Unbinder {
        private TeenModeTipViewHolder b;

        @UiThread
        public TeenModeTipViewHolder_ViewBinding(TeenModeTipViewHolder teenModeTipViewHolder, View view) {
            this.b = teenModeTipViewHolder;
            teenModeTipViewHolder.backTv = (TextView) butterknife.c.a.c(view, R.id.dialog_teen_mode_tip_back, "field 'backTv'", TextView.class);
            teenModeTipViewHolder.openButton = (TextView) butterknife.c.a.c(view, R.id.dialog_teen_mode_tip_openButton, "field 'openButton'", TextView.class);
        }

        @CallSuper
        public void a() {
            TeenModeTipViewHolder teenModeTipViewHolder = this.b;
            if (teenModeTipViewHolder != null) {
                this.b = null;
                teenModeTipViewHolder.backTv = null;
                teenModeTipViewHolder.openButton = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public TeenModeTipDialog(Context context, com.rtk.app.base.h hVar) {
        super(context);
        i(R.layout.dialog_teen_mode_tip_layout, 17);
        this.k = new TeenModeTipViewHolder(this, getWindow().getDecorView());
        setCancelable(false);
        this.l = hVar;
        p();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_teen_mode_tip_back /* 2131297371 */:
                this.l.a(new String[0]);
                dismiss();
                return;
            case R.id.dialog_teen_mode_tip_openButton /* 2131297372 */:
                new DialogOpenTeenMode(getContext(), this.l).show();
                dismiss();
                return;
            default:
                return;
        }
    }

    public void p() {
        this.k.openButton.setOnClickListener(this);
        this.k.backTv.setOnClickListener(this);
    }
}
