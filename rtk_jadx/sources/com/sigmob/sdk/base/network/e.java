package com.sigmob.sdk.base.network;

import android.text.TextUtils;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.network.SigmobRequestUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.VolleyError;
import com.sigmob.sdk.base.l;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.windad.WindAdError;
import java.net.URL;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e {

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a(int i, String str, String str2, LoadAdRequest loadAdRequest);

        void a(List<BaseAdUnit> list, LoadAdRequest loadAdRequest);
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface b {
        void a();

        void a(VolleyError volleyError);
    }

    public static void a(LoadAdRequest loadAdRequest, a aVar) {
        if (Networking.getSigRequestQueue() == null) {
            if (aVar != null) {
                aVar.a(WindAdError.ERROR_SIGMOB_NETWORK.getErrorCode(), "request queue is null", null, loadAdRequest);
                return;
            }
            return;
        }
        try {
            String K = loadAdRequest.getAdType() == 5 ? l.a().K() : l.a().p();
            try {
                if (!TextUtils.isEmpty(loadAdRequest.getBidToken())) {
                    K = l.a().q();
                }
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
            }
            if (TextUtils.isEmpty(K)) {
                if (aVar != null) {
                    WindAdError windAdError = WindAdError.ERROR_SIGMOB_BAD_REQUEST;
                    aVar.a(windAdError.getErrorCode(), windAdError.getMessage(), null, loadAdRequest);
                    return;
                }
                return;
            }
            if (SigmobRequestUtil.isConnection(new URL(K).getHost())) {
                Networking.getSigRequestQueue().add(new com.sigmob.sdk.base.network.a(K, loadAdRequest, aVar));
            } else if (aVar != null) {
                aVar.a(WindAdError.ERROR_SIGMOB_NETWORK.getErrorCode(), "network is disconnection", null, loadAdRequest);
            }
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
            if (aVar != null) {
                aVar.a(WindAdError.ERROR_SIGMOB_NETWORK.getErrorCode(), th2.getMessage(), null, loadAdRequest);
            }
        }
    }
}
