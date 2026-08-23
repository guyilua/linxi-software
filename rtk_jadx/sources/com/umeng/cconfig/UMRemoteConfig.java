package com.umeng.cconfig;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.text.TextUtils;
import com.umeng.analytics.pro.ak;
import com.umeng.analytics.pro.e;
import com.umeng.cconfig.b.c;
import com.umeng.cconfig.b.d;
import com.umeng.cconfig.b.e;
import com.umeng.cconfig.c.b;
import com.umeng.cconfig.listener.OnConfigStatusChangedListener;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UMRemoteConfig {
    private int g;
    private RemoteConfigSettings h;
    private OnConfigStatusChangedListener i;
    private final ReadWriteLock j;
    public static final Pattern a = Pattern.compile("^[a-zA-Z_][a-zA-Z0-9_]{1,255}");

    /* renamed from: c, reason: collision with root package name */
    private static Context f1072c = null;
    private static Map<String, c> d = new HashMap();
    private static Map<String, c> e = new HashMap();
    private static Map<String, String> f = new HashMap();
    public static boolean b = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        private static final UMRemoteConfig a = new UMRemoteConfig(0);
    }

    private UMRemoteConfig() {
        this.j = new ReentrantReadWriteLock(true);
    }

    /* synthetic */ UMRemoteConfig(byte b2) {
        this();
    }

    private void a(Context context, int i) {
        if (context == null || i <= 0) {
            return;
        }
        try {
            try {
                try {
                    try {
                        this.j.writeLock().lock();
                        XmlResourceParser xml = context.getResources().getXml(i);
                        String str = null;
                        String str2 = null;
                        String str3 = null;
                        for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                            if (eventType == 2) {
                                str = xml.getName();
                            } else if (eventType == 3) {
                                if ("entry".equals(xml.getName()) && str2 != null && str3 != null) {
                                    if (a.matcher(str2.trim()).matches()) {
                                        f.put(str2, str3);
                                        c cVar = new c();
                                        cVar.a = str2;
                                        cVar.b = str3;
                                        e.put(str2, cVar);
                                        str2 = null;
                                        str3 = null;
                                    }
                                    if (f.size() > 1000) {
                                        break;
                                    }
                                }
                                str = null;
                            } else if (eventType == 4) {
                                if ("key".equals(str)) {
                                    str2 = xml.getText();
                                } else if ("value".equals(str)) {
                                    str3 = xml.getText();
                                }
                            }
                        }
                    } catch (XmlPullParserException unused) {
                        ULog.e("jessie", "[xmlLoad] xml load fail");
                    }
                } catch (IOException unused2) {
                    ULog.e("jessie", "[xmlLoad] xml load fail");
                }
            } catch (Exception unused3) {
                ULog.e("jessie", "[xmlLoad] xml load fail");
            }
        } finally {
            this.j.writeLock().unlock();
        }
    }

    private void a(d dVar) {
        if (dVar != null) {
            String str = dVar.b;
            try {
                try {
                    this.j.writeLock().lock();
                    if (!TextUtils.isEmpty(str)) {
                        JSONArray jSONArray = new JSONArray(str);
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            JSONObject jSONObject = new JSONObject(jSONArray.getString(i));
                            try {
                                String str2 = "";
                                c cVar = new c();
                                if (jSONObject.has("k")) {
                                    str2 = jSONObject.getString("k");
                                    cVar.a = str2;
                                }
                                if (jSONObject.has(ak.aE)) {
                                    cVar.b = jSONObject.getString(ak.aE);
                                }
                                if (jSONObject.has("e")) {
                                    cVar.f1076c = jSONObject.getString("e");
                                }
                                if (jSONObject.has("g")) {
                                    cVar.d = jSONObject.getString("g");
                                }
                                if (!TextUtils.isEmpty(str2)) {
                                    e.put(jSONObject.getString("k"), cVar);
                                }
                            } catch (Exception unused) {
                                ULog.e("jessie", "[active] new config active false");
                            }
                        }
                    }
                    d.clear();
                    d.putAll(e);
                    e.clear();
                    ULog.i("jessie", "[active] new config active success i");
                } catch (Exception unused2) {
                    ULog.e("jessie", "[active] new config active false");
                }
            } finally {
                this.j.writeLock().unlock();
            }
        } else {
            try {
                this.j.writeLock().lock();
                d.clear();
                d.putAll(e);
                e.clear();
                ULog.i("[active] new config active success ii");
            } catch (Exception unused3) {
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static UMRemoteConfig getInstance() {
        return a.a;
    }

    public static String getVersion() {
        return "1.0.0";
    }

    public void activeFetchConfig() {
        if (!b) {
            MLog.d("ucc", "remote config disable");
            return;
        }
        Context context = f1072c;
        if (context == null) {
            MLog.d("ucc", "UMRemoteConfig did not init");
        } else if (!UMUtils.isMainProgress(context)) {
            MLog.d("ucc", "can not be called in child process");
        } else {
            try {
                new com.umeng.cconfig.d.a(f1072c).run();
            } catch (Exception unused) {
            }
        }
    }

    public String getConfigValue(String str) {
        String str2 = null;
        if (!b) {
            MLog.d("ucc", "remote config disable");
            return null;
        }
        Context context = f1072c;
        if (context == null) {
            MLog.d("ucc", "UMRemoteConfig did not init");
            return null;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.d("ucc", "can not be called in child process");
            return null;
        }
        try {
            this.j.readLock().lock();
            c cVar = d.get(str);
            if (cVar != null) {
                str2 = cVar.b;
                if (!TextUtils.isEmpty(cVar.d)) {
                    JSONArray a2 = e.a(cVar, f1072c);
                    ULog.d("jessie", "[ablog] ablog params : " + a2.toString());
                    if (a2 != null) {
                        com.umeng.cconfig.c.c.a(new b("https://pslog.umeng.com/ablog", a2));
                    }
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.j.readLock().unlock();
            throw th;
        }
        this.j.readLock().unlock();
        return str2;
    }

    public void handlerMessage(int i, Object obj, String str) {
        SharedPreferences a2;
        OnConfigStatusChangedListener onConfigStatusChangedListener;
        try {
            if (i == 1) {
                String str2 = (String) obj;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                try {
                    this.j.writeLock().lock();
                    JSONObject jSONObject = new JSONObject(str2);
                    String string = jSONObject.has("cc") ? jSONObject.getString("cc") : "";
                    String string2 = jSONObject.has("ts") ? jSONObject.getString("ts") : "";
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                        com.umeng.cconfig.a.b a3 = com.umeng.cconfig.a.b.a(f1072c);
                        try {
                            try {
                                try {
                                    a3.a();
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("__ts", string2);
                                    contentValues.put(e.d.a.d, string);
                                    contentValues.put("__a", "0");
                                    ULog.i("jessie", "[DbManager] insert timeStamp: " + string2 + " content: " + string + " active: 0");
                                    a3.a.insert("__cc", null, contentValues);
                                    a3.a.setTransactionSuccessful();
                                    SQLiteDatabase sQLiteDatabase = a3.a;
                                    if (sQLiteDatabase != null) {
                                        sQLiteDatabase.endTransaction();
                                    }
                                } catch (Throwable th) {
                                    try {
                                        SQLiteDatabase sQLiteDatabase2 = a3.a;
                                        if (sQLiteDatabase2 != null) {
                                            sQLiteDatabase2.endTransaction();
                                        }
                                    } catch (Throwable unused) {
                                    }
                                    a3.b();
                                    throw th;
                                }
                            } catch (SQLiteDatabaseCorruptException unused2) {
                                ULog.i("jessie", "[DbManager] insert failed");
                                SQLiteDatabase sQLiteDatabase3 = a3.a;
                                if (sQLiteDatabase3 != null) {
                                    sQLiteDatabase3.endTransaction();
                                }
                            } catch (Throwable unused3) {
                                SQLiteDatabase sQLiteDatabase4 = a3.a;
                                if (sQLiteDatabase4 != null) {
                                    sQLiteDatabase4.endTransaction();
                                }
                            }
                        } catch (Throwable unused4) {
                        }
                        a3.b();
                        com.umeng.cconfig.a.b.a(f1072c).d();
                        MLog.i("ucc", "get new config success");
                        RemoteConfigSettings remoteConfigSettings = this.h;
                        if (remoteConfigSettings != null) {
                            if (remoteConfigSettings.isAutoUpdateModeEnabled()) {
                                activeFetchConfig();
                            } else {
                                OnConfigStatusChangedListener onConfigStatusChangedListener2 = this.i;
                                if (onConfigStatusChangedListener2 != null) {
                                    onConfigStatusChangedListener2.onFetchComplete();
                                }
                            }
                        }
                    }
                } finally {
                }
            } else if (i == 2) {
                try {
                    this.j.writeLock().lock();
                    if (TextUtils.isEmpty((String) obj) && !TextUtils.isEmpty(str) && (a2 = com.umeng.cconfig.a.c.a(f1072c)) != null) {
                        SharedPreferences.Editor edit = a2.edit();
                        edit.putString("abtest_sp_last_request_data", str);
                        edit.commit();
                    }
                } finally {
                }
            } else {
                if (i != 3) {
                    return;
                }
                try {
                    this.j.writeLock().lock();
                    if (((Boolean) obj).booleanValue()) {
                        a(f1072c, this.g);
                        a(com.umeng.cconfig.a.b.a(f1072c).c());
                        MLog.i("ucc", "active new config success");
                        if (this.h != null && (onConfigStatusChangedListener = this.i) != null) {
                            onConfigStatusChangedListener.onActiveComplete();
                        }
                    }
                } finally {
                }
            }
        } catch (Exception unused5) {
        }
    }

    public void init(Context context) {
        try {
            if (!b) {
                MLog.d("ucc", "remote config disable");
                return;
            }
            if (context == null) {
                return;
            }
            if (f1072c == null) {
                f1072c = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(context)) {
                MLog.d("ucc", "can not be called in child process");
            } else {
                if (this.h == null) {
                    MLog.d("ucc", "please set RemoteConfigSettings using UMRemoteConfig.getInstance().setConfigSettings");
                    return;
                }
                a(f1072c, this.g);
                a(com.umeng.cconfig.a.b.a(f1072c).c());
                ImprintHandler.getImprintService(f1072c).registImprintCallback("ucc", new UMImprintChangeCallback() { // from class: com.umeng.cconfig.UMRemoteConfig.1
                    @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
                    public final void onImprintValueChanged(String str, String str2) {
                        SharedPreferences a2;
                        try {
                            if ("ucc".equals(str)) {
                                ULog.i("jessie", "[imprint] key: " + str + " value: " + str2);
                                String[] split = str2.split("@");
                                String str3 = split[3];
                                if (TextUtils.isEmpty(str3) || !"1".equals(str3)) {
                                    return;
                                }
                                String str4 = split[0];
                                if (TextUtils.isEmpty(str4) || (a2 = com.umeng.cconfig.a.c.a(UMRemoteConfig.f1072c)) == null) {
                                    return;
                                }
                                String string = a2.getString("cconfig_sp_last_request_time", "");
                                if (!TextUtils.isEmpty(string) && str4.equals(string)) {
                                    ULog.i("jessie", "[imprint] newTimeStamp.equals(oldTimeStamp)");
                                    return;
                                }
                                SharedPreferences.Editor edit = a2.edit();
                                edit.putString("cconfig_sp_last_request_time", str4);
                                edit.commit();
                                JSONObject a3 = com.umeng.cconfig.b.e.a(UMRemoteConfig.f1072c);
                                if (a3 != null) {
                                    try {
                                        ULog.i("jessie", "[imprint] send request. body: " + a3.toString());
                                        com.umeng.cconfig.c.c.a(new b("https://ucc.umeng.com/v1/fetch", a3));
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                        } catch (Exception unused2) {
                            ULog.e("jessie", "[imprint] fail");
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized void setConfigSettings(RemoteConfigSettings remoteConfigSettings) {
        if (!b) {
            MLog.d("ucc", "remote config disable");
        } else {
            if (remoteConfigSettings != null) {
                this.h = remoteConfigSettings;
            }
        }
    }

    public synchronized void setDefaults(int i) {
        if (b) {
            this.g = i;
        } else {
            MLog.d("ucc", "remote config disable");
        }
    }

    public synchronized void setOnNewConfigfecthed(OnConfigStatusChangedListener onConfigStatusChangedListener) {
        if (!b) {
            MLog.d("ucc", "remote config disable");
        } else {
            if (onConfigStatusChangedListener != null) {
                this.i = onConfigStatusChangedListener;
            }
        }
    }
}
