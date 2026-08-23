package com.rtk.app.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> a;

    public int getCount() {
        return this.a.size();
    }

    public Fragment getItem(int i) {
        return this.a.get(i);
    }

    public int getItemPosition(Object obj) {
        return -2;
    }
}
