package com.rtk.app.custom.RichEditText;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ScrollViewAddEditView extends ScrollView {
    private int a;

    public ScrollViewAddEditView(Context context) {
        super(context);
        this.a = 0;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        if (!(view instanceof EditText)) {
            return false;
        }
        int i = this.a + 1;
        this.a = i;
        return i <= 2;
    }

    public ScrollViewAddEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
    }

    public ScrollViewAddEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
    }
}
