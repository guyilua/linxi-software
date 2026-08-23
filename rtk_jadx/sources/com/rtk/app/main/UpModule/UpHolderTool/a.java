package com.rtk.app.main.UpModule.UpHolderTool;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.rtk.app.bean.LoginBean;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.MyApplication;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.t;
import com.rtk.app.tool.v;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import d.a.a.e.f;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: UnZipAsyncTask.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a extends AsyncTask<String, Void, Boolean> {
    private String a;
    private String b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f219c;
    private d.a.a.a.b d;
    private String e;
    private String f;
    private long g;
    private long h;
    private String i;
    String j = "";
    private String k = "";

    public a(String str, Handler handler) {
        this.a = str;
        this.f219c = handler;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(String... strArr) {
        try {
            ArrayList arrayList = new ArrayList();
            File file = new File(this.a);
            this.b = file.getParent();
            d.a.a.a.b bVar = new d.a.a.a.b(file);
            this.d = bVar;
            List i = bVar.i();
            f fVar = null;
            int i2 = 0;
            for (int i3 = 0; i3 < i.size(); i3++) {
                c0.u("UnZipAsyncTask", "压缩文件里面的内容   " + ((f) i.get(i3)).l());
                arrayList.add(((f) i.get(i3)).l());
                if (((f) i.get(i3)).l().endsWith(".apk")) {
                    fVar = (f) i.get(i3);
                    this.j = this.b + "/" + ((f) i.get(i3)).l();
                    i2++;
                }
            }
            if (i2 > 1) {
                this.k = "数据包中含有多个apk";
                return Boolean.FALSE;
            }
            if (fVar == null) {
                this.k = "数据包内缺少apk文件";
                return Boolean.FALSE;
            }
            this.d.e(fVar, this.b);
            c0.u("UnZipAsyncTask", "解压结束" + this.j);
            String absolutePath = this.d.h().getAbsolutePath();
            this.e = t.I(absolutePath);
            this.f = t.I(this.j);
            this.g = new File(this.j).length();
            this.h = file.length();
            c0.u("UnZipAsyncTask", "zipSize" + this.h + "  当前时间 " + WXVideoFileObject.FILE_SIZE_LIMIT);
            if (this.h >= 5.36870912E9d) {
                this.k = "上传文件大小不可超过5G";
                return Boolean.FALSE;
            }
            File file2 = new File(this.j);
            PackageInfo Q = t.Q(MyApplication.b(), this.j);
            ApplicationInfo applicationInfo = Q.applicationInfo;
            applicationInfo.sourceDir = file2.getAbsolutePath();
            applicationInfo.publicSourceDir = file2.getAbsolutePath();
            this.i = Q.applicationInfo.loadLabel(MyApplication.b().getPackageManager()).toString();
            v.h(MyApplication.b(), absolutePath + "MD5", this.e);
            v.h(MyApplication.b(), this.f + "MD5", this.f);
            c0.u("UnZipAsyncTask", "压缩文件的Md5值" + this.e);
            c0.u("UnZipAsyncTask", "apk文件的Md5值" + this.f);
            String str = Q.packageName;
            LoginBean loginBean = MainActivity.p;
            if (loginBean != null && loginBean.getData() != null && MainActivity.p.getData().getAuthority() != null && MainActivity.p.getData().getAuthority().getZipAuthority() == 1) {
                return Boolean.TRUE;
            }
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                String str2 = (String) arrayList.get(i4);
                if (!str2.contains("Android/") && !str2.endsWith(".apk") && !str2.equals("AndroidManifest.xml") && !str2.equals("icon.png")) {
                    String str3 = "数据包内根目录包含额外文件或文件夹：" + str2;
                    this.k = str3;
                    c0.u("UnZipAsyncTask", str3);
                    return Boolean.FALSE;
                }
            }
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                String str4 = (String) arrayList.get(i5);
                if (str4.contains("Android/") && !str4.equals("Android/") && !((String) arrayList.get(i5)).contains("Android/obb/") && !((String) arrayList.get(i5)).contains("Android/data/")) {
                    String str5 = "数据包二级目录包含额外文件夹：" + str4;
                    this.k = str5;
                    c0.u("UnZipAsyncTask", str5);
                    return Boolean.FALSE;
                }
            }
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                if (!((String) arrayList.get(i6)).contains("Android/obb/" + str + "/")) {
                    if (!((String) arrayList.get(i6)).contains("Android/data/" + str + "/")) {
                    }
                }
                return Boolean.TRUE;
            }
            this.k = "缺少数据包文件或者数据包文件路径不正确";
            return Boolean.FALSE;
        } catch (d.a.a.c.a e) {
            e.printStackTrace();
            this.k = "解压失败" + e.toString();
            c0.u("UnZipAsyncTask", "解压失败");
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        if (bool.booleanValue()) {
            Message message = new Message();
            message.what = 8;
            HashMap hashMap = new HashMap();
            hashMap.put("apk_path", this.j);
            hashMap.put("zipMd5", this.e);
            hashMap.put("apkMd5", this.f);
            hashMap.put("zipSize", this.h + "");
            hashMap.put("apkSize", this.g + "");
            hashMap.put("zipPath", this.a);
            hashMap.put("apkName", this.i);
            message.obj = hashMap;
            this.f219c.sendMessage(message);
            return;
        }
        Message message2 = new Message();
        message2.what = 9;
        message2.obj = this.k;
        this.f219c.sendMessage(message2);
    }
}
