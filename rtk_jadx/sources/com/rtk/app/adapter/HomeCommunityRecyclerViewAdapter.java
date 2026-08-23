package com.rtk.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.bean.FamilyListBean;
import com.rtk.app.bean.HomeCommunityBean;
import com.rtk.app.bean.UpAdBean;
import com.rtk.app.main.MainActivityPack.HomePageItem1Pack.BannerHolder;
import com.rtk.app.main.MainActivityPack.HomePageItem1Pack.CommunityFamilyHolder;
import com.rtk.app.main.MainActivityPack.MainActivity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeCommunityRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static int e;
    private List<HomeCommunityBean.DataBean> a;
    private Context b;

    /* renamed from: c, reason: collision with root package name */
    private UpAdBean f75c;
    private FamilyListBean d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ElementViewHolder extends RecyclerView.ViewHolder {
        View a;

        @BindView
        TextView homeCommunityFragmentItemHuatiNum;

        @BindView
        ImageView homeCommunityFragmentItemIcon;

        @BindView
        TextView homeCommunityFragmentItemName;

        public ElementViewHolder(View view) {
            super(view);
            ButterKnife.b(this, view);
            this.a = view;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ElementViewHolder_ViewBinding implements Unbinder {
        private ElementViewHolder b;

        @UiThread
        public ElementViewHolder_ViewBinding(ElementViewHolder elementViewHolder, View view) {
            this.b = elementViewHolder;
            elementViewHolder.homeCommunityFragmentItemIcon = (ImageView) butterknife.c.a.c(view, R.id.home_community_fragment_item_icon, "field 'homeCommunityFragmentItemIcon'", ImageView.class);
            elementViewHolder.homeCommunityFragmentItemName = (TextView) butterknife.c.a.c(view, R.id.home_community_fragment_item_Name, "field 'homeCommunityFragmentItemName'", TextView.class);
            elementViewHolder.homeCommunityFragmentItemHuatiNum = (TextView) butterknife.c.a.c(view, R.id.home_community_fragment_item_huatiNum, "field 'homeCommunityFragmentItemHuatiNum'", TextView.class);
        }

        @CallSuper
        public void a() {
            ElementViewHolder elementViewHolder = this.b;
            if (elementViewHolder != null) {
                this.b = null;
                elementViewHolder.homeCommunityFragmentItemIcon = null;
                elementViewHolder.homeCommunityFragmentItemName = null;
                elementViewHolder.homeCommunityFragmentItemHuatiNum = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class FansBoardHolder extends RecyclerView.ViewHolder {
        View a;

        @BindView
        RoundedImageView moduleFansBoardIcon;

        public FansBoardHolder(View view) {
            super(view);
            ButterKnife.b(this, view);
            this.a = view;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class FansBoardHolder_ViewBinding implements Unbinder {
        private FansBoardHolder b;

        @UiThread
        public FansBoardHolder_ViewBinding(FansBoardHolder fansBoardHolder, View view) {
            this.b = fansBoardHolder;
            fansBoardHolder.moduleFansBoardIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.module_fans_board_icon, "field 'moduleFansBoardIcon'", RoundedImageView.class);
        }

        @CallSuper
        public void a() {
            FansBoardHolder fansBoardHolder = this.b;
            if (fansBoardHolder != null) {
                this.b = null;
                fansBoardHolder.moduleFansBoardIcon = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class MoudleTitleHolder extends RecyclerView.ViewHolder {

        @BindView
        TextView moudleTitleAuditComment;

        @BindView
        LinearLayout moudleTitleAuditLv;

        @BindView
        TextView moudleTitleAuditPost;

        @BindView
        ImageView moudleTitleSetting;

        @BindView
        TextView moudleTitleTv;

        public MoudleTitleHolder(View view) {
            super(view);
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class MoudleTitleHolder_ViewBinding implements Unbinder {
        private MoudleTitleHolder b;

        @UiThread
        public MoudleTitleHolder_ViewBinding(MoudleTitleHolder moudleTitleHolder, View view) {
            this.b = moudleTitleHolder;
            moudleTitleHolder.moudleTitleTv = (TextView) butterknife.c.a.c(view, R.id.moudle_title_tv, "field 'moudleTitleTv'", TextView.class);
            moudleTitleHolder.moudleTitleAuditPost = (TextView) butterknife.c.a.c(view, R.id.moudle_title_audit_post, "field 'moudleTitleAuditPost'", TextView.class);
            moudleTitleHolder.moudleTitleAuditComment = (TextView) butterknife.c.a.c(view, R.id.moudle_title_audit_comment, "field 'moudleTitleAuditComment'", TextView.class);
            moudleTitleHolder.moudleTitleAuditLv = (LinearLayout) butterknife.c.a.c(view, R.id.moudle_title_audit_lv, "field 'moudleTitleAuditLv'", LinearLayout.class);
            moudleTitleHolder.moudleTitleSetting = (ImageView) butterknife.c.a.c(view, R.id.moudle_title_setting, "field 'moudleTitleSetting'", ImageView.class);
        }

        @CallSuper
        public void a() {
            MoudleTitleHolder moudleTitleHolder = this.b;
            if (moudleTitleHolder != null) {
                this.b = null;
                moudleTitleHolder.moudleTitleTv = null;
                moudleTitleHolder.moudleTitleAuditPost = null;
                moudleTitleHolder.moudleTitleAuditComment = null;
                moudleTitleHolder.moudleTitleAuditLv = null;
                moudleTitleHolder.moudleTitleSetting = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class MyAttentionHolder extends RecyclerView.ViewHolder {
        View a;

        @BindView
        RoundedImageView moduleMyAttentionIcon;

        @BindView
        TextView moduleMyAttentionNum;

        public MyAttentionHolder(View view) {
            super(view);
            ButterKnife.b(this, view);
            this.a = view;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class MyAttentionHolder_ViewBinding implements Unbinder {
        private MyAttentionHolder b;

        @UiThread
        public MyAttentionHolder_ViewBinding(MyAttentionHolder myAttentionHolder, View view) {
            this.b = myAttentionHolder;
            myAttentionHolder.moduleMyAttentionIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.module_my_attention_icon, "field 'moduleMyAttentionIcon'", RoundedImageView.class);
            myAttentionHolder.moduleMyAttentionNum = (TextView) butterknife.c.a.c(view, R.id.module_my_attention_num, "field 'moduleMyAttentionNum'", TextView.class);
        }

        @CallSuper
        public void a() {
            MyAttentionHolder myAttentionHolder = this.b;
            if (myAttentionHolder != null) {
                this.b = null;
                myAttentionHolder.moduleMyAttentionIcon = null;
                myAttentionHolder.moduleMyAttentionNum = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class NoPictrueHolder extends RecyclerView.ViewHolder {

        @BindView
        TextView moudleOnePictureItemClickNum;

        @BindView
        TextView moudleOnePictureItemCommentNum;

        @BindView
        TextView moudleOnePictureItemContent;

        @BindView
        TextView moudleOnePictureItemName;

        @BindView
        TextView moudleOnePictureItemTime;

        @BindView
        TextView moudleOnePictureItemUserName;
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class NoPictrueHolder_ViewBinding implements Unbinder {
        private NoPictrueHolder b;

        @UiThread
        public NoPictrueHolder_ViewBinding(NoPictrueHolder noPictrueHolder, View view) {
            noPictrueHolder.moudleOnePictureItemName = (TextView) butterknife.c.a.c(view, R.id.moudle_no_picture_postlist_item_name, "field 'moudleOnePictureItemName'", TextView.class);
            noPictrueHolder.moudleOnePictureItemContent = (TextView) butterknife.c.a.c(view, R.id.moudle_no_picture_postlist_item_content, "field 'moudleOnePictureItemContent'", TextView.class);
            noPictrueHolder.moudleOnePictureItemUserName = (TextView) butterknife.c.a.c(view, R.id.moudle_no_picture_postlist_item_userName, "field 'moudleOnePictureItemUserName'", TextView.class);
            noPictrueHolder.moudleOnePictureItemCommentNum = (TextView) butterknife.c.a.c(view, R.id.moudle_no_picture_postlist_item_commentNum, "field 'moudleOnePictureItemCommentNum'", TextView.class);
            noPictrueHolder.moudleOnePictureItemClickNum = (TextView) butterknife.c.a.c(view, R.id.moudle_no_picture_postlist_item_clickNum, "field 'moudleOnePictureItemClickNum'", TextView.class);
            noPictrueHolder.moudleOnePictureItemTime = (TextView) butterknife.c.a.c(view, R.id.moudle_no_picture_postlist_item_time, "field 'moudleOnePictureItemTime'", TextView.class);
        }

        @CallSuper
        public void a() {
            NoPictrueHolder noPictrueHolder = this.b;
            if (noPictrueHolder != null) {
                noPictrueHolder.moudleOnePictureItemName = null;
                noPictrueHolder.moudleOnePictureItemContent = null;
                noPictrueHolder.moudleOnePictureItemUserName = null;
                noPictrueHolder.moudleOnePictureItemCommentNum = null;
                noPictrueHolder.moudleOnePictureItemClickNum = null;
                noPictrueHolder.moudleOnePictureItemTime = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class OnePictrueHolder extends RecyclerView.ViewHolder {

        @BindView
        TextView moudleOnePictureOnePictrueItemAuthor;

        @BindView
        TextView moudleOnePictureOnePictrueItemCommentNum;

        @BindView
        TextView moudleOnePictureOnePictrueItemContent;

        @BindView
        ImageView moudleOnePictureOnePictrueItemImg;

        @BindView
        TextView moudleOnePictureOnePictrueItemImgNum;

        @BindView
        TextView moudleOnePictureOnePictrueItemTime;

        @BindView
        TextView moudleOnePictureOnePictrueItemTitle;

        @BindView
        TextView moudleOnePictureOnePictrueItemViewNum;
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class OnePictrueHolder_ViewBinding implements Unbinder {
        private OnePictrueHolder b;

        @UiThread
        public OnePictrueHolder_ViewBinding(OnePictrueHolder onePictrueHolder, View view) {
            onePictrueHolder.moudleOnePictureOnePictrueItemImg = (ImageView) butterknife.c.a.c(view, R.id.moudle_one_picture_one_pictrue_item_img, "field 'moudleOnePictureOnePictrueItemImg'", ImageView.class);
            onePictrueHolder.moudleOnePictureOnePictrueItemTitle = (TextView) butterknife.c.a.c(view, R.id.moudle_one_picture_one_pictrue_item_title, "field 'moudleOnePictureOnePictrueItemTitle'", TextView.class);
            onePictrueHolder.moudleOnePictureOnePictrueItemContent = (TextView) butterknife.c.a.c(view, R.id.moudle_one_picture_one_pictrue_item_content, "field 'moudleOnePictureOnePictrueItemContent'", TextView.class);
            onePictrueHolder.moudleOnePictureOnePictrueItemAuthor = (TextView) butterknife.c.a.c(view, R.id.moudle_one_picture_one_pictrue_item_author, "field 'moudleOnePictureOnePictrueItemAuthor'", TextView.class);
            onePictrueHolder.moudleOnePictureOnePictrueItemCommentNum = (TextView) butterknife.c.a.c(view, R.id.moudle_one_picture_one_pictrue_item_comment_num, "field 'moudleOnePictureOnePictrueItemCommentNum'", TextView.class);
            onePictrueHolder.moudleOnePictureOnePictrueItemViewNum = (TextView) butterknife.c.a.c(view, R.id.moudle_one_picture_one_pictrue_item_viewNum, "field 'moudleOnePictureOnePictrueItemViewNum'", TextView.class);
            onePictrueHolder.moudleOnePictureOnePictrueItemTime = (TextView) butterknife.c.a.c(view, R.id.moudle_one_picture_one_pictrue_item_time, "field 'moudleOnePictureOnePictrueItemTime'", TextView.class);
            onePictrueHolder.moudleOnePictureOnePictrueItemImgNum = (TextView) butterknife.c.a.c(view, R.id.moudle_one_picture_one_pictrue_item_img_num, "field 'moudleOnePictureOnePictrueItemImgNum'", TextView.class);
        }

        @CallSuper
        public void a() {
            OnePictrueHolder onePictrueHolder = this.b;
            if (onePictrueHolder != null) {
                onePictrueHolder.moudleOnePictureOnePictrueItemImg = null;
                onePictrueHolder.moudleOnePictureOnePictrueItemTitle = null;
                onePictrueHolder.moudleOnePictureOnePictrueItemContent = null;
                onePictrueHolder.moudleOnePictureOnePictrueItemAuthor = null;
                onePictrueHolder.moudleOnePictureOnePictrueItemCommentNum = null;
                onePictrueHolder.moudleOnePictureOnePictrueItemViewNum = null;
                onePictrueHolder.moudleOnePictureOnePictrueItemTime = null;
                onePictrueHolder.moudleOnePictureOnePictrueItemImgNum = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public HomeCommunityRecyclerViewAdapter(Context context, List<HomeCommunityBean.DataBean> list) {
        this.b = context;
        this.a = list;
    }

    public void g(FamilyListBean familyListBean) {
        this.d = familyListBean;
    }

    public int getItemCount() {
        return this.a.size() + 4;
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 4;
        }
        if (i != 2) {
            return i != 3 ? 3 : 6;
        }
        return 5;
    }

    public void h(int i) {
        e = i;
        notifyDataSetChanged();
    }

    public void i(UpAdBean upAdBean) {
        this.f75c = upAdBean;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            BannerHolder bannerHolder = (BannerHolder) viewHolder;
            if (this.f75c == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (r1 < this.f75c.getData().size()) {
                arrayList.add(this.f75c.getData().get(r1).getDesc());
                arrayList2.add(this.f75c.getData().get(r1).getPic());
                r1++;
            }
            bannerHolder.homeUpChoicenessBannerLayoutBanner.w(new com.rtk.app.tool.l());
            bannerHolder.homeUpChoicenessBannerLayoutBanner.t(arrayList);
            bannerHolder.homeUpChoicenessBannerLayoutBanner.x(arrayList2);
            bannerHolder.homeUpChoicenessBannerLayoutBanner.B();
            bannerHolder.c(this.b);
            bannerHolder.e(this.f75c);
            return;
        }
        if (itemViewType == 1) {
            ((CommunityFamilyHolder) viewHolder).e(this.d);
            return;
        }
        if (itemViewType == 3) {
            int i2 = i - 4;
            ElementViewHolder elementViewHolder = (ElementViewHolder) viewHolder;
            elementViewHolder.homeCommunityFragmentItemName.setText(this.a.get(i2).getName());
            elementViewHolder.homeCommunityFragmentItemHuatiNum.setText(this.a.get(i2).getPostsNum() + "");
            com.rtk.app.tool.t.c(this.b, this.a.get(i2).getLogo(), elementViewHolder.homeCommunityFragmentItemIcon, new boolean[0]);
            elementViewHolder.a.setOnClickListener(new a((Activity) this.b, 1, i2, this.a.get(i2)));
            return;
        }
        if (itemViewType == 4) {
            MoudleTitleHolder moudleTitleHolder = (MoudleTitleHolder) viewHolder;
            if (c.d.a.d.d() && (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getAdmin() == 2 || MainActivity.p.getData().getAdmin().getBbsAdmin() == 1 || MainActivity.p.getData().getAdmin().getBbsAdmin() == 2)) {
                moudleTitleHolder.moudleTitleAuditLv.setVisibility(0);
            } else {
                moudleTitleHolder.moudleTitleAuditLv.setVisibility(8);
            }
            moudleTitleHolder.moudleTitleAuditPost.setOnClickListener(new a((Activity) this.b, 2));
            moudleTitleHolder.moudleTitleAuditComment.setOnClickListener(new a((Activity) this.b, 3));
            moudleTitleHolder.moudleTitleSetting.setOnClickListener(new a((Activity) this.b, 4));
            return;
        }
        if (itemViewType != 5) {
            if (itemViewType != 6) {
                return;
            }
            ((RecyclerView.ViewHolder) ((FansBoardHolder) viewHolder)).itemView.setOnClickListener(new a((Activity) this.b, 6));
            return;
        }
        MyAttentionHolder myAttentionHolder = (MyAttentionHolder) viewHolder;
        TextView textView = myAttentionHolder.moduleMyAttentionNum;
        StringBuilder sb = new StringBuilder();
        int i3 = e;
        sb.append(i3 > 99 ? "99+" : Integer.valueOf(i3));
        sb.append("");
        textView.setText(sb.toString());
        myAttentionHolder.moduleMyAttentionNum.setVisibility(e <= 0 ? 8 : 0);
        ((RecyclerView.ViewHolder) myAttentionHolder).itemView.setOnClickListener(new a((Activity) this.b, 5));
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new BannerHolder(LayoutInflater.from(this.b).inflate(R.layout.home_up_choiceness_banner_layout, viewGroup, false), BannerHolder.b.CommunityBanner);
        }
        if (i == 1) {
            return new CommunityFamilyHolder(this.b, LayoutInflater.from(this.b).inflate(R.layout.home_comunity_family_layout, viewGroup, false));
        }
        if (i == 4) {
            return new MoudleTitleHolder(LayoutInflater.from(this.b).inflate(R.layout.moudle_title_textview, viewGroup, false));
        }
        if (i == 5) {
            return new MyAttentionHolder(LayoutInflater.from(this.b).inflate(R.layout.moudle_my_attention_textview, viewGroup, false));
        }
        if (i != 6) {
            return new ElementViewHolder(LayoutInflater.from(this.b).inflate(R.layout.home_community_recyclerview_item_layout, (ViewGroup) null));
        }
        return new FansBoardHolder(LayoutInflater.from(this.b).inflate(R.layout.moudle_fans_board_view, viewGroup, false));
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class a implements View.OnClickListener {
        private int a;
        private HomeCommunityBean.DataBean b;

        /* renamed from: c, reason: collision with root package name */
        private Activity f76c;

        public a(Activity activity, int i, int i2, HomeCommunityBean.DataBean dataBean) {
            this.a = i;
            this.b = dataBean;
            this.f76c = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (this.a) {
                case 1:
                    com.rtk.app.tool.t.H0(this.f76c, this.b.getName(), this.b.getLogo(), this.b.getId());
                    return;
                case 2:
                    com.rtk.app.tool.c0.u("HomeCommunityRecyclerViewAdapter", "我是审核");
                    com.rtk.app.tool.t.E0(this.f76c, "0", false);
                    return;
                case 3:
                    com.rtk.app.tool.t.m0(this.f76c, "0", 0, null, false);
                    return;
                case 4:
                    com.rtk.app.tool.t.n0(this.f76c);
                    return;
                case 5:
                    int unused = HomeCommunityRecyclerViewAdapter.e = 0;
                    com.rtk.app.tool.t.x(this.f76c);
                    return;
                case 6:
                    com.rtk.app.tool.t.w(this.f76c);
                    return;
                default:
                    return;
            }
        }

        public a(Activity activity, int i) {
            this.f76c = activity;
            this.a = i;
        }
    }
}
