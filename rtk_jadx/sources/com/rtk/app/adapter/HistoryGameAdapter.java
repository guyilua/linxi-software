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
import com.rtk.app.adapter.HistoryGameAdapter;
import com.rtk.app.bean.ListHisGameBean;
import com.rtk.app.main.dialogPack.DialogForEnSure;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HistoryGameAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private ListHisGameBean f65c;
    private Context d;
    private HisUpHolder e;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class HisUpHolder {
        private View a;
        private ListHisGameBean.HisGameBean b;

        @BindView
        TextView clickTime;

        @BindView
        ImageView historyGameItemIcon;

        @BindView
        TextView historyGameItemName;

        @BindView
        TextView historyGameItemSizeAndVersion;

        HisUpHolder(View view) {
            ButterKnife.b(this, view);
            this.a = view;
            a();
        }

        private void a() {
            this.a.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.r0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HistoryGameAdapter.HisUpHolder.this.c(view);
                }
            });
            this.a.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.rtk.app.adapter.s0
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return HistoryGameAdapter.HisUpHolder.this.e(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void c(View view) {
            com.rtk.app.tool.t.e0(HistoryGameAdapter.this.d, this.b.getApkInfo());
            com.rtk.app.main.Home5Activity.ClickHistory.f.q(HistoryGameAdapter.this.d, this.b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean e(View view) {
            new DialogForEnSure(HistoryGameAdapter.this.d, "删除该浏览记录？", new com.rtk.app.tool.s() { // from class: com.rtk.app.adapter.t0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    HistoryGameAdapter.HisUpHolder.this.g(strArr);
                }
            }).show();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void g(String[] strArr) {
            com.rtk.app.main.Home5Activity.ClickHistory.f.i(HistoryGameAdapter.this.d, this.b);
            HistoryGameAdapter.this.f65c.getListBean().remove(this.b);
            HistoryGameAdapter.this.notifyDataSetChanged();
        }

        protected void h(ListHisGameBean.HisGameBean hisGameBean) {
            this.b = hisGameBean;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class HisUpHolder_ViewBinding implements Unbinder {
        private HisUpHolder b;

        @UiThread
        public HisUpHolder_ViewBinding(HisUpHolder hisUpHolder, View view) {
            this.b = hisUpHolder;
            hisUpHolder.historyGameItemIcon = (ImageView) butterknife.c.a.c(view, R.id.history_game_item_icon, "field 'historyGameItemIcon'", ImageView.class);
            hisUpHolder.historyGameItemName = (TextView) butterknife.c.a.c(view, R.id.history_game_item_Name, "field 'historyGameItemName'", TextView.class);
            hisUpHolder.historyGameItemSizeAndVersion = (TextView) butterknife.c.a.c(view, R.id.history_game_item_size_and_version, "field 'historyGameItemSizeAndVersion'", TextView.class);
            hisUpHolder.clickTime = (TextView) butterknife.c.a.c(view, R.id.history_game_item_click_time, "field 'clickTime'", TextView.class);
        }

        @CallSuper
        public void a() {
            HisUpHolder hisUpHolder = this.b;
            if (hisUpHolder != null) {
                this.b = null;
                hisUpHolder.historyGameItemIcon = null;
                hisUpHolder.historyGameItemName = null;
                hisUpHolder.historyGameItemSizeAndVersion = null;
                hisUpHolder.clickTime = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public HistoryGameAdapter(Context context, ListHisGameBean listHisGameBean) {
        super(listHisGameBean.getListBean());
        this.d = context;
        this.f65c = listHisGameBean;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.d).inflate(R.layout.history_game_layout, (ViewGroup) null);
            HisUpHolder hisUpHolder = new HisUpHolder(view);
            this.e = hisUpHolder;
            view.setTag(hisUpHolder);
        } else {
            this.e = (HisUpHolder) view.getTag();
        }
        this.e.h(this.f65c.getListBean().get(i));
        com.rtk.app.tool.t.c(this.d, this.f65c.getListBean().get(i).getApkInfo().getIcon_url(), this.e.historyGameItemIcon, new boolean[0]);
        this.e.historyGameItemName.setText(this.f65c.getListBean().get(i).getApkInfo().getAppName());
        this.e.clickTime.setText(com.rtk.app.tool.c0.m(this.f65c.getListBean().get(i).getClickTime()));
        this.e.historyGameItemSizeAndVersion.setText("V" + this.f65c.getListBean().get(i).getApkInfo().getVersionName() + " | " + this.f65c.getListBean().get(i).getApkInfo().getApkSize());
        return view;
    }
}
