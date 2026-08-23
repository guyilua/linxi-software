package com.rtk.app.main.comment;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.viewpager.widget.ViewPager;
import com.rtk.app.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: EmojioInit.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f {
    private com.rtk.app.main.comment.express.a e;
    private ViewPager g;
    private Context h;
    private EditText i;
    private LinearLayout j;
    private List<GridView> a = new ArrayList();
    private List<List<Integer>> b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private List<List<String>> f231c = new ArrayList();
    private Map<Integer, List<List<Integer>>> d = new TreeMap();
    private com.rtk.app.main.comment.express.c f = com.rtk.app.main.comment.express.c.g();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EmojioInit.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        final /* synthetic */ List a;
        final /* synthetic */ List b;

        a(List list, List list2) {
            this.a = list;
            this.b = list2;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i != this.a.size()) {
                f.this.i.getText().insert(f.this.i.getSelectionStart(), f.this.f.b((CharSequence) this.b.get(i), 20, 20));
            } else {
                f.this.i.dispatchKeyEvent(new KeyEvent(0, 67));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EmojioInit.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements ViewPager.OnPageChangeListener {
        b() {
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            for (int i2 = 0; i2 < f.this.j.getChildCount(); i2++) {
                if (i2 != i) {
                    ((ImageView) f.this.j.getChildAt(i2)).setImageResource(R.drawable.shape_dot_nomal);
                }
            }
            ((ImageView) f.this.j.getChildAt(i)).setImageResource(R.drawable.shape_dot_select);
        }
    }

    public f(Context context, EditText editText, ViewPager viewPager, LinearLayout linearLayout) {
        this.h = context;
        this.i = editText;
        this.g = viewPager;
        this.j = linearLayout;
        e();
    }

    private void d(List<GridView> list) {
        this.j.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            ImageView imageView = new ImageView(this.h);
            if (i == 0) {
                imageView.setImageResource(R.drawable.shape_dot_select);
            } else {
                imageView.setImageResource(R.drawable.shape_dot_nomal);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.rtk.app.main.comment.express.d.a(this.h, 8), com.rtk.app.main.comment.express.d.a(this.h, 8));
            layoutParams.setMargins(20, 0, 0, 0);
            this.j.addView(imageView, layoutParams);
        }
        if (this.j.getChildCount() <= 1) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
        }
        this.g.setOffscreenPageLimit(6);
        this.g.setCurrentItem(0);
        this.g.setOnPageChangeListener(new b());
    }

    private void e() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int[] iArr = com.rtk.app.main.comment.express.c.g;
            if (i < iArr.length) {
                arrayList.add(Integer.valueOf(iArr[i]));
                i++;
            } else {
                this.b = EmojioAdapter.c(arrayList, 20);
                this.d.put(Integer.valueOf(R.drawable.aw), this.b);
                this.f231c = EmojioAdapter.d(Arrays.asList(this.f.f230c), 20);
                f(this.b.size());
                return;
            }
        }
    }

    private void f(int i) {
        this.a.clear();
        LayoutInflater layoutInflater = ((Activity) this.h).getLayoutInflater();
        for (int i2 = 0; i2 < i; i2++) {
            GridView gridView = (GridView) layoutInflater.inflate(R.layout.gridview_emoji, (ViewGroup) null);
            List<Integer> list = this.b.get(i2);
            List<String> list2 = this.f231c.get(i2);
            com.rtk.app.main.comment.express.a aVar = new com.rtk.app.main.comment.express.a(layoutInflater, list);
            this.e = aVar;
            gridView.setAdapter((ListAdapter) aVar);
            gridView.setOnItemClickListener(new a(list, list2));
            this.a.add(gridView);
        }
        this.g.setAdapter(new EmojioAdapter(this.a));
        d(this.a);
    }
}
