package com.rtk.app.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import com.rtk.app.tool.c0;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.lang.ref.WeakReference;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {
    private static String b = "WXEntryActivity";
    private IWXAPI a;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class a extends Handler {
        public a(WXPayEntryActivity wXPayEntryActivity) {
            new WeakReference(wXPayEntryActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c0.r(b, "onCreate");
        this.a = WXAPIFactory.createWXAPI(this, "wxc3ee7ebfc4bc90e1", false);
        new a(this);
        try {
            this.a.handleIntent(getIntent(), this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.a.handleIntent(intent, this);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        if (baseReq.getType() == 5) {
            Log.d(b, "onPayFinish");
        }
        finish();
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        if (baseResp == null) {
            return;
        }
        c0.r(b, "onResp,resp.getType:" + baseResp.getType());
        if (baseResp.getType() != 5) {
            return;
        }
        int i = baseResp.errCode;
        c0.r(b, "errCode" + i);
        Toast.makeText(this, i != -2 ? i != 0 ? "支付失败!" : "支付成功!" : "您取消了支付!", 0).show();
        setResult(AdBaseConstants.DEFAULT_BROADCAST_CHECK_TIME);
        finish();
    }
}
