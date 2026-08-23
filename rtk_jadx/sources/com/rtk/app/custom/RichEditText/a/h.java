package com.rtk.app.custom.RichEditText.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.rtk.app.bean.MyAttentionBean;
import com.rtk.app.custom.RichEditText.RichEditText;

/* compiled from: UserBeanPlate.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class h {
    private Context a;
    private RichEditText b;

    public h(Context context, RichEditText richEditText) {
        this.a = context;
        this.b = richEditText;
    }

    public void a(MyAttentionBean.DataBean dataBean) {
        String dataBean2 = dataBean.toString();
        int selectionStart = this.b.getSelectionStart();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(dataBean2);
        Context context = this.a;
        spannableStringBuilder.setSpan(new e(context, com.rtk.app.custom.RichEditText.g.b(this.b, context, "@：", dataBean.getNickname()), dataBean2), 0, dataBean2.length(), 33);
        this.b.getEditableText().insert(selectionStart, spannableStringBuilder);
        com.rtk.app.custom.RichEditText.g.a(this.b, dataBean2, selectionStart);
        this.b.requestLayout();
        this.b.requestFocus();
    }
}
