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
import com.rtk.app.bean.AuditPhotoListBean;
import com.rtk.app.bean.AuditResultBean;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.dialogPack.DialogForAuditCheckReason;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AuditPhotoAdapter extends a3 implements h.j {

    /* renamed from: c, reason: collision with root package name */
    private Context f37c;
    private ViewHolder d;
    private List<AuditPhotoListBean.DataDTO> e;
    private int f;
    private int g;
    private Gson h;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ViewHolder {
        View a;

        @BindView
        RoundedImageView auditPhotoListItemAuditCheckUserIcon;

        @BindView
        LinearLayout auditPhotoListItemAuditCheckUserLv;

        @BindView
        TextView auditPhotoListItemAuditCheckUserNickName;

        @BindView
        TextView auditPhotoListItemAuditCheckUserReason;

        @BindView
        TextView auditPhotoListItemDeleteBtu;

        @BindView
        TextView auditPhotoListItemGrade;

        @BindView
        RoundedImageView auditPhotoListItemIcon;

        @BindView
        TextView auditPhotoListItemNickName;

        @BindView
        TextView auditPhotoListItemNoPassBtu;

        @BindView
        TextView auditPhotoListItemPassBtu;

        @BindView
        ImageView auditPhotoListItemPicture;

        @BindView
        TextView auditPhotoListItemState;

        @BindView
        LinearLayout auditPhotoListItemStateBtuLv;

        @BindView
        TextView auditPhotoListItemTime;

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
            viewHolder.auditPhotoListItemIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.audit_photo_list_item_icon, "field 'auditPhotoListItemIcon'", RoundedImageView.class);
            viewHolder.auditPhotoListItemNickName = (TextView) butterknife.c.a.c(view, R.id.audit_photo_list_item_nickName, "field 'auditPhotoListItemNickName'", TextView.class);
            viewHolder.auditPhotoListItemGrade = (TextView) butterknife.c.a.c(view, R.id.audit_photo_list_item_grade, "field 'auditPhotoListItemGrade'", TextView.class);
            viewHolder.auditPhotoListItemTime = (TextView) butterknife.c.a.c(view, R.id.audit_photo_list_item_time, "field 'auditPhotoListItemTime'", TextView.class);
            viewHolder.auditPhotoListItemPassBtu = (TextView) butterknife.c.a.c(view, R.id.audit_photo_list_item_pass_btu, "field 'auditPhotoListItemPassBtu'", TextView.class);
            viewHolder.auditPhotoListItemNoPassBtu = (TextView) butterknife.c.a.c(view, R.id.audit_photo_list_item_no_pass_btu, "field 'auditPhotoListItemNoPassBtu'", TextView.class);
            viewHolder.auditPhotoListItemDeleteBtu = (TextView) butterknife.c.a.c(view, R.id.audit_photo_list_item_delete_btu, "field 'auditPhotoListItemDeleteBtu'", TextView.class);
            viewHolder.auditPhotoListItemStateBtuLv = (LinearLayout) butterknife.c.a.c(view, R.id.audit_photo_list_item_stateBtu_lv, "field 'auditPhotoListItemStateBtuLv'", LinearLayout.class);
            viewHolder.auditPhotoListItemState = (TextView) butterknife.c.a.c(view, R.id.audit_photo_list_item_state, "field 'auditPhotoListItemState'", TextView.class);
            viewHolder.auditPhotoListItemPicture = (ImageView) butterknife.c.a.c(view, R.id.audit_photo_list_item_picture, "field 'auditPhotoListItemPicture'", ImageView.class);
            viewHolder.auditPhotoListItemAuditCheckUserIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.audit_photo_list_item_audit_check_user_icon, "field 'auditPhotoListItemAuditCheckUserIcon'", RoundedImageView.class);
            viewHolder.auditPhotoListItemAuditCheckUserNickName = (TextView) butterknife.c.a.c(view, R.id.audit_photo_list_item_audit_check_user_nick_name, "field 'auditPhotoListItemAuditCheckUserNickName'", TextView.class);
            viewHolder.auditPhotoListItemAuditCheckUserReason = (TextView) butterknife.c.a.c(view, R.id.audit_photo_list_item_audit_check_user_reason, "field 'auditPhotoListItemAuditCheckUserReason'", TextView.class);
            viewHolder.auditPhotoListItemAuditCheckUserLv = (LinearLayout) butterknife.c.a.c(view, R.id.audit_photo_list_item_audit_check_user_lv, "field 'auditPhotoListItemAuditCheckUserLv'", LinearLayout.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.auditPhotoListItemIcon = null;
                viewHolder.auditPhotoListItemNickName = null;
                viewHolder.auditPhotoListItemGrade = null;
                viewHolder.auditPhotoListItemTime = null;
                viewHolder.auditPhotoListItemPassBtu = null;
                viewHolder.auditPhotoListItemNoPassBtu = null;
                viewHolder.auditPhotoListItemDeleteBtu = null;
                viewHolder.auditPhotoListItemStateBtuLv = null;
                viewHolder.auditPhotoListItemState = null;
                viewHolder.auditPhotoListItemPicture = null;
                viewHolder.auditPhotoListItemAuditCheckUserIcon = null;
                viewHolder.auditPhotoListItemAuditCheckUserNickName = null;
                viewHolder.auditPhotoListItemAuditCheckUserReason = null;
                viewHolder.auditPhotoListItemAuditCheckUserLv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public AuditPhotoAdapter(Context context, List<AuditPhotoListBean.DataDTO> list, int i, int i2) {
        super(list);
        this.f = 0;
        this.g = 0;
        this.h = new GsonBuilder().enableComplexMapKeySerialization().create();
        this.f37c = context;
        this.e = list;
        this.f = i;
        this.g = i2;
    }

    private void e(int i, int i2, String str) {
        AuditPhotoListBean.DataDTO dataDTO = this.e.get(i2);
        HashMap hashMap = new HashMap();
        Context context = this.f37c;
        hashMap.put("channel", com.rtk.app.tool.y.m(context, context.getPackageName()));
        hashMap.put("version", com.rtk.app.tool.y.i(this.f37c));
        hashMap.put(ak.aj, com.rtk.app.tool.y.g());
        hashMap.put("phone_model", com.rtk.app.tool.y.T());
        hashMap.put("uid", com.rtk.app.tool.y.K() + "");
        hashMap.put("token", com.rtk.app.tool.y.H());
        hashMap.put("cid", dataDTO.getCid());
        hashMap.put("msg", str);
        hashMap.put("state", i + "");
        hashMap.put("key", com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f37c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "cid=" + dataDTO.getCid(), "state=" + i))));
        Context context2 = this.f37c;
        StringBuilder sb = new StringBuilder();
        sb.append(com.rtk.app.tool.y.e);
        sb.append("user/check/photo-operate");
        com.rtk.app.tool.o.h.j(context2, this, sb.toString(), i2, hashMap);
    }

    private void f(ViewHolder viewHolder, final int i) {
        viewHolder.auditPhotoListItemIcon.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuditPhotoAdapter.this.i(i, view);
            }
        });
        viewHolder.auditPhotoListItemNoPassBtu.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuditPhotoAdapter.this.k(i, view);
            }
        });
        viewHolder.auditPhotoListItemDeleteBtu.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuditPhotoAdapter.this.m(i, view);
            }
        });
        viewHolder.auditPhotoListItemPassBtu.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuditPhotoAdapter.this.o(i, view);
            }
        });
        viewHolder.auditPhotoListItemAuditCheckUserLv.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuditPhotoAdapter.this.q(i, view);
            }
        });
        viewHolder.auditPhotoListItemPicture.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuditPhotoAdapter.this.s(i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(int i, View view) {
        AuditPhotoListBean.DataDTO dataDTO = this.e.get(i);
        com.rtk.app.tool.t.B0(this.f37c, dataDTO.getUser().getId() + "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(final int i, View view) {
        new DialogForAuditCheckReason(this.f37c, R.array.audit_reason_picture, new com.rtk.app.tool.s() { // from class: com.rtk.app.adapter.v
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                AuditPhotoAdapter.this.u(i, strArr);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(final int i, View view) {
        new DialogForAuditCheckReason(this.f37c, R.array.audit_reason_picture, new com.rtk.app.tool.s() { // from class: com.rtk.app.adapter.y
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                AuditPhotoAdapter.this.w(i, strArr);
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
            com.rtk.app.tool.t.B0(this.f37c, this.e.get(i).getCheck_user().getCheck_uid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(int i, View view) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.e.get(i).getThumPic());
        com.rtk.app.tool.t.C0(MyApplication.b(), arrayList, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u(int i, String[] strArr) {
        e(2, i, strArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(int i, String[] strArr) {
        e(4, i, strArr[0]);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("AuditPhotoAdapter", "图片审核成功：" + str);
        AuditResultBean auditResultBean = (AuditResultBean) this.h.fromJson(str, AuditResultBean.class);
        if (auditResultBean.getCode() != 0 || auditResultBean.getData() == null) {
            return;
        }
        this.e.get(i).setState(auditResultBean.getData().getState() + "");
        notifyDataSetChanged();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("AuditPhotoAdapter", "图片审核失败：" + str);
        com.rtk.app.tool.f.a(this.f37c, str, f.a.f);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f37c).inflate(R.layout.audit_photo_list_item_layout, (ViewGroup) null);
            ViewHolder viewHolder = new ViewHolder(view);
            this.d = viewHolder;
            view.setTag(viewHolder);
        } else {
            this.d = (ViewHolder) view.getTag();
        }
        AuditPhotoListBean.DataDTO dataDTO = this.e.get(i);
        com.rtk.app.tool.t.c(this.f37c, dataDTO.getUser().getFace(), this.d.auditPhotoListItemIcon, new boolean[0]);
        this.d.auditPhotoListItemNickName.setText(dataDTO.getUser().getNickname());
        this.d.auditPhotoListItemTime.setText(dataDTO.getAddtime());
        int parseInt = Integer.parseInt(dataDTO.getState());
        c.d.a.d.f(this.f37c, this.d.auditPhotoListItemState, parseInt);
        new ArrayList().add(this.e.get(i).getPic());
        com.rtk.app.tool.t.c(this.f37c, this.e.get(i).getPic(), this.d.auditPhotoListItemPicture, new boolean[0]);
        this.d.auditPhotoListItemGrade.setText(dataDTO.getUser().getUser_title().getTxt());
        int i2 = this.f;
        if (i2 == 1) {
            this.d.auditPhotoListItemPassBtu.setVisibility(parseInt == 3 ? 8 : 0);
            this.d.auditPhotoListItemNoPassBtu.setVisibility(parseInt == 1 ? 0 : 8);
            this.d.auditPhotoListItemDeleteBtu.setVisibility((parseInt == 4 || parseInt == 1 || parseInt == 2) ? 8 : 0);
        } else if (i2 == 2) {
            this.d.auditPhotoListItemPassBtu.setVisibility(parseInt == 1 ? 0 : 8);
            this.d.auditPhotoListItemNoPassBtu.setVisibility(parseInt == 1 ? 0 : 8);
            this.d.auditPhotoListItemDeleteBtu.setVisibility(8);
        } else {
            this.d.auditPhotoListItemPassBtu.setVisibility(8);
            this.d.auditPhotoListItemNoPassBtu.setVisibility(8);
            this.d.auditPhotoListItemDeleteBtu.setVisibility(8);
        }
        if (this.g == 1) {
            this.d.auditPhotoListItemAuditCheckUserLv.setVisibility(0);
            if (dataDTO.getCheck_user() != null && !com.rtk.app.tool.c0.q(dataDTO.getCheck_user().getCheck_nickname())) {
                com.rtk.app.tool.t.c(this.f37c, dataDTO.getCheck_user().getCheck_face(), this.d.auditPhotoListItemAuditCheckUserIcon, new boolean[0]);
                this.d.auditPhotoListItemAuditCheckUserNickName.setText(dataDTO.getCheck_user().getCheck_nickname());
                this.d.auditPhotoListItemAuditCheckUserReason.setText(dataDTO.getCheck_user().getCheck_reason());
            } else {
                this.d.auditPhotoListItemAuditCheckUserLv.setVisibility(8);
            }
        } else {
            this.d.auditPhotoListItemAuditCheckUserLv.setVisibility(8);
        }
        f(this.d, i);
        return view;
    }
}
