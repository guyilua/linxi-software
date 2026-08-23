package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.main.MyApplication;
import com.sigmob.sdk.downloader.f;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogUpUserAgreement extends o {
    private com.rtk.app.tool.s k;

    @BindView
    TextView userAgreementNo;

    @BindView
    TextView userAgreementTv;

    @BindView
    TextView userAgreementYes;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a extends b {
        a(int i) {
            super(DialogUpUserAgreement.this, i);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            DialogUpUserAgreement.this.k.a("0");
            com.rtk.app.tool.f.a(DialogUpUserAgreement.this.getContext(), "用户协议", f.a.f);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public abstract class b extends ClickableSpan {
        private int a;

        public b(DialogUpUserAgreement dialogUpUserAgreement, int i) {
            this.a = i;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (this.a == 1) {
                textPaint.setColor(com.rtk.app.tool.t.F(MyApplication.b(), false));
                textPaint.setUnderlineText(false);
            }
        }
    }

    public DialogUpUserAgreement(Context context, com.rtk.app.tool.s sVar) {
        super(context);
        this.k = sVar;
        i(R.layout.dialog_up_user_agreement_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        q();
        r();
    }

    private void q() {
        SpannableString spannableString = new SpannableString("进入下一步前，请先阅读并同意软天空的《UP资源功能使用协议》");
        spannableString.setSpan(new a(1), 18, 30, 33);
        this.userAgreementTv.setText(spannableString);
        this.userAgreementTv.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131301128) {
            dismiss();
            this.k.a("no");
        } else {
            if (id != 2131301130) {
                return;
            }
            dismiss();
            this.k.a("yes");
        }
    }

    public void r() {
        this.userAgreementNo.setOnClickListener(this);
        this.userAgreementYes.setOnClickListener(this);
    }
}
