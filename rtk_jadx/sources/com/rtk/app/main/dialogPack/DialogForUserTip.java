package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.bean.MainUseProtocolUpdateNoticeBean;
import java.util.ArrayList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForUserTip extends o {

    @BindView
    TextView dialogForCheckAppSignLayoutCancle;

    @BindView
    TextView dialogForCheckAppSignLayoutSubmit;

    @BindView
    TextView dialogForCheckAppSignLayoutTip;

    @BindView
    TextView dialogForCheckAppSignLayoutTitle;
    private Context k;
    private MainUseProtocolUpdateNoticeBean.DataBean.SignBean l;

    public DialogForUserTip(Context context, MainUseProtocolUpdateNoticeBean.DataBean.SignBean signBean) {
        super(context);
        this.k = context;
        this.l = signBean;
        i(R.layout.dialog_for_check_app_sign_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        p();
        com.rtk.app.tool.c0.u("DialogForUserTip", "应该显示" + com.rtk.app.tool.w.b(context, context.getPackageName()));
        if (signBean.getIs_signature().equals("1") && !signBean.getSignature_val().equalsIgnoreCase(com.rtk.app.tool.w.b(context, context.getPackageName()))) {
            this.dialogForCheckAppSignLayoutTip.setText(signBean.getSignature_msg());
            show();
            com.rtk.app.tool.c0.u("DialogForUserTip", "应该显示");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("40o+Q406S6");
        arrayList.add("40LiL6L2940q2j404mI");
        arrayList.add("4040+l6YGT40LqG");
        this.dialogForCheckAppSignLayoutTitle.setText(new String(Base64.decode(((String) arrayList.get(0)).replaceAll("40", "5"), 2)));
        this.dialogForCheckAppSignLayoutSubmit.setText(new String(Base64.decode(((String) arrayList.get(1)).replaceAll("40", "5"), 2)));
        this.dialogForCheckAppSignLayoutCancle.setText(new String(Base64.decode(((String) arrayList.get(2)).replaceAll("40", "5"), 2)));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_for_check_app_sign_layout_cancle /* 2131297168 */:
                dismiss();
                return;
            case R.id.dialog_for_check_app_sign_layout_submit /* 2131297169 */:
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(this.l.getSignature_url()));
                this.k.startActivity(intent);
                dismiss();
                return;
            default:
                return;
        }
    }

    public void p() {
        this.dialogForCheckAppSignLayoutSubmit.setOnClickListener(this);
        this.dialogForCheckAppSignLayoutCancle.setOnClickListener(this);
    }
}
