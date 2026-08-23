package com.rtk.app.main.dialogPack;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.rtk.app.R;

/* compiled from: DialogUpImg.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b0 extends Dialog {
    private Window a;

    public b0(@NonNull Context context) {
        super(context);
        a();
    }

    private void a() {
        setContentView(R.layout.dialog_up_img);
        b(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }

    public void b(float f, float f2) {
        Window window = getWindow();
        this.a = window;
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = (int) f;
        attributes.y = (int) f2;
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -2;
        this.a.setAttributes(attributes);
    }
}
