package com.sigmob.sdk.videoAd;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.czhj.sdk.common.ClientMetadata;
import com.sigmob.sdk.base.common.AdActivity;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.common.LandscapeAdActivity;
import com.sigmob.sdk.base.common.LandscapeTransparentAdActivity;
import com.sigmob.sdk.base.common.PortraitAdActivity;
import com.sigmob.sdk.base.common.PortraitTransparentAdActivity;
import com.sigmob.sdk.base.common.TransparentAdActivity;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class BaseAdActivity extends Activity {
    public static final String a = "LandPage";
    public static final String b = "reward";

    /* renamed from: c, reason: collision with root package name */
    public static final String f649c = "mraid";
    public static final String d = "mraid_two";
    public static final String e = "LandNative";
    public static final String f = "DisLike";
    protected static final String g = "ad_view_class_name";
    protected static final String h = "adUnit_requestId_key";
    public static final String i = "land_page_url";
    public static final String j = "new_interstitial";

    private static Intent a(Context context, Class<? extends BaseAdActivity> cls, String str, String str2) {
        Intent intent = new Intent(context, cls);
        intent.setFlags(268435456);
        intent.putExtra(g, str2);
        intent.putExtra(h, str);
        int requestedOrientation = context instanceof Activity ? ((Activity) context).getRequestedOrientation() : 3;
        if (requestedOrientation != 7 && requestedOrientation != 6) {
            requestedOrientation = context.getResources().getDisplayMetrics().widthPixels > context.getResources().getDisplayMetrics().heightPixels ? 6 : 7;
        }
        intent.putExtra(com.sigmob.sdk.base.k.w, requestedOrientation);
        intent.putExtra("broadcastIdentifier", str);
        return intent;
    }

    public static void a(Context context, Class<? extends BaseAdActivity> cls, BaseAdUnit baseAdUnit) {
        Intent a2 = a(context, cls, baseAdUnit.getUuid(), a);
        try {
            Bundle bundle = new Bundle();
            bundle.putSerializable(i, baseAdUnit);
            a2.putExtras(bundle);
            context.startActivity(a2);
        } catch (Throwable th) {
            new HashMap().put("error", th.getMessage());
        }
    }

    public static void a(Context context, Class<? extends BaseAdActivity> cls, String str) {
        a(context, cls, str, null, a);
    }

    public static void a(Context context, Class<? extends BaseAdActivity> cls, String str, Bundle bundle, String str2) {
        try {
            int display_orientation = com.sigmob.sdk.base.common.h.c(str).getDisplay_orientation();
            if (display_orientation == 0) {
                display_orientation = ClientMetadata.getInstance().getOrientationInt().intValue();
            }
            Intent a2 = a(context, cls == TransparentAdActivity.class ? display_orientation != 1 ? display_orientation != 2 ? TransparentAdActivity.class : LandscapeTransparentAdActivity.class : PortraitTransparentAdActivity.class : display_orientation != 1 ? display_orientation != 2 ? AdActivity.class : LandscapeAdActivity.class : PortraitAdActivity.class, str, str2);
            if (bundle != null) {
                a2.putExtras(bundle);
            }
            context.startActivity(a2);
        } catch (Throwable th) {
            HashMap hashMap = new HashMap();
            hashMap.put("error", th.getMessage());
            BaseBroadcastReceiver.a(context, str, hashMap, IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL);
        }
    }

    public static void b(Context context, Class<? extends BaseAdActivity> cls, String str) {
        try {
            Intent intent = new Intent(context, cls);
            intent.setFlags(268435456);
            intent.putExtra(g, f);
            intent.putExtra(h, str);
            intent.putExtra("broadcastIdentifier", "dislike_broadcastIdentifier");
            context.startActivity(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
