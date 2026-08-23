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
import com.rtk.app.adapter.HistoryUpAdapter;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.main.dialogPack.DialogForEnSure;
import com.rtk.app.tool.ApkInfo;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HistoryUpAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private List<ApkInfo> f69c;
    private Context d;
    private HisUpHolder e;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class HisUpHolder {
        private View a;
        private ApkInfo b;

        @BindView
        CustomTextView historyUpItemClickTime;

        @BindView
        RoundedImageView historyUpItemIcon;

        @BindView
        TextView historyUpItemName;

        @BindView
        TextView historyUpItemSizeAndVersion;

        HisUpHolder(View view) {
            ButterKnife.b(this, view);
            this.a = view;
            a();
        }

        private void a() {
            this.a.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.y0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HistoryUpAdapter.HisUpHolder.this.c(view);
                }
            });
            this.a.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.rtk.app.adapter.x0
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return HistoryUpAdapter.HisUpHolder.this.e(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void c(View view) {
            com.rtk.app.tool.t.X0(HistoryUpAdapter.this.d, this.b);
            com.rtk.app.main.Home5Activity.ClickHistory.f.s(HistoryUpAdapter.this.d, this.b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean e(View view) {
            new DialogForEnSure(HistoryUpAdapter.this.d, "删除该浏览记录？", new com.rtk.app.tool.s() { // from class: com.rtk.app.adapter.z0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    HistoryUpAdapter.HisUpHolder.this.g(strArr);
                }
            }).show();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void g(String[] strArr) {
            com.rtk.app.main.Home5Activity.ClickHistory.f.k(HistoryUpAdapter.this.d, this.b);
            HistoryUpAdapter.this.f69c.remove(this.b);
            HistoryUpAdapter.this.notifyDataSetChanged();
        }

        protected void h(ApkInfo apkInfo) {
            this.b = apkInfo;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class HisUpHolder_ViewBinding implements Unbinder {
        private HisUpHolder b;

        @UiThread
        public HisUpHolder_ViewBinding(HisUpHolder hisUpHolder, View view) {
            this.b = hisUpHolder;
            hisUpHolder.historyUpItemIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.history_up_item_icon, "field 'historyUpItemIcon'", RoundedImageView.class);
            hisUpHolder.historyUpItemName = (TextView) butterknife.c.a.c(view, R.id.history_up_item_name, "field 'historyUpItemName'", TextView.class);
            hisUpHolder.historyUpItemSizeAndVersion = (TextView) butterknife.c.a.c(view, R.id.history_up_item_size_and_version, "field 'historyUpItemSizeAndVersion'", TextView.class);
            hisUpHolder.historyUpItemClickTime = (CustomTextView) butterknife.c.a.c(view, R.id.history_up_item_clickTime, "field 'historyUpItemClickTime'", CustomTextView.class);
        }

        @CallSuper
        public void a() {
            HisUpHolder hisUpHolder = this.b;
            if (hisUpHolder != null) {
                this.b = null;
                hisUpHolder.historyUpItemIcon = null;
                hisUpHolder.historyUpItemName = null;
                hisUpHolder.historyUpItemSizeAndVersion = null;
                hisUpHolder.historyUpItemClickTime = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public HistoryUpAdapter(Context context, List<ApkInfo> list) {
        super(list);
        this.d = context;
        this.f69c = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.d).inflate(R.layout.history_up_layout, (ViewGroup) null);
            HisUpHolder hisUpHolder = new HisUpHolder(view);
            this.e = hisUpHolder;
            view.setTag(hisUpHolder);
        } else {
            this.e = (HisUpHolder) view.getTag();
        }
        this.e.h(this.f69c.get(i));
        com.rtk.app.tool.t.c(this.d, this.f69c.get(i).getIcon_url(), this.e.historyUpItemIcon, new boolean[0]);
        this.e.historyUpItemName.setText(this.f69c.get(i).getAppName());
        this.e.historyUpItemClickTime.setText(com.rtk.app.tool.c0.m(this.f69c.get(i).getClickTime()));
        this.e.historyUpItemSizeAndVersion.setText("版本：" + this.f69c.get(i).getVersionName() + " | " + this.f69c.get(i).getApkSize());
        return view;
    }
}
