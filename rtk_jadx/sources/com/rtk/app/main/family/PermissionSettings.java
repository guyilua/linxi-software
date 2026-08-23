package com.rtk.app.main.family;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.main.MainActivityPack.MainActivity;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PermissionSettings extends FamilyBaseActivity {

    @BindView
    TextView fileAccess;

    @BindView
    TextView installApp;
    boolean r;
    boolean s;
    private boolean t = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent((Context) PermissionSettings.this, (Class<?>) MainActivity.class);
            intent.addFlags(67108864);
            PermissionSettings.this.startActivity(intent);
            Process.killProcess(Process.myPid());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void N() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("重启App");
        builder.setMessage("授权成功，需要重启APP才可正常使用。");
        builder.setPositiveButton("确定", new a());
        builder.setCancelable(false);
        builder.create().show();
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initView() {
        super.initView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.file_access_layout /* 2131297575 */:
            case R.id.go_storage_permission /* 2131297803 */:
                if (this.r) {
                    return;
                }
                com.rtk.app.tool.r.f(this);
                return;
            case R.id.go_install_permission /* 2131297801 */:
            case R.id.install_app_layout /* 2131298239 */:
                if (this.s) {
                    return;
                }
                this.t = true;
                com.rtk.app.tool.r.g(this);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_permission_settings_layout);
        ButterKnife.a(this);
        this.r = com.rtk.app.tool.r.e(this);
        this.s = com.rtk.app.tool.r.d(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        boolean e = com.rtk.app.tool.r.e(this);
        this.r = e;
        if (e) {
            this.fileAccess.setEnabled(false);
            this.fileAccess.setBackgroundResource(R.drawable.shape_corner_theme35_5dp);
            this.fileAccess.setTextColor(-16777216);
            this.fileAccess.setText("已完成");
        } else {
            this.fileAccess.setEnabled(true);
            this.fileAccess.setBackgroundResource(R.drawable.shape_corner_white_solid_white_5dp);
            this.fileAccess.setText("去授权");
            this.fileAccess.setTextColor(getResources().getColor(R.color.theme1));
        }
        boolean d = com.rtk.app.tool.r.d(this);
        this.s = d;
        if (d) {
            this.installApp.setBackgroundResource(R.drawable.shape_corner_theme35_5dp);
            this.installApp.setTextColor(-16777216);
            this.installApp.setText("已完成");
            this.installApp.setEnabled(false);
            if (this.t) {
                N();
                this.t = false;
                return;
            } else {
                if (this.r) {
                    finish();
                    return;
                }
                return;
            }
        }
        this.installApp.setEnabled(true);
        this.installApp.setBackgroundResource(R.drawable.shape_corner_white_solid_white_5dp);
        this.installApp.setText("去授权");
        this.installApp.setTextColor(getResources().getColor(R.color.theme1));
    }
}
