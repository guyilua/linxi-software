package com.qq.e.comm.adevent;

import com.qq.e.comm.util.GDTLogger;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ADEvent {
    private final int a;
    private final Object[] b;

    public ADEvent(int i, Object... objArr) {
        this.a = i;
        this.b = objArr;
        if (i < 100) {
            a("EventId 错误" + i);
        }
    }

    private void a(String str) {
        GDTLogger.e(str);
    }

    public <T> T getParam(int i, Class<T> cls) {
        Object[] objArr;
        if (cls == null || (objArr = this.b) == null || objArr.length <= i) {
            return null;
        }
        T t = (T) objArr[i];
        if (t == null) {
            GDTLogger.e("ADEvent 参数为空,type:" + this.a);
            return null;
        }
        if (cls.isInstance(objArr[i])) {
            return t;
        }
        GDTLogger.e("ADEvent" + this.a + " 参数类型错误,期望类型" + cls.getName() + "实际类型 " + t.getClass().getName());
        return null;
    }

    public <T> T getParam(Class<T> cls) {
        return (T) getParam(0, cls);
    }

    public int getType() {
        return this.a;
    }
}
