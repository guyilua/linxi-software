package com.sigmob.sdk.base.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ai {
    static final int a = 1;
    private static final String b = "LocalBroadcastManager";

    /* renamed from: c, reason: collision with root package name */
    private static final boolean f366c = false;
    private static final Object d = new Object();
    private static ai e;
    private final Context f;
    private final HashMap<BroadcastReceiver, ArrayList<b>> g = new HashMap<>();
    private final HashMap<String, ArrayList<b>> h = new HashMap<>();
    private final ArrayList<a> i = new ArrayList<>();
    private final Handler j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class a {
        final Intent a;
        final ArrayList<b> b;

        a(Intent intent, ArrayList<b> arrayList) {
            this.a = intent;
            this.b = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class b {
        final IntentFilter a;
        final BroadcastReceiver b;

        /* renamed from: c, reason: collision with root package name */
        boolean f367c;
        boolean d;

        b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.a = intentFilter;
            this.b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.b);
            sb.append(" filter=");
            sb.append(this.a);
            if (this.d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private ai(Context context) {
        this.f = context;
        this.j = new Handler(context.getMainLooper()) { // from class: com.sigmob.sdk.base.common.ai.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    ai.this.a();
                }
            }
        };
    }

    public static ai a(Context context) {
        ai aiVar;
        synchronized (d) {
            if (e == null) {
                e = new ai(context.getApplicationContext());
            }
            aiVar = e;
        }
        return aiVar;
    }

    void a() {
        int size;
        a[] aVarArr;
        while (true) {
            synchronized (this.g) {
                size = this.i.size();
                if (size <= 0) {
                    return;
                }
                aVarArr = new a[size];
                this.i.toArray(aVarArr);
                this.i.clear();
            }
            for (int i = 0; i < size; i++) {
                a aVar = aVarArr[i];
                int size2 = aVar.b.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    b bVar = aVar.b.get(i2);
                    if (!bVar.d) {
                        bVar.b.onReceive(this.f, aVar.a);
                    }
                }
            }
        }
    }

    public void a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.g) {
            ArrayList<b> remove = this.g.remove(broadcastReceiver);
            if (remove == null) {
                return;
            }
            for (int size = remove.size() - 1; size >= 0; size--) {
                b bVar = remove.get(size);
                bVar.d = true;
                for (int i = 0; i < bVar.a.countActions(); i++) {
                    String action = bVar.a.getAction(i);
                    ArrayList<b> arrayList = this.h.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            b bVar2 = arrayList.get(size2);
                            if (bVar2.b == broadcastReceiver) {
                                bVar2.d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.h.remove(action);
                        }
                    }
                }
            }
        }
    }

    public void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.g) {
            b bVar = new b(intentFilter, broadcastReceiver);
            ArrayList<b> arrayList = this.g.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.g.put(broadcastReceiver, arrayList);
            }
            arrayList.add(bVar);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<b> arrayList2 = this.h.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.h.put(action, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }

    public boolean a(Intent intent) {
        return a(intent, 0);
    }

    public boolean a(Intent intent, int i) {
        int i2;
        String str;
        ArrayList arrayList;
        ArrayList<b> arrayList2;
        String str2;
        Uri uri;
        synchronized (this.g) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v(b, "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<b> arrayList3 = this.h.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    Log.v(b, "Action list: " + arrayList3);
                }
                ArrayList arrayList4 = null;
                int i3 = 0;
                while (i3 < arrayList3.size()) {
                    b bVar = arrayList3.get(i3);
                    if (z) {
                        Log.v(b, "Matching against filter " + bVar.a);
                    }
                    if (bVar.f367c) {
                        if (z) {
                            Log.v(b, "  Filter's target already added");
                        }
                        i2 = i3;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = resolveTypeIfNeeded;
                        uri = data;
                        arrayList = arrayList4;
                    } else {
                        i2 = i3;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = resolveTypeIfNeeded;
                        uri = data;
                        int match = bVar.a.match(action, resolveTypeIfNeeded, scheme, data, categories, b);
                        if (match >= 0) {
                            if (z) {
                                Log.v(b, "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(bVar);
                            bVar.f367c = true;
                            i3 = i2 + 1;
                            data = uri;
                            action = str;
                            arrayList3 = arrayList2;
                            resolveTypeIfNeeded = str2;
                        } else if (z) {
                            Log.v(b, "  Filter did not match: " + (match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : com.umeng.analytics.pro.d.y : "data" : "action" : "category"));
                        }
                    }
                    arrayList4 = arrayList;
                    i3 = i2 + 1;
                    data = uri;
                    action = str;
                    arrayList3 = arrayList2;
                    resolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i4 = 0; i4 < arrayList5.size(); i4++) {
                        ((b) arrayList5.get(i4)).f367c = false;
                    }
                    this.i.add(new a(intent, arrayList5));
                    if (!this.j.hasMessages(1)) {
                        if (i > 0) {
                            this.j.sendEmptyMessageDelayed(1, i);
                        } else {
                            this.j.sendEmptyMessage(1);
                        }
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void b(Intent intent) {
        if (a(intent)) {
            a();
        }
    }
}
