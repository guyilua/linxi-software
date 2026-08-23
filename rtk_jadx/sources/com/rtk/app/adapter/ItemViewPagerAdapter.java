package com.rtk.app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ItemViewPagerAdapter extends PagerAdapter {
    private List<View> a;
    private List<String> b;

    public ItemViewPagerAdapter(List<View> list, List<String> list2, Context context) {
        this.a = list;
        this.b = list2;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.a.get(i));
    }

    public int getCount() {
        return this.a.size();
    }

    public CharSequence getPageTitle(int i) {
        return this.b.get(i);
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup.addView(this.a.get(i), 0);
        return this.a.get(i);
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
