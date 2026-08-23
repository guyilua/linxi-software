package com.rtk.app.custom;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CustomMultiLineEditTextView extends LinearLayoutCompat implements TextWatcher {
    EditText a;
    TextView b;

    /* renamed from: c, reason: collision with root package name */
    private int f154c;

    public CustomMultiLineEditTextView(Context context) {
        this(context, null);
    }

    private void a() {
        this.a.addTextChangedListener(this);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        int length = editable.toString().length();
        if (this.f154c > 0) {
            this.b.setText(length + "/" + this.f154c);
            return;
        }
        this.b.setText("");
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public String getContent() {
        return this.a.getText().toString();
    }

    public EditText getEditText() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onFinishInflate() {
        super/*android.view.ViewGroup*/.onFinishInflate();
        this.a = (EditText) findViewById(R.id.edit_text);
        this.b = (TextView) findViewById(2131300394);
        setMaxWordCount(this.f154c);
        a();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void setContent(String str) {
        this.a.setText(str);
    }

    public void setHint(String str) {
        this.a.setHint(str);
    }

    public void setMaxWordCount(int i) {
        this.f154c = i;
        if (i > 0) {
            this.a.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
            this.b.setText(getContent().length() + "/" + i);
            return;
        }
        this.b.setText("");
    }

    public CustomMultiLineEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f154c = context.obtainStyledAttributes(attributeSet, R.styleable.CustomSingleEditTextView).getInt(0, 0);
    }
}
