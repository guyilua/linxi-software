package com.rtk.app.main.comment;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

/* compiled from: MyTextWatcher.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class g implements TextWatcher {
    private int a;
    private int b;

    /* renamed from: c, reason: collision with root package name */
    private EditText f233c;
    private int d;
    private TextView e;
    private TextView f;

    public g(EditText editText, int i, TextView textView, TextView textView2) {
        this.f233c = editText;
        this.d = i;
        this.e = textView;
        this.f = textView2;
    }

    private long a() {
        return EmojioAdapter.a(this.f233c.getText().toString());
    }

    private void b() {
        this.e.setText(String.valueOf(a()) + "/" + this.d);
        if (this.f != null) {
            if (a() > 0) {
                this.f.setEnabled(true);
            } else {
                this.f.setEnabled(false);
            }
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.a = this.f233c.getSelectionStart();
        this.b = this.f233c.getSelectionEnd();
        this.f233c.removeTextChangedListener(this);
        while (EmojioAdapter.a(editable.toString()) > this.d) {
            editable.delete(this.a - 1, this.b);
            this.a--;
            this.b--;
        }
        this.f233c.addTextChangedListener(this);
        b();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
