package com.tencent.smtt.utils;

import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UnknownFormatConversionException;

/* compiled from: Elf.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e implements Closeable {
    static final char[] a = {127, 'E', 'L', 'F', 0};
    final char[] b;

    /* renamed from: c, reason: collision with root package name */
    boolean f977c;
    j[] d;
    l[] e;
    byte[] f;
    private final com.tencent.smtt.utils.c g;
    private final a h;
    private final k[] i;
    private byte[] j;

    /* compiled from: Elf.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static abstract class a {
        short a;
        short b;

        /* renamed from: c, reason: collision with root package name */
        int f978c;
        int d;
        short e;
        short f;
        short g;
        short h;
        short i;
        short j;

        abstract long a();

        abstract long b();
    }

    /* compiled from: Elf.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class b extends a {
        int k;
        int l;
        int m;

        b() {
        }

        @Override // com.tencent.smtt.utils.e.a
        long a() {
            return this.m;
        }

        @Override // com.tencent.smtt.utils.e.a
        long b() {
            return this.l;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Elf.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class c extends j {
        int a;
        int b;

        /* renamed from: c, reason: collision with root package name */
        int f979c;
        int d;
        int e;
        int f;

        c() {
        }
    }

    /* compiled from: Elf.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class d extends k {
        int a;
        int b;

        /* renamed from: c, reason: collision with root package name */
        int f980c;
        int d;
        int e;
        int f;

        d() {
        }

        @Override // com.tencent.smtt.utils.e.k
        public int a() {
            return this.d;
        }

        @Override // com.tencent.smtt.utils.e.k
        public long b() {
            return this.f980c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Elf.java */
    /* renamed from: com.tencent.smtt.utils.e$e, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class C0120e extends l {
        int a;
        int b;

        C0120e() {
        }
    }

    /* compiled from: Elf.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class f extends a {
        long k;
        long l;
        long m;

        f() {
        }

        @Override // com.tencent.smtt.utils.e.a
        long a() {
            return this.m;
        }

        @Override // com.tencent.smtt.utils.e.a
        long b() {
            return this.l;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Elf.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class g extends j {
        long a;
        long b;

        /* renamed from: c, reason: collision with root package name */
        long f981c;
        long d;
        long e;
        long f;

        g() {
        }
    }

    /* compiled from: Elf.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class h extends k {
        long a;
        long b;

        /* renamed from: c, reason: collision with root package name */
        long f982c;
        long d;
        long e;
        long f;

        h() {
        }

        @Override // com.tencent.smtt.utils.e.k
        public int a() {
            return (int) this.d;
        }

        @Override // com.tencent.smtt.utils.e.k
        public long b() {
            return this.f982c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Elf.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class i extends l {
        long a;
        long b;

        i() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Elf.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static abstract class j {
        int g;
        int h;

        j() {
        }
    }

    /* compiled from: Elf.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static abstract class k {
        int g;
        int h;
        int i;
        int j;

        public abstract int a();

        public abstract long b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Elf.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static abstract class l {

        /* renamed from: c, reason: collision with root package name */
        int f983c;
        char d;
        char e;
        short f;

        l() {
        }
    }

    public e(File file) {
        char[] cArr = new char[16];
        this.b = cArr;
        com.tencent.smtt.utils.c cVar = new com.tencent.smtt.utils.c(file);
        this.g = cVar;
        cVar.a(cArr);
        if (a()) {
            cVar.a(e());
            boolean d2 = d();
            if (d2) {
                f fVar = new f();
                fVar.a = cVar.a();
                fVar.b = cVar.a();
                fVar.f978c = cVar.b();
                fVar.k = cVar.c();
                fVar.l = cVar.c();
                fVar.m = cVar.c();
                this.h = fVar;
            } else {
                b bVar = new b();
                bVar.a = cVar.a();
                bVar.b = cVar.a();
                bVar.f978c = cVar.b();
                bVar.k = cVar.b();
                bVar.l = cVar.b();
                bVar.m = cVar.b();
                this.h = bVar;
            }
            a aVar = this.h;
            aVar.d = cVar.b();
            aVar.e = cVar.a();
            aVar.f = cVar.a();
            aVar.g = cVar.a();
            aVar.h = cVar.a();
            aVar.i = cVar.a();
            aVar.j = cVar.a();
            this.i = new k[aVar.i];
            for (int i2 = 0; i2 < aVar.i; i2++) {
                cVar.a(aVar.a() + (aVar.h * i2));
                if (d2) {
                    h hVar = new h();
                    hVar.g = cVar.b();
                    hVar.h = cVar.b();
                    hVar.a = cVar.c();
                    hVar.b = cVar.c();
                    hVar.f982c = cVar.c();
                    hVar.d = cVar.c();
                    hVar.i = cVar.b();
                    hVar.j = cVar.b();
                    hVar.e = cVar.c();
                    hVar.f = cVar.c();
                    this.i[i2] = hVar;
                } else {
                    d dVar = new d();
                    dVar.g = cVar.b();
                    dVar.h = cVar.b();
                    dVar.a = cVar.b();
                    dVar.b = cVar.b();
                    dVar.f980c = cVar.b();
                    dVar.d = cVar.b();
                    dVar.i = cVar.b();
                    dVar.j = cVar.b();
                    dVar.e = cVar.b();
                    dVar.f = cVar.b();
                    this.i[i2] = dVar;
                }
            }
            short s = aVar.j;
            if (s > -1) {
                k[] kVarArr = this.i;
                if (s < kVarArr.length) {
                    k kVar = kVarArr[s];
                    if (kVar.h == 3) {
                        this.j = new byte[kVar.a()];
                        cVar.a(kVar.b());
                        cVar.a(this.j);
                        if (this.f977c) {
                            f();
                            return;
                        }
                        return;
                    }
                    throw new UnknownFormatConversionException("Wrong string section e_shstrndx=" + ((int) aVar.j));
                }
            }
            throw new UnknownFormatConversionException("Invalid e_shstrndx=" + ((int) aVar.j));
        }
        throw new UnknownFormatConversionException("Invalid elf magic: " + file);
    }

    private void f() {
        a aVar = this.h;
        com.tencent.smtt.utils.c cVar = this.g;
        boolean d2 = d();
        k a2 = a(".dynsym");
        if (a2 != null) {
            cVar.a(a2.b());
            int a3 = a2.a() / (d2 ? 24 : 16);
            this.e = new l[a3];
            char[] cArr = new char[1];
            for (int i2 = 0; i2 < a3; i2++) {
                if (d2) {
                    i iVar = new i();
                    iVar.f983c = cVar.b();
                    cVar.a(cArr);
                    iVar.d = cArr[0];
                    cVar.a(cArr);
                    iVar.e = cArr[0];
                    iVar.a = cVar.c();
                    iVar.b = cVar.c();
                    iVar.f = cVar.a();
                    this.e[i2] = iVar;
                } else {
                    C0120e c0120e = new C0120e();
                    c0120e.f983c = cVar.b();
                    c0120e.a = cVar.b();
                    c0120e.b = cVar.b();
                    cVar.a(cArr);
                    c0120e.d = cArr[0];
                    cVar.a(cArr);
                    c0120e.e = cArr[0];
                    c0120e.f = cVar.a();
                    this.e[i2] = c0120e;
                }
            }
            k kVar = this.i[a2.i];
            cVar.a(kVar.b());
            byte[] bArr = new byte[kVar.a()];
            this.f = bArr;
            cVar.a(bArr);
        }
        this.d = new j[aVar.g];
        for (int i3 = 0; i3 < aVar.g; i3++) {
            cVar.a(aVar.b() + (aVar.f * i3));
            if (d2) {
                g gVar = new g();
                gVar.g = cVar.b();
                gVar.h = cVar.b();
                gVar.a = cVar.c();
                gVar.b = cVar.c();
                gVar.f981c = cVar.c();
                gVar.d = cVar.c();
                gVar.e = cVar.c();
                gVar.f = cVar.c();
                this.d[i3] = gVar;
            } else {
                c cVar2 = new c();
                cVar2.g = cVar.b();
                cVar2.h = cVar.b();
                cVar2.a = cVar.b();
                cVar2.b = cVar.b();
                cVar2.f979c = cVar.b();
                cVar2.d = cVar.b();
                cVar2.e = cVar.b();
                cVar2.f = cVar.b();
                this.d[i3] = cVar2;
            }
        }
    }

    private static boolean g() {
        String property = System.getProperty("java.vm.version");
        return property != null && property.startsWith("2");
    }

    final boolean a() {
        return this.b[0] == a[0];
    }

    final char b() {
        return this.b[4];
    }

    final char c() {
        return this.b[5];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.g.close();
    }

    public final boolean d() {
        return b() == 2;
    }

    public final boolean e() {
        return c() == 1;
    }

    public static boolean b(File file) {
        if (!g() || !a(file)) {
            return true;
        }
        try {
            new e(file);
            return true;
        } catch (IOException e) {
            Log.e("ELF", "checkElfFile IOException: " + e);
            return false;
        } catch (UnknownFormatConversionException e2) {
            Log.e("ELF", "checkElfFile UnknownFormatConversionException: " + e2);
            return true;
        } catch (Throwable th) {
            Log.e("ELF", "checkElfFile Throwable: " + th);
            return true;
        }
    }

    public final k a(String str) {
        for (k kVar : this.i) {
            if (str.equals(a(kVar.g))) {
                return kVar;
            }
        }
        return null;
    }

    public final String a(int i2) {
        if (i2 == 0) {
            return "SHN_UNDEF";
        }
        int i3 = i2;
        while (this.j[i3] != 0) {
            i3++;
        }
        return new String(this.j, i2, i3 - i2);
    }

    public static boolean a(File file) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            long readInt = randomAccessFile.readInt();
            randomAccessFile.close();
            return readInt == 2135247942;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
