package com.rtk.app.main.Home5Activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.base.BaseActivity;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class RTKLogActivity extends BaseActivity {

    @BindView
    Button clearLog;

    @BindView
    Button enableLog;

    @BindView
    TextView text;

    @BindView
    TextView textZip;

    @BindView
    TextView tvOs;

    @BindView
    Button zipThreeDaysLog;

    @BindView
    Button zipTodayLog;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_clear_log /* 2131296825 */:
                com.rtk.app.b.d.b();
                Toast.makeText((Context) this, (CharSequence) "日志清理完成", 0).show();
                com.rtk.app.b.b.c("RTKLogActivity", "清除日志");
                return;
            case R.id.btn_enable_log /* 2131296827 */:
                boolean z = !com.rtk.app.b.b.a;
                com.rtk.app.b.b.a = z;
                this.enableLog.setText(z ? "关闭保存日志" : "开启保存日志");
                com.rtk.app.tool.v.e(this, "log4jSaveLogSwitch", Boolean.valueOf(com.rtk.app.b.b.a));
                return;
            case R.id.btn_zip_logs_in_the_past_three_days /* 2131296835 */:
                String d = com.rtk.app.b.d.d(2);
                Log.d("RTKLogActivity", "三天前的日期：" + d);
                String d2 = com.rtk.app.b.d.d(0);
                Log.d("RTKLogActivity", "今天的日期：" + d2);
                String b = com.rtk.app.b.c.b(d, d2);
                if (!"".equals(b)) {
                    Toast.makeText((Context) this, (CharSequence) b, 0).show();
                    return;
                } else {
                    Toast.makeText((Context) this, (CharSequence) "压缩日志文件成功", 0).show();
                    return;
                }
            case R.id.btn_zip_today_log /* 2131296836 */:
                String d3 = com.rtk.app.b.d.d(0);
                Log.d("RTKLogActivity", "今天的日期：" + d3);
                String a = com.rtk.app.b.c.a(d3);
                if (!"".equals(a)) {
                    Toast.makeText((Context) this, (CharSequence) a, 0).show();
                    return;
                } else {
                    Toast.makeText((Context) this, (CharSequence) "压缩日志文件成功", 0).show();
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_rtk_log);
        ButterKnife.a(this);
        this.enableLog.setText(com.rtk.app.b.b.a ? "关闭保存日志" : "开启保存日志");
        this.text.setText("日志文件保存路径：" + com.rtk.app.b.d.e());
        this.textZip.setText("压缩日志文件保存路径：" + com.rtk.app.b.d.g());
        this.tvOs.setText("系统信息：" + com.rtk.app.tool.y.y());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
    }
}
