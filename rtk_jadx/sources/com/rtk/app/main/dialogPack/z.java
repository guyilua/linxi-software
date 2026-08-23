package com.rtk.app.main.dialogPack;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.rtk.app.R;

/* compiled from: DialogSignValidate.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class z extends Dialog {
    private Window a;

    public z(Context context) {
        super(context);
        a();
    }

    private void a() {
        setContentView(R.layout.dialog_sign_validate);
        b(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
        setCanceledOnTouchOutside(false);
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
        attributes.height = -1;
        this.a.setAttributes(attributes);
    }
}
