package com.rtk.app.main.family;

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
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.adapter.a3;
import com.rtk.app.bean.FamilyMemberInfo;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyMemberAdapter extends a3 implements h.j, com.rtk.app.tool.s {

    /* renamed from: c, reason: collision with root package name */
    private Context f261c;
    private List<FamilyMemberInfo.DataBean> d;
    private DialogForProgressTip e;
    private List<com.rtk.app.tool.b0.c> f;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ViewHolder {
        View a;

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

        ViewHolder(View view) {
            ButterKnife.b(this, view);
            this.a = this.a;
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
            viewHolder.userRankItemLever = (TextView) butterknife.c.a.c(view, R.id.user_rank_item_lever, "field 'userRankItemLever'", TextView.class);
            viewHolder.userRankItemAttentionState = (TextView) butterknife.c.a.c(view, R.id.user_rank_item_attentionState, "field 'userRankItemAttentionState'", TextView.class);
            viewHolder.userRankItemMedal = (LinearLayout) butterknife.c.a.c(view, R.id.user_rank_item_medal, "field 'userRankItemMedal'", LinearLayout.class);
            viewHolder.userRankItemNoteName = (TextView) butterknife.c.a.c(view, R.id.user_rank_item_notename, "field 'userRankItemNoteName'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.userRankItemIcon = null;
                viewHolder.userRankItemNickName = null;
                viewHolder.userRankItemLever = null;
                viewHolder.userRankItemAttentionState = null;
                viewHolder.userRankItemMedal = null;
                viewHolder.userRankItemNoteName = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public FamilyMemberAdapter(Context context, String str, List<FamilyMemberInfo.DataBean> list) {
        super(list);
        this.f = new ArrayList();
        this.f261c = context;
        this.d = list;
        DialogForProgressTip dialogForProgressTip = new DialogForProgressTip(context, "请稍后...");
        this.e = dialogForProgressTip;
        dialogForProgressTip.setCancelable(false);
    }

    @Override // com.rtk.app.tool.s
    public void a(String... strArr) {
        if (com.rtk.app.tool.c0.q(com.rtk.app.tool.y.H())) {
            com.rtk.app.tool.f.a(this.f261c, "请先登录~", f.a.f);
            com.rtk.app.tool.t.w0(this.f261c);
        }
        int parseInt = Integer.parseInt(strArr[1]);
        int followed = this.d.get(parseInt).getFollowed();
        StringBuilder sb = new StringBuilder();
        sb.append("members/follows");
        sb.append(com.rtk.app.tool.y.u(this.f261c));
        sb.append("&uid=");
        sb.append(com.rtk.app.tool.y.K());
        sb.append("&token=");
        sb.append(com.rtk.app.tool.y.H());
        sb.append("&fans=");
        sb.append(this.d.get(parseInt).getUid());
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f261c, "fans=" + this.d.get(parseInt).getUid(), "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
        String sb2 = sb.toString();
        this.e.show();
        com.rtk.app.tool.o.h.l(this.f261c, this, followed + (parseInt * 10), com.rtk.app.tool.o.h.h(new String[0]).a(sb2));
    }

    @Override // com.rtk.app.adapter.a3
    public void b() {
        super.b();
        com.rtk.app.tool.b0.b.b().d(this.f);
        this.f.clear();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("FamilyMemberAdapter", "关注状态  " + str);
        int i2 = i / 10;
        int i3 = i % 10;
        this.e.dismiss();
        if (i3 != 1 && i3 != 2) {
            com.rtk.app.tool.f.a(this.f261c, "关注成功", f.a.f);
            com.rtk.app.tool.b0.b.b().e(Integer.parseInt(this.d.get(i2).getUid()), 1);
        } else {
            com.rtk.app.tool.f.a(this.f261c, "取消关注成功", f.a.f);
            com.rtk.app.tool.b0.b.b().e(Integer.parseInt(this.d.get(i2).getUid()), 0);
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.f261c, str, f.a.f);
        int i3 = i2 / 10;
        int i4 = i2 % 10;
        this.e.dismiss();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f261c).inflate(R.layout.family_member_list_item, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.userRankItemNickName.setTag(this.d.get(i));
        com.rtk.app.tool.t.d(this.f261c, this.d.get(i).getFace(), viewHolder.userRankItemIcon);
        if (!com.rtk.app.tool.c0.q(this.d.get(i).getNotename())) {
            viewHolder.userRankItemNoteName.setVisibility(0);
            viewHolder.userRankItemNoteName.setText("备注：" + this.d.get(i).getNotename());
        } else {
            viewHolder.userRankItemNoteName.setVisibility(8);
        }
        com.rtk.app.tool.g.h hVar = new com.rtk.app.tool.g.h();
        hVar.j(this.d.get(i).getUid());
        hVar.k(this.d.get(i));
        com.rtk.app.tool.b0.a aVar = new com.rtk.app.tool.b0.a(this.d.get(i).getUid(), this.d.get(i).getFollowed() + "", viewHolder.userRankItemAttentionState, viewHolder.userRankItemNoteName, hVar);
        this.f.add(aVar);
        com.rtk.app.tool.b0.b.b().a(aVar);
        com.rtk.app.tool.t.G1(viewHolder.userRankItemAttentionState, this.d.get(i).getFollowed() + "", i, this);
        viewHolder.userRankItemNickName.setText(this.d.get(i).getNickname());
        com.rtk.app.tool.t.T1(viewHolder.userRankItemLever, "", this.d.get(i).getAdmin_title(), 25, 25);
        if (this.d.get(i).getMedalList() != null) {
            com.rtk.app.tool.t.p1(this.f261c, viewHolder.userRankItemMedal, this.d.get(i).getMedalList().getAchievement(), this.d.get(i).getMedalList().getEventMedal());
        }
        return view;
    }
}
