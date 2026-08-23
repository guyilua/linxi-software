package com.rtk.app.main.dialogPack;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import com.rtk.app.R;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DeleteDialog.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class p extends AlertDialog.Builder {
    private Context a;
    private com.rtk.app.tool.DownLoadTool.p b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f256c;
    private List<com.rtk.app.tool.DownLoadTool.p> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeleteDialog.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(p.this.d);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                com.rtk.app.tool.DownLoadTool.p pVar = (com.rtk.app.tool.DownLoadTool.p) arrayList.get(i2);
                com.rtk.app.tool.p.a(p.this.a).d(pVar.j());
                com.rtk.app.tool.DownLoadTool.t.h(pVar.j(), com.rtk.app.tool.DownLoadTool.q.b, false);
                p.this.e(pVar);
            }
            p.this.d.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeleteDialog.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements DialogInterface.OnClickListener {
        b(p pVar) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeleteDialog.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            com.rtk.app.tool.DownLoadTool.t.h(p.this.b.j(), com.rtk.app.tool.DownLoadTool.q.b, new boolean[0]);
            p pVar = p.this;
            pVar.e(pVar.b);
            com.rtk.app.tool.p.a(p.this.a).d(p.this.b.j());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeleteDialog.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class d implements DialogInterface.OnClickListener {
        d(p pVar) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public p(Context context, com.rtk.app.tool.DownLoadTool.p pVar, Handler handler, int i, List<com.rtk.app.tool.DownLoadTool.p>... listArr) {
        super(context);
        this.a = context;
        this.b = pVar;
        this.f256c = handler;
        if (pVar == null && i == 0 && listArr.length > 0) {
            this.d = listArr[0];
            d();
        } else {
            g();
        }
    }

    private void d() {
        setIcon(R.mipmap.icon_logo);
        setTitle("提示");
        setMessage("是否删除全部游戏");
        setPositiveButton("确定", new a());
        setNegativeButton("取消", new b(this));
    }

    private void f(String str) {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/download/apks/" + str.substring(str.lastIndexOf("/") + 1, str.length()));
        if (file.exists()) {
            file.delete();
        }
    }

    private void g() {
        setIcon(R.mipmap.icon_logo);
        setTitle("提示");
        setMessage("是否删除" + this.b.c());
        setPositiveButton("确定", new c());
        setNegativeButton("取消", new d(this));
    }

    public void e(com.rtk.app.tool.DownLoadTool.p pVar) {
        String absolutePath;
        String t;
        if (pVar.m() == 1) {
            absolutePath = pVar.e();
            t = null;
        } else {
            absolutePath = new File(pVar.e()).getParentFile().getAbsolutePath();
            t = pVar.t();
        }
        pVar.y(com.rtk.app.tool.DownLoadTool.q.d);
        com.rtk.app.tool.DownLoadTool.x c2 = com.rtk.app.tool.DownLoadTool.x.c();
        c2.k(pVar.j());
        com.rtk.app.tool.g.c.e(this.a).i(com.rtk.app.tool.DownLoadTool.q.d, pVar.j());
        com.rtk.app.tool.DownLoadTool.t.h(pVar.j(), com.rtk.app.tool.DownLoadTool.q.d, new boolean[0]);
        com.rtk.app.tool.g.c.e(this.a).a(pVar.j());
        c2.i(pVar.j());
        if (com.rtk.app.tool.c0.q(absolutePath)) {
            com.rtk.app.tool.f.a(this.a, "删除失败！", f.a.f);
            return;
        }
        File file = new File(absolutePath);
        if (absolutePath.endsWith(".apk")) {
            f(absolutePath);
        } else if (!TextUtils.isEmpty(t) && t.endsWith(".apk")) {
            f(t);
        }
        if (!file.exists()) {
            com.rtk.app.tool.g.c.e(this.a).a(pVar.j());
            this.f256c.sendEmptyMessage(1);
        } else if (file.delete()) {
            com.rtk.app.tool.g.c.e(this.a).a(pVar.j());
            this.f256c.sendEmptyMessage(1);
        } else if (com.rtk.app.tool.e0.a.h(file)) {
            com.rtk.app.tool.g.c.e(this.a).a(pVar.j());
            this.f256c.sendEmptyMessage(1);
        } else {
            com.rtk.app.tool.f.a(this.a, "删除失败！", f.a.f);
        }
    }
}
