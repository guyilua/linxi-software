package com.rtk.app.custom.RichEditText.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.rtk.app.custom.RichEditText.RichEditText;

/* compiled from: GameBeanPlate.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    private Context a;
    private RichEditText b;

    public a(Context context, RichEditText richEditText) {
        this.a = context;
        this.b = richEditText;
    }

    public void a(com.rtk.app.custom.RichEditText.f fVar) {
        String fVar2 = fVar.toString();
        int selectionStart = this.b.getSelectionStart();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(fVar2);
        Context context = this.a;
        spannableStringBuilder.setSpan(new e(context, com.rtk.app.custom.RichEditText.g.b(this.b, context, "游戏：", fVar.a()), fVar2), 0, fVar2.length(), 33);
        this.b.getEditableText().insert(selectionStart, spannableStringBuilder);
        com.rtk.app.custom.RichEditText.g.a(this.b, fVar2, selectionStart);
        this.b.requestLayout();
        this.b.requestFocus();
    }
}
