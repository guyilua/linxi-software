package com.sigmob.sdk.base.mta;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PointEntityActive extends PointEntitySigmobSuper {
    private String a;
    private String b;

    /* renamed from: c, reason: collision with root package name */
    private String f415c;
    private String d;

    public static PointEntityActive ActiveTracking(String str, String str2, String str3, String str4) {
        PointEntityActive pointEntityActive = new PointEntityActive();
        pointEntityActive.setAc_type(PointType.WIND_ACTIVE);
        pointEntityActive.setCategory(str);
        pointEntityActive.setActive_id(str2);
        pointEntityActive.setDuration(str3);
        pointEntityActive.setTimestamp(str4);
        pointEntityActive.commit();
        return pointEntityActive;
    }

    public String getActive_id() {
        return this.a;
    }

    public String getDuration() {
        return this.d;
    }

    public String getRequest_id() {
        return this.b;
    }

    public String getVid() {
        return this.f415c;
    }

    public void setActive_id(String str) {
        this.a = str;
    }

    public void setDuration(String str) {
        this.d = str;
    }

    public void setRequest_id(String str) {
        this.b = str;
    }

    public void setVid(String str) {
        this.f415c = str;
    }
}
