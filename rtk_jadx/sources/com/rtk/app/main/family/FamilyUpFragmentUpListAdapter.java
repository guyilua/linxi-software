package com.rtk.app.main.family;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.base.BaseRecyclerViewAdapter;
import com.rtk.app.bean.UpApkListBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.tool.ApkInfo;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyUpFragmentUpListAdapter extends BaseRecyclerViewAdapter {
    private List<UpApkListBean.DataBean> e;
    private Context f;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ViewHolder extends RecyclerView.ViewHolder {
        View a;

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
            super(view);
            ButterKnife.b(this, view);
            this.a = view;
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
            com.rtk.app.tool.i.i.o(FamilyUpFragmentUpListAdapter.this.f, this.a, (TextView) view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = (String) view.getTag();
            com.rtk.app.tool.t.B0(FamilyUpFragmentUpListAdapter.this.f, str + "");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements View.OnClickListener {
        final /* synthetic */ ApkInfo a;

        c(ApkInfo apkInfo) {
            this.a = apkInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.rtk.app.tool.t.X0(FamilyUpFragmentUpListAdapter.this.f, this.a);
        }
    }

    public FamilyUpFragmentUpListAdapter(List<UpApkListBean.DataBean> list, Context context) {
        this.e = list;
        this.f = context;
    }

    public int getItemCount() {
        if (this.e.size() == 0) {
            return 1;
        }
        return this.e.size() + 1;
    }

    public int getItemViewType(int i) {
        return (i == getItemCount() - 1 || getItemCount() == 1) ? 0 : 1;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        String str;
        try {
            int i2 = 0;
            if (getItemViewType(i) != 0) {
                ViewHolder viewHolder2 = (ViewHolder) viewHolder;
                UpApkListBean.DataBean dataBean = this.e.get(i);
                viewHolder2.upApkListMyAttentionItemGameTime.setText(dataBean.getAddtime());
                viewHolder2.upApkListMyAttentionItemGameName.setText(dataBean.getVarName());
                if (com.rtk.app.tool.c0.q(this.e.get(i).getDataPath())) {
                    str = dataBean.getSourceSize();
                } else {
                    str = this.e.get(i).getDataSize() + "(数据包)";
                }
                viewHolder2.upApkListMyAttentionItemGameVersionAndSize.setText(dataBean.getVersionName() + "  |  " + str);
                com.rtk.app.tool.t.c(this.f, dataBean.getSourceLogo(), viewHolder2.upApkListMyAttentionItemIcon, new boolean[0]);
                com.rtk.app.tool.t.c(this.f, dataBean.getFace(), viewHolder2.upApkListMyAttentionUserIcon, new boolean[0]);
                viewHolder2.upApkListMyAttentionUserName.setText(dataBean.getNickname());
                if (!com.rtk.app.tool.c0.q(dataBean.getNotename())) {
                    viewHolder2.upApkListMyAttentionRemark.setVisibility(0);
                    viewHolder2.upApkListMyAttentionRemark.setText("备注：" + dataBean.getNotename());
                } else {
                    viewHolder2.upApkListMyAttentionRemark.setVisibility(8);
                }
                ApkInfo apkInfo = new ApkInfo(dataBean);
                viewHolder2.upApkListMyAttentionItemDownload.setTag(Integer.valueOf(apkInfo.getGameId()));
                com.rtk.app.tool.DownLoadTool.x.c().a(new com.rtk.app.tool.DownLoadTool.u(viewHolder2.upApkListMyAttentionItemProgressBar, apkInfo.getGameId(), viewHolder2.upApkListMyAttentionItemDownload));
                com.rtk.app.tool.i.i.p(this.f, apkInfo, viewHolder2.upApkListMyAttentionItemDownload, viewHolder2.upApkListMyAttentionItemProgressBar);
                viewHolder2.upApkListMyAttentionItemDownload.setOnClickListener(new a(apkInfo));
                viewHolder2.upApkListMyAttentionUserLv.setTag(this.e.get(i).getUid());
                viewHolder2.upApkListMyAttentionUserLv.setOnClickListener(new b());
                viewHolder2.a.setOnClickListener(new c(apkInfo));
                return;
            }
            BaseRecyclerViewAdapter.RecyclerViewFootViewHolder recyclerViewFootViewHolder = (BaseRecyclerViewAdapter.RecyclerViewFootViewHolder) viewHolder;
            Boolean valueOf = Boolean.valueOf(g());
            List<UpApkListBean.DataBean> list = this.e;
            if (list != null) {
                i2 = list.size();
            }
            recyclerViewFootViewHolder.f(valueOf, i2, h(), f());
        } catch (Exception e) {
            com.rtk.app.tool.c0.u("CommunityFragmentPostListAdapter", "异常" + e.toString());
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != 0) {
            return new ViewHolder(LayoutInflater.from(this.f).inflate(R.layout.up_apk_list_my_attention_item_layout, (ViewGroup) null));
        }
        return new BaseRecyclerViewAdapter.RecyclerViewFootViewHolder(LayoutInflater.from(this.f).inflate(R.layout.looding_footview, viewGroup, false));
    }
}
