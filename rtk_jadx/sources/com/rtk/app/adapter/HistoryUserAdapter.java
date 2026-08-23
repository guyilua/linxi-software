package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.adapter.HistoryUserAdapter;
import com.rtk.app.bean.ListHisUserBean;
import com.rtk.app.main.dialogPack.DialogForEnSure;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HistoryUserAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private ListHisUserBean f71c;
    private Context d;
    private HisUpHolder e;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class HisUpHolder {
        private View a;
        private ListHisUserBean.HisUserBean b;

        @BindView
        TextView hisClickTime;

        @BindView
        ImageView hisIcon;

        @BindView
        TextView hisNickName;

        HisUpHolder(View view) {
            ButterKnife.b(this, view);
            this.a = view;
            a();
        }

        private void a() {
            this.a.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.b1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HistoryUserAdapter.HisUpHolder.this.c(view);
                }
            });
            this.a.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.rtk.app.adapter.a1
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return HistoryUserAdapter.HisUpHolder.this.e(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void c(View view) {
            com.rtk.app.tool.t.B0(HistoryUserAdapter.this.d, this.b.getUid());
            com.rtk.app.main.Home5Activity.ClickHistory.f.t(HistoryUserAdapter.this.d, this.b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean e(View view) {
            new DialogForEnSure(HistoryUserAdapter.this.d, "删除该浏览记录？", new com.rtk.app.tool.s() { // from class: com.rtk.app.adapter.c1
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    HistoryUserAdapter.HisUpHolder.this.g(strArr);
                }
            }).show();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void g(String[] strArr) {
            com.rtk.app.main.Home5Activity.ClickHistory.f.l(HistoryUserAdapter.this.d, this.b);
            HistoryUserAdapter.this.f71c.getListBean().remove(this.b);
            HistoryUserAdapter.this.notifyDataSetChanged();
        }

        protected void h(ListHisUserBean.HisUserBean hisUserBean) {
            this.b = hisUserBean;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class HisUpHolder_ViewBinding implements Unbinder {
        private HisUpHolder b;

        @UiThread
        public HisUpHolder_ViewBinding(HisUpHolder hisUpHolder, View view) {
            this.b = hisUpHolder;
            hisUpHolder.hisNickName = (TextView) butterknife.c.a.c(view, R.id.history_user_item_nickname, "field 'hisNickName'", TextView.class);
            hisUpHolder.hisClickTime = (TextView) butterknife.c.a.c(view, R.id.history_user_item_click_time, "field 'hisClickTime'", TextView.class);
            hisUpHolder.hisIcon = (ImageView) butterknife.c.a.c(view, R.id.history_user_item_icon, "field 'hisIcon'", ImageView.class);
        }

        @CallSuper
        public void a() {
            HisUpHolder hisUpHolder = this.b;
            if (hisUpHolder != null) {
                this.b = null;
                hisUpHolder.hisNickName = null;
                hisUpHolder.hisClickTime = null;
                hisUpHolder.hisIcon = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public HistoryUserAdapter(Context context, ListHisUserBean listHisUserBean) {
        super(listHisUserBean.getListBean());
        this.d = context;
        this.f71c = listHisUserBean;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.d).inflate(R.layout.history_user_layout, (ViewGroup) null);
            HisUpHolder hisUpHolder = new HisUpHolder(view);
            this.e = hisUpHolder;
            view.setTag(hisUpHolder);
        } else {
            this.e = (HisUpHolder) view.getTag();
        }
        this.e.h(this.f71c.getListBean().get(i));
        com.rtk.app.tool.t.c(this.d, this.f71c.getListBean().get(i).getFace(), this.e.hisIcon, new boolean[0]);
        this.e.hisNickName.setText(this.f71c.getListBean().get(i).getNickname());
        this.e.hisClickTime.setText(com.rtk.app.tool.c0.m(this.f71c.getListBean().get(i).getClickTime()));
        return view;
    }
}
