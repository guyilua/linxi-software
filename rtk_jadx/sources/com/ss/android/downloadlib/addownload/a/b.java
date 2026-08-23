package com.ss.android.downloadlib.addownload.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.k;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class b {
    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.b.a> a(String str, String str2) {
        CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.b.a> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            String string = k.a().getSharedPreferences(str, 0).getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    com.ss.android.downloadlib.addownload.b.a a = com.ss.android.downloadlib.addownload.b.a.a(jSONObject.optJSONObject(keys.next()));
                    if (a != null) {
                        copyOnWriteArrayList.add(a);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return copyOnWriteArrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        k.a().getSharedPreferences(str, 0).edit().putString(str2, "").apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.b.a> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator<com.ss.android.downloadlib.addownload.b.a> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.ss.android.downloadlib.addownload.b.a next = it.next();
                if (next != null) {
                    jSONObject.put(String.valueOf(next.b), next.a());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        k.a().getSharedPreferences(str, 0).edit().putString(str2, jSONObject.toString()).apply();
    }
}
