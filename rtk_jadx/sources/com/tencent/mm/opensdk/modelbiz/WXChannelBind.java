package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class WXChannelBind {

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.WXChannelBind.Req";

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 42;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class Resp extends BaseResp {
        private static final String KEY_AUTH_BUFFER = "_wxapi_finder_authBuffer";
        private static final String KEY_EXT_MSG = "_wxapi_finder_extMsg";
        private static final String TAG = "MicroMsg.SDK.WXChannelBind.Resp";
        public byte[] authBuffer;
        public String extMsg;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            if (bundle != null) {
                fromBundle(bundle);
            }
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.authBuffer = bundle.getByteArray(KEY_AUTH_BUFFER);
            this.extMsg = bundle.getString(KEY_EXT_MSG);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 42;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putByteArray(KEY_AUTH_BUFFER, this.authBuffer);
            bundle.putString(KEY_EXT_MSG, this.extMsg);
        }
    }
}
