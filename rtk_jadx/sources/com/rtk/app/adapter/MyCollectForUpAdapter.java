package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.bean.UpApkListBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.tool.ApkInfo;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyCollectForUpAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f85c;
    private List<UpApkListBean.DataBean> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ViewHolder {

        @BindView
        TextView upApkListItemDownload;

        @BindView
        TextView upApkListItemGameName;

        @BindView
        CustomTextView upApkListItemGameTime;

        @BindView
        CustomTextView upApkListItemGameVersionAndSize;

        @BindView
        RoundedImageView upApkListItemIcon;

        @BindView
        ProgressBar upApkListItemProgressBar;

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
            viewHolder.upApkListItemIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.up_apk_list_item_icon, "field 'upApkListItemIcon'", RoundedImageView.class);
            viewHolder.upApkListItemGameName = (TextView) butterknife.c.a.c(view, R.id.up_apk_list_item_gameName, "field 'upApkListItemGameName'", TextView.class);
            viewHolder.upApkListItemGameVersionAndSize = (CustomTextView) butterknife.c.a.c(view, R.id.up_apk_list_item_gameVersionAndSize, "field 'upApkListItemGameVersionAndSize'", CustomTextView.class);
            viewHolder.upApkListItemGameTime = (CustomTextView) butterknife.c.a.c(view, R.id.up_apk_list_item_gameTime, "field 'upApkListItemGameTime'", CustomTextView.class);
            viewHolder.upApkListItemProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.up_apk_list_item_progressBar, "field 'upApkListItemProgressBar'", ProgressBar.class);
            viewHolder.upApkListItemDownload = (TextView) butterknife.c.a.c(view, R.id.up_apk_list_item_download, "field 'upApkListItemDownload'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.upApkListItemIcon = null;
                viewHolder.upApkListItemGameName = null;
                viewHolder.upApkListItemGameVersionAndSize = null;
                viewHolder.upApkListItemGameTime = null;
                viewHolder.upApkListItemProgressBar = null;
                viewHolder.upApkListItemDownload = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements View.OnClickListener {
        final /* synthetic */ ApkInfo a;

        a(ApkInfo apkInfo) {
            this.a = apkInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.rtk.app.tool.i.i.o(MyCollectForUpAdapter.this.f85c, this.a, (TextView) view);
        }
    }

    public MyCollectForUpAdapter(Context context, List<UpApkListBean.DataBean> list) {
        super(list);
        this.f85c = context;
        this.d = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f85c).inflate(R.layout.up_apk_list_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.upApkListItemGameTime.setLeftText("收藏时间:");
        viewHolder.upApkListItemGameTime.setText(this.d.get(i).getAddtime());
        viewHolder.upApkListItemGameName.setText(this.d.get(i).getVarName());
        viewHolder.upApkListItemGameVersionAndSize.setText(this.d.get(i).getVersionName() + "  |  " + this.d.get(i).getSourceSize());
        com.rtk.app.tool.t.c(this.f85c, this.d.get(i).getSourceLogo(), viewHolder.upApkListItemIcon, new boolean[0]);
        ApkInfo apkInfo = new ApkInfo(this.d.get(i));
        viewHolder.upApkListItemDownload.setTag(Integer.valueOf(apkInfo.getGameId()));
        com.rtk.app.tool.DownLoadTool.u uVar = new com.rtk.app.tool.DownLoadTool.u(viewHolder.upApkListItemProgressBar, apkInfo.getGameId(), viewHolder.upApkListItemDownload);
        this.b.add(uVar);
        com.rtk.app.tool.DownLoadTool.x.c().a(uVar);
        com.rtk.app.tool.i.i.p(this.f85c, apkInfo, viewHolder.upApkListItemDownload, viewHolder.upApkListItemProgressBar);
        viewHolder.upApkListItemDownload.setOnClickListener(new a(apkInfo));
        return view;
    }
}
