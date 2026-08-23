package com.sigmob.sdk.downloader.core.download;

import com.sigmob.sdk.downloader.core.connection.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c {
    private static final String a = "ConnectTrial";
    private static final Pattern i = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
    private static final Pattern j = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
    private final com.sigmob.sdk.downloader.f b;

    /* renamed from: c, reason: collision with root package name */
    private final com.sigmob.sdk.downloader.core.breakpoint.c f530c;
    private boolean d;
    private long e;
    private String f;
    private String g;
    private int h;

    public c(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        this.b = fVar;
        this.f530c = cVar;
    }

    private static String a(String str) {
        String group;
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = i.matcher(str);
            if (matcher.find()) {
                group = matcher.group(1);
            } else {
                Matcher matcher2 = j.matcher(str);
                group = matcher2.find() ? matcher2.group(1) : null;
            }
            if (group != null && group.contains("../")) {
                throw new com.sigmob.sdk.downloader.core.exception.a("The filename [" + group + "] from the response is not allowable, because it contains '../', which can raise the directory traversal vulnerability");
            }
            return group;
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    private static boolean a(a.InterfaceC0041a interfaceC0041a) {
        if (interfaceC0041a.d() == 206) {
            return true;
        }
        return "bytes".equals(interfaceC0041a.c(com.sigmob.sdk.downloader.core.c.i));
    }

    private static String b(a.InterfaceC0041a interfaceC0041a) {
        return a(interfaceC0041a.c(com.sigmob.sdk.downloader.core.c.j));
    }

    private static boolean b(String str) {
        return str != null && str.equals("chunked");
    }

    private static long c(String str) {
        if (str == null) {
            return -1L;
        }
        String[] split = str.split("/");
        if (split.length >= 2) {
            try {
                return Long.parseLong(split[1]);
            } catch (NumberFormatException unused) {
                com.sigmob.sdk.downloader.core.c.a(a, "parse instance length failed with " + str);
            }
        }
        return -1L;
    }

    private static String c(a.InterfaceC0041a interfaceC0041a) {
        return interfaceC0041a.c(com.sigmob.sdk.downloader.core.c.g);
    }

    private static long d(a.InterfaceC0041a interfaceC0041a) {
        long c2 = c(interfaceC0041a.c(com.sigmob.sdk.downloader.core.c.f));
        if (c2 != -1) {
            return c2;
        }
        if (!b(interfaceC0041a.c(com.sigmob.sdk.downloader.core.c.h))) {
            com.sigmob.sdk.downloader.core.c.a(a, "Transfer-Encoding isn't chunked but there is no valid instance length found either!");
        }
        return -1L;
    }

    public void a() {
        com.sigmob.sdk.downloader.g.j().g().b(this.b);
        com.sigmob.sdk.downloader.g.j().g().b();
        com.sigmob.sdk.downloader.core.connection.a a2 = com.sigmob.sdk.downloader.g.j().d().a(this.b.i());
        try {
            if (!com.sigmob.sdk.downloader.core.c.a((CharSequence) this.f530c.k())) {
                a2.a(com.sigmob.sdk.downloader.core.c.f508c, this.f530c.k());
            }
            a2.a(com.sigmob.sdk.downloader.core.c.b, "bytes=0-0");
            Map<String, List<String>> b = this.b.b();
            if (b != null) {
                com.sigmob.sdk.downloader.core.c.a(b, a2);
            }
            com.sigmob.sdk.downloader.c a3 = com.sigmob.sdk.downloader.g.j().b().a();
            a3.a(this.b, a2.c());
            a.InterfaceC0041a a4 = a2.a();
            this.b.a(a4.g());
            com.sigmob.sdk.downloader.core.c.b(a, "task[" + this.b.c() + "] redirect location: " + this.b.j());
            this.h = a4.d();
            this.d = a(a4);
            this.e = d(a4);
            this.f = c(a4);
            this.g = b(a4);
            Map<String, List<String>> f = a4.f();
            if (f == null) {
                f = new HashMap<>();
            }
            a3.a(this.b, this.h, f);
            if (a(this.e, a4)) {
                i();
            }
        } finally {
            a2.b();
        }
    }

    boolean a(long j2, a.InterfaceC0041a interfaceC0041a) {
        String c2;
        if (j2 != -1) {
            return false;
        }
        String c3 = interfaceC0041a.c(com.sigmob.sdk.downloader.core.c.f);
        return (c3 == null || c3.length() <= 0) && !b(interfaceC0041a.c(com.sigmob.sdk.downloader.core.c.h)) && (c2 = interfaceC0041a.c(com.sigmob.sdk.downloader.core.c.e)) != null && c2.length() > 0;
    }

    public long b() {
        return this.e;
    }

    public boolean c() {
        return this.d;
    }

    public boolean d() {
        return this.e == -1;
    }

    public String e() {
        return this.f;
    }

    public String f() {
        return this.g;
    }

    public int g() {
        return this.h;
    }

    public boolean h() {
        return (this.f530c.k() == null || this.f530c.k().equals(this.f)) ? false : true;
    }

    void i() {
        com.sigmob.sdk.downloader.core.connection.a a2 = com.sigmob.sdk.downloader.g.j().d().a(this.b.i());
        com.sigmob.sdk.downloader.c a3 = com.sigmob.sdk.downloader.g.j().b().a();
        try {
            a2.a(com.sigmob.sdk.downloader.core.c.a);
            Map<String, List<String>> b = this.b.b();
            if (b != null) {
                com.sigmob.sdk.downloader.core.c.a(b, a2);
            }
            a3.a(this.b, a2.c());
            a.InterfaceC0041a a4 = a2.a();
            a3.a(this.b, a4.d(), a4.f());
            this.e = com.sigmob.sdk.downloader.core.c.b(a4.c(com.sigmob.sdk.downloader.core.c.e));
        } finally {
            a2.b();
        }
    }
}
