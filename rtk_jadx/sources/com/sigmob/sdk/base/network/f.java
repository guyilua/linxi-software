package com.sigmob.sdk.base.network;

import android.util.Base64;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.models.ModelBuilderCreator;
import com.czhj.sdk.common.network.SigmobRequest;
import com.czhj.sdk.common.utils.AESUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.DefaultRetryPolicy;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.ParseError;
import com.czhj.volley.Response;
import com.czhj.volley.toolbox.HttpHeaderParser;
import com.sigmob.sdk.base.models.config.SigmobSdkConfigRequest;
import com.sigmob.sdk.base.models.config.SigmobSdkConfigResponse;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f extends SigmobRequest<SigmobSdkConfigResponse> {
    private final a a;
    private final SigmobSdkConfigRequest.Builder b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f425c;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a extends Response.ErrorListener {
        void a(SigmobSdkConfigResponse sigmobSdkConfigResponse);
    }

    public f(String str, a aVar) {
        super(str, 1, aVar);
        this.a = aVar;
        setRetryPolicy(new DefaultRetryPolicy(5000, 2, com.sigmob.sdk.base.blurkit.c.d));
        setShouldCache(false);
        this.b = a();
    }

    public static SigmobSdkConfigRequest.Builder a() {
        SigmobSdkConfigRequest.Builder builder = new SigmobSdkConfigRequest.Builder();
        if (ClientMetadata.getInstance() != null && ClientMetadata.getInstance().getDeviceLocale() != null) {
            builder.app(com.sigmob.sdk.base.network.a.b().build());
            builder.user(com.sigmob.sdk.base.network.a.c().build());
            builder.privacy(com.sigmob.sdk.base.network.a.d().build());
            builder.network(ModelBuilderCreator.createNetwork(com.sigmob.sdk.b.b()).build());
            builder.device(ModelBuilderCreator.createDevice(com.sigmob.sdk.b.b()).did(ModelBuilderCreator.createDeviceId(com.sigmob.sdk.b.b()).build()).build());
        }
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void deliverResponse(SigmobSdkConfigResponse sigmobSdkConfigResponse) {
        this.a.a(sigmobSdkConfigResponse);
    }

    public a b() {
        return this.a;
    }

    public byte[] getBody() {
        return this.f425c;
    }

    public String getBodyContentType() {
        return "application/octet-stream";
    }

    public Map<String, String> getHeaders() {
        Map<String, String> headers = super.getHeaders();
        try {
            headers.put("agn", Base64.encodeToString(AESUtil.generateNonce(), 2));
        } catch (NoSuchMethodError unused) {
            headers.put("e", "1");
        }
        SigmobSdkConfigRequest build = this.b.build();
        try {
            byte[] encode = build.encode();
            this.f425c = encode;
            this.f425c = c.b(encode);
            headers.put("cp", "1");
        } catch (Throwable unused2) {
            headers.remove("cp");
            this.f425c = build.encode();
        }
        try {
            this.f425c = AESUtil.Encrypt(this.f425c, "KGpfzbYsn4T9Jyuq");
        } catch (Exception e) {
            e.printStackTrace();
            headers.remove("e");
            headers.remove("agn");
        }
        return headers;
    }

    protected Response<SigmobSdkConfigResponse> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            if (networkResponse.data == null) {
                return Response.error(new ParseError(networkResponse));
            }
            return Response.success((SigmobSdkConfigResponse) SigmobSdkConfigResponse.ADAPTER.decode((networkResponse.headers.containsKey("cp") && "1".equals(networkResponse.headers.get("cp"))) ? c.a(networkResponse.data) : networkResponse.data), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return Response.error(new ParseError(th));
        }
    }
}
