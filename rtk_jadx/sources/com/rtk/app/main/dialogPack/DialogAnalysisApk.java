package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogAnalysisApk extends o {

    @BindView
    TextView dialogAnalysisApkTip;
    private long k;

    public DialogAnalysisApk(@NonNull Context context) {
        super(context);
        this.k = 0L;
        i(R.layout.dialog_analysis_apk_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        setCancelable(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void p(long j) {
        com.rtk.app.tool.c0.u("DialogAnalysisApk", "文件长度" + j);
        this.k = j / BaseConstants.MB_VALUE;
    }

    @Override // com.rtk.app.main.dialogPack.o, android.app.Dialog
    public void show() {
        long j = this.k;
        String str = j > ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLSX ? "解析文件中，请勿退出，请耐心等待15-120秒" : j > ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS ? "解析文件中，请勿退出，请耐心等待10-90秒" : j > 512 ? "解析文件中，请勿退出，请耐心等待5-30秒" : "解析文件中";
        com.rtk.app.tool.c0.u("DialogAnalysisApk", "当前显示文字" + str + "  当前尺寸" + this.k);
        this.dialogAnalysisApkTip.setText(str);
        super.show();
    }
}
