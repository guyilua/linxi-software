package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.rtk.app.R;
import com.rtk.app.adapter.RecommendModuleAndClassifyGridViewAdapter;
import com.rtk.app.base.BaseRecyclerViewAdapter;
import com.rtk.app.bean.DataBean;
import com.rtk.app.bean.HomeAdBean;
import com.rtk.app.bean.RecommendModuleAndClassifyBean;
import com.rtk.app.bean.UpAdBean;
import com.rtk.app.bean.UserRankBean;
import com.rtk.app.main.MainActivityPack.HomePageItem1Pack.BannerHolder;
import com.rtk.app.main.MainActivityPack.HomePageItem1Pack.GameListHolder;
import com.rtk.app.main.MainActivityPack.HomePageItem1Pack.HomeAdImageHolder;
import com.rtk.app.main.MainActivityPack.HomePageItem1Pack.HotViewHolder;
import com.rtk.app.main.MainActivityPack.HomePageItem1Pack.SpeedGameHolder;
import com.rtk.app.main.MainActivityPack.HomePageItem1Pack.TypeModuleHolder;
import com.rtk.app.main.MainActivityPack.HomePageItem1Pack.UserRankViewHolder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomePageItem1Adapter extends BaseRecyclerViewAdapter implements UserRankViewHolder.c {
    private Context e;
    private List<DataBean> f;
    private List<DataBean> g;
    private List<DataBean> h;
    private UpAdBean i;
    private RecommendModuleAndClassifyBean j;
    private UserRankBean k;
    private UserRankBean l;
    private HomeAdBean m;
    private List<com.rtk.app.tool.b0.c> n = new ArrayList();

    public HomePageItem1Adapter(Context context, List<DataBean> list) {
        this.h = list;
        this.e = context;
    }

    @Override // com.rtk.app.main.MainActivityPack.HomePageItem1Pack.UserRankViewHolder.c
    public void d(com.rtk.app.tool.b0.c cVar) {
        this.n.add(cVar);
    }

    public int getItemCount() {
        return this.h.size() + 8;
    }

    public int getItemViewType(int i) {
        if (i == getItemCount() - 1) {
            return 10;
        }
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 7;
            default:
                return 8;
        }
    }

    @Override // com.rtk.app.base.BaseRecyclerViewAdapter
    public void i() {
        super.i();
        com.rtk.app.tool.b0.b.b().d(this.n);
    }

    public void l(HomeAdBean homeAdBean) {
        this.m = homeAdBean;
    }

    public void m(List<DataBean> list) {
        this.f = list;
    }

    public void n(List<DataBean> list) {
        this.g = list;
    }

    public void o(RecommendModuleAndClassifyBean recommendModuleAndClassifyBean) {
        this.j = recommendModuleAndClassifyBean;
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType != 10) {
            switch (itemViewType) {
                case 1:
                    BannerHolder bannerHolder = (BannerHolder) viewHolder;
                    if (this.i == null) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    while (r2 < this.i.getData().size()) {
                        arrayList.add(this.i.getData().get(r2).getDesc());
                        arrayList2.add(this.i.getData().get(r2).getPic());
                        r2++;
                    }
                    bannerHolder.homeUpChoicenessBannerLayoutBanner.w(new com.rtk.app.tool.l());
                    bannerHolder.homeUpChoicenessBannerLayoutBanner.t(arrayList);
                    bannerHolder.homeUpChoicenessBannerLayoutBanner.x(arrayList2);
                    try {
                        bannerHolder.homeUpChoicenessBannerLayoutBanner.B();
                    } catch (Exception unused) {
                    }
                    bannerHolder.c(this.e);
                    bannerHolder.e(this.i);
                    return;
                case 2:
                    RecommendModuleAndClassifyBean recommendModuleAndClassifyBean = this.j;
                    if (recommendModuleAndClassifyBean == null) {
                        return;
                    }
                    ((TypeModuleHolder) viewHolder).c(this.e, recommendModuleAndClassifyBean, RecommendModuleAndClassifyGridViewAdapter.b.HomePage);
                    return;
                case 3:
                    HomeAdBean homeAdBean = this.m;
                    if (homeAdBean == null || homeAdBean.getData() == null) {
                        return;
                    }
                    ((HomeAdImageHolder) viewHolder).b(this.e, this.m, HomeAdImageHolder.b.homePage);
                    return;
                case 4:
                    List<DataBean> list = this.f;
                    if (list == null) {
                        return;
                    }
                    ((HotViewHolder) viewHolder).h(this.e, list);
                    return;
                case 5:
                    if (this.k == null) {
                        return;
                    }
                    UserRankViewHolder userRankViewHolder = (UserRankViewHolder) viewHolder;
                    userRankViewHolder.homePageItem1FragmentUserRankItemTitle.setText("近一天UP达人");
                    userRankViewHolder.h(this.e, this.k.getData(), this);
                    return;
                case 6:
                    if (this.l == null) {
                        return;
                    }
                    UserRankViewHolder userRankViewHolder2 = (UserRankViewHolder) viewHolder;
                    userRankViewHolder2.homePageItem1FragmentUserRankItemTitle.setText("近一周UP达人");
                    userRankViewHolder2.h(this.e, this.l.getData(), this);
                    return;
                case 7:
                    SpeedGameHolder speedGameHolder = (SpeedGameHolder) viewHolder;
                    List<DataBean> list2 = this.g;
                    if (list2 == null) {
                        return;
                    }
                    speedGameHolder.h(this.e, list2);
                    return;
                default:
                    GameListHolder gameListHolder = (GameListHolder) viewHolder;
                    if (this.h.size() == 0) {
                        return;
                    }
                    gameListHolder.e(this.h.get(i - 7));
                    return;
            }
        }
        BaseRecyclerViewAdapter.RecyclerViewFootViewHolder recyclerViewFootViewHolder = (BaseRecyclerViewAdapter.RecyclerViewFootViewHolder) viewHolder;
        Boolean valueOf = Boolean.valueOf(g());
        List<DataBean> list3 = this.h;
        recyclerViewFootViewHolder.f(valueOf, list3 != null ? list3.size() : 0, h(), f());
    }

    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i != 10) {
            switch (i) {
                case 1:
                    return new BannerHolder(LayoutInflater.from(this.e).inflate(R.layout.home_up_choiceness_banner_layout, viewGroup, false), BannerHolder.b.HomeBanner);
                case 2:
                    return new TypeModuleHolder(LayoutInflater.from(this.e).inflate(R.layout.home_page_item1_fragment_type_module_item_layout, viewGroup, false));
                case 3:
                    return new HomeAdImageHolder(LayoutInflater.from(this.e).inflate(R.layout.home_page_item1_fragment_type_ad_image_layout, viewGroup, false));
                case 4:
                    return new HotViewHolder(LayoutInflater.from(this.e).inflate(R.layout.home_page_item1_fragment_hot_item_layout, viewGroup, false));
                case 5:
                case 6:
                    return new UserRankViewHolder(LayoutInflater.from(this.e).inflate(R.layout.home_page_item1_fragment_user_rank_item_layout, viewGroup, false));
                case 7:
                    return new SpeedGameHolder(LayoutInflater.from(this.e).inflate(R.layout.home_page_item1_fragment_speed_game_view_layout, viewGroup, false));
                default:
                    return new GameListHolder(LayoutInflater.from(this.e).inflate(R.layout.game_listview_item_layout, viewGroup, false));
            }
        }
        return new BaseRecyclerViewAdapter.RecyclerViewFootViewHolder(LayoutInflater.from(this.e).inflate(R.layout.looding_footview, viewGroup, false));
    }

    public void p(UpAdBean upAdBean) {
        this.i = upAdBean;
    }

    public void q(UserRankBean userRankBean) {
        this.l = userRankBean;
    }

    public void r(UserRankBean userRankBean) {
        this.k = userRankBean;
    }
}
