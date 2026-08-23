package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
public class UpApkListMyAttentionAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f115c;
    private List<UpApkListBean.DataBean> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ViewHolder {

        @BindView
        TextView upApkListMyAttentionItemDownload;

        @BindView
        TextView upApkListMyAttentionItemGameName;

        @BindView
        CustomTextView upApkListMyAttentionItemGameTime;

        @BindView
        CustomTextView upApkListMyAttentionItemGameVersionAndSize;

        @BindView
        RoundedImageView upApkListMyAttentionItemIcon;

        @BindView
        ProgressBar upApkListMyAttentionItemProgressBar;

        @BindView
        TextView upApkListMyAttentionRemark;

        @BindView
        RoundedImageView upApkListMyAttentionUserIcon;

        @BindView
        LinearLayout upApkListMyAttentionUserLv;

        @BindView
        TextView upApkListMyAttentionUserName;

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
            viewHolder.upApkListMyAttentionUserIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.up_apk_list_my_attention_userIcon, "field 'upApkListMyAttentionUserIcon'", RoundedImageView.class);
            viewHolder.upApkListMyAttentionUserName = (TextView) butterknife.c.a.c(view, R.id.up_apk_list_my_attention_userName, "field 'upApkListMyAttentionUserName'", TextView.class);
            viewHolder.upApkListMyAttentionRemark = (TextView) butterknife.c.a.c(view, R.id.up_apk_list_my_attention_remake, "field 'upApkListMyAttentionRemark'", TextView.class);
            viewHolder.upApkListMyAttentionUserLv = (LinearLayout) butterknife.c.a.c(view, R.id.up_apk_list_my_attention_userLv, "field 'upApkListMyAttentionUserLv'", LinearLayout.class);
            viewHolder.upApkListMyAttentionItemIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.up_apk_list_my_attention_item_icon, "field 'upApkListMyAttentionItemIcon'", RoundedImageView.class);
            viewHolder.upApkListMyAttentionItemGameName = (TextView) butterknife.c.a.c(view, R.id.up_apk_list_my_attention_item_gameName, "field 'upApkListMyAttentionItemGameName'", TextView.class);
            viewHolder.upApkListMyAttentionItemGameVersionAndSize = (CustomTextView) butterknife.c.a.c(view, R.id.up_apk_list_my_attention_item_gameVersionAndSize, "field 'upApkListMyAttentionItemGameVersionAndSize'", CustomTextView.class);
            viewHolder.upApkListMyAttentionItemGameTime = (CustomTextView) butterknife.c.a.c(view, R.id.up_apk_list_my_attention_item_gameTime, "field 'upApkListMyAttentionItemGameTime'", CustomTextView.class);
            viewHolder.upApkListMyAttentionItemProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.up_apk_list_my_attention_item_progressBar, "field 'upApkListMyAttentionItemProgressBar'", ProgressBar.class);
            viewHolder.upApkListMyAttentionItemDownload = (TextView) butterknife.c.a.c(view, R.id.up_apk_list_my_attention_item_download, "field 'upApkListMyAttentionItemDownload'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.upApkListMyAttentionUserIcon = null;
                viewHolder.upApkListMyAttentionUserName = null;
                viewHolder.upApkListMyAttentionRemark = null;
                viewHolder.upApkListMyAttentionUserLv = null;
                viewHolder.upApkListMyAttentionItemIcon = null;
                viewHolder.upApkListMyAttentionItemGameName = null;
                viewHolder.upApkListMyAttentionItemGameVersionAndSize = null;
                viewHolder.upApkListMyAttentionItemGameTime = null;
                viewHolder.upApkListMyAttentionItemProgressBar = null;
                viewHolder.upApkListMyAttentionItemDownload = null;
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
            com.rtk.app.tool.i.i.o(UpApkListMyAttentionAdapter.this.f115c, this.a, (TextView) view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = (String) view.getTag();
            com.rtk.app.tool.t.B0(UpApkListMyAttentionAdapter.this.f115c, str + "");
        }
    }

    public UpApkListMyAttentionAdapter(Context context, List<UpApkListBean.DataBean> list) {
        super(list);
        this.f115c = context;
        this.d = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.f115c).inflate(R.layout.up_apk_list_my_attention_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.upApkListMyAttentionItemGameTime.setText(this.d.get(i).getAddtime());
        viewHolder.upApkListMyAttentionItemGameName.setText(this.d.get(i).getVarName());
        if (com.rtk.app.tool.c0.q(this.d.get(i).getDataPath())) {
            str = this.d.get(i).getSourceSize();
        } else {
            str = this.d.get(i).getDataSize() + "(数据包)";
        }
        viewHolder.upApkListMyAttentionItemGameVersionAndSize.setText(this.d.get(i).getVersionName() + "  |  " + str);
        com.rtk.app.tool.t.c(this.f115c, this.d.get(i).getSourceLogo(), viewHolder.upApkListMyAttentionItemIcon, new boolean[0]);
        com.rtk.app.tool.t.c(this.f115c, this.d.get(i).getFace(), viewHolder.upApkListMyAttentionUserIcon, new boolean[0]);
        viewHolder.upApkListMyAttentionUserName.setText(this.d.get(i).getNickname());
        if (!com.rtk.app.tool.c0.q(this.d.get(i).getNotename())) {
            viewHolder.upApkListMyAttentionRemark.setVisibility(0);
            viewHolder.upApkListMyAttentionRemark.setText("备注：" + this.d.get(i).getNotename());
        } else {
            viewHolder.upApkListMyAttentionRemark.setVisibility(8);
        }
        ApkInfo apkInfo = new ApkInfo(this.d.get(i));
        viewHolder.upApkListMyAttentionItemDownload.setTag(Integer.valueOf(apkInfo.getGameId()));
        com.rtk.app.tool.DownLoadTool.u uVar = new com.rtk.app.tool.DownLoadTool.u(viewHolder.upApkListMyAttentionItemProgressBar, apkInfo.getGameId(), viewHolder.upApkListMyAttentionItemDownload);
        this.b.add(uVar);
        com.rtk.app.tool.DownLoadTool.x.c().a(uVar);
        com.rtk.app.tool.i.i.p(this.f115c, apkInfo, viewHolder.upApkListMyAttentionItemDownload, viewHolder.upApkListMyAttentionItemProgressBar);
        viewHolder.upApkListMyAttentionItemDownload.setOnClickListener(new a(apkInfo));
        viewHolder.upApkListMyAttentionUserLv.setTag(this.d.get(i).getUid());
        viewHolder.upApkListMyAttentionUserLv.setOnClickListener(new b());
        return view;
    }
}
