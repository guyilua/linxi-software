package com.qumeng.advlib.common;

import androidx.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {
    private static volatile b a;
    private static Map<String, Class> b = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements InvocationHandler {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            try {
                Method declaredMethod = ((Class) b.b.get(this.a)).getDeclaredMethod(method.getName(), method.getParameterTypes());
                if (Modifier.isPrivate(declaredMethod.getModifiers())) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod.invoke(null, objArr);
            } catch (Error e) {
                e.printStackTrace();
                return null;
            } catch (RuntimeException e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qumeng.advlib.common.b$b, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class C0004b implements InvocationHandler {
        final /* synthetic */ Object a;

        C0004b(Object obj) {
            this.a = obj;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            try {
                Method method2 = this.a.getClass().getMethod(method.getName(), method.getParameterTypes());
                return method2.invoke(Modifier.isStatic(method2.getModifiers()) ? null : this.a, objArr);
            } catch (Error e) {
                e.printStackTrace();
                return null;
            } catch (RuntimeException e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    private b() {
    }

    public static b c() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public <T> Class<T> b(Class cls) {
        return b.get(cls.getName());
    }

    public void a(Class cls, Class cls2) {
        b.put(cls.getName(), cls2);
    }

    public void b() {
        b.clear();
    }

    @Nullable
    public <T> T a(Class<T> cls) {
        return (T) a(cls, cls.getName());
    }

    public <T> T b(Class<T> cls, Object... objArr) {
        return (T) a(true, cls, objArr);
    }

    @Nullable
    private <T> T a(Class<T> cls, String str) {
        if (b.get(str) == null) {
            return null;
        }
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(str));
    }

    @Nullable
    public <T> T a(Class<T> cls, Object... objArr) {
        return (T) a(false, cls, objArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    private <T> T a(boolean z, Class<T> cls, Object... objArr) {
        boolean z2;
        T t;
        Class cls2 = b.get(cls.getName());
        T t2 = null;
        if (cls2 == null) {
            return null;
        }
        if (objArr != null) {
            try {
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (objArr.length > 0) {
                for (Constructor<?> constructor : cls2.getConstructors()) {
                    if (objArr.length == constructor.getParameterTypes().length) {
                        Class<?>[] parameterTypes = constructor.getParameterTypes();
                        int i = 0;
                        while (true) {
                            if (i >= parameterTypes.length) {
                                z2 = true;
                                break;
                            }
                            if (!parameterTypes[i].isInstance(objArr[i])) {
                                z2 = false;
                                break;
                            }
                            i++;
                        }
                        if (z2) {
                            t = constructor.newInstance(objArr);
                            t2 = t;
                            break;
                        }
                    }
                }
                return (t2 != null || z) ? t2 : (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new C0004b(t2));
            }
        }
        t = cls2.newInstance();
        t2 = t;
        if (t2 != null) {
        }
    }
}
