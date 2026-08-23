package com.windmill.baidu;

import android.content.Context;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.natives.WMNativeAdData;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class g {

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void onNativeAdFailToLoad(WMAdapterError wMAdapterError);

        void onNativeAdLoadSuccess(List<WMNativeAdData> list, String str, String... strArr);
    }

    public abstract void a(Context context, String str, Map<String, Object> map, Map<String, Object> map2);

    public abstract void a(String str, LinkedHashMap<String, Object> linkedHashMap);

    public abstract boolean a();

    public abstract List<WMNativeAdData> b();

    public abstract void b(String str, LinkedHashMap<String, Object> linkedHashMap);

    public abstract Map<String, Object> c();
}
