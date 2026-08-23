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
public class DialogLoginUserAgreement extends o {
    private com.rtk.app.tool.s k;

    @BindView
    TextView userAgreementNo;

    @BindView
    TextView userAgreementTv;

    @BindView
    TextView userAgreementYes;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a extends c {
        a(int i) {
            super(DialogLoginUserAgreement.this, i);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            DialogLoginUserAgreement.this.k.a("0");
            com.rtk.app.tool.f.a(DialogLoginUserAgreement.this.getContext(), "用户协议", f.a.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b extends c {
        b(int i) {
            super(DialogLoginUserAgreement.this, i);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            com.rtk.app.tool.f.a(DialogLoginUserAgreement.this.getContext(), "隐私政策", f.a.f);
            DialogLoginUserAgreement.this.k.a("1");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public abstract class c extends ClickableSpan {
        private int a;

        public c(DialogLoginUserAgreement dialogLoginUserAgreement, int i) {
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

    public DialogLoginUserAgreement(Context context, com.rtk.app.tool.s sVar) {
        super(context);
        this.k = sVar;
        i(R.layout.dialog_login_user_agreement_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        q();
        r();
    }

    private void q() {
        SpannableString spannableString = new SpannableString("进入下一步前，请先阅读并同意软天空的《用户协议》、《隐私政策》");
        spannableString.setSpan(new a(1), 18, 24, 33);
        spannableString.setSpan(new b(1), 25, 31, 33);
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
