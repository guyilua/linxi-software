package com.sigmob.sdk.mraid2;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.json.JSONSerializer;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ReflectionUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.Sigmob;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.ah;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.Ad;
import com.sigmob.sdk.base.models.rtb.BidResponse;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.models.rtb.Template;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.mraid2.d;
import com.sigmob.sdk.mraid2.m;
import com.tencent.smtt.sdk.TbsListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c implements i {
    private static String a = "Mraid2Bridge";
    private static m e;
    private static HashMap<String, List<String>> h = new HashMap<>();
    private List<BaseAdUnit> b;

    /* renamed from: c, reason: collision with root package name */
    private b f578c;
    private g d;
    private d.a f;
    private List<BaseAdUnit> g;
    private volatile boolean i;
    private boolean j;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class a {
        private final WeakReference<c> a;

        public a(c cVar) {
            this.a = new WeakReference<>(cVar);
        }

        public c a() {
            return this.a.get();
        }

        @JavascriptInterface
        public String addDclog(JSONObject jSONObject) {
            try {
                if (jSONObject == null) {
                    return c.a(TbsListener.ErrorCode.INFO_CODE_BASE, "not params", (Object) null);
                }
                Log.d(c.a, "----------addDclog----------" + jSONObject);
                final JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null || !optJSONObject.has("_ac_type")) {
                    return c.a(TbsListener.ErrorCode.ERROR_CODE_LOAD_BASE, "_ac_type is empty", (Object) null);
                }
                String optString = optJSONObject.optString("_ac_type");
                BaseAdUnit b = a() != null ? a().b(jSONObject.optString("vid")) : null;
                ae.a(optString, b, b == null ? a().k() : null, new ae.a() { // from class: com.sigmob.sdk.mraid2.c.a.1
                    @Override // com.sigmob.sdk.base.common.ae.a
                    public void a(Object obj) {
                        HashMap hashMap = new HashMap();
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            if (!next.equalsIgnoreCase("_ac_type")) {
                                hashMap.put(next, optJSONObject.optString(next));
                            }
                        }
                        if (obj instanceof PointEntitySigmob) {
                            ((PointEntitySigmob) obj).setOptions(hashMap);
                        }
                    }
                });
                return c.a(200, "add dc log success", (Object) null);
            } catch (Throwable th) {
                return c.a(TbsListener.ErrorCode.INFO_CODE_MINIQB, th.toString(), (Object) null);
            }
        }

        @JavascriptInterface
        public String func(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.has("func") ? jSONObject.getString("func") : null;
                if (TextUtils.isEmpty(string)) {
                    return c.a(TbsListener.ErrorCode.INFO_CODE_BASE, "func is empty", (Object) null);
                }
                ReflectionUtil.MethodBuilder methodBuilder = new ReflectionUtil.MethodBuilder(this, string.replace(":", ""));
                methodBuilder.addParam(JSONObject.class, jSONObject);
                return (String) methodBuilder.execute();
            } catch (Throwable th) {
                return c.a(TbsListener.ErrorCode.INFO_CODE_MINIQB, th.getMessage(), (Object) null);
            }
        }

        @JavascriptInterface
        public String getDeviceInfo() {
            try {
                Log.d(c.a, "---------getDeviceInfo----------");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("clientType", ClientMetadata.getDeviceModel());
                jSONObject.put("osVersion", ClientMetadata.getDeviceOsVersion());
                jSONObject.put("appVersion", ClientMetadata.getInstance().getAppVersion());
                jSONObject.put("width", ClientMetadata.getInstance().getDisplayMetrics().widthPixels);
                jSONObject.put("height", ClientMetadata.getInstance().getDisplayMetrics().heightPixels);
                jSONObject.put("screenDensity", ClientMetadata.getInstance().getDensityDpi());
                jSONObject.put("networkType", ClientMetadata.getInstance().getActiveNetworkType());
                jSONObject.put("pkgName", ClientMetadata.getInstance().getAppPackageName());
                jSONObject.put("userAgent", Networking.getUserAgent());
                jSONObject.put("uid", ClientMetadata.getUid());
                jSONObject.put("udid", ClientMetadata.getInstance().getUDID());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("imei", ClientMetadata.getInstance().getDeviceId());
                jSONObject2.put("androidId", ClientMetadata.getInstance().getAndroidId());
                jSONObject2.put("googleId", ClientMetadata.getInstance().getAdvertisingId());
                jSONObject2.put("oaid", ClientMetadata.getInstance().getOAID());
                jSONObject.put("android", jSONObject2);
                return jSONObject.toString();
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        @JavascriptInterface
        public String getUniqueId() {
            c a = a();
            if (a != null) {
                return a.a().getUniqueId();
            }
            return null;
        }

        @JavascriptInterface
        public String handleMacro(JSONObject jSONObject) {
            String optString;
            JSONObject optJSONObject;
            if (jSONObject == null) {
                return null;
            }
            try {
                Log.d(c.a, "-----------handleMacro---------" + jSONObject);
                optString = jSONObject.optString("event");
                optJSONObject = jSONObject.optJSONObject("args");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (optJSONObject == null) {
                return null;
            }
            String optString2 = optJSONObject.optString("key");
            String optString3 = optJSONObject.optString("value");
            BaseAdUnit b = a() != null ? a().b(optJSONObject.optString("vid")) : null;
            char c2 = 65535;
            switch (optString.hashCode()) {
                case -1253019733:
                    if (optString.equals("addMacro")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -759131257:
                    if (optString.equals("addAllMacros")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -750002817:
                    if (optString.equals("clearMacro")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -310745688:
                    if (optString.equals("removeMacro")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1959477782:
                    if (optString.equals("getMacro")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("maps");
                if (optJSONObject2 != null) {
                    Iterator<String> keys = optJSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        (b != null ? b.getMacroCommon() : Sigmob.getInstance().getMacroCommon()).addMarcoKey(next, optJSONObject2.optString(next));
                    }
                }
            } else if (c2 != 1) {
                if (c2 == 2) {
                    if (TextUtils.isEmpty(optString2)) {
                        return null;
                    }
                    return b != null ? b.getMacroCommon().getMarcoKey(optString2) : Sigmob.getInstance().getMacroCommon().getMarcoKey(optString2);
                }
                if (c2 != 3) {
                    if (c2 == 4) {
                        (b != null ? b.getMacroCommon() : Sigmob.getInstance().getMacroCommon()).clearMacro();
                    }
                } else {
                    if (TextUtils.isEmpty(optString2)) {
                        return null;
                    }
                    (b != null ? b.getMacroCommon() : Sigmob.getInstance().getMacroCommon()).removeMarcoKey(optString2);
                }
            } else {
                if (TextUtils.isEmpty(optString2)) {
                    return null;
                }
                (b != null ? b.getMacroCommon() : Sigmob.getInstance().getMacroCommon()).addMarcoKey(optString2, optString3);
            }
            return null;
        }

        @JavascriptInterface
        public void postMessage(final String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Log.d(c.a, "-----------postMessage---------" + str);
            final c a = a();
            if (a == null || a.d == null) {
                return;
            }
            a.d.post(new Runnable() { // from class: com.sigmob.sdk.mraid2.c.a.3
                @Override // java.lang.Runnable
                public void run() {
                    c cVar = a;
                    cVar.a(cVar, str);
                }
            });
        }

        @JavascriptInterface
        public String storage(String str) {
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Log.d(c.a, "-----------storage---------" + str);
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("event");
            JSONObject optJSONObject = jSONObject.optJSONObject("args");
            int optInt = optJSONObject.optInt(com.umeng.analytics.pro.d.y);
            String optString2 = optJSONObject.optString("key");
            String optString3 = optJSONObject.optString("value");
            if (optInt == 1 || optInt == 2) {
                if (c.e == null) {
                    m unused = c.e = new m(a().d.getContext());
                }
                char c2 = 65535;
                switch (optString.hashCode()) {
                    case -1106363674:
                        if (optString.equals("length")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case -625809843:
                        if (optString.equals("addEventListener")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case -75439223:
                        if (optString.equals("getItem")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 94746189:
                        if (optString.equals("clear")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 1098253751:
                        if (optString.equals("removeItem")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 1984670357:
                        if (optString.equals("setItem")) {
                            c2 = 0;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    c.e.a(optInt, optString2, optString3);
                } else {
                    if (c2 == 1) {
                        return c.e.a(optInt, optString2);
                    }
                    if (c2 == 2) {
                        c.e.b(optInt, optString2);
                    } else if (c2 == 3) {
                        c.e.a(optInt);
                    } else {
                        if (c2 == 4) {
                            return String.valueOf(c.e.b(optInt));
                        }
                        if (c2 == 5) {
                            c.e.a(optInt, optString2, new m.a() { // from class: com.sigmob.sdk.mraid2.c.a.2
                                @Override // com.sigmob.sdk.mraid2.m.a
                                public void a(final JSONObject jSONObject2) {
                                    if (a.this.a() == null || a.this.a().a() == null) {
                                        return;
                                    }
                                    a.this.a().a().post(new Runnable() { // from class: com.sigmob.sdk.mraid2.c.a.2.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            a.this.a().b(jSONObject2);
                                        }
                                    });
                                }
                            });
                        }
                    }
                }
            }
            return null;
        }

        @JavascriptInterface
        public String tracking(JSONObject jSONObject) {
            String str;
            boolean z;
            boolean z2;
            boolean z3;
            int i;
            try {
                if (jSONObject == null) {
                    return c.a(TbsListener.ErrorCode.INFO_CODE_BASE, "not params", (Object) null);
                }
                Log.d(c.a, "---------tracking----------" + jSONObject);
                String optString = jSONObject.optString("event");
                JSONArray optJSONArray = jSONObject.optJSONArray("urls");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                int i2 = 0;
                if (optJSONObject != null) {
                    z2 = optJSONObject.optBoolean("inQueue");
                    z3 = optJSONObject.optBoolean("statistic");
                    i = optJSONObject.optInt("retry");
                    str = optJSONObject.optString("vid");
                    z = optJSONObject.optBoolean("repeat");
                } else {
                    str = "";
                    z = false;
                    z2 = false;
                    z3 = false;
                    i = 0;
                }
                BaseAdUnit b = a() != null ? a().b(str) : null;
                String str2 = "js";
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    while (i2 < optJSONArray.length()) {
                        ah ahVar = new ah(optJSONArray.optString(i2), optString, b != null ? b.getRequestId() : "");
                        ahVar.setRetryNum(Integer.valueOf(i));
                        ahVar.setSource(str2);
                        com.sigmob.sdk.base.network.g.a(ahVar, b, z, z2, z3, null);
                        i2++;
                        str2 = str2;
                    }
                    return c.a(200, "tracking success", (Object) null);
                }
                String str3 = "js";
                List<ah> adTracker = b != null ? b.getAdTracker(optString) : null;
                if (adTracker != null) {
                    for (ah ahVar2 : adTracker) {
                        ahVar2.setRetryNum(Integer.valueOf(i));
                        String str4 = str3;
                        ahVar2.setSource(str4);
                        com.sigmob.sdk.base.network.g.a(ahVar2, b, z, z2, z3, null);
                        str3 = str4;
                    }
                }
                return c.a(TbsListener.ErrorCode.ERROR_CODE_LOAD_BASE, "urls is empty", (Object) null);
            } catch (Throwable th) {
                return c.a(TbsListener.ErrorCode.INFO_CODE_MINIQB, "unknown error: " + th.getMessage(), (Object) null);
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface b {
        void a();

        void a(BaseAdUnit baseAdUnit, JSONObject jSONObject);

        void a(String str);

        void a(String str, JSONObject jSONObject);

        void a(JSONObject jSONObject);

        void b();

        void b(String str, JSONObject jSONObject);

        void b(JSONObject jSONObject);

        void c();

        void c(String str, JSONObject jSONObject);

        void c(JSONObject jSONObject);

        void d();

        void d(JSONObject jSONObject);

        void e(JSONObject jSONObject);

        void f(JSONObject jSONObject);

        void g(JSONObject jSONObject);
    }

    /* renamed from: com.sigmob.sdk.mraid2.c$c, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface InterfaceC0053c {
        void a(g gVar, int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(List<BaseAdUnit> list) {
        LinkedList linkedList = new LinkedList();
        this.g = linkedList;
        this.j = false;
        this.b = list;
        linkedList.addAll(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BidResponse a(List<BaseAdUnit> list) {
        Template build;
        List<MaterialMeta> list2;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Ad ad = list.get(i).getAd();
            ArrayList arrayList2 = new ArrayList();
            if (ad != null && (list2 = ad.materials) != null && list2.size() > 0) {
                MaterialMeta.Builder newBuilder = ad.materials.get(0).newBuilder();
                Template template = newBuilder.main_template;
                if (template != null && template.type.intValue() == 2) {
                    Template build2 = newBuilder.main_template.newBuilder().context(null).build();
                    build2.templateId = newBuilder.main_template.templateId;
                    newBuilder.main_template(build2);
                }
                Template template2 = newBuilder.sub_template;
                if (template2 != null && template2.type.intValue() == 2) {
                    Template build3 = newBuilder.sub_template.newBuilder().context(null).build();
                    build3.templateId = newBuilder.sub_template.templateId;
                    newBuilder.sub_template(build3);
                }
                arrayList2.add(newBuilder.html_snippet(null).build());
                arrayList.add(ad.newBuilder().materials(arrayList2).build());
            }
        }
        BidResponse.Builder builder = new BidResponse.Builder();
        if (list.get(0) != null) {
            if (list.get(0).scene != null) {
                if (list.get(0).scene.type.intValue() == 2) {
                    build = list.get(0).scene.newBuilder().context(null).build();
                    build.templateId = list.get(0).scene.templateId;
                } else {
                    build = list.get(0).scene.newBuilder().build();
                }
                builder.scene(build);
            }
            if (list.get(0).slotAdSetting != null) {
                builder.slot_ad_setting(list.get(0).slotAdSetting.newBuilder().build());
            }
            if (list.get(0).bidding_response != null) {
                builder.bidding_response(list.get(0).bidding_response.newBuilder().build());
            }
            builder.request_id(list.get(0).getRequestId());
            builder.uid(list.get(0).uid);
            builder.expiration_time(Integer.valueOf(list.get(0).expiration_time));
        }
        return builder.ads(arrayList).build();
    }

    public static String a(int i, String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("message", str);
            }
            if (obj != null) {
                jSONObject.put("data", obj);
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01e0 A[Catch: Exception -> 0x04ae, TryCatch #0 {Exception -> 0x04ae, blocks: (B:3:0x0008, B:6:0x003e, B:11:0x019f, B:12:0x01a2, B:15:0x01a7, B:16:0x01ab, B:17:0x01af, B:26:0x01d8, B:28:0x01dc, B:29:0x01e0, B:31:0x01e4, B:32:0x01be, B:35:0x01c8, B:38:0x01e8, B:40:0x01ec, B:43:0x020b, B:45:0x020f, B:46:0x0213, B:48:0x0217, B:49:0x021b, B:51:0x0223, B:54:0x0230, B:56:0x0238, B:59:0x0243, B:61:0x024b, B:64:0x0256, B:66:0x025a, B:69:0x025f, B:71:0x0263, B:72:0x0268, B:74:0x026c, B:75:0x0271, B:77:0x0275, B:78:0x027a, B:80:0x027e, B:83:0x0283, B:85:0x0287, B:86:0x028c, B:88:0x0290, B:89:0x0295, B:91:0x0299, B:92:0x029e, B:94:0x02a6, B:97:0x02ab, B:99:0x02af, B:102:0x02b4, B:104:0x02b8, B:107:0x02bd, B:109:0x02c1, B:112:0x02c6, B:114:0x02cc, B:115:0x02d3, B:117:0x02d9, B:118:0x02dd, B:120:0x02e3, B:122:0x02e8, B:124:0x02f2, B:126:0x02f8, B:127:0x02fd, B:129:0x031f, B:131:0x0327, B:133:0x034a, B:134:0x0351, B:136:0x0359, B:137:0x0360, B:138:0x03ac, B:141:0x03bc, B:144:0x03d5, B:146:0x03e2, B:152:0x036c, B:153:0x039a, B:158:0x03a5, B:159:0x03a9, B:160:0x03e7, B:162:0x03f1, B:164:0x03f7, B:165:0x03fc, B:166:0x0403, B:168:0x0409, B:171:0x040e, B:173:0x041d, B:174:0x0421, B:176:0x0427, B:178:0x0435, B:180:0x043d, B:183:0x046b, B:186:0x047d, B:191:0x048d, B:193:0x0493, B:194:0x049a, B:195:0x04a2, B:197:0x04a6, B:200:0x04aa, B:203:0x004a, B:206:0x0055, B:209:0x0061, B:212:0x006d, B:215:0x0079, B:218:0x0085, B:221:0x0090, B:224:0x009c, B:227:0x00a8, B:230:0x00b1, B:233:0x00bd, B:236:0x00c9, B:239:0x00d5, B:242:0x00e0, B:245:0x00ec, B:248:0x00f8, B:251:0x0103, B:254:0x010f, B:257:0x011b, B:260:0x0127, B:263:0x0132, B:266:0x013d, B:269:0x0148, B:272:0x0153, B:275:0x015e, B:278:0x0168, B:281:0x0173, B:284:0x017e, B:287:0x0189), top: B:2:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(final com.sigmob.sdk.mraid2.c r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 1390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.mraid2.c.a(com.sigmob.sdk.mraid2.c, java.lang.String):void");
    }

    private void a(String str, Map map) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("event", str);
            jSONObject.put("notify", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    private void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("uniqId");
            String optString2 = jSONObject.optString("event");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return;
            }
            List<String> list = h.get(optString + "~" + optString2);
            if (list != null) {
                Iterator it = new CopyOnWriteArrayList(list).iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (str.equals(optString)) {
                        list.remove(str);
                    }
                }
            }
        }
    }

    private void d(JSONObject jSONObject) {
        HashMap<String, g> mraidWebViews;
        c mraidBridge;
        if (jSONObject != null) {
            String uniqueId = a().getUniqueId();
            String optString = jSONObject.optString("event");
            if (TextUtils.isEmpty(uniqueId) || TextUtils.isEmpty(optString)) {
                return;
            }
            List<String> list = h.get(uniqueId + "~" + optString);
            if (list == null || list.size() <= 0 || (mraidWebViews = g.getMraidWebViews()) == null) {
                return;
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                g gVar = mraidWebViews.get(it.next());
                if (gVar != null && (mraidBridge = gVar.getMraidBridge()) != null) {
                    mraidBridge.a(uniqueId, optString, jSONObject);
                }
            }
        }
    }

    private void e(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("uniqId");
            String optString2 = jSONObject.optString("event");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return;
            }
            List<String> list = h.get(optString2);
            if (list == null) {
                list = new ArrayList<>();
                h.put(optString + "~" + optString2, list);
            }
            list.add(this.d.getUniqueId());
        }
    }

    private void j() {
        this.i = true;
        this.d.post(new Runnable() { // from class: com.sigmob.sdk.mraid2.c.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (c.this.f != null) {
                        c.this.f.c();
                    }
                    c.this.a(true);
                    c.this.e();
                    c cVar = c.this;
                    cVar.a(cVar.d.getAdSize());
                    c.this.f();
                    c.this.a(100);
                    c cVar2 = c.this;
                    c.this.a(cVar2.a((List<BaseAdUnit>) cVar2.b));
                } catch (Throwable th) {
                    SigmobLog.e("handleMraidLoad", th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LoadAdRequest k() {
        List<BaseAdUnit> list = this.b;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.b.get(0).getAdRequest();
    }

    public g a() {
        return this.d;
    }

    void a(int i) {
        a("mraidbridge.fireChangeEvent({\"exposure\":" + i + "});");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.umeng.analytics.pro.d.y, i);
            jSONObject.put("index", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.notifyPageChangeEvent(" + jSONObject + ");");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2, int i3, int i4) {
        a("mraidbridge.setSafeAreaInsets(" + (i + "," + i2 + "," + i3 + "," + i4) + ")");
    }

    public void a(com.sigmob.sdk.base.common.g gVar) {
        int i;
        int i2;
        DisplayMetrics displayMetrics = this.d.getContext().getResources().getDisplayMetrics();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (gVar != null) {
                i = Dips.pixelsToIntDips(gVar.a(), this.d.getContext());
                i2 = Dips.pixelsToIntDips(gVar.b(), this.d.getContext());
            } else {
                int pixelsToIntDips = Dips.pixelsToIntDips(displayMetrics.widthPixels, this.d.getContext());
                int pixelsToIntDips2 = Dips.pixelsToIntDips(displayMetrics.heightPixels, this.d.getContext());
                i = pixelsToIntDips;
                i2 = pixelsToIntDips2;
            }
            jSONObject2.put("width", i);
            jSONObject2.put("height", i2);
            jSONObject.put("screenSize", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    void a(BidResponse bidResponse) {
        a("mraidbridge.fireChangeEvent(" + JSONSerializer.Serialize(bidResponse, "bidResponse", true, true) + ");");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.f578c = bVar;
    }

    public void a(d.a aVar) {
        this.f = aVar;
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void a(g gVar) {
        this.d = gVar;
        gVar.setScrollContainer(false);
        this.d.setVerticalScrollBarEnabled(false);
        this.d.setHorizontalScrollBarEnabled(false);
        this.d.setBackgroundColor(0);
        this.d.setWebChromeClient(new WebChromeClient() { // from class: com.sigmob.sdk.mraid2.c.1
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                return c.this.f != null ? c.this.f.a(consoleMessage) : super.onConsoleMessage(consoleMessage);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                return super.onJsAlert(webView, str, str2, jsResult);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (c.this.i || c.this.j || i <= 70) {
                    return;
                }
                c.this.j = true;
                c.this.a("javascript:(function () {\n    var uniqueId = 1;\n    var mraid = window.mraid = {};\n    var bridge = window.mraidbridge = {\n        nativeCallQueue: [],\n        nativeCallInFlight: false,\n        queue: {},\n    };\n    var bidResponse = {};\n    var bindData = undefined;\n    var isViewable = false;\n    var exposure = 0;\n    var sdkVersion = undefined;\n    var listeners = {};\n    var screenSize = {\n        width: 0,\n        height: 0\n    };\n    var currentAppOrientation = {\n        orientation: 0,\n        locked: true\n    };\n    var isNullOrEmpty = function(param) {\n        return param === null || param === undefined;\n    };\n    var EVENTS = mraid.EVENTS = {\n        error: 'error',\n        info: 'info',\n        ready: 'ready',\n        viewableChange: 'viewableChange',\n        sizeChange: 'sizeChange',\n        exposureChange: 'exposureChange',\n        playStateChanged: 'playStateChanged',\n        loadStateChanged: 'loadStateChanged',\n        currentTime: 'currentTime',\n        playEnd: 'playEnd',\n        pageChanged: 'pageChanged',\n        downloadStateChanged: 'downloadStateChanged',\n        safeAreaInsetsChange: 'safeAreaInsetsChange',\n    };\n\n    bridge.setScreenSize = function (val) {\n       if (screenSize.width != val.width || screenSize.height != val.height) {\n            screenSize = val;\n            broadcastEvent(listeners, EVENTS.sizeChange, val.width, val.height);\n        }\n    };\n    bridge.setIsViewable = function (val) {\n        if ((val ^ isViewable) == 1) {\n            isViewable = val;\n            broadcastEvent(listeners, EVENTS.viewableChange, isViewable)\n        }\n    };\n    bridge.setExposureChange = function (val) {\n        if (val != exposure) {\n            exposure = val;\n            broadcastEvent(listeners, EVENTS.exposureChange, val)\n        }\n    };\n    bridge.setBindData = function (val) { bindData = val; };\n    bridge.sdkVersion = function (val) { sdkVersion = val; }\n    bridge.orientation = function (val) { currentAppOrientation = val; }\n    bridge.onStorageChanged = function (evt) {\n        const key = 'storage_' + evt.key;\n        broadcastEvent(listeners, key, evt);\n    };\n    bridge.setBidResponse = function (val) {\n        bidResponse = val;\n    };\n    bridge.onChangeEvent = function(evt) {\n        broadcastEvent(listeners, evt.event, evt.data);\n    };\n    bridge.setvdReadyToPlay = function (val) {\n        let vpaid = bridge.queue[val.uniqueId]\n        broadcastEvent(vpaid.handlers, EVENTS.ready, val);\n    };\n    bridge.setvdPlayStateChanged = function (val) {\n        let vpaid = bridge.queue[val.uniqueId]\n        broadcastEvent(vpaid.handlers, EVENTS.playStateChanged, val);\n    };\n    bridge.setvdLoadStateChanged = function (val) {\n        let vpaid = bridge.queue[val.uniqueId]\n        broadcastEvent(vpaid.handlers, EVENTS.loadStateChanged, val);\n    };\n    bridge.setvdPlayCurrentTime = function (val) {\n        let vpaid = bridge.queue[val.uniqueId]\n        broadcastEvent(vpaid.handlers, EVENTS.currentTime, val);\n    };\n    bridge.setvdPlayToEnd = function (val) {\n        let vpaid = bridge.queue[val.uniqueId]\n        broadcastEvent(vpaid.handlers, EVENTS.playEnd, val);\n    };\n    bridge.setvdPlayError = function (val) {\n        let vpaid = bridge.queue[val.uniqueId]\n        broadcastEvent(vpaid.handlers, EVENTS.error, val);\n    };\n    bridge.onChangeFired = function (val) {\n        let obj = bridge.queue[val.uniqueId];\n        broadcastEvent(obj.handlers, val.event, val.args);\n    };\n    bridge.notify = function (val) {\n        console.log(val)\n        if (val.event.startsWith('fire_')) {\n            broadcastEvent(listeners, val.event)\n            return\n        }\n\n        if (val.event.startsWith('dispatch_')) {\n            broadcastEvent(listeners, val.event)\n            mraid.removeEventListener(val.event);\n            return\n        }\n\n        if (val.event.startsWith('animation_')) {\n            broadcastEvent(listeners, val.event)\n            mraid.removeEventListener(val.event);\n            return\n        }\n\n        broadcastEvent(listeners, val.event, val.message)\n        mraid.removeEventListener(val.event);\n    };\n    bridge.notifyPageChangeEvent = function (val) {\n        broadcastEvent(listeners, EVENTS.pageChanged, val)\n    };\n    bridge.notifyApkDownloadStateEvent = function (val) {\n        broadcastEvent(listeners, EVENTS.downloadStateChanged, val)\n    };\n    bridge.setWVFinished = function (val) {\n        let web = bridge.queue[val.uniqueId]\n        broadcastEvent(web.handlers, EVENTS.ready);\n    };\n    bridge.setWVError = function (val) {\n        let web = bridge.queue[val.uniqueId]\n        broadcastEvent(web.handlers, EVENTS.error, val.error);\n    };\n    bridge.postMessage = function (msg) {\n        var msgStr = JSON.stringify(msg);\n        sigandroid.postMessage(msgStr);\n    }\n    bridge.syncMessage = function (msg) {\n        if (this.nativeCallInFlight) {\n            this.nativeCallQueue.push(msg)\n        } else {\n            this.nativeCallInFlight = true;\n            var msgStr = JSON.stringify(msg);\n            sigandroid.postMessage(msgStr);\n        }\n    }\n    bridge.nativeCallComplete = function (command) {\n        console.log('nativeCallCompletecommand = ' + command)\n        if (this.nativeCallQueue.length === 0) {\n            this.nativeCallInFlight = false;\n            return\n        }\n        var nextCall = this.nativeCallQueue.shift();\n        bridge.postMessage(nextCall);\n    };\n    bridge.onMotionChanged = function (evt) {\n        const key = 'motion_' + evt.type+evt.event;\n        delete evt.type;\n        delete evt.event;\n        broadcastEvent(listeners, key, evt);\n    };\n    var changeHandlers = {\n        onChangeEvent: bridge.onChangeEvent,\n        vdReadyToPlay: bridge.setvdReadyToPlay,\n        vdPlayStateChanged: bridge.setvdPlayStateChanged,\n        vdLoadStateChanged: bridge.setvdLoadStateChanged,\n        vdPlayCurrentTime: bridge.setvdPlayCurrentTime,\n        vdPlayToEnd: bridge.setvdPlayToEnd,\n        vdPlayError: bridge.setvdPlayError,\n        wvFinished: bridge.setWVFinished,\n        wvError: bridge.setWVError,\n        screenSize: bridge.setScreenSize,\n        viewable: bridge.setIsViewable,\n        exposure: bridge.setExposureChange,\n        bindData: bridge.setBindData,\n        sdkVersion: bridge.sdkVersion,\n        orientation: bridge.orientation,\n        storageChanged: bridge.onStorageChanged,\n        bidResponse: bridge.setBidResponse,\n        notify: bridge.notify,\n        motionChanged: bridge.onMotionChanged,\n        onChangeFired: bridge.onChangeFired,\n    };\n    bridge.fireChangeEvent = function (properties) {\n        for (let p in properties) {\n            if (properties.hasOwnProperty(p)) {\n                let handler = changeHandlers[p];\n                try {\n                    handler(properties[p])\n                } catch (error) {\n                    console.log('error: ' + error.message);\n                }\n            }\n        }\n    };\n\n    var Storage = function (type) {\n        this.setItem = function (key, value) {\n            sigandroid.storage(JSON.stringify({ event: 'setItem', args: { type, key, value } }))\n        };\n        this.getItem = function (key) {\n            var result = sigandroid.storage(JSON.stringify({ event: 'getItem', args: { type, key } }));\n            return result\n        };\n        this.removeItem = function (key) {\n            sigandroid.storage(JSON.stringify({ event: 'removeItem', args: { type, key } }))\n        };\n        this.clear = function () {\n            sigandroid.storage(JSON.stringify({ event: 'clear', args: { type } }))\n        };\n        this.length = function () {\n            var result = sigandroid.storage(JSON.stringify({ event: 'length', args: { type } }));\n            return parseInt(result)\n        };\n        this.addEventListener = function (key, callback) {\n            sigandroid.storage(JSON.stringify({ event: 'addEventListener', args: { type, key } }))\n            mraid.addEventListener('storage_' + key, callback);\n        };\n    };\n    var EventListeners = function (event) {\n        this.event = event;\n        this.count = 0;\n        var listeners = {};\n        this.add = function (func) {\n            var id = String(func);\n            if (!listeners[id]) {\n                listeners[id] = func;\n                this.count++\n            }\n        };\n        this.remove = function (func) {\n            var id = String(func);\n            if (listeners[id]) {\n                listeners[id] = null;\n                delete listeners[id];\n                this.count--;\n                return true\n            } else {\n                return false\n            }\n        };\n        this.removeAll = function () {\n            for (var id in listeners) {\n                if (listeners.hasOwnProperty(id)) this.remove(listeners[id])\n            }\n        };\n        this.broadcast = function (args) {\n            for (var id in listeners) {\n                if (listeners.hasOwnProperty(id)) listeners[id].apply(mraid, args)\n            }\n        };\n        this.toString = function () {\n            var out = [event, ':'];\n            for (var id in listeners) {\n                if (listeners.hasOwnProperty(id)) out.push('|', id, '|')\n            }\n            return out.join('')\n        }\n    };\n    var contains = function (value, array) {\n        if (value.indexOf('motion_') == 0) {\n            return true;\n        }\n        if (value.indexOf('storage_') == 0) {\n            return true;\n        }\n        if (value.indexOf('fire_') == 0) {\n            return true;\n        }\n        if (value.indexOf('dispatch_') == 0) {\n            return true;\n        }\n        if (value.indexOf('animation_') == 0) {\n            return true;\n        }\n        if (value.indexOf('open_') == 0) {\n            return true;\n        }\n        if (value.indexOf('lance_') == 0) {\n            return true;\n        }\n\n        for (var i in array) {\n            if (array[i] === value) return true\n        }\n        return false\n    };\n    var broadcastEvent = function () {\n        var args = new Array(arguments.length);\n        var l = arguments.length;\n        for (var i = 0; i < l; i++) args[i] = arguments[i];\n        var handlers = args.shift();\n        var event = args.shift();\n        if (handlers[event]) {\n            handlers[event].broadcast(args)\n        }\n    };\n    var addEventListener = function (handlers, event, listener) {\n        if (!event || !listener) {\n            broadcastEvent(listeners, EVENTS.error, 'Both event and listener are required.', 'addEventListener')\n        } else {\n            if (!handlers[event]) {\n                handlers[event] = new EventListeners(event)\n            }\n            handlers[event].add(listener)\n        }\n    };\n    var removeEventListener = function (funs, event, listener) {\n        if (!event) {\n            broadcastEvent(listeners, EVENTS.error, 'Event is required.', 'removeEventListener');\n            return\n        }\n        if (listener) {\n            var success = false;\n            if (funs[event]) {\n                success = funs[event].remove(listener)\n            }\n            if (!success) {\n                broadcastEvent(listeners, EVENTS.error, 'Listener not currently registered for event.', 'removeEventListener');\n                return\n            }\n        } else if (funs && funs[event]) {\n            funs[event].removeAll()\n        }\n        if (funs[event] && funs[event].count === 0) {\n            funs[event] = null;\n            delete funs[event]\n        }\n    };\n    \n    var Motion = function(type) {\n        this.uniqId = 'motion_' + (uniqueId++) + '_' + new Date().getTime();\n        this.event = 'motion';\n        var events = [];\n        this.handlers = {};\n        bridge.queue[this.uniqId] = this;\n        this.init = function (sensitivity) {\n            bridge.syncMessage({ event: this.event, subEvent: 'init',args: { uniqueId: this.uniqId, type, sensitivity} });\n        };\n        this.initSensitivityRaw = function (sensitivity_raw) {\n            bridge.syncMessage({ event: this.event, subEvent: 'init_sensitivity_raw', args: { uniqueId: this.uniqId, type, sensitivity_raw } });\n        };\n        this.destroy = function () {\n            bridge.syncMessage({ event: this.event, subEvent: 'destroy',args: { uniqueId: this.uniqId, type } });\n        };\n        this.addEventListener = function (event,listener) {\n            addEventListener(this.handlers, event, listener);\n        };\n        this.removeEventListener = function (event, listener) {\n            removeEventListener(this.handlers, event, listener);\n        };\n    };\n    bridge.fireReadyEvent = function () { broadcastEvent(listeners, EVENTS.ready) };\n    bridge.frame = function (event, uniqId, x, y, w, h) {\n        if (!w || !h) {\n            broadcastEvent(listeners, EVENTS.error, 'x,y,w,h is required!', 'frame');\n        } else {\n            bridge.syncMessage({ event: event, subEvent: 'frame', args: { uniqueId: uniqId, frame: { x, y, w, h } } });\n        }\n    }\n    var safeAreaInsets = {\n        top: 0,\n        left: 0,\n        bottom: 0,\n        right: 0\n    };\n    bridge.setSafeAreaInsets = function(top, left, bottom, right) {\n        if (safeAreaInsets.top == top && safeAreaInsets.left == left && safeAreaInsets.bottom == bottom && safeAreaInsets.right == right) {\n            return;\n        }\n        safeAreaInsets = {\n            top: top,\n            left: left,\n            bottom: bottom,\n            right: right\n          };\n         broadcastEvent(listeners,EVENTS.safeAreaInsetsChange, top, left, bottom, right);\n    };\n    mraid.getSafeAreaInsets = function() {\n        return {\n            top: safeAreaInsets.top,\n            left: safeAreaInsets.left,\n            bottom: safeAreaInsets.bottom,\n            right: safeAreaInsets.right\n        };\n    };\n   mraid.MotionView = function(type) {\n        this.uniqId = 'motion_view_' + (uniqueId++) + '_' + new Date().getTime();\n        this.event = 'motionView';\n        this.rect = {x: 0, y: 0, w: 0, h: 0};\n        this.handlers = {};\n        bridge.queue[this.uniqId] = this;\n        bridge.syncMessage({ event: this.event, subEvent: 'init', args: { uniqueId: this.uniqId, type } });\n        this.frame = function (x, y, w, h) {\n            this.rect = {x, y, w, h};\n            bridge.frame(this.event, this.uniqId, x, y, w, h);\n        };\n        this.hidden = function (hidden) {\n            bridge.syncMessage({ event: this.event, subEvent: 'hidden', args: { uniqueId: this.uniqId, hidden } });\n        };\n        this.sensitivity = function (sensitivity) {\n            bridge.syncMessage({ event: this.event, subEvent: 'sensitivity', args: { uniqueId: this.uniqId, sensitivity } });\n        };\n        this.sensitivityRaw = function (sensitivity_raw) {\n            bridge.syncMessage({ event: this.event, subEvent: 'sensitivity_raw', args: { uniqueId: this.uniqId, sensitivity_raw } });\n        };\n        this.start = function () {\n            bridge.syncMessage({ event: this.event, subEvent: 'start', args: { uniqueId: this.uniqId } });\n        };\n        this.destroy = function () {\n            bridge.syncMessage({ event: this.event, subEvent: 'destroy', args: { uniqueId: this.uniqId } });\n        };\n        this.addEventListener = function (event, listener) {\n            addEventListener(this.handlers, event, listener);\n        };\n        this.removeEventListener = function (event, listener) {\n            removeEventListener(this.handlers, event, listener);\n        };\n    };\n    mraid.Vpaid = function (val) {\n        if (typeof (val) == 'object' && val.uniqId) {\n            this.uniqId = val.uniqId;\n            uniqueId++;\n            this.rect = val.rect;\n        } else {\n            this.uniqId = 'vd_' + (uniqueId++) + '_' + new Date().getTime();\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'init', args: { uniqueId: this.uniqId } });\n            this.rect = { x: 0, y: 0, w: 0, h: 0 };\n        }\n        bridge.queue[this.uniqId] = this;\n        this.handlers = {};\n        this.assetURL = function (URL,useProxy = true) {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'assetURL', args: { uniqueId: this.uniqId, URL: URL,proxy:useProxy} });\n        };\n        this.play = function () {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'play', args: { uniqueId: this.uniqId } });\n        };\n        this.replay = function () {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'replay', args: { uniqueId: this.uniqId } });\n        };\n        this.pause = function () {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'pause', args: { uniqueId: this.uniqId } });\n        };\n        this.stop = function () {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'stop', args: { uniqueId: this.uniqId } });\n        };\n        this.muted = function (flag) {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'muted', args: { uniqueId: this.uniqId, muted: flag } });\n        };\n        this.seek = function (val) {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'seek', args: { uniqueId: this.uniqId, seekTime: val } });\n        };\n        this.frame = function (x, y, w, h) {\n            this.rect = { x, y, w, h };\n            bridge.frame('vpaid', this.uniqId, x, y, w, h)\n        };\n        this.addEventListener = function (event, listener) {\n            addEventListener(this.handlers, event, listener);\n        };\n        this.removeEventListener = function (event, listener) {\n            removeEventListener(this.handlers, event, listener);\n        };\n    };\n\n    function callNativeFunc(kwargs, func) {\n        if (kwargs === undefined) return undefined;\n        if (func === undefined) return undefined;\n        kwargs['func'] = func;\n        var returnStr = sigandroid.func(JSON.stringify(kwargs));\n        if (returnStr) {\n            try {\n                return JSON.parse(returnStr)\n            } catch (e) {\n                return JSON.stringify(returnStr)\n            }\n        } else {\n            console.log('-------callNativeFunc return null-----');\n        }\n    };\n\n    mraid.Color = function(red, green, blue, alpha) {\n        this.red = red;\n        this.green = green;\n        this.blue = blue;\n        this.alpha = alpha;\n    };\n   mraid.backgroundColor = function (color) {\n        bridge.postMessage({ event: 'backgroundColor', args: { red: color.red, green: color.green, blue: color.blue, alpha: color.alpha } });\n    };\n   mraid.uniqId = function () {\n        return sigandroid.getUniqueId()\n    };    mraid.Timer = function (interval, repeats = false, callback) {\n        if (!interval || interval <= 0) return;\n        this.uniqId = 'timer_' + (uniqueId++) + '_' + new Date().getTime();\n        bridge.syncMessage({\n            event: 'timer',\n            subEvent: 'init',\n            args: {\n                uniqueId: this.uniqId,\n                interval: interval,\n                repeats: repeats\n            }\n        });\n        this.fire = function () {\n            mraid.addEventListener('fire_' + this.uniqId, callback);\n            bridge.syncMessage({ event: 'timer', subEvent: 'fire', args: { uniqueId: this.uniqId } });\n        };\n        this.invalidate = function () {\n            mraid.removeEventListener('fire_' + this.uniqId, callback);\n            bridge.syncMessage({ event: 'timer', subEvent: 'invalidate', args: { uniqueId: this.uniqId } });\n        };\n        this.pause = function () {\n            bridge.syncMessage({ event: 'timer', subEvent: 'pause', args: { uniqueId: this.uniqId } });\n        };\n        this.resume = function () {\n            bridge.syncMessage({ event: 'timer', subEvent: 'resume', args: { uniqueId: this.uniqId } });\n        };\n    };\n    mraid.WebView = function () {\n        this.uniqId = 'wv_' + (uniqueId++) + '_' + new Date().getTime();\n        this.event = 'webView'\n        this.handlers = {}\n        this.rect = { x: 0, y: 0, w: 0, h: 0 };\n        var args = undefined;\n        if (arguments) {\n            args = JSON.stringify(arguments);\n        }\n        bridge.queue[this.uniqId] = this;\n        bridge.syncMessage({ event: this.event, subEvent: 'init', args: { uniqueId: this.uniqId, args } });\n        this.frame = function (x, y, w, h) {\n            this.rect = { x, y, w, h };\n            bridge.frame(this.event, this.uniqId, x, y, w, h)\n        };\n        this.loadURL = function (url) {\n            bridge.syncMessage({ event: this.event, subEvent: 'loadURL', args: { uniqueId: this.uniqId, url } });\n        };\n        this.loadURLByPackage = function (URL) {\n            bridge.syncMessage({ event: this.event, subEvent: 'loadURLByPackage', args: { uniqueId: this.uniqId, URL } });\n        };\n        this.loadHTMLString = function (html) {\n            bridge.syncMessage({ event: this.event, subEvent: 'loadHTMLString', args: { uniqueId: this.uniqId, html } });\n        };\n        this.loadById = function (id) {\n            bridge.syncMessage({ event: this.event, subEvent: 'loadId', args: { uniqueId: this.uniqId, id } });\n        };\n        this.reload = function (id) {\n            bridge.syncMessage({ event: this.event, subEvent: 'reload', args: { uniqueId: this.uniqId } });\n        };\n        this.stopLoading = function (id) {\n            bridge.syncMessage({ event: this.event, subEvent: 'stopLoading', args: { uniqueId: this.uniqId } });\n        };\n        this.addEventListener = function (event, listener) {\n            addEventListener(this.handlers, event, listener);\n        };\n        this.removeEventListener = function (event, listener) {\n            removeEventListener(this.handlers, event, listener);\n        };\n    };\n    mraid.motion = {\n        shake: new Motion('shake'),\n        twist: new Motion('twist'),\n        slope: new Motion('slope'),\n        swing: new Motion('swing'),\n    };\n    mraid.blurEffect = {\n        init: function (color) {\n            bridge.syncMessage({ event: 'blurEffect', subEvent: 'init', args: { red: color.red, green: color.green, blue: color.blue, alpha: color.alpha } });\n        },\n        destroy: function () {\n            bridge.syncMessage({ event: 'blurEffect', subEvent: 'destroy' });\n        },\n    };\n    mraid.localStorage = new Storage(1);\n    mraid.sessionStorage = new Storage(2);\n    mraid.getVersion = () => sdkVersion;\n    mraid.getOs = () => 2;\n    mraid.isViewable = () => isViewable;\n    mraid.getState = () => state;\n    mraid.version = () => '2.2'; \n     mraid.getScreenSize = () => screenSize;\n    mraid.getCurrentAppOrientation = () => currentAppOrientation;\n    mraid.bidResponse = () => bidResponse;\n    mraid.visible = function(visible) {\n        bridge.syncMessage({ event: 'visible', args: {visible} });\n    };\n    mraid.feedbackByVid = function(vid) {\n        bridge.postMessage({ event: 'feedbackByVid', args: { vid } });\n    };\n    mraid.openByVid = function(vid, data, cbObj = {}) {\n        var event = 'open_' + new Date().getTime();\n        if (cbObj.onSuccess) {\n            mraid.addEventListener(event + \"_success\", cbObj.onSuccess)\n        }\n        if (cbObj.onFailed) {\n            mraid.addEventListener(event + \"_failed\", cbObj.onFailed)\n        }\n        bridge.syncMessage({ event: 'openByVid', args: {vid, event, data} });\n    };\n    mraid.open = function (url, data, cbObj = {}) {\n        var event = 'open_' + new Date().getTime();\n        if (cbObj.onSuccess) {\n            mraid.addEventListener(event + \"_success\", cbObj.onSuccess)\n        }\n        if (cbObj.onFailed) {\n            mraid.addEventListener(event + \"_failed\", cbObj.onFailed)\n        }\n        bridge.postMessage({ event: 'open', args: { url, event, data } })\n    };\n   mraid.subscribe = function(uniqId, event, listener) {\n        if (isNullOrEmpty(uniqId) || isNullOrEmpty(event)) {\n            broadcastEvent(listeners, EVENTS.error, 'Both event and uniqId are required.', 'subscribe');\n            return;\n        }\n        let key = uniqId + '~' + event;\n        addEventListener(listeners, key, listener);\n        if (listeners[key] && listeners[key].count == 1) {\n            bridge.syncMessage({ event: 'subscribe', args: { uniqId, event } });\n        }\n    };\n    mraid.unsubscribe = function(uniqId, event, listener) {\n        if (isNullOrEmpty(uniqId) || isNullOrEmpty(event)) {\n            broadcastEvent(listeners, EVENTS.error, 'Both event and uniqId are required.', 'unsubscribe');\n            return;\n        }\n        let key = uniqId + '~' + event;\n        removeEventListener(listeners, key, listener);\n        if (isNullOrEmpty(listeners[key])) {\n            bridge.syncMessage({ event: 'unsubscribe', args: { uniqId, event } });\n        }\n    };\n    mraid.publish = function(event, data) {\n        if (isNullOrEmpty(event)) {\n            broadcastEvent(listeners, EVENTS.error, 'event are required.', 'publish');\n            return;\n        }\n        bridge.syncMessage({ event: 'publish', args: {event, data} });\n    };\n    mraid.ready = function () { bridge.postMessage({ event: 'ready' }); };\n    mraid.close = function () { bridge.postMessage({ event: 'close' }) };\n    mraid.unload = function () { bridge.postMessage({ event: 'unload' }) }\n    mraid.addSubview = function (val) { bridge.syncMessage({ event: 'addSubview', args: { uniqueId: val.uniqId } }); };\n    mraid.belowSubview = function (val) { bridge.syncMessage({ event: 'belowSubview', args: { uniqueId: val.uniqId } }); };\n    mraid.useScrollView = function (flag) { bridge.syncMessage({ event: 'useScrollView', args: { flag } }); };\n    mraid.touchStart = function (x, y) { bridge.postMessage({ event: 'touchStart', args: { x, y } }); };\n    mraid.touchMove = function (x, y) { bridge.postMessage({ event: 'touchMove', args: { x, y } }); };\n    mraid.touchEnd = function (x, y) { bridge.postMessage({ event: 'touchEnd', args: { x, y } }); };\n    mraid.dispatchAfter = function (delay, callback) {\n        var event = 'dispatch_' + new Date().getTime();\n        mraid.addEventListener(event, callback);\n        bridge.postMessage({ event: 'dispatch_after', args: { 'event': event, 'delay': delay } });\n    };\n    mraid.useCustomClose = function (flag) { bridge.postMessage({ event: 'useCustomClose', args: { flag } }) };\n    mraid.addEventListener = function (event, listener) { addEventListener(listeners, event, listener); };\n    mraid.removeEventListener = function (event, listener) { removeEventListener(listeners, event, listener); };\n    mraid.arguments = () => bindData;\n    mraid.reward = function () {\n        bridge.postMessage({ event: 'reward' })\n    };\n    mraid.addMacro = function (key, value, vid) {\n        callNativeFunc({ event: 'addMacro', args: { key, value, vid } }, 'handleMacro:')\n    };\n    mraid.addAllMacros = function (maps, vid) {\n        callNativeFunc({ event: 'addAllMacros', args: { maps, vid } }, 'handleMacro:')\n    };\n    mraid.removeMacro = function (key, vid) {\n        callNativeFunc({ event: 'removeMacro', args: { key, vid } }, 'handleMacro:')\n    };\n    mraid.clearMacro = function (vid) {\n        callNativeFunc({ event: 'clearMacro', args: { vid } }, 'handleMacro:')\n    };\n    mraid.getMacro = function (key, vid) {\n        return callNativeFunc({ event: 'getMacro', args: { key, vid } }, 'handleMacro:')\n    };\n    mraid.addDclog = function (data, vid) {\n        return callNativeFunc({ data, vid }, 'addDclog:')\n    };\n    mraid.device = function () {\n        var device = sigandroid.getDeviceInfo()\n        if (device) {\n            return JSON.parse(device)\n        }\n    };\n    mraid.tracking = function (urls, event, data) {\n        if (urls.length > 0 || event) {\n            return callNativeFunc({ urls, event, data }, 'tracking:')\n        }\n    };\n    mraid.android = {\n        getApKDownloadProcess: function (vid) {\n            var process = sigandroidapk.getApKDownloadProcessId(vid);\n            return process\n        },\n        addEventListener: function (event, vid, listener) {\n            sigandroidapk.registerDownloadEvent(vid);\n            addEventListener(listeners, event, listener);\n        },\n        removeEventListener: function (event, listener) {\n            removeEventListener(listeners, event, listener);\n        }\n    };\n\n    mraid.loadAd = function (data, callback) {\n        var event = 'lance_' + new Date().getTime();\n        mraid.addEventListener(event, callback);\n        bridge.postMessage({ event: 'mraidLoadAd', args: { 'event': event, 'data': data } });\n    };\n\n    mraid.setCurPlayAd = function (vid) { bridge.postMessage({ event: 'curPlayAd', args: { vid } }); };\n\n    mraid.animation = function (duration, obj, from, to, completion) {\n        const fromRect = { x: from.x, y: from.y, w: from.w, h: from.h };\n        const toRect = { x: to.x, y: to.y, w: to.w, h: to.h };\n        var event = 'animation_' + new Date().getTime();\n        mraid.addEventListener(event, completion);\n        bridge.postMessage({ event: 'animation', args: { 'event': event, duration, uniqueId: obj.uniqId, from: fromRect, to: toRect } });\n    };\n\n    (function () {\n        bridge.postMessage({ event: 'mraidJsLoaded' })\n    })();\n\n    console.log('mraid ---- successed!!!')\n}());\n", (ValueCallback) null);
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                super.onShowCustomView(view, customViewCallback);
            }
        });
    }

    void a(String str) {
        StringBuilder sb;
        String str2;
        if (!this.i) {
            sb = new StringBuilder();
            str2 = "MRAID JS Not Load attached:\n\t";
        } else {
            if (this.d != null) {
                SigmobLog.d("Injecting Javascript into MRAID WebView:\n\t" + str);
                if (Build.VERSION.SDK_INT >= 19) {
                    this.d.b(str, (ValueCallback) null);
                    return;
                }
                this.d.a("javascript:" + str);
                return;
            }
            sb = new StringBuilder();
            str2 = "Attempted to inject Javascript into MRAID WebView while was not attached:\n\t";
        }
        sb.append(str2);
        sb.append(str);
        SigmobLog.e(sb.toString());
    }

    public void a(String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", str);
            jSONObject2.put("state", i);
            jSONObject.put("vdPlayStateChanged", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public void a(String str, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", str);
            jSONObject2.put("currentTime", i / 1000.0f);
            jSONObject2.put("duration", i2 / 1000.0f);
            jSONObject.put("vdPlayCurrentTime", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, int i2, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", str);
            jSONObject2.put("duration", i / 1000.0f);
            jSONObject2.put("width", i2);
            jSONObject2.put("height", i3);
            jSONObject.put("vdReadyToPlay", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public void a(String str, int i, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", i);
            jSONObject2.put("message", str2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("uniqueId", str);
            jSONObject3.put("error", jSONObject2);
            jSONObject.put("wvError", jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, ValueCallback valueCallback) {
        if (this.d == null) {
            SigmobLog.e("Attempted to inject Javascript into MRAID WebView while was not attached:\n\t" + str);
            return;
        }
        SigmobLog.d("Injecting Javascript into MRAID WebView:\n\t" + str);
        if (Build.VERSION.SDK_INT >= 19) {
            this.d.b(str, valueCallback);
            return;
        }
        SigmobLog.e("Injecting Javascript into MRAID WebView:\n\t can't support less KITKAT" + str);
    }

    void a(String str, BidResponse bidResponse, int i, String str2) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (bidResponse == null) {
                jSONObject = new JSONObject();
                jSONObject.put("data", (Object) null);
            } else {
                jSONObject = new JSONObject(JSONSerializer.Serialize(bidResponse, "data", true, true));
            }
            jSONObject.put("code", i);
            jSONObject.put("message", str2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("event", str);
            jSONObject3.put("message", jSONObject);
            jSONObject2.put("notify", jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject2 + ");");
    }

    public void a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", str);
            jSONObject2.put("error", str2);
            jSONObject.put("vdPlayError", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    @Override // com.sigmob.sdk.mraid2.i
    public void a(String str, String str2, String str3, HashMap<String, Object> hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("event", str3);
            jSONObject2.put("uniqueId", str);
            if (hashMap != null) {
                jSONObject2.put("args", new JSONObject(hashMap));
            }
            jSONObject.put("onChangeFired", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    void a(String str, String str2, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        Object opt = jSONObject.opt("data");
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("event", str + "~" + str2);
            if (opt != null) {
                jSONObject3.put("data", opt);
            }
            jSONObject2.put("onChangeEvent", jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject2 + ");");
    }

    public void a(String str, HashMap<String, Object> hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("event", str);
            if (hashMap != null) {
                jSONObject2.put("args", new JSONObject(hashMap));
            }
            jSONObject.put("onChangeEvent", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("bindData", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject2 + ");");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("viewable", z);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ")");
    }

    public BaseAdUnit b(String str) {
        List<BaseAdUnit> list;
        if (!TextUtils.isEmpty(str) && (list = this.g) != null && list.size() > 0) {
            for (int i = 0; i < this.g.size(); i++) {
                BaseAdUnit baseAdUnit = this.b.get(i);
                if (str.equals(baseAdUnit.getAd().vid)) {
                    return baseAdUnit;
                }
            }
        }
        return null;
    }

    public void b(String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", str);
            jSONObject2.put("state", i);
            jSONObject.put("vdLoadStateChanged", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("event", str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject2.put("message", str2);
            }
            jSONObject.put("notify", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    void b(JSONObject jSONObject) {
        a("mraidbridge.onStorageChanged(" + jSONObject.toString() + ");");
    }

    public boolean b() {
        return this.i;
    }

    public List<BaseAdUnit> c() {
        return this.g;
    }

    public void c(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", str);
            jSONObject.put("wvFinished", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public void c(String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", str);
            jSONObject2.put("currentTime", i / 1000.0f);
            jSONObject.put("vdPlayToEnd", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        a("mraidbridge.fireReadyEvent();");
    }

    void d(String str) {
        a("mraidbridge.nativeCallComplete(" + JSONObject.quote(str) + ")");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("orientation", ClientMetadata.getInstance().getOrientationInt());
            jSONObject2.put(PointCategory.LOCKED, true);
            jSONObject.put("orientation", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("event", "fire_" + str);
            jSONObject.put("notify", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    void f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdkVersion", com.sigmob.sdk.base.k.k);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ")");
    }

    void f(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("event", str);
            jSONObject.put("notify", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public void g() {
        if (e != null) {
            e = null;
        }
        if (this.d != null) {
            this.d = null;
        }
        a((b) null);
        a((d.a) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("event", str);
            jSONObject.put("notify", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }
}
