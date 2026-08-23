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
import com.rtk.app.R;
import com.rtk.app.bean.DialogForApkPermissionBean;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ApkPermissionAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private List<DialogForApkPermissionBean.DataBean> f33c;
    private Context d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    protected static class ViewHolder {

        @BindView
        TextView apkPermissionItemIntro;

        @BindView
        TextView apkPermissionItemName;

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
            viewHolder.apkPermissionItemName = (TextView) butterknife.c.a.c(view, R.id.apk_permission_item_name, "field 'apkPermissionItemName'", TextView.class);
            viewHolder.apkPermissionItemIntro = (TextView) butterknife.c.a.c(view, R.id.apk_permission_item_intro, "field 'apkPermissionItemIntro'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.apkPermissionItemName = null;
                viewHolder.apkPermissionItemIntro = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public ApkPermissionAdapter(Context context, List<DialogForApkPermissionBean.DataBean> list) {
        super(list);
        this.d = context;
        this.f33c = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.d).inflate(R.layout.apk_permission_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        if (com.rtk.app.tool.c0.q(this.f33c.get(i).getName())) {
            viewHolder.apkPermissionItemName.setText(this.f33c.get(i).getEnglish());
            viewHolder.apkPermissionItemIntro.setVisibility(8);
        } else {
            viewHolder.apkPermissionItemName.setText(this.f33c.get(i).getName());
            viewHolder.apkPermissionItemIntro.setText(this.f33c.get(i).getMsg());
            viewHolder.apkPermissionItemIntro.setVisibility(0);
        }
        return view;
    }
}
