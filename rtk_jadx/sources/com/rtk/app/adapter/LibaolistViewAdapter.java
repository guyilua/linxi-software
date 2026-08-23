package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.bean.GiftNumberBean;
import com.rtk.app.bean.LiBaoListBean;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.dialogPack.DilalogLibao;
import com.rtk.app.main.dialogPack.DilalogLibaoTaoHao;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class LibaolistViewAdapter extends a3 implements h.j {

    /* renamed from: c, reason: collision with root package name */
    private Context f80c;
    private List<LiBaoListBean.DataBean> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        TextView libaolistListviewItemBtu;

        @BindView
        ImageView libaolistListviewItemIcon;

        @BindView
        TextView libaolistListviewItemIntro;

        @BindView
        TextView libaolistListviewItemName;

        @BindView
        TextView libaolistListviewItemPlan;

        @BindView
        ProgressBar libaolistListviewItemProgressBar;

        @BindView
        LinearLayout libaolistListviewItemProgressBarLayout;

        @BindView
        TextView libaolistListviewItemReceiveNumber;

        ViewHolder(LibaolistViewAdapter libaolistViewAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.libaolistListviewItemIcon = (ImageView) butterknife.c.a.c(view, R.id.libaolist_listview_item_icon, "field 'libaolistListviewItemIcon'", ImageView.class);
            viewHolder.libaolistListviewItemName = (TextView) butterknife.c.a.c(view, R.id.libaolist_listview_item_name, "field 'libaolistListviewItemName'", TextView.class);
            viewHolder.libaolistListviewItemProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.libaolist_listview_item_progressBar, "field 'libaolistListviewItemProgressBar'", ProgressBar.class);
            viewHolder.libaolistListviewItemPlan = (TextView) butterknife.c.a.c(view, R.id.libaolist_listview_item_plan, "field 'libaolistListviewItemPlan'", TextView.class);
            viewHolder.libaolistListviewItemIntro = (TextView) butterknife.c.a.c(view, R.id.libaolist_listview_item_intro, "field 'libaolistListviewItemIntro'", TextView.class);
            viewHolder.libaolistListviewItemBtu = (TextView) butterknife.c.a.c(view, R.id.libaolist_listview_item_Btu, "field 'libaolistListviewItemBtu'", TextView.class);
            viewHolder.libaolistListviewItemProgressBarLayout = (LinearLayout) butterknife.c.a.c(view, R.id.libaolist_listview_item_progressBar_layout, "field 'libaolistListviewItemProgressBarLayout'", LinearLayout.class);
            viewHolder.libaolistListviewItemReceiveNumber = (TextView) butterknife.c.a.c(view, R.id.libaolist_listview_item_receiveNumber, "field 'libaolistListviewItemReceiveNumber'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.libaolistListviewItemIcon = null;
                viewHolder.libaolistListviewItemName = null;
                viewHolder.libaolistListviewItemProgressBar = null;
                viewHolder.libaolistListviewItemPlan = null;
                viewHolder.libaolistListviewItemIntro = null;
                viewHolder.libaolistListviewItemBtu = null;
                viewHolder.libaolistListviewItemProgressBarLayout = null;
                viewHolder.libaolistListviewItemReceiveNumber = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TextView textView = (TextView) view;
            int intValue = ((Integer) view.getTag()).intValue();
            String trim = textView.getText().toString().trim();
            trim.hashCode();
            char c2 = 65535;
            switch (trim.hashCode()) {
                case 727753:
                    if (trim.equals("复制")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 893215:
                    if (trim.equals("淘号")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1233814:
                    if (trim.equals("预定")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 25248619:
                    if (trim.equals("抢礼包")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 667554696:
                    if (trim.equals("取消预定")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    com.rtk.app.tool.t.I1(LibaolistViewAdapter.this.f80c, ((LiBaoListBean.DataBean) LibaolistViewAdapter.this.d.get(intValue)).getGift_content());
                    return;
                case 1:
                    LibaolistViewAdapter.this.h(6, intValue);
                    return;
                case 2:
                    LibaolistViewAdapter.this.h(4, intValue);
                    return;
                case 3:
                    com.rtk.app.tool.c0.u("LibaolistViewAdapter", "礼包包名" + ((LiBaoListBean.DataBean) LibaolistViewAdapter.this.d.get(intValue)).getGame_package_name() + "   " + ((LiBaoListBean.DataBean) LibaolistViewAdapter.this.d.get(intValue)).getOtherPackage());
                    if (((LiBaoListBean.DataBean) LibaolistViewAdapter.this.d.get(intValue)).getNeed_install_game() != 0 && !com.rtk.app.tool.t.q1(LibaolistViewAdapter.this.f80c, ((LiBaoListBean.DataBean) LibaolistViewAdapter.this.d.get(intValue)).getGame_package_name()) && !com.rtk.app.tool.t.q1(LibaolistViewAdapter.this.f80c, ((LiBaoListBean.DataBean) LibaolistViewAdapter.this.d.get(intValue)).getOtherPackage())) {
                        com.rtk.app.tool.f.a(LibaolistViewAdapter.this.f80c, "请安装游戏后再领取", f.a.f);
                        return;
                    } else {
                        LibaolistViewAdapter.this.h(7, intValue);
                        return;
                    }
                case 4:
                    LibaolistViewAdapter.this.h(3, intValue);
                    return;
                default:
                    return;
            }
        }
    }

    public LibaolistViewAdapter(Context context, List<LiBaoListBean.DataBean> list) {
        super(list);
        this.d = list;
        this.f80c = context;
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("LibaolistViewAdapter", "抢礼包" + str);
        int i2 = i % 100000;
        int i3 = i / 100000;
        try {
            GiftNumberBean giftNumberBean = (GiftNumberBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, GiftNumberBean.class);
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 6) {
                        if (i3 == 7) {
                            com.rtk.app.tool.c0.u("LibaolistViewAdapter", "抢礼包" + str);
                            if (giftNumberBean.getCode() == 0) {
                                this.d.get(i2).setGift_content(giftNumberBean.getData().getReceive_code());
                                this.d.get(i2).setGift_status(1);
                                new DilalogLibao(MyApplication.b(), giftNumberBean.getData().getReceive_code(), new ApkInfo(this.d.get(i2).getGame_id(), this.d.get(i2).getGame_name(), this.d.get(i2).getGame_package_name(), this.d.get(i2).getGame_logo(), null, null, 0, 0, null)).show();
                            }
                        }
                    } else if (giftNumberBean.getCode() == 0) {
                        this.d.get(i2).setGift_content(giftNumberBean.getData().getTake_out_code());
                        new DilalogLibaoTaoHao(MyApplication.b(), giftNumberBean.getData().getTake_out_code(), new ApkInfo(this.d.get(i2).getGame_id(), this.d.get(i2).getGame_name(), this.d.get(i2).getGame_package_name(), this.d.get(i2).getGame_logo(), null, null, 0, 0, null)).show();
                    }
                } else if (giftNumberBean.getCode() == 0) {
                    this.d.get(i2).setGift_status(3);
                }
            } else if (giftNumberBean.getCode() == 0) {
                this.d.get(i2).setGift_status(4);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            notifyDataSetChanged();
            throw th;
        }
        notifyDataSetChanged();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.f80c, str, f.a.f);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f80c).inflate(R.layout.libaolist_listview_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(this, view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        com.rtk.app.tool.t.d(this.f80c, this.d.get(i).getGame_logo(), viewHolder.libaolistListviewItemIcon);
        viewHolder.libaolistListviewItemIntro.setText(this.d.get(i).getGift_description());
        viewHolder.libaolistListviewItemName.setText(this.d.get(i).getGift_title());
        viewHolder.libaolistListviewItemProgressBar.setProgress((int) (this.d.get(i).getGift_surplus_percent() * 100.0d));
        viewHolder.libaolistListviewItemPlan.setText(((int) (this.d.get(i).getGift_surplus_percent() * 100.0d)) + "%");
        viewHolder.libaolistListviewItemBtu.setTag(Integer.valueOf(i));
        com.rtk.app.tool.t.K1(this.d.get(i).getGift_status(), viewHolder.libaolistListviewItemBtu, viewHolder.libaolistListviewItemProgressBarLayout, viewHolder.libaolistListviewItemReceiveNumber, this.d.get(i).getGift_content(), new TextView[0]);
        viewHolder.libaolistListviewItemBtu.setOnClickListener(new a());
        return view;
    }

    public void h(int i, int i2) {
        int I = com.rtk.app.tool.y.I(this.f80c);
        if (I == 0) {
            return;
        }
        int i3 = (100000 * i) + i2;
        if (i == 3) {
            Context context = this.f80c;
            com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(new String[0]);
            StringBuilder sb = new StringBuilder();
            sb.append("game/reservation_cancel");
            sb.append(com.rtk.app.tool.y.u(this.f80c));
            sb.append("&uid=");
            sb.append(I);
            sb.append("&giftbag_id=");
            sb.append(this.d.get(i2).getGift_id());
            sb.append("&key=");
            sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f80c, "uid=" + I, "giftbag_id=" + this.d.get(i2).getGift_id()))));
            com.rtk.app.tool.o.h.l(context, this, i3, h.a(sb.toString()));
            return;
        }
        if (i == 4) {
            Context context2 = this.f80c;
            com.rtk.app.tool.o.i h2 = com.rtk.app.tool.o.h.h(new String[0]);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("game/reservation");
            sb2.append(com.rtk.app.tool.y.u(this.f80c));
            sb2.append("&uid=");
            sb2.append(I);
            sb2.append("&giftbag_id=");
            sb2.append(this.d.get(i2).getGift_id());
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f80c, "uid=" + I, "giftbag_id=" + this.d.get(i2).getGift_id()))));
            com.rtk.app.tool.o.h.l(context2, this, i3, h2.a(sb2.toString()));
            return;
        }
        if (i == 6) {
            Context context3 = this.f80c;
            com.rtk.app.tool.o.i h3 = com.rtk.app.tool.o.h.h(new String[0]);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("game/take_out");
            sb3.append(com.rtk.app.tool.y.u(this.f80c));
            sb3.append("&uid=");
            sb3.append(I);
            sb3.append("&giftbag_id=");
            sb3.append(this.d.get(i2).getGift_id());
            sb3.append("&key=");
            sb3.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f80c, "uid=" + I, "giftbag_id=" + this.d.get(i2).getGift_id()))));
            com.rtk.app.tool.o.h.l(context3, this, i3, h3.a(sb3.toString()));
            return;
        }
        if (i != 7) {
            return;
        }
        Context context4 = this.f80c;
        com.rtk.app.tool.o.i h4 = com.rtk.app.tool.o.h.h(new String[0]);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("game/gift_receive");
        sb4.append(com.rtk.app.tool.y.u(this.f80c));
        sb4.append("&uid=");
        sb4.append(I);
        sb4.append("&giftbag_id=");
        sb4.append(this.d.get(i2).getGift_id());
        sb4.append("&key=");
        sb4.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f80c, "uid=" + I, "giftbag_id=" + this.d.get(i2).getGift_id()))));
        com.rtk.app.tool.o.h.l(context4, this, i3, h4.a(sb4.toString()));
    }
}
