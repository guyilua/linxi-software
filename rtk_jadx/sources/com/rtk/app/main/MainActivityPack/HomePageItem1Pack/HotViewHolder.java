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
import com.rtk.app.tool.t;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HotViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private List<DataBean> a;
    private Context b;

    @BindView
    public LinearLayout homePageItem1FragmentHotItem14;

    @BindView
    public LinearLayout homePageItem1FragmentHotItem58;

    @BindView
    public TextView homePageItem1FragmentHotItemMore;

    @BindView
    public TextView homePageItem1FragmentHotItemTitle;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements View.OnClickListener {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t.e0(HotViewHolder.this.b, new ApkInfo((DataBean) HotViewHolder.this.a.get(this.a)));
        }
    }

    public HotViewHolder(@NonNull View view) {
        super(view);
        ButterKnife.b(this, view);
    }

    private void e() {
        this.homePageItem1FragmentHotItemMore.setOnClickListener(this);
    }

    private void f() {
        this.homePageItem1FragmentHotItem14.removeAllViews();
        this.homePageItem1FragmentHotItem58.removeAllViews();
        for (int i = 0; i < this.a.size(); i++) {
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.home1_item1_game_gridview_item_layout, (ViewGroup) null);
            new Home1Item1GameGridViewAdapter$GameGridViewHolder(inflate).a(this.b, this.a.get(i));
            inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -2, 1.0f));
            if (i < 4) {
                this.homePageItem1FragmentHotItem14.addView(inflate);
            } else if (i < 8) {
                this.homePageItem1FragmentHotItem58.addView(inflate);
            }
            inflate.setOnClickListener(new a(i));
        }
    }

    public void h(Context context, List<DataBean> list) {
        this.a = list;
        this.b = context;
        f();
        e();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131298067) {
            return;
        }
        t.T0(this.b, "全部游戏", new HashMap());
    }
}
