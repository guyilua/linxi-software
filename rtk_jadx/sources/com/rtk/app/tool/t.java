package com.rtk.app.tool;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.GsonBuilder;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.rtk.app.R;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.AchievementBean;
import com.rtk.app.bean.ApkBean;
import com.rtk.app.bean.BoundQQorWechatBean;
import com.rtk.app.bean.EventMedalBean;
import com.rtk.app.bean.InstallWayBean;
import com.rtk.app.bean.LoginBean;
import com.rtk.app.bean.PostDetailsBean;
import com.rtk.app.bean.PostTitleBean;
import com.rtk.app.bean.ResponseBean;
import com.rtk.app.bean.UpApkDetailsBean;
import com.rtk.app.bean.UpSuguestBean;
import com.rtk.app.custom.RichEditText.PostModificationBean;
import com.rtk.app.custom.TestPost.TestPostHtmlPageActivity;
import com.rtk.app.main.AdWebViewActivity;
import com.rtk.app.main.AllNewsListActivity;
import com.rtk.app.main.DownLoadActivity;
import com.rtk.app.main.DownLoadTipsAdWebViewActivity;
import com.rtk.app.main.GameDetailsActivity;
import com.rtk.app.main.GiftDetailsActivity;
import com.rtk.app.main.Home5Activity.AccountSecurityActivity;
import com.rtk.app.main.Home5Activity.InstallWayActivity;
import com.rtk.app.main.Home5Activity.MedalDetailAchievementActivity;
import com.rtk.app.main.Home5Activity.MedalDetailEventActivity;
import com.rtk.app.main.Home5Activity.MyAttentionActivity;
import com.rtk.app.main.Home5Activity.MyFansActivity;
import com.rtk.app.main.Home5Activity.MyPostClickDataActivity;
import com.rtk.app.main.HomeCommunityPack.CommunityListActivity;
import com.rtk.app.main.HomeCommunityPack.CommunitySettingActivity;
import com.rtk.app.main.HomeCommunityPack.ModuleDetailsActivity;
import com.rtk.app.main.HomeCommunityPack.MyPostAttentionActivity;
import com.rtk.app.main.HomeCommunityPack.PostAuditListActivity;
import com.rtk.app.main.HomeCommunityPack.PostCommentAuditListActivity;
import com.rtk.app.main.HomeCommunityPack.PostCommentDetailsActivity;
import com.rtk.app.main.HomeCommunityPack.PostCommentSecondActivity;
import com.rtk.app.main.HomeCommunityPack.PostDetailsActivity;
import com.rtk.app.main.HomeCommunityPack.PublishPostActivity;
import com.rtk.app.main.HomeCommunityPack.ReplyPostFristCommentActivity;
import com.rtk.app.main.HomeCommunityPack.ReportPostActivity;
import com.rtk.app.main.HomeCommunityPack.VideoDetailsActivity;
import com.rtk.app.main.LiBaoListActivity;
import com.rtk.app.main.MainActivityPack.FansBoardActivity;
import com.rtk.app.main.MainActivityPack.GameClassifyActivity;
import com.rtk.app.main.MainActivityPack.HomeManageFragment;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.MainActivityPack.UpChoicenessPack.HomeUpClassifyActivity;
import com.rtk.app.main.MainActivityPack.UpChoicenessPack.HomeUpSrcListActivity;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.NewDetailsActivity;
import com.rtk.app.main.OtherImfomationPack.OtherPersonerImformationActivity;
import com.rtk.app.main.PictureDetailsActivity;
import com.rtk.app.main.QQWebViewActivity;
import com.rtk.app.main.TagListActivity;
import com.rtk.app.main.UpMadeRuleActivity;
import com.rtk.app.main.UpModule.UpApkCommentDetailsActivity;
import com.rtk.app.main.UpModule.UpApkDetailsActivity;
import com.rtk.app.main.UpModule.UpCheckAgainPassOrListShowActivity;
import com.rtk.app.main.UpModule.UpCheckPassOrListShowActivity;
import com.rtk.app.main.UpModule.UpClickSrcDataActivity;
import com.rtk.app.main.UpModule.UpControlPack.UpApk.UpGameActivity;
import com.rtk.app.main.UpModule.UpControlPack.UpZip.UpZipActivity;
import com.rtk.app.main.UpModule.UpControlPack.YcFileManageActivity;
import com.rtk.app.main.UpModule.UpEditApkInformationActivity;
import com.rtk.app.main.UpModule.UpSearchJustHistoryActivity;
import com.rtk.app.main.UpModule.UpSearchToMoreTypeActivity;
import com.rtk.app.main.UpModule.UpSrcApkInformationForAdministratorActivity;
import com.rtk.app.main.UpModule.UpSrcDataActivity;
import com.rtk.app.main.comment.CommentActivity;
import com.rtk.app.main.comment.CommentDetailsForGameActivity;
import com.rtk.app.main.dialogPack.DialogApkVersionSamll;
import com.rtk.app.main.dialogPack.DialogDownLoadTip;
import com.rtk.app.main.dialogPack.DialogFileCopy;
import com.rtk.app.main.dialogPack.DialogForAttention;
import com.rtk.app.main.dialogPack.DialogForFamily;
import com.rtk.app.main.dialogPack.DialogForGameCommand;
import com.rtk.app.main.dialogPack.DialogForInstallPermission;
import com.rtk.app.main.dialogPack.DialogForPost;
import com.rtk.app.main.dialogPack.DialogForToAccountSecurityActivity;
import com.rtk.app.main.dialogPack.DialogForUpCommand;
import com.rtk.app.main.dialogPack.DialogForUser;
import com.rtk.app.main.dialogPack.DialogJustEnsure;
import com.rtk.app.main.family.FamilyCommunityListActivity;
import com.rtk.app.main.family.upAudit.FamilyUpCheckPassActivity;
import com.rtk.app.main.login.BoundPhoneActivity;
import com.rtk.app.main.login.InformationActivity;
import com.rtk.app.main.login.LoginActivity;
import com.rtk.app.main.login.RegisterActivity;
import com.sigmob.sdk.downloader.f;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.uc.crashsdk.export.LogType;
import com.xiao.nicevideoplayer.VideoBean;
import com.zhy.view.flowlayout.FlowLayout;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: PublicClass.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class t {
    private static int a;
    private static int b;

    /* renamed from: c, reason: collision with root package name */
    private static com.bumptech.glide.p.e f330c;
    private static com.bumptech.glide.p.e d;
    private static long e;

    /* compiled from: PublicClass.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class a implements PlatformActionListener {
        final /* synthetic */ Context a;
        final /* synthetic */ ApkInfo b;

        a(Context context, ApkInfo apkInfo) {
            this.a = context;
            this.b = apkInfo;
        }

        public void onCancel(Platform platform, int i) {
            com.rtk.app.tool.f.a(this.a, "分享取消", f.a.f);
        }

        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
            com.rtk.app.tool.f.a(this.a, "分享成功", f.a.f);
            String d = v.d(this.a, "IsShareStr");
            MyApplication.f210c = this.b.getGameId() + "";
            MyApplication.d = "game";
            MyApplication.g();
            if (c0.q(d)) {
                v.h(this.a, "IsShareStr", this.b.getGameId() + ";");
                return;
            }
            v.h(this.a, "IsShareStr", d + this.b.getGameId() + ";");
        }

        public void onError(Platform platform, int i, Throwable th) {
            com.rtk.app.tool.f.a(this.a, "分享失败", f.a.f);
        }
    }

    /* compiled from: PublicClass.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class b implements PlatformActionListener {
        final /* synthetic */ Context a;

        b(Context context) {
            this.a = context;
        }

        public void onCancel(Platform platform, int i) {
        }

        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
            c0.u("", "分享成功");
            com.rtk.app.tool.f.a(this.a, "分享成功", f.a.f);
            MyApplication.f210c = "";
            MyApplication.d = "client";
            MyApplication.g();
        }

        public void onError(Platform platform, int i, Throwable th) {
            com.rtk.app.tool.f.a(this.a, "分享失败", f.a.f);
        }
    }

    /* compiled from: PublicClass.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class c implements com.rtk.app.tool.s {
        c() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            t.g0(MyApplication.b());
        }
    }

    /* compiled from: PublicClass.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class d implements com.rtk.app.tool.s {
        d() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            t.g0(MyApplication.b());
        }
    }

    /* compiled from: PublicClass.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class e implements com.rtk.app.tool.s {
        e() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            t.g0(MyApplication.b());
        }
    }

    /* compiled from: PublicClass.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class f implements View.OnClickListener {
        final /* synthetic */ TextView a;
        final /* synthetic */ com.rtk.app.tool.s b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f331c;
        final /* synthetic */ int d;

        /* compiled from: PublicClass.java */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        class a implements com.rtk.app.tool.s {
            a() {
            }

            @Override // com.rtk.app.tool.s
            public void a(String... strArr) {
                f fVar = f.this;
                fVar.b.a(fVar.f331c, f.this.d + "");
            }
        }

        f(TextView textView, com.rtk.app.tool.s sVar, String str, int i) {
            this.a = textView;
            this.b = sVar;
            this.f331c = str;
            this.d = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String trim = this.a.getText().toString().trim();
            trim.hashCode();
            if (!trim.equals("已关注") && !trim.equals("互相关注")) {
                this.a.setText("关注");
                this.b.a(this.f331c, this.d + "");
                return;
            }
            new DialogForAttention(MyApplication.b(), new a()).show();
        }
    }

    /* compiled from: PublicClass.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class g extends ClickableSpan {
        final /* synthetic */ com.rtk.app.tool.s a;

        g(com.rtk.app.tool.s sVar) {
            this.a = sVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            this.a.a(new String[0]);
        }
    }

    /* compiled from: PublicClass.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class h extends com.bumptech.glide.p.i.f<File> {
        final /* synthetic */ String d;
        final /* synthetic */ Context e;

        h(String str, Context context) {
            this.d = str;
            this.e = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0124 A[Catch: IOException -> 0x0152, LOOP:0: B:24:0x011e->B:26:0x0124, LOOP_END, TryCatch #0 {IOException -> 0x0152, blocks: (B:3:0x000a, B:5:0x002a, B:6:0x002d, B:9:0x0037, B:12:0x0043, B:14:0x004b, B:17:0x0056, B:19:0x005e, B:22:0x0069, B:23:0x00f3, B:24:0x011e, B:26:0x0124, B:28:0x0129, B:32:0x008a, B:33:0x00ae, B:34:0x00d1), top: B:2:0x000a }] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0129 A[SYNTHETIC] */
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void g(@androidx.annotation.NonNull java.io.File r8, @androidx.annotation.Nullable com.bumptech.glide.p.j.d<? super java.io.File> r9) {
            /*
                Method dump skipped, instructions count: 372
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.t.h.g(java.io.File, com.bumptech.glide.p.j.d):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PublicClass.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class i implements com.rtk.app.tool.s {
        i() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            t.g0(MyApplication.b());
        }
    }

    /* compiled from: PublicClass.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class j implements Runnable {
        final /* synthetic */ EditText a;
        final /* synthetic */ Context b;

        j(EditText editText, Context context) {
            this.a = editText;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) this.b.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.a, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PublicClass.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class k implements com.rtk.app.tool.s {
        k() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            t.g0(MyApplication.b());
        }
    }

    /* compiled from: PublicClass.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class l implements PopupMenu.OnMenuItemClickListener {
        final /* synthetic */ Context a;
        final /* synthetic */ PopupMenu b;

        l(Context context, PopupMenu popupMenu) {
            this.a = context;
            this.b = popupMenu;
        }

        @Override // android.widget.PopupMenu.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.publish_up_apk /* 2131299963 */:
                    t.c1(this.a);
                    break;
                case R.id.publish_up_zip /* 2131299964 */:
                    t.e1(this.a);
                    break;
            }
            this.b.dismiss();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PublicClass.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class m extends Thread {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f332c;
        final /* synthetic */ InstallWayBean d;
        final /* synthetic */ DialogFileCopy e;

        m(Context context, String str, String str2, InstallWayBean installWayBean, DialogFileCopy dialogFileCopy) {
            this.a = context;
            this.b = str;
            this.f332c = str2;
            this.d = installWayBean;
            this.e = dialogFileCopy;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            if (com.rtk.app.b.a.h(this.a, this.b, this.f332c) != null) {
                t.z1(this.a, this.d.getPackageName());
            }
            this.e.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PublicClass.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class n extends ClickableSpan {
        final /* synthetic */ Context a;
        final /* synthetic */ InstallWayBean b;

        n(Context context, InstallWayBean installWayBean) {
            this.a = context;
            this.b = installWayBean;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            t.q0(this.a, this.b.getPrompt_id() + "", "安装流程说明");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(this.a.getResources().getColor(R.color.theme1));
        }
    }

    /* compiled from: PublicClass.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class o implements com.rtk.app.tool.s {
        o() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            t.g0(MyApplication.b());
        }
    }

    /* compiled from: PublicClass.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class p implements PlatformActionListener {
        final /* synthetic */ Context a;
        final /* synthetic */ ApkInfo b;

        p(Context context, ApkInfo apkInfo) {
            this.a = context;
            this.b = apkInfo;
        }

        public void onCancel(Platform platform, int i) {
            com.rtk.app.tool.f.a(this.a, "分享取消", f.a.f);
        }

        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
            com.rtk.app.tool.f.a(this.a, "分享成功", f.a.f);
            MyApplication.f210c = this.b.getGameId() + "";
            MyApplication.d = "game";
            MyApplication.g();
        }

        public void onError(Platform platform, int i, Throwable th) {
            com.rtk.app.tool.f.a(this.a, "分享失败", f.a.f);
        }
    }

    /* compiled from: PublicClass.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class q implements PlatformActionListener {
        final /* synthetic */ Context a;
        final /* synthetic */ com.rtk.app.tool.s b;

        q(Context context, com.rtk.app.tool.s sVar) {
            this.a = context;
            this.b = sVar;
        }

        public void onCancel(Platform platform, int i) {
            com.rtk.app.tool.f.a(this.a, "分享取消", f.a.f);
        }

        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
            com.rtk.app.tool.f.a(this.a, "分享成功", f.a.f);
            this.b.a(new String[0]);
        }

        public void onError(Platform platform, int i, Throwable th) {
            com.rtk.app.tool.f.a(this.a, "分享失败", f.a.f);
        }
    }

    /* compiled from: PublicClass.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class r implements PlatformActionListener {
        final /* synthetic */ Context a;
        final /* synthetic */ com.rtk.app.tool.s b;

        r(Context context, com.rtk.app.tool.s sVar) {
            this.a = context;
            this.b = sVar;
        }

        public void onCancel(Platform platform, int i) {
            com.rtk.app.tool.f.a(this.a, "分享取消", f.a.f);
        }

        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
            com.rtk.app.tool.f.a(this.a, "分享成功", f.a.f);
            this.b.a(new String[0]);
        }

        public void onError(Platform platform, int i, Throwable th) {
            com.rtk.app.tool.f.a(this.a, "分享失败", f.a.f);
        }
    }

    /* compiled from: PublicClass.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class s implements PlatformActionListener {
        final /* synthetic */ Context a;
        final /* synthetic */ ApkInfo b;

        s(Context context, ApkInfo apkInfo) {
            this.a = context;
            this.b = apkInfo;
        }

        public void onCancel(Platform platform, int i) {
            com.rtk.app.tool.f.a(this.a, "分享取消", f.a.f);
        }

        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
            com.rtk.app.tool.f.a(this.a, "分享成功", f.a.f);
            MyApplication.f210c = this.b.getGameId() + "";
            MyApplication.d = "up";
            MyApplication.g();
        }

        public void onError(Platform platform, int i, Throwable th) {
            com.rtk.app.tool.f.a(this.a, "分享失败", f.a.f);
        }
    }

    /* compiled from: PublicClass.java */
    /* renamed from: com.rtk.app.tool.t$t, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class C0029t implements PlatformActionListener {
        final /* synthetic */ Context a;

        C0029t(Context context) {
            this.a = context;
        }

        public void onCancel(Platform platform, int i) {
            com.rtk.app.tool.f.a(this.a, "分享取消", f.a.f);
        }

        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
            com.rtk.app.tool.f.a(this.a, "分享成功", f.a.f);
            MyApplication.d = "up";
            MyApplication.g();
        }

        public void onError(Platform platform, int i, Throwable th) {
            com.rtk.app.tool.f.a(this.a, "分享失败", f.a.f);
        }
    }

    static {
        new ArrayList();
        b = 0;
        e = 0L;
    }

    public static List<PackageInfo> A(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        for (PackageInfo packageInfo : packageManager.getInstalledPackages(0)) {
            if ((packageInfo.applicationInfo.flags & 1) == 1) {
                arrayList.add(packageInfo);
            }
        }
        return arrayList;
    }

    public static void A0(Context context, int i2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", i2);
        bundle.putInt(com.umeng.analytics.pro.d.y, i3);
        com.rtk.app.tool.c.b((Activity) context, AllNewsListActivity.class, bundle);
    }

    public static void A1(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            c0.r("", "此应用无法打开, packageName:" + str);
            com.rtk.app.tool.f.a(context, "此应用无法打开.", f.a.f);
            return;
        }
        MyApplication.b().startActivity(launchIntentForPackage);
    }

    public static ApkBean B(Context context, String str) {
        PackageInfo packageArchiveInfo;
        PackageManager packageManager = MyApplication.b().getPackageManager();
        File file = new File(str);
        if (!file.getName().endsWith(".apk") || (packageArchiveInfo = packageManager.getPackageArchiveInfo(file.getAbsolutePath(), 1)) == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
        ApkBean apkBean = new ApkBean();
        apkBean.setName(file.getName());
        apkBean.setPath(file.getAbsolutePath());
        apkBean.setPackageName(applicationInfo.packageName);
        apkBean.setInstall(q1(context, applicationInfo.packageName));
        apkBean.setSize(c0.k(file.length()));
        apkBean.setVersion(packageArchiveInfo.versionName);
        apkBean.setVersionCode(packageArchiveInfo.versionCode);
        return apkBean;
    }

    public static void B0(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fans", str);
        if (str.equals(y.K())) {
            com.rtk.app.tool.c.b((Activity) context, InformationActivity.class, bundle);
        } else {
            com.rtk.app.tool.c.b((Activity) context, OtherPersonerImformationActivity.class, bundle);
        }
    }

    public static void B1(EditText editText, Context context) {
        editText.post(new j(editText, context));
    }

    public static Drawable C(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 1);
        if (packageArchiveInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        try {
            return applicationInfo.loadIcon(packageManager);
        } catch (OutOfMemoryError e2) {
            Log.e("ApkIconLoader", e2.toString());
            return null;
        }
    }

    public static void C0(Context context, List<String> list, int i2) {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("list", (ArrayList) list);
        bundle.putString("nowPicture", list.get(i2));
        com.rtk.app.tool.c.b((Activity) context, PictureDetailsActivity.class, bundle);
    }

    public static void C1(Context context) {
        try {
            com.bumptech.glide.c.c(context).b();
        } catch (Exception unused) {
            c0.u("", "清除缓存");
        }
    }

    private static AlertDialog.Builder D(final Context context, final String str, final InstallWayBean installWayBean) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("安装提示");
        TextView textView = new TextView(context);
        textView.setHighlightColor(context.getResources().getColor(android.R.color.transparent));
        textView.setText(S(context, installWayBean));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        int a2 = com.rtk.app.tool.h.a(20.0f, context);
        textView.setPadding(a2, a2, a2, a2);
        builder.setView(textView);
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() { // from class: com.rtk.app.tool.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                t.x1(str, context, installWayBean, dialogInterface, i2);
            }
        });
        return builder;
    }

    public static void D0(Activity activity, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("mid", str2);
        bundle.putString("family_id", str);
        com.rtk.app.tool.c.b(activity, PostAuditListActivity.class, bundle);
    }

    public static void D1(Context context, List<String> list) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < list.size(); i2++) {
            stringBuffer.append(list.get(i2) + "||");
        }
        v.h(context, "searchUpHistoryVALUE", stringBuffer.toString());
    }

    public static String E(Context context) {
        return context.getString(Build.VERSION.SDK_INT >= 33 ? R.string.camera_permission_tips2 : R.string.camera_permission_tips);
    }

    public static void E0(Activity activity, String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("mid", str);
        bundle.putBoolean("isAuditInfoForFamily", z);
        com.rtk.app.tool.c.b(activity, PostAuditListActivity.class, bundle);
    }

    public static void E1(Context context, int i2, boolean z) {
        com.luck.picture.lib.a f2 = com.luck.picture.lib.b.a((Activity) context).f(com.luck.picture.lib.e.a.n());
        f2.k(i2);
        f2.f(3);
        f2.t(1, 1);
        f2.p(2);
        f2.n(true);
        f2.g(false);
        f2.e(".png");
        f2.j(true);
        f2.r(1.0f);
        f2.q("/CustomPath");
        f2.a(false);
        f2.i(true);
        f2.d(true);
        f2.m(true);
        f2.l(100);
        f2.s(true);
        f2.b(z);
        f2.o(true);
        f2.h(false);
        f2.c(115);
    }

    public static int F(Context context, boolean... zArr) {
        switch (v.b(context, "THEME")) {
            case 2:
                return R.color.theme2;
            case 3:
                return R.color.theme3;
            case 4:
                return R.color.theme4;
            case 5:
                return R.color.theme5;
            case 6:
                return R.color.theme6;
            case 7:
                return R.color.theme7;
            case 8:
                return R.color.theme8;
            case 9:
                return R.color.theme9;
            case 10:
                return R.color.theme10;
            case 11:
                return R.color.theme11;
            case 12:
                return R.color.theme12;
            case 13:
                return R.color.theme13;
            case 14:
                return R.color.theme14;
            case 15:
                return R.color.theme15;
            case 16:
                return R.color.theme16;
            case 17:
                return R.color.theme17;
            case 18:
                return R.color.theme18;
            case 19:
                return R.color.theme19;
            case 20:
                return R.color.theme20;
            case 21:
                return R.color.theme21;
            case 22:
                return R.color.theme22;
            case 23:
                return R.color.theme23;
            case 24:
                return R.color.theme24;
            case 25:
                return R.color.theme25;
            case 26:
                return R.color.theme26;
            case 27:
                return zArr.length == 0 ? R.color.bg1 : R.color.theme1;
            default:
                return R.color.theme1;
        }
    }

    public static void F0(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("up_id", str);
        com.rtk.app.tool.c.b((Activity) MyApplication.b(), MyPostClickDataActivity.class, bundle);
    }

    public static void F1(Context context, int i2) {
        com.luck.picture.lib.a f2 = com.luck.picture.lib.b.a((Activity) context).f(com.luck.picture.lib.e.a.o());
        f2.k(i2);
        f2.f(3);
        f2.t(1, 1);
        f2.p(2);
        f2.n(true);
        f2.g(true);
        f2.e(".png");
        f2.j(true);
        f2.r(1.0f);
        f2.q("/CustomPath");
        f2.a(false);
        f2.m(true);
        f2.l(100);
        f2.s(true);
        f2.c(116);
    }

    public static void G(Activity activity) {
        String charSequence;
        if (!v.a(activity, "user_privacy_protocol")) {
            c0.u("", "用户未同意隐私协议");
            return;
        }
        try {
            ClipboardManager clipboardManager = (ClipboardManager) activity.getSystemService("clipboard");
            if (clipboardManager.hasPrimaryClip()) {
                char c2 = 0;
                if (!c0.q(clipboardManager.getPrimaryClip().getItemAt(0).getText().toString())) {
                    charSequence = clipboardManager.getPrimaryClip().getItemAt(0).getText().toString();
                } else {
                    charSequence = clipboardManager.getPrimaryClip().getItemAt(0).coerceToText(activity).toString();
                }
                if (charSequence.contains("@#&") && charSequence.contains("$#@")) {
                    int indexOf = charSequence.indexOf("@#&") + 3;
                    int indexOf2 = charSequence.indexOf("$#@");
                    if (indexOf2 > indexOf) {
                        try {
                            String str = new String(u.a(charSequence.substring(indexOf, indexOf2)));
                            c0.u("", "   复制口令  " + str);
                            String str2 = c0.d(str, "-").get(0);
                            switch (str2.hashCode()) {
                                case 49:
                                    if (str2.equals("1")) {
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 50:
                                    if (str2.equals("2")) {
                                        c2 = 1;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 51:
                                    if (str2.equals(GlobalSetting.SPLASH_AD)) {
                                        c2 = 2;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 52:
                                    if (str2.equals(GlobalSetting.NATIVE_EXPRESS_AD)) {
                                        c2 = 3;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 53:
                                    if (str2.equals("5")) {
                                        c2 = 4;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                default:
                                    c2 = 65535;
                                    break;
                            }
                            if (c2 == 0) {
                                new DialogForGameCommand(activity, str).show();
                            } else if (c2 == 1) {
                                new DialogForUpCommand(activity, str).show();
                            } else if (c2 == 2) {
                                new DialogForPost(activity, str).show();
                            } else if (c2 == 3) {
                                new DialogForUser(activity, str).show();
                            } else if (c2 != 4) {
                                c0.u("", "口令类型:" + str2);
                                com.rtk.app.tool.f.a(activity, "暂不支持该类型口令，请检查是否为最新版~", f.a.f);
                            } else {
                                new DialogForFamily(activity, str).show();
                            }
                        } catch (Exception e2) {
                            c0.u("", "   复制口令 异常 " + e2.toString());
                        }
                    }
                    clipboardManager.setText("");
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void G0(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, (Class<?>) PostCommentDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("pid", str);
        bundle.putString("reply_id", str2);
        bundle.putString("mid", str3);
        intent.putExtras(bundle);
        ((Activity) context).startActivityForResult(intent, 1020);
    }

    public static void G1(TextView textView, String str, int i2, com.rtk.app.tool.s sVar) {
        textView.setOnClickListener(new f(textView, sVar, str, i2));
    }

    public static String H(String str) {
        try {
            List i2 = new d.a.a.a.b(str).i();
            for (int i3 = 0; i3 < i2.size(); i3++) {
                if (s1(((d.a.a.e.f) i2.get(i3)).l())) {
                    return "UTF-8";
                }
            }
            return "GBK";
        } catch (d.a.a.c.a e2) {
            e2.printStackTrace();
            return "GBK";
        }
    }

    public static void H0(Context context, String str, String str2, String str3) {
        I0(context, str, str2, str3, null);
    }

    public static void H1(TextView textView, String str) {
        str.hashCode();
        if (str.equals("1")) {
            textView.setText("已关注");
            textView.setBackgroundResource(R.drawable.shape_corner_theme1_5dp);
        } else if (!str.equals("2")) {
            textView.setText("关注");
            textView.setBackgroundResource(R.drawable.shape_corner_theme26_5dp);
        } else {
            textView.setBackgroundResource(R.drawable.shape_corner_theme3_5dp);
            textView.setText("互相关注");
        }
    }

    public static String I(String str) {
        File file = new File(str);
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                if (read != -1) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return n(messageDigest.digest());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void I0(Context context, String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString("name", str);
        bundle.putString("logo", str2);
        bundle.putString("mid", str3);
        if (str4 != null && !TextUtils.equals(str4, "0")) {
            bundle.putString("family_id", str4);
            com.rtk.app.tool.c.b((Activity) context, FamilyCommunityListActivity.class, bundle);
        } else {
            com.rtk.app.tool.c.b((Activity) context, CommunityListActivity.class, bundle);
        }
    }

    public static void I1(Context context, String str) {
        ((ClipboardManager) context.getSystemService("clipboard")).setText(str);
        if (!str.contains("user") && !str.contains("post") && !str.contains("family")) {
            com.rtk.app.tool.f.a(context, "已复制：" + str, f.a.f);
            return;
        }
        com.rtk.app.tool.f.a(context, "已复制：" + str + "，您可通过QQ或微信等发给您的好友。", f.a.f);
    }

    public static List<Integer> J(Context context, int i2) {
        ArrayList arrayList = new ArrayList();
        String d2 = v.d(context, "CommentUpOrDown" + i2);
        if (!c0.q(d2)) {
            String[] split = d2.split(";");
            c0.u("", "保存str" + d2);
            for (int i3 = 0; i3 < split.length; i3++) {
                if (split[i3].length() > 0 && !c0.q(split[i3])) {
                    try {
                        arrayList.add(Integer.valueOf(split[i3]));
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return arrayList;
    }

    public static void J0(Context context, String str) {
        K0(context, str, null);
    }

    public static void J1(Context context, View view) {
        float f2 = 10;
        float[] fArr = {f2, f2, f2, f2, com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d};
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(fArr);
        gradientDrawable.setColor(context.getResources().getColor(F(context, new boolean[0])));
        view.setBackgroundDrawable(gradientDrawable);
    }

    public static PackageInfo K(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void K0(Context context, String str, String str2) {
        Bundle b2 = com.rtk.app.c.b.a().b("pid", str);
        b2.putString("family_id", str2);
        Intent intent = new Intent(context, (Class<?>) PostDetailsActivity.class);
        intent.putExtras(b2);
        ((Activity) context).startActivityForResult(intent, 1023);
    }

    public static void K1(int i2, TextView textView, View view, TextView textView2, String str, TextView... textViewArr) {
        switch (i2) {
            case 1:
                view.setVisibility(8);
                textView2.setVisibility(0);
                textView2.setText("串号：" + str);
                textView.setText("复制");
                textView.setEnabled(true);
                try {
                    if (textViewArr[0] != null) {
                        textViewArr[0].setVisibility(0);
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    return;
                }
            case 2:
                view.setVisibility(0);
                textView2.setVisibility(8);
                textView.setText("已过期");
                textView.setEnabled(false);
                return;
            case 3:
                view.setVisibility(0);
                textView2.setVisibility(8);
                textView.setText("取消预定");
                textView.setEnabled(true);
                return;
            case 4:
                view.setVisibility(0);
                textView2.setVisibility(8);
                textView.setText("预定");
                textView.setEnabled(true);
                return;
            case 5:
                view.setVisibility(0);
                textView2.setVisibility(8);
                textView.setText("即将淘号");
                textView.setEnabled(false);
                return;
            case 6:
                if (c0.q(str)) {
                    view.setVisibility(0);
                    textView2.setVisibility(8);
                } else {
                    view.setVisibility(8);
                    textView2.setVisibility(0);
                }
                textView.setText("淘号");
                textView2.setText("串号：" + str);
                textView.setEnabled(true);
                return;
            case 7:
                view.setVisibility(0);
                textView2.setVisibility(8);
                textView.setText("抢礼包");
                textView.setEnabled(true);
                return;
            default:
                return;
        }
    }

    public static String L(Map<String, String> map) {
        List<String> s2 = y.s(map);
        c0.r("", "getKey--参与计算的 key:" + s2);
        return c0(c0.e(s2));
    }

    public static void L0(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        com.rtk.app.tool.c.b((Activity) context, TestPostHtmlPageActivity.class, bundle);
    }

    public static void L1(TextView textView, String str, List<PostTitleBean> list, com.rtk.app.tool.s sVar) {
        try {
            if (c0.q(str)) {
                str = " ";
            }
            Iterator<PostTitleBean> it = list.iterator();
            String str2 = str;
            while (it.hasNext()) {
                str2 = str2 + it.next().getTxt();
            }
            SpannableString spannableString = new SpannableString(str2);
            int length = str.length();
            for (int i2 = 0; i2 < list.size(); i2++) {
                PostTitleBean postTitleBean = list.get(i2);
                if (postTitleBean.getTxt().contains("Lv")) {
                    spannableString.setSpan(new g(sVar), length, postTitleBean.getTxt().length() + length, 33);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
                StyleSpan styleSpan = new StyleSpan(0);
                com.rtk.app.custom.e eVar = new com.rtk.app.custom.e(Color.parseColor(postTitleBean.getColor()), Color.parseColor("#ffffff"));
                spannableString.setSpan(styleSpan, length, postTitleBean.getTxt().length() + length, 33);
                spannableString.setSpan(eVar, length, postTitleBean.getTxt().length() + length, 33);
                length += postTitleBean.getTxt().length();
            }
            textView.setText(spannableString);
        } catch (Exception unused) {
        }
    }

    public static int M(Context context) {
        ConnectivityManager connectivityManager;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception unused) {
        }
        if (connectivityManager == null) {
            return 0;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo.isConnected()) {
            return 1;
        }
        if (networkInfo2.isConnected()) {
            return 2;
        }
        if (!networkInfo.isConnected()) {
            if (!networkInfo2.isConnected()) {
            }
        }
        return 0;
    }

    public static void M0(Context context, String str, String str2, String str3, String str4, String str5, int i2, int i3) {
        if (!y.x(context)) {
            w0(context);
        }
        if ((y.j() && MainActivity.p.getData().getLevel() >= MainActivity.p.getData().getAuthority().getReplyLevel()) || y.B()) {
            Bundle bundle = new Bundle();
            bundle.putString("mid", str);
            bundle.putString("pid", str2);
            bundle.putString("root_cmt_id", str3);
            bundle.putString("reply_cmt_id", str4);
            bundle.putString("toUser", str5);
            bundle.putInt("truePosition", i2);
            bundle.putInt("position", i3);
            Intent intent = new Intent(context, (Class<?>) PostCommentSecondActivity.class);
            intent.putExtras(bundle);
            ((Activity) context).startActivityForResult(intent, 1007);
            return;
        }
        new DialogForToAccountSecurityActivity(context, context.getResources().getString(R.string.no_bound_qq_or_wechat), new e()).show();
    }

    public static void M1(int i2, Context context, com.rtk.app.tool.s... sVarArr) {
        if (com.rtk.app.tool.DownLoadTool.q.e().size() == 0) {
            com.rtk.app.tool.g.c.e(MyApplication.b()).b();
        }
        com.rtk.app.tool.DownLoadTool.p d2 = com.rtk.app.tool.DownLoadTool.q.d(i2);
        try {
            if (new File(d2.e()).exists() && !c0.q(d2.e())) {
                com.rtk.app.tool.DownLoadTool.q.b(d2.j(), d2.n());
                if (d2.m() != 0 && !d2.e().endsWith(".zip")) {
                    m1(context, d2);
                    return;
                }
                if ((c0.q(d2.t()) || !V(context, d2.t())) && com.rtk.app.tool.e0.a.j(d2.e())) {
                    c0.u("", "PublicClass setInstall method downLoadInfo  我是压缩包");
                    if (new File(d2.e()).length() < R() / 1.2d) {
                        r(context, d2);
                        return;
                    } else {
                        com.rtk.app.tool.f.b(context, "存储空间不足！", f.a.f);
                        return;
                    }
                }
                if (!c0.q(d2.n())) {
                    String str = Environment.getExternalStorageDirectory().getPath() + "/Android/obb/" + d2.n();
                    c0.u("", "解压的obb地址保存" + str);
                    File file = new File(str);
                    if (file.exists()) {
                        File[] listFiles = file.listFiles();
                        for (File file2 : listFiles) {
                            if (file2.getName().endsWith(".obb")) {
                                m1(context, d2);
                                return;
                            }
                        }
                    }
                }
                r(context, d2);
                return;
            }
            c0.u("", "（PublicClass.setInstall()）文件不存在 或者地址为空");
            com.rtk.app.tool.g.c.e(context).a(d2.j());
            d2.y(com.rtk.app.tool.DownLoadTool.q.b);
            d2.w(null);
            com.rtk.app.tool.DownLoadTool.x.c().i(d2.j());
            com.rtk.app.tool.DownLoadTool.q.g(d2);
            if (sVarArr.length > 0) {
                sVarArr[0].a(new String[0]);
            }
            new DialogDownLoadTip(MyApplication.b(), d2, "APK文件不存在或者已损坏，是否重新下载？").show();
        } catch (NullPointerException e2) {
            c0.u("", "我被执行了" + e2.toString());
            com.rtk.app.tool.g.c.e(context).i(com.rtk.app.tool.DownLoadTool.q.b, d2.j());
            d2.y(com.rtk.app.tool.DownLoadTool.q.b);
            d2.w(null);
            com.rtk.app.tool.DownLoadTool.x.c().i(d2.j());
            com.rtk.app.tool.DownLoadTool.q.g(d2);
            if (sVarArr.length > 0) {
                sVarArr[0].a(new String[0]);
            }
        }
    }

    public static String N(String str) {
        int parseInt = Integer.parseInt(str);
        return parseInt != 1 ? parseInt != 2 ? parseInt != 3 ? parseInt != 4 ? parseInt != 5 ? "新闻" : "公告" : "活动" : "评测" : "攻略" : "资料";
    }

    public static void N0(Activity activity, PostModificationBean postModificationBean) {
        if (y.I(activity) == 0) {
            return;
        }
        if (y.j() && MainActivity.p.getData().getLevel() < MainActivity.p.getData().getAuthority().getPublishPost()) {
            DialogJustEnsure dialogJustEnsure = new DialogJustEnsure(activity, "发帖需要" + MainActivity.p.getData().getAuthority().getPublishPost() + "级，你目前" + MainActivity.p.getData().getLevel() + "级，抓紧升级吧！", null);
            dialogJustEnsure.show();
            dialogJustEnsure.setCancelable(true);
            return;
        }
        if ((y.j() && MainActivity.p.getData().getLevel() >= MainActivity.p.getData().getAuthority().getPostLevel()) || y.B()) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("modificationBean", postModificationBean);
            Intent intent = new Intent(activity, (Class<?>) PublishPostActivity.class);
            intent.putExtras(bundle);
            activity.startActivityForResult(intent, 1000);
            return;
        }
        new DialogForToAccountSecurityActivity(activity, activity.getResources().getString(R.string.no_bound_qq_or_wechat), new c()).show();
    }

    public static void N1(Activity activity, String str) {
        Intent intent = new Intent();
        HomeManageFragment.u = true;
        LiBaoListActivity.w = true;
        intent.putExtra("isLoginSuccer", true);
        intent.putExtra("isLoginOpen", true);
        activity.setResult(100023, intent);
        v.h(activity, "userInformation", str);
        com.rtk.app.tool.f.a(activity, "登录成功", f.a.f);
        LoginActivity.z = true;
    }

    public static com.bumptech.glide.p.e O() {
        if (f330c == null) {
            f330c = new com.bumptech.glide.p.e().U(R.mipmap.icon_load_logo).k(R.mipmap.icon_load_logo);
        }
        return f330c;
    }

    public static void O0(BaseActivity baseActivity, String str, BoundQQorWechatBean boundQQorWechatBean) {
        Bundle bundle = new Bundle();
        bundle.putString("phone", str);
        bundle.putSerializable("boundQQorWechatBean", boundQQorWechatBean);
        com.rtk.app.tool.c.b((Activity) MyApplication.b(), RegisterActivity.class, bundle);
    }

    public static String O1(String str) {
        return str.contains("ConnectException") ? "服务器连接异常，请检查你的网络" : str.contains("空指针异常") ? "服务器数据异常，可与客服反馈" : str.contains("SocketTimeoutException") ? "连接超时，请检查你的网络" : str;
    }

    public static com.bumptech.glide.p.e P() {
        if (d == null) {
            d = new com.bumptech.glide.p.e().U(R.mipmap.icon_load_logo).k(R.mipmap.icon_load_logo);
        }
        return d;
    }

    public static void P0(Context context, String str, String str2, PostDetailsBean.DataBean dataBean) {
        if (!y.x(context)) {
            w0(context);
        }
        if ((y.j() && MainActivity.p.getData().getLevel() >= MainActivity.p.getData().getAuthority().getReplyLevel()) || y.B()) {
            Q0(context, str, str2, dataBean, null);
        } else {
            new DialogForToAccountSecurityActivity(context, context.getResources().getString(R.string.no_bound_qq_or_wechat), new d()).show();
        }
    }

    public static void P1(View view, Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(10.0f);
        gradientDrawable.setColor(context.getResources().getColor(F(context, true)));
        view.setBackground(gradientDrawable);
    }

    public static PackageInfo Q(Context context, String str) {
        return context.getPackageManager().getPackageArchiveInfo(str, 1);
    }

    public static void Q0(Context context, String str, String str2, PostDetailsBean.DataBean dataBean, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("mid", str);
        bundle.putString("pid", str2);
        bundle.putString("toUser", dataBean.getUid());
        bundle.putString("title", dataBean.getTitle());
        bundle.putString("nickName", dataBean.getPostsBase().getNickname());
        bundle.putString("logo", dataBean.getFace());
        bundle.putString("family_id", str3);
        Intent intent = new Intent(context, (Class<?>) ReplyPostFristCommentActivity.class);
        intent.putExtras(bundle);
        ((Activity) context).startActivityForResult(intent, 1006);
    }

    public static void Q1(int i2, ImageView imageView) {
        if (i2 == 1) {
            imageView.setBackgroundResource(R.mipmap.star_1);
            return;
        }
        if (i2 == 2) {
            imageView.setBackgroundResource(R.mipmap.star_4);
            return;
        }
        if (i2 == 3) {
            imageView.setBackgroundResource(R.mipmap.star_6);
            return;
        }
        if (i2 == 4) {
            imageView.setBackgroundResource(R.mipmap.star_8);
        } else if (i2 != 5) {
            imageView.setBackgroundResource(R.mipmap.star_10);
        } else {
            imageView.setBackgroundResource(R.mipmap.star_10);
        }
    }

    public static long R() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    public static void R0(Context context, String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("mid", str);
        bundle.putString("pid", str2);
        bundle.putString("cmtid", str3);
        bundle.putBoolean("reportUser", false);
        com.rtk.app.tool.c.b((Activity) context, ReportPostActivity.class, bundle);
    }

    public static void R1(int i2, ImageView imageView) {
        switch (i2) {
            case 1:
                imageView.setBackgroundResource(R.mipmap.star_1);
                return;
            case 2:
                imageView.setBackgroundResource(R.mipmap.star_2);
                return;
            case 3:
                imageView.setBackgroundResource(R.mipmap.star_3);
                return;
            case 4:
                imageView.setBackgroundResource(R.mipmap.star_4);
                return;
            case 5:
                imageView.setBackgroundResource(R.mipmap.star_5);
                return;
            case 6:
                imageView.setBackgroundResource(R.mipmap.star_6);
                return;
            case 7:
                imageView.setBackgroundResource(R.mipmap.star_7);
                return;
            case 8:
                imageView.setBackgroundResource(R.mipmap.star_8);
                return;
            case 9:
                imageView.setBackgroundResource(R.mipmap.star_9);
                return;
            case 10:
                imageView.setBackgroundResource(R.mipmap.star_10);
                return;
            default:
                imageView.setBackgroundResource(R.mipmap.star_10);
                return;
        }
    }

    private static SpannableStringBuilder S(Context context, InstallWayBean installWayBean) {
        String str = installWayBean.getPrompt_window() + "查看详情";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int lastIndexOf = str.lastIndexOf("查看详情");
        spannableStringBuilder.setSpan(new n(context, installWayBean), lastIndexOf, lastIndexOf + 4, 33);
        return spannableStringBuilder;
    }

    public static void S0(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("toUser", str);
        bundle.putBoolean("reportUser", true);
        com.rtk.app.tool.c.b((Activity) context, ReportPostActivity.class, bundle);
    }

    public static void S1(Context context, View... viewArr) {
        try {
            int b2 = v.b(context, "THEME");
            V1((Activity) context);
            for (int i2 = 0; i2 < viewArr.length; i2++) {
                if (viewArr[i2] != null) {
                    if (i2 == 0) {
                        viewArr[0].setBackgroundResource(F(context, new boolean[0]));
                    } else if (i2 == 1) {
                        TabLayout tabLayout = (TabLayout) viewArr[1];
                        if (b2 == 27) {
                            tabLayout.setTabTextColors(context.getResources().getColor(R.color.theme1), context.getResources().getColor(2131100024));
                        } else {
                            tabLayout.setTabTextColors(context.getResources().getColor(R.color.drak444), context.getResources().getColor(2131100024));
                        }
                        tabLayout.setBackgroundResource(F(context, new boolean[0]));
                    } else if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                viewArr[i2].setBackgroundResource(F(context, new boolean[0]));
                            } else {
                                viewArr[4].setBackgroundResource(F(context, new boolean[0]));
                            }
                        } else if (b2 == 27) {
                            viewArr[3].setBackgroundResource(F(context, new boolean[0]));
                        } else {
                            viewArr[3].setBackgroundResource(2131100024);
                        }
                    } else if (b2 == 27) {
                        ((TextView) viewArr[2]).setTextColor(context.getResources().getColor(2131100024));
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
        }
    }

    public static String T(Context context) {
        return context.getString(Build.VERSION.SDK_INT >= 33 ? R.string.storage_and_readphond_state_permission_tips2 : R.string.storage_and_readphond_state_permission_tips);
    }

    public static void T0(Context context, String str, Map<String, String> map) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("map", (Serializable) map);
        bundle.putString("tagName", str);
        com.rtk.app.tool.c.b((Activity) context, TagListActivity.class, bundle);
    }

    public static void T1(TextView textView, String str, List<PostTitleBean> list, int i2, int i3) {
        try {
            if (c0.q(str)) {
                str = " ";
            }
            Iterator<PostTitleBean> it = list.iterator();
            String str2 = str;
            while (it.hasNext()) {
                str2 = str2 + it.next().getTxt();
            }
            SpannableString spannableString = new SpannableString(str2);
            int length = str.length();
            for (int i4 = 0; i4 < list.size(); i4++) {
                PostTitleBean postTitleBean = list.get(i4);
                StyleSpan styleSpan = new StyleSpan(0);
                com.rtk.app.custom.e eVar = new com.rtk.app.custom.e(Color.parseColor(postTitleBean.getColor()), Color.parseColor("#ffffff"), i2, i3);
                spannableString.setSpan(styleSpan, length, postTitleBean.getTxt().length() + length, 33);
                spannableString.setSpan(eVar, length, postTitleBean.getTxt().length() + length, 33);
                length += postTitleBean.getTxt().length();
            }
            textView.setText(spannableString);
        } catch (Exception unused) {
        }
    }

    public static String U(Context context) {
        return context.getString(Build.VERSION.SDK_INT >= 33 ? R.string.storage_permission_tips2 : R.string.storage_permission_tips);
    }

    public static void U0(Context context, String str, Map<String, String> map, String str2) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("map", (Serializable) map);
        bundle.putString("tagName", str);
        bundle.putString("url", str2);
        com.rtk.app.tool.c.b((Activity) context, TagListActivity.class, bundle);
    }

    public static void U1(TextView textView, String str, List<PostTitleBean> list) {
        try {
            String str2 = "";
            Iterator<PostTitleBean> it = list.iterator();
            while (it.hasNext()) {
                str2 = str2 + it.next().getTxt();
            }
            SpannableString spannableString = new SpannableString(str2 + str);
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                PostTitleBean postTitleBean = list.get(i3);
                StyleSpan styleSpan = new StyleSpan(0);
                com.rtk.app.custom.d dVar = new com.rtk.app.custom.d(Color.parseColor(postTitleBean.getColor()), Color.parseColor("#ffffff"), 5);
                spannableString.setSpan(styleSpan, i2, postTitleBean.getTxt().length() + i2, 33);
                spannableString.setSpan(new RelativeSizeSpan(0.7f), i2, postTitleBean.getTxt().length() + i2, 33);
                spannableString.setSpan(dVar, i2, postTitleBean.getTxt().length() + i2, 33);
                i2 += postTitleBean.getTxt().length();
            }
            textView.setText(spannableString);
        } catch (Exception unused) {
            textView.setText(str);
        }
    }

    public static boolean V(Context context, String str) {
        boolean z = false;
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
            if (packageArchiveInfo != null) {
                if (packageArchiveInfo.applicationInfo != null) {
                    z = true;
                } else {
                    c0.u("", "apk不为空但是获取不到信息");
                }
            }
        } catch (Exception e2) {
            c0.u("", "异常" + e2.toString());
        }
        if (z) {
            c0.u("", "我是 完整的apk" + str);
        } else {
            context.getPackageManager();
            c0.u("", "我是  不   完整的apk" + str);
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void V0(BaseActivity baseActivity, String str, int i2) {
        Intent intent = new Intent((Context) baseActivity, (Class<?>) UpSrcApkInformationForAdministratorActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("sid", str);
        intent.putExtras(bundle);
        baseActivity.startActivityForResult(intent, i2);
    }

    public static void V1(Activity activity) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            activity.getWindow().addFlags(67108864);
            z zVar = new z(activity);
            zVar.b(true);
            zVar.c(F(activity, new boolean[0]));
            activity.getWindow().getDecorView().setFitsSystemWindows(true);
            if (i2 >= 21) {
                Window window = activity.getWindow();
                window.clearFlags(67108864);
                window.getDecorView().setSystemUiVisibility(LogType.UNEXP_ANR);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(0);
            }
        }
    }

    public static String W(int i2) {
        return i2 != 1 ? i2 != 2 ? "公开" : "仅自己可见" : "分享后可见";
    }

    public static void W0(Context context, int i2, int i3, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("upGameId", i2);
        bundle.putInt("root_reply_id", i3);
        bundle.putString("packageName", str + "");
        com.rtk.app.tool.c.b((Activity) context, UpApkCommentDetailsActivity.class, bundle);
    }

    public static void W1(Context context, TextView textView, String str) {
        str.hashCode();
        if (str.equals("0")) {
            textView.setText("不展示");
            textView.setTextColor(context.getResources().getColor(R.color.theme2));
        } else if (str.equals("1")) {
            textView.setText("列表展示");
            textView.setTextColor(context.getResources().getColor(R.color.theme3));
        }
    }

    public static String X(int i2, int i3) {
        return i2 != 1 ? i2 != 2 ? i3 == 0 ? "公开受限" : "公开" : "仅自己可见" : "分享后可见";
    }

    public static void X0(Context context, ApkInfo apkInfo) {
        Intent intent = new Intent(context, (Class<?>) UpApkDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("apkInfo", apkInfo);
        intent.putExtras(bundle);
        ((Activity) context).startActivityForResult(intent, 1010);
    }

    public static void X1(Context context, TextView textView, String str) {
        Y1(context, textView, str, false);
    }

    public static int Y(Context context) {
        int i2 = a;
        if (i2 != 0) {
            return i2;
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        int i3 = packageInfo.versionCode;
        a = i3;
        return i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void Y0(BaseActivity baseActivity, String str, int i2, int i3, UpApkDetailsBean upApkDetailsBean) {
        Intent intent = new Intent((Context) baseActivity, (Class<?>) UpCheckAgainPassOrListShowActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("sid", str);
        bundle.putInt("startStatus", i2);
        bundle.putSerializable("upApkDetailsBean", upApkDetailsBean);
        intent.putExtras(bundle);
        baseActivity.startActivityForResult(intent, i3);
    }

    public static void Y1(Context context, TextView textView, String str, boolean z) {
        String str2 = z ? "[家族]" : "";
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c2 = 0;
                    break;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    c2 = 1;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c2 = 2;
                    break;
                }
                break;
            case 51:
                if (str.equals(GlobalSetting.SPLASH_AD)) {
                    c2 = 3;
                    break;
                }
                break;
            case 52:
                if (str.equals(GlobalSetting.NATIVE_EXPRESS_AD)) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 4:
                textView.setText(str2 + "已下架");
                textView.setTextColor(context.getResources().getColor(R.color.drak999));
                return;
            case 1:
                textView.setText(str2 + "审核中");
                textView.setTextColor(context.getResources().getColor(R.color.theme2));
                return;
            case 2:
                textView.setText(str2 + "审核未通过");
                textView.setTextColor(context.getResources().getColor(R.color.theme20));
                return;
            case 3:
                textView.setText(str2 + "审核已通过");
                textView.setTextColor(context.getResources().getColor(R.color.theme3));
                return;
            default:
                return;
        }
    }

    public static int Z(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void Z0(BaseActivity baseActivity, String str, UpSuguestBean upSuguestBean, String str2, int i2, UpApkDetailsBean upApkDetailsBean) {
        Intent intent = new Intent((Context) baseActivity, (Class<?>) UpCheckPassOrListShowActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("sid", str);
        bundle.putSerializable("suguestBean", upSuguestBean);
        bundle.putString("startStatus", str2);
        bundle.putSerializable("upApkDetailsBean", upApkDetailsBean);
        intent.putExtras(bundle);
        baseActivity.startActivityForResult(intent, i2);
    }

    public static void Z1(Context context) {
        OnekeyShare onekeyShare = new OnekeyShare();
        onekeyShare.disableSSOWhenAuthorize();
        onekeyShare.setTitle("软天空");
        onekeyShare.setTitleUrl("https://a.app.qq.com/o/simple.jsp?pkgname=com.rtk.app");
        onekeyShare.setText("玩游戏，就来软天空，超多免费游戏爽到爆！");
        onekeyShare.setImageUrl("http://android.ruansky.com/uploads/game_logo/201605/gLogo_574975919741f0.53228633.png");
        onekeyShare.setUrl("https://a.app.qq.com/o/simple.jsp?pkgname=com.rtk.app");
        onekeyShare.setComment("这是一款非常不错的软件");
        onekeyShare.setSite("软天空");
        onekeyShare.setSiteUrl("https://a.app.qq.com/o/simple.jsp?pkgname=com.rtk.app");
        onekeyShare.setCallback(new b(context));
        onekeyShare.show(context);
    }

    public static void a(Context context, int i2, int i3) {
        String str;
        String d2 = v.d(context, "CommentUpOrDown" + i2);
        if (!c0.q(d2)) {
            str = d2 + i3 + ";";
        } else {
            str = "" + i3 + ";";
        }
        c0.u("", "保存addid" + str);
        v.h(context, "CommentUpOrDown" + i2, str);
    }

    public static String a0(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void a1(int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("up_id", i2);
        com.rtk.app.tool.c.b((Activity) MyApplication.b(), UpClickSrcDataActivity.class, bundle);
    }

    public static void a2(Context context, ApkInfo apkInfo, String str) {
        String str2 = "http://a.ruansky.com/up/" + apkInfo.getUpGameId() + "/";
        OnekeyShare onekeyShare = new OnekeyShare();
        onekeyShare.disableSSOWhenAuthorize();
        onekeyShare.setTitle(apkInfo.getAppName());
        onekeyShare.setTitleUrl(str2);
        onekeyShare.setText(str);
        onekeyShare.setImageUrl(apkInfo.getIcon_url());
        onekeyShare.setUrl(str2);
        onekeyShare.setComment("这个软件真不错，大家一起玩吧");
        onekeyShare.setSite("软天空");
        onekeyShare.setSiteUrl(str2);
        onekeyShare.setCallback(new s(context, apkInfo));
        onekeyShare.show(context);
    }

    public static String b(String str) {
        try {
            ResponseBean responseBean = (ResponseBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, ResponseBean.class);
            byte[] bytes = "P.8CGq@Wr~Vs]!4!".getBytes();
            String iv = responseBean.getIv();
            String data = responseBean.getData();
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(u.a(iv)));
            return new String(cipher.doFinal(u.a(data))).trim();
        } catch (Exception e2) {
            e2.printStackTrace();
            c0.u("", "解密出错" + e2.toString());
            return null;
        }
    }

    public static int b0() {
        if (b == 0) {
            b = ((WindowManager) MyApplication.b().getSystemService("window")).getDefaultDisplay().getWidth();
        }
        return b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b1(BaseActivity baseActivity, UpApkDetailsBean.DataBean dataBean, int i2) {
        Intent intent = new Intent((Context) baseActivity, (Class<?>) UpEditApkInformationActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("upApkDetailsBean", dataBean);
        intent.putExtras(bundle);
        baseActivity.startActivityForResult(intent, i2);
    }

    public static void b2(Context context, String str, String str2, String str3, String str4) {
        OnekeyShare onekeyShare = new OnekeyShare();
        onekeyShare.disableSSOWhenAuthorize();
        onekeyShare.setTitle(str2 + "的UP资源");
        onekeyShare.setTitleUrl(str);
        onekeyShare.setText(str4);
        onekeyShare.setImageUrl(str3);
        onekeyShare.setUrl(str);
        onekeyShare.setComment("快来看看我在软天空上传的up资源");
        onekeyShare.setSite("软天空");
        onekeyShare.setSiteUrl(str);
        onekeyShare.setCallback(new C0029t(context));
        onekeyShare.show(context);
    }

    public static void c(Context context, String str, ImageView imageView, boolean... zArr) {
        try {
            ImageView imageView2 = (ImageView) new WeakReference(imageView).get();
            if (zArr.length > 0) {
                com.bumptech.glide.i q2 = com.bumptech.glide.c.t(context.getApplicationContext()).q(str);
                q2.a(O());
                q2.l(imageView2);
            } else if (imageView2 != null) {
                if (imageView.getWidth() < 256) {
                    com.bumptech.glide.i q3 = com.bumptech.glide.c.t(context.getApplicationContext()).q(str);
                    q3.a(O());
                    q3.l(imageView2);
                } else {
                    com.bumptech.glide.i q4 = com.bumptech.glide.c.t(context.getApplicationContext()).q(str);
                    q4.a(O());
                    q4.l(imageView2);
                }
            }
        } catch (Exception e2) {
            c0.u("", "错误" + e2);
        }
    }

    public static String c0(String... strArr) {
        String str = "P.8CGq@Wr~Vs]!4!";
        for (String str2 : strArr) {
            str = str + str2;
        }
        return com.rtk.app.tool.n.b(str);
    }

    public static void c1(Context context) {
        if (com.rtk.app.tool.r.b(context)) {
            v.e(context, "MAINPermisionFrist", Boolean.TRUE);
            if (!y.x(context)) {
                w0(context);
            } else if ((y.j() && MainActivity.p.getData().getLevel() >= MainActivity.p.getData().getAuthority().getUpLevel()) || y.B()) {
                com.rtk.app.tool.c.b((Activity) context, UpGameActivity.class, null);
            } else {
                new DialogForToAccountSecurityActivity(context, context.getResources().getString(R.string.no_bound_qq_or_wechat), new i()).show();
            }
        }
    }

    public static void c2(Context context, String str, String str2, com.rtk.app.tool.s sVar) {
        OnekeyShare onekeyShare = new OnekeyShare();
        onekeyShare.disableSSOWhenAuthorize();
        onekeyShare.setImageUrl(str);
        onekeyShare.setCallback(new q(context, sVar));
        onekeyShare.show(context);
    }

    public static void d(Context context, String str, ImageView imageView) {
        try {
            ImageView imageView2 = (ImageView) new WeakReference(imageView).get();
            if (imageView2 != null) {
                if (str.endsWith(".gif")) {
                    com.bumptech.glide.i m2 = com.bumptech.glide.c.t(context.getApplicationContext()).m();
                    m2.p(str);
                    m2.a(P());
                    m2.l(imageView2);
                } else {
                    com.bumptech.glide.m.q.c.s sVar = new com.bumptech.glide.m.q.c.s(10);
                    com.bumptech.glide.i q2 = com.bumptech.glide.c.t(context.getApplicationContext()).q(str);
                    q2.a(O().e0(sVar));
                    q2.l(imageView2);
                }
            }
        } catch (Exception e2) {
            c0.u("", "错误" + e2 + "不可在Img上设置Tag");
        }
    }

    public static void d0(Context context, int i2, int i3, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("game_id", i2);
        bundle.putInt("reply_id", i3);
        bundle.putString("install_comment", str);
        bundle.putString("packageName", str2);
        com.rtk.app.tool.c.b((Activity) context, CommentDetailsForGameActivity.class, bundle);
    }

    public static void d1(Context context, String str) {
        if (com.rtk.app.tool.r.b(context) && !TextUtils.isEmpty(str)) {
            if (!y.x(context)) {
                w0(context);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("family_id", str);
            com.rtk.app.tool.c.b((Activity) context, UpGameActivity.class, bundle);
        }
    }

    public static void d2(Context context, String str, String str2, String str3, String str4, com.rtk.app.tool.s sVar) {
        OnekeyShare onekeyShare = new OnekeyShare();
        onekeyShare.disableSSOWhenAuthorize();
        onekeyShare.setTitle(str3);
        onekeyShare.setText(str4);
        onekeyShare.setUrl(str2);
        onekeyShare.setTitleUrl(str2);
        onekeyShare.setSiteUrl(str2);
        onekeyShare.setImageUrl(str);
        onekeyShare.setCallback(new r(context, sVar));
        onekeyShare.show(context);
    }

    public static void e(Context context, ApkInfo apkInfo, String str) {
        String str2 = "http://a.ruansky.com/g/" + apkInfo.getGameId() + "/";
        OnekeyShare onekeyShare = new OnekeyShare();
        onekeyShare.disableSSOWhenAuthorize();
        onekeyShare.setTitle(apkInfo.getAppName());
        onekeyShare.setTitleUrl(str2);
        onekeyShare.setText(str);
        onekeyShare.setImageUrl(apkInfo.getIcon_url());
        onekeyShare.setUrl(str2);
        onekeyShare.setComment("这个游戏真不错，大家一起玩吧");
        onekeyShare.setSite("软天空");
        onekeyShare.setSiteUrl(str2);
        onekeyShare.setCallback(new p(context, apkInfo));
        onekeyShare.show(context);
    }

    public static void e0(Context context, ApkInfo apkInfo) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("apkInfo", apkInfo);
        com.rtk.app.tool.c.b((Activity) context, GameDetailsActivity.class, bundle);
    }

    public static void e1(Context context) {
        if (com.rtk.app.tool.r.b(context)) {
            v.e(context, "MAINPermisionFrist", Boolean.TRUE);
            if (!y.x(context)) {
                w0(context);
                return;
            }
            LoginBean loginBean = MainActivity.p;
            if (loginBean != null && loginBean.getData() != null && MainActivity.p.getData().getAuthority() != null && MainActivity.p.getData().getAuthority().getZipAuthority() == 0) {
                com.rtk.app.tool.f.a(context, MainActivity.p.getData().getAuthority().getNoZipAuthorityShow(), f.a.f);
            } else if ((y.j() && MainActivity.p.getData().getLevel() >= MainActivity.p.getData().getAuthority().getUpLevel()) || y.B()) {
                com.rtk.app.tool.c.b((Activity) context, UpZipActivity.class, null);
            } else {
                new DialogForToAccountSecurityActivity(context, context.getResources().getString(R.string.no_bound_qq_or_wechat), new k()).show();
            }
        }
    }

    public static void e2(Context context, View view) {
        PopupMenu popupMenu = new PopupMenu(context, view);
        popupMenu.getMenuInflater().inflate(R.menu.publish_up_item_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new l(context, popupMenu));
        popupMenu.show();
    }

    public static String f(String str) {
        if (str == null) {
            return null;
        }
        String str2 = "";
        String replaceAll = str.replaceAll("[^\\u0000-\\uFFFF]", "");
        char[] charArray = replaceAll.toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            char charAt = replaceAll.charAt(i2);
            str2 = charAt <= 256 ? str2 + "\\u00" + Integer.toHexString(charAt) : str2 + "\\u" + Integer.toHexString(charAt);
        }
        return str2;
    }

    public static void f0(Context context, String str, int i2, int i3) {
        Intent intent = new Intent(context, (Class<?>) GiftDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("giftbag_id", str);
        bundle.putInt("position", i3);
        intent.putExtras(bundle);
        ((Activity) context).startActivityForResult(intent, i2);
    }

    public static void f1(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("pathUrl", str);
        com.rtk.app.tool.c.b((Activity) context, UpMadeRuleActivity.class, bundle);
    }

    public static void f2(Context context, View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        File file = new File(Environment.getExternalStorageDirectory() + "/DCIM/rtk");
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        File file2 = new File(Environment.getExternalStorageDirectory() + "/DCIM/rtk/" + System.currentTimeMillis() + ".png");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            createBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            com.rtk.app.tool.f.a(context, "图片保存在" + file2.getAbsolutePath(), f.a.f);
            h2(file2, context);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void g0(Context context) {
        if (!y.x(context)) {
            w0(context);
        } else {
            com.rtk.app.tool.c.b((Activity) MyApplication.b(), AccountSecurityActivity.class, null);
        }
    }

    public static void g1(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("history", str);
        Intent intent = new Intent(context, (Class<?>) UpSearchToMoreTypeActivity.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public static void g2(Context context, String str) {
        try {
            ((Activity) MyApplication.b()).startActivityForResult(new Intent("android.intent.action.DELETE", Uri.parse("package:" + str)), AdBaseConstants.DEFAULT_BROADCAST_CHECK_TIME);
        } catch (Exception unused) {
        }
    }

    public static void h(View view, ListView listView) {
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        view.setVisibility(8);
        ((ViewGroup) listView.getParent()).addView(view);
        listView.setEmptyView(view);
    }

    public static void h0(Context context, String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("gid", str);
        bundle.putString("pid", str2);
        bundle.putString("uid", str3);
        com.rtk.app.tool.c.b((Activity) context, MedalDetailAchievementActivity.class, bundle);
    }

    public static void h1(Context context) {
        com.rtk.app.tool.c.b((Activity) context, UpSearchJustHistoryActivity.class, new Bundle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h2(File file, Context context) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(file));
        context.sendBroadcast(intent);
    }

    public static void i(Context context, FlowLayout flowLayout, final List<String> list) {
        flowLayout.removeAllViews();
        if (list == null || list.size() < 0) {
            return;
        }
        for (final int i2 = 0; i2 < list.size(); i2++) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.just_image_view_layout, (ViewGroup) flowLayout, false);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.just_imageView);
            flowLayout.addView(inflate);
            c(context, list.get(i2), imageView, new boolean[0]);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.tool.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    t.C0(MyApplication.b(), list, i2);
                }
            });
        }
    }

    public static void i0(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("adId", str);
        com.rtk.app.tool.c.b((Activity) context, AdWebViewActivity.class, bundle);
    }

    public static void i1(int i2, int i3, int i4) {
        Bundle bundle = new Bundle();
        bundle.putInt("sid", i2);
        bundle.putInt("allNum", i3);
        bundle.putInt("toDayDown", i4);
        com.rtk.app.tool.c.b((Activity) MyApplication.b(), UpSrcDataActivity.class, bundle);
    }

    public static void j(Activity activity, String str) {
        try {
            Intent intent = new Intent();
            intent.setData(Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3D" + str));
            activity.startActivity(intent);
        } catch (Exception e2) {
            com.rtk.app.tool.f.a(activity, "您的手机未安装QQ客户端", f.a.f);
            e2.printStackTrace();
        }
    }

    public static void j0(Context context, String str) {
        if (y.x(context)) {
            Bundle bundle = new Bundle();
            bundle.putString("uid", str);
            com.rtk.app.tool.c.b((Activity) context, MyAttentionActivity.class, bundle);
        } else {
            com.rtk.app.tool.f.a(context, "请先登录", f.a.f);
            w0(context);
        }
    }

    public static void j1(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("currentPath", str);
        Intent intent = new Intent(context, (Class<?>) YcFileManageActivity.class);
        intent.putExtras(bundle);
        ((Activity) context).startActivityForResult(intent, 1028);
    }

    public static void k(Activity activity, String str, String... strArr) {
        try {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("mqqwpa://im/chat?chat_type=wpa&uin=" + str)));
        } catch (Exception e2) {
            e2.printStackTrace();
            com.rtk.app.tool.f.a(activity, "您的手机未安装QQ客户端", f.a.f);
        }
    }

    public static void k0(Activity activity, BoundQQorWechatBean boundQQorWechatBean) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("boundQQorWechatBean", boundQQorWechatBean);
        com.rtk.app.tool.c.b((Activity) MyApplication.b(), BoundPhoneActivity.class, bundle);
    }

    public static void k1(Activity activity, String str) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + str));
        activity.startActivity(intent);
    }

    public static File l(Context context, Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        File file = new File(y.C(context) + "/picture/cutImg");
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            byte[] bArr = new byte[102400];
            while (true) {
                int read = byteArrayInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return file;
    }

    public static void l0(Context context, int i2, int i3, int i4, int i5, String str, String str2, String... strArr) {
        if (!y.x(context)) {
            w0(context);
            return;
        }
        if (str.equals("1") && !q1(context, str2)) {
            com.rtk.app.tool.f.a(context, "请安装该游戏后再来评论", f.a.f);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("game_id", i3);
        bundle.putInt("itemPosition", i2);
        bundle.putInt("reply_cmt_id", i4);
        bundle.putInt("root_cmt_id", i5);
        if (strArr.length == 0) {
            bundle.putString("commentType", "game");
        } else {
            bundle.putString("commentType", strArr[0]);
            bundle.putString("toUser", strArr[1]);
        }
        c0.u("", "跳转评论页面 game_id" + i3 + "   reply_cmt_id" + i4 + "   root_cmt_id" + i5);
        if ((y.j() && MainActivity.p.getData().getLevel() >= MainActivity.p.getData().getAuthority().getCommentLevel()) || y.B()) {
            Intent intent = new Intent(context, (Class<?>) CommentActivity.class);
            intent.putExtras(bundle);
            ((Activity) context).startActivityForResult(intent, 1022);
            return;
        }
        new DialogForToAccountSecurityActivity(context, context.getResources().getString(R.string.no_bound_qq_or_wechat), new o()).show();
    }

    public static void l1(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null) {
            currentFocus = new View(activity);
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    public static String m(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    public static void m0(Activity activity, String str, int i2, String str2, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("mid", str);
        bundle.putInt("moudleAdmin", i2);
        bundle.putBoolean("isAuditInfoForFamily", z);
        bundle.putString("family_id", str2);
        com.rtk.app.tool.c.b(activity, PostCommentAuditListActivity.class, bundle);
    }

    public static void m1(Context context, com.rtk.app.tool.DownLoadTool.p pVar) {
        c0.u("", "inStallApkFile in" + pVar.l());
        String e2 = pVar.e();
        if (pVar.m() == 0 && !c0.q(pVar.t())) {
            e2 = pVar.t();
        }
        if (!c0.q(pVar.n()) && pVar.n().equalsIgnoreCase(context.getPackageName())) {
            com.rtk.app.tool.g.c.e(context).a(pVar.j());
            com.rtk.app.tool.DownLoadTool.q.f(pVar.j());
            u1(context, e2, pVar);
            return;
        }
        if (!V(context, e2)) {
            if (com.rtk.app.tool.e0.a.j(e2)) {
                new com.rtk.app.main.dialogPack.a0(context, "[" + pVar.c() + "]" + context.getResources().getString(R.string.apk_version_max));
                return;
            }
            c0.u("", "我是不完整的apk inStallApkFile   " + e2);
            new DialogDownLoadTip(MyApplication.b(), pVar, "APK文件不存在或者已损坏，是否重新下载？").show();
            new File(e2).delete();
            com.rtk.app.tool.DownLoadTool.q.f(pVar.j());
            com.rtk.app.tool.g.c.e(context).a(pVar.j());
            return;
        }
        if (!q1(context, pVar.n())) {
            u1(context, e2, pVar);
            return;
        }
        if (!c0.q(pVar.o()) && pVar.o().length() == 32) {
            c0.u("", "线上md5   " + pVar.o() + "本地md5   " + w.b(context, pVar.n()));
            if (pVar.o().equalsIgnoreCase(w.b(context, pVar.n()))) {
                if (pVar.s() >= Z(context, pVar.n())) {
                    u1(context, e2, pVar);
                    return;
                } else {
                    new DialogApkVersionSamll(MyApplication.b(), pVar).show();
                    return;
                }
            }
            new x(MyApplication.b(), e2, pVar).a();
            return;
        }
        new x(MyApplication.b(), e2, pVar).a();
    }

    public static String n(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static void n0(Activity activity) {
        com.rtk.app.tool.c.b(activity, CommunitySettingActivity.class, null);
    }

    public static void n1(Context context, String str) {
        c0.u("", "开始安装");
        File file = new File(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
            intent.addFlags(1);
            intent.setDataAndType(uriForFile, AdBaseConstants.MIME_APK);
        } else {
            intent.setDataAndType(Uri.fromFile(file), AdBaseConstants.MIME_APK);
        }
        if (i2 >= 26) {
            if (!context.getPackageManager().canRequestPackageInstalls()) {
                MyApplication.b().startActivity(intent);
                DialogForInstallPermission.l = System.currentTimeMillis();
                return;
            } else {
                MyApplication.b().startActivity(intent);
                return;
            }
        }
        MyApplication.b().startActivity(intent);
    }

    public static void o(RadioButton radioButton, int i2, Context context) {
        Bitmap bitmap = ((BitmapDrawable) context.getResources().getDrawable(i2)).getBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            try {
                int color = context.getResources().getColor(F(context, true));
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int[] iArr = new int[width * height];
                int i3 = 0;
                for (int i4 = 0; i4 < height; i4++) {
                    for (int i5 = 0; i5 < width; i5++) {
                        if (Color.alpha(bitmap.getPixel(i5, i4)) != 0) {
                            iArr[i3] = color;
                        } else {
                            iArr[i3] = Color.parseColor("#00000000");
                        }
                        i3++;
                    }
                }
                Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
                StateListDrawable stateListDrawable = new StateListDrawable();
                Drawable drawable = context.getResources().getDrawable(i2);
                stateListDrawable.addState(new int[]{android.R.attr.state_checked}, new BitmapDrawable(createBitmap));
                stateListDrawable.addState(new int[0], drawable);
                stateListDrawable.setBounds(0, 0, stateListDrawable.getMinimumWidth(), stateListDrawable.getMinimumHeight());
                radioButton.setCompoundDrawables(null, stateListDrawable, null, null);
                radioButton.setTextColor(new ColorStateList(new int[][]{new int[]{android.R.attr.state_checked}, new int[0]}, y.F() ? new int[]{color, -12303292} : new int[]{color, -6118750}));
                return;
            } catch (Exception unused) {
                throw new RuntimeException("aimColorStr error!!!");
            }
        }
        throw new RuntimeException("source exception!!!");
    }

    public static void o0(Context context) {
        com.rtk.app.tool.c.b((Activity) context, DownLoadActivity.class, null);
    }

    private static void o1(Context context, com.rtk.app.tool.DownLoadTool.p pVar) {
        com.rtk.app.tool.e0.a aVar = new com.rtk.app.tool.e0.a(context);
        try {
            aVar.l(pVar.e(), Environment.getExternalStorageDirectory() + "/", false, pVar);
        } catch (d.a.a.c.a e2) {
            c0.u("", "解压文件异常" + e2.toString());
            com.rtk.app.tool.DownLoadTool.x.c().i(pVar.j());
            com.rtk.app.tool.DownLoadTool.q.f(pVar.j());
            com.rtk.app.tool.g.c.e(context).a(pVar.j());
            new DialogDownLoadTip(MyApplication.b(), pVar, "APK文件不存在或者已损坏，是否重新下载？").show();
            new File(pVar.e()).delete();
            aVar.k();
        }
    }

    public static void p(Activity activity, String str) {
        try {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("mqqwpa://im/chat?chat_type=crm&uin=" + str)));
        } catch (Exception e2) {
            e2.printStackTrace();
            com.rtk.app.tool.f.a(activity, "您的手机未安装QQ客户端", f.a.f);
        }
    }

    public static void p0(Context context, String str) {
        q0(context, str, null);
    }

    public static void p1(Context context, ViewGroup viewGroup, List<AchievementBean> list, List<EventMedalBean> list2) {
        viewGroup.removeAllViews();
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                View inflate = LayoutInflater.from(context).inflate(R.layout.medal_small_layout, viewGroup, false);
                c(context, list.get(i2).getPic(), (ImageView) inflate.findViewById(R.id.medal_small_img), new boolean[0]);
                viewGroup.addView(inflate);
            }
        }
        if (list2 != null) {
            for (int i3 = 0; i3 < list2.size(); i3++) {
                View inflate2 = LayoutInflater.from(context).inflate(R.layout.medal_small_layout, viewGroup, false);
                c(context, list2.get(i3).getPic(), (ImageView) inflate2.findViewById(R.id.medal_small_img), new boolean[0]);
                viewGroup.addView(inflate2);
            }
        }
    }

    public static void q(Activity activity, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("qqUrl", str);
        com.rtk.app.tool.c.b(activity, QQWebViewActivity.class, bundle);
    }

    public static void q0(Context context, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("adId", str);
        bundle.putString("title", str2);
        com.rtk.app.tool.c.b((Activity) context, DownLoadTipsAdWebViewActivity.class, bundle);
    }

    public static boolean q1(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private static void r(Context context, com.rtk.app.tool.DownLoadTool.p pVar) {
        if (!com.rtk.app.tool.r.b(context)) {
            com.rtk.app.tool.DownLoadTool.x.c().l(pVar.j());
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (!context.getPackageManager().canRequestPackageInstalls()) {
                new DialogForInstallPermission(context).show();
                return;
            } else {
                o1(context, pVar);
                return;
            }
        }
        o1(context, pVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void r0(BaseActivity baseActivity, String str, int i2, UpApkDetailsBean upApkDetailsBean) {
        Intent intent = new Intent((Context) baseActivity, (Class<?>) FamilyUpCheckPassActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("sid", str);
        bundle.putSerializable("upApkDetailsBean", upApkDetailsBean);
        intent.putExtras(bundle);
        baseActivity.startActivityForResult(intent, i2);
    }

    public static Map<String, String> r1(Context context, String str) {
        HashMap hashMap = new HashMap();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                hashMap.put(com.umeng.analytics.pro.d.y, "0");
                hashMap.put("state", "未安装");
                return hashMap;
            }
            if ((packageInfo.applicationInfo.flags & 1) != 0) {
                hashMap.put(com.umeng.analytics.pro.d.y, "2");
                hashMap.put("state", "已内置");
                return hashMap;
            }
            hashMap.put(com.umeng.analytics.pro.d.y, "1");
            hashMap.put("state", "已安装");
            return hashMap;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            hashMap.put(com.umeng.analytics.pro.d.y, "0");
            hashMap.put("state", "未安装");
            return hashMap;
        }
    }

    public static void s(EditText editText, Context context) {
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public static void s0(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("uid", str);
        com.rtk.app.tool.c.b((Activity) context, MyFansActivity.class, bundle);
    }

    private static boolean s1(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == 65533) {
                return true;
            }
        }
        return false;
    }

    public static boolean t(Context context, String str, String str2) {
        File file = new File(str2);
        if (file.exists() && V(context, file.getAbsolutePath())) {
            return true;
        }
        try {
            file.delete();
            file.createNewFile();
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[f.a.f548c];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    return true;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (Exception unused) {
            c0.u("", "复制异常");
            return false;
        }
    }

    public static void t0(Context context) {
        com.rtk.app.tool.c.b((Activity) context, GameClassifyActivity.class, new Bundle());
    }

    public static boolean t1(Context context) {
        ConnectivityManager connectivityManager;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception unused) {
        }
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo.isConnected() || networkInfo2.isConnected()) {
            return true;
        }
        if (!networkInfo.isConnected()) {
            if (!networkInfo2.isConnected()) {
            }
        }
        return false;
    }

    public static void u(Context context, String str) {
        com.bumptech.glide.i l2 = com.bumptech.glide.c.t(context).l();
        l2.p(str);
        l2.a(O());
        l2.i(new h(str, context));
    }

    public static void u0(Context context) {
        com.rtk.app.tool.c.b((Activity) context, HomeUpClassifyActivity.class, new Bundle());
    }

    public static void u1(Context context, String str, com.rtk.app.tool.DownLoadTool.p pVar) {
        if (pVar.l() != null && pVar.l().getInstallWay() != null && pVar.l().getInstallWay().size() > 0) {
            if (pVar.l().isOnlyWay2()) {
                D(context, str, pVar.l().getInstallWay().get(0)).show();
                return;
            } else {
                if (str != null) {
                    Intent intent = new Intent(context, (Class<?>) InstallWayActivity.class);
                    intent.putExtra("install_way", pVar.l());
                    intent.putExtra("app_save_path", str);
                    context.startActivity(intent);
                    return;
                }
                return;
            }
        }
        n1(context, str);
    }

    public static int v(int[] iArr) {
        int i2 = iArr[0];
        for (int i3 : iArr) {
            if (i3 > i2) {
                i2 = i3;
            }
        }
        return i2;
    }

    public static void v0(Context context, String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(com.umeng.analytics.pro.d.y, str);
        bundle.putString("tags", str2);
        bundle.putString("typeName", str3);
        com.rtk.app.tool.c.b((Activity) context, HomeUpSrcListActivity.class, bundle);
    }

    public static void v1(Context context, PostModificationBean postModificationBean) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("modificationBean", postModificationBean);
        Intent intent = new Intent(context, (Class<?>) PublishPostActivity.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public static void w(Activity activity) {
        com.rtk.app.tool.c.b(activity, FansBoardActivity.class, null);
    }

    public static void w0(Context context) {
        if (M(context) == 0) {
            com.rtk.app.tool.f.a(context, "请检查网络", f.a.f);
            return;
        }
        if (!y.K().equals("0")) {
            y.e(context);
            MainActivity.p = null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - e < 300) {
            return;
        }
        e = currentTimeMillis;
        c0.u("", "当前页面" + MyApplication.b().getClass());
        if (MyApplication.b().getClass().toString().contains("LoginActivity")) {
            c0.u("", "当前是在登录页面");
        } else {
            ((Activity) context).startActivityForResult(new Intent(context, (Class<?>) LoginActivity.class), 1);
        }
    }

    public static void x(Activity activity) {
        if (!y.x(activity)) {
            com.rtk.app.tool.f.a(activity, "请先登录", f.a.f);
            w0(activity);
        } else {
            com.rtk.app.tool.c.b(activity, MyPostAttentionActivity.class, null);
        }
    }

    public static void x0(Context context, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gid", str);
        bundle.putString("uid", str2);
        com.rtk.app.tool.c.b((Activity) context, MedalDetailEventActivity.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void x1(String str, Context context, InstallWayBean installWayBean, DialogInterface dialogInterface, int i2) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf == -1) {
            return;
        }
        String substring = str.substring(lastIndexOf + 1, str.length());
        DialogFileCopy dialogFileCopy = new DialogFileCopy(context, "操作中，请耐心等待一会……");
        dialogFileCopy.show();
        new m(context, str, substring, installWayBean, dialogFileCopy).start();
    }

    public static void y(Activity activity, VideoBean videoBean) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("videoBean", videoBean);
        com.rtk.app.tool.c.b((Activity) MyApplication.b(), VideoDetailsActivity.class, bundle);
    }

    public static void y0(Activity activity, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("mid", str);
        bundle.putString("moduleName", str2);
        com.rtk.app.tool.c.b(activity, ModuleDetailsActivity.class, bundle);
    }

    public static void y1(Context context, ApkInfo apkInfo) {
        com.rtk.app.tool.f.a(context, "本游戏需要分享后才能下载！", f.a.f);
        OnekeyShare onekeyShare = new OnekeyShare();
        onekeyShare.disableSSOWhenAuthorize();
        onekeyShare.setTitle("软天空");
        onekeyShare.setTitleUrl("https://a.app.qq.com/o/simple.jsp?pkgname=com.rtk.app");
        onekeyShare.setText("玩游戏，就来软天空，超多免费游戏爽到爆！");
        onekeyShare.setImageUrl("http://android.ruansky.com/uploads/game_logo/201605/gLogo_574975919741f0.53228633.png");
        onekeyShare.setUrl("https://a.app.qq.com/o/simple.jsp?pkgname=com.rtk.app");
        onekeyShare.setComment("这是一款非常不错的软件");
        onekeyShare.setSite("软天空");
        onekeyShare.setSiteUrl("https://a.app.qq.com/o/simple.jsp?pkgname=com.rtk.app");
        onekeyShare.setCallback(new a(context, apkInfo));
        onekeyShare.show(context);
    }

    public static List<PackageInfo> z(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        for (PackageInfo packageInfo : packageManager.getInstalledPackages(0)) {
            if ((packageInfo.applicationInfo.flags & 1) == 0 && !packageInfo.packageName.equals(context.getPackageName())) {
                arrayList.add(packageInfo);
            }
        }
        return arrayList;
    }

    public static void z0(Context context, int i2, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", i2);
        bundle.putString("title", str);
        com.rtk.app.tool.c.b((Activity) context, NewDetailsActivity.class, bundle);
    }

    public static boolean z1(Context context, List<String> list) {
        if (list == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        for (String str : list) {
            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                if ("com.huawei.hidisk".equals(str)) {
                    launchIntentForPackage.setClassName(str, "com.huawei.hidisk.filemanager.FileManager");
                }
                try {
                    MyApplication.b().startActivity(launchIntentForPackage);
                    return true;
                } catch (Exception unused) {
                    com.rtk.app.tool.f.a(context, "打开失败，请手动打开文件管理软件。", f.a.f);
                    return true;
                }
            }
        }
        com.rtk.app.tool.f.a(context, "打开失败，请手动打开文件管理软件。", f.a.f);
        return false;
    }
}
