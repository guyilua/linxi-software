package com.qumeng.advlib.api;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.qumeng.advlib.common.b;
import com.qumeng.advlib.common.c;
import com.qumeng.advlib.core.IMultiAdObject;
import com.qumeng.advlib.core.IMultiAdRequest;
import com.qumeng.advlib.core.QMConfig;
import com.qumeng.advlib.core.a;
import com.qumeng.advlib.open.JFIdentifierManager;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Keep
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AiClkAdManager {
    private static volatile AiClkAdManager sManager;
    private AtomicBoolean isInit = new AtomicBoolean(false);
    private a mFactory;
    private QMConfig mQmConfig;

    private AiClkAdManager() {
    }

    public static AiClkAdManager getInstance() {
        if (sManager == null) {
            synchronized (AiClkAdManager.class) {
                if (sManager == null) {
                    sManager = new AiClkAdManager();
                }
            }
        }
        return sManager;
    }

    public static String getSdkVersion() {
        return "3.468.13.434";
    }

    private void setCanUseOaid(QMConfig qMConfig) {
        boolean z;
        try {
            JFIdentifierManager jFIdentifierManager = JFIdentifierManager.getInstance();
            Context context = qMConfig.getContext();
            if (qMConfig.getCustomControl() != null && !qMConfig.getCustomControl().isCanUseOaid()) {
                z = false;
                jFIdentifierManager.setIsCanUseOaid(context, z);
            }
            z = true;
            jFIdentifierManager.setIsCanUseOaid(context, z);
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    public void appListFromClientNotice() {
        a aVar = this.mFactory;
        if (aVar == null) {
            Log.i("aiclk", "aiclk ad not init");
        } else {
            aVar.appListFromClientNotice();
        }
    }

    public void closeInteractionAd(IMultiAdObject iMultiAdObject) {
        try {
            c.a(iMultiAdObject).b("closeInteractionAd");
        } catch (Throwable unused) {
        }
    }

    public IMultiAdRequest createAdRequest() {
        if (this.mFactory == null) {
            Log.i("aiclk", "aiclk ad not init");
            return null;
        }
        JFIdentifierManager.getInstance().acquireOAID(this.mQmConfig.getContext());
        return this.mFactory.createNativeMultiAdRequest();
    }

    @Deprecated
    public void init(Context context, String str) {
        init(new QMConfig.Builder().build(context));
    }

    public void setAppList(List<PackageInfo> list) {
        a aVar = this.mFactory;
        if (aVar == null) {
            Log.i("aiclk", "aiclk ad not init");
        } else {
            aVar.setAppList(list);
        }
    }

    public void setOaid(String str) {
        JFIdentifierManager.getInstance().setOaid(str);
    }

    public void setPersonalRecommend(boolean z) {
        try {
            c.b((Class<?>) b.c().b(IMultiAdRequest.class)).a("savePersonalRecommendSwitch", Boolean.valueOf(z));
        } catch (Throwable unused) {
        }
    }

    public void init(@NonNull QMConfig qMConfig) {
        if (this.isInit.getAndSet(true)) {
            return;
        }
        this.mQmConfig = qMConfig;
        JFIdentifierManager.getInstance().setOaid(qMConfig.getCustomControl() != null ? qMConfig.getCustomControl().getOaid() : "");
        setCanUseOaid(qMConfig);
        this.mFactory = a.a(qMConfig);
        JFIdentifierManager.getInstance().asyncAcquireOAID(this.mQmConfig.getContext());
    }
}
