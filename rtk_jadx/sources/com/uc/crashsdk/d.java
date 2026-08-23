package com.uc.crashsdk;

import android.os.Bundle;
import android.webkit.ValueCallback;
import com.uc.crashsdk.export.ICrashClient;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class d {
    private static ICrashClient a = null;
    private static int b = 3;

    /* renamed from: c, reason: collision with root package name */
    private static volatile List<ValueCallback<Bundle>> f1000c;
    private static volatile List<ValueCallback<Bundle>> d;
    private static volatile List<ValueCallback<Bundle>> e;
    private static volatile List<ValueCallback<Bundle>> f;
    private static final Object g = new Object();

    public static void a(ICrashClient iCrashClient) {
        a = iCrashClient;
    }

    public static boolean b(ValueCallback<Bundle> valueCallback) {
        if (d == null) {
            synchronized (g) {
                if (d == null) {
                    d = new ArrayList();
                }
            }
        }
        synchronized (d) {
            if (d.size() >= b) {
                return false;
            }
            d.add(valueCallback);
            return true;
        }
    }

    public static boolean c(ValueCallback<Bundle> valueCallback) {
        if (e == null) {
            synchronized (g) {
                if (e == null) {
                    e = new ArrayList();
                }
            }
        }
        synchronized (e) {
            if (e.size() >= b) {
                return false;
            }
            e.add(valueCallback);
            return true;
        }
    }

    public static boolean d(ValueCallback<Bundle> valueCallback) {
        if (f == null) {
            synchronized (g) {
                if (f == null) {
                    f = new ArrayList();
                }
            }
        }
        synchronized (f) {
            if (f.size() >= b) {
                return false;
            }
            f.add(valueCallback);
            return true;
        }
    }

    public static void a(String str, String str2, String str3) {
        if (com.uc.crashsdk.a.g.a(str)) {
            com.uc.crashsdk.a.a.a("crashsdk", "onLogGenerated file name is null!", null);
            return;
        }
        boolean equals = e.h().equals(str2);
        if (a != null) {
            File file = new File(str);
            try {
                if (equals) {
                    a.onLogGenerated(file, str3);
                } else {
                    a.onClientProcessLogGenerated(str2, file, str3);
                }
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        List<ValueCallback<Bundle>> list = f1000c;
        if (!equals) {
            list = d;
        }
        if (list != null) {
            synchronized (list) {
                for (ValueCallback<Bundle> valueCallback : list) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString("filePathName", str);
                        if (!equals) {
                            bundle.putString("processName", str2);
                        }
                        bundle.putString("logType", str3);
                        valueCallback.onReceiveValue(bundle);
                    } catch (Throwable th2) {
                        com.uc.crashsdk.a.g.a(th2);
                    }
                }
            }
        }
    }

    public static File a(File file) {
        ICrashClient iCrashClient = a;
        if (iCrashClient != null) {
            try {
                return iCrashClient.onBeforeUploadLog(file);
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        return file;
    }

    public static void a(boolean z) {
        ICrashClient iCrashClient = a;
        if (iCrashClient != null) {
            try {
                iCrashClient.onCrashRestarting(z);
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        if (e != null) {
            synchronized (e) {
                for (ValueCallback<Bundle> valueCallback : e) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("isJava", z);
                        valueCallback.onReceiveValue(bundle);
                    } catch (Throwable th2) {
                        com.uc.crashsdk.a.g.a(th2);
                    }
                }
            }
        }
    }

    public static void a(String str, int i, int i2) {
        ICrashClient iCrashClient = a;
        if (iCrashClient != null) {
            iCrashClient.onAddCrashStats(str, i, i2);
        }
        if (f != null) {
            synchronized (f) {
                for (ValueCallback<Bundle> valueCallback : f) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString("processName", str);
                        bundle.putInt("key", i);
                        bundle.putInt("count", i2);
                        valueCallback.onReceiveValue(bundle);
                    } catch (Throwable th) {
                        com.uc.crashsdk.a.g.a(th);
                    }
                }
            }
        }
    }

    public static String a(String str, boolean z) {
        ICrashClient iCrashClient = a;
        return iCrashClient != null ? iCrashClient.onGetCallbackInfo(str, z) : "";
    }

    public static boolean a(ValueCallback<Bundle> valueCallback) {
        if (f1000c == null) {
            synchronized (g) {
                if (f1000c == null) {
                    f1000c = new ArrayList();
                }
            }
        }
        synchronized (f1000c) {
            if (f1000c.size() >= b) {
                return false;
            }
            f1000c.add(valueCallback);
            return true;
        }
    }
}
