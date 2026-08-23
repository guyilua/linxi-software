package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.bean.MyAttentionBean;
import com.rtk.app.main.dialogPack.DialogAddBlacklist;
import com.rtk.app.main.dialogPack.DialogEditTipEnsure;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.tool.j;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyAttentionSearchAdapter extends a3 implements com.rtk.app.tool.s, h.j {

    /* renamed from: c, reason: collision with root package name */
    private Context f82c;
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

        @BindView
        ImageView more;

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
            viewHolder.more = (ImageView) butterknife.c.a.c(view, R.id.more, "field 'more'", ImageView.class);
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
                viewHolder.more = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements View.OnClickListener {
        final /* synthetic */ int a;
        final /* synthetic */ ViewGroup b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewHolder f83c;
        final /* synthetic */ MyAttentionBean.DataBean d;

        a(int i, ViewGroup viewGroup, ViewHolder viewHolder, MyAttentionBean.DataBean dataBean) {
            this.a = i;
            this.b = viewGroup;
            this.f83c = viewHolder;
            this.d = dataBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MyAttentionSearchAdapter.this.m(this.a, view, this.b, this.f83c.attentionItemAttentionState, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements com.rtk.app.base.h {
        final /* synthetic */ MyAttentionBean.DataBean a;
        final /* synthetic */ int b;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        class a implements h.j {
            final /* synthetic */ String a;

            a(String str) {
                this.a = str;
            }

            @Override // com.rtk.app.tool.o.h.j
            public void d(String str, int i) {
                ((MyAttentionBean.DataBean) MyAttentionSearchAdapter.this.d.get(b.this.b)).setNotename(this.a);
                com.rtk.app.tool.b0.b.b().e(Integer.parseInt(((MyAttentionBean.DataBean) MyAttentionSearchAdapter.this.d.get(b.this.b)).getFans()), Integer.parseInt(b.this.a.getFollowed()));
            }

            @Override // com.rtk.app.tool.o.h.j
            public void g(int i, String str, int i2) {
                com.rtk.app.tool.f.a(MyAttentionSearchAdapter.this.f82c, str, f.a.f);
            }
        }

        b(MyAttentionBean.DataBean dataBean, int i) {
            this.a = dataBean;
            this.b = i;
        }

        @Override // com.rtk.app.base.h
        public void a(String... strArr) {
        }

        @Override // com.rtk.app.base.h
        public void b(String... strArr) {
            if (strArr.length < 1) {
                com.rtk.app.tool.c0.s("MyAttentionSearchAdapter", "未返回内容");
                com.rtk.app.tool.f.a(MyAttentionSearchAdapter.this.f82c, "请输入备注", 5000);
                return;
            }
            String str = strArr[0];
            HashMap hashMap = new HashMap();
            hashMap.put("channel", com.rtk.app.tool.y.m(MyAttentionSearchAdapter.this.f82c, MyAttentionSearchAdapter.this.f82c.getPackageName()));
            hashMap.put("version", com.rtk.app.tool.y.i(MyAttentionSearchAdapter.this.f82c));
            hashMap.put(ak.aj, com.rtk.app.tool.y.g());
            hashMap.put("phone_model", com.rtk.app.tool.y.T());
            hashMap.put("uid", com.rtk.app.tool.y.K());
            hashMap.put("token", com.rtk.app.tool.y.H());
            hashMap.put("toUid", this.a.getFans());
            hashMap.put("toName", str);
            hashMap.put("key", com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(MyAttentionSearchAdapter.this.f82c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "toUid=" + this.a.getFans(), "toName=" + str))));
            Context context = MyAttentionSearchAdapter.this.f82c;
            a aVar = new a(str);
            StringBuilder sb = new StringBuilder();
            sb.append(com.rtk.app.tool.y.e);
            sb.append("user/nickname/notes");
            com.rtk.app.tool.o.h.j(context, aVar, sb.toString(), 10, hashMap);
        }
    }

    public MyAttentionSearchAdapter(Context context, List<MyAttentionBean.DataBean> list) {
        super(list);
        this.f = new ArrayList();
        this.f82c = context;
        this.d = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(int i, j.a aVar) {
        if (aVar == j.a.YES) {
            this.d.get(i).setFollowed("0");
            com.rtk.app.tool.b0.b.b().e(Integer.parseInt(this.d.get(i).getFans()), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean l(final int i, ViewGroup viewGroup, MyAttentionBean.DataBean dataBean, TextView textView, MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 2131296527) {
            textView.performClick();
            return false;
        }
        if (itemId == 2131296534) {
            n(i, viewGroup, dataBean);
            return false;
        }
        if (itemId != 2131296797) {
            return false;
        }
        new DialogAddBlacklist(this.f82c, null, null, dataBean.getFans(), new com.rtk.app.tool.j() { // from class: com.rtk.app.adapter.n1
            @Override // com.rtk.app.tool.j
            public final void m(j.a aVar) {
                MyAttentionSearchAdapter.this.j(i, aVar);
            }
        }).show();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(final int i, View view, final ViewGroup viewGroup, final TextView textView, final MyAttentionBean.DataBean dataBean) {
        PopupMenu popupMenu = new PopupMenu(this.f82c, view);
        popupMenu.getMenuInflater().inflate(R.menu.attention_search, popupMenu.getMenu());
        String followed = dataBean.getFollowed();
        if (!"1".equals(followed) && !"2".equals(followed)) {
            popupMenu.getMenu().getItem(1).setTitle("关注");
        } else {
            popupMenu.getMenu().getItem(1).setTitle("取消关注");
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.rtk.app.adapter.o1
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return MyAttentionSearchAdapter.this.l(i, viewGroup, dataBean, textView, menuItem);
            }
        });
        popupMenu.show();
    }

    private void n(int i, ViewGroup viewGroup, MyAttentionBean.DataBean dataBean) {
        DialogEditTipEnsure dialogEditTipEnsure = new DialogEditTipEnsure(this.f82c, "修改备注", new b(dataBean, i));
        dialogEditTipEnsure.q("请输入备注");
        if (!com.rtk.app.tool.c0.q(dataBean.getNotename())) {
            dialogEditTipEnsure.r(dataBean.getNotename());
        }
        dialogEditTipEnsure.s(1);
        dialogEditTipEnsure.t(10, "备注信息不可超过10个字符");
        dialogEditTipEnsure.show();
    }

    @Override // com.rtk.app.tool.s
    public void a(String... strArr) {
        if (com.rtk.app.tool.c0.q(com.rtk.app.tool.y.H())) {
            com.rtk.app.tool.f.a(this.f82c, "请先登录~", f.a.f);
            com.rtk.app.tool.t.w0(this.f82c);
        }
        Integer.parseInt(strArr[0]);
        int parseInt = Integer.parseInt(strArr[1]);
        StringBuilder sb = new StringBuilder();
        sb.append("members/follows");
        sb.append(com.rtk.app.tool.y.u(this.f82c));
        sb.append("&uid=");
        sb.append(com.rtk.app.tool.y.K());
        sb.append("&token=");
        sb.append(com.rtk.app.tool.y.H());
        sb.append("&fans=");
        sb.append(this.d.get(parseInt).getFans());
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f82c, "fans=" + this.d.get(parseInt).getFans(), "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
        String sb2 = sb.toString();
        this.e.show();
        com.rtk.app.tool.o.h.l(this.f82c, this, Integer.parseInt(this.d.get(parseInt).getFollowed()) + (parseInt * 10), com.rtk.app.tool.o.h.h(new String[0]).a(sb2));
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
            com.rtk.app.tool.f.a(this.f82c, "关注成功", f.a.f);
            com.rtk.app.tool.b0.b.b().e(Integer.parseInt(this.d.get(i2).getFans()), 1);
        } else {
            this.d.get(i2).setFollowed("0");
            com.rtk.app.tool.f.a(this.f82c, "取消关注成功", f.a.f);
            com.rtk.app.tool.b0.b.b().e(Integer.parseInt(this.d.get(i2).getFans()), 0);
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.f82c, str, f.a.f);
        int i3 = i2 / 10;
        int i4 = i2 % 10;
        this.e.dismiss();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        View view2;
        if (view == null) {
            View inflate = LayoutInflater.from(this.f82c).inflate(R.layout.post_attention_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(inflate);
            inflate.setTag(viewHolder);
            view2 = inflate;
        } else {
            viewHolder = (ViewHolder) view.getTag();
            view2 = view;
        }
        ViewHolder viewHolder2 = viewHolder;
        MyAttentionBean.DataBean dataBean = this.d.get(i);
        com.rtk.app.tool.t.c(this.f82c, dataBean.getFace(), viewHolder2.attentionItemIcon, new boolean[0]);
        viewHolder2.attentionItemNickName.setText(dataBean.getNickname());
        com.rtk.app.tool.g.h hVar = new com.rtk.app.tool.g.h();
        hVar.j(dataBean.getFans());
        hVar.f(dataBean);
        viewHolder2.more.setVisibility(0);
        viewHolder2.more.setOnClickListener(new a(i, viewGroup, viewHolder2, dataBean));
        com.rtk.app.tool.b0.a aVar = new com.rtk.app.tool.b0.a(dataBean.getFans(), dataBean.getFollowed(), viewHolder2.attentionItemAttentionState, viewHolder2.attentionItemRemake, hVar);
        com.rtk.app.tool.b0.b.b().a(aVar);
        this.f.add(aVar);
        if (!com.rtk.app.tool.c0.q(dataBean.getNotename())) {
            viewHolder2.attentionItemRemake.setVisibility(0);
            viewHolder2.attentionItemRemake.setText("备注：" + dataBean.getNotename());
        } else {
            viewHolder2.attentionItemRemake.setVisibility(8);
        }
        viewHolder2.attentionItemFans.setText(dataBean.getFansNum());
        if (!com.rtk.app.tool.c0.q(dataBean.getRtkUid())) {
            viewHolder2.attentionItemRtkUid.setVisibility(0);
            viewHolder2.attentionItemRtkUid.setText(dataBean.getRtkUid());
        } else {
            viewHolder2.attentionItemRtkUid.setVisibility(8);
        }
        com.rtk.app.tool.t.G1(viewHolder2.attentionItemAttentionState, dataBean.getFollowed(), i, this);
        DialogForProgressTip dialogForProgressTip = new DialogForProgressTip(this.f82c, "请稍后...");
        this.e = dialogForProgressTip;
        dialogForProgressTip.setCancelable(false);
        return view2;
    }
}
