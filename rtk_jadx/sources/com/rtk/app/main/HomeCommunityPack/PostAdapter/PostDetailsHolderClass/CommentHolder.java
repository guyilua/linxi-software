package com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsHolderClass;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.GsonBuilder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.bean.PostCommentUpBean;
import com.rtk.app.bean.PostDetailsCommentBean;
import com.rtk.app.bean.ReplyBean;
import com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsRecyclerViewAdapter;
import com.rtk.app.main.comment.express.c;
import com.rtk.app.main.dialogPack.DialogPostCommentMore;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.f;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CommentHolder extends RecyclerView.ViewHolder implements View.OnClickListener, h.j {
    private c a;
    private View b;

    /* renamed from: c, reason: collision with root package name */
    private Context f191c;
    private PostDetailsCommentBean.DataBean.ReplyListBean d;
    private PostDetailsRecyclerViewAdapter.a e;
    private String f;
    private String g;
    private String h;
    private int i;
    private int j;
    private int k;
    private String l;

    @BindView
    TextView postDetailsRecyclerViewItemCommentComment;

    @BindView
    ImageView postDetailsRecyclerViewItemCommentMore;

    @BindView
    LinearLayout postDetailsRecyclerViewItemCommentSecondCommentLv;

    @BindView
    CheckBox postDetailsRecyclerViewItemCommentUp;

    @BindView
    LinearLayout testPostAdapterItemLv;

    @BindView
    TextView testPostFloor;

    @BindView
    RoundedImageView testPostUserIcon;

    @BindView
    TextView testPostUserIsMaster;

    @BindView
    TextView testPostUserLever;

    @BindView
    LinearLayout testPostUserMedal;

    @BindView
    TextView testPostUserNickName;

    @BindView
    TextView testPostUserTime;

    public CommentHolder(View view) {
        super(view);
        this.b = view;
        ButterKnife.b(this, view);
    }

    private void c() {
        this.b.setOnClickListener(this);
    }

    public void b(Context context, String str, String str2, String str3, PostDetailsCommentBean.DataBean.ReplyListBean replyListBean, PostDetailsRecyclerViewAdapter.a aVar, int i, String str4, int i2, int i3) {
        this.d = replyListBean;
        this.k = i3;
        this.l = str3;
        this.j = i2;
        this.e = aVar;
        this.f191c = context;
        this.h = str4;
        this.f = str;
        this.g = str2;
        this.i = i;
        try {
            e();
        } catch (Exception unused) {
            c0.u("CommentHolder", "initView()异常");
        }
        c();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i != 1) {
            return;
        }
        PostCommentUpBean postCommentUpBean = (PostCommentUpBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, PostCommentUpBean.class);
        this.d.setDu(postCommentUpBean.getData().getDu());
        this.d.setIsdu(postCommentUpBean.getData().getIsdu());
        this.postDetailsRecyclerViewItemCommentUp.setText(this.d.getDu() + "");
        this.postDetailsRecyclerViewItemCommentUp.setChecked(this.d.getIsdu() == 1);
    }

    public void e() {
        this.testPostAdapterItemLv.removeAllViews();
        t.c(this.f191c, this.d.getU_face(), this.testPostUserIcon, new boolean[0]);
        this.testPostUserNickName.setText(this.d.getU_name());
        this.testPostUserTime.setText(this.d.getTime());
        t.T1(this.testPostUserLever, "", this.d.getUser_title(), 5, 5);
        this.testPostFloor.setText(this.d.getFloor() + "楼");
        f(this.f191c, this.d.getReply());
        this.postDetailsRecyclerViewItemCommentUp.setText(this.d.getDu() + "");
        this.postDetailsRecyclerViewItemCommentUp.setChecked(this.d.getIsdu() == 1);
        this.postDetailsRecyclerViewItemCommentUp.setOnClickListener(this);
        this.postDetailsRecyclerViewItemCommentMore.setOnClickListener(this);
        this.postDetailsRecyclerViewItemCommentComment.setOnClickListener(this);
        this.postDetailsRecyclerViewItemCommentComment.setText(this.d.getReplyNum() + "");
        this.testPostUserIcon.setOnClickListener(this);
        t.p1(this.f191c, this.testPostUserMedal, this.d.getMedalList().getAchievement(), this.d.getMedalList().getEventMedal());
        try {
            if (!c0.q(this.d.getDisplay_mode()) && !this.d.getDisplay_mode().endsWith("2")) {
                this.testPostAdapterItemLv.removeAllViews();
                this.testPostAdapterItemLv.addView(a.g(this.f191c));
                return;
            }
        } catch (NullPointerException unused) {
        }
        a.p(this.f191c, this.testPostAdapterItemLv, this.d.getContent(), this.d.getList_post_user(), this.d.getList_post_post(), this.d.getList_post_upfile(), this.d.getList_post_game(), this.d.getList_post_img());
        if (this.l.equals(this.d.getUid() + "")) {
            this.testPostUserIsMaster.setVisibility(0);
        } else {
            this.testPostUserIsMaster.setVisibility(8);
        }
    }

    public void f(Context context, List<ReplyBean> list) {
        this.a = c.g();
        int i = 0;
        if (list.size() > 0) {
            this.postDetailsRecyclerViewItemCommentSecondCommentLv.setVisibility(0);
        } else {
            this.postDetailsRecyclerViewItemCommentSecondCommentLv.setVisibility(8);
        }
        this.postDetailsRecyclerViewItemCommentSecondCommentLv.removeAllViews();
        for (ReplyBean replyBean : list) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.post_details_recycler_view_reply_item_layout, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.post_details_recycler_view_reply_item_nickName);
            TextView textView2 = (TextView) inflate.findViewById(R.id.post_details_recycler_view_reply_item_content);
            textView2.setSingleLine(true);
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView.setText(replyBean.getU_name() + ":");
            textView2.setText(this.a.a(replyBean.getContent()));
            this.postDetailsRecyclerViewItemCommentSecondCommentLv.addView(inflate);
            i++;
            if (i >= 2) {
                TextView textView3 = (TextView) LayoutInflater.from(context).inflate(R.layout.post_details_recycler_view_reply_all_textview_item_layout, (ViewGroup) null);
                textView3.setText("全部" + this.d.getReplyNum() + "条回复");
                this.postDetailsRecyclerViewItemCommentSecondCommentLv.addView(textView3);
                return;
            }
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != 2131300385) {
            switch (id) {
                case R.id.post_details_recyclerView_item_comment_comment /* 2131299809 */:
                    if (!this.h.endsWith("0")) {
                        f.a(this.f191c, "本帖已关闭回复", f.a.f);
                        return;
                    }
                    t.M0(this.f191c, this.g, this.f, this.d.getCmtid() + "", this.d.getCmtid() + "", this.d.getUid() + "", this.j, this.k);
                    return;
                case R.id.post_details_recyclerView_item_comment_more /* 2131299810 */:
                    new DialogPostCommentMore(this.f191c, this.f, this.g, this.d.getIs_owner(), this.i, this.d.getCmtid(), this.e, this.d.getCmtid() + "", this.d.getCmtid() + "", this.d.getUid() + "", true, this.h).show();
                    return;
                case R.id.post_details_recyclerView_item_comment_up /* 2131299811 */:
                    if (!y.x(this.f191c)) {
                        t.w0(this.f191c);
                        this.postDetailsRecyclerViewItemCommentUp.setChecked(false);
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("members/postsCommentLikes");
                    sb.append(y.u(this.f191c));
                    sb.append("&cmtid=");
                    sb.append(this.d.getCmtid());
                    sb.append("&uid=");
                    sb.append(y.K());
                    sb.append("&token=");
                    sb.append(y.H());
                    sb.append("&key=");
                    sb.append(t.c0(c0.e(y.v(this.f191c, "cmtid=" + this.d.getCmtid(), "uid=" + y.K(), "token=" + y.H()))));
                    h.l(this.f191c, this, 1, h.h(new String[0]).a(sb.toString()));
                    return;
                default:
                    c0.u("CommentHolder", "点击的Cmid" + this.d.getCmtid());
                    t.G0(this.f191c, this.f, this.d.getCmtid() + "", this.g);
                    return;
            }
        }
        t.B0(this.f191c, this.d.getUid() + "");
    }
}
