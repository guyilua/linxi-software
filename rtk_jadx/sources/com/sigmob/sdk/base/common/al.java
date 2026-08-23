package com.sigmob.sdk.base.common;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.downloader.f;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class al {

    /* renamed from: com.sigmob.sdk.base.common.al$1, reason: invalid class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            a = iArr;
            try {
                iArr[c.SLOPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.SWING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c.WRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a implements SensorEventListener {
        static int[] b = {25, 60, 50, 45, 35, 25, 20, 15, 10, 5, 1};

        /* renamed from: c, reason: collision with root package name */
        static float[] f369c = {4.0f, 10.0f, 8.0f, 6.0f, 5.0f, 4.0f, 3.0f, 2.0f, 1.8f, 1.5f, 1.0f};
        private static float j = 40.0f;
        private float A;
        private long D;
        private Integer E;
        Float f;
        private final SensorManager g;
        private float[] h;
        private float[] i;
        private b k;
        private float l;
        private float m;
        private float n;
        private long o;
        private boolean p;
        private float r;
        private float s;
        private float t;
        private c u;
        private long v;
        private float w;
        private float x;
        private float y;
        private boolean z;
        protected int a = 2;
        float[] d = new float[9];
        float[] e = new float[3];
        private int q = 0;
        private int B = 100;
        private int C = f.a.f;

        public a(Context context, b bVar, c cVar) {
            this.g = (SensorManager) context.getSystemService(com.umeng.analytics.pro.ak.ac);
            this.k = bVar;
            this.u = cVar;
        }

        private void a(float[] fArr) {
            float f;
            float sqrt = (float) Math.sqrt(Math.pow(fArr[0], 2.0d) + Math.pow(fArr[1], 2.0d) + Math.pow(fArr[2], 2.0d));
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = currentTimeMillis - this.o >= ((long) this.C);
            if (Math.abs(this.l) < Math.abs(fArr[0])) {
                this.l = fArr[0];
            }
            if (Math.abs(this.m) < Math.abs(fArr[1])) {
                this.m = fArr[1];
            }
            if (Math.abs(this.n) < Math.abs(fArr[2])) {
                this.n = fArr[2];
            }
            Integer num = this.E;
            if (num != null) {
                f = num.intValue();
            } else {
                int i = this.a;
                f = (i <= 0 || i > 10) ? 4.0f : f369c[i];
            }
            j = f;
            SigmobLog.d("shake magnitude" + sqrt);
            float f2 = j;
            if (sqrt > f2 && !this.p && z) {
                this.p = true;
                b bVar = this.k;
                if (bVar != null) {
                    bVar.a();
                    return;
                }
                return;
            }
            if (sqrt < f2 && this.p && z) {
                this.p = false;
                this.o = currentTimeMillis;
                HashMap hashMap = new HashMap();
                hashMap.put("x_max_acc", Float.valueOf(this.l * this.B));
                hashMap.put("y_max_acc", Float.valueOf(this.m * this.B));
                hashMap.put("z_max_acc", Float.valueOf(this.n * this.B));
                this.l = com.sigmob.sdk.base.blurkit.c.d;
                this.m = com.sigmob.sdk.base.blurkit.c.d;
                this.n = com.sigmob.sdk.base.blurkit.c.d;
                b bVar2 = this.k;
                if (bVar2 != null) {
                    bVar2.a(hashMap);
                }
            }
        }

        public void a() {
            SensorManager sensorManager = this.g;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
                SensorManager sensorManager2 = this.g;
                sensorManager2.registerListener(this, sensorManager2.getDefaultSensor(4), 3);
                if (this.u == c.SHAKE) {
                    return;
                }
                SensorManager sensorManager3 = this.g;
                sensorManager3.registerListener(this, sensorManager3.getDefaultSensor(1), 3);
                SensorManager sensorManager4 = this.g;
                sensorManager4.registerListener(this, sensorManager4.getDefaultSensor(2), 3);
            }
            this.f = null;
        }

        public void a(int i) {
            if (i > 0) {
                this.B = i;
            }
        }

        public void b() {
            SensorManager sensorManager = this.g;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
        }

        public void b(int i) {
            this.E = Integer.valueOf(i);
        }

        public void c() {
            SensorManager sensorManager = this.g;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
            this.x = com.sigmob.sdk.base.blurkit.c.d;
            this.y = com.sigmob.sdk.base.blurkit.c.d;
            this.w = com.sigmob.sdk.base.blurkit.c.d;
            this.l = com.sigmob.sdk.base.blurkit.c.d;
            this.m = com.sigmob.sdk.base.blurkit.c.d;
            this.n = com.sigmob.sdk.base.blurkit.c.d;
            this.A = com.sigmob.sdk.base.blurkit.c.d;
            this.D = 0L;
            this.f = null;
            this.k = null;
        }

        public void c(int i) {
            this.a = i;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        /* JADX WARN: Removed duplicated region for block: B:103:0x028a  */
        /* JADX WARN: Removed duplicated region for block: B:106:0x029b  */
        /* JADX WARN: Removed duplicated region for block: B:111:0x02ab  */
        /* JADX WARN: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:118:0x028d  */
        /* JADX WARN: Removed duplicated region for block: B:144:0x0354  */
        /* JADX WARN: Removed duplicated region for block: B:147:0x0364  */
        /* JADX WARN: Removed duplicated region for block: B:150:0x0374  */
        /* JADX WARN: Removed duplicated region for block: B:153:0x0387 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:154:0x0388  */
        @Override // android.hardware.SensorEventListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onSensorChanged(android.hardware.SensorEvent r24) {
            /*
                Method dump skipped, instructions count: 1013
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.common.al.a.onSensorChanged(android.hardware.SensorEvent):void");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface b {
        void a();

        void a(float f);

        void a(Map<String, Number> map);
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum c {
        SWING,
        WRING,
        SLOPE,
        SHAKE
    }
}
