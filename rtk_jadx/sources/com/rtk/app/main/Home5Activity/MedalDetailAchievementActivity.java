package com.rtk.app.main.Home5Activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.adapter.MyFragmentAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.MedalDetailBean;
import com.rtk.app.custom.BaseViewPager;
import com.rtk.app.tool.o.h;
import com.uc.crashsdk.export.LogType;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MedalDetailAchievementActivity extends AppCompatActivity implements View.OnClickListener, com.rtk.app.base.f, h.j {
    private List<BaseFragment> a;
    private MyFragmentAdapter b;
    private MedalDetailBean e;
    private Activity f;

    @BindView
    LinearLayout medalDetaiAchievementMedalFlow;

    @BindView
    TextView medalDetaiAchievementTopBack;

    @BindView
    LinearLayout medalDetaiAchievementTopLayout;

    @BindView
    BaseViewPager medalDetaiAchievementViewPager;

    /* renamed from: c, reason: collision with root package name */
    private String f185c = "";
    private String d = "";
    private String g = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            MedalDetailAchievementActivity.this.u(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (MedalDetailAchievementActivity.this.f185c.equals(MedalDetailAchievementActivity.this.e.getData().get(intValue).getId())) {
                MedalDetailAchievementActivity.this.u(intValue);
            }
            MedalDetailAchievementActivity.this.medalDetaiAchievementViewPager.setCurrentItem(intValue);
        }
    }

    private void s(String str, String str2, int i, int i2) {
        LinearLayout.LayoutParams layoutParams;
        ImageView imageView = new ImageView(this.f);
        if (!com.rtk.app.tool.c0.q(this.f185c) && !this.f185c.equals(str)) {
            layoutParams = new LinearLayout.LayoutParams(100, 100);
        } else {
            layoutParams = new LinearLayout.LayoutParams(135, 135);
        }
        imageView.setLayoutParams(layoutParams);
        com.rtk.app.tool.t.c(this.f, str2, imageView, new boolean[0]);
        this.medalDetaiAchievementMedalFlow.addView(imageView);
        if (i2 == 0) {
            imageView.setTag(Integer.valueOf(i));
            imageView.setOnClickListener(new b());
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("MedalDetailAchievementActivity", " 勋章详情   " + str);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        this.a.clear();
        this.medalDetaiAchievementMedalFlow.removeAllViews();
        MedalDetailBean medalDetailBean = (MedalDetailBean) create.fromJson(str, MedalDetailBean.class);
        this.e = medalDetailBean;
        if (medalDetailBean.getData() != null) {
            for (int i2 = 0; i2 < this.e.getData().size(); i2++) {
                MedalDetailInformationFragment medalDetailInformationFragment = new MedalDetailInformationFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("medal", this.e.getData().get(i2));
                medalDetailInformationFragment.setArguments(bundle);
                this.a.add(medalDetailInformationFragment);
                s(this.e.getData().get(i2).getId(), this.e.getData().get(i2).getPic(), i2, 0);
            }
        }
        this.b.notifyDataSetChanged();
        for (int i3 = 0; i3 < this.e.getData().size(); i3++) {
            if (com.rtk.app.tool.c0.q(this.f185c) || this.f185c.equals(this.e.getData().get(i3).getId())) {
                this.medalDetaiAchievementViewPager.setCurrentItem(i3);
            }
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("MedalDetailAchievementActivity", " 勋章详情失败   " + str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        this.f185c = extras.getString("gid", "");
        this.d = extras.getString("pid", "");
        this.g = extras.getString("uid", "");
        t(1);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.medalDetaiAchievementViewPager.setOnPageChangeListener(new a());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.a = new ArrayList();
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this.a, null);
        this.b = myFragmentAdapter;
        this.medalDetaiAchievementViewPager.setAdapter(myFragmentAdapter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131299054) {
            return;
        }
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        int i = Build.VERSION.SDK_INT;
        if (i >= 19 && i >= 19) {
            getWindow().addFlags(67108864);
            com.rtk.app.tool.z zVar = new com.rtk.app.tool.z(this);
            zVar.b(true);
            zVar.c(R.color.black_ground);
            getWindow().getDecorView().setFitsSystemWindows(true);
            if (i >= 21) {
                Window window = getWindow();
                window.clearFlags(67108864);
                window.getDecorView().setSystemUiVisibility(LogType.UNEXP_ANR);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(0);
            }
        }
        setContentView(R.layout.activity_medal_avhievement_detail);
        ButterKnife.a(this);
        this.f = this;
        initData();
        initView();
        initListener();
    }

    public void t(int... iArr) {
        String str;
        if (iArr[0] != 1) {
            str = "";
        } else {
            str = "members/medaldetail" + com.rtk.app.tool.y.u(this.f) + "&uid=" + this.g + "&gid=" + this.f185c + "&pid=" + this.d + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f, new String[0])));
        }
        com.rtk.app.tool.o.h.l(this.f, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a(str));
        com.rtk.app.tool.c0.u("MedalDetailAchievementActivity", "勋章详情链接  " + com.rtk.app.tool.y.d + str);
    }

    public void u(int i) {
        LinearLayout.LayoutParams layoutParams;
        for (int i2 = 0; i2 < this.medalDetaiAchievementMedalFlow.getChildCount(); i2++) {
            if (i2 == i) {
                layoutParams = new LinearLayout.LayoutParams(135, 135);
            } else {
                layoutParams = new LinearLayout.LayoutParams(100, 100);
            }
            this.medalDetaiAchievementMedalFlow.getChildAt(i2).setLayoutParams(layoutParams);
        }
    }
}
