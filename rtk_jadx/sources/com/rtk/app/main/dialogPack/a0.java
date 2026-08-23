package com.rtk.app.main.dialogPack;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import com.rtk.app.R;
import com.rtk.app.main.MyApplication;

/* compiled from: DialogTips.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a0 {
    private String a;

    public a0(@NonNull Context context, String str) {
        this.a = str;
        a();
    }

    private void a() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MyApplication.b());
        builder.setIcon(R.mipmap.icon_logo);
        builder.setTitle("提示");
        builder.setMessage(this.a);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.rtk.app.main.dialogPack.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }
}
