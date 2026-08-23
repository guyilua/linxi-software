package com.rtk.app.main.family;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyCoinManagerActivity_ViewBinding implements Unbinder {
    private FamilyCoinManagerActivity b;

    @UiThread
    public FamilyCoinManagerActivity_ViewBinding(FamilyCoinManagerActivity familyCoinManagerActivity, View view) {
        this.b = familyCoinManagerActivity;
        familyCoinManagerActivity.coinNum = (TextView) butterknife.c.a.c(view, R.id.coin_num, "field 'coinNum'", TextView.class);
    }

    @CallSuper
    public void a() {
        FamilyCoinManagerActivity familyCoinManagerActivity = this.b;
        if (familyCoinManagerActivity != null) {
            this.b = null;
            familyCoinManagerActivity.coinNum = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
