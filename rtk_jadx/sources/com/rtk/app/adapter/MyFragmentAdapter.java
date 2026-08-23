package com.rtk.app.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyFragmentAdapter<T> extends FragmentPagerAdapter {
    private List<T> a;
    private List<String> b;

    public MyFragmentAdapter(FragmentManager fragmentManager, List<T> list, List<String> list2) {
        super(fragmentManager);
        this.a = list;
        this.b = list2;
    }

    public int getCount() {
        return this.a.size();
    }

    public Fragment getItem(int i) {
        return (Fragment) this.a.get(i);
    }

    public int getItemPosition(Object obj) {
        return -2;
    }

    public CharSequence getPageTitle(int i) {
        return this.b.get(i);
    }
}
