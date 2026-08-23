package com.rtk.app.main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.base.MainBaseActivity;
import com.rtk.app.main.Home5Activity.AboutUsAndHelpActivity;
import com.rtk.app.main.Home5Activity.FeedBackdActivity;
import com.rtk.app.main.Home5Activity.InstallApkActivity;
import com.rtk.app.main.Home5Activity.SetThemeActivity;
import com.rtk.app.main.Home5Activity.UnInstallActivity;
import com.rtk.app.tool.o.h;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CoverActivity extends MainBaseActivity implements h.j {

    @BindView
    TextView coverAppAboutUs;

    @BindView
    TextView coverAppApkPackage;

    @BindView
    TextView coverAppFeadBack;

    @BindView
    TextView coverAppQqChat;

    @BindView
    TextView coverAppSetTheme;

    @BindView
    TextView coverAppUninstall;

    @BindView
    LinearLayout coverLayout;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements DialogInterface.OnClickListener {
        final /* synthetic */ EditText a;

        a(EditText editText) {
            this.a = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            com.rtk.app.tool.t.k(CoverActivity.this.a, this.a.getText().toString().trim(), new String[0]);
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        u(1);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cover_app_aboutUs /* 2131297076 */:
                com.rtk.app.tool.c.b(this.a, AboutUsAndHelpActivity.class, null);
                return;
            case R.id.cover_app_apkPackage /* 2131297077 */:
                com.rtk.app.tool.c.b(this.a, InstallApkActivity.class, null);
                return;
            case R.id.cover_app_feadBack /* 2131297078 */:
                com.rtk.app.tool.c.b(this.a, FeedBackdActivity.class, null);
                return;
            case R.id.cover_app_qqChat /* 2131297079 */:
                t();
                return;
            case R.id.cover_app_setTheme /* 2131297080 */:
                com.rtk.app.tool.c.b(this.a, SetThemeActivity.class, null);
                return;
            case R.id.cover_app_uninstall /* 2131297081 */:
                com.rtk.app.tool.c.b(this.a, UnInstallActivity.class, null);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.MainBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_cover);
        ButterKnife.a(this);
    }

    @Override // com.rtk.app.base.MainBaseActivity
    protected void s() {
        com.rtk.app.tool.t.S1(this.a, this.coverLayout, null, null, ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void t() {
        EditText editText = new EditText(this);
        new AlertDialog.Builder(this).setTitle("请输入需要会话的qq号").setIcon(R.mipmap.icon_logo).setView(editText).setPositiveButton("确定", new a(editText)).setNegativeButton("取消", (DialogInterface.OnClickListener) null).show();
    }

    public void u(int... iArr) {
        int i = iArr[0];
    }
}
