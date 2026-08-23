package com.sigmob.sdk.base.common;

import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.mta.PointEntitySigmob;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class af implements s {
    private boolean b;

    /* renamed from: c, reason: collision with root package name */
    private int f364c;
    private int a = 0;
    private int d = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int i) {
        return i == 0 ? "0" : String.valueOf(i / 1000);
    }

    private void a(final BaseAdUnit baseAdUnit, final String str, final int i, String str2) {
        ae.a(str, str2, baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.af.2
            @Override // com.sigmob.sdk.base.common.ae.a
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                    af afVar = af.this;
                    pointEntitySigmob.setVtime(afVar.b(afVar.a));
                    af afVar2 = af.this;
                    pointEntitySigmob.setSkip_show_time(afVar2.b(afVar2.f364c));
                    pointEntitySigmob.setCurrent_time(af.this.b(i));
                    pointEntitySigmob.setPlay_process(String.valueOf((i * 1.0d) / af.this.b()));
                    if (str.equals("start")) {
                        pointEntitySigmob.setScene_id(baseAdUnit.getAd_scene_id());
                        pointEntitySigmob.setScene_desc(baseAdUnit.getAd_scene_desc());
                        pointEntitySigmob.setBid_token(baseAdUnit.getBid_token());
                    }
                    pointEntitySigmob.setPlay_time(af.this.a(i));
                    pointEntitySigmob.setSet_close_time(String.format("%d", Integer.valueOf(af.this.d)));
                    pointEntitySigmob.setIs_truncation(af.this.a() ? "1" : "0");
                    pointEntitySigmob.setIs_force(af.this.b ? "1" : "0");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        int i = this.d;
        return i > 0 && i * 1000 < this.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        int i = this.d;
        return (i <= 0 || i * 1000 >= this.a) ? this.a : i * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(int i) {
        return i == 0 ? "0" : String.format("%.2f", Float.valueOf(i / 1000.0f));
    }

    private void b(BaseAdUnit baseAdUnit, String str, int i) {
        a(baseAdUnit, str, i, null);
    }

    @Override // com.sigmob.sdk.base.common.s
    public boolean a(BaseAdUnit baseAdUnit) {
        return true;
    }

    @Override // com.sigmob.sdk.base.common.s
    public boolean a(BaseAdUnit baseAdUnit, int i, int i2) {
        this.a = i;
        this.d = baseAdUnit.getEndTime();
        SigMacroCommon macroCommon = baseAdUnit.getMacroCommon();
        if (!(macroCommon instanceof SigMacroCommon)) {
            return true;
        }
        macroCommon.addMarcoKey(SigMacroCommon._VIDEOTIME_, a(this.a));
        return true;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:82:0x0155. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:218:0x050c A[Catch: all -> 0x0828, TryCatch #0 {all -> 0x0828, blocks: (B:3:0x0009, B:6:0x001e, B:9:0x002a, B:12:0x0036, B:15:0x0042, B:18:0x004e, B:21:0x005a, B:24:0x0063, B:27:0x006c, B:30:0x0075, B:33:0x007e, B:36:0x008a, B:39:0x0096, B:42:0x00a2, B:45:0x00ae, B:48:0x00b9, B:51:0x00c4, B:54:0x00cd, B:57:0x00d8, B:60:0x00e3, B:63:0x00ee, B:66:0x00f8, B:69:0x0101, B:72:0x010c, B:75:0x0117, B:78:0x0122, B:83:0x0158, B:84:0x0824, B:87:0x015d, B:89:0x0162, B:91:0x016f, B:93:0x017d, B:95:0x0182, B:97:0x018f, B:99:0x019e, B:101:0x01ab, B:103:0x01ba, B:105:0x01c7, B:107:0x01d6, B:109:0x01db, B:111:0x01e1, B:114:0x01f0, B:116:0x01f7, B:118:0x01fe, B:121:0x0208, B:122:0x020e, B:124:0x0219, B:127:0x021f, B:128:0x0231, B:129:0x022e, B:130:0x0242, B:134:0x0249, B:135:0x024f, B:139:0x0258, B:140:0x025e, B:142:0x0269, B:143:0x0275, B:146:0x027a, B:148:0x0282, B:151:0x0291, B:152:0x02a3, B:153:0x02a0, B:156:0x02bb, B:157:0x02bf, B:160:0x02cd, B:162:0x02d1, B:164:0x02fb, B:165:0x0308, B:167:0x0314, B:168:0x0323, B:170:0x032f, B:171:0x033e, B:174:0x0350, B:175:0x035f, B:180:0x0370, B:181:0x0374, B:184:0x0382, B:186:0x038c, B:188:0x03b6, B:189:0x03c1, B:191:0x03cd, B:192:0x03da, B:194:0x03e6, B:195:0x03f3, B:198:0x0403, B:199:0x0414, B:200:0x0419, B:205:0x0430, B:206:0x0436, B:209:0x0442, B:211:0x044c, B:214:0x0482, B:215:0x04b7, B:216:0x0506, B:218:0x050c, B:219:0x0517, B:221:0x0523, B:222:0x0530, B:224:0x053c, B:225:0x0549, B:228:0x0559, B:229:0x056a, B:230:0x04bb, B:232:0x04c9, B:233:0x04f4, B:234:0x056f, B:236:0x05cc, B:237:0x05f5, B:238:0x0626, B:240:0x05f9, B:242:0x0607, B:247:0x068b, B:248:0x068f, B:251:0x069d, B:253:0x06a7, B:255:0x06d1, B:256:0x06dc, B:258:0x06e8, B:259:0x06f5, B:261:0x0701, B:262:0x070e, B:265:0x071e, B:266:0x072f, B:271:0x073d, B:272:0x0741, B:274:0x0750, B:277:0x075d, B:278:0x076c, B:279:0x076f, B:282:0x0776, B:284:0x0780, B:289:0x0789, B:291:0x0791, B:295:0x0798, B:300:0x07a7, B:303:0x07b0, B:305:0x07be, B:308:0x07cb, B:309:0x07da, B:310:0x07dd, B:312:0x07e1, B:314:0x07f1, B:317:0x0820), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0523 A[Catch: all -> 0x0828, TryCatch #0 {all -> 0x0828, blocks: (B:3:0x0009, B:6:0x001e, B:9:0x002a, B:12:0x0036, B:15:0x0042, B:18:0x004e, B:21:0x005a, B:24:0x0063, B:27:0x006c, B:30:0x0075, B:33:0x007e, B:36:0x008a, B:39:0x0096, B:42:0x00a2, B:45:0x00ae, B:48:0x00b9, B:51:0x00c4, B:54:0x00cd, B:57:0x00d8, B:60:0x00e3, B:63:0x00ee, B:66:0x00f8, B:69:0x0101, B:72:0x010c, B:75:0x0117, B:78:0x0122, B:83:0x0158, B:84:0x0824, B:87:0x015d, B:89:0x0162, B:91:0x016f, B:93:0x017d, B:95:0x0182, B:97:0x018f, B:99:0x019e, B:101:0x01ab, B:103:0x01ba, B:105:0x01c7, B:107:0x01d6, B:109:0x01db, B:111:0x01e1, B:114:0x01f0, B:116:0x01f7, B:118:0x01fe, B:121:0x0208, B:122:0x020e, B:124:0x0219, B:127:0x021f, B:128:0x0231, B:129:0x022e, B:130:0x0242, B:134:0x0249, B:135:0x024f, B:139:0x0258, B:140:0x025e, B:142:0x0269, B:143:0x0275, B:146:0x027a, B:148:0x0282, B:151:0x0291, B:152:0x02a3, B:153:0x02a0, B:156:0x02bb, B:157:0x02bf, B:160:0x02cd, B:162:0x02d1, B:164:0x02fb, B:165:0x0308, B:167:0x0314, B:168:0x0323, B:170:0x032f, B:171:0x033e, B:174:0x0350, B:175:0x035f, B:180:0x0370, B:181:0x0374, B:184:0x0382, B:186:0x038c, B:188:0x03b6, B:189:0x03c1, B:191:0x03cd, B:192:0x03da, B:194:0x03e6, B:195:0x03f3, B:198:0x0403, B:199:0x0414, B:200:0x0419, B:205:0x0430, B:206:0x0436, B:209:0x0442, B:211:0x044c, B:214:0x0482, B:215:0x04b7, B:216:0x0506, B:218:0x050c, B:219:0x0517, B:221:0x0523, B:222:0x0530, B:224:0x053c, B:225:0x0549, B:228:0x0559, B:229:0x056a, B:230:0x04bb, B:232:0x04c9, B:233:0x04f4, B:234:0x056f, B:236:0x05cc, B:237:0x05f5, B:238:0x0626, B:240:0x05f9, B:242:0x0607, B:247:0x068b, B:248:0x068f, B:251:0x069d, B:253:0x06a7, B:255:0x06d1, B:256:0x06dc, B:258:0x06e8, B:259:0x06f5, B:261:0x0701, B:262:0x070e, B:265:0x071e, B:266:0x072f, B:271:0x073d, B:272:0x0741, B:274:0x0750, B:277:0x075d, B:278:0x076c, B:279:0x076f, B:282:0x0776, B:284:0x0780, B:289:0x0789, B:291:0x0791, B:295:0x0798, B:300:0x07a7, B:303:0x07b0, B:305:0x07be, B:308:0x07cb, B:309:0x07da, B:310:0x07dd, B:312:0x07e1, B:314:0x07f1, B:317:0x0820), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x053c A[Catch: all -> 0x0828, TryCatch #0 {all -> 0x0828, blocks: (B:3:0x0009, B:6:0x001e, B:9:0x002a, B:12:0x0036, B:15:0x0042, B:18:0x004e, B:21:0x005a, B:24:0x0063, B:27:0x006c, B:30:0x0075, B:33:0x007e, B:36:0x008a, B:39:0x0096, B:42:0x00a2, B:45:0x00ae, B:48:0x00b9, B:51:0x00c4, B:54:0x00cd, B:57:0x00d8, B:60:0x00e3, B:63:0x00ee, B:66:0x00f8, B:69:0x0101, B:72:0x010c, B:75:0x0117, B:78:0x0122, B:83:0x0158, B:84:0x0824, B:87:0x015d, B:89:0x0162, B:91:0x016f, B:93:0x017d, B:95:0x0182, B:97:0x018f, B:99:0x019e, B:101:0x01ab, B:103:0x01ba, B:105:0x01c7, B:107:0x01d6, B:109:0x01db, B:111:0x01e1, B:114:0x01f0, B:116:0x01f7, B:118:0x01fe, B:121:0x0208, B:122:0x020e, B:124:0x0219, B:127:0x021f, B:128:0x0231, B:129:0x022e, B:130:0x0242, B:134:0x0249, B:135:0x024f, B:139:0x0258, B:140:0x025e, B:142:0x0269, B:143:0x0275, B:146:0x027a, B:148:0x0282, B:151:0x0291, B:152:0x02a3, B:153:0x02a0, B:156:0x02bb, B:157:0x02bf, B:160:0x02cd, B:162:0x02d1, B:164:0x02fb, B:165:0x0308, B:167:0x0314, B:168:0x0323, B:170:0x032f, B:171:0x033e, B:174:0x0350, B:175:0x035f, B:180:0x0370, B:181:0x0374, B:184:0x0382, B:186:0x038c, B:188:0x03b6, B:189:0x03c1, B:191:0x03cd, B:192:0x03da, B:194:0x03e6, B:195:0x03f3, B:198:0x0403, B:199:0x0414, B:200:0x0419, B:205:0x0430, B:206:0x0436, B:209:0x0442, B:211:0x044c, B:214:0x0482, B:215:0x04b7, B:216:0x0506, B:218:0x050c, B:219:0x0517, B:221:0x0523, B:222:0x0530, B:224:0x053c, B:225:0x0549, B:228:0x0559, B:229:0x056a, B:230:0x04bb, B:232:0x04c9, B:233:0x04f4, B:234:0x056f, B:236:0x05cc, B:237:0x05f5, B:238:0x0626, B:240:0x05f9, B:242:0x0607, B:247:0x068b, B:248:0x068f, B:251:0x069d, B:253:0x06a7, B:255:0x06d1, B:256:0x06dc, B:258:0x06e8, B:259:0x06f5, B:261:0x0701, B:262:0x070e, B:265:0x071e, B:266:0x072f, B:271:0x073d, B:272:0x0741, B:274:0x0750, B:277:0x075d, B:278:0x076c, B:279:0x076f, B:282:0x0776, B:284:0x0780, B:289:0x0789, B:291:0x0791, B:295:0x0798, B:300:0x07a7, B:303:0x07b0, B:305:0x07be, B:308:0x07cb, B:309:0x07da, B:310:0x07dd, B:312:0x07e1, B:314:0x07f1, B:317:0x0820), top: B:2:0x0009 }] */
    @Override // com.sigmob.sdk.base.common.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(com.sigmob.sdk.base.models.BaseAdUnit r25, java.lang.String r26, int r27) {
        /*
            Method dump skipped, instructions count: 2254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.common.af.a(com.sigmob.sdk.base.models.BaseAdUnit, java.lang.String, int):boolean");
    }

    @Override // com.sigmob.sdk.base.common.s
    public boolean a(BaseAdUnit baseAdUnit, boolean z, int i) {
        this.b = z;
        this.f364c = i;
        return true;
    }

    @Override // com.sigmob.sdk.base.common.s
    public boolean b(BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.base.network.g.a(baseAdUnit, "ad_close");
        a(baseAdUnit, "ad_close", b(), null);
        return true;
    }
}
