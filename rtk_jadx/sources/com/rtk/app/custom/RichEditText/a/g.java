package com.rtk.app.custom.RichEditText.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.rtk.app.custom.RichEditText.RichEditText;
import com.rtk.app.custom.RichEditText.UpSrcBean;

/* compiled from: UpSrcBeanPlate.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class g {
    private Context a;
    private RichEditText b;

    public g(Context context, RichEditText richEditText) {
        this.a = context;
        this.b = richEditText;
    }

    public void a(UpSrcBean upSrcBean) {
        String upSrcBean2 = upSrcBean.toString();
        int selectionStart = this.b.getSelectionStart();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(upSrcBean2);
        Context context = this.a;
        spannableStringBuilder.setSpan(new e(context, com.rtk.app.custom.RichEditText.g.b(this.b, context, "UP资源：", upSrcBean.getUpSrcName()), upSrcBean2), 0, upSrcBean2.length(), 33);
        this.b.getEditableText().insert(selectionStart, spannableStringBuilder);
        com.rtk.app.custom.RichEditText.g.a(this.b, upSrcBean2, selectionStart);
        this.b.requestLayout();
        this.b.requestFocus();
    }
}
