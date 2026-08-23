package com.sigmob.sdk.base.network;

import android.text.TextUtils;
import android.util.Base64;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.network.SigmobRequest;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.Cache;
import com.czhj.volley.DefaultRetryPolicy;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.Request;
import com.czhj.volley.Response;
import com.czhj.volley.VolleyError;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.ak;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.windad.WindAdRequest;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b extends SigmobRequest<NetworkResponse> {
    private final a a;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a extends Response.ErrorListener {
        void a(NetworkResponse networkResponse);
    }

    public b(String str, int i, a aVar) {
        super(str, 0, aVar);
        this.a = aVar;
        setShouldRetryServerErrors(true);
        setRetryPolicy(new DefaultRetryPolicy(i, 5000, 0, com.sigmob.sdk.base.blurkit.c.d));
        setShouldCache(false);
    }

    public b(String str, a aVar) {
        this(str, 5000, aVar);
    }

    public static void a(final String str, final String str2, WindAdRequest windAdRequest, final NetworkResponse networkResponse, final String str3) {
        ak.a(PointCategory.HB_TRACKING).a(windAdRequest).a(new ae.a() { // from class: com.sigmob.sdk.base.network.b.2
            @Override // com.sigmob.sdk.base.common.ae.a
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                    pointEntitySigmob.setUrl(str);
                    pointEntitySigmob.setTracking_type(str2);
                    pointEntitySigmob.setRequest_id(str3);
                    NetworkResponse networkResponse2 = networkResponse;
                    if (networkResponse2 != null) {
                        byte[] bArr = networkResponse2.data;
                        pointEntitySigmob.setResponse(bArr != null ? Base64.encodeToString(bArr, 2) : null);
                        pointEntitySigmob.setHttp_code(String.valueOf(networkResponse.statusCode));
                        pointEntitySigmob.setTime_spend(String.valueOf(networkResponse.networkTimeMs));
                        pointEntitySigmob.setContent_type((String) networkResponse.headers.get("Content-Type"));
                        pointEntitySigmob.setContent_length((String) networkResponse.headers.get(com.sigmob.sdk.downloader.core.c.e));
                    }
                }
            }
        }).a();
    }

    public static void a(final String str, final String str2, final WindAdRequest windAdRequest, final String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b bVar = new b(str, new a() { // from class: com.sigmob.sdk.base.network.b.1
            @Override // com.sigmob.sdk.base.network.b.a
            public void a(NetworkResponse networkResponse) {
                b.a(str, str2, windAdRequest, networkResponse, str3);
            }

            public void onErrorResponse(VolleyError volleyError) {
                b.a(str, str2, windAdRequest, volleyError != null ? volleyError.networkResponse : null, str3);
            }
        });
        if (Networking.getSigRequestQueue() != null) {
            Networking.getSigRequestQueue().add(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void deliverResponse(NetworkResponse networkResponse) {
        a aVar;
        synchronized (((Request) this).mLock) {
            aVar = this.a;
        }
        SigmobLog.i("send tracking: " + getUrl() + " success");
        if (aVar != null) {
            aVar.a(networkResponse);
        }
    }

    public void deliverError(VolleyError volleyError) {
        SigmobLog.e("send tracking: " + getUrl() + " fail");
        super/*com.czhj.volley.Request*/.deliverError(volleyError);
    }

    public int getMaxLength() {
        return 100;
    }

    protected Response<NetworkResponse> parseNetworkResponse(NetworkResponse networkResponse) {
        return Response.success(networkResponse, (Cache.Entry) null);
    }
}
