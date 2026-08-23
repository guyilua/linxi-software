package com.rtk.app.main.comment.express;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.AttributeSet;
import android.widget.EditText;
import java.util.regex.Pattern;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FilterEmoJiEditText extends EditText {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements InputFilter {
        Pattern a = Pattern.compile("[🀀-🏿]|[🐀-\u1f7ff]|[☀-⟿]", 66);

        a(FilterEmoJiEditText filterEmoJiEditText) {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            this.a.matcher(charSequence);
            return charSequence;
        }
    }

    public FilterEmoJiEditText(Context context) {
        super(context);
    }

    private void a(Context context) {
        setFilters(new InputFilter[]{new a(this)});
    }

    public FilterEmoJiEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public FilterEmoJiEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
