package com.rtk.app.main.HomeCommunityPack.PostAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.base.BaseRecyclerViewAdapter;
import com.rtk.app.bean.CommunityPostBean;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostSelectPostListAdapter extends BaseRecyclerViewAdapter {
    private List<CommunityPostBean.DataBean> e;
    private Context f;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class NoPictrueHolder extends RecyclerView.ViewHolder {
        View a;

        @BindView
        TextView communityFragmentPostlistItemClickNum;

        @BindView
        TextView communityFragmentPostlistItemCommentNum;

        @BindView
        TextView communityFragmentPostlistItemContent;

        @BindView
        TextView communityFragmentPostlistItemName;

        @BindView
        TextView communityFragmentPostlistItemTime;

        @BindView
        TextView communityFragmentPostlistItemUserName;

        @BindView
        View familyPrefix;

        public NoPictrueHolder(View view) {
            super(view);
            ButterKnife.b(this, view);
            this.a = view;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class NoPictrueHolder_ViewBinding implements Unbinder {
        private NoPictrueHolder b;

        @UiThread
        public NoPictrueHolder_ViewBinding(NoPictrueHolder noPictrueHolder, View view) {
            this.b = noPictrueHolder;
            noPictrueHolder.communityFragmentPostlistItemName = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_item_name, "field 'communityFragmentPostlistItemName'", TextView.class);
            noPictrueHolder.communityFragmentPostlistItemContent = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_item_content, "field 'communityFragmentPostlistItemContent'", TextView.class);
            noPictrueHolder.communityFragmentPostlistItemUserName = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_item_userName, "field 'communityFragmentPostlistItemUserName'", TextView.class);
            noPictrueHolder.communityFragmentPostlistItemCommentNum = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_item_commentNum, "field 'communityFragmentPostlistItemCommentNum'", TextView.class);
            noPictrueHolder.communityFragmentPostlistItemClickNum = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_item_clickNum, "field 'communityFragmentPostlistItemClickNum'", TextView.class);
            noPictrueHolder.communityFragmentPostlistItemTime = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_item_time, "field 'communityFragmentPostlistItemTime'", TextView.class);
            noPictrueHolder.familyPrefix = butterknife.c.a.b(view, R.id.family_post_title_prefix, "field 'familyPrefix'");
        }

        @CallSuper
        public void a() {
            NoPictrueHolder noPictrueHolder = this.b;
            if (noPictrueHolder != null) {
                this.b = null;
                noPictrueHolder.communityFragmentPostlistItemName = null;
                noPictrueHolder.communityFragmentPostlistItemContent = null;
                noPictrueHolder.communityFragmentPostlistItemUserName = null;
                noPictrueHolder.communityFragmentPostlistItemCommentNum = null;
                noPictrueHolder.communityFragmentPostlistItemClickNum = null;
                noPictrueHolder.communityFragmentPostlistItemTime = null;
                noPictrueHolder.familyPrefix = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class OnePictrueHolder extends RecyclerView.ViewHolder {
        View a;

        @BindView
        TextView communityFragmentPostlistOnePictrueItemAuthor;

        @BindView
        TextView communityFragmentPostlistOnePictrueItemCommentNum;

        @BindView
        TextView communityFragmentPostlistOnePictrueItemContent;

        @BindView
        ImageView communityFragmentPostlistOnePictrueItemImg;

        @BindView
        TextView communityFragmentPostlistOnePictrueItemImgNum;

        @BindView
        TextView communityFragmentPostlistOnePictrueItemTime;

        @BindView
        TextView communityFragmentPostlistOnePictrueItemTitle;

        @BindView
        TextView communityFragmentPostlistOnePictrueItemViewNum;

        @BindView
        View familyPrefix;

        OnePictrueHolder(View view) {
            super(view);
            ButterKnife.b(this, view);
            this.a = view;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class OnePictrueHolder_ViewBinding implements Unbinder {
        private OnePictrueHolder b;

        @UiThread
        public OnePictrueHolder_ViewBinding(OnePictrueHolder onePictrueHolder, View view) {
            this.b = onePictrueHolder;
            onePictrueHolder.familyPrefix = butterknife.c.a.b(view, R.id.family_post_title_prefix, "field 'familyPrefix'");
            onePictrueHolder.communityFragmentPostlistOnePictrueItemImg = (ImageView) butterknife.c.a.c(view, R.id.community_fragment_postlist_one_pictrue_item_img, "field 'communityFragmentPostlistOnePictrueItemImg'", ImageView.class);
            onePictrueHolder.communityFragmentPostlistOnePictrueItemTitle = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_one_pictrue_item_title, "field 'communityFragmentPostlistOnePictrueItemTitle'", TextView.class);
            onePictrueHolder.communityFragmentPostlistOnePictrueItemContent = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_one_pictrue_item_content, "field 'communityFragmentPostlistOnePictrueItemContent'", TextView.class);
            onePictrueHolder.communityFragmentPostlistOnePictrueItemAuthor = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_one_pictrue_item_author, "field 'communityFragmentPostlistOnePictrueItemAuthor'", TextView.class);
            onePictrueHolder.communityFragmentPostlistOnePictrueItemCommentNum = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_one_pictrue_item_comment_num, "field 'communityFragmentPostlistOnePictrueItemCommentNum'", TextView.class);
            onePictrueHolder.communityFragmentPostlistOnePictrueItemViewNum = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_one_pictrue_item_viewNum, "field 'communityFragmentPostlistOnePictrueItemViewNum'", TextView.class);
            onePictrueHolder.communityFragmentPostlistOnePictrueItemTime = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_one_pictrue_item_time, "field 'communityFragmentPostlistOnePictrueItemTime'", TextView.class);
            onePictrueHolder.communityFragmentPostlistOnePictrueItemImgNum = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_one_pictrue_item_img_num, "field 'communityFragmentPostlistOnePictrueItemImgNum'", TextView.class);
        }

        @CallSuper
        public void a() {
            OnePictrueHolder onePictrueHolder = this.b;
            if (onePictrueHolder != null) {
                this.b = null;
                onePictrueHolder.familyPrefix = null;
                onePictrueHolder.communityFragmentPostlistOnePictrueItemImg = null;
                onePictrueHolder.communityFragmentPostlistOnePictrueItemTitle = null;
                onePictrueHolder.communityFragmentPostlistOnePictrueItemContent = null;
                onePictrueHolder.communityFragmentPostlistOnePictrueItemAuthor = null;
                onePictrueHolder.communityFragmentPostlistOnePictrueItemCommentNum = null;
                onePictrueHolder.communityFragmentPostlistOnePictrueItemViewNum = null;
                onePictrueHolder.communityFragmentPostlistOnePictrueItemTime = null;
                onePictrueHolder.communityFragmentPostlistOnePictrueItemImgNum = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ThreePictrueHolder extends RecyclerView.ViewHolder {
        View a;

        @BindView
        TextView communityFragmentPostlistThreePictrueItemAuthor;

        @BindView
        TextView communityFragmentPostlistThreePictrueItemCommentNum;

        @BindView
        TextView communityFragmentPostlistThreePictrueItemContent;

        @BindView
        ImageView communityFragmentPostlistThreePictrueItemImg1;

        @BindView
        ImageView communityFragmentPostlistThreePictrueItemImg2;

        @BindView
        ImageView communityFragmentPostlistThreePictrueItemImg3;

        @BindView
        TextView communityFragmentPostlistThreePictrueItemImg3Num;

        @BindView
        TextView communityFragmentPostlistThreePictrueItemTime;

        @BindView
        TextView communityFragmentPostlistThreePictrueItemTitle;

        @BindView
        TextView communityFragmentPostlistThreePictrueItemViewNum;

        @BindView
        View familyPrefix;

        ThreePictrueHolder(View view) {
            super(view);
            ButterKnife.b(this, view);
            this.a = view;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ThreePictrueHolder_ViewBinding implements Unbinder {
        private ThreePictrueHolder b;

        @UiThread
        public ThreePictrueHolder_ViewBinding(ThreePictrueHolder threePictrueHolder, View view) {
            this.b = threePictrueHolder;
            threePictrueHolder.familyPrefix = butterknife.c.a.b(view, R.id.family_post_title_prefix, "field 'familyPrefix'");
            threePictrueHolder.communityFragmentPostlistThreePictrueItemTitle = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_three_pictrue_item_title, "field 'communityFragmentPostlistThreePictrueItemTitle'", TextView.class);
            threePictrueHolder.communityFragmentPostlistThreePictrueItemContent = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_three_pictrue_item_content, "field 'communityFragmentPostlistThreePictrueItemContent'", TextView.class);
            threePictrueHolder.communityFragmentPostlistThreePictrueItemAuthor = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_three_pictrue_item_author, "field 'communityFragmentPostlistThreePictrueItemAuthor'", TextView.class);
            threePictrueHolder.communityFragmentPostlistThreePictrueItemImg1 = (ImageView) butterknife.c.a.c(view, R.id.community_fragment_postlist_three_pictrue_item_img1, "field 'communityFragmentPostlistThreePictrueItemImg1'", ImageView.class);
            threePictrueHolder.communityFragmentPostlistThreePictrueItemImg2 = (ImageView) butterknife.c.a.c(view, R.id.community_fragment_postlist_three_pictrue_item_img2, "field 'communityFragmentPostlistThreePictrueItemImg2'", ImageView.class);
            threePictrueHolder.communityFragmentPostlistThreePictrueItemImg3 = (ImageView) butterknife.c.a.c(view, R.id.community_fragment_postlist_three_pictrue_item_img3, "field 'communityFragmentPostlistThreePictrueItemImg3'", ImageView.class);
            threePictrueHolder.communityFragmentPostlistThreePictrueItemTime = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_three_pictrue_item_time, "field 'communityFragmentPostlistThreePictrueItemTime'", TextView.class);
            threePictrueHolder.communityFragmentPostlistThreePictrueItemViewNum = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_three_pictrue_item_viewNum, "field 'communityFragmentPostlistThreePictrueItemViewNum'", TextView.class);
            threePictrueHolder.communityFragmentPostlistThreePictrueItemCommentNum = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_three_pictrue_item_commentNum, "field 'communityFragmentPostlistThreePictrueItemCommentNum'", TextView.class);
            threePictrueHolder.communityFragmentPostlistThreePictrueItemImg3Num = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_three_pictrue_item_img3_num, "field 'communityFragmentPostlistThreePictrueItemImg3Num'", TextView.class);
        }

        @CallSuper
        public void a() {
            ThreePictrueHolder threePictrueHolder = this.b;
            if (threePictrueHolder != null) {
                this.b = null;
                threePictrueHolder.familyPrefix = null;
                threePictrueHolder.communityFragmentPostlistThreePictrueItemTitle = null;
                threePictrueHolder.communityFragmentPostlistThreePictrueItemContent = null;
                threePictrueHolder.communityFragmentPostlistThreePictrueItemAuthor = null;
                threePictrueHolder.communityFragmentPostlistThreePictrueItemImg1 = null;
                threePictrueHolder.communityFragmentPostlistThreePictrueItemImg2 = null;
                threePictrueHolder.communityFragmentPostlistThreePictrueItemImg3 = null;
                threePictrueHolder.communityFragmentPostlistThreePictrueItemTime = null;
                threePictrueHolder.communityFragmentPostlistThreePictrueItemViewNum = null;
                threePictrueHolder.communityFragmentPostlistThreePictrueItemCommentNum = null;
                threePictrueHolder.communityFragmentPostlistThreePictrueItemImg3Num = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class a implements View.OnClickListener {
        private Context a;
        private int b;

        /* renamed from: c, reason: collision with root package name */
        private CommunityPostBean.DataBean f198c;

        public a(Context context, int i, CommunityPostBean.DataBean dataBean, int i2) {
            this.a = context;
            this.b = i;
            this.f198c = dataBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.b != 1) {
                return;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post", this.f198c);
            intent.putExtras(bundle);
            ((Activity) this.a).setResult(1004, intent);
            ((Activity) this.a).finish();
        }
    }

    public PostSelectPostListAdapter(List<CommunityPostBean.DataBean> list, Context context) {
        this.e = list;
        this.f = context;
    }

    public int getItemCount() {
        if (this.e.size() == 0) {
            return 0;
        }
        return this.e.size() + 1;
    }

    public int getItemViewType(int i) {
        int size;
        if (i == getItemCount() - 1) {
            return 4;
        }
        if (this.e.get(i).getPic() != null && (size = this.e.get(i).getPic().size()) != 0) {
            if (size == 1 || size == 2) {
                return 1;
            }
            if (size == 3) {
                return 3;
            }
        }
        return 0;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        try {
            int itemViewType = getItemViewType(i);
            int i2 = 0;
            if (itemViewType == 1) {
                OnePictrueHolder onePictrueHolder = (OnePictrueHolder) viewHolder;
                CommunityPostBean.DataBean dataBean = this.e.get(i);
                onePictrueHolder.communityFragmentPostlistOnePictrueItemTitle.setText(dataBean.getTitle());
                onePictrueHolder.communityFragmentPostlistOnePictrueItemAuthor.setText(dataBean.getOwner().getNickname());
                t.c(this.f, dataBean.getPic().get(0), onePictrueHolder.communityFragmentPostlistOnePictrueItemImg, new boolean[0]);
                onePictrueHolder.communityFragmentPostlistOnePictrueItemTime.setText(this.e.get(i).getBefore());
                onePictrueHolder.communityFragmentPostlistOnePictrueItemViewNum.setText(this.e.get(i).getClickNum());
                onePictrueHolder.communityFragmentPostlistOnePictrueItemViewNum.setVisibility(y.f335c ? 0 : 8);
                onePictrueHolder.communityFragmentPostlistOnePictrueItemCommentNum.setText(this.e.get(i).getCommentNum());
                onePictrueHolder.communityFragmentPostlistOnePictrueItemContent.setText(this.e.get(i).getContent());
                onePictrueHolder.communityFragmentPostlistOnePictrueItemImgNum.setText(this.e.get(i).getPic().size() + "图");
                onePictrueHolder.a.setOnClickListener(new a(this.f, 1, this.e.get(i), i));
                onePictrueHolder.familyPrefix.setVisibility(dataBean.isFamilyPost() ? 0 : 8);
                return;
            }
            if (itemViewType != 3) {
                if (itemViewType != 4) {
                    CommunityPostBean.DataBean dataBean2 = this.e.get(i);
                    NoPictrueHolder noPictrueHolder = (NoPictrueHolder) viewHolder;
                    noPictrueHolder.communityFragmentPostlistItemContent.setText(this.e.get(i).getContent());
                    noPictrueHolder.communityFragmentPostlistItemName.setText(this.e.get(i).getTitle());
                    noPictrueHolder.communityFragmentPostlistItemUserName.setText(this.e.get(i).getOwner().getNickname());
                    noPictrueHolder.communityFragmentPostlistItemTime.setText(this.e.get(i).getBefore());
                    noPictrueHolder.communityFragmentPostlistItemClickNum.setText(this.e.get(i).getClickNum());
                    noPictrueHolder.communityFragmentPostlistItemClickNum.setVisibility(y.f335c ? 0 : 8);
                    noPictrueHolder.communityFragmentPostlistItemCommentNum.setText(this.e.get(i).getCommentNum());
                    noPictrueHolder.a.setOnClickListener(new a(this.f, 1, this.e.get(i), i));
                    noPictrueHolder.familyPrefix.setVisibility(dataBean2.isFamilyPost() ? 0 : 8);
                    return;
                }
                BaseRecyclerViewAdapter.RecyclerViewFootViewHolder recyclerViewFootViewHolder = (BaseRecyclerViewAdapter.RecyclerViewFootViewHolder) viewHolder;
                Boolean valueOf = Boolean.valueOf(g());
                List<CommunityPostBean.DataBean> list = this.e;
                if (list != null) {
                    i2 = list.size();
                }
                recyclerViewFootViewHolder.f(valueOf, i2, h(), f());
                return;
            }
            ThreePictrueHolder threePictrueHolder = (ThreePictrueHolder) viewHolder;
            CommunityPostBean.DataBean dataBean3 = this.e.get(i);
            threePictrueHolder.communityFragmentPostlistThreePictrueItemTitle.setText(dataBean3.getTitle());
            threePictrueHolder.communityFragmentPostlistThreePictrueItemAuthor.setText(dataBean3.getOwner().getNickname());
            t.c(this.f, dataBean3.getPic().get(0), threePictrueHolder.communityFragmentPostlistThreePictrueItemImg1, new boolean[0]);
            t.c(this.f, dataBean3.getPic().get(1), threePictrueHolder.communityFragmentPostlistThreePictrueItemImg2, new boolean[0]);
            t.c(this.f, dataBean3.getPic().get(2), threePictrueHolder.communityFragmentPostlistThreePictrueItemImg3, new boolean[0]);
            threePictrueHolder.communityFragmentPostlistThreePictrueItemTime.setText(this.e.get(i).getBefore());
            threePictrueHolder.communityFragmentPostlistThreePictrueItemViewNum.setText(this.e.get(i).getClickNum());
            threePictrueHolder.communityFragmentPostlistThreePictrueItemViewNum.setVisibility(y.f335c ? 0 : 8);
            threePictrueHolder.communityFragmentPostlistThreePictrueItemCommentNum.setText(this.e.get(i).getCommentNum());
            threePictrueHolder.communityFragmentPostlistThreePictrueItemImg3Num.setText(this.e.get(i).getPic().size() + "图");
            threePictrueHolder.communityFragmentPostlistThreePictrueItemContent.setText(this.e.get(i).getContent());
            threePictrueHolder.a.setOnClickListener(new a(this.f, 1, this.e.get(i), i));
            threePictrueHolder.familyPrefix.setVisibility(dataBean3.isFamilyPost() ? 0 : 8);
        } catch (Exception unused) {
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new OnePictrueHolder(LayoutInflater.from(this.f).inflate(R.layout.community_fragment_postlist_one_pictrue_item_layout, viewGroup, false));
        }
        if (i == 3) {
            return new ThreePictrueHolder(LayoutInflater.from(this.f).inflate(R.layout.community_fragment_postlist_three_pictrue_item_layout, viewGroup, false));
        }
        if (i != 4) {
            return new NoPictrueHolder(LayoutInflater.from(this.f).inflate(R.layout.community_fragment_postlist_no_pictrue_item_layout, viewGroup, false));
        }
        return new BaseRecyclerViewAdapter.RecyclerViewFootViewHolder(LayoutInflater.from(this.f).inflate(R.layout.looding_footview, viewGroup, false));
    }
}
