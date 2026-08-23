package com.sigmob.sdk.newInterstitial;

import com.czhj.sdk.common.ClientMetadata;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.s;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b implements s {
    private void a(BaseAdUnit baseAdUnit, String str, String str2, final HashMap<String, String> hashMap) {
        ae.a(str, str2, baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.newInterstitial.b.1
            @Override // com.sigmob.sdk.base.common.ae.a
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    ((PointEntitySigmob) obj).setOptions(hashMap);
                }
            }
        });
    }

    @Override // com.sigmob.sdk.base.common.s
    public boolean a(BaseAdUnit baseAdUnit) {
        return true;
    }

    @Override // com.sigmob.sdk.base.common.s
    public boolean a(BaseAdUnit baseAdUnit, int i, int i2) {
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:62:0x0108. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v128 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.util.HashMap, java.lang.String] */
    @Override // com.sigmob.sdk.base.common.s
    public boolean a(BaseAdUnit baseAdUnit, String str, int i) {
        b bVar;
        ?? r2;
        String str2;
        b bVar2;
        Object obj;
        String str3;
        String str4;
        HashMap<String, String> hashMap;
        String str5;
        String str6;
        char c2 = 65535;
        try {
            switch (str.hashCode()) {
                case -2050793311:
                    if (str.equals("play_quarter")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case -1903355519:
                    if (str.equals("show_skip")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1618089666:
                    if (str.equals("video_link")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -1361632588:
                    if (str.equals("charge")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1170756021:
                    if (str.equals("video_restart")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case -1152604194:
                    if (str.equals("ad_hide")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -981662273:
                    if (str.equals(com.sigmob.sdk.base.common.a.f)) {
                        c2 = 16;
                        break;
                    }
                    break;
                case -599445191:
                    if (str.equals("complete")) {
                        c2 = 14;
                        break;
                    }
                    break;
                case -381416586:
                    if (str.equals(com.sigmob.sdk.base.common.a.g)) {
                        c2 = 17;
                        break;
                    }
                    break;
                case -236894925:
                    if (str.equals("play_three_quarters")) {
                        c2 = '\r';
                        break;
                    }
                    break;
                case 3532159:
                    if (str.equals("skip")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 94750088:
                    if (str.equals("click")) {
                        c2 = 15;
                        break;
                    }
                    break;
                case 109757538:
                    if (str.equals("start")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 471706373:
                    if (str.equals("play_two_quarters")) {
                        c2 = '\f';
                        break;
                    }
                    break;
                case 844450526:
                    if (str.equals(com.sigmob.sdk.base.common.a.z)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1110780470:
                    if (str.equals("show_close")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1382290738:
                    if (str.equals("video_pause")) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case 1385608094:
                    if (str.equals("video_start")) {
                        c2 = '\t';
                        break;
                    }
                    break;
            }
        } catch (Throwable unused) {
        }
        try {
            try {
                switch (c2) {
                    case 0:
                        bVar = this;
                        r2 = 0;
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, "start");
                        str2 = "start";
                        bVar.a(baseAdUnit, str2, r2, r2);
                        return true;
                    case 1:
                        bVar = this;
                        r2 = 0;
                        str2 = PointCategory.VCLOSE;
                        bVar.a(baseAdUnit, str2, r2, r2);
                        return true;
                    case 2:
                        bVar = this;
                        r2 = 0;
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, "ad_hide");
                        str2 = "ad_hide";
                        bVar.a(baseAdUnit, str2, r2, r2);
                        return true;
                    case 3:
                        bVar2 = this;
                        obj = null;
                        str2 = "charge";
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, str2);
                        r2 = obj;
                        bVar = bVar2;
                        bVar.a(baseAdUnit, str2, r2, r2);
                        return true;
                    case 4:
                        bVar2 = this;
                        obj = null;
                        str2 = "show_skip";
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, str2);
                        r2 = obj;
                        bVar = bVar2;
                        bVar.a(baseAdUnit, str2, r2, r2);
                        return true;
                    case 5:
                        bVar = this;
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, "skip");
                        str2 = "skip";
                        r2 = 0;
                        bVar.a(baseAdUnit, str2, r2, r2);
                        return true;
                    case 6:
                        bVar = this;
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, "show_close");
                        str2 = "show_close";
                        r2 = 0;
                        bVar.a(baseAdUnit, str2, r2, r2);
                        return true;
                    case 7:
                        SigMacroCommon macroCommon = baseAdUnit.getMacroCommon();
                        if (macroCommon instanceof SigMacroCommon) {
                            macroCommon.addMarcoKey(SigMacroCommon._VIDEOTIME_, String.valueOf(baseAdUnit.getVideoCommon().video_time));
                            macroCommon.addMarcoKey(SigMacroCommon._BEGINTIME_, String.valueOf(baseAdUnit.getVideoCommon().begin_time));
                            macroCommon.addMarcoKey(SigMacroCommon._ENDTIME_, String.valueOf(baseAdUnit.getVideoCommon().end_time));
                            macroCommon.addMarcoKey(SigMacroCommon._PLAYFIRSTFRAME_, String.valueOf(baseAdUnit.getVideoCommon().is_first));
                            macroCommon.addMarcoKey(SigMacroCommon._PLAYLASTFRAME_, String.valueOf(baseAdUnit.getVideoCommon().is_last));
                            macroCommon.addMarcoKey(SigMacroCommon._SCENE_, String.valueOf(baseAdUnit.getVideoCommon().scene));
                            macroCommon.addMarcoKey(SigMacroCommon._TYPE_, String.valueOf(baseAdUnit.getVideoCommon().type));
                            macroCommon.addMarcoKey(SigMacroCommon._BEHAVIOR_, String.valueOf(baseAdUnit.getVideoCommon().is_auto_play));
                            macroCommon.addMarcoKey(SigMacroCommon._STATUS_, String.valueOf(baseAdUnit.getVideoCommon().status));
                        }
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, "video_link", true);
                        HashMap<String, String> hashMap2 = new HashMap<>();
                        hashMap2.put("video_time", String.valueOf(baseAdUnit.getVideoCommon().video_time));
                        hashMap2.put("begin_time", String.valueOf(baseAdUnit.getVideoCommon().begin_time));
                        hashMap2.put(com.umeng.analytics.pro.d.q, String.valueOf(baseAdUnit.getVideoCommon().end_time));
                        hashMap2.put("is_first", String.valueOf(baseAdUnit.getVideoCommon().is_first));
                        hashMap2.put("scene", String.valueOf(baseAdUnit.getVideoCommon().scene));
                        hashMap2.put(com.umeng.analytics.pro.d.y, String.valueOf(baseAdUnit.getVideoCommon().type));
                        hashMap2.put("is_auto_play", String.valueOf(baseAdUnit.getVideoCommon().is_auto_play));
                        hashMap2.put("status", String.valueOf(baseAdUnit.getVideoCommon().status));
                        a(baseAdUnit, "video_link", null, hashMap2);
                        return true;
                    case '\b':
                        SigMacroCommon macroCommon2 = baseAdUnit.getMacroCommon();
                        if (macroCommon2 instanceof SigMacroCommon) {
                            macroCommon2.addMarcoKey(SigMacroCommon._VIDEOTIME_, String.valueOf(baseAdUnit.getVideoCommon().video_time));
                            macroCommon2.addMarcoKey(SigMacroCommon._BEGINTIME_, String.valueOf(baseAdUnit.getVideoCommon().begin_time));
                            macroCommon2.addMarcoKey(SigMacroCommon._ENDTIME_, String.valueOf(baseAdUnit.getVideoCommon().end_time));
                            macroCommon2.addMarcoKey(SigMacroCommon._PLAYFIRSTFRAME_, String.valueOf(baseAdUnit.getVideoCommon().is_first));
                            macroCommon2.addMarcoKey(SigMacroCommon._PLAYLASTFRAME_, String.valueOf(baseAdUnit.getVideoCommon().is_last));
                            macroCommon2.addMarcoKey(SigMacroCommon._SCENE_, String.valueOf(baseAdUnit.getVideoCommon().scene));
                            macroCommon2.addMarcoKey(SigMacroCommon._TYPE_, String.valueOf(baseAdUnit.getVideoCommon().type));
                            macroCommon2.addMarcoKey(SigMacroCommon._BEHAVIOR_, String.valueOf(baseAdUnit.getVideoCommon().is_auto_play));
                            macroCommon2.addMarcoKey(SigMacroCommon._STATUS_, String.valueOf(baseAdUnit.getVideoCommon().status));
                        }
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, "video_restart");
                        HashMap<String, String> hashMap3 = new HashMap<>();
                        hashMap3.put("video_time", String.valueOf(baseAdUnit.getVideoCommon().video_time));
                        hashMap3.put("begin_time", String.valueOf(baseAdUnit.getVideoCommon().begin_time));
                        hashMap3.put(com.umeng.analytics.pro.d.q, String.valueOf(baseAdUnit.getVideoCommon().end_time));
                        hashMap3.put("is_first", String.valueOf(baseAdUnit.getVideoCommon().is_first));
                        hashMap3.put("scene", String.valueOf(baseAdUnit.getVideoCommon().scene));
                        hashMap3.put(com.umeng.analytics.pro.d.y, String.valueOf(baseAdUnit.getVideoCommon().type));
                        hashMap3.put("is_auto_play", String.valueOf(baseAdUnit.getVideoCommon().is_auto_play));
                        hashMap3.put("status", String.valueOf(baseAdUnit.getVideoCommon().status));
                        a(baseAdUnit, "video_restart", null, hashMap3);
                        break;
                    case '\t':
                        SigMacroCommon macroCommon3 = baseAdUnit.getMacroCommon();
                        if (macroCommon3 instanceof SigMacroCommon) {
                            macroCommon3.addMarcoKey(SigMacroCommon._VIDEOTIME_, String.valueOf(baseAdUnit.getVideoCommon().video_time));
                            macroCommon3.addMarcoKey(SigMacroCommon._BEGINTIME_, String.valueOf(baseAdUnit.getVideoCommon().begin_time));
                            macroCommon3.addMarcoKey(SigMacroCommon._ENDTIME_, String.valueOf(baseAdUnit.getVideoCommon().end_time));
                            macroCommon3.addMarcoKey(SigMacroCommon._PLAYFIRSTFRAME_, String.valueOf(baseAdUnit.getVideoCommon().is_first));
                            macroCommon3.addMarcoKey(SigMacroCommon._PLAYLASTFRAME_, String.valueOf(baseAdUnit.getVideoCommon().is_last));
                            macroCommon3.addMarcoKey(SigMacroCommon._SCENE_, String.valueOf(baseAdUnit.getVideoCommon().scene));
                            macroCommon3.addMarcoKey(SigMacroCommon._TYPE_, String.valueOf(baseAdUnit.getVideoCommon().type));
                            macroCommon3.addMarcoKey(SigMacroCommon._BEHAVIOR_, String.valueOf(baseAdUnit.getVideoCommon().is_auto_play));
                            macroCommon3.addMarcoKey(SigMacroCommon._STATUS_, String.valueOf(baseAdUnit.getVideoCommon().status));
                        }
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, "video_start", false);
                        HashMap<String, String> hashMap4 = new HashMap<>();
                        hashMap4.put("video_time", String.valueOf(baseAdUnit.getVideoCommon().video_time));
                        hashMap4.put("begin_time", String.valueOf(baseAdUnit.getVideoCommon().begin_time));
                        hashMap4.put(com.umeng.analytics.pro.d.q, String.valueOf(baseAdUnit.getVideoCommon().end_time));
                        hashMap4.put("is_first", String.valueOf(baseAdUnit.getVideoCommon().is_first));
                        hashMap4.put("scene", String.valueOf(baseAdUnit.getVideoCommon().scene));
                        hashMap4.put(com.umeng.analytics.pro.d.y, String.valueOf(baseAdUnit.getVideoCommon().type));
                        hashMap4.put("is_auto_play", String.valueOf(baseAdUnit.getVideoCommon().is_auto_play));
                        hashMap4.put("status", String.valueOf(baseAdUnit.getVideoCommon().status));
                        a(baseAdUnit, "video_start", null, hashMap4);
                        break;
                    case '\n':
                        SigMacroCommon macroCommon4 = baseAdUnit.getMacroCommon();
                        if (macroCommon4 instanceof SigMacroCommon) {
                            macroCommon4.addMarcoKey(SigMacroCommon._VIDEOTIME_, String.valueOf(baseAdUnit.getVideoCommon().video_time));
                            macroCommon4.addMarcoKey(SigMacroCommon._BEGINTIME_, String.valueOf(baseAdUnit.getVideoCommon().begin_time));
                            macroCommon4.addMarcoKey(SigMacroCommon._ENDTIME_, String.valueOf(baseAdUnit.getVideoCommon().end_time));
                            macroCommon4.addMarcoKey(SigMacroCommon._PLAYFIRSTFRAME_, String.valueOf(baseAdUnit.getVideoCommon().is_first));
                            macroCommon4.addMarcoKey(SigMacroCommon._PLAYLASTFRAME_, String.valueOf(baseAdUnit.getVideoCommon().is_last));
                            macroCommon4.addMarcoKey(SigMacroCommon._SCENE_, String.valueOf(baseAdUnit.getVideoCommon().scene));
                            macroCommon4.addMarcoKey(SigMacroCommon._TYPE_, String.valueOf(baseAdUnit.getVideoCommon().type));
                            macroCommon4.addMarcoKey(SigMacroCommon._BEHAVIOR_, String.valueOf(baseAdUnit.getVideoCommon().is_auto_play));
                            macroCommon4.addMarcoKey(SigMacroCommon._STATUS_, String.valueOf(baseAdUnit.getVideoCommon().status));
                        }
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, "video_pause", true);
                        HashMap<String, String> hashMap5 = new HashMap<>();
                        hashMap5.put("video_time", String.valueOf(baseAdUnit.getVideoCommon().video_time));
                        hashMap5.put("begin_time", String.valueOf(baseAdUnit.getVideoCommon().begin_time));
                        hashMap5.put(com.umeng.analytics.pro.d.q, String.valueOf(baseAdUnit.getVideoCommon().end_time));
                        hashMap5.put("is_first", String.valueOf(baseAdUnit.getVideoCommon().is_first));
                        hashMap5.put("scene", String.valueOf(baseAdUnit.getVideoCommon().scene));
                        hashMap5.put(com.umeng.analytics.pro.d.y, String.valueOf(baseAdUnit.getVideoCommon().type));
                        hashMap5.put("is_auto_play", String.valueOf(baseAdUnit.getVideoCommon().is_auto_play));
                        hashMap5.put("status", String.valueOf(baseAdUnit.getVideoCommon().status));
                        a(baseAdUnit, "video_pause", null, hashMap5);
                        break;
                    case 11:
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, "play_quarter");
                        str3 = PointCategory.PLAY;
                        str4 = "0.25";
                        hashMap = null;
                        a(baseAdUnit, str3, str4, hashMap);
                        return true;
                    case '\f':
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, "play_two_quarters");
                        str3 = PointCategory.PLAY;
                        str4 = "0.50";
                        hashMap = null;
                        a(baseAdUnit, str3, str4, hashMap);
                        return true;
                    case '\r':
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, "play_three_quarters");
                        str3 = PointCategory.PLAY;
                        str4 = "0.75";
                        hashMap = null;
                        a(baseAdUnit, str3, str4, hashMap);
                        return true;
                    case 14:
                        SigMacroCommon macroCommon5 = baseAdUnit.getMacroCommon();
                        if (macroCommon5 instanceof SigMacroCommon) {
                            macroCommon5.addMarcoKey(SigMacroCommon._VIDEOTIME_, String.valueOf(baseAdUnit.getVideoCommon().video_time));
                            macroCommon5.addMarcoKey(SigMacroCommon._BEGINTIME_, String.valueOf(baseAdUnit.getVideoCommon().begin_time));
                            macroCommon5.addMarcoKey(SigMacroCommon._ENDTIME_, String.valueOf(baseAdUnit.getVideoCommon().end_time));
                            macroCommon5.addMarcoKey(SigMacroCommon._PLAYFIRSTFRAME_, String.valueOf(baseAdUnit.getVideoCommon().is_first));
                            macroCommon5.addMarcoKey(SigMacroCommon._PLAYLASTFRAME_, String.valueOf(baseAdUnit.getVideoCommon().is_last));
                            macroCommon5.addMarcoKey(SigMacroCommon._SCENE_, String.valueOf(baseAdUnit.getVideoCommon().scene));
                            macroCommon5.addMarcoKey(SigMacroCommon._TYPE_, String.valueOf(baseAdUnit.getVideoCommon().type));
                            macroCommon5.addMarcoKey(SigMacroCommon._BEHAVIOR_, String.valueOf(baseAdUnit.getVideoCommon().is_auto_play));
                            macroCommon5.addMarcoKey(SigMacroCommon._STATUS_, String.valueOf(baseAdUnit.getVideoCommon().status));
                        }
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, "complete", true);
                        HashMap<String, String> hashMap6 = new HashMap<>();
                        hashMap6.put("video_time", String.valueOf(baseAdUnit.getVideoCommon().video_time));
                        hashMap6.put("begin_time", String.valueOf(baseAdUnit.getVideoCommon().begin_time));
                        hashMap6.put(com.umeng.analytics.pro.d.q, String.valueOf(baseAdUnit.getVideoCommon().end_time));
                        hashMap6.put("is_first", String.valueOf(baseAdUnit.getVideoCommon().is_first));
                        hashMap6.put("scene", String.valueOf(baseAdUnit.getVideoCommon().scene));
                        hashMap6.put(com.umeng.analytics.pro.d.y, String.valueOf(baseAdUnit.getVideoCommon().type));
                        hashMap6.put("is_auto_play", String.valueOf(baseAdUnit.getVideoCommon().is_auto_play));
                        hashMap6.put("status", String.valueOf(baseAdUnit.getVideoCommon().status));
                        a(baseAdUnit, "complete", null, hashMap6);
                        return true;
                    case 15:
                        String str7 = baseAdUnit.getClickCommon().is_final_click ? "1" : "0";
                        SigMacroCommon macroCommon6 = baseAdUnit.getMacroCommon();
                        if (macroCommon6 instanceof SigMacroCommon) {
                            macroCommon6.addMarcoKey(SigMacroCommon._TEMPLATE_, String.valueOf(baseAdUnit.getTemplateId()));
                            macroCommon6.addMarcoKey(SigMacroCommon._CLICKAREA_, String.valueOf(baseAdUnit.getClickCommon().click_area));
                            macroCommon6.addMarcoKey(SigMacroCommon._CLICKSCENE_, String.valueOf(baseAdUnit.getClickCommon().click_scene));
                            macroCommon6.addMarcoKey(SigMacroCommon._FINALCLICK_, str7);
                        }
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, "click");
                        hashMap = new HashMap<>();
                        hashMap.put("click_area", baseAdUnit.getClickCommon().click_area);
                        hashMap.put("click_scene", baseAdUnit.getClickCommon().click_scene);
                        hashMap.put("template_id", String.valueOf(baseAdUnit.getTemplateId()));
                        hashMap.put("cwidth", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealWidthDip()));
                        hashMap.put("cheight", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealHeightDip()));
                        hashMap.put("is_final_click", str7);
                        hashMap.put("coordinate", macroCommon6.getCoordinate());
                        str3 = baseAdUnit.getClickCommon().click_scene;
                        str4 = "click";
                        a(baseAdUnit, str3, str4, hashMap);
                        return true;
                    case 16:
                        str5 = PointCategory.FOURELEMENTS;
                        str6 = "show";
                        a(baseAdUnit, str5, str6, null);
                        return true;
                    case 17:
                        str5 = PointCategory.FOURELEMENTS;
                        str6 = PointCategory.CLOSE;
                        a(baseAdUnit, str5, str6, null);
                        return true;
                    default:
                        return true;
                }
            } catch (Throwable unused2) {
                return true;
            }
        } catch (Throwable unused3) {
            return true;
        }
    }

    @Override // com.sigmob.sdk.base.common.s
    public boolean a(BaseAdUnit baseAdUnit, boolean z, int i) {
        return false;
    }

    @Override // com.sigmob.sdk.base.common.s
    public boolean b(BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.base.network.g.a(baseAdUnit, "ad_close");
        a(baseAdUnit, "ad_close", null, null);
        return true;
    }
}
