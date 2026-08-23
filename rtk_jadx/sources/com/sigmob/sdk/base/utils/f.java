package com.sigmob.sdk.base.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f {

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        boolean a(View view, MotionEvent motionEvent, MotionEvent motionEvent2);
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements View.OnTouchListener {
        private final a b;

        /* renamed from: c, reason: collision with root package name */
        private MotionEvent f439c;

        b(a aVar) {
            this.b = aVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            a aVar;
            if (motionEvent.getAction() == 0) {
                this.f439c = motionEvent;
                return false;
            }
            if (motionEvent.getAction() != 1 || (aVar = this.b) == null) {
                return false;
            }
            aVar.a(view, this.f439c, motionEvent);
            return false;
        }
    }

    private static int a(View view, ViewGroup viewGroup) {
        int i = 0;
        while (i < viewGroup.getChildCount() && viewGroup.getChildAt(i) != view) {
            i++;
        }
        return i;
    }

    private static View a(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getWindow().getDecorView().findViewById(R.id.content);
        }
        return null;
    }

    public static View a(Context context, View view) {
        View a2 = a(context);
        return a2 != null ? a2 : e(view);
    }

    public static <T extends View> T a(ViewGroup viewGroup, Class<T> cls) {
        T t;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (cls.isInstance(childAt)) {
                return cls.cast(childAt);
            }
            if ((childAt instanceof ViewGroup) && (t = (T) a((ViewGroup) childAt, cls)) != null) {
                return t;
            }
        }
        return null;
    }

    public static void a(View view) {
        if (view == null || view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) view.getParent()).removeView(view);
    }

    public static void a(final View view, final Runnable runnable) {
        if (view == null || runnable == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sigmob.sdk.base.utils.f.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                View view2 = view;
                if (view2 != null) {
                    view2.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        });
    }

    public static boolean a(View view, MotionEvent motionEvent) {
        if (view == null) {
            return false;
        }
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return rawY >= i2 && rawY <= view.getMeasuredHeight() + i2 && rawX >= i && rawX <= view.getMeasuredWidth() + i;
    }

    public static boolean a(View view, boolean z, float f) {
        Rect rect = new Rect();
        if (!(view.getGlobalVisibleRect(rect) && (rect.bottom - rect.top >= view.getMeasuredHeight()) && (rect.right - rect.left >= view.getMeasuredWidth())) && z) {
            return true;
        }
        View view2 = view;
        while (view2.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            if (viewGroup.getVisibility() != 0) {
                return true;
            }
            for (int a2 = a(view2, viewGroup) + 1; a2 < viewGroup.getChildCount(); a2++) {
                Rect rect2 = new Rect();
                view.getGlobalVisibleRect(rect2);
                View childAt = viewGroup.getChildAt(a2);
                Rect rect3 = new Rect();
                childAt.getGlobalVisibleRect(rect3);
                rect3.height();
                rect2.height();
                int height = (int) ((rect3.height() * 100.0f) / rect2.height());
                if (Rect.intersects(rect2, rect3) && height >= f) {
                    return true;
                }
            }
            view2 = viewGroup;
        }
        return false;
    }

    public static boolean b(View view) {
        return view.getParent() != null && view.getVisibility() == 0 && view.isShown();
    }

    public static Activity c(View view) {
        View e = e(view);
        if (e != null) {
            return d(e);
        }
        return null;
    }

    public static Activity d(View view) {
        if (view == null) {
            return null;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public static View e(View view) {
        View rootView;
        if (view == null || (rootView = view.getRootView()) == null) {
            return null;
        }
        View findViewById = rootView.findViewById(R.id.content);
        return findViewById != null ? findViewById : rootView;
    }
}
