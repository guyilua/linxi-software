package com.sigmob.sdk.nativead;

import com.czhj.sdk.common.ClientMetadata;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e implements com.sigmob.sdk.base.common.s {
    private void a(BaseAdUnit baseAdUnit, String str, String str2, final HashMap<String, String> hashMap) {
        ae.a(str, str2, baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.nativead.e.1
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
    /* JADX WARN: Failed to find 'out' block for switch in B:50:0x00d6. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.HashMap, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v5 */
    @Override // com.sigmob.sdk.base.common.s
    public boolean a(BaseAdUnit baseAdUnit, String str, int i) {
        HashMap<String, String> hashMap;
        e eVar;
        String str2;
        ?? r2;
        String str3;
        HashMap<String, String> hashMap2;
        String str4;
        String str5;
        String str6;
        String valueOf;
        String str7;
        String str8;
        char c2 = 65535;
        try {
            switch (str.hashCode()) {
                case -2050793311:
                    if (str.equals("play_quarter")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -1618089666:
                    if (str.equals("video_link")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1170756021:
                    if (str.equals("video_restart")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1152604194:
                    if (str.equals("ad_hide")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1152277095:
                    if (str.equals("ad_show")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -981662273:
                    if (str.equals(com.sigmob.sdk.base.common.a.f)) {
                        c2 = '\f';
                        break;
                    }
                    break;
                case -599445191:
                    if (str.equals("complete")) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case -381416586:
                    if (str.equals(com.sigmob.sdk.base.common.a.g)) {
                        c2 = '\r';
                        break;
                    }
                    break;
                case -236894925:
                    if (str.equals("play_three_quarters")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case 94750088:
                    if (str.equals("click")) {
                        c2 = 11;
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
                        c2 = '\b';
                        break;
                    }
                    break;
                case 1382290738:
                    if (str.equals("video_pause")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1385608094:
                    if (str.equals("video_start")) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            hashMap = null;
        } catch (Throwable unused) {
        }
        try {
            try {
                switch (c2) {
                    case 0:
                        eVar = this;
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, "start");
                        str2 = "start";
                        r2 = 0;
                        eVar.a(baseAdUnit, str2, r2, r2);
                        return true;
                    case 1:
                        eVar = this;
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, "ad_show");
                        str2 = "ad_show";
                        r2 = 0;
                        eVar.a(baseAdUnit, str2, r2, r2);
                        return true;
                    case 2:
                        eVar = this;
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, "ad_hide");
                        str2 = "ad_hide";
                        r2 = 0;
                        eVar.a(baseAdUnit, str2, r2, r2);
                        return true;
                    case 3:
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
                        str3 = "video_link";
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, str3, true);
                        hashMap2 = new HashMap<>();
                        hashMap2.put("video_time", String.valueOf(baseAdUnit.getVideoCommon().video_time));
                        hashMap2.put("begin_time", String.valueOf(baseAdUnit.getVideoCommon().begin_time));
                        hashMap2.put(com.umeng.analytics.pro.d.q, String.valueOf(baseAdUnit.getVideoCommon().end_time));
                        hashMap2.put("is_first", String.valueOf(baseAdUnit.getVideoCommon().is_first));
                        hashMap2.put("scene", String.valueOf(baseAdUnit.getVideoCommon().scene));
                        hashMap2.put(com.umeng.analytics.pro.d.y, String.valueOf(baseAdUnit.getVideoCommon().type));
                        hashMap2.put("is_auto_play", String.valueOf(baseAdUnit.getVideoCommon().is_auto_play));
                        hashMap2.put("status", String.valueOf(baseAdUnit.getVideoCommon().status));
                        a(baseAdUnit, str3, null, hashMap2);
                        return true;
                    case 4:
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
                        str3 = "video_restart";
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, str3);
                        hashMap2 = new HashMap<>();
                        hashMap2.put("video_time", String.valueOf(baseAdUnit.getVideoCommon().video_time));
                        hashMap2.put("begin_time", String.valueOf(baseAdUnit.getVideoCommon().begin_time));
                        hashMap2.put(com.umeng.analytics.pro.d.q, String.valueOf(baseAdUnit.getVideoCommon().end_time));
                        hashMap2.put("is_first", String.valueOf(baseAdUnit.getVideoCommon().is_first));
                        hashMap2.put("scene", String.valueOf(baseAdUnit.getVideoCommon().scene));
                        hashMap2.put(com.umeng.analytics.pro.d.y, String.valueOf(baseAdUnit.getVideoCommon().type));
                        hashMap2.put("is_auto_play", String.valueOf(baseAdUnit.getVideoCommon().is_auto_play));
                        hashMap2.put("status", String.valueOf(baseAdUnit.getVideoCommon().status));
                        a(baseAdUnit, str3, null, hashMap2);
                        return true;
                    case 5:
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
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, "video_start");
                        HashMap<String, String> hashMap3 = new HashMap<>();
                        hashMap3.put("video_time", String.valueOf(baseAdUnit.getVideoCommon().video_time));
                        hashMap3.put("begin_time", String.valueOf(baseAdUnit.getVideoCommon().begin_time));
                        hashMap3.put(com.umeng.analytics.pro.d.q, String.valueOf(baseAdUnit.getVideoCommon().end_time));
                        hashMap3.put("is_first", String.valueOf(baseAdUnit.getVideoCommon().is_first));
                        hashMap3.put("scene", String.valueOf(baseAdUnit.getVideoCommon().scene));
                        hashMap3.put(com.umeng.analytics.pro.d.y, String.valueOf(baseAdUnit.getVideoCommon().type));
                        hashMap3.put("is_auto_play", String.valueOf(baseAdUnit.getVideoCommon().is_auto_play));
                        hashMap3.put("status", String.valueOf(baseAdUnit.getVideoCommon().status));
                        a(baseAdUnit, "video_start", null, hashMap3);
                        break;
                    case 6:
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
                        HashMap<String, String> hashMap4 = new HashMap<>();
                        hashMap4.put("video_time", String.valueOf(baseAdUnit.getVideoCommon().video_time));
                        hashMap4.put("begin_time", String.valueOf(baseAdUnit.getVideoCommon().begin_time));
                        hashMap4.put(com.umeng.analytics.pro.d.q, String.valueOf(baseAdUnit.getVideoCommon().end_time));
                        hashMap4.put("is_first", String.valueOf(baseAdUnit.getVideoCommon().is_first));
                        hashMap4.put("scene", String.valueOf(baseAdUnit.getVideoCommon().scene));
                        hashMap4.put(com.umeng.analytics.pro.d.y, String.valueOf(baseAdUnit.getVideoCommon().type));
                        hashMap4.put("is_auto_play", String.valueOf(baseAdUnit.getVideoCommon().is_auto_play));
                        hashMap4.put("status", String.valueOf(baseAdUnit.getVideoCommon().status));
                        a(baseAdUnit, "video_pause", null, hashMap4);
                        break;
                    case 7:
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, "play_quarter");
                        str4 = PointCategory.PLAY;
                        str5 = "0.25";
                        hashMap = null;
                        a(baseAdUnit, str4, str5, hashMap);
                        return true;
                    case '\b':
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, "play_two_quarters");
                        str4 = PointCategory.PLAY;
                        str5 = "0.50";
                        hashMap = null;
                        a(baseAdUnit, str4, str5, hashMap);
                        return true;
                    case '\t':
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, "play_three_quarters");
                        str4 = PointCategory.PLAY;
                        str5 = "0.75";
                        hashMap = null;
                        a(baseAdUnit, str4, str5, hashMap);
                        return true;
                    case '\n':
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
                        HashMap<String, String> hashMap5 = new HashMap<>();
                        hashMap5.put("video_time", String.valueOf(baseAdUnit.getVideoCommon().video_time));
                        hashMap5.put("begin_time", String.valueOf(baseAdUnit.getVideoCommon().begin_time));
                        hashMap5.put(com.umeng.analytics.pro.d.q, String.valueOf(baseAdUnit.getVideoCommon().end_time));
                        hashMap5.put("is_first", String.valueOf(baseAdUnit.getVideoCommon().is_first));
                        hashMap5.put("scene", String.valueOf(baseAdUnit.getVideoCommon().scene));
                        hashMap5.put(com.umeng.analytics.pro.d.y, String.valueOf(baseAdUnit.getVideoCommon().type));
                        hashMap5.put("is_auto_play", String.valueOf(baseAdUnit.getVideoCommon().is_auto_play));
                        hashMap5.put("status", String.valueOf(baseAdUnit.getVideoCommon().status));
                        a(baseAdUnit, "complete", null, hashMap5);
                        return true;
                    case 11:
                        String str9 = baseAdUnit.getClickCommon().is_final_click ? "1" : "0";
                        SigMacroCommon macroCommon6 = baseAdUnit.getMacroCommon();
                        if (macroCommon6 instanceof SigMacroCommon) {
                            macroCommon6.addMarcoKey(SigMacroCommon._SLD_, baseAdUnit.getClickCommon().sld);
                            macroCommon6.addMarcoKey("_AX_", baseAdUnit.getClickCommon().adarea_x);
                            macroCommon6.addMarcoKey("_AY_", baseAdUnit.getClickCommon().adarea_y);
                            macroCommon6.addMarcoKey("_AW_", baseAdUnit.getClickCommon().adarea_w);
                            macroCommon6.addMarcoKey("_AH_", baseAdUnit.getClickCommon().adarea_h);
                            if ("5".equals(baseAdUnit.getClickCommon().sld)) {
                                macroCommon6.updateClickMarco("-999", "-999", "-999", "-999");
                                macroCommon6.addMarcoKey("_TURNX_", baseAdUnit.getClickCommon().turn_x);
                                macroCommon6.addMarcoKey("_TURNY_", baseAdUnit.getClickCommon().turn_y);
                                macroCommon6.addMarcoKey("_TURNZ_", baseAdUnit.getClickCommon().turn_z);
                                macroCommon6.addMarcoKey("_TURNTIME_", baseAdUnit.getClickCommon().turn_time);
                                str7 = "_CPTIDS_";
                                str8 = String.valueOf(baseAdUnit.getClickCommon().widget_id);
                            } else if ("2".equals(baseAdUnit.getClickCommon().sld)) {
                                macroCommon6.updateClickMarco("-999", "-999", "-999", "-999");
                                macroCommon6.addMarcoKey("_CPTIDS_", String.valueOf(baseAdUnit.getClickCommon().widget_id));
                                macroCommon6.addMarcoKey("_XMAXACC_", baseAdUnit.getClickCommon().x_max_acc);
                                macroCommon6.addMarcoKey("_YMAXACC_", baseAdUnit.getClickCommon().y_max_acc);
                                str7 = "_ZMAXACC_";
                                str8 = baseAdUnit.getClickCommon().z_max_acc;
                            } else {
                                macroCommon6.updateClickMarco(baseAdUnit.getClickCommon().down, baseAdUnit.getClickCommon().up);
                                macroCommon6.addMarcoKey(SigMacroCommon._TEMPLATE_, String.valueOf(baseAdUnit.getTemplateId()));
                                macroCommon6.addMarcoKey(SigMacroCommon._CLICKAREA_, String.valueOf(baseAdUnit.getClickCommon().click_area));
                                macroCommon6.addMarcoKey(SigMacroCommon._CLICKSCENE_, String.valueOf(baseAdUnit.getClickCommon().click_scene));
                                macroCommon6.addMarcoKey(SigMacroCommon._FINALCLICK_, str9);
                            }
                            macroCommon6.addMarcoKey(str7, str8);
                            macroCommon6.addMarcoKey(SigMacroCommon._TEMPLATE_, String.valueOf(baseAdUnit.getTemplateId()));
                            macroCommon6.addMarcoKey(SigMacroCommon._CLICKAREA_, String.valueOf(baseAdUnit.getClickCommon().click_area));
                            macroCommon6.addMarcoKey(SigMacroCommon._CLICKSCENE_, String.valueOf(baseAdUnit.getClickCommon().click_scene));
                            macroCommon6.addMarcoKey(SigMacroCommon._FINALCLICK_, str9);
                        }
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, "click");
                        hashMap = new HashMap<>();
                        hashMap.put("template_id", baseAdUnit.getClickCommon().template_id);
                        hashMap.put("sld", baseAdUnit.getClickCommon().sld);
                        hashMap.put("adarea_x", baseAdUnit.getClickCommon().adarea_x);
                        hashMap.put("adarea_y", baseAdUnit.getClickCommon().adarea_y);
                        hashMap.put("adarea_w", baseAdUnit.getClickCommon().adarea_w);
                        hashMap.put("adarea_h", baseAdUnit.getClickCommon().adarea_h);
                        if (!"5".equals(baseAdUnit.getClickCommon().sld)) {
                            if ("2".equals(baseAdUnit.getClickCommon().sld)) {
                                hashMap.put("x_max_acc", baseAdUnit.getClickCommon().x_max_acc);
                                hashMap.put("y_max_acc", baseAdUnit.getClickCommon().y_max_acc);
                                hashMap.put("z_max_acc", baseAdUnit.getClickCommon().z_max_acc);
                                str6 = "cpt_id";
                                valueOf = String.valueOf(baseAdUnit.getClickCommon().widget_id);
                            }
                            hashMap.put("click_area", baseAdUnit.getClickCommon().click_area);
                            hashMap.put("click_scene", baseAdUnit.getClickCommon().click_scene);
                            hashMap.put("cwidth", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealWidthDip()));
                            hashMap.put("cheight", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealHeightDip()));
                            hashMap.put("is_final_click", str9);
                            hashMap.put("coordinate", macroCommon6.getCoordinate());
                            str4 = baseAdUnit.getClickCommon().click_scene;
                            str5 = "click";
                            a(baseAdUnit, str4, str5, hashMap);
                            return true;
                        }
                        hashMap.put("turn_x", baseAdUnit.getClickCommon().turn_x);
                        hashMap.put("turn_y", baseAdUnit.getClickCommon().turn_y);
                        hashMap.put("turn_z", baseAdUnit.getClickCommon().turn_z);
                        hashMap.put("cpt_id", String.valueOf(baseAdUnit.getClickCommon().widget_id));
                        str6 = "turn_time";
                        valueOf = baseAdUnit.getClickCommon().turn_time;
                        hashMap.put(str6, valueOf);
                        hashMap.put("click_area", baseAdUnit.getClickCommon().click_area);
                        hashMap.put("click_scene", baseAdUnit.getClickCommon().click_scene);
                        hashMap.put("cwidth", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealWidthDip()));
                        hashMap.put("cheight", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealHeightDip()));
                        hashMap.put("is_final_click", str9);
                        hashMap.put("coordinate", macroCommon6.getCoordinate());
                        str4 = baseAdUnit.getClickCommon().click_scene;
                        str5 = "click";
                        a(baseAdUnit, str4, str5, hashMap);
                        return true;
                    case '\f':
                        str4 = PointCategory.FOURELEMENTS;
                        str5 = "show";
                        a(baseAdUnit, str4, str5, hashMap);
                        return true;
                    case '\r':
                        str4 = PointCategory.FOURELEMENTS;
                        str5 = PointCategory.CLOSE;
                        a(baseAdUnit, str4, str5, hashMap);
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
        return true;
    }
}
