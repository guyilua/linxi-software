package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.bean.FamilyCoinDetailBean;
import com.rtk.app.custom.CustomTextView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyCoinDetailDialog extends o {
    private ViewHolder k;
    private Context l;
    private FamilyCoinDetailBean.DataBean m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ViewHolder {

        @BindView
        TextView coinDialogName;

        @BindView
        CustomTextView coinDialogNu;

        @BindView
        CustomTextView coinDialogTime;

        @BindView
        CustomTextView coinDialogType;

        @BindView
        RoundedImageView face;

        @BindView
        View userLayout;

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
            viewHolder.coinDialogType = (CustomTextView) butterknife.c.a.c(view, R.id.coin_type, "field 'coinDialogType'", CustomTextView.class);
            viewHolder.coinDialogTime = (CustomTextView) butterknife.c.a.c(view, R.id.coin_dialog_time, "field 'coinDialogTime'", CustomTextView.class);
            viewHolder.coinDialogNu = (CustomTextView) butterknife.c.a.c(view, R.id.coin_dialog_nu, "field 'coinDialogNu'", CustomTextView.class);
            viewHolder.coinDialogName = (TextView) butterknife.c.a.c(view, R.id.coin_dialog_name, "field 'coinDialogName'", TextView.class);
            viewHolder.face = (RoundedImageView) butterknife.c.a.c(view, R.id.coin_dialog_face, "field 'face'", RoundedImageView.class);
            viewHolder.userLayout = butterknife.c.a.b(view, R.id.coin_dialog_user_layout, "field 'userLayout'");
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.coinDialogType = null;
                viewHolder.coinDialogTime = null;
                viewHolder.coinDialogNu = null;
                viewHolder.coinDialogName = null;
                viewHolder.face = null;
                viewHolder.userLayout = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.rtk.app.tool.t.B0(FamilyCoinDetailDialog.this.l, FamilyCoinDetailDialog.this.m.getTransaction_user().getUid());
            FamilyCoinDetailDialog.this.dismiss();
        }
    }

    public FamilyCoinDetailDialog(Context context, FamilyCoinDetailBean.DataBean dataBean) {
        super(context);
        this.l = context;
        this.m = dataBean;
        i(R.layout.family_coin_detail_dialog_layout, 17);
        this.k = new ViewHolder(getWindow().getDecorView());
        s();
        r();
    }

    private void s() {
        this.k.coinDialogName.setText(this.m.getTransaction_user().getNickname());
        this.k.coinDialogType.setText(this.m.getTransaction_type().getName());
        this.k.coinDialogNu.setText(this.m.getTransaction_coin());
        this.k.coinDialogTime.setText(this.m.getTransaction_time());
        com.rtk.app.tool.t.c(this.l, this.m.getTransaction_user().getFace(), this.k.face, new boolean[0]);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void r() {
        this.k.userLayout.setOnClickListener(new a());
    }
}
