package com.rtk.app.custom.RichEditText.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import androidx.annotation.Nullable;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.bean.UpServiceUpImgBean;
import com.rtk.app.custom.RichEditText.RichEditText;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.dialogPack.b0;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ImagePlate.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b implements h.j {
    private Context a;
    private RichEditText b;

    /* renamed from: c, reason: collision with root package name */
    private int f167c;
    private e d;
    private b0 e;
    private SpannableStringBuilder f;
    private int g;
    private int h;
    private List<String> i = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImagePlate.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a extends com.bumptech.glide.p.i.f<Bitmap> {
        final /* synthetic */ String d;

        a(String str) {
            this.d = str;
        }

        public void i(@Nullable Drawable drawable) {
            Bitmap c2;
            super/*com.bumptech.glide.p.i.a*/.i(drawable);
            Bitmap decodeResource = BitmapFactory.decodeResource(b.this.a.getResources(), R.mipmap.icon_image_load_failed);
            if (!this.d.contains(".gif") && !this.d.contains(".GIF")) {
                c2 = c.c(decodeResource, (decodeResource.getWidth() <= b.this.f167c || b.this.f167c == 0) ? decodeResource.getWidth() : b.this.f167c, new String[0]);
            } else {
                c2 = c.c(decodeResource, (decodeResource.getWidth() <= b.this.f167c || b.this.f167c == 0) ? decodeResource.getWidth() : b.this.f167c, "gif");
            }
            b.this.k(c2, this.d);
            b.this.d.a("[img]" + this.d + "[/img]");
            b.this.e.dismiss();
        }

        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(Bitmap bitmap, com.bumptech.glide.p.j.d<? super Bitmap> dVar) {
            Bitmap c2;
            if (!this.d.contains(".gif") && !this.d.contains(".GIF")) {
                c2 = c.c(bitmap, (bitmap.getWidth() <= b.this.f167c || b.this.f167c == 0) ? bitmap.getWidth() : b.this.f167c, new String[0]);
            } else {
                c2 = c.c(bitmap, (bitmap.getWidth() <= b.this.f167c || b.this.f167c == 0) ? bitmap.getWidth() : b.this.f167c, "gif");
            }
            b.this.k(c2, this.d);
            b.this.d.a("[img]" + this.d + "[/img]");
            b.this.e.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImagePlate.java */
    /* renamed from: com.rtk.app.custom.RichEditText.a.b$b, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class RunnableC0018b implements Runnable {
        RunnableC0018b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.i.size() <= 0) {
                b.this.e.dismiss();
                return;
            }
            File file = new File((String) b.this.i.get(b.this.i.size() - 1));
            Bitmap decodeFile = BitmapFactory.decodeFile(file.getPath());
            b.this.i.remove(b.this.i.size() - 1);
            if (decodeFile != null) {
                int i = b.this.f167c;
                String[] strArr = new String[1];
                strArr[0] = (file.getPath().endsWith(".gif") || file.getPath().endsWith(".GIF")) ? "gif" : null;
                b.this.m(c.c(decodeFile, i, strArr), "图片");
                c0.u("ImagePlate", "宽度" + decodeFile.getWidth() + " 高度 " + decodeFile.getHeight());
                b.this.p(file);
                return;
            }
            c0.u("ImagePlate", "图片错误");
            b.this.q();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Context context, RichEditText richEditText) {
        this.a = context;
        this.b = richEditText;
        this.e = new b0(context);
        richEditText.setMovementMethod(LinkMovementMethod.getInstance());
        com.bumptech.glide.c.t(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Bitmap bitmap, String str) {
        String str2 = "[img]" + str + "[/img]";
        this.b.getEditableText().replace(this.g, this.h, "");
        this.f = new SpannableStringBuilder(str2);
        e eVar = new e(this.a, bitmap, str2);
        this.d = eVar;
        this.f.setSpan(eVar, 0, str2.length(), 33);
        Editable editableText = this.b.getEditableText();
        int i = this.g;
        editableText.replace(i, i, this.f);
        this.b.requestLayout();
        this.b.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Bitmap bitmap, String str) {
        String str2 = "[img]" + str + "[/img]";
        this.e.show();
        this.f = new SpannableStringBuilder(str2);
        this.d = new e(this.a, bitmap, str);
        this.h = this.g + str2.length();
        this.f.setSpan(this.d, 0, str2.length(), 33);
        this.b.getEditableText().insert(this.g, this.f);
        com.rtk.app.custom.RichEditText.g.a(this.b, str2, this.g);
        this.b.requestLayout();
        this.b.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        ((Activity) MyApplication.b()).runOnUiThread(new RunnableC0018b());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        c0.u("ImagePlate", "上传图片的地址   " + str);
        UpServiceUpImgBean upServiceUpImgBean = (UpServiceUpImgBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, UpServiceUpImgBean.class);
        c0.u("ImagePlate", "图片替换" + upServiceUpImgBean.toString() + "   再次替换   " + upServiceUpImgBean.getPath().getUrl() + upServiceUpImgBean.getPath().getThumb());
        this.d.a(upServiceUpImgBean.toString());
        SpannableStringBuilder spannableStringBuilder = this.f;
        StringBuilder sb = new StringBuilder();
        sb.append(upServiceUpImgBean.getPath().getUrl());
        sb.append(upServiceUpImgBean.getPath().getThumb());
        spannableStringBuilder.replace(5, 7, (CharSequence) sb.toString());
        q();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.e.dismiss();
        c0.u("ImagePlate", "上传图片失败  " + str);
        if (str.contains("SocketTimeoutException")) {
            com.rtk.app.tool.f.a(this.a, "上传失败：链接服务器失败", 200);
        } else {
            com.rtk.app.tool.f.a(this.a, "上传失败：" + str, 200);
        }
        try {
            this.b.getText().delete(this.g, this.h);
        } catch (Exception unused) {
        }
    }

    public void l(Bitmap bitmap, File file) {
        this.g = this.b.getSelectionStart();
        int measuredWidth = this.b.getMeasuredWidth() / 5;
        this.f167c = measuredWidth;
        String[] strArr = new String[1];
        strArr[0] = (file.getPath().endsWith(".gif") || file.getPath().endsWith(".GIF")) ? "gif" : null;
        Bitmap c2 = c.c(bitmap, measuredWidth, strArr);
        m(c2, "图片");
        c0.u("ImagePlate", "宽度" + bitmap.getWidth() + " 高度 " + bitmap.getHeight() + "\n原尺寸" + bitmap.getByteCount() + "\n现在尺寸" + c2.getByteCount());
        p(file);
    }

    public void n(String str) {
        this.g = this.b.getSelectionStart();
        this.f167c = y.P(this.a, this.b) / 5;
        if (str.startsWith("http")) {
            m(BitmapFactory.decodeResource(this.a.getResources(), R.mipmap.icon_load_logo), str);
            c0.u("ImagePlate", "网址    " + str);
            com.bumptech.glide.i c2 = com.bumptech.glide.c.t(this.a).c();
            c2.p(str);
            c2.a(t.O());
            c2.i(new a(str));
            return;
        }
        c0.u("ImagePlate", "图片地址" + str);
        com.rtk.app.tool.f.a(this.a, "图片地址出错", f.a.f);
    }

    public void o(List<String> list) {
        this.g = this.b.getSelectionStart();
        this.f167c = this.b.getMeasuredWidth() / 5;
        this.i.addAll(list);
        q();
    }

    public void p(File file) {
        com.rtk.app.tool.o.h.v(this.a, new f(y.K(), y.H(), MainActivity.p.getData().getLevel() + "", this, y.i + "html/filelist/uploadBbsImg", 1, file, "picture"), new boolean[0]);
    }
}
