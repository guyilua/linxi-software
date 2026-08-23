package com.sigmob.sdk.base.common;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.downloader.f;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class aa {

    /* renamed from: com.sigmob.sdk.base.common.aa$1, reason: invalid class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.values().length];
            a = iArr;
            try {
                iArr[d.SLOPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.SWING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[d.WRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static abstract class a {
        static int[] b = {25, 60, 50, 45, 35, 25, 20, 15, 10, 5, 1};

        /* renamed from: c, reason: collision with root package name */
        static float[] f357c = {4.0f, 10.0f, 8.0f, 6.0f, 5.0f, 4.0f, 3.0f, 2.0f, 1.8f, 1.5f, 1.0f};
        protected int a = 2;

        public abstract void a();

        public abstract void a(int i);

        public abstract void b();

        public abstract void b(int i);

        public abstract void c();
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface b {
        void a();

        void a(float f);

        void a(Map<String, Number> map);
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class c extends a implements SensorEventListener {
        private static float j = 40.0f;
        private long B;
        private Integer C;
        Float f;
        private final SensorManager g;
        private float[] h;
        private float[] i;
        private b k;
        private float l;
        private float m;
        private float n;
        private float p;
        private float q;
        private float r;
        private d s;
        private long t;
        private float u;
        private float v;
        private float w;
        private boolean x;
        private float y;
        float[] d = new float[9];
        float[] e = new float[3];
        private int o = 0;
        private int z = 100;
        private int A = f.a.f;

        public c(Context context, b bVar, d dVar) {
            this.g = (SensorManager) context.getSystemService(com.umeng.analytics.pro.ak.ac);
            this.k = bVar;
            this.s = dVar;
        }

        @Override // com.sigmob.sdk.base.common.aa.a
        public void a() {
            SensorManager sensorManager = this.g;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
                SensorManager sensorManager2 = this.g;
                sensorManager2.registerListener(this, sensorManager2.getDefaultSensor(1), 3);
                SensorManager sensorManager3 = this.g;
                sensorManager3.registerListener(this, sensorManager3.getDefaultSensor(2), 3);
                SensorManager sensorManager4 = this.g;
                sensorManager4.registerListener(this, sensorManager4.getDefaultSensor(4), 3);
            }
            this.f = null;
        }

        @Override // com.sigmob.sdk.base.common.aa.a
        public void a(int i) {
            this.a = i;
        }

        @Override // com.sigmob.sdk.base.common.aa.a
        public void b() {
            SensorManager sensorManager = this.g;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
        }

        @Override // com.sigmob.sdk.base.common.aa.a
        public void b(int i) {
            this.C = Integer.valueOf(i);
        }

        @Override // com.sigmob.sdk.base.common.aa.a
        public void c() {
            SensorManager sensorManager = this.g;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
            this.v = com.sigmob.sdk.base.blurkit.c.d;
            this.w = com.sigmob.sdk.base.blurkit.c.d;
            this.u = com.sigmob.sdk.base.blurkit.c.d;
            this.l = com.sigmob.sdk.base.blurkit.c.d;
            this.m = com.sigmob.sdk.base.blurkit.c.d;
            this.n = com.sigmob.sdk.base.blurkit.c.d;
            this.y = com.sigmob.sdk.base.blurkit.c.d;
            this.B = 0L;
            this.f = null;
            this.k = null;
        }

        public void c(int i) {
            if (i > 0) {
                this.z = i;
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        /* JADX WARN: Removed duplicated region for block: B:103:0x0280  */
        /* JADX WARN: Removed duplicated region for block: B:106:0x0291  */
        /* JADX WARN: Removed duplicated region for block: B:111:0x02a1  */
        /* JADX WARN: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:118:0x0283  */
        /* JADX WARN: Removed duplicated region for block: B:144:0x034a  */
        /* JADX WARN: Removed duplicated region for block: B:147:0x035a  */
        /* JADX WARN: Removed duplicated region for block: B:150:0x036a  */
        /* JADX WARN: Removed duplicated region for block: B:153:0x037d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:154:0x037e  */
        @Override // android.hardware.SensorEventListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onSensorChanged(android.hardware.SensorEvent r24) {
            /*
                Method dump skipped, instructions count: 1003
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.common.aa.c.onSensorChanged(android.hardware.SensorEvent):void");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum d {
        SWING,
        WRING,
        SLOPE
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class e extends a implements SensorEventListener {
        private static float d = 3.0f;
        private static final long e = 2000;
        private final SensorManager f;
        private long g;
        private boolean h;
        private float i;
        private float j;
        private float k;
        private b l;
        private int m = 100;
        private Integer n;

        public e(Context context, b bVar) {
            this.l = bVar;
            this.f = (SensorManager) context.getSystemService(com.umeng.analytics.pro.ak.ac);
        }

        private void a(float[] fArr) {
            float f;
            float sqrt = (float) Math.sqrt(Math.pow(fArr[0], 2.0d) + Math.pow(fArr[1], 2.0d) + Math.pow(fArr[2], 2.0d));
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = currentTimeMillis - this.g >= e;
            if (Math.abs(this.i) < Math.abs(fArr[0])) {
                this.i = fArr[0];
            }
            if (Math.abs(this.j) < Math.abs(fArr[1])) {
                this.j = fArr[1];
            }
            if (Math.abs(this.k) < Math.abs(fArr[2])) {
                this.k = fArr[2];
            }
            Integer num = this.n;
            if (num != null) {
                f = num.intValue();
            } else {
                int i = this.a;
                f = (i <= 0 || i > 10) ? 4.0f : a.f357c[i];
            }
            d = f;
            SigmobLog.d("shake magnitude" + sqrt);
            float f2 = d;
            if (sqrt > f2 && !this.h && z) {
                this.h = true;
                b bVar = this.l;
                if (bVar != null) {
                    bVar.a();
                    return;
                }
                return;
            }
            if (sqrt < f2 && this.h && z) {
                this.h = false;
                this.g = currentTimeMillis;
                HashMap hashMap = new HashMap();
                hashMap.put("x_max_acc", Float.valueOf(this.i * this.m));
                hashMap.put("y_max_acc", Float.valueOf(this.j * this.m));
                hashMap.put("z_max_acc", Float.valueOf(this.k * this.m));
                this.i = com.sigmob.sdk.base.blurkit.c.d;
                this.j = com.sigmob.sdk.base.blurkit.c.d;
                this.k = com.sigmob.sdk.base.blurkit.c.d;
                b bVar2 = this.l;
                if (bVar2 != null) {
                    bVar2.a(hashMap);
                }
            }
        }

        @Override // com.sigmob.sdk.base.common.aa.a
        public void a() {
            SensorManager sensorManager = this.f;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
                SensorManager sensorManager2 = this.f;
                sensorManager2.registerListener(this, sensorManager2.getDefaultSensor(4), 3);
            }
        }

        @Override // com.sigmob.sdk.base.common.aa.a
        public void a(int i) {
            this.a = i;
        }

        @Override // com.sigmob.sdk.base.common.aa.a
        public void b() {
            SensorManager sensorManager = this.f;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
        }

        @Override // com.sigmob.sdk.base.common.aa.a
        public void b(int i) {
            this.n = Integer.valueOf(i);
        }

        @Override // com.sigmob.sdk.base.common.aa.a
        public void c() {
            SensorManager sensorManager = this.f;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
            this.g = 0L;
            this.i = com.sigmob.sdk.base.blurkit.c.d;
            this.j = com.sigmob.sdk.base.blurkit.c.d;
            this.k = com.sigmob.sdk.base.blurkit.c.d;
            this.l = null;
        }

        public void c(int i) {
            if (i > 0) {
                this.m = i;
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 4) {
                a(sensorEvent.values);
            }
        }
    }
}
