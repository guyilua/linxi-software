package com.sigmob.sdk.base.network;

import android.text.TextUtils;
import com.czhj.sdk.common.track.AdTracker;
import com.czhj.sdk.common.track.BaseMacroCommon;
import com.czhj.sdk.common.track.TrackManager;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.VolleyError;
import com.sigmob.sdk.Sigmob;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.ah;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.SigMacroCommon;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class g {
    public static void a(AdTracker adTracker, BaseAdUnit baseAdUnit, boolean z) {
        a(adTracker, baseAdUnit, z, true, true, null);
    }

    public static void a(AdTracker adTracker, final BaseAdUnit baseAdUnit, boolean z, boolean z2, final boolean z3, final TrackManager.Listener listener) {
        if (adTracker == null || adTracker.getMessageType() != AdTracker.MessageType.TRACKING_URL) {
            return;
        }
        if (!adTracker.isTracked() || z) {
            String url = adTracker.getUrl();
            final String macroProcess = baseAdUnit != null ? baseAdUnit.getMacroCommon().macroProcess(url, Sigmob.getInstance().getMacroCommon().getMacroMap()) : Sigmob.getInstance().getMacroCommon().macroProcess(url);
            adTracker.setUrl(macroProcess);
            TrackManager.sendTracking(adTracker, (BaseMacroCommon) null, z, z2, new TrackManager.Listener() { // from class: com.sigmob.sdk.base.network.g.1
                public void onErrorResponse(AdTracker adTracker2, VolleyError volleyError) {
                    if (z3) {
                        ae.a(adTracker2, macroProcess, baseAdUnit, volleyError);
                    }
                    TrackManager.Listener listener2 = listener;
                    if (listener2 != null) {
                        listener2.onErrorResponse(adTracker2, volleyError);
                    }
                }

                public void onSuccess(AdTracker adTracker2, NetworkResponse networkResponse) {
                    if (z3) {
                        ae.a(adTracker2, macroProcess, baseAdUnit, networkResponse, (ae.a) null);
                    }
                    TrackManager.Listener listener2 = listener;
                    if (listener2 != null) {
                        listener2.onSuccess(adTracker2, networkResponse);
                    }
                }
            });
        }
    }

    public static void a(BaseAdUnit baseAdUnit, String str) {
        a(baseAdUnit, str, false);
    }

    public static void a(BaseAdUnit baseAdUnit, String str, boolean z) {
        List<ah> adTracker;
        if (str == null || baseAdUnit == null || TextUtils.isEmpty(str) || (adTracker = baseAdUnit.getAdTracker(str)) == null) {
            return;
        }
        for (ah ahVar : adTracker) {
            baseAdUnit.getMacroCommon().addMarcoKey(SigMacroCommon._PLAYFIRSTFRAME_, "1");
            a(ahVar, baseAdUnit, z);
        }
    }

    public static int b(BaseAdUnit baseAdUnit, String str, boolean z) {
        if (baseAdUnit == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str)) {
            return -1;
        }
        List<ah> adTracker = baseAdUnit.getAdTracker(str);
        if (adTracker == null || adTracker.isEmpty()) {
            return -2;
        }
        for (ah ahVar : adTracker) {
            if (z) {
                ahVar.setSource("js");
            }
            baseAdUnit.getMacroCommon().addMarcoKey(SigMacroCommon._PLAYFIRSTFRAME_, "1");
            a((AdTracker) ahVar, baseAdUnit, false);
        }
        return 0;
    }
}
