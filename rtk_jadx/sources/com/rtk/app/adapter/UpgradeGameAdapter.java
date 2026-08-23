package com.rtk.app.adapter;

import android.content.Context;
import android.content.pm.PackageInfo;
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
import com.rtk.app.bean.UpgradeGameBean;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpgradeGameAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f128c;
    private List<UpgradeGameBean.DataBean> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        TextView upgradeGameItemBtu;

        @BindView
        ImageView upgradeGameItemIcon;

        @BindView
        TextView upgradeGameItemName;

        @BindView
        TextView upgradeGameItemSize;

        @BindView
        TextView upgradeGameItemVersion;

        ViewHolder(UpgradeGameAdapter upgradeGameAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.upgradeGameItemIcon = (ImageView) butterknife.c.a.c(view, R.id.upgrade_game_item_icon, "field 'upgradeGameItemIcon'", ImageView.class);
            viewHolder.upgradeGameItemName = (TextView) butterknife.c.a.c(view, R.id.upgrade_game_item_name, "field 'upgradeGameItemName'", TextView.class);
            viewHolder.upgradeGameItemVersion = (TextView) butterknife.c.a.c(view, R.id.upgrade_game_item_version, "field 'upgradeGameItemVersion'", TextView.class);
            viewHolder.upgradeGameItemSize = (TextView) butterknife.c.a.c(view, R.id.upgrade_game_item_size, "field 'upgradeGameItemSize'", TextView.class);
            viewHolder.upgradeGameItemBtu = (TextView) butterknife.c.a.c(view, R.id.upgrade_game_item_btu, "field 'upgradeGameItemBtu'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.upgradeGameItemIcon = null;
                viewHolder.upgradeGameItemName = null;
                viewHolder.upgradeGameItemVersion = null;
                viewHolder.upgradeGameItemSize = null;
                viewHolder.upgradeGameItemBtu = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public UpgradeGameAdapter(Context context, List<UpgradeGameBean.DataBean> list) {
        super(list);
        this.f128c = context;
        this.d = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f128c).inflate(R.layout.upgrade_game_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(this, view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        PackageInfo K = com.rtk.app.tool.t.K(this.f128c, this.d.get(i).getPackage_name());
        viewHolder.upgradeGameItemName.setText(K.applicationInfo.loadLabel(this.f128c.getPackageManager()).toString());
        viewHolder.upgradeGameItemVersion.setText(K.versionName + " -> " + this.d.get(i).getGame_version());
        viewHolder.upgradeGameItemIcon.setImageDrawable(K.applicationInfo.loadIcon(this.f128c.getPackageManager()));
        return view;
    }
}
