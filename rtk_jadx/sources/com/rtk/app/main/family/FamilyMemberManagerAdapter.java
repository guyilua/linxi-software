package com.rtk.app.main.family;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qq.e.comm.constants.ErrorCode;
import com.rtk.app.R;
import com.rtk.app.adapter.a3;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.FamilyMemberInfo;
import com.rtk.app.tool.o.h;
import com.umeng.analytics.pro.ak;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyMemberManagerAdapter extends a3 implements h.j {

    /* renamed from: c, reason: collision with root package name */
    private Context f262c;
    private List<FamilyMemberInfo.DataBean> d;
    private String e;
    private int f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder {

        @BindView
        TextView userRankItemAttentionState;

        @BindView
        RoundedImageView userRankItemIcon;

        @BindView
        TextView userRankItemLever;

        @BindView
        LinearLayout userRankItemMedal;

        @BindView
        TextView userRankItemNickName;

        @BindView
        TextView userRankItemNoteName;

        ViewHolder(FamilyMemberManagerAdapter familyMemberManagerAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.userRankItemIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.user_rank_item_icon, "field 'userRankItemIcon'", RoundedImageView.class);
            viewHolder.userRankItemNickName = (TextView) butterknife.c.a.c(view, R.id.user_rank_item_nickName, "field 'userRankItemNickName'", TextView.class);
            viewHolder.userRankItemAttentionState = (TextView) butterknife.c.a.c(view, R.id.user_rank_item_attentionState, "field 'userRankItemAttentionState'", TextView.class);
            viewHolder.userRankItemMedal = (LinearLayout) butterknife.c.a.c(view, R.id.user_rank_item_medal, "field 'userRankItemMedal'", LinearLayout.class);
            viewHolder.userRankItemNoteName = (TextView) butterknife.c.a.c(view, R.id.user_rank_item_notename, "field 'userRankItemNoteName'", TextView.class);
            viewHolder.userRankItemLever = (TextView) butterknife.c.a.c(view, R.id.user_rank_item_lever, "field 'userRankItemLever'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.userRankItemIcon = null;
                viewHolder.userRankItemNickName = null;
                viewHolder.userRankItemAttentionState = null;
                viewHolder.userRankItemMedal = null;
                viewHolder.userRankItemNoteName = null;
                viewHolder.userRankItemLever = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements View.OnClickListener {
        final /* synthetic */ FamilyMemberInfo.DataBean a;
        final /* synthetic */ int b;

        a(FamilyMemberInfo.DataBean dataBean, int i) {
            this.a = dataBean;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FamilyMemberManagerAdapter.this.f != 0) {
                FamilyMemberManagerAdapter.this.o(this.a, this.b);
            } else {
                FamilyMemberManagerAdapter.this.p(this.a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements DialogInterface.OnClickListener {
        b(FamilyMemberManagerAdapter familyMemberManagerAdapter) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class c implements DialogInterface.OnClickListener {
        c(FamilyMemberManagerAdapter familyMemberManagerAdapter) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public FamilyMemberManagerAdapter(Context context, String str, List<FamilyMemberInfo.DataBean> list) {
        super(list);
        this.f = 0;
        this.f262c = context;
        this.e = str;
        this.d = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(boolean z, FamilyMemberInfo.DataBean dataBean, DialogInterface dialogInterface, int i) {
        String str = z ? "family/user/permission-cancel" : "family/user/permission-add";
        HashMap hashMap = new HashMap();
        Context context = this.f262c;
        hashMap.put("channel", com.rtk.app.tool.y.m(context, context.getPackageName()));
        hashMap.put("version", com.rtk.app.tool.y.i(this.f262c));
        hashMap.put(ak.aj, com.rtk.app.tool.y.g());
        hashMap.put("phone_model", com.rtk.app.tool.y.T());
        hashMap.put("suid", dataBean.getUid());
        hashMap.put("uid", com.rtk.app.tool.y.K() + "");
        hashMap.put("token", com.rtk.app.tool.y.H());
        hashMap.put("family_id", this.e);
        hashMap.put(com.umeng.analytics.pro.d.y, this.f + "");
        hashMap.put("key", com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f262c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "suid=" + dataBean.getUid(), "type=" + this.f + "", "family_id=" + this.e))));
        Context context2 = this.f262c;
        StringBuilder sb = new StringBuilder();
        sb.append(com.rtk.app.tool.y.e);
        sb.append(str);
        com.rtk.app.tool.o.h.j(context2, this, sb.toString(), 1, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(FamilyMemberInfo.DataBean dataBean, CheckBox checkBox, DialogInterface dialogInterface, int i) {
        HashMap hashMap = new HashMap();
        Context context = this.f262c;
        hashMap.put("channel", com.rtk.app.tool.y.m(context, context.getPackageName()));
        hashMap.put("version", com.rtk.app.tool.y.i(this.f262c));
        hashMap.put(ak.aj, com.rtk.app.tool.y.g());
        hashMap.put("phone_model", com.rtk.app.tool.y.T());
        hashMap.put("delete_uid", dataBean.getUid());
        hashMap.put("uid", com.rtk.app.tool.y.K() + "");
        hashMap.put("token", com.rtk.app.tool.y.H());
        hashMap.put("family_id", this.e);
        if (checkBox.isChecked()) {
            hashMap.put("is_black", "1");
        }
        hashMap.put("key", com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f262c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "delete_uid=" + dataBean.getUid(), "family_id=" + this.e))));
        Context context2 = this.f262c;
        StringBuilder sb = new StringBuilder();
        sb.append(com.rtk.app.tool.y.e);
        sb.append("family/user/delete");
        com.rtk.app.tool.o.h.j(context2, this, sb.toString(), 1, hashMap);
    }

    private void l(ViewHolder viewHolder, FamilyMemberInfo.DataBean dataBean, int i) {
        viewHolder.userRankItemAttentionState.setOnClickListener(new a(dataBean, i));
    }

    private void m(ViewHolder viewHolder, FamilyMemberInfo.DataBean dataBean) {
        int i;
        if (dataBean.isHeadLeader()) {
            viewHolder.userRankItemAttentionState.setVisibility(8);
            return;
        }
        viewHolder.userRankItemAttentionState.setVisibility(0);
        int i2 = this.f;
        if (i2 == 0) {
            viewHolder.userRankItemAttentionState.setText(R.string.delete);
            l(viewHolder, dataBean, -1);
            return;
        }
        if (i2 == 1) {
            i = dataBean.isSecondLeader() ? R.string.remove_fu_zu_zhang : R.string.add_fu_zu_zhang;
        } else if (i2 == 2) {
            i = dataBean.isBbsAdmin() ? R.string.remove_board_master : R.string.add_board_master;
        } else if (i2 != 3) {
            i = -1;
        } else {
            i = dataBean.isUpAdmin() ? R.string.remove_up_audit : R.string.add_up_audit;
        }
        if (i == -1) {
            return;
        }
        viewHolder.userRankItemAttentionState.setBackgroundResource(R.drawable.shape_corner_theme26_5dp);
        viewHolder.userRankItemAttentionState.setText(i);
        l(viewHolder, dataBean, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(final FamilyMemberInfo.DataBean dataBean, int i) {
        String str;
        String string = this.f262c.getString(i);
        final boolean z = false;
        if (i == 2131886478) {
            str = "是否确认将" + dataBean.getNickname() + "移除副族长?";
        } else {
            if (i == 2131886113) {
                str = "是否确认将" + dataBean.getNickname() + "设置为副族长?";
            } else if (i == 2131886477) {
                str = "是否确认将" + dataBean.getNickname() + "移除版主?";
            } else if (i == 2131886112) {
                str = "是否确认将" + dataBean.getNickname() + "设置为版主?";
            } else if (i == 2131886479) {
                str = "是否确认将" + dataBean.getNickname() + "移除UP审核?";
            } else {
                str = "是否确认将" + dataBean.getNickname() + "设置为UP审核?";
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f262c);
            builder.setTitle(string);
            builder.setMessage(str);
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.rtk.app.main.family.t
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    FamilyMemberManagerAdapter.this.i(z, dataBean, dialogInterface, i2);
                }
            });
            builder.setNegativeButton("取消", new b(this));
            builder.create().show();
        }
        z = true;
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this.f262c);
        builder2.setTitle(string);
        builder2.setMessage(str);
        builder2.setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.rtk.app.main.family.t
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                FamilyMemberManagerAdapter.this.i(z, dataBean, dialogInterface, i2);
            }
        });
        builder2.setNegativeButton("取消", new b(this));
        builder2.create().show();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.r("FamilyMemberManagerAdapter", "str=" + str);
        com.rtk.app.tool.f.a(this.f262c, "操作成功", ErrorCode.NETWORK_UNKNOWN);
        ((BaseActivity) this.f262c).S();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.r("FamilyMemberManagerAdapter", "error, code=" + i + ",str=" + str);
        com.rtk.app.tool.f.a(this.f262c, str, ErrorCode.NETWORK_UNKNOWN);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f262c).inflate(R.layout.family_member_list_item, (ViewGroup) null);
            viewHolder = new ViewHolder(this, view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        FamilyMemberInfo.DataBean dataBean = this.d.get(i);
        viewHolder.userRankItemNickName.setTag(dataBean);
        com.rtk.app.tool.t.d(this.f262c, dataBean.getFace(), viewHolder.userRankItemIcon);
        if (!com.rtk.app.tool.c0.q(dataBean.getNotename())) {
            viewHolder.userRankItemNoteName.setVisibility(0);
            viewHolder.userRankItemNoteName.setText("备注：" + this.d.get(i).getNotename());
        } else {
            viewHolder.userRankItemNoteName.setVisibility(8);
        }
        viewHolder.userRankItemNickName.setText(dataBean.getNickname());
        if (this.d.get(i).getMedalList() != null) {
            com.rtk.app.tool.t.p1(this.f262c, viewHolder.userRankItemMedal, dataBean.getMedalList().getAchievement(), this.d.get(i).getMedalList().getEventMedal());
        }
        com.rtk.app.tool.t.T1(viewHolder.userRankItemLever, "", this.d.get(i).getAdmin_title(), 25, 25);
        m(viewHolder, dataBean);
        return view;
    }

    public void n(int i) {
        this.f = i;
    }

    void p(final FamilyMemberInfo.DataBean dataBean) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f262c);
        builder.setTitle("移除家族人员");
        builder.setMessage("您确认要移除" + dataBean.getNickname() + "吗?");
        final CheckBox checkBox = new CheckBox(this.f262c);
        checkBox.setText("同时加入黑名单");
        checkBox.setChecked(false);
        builder.setView(checkBox);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.rtk.app.main.family.u
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                FamilyMemberManagerAdapter.this.k(dataBean, checkBox, dialogInterface, i);
            }
        });
        builder.setNegativeButton("取消", new c(this));
        builder.create().show();
    }
}
