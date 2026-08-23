package com.rtk.app.adapter;

import android.content.Context;
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
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CommunityFragmentPostListAdapter extends BaseRecyclerViewAdapter {
    private List<CommunityPostBean.DataBean> e;
    private Context f;
    private String g;

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
    static class OnlyTitleHolder extends RecyclerView.ViewHolder {
        private View a;

        @BindView
        TextView postListOnlyTitleLayoutItemAuthor;

        @BindView
        TextView postListOnlyTitleLayoutItemCommentNum;

        @BindView
        TextView postListOnlyTitleLayoutItemTime;

        @BindView
        TextView postListOnlyTitleLayoutItemTitle;

        @BindView
        TextView postListOnlyTitleLayoutItemViewNum;

        OnlyTitleHolder(View view) {
            super(view);
            ButterKnife.b(this, view);
            this.a = view;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class OnlyTitleHolder_ViewBinding implements Unbinder {
        private OnlyTitleHolder b;

        @UiThread
        public OnlyTitleHolder_ViewBinding(OnlyTitleHolder onlyTitleHolder, View view) {
            this.b = onlyTitleHolder;
            onlyTitleHolder.postListOnlyTitleLayoutItemTitle = (TextView) butterknife.c.a.c(view, R.id.post_list_only_title_layout_item_title, "field 'postListOnlyTitleLayoutItemTitle'", TextView.class);
            onlyTitleHolder.postListOnlyTitleLayoutItemAuthor = (TextView) butterknife.c.a.c(view, R.id.post_list_only_title_layout_item_author, "field 'postListOnlyTitleLayoutItemAuthor'", TextView.class);
            onlyTitleHolder.postListOnlyTitleLayoutItemTime = (TextView) butterknife.c.a.c(view, R.id.post_list_only_title_layout_item_time, "field 'postListOnlyTitleLayoutItemTime'", TextView.class);
            onlyTitleHolder.postListOnlyTitleLayoutItemViewNum = (TextView) butterknife.c.a.c(view, R.id.post_list_only_title_layout_item_viewNum, "field 'postListOnlyTitleLayoutItemViewNum'", TextView.class);
            onlyTitleHolder.postListOnlyTitleLayoutItemCommentNum = (TextView) butterknife.c.a.c(view, R.id.post_list_only_title_layout_item_commentNum, "field 'postListOnlyTitleLayoutItemCommentNum'", TextView.class);
        }

        @CallSuper
        public void a() {
            OnlyTitleHolder onlyTitleHolder = this.b;
            if (onlyTitleHolder != null) {
                this.b = null;
                onlyTitleHolder.postListOnlyTitleLayoutItemTitle = null;
                onlyTitleHolder.postListOnlyTitleLayoutItemAuthor = null;
                onlyTitleHolder.postListOnlyTitleLayoutItemTime = null;
                onlyTitleHolder.postListOnlyTitleLayoutItemViewNum = null;
                onlyTitleHolder.postListOnlyTitleLayoutItemCommentNum = null;
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
    static class VideoHolder extends RecyclerView.ViewHolder {
        View a;

        @BindView
        TextView communityFragmentPostlistVideoItemAuthor;

        @BindView
        TextView communityFragmentPostlistVideoItemCommentNum;

        @BindView
        TextView communityFragmentPostlistVideoItemContent;

        @BindView
        ImageView communityFragmentPostlistVideoItemPerviewImg;

        @BindView
        TextView communityFragmentPostlistVideoItemTime;

        @BindView
        TextView communityFragmentPostlistVideoItemTitle;

        @BindView
        TextView communityFragmentPostlistVideoItemViewNum;

        public VideoHolder(View view) {
            super(view);
            ButterKnife.b(this, view);
            this.a = view;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class VideoHolder_ViewBinding implements Unbinder {
        private VideoHolder b;

        @UiThread
        public VideoHolder_ViewBinding(VideoHolder videoHolder, View view) {
            this.b = videoHolder;
            videoHolder.communityFragmentPostlistVideoItemTitle = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_video_item_title, "field 'communityFragmentPostlistVideoItemTitle'", TextView.class);
            videoHolder.communityFragmentPostlistVideoItemContent = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_video_item_content, "field 'communityFragmentPostlistVideoItemContent'", TextView.class);
            videoHolder.communityFragmentPostlistVideoItemPerviewImg = (ImageView) butterknife.c.a.c(view, R.id.community_fragment_postlist_video_item_perview_img, "field 'communityFragmentPostlistVideoItemPerviewImg'", ImageView.class);
            videoHolder.communityFragmentPostlistVideoItemAuthor = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_video_item_author, "field 'communityFragmentPostlistVideoItemAuthor'", TextView.class);
            videoHolder.communityFragmentPostlistVideoItemTime = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_video_item_time, "field 'communityFragmentPostlistVideoItemTime'", TextView.class);
            videoHolder.communityFragmentPostlistVideoItemViewNum = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_video_item_viewNum, "field 'communityFragmentPostlistVideoItemViewNum'", TextView.class);
            videoHolder.communityFragmentPostlistVideoItemCommentNum = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_video_item_commentNum, "field 'communityFragmentPostlistVideoItemCommentNum'", TextView.class);
        }

        @CallSuper
        public void a() {
            VideoHolder videoHolder = this.b;
            if (videoHolder != null) {
                this.b = null;
                videoHolder.communityFragmentPostlistVideoItemTitle = null;
                videoHolder.communityFragmentPostlistVideoItemContent = null;
                videoHolder.communityFragmentPostlistVideoItemPerviewImg = null;
                videoHolder.communityFragmentPostlistVideoItemAuthor = null;
                videoHolder.communityFragmentPostlistVideoItemTime = null;
                videoHolder.communityFragmentPostlistVideoItemViewNum = null;
                videoHolder.communityFragmentPostlistVideoItemCommentNum = null;
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
        private CommunityPostBean.DataBean f40c;
        private String d;

        public a(Context context, int i, CommunityPostBean.DataBean dataBean, int i2, String str) {
            this.a = context;
            this.b = i;
            this.f40c = dataBean;
            this.d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.b != 1) {
                return;
            }
            com.rtk.app.tool.t.K0(this.a, this.f40c.getPid(), this.d);
        }
    }

    public CommunityFragmentPostListAdapter(List<CommunityPostBean.DataBean> list, Context context) {
        this.e = list;
        this.f = context;
    }

    public int getItemCount() {
        if (this.e.size() == 0) {
            return 1;
        }
        return this.e.size() + 1;
    }

    public int getItemViewType(int i) {
        int size;
        if (i == getItemCount() - 1 || getItemCount() == 1) {
            return 4;
        }
        if (com.rtk.app.tool.v.a(this.f, "postJustTitle")) {
            return 6;
        }
        if (this.e.get(i).getList_post_video() != null && this.e.get(i).getList_post_video().size() > 0) {
            return 5;
        }
        if (this.e.get(i).getPic() == null || (size = this.e.get(i).getPic().size()) == 0) {
            return 0;
        }
        return (size == 1 || size == 2) ? 1 : 3;
    }

    public void l(String str) {
        this.g = str;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        try {
            int itemViewType = getItemViewType(i);
            int i2 = 0;
            if (itemViewType == 1) {
                OnePictrueHolder onePictrueHolder = (OnePictrueHolder) viewHolder;
                com.rtk.app.tool.t.U1(onePictrueHolder.communityFragmentPostlistOnePictrueItemTitle, this.e.get(i).getTitle(), this.e.get(i).getPost_title());
                onePictrueHolder.communityFragmentPostlistOnePictrueItemAuthor.setText(this.e.get(i).getOwner().getNickname());
                com.rtk.app.tool.t.c(this.f, this.e.get(i).getPic().get(0), onePictrueHolder.communityFragmentPostlistOnePictrueItemImg, new boolean[0]);
                onePictrueHolder.communityFragmentPostlistOnePictrueItemTime.setText(this.e.get(i).getBefore());
                onePictrueHolder.communityFragmentPostlistOnePictrueItemViewNum.setText(this.e.get(i).getClickNum());
                onePictrueHolder.communityFragmentPostlistOnePictrueItemViewNum.setVisibility(com.rtk.app.tool.y.f335c ? 0 : 8);
                onePictrueHolder.communityFragmentPostlistOnePictrueItemCommentNum.setText(this.e.get(i).getLevelCommentNum());
                onePictrueHolder.communityFragmentPostlistOnePictrueItemContent.setText(this.e.get(i).getContent());
                onePictrueHolder.communityFragmentPostlistOnePictrueItemImgNum.setText(this.e.get(i).getPic().size() + "图");
                onePictrueHolder.a.setOnClickListener(new a(this.f, 1, this.e.get(i), i, this.g));
                return;
            }
            if (itemViewType == 3) {
                ThreePictrueHolder threePictrueHolder = (ThreePictrueHolder) viewHolder;
                com.rtk.app.tool.t.U1(threePictrueHolder.communityFragmentPostlistThreePictrueItemTitle, this.e.get(i).getTitle(), this.e.get(i).getPost_title());
                threePictrueHolder.communityFragmentPostlistThreePictrueItemAuthor.setText(this.e.get(i).getOwner().getNickname());
                com.rtk.app.tool.t.c(this.f, this.e.get(i).getPic().get(0), threePictrueHolder.communityFragmentPostlistThreePictrueItemImg1, new boolean[0]);
                com.rtk.app.tool.t.c(this.f, this.e.get(i).getPic().get(1), threePictrueHolder.communityFragmentPostlistThreePictrueItemImg2, new boolean[0]);
                com.rtk.app.tool.t.c(this.f, this.e.get(i).getPic().get(2), threePictrueHolder.communityFragmentPostlistThreePictrueItemImg3, new boolean[0]);
                threePictrueHolder.communityFragmentPostlistThreePictrueItemTime.setText(this.e.get(i).getBefore());
                threePictrueHolder.communityFragmentPostlistThreePictrueItemViewNum.setText(this.e.get(i).getClickNum());
                threePictrueHolder.communityFragmentPostlistThreePictrueItemViewNum.setVisibility(com.rtk.app.tool.y.f335c ? 0 : 8);
                threePictrueHolder.communityFragmentPostlistThreePictrueItemCommentNum.setText(this.e.get(i).getLevelCommentNum());
                threePictrueHolder.communityFragmentPostlistThreePictrueItemImg3Num.setText(this.e.get(i).getPic().size() + "图");
                threePictrueHolder.communityFragmentPostlistThreePictrueItemContent.setText(this.e.get(i).getContent());
                threePictrueHolder.a.setOnClickListener(new a(this.f, 1, this.e.get(i), i, this.g));
                return;
            }
            if (itemViewType == 4) {
                BaseRecyclerViewAdapter.RecyclerViewFootViewHolder recyclerViewFootViewHolder = (BaseRecyclerViewAdapter.RecyclerViewFootViewHolder) viewHolder;
                Boolean valueOf = Boolean.valueOf(g());
                List<CommunityPostBean.DataBean> list = this.e;
                if (list != null) {
                    i2 = list.size();
                }
                recyclerViewFootViewHolder.f(valueOf, i2, h(), f());
                return;
            }
            if (itemViewType == 5) {
                VideoHolder videoHolder = (VideoHolder) viewHolder;
                com.rtk.app.tool.t.U1(videoHolder.communityFragmentPostlistVideoItemTitle, this.e.get(i).getTitle(), this.e.get(i).getPost_title());
                videoHolder.communityFragmentPostlistVideoItemAuthor.setText(this.e.get(i).getOwner().getNickname());
                com.rtk.app.tool.t.c(this.f, this.e.get(i).getList_post_video().get(0).getLogo(), videoHolder.communityFragmentPostlistVideoItemPerviewImg, new boolean[0]);
                videoHolder.communityFragmentPostlistVideoItemTime.setText(this.e.get(i).getBefore());
                videoHolder.communityFragmentPostlistVideoItemViewNum.setText(this.e.get(i).getClickNum());
                videoHolder.communityFragmentPostlistVideoItemViewNum.setVisibility(com.rtk.app.tool.y.f335c ? 0 : 8);
                videoHolder.communityFragmentPostlistVideoItemCommentNum.setText(this.e.get(i).getLevelCommentNum());
                videoHolder.communityFragmentPostlistVideoItemContent.setText(this.e.get(i).getContent());
                videoHolder.a.setOnClickListener(new a(this.f, 1, this.e.get(i), i, this.g));
                return;
            }
            if (itemViewType != 6) {
                NoPictrueHolder noPictrueHolder = (NoPictrueHolder) viewHolder;
                com.rtk.app.tool.t.U1(noPictrueHolder.communityFragmentPostlistItemName, this.e.get(i).getTitle(), this.e.get(i).getPost_title());
                noPictrueHolder.communityFragmentPostlistItemContent.setText(this.e.get(i).getContent());
                noPictrueHolder.communityFragmentPostlistItemUserName.setText(this.e.get(i).getOwner().getNickname());
                noPictrueHolder.communityFragmentPostlistItemClickNum.setText(this.e.get(i).getClickNum());
                noPictrueHolder.communityFragmentPostlistItemClickNum.setVisibility(com.rtk.app.tool.y.f335c ? 0 : 8);
                noPictrueHolder.communityFragmentPostlistItemCommentNum.setText(this.e.get(i).getLevelCommentNum());
                noPictrueHolder.a.setOnClickListener(new a(this.f, 1, this.e.get(i), i, this.g));
                noPictrueHolder.communityFragmentPostlistItemTime.setText(this.e.get(i).getBefore());
                return;
            }
            OnlyTitleHolder onlyTitleHolder = (OnlyTitleHolder) viewHolder;
            com.rtk.app.tool.t.U1(onlyTitleHolder.postListOnlyTitleLayoutItemTitle, this.e.get(i).getTitle(), this.e.get(i).getPost_title());
            onlyTitleHolder.postListOnlyTitleLayoutItemAuthor.setText(this.e.get(i).getOwner().getNickname());
            onlyTitleHolder.postListOnlyTitleLayoutItemViewNum.setText(this.e.get(i).getClickNum());
            onlyTitleHolder.postListOnlyTitleLayoutItemCommentNum.setText(this.e.get(i).getLevelCommentNum());
            onlyTitleHolder.a.setOnClickListener(new a(this.f, 1, this.e.get(i), i, this.g));
            onlyTitleHolder.postListOnlyTitleLayoutItemTime.setText(this.e.get(i).getBefore());
        } catch (Exception e) {
            com.rtk.app.tool.c0.u("CommunityFragmentPostListAdapter", "异常" + e.toString());
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new OnePictrueHolder(LayoutInflater.from(this.f).inflate(R.layout.community_fragment_postlist_one_pictrue_item_layout, viewGroup, false));
        }
        if (i == 3) {
            return new ThreePictrueHolder(LayoutInflater.from(this.f).inflate(R.layout.community_fragment_postlist_three_pictrue_item_layout, viewGroup, false));
        }
        if (i == 4) {
            return new BaseRecyclerViewAdapter.RecyclerViewFootViewHolder(LayoutInflater.from(this.f).inflate(R.layout.looding_footview, viewGroup, false));
        }
        if (i == 5) {
            return new VideoHolder(LayoutInflater.from(this.f).inflate(R.layout.community_fragment_postlist_video_item_layout, viewGroup, false));
        }
        if (i != 6) {
            return new NoPictrueHolder(LayoutInflater.from(this.f).inflate(R.layout.community_fragment_postlist_no_pictrue_item_layout, viewGroup, false));
        }
        return new OnlyTitleHolder(LayoutInflater.from(this.f).inflate(R.layout.post_list_only_title_layout, viewGroup, false));
    }
}
