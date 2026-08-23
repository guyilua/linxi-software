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
import com.rtk.app.adapter.MyFragmentAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.custom.MarkedImageView;
import com.rtk.app.tool.DownLoadTool.x;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GameRankListActivity extends BaseActivity {

    @BindView
    TabLayout gameRankListTab;

    @BindView
    TextView gameRankListTopBack;

    @BindView
    MarkedImageView gameRankListTopDownload;

    @BindView
    LinearLayout gameRankListTopLayout;

    @BindView
    ViewPager gameRankListViewPager;
    private List<String> q;
    private List<BaseFragment> r;
    private MyFragmentAdapter s;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.gameRankListTopLayout, this.gameRankListTab, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        for (int i = 0; i < this.r.size(); i++) {
            this.r.get(i).n();
        }
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        ArrayList arrayList = new ArrayList();
        this.q = arrayList;
        arrayList.add("总榜");
        this.q.add("单机榜");
        this.q.add("新品榜");
        this.q.add("BT榜");
        this.r = new ArrayList();
        String[] strArr = {"all", "modify", "new", "bt"};
        for (int i = 0; i < 4; i++) {
            HomeGameRankItemFragment homeGameRankItemFragment = new HomeGameRankItemFragment();
            Bundle bundle = new Bundle();
            bundle.putString("rank", strArr[i]);
            homeGameRankItemFragment.setArguments(bundle);
            this.r.add(homeGameRankItemFragment);
        }
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this.r, this.q);
        this.s = myFragmentAdapter;
        this.gameRankListViewPager.setAdapter(myFragmentAdapter);
        this.gameRankListTab.setupWithViewPager(this.gameRankListViewPager, true);
        this.b = new com.rtk.app.tool.DownLoadTool.n(this.gameRankListTopDownload);
        x.c().b(this.b);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.rtk.app.R.id.game_rank_list_top_back /* 2131297773 */:
                finish();
                return;
            case com.rtk.app.R.id.game_rank_list_top_download /* 2131297774 */:
                com.rtk.app.tool.t.o0(this.f147c);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_game_rank_list);
        ButterKnife.a(this);
    }
}
