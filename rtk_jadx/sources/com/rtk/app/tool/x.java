package com.rtk.app.tool;

import android.content.Context;
import android.os.Handler;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.dialogPack.DialogGameMd5Different;

/* compiled from: SignValidate.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class x {
    static String e;
    private final com.rtk.app.main.dialogPack.z a;
    private Context b;

    /* renamed from: c, reason: collision with root package name */
    private String f334c;
    private com.rtk.app.tool.DownLoadTool.p d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SignValidate.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            x xVar = x.this;
            x.e = xVar.h(xVar.b, x.this.f334c);
            boolean z = false;
            try {
                x.this.b.getPackageManager().getPackageInfo(x.e, 64).signatures[0].toCharsString();
                z = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!z) {
                t.u1(x.this.b, x.this.f334c, x.this.d);
            } else {
                x xVar2 = x.this;
                if (xVar2.g(xVar2.b, x.e).equals(x.f(x.this.b, x.this.f334c))) {
                    t.u1(x.this.b, x.this.f334c, x.this.d);
                } else {
                    new DialogGameMd5Different(MyApplication.b(), x.this.d).show();
                }
            }
            x.this.a.dismiss();
        }
    }

    public x(Context context, String str, com.rtk.app.tool.DownLoadTool.p pVar) {
        this.b = context;
        this.f334c = str;
        this.d = pVar;
        com.rtk.app.main.dialogPack.z zVar = new com.rtk.app.main.dialogPack.z(context);
        this.a = zVar;
        zVar.show();
    }

    public static String f(Context context, String str) {
        try {
            return context.getPackageManager().getPackageArchiveInfo(str, 64).signatures[0].toCharsString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void a() {
        new Handler().postDelayed(new a(), 500L);
    }

    public String g(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures[0].toCharsString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String h(Context context, String str) {
        try {
            return context.getPackageManager().getPackageArchiveInfo(str, 1).packageName;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
