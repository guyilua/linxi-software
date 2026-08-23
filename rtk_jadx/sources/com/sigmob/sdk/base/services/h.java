package com.sigmob.sdk.base.services;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.mta.PointEntitySensor;
import com.tencent.smtt.sdk.TbsListener;
import com.umeng.analytics.pro.ak;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class h implements SensorEventListener {
    private static Handler b = null;

    /* renamed from: c, reason: collision with root package name */
    private static int f431c = 500;
    private List<g> e;
    private SensorManager f;
    DecimalFormat a = new DecimalFormat("#######.######");
    private g d = new g();
    private int g = TbsListener.ErrorCode.ERROR_CODE_LOAD_BASE;
    private int h = 50;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class a {
        private static final h a = new h();

        private a() {
        }
    }

    public static h a() {
        return a.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0228  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String a(java.util.List<com.sigmob.sdk.base.services.g> r27) {
        /*
            Method dump skipped, instructions count: 927
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.services.h.a(java.util.List):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<g> list, List<g> list2, String str, String str2) {
        PointEntitySensor pointEntitySensor = new PointEntitySensor();
        pointEntitySensor.setAc_type("101");
        pointEntitySensor.setCategory(str);
        pointEntitySensor.setMotion_before(a(list));
        pointEntitySensor.setMotion_after(a(list2));
        pointEntitySensor.setMotion_interval(String.valueOf(this.g));
        pointEntitySensor.setLoad_id(str2);
        pointEntitySensor.commit();
    }

    String a(String str) {
        return str;
    }

    public void a(int i) {
        this.g = i;
    }

    public void a(Context context) {
        try {
            if (this.f != null) {
                if (com.sigmob.sdk.base.l.a().z()) {
                    return;
                }
                this.f.unregisterListener(this);
                b.removeCallbacksAndMessages(null);
                this.e.clear();
                this.f = null;
                return;
            }
            if (com.sigmob.sdk.base.l.a().z()) {
                SigmobLog.i("start anti spam motion");
                this.e = new ArrayList();
                this.h = com.sigmob.sdk.base.l.a().B();
                this.g = com.sigmob.sdk.base.l.a().A();
                f431c = com.sigmob.sdk.base.l.a().C();
                SensorManager sensorManager = (SensorManager) context.getSystemService(ak.ac);
                this.f = sensorManager;
                sensorManager.registerListener(this, sensorManager.getDefaultSensor(5), 3);
                SigmobLog.d("光线传感器 ");
                SensorManager sensorManager2 = this.f;
                sensorManager2.registerListener(this, sensorManager2.getDefaultSensor(1), 3);
                SigmobLog.d("加速传感器 ");
                SensorManager sensorManager3 = this.f;
                sensorManager3.registerListener(this, sensorManager3.getDefaultSensor(2), 3);
                SigmobLog.d("磁场传感器 ");
                SensorManager sensorManager4 = this.f;
                sensorManager4.registerListener(this, sensorManager4.getDefaultSensor(4), 3);
                SigmobLog.d("陀螺仪 ");
                SensorManager sensorManager5 = this.f;
                sensorManager5.registerListener(this, sensorManager5.getDefaultSensor(9), 3);
                SigmobLog.d("重力传感器 ");
                SensorManager sensorManager6 = this.f;
                sensorManager6.registerListener(this, sensorManager6.getDefaultSensor(10), 3);
                SigmobLog.d("线性加速器 ");
                b = new Handler(Looper.getMainLooper()) { // from class: com.sigmob.sdk.base.services.h.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        if (message.what == f.SENSOR_EVENT_BEGIN.a()) {
                            i iVar = (i) message.obj;
                            int size = h.this.e.size() - 1;
                            iVar.a = (g) h.this.e.get(size >= 0 ? size : 0);
                            Message message2 = new Message();
                            message2.what = f.SENSOR_EVENT_END.a();
                            message2.obj = iVar;
                            h.b.sendMessageDelayed(message2, h.this.g * (h.this.h + 1));
                            return;
                        }
                        if (message.what != f.SENSOR_EVENT_END.a()) {
                            if (message.what == f.SENSOR_EVENT_PUSH.a()) {
                                try {
                                    h.this.d.g = System.currentTimeMillis();
                                    g clone = h.this.d.clone();
                                    if (h.this.e.size() > h.f431c) {
                                        h.this.e.remove(0);
                                    }
                                    if (clone != null) {
                                        h.this.e.add(clone);
                                    }
                                } catch (CloneNotSupportedException e) {
                                    SigmobLog.e(e.getMessage());
                                }
                                Message message3 = new Message();
                                message3.what = f.SENSOR_EVENT_PUSH.a();
                                h.b.sendMessageDelayed(message3, h.this.g);
                                return;
                            }
                            return;
                        }
                        i iVar2 = (i) message.obj;
                        int indexOf = h.this.e.indexOf(iVar2.a);
                        int i = indexOf - h.this.h;
                        if (indexOf >= 0 && indexOf >= h.this.h) {
                            r2 = i;
                        }
                        int i2 = h.this.h + indexOf;
                        if (i2 > h.this.e.size() - 1) {
                            i2 = h.this.e.size() - 1;
                        }
                        if (h.this.e.size() > 0) {
                            CopyOnWriteArrayList copyOnWriteArrayList = r2 < indexOf ? new CopyOnWriteArrayList(h.this.e.subList(r2, indexOf)) : null;
                            CopyOnWriteArrayList copyOnWriteArrayList2 = indexOf < i2 ? new CopyOnWriteArrayList(h.this.e.subList(indexOf, i2)) : null;
                            if (copyOnWriteArrayList == null && copyOnWriteArrayList2 == null) {
                                return;
                            }
                            h.this.a(copyOnWriteArrayList, copyOnWriteArrayList2, iVar2.b, iVar2.f432c);
                        }
                    }
                };
                Message message = new Message();
                message.what = f.SENSOR_EVENT_PUSH.a();
                Handler handler = b;
                if (handler != null) {
                    handler.sendMessage(message);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void a(String str, String str2) {
        if (com.sigmob.sdk.base.l.a().z() && com.sigmob.sdk.base.l.a().a(str)) {
            a(com.sigmob.sdk.b.e());
            Message message = new Message();
            i iVar = new i();
            iVar.b = str;
            iVar.f432c = str2;
            message.what = f.SENSOR_EVENT_BEGIN.a();
            message.obj = iVar;
            Handler handler = b;
            if (handler != null) {
                handler.sendMessage(message);
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            this.d.d = (float[]) sensorEvent.values.clone();
            return;
        }
        if (type == 2) {
            this.d.f430c = (float[]) sensorEvent.values.clone();
            return;
        }
        if (type == 4) {
            this.d.b = (float[]) sensorEvent.values.clone();
            return;
        }
        if (type == 5) {
            this.d.e = (float[]) sensorEvent.values.clone();
        } else if (type == 9) {
            this.d.a = (float[]) sensorEvent.values.clone();
        } else {
            if (type != 10) {
                return;
            }
            this.d.f = (float[]) sensorEvent.values.clone();
        }
    }
}
