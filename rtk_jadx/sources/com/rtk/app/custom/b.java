package com.rtk.app.custom;

import com.google.android.material.appbar.AppBarLayout;

/* compiled from: AppBarStateChangeListener.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class b implements AppBarLayout.OnOffsetChangedListener {
    private a a = a.IDLE;

    /* compiled from: AppBarStateChangeListener.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum a {
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    public abstract void a(AppBarLayout appBarLayout, a aVar);

    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        if (i == 0) {
            a aVar = this.a;
            a aVar2 = a.EXPANDED;
            if (aVar != aVar2) {
                try {
                    a(appBarLayout, aVar2);
                } catch (Exception unused) {
                }
            }
            this.a = a.EXPANDED;
            return;
        }
        if (Math.abs(i) >= appBarLayout.getTotalScrollRange()) {
            a aVar3 = this.a;
            a aVar4 = a.COLLAPSED;
            if (aVar3 != aVar4) {
                a(appBarLayout, aVar4);
            }
            this.a = aVar4;
            return;
        }
        a aVar5 = this.a;
        a aVar6 = a.IDLE;
        if (aVar5 != aVar6) {
            a(appBarLayout, aVar6);
        }
        this.a = aVar6;
    }
}
