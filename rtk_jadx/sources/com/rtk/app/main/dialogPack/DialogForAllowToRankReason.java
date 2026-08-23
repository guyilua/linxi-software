package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import butterknife.BindView;
import com.rtk.app.R;
import com.rtk.app.custom.GridRadioGroup;
import com.sigmob.sdk.downloader.f;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForAllowToRankReason extends o {

    @BindView
    TextView dialogForAllowToRankReasonEnsure;

    @BindView
    RadioButton dialogForAllowToRankReasonProhibitDays1;

    @BindView
    RadioButton dialogForAllowToRankReasonProhibitDays1095;

    @BindView
    RadioButton dialogForAllowToRankReasonProhibitDays15;

    @BindView
    RadioButton dialogForAllowToRankReasonProhibitDays180;

    @BindView
    RadioButton dialogForAllowToRankReasonProhibitDays30;

    @BindView
    RadioButton dialogForAllowToRankReasonProhibitDays365;

    @BindView
    RadioButton dialogForAllowToRankReasonProhibitDays36500;

    @BindView
    RadioButton dialogForAllowToRankReasonProhibitDays7;

    @BindView
    RadioButton dialogForAllowToRankReasonProhibitDays90;

    @BindView
    GridRadioGroup dialogForAllowToRankReasonProhibitDaysGroup;

    @BindView
    EditText dialogForAllowToRankReasonReason;
    private com.rtk.app.tool.s k;
    private int l;
    private Context m;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_for_allow_to_rank_reason_ensure /* 2131297136 */:
                String obj = this.dialogForAllowToRankReasonReason.getText().toString();
                com.rtk.app.tool.c0.u("DialogForAllowToRankReason", "当前时间" + this.l + "   " + obj);
                if (!com.rtk.app.tool.c0.q(obj) && this.l != 0) {
                    com.rtk.app.tool.s sVar = this.k;
                    if (sVar != null) {
                        sVar.a(this.l + "", obj);
                        return;
                    }
                    return;
                }
                com.rtk.app.tool.f.a(this.m, "请输入原因", f.a.f);
                return;
            case R.id.dialog_for_allow_to_rank_reason_prohibit_days1 /* 2131297137 */:
                this.l = 1;
                return;
            case R.id.dialog_for_allow_to_rank_reason_prohibit_days1095 /* 2131297138 */:
                this.l = 1095;
                return;
            case R.id.dialog_for_allow_to_rank_reason_prohibit_days15 /* 2131297139 */:
                this.l = 15;
                return;
            case R.id.dialog_for_allow_to_rank_reason_prohibit_days180 /* 2131297140 */:
                this.l = 180;
                return;
            case R.id.dialog_for_allow_to_rank_reason_prohibit_days30 /* 2131297141 */:
                this.l = 30;
                return;
            case R.id.dialog_for_allow_to_rank_reason_prohibit_days365 /* 2131297142 */:
                this.l = 365;
                return;
            case R.id.dialog_for_allow_to_rank_reason_prohibit_days36500 /* 2131297143 */:
                this.l = 36500;
                return;
            case R.id.dialog_for_allow_to_rank_reason_prohibit_days7 /* 2131297144 */:
                this.l = 7;
                return;
            case R.id.dialog_for_allow_to_rank_reason_prohibit_days90 /* 2131297145 */:
                this.l = 90;
                return;
            default:
                return;
        }
    }

    public void p(com.rtk.app.tool.s sVar) {
        this.k = sVar;
    }
}
