package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.rtk.app.base.BaseRecyclerViewAdapter;
import com.rtk.app.bean.MypostMyReplyBean;
import com.rtk.app.custom.CustomTextView;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FragementMyPostReplyAdapter extends BaseRecyclerViewAdapter {
    private Context e;
    private List<MypostMyReplyBean.DataBean> f;
    private String g;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class CommentViewHolder extends RecyclerView.ViewHolder {

        @BindView
        CustomTextView myPostMyReplyCommentItemMyContent;

        @BindView
        RoundedImageView myPostMyReplyCommentItemMyIcon;

        @BindView
        TextView myPostMyReplyCommentItemMyNickName;

        @BindView
        CustomTextView myPostMyReplyCommentItemOtherContent;

        @BindView
        TextView myPostMyReplyCommentItemPostContent;

        @BindView
        LinearLayout myPostMyReplyCommentItemPostLv;

        @BindView
        TextView myPostMyReplyCommentItemTime;

        @BindView
        TextView myPostMyReplyCommentItemTitle;

        public CommentViewHolder(View view) {
            super(view);
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class CommentViewHolder_ViewBinding implements Unbinder {
        private CommentViewHolder b;

        @UiThread
        public CommentViewHolder_ViewBinding(CommentViewHolder commentViewHolder, View view) {
            this.b = commentViewHolder;
            commentViewHolder.myPostMyReplyCommentItemMyIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.my_post_my_reply_comment_item_my_icon, "field 'myPostMyReplyCommentItemMyIcon'", RoundedImageView.class);
            commentViewHolder.myPostMyReplyCommentItemMyNickName = (TextView) butterknife.c.a.c(view, R.id.my_post_my_reply_comment_item_my_nickName, "field 'myPostMyReplyCommentItemMyNickName'", TextView.class);
            commentViewHolder.myPostMyReplyCommentItemTime = (TextView) butterknife.c.a.c(view, R.id.my_post_my_reply_comment_item_time, "field 'myPostMyReplyCommentItemTime'", TextView.class);
            commentViewHolder.myPostMyReplyCommentItemOtherContent = (CustomTextView) butterknife.c.a.c(view, R.id.my_post_my_reply_comment_item_other_content, "field 'myPostMyReplyCommentItemOtherContent'", CustomTextView.class);
            commentViewHolder.myPostMyReplyCommentItemMyContent = (CustomTextView) butterknife.c.a.c(view, R.id.my_post_my_reply_comment_item_my_content, "field 'myPostMyReplyCommentItemMyContent'", CustomTextView.class);
            commentViewHolder.myPostMyReplyCommentItemTitle = (TextView) butterknife.c.a.c(view, R.id.my_post_my_reply_comment_item_title, "field 'myPostMyReplyCommentItemTitle'", TextView.class);
            commentViewHolder.myPostMyReplyCommentItemPostContent = (TextView) butterknife.c.a.c(view, R.id.my_post_my_reply_comment_item_postContent, "field 'myPostMyReplyCommentItemPostContent'", TextView.class);
            commentViewHolder.myPostMyReplyCommentItemPostLv = (LinearLayout) butterknife.c.a.c(view, R.id.my_post_my_reply_comment_item_postLv, "field 'myPostMyReplyCommentItemPostLv'", LinearLayout.class);
        }

        @CallSuper
        public void a() {
            CommentViewHolder commentViewHolder = this.b;
            if (commentViewHolder != null) {
                this.b = null;
                commentViewHolder.myPostMyReplyCommentItemMyIcon = null;
                commentViewHolder.myPostMyReplyCommentItemMyNickName = null;
                commentViewHolder.myPostMyReplyCommentItemTime = null;
                commentViewHolder.myPostMyReplyCommentItemOtherContent = null;
                commentViewHolder.myPostMyReplyCommentItemMyContent = null;
                commentViewHolder.myPostMyReplyCommentItemTitle = null;
                commentViewHolder.myPostMyReplyCommentItemPostContent = null;
                commentViewHolder.myPostMyReplyCommentItemPostLv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class PostViewHolder extends RecyclerView.ViewHolder {

        @BindView
        TextView myPostMyReplyPostItemContent;

        @BindView
        RoundedImageView myPostMyReplyPostItemMyIcon;

        @BindView
        TextView myPostMyReplyPostItemMyNickName;

        @BindView
        TextView myPostMyReplyPostItemPostContent;

        @BindView
        LinearLayout myPostMyReplyPostItemPostLv;

        @BindView
        CustomTextView myPostMyReplyPostItemReplyToWho;

        @BindView
        TextView myPostMyReplyPostItemTime;

        @BindView
        TextView myPostMyReplyPostItemTitle;

        public PostViewHolder(View view) {
            super(view);
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class PostViewHolder_ViewBinding implements Unbinder {
        private PostViewHolder b;

        @UiThread
        public PostViewHolder_ViewBinding(PostViewHolder postViewHolder, View view) {
            this.b = postViewHolder;
            postViewHolder.myPostMyReplyPostItemMyIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.my_post_my_reply_post_item_my_icon, "field 'myPostMyReplyPostItemMyIcon'", RoundedImageView.class);
            postViewHolder.myPostMyReplyPostItemMyNickName = (TextView) butterknife.c.a.c(view, R.id.my_post_my_reply_post_item_my_nickName, "field 'myPostMyReplyPostItemMyNickName'", TextView.class);
            postViewHolder.myPostMyReplyPostItemTime = (TextView) butterknife.c.a.c(view, R.id.my_post_my_reply_post_item_time, "field 'myPostMyReplyPostItemTime'", TextView.class);
            postViewHolder.myPostMyReplyPostItemReplyToWho = (CustomTextView) butterknife.c.a.c(view, R.id.my_post_my_reply_post_item_reply_to_who, "field 'myPostMyReplyPostItemReplyToWho'", CustomTextView.class);
            postViewHolder.myPostMyReplyPostItemContent = (TextView) butterknife.c.a.c(view, R.id.my_post_my_reply_post_item_content, "field 'myPostMyReplyPostItemContent'", TextView.class);
            postViewHolder.myPostMyReplyPostItemTitle = (TextView) butterknife.c.a.c(view, R.id.my_post_my_reply_post_item_title, "field 'myPostMyReplyPostItemTitle'", TextView.class);
            postViewHolder.myPostMyReplyPostItemPostContent = (TextView) butterknife.c.a.c(view, R.id.my_post_my_reply_post_item_postContent, "field 'myPostMyReplyPostItemPostContent'", TextView.class);
            postViewHolder.myPostMyReplyPostItemPostLv = (LinearLayout) butterknife.c.a.c(view, R.id.my_post_my_reply_post_item_postLv, "field 'myPostMyReplyPostItemPostLv'", LinearLayout.class);
        }

        @CallSuper
        public void a() {
            PostViewHolder postViewHolder = this.b;
            if (postViewHolder != null) {
                this.b = null;
                postViewHolder.myPostMyReplyPostItemMyIcon = null;
                postViewHolder.myPostMyReplyPostItemMyNickName = null;
                postViewHolder.myPostMyReplyPostItemTime = null;
                postViewHolder.myPostMyReplyPostItemReplyToWho = null;
                postViewHolder.myPostMyReplyPostItemContent = null;
                postViewHolder.myPostMyReplyPostItemTitle = null;
                postViewHolder.myPostMyReplyPostItemPostContent = null;
                postViewHolder.myPostMyReplyPostItemPostLv = null;
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
        private MypostMyReplyBean.DataBean f48c;

        public a(Context context, int i, MypostMyReplyBean.DataBean dataBean) {
            this.a = context;
            this.b = i;
            this.f48c = dataBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = this.b;
            if (i == 1) {
                com.rtk.app.tool.t.B0(this.a, this.f48c.getUid());
                return;
            }
            if (i == 2) {
                com.rtk.app.tool.t.J0(this.a, this.f48c.getPostId());
                return;
            }
            if (i != 3) {
                return;
            }
            if (this.f48c.getReplyType() == 0) {
                com.rtk.app.tool.t.G0(this.a, this.f48c.getPostId(), this.f48c.getId() + "", this.f48c.getMid());
                return;
            }
            com.rtk.app.tool.t.G0(this.a, this.f48c.getPostId(), this.f48c.getRoot_reply_id() + "", this.f48c.getMid());
        }
    }

    public FragementMyPostReplyAdapter(Context context, List<MypostMyReplyBean.DataBean> list) {
        this.e = context;
        this.f = list;
    }

    public int getItemCount() {
        return this.f.size() + 1;
    }

    public int getItemViewType(int i) {
        if (i == getItemCount() - 1) {
            return 3;
        }
        return this.f.get(i).getReplyType() == 0 ? 1 : 2;
    }

    public String l() {
        return this.g;
    }

    public void m(String str) {
        this.g = str;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 1) {
            PostViewHolder postViewHolder = (PostViewHolder) viewHolder;
            com.rtk.app.tool.t.c(this.e, this.f.get(i).getFace(), postViewHolder.myPostMyReplyPostItemMyIcon, new boolean[0]);
            postViewHolder.myPostMyReplyPostItemMyNickName.setText(this.f.get(i).getNickname());
            postViewHolder.myPostMyReplyPostItemTime.setText(this.f.get(i).getAddtime());
            postViewHolder.myPostMyReplyPostItemTitle.setText(this.f.get(i).getPostTitle());
            postViewHolder.myPostMyReplyPostItemPostContent.setText(this.f.get(i).getModuleName());
            postViewHolder.myPostMyReplyPostItemContent.setText(this.f.get(i).getReply());
            postViewHolder.myPostMyReplyPostItemMyIcon.setOnClickListener(new a(this.e, 1, this.f.get(i)));
            postViewHolder.myPostMyReplyPostItemPostLv.setOnClickListener(new a(this.e, 2, this.f.get(i)));
            ((RecyclerView.ViewHolder) postViewHolder).itemView.setOnClickListener(new a(this.e, 3, this.f.get(i)));
            if (com.rtk.app.tool.c0.q(l())) {
                postViewHolder.myPostMyReplyPostItemReplyToWho.setLeftText("我回复了 ");
                postViewHolder.myPostMyReplyPostItemReplyToWho.setRightText(" 的帖子");
                postViewHolder.myPostMyReplyPostItemReplyToWho.setText(this.f.get(i).getNickname());
                return;
            }
            postViewHolder.myPostMyReplyPostItemReplyToWho.setLeftText(l() + " 回复了");
            postViewHolder.myPostMyReplyPostItemReplyToWho.setRightText(" 的帖子");
            postViewHolder.myPostMyReplyPostItemReplyToWho.setText(this.f.get(i).getNickname());
            return;
        }
        if (itemViewType != 2) {
            if (itemViewType != 3) {
                return;
            }
            BaseRecyclerViewAdapter.RecyclerViewFootViewHolder recyclerViewFootViewHolder = (BaseRecyclerViewAdapter.RecyclerViewFootViewHolder) viewHolder;
            Boolean valueOf = Boolean.valueOf(g());
            List<MypostMyReplyBean.DataBean> list = this.f;
            recyclerViewFootViewHolder.f(valueOf, list != null ? list.size() : 0, h(), f());
            return;
        }
        CommentViewHolder commentViewHolder = (CommentViewHolder) viewHolder;
        com.rtk.app.tool.t.c(this.e, this.f.get(i).getFace(), commentViewHolder.myPostMyReplyCommentItemMyIcon, new boolean[0]);
        commentViewHolder.myPostMyReplyCommentItemMyNickName.setText(this.f.get(i).getNickname());
        commentViewHolder.myPostMyReplyCommentItemTime.setText(this.f.get(i).getAddtime());
        commentViewHolder.myPostMyReplyCommentItemTitle.setText(this.f.get(i).getPostTitle());
        commentViewHolder.myPostMyReplyCommentItemPostContent.setText(this.f.get(i).getModuleName());
        commentViewHolder.myPostMyReplyCommentItemOtherContent.setLeftText(this.f.get(i).getNickname() + "回复:");
        commentViewHolder.myPostMyReplyCommentItemOtherContent.setText(this.f.get(i).getContent());
        commentViewHolder.myPostMyReplyCommentItemMyIcon.setOnClickListener(new a(this.e, 1, this.f.get(i)));
        commentViewHolder.myPostMyReplyCommentItemPostLv.setOnClickListener(new a(this.e, 2, this.f.get(i)));
        ((RecyclerView.ViewHolder) commentViewHolder).itemView.setOnClickListener(new a(this.e, 3, this.f.get(i)));
        if (com.rtk.app.tool.c0.q(l())) {
            commentViewHolder.myPostMyReplyCommentItemMyContent.setLeftText("我回复:");
            commentViewHolder.myPostMyReplyCommentItemMyContent.setText(this.f.get(i).getReply());
            return;
        }
        commentViewHolder.myPostMyReplyCommentItemMyContent.setLeftText(l() + "回复:");
        commentViewHolder.myPostMyReplyCommentItemMyContent.setText(this.f.get(i).getReply());
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new PostViewHolder(LayoutInflater.from(this.e).inflate(R.layout.my_post_my_reply_post_item_layout, viewGroup, false));
        }
        if (i != 2) {
            return new BaseRecyclerViewAdapter.RecyclerViewFootViewHolder(LayoutInflater.from(this.e).inflate(R.layout.looding_footview, viewGroup, false));
        }
        return new CommentViewHolder(LayoutInflater.from(this.e).inflate(R.layout.my_post_my_reply_comment_item_layout, viewGroup, false));
    }
}
