package com.sigmob.sdk.base.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import java.util.ArrayList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MiMarketManager {
    private static final int a = 0;
    private static final int b = 1;

    /* renamed from: c, reason: collision with root package name */
    private static final int f354c = 2;
    private static final int d = 3;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DirectMailStatusReceiver extends BroadcastReceiver {
        private static final String a = "com.xiaomi.market.DIRECT_MAIL_CHECK_RESULT";
        private static final String b = "com.xiaomi.market.DIRECT_MAIL_STATUS";

        /* renamed from: c, reason: collision with root package name */
        private static final String f355c = "com.xiaomi.market.DIRECT_MAIL_DOWNLOAD_PROGRESS";
        private BaseAdUnit d;

        public void a(Context context, BaseAdUnit baseAdUnit) {
            if (context == null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(a);
            intentFilter.addAction(b);
            intentFilter.addAction(f355c);
            this.d = baseAdUnit;
            u.a(context, this, intentFilter);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i;
            final String string;
            StringBuilder sb;
            String str;
            String action = intent.getAction();
            action.hashCode();
            char c2 = 65535;
            switch (action.hashCode()) {
                case 490579568:
                    if (action.equals(b)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 771983046:
                    if (action.equals(f355c)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1766490962:
                    if (action.equals(a)) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    Bundle extras = intent.getExtras();
                    int i2 = extras.getInt("statusCode");
                    final String string2 = extras.getString("packageName");
                    SigmobLog.d("MiMarketManager: statusCode:" + i2 + " packageName:" + string2);
                    ae.a("mimarket_status", String.valueOf(i2), this.d, new ae.a() { // from class: com.sigmob.sdk.base.common.MiMarketManager.DirectMailStatusReceiver.2
                        @Override // com.sigmob.sdk.base.common.ae.a
                        public void a(Object obj) {
                            if (obj instanceof PointEntitySigmob) {
                                ((PointEntitySigmob) obj).getOptions().put("packageName", string2);
                            }
                        }
                    });
                    return;
                case 1:
                    Bundle extras2 = intent.getExtras();
                    i = extras2.getInt("downloadProgress");
                    string = extras2.getString("packageName");
                    ae.a("mimarket_download_progress", String.valueOf(i), this.d, new ae.a() { // from class: com.sigmob.sdk.base.common.MiMarketManager.DirectMailStatusReceiver.3
                        @Override // com.sigmob.sdk.base.common.ae.a
                        public void a(Object obj) {
                            if (obj instanceof PointEntitySigmob) {
                                ((PointEntitySigmob) obj).getOptions().put("packageName", string);
                            }
                        }
                    });
                    sb = new StringBuilder();
                    str = "MiMarketManager: downloadProgress:";
                    break;
                case 2:
                    Bundle extras3 = intent.getExtras();
                    i = extras3.getInt("styleCheckResult");
                    string = extras3.getString("packageName");
                    ae.a("mimarket_check_result", i == 0 ? "1" : "0", this.d, new ae.a() { // from class: com.sigmob.sdk.base.common.MiMarketManager.DirectMailStatusReceiver.1
                        @Override // com.sigmob.sdk.base.common.ae.a
                        public void a(Object obj) {
                            if (obj instanceof PointEntitySigmob) {
                                ((PointEntitySigmob) obj).getOptions().put("packageName", string);
                            }
                        }
                    });
                    sb = new StringBuilder();
                    str = "MiMarketManager: styleResult:";
                    break;
                default:
                    return;
            }
            sb.append(str);
            sb.append(i);
            sb.append(" packageName:");
            sb.append(string);
            SigmobLog.d(sb.toString());
        }
    }

    public static void a(Context context, ArrayList<String> arrayList) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider/referrer"), null, null, null, null);
            while (cursor != null) {
                if (!cursor.moveToFirst()) {
                    break;
                }
                cursor.getString(0);
                cursor.getString(1);
                cursor.getString(2);
                cursor.getString(3);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static void b(Context context, ArrayList<String> arrayList) {
        ArrayList<Bundle> parcelableArrayList;
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("packageNames", arrayList);
        Bundle call = context.getContentResolver().call(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider/status"), "queryDownloadStatus", (String) null, bundle);
        if (call == null || (parcelableArrayList = call.getParcelableArrayList("packageNames")) == null || parcelableArrayList.size() <= 0) {
            return;
        }
        for (Bundle bundle2 : parcelableArrayList) {
            SigmobLog.d("packageName=" + bundle2.getString("packageName") + ",status=" + bundle2.getInt("status") + ",progress=" + bundle2.getInt(PointCategory.PROGRESS));
        }
    }
}
