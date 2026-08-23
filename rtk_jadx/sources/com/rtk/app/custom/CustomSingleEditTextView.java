package com.rtk.app.custom;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CustomSingleEditTextView extends LinearLayoutCompat implements TextWatcher {
    EditText a;
    ImageView b;

    /* renamed from: c, reason: collision with root package name */
    TextView f155c;
    private int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CustomSingleEditTextView.this.a.setText("");
        }
    }

    public CustomSingleEditTextView(Context context) {
        super(context);
        this.d = 0;
    }

    private void a() {
        this.a.addTextChangedListener(this);
        this.b.setOnClickListener(new a());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        int length = editable.toString().length();
        this.b.setVisibility(length == 0 ? 8 : 0);
        if (this.d > 0) {
            this.f155c.setText(length + "/" + this.d);
            return;
        }
        this.f155c.setText("");
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
        this.b = (ImageView) findViewById(R.id.delete);
        this.f155c = (TextView) findViewById(2131300394);
        setMaxWordCount(this.d);
        a();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void setContent(String str) {
        this.a.setText(str);
    }

    public void setDigits(DigitsKeyListener digitsKeyListener) {
        this.a.setKeyListener(DigitsKeyListener.getInstance("1234567890X"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setEnabled(boolean z) {
        super/*android.view.ViewGroup*/.setEnabled(z);
        if (!z) {
            setMaxWordCount(0);
            this.a.setEnabled(false);
            this.b.setVisibility(8);
        } else {
            this.a.setEnabled(true);
            this.b.setVisibility(0);
            setMaxWordCount(this.d);
        }
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        this.a.setFilters(inputFilterArr);
    }

    public void setHint(String str) {
        this.a.setHint(str);
    }

    public void setMaxWordCount(int i) {
        this.d = i;
        if (i > 0) {
            this.a.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
            this.f155c.setText(getContent().length() + "/" + i);
            return;
        }
        this.f155c.setText("");
    }

    public CustomSingleEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0;
        this.d = context.obtainStyledAttributes(attributeSet, R.styleable.CustomSingleEditTextView).getInt(0, 0);
    }

    public void setMaxWordCount(int i, InputFilter inputFilter) {
        this.d = i;
        if (i > 0) {
            this.a.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i), inputFilter});
            this.f155c.setText(getContent().length() + "/" + i);
            return;
        }
        this.f155c.setText("");
    }
}
