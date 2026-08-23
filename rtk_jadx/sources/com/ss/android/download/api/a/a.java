package com.ss.android.download.api.a;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.l;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.b;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a implements l {
    @Override // com.ss.android.download.api.config.l
    public void a(int i, @Nullable Context context, DownloadModel downloadModel, String str, Drawable drawable, int i2) {
        Toast.makeText(context, str, 0).show();
    }

    @Override // com.ss.android.download.api.config.l
    public Dialog b(@NonNull com.ss.android.download.api.model.b bVar) {
        return a(bVar);
    }

    private static Dialog a(final com.ss.android.download.api.model.b bVar) {
        if (bVar == null) {
            return null;
        }
        AlertDialog show = new AlertDialog.Builder(bVar.a).setTitle(bVar.b).setMessage(bVar.f704c).setPositiveButton(bVar.d, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.a.a.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                b.InterfaceC0069b interfaceC0069b = com.ss.android.download.api.model.b.this.h;
                if (interfaceC0069b != null) {
                    interfaceC0069b.a(dialogInterface);
                }
            }
        }).setNegativeButton(bVar.e, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.a.a.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                b.InterfaceC0069b interfaceC0069b = com.ss.android.download.api.model.b.this.h;
                if (interfaceC0069b != null) {
                    interfaceC0069b.b(dialogInterface);
                }
            }
        }).show();
        show.setCanceledOnTouchOutside(bVar.f);
        show.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.download.api.a.a.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                b.InterfaceC0069b interfaceC0069b = com.ss.android.download.api.model.b.this.h;
                if (interfaceC0069b != null) {
                    interfaceC0069b.c(dialogInterface);
                }
            }
        });
        Drawable drawable = bVar.g;
        if (drawable != null) {
            show.setIcon(drawable);
        }
        return show;
    }
}
