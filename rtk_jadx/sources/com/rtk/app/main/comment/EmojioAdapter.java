package com.rtk.app.main.comment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class EmojioAdapter extends PagerAdapter {
    private List<GridView> a;

    public EmojioAdapter(List<GridView> list) {
        this.a = list;
    }

    public static long a(CharSequence charSequence) {
        double d = 0.0d;
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            d += (charAt <= 0 || charAt >= 127) ? 1.0d : 0.5d;
        }
        return Math.round(d);
    }

    public static List<List<Integer>> c(List<Integer> list, int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < list.size()) {
            int i3 = i2 + i;
            List<Integer> subList = list.subList(i2, i3 > list.size() ? list.size() : i3);
            if (subList.size() == 0) {
                break;
            }
            arrayList.add(subList);
            i2 = i3;
        }
        return arrayList;
    }

    public static List<List<String>> d(List<String> list, int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < list.size()) {
            int i3 = i2 + i;
            List<String> subList = list.subList(i2, i3 > list.size() ? list.size() : i3);
            if (subList.size() == 0) {
                break;
            }
            arrayList.add(subList);
            i2 = i3;
        }
        return arrayList;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public GridView instantiateItem(ViewGroup viewGroup, int i) {
        GridView gridView = this.a.get(i);
        viewGroup.addView(gridView);
        return gridView;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((GridView) obj);
    }

    public int getCount() {
        List<GridView> list = this.a;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.a.size();
    }

    public int getItemPosition(Object obj) {
        return -2;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
