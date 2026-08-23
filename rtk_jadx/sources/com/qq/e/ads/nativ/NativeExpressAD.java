package com.qq.e.ads.nativ;

import android.content.Context;
import com.qq.e.ads.NativeAbstractAD;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class NativeExpressAD extends NativeAbstractAD<NEADI> implements IReward {
    private volatile int h;
    private volatile int i;
    private List<Integer> j = Collections.synchronizedList(new ArrayList());
    private VideoOption k;
    private ADSize l;
    private NativeExpressADListener m;
    private final ADListenerAdapter n;
    private LoadAdParams o;
    private volatile ServerSideVerificationOptions p;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ADListenerAdapter implements ADListener {
        private NativeExpressADListener a;
        private NativeExpressMediaListener b;

        /* renamed from: c, reason: collision with root package name */
        private NegativeFeedbackListener f9c;
        private ADRewardListener d;

        public ADListenerAdapter(NativeExpressADListener nativeExpressADListener) {
            this.a = nativeExpressADListener;
        }

        public ADListenerAdapter(NativeExpressMediaListener nativeExpressMediaListener) {
            this.b = nativeExpressMediaListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (NativeExpressAD.g(this.a, aDEvent) || NativeExpressAD.h(this.b, aDEvent) || NativeExpressAD.j(this.f9c, aDEvent)) {
                return;
            }
            NativeExpressAD.i(this.d, aDEvent);
        }

        public void setAdRewardListener(ADRewardListener aDRewardListener) {
            this.d = aDRewardListener;
        }

        public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
            this.b = nativeExpressMediaListener;
        }

        public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
            this.f9c = negativeFeedbackListener;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface NativeExpressADListener extends NativeAbstractAD.BasicADListener {
        void onADClicked(NativeExpressADView nativeExpressADView);

        void onADClosed(NativeExpressADView nativeExpressADView);

        void onADExposure(NativeExpressADView nativeExpressADView);

        void onADLeftApplication(NativeExpressADView nativeExpressADView);

        void onADLoaded(List<NativeExpressADView> list);

        void onRenderFail(NativeExpressADView nativeExpressADView);

        void onRenderSuccess(NativeExpressADView nativeExpressADView);
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, NativeExpressADListener nativeExpressADListener) {
        this.m = nativeExpressADListener;
        this.n = new ADListenerAdapter(nativeExpressADListener);
        if (f(aDSize)) {
            return;
        }
        a(context, str);
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, NativeExpressADListener nativeExpressADListener, String str2) {
        this.m = nativeExpressADListener;
        this.n = new ADListenerAdapter(nativeExpressADListener);
        if (f(aDSize)) {
            return;
        }
        a(context, str, str2);
    }

    private boolean f(ADSize aDSize) {
        if (aDSize != null) {
            this.l = aDSize;
            return false;
        }
        GDTLogger.e("初始化错误：参数adSize不能为空");
        a(ErrorCode.INIT_ERROR);
        return true;
    }

    static boolean g(NativeExpressADListener nativeExpressADListener, ADEvent aDEvent) {
        if (nativeExpressADListener != null) {
            int type = aDEvent.getType();
            if (type == 100) {
                List<NativeExpressADView> list = (List) aDEvent.getParam(List.class);
                if (list != null) {
                    nativeExpressADListener.onADLoaded(list);
                }
            } else if (type == 101) {
                Integer num = (Integer) aDEvent.getParam(Integer.class);
                if (num != null) {
                    nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                }
            } else if (type == 103) {
                NativeExpressADView nativeExpressADView = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView != null) {
                    nativeExpressADListener.onADExposure(nativeExpressADView);
                }
            } else if (type == 303) {
                NativeExpressADView nativeExpressADView2 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView2 != null) {
                    nativeExpressADListener.onADLeftApplication(nativeExpressADView2);
                }
            } else if (type == 105) {
                NativeExpressADView nativeExpressADView3 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView3 != null) {
                    nativeExpressADListener.onADClicked(nativeExpressADView3);
                }
            } else if (type == 106) {
                NativeExpressADView nativeExpressADView4 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView4 != null) {
                    nativeExpressADListener.onADClosed(nativeExpressADView4);
                    nativeExpressADView4.negativeFeedback();
                }
            } else if (type == 109) {
                NativeExpressADView nativeExpressADView5 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView5 != null) {
                    nativeExpressADListener.onRenderSuccess(nativeExpressADView5);
                }
            } else if (type == 110) {
                NativeExpressADView nativeExpressADView6 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView6 != null) {
                    nativeExpressADListener.onRenderFail(nativeExpressADView6);
                }
            }
            return true;
        }
        return false;
    }

    static boolean h(NativeExpressMediaListener nativeExpressMediaListener, ADEvent aDEvent) {
        NativeExpressADView nativeExpressADView;
        if (nativeExpressMediaListener != null && (nativeExpressADView = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class)) != null) {
            int type = aDEvent.getType();
            if (type == 201) {
                nativeExpressMediaListener.onVideoCached(nativeExpressADView);
                return true;
            }
            if (type == 202) {
                nativeExpressMediaListener.onVideoStart(nativeExpressADView);
                return true;
            }
            if (type == 204) {
                nativeExpressMediaListener.onVideoPause(nativeExpressADView);
                return true;
            }
            if (type == 206) {
                nativeExpressMediaListener.onVideoComplete(nativeExpressADView);
                return true;
            }
            if (type == 207) {
                Integer num = (Integer) aDEvent.getParam(1, Integer.class);
                if (num == null) {
                    return true;
                }
                nativeExpressMediaListener.onVideoError(nativeExpressADView, AdErrorConvertor.formatErrorCode(num.intValue()));
                return true;
            }
            if (type == 301) {
                nativeExpressMediaListener.onVideoPageOpen(nativeExpressADView);
                return true;
            }
            if (type == 302) {
                nativeExpressMediaListener.onVideoPageClose(nativeExpressADView);
                return true;
            }
            switch (type) {
                case 209:
                    nativeExpressMediaListener.onVideoInit(nativeExpressADView);
                    return true;
                case 210:
                    if (((Integer) aDEvent.getParam(1, Integer.class)) == null) {
                        return true;
                    }
                    nativeExpressMediaListener.onVideoReady(nativeExpressADView, r6.intValue());
                    return true;
                case 211:
                    nativeExpressMediaListener.onVideoLoading(nativeExpressADView);
                    return true;
            }
        }
        return false;
    }

    static boolean i(ADRewardListener aDRewardListener, ADEvent aDEvent) {
        if (aDRewardListener == null || aDEvent.getType() != 104) {
            return false;
        }
        String str = (String) aDEvent.getParam(String.class);
        if (str != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(ServerSideVerificationOptions.TRANS_ID, str);
            aDRewardListener.onReward(hashMap);
        }
        return true;
    }

    static boolean j(NegativeFeedbackListener negativeFeedbackListener, ADEvent aDEvent) {
        if (negativeFeedbackListener == null || aDEvent.getType() != 304) {
            return false;
        }
        negativeFeedbackListener.onComplainSuccess();
        return true;
    }

    @Override // com.qq.e.ads.AbstractAD
    protected Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeExpressADDelegate(context, this.l, str, str2, str3, this.n);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i) {
        NativeExpressADListener nativeExpressADListener = this.m;
        if (nativeExpressADListener != null) {
            nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
        }
    }

    public String getAdNetWorkName() {
        T t = this.a;
        if (t != 0) {
            return ((NEADI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadAD(int i) {
        loadAD(i, null);
    }

    public void loadAD(int i, LoadAdParams loadAdParams) {
        if (a()) {
            if (loadAdParams != null) {
                setAdParams(loadAdParams);
            }
            if (!b()) {
                synchronized (this.j) {
                    this.j.add(Integer.valueOf(i));
                }
                return;
            }
            T t = this.a;
            if (t == 0) {
                a("loadAD");
                return;
            }
            LoadAdParams loadAdParams2 = this.o;
            NEADI neadi = (NEADI) t;
            if (loadAdParams2 != null) {
                neadi.loadAd(i, loadAdParams2);
            } else {
                neadi.loadAd(i);
            }
        }
    }

    public void setAdParams(LoadAdParams loadAdParams) {
        this.o = loadAdParams;
    }

    public void setMaxVideoDuration(int i) {
        this.i = i;
        if (this.i > 0 && this.h > this.i) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t = this.a;
        if (t != 0) {
            ((NEADI) t).setMaxVideoDuration(this.i);
        }
    }

    public void setMinVideoDuration(int i) {
        this.h = i;
        if (this.i > 0 && this.h > this.i) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t = this.a;
        if (t != 0) {
            ((NEADI) t).setMinVideoDuration(this.h);
        }
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.n.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.p = serverSideVerificationOptions;
        T t = this.a;
        if (t != 0) {
            ((NEADI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.k = videoOption;
        T t = this.a;
        if (t == 0 || videoOption == null) {
            return;
        }
        ((NEADI) t).setVideoOption(videoOption);
    }

    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    protected void a(Object obj) {
        NEADI neadi = (NEADI) obj;
        neadi.setMinVideoDuration(this.h);
        neadi.setMaxVideoDuration(this.i);
        ((NEADI) this.a).setServerSideVerificationOptions(this.p);
        VideoOption videoOption = this.k;
        if (videoOption != null) {
            setVideoOption(videoOption);
        }
        synchronized (this.j) {
            Iterator<Integer> it = this.j.iterator();
            while (it.hasNext()) {
                T t = this.a;
                if (t != 0) {
                    if (this.o != null) {
                        ((NEADI) t).loadAd(it.next().intValue(), this.o);
                    } else {
                        ((NEADI) t).loadAd(it.next().intValue());
                    }
                }
            }
        }
    }
}
