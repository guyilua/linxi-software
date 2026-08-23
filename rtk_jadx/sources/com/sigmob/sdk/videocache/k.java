package com.sigmob.sdk.videocache;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class k extends ProxySelector {
    private static final List<Proxy> a = Arrays.asList(Proxy.NO_PROXY);
    private final ProxySelector b;

    /* renamed from: c, reason: collision with root package name */
    private final String f668c;
    private final int d;

    k(ProxySelector proxySelector, String str, int i) {
        this.b = (ProxySelector) o.a(proxySelector);
        this.f668c = (String) o.a(str);
        this.d = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, int i) {
        ProxySelector.setDefault(new k(ProxySelector.getDefault(), str, i));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.b.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return this.f668c.equals(uri.getHost()) && this.d == uri.getPort() ? a : this.b.select(uri);
    }
}
