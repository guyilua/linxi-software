package com.sigmob.sdk.base.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.czhj.sdk.common.utils.Preconditions;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class BaseBroadcastReceiver extends BroadcastReceiver {
    private String a;

    public BaseBroadcastReceiver(String str) {
        this.a = str;
    }

    public static void a(Context context, String str, String str2) {
        a(context, str, null, str2, 0);
    }

    public static void a(Context context, String str, String str2, int i) {
        a(context, str, null, str2, i);
    }

    public static void a(Context context, String str, Map<String, Object> map, String str2) {
        a(context, str, map, str2, 0);
    }

    public static void a(Context context, String str, Map<String, Object> map, String str2, int i) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(str2);
        Intent intent = new Intent(str2);
        intent.putExtra("broadcastIdentifier", str);
        if (map != null) {
            for (String str3 : map.keySet()) {
                try {
                    Object obj = map.get(str3);
                    if (obj instanceof Number) {
                        intent.putExtra(str3, (Number) obj);
                    } else {
                        intent.putExtra(str3, (String) obj);
                    }
                } catch (Throwable unused) {
                }
            }
        }
        ai a = ai.a(context);
        if (a != null) {
            try {
                a.a(intent, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected abstract IntentFilter a();

    public void a(BroadcastReceiver broadcastReceiver) {
        ai a = ai.a(com.sigmob.sdk.b.e());
        if (a != null) {
            try {
                a.a(broadcastReceiver, a());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(Intent intent) {
        Preconditions.NoThrow.checkNotNull(intent);
        String stringExtra = intent.getStringExtra("broadcastIdentifier");
        return !TextUtils.isEmpty(stringExtra) && stringExtra.equalsIgnoreCase(this.a);
    }

    public void b(BroadcastReceiver broadcastReceiver) {
        ai a;
        if (broadcastReceiver == null || (a = ai.a(com.sigmob.sdk.b.e())) == null) {
            return;
        }
        try {
            a.a(broadcastReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
