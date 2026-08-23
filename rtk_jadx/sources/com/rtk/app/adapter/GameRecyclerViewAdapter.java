package com.rtk.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.adapter.RecommendModuleAndClassifyGridViewAdapter;
import com.rtk.app.base.BaseRecyclerViewAdapter;
import com.rtk.app.bean.DataBean;
import com.rtk.app.bean.RecommendModuleAndClassifyBean;
import com.rtk.app.bean.UpAdBean;
import com.rtk.app.main.Home5Activity.Home5MyUpSrcActivity;
import com.rtk.app.main.MainActivityPack.GameRankListActivity;
import com.rtk.app.main.MainActivityPack.HomePageItem1Pack.BannerHolder;
import com.rtk.app.main.MainActivityPack.HomePageItem1Pack.TypeModuleHolder;
import com.rtk.app.main.UpModule.UpApkListActivity;
import com.rtk.app.tool.ApkInfo;
import com.sigmob.sdk.downloader.f;
import com.zhy.view.flowlayout.TagFlowLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GameRecyclerViewAdapter extends BaseRecyclerViewAdapter {
    private Context e;
    private List<DataBean> f;
    private List<DataBean> g;
    private List<DataBean> h;
    private List<DataBean> i;
    private boolean j = true;
    private RecommendModuleAndClassifyBean k;
    private UpAdBean l;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class FootViewHolder extends RecyclerView.ViewHolder {

        @BindView
        ProgressBar loodingFootviewProgressbar;

        @BindView
        TextView loodingFootviewTv;

        FootViewHolder(GameRecyclerViewAdapter gameRecyclerViewAdapter, View view) {
            super(view);
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class FootViewHolder_ViewBinding implements Unbinder {
        private FootViewHolder b;

        @UiThread
        public FootViewHolder_ViewBinding(FootViewHolder footViewHolder, View view) {
            this.b = footViewHolder;
            footViewHolder.loodingFootviewTv = (TextView) butterknife.c.a.c(view, R.id.looding_footview_tv, "field 'loodingFootviewTv'", TextView.class);
            footViewHolder.loodingFootviewProgressbar = (ProgressBar) butterknife.c.a.c(view, R.id.looding_footview_progressbar, "field 'loodingFootviewProgressbar'", ProgressBar.class);
        }

        @CallSuper
        public void a() {
            FootViewHolder footViewHolder = this.b;
            if (footViewHolder != null) {
                this.b = null;
                footViewHolder.loodingFootviewTv = null;
                footViewHolder.loodingFootviewProgressbar = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class GameListHolder extends RecyclerView.ViewHolder {
        View a;

        @BindView
        TextView gameListViewItemVersion;

        @BindView
        TextView gameListviewItemDownLoad;

        @BindView
        TextView gameListviewItemGameName;

        @BindView
        ImageView gameListviewItemIcon;

        @BindView
        TextView gameListviewItemLanguage;

        @BindView
        ProgressBar gameListviewItemProgressBar;

        @BindView
        ImageView gameListviewItemRang;

        @BindView
        TextView gameListviewItemSize;

        @BindView
        TagFlowLayout gameListviewItemTag;

        @BindView
        TextView gameListviewItemType;

        public GameListHolder(GameRecyclerViewAdapter gameRecyclerViewAdapter, View view) {
            super(view);
            ButterKnife.b(this, view);
            this.a = view;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class GameListHolder_ViewBinding implements Unbinder {
        private GameListHolder b;

        @UiThread
        public GameListHolder_ViewBinding(GameListHolder gameListHolder, View view) {
            this.b = gameListHolder;
            gameListHolder.gameListviewItemIcon = (ImageView) butterknife.c.a.c(view, R.id.game_listview_item_icon, "field 'gameListviewItemIcon'", ImageView.class);
            gameListHolder.gameListviewItemProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.game_listview_item_ProgressBar, "field 'gameListviewItemProgressBar'", ProgressBar.class);
            gameListHolder.gameListviewItemDownLoad = (TextView) butterknife.c.a.c(view, R.id.game_listview_item_downLoad, "field 'gameListviewItemDownLoad'", TextView.class);
            gameListHolder.gameListviewItemGameName = (TextView) butterknife.c.a.c(view, R.id.game_listview_item_GameName, "field 'gameListviewItemGameName'", TextView.class);
            gameListHolder.gameListviewItemRang = (ImageView) butterknife.c.a.c(view, R.id.game_listview_item_rang, "field 'gameListviewItemRang'", ImageView.class);
            gameListHolder.gameListViewItemVersion = (TextView) butterknife.c.a.c(view, R.id.game_listView_item_version, "field 'gameListViewItemVersion'", TextView.class);
            gameListHolder.gameListviewItemTag = (TagFlowLayout) butterknife.c.a.c(view, R.id.game_listview_item_tag, "field 'gameListviewItemTag'", TagFlowLayout.class);
            gameListHolder.gameListviewItemType = (TextView) butterknife.c.a.c(view, R.id.game_listview_item_type, "field 'gameListviewItemType'", TextView.class);
            gameListHolder.gameListviewItemLanguage = (TextView) butterknife.c.a.c(view, R.id.game_listview_item_language, "field 'gameListviewItemLanguage'", TextView.class);
            gameListHolder.gameListviewItemSize = (TextView) butterknife.c.a.c(view, R.id.game_listview_item_size, "field 'gameListviewItemSize'", TextView.class);
        }

        @CallSuper
        public void a() {
            GameListHolder gameListHolder = this.b;
            if (gameListHolder != null) {
                this.b = null;
                gameListHolder.gameListviewItemIcon = null;
                gameListHolder.gameListviewItemProgressBar = null;
                gameListHolder.gameListviewItemDownLoad = null;
                gameListHolder.gameListviewItemGameName = null;
                gameListHolder.gameListviewItemRang = null;
                gameListHolder.gameListViewItemVersion = null;
                gameListHolder.gameListviewItemTag = null;
                gameListHolder.gameListviewItemType = null;
                gameListHolder.gameListviewItemLanguage = null;
                gameListHolder.gameListviewItemSize = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class HeadTitleHolder extends RecyclerView.ViewHolder {

        @BindView
        TextView titleIntro;

        @BindView
        TextView titleMore;

        @BindView
        TextView titleName;

        public HeadTitleHolder(GameRecyclerViewAdapter gameRecyclerViewAdapter, View view) {
            super(view);
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class HeadTitleHolder_ViewBinding implements Unbinder {
        private HeadTitleHolder b;

        @UiThread
        public HeadTitleHolder_ViewBinding(HeadTitleHolder headTitleHolder, View view) {
            this.b = headTitleHolder;
            headTitleHolder.titleName = (TextView) butterknife.c.a.c(view, R.id.home1_item1_title_name, "field 'titleName'", TextView.class);
            headTitleHolder.titleIntro = (TextView) butterknife.c.a.c(view, R.id.home1_item1_title_intro, "field 'titleIntro'", TextView.class);
            headTitleHolder.titleMore = (TextView) butterknife.c.a.c(view, R.id.home1_item1_title_more, "field 'titleMore'", TextView.class);
        }

        @CallSuper
        public void a() {
            HeadTitleHolder headTitleHolder = this.b;
            if (headTitleHolder != null) {
                this.b = null;
                headTitleHolder.titleName = null;
                headTitleHolder.titleIntro = null;
                headTitleHolder.titleMore = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements View.OnClickListener {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.rtk.app.tool.t.e0(GameRecyclerViewAdapter.this.e, new ApkInfo((DataBean) GameRecyclerViewAdapter.this.f.get(this.a)));
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b extends RecyclerView.ViewHolder {
        LinearLayout a;

        public b(GameRecyclerViewAdapter gameRecyclerViewAdapter, View view) {
            super(view);
            ButterKnife.b(this, view);
            this.a = (LinearLayout) view;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private class c implements View.OnClickListener, AdapterView.OnItemClickListener {
        private int a;
        private int b;

        public c(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                com.rtk.app.tool.c0.u("GameRecyclerViewAdapter", "下载按钮");
                com.rtk.app.tool.DownLoadTool.r.g(GameRecyclerViewAdapter.this.e, new ApkInfo((DataBean) GameRecyclerViewAdapter.this.getItem(this.b)), (TextView) view);
                return;
            }
            if (i == 1) {
                com.rtk.app.tool.c.b((Activity) GameRecyclerViewAdapter.this.e, UpApkListActivity.class, null);
                return;
            }
            if (i == 2) {
                if (!com.rtk.app.tool.y.x(GameRecyclerViewAdapter.this.e) || com.rtk.app.tool.c0.q(com.rtk.app.tool.y.H())) {
                    com.rtk.app.tool.f.a(GameRecyclerViewAdapter.this.e, "请先登录", f.a.f);
                    com.rtk.app.tool.t.w0(GameRecyclerViewAdapter.this.e);
                    return;
                } else {
                    com.rtk.app.tool.c.b((Activity) GameRecyclerViewAdapter.this.e, Home5MyUpSrcActivity.class, null);
                    return;
                }
            }
            if (i == 4) {
                com.rtk.app.tool.f.a(GameRecyclerViewAdapter.this.e, "up类", f.a.f);
                return;
            }
            if (i == 5) {
                com.rtk.app.tool.t.t0(GameRecyclerViewAdapter.this.e);
                return;
            }
            if (i == 6) {
                com.rtk.app.tool.c.b((Activity) GameRecyclerViewAdapter.this.e, GameRankListActivity.class, null);
                return;
            }
            if (i == 100) {
                com.rtk.app.tool.t.T0(GameRecyclerViewAdapter.this.e, "全部游戏", new HashMap());
                return;
            }
            if (i == 102) {
                com.rtk.app.tool.t.e0(GameRecyclerViewAdapter.this.e, new ApkInfo((DataBean) GameRecyclerViewAdapter.this.getItem(this.b)));
                return;
            }
            if (i != 104) {
                return;
            }
            com.rtk.app.tool.t.i0(GameRecyclerViewAdapter.this.e, com.rtk.app.tool.y.o.getData().get(0).getAd_id() + "");
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.a != 101) {
                return;
            }
            com.rtk.app.tool.t.e0(GameRecyclerViewAdapter.this.e, new ApkInfo((DataBean) GameRecyclerViewAdapter.this.f.get(i)));
        }
    }

    public GameRecyclerViewAdapter(Context context, List<DataBean> list, List<DataBean> list2, List<DataBean> list3, List<DataBean> list4) {
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.e = context;
        this.f = list;
        this.g = list2;
        this.h = list3;
        this.i = list4;
    }

    public Object getItem(int i) {
        HashMap hashMap = new HashMap();
        if (i == 0) {
            return this.l;
        }
        if (i == 15) {
            hashMap.put("title", "加速游戏");
            hashMap.put("intro", "效率成倍提升");
            hashMap.put(com.umeng.analytics.pro.d.y, "newest");
            return hashMap;
        }
        if (i == 26) {
            hashMap.put("title", "精品游戏");
            hashMap.put("intro", "精选好玩游戏");
            return hashMap;
        }
        if (i == 2) {
            hashMap.put("title", "热门推荐");
            hashMap.put("intro", "大家都喜欢的");
            hashMap.put(com.umeng.analytics.pro.d.y, "hot");
            return hashMap;
        }
        if (i == 3) {
            return this.f;
        }
        if (i != 4) {
            if (i == getItemCount() - 1) {
                return 0;
            }
            if (i >= 5 && i < 15) {
                return this.h.get(i - 5);
            }
            if (i >= 16 && i < 26) {
                return this.g.get(i - 16);
            }
            if (i < 27 || i >= getItemCount()) {
                return null;
            }
            return this.i.get(i - 27);
        }
        hashMap.put("title", "新品速递");
        hashMap.put("intro", "新游抢先体验");
        hashMap.put(com.umeng.analytics.pro.d.y, "newest");
        return hashMap;
    }

    public int getItemCount() {
        return this.g.size() + 8 + this.h.size() + this.i.size();
    }

    public int getItemViewType(int i) {
        this.f.size();
        if (i == 0) {
            return 98;
        }
        if (i == 1) {
            return 99;
        }
        if (i != 2) {
            if (i == 3) {
                return 101;
            }
            if (i != 4 && i != 15 && i != 26) {
                return i == getItemCount() - 1 ? 103 : 102;
            }
        }
        return 100;
    }

    public void n(boolean z) {
        this.j = z;
    }

    public void o(RecommendModuleAndClassifyBean recommendModuleAndClassifyBean) {
        this.k = recommendModuleAndClassifyBean;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        try {
            switch (getItemViewType(i)) {
                case 98:
                    BannerHolder bannerHolder = (BannerHolder) viewHolder;
                    if (this.l == null) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    for (int i2 = 0; i2 < this.l.getData().size(); i2++) {
                        arrayList.add(this.l.getData().get(i2).getDesc());
                        arrayList2.add(this.l.getData().get(i2).getPic());
                        arrayList3.add(new com.rtk.app.main.MainActivityPack.HomePageItem1Pack.c(this.l.getData().get(i2).getPic(), this.l.getData().get(i2).getDesc(), 1));
                    }
                    bannerHolder.homeUpChoicenessBannerLayoutBanner.w(new com.rtk.app.tool.l());
                    bannerHolder.homeUpChoicenessBannerLayoutBanner.t(arrayList);
                    bannerHolder.homeUpChoicenessBannerLayoutBanner.x(arrayList2);
                    bannerHolder.homeUpChoicenessBannerLayoutBanner.B();
                    bannerHolder.c(this.e);
                    bannerHolder.e(this.l);
                    return;
                case 99:
                    RecommendModuleAndClassifyBean recommendModuleAndClassifyBean = this.k;
                    if (recommendModuleAndClassifyBean == null) {
                        return;
                    }
                    ((TypeModuleHolder) viewHolder).c(this.e, recommendModuleAndClassifyBean, RecommendModuleAndClassifyGridViewAdapter.b.GamePage);
                    return;
                case 100:
                    Map map = (Map) getItem(i);
                    ((HeadTitleHolder) viewHolder).titleName.setText((CharSequence) map.get("title"));
                    ((HeadTitleHolder) viewHolder).titleIntro.setText((CharSequence) map.get("intro"));
                    ((HeadTitleHolder) viewHolder).titleMore.setOnClickListener(new c(100, i));
                    return;
                case 101:
                    if (this.f == null) {
                        return;
                    }
                    ((b) viewHolder).a.removeAllViews();
                    for (int i3 = 0; i3 < this.f.size(); i3++) {
                        View inflate = LayoutInflater.from(this.e).inflate(R.layout.home1_item1_game_gridview_item_layout, (ViewGroup) null);
                        new Home1Item1GameGridViewAdapter$GameGridViewHolder(inflate).a(this.e, this.f.get(i3));
                        inflate.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
                        ((b) viewHolder).a.addView(inflate);
                        inflate.setOnClickListener(new a(i3));
                    }
                    return;
                case 102:
                    GameListHolder gameListHolder = (GameListHolder) viewHolder;
                    gameListHolder.a.setOnClickListener(new c(102, i));
                    com.rtk.app.tool.t.d(this.e, ((DataBean) getItem(i)).getGame_logo(), gameListHolder.gameListviewItemIcon);
                    gameListHolder.gameListviewItemGameName.setText(((DataBean) getItem(i)).getGame_name());
                    gameListHolder.gameListviewItemLanguage.setText(((DataBean) getItem(i)).getLangues());
                    gameListHolder.gameListviewItemTag.setAdapter(new d3(((DataBean) getItem(i)).getTag_name(), this.e));
                    gameListHolder.gameListviewItemType.setText(((DataBean) getItem(i)).getGame_type());
                    gameListHolder.gameListviewItemSize.setText(((DataBean) getItem(i)).getPackage_size());
                    gameListHolder.gameListViewItemVersion.setText("V" + ((DataBean) getItem(i)).getGame_version());
                    com.rtk.app.tool.t.R1(((DataBean) getItem(i)).getGame_level(), gameListHolder.gameListviewItemRang);
                    gameListHolder.gameListviewItemDownLoad.setTag(Integer.valueOf(((DataBean) getItem(i)).getGame_id()));
                    gameListHolder.gameListviewItemDownLoad.setOnClickListener(new c(0, i));
                    com.rtk.app.tool.DownLoadTool.x.c().a(new com.rtk.app.tool.DownLoadTool.u(gameListHolder.gameListviewItemProgressBar, ((DataBean) getItem(i)).getGame_id(), gameListHolder.gameListviewItemDownLoad));
                    com.rtk.app.tool.DownLoadTool.r.h(this.e, new ApkInfo((DataBean) getItem(i)), gameListHolder.gameListviewItemDownLoad, gameListHolder.gameListviewItemProgressBar);
                    return;
                case 103:
                    FootViewHolder footViewHolder = (FootViewHolder) viewHolder;
                    if (this.j) {
                        footViewHolder.loodingFootviewTv.setText("加载中...");
                        footViewHolder.loodingFootviewProgressbar.setVisibility(0);
                        return;
                    } else {
                        footViewHolder.loodingFootviewTv.setText("亲，我是有底的~");
                        footViewHolder.loodingFootviewProgressbar.setVisibility(8);
                        return;
                    }
                default:
                    return;
            }
        } catch (Exception unused) {
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (i) {
            case 98:
                return new BannerHolder(LayoutInflater.from(this.e).inflate(R.layout.home_up_choiceness_banner_layout, viewGroup, false), BannerHolder.b.GameBanner);
            case 99:
                return new TypeModuleHolder(LayoutInflater.from(this.e).inflate(R.layout.home_page_item1_fragment_type_module_item_layout, viewGroup, false));
            case 100:
                return new HeadTitleHolder(this, LayoutInflater.from(this.e).inflate(R.layout.home1_item1_title_layout, viewGroup, false));
            case 101:
                return new b(this, LayoutInflater.from(this.e).inflate(R.layout.home1_item1_hot_game_view_layout, viewGroup, false));
            case 102:
                return new GameListHolder(this, LayoutInflater.from(this.e).inflate(R.layout.game_listview_item_layout, viewGroup, false));
            case 103:
                return new FootViewHolder(this, LayoutInflater.from(this.e).inflate(R.layout.looding_footview, viewGroup, false));
            default:
                return null;
        }
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        com.rtk.app.tool.t.C1(this.e);
    }

    public void p(UpAdBean upAdBean) {
        this.l = upAdBean;
    }
}
