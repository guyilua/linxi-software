package com.tencent.smtt.export.external;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DexClassLoaderProviderService extends Service {
    private static final String LOGTAG = "dexloader";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d(LOGTAG, "DexClassLoaderProviderService -- onCreate()");
        DexClassLoaderProvider.setForceLoadDexFlag(true, this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.d(LOGTAG, "DexClassLoaderProviderService -- onDestroy()");
        System.exit(0);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        ArrayList<String> stringArrayListExtra;
        Log.d(LOGTAG, "DexClassLoaderProviderService -- onStartCommand(" + intent + ")");
        if (intent == null) {
            return 1;
        }
        try {
            stringArrayListExtra = intent.getStringArrayListExtra("dex2oat");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (stringArrayListExtra == null) {
            return 1;
        }
        String str = stringArrayListExtra.get(0);
        String str2 = stringArrayListExtra.get(1);
        String str3 = stringArrayListExtra.get(2);
        String str4 = stringArrayListExtra.get(3);
        Log.d(LOGTAG, "DexClassLoaderProviderService -- onStartCommand(" + str + ")");
        ClassLoader classLoader = getClassLoader();
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        DexClassLoaderProvider.createDexClassLoader(str2, str3, str4, classLoader, getApplicationContext());
        return 1;
    }
}
