package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.bean.AuditCommentBean;
import com.rtk.app.bean.UpApkCommentAuditBean;
import com.rtk.app.main.dialogPack.DialogForAuditCheckReason;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import com.zhy.view.flowlayout.FlowLayout;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpCommentAuditAdapter extends a3 implements h.j {

    /* renamed from: c, reason: collision with root package name */
    private Context f118c;
    private List<UpApkCommentAuditBean.DataDTO> d;
    private int e;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ViewHolder {
        View a;

        @BindView
        RoundedImageView upCommentAuditListItemAuditCheckUserIcon;

        @BindView
        LinearLayout upCommentAuditListItemAuditCheckUserLv;

        @BindView
        TextView upCommentAuditListItemAuditCheckUserNickName;

        @BindView
        TextView upCommentAuditListItemAuditCheckUserReason;

        @BindView
        FlowLayout upCommentAuditListItemAuditContentLv;

        @BindView
        TextView upCommentAuditListItemContent;

        @BindView
        TextView upCommentAuditListItemDeleteBtu;

        @BindView
        TextView upCommentAuditListItemGrade;

        @BindView
        RoundedImageView upCommentAuditListItemIcon;

        @BindView
        TextView upCommentAuditListItemNickName;

        @BindView
        TextView upCommentAuditListItemNoPassBtu;

        @BindView
        TextView upCommentAuditListItemPassBtu;

        @BindView
        TextView upCommentAuditListItemState;

        @BindView
        TextView upCommentAuditListItemTime;

        ViewHolder(View view) {
            ButterKnife.b(this, view);
            this.a = view;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.upCommentAuditListItemIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.up_comment_audit_list_item_icon, "field 'upCommentAuditListItemIcon'", RoundedImageView.class);
            viewHolder.upCommentAuditListItemNickName = (TextView) butterknife.c.a.c(view, R.id.up_comment_audit_list_item_nickName, "field 'upCommentAuditListItemNickName'", TextView.class);
            viewHolder.upCommentAuditListItemTime = (TextView) butterknife.c.a.c(view, R.id.up_comment_audit_list_item_time, "field 'upCommentAuditListItemTime'", TextView.class);
            viewHolder.upCommentAuditListItemNoPassBtu = (TextView) butterknife.c.a.c(view, R.id.up_comment_audit_list_item_no_pass_btu, "field 'upCommentAuditListItemNoPassBtu'", TextView.class);
            viewHolder.upCommentAuditListItemPassBtu = (TextView) butterknife.c.a.c(view, R.id.up_comment_audit_list_item_pass_btu, "field 'upCommentAuditListItemPassBtu'", TextView.class);
            viewHolder.upCommentAuditListItemState = (TextView) butterknife.c.a.c(view, R.id.up_comment_audit_list_item_state, "field 'upCommentAuditListItemState'", TextView.class);
            viewHolder.upCommentAuditListItemGrade = (TextView) butterknife.c.a.c(view, R.id.up_comment_audit_list_item_grade, "field 'upCommentAuditListItemGrade'", TextView.class);
            viewHolder.upCommentAuditListItemDeleteBtu = (TextView) butterknife.c.a.c(view, R.id.up_comment_audit_list_item_delete_btu, "field 'upCommentAuditListItemDeleteBtu'", TextView.class);
            viewHolder.upCommentAuditListItemContent = (TextView) butterknife.c.a.c(view, R.id.up_comment_audit_list_item_content, "field 'upCommentAuditListItemContent'", TextView.class);
            viewHolder.upCommentAuditListItemAuditContentLv = (FlowLayout) butterknife.c.a.c(view, R.id.up_comment_audit_list_item_audit_content_lv, "field 'upCommentAuditListItemAuditContentLv'", FlowLayout.class);
            viewHolder.upCommentAuditListItemAuditCheckUserLv = (LinearLayout) butterknife.c.a.c(view, R.id.up_comment_audit_list_item_audit_check_user_lv, "field 'upCommentAuditListItemAuditCheckUserLv'", LinearLayout.class);
            viewHolder.upCommentAuditListItemAuditCheckUserIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.up_comment_audit_list_item_audit_check_user_icon, "field 'upCommentAuditListItemAuditCheckUserIcon'", RoundedImageView.class);
            viewHolder.upCommentAuditListItemAuditCheckUserNickName = (TextView) butterknife.c.a.c(view, R.id.up_comment_audit_list_item_audit_check_user_nick_name, "field 'upCommentAuditListItemAuditCheckUserNickName'", TextView.class);
            viewHolder.upCommentAuditListItemAuditCheckUserReason = (TextView) butterknife.c.a.c(view, R.id.up_comment_audit_list_item_audit_check_user_reason, "field 'upCommentAuditListItemAuditCheckUserReason'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.upCommentAuditListItemIcon = null;
                viewHolder.upCommentAuditListItemNickName = null;
                viewHolder.upCommentAuditListItemTime = null;
                viewHolder.upCommentAuditListItemNoPassBtu = null;
                viewHolder.upCommentAuditListItemPassBtu = null;
                viewHolder.upCommentAuditListItemState = null;
                viewHolder.upCommentAuditListItemGrade = null;
                viewHolder.upCommentAuditListItemDeleteBtu = null;
                viewHolder.upCommentAuditListItemContent = null;
                viewHolder.upCommentAuditListItemAuditContentLv = null;
                viewHolder.upCommentAuditListItemAuditCheckUserLv = null;
                viewHolder.upCommentAuditListItemAuditCheckUserIcon = null;
                viewHolder.upCommentAuditListItemAuditCheckUserNickName = null;
                viewHolder.upCommentAuditListItemAuditCheckUserReason = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public UpCommentAuditAdapter(Context context, List<UpApkCommentAuditBean.DataDTO> list, int i) {
        super(list);
        this.e = 0;
        this.f118c = context;
        this.d = list;
        this.e = i;
    }

    private void e(FlowLayout flowLayout, final List<String> list) {
        flowLayout.removeAllViews();
        if (list == null || list.size() < 0) {
            return;
        }
        for (final int i = 0; i < list.size(); i++) {
            View inflate = LayoutInflater.from(this.f118c).inflate(R.layout.just_image_view_layout, (ViewGroup) flowLayout, false);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.just_imageView);
            flowLayout.addView(inflate);
            com.rtk.app.tool.t.c(this.f118c, list.get(i), imageView, new boolean[0]);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.l2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UpCommentAuditAdapter.this.j(list, i, view);
                }
            });
        }
    }

    private void f(int i, int i2, String str) {
        UpApkCommentAuditBean.DataDTO dataDTO = this.d.get(i2);
        StringBuilder sb = new StringBuilder();
        sb.append("up/examine-comment/operate");
        sb.append(com.rtk.app.tool.y.u(this.f118c));
        sb.append("&uid=");
        sb.append(com.rtk.app.tool.y.K());
        sb.append("&token=");
        sb.append(com.rtk.app.tool.y.H());
        sb.append("&cid=");
        sb.append(dataDTO.getId());
        sb.append("&state=");
        sb.append(i);
        sb.append("&msg=");
        sb.append(str);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f118c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "cid=" + dataDTO.getId(), "state=" + i))));
        com.rtk.app.tool.o.h.l(this.f118c, this, i2, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb.toString()));
    }

    private void h(ViewHolder viewHolder, final int i) {
        viewHolder.a.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.k2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UpCommentAuditAdapter.this.l(i, view);
            }
        });
        viewHolder.upCommentAuditListItemIcon.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.p2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UpCommentAuditAdapter.this.n(i, view);
            }
        });
        viewHolder.upCommentAuditListItemNoPassBtu.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.o2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UpCommentAuditAdapter.this.p(i, view);
            }
        });
        viewHolder.upCommentAuditListItemDeleteBtu.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.r2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UpCommentAuditAdapter.this.r(i, view);
            }
        });
        viewHolder.upCommentAuditListItemPassBtu.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.j2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UpCommentAuditAdapter.this.t(i, view);
            }
        });
        viewHolder.upCommentAuditListItemAuditCheckUserLv.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.n2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UpCommentAuditAdapter.this.v(i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(List list, int i, View view) {
        com.rtk.app.tool.t.C0(this.f118c, list, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(int i, View view) {
        UpApkCommentAuditBean.DataDTO dataDTO = this.d.get(i);
        int parseInt = Integer.parseInt(dataDTO.getRoot_reply_id());
        if (parseInt == 0) {
            com.rtk.app.tool.t.W0(this.f118c, Integer.parseInt(dataDTO.getSid()), Integer.parseInt(dataDTO.getId()), "游戏Id");
        } else {
            com.rtk.app.tool.t.W0(this.f118c, Integer.parseInt(dataDTO.getSid()), parseInt, "游戏Id");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(int i, View view) {
        UpApkCommentAuditBean.DataDTO dataDTO = this.d.get(i);
        com.rtk.app.tool.t.B0(this.f118c, dataDTO.getUser().getId() + "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(final int i, View view) {
        new DialogForAuditCheckReason(this.f118c, R.array.audit_reason_bbs_comment, new com.rtk.app.tool.s() { // from class: com.rtk.app.adapter.m2
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                UpCommentAuditAdapter.this.x(i, strArr);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r(final int i, View view) {
        new DialogForAuditCheckReason(this.f118c, R.array.audit_reason_bbs_comment, new com.rtk.app.tool.s() { // from class: com.rtk.app.adapter.q2
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                UpCommentAuditAdapter.this.z(i, strArr);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(int i, View view) {
        f(3, i, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(int i, View view) {
        if (this.d.get(i).getCheck_user() != null) {
            com.rtk.app.tool.t.B0(this.f118c, this.d.get(i).getCheck_user().getCheck_uid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(int i, String[] strArr) {
        f(2, i, strArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z(int i, String[] strArr) {
        f(4, i, strArr[0]);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        com.rtk.app.tool.c0.u("UpCommentAuditAdapter", "up评论审核返回:" + str);
        AuditCommentBean auditCommentBean = (AuditCommentBean) create.fromJson(str, AuditCommentBean.class);
        this.d.get(i).setState(auditCommentBean.getData().getState() + "");
        notifyDataSetChanged();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.f118c, str, f.a.f);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f118c).inflate(R.layout.up_comment_audit_list_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        UpApkCommentAuditBean.DataDTO dataDTO = this.d.get(i);
        com.rtk.app.tool.t.c(this.f118c, dataDTO.getUser().getFace(), viewHolder.upCommentAuditListItemIcon, new boolean[0]);
        viewHolder.upCommentAuditListItemNickName.setText(dataDTO.getUser().getNickname());
        viewHolder.upCommentAuditListItemTime.setText(dataDTO.getCreated());
        int parseInt = Integer.parseInt(dataDTO.getState());
        c.d.a.d.f(this.f118c, viewHolder.upCommentAuditListItemState, parseInt);
        viewHolder.upCommentAuditListItemContent.setText(com.rtk.app.main.comment.express.c.g().a(dataDTO.getContent()));
        viewHolder.upCommentAuditListItemAuditContentLv.removeAllViews();
        viewHolder.upCommentAuditListItemGrade.setText(dataDTO.getUser().getUser_title().getTxt());
        e(viewHolder.upCommentAuditListItemAuditContentLv, dataDTO.getPic());
        int i2 = this.e;
        if (i2 == 1) {
            viewHolder.upCommentAuditListItemPassBtu.setVisibility(parseInt == 3 ? 8 : 0);
            viewHolder.upCommentAuditListItemNoPassBtu.setVisibility(parseInt == 1 ? 0 : 8);
            viewHolder.upCommentAuditListItemDeleteBtu.setVisibility((parseInt == 4 || parseInt == 1 || parseInt == 2) ? 8 : 0);
        } else if (i2 == 2) {
            viewHolder.upCommentAuditListItemPassBtu.setVisibility(parseInt == 1 ? 0 : 8);
            viewHolder.upCommentAuditListItemNoPassBtu.setVisibility(parseInt == 1 ? 0 : 8);
            viewHolder.upCommentAuditListItemDeleteBtu.setVisibility(8);
        } else {
            viewHolder.upCommentAuditListItemPassBtu.setVisibility(8);
            viewHolder.upCommentAuditListItemNoPassBtu.setVisibility(8);
            viewHolder.upCommentAuditListItemDeleteBtu.setVisibility(8);
        }
        viewHolder.upCommentAuditListItemAuditCheckUserLv.setVisibility(0);
        if (dataDTO.getCheck_user() != null && !com.rtk.app.tool.c0.q(dataDTO.getCheck_user().getCheck_nickname())) {
            com.rtk.app.tool.t.c(this.f118c, dataDTO.getCheck_user().getCheck_face(), viewHolder.upCommentAuditListItemAuditCheckUserIcon, new boolean[0]);
            viewHolder.upCommentAuditListItemAuditCheckUserNickName.setText(dataDTO.getCheck_user().getCheck_nickname());
            viewHolder.upCommentAuditListItemAuditCheckUserReason.setText(dataDTO.getCheck_user().getCheck_reason());
        } else {
            viewHolder.upCommentAuditListItemAuditCheckUserLv.setVisibility(8);
        }
        h(viewHolder, i);
        return view;
    }
}
