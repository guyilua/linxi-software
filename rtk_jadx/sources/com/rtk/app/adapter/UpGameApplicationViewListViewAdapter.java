package com.rtk.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import io.reactivex.disposables.CompositeDisposable;
import java.io.File;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpGameApplicationViewListViewAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f120c;
    private List<PackageInfo> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        ImageView up_gameItemImg;

        @BindView
        TextView up_gameItemName;

        @BindView
        TextView up_gameItemSize;

        @BindView
        TextView up_gameItemVersion;

        @BindView
        LinearLayout up_gameItemVersionInstallLy;

        ViewHolder(UpGameApplicationViewListViewAdapter upGameApplicationViewListViewAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.up_gameItemImg = (ImageView) butterknife.c.a.c(view, R.id.up_game_item_img, "field 'up_gameItemImg'", ImageView.class);
            viewHolder.up_gameItemName = (TextView) butterknife.c.a.c(view, R.id.up_game_item_name, "field 'up_gameItemName'", TextView.class);
            viewHolder.up_gameItemSize = (TextView) butterknife.c.a.c(view, R.id.up_game_item_size, "field 'up_gameItemSize'", TextView.class);
            viewHolder.up_gameItemVersion = (TextView) butterknife.c.a.c(view, R.id.up_game_item_version, "field 'up_gameItemVersion'", TextView.class);
            viewHolder.up_gameItemVersionInstallLy = (LinearLayout) butterknife.c.a.c(view, R.id.up_game_item_version_install_ly, "field 'up_gameItemVersionInstallLy'", LinearLayout.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.up_gameItemImg = null;
                viewHolder.up_gameItemName = null;
                viewHolder.up_gameItemSize = null;
                viewHolder.up_gameItemVersion = null;
                viewHolder.up_gameItemVersionInstallLy = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements View.OnClickListener {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("apkName", ((PackageInfo) UpGameApplicationViewListViewAdapter.this.d.get(intValue)).applicationInfo.loadLabel(UpGameApplicationViewListViewAdapter.this.f120c.getPackageManager()).toString());
            bundle.putString("apkSize", com.rtk.app.tool.c0.k(Integer.valueOf((int) new File(((PackageInfo) UpGameApplicationViewListViewAdapter.this.d.get(this.a)).applicationInfo.publicSourceDir).length()).intValue()));
            bundle.putString("apkPath", ((PackageInfo) UpGameApplicationViewListViewAdapter.this.d.get(intValue)).applicationInfo.sourceDir);
            intent.putExtras(bundle);
            ((Activity) UpGameApplicationViewListViewAdapter.this.f120c).setResult(1014, intent);
            ((Activity) UpGameApplicationViewListViewAdapter.this.f120c).finish();
        }
    }

    public UpGameApplicationViewListViewAdapter(Context context, List<PackageInfo> list) {
        super(list);
        new CompositeDisposable();
        this.f120c = context;
        this.d = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f120c).inflate(R.layout.up_game_listview_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(this, view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        com.rtk.app.tool.e eVar = new com.rtk.app.tool.e(this.f120c, viewHolder.up_gameItemImg);
        if (viewHolder.up_gameItemImg.getTag() != null) {
            ((com.rtk.app.tool.e) viewHolder.up_gameItemImg.getTag()).cancel(true);
        }
        viewHolder.up_gameItemImg.setTag(eVar);
        eVar.execute(this.d.get(i));
        viewHolder.up_gameItemName.setText(this.d.get(i).applicationInfo.loadLabel(this.f120c.getPackageManager()).toString());
        viewHolder.up_gameItemSize.setText(com.rtk.app.tool.c0.k(Integer.valueOf((int) new File(this.d.get(i).applicationInfo.publicSourceDir).length()).intValue()));
        viewHolder.up_gameItemVersion.setText(this.d.get(i).versionName);
        viewHolder.up_gameItemVersionInstallLy.setTag(Integer.valueOf(i));
        viewHolder.up_gameItemVersionInstallLy.setOnClickListener(new a(i));
        return view;
    }
}
