package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.bean.MyAttentionBean;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyAttentionAdapter extends a3 implements com.rtk.app.tool.s, h.j {

    /* renamed from: c, reason: collision with root package name */
    private Context f81c;
    private List<MyAttentionBean.DataBean> d;
    private DialogForProgressTip e;
    private List<com.rtk.app.tool.b0.c> f;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ViewHolder {

        @BindView
        TextView attentionItemAttentionState;

        @BindView
        TextView attentionItemFans;

        @BindView
        RoundedImageView attentionItemIcon;

        @BindView
        TextView attentionItemNickName;

        @BindView
        TextView attentionItemRemake;

        @BindView
        TextView attentionItemRtkUid;

        ViewHolder(View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.attentionItemIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.attention_item_icon, "field 'attentionItemIcon'", RoundedImageView.class);
            viewHolder.attentionItemNickName = (TextView) butterknife.c.a.c(view, R.id.attention_item_nickName, "field 'attentionItemNickName'", TextView.class);
            viewHolder.attentionItemRemake = (TextView) butterknife.c.a.c(view, R.id.attention_item_remake, "field 'attentionItemRemake'", TextView.class);
            viewHolder.attentionItemRtkUid = (TextView) butterknife.c.a.c(view, R.id.attention_item_rtk_uid, "field 'attentionItemRtkUid'", TextView.class);
            viewHolder.attentionItemFans = (TextView) butterknife.c.a.c(view, R.id.attention_item_fans, "field 'attentionItemFans'", TextView.class);
            viewHolder.attentionItemAttentionState = (TextView) butterknife.c.a.c(view, R.id.attention_item_attentionState, "field 'attentionItemAttentionState'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.attentionItemIcon = null;
                viewHolder.attentionItemNickName = null;
                viewHolder.attentionItemRemake = null;
                viewHolder.attentionItemRtkUid = null;
                viewHolder.attentionItemFans = null;
                viewHolder.attentionItemAttentionState = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public MyAttentionAdapter(Context context, List<MyAttentionBean.DataBean> list) {
        super(list);
        this.f = new ArrayList();
        this.f81c = context;
        this.d = list;
    }

    @Override // com.rtk.app.tool.s
    public void a(String... strArr) {
        if (com.rtk.app.tool.c0.q(com.rtk.app.tool.y.H())) {
            com.rtk.app.tool.f.a(this.f81c, "请先登录~", f.a.f);
            com.rtk.app.tool.t.w0(this.f81c);
        }
        Integer.parseInt(strArr[0]);
        int parseInt = Integer.parseInt(strArr[1]);
        StringBuilder sb = new StringBuilder();
        sb.append("members/follows");
        sb.append(com.rtk.app.tool.y.u(this.f81c));
        sb.append("&uid=");
        sb.append(com.rtk.app.tool.y.K());
        sb.append("&token=");
        sb.append(com.rtk.app.tool.y.H());
        sb.append("&fans=");
        sb.append(this.d.get(parseInt).getFans());
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f81c, "fans=" + this.d.get(parseInt).getFans(), "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
        String sb2 = sb.toString();
        this.e.show();
        com.rtk.app.tool.o.h.l(this.f81c, this, Integer.parseInt(this.d.get(parseInt).getFollowed()) + (parseInt * 10), com.rtk.app.tool.o.h.h(new String[0]).a(sb2));
    }

    @Override // com.rtk.app.adapter.a3
    public void b() {
        super.b();
        com.rtk.app.tool.b0.b.b().d(this.f);
        this.f.clear();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        int i2 = i / 10;
        int i3 = i % 10;
        this.e.dismiss();
        if (i3 != 1 && i3 != 2) {
            this.d.get(i2).setFollowed("1");
            com.rtk.app.tool.f.a(this.f81c, "关注成功", f.a.f);
            com.rtk.app.tool.b0.b.b().e(Integer.parseInt(this.d.get(i2).getFans()), 1);
        } else {
            this.d.get(i2).setFollowed("0");
            com.rtk.app.tool.f.a(this.f81c, "取消关注成功", f.a.f);
            com.rtk.app.tool.b0.b.b().e(Integer.parseInt(this.d.get(i2).getFans()), 0);
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.f81c, str, f.a.f);
        int i3 = i2 / 10;
        int i4 = i2 % 10;
        this.e.dismiss();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f81c).inflate(R.layout.post_attention_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        com.rtk.app.tool.t.c(this.f81c, this.d.get(i).getFace(), viewHolder.attentionItemIcon, new boolean[0]);
        viewHolder.attentionItemNickName.setText(this.d.get(i).getNickname());
        com.rtk.app.tool.g.h hVar = new com.rtk.app.tool.g.h();
        hVar.j(this.d.get(i).getFans());
        hVar.f(this.d.get(i));
        com.rtk.app.tool.b0.a aVar = new com.rtk.app.tool.b0.a(this.d.get(i).getFans(), this.d.get(i).getFollowed(), viewHolder.attentionItemAttentionState, hVar);
        com.rtk.app.tool.b0.b.b().a(aVar);
        this.f.add(aVar);
        if (!com.rtk.app.tool.c0.q(this.d.get(i).getNotename())) {
            viewHolder.attentionItemRemake.setVisibility(0);
            viewHolder.attentionItemRemake.setText("备注：" + this.d.get(i).getNotename());
        } else {
            viewHolder.attentionItemRemake.setVisibility(8);
        }
        viewHolder.attentionItemFans.setText(this.d.get(i).getFansNum());
        if (!com.rtk.app.tool.c0.q(this.d.get(i).getRtkUid())) {
            viewHolder.attentionItemRtkUid.setVisibility(0);
            viewHolder.attentionItemRtkUid.setText(this.d.get(i).getRtkUid());
        } else {
            viewHolder.attentionItemRtkUid.setVisibility(8);
        }
        com.rtk.app.tool.t.G1(viewHolder.attentionItemAttentionState, this.d.get(i).getFollowed(), i, this);
        DialogForProgressTip dialogForProgressTip = new DialogForProgressTip(this.f81c, "请稍后...");
        this.e = dialogForProgressTip;
        dialogForProgressTip.setCancelable(false);
        return view;
    }
}
