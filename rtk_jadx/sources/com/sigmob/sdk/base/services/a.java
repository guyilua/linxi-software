package com.sigmob.sdk.base.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.utils.FileUtil;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.mta.PointCategory;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a extends BroadcastReceiver {
    private void a(Context context, PackageInfo packageInfo, String str) {
        ae.a((BaseAdUnit) null, PointCategory.APP_INSTALL_MONITOR, packageInfo, str);
    }

    private void a(final Context context, final BaseAdUnit baseAdUnit, PackageInfo packageInfo) {
        com.sigmob.sdk.base.network.g.a(baseAdUnit, com.sigmob.sdk.base.common.a.J);
        ae.a(baseAdUnit, PointCategory.APP_INSTALL_END, packageInfo, "1");
        HashMap hashMap = new HashMap();
        hashMap.put("result", "1");
        BaseBroadcastReceiver.a(context, baseAdUnit.getUuid(), hashMap, IntentActions.ACTION_INTERSTITIAL_INSTALL_END);
        baseAdUnit.setApkPackageName(packageInfo.packageName);
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new Runnable() { // from class: com.sigmob.sdk.base.services.a.1
            @Override // java.lang.Runnable
            public void run() {
                FileUtil.deleteFile(new File(com.sigmob.sdk.base.utils.e.a(context.getApplicationContext()), baseAdUnit.getApkName()).getAbsolutePath());
            }
        });
        TextUtils.isEmpty(baseAdUnit.getDeeplinkUrl());
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0052 A[Catch: all -> 0x01c2, TryCatch #1 {all -> 0x01c2, blocks: (B:3:0x0004, B:10:0x002f, B:12:0x0039, B:14:0x0043, B:16:0x0047, B:17:0x004c, B:19:0x0052, B:21:0x0076, B:23:0x007a, B:27:0x0088, B:30:0x0092, B:34:0x00b1, B:35:0x00b6, B:42:0x00eb, B:44:0x00f3, B:45:0x010b, B:48:0x0145, B:50:0x014d, B:51:0x0163, B:54:0x0169, B:55:0x0180, B:57:0x0188, B:60:0x01a1, B:62:0x01a9, B:63:0x00ba, B:66:0x00c4, B:69:0x00ce, B:72:0x00d6), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0091 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0092 A[Catch: all -> 0x01c2, TRY_LEAVE, TryCatch #1 {all -> 0x01c2, blocks: (B:3:0x0004, B:10:0x002f, B:12:0x0039, B:14:0x0043, B:16:0x0047, B:17:0x004c, B:19:0x0052, B:21:0x0076, B:23:0x007a, B:27:0x0088, B:30:0x0092, B:34:0x00b1, B:35:0x00b6, B:42:0x00eb, B:44:0x00f3, B:45:0x010b, B:48:0x0145, B:50:0x014d, B:51:0x0163, B:54:0x0169, B:55:0x0180, B:57:0x0188, B:60:0x01a1, B:62:0x01a9, B:63:0x00ba, B:66:0x00c4, B:69:0x00ce, B:72:0x00d6), top: B:2:0x0004 }] */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onReceive(android.content.Context r14, android.content.Intent r15) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.services.a.onReceive(android.content.Context, android.content.Intent):void");
    }
}
