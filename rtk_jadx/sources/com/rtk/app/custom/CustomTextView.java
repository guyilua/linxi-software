package com.rtk.app.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.rtk.app.R;
import com.rtk.app.tool.c0;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CustomTextView extends AppCompatTextView {
    private String a;
    private String b;

    /* renamed from: c, reason: collision with root package name */
    private int f156c;
    private boolean d;

    public CustomTextView(Context context) {
        super(context);
        this.a = "";
        this.b = "";
        this.d = false;
        a(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomTextView);
        if (obtainStyledAttributes != null) {
            this.a = obtainStyledAttributes.getString(2);
            this.b = obtainStyledAttributes.getString(3);
            this.f156c = obtainStyledAttributes.getColor(0, -16777216);
            this.d = obtainStyledAttributes.getBoolean(1, false);
        }
        setText(getText());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setLeftText(String str) {
        this.a = str;
        setText(getText());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setRightText(String str) {
        this.b = str;
        setText(getText());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        String str;
        this.a = c0.q(this.a) ? "" : this.a;
        this.b = c0.q(this.b) ? "" : this.b;
        com.rtk.app.main.comment.express.c g = com.rtk.app.main.comment.express.c.g();
        if (this.d) {
            str = this.a + "(" + ((Object) charSequence) + ")" + this.b;
        } else {
            str = this.a + ((Object) charSequence) + this.b;
        }
        if (this.f156c != -16777216) {
            SpannableString spannableString = new SpannableString(str);
            if (!c0.q(this.a)) {
                spannableString.setSpan(new ForegroundColorSpan(this.f156c), 0, this.a.length(), 33);
            }
            if (!c0.q(this.b)) {
                spannableString.setSpan(new ForegroundColorSpan(this.f156c), str.length() - this.b.length(), str.length(), 33);
            }
            try {
                super/*android.widget.TextView*/.setText(g.a(spannableString), bufferType);
                return;
            } catch (Exception e) {
                c0.u("CustomTextView", "某些异常" + e);
                try {
                    super/*android.widget.TextView*/.setText(spannableString, bufferType);
                    return;
                } catch (Exception e2) {
                    c0.u("CustomTextView", "自定义左右视图还是错误" + e2);
                    return;
                }
            }
        }
        super/*android.widget.TextView*/.setText(str, bufferType);
    }

    public CustomTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = "";
        this.b = "";
        this.d = false;
        a(context, attributeSet);
    }

    public CustomTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = "";
        this.b = "";
        this.d = false;
        a(context, attributeSet);
    }
}
