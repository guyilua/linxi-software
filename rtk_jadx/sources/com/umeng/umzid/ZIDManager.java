package com.umeng.umzid;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ZIDManager {

    /* renamed from: c, reason: collision with root package name */
    public static ZIDManager f1126c;
    public boolean a = false;
    public boolean b = false;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ IZIDCompletionCallback b;

        public a(Context context, IZIDCompletionCallback iZIDCompletionCallback) {
            this.a = context;
            this.b = iZIDCompletionCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            String a = ZIDManager.a(ZIDManager.this, this.a);
            if (TextUtils.isEmpty(a)) {
                IZIDCompletionCallback iZIDCompletionCallback = this.b;
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1002", "获取zid失败");
                    return;
                }
                return;
            }
            IZIDCompletionCallback iZIDCompletionCallback2 = this.b;
            if (iZIDCompletionCallback2 != null) {
                iZIDCompletionCallback2.onSuccess(a);
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements Runnable {
        public final /* synthetic */ Context a;

        public b(Context context) {
            this.a = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x00b0 A[Catch: all -> 0x0108, TRY_LEAVE, TryCatch #0 {all -> 0x0108, blocks: (B:60:0x001a, B:62:0x0020, B:6:0x0027, B:9:0x0037, B:11:0x003d, B:13:0x0047, B:14:0x004d, B:17:0x005d, B:19:0x0063, B:21:0x006d, B:22:0x0073, B:25:0x008d, B:27:0x0093, B:28:0x0099, B:31:0x00a0, B:33:0x00a6, B:34:0x00aa, B:36:0x00b0, B:38:0x00b5, B:40:0x00c3, B:42:0x00d8, B:44:0x00eb, B:45:0x00ee, B:47:0x00f8, B:48:0x00fb, B:50:0x0105), top: B:59:0x001a }] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00c3 A[Catch: all -> 0x0108, TryCatch #0 {all -> 0x0108, blocks: (B:60:0x001a, B:62:0x0020, B:6:0x0027, B:9:0x0037, B:11:0x003d, B:13:0x0047, B:14:0x004d, B:17:0x005d, B:19:0x0063, B:21:0x006d, B:22:0x0073, B:25:0x008d, B:27:0x0093, B:28:0x0099, B:31:0x00a0, B:33:0x00a6, B:34:0x00aa, B:36:0x00b0, B:38:0x00b5, B:40:0x00c3, B:42:0x00d8, B:44:0x00eb, B:45:0x00ee, B:47:0x00f8, B:48:0x00fb, B:50:0x0105), top: B:59:0x001a }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r12 = this;
                java.lang.String r0 = "aaid"
                com.umeng.umzid.ZIDManager r1 = com.umeng.umzid.ZIDManager.this
                android.content.Context r2 = r12.a
                boolean r3 = r1.b
                if (r3 == 0) goto Lc
                goto L10b
            Lc:
                r3 = 1
                r1.b = r3
                org.json.JSONObject r4 = new org.json.JSONObject
                r4.<init>()
                java.lang.String r5 = "zdata"
                java.lang.String r6 = ""
                if (r2 == 0) goto L26
                android.content.SharedPreferences r7 = com.umeng.umzid.a.a(r2)     // Catch: java.lang.Throwable -> L108
                if (r7 == 0) goto L26
                r8 = 0
                java.lang.String r7 = r7.getString(r5, r8)     // Catch: java.lang.Throwable -> L108
                goto L27
            L26:
                r7 = r6
            L27:
                java.lang.String r8 = com.umeng.umzid.Spy.getID()     // Catch: java.lang.Throwable -> L108
                r4.put(r5, r8)     // Catch: java.lang.Throwable -> L108
                java.lang.String r5 = "old_zdata"
                r4.put(r5, r7)     // Catch: java.lang.Throwable -> L108
                java.lang.String r5 = "oaid"
                if (r2 == 0) goto L4c
                android.content.SharedPreferences r7 = com.umeng.umzid.a.a(r2)     // Catch: java.lang.Throwable -> L108
                if (r7 == 0) goto L4c
                java.lang.String r7 = r7.getString(r5, r6)     // Catch: java.lang.Throwable -> L108
                boolean r9 = com.umeng.umzid.c.c(r7)     // Catch: java.lang.Throwable -> L108
                if (r9 == 0) goto L4d
                java.lang.String r7 = com.umeng.umzid.c.a(r7)     // Catch: java.lang.Throwable -> L108
                goto L4d
            L4c:
                r7 = r6
            L4d:
                java.lang.String r9 = com.umeng.umzid.c.c(r2)     // Catch: java.lang.Throwable -> L108
                java.lang.String r10 = "old_oaid"
                r4.put(r10, r7)     // Catch: java.lang.Throwable -> L108
                r4.put(r5, r9)     // Catch: java.lang.Throwable -> L108
                java.lang.String r5 = "mac"
                if (r2 == 0) goto L72
                android.content.SharedPreferences r7 = com.umeng.umzid.a.a(r2)     // Catch: java.lang.Throwable -> L108
                if (r7 == 0) goto L72
                java.lang.String r7 = r7.getString(r5, r6)     // Catch: java.lang.Throwable -> L108
                boolean r10 = com.umeng.umzid.c.c(r7)     // Catch: java.lang.Throwable -> L108
                if (r10 == 0) goto L73
                java.lang.String r7 = com.umeng.umzid.c.a(r7)     // Catch: java.lang.Throwable -> L108
                goto L73
            L72:
                r7 = r6
            L73:
                java.lang.String r10 = com.umeng.umzid.c.b(r2)     // Catch: java.lang.Throwable -> L108
                r4.put(r5, r10)     // Catch: java.lang.Throwable -> L108
                java.lang.String r5 = "old_mac"
                r4.put(r5, r7)     // Catch: java.lang.Throwable -> L108
                r1.a(r2, r4)     // Catch: java.lang.Throwable -> L108
                java.lang.String r5 = com.umeng.umzid.c.a(r2)     // Catch: java.lang.Throwable -> L108
                r4.put(r0, r5)     // Catch: java.lang.Throwable -> L108
                java.lang.String r5 = "uabc"
                if (r2 == 0) goto L98
                android.content.SharedPreferences r7 = com.umeng.umzid.a.a(r2)     // Catch: java.lang.Throwable -> L108
                if (r7 == 0) goto L98
                java.lang.String r7 = r7.getString(r5, r6)     // Catch: java.lang.Throwable -> L108
                goto L99
            L98:
                r7 = r6
            L99:
                r4.put(r5, r7)     // Catch: java.lang.Throwable -> L108
                java.lang.String r7 = "resetToken"
                if (r2 == 0) goto Laa
                android.content.SharedPreferences r11 = com.umeng.umzid.a.a(r2)     // Catch: java.lang.Throwable -> L108
                if (r11 == 0) goto Laa
                java.lang.String r6 = r11.getString(r7, r6)     // Catch: java.lang.Throwable -> L108
            Laa:
                boolean r11 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L108
                if (r11 != 0) goto Lb3
                r4.put(r7, r6)     // Catch: java.lang.Throwable -> L108
            Lb3:
                java.lang.String r6 = "https://aaid.umeng.com/api/updateZdata"
                java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L108
                java.lang.String r4 = com.umeng.umzid.a.a(r6, r4)     // Catch: java.lang.Throwable -> L108
                boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L108
                if (r6 != 0) goto L108
                org.json.JSONObject r6 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L108
                r6.<init>(r4)     // Catch: java.lang.Throwable -> L108
                java.lang.String r4 = "suc"
                boolean r4 = r6.optBoolean(r4)     // Catch: java.lang.Throwable -> L108
                java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Throwable -> L108
                boolean r4 = r4.booleanValue()     // Catch: java.lang.Throwable -> L108
                if (r4 != r3) goto L108
                com.umeng.umzid.c.f(r2, r8)     // Catch: java.lang.Throwable -> L108
                com.umeng.umzid.c.a(r2, r10)     // Catch: java.lang.Throwable -> L108
                com.umeng.umzid.c.b(r2, r9)     // Catch: java.lang.Throwable -> L108
                java.lang.String r0 = r6.optString(r0)     // Catch: java.lang.Throwable -> L108
                boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L108
                if (r3 != 0) goto Lee
                com.umeng.umzid.c.e(r2, r0)     // Catch: java.lang.Throwable -> L108
            Lee:
                java.lang.String r0 = r6.getString(r5)     // Catch: java.lang.Throwable -> L108
                boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L108
                if (r3 != 0) goto Lfb
                com.umeng.umzid.c.d(r2, r0)     // Catch: java.lang.Throwable -> L108
            Lfb:
                java.lang.String r0 = r6.getString(r7)     // Catch: java.lang.Throwable -> L108
                boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L108
                if (r3 != 0) goto L108
                com.umeng.umzid.c.c(r2, r0)     // Catch: java.lang.Throwable -> L108
            L108:
                r0 = 0
                r1.b = r0
            L10b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.b.run():void");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class c implements Runnable {
        public final /* synthetic */ Context a;

        public c(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.a(ZIDManager.this, this.a);
        }
    }

    public static /* synthetic */ String a(ZIDManager zIDManager, Context context) {
        String str = null;
        if (!zIDManager.a) {
            zIDManager.a = true;
            JSONObject jSONObject = new JSONObject();
            try {
                String id = Spy.getID();
                jSONObject.put("zdata", id);
                String b2 = com.umeng.umzid.c.b(context);
                jSONObject.put("mac", b2);
                String c2 = com.umeng.umzid.c.c(context);
                jSONObject.put("oaid", c2);
                zIDManager.a(context, jSONObject);
                String a2 = com.umeng.umzid.a.a("https://aaid.umeng.com/api/postZdata", jSONObject.toString());
                if (!TextUtils.isEmpty(a2)) {
                    JSONObject jSONObject2 = new JSONObject(a2);
                    if (Boolean.valueOf(jSONObject2.optBoolean("suc")).booleanValue()) {
                        com.umeng.umzid.c.f(context, id);
                        com.umeng.umzid.c.a(context, b2);
                        com.umeng.umzid.c.b(context, c2);
                        str = jSONObject2.optString("aaid");
                        if (!TextUtils.isEmpty(str)) {
                            com.umeng.umzid.c.e(context, str);
                        }
                        String string = jSONObject2.getString("uabc");
                        if (!TextUtils.isEmpty(string)) {
                            com.umeng.umzid.c.d(context, string);
                        }
                        String string2 = jSONObject2.getString("resetToken");
                        if (!TextUtils.isEmpty(string2)) {
                            com.umeng.umzid.c.c(context, string2);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            zIDManager.a = false;
        }
        return str;
    }

    public static synchronized ZIDManager getInstance() {
        ZIDManager zIDManager;
        synchronized (ZIDManager.class) {
            if (f1126c == null) {
                f1126c = new ZIDManager();
            }
            zIDManager = f1126c;
        }
        return zIDManager;
    }

    public static String getSDKVersion() {
        return "1.4.1";
    }

    public synchronized String getZID(Context context) {
        if (context == null) {
            return "";
        }
        Context applicationContext = context.getApplicationContext();
        String a2 = com.umeng.umzid.c.a(applicationContext);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        com.umeng.umzid.b.a(new c(applicationContext));
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x006d A[Catch: all -> 0x009c, TryCatch #1 {, blocks: (B:5:0x0005, B:9:0x000e, B:12:0x0016, B:15:0x001f, B:18:0x0027, B:20:0x002d, B:22:0x0033, B:24:0x0039, B:25:0x0042, B:27:0x0048, B:30:0x004f, B:32:0x0059, B:33:0x0065, B:35:0x006d, B:36:0x0075, B:38:0x007b, B:42:0x008d, B:47:0x005d), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007b A[Catch: all -> 0x009c, TRY_LEAVE, TryCatch #1 {, blocks: (B:5:0x0005, B:9:0x000e, B:12:0x0016, B:15:0x001f, B:18:0x0027, B:20:0x002d, B:22:0x0033, B:24:0x0039, B:25:0x0042, B:27:0x0048, B:30:0x004f, B:32:0x0059, B:33:0x0065, B:35:0x006d, B:36:0x0075, B:38:0x007b, B:42:0x008d, B:47:0x005d), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void init(android.content.Context r4, java.lang.String r5, com.umeng.umzid.IZIDCompletionCallback r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r4 != 0) goto Le
            if (r6 == 0) goto Lc
            java.lang.String r4 = "1001"
            java.lang.String r5 = "传入参数Context为null"
            r6.onFailure(r4, r5)     // Catch: java.lang.Throwable -> L9c
        Lc:
            monitor-exit(r3)
            return
        Le:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L9c
            if (r0 == 0) goto L1f
            if (r6 == 0) goto L1d
            java.lang.String r4 = "1003"
            java.lang.String r5 = "传入参数appkey为空"
            r6.onFailure(r4, r5)     // Catch: java.lang.Throwable -> L9c
        L1d:
            monitor-exit(r3)
            return
        L1f:
            android.content.Context r0 = r4.getApplicationContext()     // Catch: java.lang.Throwable -> L9c
            if (r0 == 0) goto L42
            if (r5 == 0) goto L42
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L9c
            if (r1 != 0) goto L42
            android.content.SharedPreferences r1 = com.umeng.umzid.a.a(r0)     // Catch: java.lang.Throwable -> L9c
            if (r1 == 0) goto L42
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch: java.lang.Throwable -> L9c
            if (r1 == 0) goto L42
            java.lang.String r2 = "appkey"
            android.content.SharedPreferences$Editor r5 = r1.putString(r2, r5)     // Catch: java.lang.Throwable -> L9c
            r5.commit()     // Catch: java.lang.Throwable -> L9c
        L42:
            java.lang.String r5 = com.umeng.umzid.c.a(r0)     // Catch: java.lang.Throwable -> L9c
            if (r5 == 0) goto L5d
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L9c
            if (r1 == 0) goto L4f
            goto L5d
        L4f:
            com.umeng.umzid.ZIDManager$b r1 = new com.umeng.umzid.ZIDManager$b     // Catch: java.lang.Throwable -> L9c
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L9c
            com.umeng.umzid.b.a(r1)     // Catch: java.lang.Throwable -> L9c
            if (r6 == 0) goto L65
            r6.onSuccess(r5)     // Catch: java.lang.Throwable -> L9c
            goto L65
        L5d:
            com.umeng.umzid.ZIDManager$a r5 = new com.umeng.umzid.ZIDManager$a     // Catch: java.lang.Throwable -> L9c
            r5.<init>(r0, r6)     // Catch: java.lang.Throwable -> L9c
            com.umeng.umzid.b.a(r5)     // Catch: java.lang.Throwable -> L9c
        L65:
            java.lang.String r5 = ""
            android.content.SharedPreferences r6 = com.umeng.umzid.a.a(r4)     // Catch: java.lang.Throwable -> L9c
            if (r6 == 0) goto L75
            java.lang.String r5 = "uuid"
            java.lang.String r0 = ""
            java.lang.String r5 = r6.getString(r5, r0)     // Catch: java.lang.Throwable -> L9c
        L75:
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L9c
            if (r5 == 0) goto L9a
            java.lang.String r5 = ""
            android.content.SharedPreferences r4 = com.umeng.umzid.a.a(r4)     // Catch: java.lang.Throwable -> L9c
            java.util.UUID r6 = java.util.UUID.randomUUID()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Throwable -> L8a
            goto L8b
        L8a:
        L8b:
            if (r4 == 0) goto L9a
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r6 = "uuid"
            android.content.SharedPreferences$Editor r4 = r4.putString(r6, r5)     // Catch: java.lang.Throwable -> L9c
            r4.commit()     // Catch: java.lang.Throwable -> L9c
        L9a:
            monitor-exit(r3)
            return
        L9c:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.init(android.content.Context, java.lang.String, com.umeng.umzid.IZIDCompletionCallback):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(43:1|(2:2|3)|(2:8|(39:12|13|(1:123)(1:17)|(1:21)|22|(5:111|112|(2:119|120)|114|(33:116|25|26|27|(2:32|(28:36|37|38|39|40|41|(3:92|93|(5:95|96|(2:99|97)|100|101))|43|(1:45)(1:91)|46|(1:48)(1:90)|49|50|51|52|53|54|55|56|57|58|(1:62)|63|64|65|(2:70|(2:74|75))|77|78))|109|37|38|39|40|41|(0)|43|(0)(0)|46|(0)(0)|49|50|51|52|53|54|55|56|57|58|(2:60|62)|63|64|65|(4:67|68|70|(3:72|74|75))|77|78))|24|25|26|27|(4:29|30|32|(29:34|36|37|38|39|40|41|(0)|43|(0)(0)|46|(0)(0)|49|50|51|52|53|54|55|56|57|58|(0)|63|64|65|(0)|77|78))|109|37|38|39|40|41|(0)|43|(0)(0)|46|(0)(0)|49|50|51|52|53|54|55|56|57|58|(0)|63|64|65|(0)|77|78))|125|13|(1:15)|123|(2:19|21)|22|(0)|24|25|26|27|(0)|109|37|38|39|40|41|(0)|43|(0)(0)|46|(0)(0)|49|50|51|52|53|54|55|56|57|58|(0)|63|64|65|(0)|77|78) */
    /* JADX WARN: Can't wrap try/catch for region: R(44:1|2|3|(2:8|(39:12|13|(1:123)(1:17)|(1:21)|22|(5:111|112|(2:119|120)|114|(33:116|25|26|27|(2:32|(28:36|37|38|39|40|41|(3:92|93|(5:95|96|(2:99|97)|100|101))|43|(1:45)(1:91)|46|(1:48)(1:90)|49|50|51|52|53|54|55|56|57|58|(1:62)|63|64|65|(2:70|(2:74|75))|77|78))|109|37|38|39|40|41|(0)|43|(0)(0)|46|(0)(0)|49|50|51|52|53|54|55|56|57|58|(2:60|62)|63|64|65|(4:67|68|70|(3:72|74|75))|77|78))|24|25|26|27|(4:29|30|32|(29:34|36|37|38|39|40|41|(0)|43|(0)(0)|46|(0)(0)|49|50|51|52|53|54|55|56|57|58|(0)|63|64|65|(0)|77|78))|109|37|38|39|40|41|(0)|43|(0)(0)|46|(0)(0)|49|50|51|52|53|54|55|56|57|58|(0)|63|64|65|(0)|77|78))|125|13|(1:15)|123|(2:19|21)|22|(0)|24|25|26|27|(0)|109|37|38|39|40|41|(0)|43|(0)(0)|46|(0)(0)|49|50|51|52|53|54|55|56|57|58|(0)|63|64|65|(0)|77|78) */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x013f, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01c3, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01c4, code lost:
    
        r5.printStackTrace();
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01aa, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01ab, code lost:
    
        r5.printStackTrace();
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0187, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0188, code lost:
    
        r5.printStackTrace();
        r5 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0108 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.json.JSONObject a(android.content.Context r10, org.json.JSONObject r11) {
        /*
            Method dump skipped, instructions count: 524
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.a(android.content.Context, org.json.JSONObject):org.json.JSONObject");
    }
}
