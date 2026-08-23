package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.base.BaseRecyclerViewAdapter;
import com.rtk.app.bean.RankTioInformationBean;
import com.rtk.app.bean.UpApkListBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.tool.ApkInfo;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeUpExampleListRecyclerViewAdapter extends BaseRecyclerViewAdapter {
    private Context e;
    private List<UpApkListBean.DataBean> f;
    private UpApkListBean.DataBean g;
    private UpApkListBean.DataBean h;
    private UpApkListBean.DataBean i;
    private RankTioInformationBean j;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class CommandViewHolder extends RecyclerView.ViewHolder {
        View a;

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

        CommandViewHolder(View view) {
            super(view);
            this.a = view;
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class CommandViewHolder_ViewBinding implements Unbinder {
        private CommandViewHolder b;

        @UiThread
        public CommandViewHolder_ViewBinding(CommandViewHolder commandViewHolder, View view) {
            this.b = commandViewHolder;
            commandViewHolder.upApkListItemIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.up_apk_list_item_icon, "field 'upApkListItemIcon'", RoundedImageView.class);
            commandViewHolder.upApkListItemGameName = (TextView) butterknife.c.a.c(view, R.id.up_apk_list_item_gameName, "field 'upApkListItemGameName'", TextView.class);
            commandViewHolder.upApkListItemGameVersionAndSize = (CustomTextView) butterknife.c.a.c(view, R.id.up_apk_list_item_gameVersionAndSize, "field 'upApkListItemGameVersionAndSize'", CustomTextView.class);
            commandViewHolder.upApkListItemGameTime = (CustomTextView) butterknife.c.a.c(view, R.id.up_apk_list_item_gameTime, "field 'upApkListItemGameTime'", CustomTextView.class);
            commandViewHolder.upApkListItemProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.up_apk_list_item_progressBar, "field 'upApkListItemProgressBar'", ProgressBar.class);
            commandViewHolder.upApkListItemDownload = (TextView) butterknife.c.a.c(view, R.id.up_apk_list_item_download, "field 'upApkListItemDownload'", TextView.class);
        }

        @CallSuper
        public void a() {
            CommandViewHolder commandViewHolder = this.b;
            if (commandViewHolder != null) {
                this.b = null;
                commandViewHolder.upApkListItemIcon = null;
                commandViewHolder.upApkListItemGameName = null;
                commandViewHolder.upApkListItemGameVersionAndSize = null;
                commandViewHolder.upApkListItemGameTime = null;
                commandViewHolder.upApkListItemProgressBar = null;
                commandViewHolder.upApkListItemDownload = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class TopViewHolder extends RecyclerView.ViewHolder {

        @BindView
        ImageView homeUpExampleListRecyclerViewFirstDown;

        @BindView
        ImageView homeUpExampleListRecyclerViewFirstModify;

        @BindView
        ImageView homeUpExampleListRecyclerViewTopCap;

        @BindView
        ImageView homeUpExampleListRecyclerViewTopFirstCap;

        @BindView
        ImageView homeUpExampleListRecyclerViewTopFirstIcon;

        @BindView
        RelativeLayout homeUpExampleListRecyclerViewTopFirstLayout;

        @BindView
        TextView homeUpExampleListRecyclerViewTopFirstName;

        @BindView
        TextView homeUpExampleListRecyclerViewTopFirstSize;

        @BindView
        TextView homeUpExampleListRecyclerViewTopFristDownload;

        @BindView
        ProgressBar homeUpExampleListRecyclerViewTopFristProgressBar;

        @BindView
        TextView homeUpExampleListRecyclerViewTopMessage;

        @BindView
        LinearLayout homeUpExampleListRecyclerViewTopMessageLayout;

        @BindView
        ImageView homeUpExampleListRecyclerViewTopModify;

        @BindView
        ImageView homeUpExampleListRecyclerViewTopThreeCap;

        @BindView
        ImageView homeUpExampleListRecyclerViewTopThreeDown;

        @BindView
        TextView homeUpExampleListRecyclerViewTopThreeDownload;

        @BindView
        ImageView homeUpExampleListRecyclerViewTopThreeIcon;

        @BindView
        RelativeLayout homeUpExampleListRecyclerViewTopThreeLayout;

        @BindView
        ImageView homeUpExampleListRecyclerViewTopThreeModify;

        @BindView
        TextView homeUpExampleListRecyclerViewTopThreeName;

        @BindView
        ProgressBar homeUpExampleListRecyclerViewTopThreeProgressBar;

        @BindView
        TextView homeUpExampleListRecyclerViewTopThreeSize;

        @BindView
        ImageView homeUpExampleListRecyclerViewTopTwoDown;

        @BindView
        TextView homeUpExampleListRecyclerViewTopTwoDownload;

        @BindView
        ImageView homeUpExampleListRecyclerViewTopTwoIcon;

        @BindView
        RelativeLayout homeUpExampleListRecyclerViewTopTwoLayout;

        @BindView
        TextView homeUpExampleListRecyclerViewTopTwoName;

        @BindView
        ProgressBar homeUpExampleListRecyclerViewTopTwoProgressBar;

        @BindView
        TextView homeUpExampleListRecyclerViewTopTwoSize;

        public TopViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class TopViewHolder_ViewBinding implements Unbinder {
        private TopViewHolder b;

        @UiThread
        public TopViewHolder_ViewBinding(TopViewHolder topViewHolder, View view) {
            this.b = topViewHolder;
            topViewHolder.homeUpExampleListRecyclerViewTopMessageLayout = (LinearLayout) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_top_message_layout, "field 'homeUpExampleListRecyclerViewTopMessageLayout'", LinearLayout.class);
            topViewHolder.homeUpExampleListRecyclerViewTopMessage = (TextView) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_top_message, "field 'homeUpExampleListRecyclerViewTopMessage'", TextView.class);
            topViewHolder.homeUpExampleListRecyclerViewTopCap = (ImageView) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_top_cap, "field 'homeUpExampleListRecyclerViewTopCap'", ImageView.class);
            topViewHolder.homeUpExampleListRecyclerViewTopTwoDown = (ImageView) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_top_two_down, "field 'homeUpExampleListRecyclerViewTopTwoDown'", ImageView.class);
            topViewHolder.homeUpExampleListRecyclerViewTopModify = (ImageView) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_top_modify, "field 'homeUpExampleListRecyclerViewTopModify'", ImageView.class);
            topViewHolder.homeUpExampleListRecyclerViewTopTwoIcon = (ImageView) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_top_two_icon, "field 'homeUpExampleListRecyclerViewTopTwoIcon'", ImageView.class);
            topViewHolder.homeUpExampleListRecyclerViewTopTwoName = (TextView) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_top_two_name, "field 'homeUpExampleListRecyclerViewTopTwoName'", TextView.class);
            topViewHolder.homeUpExampleListRecyclerViewTopTwoSize = (TextView) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_top_two_size, "field 'homeUpExampleListRecyclerViewTopTwoSize'", TextView.class);
            topViewHolder.homeUpExampleListRecyclerViewTopTwoLayout = (RelativeLayout) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_top_two_layout, "field 'homeUpExampleListRecyclerViewTopTwoLayout'", RelativeLayout.class);
            topViewHolder.homeUpExampleListRecyclerViewTopFirstCap = (ImageView) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_top_first_cap, "field 'homeUpExampleListRecyclerViewTopFirstCap'", ImageView.class);
            topViewHolder.homeUpExampleListRecyclerViewFirstDown = (ImageView) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_first_down, "field 'homeUpExampleListRecyclerViewFirstDown'", ImageView.class);
            topViewHolder.homeUpExampleListRecyclerViewFirstModify = (ImageView) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_first_modify, "field 'homeUpExampleListRecyclerViewFirstModify'", ImageView.class);
            topViewHolder.homeUpExampleListRecyclerViewTopFirstIcon = (ImageView) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_top_first_icon, "field 'homeUpExampleListRecyclerViewTopFirstIcon'", ImageView.class);
            topViewHolder.homeUpExampleListRecyclerViewTopFirstName = (TextView) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_top_first_name, "field 'homeUpExampleListRecyclerViewTopFirstName'", TextView.class);
            topViewHolder.homeUpExampleListRecyclerViewTopFirstSize = (TextView) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_top_first_size, "field 'homeUpExampleListRecyclerViewTopFirstSize'", TextView.class);
            topViewHolder.homeUpExampleListRecyclerViewTopFirstLayout = (RelativeLayout) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_top_first_layout, "field 'homeUpExampleListRecyclerViewTopFirstLayout'", RelativeLayout.class);
            topViewHolder.homeUpExampleListRecyclerViewTopThreeCap = (ImageView) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_top_three_cap, "field 'homeUpExampleListRecyclerViewTopThreeCap'", ImageView.class);
            topViewHolder.homeUpExampleListRecyclerViewTopThreeDown = (ImageView) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_top_three_down, "field 'homeUpExampleListRecyclerViewTopThreeDown'", ImageView.class);
            topViewHolder.homeUpExampleListRecyclerViewTopThreeModify = (ImageView) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_top_three_modify, "field 'homeUpExampleListRecyclerViewTopThreeModify'", ImageView.class);
            topViewHolder.homeUpExampleListRecyclerViewTopThreeIcon = (ImageView) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_top_three_icon, "field 'homeUpExampleListRecyclerViewTopThreeIcon'", ImageView.class);
            topViewHolder.homeUpExampleListRecyclerViewTopThreeName = (TextView) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_top_three_name, "field 'homeUpExampleListRecyclerViewTopThreeName'", TextView.class);
            topViewHolder.homeUpExampleListRecyclerViewTopThreeSize = (TextView) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_top_three_size, "field 'homeUpExampleListRecyclerViewTopThreeSize'", TextView.class);
            topViewHolder.homeUpExampleListRecyclerViewTopThreeLayout = (RelativeLayout) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_top_three_layout, "field 'homeUpExampleListRecyclerViewTopThreeLayout'", RelativeLayout.class);
            topViewHolder.homeUpExampleListRecyclerViewTopTwoProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_top_two_progressBar, "field 'homeUpExampleListRecyclerViewTopTwoProgressBar'", ProgressBar.class);
            topViewHolder.homeUpExampleListRecyclerViewTopTwoDownload = (TextView) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_top_two_download, "field 'homeUpExampleListRecyclerViewTopTwoDownload'", TextView.class);
            topViewHolder.homeUpExampleListRecyclerViewTopFristProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_top_frist_progressBar, "field 'homeUpExampleListRecyclerViewTopFristProgressBar'", ProgressBar.class);
            topViewHolder.homeUpExampleListRecyclerViewTopFristDownload = (TextView) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_top_frist_download, "field 'homeUpExampleListRecyclerViewTopFristDownload'", TextView.class);
            topViewHolder.homeUpExampleListRecyclerViewTopThreeProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_top_three_progressBar, "field 'homeUpExampleListRecyclerViewTopThreeProgressBar'", ProgressBar.class);
            topViewHolder.homeUpExampleListRecyclerViewTopThreeDownload = (TextView) butterknife.c.a.c(view, R.id.home_up_example_list_recycler_view_top_three_download, "field 'homeUpExampleListRecyclerViewTopThreeDownload'", TextView.class);
        }

        @CallSuper
        public void a() {
            TopViewHolder topViewHolder = this.b;
            if (topViewHolder != null) {
                this.b = null;
                topViewHolder.homeUpExampleListRecyclerViewTopMessageLayout = null;
                topViewHolder.homeUpExampleListRecyclerViewTopMessage = null;
                topViewHolder.homeUpExampleListRecyclerViewTopCap = null;
                topViewHolder.homeUpExampleListRecyclerViewTopTwoDown = null;
                topViewHolder.homeUpExampleListRecyclerViewTopModify = null;
                topViewHolder.homeUpExampleListRecyclerViewTopTwoIcon = null;
                topViewHolder.homeUpExampleListRecyclerViewTopTwoName = null;
                topViewHolder.homeUpExampleListRecyclerViewTopTwoSize = null;
                topViewHolder.homeUpExampleListRecyclerViewTopTwoLayout = null;
                topViewHolder.homeUpExampleListRecyclerViewTopFirstCap = null;
                topViewHolder.homeUpExampleListRecyclerViewFirstDown = null;
                topViewHolder.homeUpExampleListRecyclerViewFirstModify = null;
                topViewHolder.homeUpExampleListRecyclerViewTopFirstIcon = null;
                topViewHolder.homeUpExampleListRecyclerViewTopFirstName = null;
                topViewHolder.homeUpExampleListRecyclerViewTopFirstSize = null;
                topViewHolder.homeUpExampleListRecyclerViewTopFirstLayout = null;
                topViewHolder.homeUpExampleListRecyclerViewTopThreeCap = null;
                topViewHolder.homeUpExampleListRecyclerViewTopThreeDown = null;
                topViewHolder.homeUpExampleListRecyclerViewTopThreeModify = null;
                topViewHolder.homeUpExampleListRecyclerViewTopThreeIcon = null;
                topViewHolder.homeUpExampleListRecyclerViewTopThreeName = null;
                topViewHolder.homeUpExampleListRecyclerViewTopThreeSize = null;
                topViewHolder.homeUpExampleListRecyclerViewTopThreeLayout = null;
                topViewHolder.homeUpExampleListRecyclerViewTopTwoProgressBar = null;
                topViewHolder.homeUpExampleListRecyclerViewTopTwoDownload = null;
                topViewHolder.homeUpExampleListRecyclerViewTopFristProgressBar = null;
                topViewHolder.homeUpExampleListRecyclerViewTopFristDownload = null;
                topViewHolder.homeUpExampleListRecyclerViewTopThreeProgressBar = null;
                topViewHolder.homeUpExampleListRecyclerViewTopThreeDownload = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public HomeUpExampleListRecyclerViewAdapter(Context context, List<UpApkListBean.DataBean> list) {
        this.e = context;
        this.f = list;
        if (list == null || list.size() < 3) {
            return;
        }
        this.g = list.get(0);
        this.h = list.get(1);
        this.i = list.get(2);
        list.remove(0);
        list.remove(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(ApkInfo apkInfo, View view) {
        com.rtk.app.tool.i.i.o(this.e, apkInfo, (TextView) view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(ApkInfo apkInfo, View view) {
        com.rtk.app.tool.i.i.o(this.e, apkInfo, (TextView) view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(ApkInfo apkInfo, View view) {
        com.rtk.app.tool.i.i.o(this.e, apkInfo, (TextView) view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(ApkInfo apkInfo, View view) {
        com.rtk.app.tool.t.X0(this.e, apkInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u(ApkInfo apkInfo, View view) {
        com.rtk.app.tool.t.X0(this.e, apkInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(ApkInfo apkInfo, View view) {
        com.rtk.app.tool.t.X0(this.e, apkInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(ApkInfo apkInfo, View view) {
        com.rtk.app.tool.i.i.o(this.e, apkInfo, (TextView) view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A(ApkInfo apkInfo, View view) {
        com.rtk.app.tool.t.X0(this.e, apkInfo);
    }

    public void B(RankTioInformationBean rankTioInformationBean) {
        this.j = rankTioInformationBean;
    }

    public int getItemCount() {
        return this.f.size() + 1;
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        return i == getItemCount() - 1 ? 2 : 1;
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType != 0) {
            if (itemViewType != 1) {
                ((BaseRecyclerViewAdapter.RecyclerViewFootViewHolder) viewHolder).f(Boolean.valueOf(g()), getItemCount(), h(), f());
                return;
            }
            CommandViewHolder commandViewHolder = (CommandViewHolder) viewHolder;
            commandViewHolder.upApkListItemGameTime.setText(this.f.get(i).getAddtime());
            commandViewHolder.upApkListItemGameName.setText(this.f.get(i).getVarName());
            commandViewHolder.upApkListItemGameVersionAndSize.setText(this.f.get(i).getVersionName() + "  |  " + this.f.get(i).getSourceSize());
            com.rtk.app.tool.t.c(this.e, this.f.get(i).getSourceLogo(), commandViewHolder.upApkListItemIcon, new boolean[0]);
            final ApkInfo apkInfo = new ApkInfo(this.f.get(i));
            commandViewHolder.upApkListItemDownload.setTag(Integer.valueOf(apkInfo.getGameId()));
            com.rtk.app.tool.DownLoadTool.u uVar = new com.rtk.app.tool.DownLoadTool.u(commandViewHolder.upApkListItemProgressBar, apkInfo.getGameId(), commandViewHolder.upApkListItemDownload);
            this.b.add(uVar);
            com.rtk.app.tool.DownLoadTool.x.c().a(uVar);
            com.rtk.app.tool.i.i.p(this.e, apkInfo, commandViewHolder.upApkListItemDownload, commandViewHolder.upApkListItemProgressBar);
            commandViewHolder.upApkListItemDownload.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.m1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeUpExampleListRecyclerViewAdapter.this.y(apkInfo, view);
                }
            });
            commandViewHolder.a.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.i1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeUpExampleListRecyclerViewAdapter.this.A(apkInfo, view);
                }
            });
            return;
        }
        TopViewHolder topViewHolder = (TopViewHolder) viewHolder;
        UpApkListBean.DataBean dataBean = this.g;
        if (dataBean == null || this.h == null || this.i == null) {
            return;
        }
        com.rtk.app.tool.t.c(this.e, dataBean.getSourceLogo(), topViewHolder.homeUpExampleListRecyclerViewTopFirstIcon, new boolean[0]);
        com.rtk.app.tool.t.c(this.e, this.h.getSourceLogo(), topViewHolder.homeUpExampleListRecyclerViewTopTwoIcon, new boolean[0]);
        com.rtk.app.tool.t.c(this.e, this.i.getSourceLogo(), topViewHolder.homeUpExampleListRecyclerViewTopThreeIcon, new boolean[0]);
        topViewHolder.homeUpExampleListRecyclerViewTopFirstName.setText(this.g.getSourceName());
        topViewHolder.homeUpExampleListRecyclerViewTopTwoName.setText(this.h.getSourceName());
        topViewHolder.homeUpExampleListRecyclerViewTopThreeName.setText(this.i.getSourceName());
        topViewHolder.homeUpExampleListRecyclerViewTopFirstSize.setText(this.g.getSourceSize());
        topViewHolder.homeUpExampleListRecyclerViewTopTwoSize.setText(this.h.getSourceSize());
        topViewHolder.homeUpExampleListRecyclerViewTopThreeSize.setText(this.i.getSourceSize());
        final ApkInfo apkInfo2 = new ApkInfo(this.g);
        final ApkInfo apkInfo3 = new ApkInfo(this.h);
        final ApkInfo apkInfo4 = new ApkInfo(this.i);
        topViewHolder.homeUpExampleListRecyclerViewTopFristDownload.setTag(Integer.valueOf(apkInfo2.getGameId()));
        topViewHolder.homeUpExampleListRecyclerViewTopTwoDownload.setTag(Integer.valueOf(apkInfo3.getGameId()));
        topViewHolder.homeUpExampleListRecyclerViewTopThreeDownload.setTag(Integer.valueOf(apkInfo4.getGameId()));
        com.rtk.app.tool.DownLoadTool.u uVar2 = new com.rtk.app.tool.DownLoadTool.u(topViewHolder.homeUpExampleListRecyclerViewTopFristProgressBar, apkInfo2.getGameId(), topViewHolder.homeUpExampleListRecyclerViewTopFristDownload);
        com.rtk.app.tool.DownLoadTool.u uVar3 = new com.rtk.app.tool.DownLoadTool.u(topViewHolder.homeUpExampleListRecyclerViewTopTwoProgressBar, apkInfo3.getGameId(), topViewHolder.homeUpExampleListRecyclerViewTopTwoDownload);
        com.rtk.app.tool.DownLoadTool.u uVar4 = new com.rtk.app.tool.DownLoadTool.u(topViewHolder.homeUpExampleListRecyclerViewTopThreeProgressBar, apkInfo4.getGameId(), topViewHolder.homeUpExampleListRecyclerViewTopThreeDownload);
        this.b.add(uVar2);
        this.b.add(uVar3);
        this.b.add(uVar4);
        com.rtk.app.tool.DownLoadTool.x.c().a(uVar2);
        com.rtk.app.tool.DownLoadTool.x.c().a(uVar3);
        com.rtk.app.tool.DownLoadTool.x.c().a(uVar4);
        com.rtk.app.tool.t.S1(this.e, null, null, null, null, topViewHolder.homeUpExampleListRecyclerViewTopTwoLayout, topViewHolder.homeUpExampleListRecyclerViewTopThreeLayout, topViewHolder.homeUpExampleListRecyclerViewTopFirstLayout, topViewHolder.homeUpExampleListRecyclerViewTopMessageLayout);
        com.rtk.app.tool.i.i.p(this.e, apkInfo2, topViewHolder.homeUpExampleListRecyclerViewTopFristDownload, topViewHolder.homeUpExampleListRecyclerViewTopFristProgressBar);
        com.rtk.app.tool.i.i.p(this.e, apkInfo3, topViewHolder.homeUpExampleListRecyclerViewTopTwoDownload, topViewHolder.homeUpExampleListRecyclerViewTopTwoProgressBar);
        com.rtk.app.tool.i.i.p(this.e, apkInfo4, topViewHolder.homeUpExampleListRecyclerViewTopThreeDownload, topViewHolder.homeUpExampleListRecyclerViewTopThreeProgressBar);
        topViewHolder.homeUpExampleListRecyclerViewTopFristDownload.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.k1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeUpExampleListRecyclerViewAdapter.this.m(apkInfo2, view);
            }
        });
        topViewHolder.homeUpExampleListRecyclerViewTopTwoDownload.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.f1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeUpExampleListRecyclerViewAdapter.this.o(apkInfo3, view);
            }
        });
        topViewHolder.homeUpExampleListRecyclerViewTopThreeDownload.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.j1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeUpExampleListRecyclerViewAdapter.this.q(apkInfo4, view);
            }
        });
        topViewHolder.homeUpExampleListRecyclerViewTopFirstLayout.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.h1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeUpExampleListRecyclerViewAdapter.this.s(apkInfo2, view);
            }
        });
        topViewHolder.homeUpExampleListRecyclerViewTopTwoLayout.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeUpExampleListRecyclerViewAdapter.this.u(apkInfo3, view);
            }
        });
        topViewHolder.homeUpExampleListRecyclerViewTopThreeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.l1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeUpExampleListRecyclerViewAdapter.this.w(apkInfo4, view);
            }
        });
        RankTioInformationBean rankTioInformationBean = this.j;
        if (rankTioInformationBean != null) {
            topViewHolder.homeUpExampleListRecyclerViewTopMessage.setText(rankTioInformationBean.getData());
        }
    }

    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new TopViewHolder(LayoutInflater.from(this.e).inflate(R.layout.home_up_example_list_recycler_view_top, viewGroup, false));
        }
        if (i != 1) {
            return new BaseRecyclerViewAdapter.RecyclerViewFootViewHolder(LayoutInflater.from(this.e).inflate(R.layout.looding_footview, viewGroup, false));
        }
        return new CommandViewHolder(LayoutInflater.from(this.e).inflate(R.layout.up_apk_list_item_layout, viewGroup, false));
    }
}
