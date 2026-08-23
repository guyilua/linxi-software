package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import java.net.URLEncoder;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HandleScanResult {

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class Req extends BaseReq {
        private static final int MAX_URL_LENGHT = 10240;
        public String scanResult;

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            String str = this.scanResult;
            return str != null && str.length() >= 0 && this.scanResult.length() <= 10240;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 17;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_scan_qrcode_result", URLEncoder.encode(this.scanResult));
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class Resp extends BaseResp {
        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 17;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
        }
    }
}
