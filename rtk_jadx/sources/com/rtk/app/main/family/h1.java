package com.rtk.app.main.family;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.rtk.app.R;
import com.rtk.app.adapter.a3;
import com.rtk.app.bean.ApplyJoinFamilyInfo;
import com.rtk.app.custom.CustomSingleEditTextView;
import com.rtk.app.tool.o.h;
import com.umeng.analytics.pro.ak;
import java.util.HashMap;
import java.util.List;

/* compiled from: FamilyApplyJoinListAdapter.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class h1 extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f270c;
    private List<ApplyJoinFamilyInfo.DataBean> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FamilyApplyJoinListAdapter.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements h.j {
        final /* synthetic */ int a;
        final /* synthetic */ e b;

        a(int i, e eVar) {
            this.a = i;
            this.b = eVar;
        }

        @Override // com.rtk.app.tool.o.h.j
        public void d(String str, int i) {
            com.rtk.app.tool.f.a(h1.this.f270c, "已同意用户加入", ErrorCode.NETWORK_UNKNOWN);
            ((ApplyJoinFamilyInfo.DataBean) h1.this.d.get(this.a)).setStatus(GlobalSetting.SPLASH_AD);
            h1.this.o(this.a, this.b);
        }

        @Override // com.rtk.app.tool.o.h.j
        public void g(int i, String str, int i2) {
            com.rtk.app.tool.f.a(h1.this.f270c, str, ErrorCode.NETWORK_UNKNOWN);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FamilyApplyJoinListAdapter.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements DialogInterface.OnClickListener {
        final /* synthetic */ ApplyJoinFamilyInfo.DataBean a;
        final /* synthetic */ CustomSingleEditTextView b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f272c;
        final /* synthetic */ e d;
        final /* synthetic */ CheckBox e;

        /* compiled from: FamilyApplyJoinListAdapter.java */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        class a implements h.j {
            final /* synthetic */ String a;

            a(String str) {
                this.a = str;
            }

            @Override // com.rtk.app.tool.o.h.j
            public void d(String str, int i) {
                com.rtk.app.tool.f.a(h1.this.f270c, "已拒绝用户加入", ErrorCode.NETWORK_UNKNOWN);
                ((ApplyJoinFamilyInfo.DataBean) h1.this.d.get(b.this.f272c)).setStatus(this.a);
                b bVar = b.this;
                h1.this.o(bVar.f272c, bVar.d);
                if (b.this.e.isChecked()) {
                    b bVar2 = b.this;
                    h1.this.i(bVar2.a);
                }
            }

            @Override // com.rtk.app.tool.o.h.j
            public void g(int i, String str, int i2) {
                com.rtk.app.tool.f.a(h1.this.f270c, str, ErrorCode.NETWORK_UNKNOWN);
            }
        }

        b(ApplyJoinFamilyInfo.DataBean dataBean, CustomSingleEditTextView customSingleEditTextView, int i, e eVar, CheckBox checkBox) {
            this.a = dataBean;
            this.b = customSingleEditTextView;
            this.f272c = i;
            this.d = eVar;
            this.e = checkBox;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            HashMap hashMap = new HashMap();
            hashMap.put("channel", com.rtk.app.tool.y.m(h1.this.f270c, h1.this.f270c.getPackageName()));
            hashMap.put("version", com.rtk.app.tool.y.i(h1.this.f270c));
            hashMap.put(ak.aj, com.rtk.app.tool.y.g());
            hashMap.put("phone_model", com.rtk.app.tool.y.T());
            hashMap.put("id", this.a.getId());
            hashMap.put("msg", this.b.getContent().toString());
            hashMap.put("uid", com.rtk.app.tool.y.K() + "");
            hashMap.put("token", com.rtk.app.tool.y.H());
            hashMap.put("family_id", this.a.getFamily_id());
            hashMap.put("status", "2");
            hashMap.put("key", com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(h1.this.f270c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "status=2", "id=" + this.a.getId(), "family_id=" + this.a.getFamily_id()))));
            Context context = h1.this.f270c;
            a aVar = new a("2");
            StringBuilder sb = new StringBuilder();
            sb.append(com.rtk.app.tool.y.e);
            sb.append("family/join/user-result");
            com.rtk.app.tool.o.h.j(context, aVar, sb.toString(), 1, hashMap);
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FamilyApplyJoinListAdapter.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class c implements DialogInterface.OnClickListener {
        c(h1 h1Var) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FamilyApplyJoinListAdapter.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class d implements h.j {
        d(h1 h1Var) {
        }

        @Override // com.rtk.app.tool.o.h.j
        public void d(String str, int i) {
        }

        @Override // com.rtk.app.tool.o.h.j
        public void g(int i, String str, int i2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FamilyApplyJoinListAdapter.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class e {
        RoundedImageView a;
        TextView b;

        /* renamed from: c, reason: collision with root package name */
        TextView f273c;
        TextView d;
        TextView e;
        TextView f;
        TextView g;

        e(h1 h1Var, View view) {
            this.a = view.findViewById(R.id.family_logo);
            this.b = (TextView) view.findViewById(R.id.name);
            this.f273c = (TextView) view.findViewById(R.id.msg);
            this.d = (TextView) view.findViewById(R.id.accept);
            this.e = (TextView) view.findViewById(R.id.reject);
            this.f = (TextView) view.findViewById(R.id.lever);
            this.g = (TextView) view.findViewById(R.id.expire);
        }
    }

    public h1(Context context, List<ApplyJoinFamilyInfo.DataBean> list) {
        super(list);
        this.f270c = context;
        this.d = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ApplyJoinFamilyInfo.DataBean dataBean) {
        HashMap<String, String> l = com.rtk.app.tool.y.l();
        l.put("family_id", dataBean.getFamily_id());
        l.put("suid", dataBean.getUid());
        l.put("key", com.rtk.app.tool.t.L(l));
        com.rtk.app.tool.o.h.j(this.f270c, new d(this), com.rtk.app.tool.y.e + "family/user/blacklist-add", 5, l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(ApplyJoinFamilyInfo.DataBean dataBean, int i, e eVar, View view) {
        HashMap hashMap = new HashMap();
        Context context = this.f270c;
        hashMap.put("channel", com.rtk.app.tool.y.m(context, context.getPackageName()));
        hashMap.put("version", com.rtk.app.tool.y.i(this.f270c));
        hashMap.put(ak.aj, com.rtk.app.tool.y.g());
        hashMap.put("phone_model", com.rtk.app.tool.y.T());
        hashMap.put("id", dataBean.getId());
        hashMap.put("uid", com.rtk.app.tool.y.K() + "");
        hashMap.put("token", com.rtk.app.tool.y.H());
        hashMap.put("family_id", dataBean.getFamily_id());
        hashMap.put("status", GlobalSetting.SPLASH_AD);
        hashMap.put("key", com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f270c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "status=" + GlobalSetting.SPLASH_AD, "id=" + dataBean.getId(), "family_id=" + dataBean.getFamily_id()))));
        Context context2 = this.f270c;
        a aVar = new a(i, eVar);
        StringBuilder sb = new StringBuilder();
        sb.append(com.rtk.app.tool.y.e);
        sb.append("family/join/user-result");
        com.rtk.app.tool.o.h.j(context2, aVar, sb.toString(), 1, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(int i, e eVar, ApplyJoinFamilyInfo.DataBean dataBean, View view) {
        n(i, eVar, dataBean);
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [android.view.ViewGroup, com.rtk.app.custom.CustomSingleEditTextView] */
    private void n(int i, e eVar, ApplyJoinFamilyInfo.DataBean dataBean) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f270c);
        builder.setTitle("请输入拒绝加入家族原因");
        View inflate = LayoutInflater.from(this.f270c).inflate(R.layout.dialog_reject_join_family, (ViewGroup) null);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.checkBox);
        ?? r6 = (CustomSingleEditTextView) inflate.findViewById(R.id.custom_single_edit_text);
        r6.setBackground(ContextCompat.getDrawable(this.f270c, R.color.theme35));
        checkBox.setText("同时加入黑名单");
        checkBox.setChecked(false);
        builder.setView(inflate);
        builder.setPositiveButton("确定", new b(dataBean, r6, i, eVar, checkBox));
        builder.setNegativeButton("取消", new c(this));
        builder.create().show();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        e eVar;
        com.rtk.app.tool.c0.r("FamilyApplyJoinListAdapter", "getView--" + i + view);
        if (view == null) {
            view = LayoutInflater.from(this.f270c).inflate(R.layout.family_join_apply_list_item, (ViewGroup) null);
            eVar = new e(this, view);
            view.setTag(eVar);
        } else {
            eVar = (e) view.getTag();
        }
        super.c(i, view, viewGroup);
        o(i, eVar);
        return view;
    }

    void o(final int i, final e eVar) {
        final ApplyJoinFamilyInfo.DataBean dataBean = this.d.get(i);
        com.rtk.app.tool.t.c(this.f270c, dataBean.getFace(), eVar.a, new boolean[0]);
        eVar.b.setText(dataBean.getNickname());
        eVar.f273c.setText("验证消息：" + dataBean.getMsg());
        com.rtk.app.tool.t.T1(eVar.f, "", dataBean.getUser_title(), 5, 5);
        String status = dataBean.getStatus();
        status.hashCode();
        char c2 = 65535;
        switch (status.hashCode()) {
            case 49:
                if (status.equals("1")) {
                    c2 = 0;
                    break;
                }
                break;
            case 50:
                if (status.equals("2")) {
                    c2 = 1;
                    break;
                }
                break;
            case 51:
                if (status.equals(GlobalSetting.SPLASH_AD)) {
                    c2 = 2;
                    break;
                }
                break;
            case 52:
                if (status.equals(GlobalSetting.NATIVE_EXPRESS_AD)) {
                    c2 = 3;
                    break;
                }
                break;
            case 53:
                if (status.equals("5")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                eVar.d.setVisibility(0);
                eVar.d.setText("同意");
                eVar.d.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.main.family.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        h1.this.k(dataBean, i, eVar, view);
                    }
                });
                eVar.e.setVisibility(0);
                eVar.e.setText("拒绝");
                eVar.e.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.main.family.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        h1.this.m(i, eVar, dataBean, view);
                    }
                });
                eVar.g.setVisibility(8);
                return;
            case 1:
                eVar.e.setVisibility(0);
                eVar.e.setText("已拒绝");
                eVar.e.setOnClickListener(null);
                eVar.d.setVisibility(8);
                eVar.g.setVisibility(8);
                return;
            case 2:
                eVar.d.setVisibility(0);
                eVar.d.setText("已同意");
                eVar.d.setOnClickListener(null);
                eVar.e.setVisibility(8);
                eVar.g.setVisibility(8);
                return;
            case 3:
                eVar.g.setVisibility(0);
                eVar.g.setText("已过期");
                eVar.d.setVisibility(8);
                eVar.e.setVisibility(8);
                return;
            case 4:
                eVar.g.setVisibility(0);
                eVar.g.setText("用户撤回");
                eVar.d.setVisibility(8);
                eVar.e.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
