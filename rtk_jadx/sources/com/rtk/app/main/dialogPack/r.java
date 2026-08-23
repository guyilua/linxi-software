package com.rtk.app.main.dialogPack;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import com.rtk.app.R;
import com.sigmob.sdk.downloader.f;
import java.io.File;

/* compiled from: DialogDeleteGameForPath.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class r extends AlertDialog.Builder {
    private Context a;
    private String b;

    /* renamed from: c, reason: collision with root package name */
    private com.rtk.app.tool.s f258c;
    private int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DialogDeleteGameForPath.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (new File(r.this.b).delete()) {
                r.this.f258c.a(r.this.d + "");
                com.rtk.app.tool.f.a(r.this.a, "删除成功！", f.a.f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DialogDeleteGameForPath.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements DialogInterface.OnClickListener {
        b(r rVar) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public r(@NonNull Context context, String str, int i, com.rtk.app.tool.s sVar) {
        super(context);
        this.a = context;
        this.b = str;
        this.f258c = sVar;
        this.d = i;
        f();
        e();
    }

    private void e() {
        setPositiveButton("确定", new a());
        setNegativeButton("取消", new b(this));
    }

    private void f() {
        setIcon(R.mipmap.icon_logo);
        setTitle("提示");
        setMessage("是否删除安装包？");
    }
}
