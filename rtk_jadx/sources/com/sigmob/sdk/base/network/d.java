package com.sigmob.sdk.base.network;

import android.text.TextUtils;
import android.util.Base64;
import com.czhj.sdk.common.json.JSONSerializer;
import com.czhj.sdk.common.network.SigmobRequest;
import com.czhj.sdk.common.utils.AESUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.DefaultRetryPolicy;
import com.czhj.volley.Response;
import com.czhj.volley.VolleyError;
import com.sigmob.sdk.base.models.rtb.BidResponse;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d extends SigmobRequest {
    private a a;
    private byte[] b;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a extends Response.ErrorListener {
        void a(JSONObject jSONObject);
    }

    public d(String str, BidResponse bidResponse, a aVar) {
        super(str, 1, aVar);
        this.a = aVar;
        setRetryPolicy(new DefaultRetryPolicy(5000, 2, com.sigmob.sdk.base.blurkit.c.d));
        setShouldCache(false);
        String a2 = a(bidResponse);
        if (a2 != null) {
            try {
                this.b = AESUtil.Encrypt(a2.getBytes(), "KGpfzbYsn4T9Jyuq");
            } catch (Exception unused) {
                SigmobLog.e("feedback body bug");
            }
        }
    }

    private String a(BidResponse bidResponse) {
        try {
            JSONObject jSONObject = new JSONObject(JSONSerializer.Serialize(bidResponse));
            JSONObject optJSONObject = jSONObject.optJSONObject("scene");
            if (optJSONObject != null) {
                a(optJSONObject, com.umeng.analytics.pro.d.R);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(com.sigmob.sdk.base.db.a.a);
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONArray jSONArray = optJSONArray.getJSONObject(i).getJSONArray("materials");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        a(jSONObject2, "html_snippet");
                        a(jSONObject2, "closecard_html_snippet");
                        JSONObject optJSONObject2 = jSONObject.optJSONObject("main_template");
                        if (optJSONObject2 != null) {
                            a(optJSONObject2, com.umeng.analytics.pro.d.R);
                        }
                        JSONObject optJSONObject3 = jSONObject.optJSONObject("sub_template");
                        if (optJSONObject3 != null) {
                            a(optJSONObject3, com.umeng.analytics.pro.d.R);
                        }
                    }
                }
            }
            SigmobLog.d("json " + jSONObject);
            return jSONObject.toString();
        } catch (Throwable th) {
            SigmobLog.e("Serialize error", th);
            return null;
        }
    }

    private void a(JSONObject jSONObject, String str) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            return;
        }
        Iterator<String> keys = optJSONObject.keys();
        while (keys.hasNext()) {
            Object opt = optJSONObject.opt(keys.next());
            if (opt instanceof String) {
                String str2 = (String) opt;
                if (TextUtils.isEmpty(str2)) {
                    continue;
                } else {
                    String encodeToString = Base64.encodeToString(str2.getBytes(), 2);
                    jSONObject.remove(str);
                    try {
                        jSONObject.put(str, encodeToString);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public int compareTo(Object obj) {
        return 0;
    }

    public void deliverError(VolleyError volleyError) {
        super/*com.czhj.volley.Request*/.deliverError(volleyError);
        a aVar = this.a;
        if (aVar != null) {
            aVar.onErrorResponse(volleyError);
        }
    }

    protected void deliverResponse(Object obj) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(null);
        }
    }

    public byte[] getBody() {
        return this.b;
    }

    public String getBodyContentType() {
        return "application/json";
    }

    public Map<String, String> getHeaders() {
        Map<String, String> headers = super.getHeaders();
        try {
            headers.put("agn", Base64.encodeToString(AESUtil.generateNonce(), 2));
        } catch (NoSuchMethodError unused) {
            headers.put("e", "1");
        }
        return headers;
    }
}
