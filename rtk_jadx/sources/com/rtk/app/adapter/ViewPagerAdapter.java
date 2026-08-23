package com.rtk.app.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ViewPagerAdapter extends PagerAdapter {
    private List<View> a;

    public ViewPagerAdapter(List<View> list) {
        this.a = list;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.a.get(i));
    }

    public int getCount() {
        return this.a.size();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup.addView(this.a.get(i), 0);
        return this.a.get(i);
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
