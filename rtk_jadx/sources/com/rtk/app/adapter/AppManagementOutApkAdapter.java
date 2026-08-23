package com.rtk.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AppManagementOutApkAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f34c;
    private List<PackageInfo> d;
    private List<Boolean> e;
    private com.rtk.app.tool.s f;
    private Thread g;
    private DialogForProgressTip h;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ViewHolder {

        @BindView
        TextView apkPackageName;

        @BindView
        ImageView appManagementOutApkItemBtu;

        @BindView
        CheckBox appManagementOutApkItemCheckbox;

        @BindView
        ImageView appManagementOutApkItemIcon;

        @BindView
        ImageView appManagementOutApkItemMore;

        @BindView
        TextView appManagementOutApkItemName;

        @BindView
        TextView appManagementOutApkItemVersion;

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
            viewHolder.appManagementOutApkItemCheckbox = (CheckBox) butterknife.c.a.c(view, R.id.app_management_out_apk_item_checkbox, "field 'appManagementOutApkItemCheckbox'", CheckBox.class);
            viewHolder.appManagementOutApkItemIcon = (ImageView) butterknife.c.a.c(view, R.id.app_management_out_apk_item_icon, "field 'appManagementOutApkItemIcon'", ImageView.class);
            viewHolder.appManagementOutApkItemName = (TextView) butterknife.c.a.c(view, R.id.app_management_out_apk_item_name, "field 'appManagementOutApkItemName'", TextView.class);
            viewHolder.appManagementOutApkItemVersion = (TextView) butterknife.c.a.c(view, R.id.app_management_out_apk_item_version, "field 'appManagementOutApkItemVersion'", TextView.class);
            viewHolder.appManagementOutApkItemMore = (ImageView) butterknife.c.a.c(view, R.id.app_management_out_apk_item_more, "field 'appManagementOutApkItemMore'", ImageView.class);
            viewHolder.appManagementOutApkItemBtu = (ImageView) butterknife.c.a.c(view, R.id.app_management_out_apk_item_btu, "field 'appManagementOutApkItemBtu'", ImageView.class);
            viewHolder.apkPackageName = (TextView) butterknife.c.a.c(view, R.id.app_management_out_apk_item_pkg, "field 'apkPackageName'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.appManagementOutApkItemCheckbox = null;
                viewHolder.appManagementOutApkItemIcon = null;
                viewHolder.appManagementOutApkItemName = null;
                viewHolder.appManagementOutApkItemVersion = null;
                viewHolder.appManagementOutApkItemMore = null;
                viewHolder.appManagementOutApkItemBtu = null;
                viewHolder.apkPackageName = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements Runnable {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = ((PackageInfo) AppManagementOutApkAdapter.this.d.get(this.a)).applicationInfo.sourceDir;
            String charSequence = ((PackageInfo) AppManagementOutApkAdapter.this.d.get(this.a)).applicationInfo.loadLabel(AppManagementOutApkAdapter.this.f34c.getPackageManager()).toString();
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                String str2 = com.rtk.app.tool.y.C(AppManagementOutApkAdapter.this.f34c) + "/files/outapk/" + charSequence + ".apk";
                if (com.rtk.app.tool.t.t(AppManagementOutApkAdapter.this.f34c, str, str2)) {
                    com.rtk.app.tool.f.a(AppManagementOutApkAdapter.this.f34c, "文件已保存在" + str2, f.a.f);
                } else {
                    com.rtk.app.tool.f.a(AppManagementOutApkAdapter.this.f34c, "文件保存失败", f.a.f);
                }
            }
            AppManagementOutApkAdapter.this.h.dismiss();
        }
    }

    public AppManagementOutApkAdapter(Context context, List<PackageInfo> list, List<Boolean> list2, com.rtk.app.tool.s sVar) {
        super(list);
        this.d = list;
        this.f = sVar;
        this.e = list2;
        this.f34c = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(View view) {
        com.rtk.app.tool.t.g2(this.f34c, this.d.get(((Integer) view.getTag()).intValue()).packageName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        this.e.set(intValue, Boolean.valueOf(!r1.get(intValue).booleanValue()));
        ((CheckBox) view).setChecked(this.e.get(intValue).booleanValue());
        com.rtk.app.tool.s sVar = this.f;
        String[] strArr = new String[1];
        strArr[0] = this.e.contains(Boolean.TRUE) ? "true" : "false";
        sVar.a(strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean p(int i, PopupMenu popupMenu, MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 2131296444) {
            com.rtk.app.tool.t.k1((Activity) this.f34c, this.d.get(i).packageName);
        } else if (itemId == 2131297072) {
            Thread thread = this.g;
            if (thread != null && thread.isAlive()) {
                com.rtk.app.tool.f.a(this.f34c, "已有文件在复制中，请稍后", f.a.f);
            } else {
                if (this.h == null) {
                    this.h = new DialogForProgressTip(this.f34c, "文件复制中请稍后");
                }
                this.h.show();
                Thread thread2 = new Thread(new a(i));
                this.g = thread2;
                thread2.start();
            }
        } else if (itemId == 2131299628) {
            com.rtk.app.tool.t.A1(this.f34c, this.d.get(i).packageName);
        }
        popupMenu.dismiss();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void l(View view) {
        final PopupMenu popupMenu = new PopupMenu(this.f34c, view);
        final int intValue = ((Integer) view.getTag()).intValue();
        popupMenu.getMenuInflater().inflate(R.menu.app_management_item_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.rtk.app.adapter.a
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return AppManagementOutApkAdapter.this.p(intValue, popupMenu, menuItem);
            }
        });
        popupMenu.show();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f34c).inflate(R.layout.app_management_out_apk_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.appManagementOutApkItemName.setText(this.d.get(i).applicationInfo.loadLabel(this.f34c.getPackageManager()).toString());
        int intValue = Integer.valueOf((int) new File(this.d.get(i).applicationInfo.publicSourceDir).length()).intValue();
        viewHolder.appManagementOutApkItemVersion.setText(this.d.get(i).versionName + "（" + com.rtk.app.tool.c0.k(intValue) + "）");
        viewHolder.apkPackageName.setText(this.d.get(i).packageName);
        com.rtk.app.tool.e eVar = new com.rtk.app.tool.e(this.f34c, viewHolder.appManagementOutApkItemIcon);
        viewHolder.appManagementOutApkItemIcon.setImageDrawable(this.f34c.getResources().getDrawable(R.mipmap.icon_load_logo));
        if (viewHolder.appManagementOutApkItemIcon.getTag() != null) {
            ((com.rtk.app.tool.e) viewHolder.appManagementOutApkItemIcon.getTag()).cancel(true);
        }
        viewHolder.appManagementOutApkItemIcon.setTag(eVar);
        eVar.execute(this.d.get(i));
        viewHolder.appManagementOutApkItemBtu.setTag(Integer.valueOf(i));
        viewHolder.appManagementOutApkItemBtu.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AppManagementOutApkAdapter.this.j(view2);
            }
        });
        viewHolder.appManagementOutApkItemMore.setTag(Integer.valueOf(i));
        viewHolder.appManagementOutApkItemMore.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AppManagementOutApkAdapter.this.l(view2);
            }
        });
        viewHolder.appManagementOutApkItemCheckbox.setChecked(this.e.get(i).booleanValue());
        viewHolder.appManagementOutApkItemCheckbox.setTag(Integer.valueOf(i));
        viewHolder.appManagementOutApkItemCheckbox.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AppManagementOutApkAdapter.this.n(view2);
            }
        });
        return view;
    }
}
