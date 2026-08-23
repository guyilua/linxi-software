package com.rtk.app.custom;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class YcSwipeRefreshLayout extends SwipeRefreshLayout {
    public YcSwipeRefreshLayout(@NonNull Context context) {
        super(context);
    }

    public void setRefreshing(boolean z) {
        super.setRefreshing(z);
        setEnabled(!z);
    }

    public YcSwipeRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
