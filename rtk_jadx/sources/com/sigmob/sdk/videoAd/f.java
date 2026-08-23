package com.sigmob.sdk.videoAd;

import com.czhj.sdk.common.track.AdTracker;
import com.czhj.sdk.common.utils.Preconditions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f extends AdTracker implements Serializable, Comparable<f> {
    private static final long serialVersionUID = 0;
    private final float a;

    public f(String str, float f) {
        super(AdTracker.MessageType.QUARTILE_EVENT, (String) null, str, (String) null);
        Preconditions.NoThrow.checkArgument(f >= com.sigmob.sdk.base.blurkit.c.d);
        this.a = f;
    }

    private float a() {
        return this.a;
    }

    public static List<f> a(List<f> list, String str, long j, long j2) {
        if (j2 <= 0 || j < 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        f fVar = new f(str, ((float) j) / ((float) j2));
        int size = list.size();
        for (int i = 0; i < size; i++) {
            f fVar2 = list.get(i);
            if (fVar2.compareTo(fVar) > 0) {
                break;
            }
            if (!fVar2.isTracked()) {
                arrayList.add(fVar2);
            }
        }
        return arrayList;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        return Double.compare(a(), fVar.a());
    }

    public String toString() {
        return String.format(Locale.US, "%2f: %s", Float.valueOf(this.a), getUrl());
    }
}
