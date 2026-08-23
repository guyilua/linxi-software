package com.qumeng.advlib.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a implements _factory {
    public static volatile boolean d = false;
    private static a e;
    private _factory a = null;
    private Context b;

    /* renamed from: c, reason: collision with root package name */
    private final QMConfig f27c;

    private a(@NonNull QMConfig qMConfig) {
        this.f27c = qMConfig;
        this.b = qMConfig.getContext();
        c();
        e = this;
    }

    private boolean a() {
        if (this.a == null) {
            Log.e("ICliFactory", "repeat loadInstance!");
            c();
        }
        if (this.a != null) {
            return true;
        }
        Log.e("ICliFactory", "Instance not present!");
        return false;
    }

    private void b() {
        _factory _factoryVar = (_factory) com.qumeng.advlib.common.b.c().a(_factory.class, this.b, this.f27c, "13.434");
        this.a = _factoryVar;
        if (_factoryVar != null) {
            d = true;
        }
    }

    private void c() {
        if (com.qumeng.advlib.common.b.c().b(_factory.class) == null) {
            Log.i("ICliFactory", "Well, our remote class didn't load yet, invoke _bootstrap() ...");
            f.a.a.a.a.b(this.f27c);
        }
        b();
    }

    @Override // com.qumeng.advlib.core._factory
    public void appListFromClientNotice() {
        if (a()) {
            this.a.appListFromClientNotice();
        }
    }

    @Override // com.qumeng.advlib.core._factory
    public IMultiAdRequest createNativeMultiAdRequest() {
        return (IMultiAdRequest) com.qumeng.advlib.common.b.c().a(IMultiAdRequest.class, new Object[0]);
    }

    @Override // com.qumeng.advlib.core._factory
    public void notifyMsg(int i, Bundle bundle) {
        if (a()) {
            this.a.notifyMsg(i, bundle);
        }
    }

    @Override // com.qumeng.advlib.core._factory, java.lang.Runnable
    public void run() {
        if (a()) {
            this.a.run();
        }
    }

    @Override // com.qumeng.advlib.core._factory
    public void setAppList(List<PackageInfo> list) {
        if (a()) {
            this.a.setAppList(list);
        }
    }

    @Override // com.qumeng.advlib.core._factory
    public void setImageAutoDownload(boolean z) {
        if (a()) {
            this.a.setImageAutoDownload(z);
        }
    }

    @Override // com.qumeng.advlib.core._factory
    public void terminate() {
        if (a()) {
            this.a.terminate();
        }
    }

    @Override // com.qumeng.advlib.core._factory
    public void useDebugServer(boolean z) {
        if (a()) {
            this.a.useDebugServer(z);
        }
    }

    @Override // com.qumeng.advlib.core._factory
    public void whenPermDialogReturns(int i, String[] strArr, int[] iArr) {
        if (a()) {
            this.a.whenPermDialogReturns(i, strArr, iArr);
        }
    }

    @Override // com.qumeng.advlib.core._factory
    public void useDebugServer(int i) {
        if (a()) {
            this.a.useDebugServer(i);
        }
    }

    public static a a(QMConfig qMConfig) {
        a aVar = e;
        return aVar != null ? aVar : new a(qMConfig);
    }
}
