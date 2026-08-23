package com.qq.e.ads.nativ;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.NativeAbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class NativeUnifiedAD extends NativeAbstractAD<NUADI> {
    private AdListenerAdapter h;
    private NativeADUnifiedListener i;
    private List<Integer> j = new ArrayList();
    private List<String> k;
    private volatile int l;
    private volatile int m;
    private String n;
    private LoadAdParams o;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class AdListenerAdapter implements ADListener {
        private NativeADUnifiedListener a;

        public AdListenerAdapter(NativeADUnifiedListener nativeADUnifiedListener) {
            this.a = nativeADUnifiedListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Integer num;
            if (this.a != null) {
                int type = aDEvent.getType();
                if (type != 100) {
                    if (type == 101 && (num = (Integer) aDEvent.getParam(Integer.class)) != null) {
                        this.a.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                        return;
                    }
                    return;
                }
                List list = (List) aDEvent.getParam(List.class);
                if (list == null || list.size() <= 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new NativeUnifiedADDataAdapter((NativeUnifiedADData) it.next()));
                }
                this.a.onADLoaded(arrayList);
            }
        }
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener) {
        this.i = nativeADUnifiedListener;
        this.h = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str);
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener, String str2) {
        this.i = nativeADUnifiedListener;
        this.h = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str, str2);
    }

    private void f(int i, boolean z) {
        if (a()) {
            if (!b()) {
                if (z) {
                    this.j.add(Integer.valueOf(i));
                    return;
                }
                return;
            }
            T t = this.a;
            if (t != 0) {
                LoadAdParams loadAdParams = this.o;
                NUADI nuadi = (NUADI) t;
                if (loadAdParams != null) {
                    nuadi.loadData(i, loadAdParams);
                } else {
                    nuadi.loadData(i);
                }
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeAdManagerDelegate(context, str, str2, str3, this.h);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i) {
        NativeADUnifiedListener nativeADUnifiedListener = this.i;
        if (nativeADUnifiedListener != null) {
            nativeADUnifiedListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
        }
    }

    public String getAdNetWorkName() {
        T t = this.a;
        if (t != 0) {
            return ((NUADI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadData(int i) {
        f(i, true);
    }

    public void loadData(int i, LoadAdParams loadAdParams) {
        this.o = loadAdParams;
        loadData(i);
    }

    public void setCategories(List<String> list) {
        this.k = list;
        T t = this.a;
        if (t == 0 || list == null) {
            return;
        }
        ((NUADI) t).setCategories(list);
    }

    public void setMaxVideoDuration(int i) {
        this.m = i;
        if (this.m > 0 && this.l > this.m) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t = this.a;
        if (t != 0) {
            ((NUADI) t).setMaxVideoDuration(this.m);
        }
    }

    public void setMinVideoDuration(int i) {
        this.l = i;
        if (this.m > 0 && this.l > this.m) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t = this.a;
        if (t != 0) {
            ((NUADI) t).setMinVideoDuration(this.l);
        }
    }

    public void setVastClassName(String str) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("Vast class name 不能为空");
            return;
        }
        this.n = str;
        T t = this.a;
        if (t != 0) {
            ((NUADI) t).setVastClassName(str);
        }
    }

    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    protected void a(Object obj) {
        NUADI nuadi = (NUADI) obj;
        nuadi.setMinVideoDuration(this.l);
        nuadi.setMaxVideoDuration(this.m);
        nuadi.setVastClassName(this.n);
        List<String> list = this.k;
        if (list != null) {
            setCategories(list);
        }
        Iterator<Integer> it = this.j.iterator();
        while (it.hasNext()) {
            f(it.next().intValue(), false);
        }
    }
}
