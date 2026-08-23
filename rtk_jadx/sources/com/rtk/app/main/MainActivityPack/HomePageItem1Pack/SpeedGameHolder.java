package com.rtk.app.main.MainActivityPack.HomePageItem1Pack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.adapter.Home1Item1GameGridViewAdapter$GameGridViewHolder;
import com.rtk.app.bean.DataBean;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.t;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SpeedGameHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public View a;
    private List<DataBean> b;

    /* renamed from: c, reason: collision with root package name */
    private Context f205c;

    @BindView
    public TextView homePageItem1FragmentBoutiqueViewItemMore;

    @BindView
    public LinearLayout homePageItem1FragmentSpeedGameViewGameLv;

    @BindView
    public TextView homePageItem1FragmentSpeedGameViewItemMore;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements View.OnClickListener {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t.e0(SpeedGameHolder.this.f205c, new ApkInfo((DataBean) SpeedGameHolder.this.b.get(this.a)));
        }
    }

    public SpeedGameHolder(@NonNull View view) {
        super(view);
        ButterKnife.b(this, view);
        this.a = view;
        e();
    }

    private void e() {
        this.homePageItem1FragmentSpeedGameViewItemMore.setOnClickListener(this);
        this.homePageItem1FragmentBoutiqueViewItemMore.setOnClickListener(this);
    }

    private void f() {
        this.homePageItem1FragmentSpeedGameViewGameLv.removeAllViews();
        c0.u("SpeedGameHolder", "速度尺寸   " + this.b.size());
        for (int i = 0; i < this.b.size(); i++) {
            View inflate = LayoutInflater.from(this.f205c).inflate(R.layout.home1_item1_game_gridview_item_layout, (ViewGroup) null);
            new Home1Item1GameGridViewAdapter$GameGridViewHolder(inflate).a(this.f205c, this.b.get(i));
            inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -2, 1.0f));
            if (i >= 4) {
                return;
            }
            this.homePageItem1FragmentSpeedGameViewGameLv.addView(inflate);
            inflate.setOnClickListener(new a(i));
        }
    }

    public void h(Context context, List<DataBean> list) {
        this.f205c = context;
        this.b = list;
        f();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131298064 || id == 2131298070) {
            t.T0(this.f205c, "全部游戏", new HashMap());
        }
    }
}
