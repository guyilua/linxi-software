package com.rtk.app.custom.RichEditText.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import androidx.annotation.Nullable;
import com.rtk.app.R;
import com.rtk.app.custom.RichEditText.RichEditText;
import com.rtk.app.main.dialogPack.b0;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.downloader.f;
import com.tencent.smtt.sdk.TbsListener;

/* compiled from: VideoPlate.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class i {
    private Context a;
    private RichEditText b;

    /* renamed from: c, reason: collision with root package name */
    private int f169c;
    private e d;
    private b0 e;
    private SpannableStringBuilder f;
    private int g;
    private int h;
    private String i;
    private int j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoPlate.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a extends com.bumptech.glide.p.i.f<Bitmap> {
        a() {
        }

        public void i(@Nullable Drawable drawable) {
            super/*com.bumptech.glide.p.i.a*/.i(drawable);
            Bitmap decodeResource = BitmapFactory.decodeResource(i.this.a.getResources(), R.mipmap.icon_image_load_failed);
            i.this.g(c.c(decodeResource, (decodeResource.getWidth() <= i.this.f169c || i.this.f169c == 0) ? decodeResource.getWidth() : i.this.f169c, PointCategory.VIDEO));
            i.this.d.a(i.this.i);
            i.this.e.dismiss();
        }

        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(Bitmap bitmap, com.bumptech.glide.p.j.d<? super Bitmap> dVar) {
            i.this.g(c.c(bitmap, (bitmap.getWidth() <= i.this.f169c || i.this.f169c == 0) ? bitmap.getWidth() : i.this.f169c, PointCategory.VIDEO));
            i.this.d.a(i.this.i);
            i.this.e.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(Context context, RichEditText richEditText) {
        this.a = context;
        this.b = richEditText;
        this.e = new b0(context);
        richEditText.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Bitmap bitmap) {
        this.b.getEditableText().replace(this.g, this.h, "");
        this.f = new SpannableStringBuilder(this.i);
        e eVar = new e(this.a, bitmap, this.i);
        this.d = eVar;
        this.f.setSpan(eVar, 0, this.i.length(), 33);
        Editable editableText = this.b.getEditableText();
        int i = this.g;
        editableText.replace(i, i, this.f);
        this.b.requestLayout();
        this.b.requestFocus();
    }

    private void i(Bitmap bitmap) {
        this.e.show();
        this.f = new SpannableStringBuilder(this.i);
        this.d = new e(this.a, bitmap, this.i);
        this.h = this.g + this.i.length();
        this.f.setSpan(this.d, 0, this.i.length(), 33);
        this.b.getEditableText().insert(this.g, this.f);
        com.rtk.app.custom.RichEditText.g.a(this.b, this.i, this.g);
        this.b.requestLayout();
        this.b.requestFocus();
    }

    public void h(int i, String str, String str2) {
        this.j = i;
        this.i = "[video=" + this.j + "]" + str + "||" + str2 + "[/video]";
        this.g = this.b.getSelectionStart();
        this.f169c = y.P(this.a, this.b) / 5 == 0 ? TbsListener.ErrorCode.INCR_UPDATE_ERROR : y.P(this.a, this.b) / 5;
        if (str.startsWith("http")) {
            i(BitmapFactory.decodeResource(this.a.getResources(), R.mipmap.icon_load_logo));
            c0.u("VideoPlate", "网址    " + str);
            com.bumptech.glide.i c2 = com.bumptech.glide.c.t(this.a).c();
            c2.p(str);
            c2.a(t.O());
            c2.i(new a());
            return;
        }
        c0.u("VideoPlate", "图片地址" + str);
        com.rtk.app.tool.f.a(this.a, "图片地址出错", f.a.f);
    }
}
