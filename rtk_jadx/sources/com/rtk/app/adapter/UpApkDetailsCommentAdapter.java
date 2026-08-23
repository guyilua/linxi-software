package com.rtk.app.adapter;

import android.content.Context;
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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.adapter.UpApkDetailsCommentAdapter;
import com.rtk.app.base.BaseRecyclerViewAdapter;
import com.rtk.app.bean.DuOrUpBean;
import com.rtk.app.bean.ResponseDataBean;
import com.rtk.app.bean.UpApkCommentBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.dialogPack.DialogForGameCommentDeleteReason;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import com.zhy.view.flowlayout.FlowLayout;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpApkDetailsCommentAdapter extends BaseRecyclerViewAdapter {
    private com.rtk.app.main.comment.express.c e = com.rtk.app.main.comment.express.c.g();
    private Context f;
    private ApkInfo g;
    private List<UpApkCommentBean.DataBean> h;
    private int i;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class CommentHolder extends RecyclerView.ViewHolder implements View.OnClickListener, h.j {
        private View a;
        private Context b;

        /* renamed from: c, reason: collision with root package name */
        private ApkInfo f113c;
        private UpApkCommentBean.DataBean d;
        private int e;
        private DialogForProgressTip f;

        @BindView
        LinearLayout upApkDetailItem2CommentItemAddLy;

        @BindView
        TextView upApkDetailItem2CommentItemCommentBtu;

        @BindView
        TextView upApkDetailItem2CommentItemContent;

        @BindView
        TextView upApkDetailItem2CommentItemDelete;

        @BindView
        CheckBox upApkDetailItem2CommentItemDuTv;

        @BindView
        TextView upApkDetailItem2CommentItemFloor;

        @BindView
        FlowLayout upApkDetailItem2CommentItemFlowLayout;

        @BindView
        RoundedImageView upApkDetailItem2CommentItemImg;

        @BindView
        TextView upApkDetailItem2CommentItemIsUpMain;

        @BindView
        LinearLayout upApkDetailItem2CommentItemMedal;

        @BindView
        TextView upApkDetailItem2CommentItemName;

        @BindView
        ImageView upApkDetailItem2CommentItemStart;

        @BindView
        TextView upApkDetailItem2CommentItemTime;

        @BindView
        TextView upApkDetailItem2CommentItemUserTitle;

        @BindView
        TextView upApkDetailItem2CommentItemUuTv;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        class a implements com.rtk.app.tool.s {
            a() {
            }

            @Override // com.rtk.app.tool.s
            public void a(String... strArr) {
                String str = strArr[0];
                Context context = CommentHolder.this.b;
                CommentHolder commentHolder = CommentHolder.this;
                com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e);
                StringBuilder sb = new StringBuilder();
                sb.append("up/comment/delete");
                sb.append(com.rtk.app.tool.y.u(CommentHolder.this.b));
                sb.append("&uid=");
                sb.append(com.rtk.app.tool.y.K());
                sb.append("&token=");
                sb.append(com.rtk.app.tool.y.H());
                sb.append("&cid=");
                sb.append(((UpApkCommentBean.DataBean) UpApkDetailsCommentAdapter.this.h.get(CommentHolder.this.e)).getCmtid());
                sb.append("&table=up&msg=");
                sb.append(str);
                sb.append("&key=");
                sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(CommentHolder.this.b, "cid=" + ((UpApkCommentBean.DataBean) UpApkDetailsCommentAdapter.this.h.get(CommentHolder.this.e)).getCmtid(), "table=up", "msg=" + str, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
                com.rtk.app.tool.o.h.l(context, commentHolder, 3, h.a(sb.toString()));
                CommentHolder.this.f = new DialogForProgressTip(CommentHolder.this.b, "删除中，请稍后...");
                CommentHolder.this.f.show();
            }
        }

        CommentHolder(View view) {
            super(view);
            ButterKnife.b(this, view);
            this.a = view;
        }

        private void h(FlowLayout flowLayout, List<String> list) {
            flowLayout.removeAllViews();
            if (list == null || list.size() < 0) {
                return;
            }
            for (final int i = 0; i < list.size(); i++) {
                View inflate = LayoutInflater.from(this.b).inflate(R.layout.just_image_view_layout, (ViewGroup) flowLayout, false);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.just_imageView);
                flowLayout.addView(inflate);
                com.rtk.app.tool.t.c(this.b, list.get(i), imageView, new boolean[0]);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.i2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        UpApkDetailsCommentAdapter.CommentHolder.this.j(i, view);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void j(int i, View view) {
            com.rtk.app.tool.t.C0(this.b, ((UpApkCommentBean.DataBean) UpApkDetailsCommentAdapter.this.h.get(this.e)).getPic(), i);
        }

        @Override // com.rtk.app.tool.o.h.j
        public void d(String str, int i) {
            com.rtk.app.tool.c0.u("UpApkDetailsCommentAdapter", "点赞或者踩mark " + i + "   " + str);
            Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
            if (i == 1) {
                DuOrUpBean duOrUpBean = (DuOrUpBean) create.fromJson(str, DuOrUpBean.class);
                ((UpApkCommentBean.DataBean) UpApkDetailsCommentAdapter.this.h.get(this.e)).setIsdu(((UpApkCommentBean.DataBean) UpApkDetailsCommentAdapter.this.h.get(this.e)).getDu() > duOrUpBean.getData().getDu() ? 0 : 1);
                ((UpApkCommentBean.DataBean) UpApkDetailsCommentAdapter.this.h.get(this.e)).setDu(duOrUpBean.getData().getDu());
                ((UpApkCommentBean.DataBean) UpApkDetailsCommentAdapter.this.h.get(this.e)).setUu(duOrUpBean.getData().getUu());
                UpApkDetailsCommentAdapter.this.notifyDataSetChanged();
                return;
            }
            if (i == 2) {
                DuOrUpBean duOrUpBean2 = (DuOrUpBean) create.fromJson(str, DuOrUpBean.class);
                ((UpApkCommentBean.DataBean) UpApkDetailsCommentAdapter.this.h.get(this.e)).setDu(duOrUpBean2.getData().getDu());
                ((UpApkCommentBean.DataBean) UpApkDetailsCommentAdapter.this.h.get(this.e)).setUu(duOrUpBean2.getData().getUu());
                UpApkDetailsCommentAdapter.this.notifyDataSetChanged();
                return;
            }
            if (i != 3) {
                return;
            }
            DialogForProgressTip dialogForProgressTip = this.f;
            if (dialogForProgressTip != null) {
                dialogForProgressTip.dismiss();
            }
            UpApkDetailsCommentAdapter.this.h.remove(this.e);
            com.rtk.app.tool.f.a(this.b, ((ResponseDataBean) create.fromJson(str, ResponseDataBean.class)).getMsg(), f.a.f);
            UpApkDetailsCommentAdapter.this.notifyDataSetChanged();
        }

        @Override // com.rtk.app.tool.o.h.j
        public void g(int i, String str, int i2) {
            if (i2 != 3) {
                return;
            }
            DialogForProgressTip dialogForProgressTip = this.f;
            if (dialogForProgressTip != null) {
                dialogForProgressTip.dismiss();
            }
            com.rtk.app.tool.f.a(this.b, str, f.a.f);
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [com.rtk.app.custom.CustomTextView, android.widget.TextView] */
        public void k(com.rtk.app.main.comment.express.c cVar, Context context, UpApkCommentBean.DataBean dataBean, ApkInfo apkInfo, int i) {
            this.b = context;
            this.e = i;
            this.f113c = apkInfo;
            this.d = dataBean;
            com.rtk.app.tool.t.c(context, dataBean.getU_face(), this.upApkDetailItem2CommentItemImg, new boolean[0]);
            this.upApkDetailItem2CommentItemName.setText(dataBean.getU_name());
            this.upApkDetailItem2CommentItemFloor.setText(dataBean.getFloor() + "楼");
            if (!dataBean.getContent().isEmpty()) {
                this.upApkDetailItem2CommentItemContent.setText(com.rtk.app.main.comment.express.c.g().a(dataBean.getContent()));
            }
            this.upApkDetailItem2CommentItemTime.setText(dataBean.getTime());
            this.upApkDetailItem2CommentItemDuTv.setText(dataBean.getDu() + "");
            this.upApkDetailItem2CommentItemUuTv.setText(dataBean.getUu() + "");
            this.upApkDetailItem2CommentItemDuTv.setChecked(dataBean.getIsdu() != 0);
            this.upApkDetailItem2CommentItemAddLy.removeAllViews();
            if (dataBean.getReply() != null && dataBean.getReply().size() > 0) {
                for (int i2 = 0; i2 < dataBean.getReply().size(); i2++) {
                    UpApkCommentBean.DataBean.ReplyBean replyBean = dataBean.getReply().get(i2);
                    View inflate = LayoutInflater.from(context).inflate(R.layout.up_apk_details_second_view_layout, (ViewGroup) null);
                    ?? r4 = (CustomTextView) inflate.findViewById(R.id.up_apk_details_second_view);
                    r4.setLeftText(replyBean.getU_name() + ":");
                    r4.setText(replyBean.getContent());
                    this.upApkDetailItem2CommentItemAddLy.addView(inflate);
                }
            }
            this.upApkDetailItem2CommentItemCommentBtu.setOnClickListener(this);
            this.upApkDetailItem2CommentItemDuTv.setOnClickListener(this);
            this.upApkDetailItem2CommentItemImg.setOnClickListener(this);
            this.upApkDetailItem2CommentItemDelete.setOnClickListener(this);
            this.upApkDetailItem2CommentItemUuTv.setVisibility(8);
            this.a.setOnClickListener(this);
            this.upApkDetailItem2CommentItemDelete.setVisibility((c.d.a.d.d() && (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getCommentadmin() == 1 || MainActivity.p.getData().getUid() == UpApkDetailsCommentAdapter.this.i)) ? 0 : 8);
            this.upApkDetailItem2CommentItemIsUpMain.setVisibility(dataBean.getUid() != UpApkDetailsCommentAdapter.this.i ? 8 : 0);
            com.rtk.app.tool.t.Q1(dataBean.getStar(), this.upApkDetailItem2CommentItemStart);
            h(this.upApkDetailItem2CommentItemFlowLayout, ((UpApkCommentBean.DataBean) UpApkDetailsCommentAdapter.this.h.get(i)).getPic());
            com.rtk.app.tool.t.p1(context, this.upApkDetailItem2CommentItemMedal, dataBean.getMedalList().getAchievement(), dataBean.getMedalList().getEventMedal());
            com.rtk.app.tool.t.T1(this.upApkDetailItem2CommentItemUserTitle, "", dataBean.getUser_title(), 5, 5);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.up_apk_detail_item2_comment_item_commentBtu /* 2131300598 */:
                    if (!com.rtk.app.tool.y.x(this.b)) {
                        com.rtk.app.tool.t.w0(this.b);
                        return;
                    }
                    com.rtk.app.tool.t.l0(this.b, this.e, this.f113c.getUpGameId(), this.d.getCmtid(), this.d.getCmtid(), "0", this.f113c.getPackageName(), "upApk", this.d.getUid() + "");
                    return;
                case R.id.up_apk_detail_item2_comment_item_delete /* 2131300600 */:
                    new DialogForGameCommentDeleteReason(this.b, new a()).show();
                    return;
                case R.id.up_apk_detail_item2_comment_item_du_tv /* 2131300601 */:
                    if (!com.rtk.app.tool.y.x(this.b)) {
                        com.rtk.app.tool.t.w0(this.b);
                        return;
                    }
                    Context context = this.b;
                    com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(new String[0]);
                    StringBuilder sb = new StringBuilder();
                    sb.append("members/sourceCommentLikes");
                    sb.append(com.rtk.app.tool.y.u(this.b));
                    sb.append("&uid=");
                    sb.append(com.rtk.app.tool.y.K());
                    sb.append("&token=");
                    sb.append(com.rtk.app.tool.y.H());
                    sb.append("&cmtid=");
                    sb.append(this.d.getCmtid());
                    sb.append("&op=du&key=");
                    sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.b, "cmtid=" + this.d.getCmtid(), "op=du", "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
                    com.rtk.app.tool.o.h.l(context, this, 1, h.a(sb.toString()));
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("顶");
                    sb2.append(com.rtk.app.tool.y.d);
                    sb2.append("members/sourceCommentLikes");
                    sb2.append(com.rtk.app.tool.y.u(this.b));
                    sb2.append("&uid=");
                    sb2.append(com.rtk.app.tool.y.K());
                    sb2.append("&token=");
                    sb2.append(com.rtk.app.tool.y.H());
                    sb2.append("&cmtid=");
                    sb2.append(this.d.getCmtid());
                    sb2.append("&op=du&key=");
                    sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.b, "cmtid=" + this.d.getCmtid(), "op=du", "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
                    com.rtk.app.tool.c0.u("UpApkDetailsCommentAdapter", sb2.toString());
                    return;
                case R.id.up_apk_detail_item2_comment_item_img /* 2131300604 */:
                    com.rtk.app.tool.t.B0(this.b, this.d.getUid() + "");
                    return;
                case R.id.up_apk_detail_item2_comment_item_uu_tv /* 2131300611 */:
                    if (!com.rtk.app.tool.y.x(this.b)) {
                        com.rtk.app.tool.t.w0(this.b);
                        return;
                    }
                    Context context2 = this.b;
                    com.rtk.app.tool.o.i h2 = com.rtk.app.tool.o.h.h(new String[0]);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("members/sourceCommentLikes");
                    sb3.append(com.rtk.app.tool.y.u(this.b));
                    sb3.append("&uid=");
                    sb3.append(com.rtk.app.tool.y.K());
                    sb3.append("&token=");
                    sb3.append(com.rtk.app.tool.y.H());
                    sb3.append("&cmtid=");
                    sb3.append(this.d.getCmtid());
                    sb3.append("&op=uu&key=");
                    sb3.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.b, "cmtid=" + this.d.getCmtid(), "op=uu", "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
                    com.rtk.app.tool.o.h.l(context2, this, 2, h2.a(sb3.toString()));
                    return;
                default:
                    com.rtk.app.tool.t.W0(this.b, this.f113c.getUpGameId(), this.d.getCmtid(), this.f113c.getPackageName());
                    return;
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class CommentHolder_ViewBinding implements Unbinder {
        private CommentHolder b;

        @UiThread
        public CommentHolder_ViewBinding(CommentHolder commentHolder, View view) {
            this.b = commentHolder;
            commentHolder.upApkDetailItem2CommentItemImg = (RoundedImageView) butterknife.c.a.c(view, R.id.up_apk_detail_item2_comment_item_img, "field 'upApkDetailItem2CommentItemImg'", RoundedImageView.class);
            commentHolder.upApkDetailItem2CommentItemIsUpMain = (TextView) butterknife.c.a.c(view, R.id.up_apk_detail_item2_comment_item_isUpMain, "field 'upApkDetailItem2CommentItemIsUpMain'", TextView.class);
            commentHolder.upApkDetailItem2CommentItemName = (TextView) butterknife.c.a.c(view, R.id.up_apk_detail_item2_comment_item_name, "field 'upApkDetailItem2CommentItemName'", TextView.class);
            commentHolder.upApkDetailItem2CommentItemStart = (ImageView) butterknife.c.a.c(view, R.id.up_apk_detail_item2_comment_item_start, "field 'upApkDetailItem2CommentItemStart'", ImageView.class);
            commentHolder.upApkDetailItem2CommentItemContent = (TextView) butterknife.c.a.c(view, R.id.up_apk_detail_item2_comment_item_content, "field 'upApkDetailItem2CommentItemContent'", TextView.class);
            commentHolder.upApkDetailItem2CommentItemTime = (TextView) butterknife.c.a.c(view, R.id.up_apk_detail_item2_comment_item_time, "field 'upApkDetailItem2CommentItemTime'", TextView.class);
            commentHolder.upApkDetailItem2CommentItemDelete = (TextView) butterknife.c.a.c(view, R.id.up_apk_detail_item2_comment_item_delete, "field 'upApkDetailItem2CommentItemDelete'", TextView.class);
            commentHolder.upApkDetailItem2CommentItemDuTv = (CheckBox) butterknife.c.a.c(view, R.id.up_apk_detail_item2_comment_item_du_tv, "field 'upApkDetailItem2CommentItemDuTv'", CheckBox.class);
            commentHolder.upApkDetailItem2CommentItemUuTv = (TextView) butterknife.c.a.c(view, R.id.up_apk_detail_item2_comment_item_uu_tv, "field 'upApkDetailItem2CommentItemUuTv'", TextView.class);
            commentHolder.upApkDetailItem2CommentItemCommentBtu = (TextView) butterknife.c.a.c(view, R.id.up_apk_detail_item2_comment_item_commentBtu, "field 'upApkDetailItem2CommentItemCommentBtu'", TextView.class);
            commentHolder.upApkDetailItem2CommentItemAddLy = (LinearLayout) butterknife.c.a.c(view, R.id.up_apk_detail_item2_comment_item_add_ly, "field 'upApkDetailItem2CommentItemAddLy'", LinearLayout.class);
            commentHolder.upApkDetailItem2CommentItemFlowLayout = (FlowLayout) butterknife.c.a.c(view, R.id.up_apk_detail_item2_comment_item_flowLayout, "field 'upApkDetailItem2CommentItemFlowLayout'", FlowLayout.class);
            commentHolder.upApkDetailItem2CommentItemFloor = (TextView) butterknife.c.a.c(view, R.id.up_apk_detail_item2_comment_item_floor, "field 'upApkDetailItem2CommentItemFloor'", TextView.class);
            commentHolder.upApkDetailItem2CommentItemUserTitle = (TextView) butterknife.c.a.c(view, R.id.up_apk_detail_item2_comment_item_user_title, "field 'upApkDetailItem2CommentItemUserTitle'", TextView.class);
            commentHolder.upApkDetailItem2CommentItemMedal = (LinearLayout) butterknife.c.a.c(view, R.id.up_apk_detail_item2_comment_item_medal, "field 'upApkDetailItem2CommentItemMedal'", LinearLayout.class);
        }

        @CallSuper
        public void a() {
            CommentHolder commentHolder = this.b;
            if (commentHolder != null) {
                this.b = null;
                commentHolder.upApkDetailItem2CommentItemImg = null;
                commentHolder.upApkDetailItem2CommentItemIsUpMain = null;
                commentHolder.upApkDetailItem2CommentItemName = null;
                commentHolder.upApkDetailItem2CommentItemStart = null;
                commentHolder.upApkDetailItem2CommentItemContent = null;
                commentHolder.upApkDetailItem2CommentItemTime = null;
                commentHolder.upApkDetailItem2CommentItemDelete = null;
                commentHolder.upApkDetailItem2CommentItemDuTv = null;
                commentHolder.upApkDetailItem2CommentItemUuTv = null;
                commentHolder.upApkDetailItem2CommentItemCommentBtu = null;
                commentHolder.upApkDetailItem2CommentItemAddLy = null;
                commentHolder.upApkDetailItem2CommentItemFlowLayout = null;
                commentHolder.upApkDetailItem2CommentItemFloor = null;
                commentHolder.upApkDetailItem2CommentItemUserTitle = null;
                commentHolder.upApkDetailItem2CommentItemMedal = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public UpApkDetailsCommentAdapter(Context context, List<UpApkCommentBean.DataBean> list, ApkInfo apkInfo, int i) {
        this.f = context;
        this.g = apkInfo;
        this.h = list;
        this.i = i;
    }

    public int getItemCount() {
        return this.h.size() + 1;
    }

    public int getItemViewType(int i) {
        if (this.h.size() == 0 && i == 0) {
            return 1110011;
        }
        return i == getItemCount() + (-1) ? 101 : 100;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType != 101) {
            if (itemViewType != 1110011) {
                ((CommentHolder) viewHolder).k(this.e, this.f, this.h.get(i), this.g, i);
                return;
            } else {
                ((BaseRecyclerViewAdapter.EmptyViewHolder) viewHolder).b(Boolean.valueOf(g()));
                return;
            }
        }
        BaseRecyclerViewAdapter.RecyclerViewFootViewHolder recyclerViewFootViewHolder = (BaseRecyclerViewAdapter.RecyclerViewFootViewHolder) viewHolder;
        Boolean valueOf = Boolean.valueOf(g());
        List<UpApkCommentBean.DataBean> list = this.h;
        recyclerViewFootViewHolder.f(valueOf, list == null ? 0 : list.size(), h(), f());
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 101) {
            return new BaseRecyclerViewAdapter.RecyclerViewFootViewHolder(LayoutInflater.from(this.f).inflate(R.layout.looding_footview, viewGroup, false));
        }
        if (i != 1110011) {
            return new CommentHolder(LayoutInflater.from(this.f).inflate(R.layout.up_apk_details_item2_comment_item_layout, viewGroup, false));
        }
        return new BaseRecyclerViewAdapter.EmptyViewHolder(this, LayoutInflater.from(this.f).inflate(R.layout.post_details_recyclerview_item_empty_view_layout, viewGroup, false));
    }
}
