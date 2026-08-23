package com.qq.e.ads.rewardvideo;

import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ServerSideVerificationOptions {
    public static final String ACTION = "rewardAction";
    public static final String TRANS_ID = "transId";
    private String a;
    private String b;

    /* renamed from: c, reason: collision with root package name */
    private final JSONObject f13c;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class Builder {
        private String a;
        private String b;

        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this);
        }

        public Builder setCustomData(String str) {
            this.a = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.b = str;
            return this;
        }
    }

    private ServerSideVerificationOptions(Builder builder) {
        this.f13c = new JSONObject();
        this.a = builder.a;
        this.b = builder.b;
    }

    public String getCustomData() {
        return this.a;
    }

    public JSONObject getOptions() {
        return this.f13c;
    }

    public String getUserId() {
        return this.b;
    }
}
