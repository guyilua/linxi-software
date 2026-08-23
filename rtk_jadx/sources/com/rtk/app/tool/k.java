package com.rtk.app.tool;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.rtk.app.bean.ApkBean;
import com.rtk.app.main.MyApplication;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GetAllApkAsyncTask.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class k extends AsyncTask<String, Void, Boolean> {
    private Activity a;

    /* renamed from: c, reason: collision with root package name */
    private Handler f311c;
    private List<ApkBean> b = new ArrayList();
    private boolean d = false;

    public k(Activity activity, Handler handler) {
        this.a = activity;
        this.f311c = handler;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(String... strArr) {
        b(this.a, Environment.getExternalStorageDirectory().getAbsolutePath());
        return Boolean.TRUE;
    }

    public List<ApkBean> b(Activity activity, String str) {
        if (this.d) {
            return null;
        }
        Message message = new Message();
        message.what = 2;
        message.obj = str;
        this.f311c.sendMessage(message);
        File file = new File(str);
        File[] listFiles = file.listFiles();
        PackageManager packageManager = activity.getPackageManager();
        if (!file.exists()) {
            Log.d("GetAllApkAsyncTask", "ryq--" + file.getAbsolutePath());
            f.a(MyApplication.b(), "获取失败", f.a.f);
            return this.b;
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                if (file2.getName().endsWith(".apk")) {
                    PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(file2.getAbsolutePath(), 1);
                    if (packageArchiveInfo != null) {
                        ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
                        applicationInfo.sourceDir = file2.getAbsolutePath();
                        applicationInfo.publicSourceDir = file2.getAbsolutePath();
                        if (applicationInfo != null) {
                            ApkBean apkBean = new ApkBean();
                            apkBean.setName(applicationInfo.loadLabel(packageManager).toString());
                            apkBean.setPath(file2.getAbsolutePath());
                            apkBean.setPackageName(applicationInfo.packageName);
                            apkBean.setInstall(t.q1(activity, applicationInfo.packageName));
                            apkBean.setSize(c0.k(file2.length()));
                            apkBean.setVersion(packageArchiveInfo.versionName);
                            this.b.add(apkBean);
                        }
                    } else {
                        c0.u("GetAllApkAsyncTask", "游戏名" + file2.getAbsolutePath());
                    }
                }
            } else {
                try {
                    b(activity, file2.getAbsolutePath());
                } catch (Exception unused) {
                }
            }
        }
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        if (bool.booleanValue()) {
            Message message = new Message();
            message.what = 1;
            message.obj = this.b;
            this.f311c.sendMessage(message);
        }
    }

    public void d(boolean z) {
        this.d = z;
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        c0.u("GetAllApkAsyncTask", "我被取消了");
    }
}
