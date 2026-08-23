package com.qumeng.advlib.common;

import android.annotation.SuppressLint;
import com.umeng.analytics.pro.ak;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c {
    private final Object a;
    private final boolean b = true;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements InvocationHandler {
        final /* synthetic */ boolean a;

        a(boolean z) {
            this.a = z;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            try {
                return c.a(c.this.a).a(name, objArr).c();
            } catch (ReflectException e) {
                if (this.a) {
                    Map map = (Map) c.this.a;
                    int length = objArr == null ? 0 : objArr.length;
                    if (length == 0 && name.startsWith("get")) {
                        return map.get(c.h(name.substring(3)));
                    }
                    if (length == 0 && name.startsWith(ak.ae)) {
                        return map.get(c.h(name.substring(2)));
                    }
                    if (length == 1 && name.startsWith("set")) {
                        map.put(c.h(name.substring(3)), objArr[0]);
                        return null;
                    }
                }
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b {
        private b() {
        }
    }

    private c(Class<?> cls) {
        this.a = cls;
    }

    public static c b(String str, ClassLoader classLoader) {
        return b(a(str, classLoader));
    }

    public static Class<?> c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (!cls.isPrimitive()) {
            return cls;
        }
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        if (Short.TYPE == cls) {
            return Short.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        return Void.TYPE == cls ? Void.class : cls;
    }

    private Field d(String str) {
        Class<?> e = e();
        try {
            return e.getField(str);
        } catch (NoSuchFieldException e2) {
            do {
                try {
                    return (Field) a(e.getDeclaredField(str));
                } catch (NoSuchFieldException unused) {
                    e = e.getSuperclass();
                }
            } while (e != null);
            throw new ReflectException(e2);
        }
    }

    private static Class<?> e(String str) {
        try {
            return Class.forName(str);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public static c g(String str) {
        return b(e(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"DefaultLocale"})
    public static String h(String str) {
        int length = str.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return str.toLowerCase();
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.a.equals(((c) obj).c());
        }
        return false;
    }

    public <T> T f(String str) {
        return (T) c(str).c();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }

    public static c b(Class<?> cls) {
        return new c(cls);
    }

    public static c a(Object obj) {
        return new c(obj);
    }

    private static Object b(Object obj) {
        return obj instanceof c ? ((c) obj).c() : obj;
    }

    public Class<?> e() {
        if (this.b) {
            return (Class) this.a;
        }
        return this.a.getClass();
    }

    private c(Object obj) {
        this.a = obj;
    }

    public static <T extends AccessibleObject> T a(T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof Member) {
            Member member = (Member) t;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return t;
            }
        }
        if (!t.isAccessible()) {
            t.setAccessible(true);
        }
        return t;
    }

    private static Class<?>[] b(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? b.class : obj.getClass();
        }
        return clsArr;
    }

    public Object d() {
        return this.a;
    }

    public Map<String, c> b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Class<?> e = e();
        do {
            for (Field field : e.getDeclaredFields()) {
                if ((!this.b) ^ Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!linkedHashMap.containsKey(name)) {
                        linkedHashMap.put(name, c(name));
                    }
                }
            }
            e = e.getSuperclass();
        } while (e != null);
        return linkedHashMap;
    }

    private static c a(Constructor<?> constructor, Object... objArr) {
        try {
            return a(((Constructor) a(constructor)).newInstance(objArr));
        } catch (Throwable th) {
            throw new ReflectException(th);
        }
    }

    private static c a(Method method, Object obj, Object... objArr) {
        try {
            a(method);
            if (method.getReturnType() == Void.TYPE) {
                method.invoke(obj, objArr);
                return a(obj);
            }
            return a(method.invoke(obj, objArr));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public c b(String str) {
        return a(str, new Object[0]);
    }

    private static Class<?> a(String str, ClassLoader classLoader) {
        try {
            return Class.forName(str, true, classLoader);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private Method b(String str, Class<?>[] clsArr) {
        Class<?> e = e();
        for (Method method : e.getMethods()) {
            if (a(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : e.getDeclaredMethods()) {
                if (a(method2, str, clsArr)) {
                    return method2;
                }
            }
            e = e.getSuperclass();
        } while (e != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + e() + ".");
    }

    public c a(Field field, Object obj) {
        try {
            field.setAccessible(true);
            field.set(this.a, b(obj));
            return this;
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public <T> T c() {
        return (T) this.a;
    }

    public c c(String str) {
        try {
            return a(d(str).get(this.a));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public c a(String str, Object obj) {
        try {
            Field d = d(str);
            d.setAccessible(true);
            d.set(this.a, b(obj));
            return this;
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public c a(String str, Object... objArr) {
        Class<?>[] b2 = b(objArr);
        try {
            try {
                return a(a(str, b2), this.a, objArr);
            } catch (NoSuchMethodException e) {
                throw new ReflectException(e);
            }
        } catch (NoSuchMethodException unused) {
            return a(b(str, b2), this.a, objArr);
        }
    }

    private Method a(String str, Class<?>[] clsArr) {
        Class<?> e = e();
        try {
            return e.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    return e.getDeclaredMethod(str, clsArr);
                } catch (NoSuchMethodException unused2) {
                    e = e.getSuperclass();
                }
            } while (e != null);
            throw new NoSuchMethodException();
        }
    }

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    public c a() {
        return a(new Object[0]);
    }

    public c a(Object... objArr) {
        Class<?>[] b2 = b(objArr);
        try {
            return a(e().getDeclaredConstructor(b2), objArr);
        } catch (NoSuchMethodException e) {
            for (Constructor<?> constructor : e().getDeclaredConstructors()) {
                if (a(constructor.getParameterTypes(), b2)) {
                    return a(constructor, objArr);
                }
            }
            throw new ReflectException(e);
        }
    }

    public <P> P a(Class<P> cls) {
        return (P) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(this.a instanceof Map));
    }

    private boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr2.length; i++) {
            if (clsArr2[i] != b.class && (c(clsArr2[i]) == null || !c(clsArr[i]).isAssignableFrom(c(clsArr2[i])))) {
                return false;
            }
        }
        return true;
    }
}
