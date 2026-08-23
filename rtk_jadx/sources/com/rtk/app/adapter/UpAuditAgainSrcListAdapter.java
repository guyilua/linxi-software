package com.rtk.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatTextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.GsonBuilder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.UpApkDetailsBean;
import com.rtk.app.bean.UpAuditAgainListBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.main.Home5Activity.UpSrcListHelpActivity;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpAuditAgainSrcListAdapter extends a3 implements h.j {

    /* renamed from: c, reason: collision with root package name */
    private final DialogForProgressTip f116c;
    private Context d;
    private List<UpAuditAgainListBean.DataDTO> e;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ViewHolder {

        @BindView
        RoundedImageView upSrcApkAgainListItemAuditCheckUserIcon;

        @BindView
        LinearLayout upSrcApkAgainListItemAuditCheckUserLv;

        @BindView
        TextView upSrcApkAgainListItemAuditCheckUserNickName;

        @BindView
        TextView upSrcApkAgainListItemAuditCheckUserReason;

        @BindView
        TextView upSrcApkAgainListItemCheckState;

        @BindView
        CustomTextView upSrcApkAgainListItemCheckStateReason;

        @BindView
        TextView upSrcApkAgainListItemDownLoad;

        @BindView
        RelativeLayout upSrcApkAgainListItemDownLoadLv;

        @BindView
        TextView upSrcApkAgainListItemGameName;

        @BindView
        CustomTextView upSrcApkAgainListItemGameTime;

        @BindView
        CustomTextView upSrcApkAgainListItemGameVersionAndSize;

        @BindView
        RoundedImageView upSrcApkAgainListItemIcon;

        @BindView
        CustomTextView upSrcApkAgainListItemJurisdiction;

        @BindView
        ProgressBar upSrcApkAgainListItemProgressBar;

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
            viewHolder.upSrcApkAgainListItemIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.up_src_apk_again_list_item_icon, "field 'upSrcApkAgainListItemIcon'", RoundedImageView.class);
            viewHolder.upSrcApkAgainListItemGameName = (TextView) butterknife.c.a.c(view, R.id.up_src_apk_again_list_item_gameName, "field 'upSrcApkAgainListItemGameName'", TextView.class);
            viewHolder.upSrcApkAgainListItemGameVersionAndSize = (CustomTextView) butterknife.c.a.c(view, R.id.up_src_apk_again_list_item_gameVersionAndSize, "field 'upSrcApkAgainListItemGameVersionAndSize'", CustomTextView.class);
            viewHolder.upSrcApkAgainListItemGameTime = (CustomTextView) butterknife.c.a.c(view, R.id.up_src_apk_again_list_item_gameTime, "field 'upSrcApkAgainListItemGameTime'", CustomTextView.class);
            viewHolder.upSrcApkAgainListItemJurisdiction = (CustomTextView) butterknife.c.a.c(view, R.id.up_src_apk_again_list_item_jurisdiction, "field 'upSrcApkAgainListItemJurisdiction'", CustomTextView.class);
            viewHolder.upSrcApkAgainListItemCheckState = (TextView) butterknife.c.a.c(view, R.id.up_src_apk_again_list_item_checkState, "field 'upSrcApkAgainListItemCheckState'", TextView.class);
            viewHolder.upSrcApkAgainListItemCheckStateReason = (CustomTextView) butterknife.c.a.c(view, R.id.up_src_apk_again_list_item_checkState_reason, "field 'upSrcApkAgainListItemCheckStateReason'", CustomTextView.class);
            viewHolder.upSrcApkAgainListItemProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.up_src_apk_again_list_item_ProgressBar, "field 'upSrcApkAgainListItemProgressBar'", ProgressBar.class);
            viewHolder.upSrcApkAgainListItemDownLoad = (TextView) butterknife.c.a.c(view, R.id.up_src_apk_again_list_item_downLoad, "field 'upSrcApkAgainListItemDownLoad'", TextView.class);
            viewHolder.upSrcApkAgainListItemDownLoadLv = (RelativeLayout) butterknife.c.a.c(view, R.id.up_src_apk_again_list_item_downLoad_lv, "field 'upSrcApkAgainListItemDownLoadLv'", RelativeLayout.class);
            viewHolder.upSrcApkAgainListItemAuditCheckUserIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.up_src_apk_again_list_item_audit_check_user_icon, "field 'upSrcApkAgainListItemAuditCheckUserIcon'", RoundedImageView.class);
            viewHolder.upSrcApkAgainListItemAuditCheckUserNickName = (TextView) butterknife.c.a.c(view, R.id.up_src_apk_again_list_item_audit_check_user_nick_name, "field 'upSrcApkAgainListItemAuditCheckUserNickName'", TextView.class);
            viewHolder.upSrcApkAgainListItemAuditCheckUserReason = (TextView) butterknife.c.a.c(view, R.id.up_src_apk_again_list_item_audit_check_user_reason, "field 'upSrcApkAgainListItemAuditCheckUserReason'", TextView.class);
            viewHolder.upSrcApkAgainListItemAuditCheckUserLv = (LinearLayout) butterknife.c.a.c(view, R.id.up_src_apk_again_list_item_audit_check_user_lv, "field 'upSrcApkAgainListItemAuditCheckUserLv'", LinearLayout.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.upSrcApkAgainListItemIcon = null;
                viewHolder.upSrcApkAgainListItemGameName = null;
                viewHolder.upSrcApkAgainListItemGameVersionAndSize = null;
                viewHolder.upSrcApkAgainListItemGameTime = null;
                viewHolder.upSrcApkAgainListItemJurisdiction = null;
                viewHolder.upSrcApkAgainListItemCheckState = null;
                viewHolder.upSrcApkAgainListItemCheckStateReason = null;
                viewHolder.upSrcApkAgainListItemProgressBar = null;
                viewHolder.upSrcApkAgainListItemDownLoad = null;
                viewHolder.upSrcApkAgainListItemDownLoadLv = null;
                viewHolder.upSrcApkAgainListItemAuditCheckUserIcon = null;
                viewHolder.upSrcApkAgainListItemAuditCheckUserNickName = null;
                viewHolder.upSrcApkAgainListItemAuditCheckUserReason = null;
                viewHolder.upSrcApkAgainListItemAuditCheckUserLv = null;
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
            int i = this.a;
            if (i == 0) {
                com.rtk.app.tool.DownLoadTool.r.g(UpAuditAgainSrcListAdapter.this.d, new ApkInfo((UpAuditAgainListBean.DataDTO) UpAuditAgainSrcListAdapter.this.e.get(this.b)), (TextView) view);
                return;
            }
            if (i != 1) {
                if (i == 3 && ((UpAuditAgainListBean.DataDTO) UpAuditAgainSrcListAdapter.this.e.get(this.b)).getCheck_user2() != null) {
                    com.rtk.app.tool.t.B0(UpAuditAgainSrcListAdapter.this.d, ((UpAuditAgainListBean.DataDTO) UpAuditAgainSrcListAdapter.this.e.get(this.b)).getCheck_user2().getCheck_uid() + "");
                    return;
                }
                return;
            }
            com.rtk.app.tool.c.b((Activity) UpAuditAgainSrcListAdapter.this.d, UpSrcListHelpActivity.class, null);
        }
    }

    public UpAuditAgainSrcListAdapter(Context context, List<UpAuditAgainListBean.DataDTO> list) {
        super(list);
        this.d = context;
        this.e = list;
        this.f116c = new DialogForProgressTip(context, "请稍后");
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        int i2 = i % 10;
        int i3 = i / 10;
        if (i2 == 1) {
            com.rtk.app.tool.c0.u("UpAuditAgainSrcListAdapter", "删除资源成功" + str);
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
            this.f116c.dismiss();
        } else {
            com.rtk.app.tool.t.b1((BaseActivity) this.d, upApkDetailsBean.getData(), 1015);
            this.f116c.dismiss();
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
            this.f116c.dismiss();
        } else {
            com.rtk.app.tool.c0.u("UpAuditAgainSrcListAdapter", "删除资源失败" + str);
            com.rtk.app.tool.f.a(this.d, str, f.a.f);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        String str;
        CharSequence charSequence;
        if (view == null) {
            view = LayoutInflater.from(this.d).inflate(R.layout.up_src_apk_again_list_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.upSrcApkAgainListItemGameTime.setText(this.e.get(i).getAddtime());
        if (this.e.get(i).getIsshow2().equals("0")) {
            viewHolder.upSrcApkAgainListItemJurisdiction.setLeftText("不展示");
            AppCompatTextView appCompatTextView = viewHolder.upSrcApkAgainListItemJurisdiction;
            if (com.rtk.app.tool.c0.q(this.e.get(i).getShowmsg2())) {
                charSequence = "";
            } else {
                charSequence = "(" + this.e.get(i).getShowmsg2() + ")";
            }
            appCompatTextView.setText(charSequence);
        } else {
            viewHolder.upSrcApkAgainListItemJurisdiction.setLeftText("展示");
            viewHolder.upSrcApkAgainListItemJurisdiction.setText("");
        }
        viewHolder.upSrcApkAgainListItemGameName.setText(this.e.get(i).getVarName());
        if (!com.rtk.app.tool.c0.q(this.e.get(i).getMsg2()) && this.e.get(i).getStatus2() != 3) {
            viewHolder.upSrcApkAgainListItemCheckStateReason.setLeftText("原因：");
            viewHolder.upSrcApkAgainListItemCheckStateReason.setText(this.e.get(i).getMsg2());
        }
        com.rtk.app.tool.t.X1(this.d, viewHolder.upSrcApkAgainListItemCheckState, this.e.get(i).getStatus2() + "");
        if (com.rtk.app.tool.c0.q(this.e.get(i).getDataPath())) {
            str = this.e.get(i).getSourceSize();
        } else {
            str = this.e.get(i).getDataSize() + "(数据包)";
        }
        viewHolder.upSrcApkAgainListItemGameVersionAndSize.setText(this.e.get(i).getVersionName() + "  |  " + str);
        com.rtk.app.tool.t.c(this.d, this.e.get(i).getSourceLogo(), viewHolder.upSrcApkAgainListItemIcon, new boolean[0]);
        ApkInfo apkInfo = new ApkInfo(this.e.get(i));
        viewHolder.upSrcApkAgainListItemDownLoad.setTag(Integer.valueOf(apkInfo.getGameId()));
        viewHolder.upSrcApkAgainListItemDownLoad.setOnClickListener(new a(0, i));
        com.rtk.app.tool.DownLoadTool.u uVar = new com.rtk.app.tool.DownLoadTool.u(viewHolder.upSrcApkAgainListItemProgressBar, apkInfo.getGameId(), viewHolder.upSrcApkAgainListItemDownLoad);
        this.b.add(uVar);
        com.rtk.app.tool.DownLoadTool.x.c().a(uVar);
        com.rtk.app.tool.DownLoadTool.r.h(this.d, apkInfo, viewHolder.upSrcApkAgainListItemDownLoad, viewHolder.upSrcApkAgainListItemProgressBar);
        if (this.e.get(i).getCheck_user2() != null && !com.rtk.app.tool.c0.q(this.e.get(i).getCheck_user2().getCheck_nickname())) {
            viewHolder.upSrcApkAgainListItemAuditCheckUserLv.setVisibility(0);
            com.rtk.app.tool.t.c(this.d, this.e.get(i).getCheck_user2().getCheck_face(), viewHolder.upSrcApkAgainListItemAuditCheckUserIcon, new boolean[0]);
            viewHolder.upSrcApkAgainListItemAuditCheckUserNickName.setText(this.e.get(i).getCheck_user2().getCheck_nickname());
            viewHolder.upSrcApkAgainListItemAuditCheckUserReason.setText(this.e.get(i).getCheck_user2().getCheck_msg());
            viewHolder.upSrcApkAgainListItemAuditCheckUserLv.setOnClickListener(new a(3, i));
        } else {
            viewHolder.upSrcApkAgainListItemAuditCheckUserLv.setVisibility(8);
        }
        return view;
    }
}
