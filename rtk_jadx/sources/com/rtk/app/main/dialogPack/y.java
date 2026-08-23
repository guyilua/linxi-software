package com.rtk.app.main.dialogPack;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

/* compiled from: DialogHtmlGameBack.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class y extends AlertDialog.Builder {
    private static y b;
    private Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DialogHtmlGameBack.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements DialogInterface.OnClickListener {
        a(y yVar) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DialogHtmlGameBack.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            y unused = y.b = null;
            y.this.a.finish();
        }
    }

    private y(Activity activity) {
        super(activity);
        this.a = activity;
        setMessage("确定离开当前游戏？");
        d();
    }

    public static y c(Activity activity) {
        if (b == null) {
            b = new y(activity);
        }
        b.show();
        return b;
    }

    private void d() {
        setNegativeButton("取消", new a(this));
        setPositiveButton("确定", new b());
    }
}
