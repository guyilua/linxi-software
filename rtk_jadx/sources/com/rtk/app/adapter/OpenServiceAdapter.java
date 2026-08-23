package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.bean.KaiFuBiaoBean;
import com.rtk.app.tool.ApkInfo;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class OpenServiceAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f96c;
    private List<KaiFuBiaoBean.DataBean> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        TextView openServiceListviewItemDownload;

        @BindView
        ImageView openServiceListviewItemIcon;

        @BindView
        TextView openServiceListviewItemName;

        @BindView
        ProgressBar openServiceListviewItemProgressBar;

        @BindView
        TextView openServiceListviewItemQuhao;

        @BindView
        TextView openServiceListviewItemTime;

        @BindView
        TextView openServiceListviewItemTypeAndsize;

        ViewHolder(OpenServiceAdapter openServiceAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.openServiceListviewItemIcon = (ImageView) butterknife.c.a.c(view, R.id.open_service_listview_item_icon, "field 'openServiceListviewItemIcon'", ImageView.class);
            viewHolder.openServiceListviewItemName = (TextView) butterknife.c.a.c(view, R.id.open_service_listview_item_Name, "field 'openServiceListviewItemName'", TextView.class);
            viewHolder.openServiceListviewItemTypeAndsize = (TextView) butterknife.c.a.c(view, R.id.open_service_listview_item_typeAndsize, "field 'openServiceListviewItemTypeAndsize'", TextView.class);
            viewHolder.openServiceListviewItemQuhao = (TextView) butterknife.c.a.c(view, R.id.open_service_listview_item_quhao, "field 'openServiceListviewItemQuhao'", TextView.class);
            viewHolder.openServiceListviewItemTime = (TextView) butterknife.c.a.c(view, R.id.open_service_listview_item_time, "field 'openServiceListviewItemTime'", TextView.class);
            viewHolder.openServiceListviewItemDownload = (TextView) butterknife.c.a.c(view, R.id.open_service_listview_item_download, "field 'openServiceListviewItemDownload'", TextView.class);
            viewHolder.openServiceListviewItemProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.open_service_listview_item_ProgressBar, "field 'openServiceListviewItemProgressBar'", ProgressBar.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.openServiceListviewItemIcon = null;
                viewHolder.openServiceListviewItemName = null;
                viewHolder.openServiceListviewItemTypeAndsize = null;
                viewHolder.openServiceListviewItemQuhao = null;
                viewHolder.openServiceListviewItemTime = null;
                viewHolder.openServiceListviewItemDownload = null;
                viewHolder.openServiceListviewItemProgressBar = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private class a implements View.OnClickListener {
        private int a;
        private int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.a != 0) {
                return;
            }
            com.rtk.app.tool.DownLoadTool.r.g(OpenServiceAdapter.this.f96c, new ApkInfo(((KaiFuBiaoBean.DataBean) OpenServiceAdapter.this.d.get(this.b)).getGame_id(), ((KaiFuBiaoBean.DataBean) OpenServiceAdapter.this.d.get(this.b)).getGame_name(), ((KaiFuBiaoBean.DataBean) OpenServiceAdapter.this.d.get(this.b)).getPackage_name(), ((KaiFuBiaoBean.DataBean) OpenServiceAdapter.this.d.get(this.b)).getGame_logo(), ((KaiFuBiaoBean.DataBean) OpenServiceAdapter.this.d.get(this.b)).getData_package_size(), ((KaiFuBiaoBean.DataBean) OpenServiceAdapter.this.d.get(this.b)).getSignaturesMD5(), ((KaiFuBiaoBean.DataBean) OpenServiceAdapter.this.d.get(this.b)).getIs_apk(), ((KaiFuBiaoBean.DataBean) OpenServiceAdapter.this.d.get(this.b)).getVersion_code(), ((KaiFuBiaoBean.DataBean) OpenServiceAdapter.this.d.get(this.b)).getDownlist()), (TextView) view);
        }
    }

    public OpenServiceAdapter(Context context, List<KaiFuBiaoBean.DataBean> list) {
        super(list);
        this.f96c = context;
        this.d = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        View view2;
        if (view == null) {
            view2 = LayoutInflater.from(this.f96c).inflate(R.layout.open_service_listview_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(this, view2);
            view2.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
            view2 = view;
        }
        com.rtk.app.tool.t.d(this.f96c, this.d.get(i).getGame_logo(), viewHolder.openServiceListviewItemIcon);
        viewHolder.openServiceListviewItemName.setText(this.d.get(i).getGame_name());
        viewHolder.openServiceListviewItemQuhao.setText(this.d.get(i).getTitle());
        viewHolder.openServiceListviewItemTypeAndsize.setText(this.d.get(i).getGame_type() + this.d.get(i).getInstall_package_size());
        viewHolder.openServiceListviewItemDownload.setTag(Integer.valueOf(this.d.get(i).getGame_id()));
        com.rtk.app.tool.DownLoadTool.u uVar = new com.rtk.app.tool.DownLoadTool.u(viewHolder.openServiceListviewItemProgressBar, this.d.get(i).getGame_id(), viewHolder.openServiceListviewItemDownload);
        this.b.add(uVar);
        com.rtk.app.tool.DownLoadTool.x.c().a(uVar);
        com.rtk.app.tool.DownLoadTool.r.h(this.f96c, new ApkInfo(this.d.get(i).getGame_id(), this.d.get(i).getGame_name(), this.d.get(i).getPackage_name(), this.d.get(i).getGame_logo(), this.d.get(i).getData_package_size(), this.d.get(i).getSignaturesMD5(), this.d.get(i).getIs_apk(), this.d.get(i).getVersion_code(), this.d.get(i).getDownlist()), viewHolder.openServiceListviewItemDownload, viewHolder.openServiceListviewItemProgressBar);
        viewHolder.openServiceListviewItemTime.setText(com.rtk.app.tool.c0.o(this.d.get(i).getStart_time()));
        viewHolder.openServiceListviewItemDownload.setOnClickListener(new a(0, i));
        return view2;
    }
}
