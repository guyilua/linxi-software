package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.bean.MainUseProtocolUpdateNoticeBean;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.DownLoadTool.DownLoadDialog;
import com.sigmob.sdk.downloader.f;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogUpdata extends o implements View.OnClickListener {

    @BindView
    ImageView dialogUpdataCancel;

    @BindView
    TextView dialogUpdataContent;

    @BindView
    TextView dialogUpdataEnsure;

    @BindView
    RelativeLayout dialogUpdataTopLayout;

    @BindView
    ProgressBar dialog_updayaProgressBar;
    private Context k;
    private MainUseProtocolUpdateNoticeBean.DataBean.CheckupdatesBean l;
    private ApkInfo m;
    private com.rtk.app.tool.DownLoadTool.p n;
    private int o;

    public DialogUpdata(@NonNull Context context, MainUseProtocolUpdateNoticeBean.DataBean.CheckupdatesBean checkupdatesBean) {
        super(context);
        this.k = context;
        this.l = checkupdatesBean;
        i(R.layout.dialog_updata, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        com.rtk.app.tool.t.J1(context, this.dialogUpdataTopLayout);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        q();
        r();
    }

    private void r() {
        int versioncode = this.l.getVersioncode() + 10000000;
        this.o = versioncode;
        com.rtk.app.tool.DownLoadTool.p pVar = new com.rtk.app.tool.DownLoadTool.p(versioncode, this.k.getPackageName(), "软天空" + this.l.getVersioncode(), this.l.getDownload_url(), com.rtk.app.tool.DownLoadTool.q.b, null, 1, this.l.getVersioncode());
        this.n = pVar;
        this.m = new ApkInfo(pVar);
        this.dialogUpdataEnsure.setTag(Integer.valueOf(this.o));
        com.rtk.app.tool.DownLoadTool.x.c().a(new com.rtk.app.tool.DownLoadTool.w(this.dialog_updayaProgressBar, this.o, this.dialogUpdataEnsure));
        this.dialogUpdataContent.setText(this.l.getUpdate_content());
        s();
    }

    @Override // com.rtk.app.main.dialogPack.o, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.rtk.app.tool.g.c.e(this.k).a(this.o);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131297379) {
            dismiss();
            return;
        }
        if (id != 2131297381) {
            return;
        }
        if ("1".equals(this.l.getUpdatesWay())) {
            com.rtk.app.tool.c0.u("DialogUpdata", "user browser down rtk.");
            this.k.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.l.getUpdatesUrl())));
            return;
        }
        t(this.k, this.m, this.dialogUpdataEnsure);
    }

    public void p() {
        if (this.l.getVersioncode() > com.rtk.app.tool.t.Y(this.k)) {
            super.show();
        } else {
            com.rtk.app.tool.f.a(this.k, "您当前已为最新版本！", f.a.f);
        }
    }

    public void q() {
        this.dialogUpdataEnsure.setOnClickListener(this);
        this.dialogUpdataCancel.setOnClickListener(this);
    }

    public void s() {
        if (com.rtk.app.tool.t.B(this.k, com.rtk.app.tool.y.C(this.k) + "/apk/" + this.o + ".apk") != null) {
            this.dialogUpdataEnsure.setText("安装");
        } else if ("1".equals(this.l.getUpdatesWay())) {
            this.dialogUpdataEnsure.setText("浏览器下载");
        } else {
            this.dialogUpdataEnsure.setText("下载");
        }
    }

    @Override // com.rtk.app.main.dialogPack.o, android.app.Dialog
    public void show() {
        if (!this.l.getIs_update().equals("1") || this.l.getVersioncode() <= com.rtk.app.tool.t.Y(this.k)) {
            return;
        }
        super.show();
        if (this.l.getForce_update().equals("1")) {
            this.dialogUpdataCancel.setVisibility(8);
        }
    }

    public void t(Context context, ApkInfo apkInfo, TextView textView) {
        String e;
        String trim = textView.getText().toString().trim();
        char c2 = 65535;
        try {
            switch (trim.hashCode()) {
                case 656082:
                    if (trim.equals("下载")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 761436:
                    if (trim.equals("安装")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 804621:
                    if (trim.equals("打开")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 843068:
                    if (trim.equals("更新")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1039590:
                    if (trim.equals("继续")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 20844108:
                    if (trim.equals("准备中")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1137621909:
                    if (trim.equals("重新下载")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                case 1:
                    com.rtk.app.tool.DownLoadTool.r.c(context, this.n);
                    return;
                case 2:
                    com.rtk.app.tool.c0.u("DialogUpdata", "DownloadInfo   游戏包名   ---------》   " + apkInfo.getPackageName());
                    com.rtk.app.tool.DownLoadTool.p d = com.rtk.app.tool.DownLoadTool.q.d(apkInfo.getGameId());
                    if (d != null) {
                        com.rtk.app.tool.DownLoadTool.r.c(context, d);
                        return;
                    }
                    return;
                case 3:
                    com.rtk.app.tool.f.a(context, "准备中！请稍后...", f.a.f);
                    return;
                case 4:
                    com.rtk.app.tool.DownLoadTool.p d2 = com.rtk.app.tool.DownLoadTool.q.d(apkInfo.getGameId());
                    if (d2 == null) {
                        e = com.rtk.app.tool.y.C(context) + "/apk/" + this.o + ".apk";
                    } else {
                        e = d2.e();
                    }
                    com.rtk.app.tool.c0.u("DialogUpdata", "地址" + e);
                    com.rtk.app.tool.t.n1(context, e);
                    return;
                case 5:
                    com.rtk.app.tool.t.A1(context, apkInfo.getPackageName());
                    return;
                case 6:
                    new DownLoadDialog(context, apkInfo);
                    return;
                default:
                    com.rtk.app.tool.DownLoadTool.x.c().k(apkInfo.getGameId());
                    com.rtk.app.tool.g.c.e(context).i(com.rtk.app.tool.DownLoadTool.q.d, apkInfo.getGameId());
                    com.rtk.app.tool.DownLoadTool.t.h(apkInfo.getGameId(), com.rtk.app.tool.DownLoadTool.q.d, new boolean[0]);
                    return;
            }
        } catch (Exception unused) {
            com.rtk.app.tool.g.c.e(context).a(this.o);
        }
    }
}
