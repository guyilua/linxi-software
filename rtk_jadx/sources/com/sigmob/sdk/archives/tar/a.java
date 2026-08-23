package com.sigmob.sdk.archives.tar;

import com.tencent.smtt.sdk.TbsListener;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.Locale;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a implements com.sigmob.sdk.archives.a, e {
    public static final int b = 31;

    /* renamed from: c, reason: collision with root package name */
    public static final int f343c = 16877;
    public static final int d = 33188;
    public static final int e = 1000;
    private String ac;
    private int ad;
    private int ae;
    private int af;
    private long ag;
    private long ah;
    private byte ai;
    private String aj;
    private String ak;
    private String al;
    private String am;
    private String an;
    private int ao;
    private int ap;
    private boolean aq;
    private long ar;
    private File as;

    private a() {
        this.ak = "ustar\u0000";
        this.al = e.V;
        this.ac = "";
        this.aj = "";
        String property = System.getProperty("user.name", "");
        property = property.length() > 31 ? property.substring(0, 31) : property;
        this.ae = 0;
        this.af = 0;
        this.am = property;
        this.an = "";
        this.as = null;
    }

    public a(File file) {
        this(file, a(file.getPath(), false));
    }

    public a(File file, String str) {
        this();
        this.as = file;
        this.aj = "";
        if (file.isDirectory()) {
            this.ad = f343c;
            this.ai = e.M;
            int length = str.length();
            if (length == 0 || str.charAt(length - 1) != '/') {
                str = str + "/";
            }
            this.ac = str;
            this.ag = 0L;
        } else {
            this.ad = d;
            this.ai = e.H;
            this.ag = file.length();
            this.ac = str;
        }
        this.ah = file.lastModified() / 1000;
        this.ao = 0;
        this.ap = 0;
    }

    public a(String str) {
        this(str, false);
    }

    public a(String str, byte b2) {
        this(str);
        this.ai = b2;
        if (b2 == 76) {
            this.ak = e.W;
            this.al = e.X;
        }
    }

    public a(String str, boolean z) {
        this();
        String a = a(str, z);
        boolean endsWith = a.endsWith("/");
        this.ao = 0;
        this.ap = 0;
        this.ac = a;
        this.ad = endsWith ? f343c : d;
        this.ai = endsWith ? e.M : e.H;
        this.ae = 0;
        this.af = 0;
        this.ag = 0L;
        this.ah = new Date().getTime() / 1000;
        this.aj = "";
        this.am = "";
        this.an = "";
        this.ao = 0;
        this.ap = 0;
    }

    public a(byte[] bArr) {
        this();
        b(bArr);
    }

    private static String a(String str, boolean z) {
        int indexOf;
        String lowerCase = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
        if (lowerCase != null) {
            if (lowerCase.startsWith("windows")) {
                if (str.length() > 2) {
                    char charAt = str.charAt(0);
                    if (str.charAt(1) == ':' && ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z'))) {
                        str = str.substring(2);
                    }
                }
            } else if (lowerCase.indexOf("netware") > -1 && (indexOf = str.indexOf(58)) != -1) {
                str = str.substring(indexOf + 1);
            }
        }
        String replace = str.replace(File.separatorChar, '/');
        while (!z && replace.startsWith("/")) {
            replace = replace.substring(1);
        }
        return replace;
    }

    private int c(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, e.n, 6);
        if (wrap.compareTo(ByteBuffer.wrap(e.W.getBytes())) == 0) {
            return 2;
        }
        return wrap.compareTo(ByteBuffer.wrap("ustar\u0000".getBytes())) == 0 ? 3 : 0;
    }

    @Override // com.sigmob.sdk.archives.a
    public String a() {
        return this.ac.toString();
    }

    public void a(int i) {
        this.ad = i;
    }

    public void a(int i, int i2) {
        b(i);
        c(i2);
    }

    public void a(long j) {
        this.ah = j / 1000;
    }

    public void a(String str) {
        this.ac = a(str, false);
    }

    public void a(String str, String str2) {
        c(str);
        d(str2);
    }

    public void a(Date date) {
        this.ah = date.getTime() / 1000;
    }

    public void a(byte[] bArr) {
        int c2 = f.c(this.ah, bArr, f.c(this.ag, bArr, f.b(this.af, bArr, f.b(this.ae, bArr, f.b(this.ad, bArr, f.a(this.ac, bArr, 0, 100), 8), 8), 8), 12), 12);
        int i = c2;
        int i2 = 0;
        while (i2 < 8) {
            bArr[i] = 32;
            i2++;
            i++;
        }
        bArr[i] = this.ai;
        for (int b2 = f.b(this.ap, bArr, f.b(this.ao, bArr, f.a(this.an, bArr, f.a(this.am, bArr, f.a(this.al, bArr, f.a(this.ak, bArr, f.a(this.aj, bArr, i + 1, 100), 6), 2), 32), 32), 8), 8); b2 < bArr.length; b2++) {
            bArr[b2] = 0;
        }
        f.d(f.a(bArr), bArr, c2, 8);
    }

    public boolean a(a aVar) {
        return a().equals(aVar.a());
    }

    @Override // com.sigmob.sdk.archives.a
    public long b() {
        return this.ag;
    }

    public void b(int i) {
        this.ae = i;
    }

    public void b(long j) {
        if (j <= e.m && j >= 0) {
            this.ag = j;
            return;
        }
        throw new IllegalArgumentException("Size is out of range: " + j);
    }

    public void b(String str) {
        this.aj = str;
    }

    public void b(byte[] bArr) {
        this.ac = f.b(bArr, 0, 100);
        this.ad = (int) f.a(bArr, 100, 8);
        this.ae = (int) f.a(bArr, 108, 8);
        this.af = (int) f.a(bArr, 116, 8);
        this.ag = f.a(bArr, 124, 12);
        this.ah = f.a(bArr, 136, 12);
        this.ai = bArr[156];
        this.aj = f.b(bArr, 157, 100);
        this.ak = f.b(bArr, e.n, 6);
        this.al = f.b(bArr, e.p, 2);
        this.am = f.b(bArr, 265, 32);
        this.an = f.b(bArr, 297, 32);
        this.ao = (int) f.a(bArr, TbsListener.ErrorCode.ERROR_GETSTRINGARRAY_JARFILE, 8);
        this.ap = (int) f.a(bArr, 337, 8);
        if (c(bArr) == 2) {
            this.aq = f.a(bArr, 482);
            this.ar = f.a(bArr, 483, 12);
            return;
        }
        String b2 = f.b(bArr, 345, e.v);
        if (c() && !this.ac.endsWith("/")) {
            this.ac += "/";
        }
        if (b2.length() > 0) {
            this.ac = b2 + "/" + this.ac;
        }
    }

    public boolean b(a aVar) {
        return aVar.a().startsWith(a());
    }

    public void c(int i) {
        this.af = i;
    }

    public void c(String str) {
        this.am = str;
    }

    @Override // com.sigmob.sdk.archives.a
    public boolean c() {
        File file = this.as;
        if (file != null) {
            return file.isDirectory();
        }
        if (this.ai == 53) {
            return true;
        }
        return a().endsWith("/");
    }

    @Override // com.sigmob.sdk.archives.a
    public Date d() {
        return j();
    }

    public void d(String str) {
        this.an = str;
    }

    public String e() {
        return this.aj.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return a((a) obj);
    }

    public int f() {
        return this.ae;
    }

    public int g() {
        return this.af;
    }

    public String h() {
        return this.am.toString();
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String i() {
        return this.an.toString();
    }

    public Date j() {
        return new Date(this.ah * 1000);
    }

    public File k() {
        return this.as;
    }

    public int l() {
        return this.ad;
    }

    public boolean m() {
        return this.aq;
    }

    public long n() {
        return this.ar;
    }

    public boolean o() {
        return this.ai == 83;
    }

    public boolean p() {
        return this.ai == 76 && this.ac.toString().equals(e.ab);
    }

    public boolean q() {
        byte b2 = this.ai;
        return b2 == 120 || b2 == 88;
    }

    public boolean r() {
        return this.ai == 103;
    }

    public boolean s() {
        File file = this.as;
        if (file != null) {
            return file.isFile();
        }
        byte b2 = this.ai;
        if (b2 == 0 || b2 == 48) {
            return true;
        }
        return !a().endsWith("/");
    }

    public boolean t() {
        return this.ai == 50;
    }

    public boolean u() {
        return this.ai == 49;
    }

    public boolean v() {
        return this.ai == 51;
    }

    public boolean w() {
        return this.ai == 52;
    }

    public boolean x() {
        return this.ai == 54;
    }

    public a[] y() {
        File file = this.as;
        if (file == null || !file.isDirectory()) {
            return new a[0];
        }
        String[] list = this.as.list();
        a[] aVarArr = new a[list.length];
        for (int i = 0; i < list.length; i++) {
            aVarArr[i] = new a(new File(this.as, list[i]));
        }
        return aVarArr;
    }
}
