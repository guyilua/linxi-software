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
import com.rtk.app.bean.MypostReplyMeBean;
import com.rtk.app.custom.CustomTextView;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FragementReplyMeReplyAdapter extends BaseRecyclerViewAdapter {
    private Context e;
    private List<MypostReplyMeBean.DataBean> f;
    private String g;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class CommentViewHolder extends RecyclerView.ViewHolder {

        @BindView
        CustomTextView myPostReplyMeCommentItemMyContent;

        @BindView
        RoundedImageView myPostReplyMeCommentItemMyIcon;

        @BindView
        TextView myPostReplyMeCommentItemMyNickName;

        @BindView
        CustomTextView myPostReplyMeCommentItemOtherContent;

        @BindView
        TextView myPostReplyMeCommentItemPostContent;

        @BindView
        LinearLayout myPostReplyMeCommentItemPostLv;

        @BindView
        TextView myPostReplyMeCommentItemTime;

        @BindView
        TextView myPostReplyMeCommentItemTitle;

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
            commentViewHolder.myPostReplyMeCommentItemMyIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.my_post_reply_me_comment_item_my_icon, "field 'myPostReplyMeCommentItemMyIcon'", RoundedImageView.class);
            commentViewHolder.myPostReplyMeCommentItemMyNickName = (TextView) butterknife.c.a.c(view, R.id.my_post_reply_me_comment_item_my_nickName, "field 'myPostReplyMeCommentItemMyNickName'", TextView.class);
            commentViewHolder.myPostReplyMeCommentItemTime = (TextView) butterknife.c.a.c(view, R.id.my_post_reply_me_comment_item_time, "field 'myPostReplyMeCommentItemTime'", TextView.class);
            commentViewHolder.myPostReplyMeCommentItemOtherContent = (CustomTextView) butterknife.c.a.c(view, R.id.my_post_reply_me_comment_item_other_content, "field 'myPostReplyMeCommentItemOtherContent'", CustomTextView.class);
            commentViewHolder.myPostReplyMeCommentItemMyContent = (CustomTextView) butterknife.c.a.c(view, R.id.my_post_reply_me_comment_item_my_content, "field 'myPostReplyMeCommentItemMyContent'", CustomTextView.class);
            commentViewHolder.myPostReplyMeCommentItemTitle = (TextView) butterknife.c.a.c(view, R.id.my_post_reply_me_comment_item_title, "field 'myPostReplyMeCommentItemTitle'", TextView.class);
            commentViewHolder.myPostReplyMeCommentItemPostContent = (TextView) butterknife.c.a.c(view, R.id.my_post_reply_me_comment_item_post_content, "field 'myPostReplyMeCommentItemPostContent'", TextView.class);
            commentViewHolder.myPostReplyMeCommentItemPostLv = (LinearLayout) butterknife.c.a.c(view, R.id.my_post_reply_me_comment_item_postLv, "field 'myPostReplyMeCommentItemPostLv'", LinearLayout.class);
        }

        @CallSuper
        public void a() {
            CommentViewHolder commentViewHolder = this.b;
            if (commentViewHolder != null) {
                this.b = null;
                commentViewHolder.myPostReplyMeCommentItemMyIcon = null;
                commentViewHolder.myPostReplyMeCommentItemMyNickName = null;
                commentViewHolder.myPostReplyMeCommentItemTime = null;
                commentViewHolder.myPostReplyMeCommentItemOtherContent = null;
                commentViewHolder.myPostReplyMeCommentItemMyContent = null;
                commentViewHolder.myPostReplyMeCommentItemTitle = null;
                commentViewHolder.myPostReplyMeCommentItemPostContent = null;
                commentViewHolder.myPostReplyMeCommentItemPostLv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class PostViewHolder extends RecyclerView.ViewHolder {

        @BindView
        TextView myPostReplyMePostItemContent;

        @BindView
        RoundedImageView myPostReplyMePostItemMyIcon;

        @BindView
        TextView myPostReplyMePostItemMyNickName;

        @BindView
        CustomTextView myPostReplyMePostItemPostContent;

        @BindView
        LinearLayout myPostReplyMePostItemPostLv;

        @BindView
        CustomTextView myPostReplyMePostItemReplyToWho;

        @BindView
        TextView myPostReplyMePostItemTime;

        @BindView
        CustomTextView myPostReplyMePostItemTitle;

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
            postViewHolder.myPostReplyMePostItemMyIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.my_post_reply_me_post_item_my_icon, "field 'myPostReplyMePostItemMyIcon'", RoundedImageView.class);
            postViewHolder.myPostReplyMePostItemMyNickName = (TextView) butterknife.c.a.c(view, R.id.my_post_reply_me_post_item_my_nickName, "field 'myPostReplyMePostItemMyNickName'", TextView.class);
            postViewHolder.myPostReplyMePostItemTime = (TextView) butterknife.c.a.c(view, R.id.my_post_reply_me_post_item_time, "field 'myPostReplyMePostItemTime'", TextView.class);
            postViewHolder.myPostReplyMePostItemReplyToWho = (CustomTextView) butterknife.c.a.c(view, R.id.my_post_reply_me_post_item_reply_to_who, "field 'myPostReplyMePostItemReplyToWho'", CustomTextView.class);
            postViewHolder.myPostReplyMePostItemContent = (TextView) butterknife.c.a.c(view, R.id.my_post_reply_me_post_item_content, "field 'myPostReplyMePostItemContent'", TextView.class);
            postViewHolder.myPostReplyMePostItemTitle = (CustomTextView) butterknife.c.a.c(view, R.id.my_post_reply_me_post_item_title, "field 'myPostReplyMePostItemTitle'", CustomTextView.class);
            postViewHolder.myPostReplyMePostItemPostContent = (CustomTextView) butterknife.c.a.c(view, R.id.my_post_reply_me_post_item_post_content, "field 'myPostReplyMePostItemPostContent'", CustomTextView.class);
            postViewHolder.myPostReplyMePostItemPostLv = (LinearLayout) butterknife.c.a.c(view, R.id.my_post_reply_me_post_item_postLv, "field 'myPostReplyMePostItemPostLv'", LinearLayout.class);
        }

        @CallSuper
        public void a() {
            PostViewHolder postViewHolder = this.b;
            if (postViewHolder != null) {
                this.b = null;
                postViewHolder.myPostReplyMePostItemMyIcon = null;
                postViewHolder.myPostReplyMePostItemMyNickName = null;
                postViewHolder.myPostReplyMePostItemTime = null;
                postViewHolder.myPostReplyMePostItemReplyToWho = null;
                postViewHolder.myPostReplyMePostItemContent = null;
                postViewHolder.myPostReplyMePostItemTitle = null;
                postViewHolder.myPostReplyMePostItemPostContent = null;
                postViewHolder.myPostReplyMePostItemPostLv = null;
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
        private MypostReplyMeBean.DataBean f49c;

        public a(Context context, int i, MypostReplyMeBean.DataBean dataBean) {
            this.a = context;
            this.b = i;
            this.f49c = dataBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = this.b;
            if (i == 1) {
                com.rtk.app.tool.t.B0(this.a, this.f49c.getUid());
                return;
            }
            if (i == 2) {
                com.rtk.app.tool.t.J0(this.a, this.f49c.getPostId());
                return;
            }
            if (i != 3) {
                return;
            }
            if (this.f49c.getReplyType() == 0) {
                com.rtk.app.tool.t.G0(this.a, this.f49c.getPostId(), this.f49c.getId() + "", this.f49c.getMid());
                return;
            }
            com.rtk.app.tool.t.G0(this.a, this.f49c.getPostId(), this.f49c.getRoot_reply_id() + "", this.f49c.getMid());
        }
    }

    public FragementReplyMeReplyAdapter(Context context, List<MypostReplyMeBean.DataBean> list) {
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
            com.rtk.app.tool.t.c(this.e, this.f.get(i).getFace(), postViewHolder.myPostReplyMePostItemMyIcon, new boolean[0]);
            postViewHolder.myPostReplyMePostItemMyNickName.setText(this.f.get(i).getNickname());
            postViewHolder.myPostReplyMePostItemTime.setText(this.f.get(i).getAddtime());
            postViewHolder.myPostReplyMePostItemContent.setText(this.f.get(i).getReply());
            postViewHolder.myPostReplyMePostItemTitle.setText(this.f.get(i).getPostTitle());
            postViewHolder.myPostReplyMePostItemPostContent.setText(this.f.get(i).getModuleName());
            postViewHolder.myPostReplyMePostItemMyIcon.setOnClickListener(new a(this.e, 1, this.f.get(i)));
            postViewHolder.myPostReplyMePostItemPostLv.setOnClickListener(new a(this.e, 2, this.f.get(i)));
            ((RecyclerView.ViewHolder) postViewHolder).itemView.setOnClickListener(new a(this.e, 3, this.f.get(i)));
            if (com.rtk.app.tool.c0.q(l())) {
                postViewHolder.myPostReplyMePostItemReplyToWho.setLeftText(this.f.get(i).getNickname() + " 回复了 ");
                postViewHolder.myPostReplyMePostItemReplyToWho.setRightText(" 的帖子");
                postViewHolder.myPostReplyMePostItemReplyToWho.setText("我");
                return;
            }
            postViewHolder.myPostReplyMePostItemReplyToWho.setLeftText(this.f.get(i).getNickname() + " 回复了 ");
            postViewHolder.myPostReplyMePostItemReplyToWho.setRightText(" 的帖子");
            postViewHolder.myPostReplyMePostItemReplyToWho.setText(l());
            return;
        }
        if (itemViewType != 2) {
            if (itemViewType != 3) {
                return;
            }
            BaseRecyclerViewAdapter.RecyclerViewFootViewHolder recyclerViewFootViewHolder = (BaseRecyclerViewAdapter.RecyclerViewFootViewHolder) viewHolder;
            Boolean valueOf = Boolean.valueOf(g());
            List<MypostReplyMeBean.DataBean> list = this.f;
            recyclerViewFootViewHolder.f(valueOf, list != null ? list.size() : 0, h(), f());
            return;
        }
        CommentViewHolder commentViewHolder = (CommentViewHolder) viewHolder;
        com.rtk.app.tool.t.c(this.e, this.f.get(i).getFace(), commentViewHolder.myPostReplyMeCommentItemMyIcon, new boolean[0]);
        commentViewHolder.myPostReplyMeCommentItemMyNickName.setText(this.f.get(i).getNickname());
        commentViewHolder.myPostReplyMeCommentItemTime.setText(this.f.get(i).getAddtime());
        commentViewHolder.myPostReplyMeCommentItemTitle.setText(this.f.get(i).getPostTitle());
        commentViewHolder.myPostReplyMeCommentItemPostContent.setText(this.f.get(i).getModuleName());
        commentViewHolder.myPostReplyMeCommentItemMyIcon.setOnClickListener(new a(this.e, 1, this.f.get(i)));
        commentViewHolder.myPostReplyMeCommentItemPostLv.setOnClickListener(new a(this.e, 2, this.f.get(i)));
        ((RecyclerView.ViewHolder) commentViewHolder).itemView.setOnClickListener(new a(this.e, 3, this.f.get(i)));
        if (com.rtk.app.tool.c0.q(l())) {
            commentViewHolder.myPostReplyMeCommentItemOtherContent.setLeftText("我回复:");
        } else {
            commentViewHolder.myPostReplyMeCommentItemOtherContent.setLeftText(l() + "回复:");
        }
        commentViewHolder.myPostReplyMeCommentItemOtherContent.setText(this.f.get(i).getContent());
        commentViewHolder.myPostReplyMeCommentItemMyContent.setLeftText(this.f.get(i).getNickname() + "回复:");
        commentViewHolder.myPostReplyMeCommentItemMyContent.setText(this.f.get(i).getReply());
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new PostViewHolder(LayoutInflater.from(this.e).inflate(R.layout.my_post_reply_me_post_item_layout, viewGroup, false));
        }
        if (i != 2) {
            return new BaseRecyclerViewAdapter.RecyclerViewFootViewHolder(LayoutInflater.from(this.e).inflate(R.layout.looding_footview, viewGroup, false));
        }
        return new CommentViewHolder(LayoutInflater.from(this.e).inflate(R.layout.my_post_reply_me_comment_item_layout, viewGroup, false));
    }
}
