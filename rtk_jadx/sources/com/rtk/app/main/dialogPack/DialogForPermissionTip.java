package com.rtk.app.main.dialogPack;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.main.Home5Activity.PrivacyOfUsageActivity;
import com.rtk.app.main.Home5Activity.ProtocolOfUsageActivity;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForPermissionTip extends o {

    @BindView
    TextView dialogForPermissionAgreement;

    @BindView
    TextView dialogForPermissionBtu;

    @BindView
    TextView dialogForPermissionNo;
    private Context k;
    private com.rtk.app.tool.s l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a extends ClickableSpan {
        a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            com.rtk.app.tool.c.b((Activity) DialogForPermissionTip.this.k, ProtocolOfUsageActivity.class, null);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(DialogForPermissionTip.this.k.getResources().getColor(R.color.theme1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b extends ClickableSpan {
        b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            com.rtk.app.tool.c.b((Activity) DialogForPermissionTip.this.k, PrivacyOfUsageActivity.class, null);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(DialogForPermissionTip.this.k.getResources().getColor(R.color.theme1));
        }
    }

    public DialogForPermissionTip(Context context, com.rtk.app.tool.s sVar) {
        super(context);
        this.k = context;
        this.l = sVar;
        i(R.layout.dialog_for_permission_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        q();
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_for_permission_btu /* 2131297225 */:
                this.l.a("YES");
                dismiss();
                return;
            case R.id.dialog_for_permission_no /* 2131297226 */:
                this.l.a("NO");
                dismiss();
                return;
            default:
                return;
        }
    }

    public void q() {
        this.dialogForPermissionBtu.setOnClickListener(this);
        this.dialogForPermissionNo.setOnClickListener(this);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("查看完整版的《用户服务协议》和《隐私政策》");
        spannableStringBuilder.setSpan(new a(), 6, 14, 33);
        spannableStringBuilder.setSpan(new b(), 15, 21, 33);
        this.dialogForPermissionAgreement.setText(spannableStringBuilder);
        this.dialogForPermissionAgreement.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
