package com.rtk.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.GsonBuilder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.rtk.app.R;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.UpApkDetailsBean;
import com.rtk.app.bean.UpApkListBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.main.Home5Activity.UpSrcListHelpActivity;
import com.rtk.app.main.dialogPack.DialogForEnSure;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpSrcListAdapter extends a3 implements h.j {

    /* renamed from: c, reason: collision with root package name */
    private final DialogForProgressTip f125c;
    private Context d;
    private List<UpApkListBean.DataBean> e;
    private c f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ViewHolder {

        @BindView
        CustomTextView upSrcApkListItemAllClickNum;

        @BindView
        CustomTextView upSrcApkListItemAllDownloadNum;

        @BindView
        TextView upSrcApkListItemCheckState;

        @BindView
        CustomTextView upSrcApkListItemCheckStateReason;

        @BindView
        CustomTextView upSrcApkListItemClickNum;

        @BindView
        TextView upSrcApkListItemDownLoad;

        @BindView
        RelativeLayout upSrcApkListItemDownLoadLv;

        @BindView
        CustomTextView upSrcApkListItemDownloadNum;

        @BindView
        TextView upSrcApkListItemGameName;

        @BindView
        CustomTextView upSrcApkListItemGameTime;

        @BindView
        CustomTextView upSrcApkListItemGameVersionAndSize;

        @BindView
        ImageView upSrcApkListItemHelp;

        @BindView
        RoundedImageView upSrcApkListItemIcon;

        @BindView
        TextView upSrcApkListItemIsFamily;

        @BindView
        CustomTextView upSrcApkListItemJurisdiction;

        @BindView
        LinearLayout upSrcApkListItemMySrcInfo;

        @BindView
        ProgressBar upSrcApkListItemProgressBar;

        @BindView
        ImageView upSrcApkListItemToMore;

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
            viewHolder.upSrcApkListItemHelp = (ImageView) butterknife.c.a.c(view, R.id.up_src_apk_list_item_help, "field 'upSrcApkListItemHelp'", ImageView.class);
            viewHolder.upSrcApkListItemIsFamily = (TextView) butterknife.c.a.c(view, R.id.up_src_apk_list_item_is_family, "field 'upSrcApkListItemIsFamily'", TextView.class);
            viewHolder.upSrcApkListItemToMore = (ImageView) butterknife.c.a.c(view, R.id.up_src_apk_list_item_toMore, "field 'upSrcApkListItemToMore'", ImageView.class);
            viewHolder.upSrcApkListItemIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.up_src_apk_list_item_icon, "field 'upSrcApkListItemIcon'", RoundedImageView.class);
            viewHolder.upSrcApkListItemGameName = (TextView) butterknife.c.a.c(view, R.id.up_src_apk_list_item_gameName, "field 'upSrcApkListItemGameName'", TextView.class);
            viewHolder.upSrcApkListItemGameVersionAndSize = (CustomTextView) butterknife.c.a.c(view, R.id.up_src_apk_list_item_gameVersionAndSize, "field 'upSrcApkListItemGameVersionAndSize'", CustomTextView.class);
            viewHolder.upSrcApkListItemGameTime = (CustomTextView) butterknife.c.a.c(view, R.id.up_src_apk_list_item_gameTime, "field 'upSrcApkListItemGameTime'", CustomTextView.class);
            viewHolder.upSrcApkListItemCheckState = (TextView) butterknife.c.a.c(view, R.id.up_src_apk_list_item_checkState, "field 'upSrcApkListItemCheckState'", TextView.class);
            viewHolder.upSrcApkListItemJurisdiction = (CustomTextView) butterknife.c.a.c(view, R.id.up_src_apk_list_item_jurisdiction, "field 'upSrcApkListItemJurisdiction'", CustomTextView.class);
            viewHolder.upSrcApkListItemCheckStateReason = (CustomTextView) butterknife.c.a.c(view, R.id.up_src_apk_list_item_checkState_reason, "field 'upSrcApkListItemCheckStateReason'", CustomTextView.class);
            viewHolder.upSrcApkListItemDownLoadLv = (RelativeLayout) butterknife.c.a.c(view, R.id.up_src_apk_list_item_downLoad_lv, "field 'upSrcApkListItemDownLoadLv'", RelativeLayout.class);
            viewHolder.upSrcApkListItemProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.up_src_apk_list_item_ProgressBar, "field 'upSrcApkListItemProgressBar'", ProgressBar.class);
            viewHolder.upSrcApkListItemDownLoad = (TextView) butterknife.c.a.c(view, R.id.up_src_apk_list_item_downLoad, "field 'upSrcApkListItemDownLoad'", TextView.class);
            viewHolder.upSrcApkListItemMySrcInfo = (LinearLayout) butterknife.c.a.c(view, R.id.up_src_apk_list_item_my_src_info, "field 'upSrcApkListItemMySrcInfo'", LinearLayout.class);
            viewHolder.upSrcApkListItemDownloadNum = (CustomTextView) butterknife.c.a.c(view, R.id.up_src_apk_list_item_download_num, "field 'upSrcApkListItemDownloadNum'", CustomTextView.class);
            viewHolder.upSrcApkListItemClickNum = (CustomTextView) butterknife.c.a.c(view, R.id.up_src_apk_list_item_click_num, "field 'upSrcApkListItemClickNum'", CustomTextView.class);
            viewHolder.upSrcApkListItemAllDownloadNum = (CustomTextView) butterknife.c.a.c(view, R.id.up_src_apk_list_item_all_download_num, "field 'upSrcApkListItemAllDownloadNum'", CustomTextView.class);
            viewHolder.upSrcApkListItemAllClickNum = (CustomTextView) butterknife.c.a.c(view, R.id.up_src_apk_list_item_all_click_num, "field 'upSrcApkListItemAllClickNum'", CustomTextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.upSrcApkListItemHelp = null;
                viewHolder.upSrcApkListItemIsFamily = null;
                viewHolder.upSrcApkListItemToMore = null;
                viewHolder.upSrcApkListItemIcon = null;
                viewHolder.upSrcApkListItemGameName = null;
                viewHolder.upSrcApkListItemGameVersionAndSize = null;
                viewHolder.upSrcApkListItemGameTime = null;
                viewHolder.upSrcApkListItemCheckState = null;
                viewHolder.upSrcApkListItemJurisdiction = null;
                viewHolder.upSrcApkListItemCheckStateReason = null;
                viewHolder.upSrcApkListItemDownLoadLv = null;
                viewHolder.upSrcApkListItemProgressBar = null;
                viewHolder.upSrcApkListItemDownLoad = null;
                viewHolder.upSrcApkListItemMySrcInfo = null;
                viewHolder.upSrcApkListItemDownloadNum = null;
                viewHolder.upSrcApkListItemClickNum = null;
                viewHolder.upSrcApkListItemAllDownloadNum = null;
                viewHolder.upSrcApkListItemAllClickNum = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements com.rtk.app.tool.s {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            UpSrcListAdapter.this.i((this.a * 10) + 1);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private class b implements View.OnClickListener {
        private int a;
        private int b;

        public b(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                com.rtk.app.tool.DownLoadTool.r.g(UpSrcListAdapter.this.d, new ApkInfo((UpApkListBean.DataBean) UpSrcListAdapter.this.e.get(this.b)), (TextView) view);
            } else {
                if (i != 1) {
                    return;
                }
                com.rtk.app.tool.c.b((Activity) UpSrcListAdapter.this.d, UpSrcListHelpActivity.class, null);
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum c {
        UpCheckApk,
        MyUpApk
    }

    public UpSrcListAdapter(Context context, List<UpApkListBean.DataBean> list, c cVar) {
        super(list);
        this.d = context;
        this.f = cVar;
        this.e = list;
        this.f125c = new DialogForProgressTip(context, "请稍后");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i) {
        String sb;
        int i2 = i % 10;
        int i3 = i / 10;
        if (i2 == 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/source_del_by_self");
            sb2.append(com.rtk.app.tool.y.u(this.d));
            sb2.append("&uid=");
            sb2.append(com.rtk.app.tool.y.K());
            sb2.append("&token=");
            sb2.append(com.rtk.app.tool.y.H());
            sb2.append("&sid=");
            sb2.append(this.e.get(i3).getId());
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.d, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "sid=" + this.e.get(i3).getId()))));
            sb = sb2.toString();
        } else {
            if (i2 == 2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("up/detail");
                sb3.append(com.rtk.app.tool.y.u(this.d));
                sb3.append("&sid=");
                sb3.append(this.e.get(i3).getId());
                sb3.append("&di=");
                sb3.append(com.rtk.app.tool.y.r(this.d));
                sb3.append("&uid=");
                sb3.append(com.rtk.app.tool.y.K());
                sb3.append("&token=");
                sb3.append(com.rtk.app.tool.y.H());
                sb3.append("&key=");
                sb3.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.d, "di=" + com.rtk.app.tool.y.r(this.d), "sid=" + this.e.get(i3).getId()))));
                com.rtk.app.tool.o.h.l(this.d, this, i, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb3.toString()));
                return;
            }
            sb = "";
        }
        com.rtk.app.tool.o.h.l(this.d, this, i, com.rtk.app.tool.o.h.h(new String[0]).a(sb));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(ViewHolder viewHolder, View view) {
        n(view, ((Integer) view.getTag()).intValue(), viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean m(int i, ViewHolder viewHolder, MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.up_src_more_click_num /* 2131301039 */:
                com.rtk.app.tool.t.a1(this.e.get(i).getId());
                return false;
            case R.id.up_src_more_delete /* 2131301040 */:
                new DialogForEnSure(this.d, "确定删除吗？删除后不可恢复！", new a(i)).show();
                return false;
            case R.id.up_src_more_downLoad /* 2131301041 */:
                ApkInfo apkInfo = new ApkInfo(this.e.get(i));
                this.e.get(i);
                com.rtk.app.tool.DownLoadTool.r.c(this.d, new com.rtk.app.tool.DownLoadTool.p(apkInfo, 0));
                com.rtk.app.tool.t.o0(this.d);
                return false;
            case R.id.up_src_more_downLoad_num /* 2131301042 */:
                try {
                    com.rtk.app.tool.t.i1(this.e.get(i).getId(), Integer.parseInt(this.e.get(i).getDownNum()), this.e.get(i).getTodayDown());
                } catch (Exception unused) {
                }
                return false;
            case R.id.up_src_more_edit /* 2131301043 */:
                this.f125c.show();
                i((i * 10) + 2);
                return false;
            case R.id.up_src_more_rights_desc /* 2131301044 */:
                viewHolder.upSrcApkListItemJurisdiction.performClick();
                return false;
            default:
                return false;
        }
    }

    private void n(View view, final int i, final ViewHolder viewHolder) {
        PopupMenu popupMenu = new PopupMenu(this.d, view);
        popupMenu.getMenuInflater().inflate(R.menu.up_src_more, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.rtk.app.adapter.s2
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return UpSrcListAdapter.this.m(i, viewHolder, menuItem);
            }
        });
        popupMenu.show();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        int i2 = i % 10;
        int i3 = i / 10;
        if (i2 == 1) {
            com.rtk.app.tool.c0.u("UpSrcListAdapter", "删除资源成功" + str);
            com.rtk.app.tool.f.a(this.d, "删除资源成功", f.a.f);
            this.e.remove(i3);
            notifyDataSetChanged();
            return;
        }
        if (i2 != 2) {
            return;
        }
        UpApkDetailsBean upApkDetailsBean = (UpApkDetailsBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, UpApkDetailsBean.class);
        if (upApkDetailsBean.getData().isZip()) {
            com.rtk.app.tool.f.a(this.d, "数据包类型UP资源不支持编辑", f.a.f);
            this.f125c.dismiss();
        } else {
            com.rtk.app.tool.t.b1((BaseActivity) this.d, upApkDetailsBean.getData(), 1015);
            this.f125c.dismiss();
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        int i3 = i2 % 10;
        int i4 = i2 / 10;
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            this.f125c.dismiss();
        } else {
            com.rtk.app.tool.c0.u("UpSrcListAdapter", "删除资源失败" + str);
            com.rtk.app.tool.f.a(this.d, str, f.a.f);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        int parseInt;
        String showmsg;
        String str;
        String str2;
        if (view == null) {
            view = LayoutInflater.from(this.d).inflate(R.layout.up_src_apk_list_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        UpApkListBean.DataBean dataBean = this.e.get(i);
        viewHolder.upSrcApkListItemGameTime.setText(dataBean.getAddtime());
        if (dataBean.isFamily()) {
            parseInt = Integer.parseInt(dataBean.getIsshow3());
            showmsg = dataBean.getShowmsg3();
        } else {
            parseInt = Integer.parseInt(dataBean.getIsshow());
            showmsg = dataBean.getShowmsg();
        }
        if (dataBean.getViewPermissions() == 0 && parseInt == 0) {
            CustomTextView customTextView = viewHolder.upSrcApkListItemJurisdiction;
            if (com.rtk.app.tool.c0.q(showmsg)) {
                str2 = "";
            } else {
                str2 = "(" + showmsg + ")";
            }
            customTextView.setRightText(str2);
        } else {
            viewHolder.upSrcApkListItemJurisdiction.setRightText("");
        }
        viewHolder.upSrcApkListItemJurisdiction.setText(com.rtk.app.tool.t.X(this.e.get(i).getViewPermissions(), parseInt));
        viewHolder.upSrcApkListItemGameName.setText(this.e.get(i).getVarName());
        viewHolder.upSrcApkListItemHelp.setVisibility(com.rtk.app.tool.y.K().equals(this.e.get(i).getUid()) ? 0 : 8);
        viewHolder.upSrcApkListItemHelp.setOnClickListener(new b(1, i));
        viewHolder.upSrcApkListItemJurisdiction.setOnClickListener(new b(1, i));
        String status3 = dataBean.isFamily() ? dataBean.getStatus3() : dataBean.getStatus();
        if (!com.rtk.app.tool.c0.q(this.e.get(i).getMsg()) && ("2".equals(status3) || "0".equals(status3))) {
            viewHolder.upSrcApkListItemCheckStateReason.setLeftText("原因：");
            viewHolder.upSrcApkListItemCheckStateReason.setText(this.e.get(i).getMsg());
            viewHolder.upSrcApkListItemToMore.setVisibility(8);
        } else if (com.rtk.app.tool.y.K().equals(this.e.get(i).getUid())) {
            viewHolder.upSrcApkListItemCheckStateReason.setLeftText("打赏：");
            viewHolder.upSrcApkListItemCheckStateReason.setText(this.e.get(i).getCoinNum());
            if (!GlobalSetting.SPLASH_AD.equals(status3) && !"1".equals(status3)) {
                viewHolder.upSrcApkListItemToMore.setVisibility(8);
            } else {
                viewHolder.upSrcApkListItemToMore.setVisibility(0);
            }
            com.rtk.app.tool.c0.u("UpSrcListAdapter", "名字" + this.e.get(i).getVarName() + "   " + status3);
        } else {
            viewHolder.upSrcApkListItemToMore.setVisibility(8);
        }
        com.rtk.app.tool.t.Y1(this.d, viewHolder.upSrcApkListItemCheckState, status3, dataBean.isFamily());
        if (com.rtk.app.tool.c0.q(this.e.get(i).getDataPath())) {
            str = this.e.get(i).getSourceSize();
        } else {
            str = this.e.get(i).getDataSize() + "(数据包)";
        }
        viewHolder.upSrcApkListItemGameVersionAndSize.setText(this.e.get(i).getVersionName() + "  |  " + str);
        com.rtk.app.tool.t.c(this.d, this.e.get(i).getSourceLogo(), viewHolder.upSrcApkListItemIcon, new boolean[0]);
        viewHolder.upSrcApkListItemToMore.setTag(Integer.valueOf(i));
        viewHolder.upSrcApkListItemToMore.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.t2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UpSrcListAdapter.this.k(viewHolder, view2);
            }
        });
        if (this.f.equals(c.UpCheckApk)) {
            viewHolder.upSrcApkListItemDownLoadLv.setVisibility(0);
            ApkInfo apkInfo = new ApkInfo(this.e.get(i));
            viewHolder.upSrcApkListItemDownLoad.setTag(Integer.valueOf(apkInfo.getGameId()));
            viewHolder.upSrcApkListItemDownLoad.setOnClickListener(new b(0, i));
            com.rtk.app.tool.DownLoadTool.u uVar = new com.rtk.app.tool.DownLoadTool.u(viewHolder.upSrcApkListItemProgressBar, apkInfo.getGameId(), viewHolder.upSrcApkListItemDownLoad);
            this.b.add(uVar);
            com.rtk.app.tool.DownLoadTool.x.c().a(uVar);
            com.rtk.app.tool.DownLoadTool.r.h(this.d, apkInfo, viewHolder.upSrcApkListItemDownLoad, viewHolder.upSrcApkListItemProgressBar);
        } else {
            viewHolder.upSrcApkListItemDownLoadLv.setVisibility(8);
        }
        if (this.f == c.MyUpApk) {
            viewHolder.upSrcApkListItemMySrcInfo.setVisibility(0);
            viewHolder.upSrcApkListItemAllDownloadNum.setLeftText("下载量：");
            viewHolder.upSrcApkListItemAllDownloadNum.setText(this.e.get(i).getDownNum() + "");
            viewHolder.upSrcApkListItemDownloadNum.setLeftText("今日：");
            viewHolder.upSrcApkListItemDownloadNum.setText(this.e.get(i).getTodayDown() + "");
            viewHolder.upSrcApkListItemAllClickNum.setLeftText("点击量：");
            viewHolder.upSrcApkListItemAllClickNum.setText(this.e.get(i).getClickNum());
            viewHolder.upSrcApkListItemClickNum.setLeftText("今日：");
            viewHolder.upSrcApkListItemClickNum.setText(this.e.get(i).getTodayClickNum());
        } else {
            viewHolder.upSrcApkListItemMySrcInfo.setVisibility(8);
        }
        if (this.e.get(i).getFamily() != null && this.e.get(i).getFamily().getFamily_id() > 0) {
            viewHolder.upSrcApkListItemIsFamily.setVisibility(0);
        } else {
            viewHolder.upSrcApkListItemIsFamily.setVisibility(8);
        }
        return view;
    }
}
