package com.sigmob.sdk.splash;

import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.s;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class j implements s {
    private void a(BaseAdUnit baseAdUnit, String str, String str2, final HashMap<String, String> hashMap) {
        ae.a(str, str2, baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.splash.j.1
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

    @Override // com.sigmob.sdk.base.common.s
    public boolean a(BaseAdUnit baseAdUnit, String str, int i) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        char c2 = 65535;
        try {
            switch (str.hashCode()) {
                case -981662273:
                    if (str.equals(com.sigmob.sdk.base.common.a.f)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -381416586:
                    if (str.equals(com.sigmob.sdk.base.common.a.g)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 3532159:
                    if (str.equals("skip")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 94750088:
                    if (str.equals("click")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 109757538:
                    if (str.equals("start")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                com.sigmob.sdk.base.network.g.a(baseAdUnit, "start");
                a(baseAdUnit, "start", null, null);
            } else if (c2 == 1) {
                com.sigmob.sdk.base.network.g.a(baseAdUnit, "skip");
                a(baseAdUnit, "skip", null, null);
            } else if (c2 != 2) {
                if (c2 != 3) {
                    str6 = c2 == 4 ? PointCategory.CLOSE : "show";
                }
                a(baseAdUnit, PointCategory.FOURELEMENTS, str6, null);
            } else {
                String str7 = baseAdUnit.getClickCommon().is_final_click ? "1" : "0";
                SigMacroCommon macroCommon = baseAdUnit.getMacroCommon();
                if (macroCommon instanceof SigMacroCommon) {
                    macroCommon.addMarcoKey(SigMacroCommon._SLD_, baseAdUnit.getClickCommon().sld);
                    macroCommon.addMarcoKey("_AX_", baseAdUnit.getClickCommon().adarea_x);
                    macroCommon.addMarcoKey("_AY_", baseAdUnit.getClickCommon().adarea_y);
                    macroCommon.addMarcoKey("_AW_", baseAdUnit.getClickCommon().adarea_w);
                    macroCommon.addMarcoKey("_AH_", baseAdUnit.getClickCommon().adarea_h);
                    if ("5".equals(baseAdUnit.getClickCommon().sld)) {
                        macroCommon.updateClickMarco("-999", "-999", "-999", "-999");
                        macroCommon.addMarcoKey("_TURNX_", baseAdUnit.getClickCommon().turn_x);
                        macroCommon.addMarcoKey("_TURNY_", baseAdUnit.getClickCommon().turn_y);
                        macroCommon.addMarcoKey("_TURNZ_", baseAdUnit.getClickCommon().turn_z);
                        str4 = "_TURNTIME_";
                        str5 = baseAdUnit.getClickCommon().turn_time;
                    } else if ("2".equals(baseAdUnit.getClickCommon().sld)) {
                        macroCommon.updateClickMarco("-999", "-999", "-999", "-999");
                        macroCommon.addMarcoKey("_XMAXACC_", baseAdUnit.getClickCommon().x_max_acc);
                        macroCommon.addMarcoKey("_YMAXACC_", baseAdUnit.getClickCommon().y_max_acc);
                        str4 = "_ZMAXACC_";
                        str5 = baseAdUnit.getClickCommon().z_max_acc;
                    } else {
                        macroCommon.updateClickMarco(baseAdUnit.getClickCommon().down, baseAdUnit.getClickCommon().up);
                        macroCommon.addMarcoKey(SigMacroCommon._TEMPLATE_, String.valueOf(baseAdUnit.getTemplateId()));
                        macroCommon.addMarcoKey(SigMacroCommon._CLICKAREA_, String.valueOf(baseAdUnit.getClickCommon().click_area));
                        macroCommon.addMarcoKey(SigMacroCommon._CLICKSCENE_, String.valueOf(baseAdUnit.getClickCommon().click_scene));
                        macroCommon.addMarcoKey(SigMacroCommon._FINALCLICK_, str7);
                    }
                    macroCommon.addMarcoKey(str4, str5);
                    macroCommon.addMarcoKey(SigMacroCommon._TEMPLATE_, String.valueOf(baseAdUnit.getTemplateId()));
                    macroCommon.addMarcoKey(SigMacroCommon._CLICKAREA_, String.valueOf(baseAdUnit.getClickCommon().click_area));
                    macroCommon.addMarcoKey(SigMacroCommon._CLICKSCENE_, String.valueOf(baseAdUnit.getClickCommon().click_scene));
                    macroCommon.addMarcoKey(SigMacroCommon._FINALCLICK_, str7);
                }
                com.sigmob.sdk.base.network.g.a(baseAdUnit, "click");
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("template_id", baseAdUnit.getClickCommon().template_id);
                hashMap.put("sld", baseAdUnit.getClickCommon().sld);
                hashMap.put("adarea_x", baseAdUnit.getClickCommon().adarea_x);
                hashMap.put("adarea_y", baseAdUnit.getClickCommon().adarea_y);
                hashMap.put("adarea_w", baseAdUnit.getClickCommon().adarea_w);
                hashMap.put("adarea_h", baseAdUnit.getClickCommon().adarea_h);
                if ("5".equals(baseAdUnit.getClickCommon().sld)) {
                    hashMap.put("turn_x", baseAdUnit.getClickCommon().turn_x);
                    hashMap.put("turn_y", baseAdUnit.getClickCommon().turn_y);
                    hashMap.put("turn_z", baseAdUnit.getClickCommon().turn_z);
                    str2 = "turn_time";
                    str3 = baseAdUnit.getClickCommon().turn_time;
                } else {
                    if ("2".equals(baseAdUnit.getClickCommon().sld)) {
                        hashMap.put("x_max_acc", baseAdUnit.getClickCommon().x_max_acc);
                        hashMap.put("y_max_acc", baseAdUnit.getClickCommon().y_max_acc);
                        str2 = "z_max_acc";
                        str3 = baseAdUnit.getClickCommon().z_max_acc;
                    }
                    hashMap.put("click_area", baseAdUnit.getClickCommon().click_area);
                    hashMap.put("click_scene", baseAdUnit.getClickCommon().click_scene);
                    hashMap.put("cwidth", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealWidthDip()));
                    hashMap.put("cheight", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealHeightDip()));
                    hashMap.put("is_final_click", str7);
                    hashMap.put("coordinate", macroCommon.getCoordinate());
                    a(baseAdUnit, baseAdUnit.getClickCommon().click_scene, "click", hashMap);
                }
                hashMap.put(str2, str3);
                hashMap.put("click_area", baseAdUnit.getClickCommon().click_area);
                hashMap.put("click_scene", baseAdUnit.getClickCommon().click_scene);
                hashMap.put("cwidth", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealWidthDip()));
                hashMap.put("cheight", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealHeightDip()));
                hashMap.put("is_final_click", str7);
                hashMap.put("coordinate", macroCommon.getCoordinate());
                a(baseAdUnit, baseAdUnit.getClickCommon().click_scene, "click", hashMap);
            }
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
        return true;
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
