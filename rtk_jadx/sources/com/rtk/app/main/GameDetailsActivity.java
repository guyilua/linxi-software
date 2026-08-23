package com.rtk.app.main;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.adapter.ItemViewPagerAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.GameDetailsBean;
import com.rtk.app.bean.ListHisGameBean;
import com.rtk.app.bean.ResponseDataBean;
import com.rtk.app.custom.MarkedImageView;
import com.rtk.app.custom.b;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GameDetailsActivity extends BaseActivity implements h.j {
    private List<com.rtk.app.base.g> A;
    private ApkInfo B;
    private ItemViewPagerAdapter C;
    private View D;
    private View E;
    private View F;
    private View G;
    private String H;
    private String I;
    private String J;
    private String K;
    private Unbinder L;
    private com.rtk.app.tool.DownLoadTool.u M;

    @BindView
    AppBarLayout appBar;

    @BindView
    CoordinatorLayout appCoordinatorLayout;

    @BindView
    LinearLayout appDetailItem1SufferLayout;

    @BindView
    TextView gameDetailsAppCollect;

    @BindView
    TextView gameDetailsAppDownLoadBtu;

    @BindView
    ProgressBar gameDetailsAppDownLoadProgressBar;

    @BindView
    ImageView gameDetailsAppIcon;

    @BindView
    TextView gameDetailsAppInvitation;

    @BindView
    TextView gameDetailsAppName;

    @BindView
    TextView gameDetailsAppOpenBtu;

    @BindView
    TextView gameDetailsAppSizeAndPlayerNum;

    @BindView
    TextView gameDetailsAppType;

    @BindView
    TextView gameDetailsAppVersion;

    @BindView
    LinearLayout gameDetailsHeadLv;

    @BindView
    TextView gameDetailsItem1Level;

    @BindView
    TabLayout gameDetailsTab;

    @BindView
    TextView gameDetailsTopBack;

    @BindView
    MarkedImageView gameDetailsTopDownload;

    @BindView
    ImageView gameDetailsTopFeedback;

    @BindView
    ImageView gameDetailsTopHome;

    @BindView
    LinearLayout gameDetailsTopLayout;

    @BindView
    ViewPager gameDetailsViewPager;
    private Context q;
    private List<View> r;
    private List<String> s;
    private String t = "";
    private GameDetailsBean u;
    private GameDetailsItem1 v;
    private GameDetailsItem2 w;
    private GameDetailsItem3 x;
    private GameDetailsItem4 y;
    private com.rtk.app.base.g z;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            if (i == 0) {
                try {
                    GameDetailsActivity gameDetailsActivity = GameDetailsActivity.this;
                    gameDetailsActivity.z = gameDetailsActivity.v;
                } catch (Exception unused) {
                }
            }
            if (i == 1) {
                GameDetailsActivity.this.w.A();
                GameDetailsActivity gameDetailsActivity2 = GameDetailsActivity.this;
                gameDetailsActivity2.z = gameDetailsActivity2.w;
            } else if (GameDetailsActivity.this.u.getData().getHas_news() == 1) {
                GameDetailsActivity.this.y.t();
                GameDetailsActivity gameDetailsActivity3 = GameDetailsActivity.this;
                gameDetailsActivity3.z = gameDetailsActivity3.y;
            }
            if (i == 2 && GameDetailsActivity.this.u.getData().getHas_giftbag() == 1) {
                GameDetailsActivity.this.x.w();
                GameDetailsActivity gameDetailsActivity4 = GameDetailsActivity.this;
                gameDetailsActivity4.z = gameDetailsActivity4.x;
            }
            if (i != 0) {
                GameDetailsActivity.this.appBar.setExpanded(false);
            } else {
                GameDetailsActivity.this.appBar.setExpanded(true);
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b extends com.rtk.app.custom.b {
        b() {
        }

        @Override // com.rtk.app.custom.b
        public void a(AppBarLayout appBarLayout, b.a aVar) {
            if (aVar == b.a.EXPANDED) {
                try {
                    GameDetailsActivity.this.gameDetailsTopBack.setText("游戏详情");
                } catch (NullPointerException | Exception unused) {
                }
            } else if (aVar == b.a.COLLAPSED) {
                GameDetailsActivity gameDetailsActivity = GameDetailsActivity.this;
                gameDetailsActivity.gameDetailsTopBack.setText(gameDetailsActivity.u.getData().getGame_name());
            }
        }
    }

    private void R(View view, String str) {
        this.r.add(view);
        this.s.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U(String[] strArr) {
        S(1);
    }

    private void V(String str, int i) {
        if (i == 1) {
            if (str.equals("1")) {
                this.appDetailItem1SufferLayout.getChildAt(i).setSelected(true);
                ((TextView) this.appDetailItem1SufferLayout.getChildAt(i)).setText("需要网络");
                return;
            }
            return;
        }
        if (i != 2) {
            if (i == 3 && str.equals("1")) {
                this.appDetailItem1SufferLayout.getChildAt(i).setSelected(true);
                ((TextView) this.appDetailItem1SufferLayout.getChildAt(i)).setText("有广告");
                return;
            }
            return;
        }
        if (str.equals("1")) {
            this.appDetailItem1SufferLayout.getChildAt(i).setSelected(true);
            ((TextView) this.appDetailItem1SufferLayout.getChildAt(i)).setText("需谷歌");
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.q, this.gameDetailsTopLayout, this.gameDetailsTab, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
        this.gameDetailsHeadLv.setBackgroundResource(com.rtk.app.tool.t.F(this.q, new boolean[0]));
    }

    public void S(int... iArr) {
        this.t = "&uid=" + com.rtk.app.tool.y.K();
        int i = iArr[0];
        if (i == 1) {
            Context context = this.q;
            com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(new String[0]);
            StringBuilder sb = new StringBuilder();
            sb.append("game/gamedetails");
            sb.append(com.rtk.app.tool.y.u(this.q));
            sb.append("&game_id=");
            sb.append(this.B.getGameId());
            sb.append(this.t);
            sb.append("&key=");
            sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.q, "game_id=" + this.B.getGameId()))));
            com.rtk.app.tool.o.h.l(context, this, 1, h.a(sb.toString()));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("游戏详情接口");
            sb2.append(com.rtk.app.tool.y.d);
            sb2.append("game/gamedetails");
            sb2.append(com.rtk.app.tool.y.u(this.q));
            sb2.append("&game_id=");
            sb2.append(this.B.getGameId());
            sb2.append(this.t);
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.q, "game_id=" + this.B.getGameId()))));
            com.rtk.app.tool.c0.u("GameDetailsActivity", sb2.toString());
            return;
        }
        if (i == 2) {
            int I = com.rtk.app.tool.y.I(this.q);
            if (I != 0) {
                Context context2 = this.q;
                com.rtk.app.tool.o.i h2 = com.rtk.app.tool.o.h.h(new String[0]);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("game/gameCollect");
                sb3.append(com.rtk.app.tool.y.u(this.q));
                sb3.append("&game_id=");
                sb3.append(this.B.getGameId());
                sb3.append(this.t);
                sb3.append("&key=");
                sb3.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.q, "game_id=" + this.B.getGameId(), "uid=" + I))));
                com.rtk.app.tool.o.h.l(context2, this, 2, h2.a(sb3.toString()));
                return;
            }
            return;
        }
        if (i != 3) {
            return;
        }
        Context context3 = this.q;
        com.rtk.app.tool.o.i h3 = com.rtk.app.tool.o.h.h(new String[0]);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("game/gameClickUpdate");
        sb4.append(com.rtk.app.tool.y.u(this.q));
        sb4.append("&game_id=");
        sb4.append(this.B.getGameId());
        sb4.append("&key=");
        sb4.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.q, "game_id=" + this.B.getGameId()))));
        com.rtk.app.tool.o.h.l(context3, this, 3, h3.a(sb4.toString()));
        StringBuilder sb5 = new StringBuilder();
        sb5.append("  点击量统计  ");
        sb5.append(com.rtk.app.tool.y.d);
        sb5.append("game/gameClickUpdate");
        sb5.append(com.rtk.app.tool.y.u(this.q));
        sb5.append("&game_id=");
        sb5.append(this.B.getGameId());
        sb5.append("&key=");
        sb5.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.q, "game_id=" + this.B.getGameId()))));
        com.rtk.app.tool.c0.u("GameDetailsActivity", sb5.toString());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        F();
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return;
                }
                com.rtk.app.tool.c0.u("GameDetailsActivity", "点击量统计" + str);
                return;
            }
            com.rtk.app.tool.c0.u("GameDetailsActivity", "游戏收藏");
            if (((ResponseDataBean) create.fromJson(str, ResponseDataBean.class)).getCode() == 0) {
                if (this.u.getData().getAlready_collected() == 0) {
                    this.u.getData().setAlready_collected(1);
                    this.gameDetailsAppCollect.setSelected(true);
                    com.rtk.app.tool.f.a(this.q, "收藏成功", f.a.f);
                    return;
                } else {
                    this.u.getData().setAlready_collected(0);
                    this.gameDetailsAppCollect.setSelected(false);
                    com.rtk.app.tool.f.a(this.q, "取消收藏", f.a.f);
                    return;
                }
            }
            return;
        }
        com.rtk.app.tool.c0.u("GameDetailsActivity", "游戏详情" + str);
        S(3);
        GameDetailsBean gameDetailsBean = (GameDetailsBean) create.fromJson(str, GameDetailsBean.class);
        this.u = gameDetailsBean;
        this.gameDetailsAppName.setText(gameDetailsBean.getData().getGame_name());
        com.rtk.app.tool.t.d(this.q, this.u.getData().getGame_logo(), this.gameDetailsAppIcon);
        this.gameDetailsAppSizeAndPlayerNum.setText(this.u.getData().getPackage_size());
        this.gameDetailsAppVersion.setText("V" + this.u.getData().getGame_version());
        this.gameDetailsAppType.setText(this.u.getData().getGame_type());
        V(this.u.getData().getNeed_network(), 1);
        V(this.u.getData().getNeed_google(), 2);
        V(this.u.getData().getExists_ad(), 3);
        this.gameDetailsItem1Level.setText("" + Integer.parseInt(this.u.getData().getGame_level()));
        this.v.A(this.u);
        if (this.u.getData().getAlready_collected() == 1) {
            this.gameDetailsAppCollect.setSelected(true);
        }
        this.B.setPackage_size(this.u.getData().getPackage_size());
        this.B.setSignaturesMD5(this.u.getData().getSignaturesMD5());
        this.B.setIsApk(this.u.getData().getIs_apk());
        this.B.setVersion_code(this.u.getData().getVersion_code());
        this.B.setAppName(this.u.getData().getGame_name());
        this.B.setIcon_url(this.u.getData().getGame_logo());
        this.B.setDownlist(this.u.getData().getDownlist());
        this.B.setApkSize(this.u.getData().getPackage_size());
        this.B.setVersionName(this.u.getData().getGame_version());
        this.B.setInstallation(this.u.getData().getInstallation());
        try {
            com.rtk.app.main.Home5Activity.ClickHistory.f.a(this.f147c, new ListHisGameBean.HisGameBean(this.B));
        } catch (Exception unused) {
        }
        this.w = new GameDetailsItem2(this.q, this.r.get(1), this.B.getGameId(), this.u.getData().getInstall_comment(), this.u.getData().getPackage_name());
        this.A.add(this.v);
        this.A.add(this.w);
        this.A.add(this.x);
        this.A.add(this.y);
        if (this.u.getData().getHas_news() == 0) {
            this.r.remove(this.G);
            this.s.remove(this.K);
            this.A.remove(this.y);
        }
        if (this.u.getData().getHas_giftbag() == 0) {
            this.r.remove(this.F);
            this.s.remove(this.J);
            this.A.remove(this.x);
        }
        ItemViewPagerAdapter itemViewPagerAdapter = new ItemViewPagerAdapter(this.r, this.s, this.q);
        this.C = itemViewPagerAdapter;
        this.gameDetailsViewPager.setAdapter(itemViewPagerAdapter);
        this.gameDetailsTab.setupWithViewPager(this.gameDetailsViewPager, true);
        this.gameDetailsViewPager.setOffscreenPageLimit(5);
        this.gameDetailsAppInvitation.setEnabled(true);
        if (this.u.getData().getComent_total() > 0) {
            this.s.set(1, "评论(" + this.u.getData().getComent_total() + ")");
            this.C.notifyDataSetChanged();
        }
        com.rtk.app.tool.DownLoadTool.r.i(1, this.q, this.B, this.gameDetailsAppDownLoadBtu, this.gameDetailsAppDownLoadProgressBar);
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        try {
            this.M = null;
            this.w = null;
            this.x = null;
            this.y = null;
            this.v.j();
            this.v = null;
        } catch (Exception unused) {
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("GameDetailsActivity", "请求失败   " + str + "    " + i2);
        if (i2 != 1) {
            return;
        }
        I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.l
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                GameDetailsActivity.this.U(strArr);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        ApkInfo apkInfo = (ApkInfo) getIntent().getExtras().getSerializable("apkInfo");
        this.B = apkInfo;
        if (apkInfo == null) {
            finish();
        }
        this.b = new com.rtk.app.tool.DownLoadTool.n(this.gameDetailsTopDownload);
        com.rtk.app.tool.DownLoadTool.x.c().b(this.b);
        this.gameDetailsAppDownLoadBtu.setTag(Integer.valueOf(this.B.getGameId()));
        this.M = new com.rtk.app.tool.DownLoadTool.u(this.gameDetailsAppDownLoadProgressBar, this.B.getGameId(), this.gameDetailsAppDownLoadBtu, this.gameDetailsAppOpenBtu);
        com.rtk.app.tool.DownLoadTool.x.c().a(this.M);
        if (com.rtk.app.tool.t.q1(this.q, this.B.getPackageName())) {
            this.gameDetailsAppOpenBtu.setVisibility(0);
        }
        S(1);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.gameDetailsViewPager.setOnPageChangeListener(new a());
        this.appBar.addOnOffsetChangedListener(new b());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.D = LayoutInflater.from(this.f147c).inflate(com.rtk.app.R.layout.game_details_item1_layout, (ViewGroup) null);
        this.E = LayoutInflater.from(this.f147c).inflate(com.rtk.app.R.layout.game_details_item2_layout, (ViewGroup) null);
        this.F = LayoutInflater.from(this.f147c).inflate(com.rtk.app.R.layout.game_details_item3_layout, (ViewGroup) null);
        this.G = LayoutInflater.from(this.f147c).inflate(com.rtk.app.R.layout.game_details_item4_layout, (ViewGroup) null);
        this.H = "详情";
        this.I = "评论";
        this.J = "礼包";
        this.K = "资讯";
        R(this.D, "详情");
        R(this.E, this.I);
        R(this.F, this.J);
        R(this.G, this.K);
        this.v = new GameDetailsItem1(this.q, this.r.get(0));
        this.x = new GameDetailsItem3(this.q, this.r.get(2), this.B.getGameId());
        this.y = new GameDetailsItem4(this.q, this.r.get(3), this.B.getGameId());
        this.A = new ArrayList();
        this.z = this.v;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("position", 0);
        intent.getStringExtra("giftbag_id");
        int intExtra2 = intent.getIntExtra("giftStatus", 0);
        String stringExtra = intent.getStringExtra("giftContent");
        if (i == 2) {
            this.x.p.get(intExtra).setGift_status(intExtra2);
            this.x.p.get(intExtra).setGift_content(stringExtra);
            return;
        }
        if (i != 1022) {
            return;
        }
        if (i2 == -1) {
            this.w.z();
        } else if (i2 == 1) {
            Bundle extras = intent.getExtras();
            String string = extras.getString("replyComment");
            this.w.y(extras.getInt("itemPosition"), string);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            switch (view.getId()) {
                case com.rtk.app.R.id.game_details_appDownLoadBtu /* 2131297652 */:
                    com.rtk.app.tool.DownLoadTool.r.g(this.q, this.B, this.gameDetailsAppDownLoadBtu);
                    return;
                case com.rtk.app.R.id.game_details_appOpenBtu /* 2131297656 */:
                    com.rtk.app.tool.t.A1(this.q, this.u.getData().getPackage_name());
                    return;
                case com.rtk.app.R.id.game_details_app_Invitation /* 2131297660 */:
                    com.rtk.app.tool.t.e(this.q, this.B, this.u.getData().getGame_intro());
                    return;
                case com.rtk.app.R.id.game_details_app_collect /* 2131297661 */:
                    S(2);
                    return;
                case com.rtk.app.R.id.game_details_top_back /* 2131297730 */:
                    finish();
                    return;
                case com.rtk.app.R.id.game_details_top_download /* 2131297731 */:
                    com.rtk.app.tool.t.o0(this.q);
                    return;
                case com.rtk.app.R.id.game_details_top_feedback /* 2131297732 */:
                    if (!com.rtk.app.tool.y.x(this.f147c)) {
                        com.rtk.app.tool.t.w0(this.f147c);
                        com.rtk.app.tool.f.a(this.f147c, "请先登录", f.a.f);
                        return;
                    } else {
                        if (this.u == null) {
                            return;
                        }
                        Bundle bundle = new Bundle();
                        bundle.putInt("gameId", this.B.getGameId());
                        bundle.putString("gameName", this.B.getAppName());
                        bundle.putString("logo", this.u.getData().getGame_logo());
                        com.rtk.app.tool.c.b((Activity) this.q, GameFeedBackActivity.class, bundle);
                        return;
                    }
                default:
                    return;
            }
        } catch (NullPointerException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_game_details);
        this.L = ButterKnife.a(this);
        this.q = this;
        G(null, this.gameDetailsTopLayout);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.L.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.L = ButterKnife.a(this);
        this.q = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        GameDetailsItem2 gameDetailsItem2 = this.w;
        if (gameDetailsItem2 != null && this.u != null && this.z == gameDetailsItem2) {
            gameDetailsItem2.k();
        }
        GameDetailsItem3 gameDetailsItem3 = this.x;
        if (gameDetailsItem3 != null && this.u != null && this.z == gameDetailsItem3) {
            gameDetailsItem3.k();
        }
        com.rtk.app.tool.DownLoadTool.r.i(1, this.q, this.B, this.gameDetailsAppDownLoadBtu, this.gameDetailsAppDownLoadProgressBar);
        GameDetailsItem1 gameDetailsItem1 = this.v;
        if (gameDetailsItem1 != null && this.z == gameDetailsItem1) {
            gameDetailsItem1.u.notifyDataSetChanged();
        }
        if (com.rtk.app.tool.t.q1(this.q, this.B.getPackageName())) {
            this.gameDetailsAppOpenBtu.setVisibility(0);
        } else {
            this.gameDetailsAppOpenBtu.setVisibility(8);
        }
    }
}
