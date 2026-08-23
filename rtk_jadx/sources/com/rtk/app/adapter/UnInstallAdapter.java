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
import java.io.File;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UnInstallAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f110c;
    private List<PackageInfo> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        ImageView unInstallListItemBtu;

        @BindView
        ImageView unInstallListItemIcon;

        @BindView
        TextView unInstallListItemName;

        @BindView
        TextView unInstallListItemSize;

        @BindView
        TextView unInstallListItemVersion;

        ViewHolder(UnInstallAdapter unInstallAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.unInstallListItemIcon = (ImageView) butterknife.c.a.c(view, R.id.un_install_list_item_icon, "field 'unInstallListItemIcon'", ImageView.class);
            viewHolder.unInstallListItemName = (TextView) butterknife.c.a.c(view, R.id.un_install_list_item_name, "field 'unInstallListItemName'", TextView.class);
            viewHolder.unInstallListItemVersion = (TextView) butterknife.c.a.c(view, R.id.un_install_list_item_version, "field 'unInstallListItemVersion'", TextView.class);
            viewHolder.unInstallListItemSize = (TextView) butterknife.c.a.c(view, R.id.un_install_list_item_size, "field 'unInstallListItemSize'", TextView.class);
            viewHolder.unInstallListItemBtu = (ImageView) butterknife.c.a.c(view, R.id.un_install_list_item_btu, "field 'unInstallListItemBtu'", ImageView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.unInstallListItemIcon = null;
                viewHolder.unInstallListItemName = null;
                viewHolder.unInstallListItemVersion = null;
                viewHolder.unInstallListItemSize = null;
                viewHolder.unInstallListItemBtu = null;
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
            com.rtk.app.tool.t.g2(UnInstallAdapter.this.f110c, ((PackageInfo) UnInstallAdapter.this.d.get(((Integer) view.getTag()).intValue())).packageName);
        }
    }

    public UnInstallAdapter(Context context, List<PackageInfo> list) {
        super(list);
        this.f110c = context;
        this.d = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f110c).inflate(R.layout.un_install_list_item, (ViewGroup) null);
            viewHolder = new ViewHolder(this, view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.unInstallListItemName.setText(this.d.get(i).applicationInfo.loadLabel(this.f110c.getPackageManager()).toString());
        viewHolder.unInstallListItemVersion.setText(this.d.get(i).versionName);
        viewHolder.unInstallListItemSize.setText(com.rtk.app.tool.c0.k(Integer.valueOf((int) new File(this.d.get(i).applicationInfo.publicSourceDir).length()).intValue()));
        viewHolder.unInstallListItemIcon.setImageDrawable(this.d.get(i).applicationInfo.loadIcon(this.f110c.getPackageManager()));
        viewHolder.unInstallListItemBtu.setTag(Integer.valueOf(i));
        viewHolder.unInstallListItemBtu.setOnClickListener(new a());
        return view;
    }
}
