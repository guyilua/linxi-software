package com.rtk.app.main.dialogPack;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.main.MyApplication;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForInstallPermission extends o {
    public static long l;

    @BindView
    TextView dialogForInstallPermissionCancel;

    @BindView
    TextView dialogForInstallPermissionEnsure;
    private Context k;

    public DialogForInstallPermission(Context context) {
        super(context);
        this.k = context;
        i(R.layout.dialog_for_install_permission_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        q();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_for_install_permission_cancel /* 2131297221 */:
                dismiss();
                return;
            case R.id.dialog_for_install_permission_ensure /* 2131297222 */:
                p();
                dismiss();
                return;
            default:
                return;
        }
    }

    public void p() {
        Intent intent = new Intent();
        intent.setData(Uri.parse("package:" + this.k.getPackageName()));
        if (Build.VERSION.SDK_INT >= 26) {
            intent.setAction("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
        } else {
            intent.setAction("android.settings.SECURITY_SETTINGS");
        }
        ((Activity) MyApplication.b()).startActivityForResult(intent, 117);
    }

    public void q() {
        this.dialogForInstallPermissionEnsure.setOnClickListener(this);
        this.dialogForInstallPermissionCancel.setOnClickListener(this);
    }
}
