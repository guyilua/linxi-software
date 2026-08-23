package com.rtk.app.custom.RichEditText;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatEditText;
import com.rtk.app.tool.c0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class BaseRitchEdit extends AppCompatEditText {
    public e a;
    private List<e> b;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a(d dVar);

        void b(int i, int i2);
    }

    public BaseRitchEdit(Context context) {
        super(context);
        this.b = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(e eVar) {
        if (this.b.size() == 0 || !this.b.contains(eVar)) {
            super/*android.widget.EditText*/.addTextChangedListener(eVar);
            this.b.add(eVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(e eVar) {
        super/*android.widget.EditText*/.removeTextChangedListener(eVar);
        this.b.remove(eVar);
        for (int i = 0; i < this.b.size(); i++) {
            e eVar2 = this.b.get(0);
            this.b.remove(0);
            super/*android.widget.EditText*/.removeTextChangedListener(eVar2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            c0.u("BaseRitchEdit", "点击了");
            a(this.a);
        }
        try {
            return super/*android.widget.EditText*/.onTouchEvent(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public BaseRitchEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new ArrayList();
    }

    public BaseRitchEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new ArrayList();
    }
}
