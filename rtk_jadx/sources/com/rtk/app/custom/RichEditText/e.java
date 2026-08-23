package com.rtk.app.custom.RichEditText;

import android.text.Editable;
import android.text.TextWatcher;
import com.rtk.app.tool.c0;
import com.umeng.umcrash.UMCustomLogInfoBuilder;

/* compiled from: ForRichEditTextWatcher.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e implements TextWatcher {
    private RichEditText a;

    public e(RichEditText richEditText) {
        this.a = richEditText;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String obj;
        int lastIndexOf;
        RichEditText richEditText = this.a;
        richEditText.a = this;
        richEditText.b(this);
        try {
            try {
                obj = this.a.getText().toString();
            } catch (Exception e) {
                c0.u("ForRichEditTextWatcher", "文本监听异常" + e.toString());
            }
            if (i <= obj.length()) {
                String substring = obj.substring(0, i);
                int i4 = i + i3;
                String substring2 = charSequence.toString().substring(i, i4);
                if (!substring2.equals(UMCustomLogInfoBuilder.LINE_SEP)) {
                    c0.u("ForRichEditTextWatcher", " before " + i2 + "  count " + i3);
                    if (i2 == 0) {
                        String substring3 = obj.substring(i4);
                        RichEditText richEditText2 = this.a;
                        if (richEditText2.j) {
                            richEditText2.j = false;
                            richEditText2.b(this);
                            this.a.getEditableText().replace(i, i4, "");
                            this.a.setTagStr(substring2);
                            this.a.a(this);
                        } else {
                            ResourceTypeBean c2 = g.c(substring, substring3);
                            c0.u("ForRichEditTextWatcher", " before " + i2 + "  count " + i3 + "   新输入文本  " + substring2);
                            if (c2 == null) {
                                c0.u("ForRichEditTextWatcher", "是空的");
                            } else if (c2.getIsStart()) {
                                this.a.b(this);
                                c0.u("ForRichEditTextWatcher", "在前面插入文本");
                                ResourceTypeBean c3 = g.c(substring2, "");
                                if (c3 == null || !c3.getIsResource()) {
                                    c0.u("ForRichEditTextWatcher", "输入文本  cutStr" + substring2 + "  cutStr.length=" + substring2.length() + "  count=" + i3 + "  s1 " + substring2 + "  s1.length" + substring2.length());
                                    String replace = substring2.replace(UMCustomLogInfoBuilder.LINE_SEP, "");
                                    if (replace.length() > 0 && replace.length() == i3) {
                                        this.a.getEditableText().insert(i4, UMCustomLogInfoBuilder.LINE_SEP);
                                    }
                                    if (substring.endsWith(UMCustomLogInfoBuilder.LINE_SEP)) {
                                        if (g.c(substring.substring(0, substring.length() - 1), "") == null) {
                                            this.a.getEditableText().delete(i - 1, i);
                                            this.a.setSelection((i4 - 1) - i2);
                                        } else {
                                            this.a.setSelection(i4 - i2);
                                        }
                                    }
                                }
                                this.a.a(this);
                            } else {
                                this.a.b(this);
                                c0.u("ForRichEditTextWatcher", "尾部文本" + substring3.substring(1));
                                if (substring3.startsWith(UMCustomLogInfoBuilder.LINE_SEP)) {
                                    ResourceTypeBean c4 = g.c("", substring3.substring(1));
                                    this.a.getEditableText().insert(i, UMCustomLogInfoBuilder.LINE_SEP);
                                    if (c4 == null) {
                                        this.a.getEditableText().delete(i4 + 1, i4 + 2);
                                    }
                                }
                                this.a.a(this);
                            }
                        }
                    } else {
                        if (i3 != 0 || i <= 0) {
                            if (i2 > 0 && i3 > 0) {
                                RichEditText richEditText3 = this.a;
                                if (richEditText3.j) {
                                    richEditText3.j = false;
                                    richEditText3.b(this);
                                    if (i > 0) {
                                        this.a.getEditableText().replace(i, i4, "");
                                    }
                                    c0.u("ForRichEditTextWatcher", "裁剪出来的数据" + substring2);
                                    substring2.replaceAll("<br>", " ");
                                    this.a.setTagStr(substring2);
                                    this.a.requestLayout();
                                    this.a.requestFocus();
                                    this.a.a(this);
                                }
                            }
                            return;
                        }
                        ResourceTypeBean c5 = g.c(substring, obj.substring(i, obj.length()));
                        if (c5 != null) {
                            if (c5.getIsStart()) {
                                this.a.b(this);
                                c0.u("ForRichEditTextWatcher", "删除前面的数据");
                                if (i > 1) {
                                    int i5 = i - 1;
                                    this.a.getEditableText().replace(i5, i, "");
                                    this.a.getEditableText().insert(i5, UMCustomLogInfoBuilder.LINE_SEP);
                                    this.a.setSelection(i5);
                                }
                                this.a.a(this);
                            } else {
                                this.a.b(this);
                                c0.u("ForRichEditTextWatcher", "删除后面的数据");
                                if (!c5.getIsStart()) {
                                    lastIndexOf = substring.lastIndexOf("[" + c5.getResourceType());
                                } else {
                                    lastIndexOf = substring.lastIndexOf("[img]");
                                }
                                if (lastIndexOf >= 0) {
                                    this.a.getEditableText().replace(lastIndexOf, i, "");
                                }
                                this.a.a(this);
                            }
                        }
                    }
                }
            }
        } finally {
            this.a.a(this);
        }
    }
}
