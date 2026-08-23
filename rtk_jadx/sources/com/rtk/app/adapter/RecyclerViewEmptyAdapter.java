package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class RecyclerViewEmptyAdapter extends RecyclerView.Adapter {
    private Context a;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private class a extends RecyclerView.ViewHolder {
        public a(RecyclerViewEmptyAdapter recyclerViewEmptyAdapter, View view) {
            super(view);
        }
    }

    public RecyclerViewEmptyAdapter(Context context) {
        this.a = context;
    }

    public int getItemCount() {
        return 1;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this, LayoutInflater.from(this.a).inflate(R.layout.post_details_recyclerview_item_empty_view_layout, viewGroup, false));
    }
}
