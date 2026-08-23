package com.rtk.app.main.MainActivityPack.HomePageItem1Pack;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.adapter.RecommendModuleAndClassifyGridViewAdapter;
import com.rtk.app.bean.RecommendModuleAndClassifyBean;
import com.rtk.app.custom.GridViewForScrollView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TypeModuleHolder extends RecyclerView.ViewHolder {
    private RecommendModuleAndClassifyBean a;
    private Context b;

    /* renamed from: c, reason: collision with root package name */
    RecommendModuleAndClassifyGridViewAdapter.b f206c;

    @BindView
    public GridViewForScrollView homePageItem1FragmentTypeModuleItemGridView;

    public TypeModuleHolder(View view) {
        super(view);
        ButterKnife.b(this, view);
    }

    private void b() {
        this.homePageItem1FragmentTypeModuleItemGridView.setAdapter((ListAdapter) new RecommendModuleAndClassifyGridViewAdapter(this.b, this.a.getData(), this.f206c));
    }

    public void c(Context context, RecommendModuleAndClassifyBean recommendModuleAndClassifyBean, RecommendModuleAndClassifyGridViewAdapter.b bVar) {
        this.a = recommendModuleAndClassifyBean;
        this.b = context;
        this.f206c = bVar;
        b();
    }
}
