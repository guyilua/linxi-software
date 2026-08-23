package com.qq.e.ads.hybrid;

import android.content.Context;
import com.qq.e.ads.AbstractAD;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.pi.HADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HybridAD extends AbstractAD<HADI> implements HADI {
    private HybridADListener h;
    private CountDownLatch i = new CountDownLatch(1);
    private HybridADSetting j;

    public HybridAD(Context context, HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        this.j = hybridADSetting;
        this.h = hybridADListener;
        a(context, "NO_POS_ID");
    }

    protected HADI a(POFactory pOFactory) {
        return pOFactory.getHybridAD(this.j, this.h);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected /* bridge */ /* synthetic */ HADI a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return a(pOFactory);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected /* bridge */ /* synthetic */ void a(HADI hadi) {
        c();
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i) {
        HybridADListener hybridADListener = this.h;
        if (hybridADListener != null) {
            hybridADListener.onError(AdErrorConvertor.formatErrorCode(i));
        }
        this.i.countDown();
    }

    protected void c() {
        this.i.countDown();
    }

    @Override // com.qq.e.comm.pi.HADI
    public void loadUrl(final String str) {
        if (a()) {
            if (!b()) {
                new Thread(new Runnable() { // from class: com.qq.e.ads.hybrid.HybridAD.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            HybridAD.this.i.await(30L, TimeUnit.SECONDS);
                            if (!HybridAD.this.b() || ((AbstractAD) HybridAD.this).a == null) {
                                GDTLogger.e("初始化错误：广告实例未被初始化");
                                HybridAD.this.a(ErrorCode.INIT_ERROR);
                            } else {
                                ((HADI) ((AbstractAD) HybridAD.this).a).loadUrl(str);
                            }
                        } catch (InterruptedException unused) {
                            GDTLogger.e("初始化错误：广告实例未被初始化");
                            HybridAD.this.a(ErrorCode.INIT_ERROR);
                        }
                    }
                }).start();
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((HADI) t).loadUrl(str);
            } else {
                a("loadUrl");
            }
        }
    }
}
