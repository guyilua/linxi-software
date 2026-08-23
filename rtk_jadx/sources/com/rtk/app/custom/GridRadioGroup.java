package com.rtk.app.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.GridLayout;
import android.widget.RadioButton;
import androidx.annotation.IdRes;
import androidx.annotation.RequiresApi;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GridRadioGroup extends GridLayout {
    private CompoundButton.OnCheckedChangeListener a;
    private boolean b;

    /* renamed from: c, reason: collision with root package name */
    private c f158c;
    private int d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        private b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (GridRadioGroup.this.b) {
                return;
            }
            GridRadioGroup.this.b = true;
            if (GridRadioGroup.this.d != -1) {
                GridRadioGroup gridRadioGroup = GridRadioGroup.this;
                gridRadioGroup.h(gridRadioGroup.d, false);
            }
            GridRadioGroup.this.b = false;
            GridRadioGroup.this.setCheckedId(compoundButton.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class c implements ViewGroup.OnHierarchyChangeListener {
        private ViewGroup.OnHierarchyChangeListener a;

        private c() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        @RequiresApi(api = 17)
        public void onChildViewAdded(View view, View view2) {
            if (view == GridRadioGroup.this && (view2 instanceof RadioButton)) {
                if (view2.getId() == -1) {
                    view2.setId(View.generateViewId());
                }
                ((RadioButton) view2).setOnCheckedChangeListener(GridRadioGroup.this.a);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (view == GridRadioGroup.this && (view2 instanceof RadioButton)) {
                ((RadioButton) view2).setOnCheckedChangeListener(null);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public GridRadioGroup(Context context) {
        super(context);
        this.b = false;
        this.d = -1;
    }

    private void g() {
        this.a = new b();
        c cVar = new c();
        this.f158c = cVar;
        super.setOnHierarchyChangeListener(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, boolean z) {
        View findViewById = findViewById(i);
        if (findViewById == null || !(findViewById instanceof RadioButton)) {
            return;
        }
        ((RadioButton) findViewById).setChecked(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(@IdRes int i) {
        this.d = i;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof RadioButton) {
            RadioButton radioButton = (RadioButton) view;
            if (radioButton.isChecked()) {
                this.b = true;
                int i2 = this.d;
                if (i2 != -1) {
                    h(i2, false);
                }
                this.b = false;
                setCheckedId(radioButton.getId());
            }
        }
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i = this.d;
        if (i != -1) {
            this.b = true;
            h(i, true);
            this.b = false;
            setCheckedId(this.d);
        }
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f158c.a = onHierarchyChangeListener;
    }

    public GridRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = false;
        this.d = -1;
        g();
    }
}
