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
import com.rtk.app.bean.AuditListSignatureBean;
import com.rtk.app.bean.AuditResultBean;
import com.rtk.app.main.dialogPack.DialogForAuditCheckReason;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AuditSignatureAdapter extends a3 implements h.j {

    /* renamed from: c, reason: collision with root package name */
    private Context f38c;
    private ViewHolder d;
    private List<AuditListSignatureBean.DataDTO> e;
    private int f;
    private int g;
    private Gson h;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ViewHolder {
        View a;

        @BindView
        RoundedImageView auditSignatureListItemAuditCheckUserIcon;

        @BindView
        LinearLayout auditSignatureListItemAuditCheckUserLv;

        @BindView
        TextView auditSignatureListItemAuditCheckUserNickName;

        @BindView
        TextView auditSignatureListItemAuditCheckUserReason;

        @BindView
        TextView auditSignatureListItemDeleteBtu;

        @BindView
        TextView auditSignatureListItemGrade;

        @BindView
        RoundedImageView auditSignatureListItemIcon;

        @BindView
        TextView auditSignatureListItemNewSignature;

        @BindView
        TextView auditSignatureListItemNickName;

        @BindView
        TextView auditSignatureListItemNoPassBtu;

        @BindView
        TextView auditSignatureListItemPassBtu;

        @BindView
        TextView auditSignatureListItemState;

        @BindView
        LinearLayout auditSignatureListItemStateBtuLv;

        @BindView
        TextView auditSignatureListItemTime;

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
            viewHolder.auditSignatureListItemIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.audit_signature_list_item_icon, "field 'auditSignatureListItemIcon'", RoundedImageView.class);
            viewHolder.auditSignatureListItemNickName = (TextView) butterknife.c.a.c(view, R.id.audit_signature_list_item_nickName, "field 'auditSignatureListItemNickName'", TextView.class);
            viewHolder.auditSignatureListItemGrade = (TextView) butterknife.c.a.c(view, R.id.audit_signature_list_item_grade, "field 'auditSignatureListItemGrade'", TextView.class);
            viewHolder.auditSignatureListItemTime = (TextView) butterknife.c.a.c(view, R.id.audit_signature_list_item_time, "field 'auditSignatureListItemTime'", TextView.class);
            viewHolder.auditSignatureListItemPassBtu = (TextView) butterknife.c.a.c(view, R.id.audit_signature_list_item_pass_btu, "field 'auditSignatureListItemPassBtu'", TextView.class);
            viewHolder.auditSignatureListItemNoPassBtu = (TextView) butterknife.c.a.c(view, R.id.audit_signature_list_item_no_pass_btu, "field 'auditSignatureListItemNoPassBtu'", TextView.class);
            viewHolder.auditSignatureListItemDeleteBtu = (TextView) butterknife.c.a.c(view, R.id.audit_signature_list_item_delete_btu, "field 'auditSignatureListItemDeleteBtu'", TextView.class);
            viewHolder.auditSignatureListItemStateBtuLv = (LinearLayout) butterknife.c.a.c(view, R.id.audit_signature_list_item_stateBtu_lv, "field 'auditSignatureListItemStateBtuLv'", LinearLayout.class);
            viewHolder.auditSignatureListItemState = (TextView) butterknife.c.a.c(view, R.id.audit_signature_list_item_state, "field 'auditSignatureListItemState'", TextView.class);
            viewHolder.auditSignatureListItemNewSignature = (TextView) butterknife.c.a.c(view, R.id.audit_signature_list_item_new_signature, "field 'auditSignatureListItemNewSignature'", TextView.class);
            viewHolder.auditSignatureListItemAuditCheckUserIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.audit_signature_list_item_audit_check_user_icon, "field 'auditSignatureListItemAuditCheckUserIcon'", RoundedImageView.class);
            viewHolder.auditSignatureListItemAuditCheckUserNickName = (TextView) butterknife.c.a.c(view, R.id.audit_signature_list_item_audit_check_user_nick_name, "field 'auditSignatureListItemAuditCheckUserNickName'", TextView.class);
            viewHolder.auditSignatureListItemAuditCheckUserReason = (TextView) butterknife.c.a.c(view, R.id.audit_signature_list_item_audit_check_user_reason, "field 'auditSignatureListItemAuditCheckUserReason'", TextView.class);
            viewHolder.auditSignatureListItemAuditCheckUserLv = (LinearLayout) butterknife.c.a.c(view, R.id.audit_signature_list_item_audit_check_user_lv, "field 'auditSignatureListItemAuditCheckUserLv'", LinearLayout.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.auditSignatureListItemIcon = null;
                viewHolder.auditSignatureListItemNickName = null;
                viewHolder.auditSignatureListItemGrade = null;
                viewHolder.auditSignatureListItemTime = null;
                viewHolder.auditSignatureListItemPassBtu = null;
                viewHolder.auditSignatureListItemNoPassBtu = null;
                viewHolder.auditSignatureListItemDeleteBtu = null;
                viewHolder.auditSignatureListItemStateBtuLv = null;
                viewHolder.auditSignatureListItemState = null;
                viewHolder.auditSignatureListItemNewSignature = null;
                viewHolder.auditSignatureListItemAuditCheckUserIcon = null;
                viewHolder.auditSignatureListItemAuditCheckUserNickName = null;
                viewHolder.auditSignatureListItemAuditCheckUserReason = null;
                viewHolder.auditSignatureListItemAuditCheckUserLv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public AuditSignatureAdapter(Context context, List<AuditListSignatureBean.DataDTO> list, int i, int i2) {
        super(list);
        this.f = 0;
        this.g = 0;
        this.h = new GsonBuilder().enableComplexMapKeySerialization().create();
        this.f38c = context;
        this.e = list;
        this.f = i;
        this.g = i2;
    }

    private void e(int i, int i2, String str) {
        AuditListSignatureBean.DataDTO dataDTO = this.e.get(i2);
        HashMap hashMap = new HashMap();
        Context context = this.f38c;
        hashMap.put("channel", com.rtk.app.tool.y.m(context, context.getPackageName()));
        hashMap.put("version", com.rtk.app.tool.y.i(this.f38c));
        hashMap.put(ak.aj, com.rtk.app.tool.y.g());
        hashMap.put("phone_model", com.rtk.app.tool.y.T());
        hashMap.put("uid", com.rtk.app.tool.y.K() + "");
        hashMap.put("token", com.rtk.app.tool.y.H());
        hashMap.put("cid", dataDTO.getCid());
        hashMap.put("msg", str);
        hashMap.put("state", i + "");
        hashMap.put("key", com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f38c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "cid=" + dataDTO.getCid(), "state=" + i))));
        Context context2 = this.f38c;
        StringBuilder sb = new StringBuilder();
        sb.append(com.rtk.app.tool.y.e);
        sb.append("user/check/signature-operate");
        com.rtk.app.tool.o.h.j(context2, this, sb.toString(), i2, hashMap);
    }

    private void f(ViewHolder viewHolder, final int i) {
        viewHolder.auditSignatureListItemIcon.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuditSignatureAdapter.this.i(i, view);
            }
        });
        viewHolder.auditSignatureListItemNoPassBtu.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuditSignatureAdapter.this.k(i, view);
            }
        });
        viewHolder.auditSignatureListItemDeleteBtu.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuditSignatureAdapter.this.m(i, view);
            }
        });
        viewHolder.auditSignatureListItemPassBtu.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuditSignatureAdapter.this.o(i, view);
            }
        });
        viewHolder.auditSignatureListItemAuditCheckUserLv.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuditSignatureAdapter.this.q(i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(int i, View view) {
        AuditListSignatureBean.DataDTO dataDTO = this.e.get(i);
        com.rtk.app.tool.t.B0(this.f38c, dataDTO.getUser().getId() + "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(final int i, View view) {
        new DialogForAuditCheckReason(this.f38c, R.array.audit_reason_signature, new com.rtk.app.tool.s() { // from class: com.rtk.app.adapter.h0
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                AuditSignatureAdapter.this.s(i, strArr);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(final int i, View view) {
        new DialogForAuditCheckReason(this.f38c, R.array.audit_reason_signature, new com.rtk.app.tool.s() { // from class: com.rtk.app.adapter.e0
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                AuditSignatureAdapter.this.u(i, strArr);
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
            com.rtk.app.tool.t.B0(this.f38c, this.e.get(i).getCheck_user().getCheck_uid());
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
        com.rtk.app.tool.c0.u("AuditSignatureAdapter", "签名审核成功：" + str);
        AuditResultBean auditResultBean = (AuditResultBean) this.h.fromJson(str, AuditResultBean.class);
        if (auditResultBean.getCode() != 0 || auditResultBean.getData() == null) {
            return;
        }
        this.e.get(i).setState(auditResultBean.getData().getState() + "");
        notifyDataSetChanged();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("AuditSignatureAdapter", "签名审核失败：" + str);
        com.rtk.app.tool.f.a(this.f38c, str, f.a.f);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f38c).inflate(R.layout.audit_signature_list_item_layout, (ViewGroup) null);
            ViewHolder viewHolder = new ViewHolder(view);
            this.d = viewHolder;
            view.setTag(viewHolder);
        } else {
            this.d = (ViewHolder) view.getTag();
        }
        AuditListSignatureBean.DataDTO dataDTO = this.e.get(i);
        com.rtk.app.tool.t.c(this.f38c, dataDTO.getUser().getFace(), this.d.auditSignatureListItemIcon, new boolean[0]);
        this.d.auditSignatureListItemNickName.setText(dataDTO.getUser().getNickname());
        this.d.auditSignatureListItemTime.setText(dataDTO.getAdd_time());
        int parseInt = Integer.parseInt(dataDTO.getState());
        c.d.a.d.f(this.f38c, this.d.auditSignatureListItemState, parseInt);
        this.d.auditSignatureListItemNewSignature.setText(dataDTO.getNew_signature());
        this.d.auditSignatureListItemGrade.setText(dataDTO.getUser().getUserTitleBean().getTxt());
        int i2 = this.f;
        if (i2 == 1) {
            this.d.auditSignatureListItemPassBtu.setVisibility(parseInt == 3 ? 8 : 0);
            this.d.auditSignatureListItemNoPassBtu.setVisibility(parseInt == 1 ? 0 : 8);
            this.d.auditSignatureListItemDeleteBtu.setVisibility((parseInt == 4 || parseInt == 1 || parseInt == 2) ? 8 : 0);
        } else if (i2 == 2) {
            this.d.auditSignatureListItemPassBtu.setVisibility(parseInt == 1 ? 0 : 8);
            this.d.auditSignatureListItemNoPassBtu.setVisibility(parseInt == 1 ? 0 : 8);
            this.d.auditSignatureListItemDeleteBtu.setVisibility(8);
        } else {
            this.d.auditSignatureListItemPassBtu.setVisibility(8);
            this.d.auditSignatureListItemNoPassBtu.setVisibility(8);
            this.d.auditSignatureListItemDeleteBtu.setVisibility(8);
        }
        if (this.g == 1) {
            this.d.auditSignatureListItemAuditCheckUserLv.setVisibility(0);
            if (dataDTO.getCheck_user() != null && !com.rtk.app.tool.c0.q(dataDTO.getCheck_user().getCheck_nickname())) {
                com.rtk.app.tool.t.c(this.f38c, dataDTO.getCheck_user().getCheck_face(), this.d.auditSignatureListItemAuditCheckUserIcon, new boolean[0]);
                this.d.auditSignatureListItemAuditCheckUserNickName.setText(dataDTO.getCheck_user().getCheck_nickname());
                this.d.auditSignatureListItemAuditCheckUserReason.setText(dataDTO.getCheck_user().getCheck_reason());
            } else {
                this.d.auditSignatureListItemAuditCheckUserLv.setVisibility(8);
            }
        } else {
            this.d.auditSignatureListItemAuditCheckUserLv.setVisibility(8);
        }
        f(this.d, i);
        return view;
    }
}
