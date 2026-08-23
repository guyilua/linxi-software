package com.rtk.app.main.MainActivityPack;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.custom.MarkedImageView;
import com.rtk.app.main.dialogPack.DialogScreen;
import com.rtk.app.tool.c0;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GameNoTypeListActivity extends BaseActivity {

    @BindView
    LinearLayout gameNoTypeListParent;

    @BindView
    TextView gameNoTypeListScreen;

    @BindView
    TabLayout gameNoTypeListTablayout;

    @BindView
    LinearLayout gameNoTypeListTablayoutTabLayout;

    @BindView
    MarkedImageView gameNoTypeListTopDownload;

    @BindView
    LinearLayout gameNoTypeListTopLayout;

    @BindView
    TextView gameNoTypeListTopTitle;

    @BindView
    TextView gameNoTypeListViewHelp;

    @BindView
    ViewPager gameNoTypeListViewPager;
    private String q = "";
    private DialogScreen r;
    private Map<String, String> s;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.gameNoTypeListTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        this.q = extras.getString("title", "");
        extras.getString("url", "");
        this.gameNoTypeListTopTitle.setText(this.q);
        Map<String, String> map = (Map) extras.getSerializable("map");
        this.s = map;
        for (String str : map.keySet()) {
            c0.u("GameNoTypeListActivity", "key" + str + ":--->" + this.s.get(str));
        }
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131297761) {
            this.r.m();
        } else if (id == 2131297764) {
            com.rtk.app.tool.t.o0(this.f147c);
        } else {
            if (id != 2131297766) {
                return;
            }
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_game_no_type_list);
        ButterKnife.a(this);
        this.gameNoTypeListScreen.getLocationOnScreen(new int[2]);
        this.r.l(com.sigmob.sdk.base.blurkit.c.d, r3[1]);
    }
}
