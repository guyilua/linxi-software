package com.rtk.app.custom.RichEditText.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.rtk.app.bean.CommunityPostBean;
import com.rtk.app.custom.RichEditText.RichEditText;

/* compiled from: PostBeanPlate.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d {
    private Context a;
    private RichEditText b;

    public d(Context context, RichEditText richEditText) {
        this.a = context;
        this.b = richEditText;
    }

    public void a(CommunityPostBean.DataBean dataBean) {
        String dataBean2 = dataBean.toString();
        int selectionStart = this.b.getSelectionStart();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(dataBean2);
        Context context = this.a;
        spannableStringBuilder.setSpan(new e(context, com.rtk.app.custom.RichEditText.g.b(this.b, context, "帖子：", dataBean.getTitle()), dataBean2), 0, dataBean2.length(), 33);
        this.b.getEditableText().insert(selectionStart, spannableStringBuilder);
        com.rtk.app.custom.RichEditText.g.a(this.b, dataBean2, selectionStart);
        this.b.requestLayout();
        this.b.requestFocus();
    }
}
