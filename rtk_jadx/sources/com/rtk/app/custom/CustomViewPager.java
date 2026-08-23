package com.rtk.app.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CustomViewPager extends ViewPager {
    private int a;
    private int b;

    /* renamed from: c, reason: collision with root package name */
    private HashMap<Integer, View> f157c;
    private boolean d;

    public CustomViewPager(Context context) {
        super(context);
        this.b = 0;
        this.f157c = new LinkedHashMap();
        this.d = true;
    }

    protected void onMeasure(int i, int i2) {
        int size = this.f157c.size();
        int i3 = this.a;
        if (size > i3) {
            View view = this.f157c.get(Integer.valueOf(i3));
            view.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
            this.b = view.getMeasuredHeight();
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.b, WXVideoFileObject.FILE_SIZE_LIMIT));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.d) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setObjectForPosition(View view, int i) {
        this.f157c.put(Integer.valueOf(i), view);
    }

    public void setScrollble(boolean z) {
        this.d = z;
    }

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
        this.f157c = new LinkedHashMap();
        this.d = true;
    }
}
