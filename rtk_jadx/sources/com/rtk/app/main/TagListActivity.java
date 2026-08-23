package com.rtk.app.main;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.adapter.ItemViewPagerAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.custom.MarkedImageView;
import com.rtk.app.main.dialogPack.DialogScreen;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TagListActivity extends BaseActivity implements h.j, com.rtk.app.tool.s {
    private Context q;
    private Map<String, String> t;

    @BindView
    TextView tagListScreen;

    @BindView
    TabLayout tagListTablayout;

    @BindView
    LinearLayout tagListTablayoutTabLayout;

    @BindView
    MarkedImageView tagListTopDownload;

    @BindView
    LinearLayout tagListTopLayout;

    @BindView
    TextView tagListTopTitle;

    @BindView
    TextView tagListViewHelp;

    @BindView
    ViewPager tagListViewPager;
    private DialogScreen v;
    private TagListItem1 w;
    private TagListItem2 x;
    private TagListItem3 y;
    private List<View> r = new ArrayList();
    private List<String> s = new ArrayList();
    private String u = "";
    private String z = "";

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            try {
                if (i == 0) {
                    TagListActivity.this.w.q();
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            TagListActivity.this.y.q();
                        }
                    }
                    TagListActivity.this.x.q();
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.q, this.tagListTopLayout, this.tagListTablayout, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0), this.tagListTablayoutTabLayout);
    }

    @Override // com.rtk.app.tool.s
    public void a(String... strArr) {
        this.w.x(strArr[0], strArr[1]);
        this.x.x(strArr[0], strArr[1]);
        this.y.x(strArr[0], strArr[1]);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        TagListItem1 tagListItem1 = this.w;
        if (tagListItem1 != null) {
            tagListItem1.j();
        }
        TagListItem2 tagListItem2 = this.x;
        if (tagListItem2 != null) {
            tagListItem2.j();
        }
        TagListItem3 tagListItem3 = this.y;
        if (tagListItem3 != null) {
            tagListItem3.j();
        }
        this.w = null;
        this.x = null;
        this.y = null;
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("TagListActivity", "标签请求列表失败" + str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        this.t = (Map) extras.getSerializable("map");
        this.u = extras.getString("tagName");
        this.z = extras.getString("url", "");
        for (String str : this.t.keySet()) {
            com.rtk.app.tool.c0.u("TagListActivity", "key" + str + ":--->" + this.t.get(str));
        }
        this.tagListTopTitle.setText(this.u);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.b = new com.rtk.app.tool.DownLoadTool.n(this.tagListTopDownload);
        com.rtk.app.tool.DownLoadTool.x.c().b(this.b);
        this.tagListViewPager.setOnPageChangeListener(new a());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        View inflate = LayoutInflater.from(this.q).inflate(com.rtk.app.R.layout.tag_list_item1_layout, (ViewGroup) null);
        View inflate2 = LayoutInflater.from(this.q).inflate(com.rtk.app.R.layout.tag_list_item2_layout, (ViewGroup) null);
        View inflate3 = LayoutInflater.from(this.q).inflate(com.rtk.app.R.layout.tag_list_item3_layout, (ViewGroup) null);
        this.r.add(inflate);
        this.r.add(inflate2);
        this.r.add(inflate3);
        this.w = new TagListItem1(this.q, inflate, this.t, this.z);
        this.x = new TagListItem2(this.q, inflate2, this.t, this.z);
        this.y = new TagListItem3(this.q, inflate3, this.t, this.z);
        this.s.add("最新");
        this.s.add("热门");
        this.s.add("精品");
        this.tagListViewPager.setAdapter(new ItemViewPagerAdapter(this.r, this.s, this.q));
        this.tagListTablayout.setupWithViewPager(this.tagListViewPager, true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131300350) {
            this.v.m();
        } else if (id == 2131300353) {
            com.rtk.app.tool.t.o0(this.q);
        } else {
            if (id != 2131300355) {
                return;
            }
            com.rtk.app.tool.c.a((Activity) this.q);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_tag_list);
        ButterKnife.a(this);
        this.q = this;
        this.v = new DialogScreen(this.q, this);
        this.tagListScreen.getLocationOnScreen(new int[2]);
        this.v.l(com.sigmob.sdk.base.blurkit.c.d, r3[1]);
    }
}
