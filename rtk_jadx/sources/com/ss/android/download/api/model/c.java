package com.ss.android.download.api.model;

import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.addownload.k;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c {
    private String a;
    private final String b;

    /* renamed from: c, reason: collision with root package name */
    private final String f706c;
    private final boolean d;
    private final long e;
    private final String f;
    private final long g;
    private final JSONObject h;
    private final JSONObject i;
    private final List<String> j;
    private final int k;
    private final Object l;
    private final String m;
    private final boolean n;
    private final String o;
    private final JSONObject p;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        private String a;
        private String b;

        /* renamed from: c, reason: collision with root package name */
        private String f707c;
        private long e;
        private String f;
        private long g;
        private JSONObject h;
        private JSONObject i;
        private Map<String, Object> j;
        private List<String> k;
        private int l;
        private Object m;
        private String n;
        private String p;
        private JSONObject q;
        private boolean d = false;
        private boolean o = false;

        public a a(boolean z) {
            this.o = z;
            return this;
        }

        public a b(String str) {
            this.f707c = str;
            return this;
        }

        public a c(String str) {
            this.f = str;
            return this;
        }

        public a d(String str) {
            this.n = str;
            return this;
        }

        public a a(String str) {
            this.b = str;
            return this;
        }

        public a b(long j) {
            this.g = j;
            return this;
        }

        public a a(long j) {
            this.e = j;
            return this;
        }

        public a b(boolean z) {
            this.d = z;
            return this;
        }

        public a a(JSONObject jSONObject) {
            this.h = jSONObject;
            return this;
        }

        public a b(JSONObject jSONObject) {
            this.i = jSONObject;
            return this;
        }

        public a a(List<String> list) {
            this.k = list;
            return this;
        }

        public a a(int i) {
            this.l = i;
            return this;
        }

        public a a(Object obj) {
            this.m = obj;
            return this;
        }

        public c a() {
            if (TextUtils.isEmpty(this.a)) {
                this.a = BaseConstants.CATEGORY_UMENG;
            }
            JSONObject jSONObject = new JSONObject();
            if (this.h == null) {
                this.h = new JSONObject();
            }
            try {
                Map<String, Object> map = this.j;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.j.entrySet()) {
                        if (!this.h.has(entry.getKey())) {
                            this.h.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.o) {
                    this.p = this.f707c;
                    JSONObject jSONObject2 = new JSONObject();
                    this.q = jSONObject2;
                    if (this.d) {
                        jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.h.toString());
                    } else {
                        Iterator<String> keys = this.h.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            this.q.put(next, this.h.get(next));
                        }
                    }
                    this.q.put("category", this.a);
                    this.q.put("tag", this.b);
                    this.q.put("value", this.e);
                    this.q.put("ext_value", this.g);
                    if (!TextUtils.isEmpty(this.n)) {
                        this.q.put("refer", this.n);
                    }
                    JSONObject jSONObject3 = this.i;
                    if (jSONObject3 != null) {
                        this.q = com.ss.android.download.api.c.b.a(jSONObject3, this.q);
                    }
                    if (this.d) {
                        if (!this.q.has(BaseConstants.EVENT_LABEL_LOG_EXTRA) && !TextUtils.isEmpty(this.f)) {
                            this.q.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.f);
                        }
                        this.q.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                    }
                }
                if (this.d) {
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.h.toString());
                    if (!jSONObject.has(BaseConstants.EVENT_LABEL_LOG_EXTRA) && !TextUtils.isEmpty(this.f)) {
                        jSONObject.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.f);
                    }
                    jSONObject.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                } else {
                    jSONObject.put(BaseConstants.EVENT_LABEL_EXTRA, this.h);
                }
                if (!TextUtils.isEmpty(this.n)) {
                    jSONObject.putOpt("refer", this.n);
                }
                JSONObject jSONObject4 = this.i;
                if (jSONObject4 != null) {
                    jSONObject = com.ss.android.download.api.c.b.a(jSONObject4, jSONObject);
                }
                this.h = jSONObject;
            } catch (Exception e) {
                k.u().a(e, "DownloadEventModel build");
            }
            return new c(this);
        }
    }

    c(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.f706c = aVar.f707c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.k;
        this.k = aVar.l;
        this.l = aVar.m;
        this.n = aVar.o;
        this.o = aVar.p;
        this.p = aVar.q;
        this.m = aVar.n;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.f706c;
    }

    public boolean d() {
        return this.d;
    }

    public long e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public long g() {
        return this.g;
    }

    public JSONObject h() {
        return this.h;
    }

    public JSONObject i() {
        return this.i;
    }

    public List<String> j() {
        return this.j;
    }

    public int k() {
        return this.k;
    }

    public Object l() {
        return this.l;
    }

    public boolean m() {
        return this.n;
    }

    public String n() {
        return this.o;
    }

    public JSONObject o() {
        return this.p;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("category: ");
        sb.append(this.a);
        sb.append("\ttag: ");
        sb.append(this.b);
        sb.append("\tlabel: ");
        sb.append(this.f706c);
        sb.append("\nisAd: ");
        sb.append(this.d);
        sb.append("\tadId: ");
        sb.append(this.e);
        sb.append("\tlogExtra: ");
        sb.append(this.f);
        sb.append("\textValue: ");
        sb.append(this.g);
        sb.append("\nextJson: ");
        sb.append(this.h);
        sb.append("\nparamsJson: ");
        sb.append(this.i);
        sb.append("\nclickTrackUrl: ");
        List<String> list = this.j;
        sb.append(list != null ? list.toString() : "");
        sb.append("\teventSource: ");
        sb.append(this.k);
        sb.append("\textraObject: ");
        Object obj = this.l;
        sb.append(obj != null ? obj.toString() : "");
        sb.append("\nisV3: ");
        sb.append(this.n);
        sb.append("\tV3EventName: ");
        sb.append(this.o);
        sb.append("\tV3EventParams: ");
        JSONObject jSONObject = this.p;
        sb.append(jSONObject != null ? jSONObject.toString() : "");
        return sb.toString();
    }
}
