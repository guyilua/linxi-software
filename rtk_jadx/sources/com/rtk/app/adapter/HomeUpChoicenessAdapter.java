package com.rtk.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.base.BaseRecyclerViewAdapter;
import com.rtk.app.bean.UpAdBean;
import com.rtk.app.bean.UpApkListBean;
import com.rtk.app.bean.UserRankBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.main.Home5Activity.Home5MyUpSrcActivity;
import com.rtk.app.main.MainActivityPack.HomePageItem1Pack.BannerHolder;
import com.rtk.app.main.MainActivityPack.HomePageItem1Pack.UpUserTypeHolder;
import com.rtk.app.main.MainActivityPack.HomePageItem1Pack.UserRankViewHolder;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.MainActivityPack.UpChoicenessPack.HomeUpChoicenessForExpertActivity;
import com.rtk.app.main.MainActivityPack.UpChoicenessPack.HomeUpExampleListActivity;
import com.rtk.app.main.MainActivityPack.UpChoicenessPack.HomeUpMyAttentionActivity;
import com.rtk.app.main.MainActivityPack.UpChoicenessPack.HomeUpRewardActivity;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.tool.ApkInfo;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeUpChoicenessAdapter extends BaseRecyclerViewAdapter implements UserRankViewHolder.c, com.rtk.app.main.MainActivityPack.HomePageItem1Pack.d {
    private DialogForProgressTip e;
    private Context f;
    private UpAdBean g;
    private UserRankBean h;
    private UserRankBean i;
    private List<UpApkListBean.DataBean> j;
    private List<com.rtk.app.tool.b0.c> k = new ArrayList();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    protected class HomeUpChoicenessClickListener implements View.OnClickListener, ViewPager.OnPageChangeListener {
        private int a;
        private RecyclerView.ViewHolder b;

        public HomeUpChoicenessClickListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.home_up_choiceness_small_type_classify /* 2131298097 */:
                    com.rtk.app.tool.t.u0(HomeUpChoicenessAdapter.this.f);
                    return;
                case R.id.home_up_choiceness_small_type_expert /* 2131298098 */:
                case R.id.home_up_user_type_recommend_more /* 2131298165 */:
                    com.rtk.app.tool.c.b((Activity) HomeUpChoicenessAdapter.this.f, HomeUpChoicenessForExpertActivity.class, null);
                    return;
                case R.id.home_up_choiceness_small_type_help /* 2131298099 */:
                    if (com.rtk.app.tool.y.x(HomeUpChoicenessAdapter.this.f)) {
                        ((MainActivity) HomeUpChoicenessAdapter.this.f).z();
                        com.rtk.app.tool.c.b((Activity) HomeUpChoicenessAdapter.this.f, HomeUpMyAttentionActivity.class, null);
                        return;
                    } else {
                        com.rtk.app.tool.t.w0(HomeUpChoicenessAdapter.this.f);
                        return;
                    }
                case R.id.home_up_choiceness_small_type_newest /* 2131298102 */:
                    com.rtk.app.tool.t.v0(HomeUpChoicenessAdapter.this.f, null, null, "最新");
                    return;
                case R.id.home_up_choiceness_small_type_rank_list /* 2131298103 */:
                case R.id.home_up_user_type_recommend_up_src_more /* 2131298168 */:
                    com.rtk.app.tool.c.b((Activity) HomeUpChoicenessAdapter.this.f, HomeUpExampleListActivity.class, null);
                    return;
                case R.id.home_up_choiceness_small_type_reward_list /* 2131298104 */:
                    com.rtk.app.tool.c.b((Activity) HomeUpChoicenessAdapter.this.f, HomeUpRewardActivity.class, null);
                    return;
                case R.id.home_up_choiceness_small_type_up_me /* 2131298105 */:
                    if (com.rtk.app.tool.y.x(HomeUpChoicenessAdapter.this.f)) {
                        com.rtk.app.tool.c.b((Activity) HomeUpChoicenessAdapter.this.f, Home5MyUpSrcActivity.class, null);
                        return;
                    } else {
                        com.rtk.app.tool.t.w0(HomeUpChoicenessAdapter.this.f);
                        return;
                    }
                case R.id.home_up_user_type_recommend_nobody_lv /* 2131298167 */:
                    com.rtk.app.tool.t.e2(HomeUpChoicenessAdapter.this.f, view);
                    return;
                default:
                    return;
            }
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            try {
                ((BannerHolder) this.b).homeUpChoicenessBannerLayoutBannerTitle.setText(HomeUpChoicenessAdapter.this.g.getData().get(this.a).getDesc());
            } catch (Exception e) {
                com.rtk.app.tool.c0.u("HomeUpChoicenessAdapter", "banner异常" + e.toString());
            }
        }

        public HomeUpChoicenessClickListener(RecyclerView.ViewHolder viewHolder) {
            this.b = viewHolder;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class SmallTypeHolder extends RecyclerView.ViewHolder {
        View a;

        @BindView
        TextView homeUpChoicenessSmallTypeClassify;

        @BindView
        TextView homeUpChoicenessSmallTypeExpert;

        @BindView
        TextView homeUpChoicenessSmallTypeIconName;

        @BindView
        LinearLayout homeUpChoicenessSmallTypeItemView;

        @BindView
        TextView homeUpChoicenessSmallTypeMyAttemtion;

        @BindView
        TextView homeUpChoicenessSmallTypeNewest;

        @BindView
        TextView homeUpChoicenessSmallTypeRankList;

        @BindView
        TextView homeUpChoicenessSmallTypeRewardList;

        @BindView
        TextView homeUpChoicenessSmallTypeUpMe;

        public SmallTypeHolder(@NonNull View view) {
            super(view);
            ButterKnife.b(this, view);
            this.a = view;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class SmallTypeHolder_ViewBinding implements Unbinder {
        private SmallTypeHolder b;

        @UiThread
        public SmallTypeHolder_ViewBinding(SmallTypeHolder smallTypeHolder, View view) {
            this.b = smallTypeHolder;
            smallTypeHolder.homeUpChoicenessSmallTypeNewest = (TextView) butterknife.c.a.c(view, R.id.home_up_choiceness_small_type_newest, "field 'homeUpChoicenessSmallTypeNewest'", TextView.class);
            smallTypeHolder.homeUpChoicenessSmallTypeClassify = (TextView) butterknife.c.a.c(view, R.id.home_up_choiceness_small_type_classify, "field 'homeUpChoicenessSmallTypeClassify'", TextView.class);
            smallTypeHolder.homeUpChoicenessSmallTypeRankList = (TextView) butterknife.c.a.c(view, R.id.home_up_choiceness_small_type_rank_list, "field 'homeUpChoicenessSmallTypeRankList'", TextView.class);
            smallTypeHolder.homeUpChoicenessSmallTypeRewardList = (TextView) butterknife.c.a.c(view, R.id.home_up_choiceness_small_type_reward_list, "field 'homeUpChoicenessSmallTypeRewardList'", TextView.class);
            smallTypeHolder.homeUpChoicenessSmallTypeExpert = (TextView) butterknife.c.a.c(view, R.id.home_up_choiceness_small_type_expert, "field 'homeUpChoicenessSmallTypeExpert'", TextView.class);
            smallTypeHolder.homeUpChoicenessSmallTypeUpMe = (TextView) butterknife.c.a.c(view, R.id.home_up_choiceness_small_type_up_me, "field 'homeUpChoicenessSmallTypeUpMe'", TextView.class);
            smallTypeHolder.homeUpChoicenessSmallTypeMyAttemtion = (TextView) butterknife.c.a.c(view, R.id.home_up_choiceness_small_type_help, "field 'homeUpChoicenessSmallTypeMyAttemtion'", TextView.class);
            smallTypeHolder.homeUpChoicenessSmallTypeIconName = (TextView) butterknife.c.a.c(view, R.id.home_up_choiceness_small_type_iconNum, "field 'homeUpChoicenessSmallTypeIconName'", TextView.class);
            smallTypeHolder.homeUpChoicenessSmallTypeItemView = (LinearLayout) butterknife.c.a.c(view, R.id.home_up_choiceness_small_type_item_view, "field 'homeUpChoicenessSmallTypeItemView'", LinearLayout.class);
        }

        @CallSuper
        public void a() {
            SmallTypeHolder smallTypeHolder = this.b;
            if (smallTypeHolder != null) {
                this.b = null;
                smallTypeHolder.homeUpChoicenessSmallTypeNewest = null;
                smallTypeHolder.homeUpChoicenessSmallTypeClassify = null;
                smallTypeHolder.homeUpChoicenessSmallTypeRankList = null;
                smallTypeHolder.homeUpChoicenessSmallTypeRewardList = null;
                smallTypeHolder.homeUpChoicenessSmallTypeExpert = null;
                smallTypeHolder.homeUpChoicenessSmallTypeUpMe = null;
                smallTypeHolder.homeUpChoicenessSmallTypeMyAttemtion = null;
                smallTypeHolder.homeUpChoicenessSmallTypeIconName = null;
                smallTypeHolder.homeUpChoicenessSmallTypeItemView = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ToDayRecommendHolder extends RecyclerView.ViewHolder {
        View a;

        @BindView
        TextView upApkListItemDownload;

        @BindView
        TextView upApkListItemGameName;

        @BindView
        CustomTextView upApkListItemGameTime;

        @BindView
        CustomTextView upApkListItemGameVersionAndSize;

        @BindView
        RoundedImageView upApkListItemIcon;

        @BindView
        ProgressBar upApkListItemProgressBar;

        public ToDayRecommendHolder(@NonNull View view) {
            super(view);
            ButterKnife.b(this, view);
            this.a = view;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ToDayRecommendHolder_ViewBinding implements Unbinder {
        private ToDayRecommendHolder b;

        @UiThread
        public ToDayRecommendHolder_ViewBinding(ToDayRecommendHolder toDayRecommendHolder, View view) {
            this.b = toDayRecommendHolder;
            toDayRecommendHolder.upApkListItemIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.up_apk_list_item_icon, "field 'upApkListItemIcon'", RoundedImageView.class);
            toDayRecommendHolder.upApkListItemGameName = (TextView) butterknife.c.a.c(view, R.id.up_apk_list_item_gameName, "field 'upApkListItemGameName'", TextView.class);
            toDayRecommendHolder.upApkListItemGameVersionAndSize = (CustomTextView) butterknife.c.a.c(view, R.id.up_apk_list_item_gameVersionAndSize, "field 'upApkListItemGameVersionAndSize'", CustomTextView.class);
            toDayRecommendHolder.upApkListItemGameTime = (CustomTextView) butterknife.c.a.c(view, R.id.up_apk_list_item_gameTime, "field 'upApkListItemGameTime'", CustomTextView.class);
            toDayRecommendHolder.upApkListItemProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.up_apk_list_item_progressBar, "field 'upApkListItemProgressBar'", ProgressBar.class);
            toDayRecommendHolder.upApkListItemDownload = (TextView) butterknife.c.a.c(view, R.id.up_apk_list_item_download, "field 'upApkListItemDownload'", TextView.class);
        }

        @CallSuper
        public void a() {
            ToDayRecommendHolder toDayRecommendHolder = this.b;
            if (toDayRecommendHolder != null) {
                this.b = null;
                toDayRecommendHolder.upApkListItemIcon = null;
                toDayRecommendHolder.upApkListItemGameName = null;
                toDayRecommendHolder.upApkListItemGameVersionAndSize = null;
                toDayRecommendHolder.upApkListItemGameTime = null;
                toDayRecommendHolder.upApkListItemProgressBar = null;
                toDayRecommendHolder.upApkListItemDownload = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public HomeUpChoicenessAdapter(Context context, List<UpApkListBean.DataBean> list) {
        this.f = context;
        this.j = list;
        try {
            DialogForProgressTip dialogForProgressTip = new DialogForProgressTip(MyApplication.b(), "请稍后...");
            this.e = dialogForProgressTip;
            dialogForProgressTip.setCancelable(false);
        } catch (Exception e) {
            MobclickAgent.reportError(context, "自定义异常0001  " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(ApkInfo apkInfo, View view) {
        com.rtk.app.tool.i.i.o(this.f, apkInfo, (TextView) view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(ApkInfo apkInfo, View view) {
        com.rtk.app.tool.t.X0(this.f, apkInfo);
    }

    @Override // com.rtk.app.main.MainActivityPack.HomePageItem1Pack.d
    public void a() {
        this.e.dismiss();
    }

    @Override // com.rtk.app.main.MainActivityPack.HomePageItem1Pack.d
    public void b() {
        this.e.show();
    }

    @Override // com.rtk.app.main.MainActivityPack.HomePageItem1Pack.d
    public void c(com.rtk.app.tool.b0.a aVar) {
        this.k.add(aVar);
    }

    @Override // com.rtk.app.main.MainActivityPack.HomePageItem1Pack.UserRankViewHolder.c
    public void d(com.rtk.app.tool.b0.c cVar) {
        this.k.add(cVar);
    }

    @Override // com.rtk.app.main.MainActivityPack.HomePageItem1Pack.d
    public void e() {
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.j.size() + 3 + 2;
    }

    public int getItemViewType(int i) {
        if (i == getItemCount() - 1) {
            return 5;
        }
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        if (i != 2) {
            return i != 3 ? 4 : 3;
        }
        return 2;
    }

    @Override // com.rtk.app.base.BaseRecyclerViewAdapter
    public void i() {
        super.i();
        com.rtk.app.tool.b0.b.b().d(this.k);
        this.k.clear();
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int i2;
        String str;
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            BannerHolder bannerHolder = (BannerHolder) viewHolder;
            if (this.g == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (r1 < this.g.getData().size()) {
                arrayList.add(this.g.getData().get(r1).getDesc());
                arrayList2.add(this.g.getData().get(r1).getPic());
                r1++;
            }
            bannerHolder.homeUpChoicenessBannerLayoutBanner.w(new com.rtk.app.tool.l());
            bannerHolder.homeUpChoicenessBannerLayoutBanner.t(arrayList);
            bannerHolder.homeUpChoicenessBannerLayoutBanner.x(arrayList2);
            bannerHolder.homeUpChoicenessBannerLayoutBanner.B();
            bannerHolder.homeUpChoicenessBannerLayoutBanner.setOnPageChangeListener(new HomeUpChoicenessClickListener(bannerHolder));
            bannerHolder.c(this.f);
            bannerHolder.e(this.g);
            return;
        }
        if (itemViewType == 1) {
            SmallTypeHolder smallTypeHolder = (SmallTypeHolder) viewHolder;
            try {
                i2 = ((MainActivity) this.f).v();
            } catch (Exception unused) {
                i2 = 0;
            }
            smallTypeHolder.homeUpChoicenessSmallTypeIconName.setVisibility(i2 <= 0 ? 8 : 0);
            TextView textView = smallTypeHolder.homeUpChoicenessSmallTypeIconName;
            if (i2 > 99) {
                str = "99+";
            } else {
                str = i2 + "";
            }
            textView.setText(str);
            smallTypeHolder.homeUpChoicenessSmallTypeNewest.setOnClickListener(new HomeUpChoicenessClickListener());
            smallTypeHolder.homeUpChoicenessSmallTypeClassify.setOnClickListener(new HomeUpChoicenessClickListener());
            smallTypeHolder.homeUpChoicenessSmallTypeRankList.setOnClickListener(new HomeUpChoicenessClickListener());
            smallTypeHolder.homeUpChoicenessSmallTypeRewardList.setOnClickListener(new HomeUpChoicenessClickListener());
            smallTypeHolder.homeUpChoicenessSmallTypeExpert.setOnClickListener(new HomeUpChoicenessClickListener());
            smallTypeHolder.homeUpChoicenessSmallTypeUpMe.setOnClickListener(new HomeUpChoicenessClickListener());
            smallTypeHolder.homeUpChoicenessSmallTypeMyAttemtion.setOnClickListener(new HomeUpChoicenessClickListener());
            return;
        }
        if (itemViewType == 2) {
            if (this.h == null) {
                return;
            }
            UserRankViewHolder userRankViewHolder = (UserRankViewHolder) viewHolder;
            userRankViewHolder.homePageItem1FragmentUserRankItemTitle.setText("近一天UP达人");
            userRankViewHolder.h(this.f, this.h.getData(), this);
            return;
        }
        if (itemViewType == 3) {
            com.rtk.app.tool.c0.u("HomeUpChoicenessAdapter", "UpUserOneMonth");
            UpUserTypeHolder upUserTypeHolder = (UpUserTypeHolder) viewHolder;
            UserRankBean userRankBean = this.i;
            if (userRankBean == null) {
                com.rtk.app.tool.c0.u("HomeUpChoicenessAdapter", "userMonthRankBean is null");
                return;
            }
            upUserTypeHolder.f(userRankBean, this.f, this);
            upUserTypeHolder.homeUpUserTypeRecommendMore.setOnClickListener(new HomeUpChoicenessClickListener());
            com.rtk.app.tool.c0.u("HomeUpChoicenessAdapter", "userMonthRankBean not null");
            if (this.i.getData() != null && this.i.getData().size() != 0) {
                upUserTypeHolder.homeUpUserTypeRecommendNoBodyLv.setVisibility(8);
                upUserTypeHolder.homeUpUserTypeRecommend14Layout.setVisibility(0);
                return;
            } else {
                upUserTypeHolder.homeUpUserTypeRecommendNoBodyLv.setVisibility(0);
                upUserTypeHolder.homeUpUserTypeRecommendNoBodyLv.setOnClickListener(new HomeUpChoicenessClickListener());
                upUserTypeHolder.homeUpUserTypeRecommend14Layout.setVisibility(8);
                return;
            }
        }
        if (itemViewType != 5) {
            ToDayRecommendHolder toDayRecommendHolder = (ToDayRecommendHolder) viewHolder;
            com.rtk.app.tool.c0.u("HomeUpChoicenessAdapter", "listUpApkBean size " + this.j.size());
            UpApkListBean.DataBean dataBean = this.j.get(i + (-4));
            toDayRecommendHolder.upApkListItemGameTime.setText(dataBean.getAddtime());
            toDayRecommendHolder.upApkListItemGameName.setText(dataBean.getVarName());
            toDayRecommendHolder.upApkListItemGameVersionAndSize.setText(dataBean.getVersionName() + "  |  " + dataBean.getSourceSize());
            com.rtk.app.tool.t.c(this.f, dataBean.getSourceLogo(), toDayRecommendHolder.upApkListItemIcon, new boolean[0]);
            final ApkInfo apkInfo = new ApkInfo(dataBean);
            apkInfo.setNeedCoin(dataBean.getNeedCoin());
            toDayRecommendHolder.upApkListItemDownload.setTag(Integer.valueOf(apkInfo.getGameId()));
            com.rtk.app.tool.DownLoadTool.u uVar = new com.rtk.app.tool.DownLoadTool.u(toDayRecommendHolder.upApkListItemProgressBar, apkInfo.getGameId(), toDayRecommendHolder.upApkListItemDownload);
            this.b.add(uVar);
            com.rtk.app.tool.DownLoadTool.x.c().a(uVar);
            com.rtk.app.tool.i.i.p(this.f, apkInfo, toDayRecommendHolder.upApkListItemDownload, toDayRecommendHolder.upApkListItemProgressBar);
            toDayRecommendHolder.upApkListItemDownload.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.d1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeUpChoicenessAdapter.this.o(apkInfo, view);
                }
            });
            toDayRecommendHolder.a.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.e1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeUpChoicenessAdapter.this.q(apkInfo, view);
                }
            });
            return;
        }
        BaseRecyclerViewAdapter.RecyclerViewFootViewHolder recyclerViewFootViewHolder = (BaseRecyclerViewAdapter.RecyclerViewFootViewHolder) viewHolder;
        Boolean valueOf = Boolean.valueOf(g());
        List<UpApkListBean.DataBean> list = this.j;
        recyclerViewFootViewHolder.f(valueOf, list != null ? list.size() : 0, h(), f());
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new BannerHolder(LayoutInflater.from(this.f).inflate(R.layout.home_up_choiceness_banner_layout, viewGroup, false), BannerHolder.b.UpBanner);
        }
        if (i == 1) {
            return new SmallTypeHolder(LayoutInflater.from(this.f).inflate(R.layout.home_up_choiceness_small_type_layout, viewGroup, false));
        }
        if (i == 2) {
            return new UserRankViewHolder(LayoutInflater.from(this.f).inflate(R.layout.home_page_item1_fragment_user_rank_item_layout, viewGroup, false));
        }
        if (i == 3) {
            return new UpUserTypeHolder(LayoutInflater.from(this.f).inflate(R.layout.home_up_user_type_recommend_layout, viewGroup, false));
        }
        if (i != 5) {
            return new ToDayRecommendHolder(LayoutInflater.from(this.f).inflate(R.layout.up_apk_list_item_layout, viewGroup, false));
        }
        return new BaseRecyclerViewAdapter.RecyclerViewFootViewHolder(LayoutInflater.from(this.f).inflate(R.layout.looding_footview, viewGroup, false));
    }

    public void r(UpAdBean upAdBean) {
        this.g = upAdBean;
    }

    public void s(UserRankBean userRankBean) {
        this.h = userRankBean;
    }

    public void t(UserRankBean userRankBean) {
        this.i = userRankBean;
    }
}
