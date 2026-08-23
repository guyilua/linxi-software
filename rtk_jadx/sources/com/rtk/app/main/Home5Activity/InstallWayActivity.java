package com.rtk.app.main.Home5Activity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.bean.InstallWayBean;
import com.rtk.app.bean.InstallationBean;
import com.rtk.app.main.dialogPack.DialogFileCopy;
import com.rtk.app.main.family.FamilyBaseActivity;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class InstallWayActivity extends FamilyBaseActivity {

    @BindView
    LinearLayout parent;
    InstallationBean r;
    private String s;

    @BindView
    TextView tips;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a extends Thread {
        final /* synthetic */ String a;
        final /* synthetic */ InstallWayBean b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ DialogFileCopy f183c;

        a(String str, InstallWayBean installWayBean, DialogFileCopy dialogFileCopy) {
            this.a = str;
            this.b = installWayBean;
            this.f183c = dialogFileCopy;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.content.Context, com.rtk.app.main.Home5Activity.InstallWayActivity] */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ?? r0 = InstallWayActivity.this;
            if (com.rtk.app.b.a.h(r0, ((InstallWayActivity) r0).s, this.a) != null) {
                com.rtk.app.tool.t.z1(InstallWayActivity.this, this.b.getPackageName());
            }
            this.f183c.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b extends ClickableSpan {
        final /* synthetic */ TextView a;
        final /* synthetic */ InstallWayBean b;

        b(TextView textView, InstallWayBean installWayBean) {
            this.a = textView;
            this.b = installWayBean;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            InstallWayActivity.this.Q(this.a);
            com.rtk.app.tool.t.q0(InstallWayActivity.this, this.b.getPrompt_id() + "", InstallWayActivity.this.S(this.b.getWay()));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(InstallWayActivity.this.getResources().getColor(R.color.theme1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(View view) {
        if (view instanceof TextView) {
            ((TextView) view).setHighlightColor(getResources().getColor(android.R.color.transparent));
        }
    }

    private SpannableStringBuilder R(TextView textView, InstallWayBean installWayBean) {
        String str = installWayBean.getPrompt_message() + "查看详情";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int lastIndexOf = str.lastIndexOf("查看详情");
        spannableStringBuilder.setSpan(new b(textView, installWayBean), lastIndexOf, lastIndexOf + 4, 33);
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String S(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "直接安装" : "使用浏览器安装" : "断网安装" : "使用文件管理安装" : "直接安装";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U(int i, InstallWayBean installWayBean, View view) {
        int lastIndexOf;
        if (i == 1) {
            com.rtk.app.tool.t.n1(this, this.s);
            return;
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
            if (com.rtk.app.tool.t.t1(this)) {
                com.rtk.app.tool.f.a(this, "请先断开所有网络", f.a.f);
                return;
            } else {
                com.rtk.app.tool.t.n1(this, this.s);
                return;
            }
        }
        if (com.rtk.app.tool.r.b(this) && (lastIndexOf = this.s.lastIndexOf("/")) != -1) {
            String str = this.s;
            String substring = str.substring(lastIndexOf + 1, str.length());
            DialogFileCopy dialogFileCopy = new DialogFileCopy(this, "操作中，请耐心等待一会……");
            dialogFileCopy.show();
            new a(substring, installWayBean, dialogFileCopy).start();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void V() {
        this.tips.setText(this.r.getTips());
        List<InstallWayBean> installWay = this.r.getInstallWay();
        int a2 = com.rtk.app.tool.h.a(8.0f, this);
        int a3 = com.rtk.app.tool.h.a(12.0f, this);
        ArrayList arrayList = new ArrayList();
        for (InstallWayBean installWayBean : installWay) {
            if (installWayBean.getWay() <= 3) {
                arrayList.add(installWayBean);
            }
        }
        int i = 0;
        while (i < arrayList.size()) {
            final InstallWayBean installWayBean2 = (InstallWayBean) arrayList.get(i);
            View inflate = LayoutInflater.from(this).inflate(R.layout.item_install_way, (ViewGroup) null);
            inflate.setPadding(a2, a2, a2, a2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.leftMargin = a3;
            layoutParams.rightMargin = a3;
            layoutParams.bottomMargin = a3;
            inflate.setLayoutParams(layoutParams);
            TextView textView = (TextView) inflate.findViewById(2131300422);
            TextView textView2 = (TextView) inflate.findViewById(R.id.go);
            TextView textView3 = (TextView) inflate.findViewById(R.id.msg);
            final int way = installWayBean2.getWay();
            StringBuilder sb = new StringBuilder();
            i++;
            sb.append(i);
            sb.append(".");
            sb.append(S(way));
            textView.setText(sb.toString());
            textView3.setText(R(textView3, installWayBean2));
            textView3.setMovementMethod(LinkMovementMethod.getInstance());
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.main.Home5Activity.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InstallWayActivity.this.U(way, installWayBean2, view);
                }
            });
            this.parent.addView(inflate);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_install_way_layout);
        ButterKnife.a(this);
        InstallationBean installationBean = (InstallationBean) getIntent().getSerializableExtra("install_way");
        this.r = installationBean;
        if (installationBean == null) {
            finish();
        } else {
            this.s = getIntent().getStringExtra("app_save_path");
            V();
        }
    }
}
