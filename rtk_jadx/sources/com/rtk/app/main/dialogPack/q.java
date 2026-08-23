package com.rtk.app.main.dialogPack;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import com.rtk.app.R;
import com.rtk.app.bean.ApkBean;
import java.io.File;
import java.util.List;

/* compiled from: DialogDeleteAllGame.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class q extends AlertDialog.Builder {
    private String a;
    private com.rtk.app.tool.s b;

    /* renamed from: c, reason: collision with root package name */
    private List<ApkBean> f257c;
    Thread d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DialogDeleteAllGame.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements DialogInterface.OnClickListener {

        /* compiled from: DialogDeleteAllGame.java */
        /* renamed from: com.rtk.app.main.dialogPack.q$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        class RunnableC0024a implements Runnable {
            RunnableC0024a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                for (int i = 0; i < q.this.f257c.size(); i++) {
                    q qVar = q.this;
                    qVar.a = ((ApkBean) qVar.f257c.get(i)).getPath();
                    new File(q.this.a).delete();
                }
                q.this.b.a(new String[0]);
            }
        }

        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            q.this.d = new Thread(new RunnableC0024a());
            q.this.d.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DialogDeleteAllGame.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements DialogInterface.OnClickListener {
        b(q qVar) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public q(@NonNull Context context, List<ApkBean> list, com.rtk.app.tool.s sVar) {
        super(context);
        this.f257c = list;
        this.b = sVar;
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
        setMessage("是否删除所有安装包？");
    }
}
