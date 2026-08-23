package com.uc.crashsdk.a;

import com.qq.e.comm.adevent.AdEventType;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.TbsMediaPlayer;

/* compiled from: ProGuard */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e implements Runnable {
    static final /* synthetic */ boolean a = true;
    private final int b;

    /* renamed from: c, reason: collision with root package name */
    private final Object[] f994c;

    public e(int i) {
        this.b = i;
        this.f994c = null;
    }

    public final boolean a() {
        int i = this.b;
        if (i != 451 && i != 452) {
            switch (i) {
                case 351:
                case 352:
                case 353:
                case 354:
                    return h.b(i, this.f994c);
                default:
                    switch (i) {
                        case TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA /* 751 */:
                        case TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA /* 752 */:
                        case 753:
                            return com.uc.crashsdk.f.a(i, this.f994c);
                        default:
                            a.d("crashsdk", "Unknown sync runnable: " + toString());
                            if (a) {
                                return false;
                            }
                            throw new AssertionError();
                    }
            }
        }
        return com.uc.crashsdk.e.b(i, this.f994c);
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = this.b;
        if (i == 10) {
            f.a(i, this.f994c);
            return;
        }
        if (i == 500) {
            d.a(i);
            return;
        }
        if (i == 700) {
            com.uc.crashsdk.f.b(i);
            return;
        }
        if (i == 800) {
            g.a(i);
            return;
        }
        if (i != 201 && i != 202) {
            switch (i) {
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                    com.uc.crashsdk.b.a(i);
                    return;
                default:
                    switch (i) {
                        case AdEventType.VIDEO_PAGE_OPEN /* 301 */:
                        case 302:
                        case 303:
                            h.a(i, this.f994c);
                            return;
                        default:
                            switch (i) {
                                case 401:
                                case 402:
                                case 403:
                                    break;
                                default:
                                    switch (i) {
                                        case 405:
                                        case 406:
                                        case 407:
                                        case TbsListener.ErrorCode.INFO_CAN_NOT_DISABLED_BY_CRASH /* 408 */:
                                        case TbsListener.ErrorCode.INFO_CAN_NOT_USE_X5_TBS_AVAILABLE /* 409 */:
                                        case TbsListener.ErrorCode.INFO_CAN_NOT_USE_X5_TBS_NOTAVAILABLE /* 410 */:
                                        case TbsListener.ErrorCode.INFO_CAN_NOT_USE_X5_FINAL_REASON /* 411 */:
                                        case TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX /* 412 */:
                                        case TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX /* 413 */:
                                        case TbsListener.ErrorCode.INFO_SDKINIT_IS_SYS_FORCED /* 414 */:
                                        case TbsListener.ErrorCode.INFO_INITX5_FALSE_DEFAULT /* 415 */:
                                        case 416:
                                            break;
                                        default:
                                            a.d("crashsdk", "Unknown async runnable: " + toString());
                                            if (!a) {
                                                throw new AssertionError();
                                            }
                                            return;
                                    }
                            }
                            com.uc.crashsdk.e.a(i, this.f994c);
                            return;
                    }
            }
        }
        com.uc.crashsdk.a.a(i);
    }

    public String toString() {
        return super.toString() + "@action_" + this.b;
    }

    public e(int i, Object[] objArr) {
        this.b = i;
        this.f994c = objArr;
    }
}
