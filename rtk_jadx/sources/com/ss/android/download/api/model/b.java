package com.ss.android.download.api.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {
    public Context a;
    public String b;

    /* renamed from: c, reason: collision with root package name */
    public String f704c;
    public String d;
    public String e;
    public boolean f;
    public Drawable g;
    public InterfaceC0069b h;
    public View i;
    public int j;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class a {
        public View a;
        public int b;

        /* renamed from: c, reason: collision with root package name */
        private Context f705c;
        private String d;
        private String e;
        private String f;
        private String g;
        private boolean h;
        private Drawable i;
        private InterfaceC0069b j;

        public a(Context context) {
            this.f705c = context;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public a b(String str) {
            this.e = str;
            return this;
        }

        public a c(String str) {
            this.f = str;
            return this;
        }

        public a d(String str) {
            this.g = str;
            return this;
        }

        public a a(boolean z) {
            this.h = z;
            return this;
        }

        public a a(Drawable drawable) {
            this.i = drawable;
            return this;
        }

        public a a(InterfaceC0069b interfaceC0069b) {
            this.j = interfaceC0069b;
            return this;
        }

        public a a(int i) {
            this.b = i;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* renamed from: com.ss.android.download.api.model.b$b, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface InterfaceC0069b {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    private b(a aVar) {
        this.f = true;
        this.a = aVar.f705c;
        this.b = aVar.d;
        this.f704c = aVar.e;
        this.d = aVar.f;
        this.e = aVar.g;
        this.f = aVar.h;
        this.g = aVar.i;
        this.h = aVar.j;
        this.i = aVar.a;
        this.j = aVar.b;
    }
}
