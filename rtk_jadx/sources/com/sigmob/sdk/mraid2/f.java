package com.sigmob.sdk.mraid2;

import android.view.View;
import com.sigmob.sdk.base.common.aa;
import com.sigmob.sdk.base.mta.PointCategory;
import com.umeng.analytics.pro.ak;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f extends com.sigmob.sdk.mraid.j {

    /* renamed from: c, reason: collision with root package name */
    private static final String f584c = "motion_shake_start";
    private static final String d = "motion_shake_end";
    private static final String e = "motion_twist_start";
    private static final String f = "motion_twist_end";
    private i g;
    private aa.a h;

    public f(String str, String str2) {
        super(str);
        str2.hashCode();
        char c2 = 65535;
        switch (str2.hashCode()) {
            case 109399814:
                if (str2.equals("shake")) {
                    c2 = 0;
                    break;
                }
                break;
            case 109532587:
                if (str2.equals("slope")) {
                    c2 = 1;
                    break;
                }
                break;
            case 109854462:
                if (str2.equals("swing")) {
                    c2 = 2;
                    break;
                }
                break;
            case 110778151:
                if (str2.equals("twist")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                f();
                return;
            case 1:
                g();
                return;
            case 2:
                h();
                return;
            case 3:
                e();
                return;
            default:
                return;
        }
    }

    private void e() {
        this.h = new aa.c(com.sigmob.sdk.b.e(), new aa.b() { // from class: com.sigmob.sdk.mraid2.f.1
            @Override // com.sigmob.sdk.base.common.aa.b
            public void a() {
                HashMap<String, Object> hashMap = new HashMap<>();
                if (f.this.g != null) {
                    f.this.g.a(((com.sigmob.sdk.mraid.j) f.this).a, "twist", "began", hashMap);
                }
            }

            @Override // com.sigmob.sdk.base.common.aa.b
            public void a(float f2) {
            }

            @Override // com.sigmob.sdk.base.common.aa.b
            public void a(Map<String, Number> map) {
                if (map != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    Number number = map.get("turn_x");
                    Number number2 = map.get("turn_y");
                    Number number3 = map.get("turn_z");
                    Number number4 = map.get("turn_time");
                    hashMap.put("x", number);
                    hashMap.put("y", number2);
                    hashMap.put(ak.aD, number3);
                    hashMap.put("time", number4);
                    if (f.this.g != null) {
                        f.this.g.a(((com.sigmob.sdk.mraid.j) f.this).a, "twist", PointCategory.END, hashMap);
                    }
                }
            }
        }, aa.d.WRING);
    }

    private void f() {
        aa.e eVar = new aa.e(com.sigmob.sdk.b.e(), new aa.b() { // from class: com.sigmob.sdk.mraid2.f.2
            @Override // com.sigmob.sdk.base.common.aa.b
            public void a() {
                HashMap<String, Object> hashMap = new HashMap<>();
                if (f.this.g != null) {
                    f.this.g.a(((com.sigmob.sdk.mraid.j) f.this).a, "shake", "began", hashMap);
                }
            }

            @Override // com.sigmob.sdk.base.common.aa.b
            public void a(float f2) {
            }

            @Override // com.sigmob.sdk.base.common.aa.b
            public void a(Map<String, Number> map) {
                if (map != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    Number number = map.get("x_max_acc");
                    Number number2 = map.get("y_max_acc");
                    Number number3 = map.get("z_max_acc");
                    hashMap.put("x", String.valueOf(number));
                    hashMap.put("y", String.valueOf(number2));
                    hashMap.put(ak.aD, String.valueOf(number3));
                    if (f.this.g != null) {
                        f.this.g.a(((com.sigmob.sdk.mraid.j) f.this).a, "shake", PointCategory.END, hashMap);
                    }
                }
            }
        });
        eVar.c(1);
        this.h = eVar;
    }

    private void g() {
        aa.c cVar = new aa.c(com.sigmob.sdk.b.e(), new aa.b() { // from class: com.sigmob.sdk.mraid2.f.3
            @Override // com.sigmob.sdk.base.common.aa.b
            public void a() {
                HashMap<String, Object> hashMap = new HashMap<>();
                if (f.this.g != null) {
                    f.this.g.a(((com.sigmob.sdk.mraid.j) f.this).a, "slope", "began", hashMap);
                }
            }

            @Override // com.sigmob.sdk.base.common.aa.b
            public void a(float f2) {
                if (f.this.g != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put(PointCategory.PROGRESS, Integer.valueOf((int) (f2 * 100.0f)));
                    f.this.g.a(((com.sigmob.sdk.mraid.j) f.this).a, "slope", PointCategory.PROGRESS, hashMap);
                }
            }

            @Override // com.sigmob.sdk.base.common.aa.b
            public void a(Map<String, Number> map) {
                if (map != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    Number number = map.get("turn_x");
                    Number number2 = map.get("turn_y");
                    Number number3 = map.get("turn_z");
                    Number number4 = map.get("turn_time");
                    hashMap.put("x", String.valueOf(number));
                    hashMap.put("y", String.valueOf(number2));
                    hashMap.put(ak.aD, String.valueOf(number3));
                    hashMap.put("time", number4);
                    if (f.this.g != null) {
                        f.this.g.a(((com.sigmob.sdk.mraid.j) f.this).a, "slope", PointCategory.END, hashMap);
                    }
                }
            }
        }, aa.d.SLOPE);
        cVar.c(1);
        this.h = cVar;
    }

    private void h() {
        aa.c cVar = new aa.c(com.sigmob.sdk.b.e(), new aa.b() { // from class: com.sigmob.sdk.mraid2.f.4
            @Override // com.sigmob.sdk.base.common.aa.b
            public void a() {
                HashMap<String, Object> hashMap = new HashMap<>();
                if (f.this.g != null) {
                    f.this.g.a(((com.sigmob.sdk.mraid.j) f.this).a, "swing", "began", hashMap);
                }
            }

            @Override // com.sigmob.sdk.base.common.aa.b
            public void a(float f2) {
                if (f.this.g != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put(PointCategory.PROGRESS, Integer.valueOf((int) (f2 * 100.0f)));
                    f.this.g.a(((com.sigmob.sdk.mraid.j) f.this).a, "swing", PointCategory.PROGRESS, hashMap);
                }
            }

            @Override // com.sigmob.sdk.base.common.aa.b
            public void a(Map<String, Number> map) {
                if (map != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    Number number = map.get("x_max_acc");
                    Number number2 = map.get("y_max_acc");
                    Number number3 = map.get("z_max_acc");
                    hashMap.put("x", String.valueOf(number));
                    hashMap.put("y", String.valueOf(number2));
                    hashMap.put(ak.aD, String.valueOf(number3));
                    if (f.this.g != null) {
                        f.this.g.a(((com.sigmob.sdk.mraid.j) f.this).a, "swing", PointCategory.END, hashMap);
                    }
                }
            }
        }, aa.d.SWING);
        cVar.c(1);
        this.h = cVar;
    }

    public void a() {
        aa.a aVar = this.h;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void a(int i) {
        aa.a aVar = this.h;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void a(i iVar) {
        this.g = iVar;
    }

    @Override // com.sigmob.sdk.mraid.j
    public View b() {
        return null;
    }

    public void b(int i) {
        aa.a aVar = this.h;
        if (aVar != null) {
            aVar.b(i);
        }
    }

    @Override // com.sigmob.sdk.mraid.j
    public void c() {
        this.g = null;
        aa.a aVar = this.h;
        if (aVar != null) {
            aVar.c();
        }
    }
}
