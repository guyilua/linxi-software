package com.rtk.app.main.HomeCommunityPack.PostAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.GsonBuilder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.base.BaseRecyclerViewAdapter;
import com.rtk.app.bean.PostCommentDetailsBean;
import com.rtk.app.bean.PostCommentUpBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsHolderClass.a;
import com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsRecyclerViewAdapter;
import com.rtk.app.main.comment.express.c;
import com.rtk.app.main.dialogPack.DialogPostCommentMore;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.f;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.d;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostCommentDetailsAdapter extends BaseRecyclerViewAdapter {
    private Context e;
    private PostCommentDetailsBean f;
    private String g;
    private String h;
    private String i;
    private int j;
    private String k;
    private PostDetailsRecyclerViewAdapter.a l;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class SecondCommentHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Context a;
        private PostCommentDetailsBean.DataBean.CommentBean b;

        /* renamed from: c, reason: collision with root package name */
        private String f189c;
        private String d;
        private String e;
        private int f;
        private String g;
        private PostDetailsRecyclerViewAdapter.a h;

        @BindView
        TextView postCommentDetailsCommentBtu;

        @BindView
        ImageView postCommentDetailsCommentMore;

        @BindView
        TextView postCommentDetailsSecondFloor;

        @BindView
        TextView postCommentDetailsSecondPhoneBrand;

        @BindView
        LinearLayout postCommentDetailsSecondReplyContentLv;

        @BindView
        RoundedImageView postCommentDetailsSecondReplyIcon;

        @BindView
        TextView postCommentDetailsSecondReplyMaster;

        @BindView
        CustomTextView postCommentDetailsSecondReplyNickName;

        @BindView
        TextView postCommentDetailsSecondReplyTime;

        public SecondCommentHolder(View view, Context context, String str, String str2, PostDetailsRecyclerViewAdapter.a aVar, int i, String str3, String str4) {
            super(view);
            ButterKnife.b(this, view);
            this.a = context;
            this.g = str4;
            this.e = str3;
            this.f = i;
            this.f189c = str;
            this.d = str2;
            this.h = aVar;
            c.g();
        }

        public void b(PostCommentDetailsBean.DataBean.CommentBean commentBean) {
            this.b = commentBean;
            t.c(this.a, commentBean.getU_face(), this.postCommentDetailsSecondReplyIcon, new boolean[0]);
            if (commentBean.getReply_id() != commentBean.getRoot_reply_id()) {
                this.postCommentDetailsSecondReplyNickName.setLeftText(commentBean.getU_name());
                this.postCommentDetailsSecondReplyNickName.setRightText(commentBean.getHisName());
                this.postCommentDetailsSecondReplyNickName.setText(" 回复" + commentBean.getHisFloor() + "层的 ");
            } else {
                this.postCommentDetailsSecondReplyNickName.setLeftText("");
                this.postCommentDetailsSecondReplyNickName.setRightText("");
                this.postCommentDetailsSecondReplyNickName.setText(commentBean.getU_name());
            }
            this.postCommentDetailsSecondFloor.setText(commentBean.getFloor() + "层");
            this.postCommentDetailsSecondReplyTime.setText(commentBean.getTime());
            this.postCommentDetailsSecondPhoneBrand.setText(commentBean.getClient());
            this.postCommentDetailsCommentBtu.setOnClickListener(this);
            this.postCommentDetailsCommentMore.setOnClickListener(this);
            this.postCommentDetailsSecondReplyIcon.setOnClickListener(this);
            this.postCommentDetailsSecondReplyContentLv.removeAllViews();
            commentBean.getContent();
            try {
                if (!c0.q(commentBean.getDisplay_mode()) && !commentBean.getDisplay_mode().endsWith("2")) {
                    this.postCommentDetailsSecondReplyContentLv.removeAllViews();
                    this.postCommentDetailsSecondReplyContentLv.addView(a.g(this.a));
                    return;
                }
            } catch (NullPointerException unused) {
            }
            a.p(this.a, this.postCommentDetailsSecondReplyContentLv, commentBean.getContent(), commentBean.getList_post_user(), commentBean.getList_post_post(), commentBean.getList_post_upfile(), commentBean.getList_post_game(), commentBean.getList_post_img());
            TextView textView = this.postCommentDetailsSecondReplyMaster;
            String str = this.g;
            StringBuilder sb = new StringBuilder();
            sb.append(commentBean.getUid());
            sb.append("");
            textView.setVisibility(str.equals(sb.toString()) ? 0 : 8);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.post_comment_details_comment_btu /* 2131299767 */:
                    if (!this.e.endsWith("0")) {
                        f.a(this.a, "暂时无法评论", f.a.f);
                        return;
                    }
                    t.M0(this.a, this.d, this.f189c, this.b.getRoot_reply_id() + "", this.b.getCmtid() + "", this.b.getUid() + "", 0, 0);
                    return;
                case R.id.post_comment_details_comment_more /* 2131299768 */:
                    new DialogPostCommentMore(this.a, this.f189c, this.d, this.b.getIs_owner(), this.f, this.b.getCmtid(), this.h, this.b.getRoot_reply_id() + "", this.b.getCmtid() + "", this.b.getUid() + "", false, this.e).show();
                    return;
                case R.id.post_comment_details_second_reply_icon /* 2131299781 */:
                    t.B0(this.a, this.b.getUid() + "");
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class SecondCommentHolder_ViewBinding implements Unbinder {
        private SecondCommentHolder b;

        @UiThread
        public SecondCommentHolder_ViewBinding(SecondCommentHolder secondCommentHolder, View view) {
            this.b = secondCommentHolder;
            secondCommentHolder.postCommentDetailsSecondReplyIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.post_comment_details_second_reply_icon, "field 'postCommentDetailsSecondReplyIcon'", RoundedImageView.class);
            secondCommentHolder.postCommentDetailsSecondReplyNickName = (CustomTextView) butterknife.c.a.c(view, R.id.post_comment_details_second_reply_nickName, "field 'postCommentDetailsSecondReplyNickName'", CustomTextView.class);
            secondCommentHolder.postCommentDetailsSecondReplyTime = (TextView) butterknife.c.a.c(view, R.id.post_comment_details_second_reply_time, "field 'postCommentDetailsSecondReplyTime'", TextView.class);
            secondCommentHolder.postCommentDetailsSecondReplyContentLv = (LinearLayout) butterknife.c.a.c(view, R.id.post_comment_details_second_reply_content_lv, "field 'postCommentDetailsSecondReplyContentLv'", LinearLayout.class);
            secondCommentHolder.postCommentDetailsCommentBtu = (TextView) butterknife.c.a.c(view, R.id.post_comment_details_comment_btu, "field 'postCommentDetailsCommentBtu'", TextView.class);
            secondCommentHolder.postCommentDetailsSecondReplyMaster = (TextView) butterknife.c.a.c(view, R.id.post_comment_details_second_reply_master, "field 'postCommentDetailsSecondReplyMaster'", TextView.class);
            secondCommentHolder.postCommentDetailsSecondPhoneBrand = (TextView) butterknife.c.a.c(view, R.id.post_comment_details_second_phoneBrand, "field 'postCommentDetailsSecondPhoneBrand'", TextView.class);
            secondCommentHolder.postCommentDetailsSecondFloor = (TextView) butterknife.c.a.c(view, R.id.post_comment_details_second_floor, "field 'postCommentDetailsSecondFloor'", TextView.class);
            secondCommentHolder.postCommentDetailsCommentMore = (ImageView) butterknife.c.a.c(view, R.id.post_comment_details_comment_more, "field 'postCommentDetailsCommentMore'", ImageView.class);
        }

        @CallSuper
        public void a() {
            SecondCommentHolder secondCommentHolder = this.b;
            if (secondCommentHolder != null) {
                this.b = null;
                secondCommentHolder.postCommentDetailsSecondReplyIcon = null;
                secondCommentHolder.postCommentDetailsSecondReplyNickName = null;
                secondCommentHolder.postCommentDetailsSecondReplyTime = null;
                secondCommentHolder.postCommentDetailsSecondReplyContentLv = null;
                secondCommentHolder.postCommentDetailsCommentBtu = null;
                secondCommentHolder.postCommentDetailsSecondReplyMaster = null;
                secondCommentHolder.postCommentDetailsSecondPhoneBrand = null;
                secondCommentHolder.postCommentDetailsSecondFloor = null;
                secondCommentHolder.postCommentDetailsCommentMore = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class TopHolder extends RecyclerView.ViewHolder implements View.OnClickListener, h.j {
        private Context a;
        private PostCommentDetailsBean b;

        /* renamed from: c, reason: collision with root package name */
        private String f190c;
        private String d;

        @BindView
        TextView postCommentDetailsCommentNum;

        @BindView
        LinearLayout postCommentDetailsContentLv;

        @BindView
        RoundedImageView postCommentDetailsIcon;

        @BindView
        TextView postCommentDetailsMaster;

        @BindView
        LinearLayout postCommentDetailsMedal;

        @BindView
        TextView postCommentDetailsNickName;

        @BindView
        TextView postCommentDetailsPhoneBrand;

        @BindView
        TextView postCommentDetailsReplyBtu;

        @BindView
        TextView postCommentDetailsTime;

        @BindView
        TextView postCommentDetailsTopPostTitle;

        @BindView
        CheckBox postCommentDetailsUp;

        TopHolder(View view, Context context, String str, String str2) {
            super(view);
            ButterKnife.b(this, view);
            this.a = context;
            this.f190c = str;
            this.d = str2;
        }

        private void b() {
            try {
                if (!c0.q(this.b.getData().getDisplay_mode()) && !this.b.getData().getDisplay_mode().endsWith("2")) {
                    this.postCommentDetailsContentLv.removeAllViews();
                    this.postCommentDetailsContentLv.addView(a.g(this.a));
                    return;
                }
            } catch (NullPointerException unused) {
            }
            a.o(this.a, this.postCommentDetailsContentLv, this.b.getData().getContent(), this.b.getData().getList_post_user(), this.b.getData().getList_post_post(), this.b.getData().getList_post_upfile(), this.b.getData().getList_post_game(), this.b.getData().getList_post_img(), this.b.getData().getList_post_video());
        }

        public void c(PostCommentDetailsBean postCommentDetailsBean) {
            this.b = postCommentDetailsBean;
            t.c(this.a, postCommentDetailsBean.getData().getU_face(), this.postCommentDetailsIcon, new boolean[0]);
            this.postCommentDetailsNickName.setText(postCommentDetailsBean.getData().getU_name());
            this.postCommentDetailsTime.setText(postCommentDetailsBean.getData().getTime());
            this.postCommentDetailsUp.setText(postCommentDetailsBean.getData().getDu() + "");
            this.postCommentDetailsPhoneBrand.setText(postCommentDetailsBean.getData().getClient());
            this.postCommentDetailsUp.setChecked(postCommentDetailsBean.getData().getIsdu() == 1);
            this.postCommentDetailsCommentNum.setText("全部回复(" + postCommentDetailsBean.getData().getCommentNum() + ")");
            t.U1(this.postCommentDetailsTopPostTitle, postCommentDetailsBean.getData().getPostsInfo().getTitle(), postCommentDetailsBean.getData().getPostsInfo().getPost_title());
            try {
                b();
            } catch (Exception unused) {
                c0.u("TopHolder", "异常");
            }
            this.postCommentDetailsIcon.setOnClickListener(this);
            this.postCommentDetailsUp.setOnClickListener(this);
            this.postCommentDetailsReplyBtu.setOnClickListener(this);
            this.postCommentDetailsTopPostTitle.setOnClickListener(this);
            TextView textView = this.postCommentDetailsMaster;
            String uid = postCommentDetailsBean.getData().getPostsInfo().getUid();
            StringBuilder sb = new StringBuilder();
            sb.append(postCommentDetailsBean.getData().getUid());
            sb.append("");
            textView.setVisibility(uid.equals(sb.toString()) ? 0 : 8);
            t.p1(this.a, this.postCommentDetailsMedal, postCommentDetailsBean.getData().getMedalList().getAchievement(), postCommentDetailsBean.getData().getMedalList().getEventMedal());
        }

        @Override // com.rtk.app.tool.o.h.j
        public void d(String str, int i) {
            if (i != 1) {
                return;
            }
            c0.u("TopHolder", "点赞" + str);
            PostCommentUpBean postCommentUpBean = (PostCommentUpBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, PostCommentUpBean.class);
            this.postCommentDetailsUp.setText(postCommentUpBean.getData().getDu() + "");
            this.postCommentDetailsUp.setChecked(postCommentUpBean.getData().getIsdu() == 1);
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt("cmid", postCommentUpBean.getData().getCmtid());
            bundle.putInt("up", postCommentUpBean.getData().getIsdu());
            bundle.putInt(d.W, postCommentUpBean.getData().getDu());
            intent.putExtras(bundle);
            ((Activity) this.a).setResult(1, intent);
        }

        @Override // com.rtk.app.tool.o.h.j
        public void g(int i, String str, int i2) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.post_comment_details_icon /* 2131299770 */:
                    t.B0(this.a, this.b.getData().getUid() + "");
                    return;
                case R.id.post_comment_details_reply_btu /* 2131299777 */:
                    t.M0(this.a, this.f190c, this.d, this.b.getData().getCmtid() + "", this.b.getData().getCmtid() + "", this.b.getData().getUid() + "", 0, 0);
                    return;
                case R.id.post_comment_details_top_postTitle /* 2131299791 */:
                    t.J0(this.a, this.d);
                    return;
                case R.id.post_comment_details_up /* 2131299792 */:
                    if (!y.x(this.a)) {
                        t.w0(this.a);
                        com.rtk.app.tool.f.a(this.a, "请先登录", f.a.f);
                        this.postCommentDetailsUp.setChecked(false);
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("members/postsCommentLikes");
                    sb.append(y.u(this.a));
                    sb.append("&cmtid=");
                    sb.append(this.b.getData().getCmtid());
                    sb.append("&uid=");
                    sb.append(y.K());
                    sb.append("&token=");
                    sb.append(y.H());
                    sb.append("&key=");
                    sb.append(t.c0(c0.e(y.v(this.a, "cmtid=" + this.b.getData().getCmtid(), "uid=" + y.K(), "token=" + y.H()))));
                    String sb2 = sb.toString();
                    h.l(this.a, this, 1, h.h(new String[0]).a(sb2));
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("评论点赞");
                    sb3.append(y.d);
                    sb3.append(sb2);
                    c0.u("TopHolder", sb3.toString());
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class TopHolder_ViewBinding implements Unbinder {
        private TopHolder b;

        @UiThread
        public TopHolder_ViewBinding(TopHolder topHolder, View view) {
            this.b = topHolder;
            topHolder.postCommentDetailsContentLv = (LinearLayout) butterknife.c.a.c(view, R.id.post_comment_details_content_lv, "field 'postCommentDetailsContentLv'", LinearLayout.class);
            topHolder.postCommentDetailsTopPostTitle = (TextView) butterknife.c.a.c(view, R.id.post_comment_details_top_postTitle, "field 'postCommentDetailsTopPostTitle'", TextView.class);
            topHolder.postCommentDetailsMaster = (TextView) butterknife.c.a.c(view, R.id.post_comment_details_master, "field 'postCommentDetailsMaster'", TextView.class);
            topHolder.postCommentDetailsMedal = (LinearLayout) butterknife.c.a.c(view, R.id.post_comment_details_medal, "field 'postCommentDetailsMedal'", LinearLayout.class);
            topHolder.postCommentDetailsIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.post_comment_details_icon, "field 'postCommentDetailsIcon'", RoundedImageView.class);
            topHolder.postCommentDetailsNickName = (TextView) butterknife.c.a.c(view, R.id.post_comment_details_nickName, "field 'postCommentDetailsNickName'", TextView.class);
            topHolder.postCommentDetailsTime = (TextView) butterknife.c.a.c(view, R.id.post_comment_details_time, "field 'postCommentDetailsTime'", TextView.class);
            topHolder.postCommentDetailsUp = (CheckBox) butterknife.c.a.c(view, R.id.post_comment_details_up, "field 'postCommentDetailsUp'", CheckBox.class);
            topHolder.postCommentDetailsReplyBtu = (TextView) butterknife.c.a.c(view, R.id.post_comment_details_reply_btu, "field 'postCommentDetailsReplyBtu'", TextView.class);
            topHolder.postCommentDetailsCommentNum = (TextView) butterknife.c.a.c(view, R.id.post_comment_details_commentNum, "field 'postCommentDetailsCommentNum'", TextView.class);
            topHolder.postCommentDetailsPhoneBrand = (TextView) butterknife.c.a.c(view, R.id.post_comment_details_phoneBrand, "field 'postCommentDetailsPhoneBrand'", TextView.class);
        }

        @CallSuper
        public void a() {
            TopHolder topHolder = this.b;
            if (topHolder != null) {
                this.b = null;
                topHolder.postCommentDetailsContentLv = null;
                topHolder.postCommentDetailsTopPostTitle = null;
                topHolder.postCommentDetailsMaster = null;
                topHolder.postCommentDetailsMedal = null;
                topHolder.postCommentDetailsIcon = null;
                topHolder.postCommentDetailsNickName = null;
                topHolder.postCommentDetailsTime = null;
                topHolder.postCommentDetailsUp = null;
                topHolder.postCommentDetailsReplyBtu = null;
                topHolder.postCommentDetailsCommentNum = null;
                topHolder.postCommentDetailsPhoneBrand = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public PostCommentDetailsAdapter(Context context, PostCommentDetailsBean postCommentDetailsBean, String str, String str2, PostDetailsRecyclerViewAdapter.a aVar, int i, String str3) {
        this.e = context;
        this.i = str3;
        this.f = postCommentDetailsBean;
        this.g = str;
        this.h = str2;
        this.j = i;
        this.l = aVar;
        this.k = postCommentDetailsBean.getData().getPostsInfo().getUid();
    }

    public int getItemCount() {
        return this.f.getData().getComment().size() + 2;
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        return i == getItemCount() - 1 ? 3 : 1;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            ((TopHolder) viewHolder).c(this.f);
        } else if (itemViewType == 1) {
            ((SecondCommentHolder) viewHolder).b(this.f.getData().getComment().get(i - 1));
        } else {
            if (itemViewType != 3) {
                return;
            }
            ((BaseRecyclerViewAdapter.RecyclerViewFootViewHolder) viewHolder).f(Boolean.valueOf(g()), this.f.getData().getComment() == null ? 0 : this.f.getData().getComment().size(), h(), f());
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder topHolder;
        if (i == 0) {
            topHolder = new TopHolder(LayoutInflater.from(this.e).inflate(R.layout.post_comment_details_top_layout, viewGroup, false), this.e, this.h, this.g);
        } else {
            if (i != 3) {
                return new SecondCommentHolder(LayoutInflater.from(this.e).inflate(R.layout.post_comment_details_comment_layout, viewGroup, false), this.e, this.g, this.h, this.l, this.j, this.i, this.k);
            }
            topHolder = new BaseRecyclerViewAdapter.RecyclerViewFootViewHolder(LayoutInflater.from(this.e).inflate(R.layout.looding_footview, viewGroup, false));
        }
        return topHolder;
    }
}
