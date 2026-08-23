package com.rtk.app.custom.AutoListView;

import android.view.View;
import android.widget.AdapterView;
import com.rtk.app.tool.c0;

/* compiled from: MyAdapterOnItemClickListener.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class b implements AdapterView.OnItemClickListener {
    public abstract void a(AdapterView<?> adapterView, View view, int i, long j);

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        try {
            a(adapterView, view, i, j);
        } catch (IndexOutOfBoundsException unused) {
            c0.s("MyAdapterOnItemClickListener", "IndexOutOfBoundsException");
        }
    }
}
