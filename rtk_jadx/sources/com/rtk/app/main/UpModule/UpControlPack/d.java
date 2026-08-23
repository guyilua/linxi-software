package com.rtk.app.main.UpModule.UpControlPack;

import android.os.Handler;
import android.os.Message;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.rtk.app.R;

/* compiled from: UpSrcViewTool.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d {
    public static void a(boolean z, ImageView imageView, LinearLayout linearLayout, TextView textView, CheckBox checkBox, TextView textView2, TextView textView3) {
        if (z) {
            imageView.setEnabled(false);
            linearLayout.setVisibility(0);
            textView.setVisibility(8);
            checkBox.setChecked(true);
            return;
        }
        checkBox.setChecked(false);
        imageView.setEnabled(true);
        imageView.setImageResource(R.mipmap.icon_post_add);
        linearLayout.setVisibility(8);
        textView.setVisibility(0);
        textView2.setText("");
        textView3.setText("");
    }

    public static void b(boolean z, Handler handler) {
        Message message = new Message();
        message.what = 4;
        message.obj = Boolean.valueOf(z);
        if (handler != null) {
            handler.sendMessage(message);
        }
    }
}
