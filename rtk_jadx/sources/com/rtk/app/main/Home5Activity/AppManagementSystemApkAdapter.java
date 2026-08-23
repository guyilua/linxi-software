package com.rtk.app.main.Home5Activity;

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
import com.rtk.app.adapter.a3;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AppManagementSystemApkAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f181c;
    private List<PackageInfo> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ViewHolder {

        @BindView
        TextView apkManagementSystemApkItemBtu;

        @BindView
        ImageView apkManagementSystemApkItemIcon;

        @BindView
        TextView apkManagementSystemApkItemName;

        @BindView
        TextView apkManagementSystemApkItemPkg;

        @BindView
        TextView apkManagementSystemApkItemVersion;

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
            viewHolder.apkManagementSystemApkItemIcon = (ImageView) butterknife.c.a.c(view, R.id.apk_management_system_apk_item_icon, "field 'apkManagementSystemApkItemIcon'", ImageView.class);
            viewHolder.apkManagementSystemApkItemName = (TextView) butterknife.c.a.c(view, R.id.apk_management_system_apk_item_name, "field 'apkManagementSystemApkItemName'", TextView.class);
            viewHolder.apkManagementSystemApkItemVersion = (TextView) butterknife.c.a.c(view, R.id.apk_management_system_apk_item_version, "field 'apkManagementSystemApkItemVersion'", TextView.class);
            viewHolder.apkManagementSystemApkItemPkg = (TextView) butterknife.c.a.c(view, R.id.app_management_system_apk_item_pkg, "field 'apkManagementSystemApkItemPkg'", TextView.class);
            viewHolder.apkManagementSystemApkItemBtu = (TextView) butterknife.c.a.c(view, R.id.apk_management_system_apk_item_btu, "field 'apkManagementSystemApkItemBtu'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.apkManagementSystemApkItemIcon = null;
                viewHolder.apkManagementSystemApkItemName = null;
                viewHolder.apkManagementSystemApkItemVersion = null;
                viewHolder.apkManagementSystemApkItemPkg = null;
                viewHolder.apkManagementSystemApkItemBtu = null;
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
            int intValue = ((Integer) view.getTag()).intValue();
            String str = ((PackageInfo) AppManagementSystemApkAdapter.this.d.get(intValue)).applicationInfo.sourceDir;
            String charSequence = ((PackageInfo) AppManagementSystemApkAdapter.this.d.get(intValue)).applicationInfo.loadLabel(AppManagementSystemApkAdapter.this.f181c.getPackageManager()).toString();
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                String str2 = com.rtk.app.tool.y.C(AppManagementSystemApkAdapter.this.f181c) + "/files/outapk/" + charSequence + ".apk";
                if (com.rtk.app.tool.t.t(AppManagementSystemApkAdapter.this.f181c, str, str2)) {
                    com.rtk.app.tool.f.a(AppManagementSystemApkAdapter.this.f181c, "文件已保存在" + str2, f.a.f);
                    return;
                }
                com.rtk.app.tool.f.a(AppManagementSystemApkAdapter.this.f181c, "文件保存失败", f.a.f);
            }
        }
    }

    public AppManagementSystemApkAdapter(Context context, List<PackageInfo> list) {
        super(list);
        this.f181c = context;
        this.d = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f181c).inflate(R.layout.apk_management_system_apk_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.apkManagementSystemApkItemName.setText(this.d.get(i).applicationInfo.loadLabel(this.f181c.getPackageManager()).toString());
        int intValue = Integer.valueOf((int) new File(this.d.get(i).applicationInfo.publicSourceDir).length()).intValue();
        viewHolder.apkManagementSystemApkItemVersion.setText(this.d.get(i).versionName + "（" + com.rtk.app.tool.c0.k(intValue) + "）");
        viewHolder.apkManagementSystemApkItemPkg.setText(this.d.get(i).packageName);
        com.rtk.app.tool.e eVar = new com.rtk.app.tool.e(this.f181c, viewHolder.apkManagementSystemApkItemIcon);
        viewHolder.apkManagementSystemApkItemIcon.setImageDrawable(this.f181c.getResources().getDrawable(R.mipmap.icon_load_logo));
        if (viewHolder.apkManagementSystemApkItemIcon.getTag() != null) {
            ((com.rtk.app.tool.e) viewHolder.apkManagementSystemApkItemIcon.getTag()).cancel(true);
        }
        viewHolder.apkManagementSystemApkItemIcon.setTag(eVar);
        eVar.execute(this.d.get(i));
        viewHolder.apkManagementSystemApkItemBtu.setTag(Integer.valueOf(i));
        viewHolder.apkManagementSystemApkItemBtu.setOnClickListener(new a());
        return view;
    }
}
