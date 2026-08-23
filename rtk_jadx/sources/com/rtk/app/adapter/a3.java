package com.rtk.app.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PublicAdapter.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class a3<T> extends BaseAdapter {
    private List<T> a;
    public List<com.rtk.app.tool.DownLoadTool.y> b = new ArrayList();

    public a3(List<T> list) {
        this.a = list;
    }

    public void b() {
        for (int i = 0; i < this.b.size(); i++) {
            if (this.b.get(i) != null) {
                com.rtk.app.tool.DownLoadTool.x.c().m(this.b.get(i));
            }
        }
        this.b.clear();
    }

    public void c(int i, View view, ViewGroup viewGroup) {
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<T> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
