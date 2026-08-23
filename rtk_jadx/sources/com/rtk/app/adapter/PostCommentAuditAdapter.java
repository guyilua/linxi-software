package com.rtk.app.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.GsonBuilder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.bean.AuditCommentBean;
import com.rtk.app.bean.CheckUser;
import com.rtk.app.bean.PostCommentAuditBean;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.dialogPack.DialogForAuditCheckReason;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostCommentAuditAdapter extends a3 implements h.j {

    /* renamed from: c, reason: collision with root package name */
    private Context f100c;
    private List<PostCommentAuditBean.DataBean> d;
    private int e;
    private String f;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ViewHolder {
        private com.rtk.app.custom.c a;

        @BindView
        View auditInfo;
        View b;

        @BindView
        LinearLayout postCommentAuditListItemAuditContentLv;

        @BindView
        TextView postCommentAuditListItemDeleteBtu;

        @BindView
        RoundedImageView postCommentAuditListItemIcon;

        @BindView
        TextView postCommentAuditListItemNickName;

        @BindView
        TextView postCommentAuditListItemNoPassBtu;

        @BindView
        TextView postCommentAuditListItemPassBtu;

        @BindView
        TextView postCommentAuditListItemState;

        @BindView
        TextView postCommentAuditListItemTime;

        ViewHolder(View view, Context context) {
            ButterKnife.b(this, view);
            this.b = view;
            this.a = new com.rtk.app.custom.c(this.auditInfo, new WeakReference(context));
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.postCommentAuditListItemIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.post_comment_audit_list_item_icon, "field 'postCommentAuditListItemIcon'", RoundedImageView.class);
            viewHolder.postCommentAuditListItemNickName = (TextView) butterknife.c.a.c(view, R.id.post_comment_audit_list_item_nickName, "field 'postCommentAuditListItemNickName'", TextView.class);
            viewHolder.postCommentAuditListItemTime = (TextView) butterknife.c.a.c(view, R.id.post_comment_audit_list_item_time, "field 'postCommentAuditListItemTime'", TextView.class);
            viewHolder.postCommentAuditListItemNoPassBtu = (TextView) butterknife.c.a.c(view, R.id.post_comment_audit_list_item_no_pass_btu, "field 'postCommentAuditListItemNoPassBtu'", TextView.class);
            viewHolder.postCommentAuditListItemPassBtu = (TextView) butterknife.c.a.c(view, R.id.post_comment_audit_list_item_pass_btu, "field 'postCommentAuditListItemPassBtu'", TextView.class);
            viewHolder.postCommentAuditListItemState = (TextView) butterknife.c.a.c(view, R.id.post_comment_audit_list_item_state, "field 'postCommentAuditListItemState'", TextView.class);
            viewHolder.postCommentAuditListItemDeleteBtu = (TextView) butterknife.c.a.c(view, R.id.post_comment_audit_list_item_delete_btu, "field 'postCommentAuditListItemDeleteBtu'", TextView.class);
            viewHolder.postCommentAuditListItemAuditContentLv = (LinearLayout) butterknife.c.a.c(view, R.id.post_comment_audit_list_item_audit_content_lv, "field 'postCommentAuditListItemAuditContentLv'", LinearLayout.class);
            viewHolder.auditInfo = butterknife.c.a.b(view, R.id.post_comment_audit_list_item_audit_info, "field 'auditInfo'");
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.postCommentAuditListItemIcon = null;
                viewHolder.postCommentAuditListItemNickName = null;
                viewHolder.postCommentAuditListItemTime = null;
                viewHolder.postCommentAuditListItemNoPassBtu = null;
                viewHolder.postCommentAuditListItemPassBtu = null;
                viewHolder.postCommentAuditListItemState = null;
                viewHolder.postCommentAuditListItemDeleteBtu = null;
                viewHolder.postCommentAuditListItemAuditContentLv = null;
                viewHolder.auditInfo = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public PostCommentAuditAdapter(Context context, List<PostCommentAuditBean.DataBean> list, int i, String str) {
        super(list);
        this.f100c = context;
        this.d = list;
        this.e = i;
        this.f = str;
    }

    private void e(int i, int i2, String str) {
        PostCommentAuditBean.DataBean dataBean = this.d.get(i2);
        if (TextUtils.isEmpty(this.f)) {
            HashMap<String, String> l = com.rtk.app.tool.y.l();
            l.put("state", i + "");
            l.put("mid", dataBean.getModules().getId() + "");
            l.put("cid", dataBean.getId() + "");
            l.put("key", com.rtk.app.tool.t.L(l));
            l.put("msg", str);
            com.rtk.app.tool.o.h.l(this.f100c, this, i2, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(com.rtk.app.tool.y.w("bbs/examine-comment/post", l)));
            return;
        }
        HashMap<String, String> l2 = com.rtk.app.tool.y.l();
        l2.put("family_id", this.f);
        l2.put("state3", i + "");
        l2.put("cid", dataBean.getId() + "");
        l2.put("key", com.rtk.app.tool.t.L(l2));
        l2.put("msg3", str);
        com.rtk.app.tool.o.h.j(this.f100c, this, com.rtk.app.tool.y.e + "family/bbs/check-comment/operate", i2, l2);
    }

    private void f(ViewHolder viewHolder, final int i) {
        viewHolder.b.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.e2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostCommentAuditAdapter.this.i(i, view);
            }
        });
        viewHolder.postCommentAuditListItemIcon.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.h2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostCommentAuditAdapter.this.k(i, view);
            }
        });
        viewHolder.postCommentAuditListItemNoPassBtu.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.f2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostCommentAuditAdapter.this.m(i, view);
            }
        });
        viewHolder.postCommentAuditListItemDeleteBtu.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.d2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostCommentAuditAdapter.this.o(i, view);
            }
        });
        viewHolder.postCommentAuditListItemPassBtu.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.b2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostCommentAuditAdapter.this.q(i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(int i, View view) {
        StringBuilder sb;
        int root_reply_id;
        PostCommentAuditBean.DataBean dataBean = this.d.get(i);
        Context context = this.f100c;
        String str = dataBean.getPosts().getId() + "";
        if (dataBean.getRoot_reply_id() == 0) {
            sb = new StringBuilder();
            root_reply_id = dataBean.getId();
        } else {
            sb = new StringBuilder();
            root_reply_id = dataBean.getRoot_reply_id();
        }
        sb.append(root_reply_id);
        sb.append("");
        com.rtk.app.tool.t.G0(context, str, sb.toString(), dataBean.getModules().getId() + "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(int i, View view) {
        PostCommentAuditBean.DataBean dataBean = this.d.get(i);
        com.rtk.app.tool.t.B0(this.f100c, dataBean.getUser().getId() + "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(final int i, View view) {
        new DialogForAuditCheckReason(this.f100c, R.array.audit_reason_bbs_comment, new com.rtk.app.tool.s() { // from class: com.rtk.app.adapter.g2
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                PostCommentAuditAdapter.this.s(i, strArr);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(final int i, View view) {
        new DialogForAuditCheckReason(this.f100c, R.array.audit_reason_bbs_comment, new com.rtk.app.tool.s() { // from class: com.rtk.app.adapter.c2
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                PostCommentAuditAdapter.this.u(i, strArr);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(int i, View view) {
        e(3, i, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(int i, String[] strArr) {
        e(2, i, strArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u(int i, String[] strArr) {
        e(4, i, strArr[0]);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        AuditCommentBean auditCommentBean = (AuditCommentBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, AuditCommentBean.class);
        if (TextUtils.isEmpty(this.f)) {
            this.d.get(i).setState(auditCommentBean.getData().getState());
        } else {
            this.d.get(i).setState3(auditCommentBean.getData().getState3());
        }
        notifyDataSetChanged();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.f100c, str, f.a.f);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        int state;
        if (view == null) {
            view = LayoutInflater.from(this.f100c).inflate(R.layout.post_comment_audit_list_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(view, this.f100c);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        com.rtk.app.tool.t.c(this.f100c, this.d.get(i).getUser().getFace(), viewHolder.postCommentAuditListItemIcon, new boolean[0]);
        viewHolder.postCommentAuditListItemNickName.setText(this.d.get(i).getUser().getNickname());
        viewHolder.postCommentAuditListItemTime.setText(this.d.get(i).getCreated());
        PostCommentAuditBean.ConvDataBean convData = this.d.get(i).getConvData();
        com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsHolderClass.a.n(this.f100c, viewHolder.postCommentAuditListItemAuditContentLv, convData.getContent(), convData.getList_post_user(), convData.getList_post_post(), convData.getList_post_upfile(), convData.getList_post_game(), convData.getList_post_img());
        if (!TextUtils.isEmpty(this.f)) {
            state = this.d.get(i).getState3();
            CheckUser check_user3 = this.d.get(i).getCheck_user3();
            viewHolder.auditInfo.setVisibility((check_user3 == null || check_user3.getCheck_uid().equals("0")) ? 8 : 0);
            if (check_user3 != null) {
                viewHolder.a.c(check_user3);
            }
        } else {
            state = this.d.get(i).getState();
        }
        c.d.a.d.f(this.f100c, viewHolder.postCommentAuditListItemState, state);
        if ((c.d.a.d.d() && (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getBbsAdmin() == 1 || this.e == 1)) || (!TextUtils.isEmpty(this.f) && c.d.a.d.a(this.f))) {
            viewHolder.postCommentAuditListItemPassBtu.setVisibility(state == 3 ? 8 : 0);
            viewHolder.postCommentAuditListItemNoPassBtu.setVisibility(state == 1 ? 0 : 8);
            viewHolder.postCommentAuditListItemDeleteBtu.setVisibility((state == 4 || state == 1 || state == 2) ? 8 : 0);
        } else if (c.d.a.d.d() && (MainActivity.p.getData().getAdmin().getAdmin() == 2 || MainActivity.p.getData().getAdmin().getBbsAdmin() == 2 || this.e == 2)) {
            viewHolder.postCommentAuditListItemPassBtu.setVisibility(state == 1 ? 0 : 8);
            viewHolder.postCommentAuditListItemNoPassBtu.setVisibility(state != 1 ? 8 : 0);
            viewHolder.postCommentAuditListItemDeleteBtu.setVisibility(8);
        } else {
            viewHolder.postCommentAuditListItemPassBtu.setVisibility(8);
            viewHolder.postCommentAuditListItemNoPassBtu.setVisibility(8);
            viewHolder.postCommentAuditListItemDeleteBtu.setVisibility(8);
        }
        f(viewHolder, i);
        return view;
    }
}
