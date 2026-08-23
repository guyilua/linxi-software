package com.rtk.app.main.coins;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ExchangeRecordsActivity_ViewBinding implements Unbinder {
    private ExchangeRecordsActivity b;

    @UiThread
    public ExchangeRecordsActivity_ViewBinding(ExchangeRecordsActivity exchangeRecordsActivity, View view) {
        this.b = exchangeRecordsActivity;
        exchangeRecordsActivity.autoListView = (AutoListView) butterknife.c.a.c(view, R.id.listview, "field 'autoListView'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        ExchangeRecordsActivity exchangeRecordsActivity = this.b;
        if (exchangeRecordsActivity != null) {
            this.b = null;
            exchangeRecordsActivity.autoListView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
