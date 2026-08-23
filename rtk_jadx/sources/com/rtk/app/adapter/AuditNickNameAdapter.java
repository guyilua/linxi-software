package com.rtk.app.adapter;

import android.content.Context;
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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.bean.AuditNickNameListBean;
import com.rtk.app.bean.AuditResultBean;
import com.rtk.app.main.dialogPack.DialogForAuditCheckReason;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AuditNickNameAdapter extends a3 implements h.j {

    /* renamed from: c, reason: collision with root package name */
    private Context f36c;
    private ViewHolder d;
    private List<AuditNickNameListBean.DataDTO> e;
    private int f;
    private int g;
    private Gson h;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ViewHolder {
        View a;

        @BindView
        RoundedImageView auditNickNameListItemAuditCheckUserIcon;

        @BindView
        LinearLayout auditNickNameListItemAuditCheckUserLv;

        @BindView
        TextView auditNickNameListItemAuditCheckUserNickName;

        @BindView
        TextView auditNickNameListItemAuditCheckUserReason;

        @BindView
        TextView auditNickNameListItemDeleteBtu;

        @BindView
        TextView auditNickNameListItemGrade;

        @BindView
        RoundedImageView auditNickNameListItemIcon;

        @BindView
        TextView auditNickNameListItemNewName;

        @BindView
        TextView auditNickNameListItemNickName;

        @BindView
        TextView auditNickNameListItemNoPassBtu;

        @BindView
        TextView auditNickNameListItemPassBtu;

        @BindView
        TextView auditNickNameListItemState;

        @BindView
        LinearLayout auditNickNameListItemStateBtuLv;

        @BindView
        TextView auditNickNameListItemTime;

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
            viewHolder.auditNickNameListItemIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.audit_nick_name_list_item_icon, "field 'auditNickNameListItemIcon'", RoundedImageView.class);
            viewHolder.auditNickNameListItemNickName = (TextView) butterknife.c.a.c(view, R.id.audit_nick_name_list_item_nickName, "field 'auditNickNameListItemNickName'", TextView.class);
            viewHolder.auditNickNameListItemGrade = (TextView) butterknife.c.a.c(view, R.id.audit_nick_name_list_item_grade, "field 'auditNickNameListItemGrade'", TextView.class);
            viewHolder.auditNickNameListItemTime = (TextView) butterknife.c.a.c(view, R.id.audit_nick_name_list_item_time, "field 'auditNickNameListItemTime'", TextView.class);
            viewHolder.auditNickNameListItemPassBtu = (TextView) butterknife.c.a.c(view, R.id.audit_nick_name_list_item_pass_btu, "field 'auditNickNameListItemPassBtu'", TextView.class);
            viewHolder.auditNickNameListItemNoPassBtu = (TextView) butterknife.c.a.c(view, R.id.audit_nick_name_list_item_no_pass_btu, "field 'auditNickNameListItemNoPassBtu'", TextView.class);
            viewHolder.auditNickNameListItemDeleteBtu = (TextView) butterknife.c.a.c(view, R.id.audit_nick_name_list_item_delete_btu, "field 'auditNickNameListItemDeleteBtu'", TextView.class);
            viewHolder.auditNickNameListItemStateBtuLv = (LinearLayout) butterknife.c.a.c(view, R.id.audit_nick_name_list_item_stateBtu_lv, "field 'auditNickNameListItemStateBtuLv'", LinearLayout.class);
            viewHolder.auditNickNameListItemState = (TextView) butterknife.c.a.c(view, R.id.audit_nick_name_list_item_state, "field 'auditNickNameListItemState'", TextView.class);
            viewHolder.auditNickNameListItemNewName = (TextView) butterknife.c.a.c(view, R.id.audit_nick_name_list_item_new_name, "field 'auditNickNameListItemNewName'", TextView.class);
            viewHolder.auditNickNameListItemAuditCheckUserIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.audit_nick_name_list_item_audit_check_user_icon, "field 'auditNickNameListItemAuditCheckUserIcon'", RoundedImageView.class);
            viewHolder.auditNickNameListItemAuditCheckUserNickName = (TextView) butterknife.c.a.c(view, R.id.audit_nick_name_list_item_audit_check_user_nick_name, "field 'auditNickNameListItemAuditCheckUserNickName'", TextView.class);
            viewHolder.auditNickNameListItemAuditCheckUserReason = (TextView) butterknife.c.a.c(view, R.id.audit_nick_name_list_item_audit_check_user_reason, "field 'auditNickNameListItemAuditCheckUserReason'", TextView.class);
            viewHolder.auditNickNameListItemAuditCheckUserLv = (LinearLayout) butterknife.c.a.c(view, R.id.audit_nick_name_list_item_audit_check_user_lv, "field 'auditNickNameListItemAuditCheckUserLv'", LinearLayout.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.auditNickNameListItemIcon = null;
                viewHolder.auditNickNameListItemNickName = null;
                viewHolder.auditNickNameListItemGrade = null;
                viewHolder.auditNickNameListItemTime = null;
                viewHolder.auditNickNameListItemPassBtu = null;
                viewHolder.auditNickNameListItemNoPassBtu = null;
                viewHolder.auditNickNameListItemDeleteBtu = null;
                viewHolder.auditNickNameListItemStateBtuLv = null;
                viewHolder.auditNickNameListItemState = null;
                viewHolder.auditNickNameListItemNewName = null;
                viewHolder.auditNickNameListItemAuditCheckUserIcon = null;
                viewHolder.auditNickNameListItemAuditCheckUserNickName = null;
                viewHolder.auditNickNameListItemAuditCheckUserReason = null;
                viewHolder.auditNickNameListItemAuditCheckUserLv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public AuditNickNameAdapter(Context context, List<AuditNickNameListBean.DataDTO> list, int i, int i2) {
        super(list);
        this.f = 0;
        this.g = 0;
        this.h = new GsonBuilder().enableComplexMapKeySerialization().create();
        this.f36c = context;
        this.e = list;
        this.f = i;
        this.g = i2;
    }

    private void e(int i, int i2, String str) {
        AuditNickNameListBean.DataDTO dataDTO = this.e.get(i2);
        HashMap hashMap = new HashMap();
        Context context = this.f36c;
        hashMap.put("channel", com.rtk.app.tool.y.m(context, context.getPackageName()));
        hashMap.put("version", com.rtk.app.tool.y.i(this.f36c));
        hashMap.put(ak.aj, com.rtk.app.tool.y.g());
        hashMap.put("phone_model", com.rtk.app.tool.y.T());
        hashMap.put("uid", com.rtk.app.tool.y.K() + "");
        hashMap.put("token", com.rtk.app.tool.y.H());
        hashMap.put("cid", dataDTO.getCid());
        hashMap.put("msg", str);
        hashMap.put("state", i + "");
        hashMap.put("key", com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f36c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "cid=" + dataDTO.getCid(), "state=" + i))));
        Context context2 = this.f36c;
        StringBuilder sb = new StringBuilder();
        sb.append(com.rtk.app.tool.y.e);
        sb.append("user/check/nickname-operate");
        com.rtk.app.tool.o.h.j(context2, this, sb.toString(), i2, hashMap);
    }

    private void f(ViewHolder viewHolder, final int i) {
        viewHolder.auditNickNameListItemIcon.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuditNickNameAdapter.this.i(i, view);
            }
        });
        viewHolder.auditNickNameListItemNoPassBtu.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuditNickNameAdapter.this.k(i, view);
            }
        });
        viewHolder.auditNickNameListItemDeleteBtu.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuditNickNameAdapter.this.m(i, view);
            }
        });
        viewHolder.auditNickNameListItemPassBtu.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuditNickNameAdapter.this.o(i, view);
            }
        });
        viewHolder.auditNickNameListItemAuditCheckUserLv.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuditNickNameAdapter.this.q(i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(int i, View view) {
        AuditNickNameListBean.DataDTO dataDTO = this.e.get(i);
        com.rtk.app.tool.t.B0(this.f36c, dataDTO.getUser().getId() + "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(final int i, View view) {
        new DialogForAuditCheckReason(this.f36c, R.array.audit_reason_nick_name, new com.rtk.app.tool.s() { // from class: com.rtk.app.adapter.n
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                AuditNickNameAdapter.this.s(i, strArr);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(final int i, View view) {
        new DialogForAuditCheckReason(this.f36c, R.array.audit_reason_nick_name, new com.rtk.app.tool.s() { // from class: com.rtk.app.adapter.o
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                AuditNickNameAdapter.this.u(i, strArr);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(int i, View view) {
        e(3, i, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(int i, View view) {
        if (this.e.get(i).getCheck_user() != null) {
            com.rtk.app.tool.t.B0(this.f36c, this.e.get(i).getCheck_user().getCheck_uid());
        }
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
        com.rtk.app.tool.c0.u("AuditNickNameAdapter", "昵称审核成功：" + str);
        AuditResultBean auditResultBean = (AuditResultBean) this.h.fromJson(str, AuditResultBean.class);
        if (auditResultBean.getCode() != 0 || auditResultBean.getData() == null) {
            return;
        }
        this.e.get(i).setState(auditResultBean.getData().getState() + "");
        notifyDataSetChanged();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("AuditNickNameAdapter", "昵称审核失败：" + str);
        com.rtk.app.tool.f.a(this.f36c, str, f.a.f);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f36c).inflate(R.layout.audit_nick_name_list_item_layout, (ViewGroup) null);
            ViewHolder viewHolder = new ViewHolder(view);
            this.d = viewHolder;
            view.setTag(viewHolder);
        } else {
            this.d = (ViewHolder) view.getTag();
        }
        AuditNickNameListBean.DataDTO dataDTO = this.e.get(i);
        com.rtk.app.tool.t.c(this.f36c, dataDTO.getUser().getFace(), this.d.auditNickNameListItemIcon, new boolean[0]);
        this.d.auditNickNameListItemNickName.setText(dataDTO.getUser().getNickname());
        this.d.auditNickNameListItemTime.setText(dataDTO.getAdd_time());
        int parseInt = Integer.parseInt(dataDTO.getState());
        c.d.a.d.f(this.f36c, this.d.auditNickNameListItemState, parseInt);
        this.d.auditNickNameListItemNewName.setText(dataDTO.getNew_name());
        this.d.auditNickNameListItemGrade.setText(dataDTO.getUser().getUser_title().getTxt());
        int i2 = this.f;
        if (i2 == 1) {
            this.d.auditNickNameListItemPassBtu.setVisibility(parseInt == 3 ? 8 : 0);
            this.d.auditNickNameListItemNoPassBtu.setVisibility(parseInt == 1 ? 0 : 8);
            this.d.auditNickNameListItemDeleteBtu.setVisibility((parseInt == 4 || parseInt == 1 || parseInt == 2) ? 8 : 0);
        } else if (i2 == 2) {
            this.d.auditNickNameListItemPassBtu.setVisibility(parseInt == 1 ? 0 : 8);
            this.d.auditNickNameListItemNoPassBtu.setVisibility(parseInt == 1 ? 0 : 8);
            this.d.auditNickNameListItemDeleteBtu.setVisibility(8);
        } else {
            this.d.auditNickNameListItemPassBtu.setVisibility(8);
            this.d.auditNickNameListItemNoPassBtu.setVisibility(8);
            this.d.auditNickNameListItemDeleteBtu.setVisibility(8);
        }
        if (this.g == 1) {
            this.d.auditNickNameListItemAuditCheckUserLv.setVisibility(0);
            if (dataDTO.getCheck_user() != null && !com.rtk.app.tool.c0.q(dataDTO.getCheck_user().getCheck_nickname())) {
                com.rtk.app.tool.t.c(this.f36c, dataDTO.getCheck_user().getCheck_face(), this.d.auditNickNameListItemAuditCheckUserIcon, new boolean[0]);
                this.d.auditNickNameListItemAuditCheckUserNickName.setText(dataDTO.getCheck_user().getCheck_nickname());
                this.d.auditNickNameListItemAuditCheckUserReason.setText(dataDTO.getCheck_user().getCheck_reason());
            } else {
                this.d.auditNickNameListItemAuditCheckUserLv.setVisibility(8);
            }
        } else {
            this.d.auditNickNameListItemAuditCheckUserLv.setVisibility(8);
        }
        f(this.d, i);
        return view;
    }
}
