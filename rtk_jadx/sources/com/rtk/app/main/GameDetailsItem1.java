package com.rtk.app.main;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.adapter.GameDetailsItem1OpenServiceAdapter;
import com.rtk.app.adapter.GameDetailsItem1OtherVersionAdapter;
import com.rtk.app.adapter.GameDetailsItem1RecommentGameAdapter;
import com.rtk.app.adapter.GameDetailsVipAdapter;
import com.rtk.app.adapter.TagFlowLayoutAdapter;
import com.rtk.app.bean.GameDetailsBean;
import com.rtk.app.bean.HomeAdBean;
import com.rtk.app.custom.CustomListView;
import com.rtk.app.custom.GridViewForScrollView;
import com.rtk.app.custom.MyHorizontalScrollView;
import com.rtk.app.custom.NestedScrollView;
import com.rtk.app.custom.RecyclerImageView;
import com.rtk.app.main.dialogPack.DialogAddQQ;
import com.rtk.app.main.dialogPack.DialogForApkPermission;
import com.rtk.app.main.dialogPack.DialogForOpenDeveloperUrl;
import com.rtk.app.tool.ApkInfo;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GameDetailsItem1 extends com.rtk.app.base.g implements View.OnClickListener {
    private Context j;
    private View k;
    private ViewHolder l;
    private GameDetailsBean m;
    private List<GameDetailsBean.DataBean.GameTagListBean> n;
    private List<GameDetailsBean.DataBean.GameTestListBean> o;
    private List<GameDetailsBean.DataBean.VipListBean> p;
    private List<GameDetailsBean.DataBean.OtherVersionBean> q;
    private TagFlowLayoutAdapter r;
    private GameDetailsItem1OpenServiceAdapter s;
    private GameDetailsVipAdapter t;
    public GameDetailsItem1OtherVersionAdapter u;
    private GameDetailsItem1RecommentGameAdapter v;
    private List<GameDetailsBean.DataBean.RecomGameBean> w;
    private DialogForApkPermission x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ViewHolder {

        @BindView
        LinearLayout gameDetailsAuthorLv;

        @BindView
        TextView gameDetailsDevelopUrl;

        @BindView
        ImageView gameDetailsItem1AdImage;

        @BindView
        LinearLayout gameDetailsItem1ApplyRebate;

        @BindView
        LinearLayout gameDetailsItem1ApplyRebate1;

        @BindView
        TextView gameDetailsItem1DataUpdated;

        @BindView
        TextView gameDetailsItem1EditDescription;

        @BindView
        LinearLayout gameDetailsItem1EditDescriptionLayout;

        @BindView
        TextView gameDetailsItem1EditDescriptionOpen;

        @BindView
        TextView gameDetailsItem1Free;

        @BindView
        LinearLayout gameDetailsItem1GameInformationLayout;

        @BindView
        TextView gameDetailsItem1GameIntro;

        @BindView
        LinearLayout gameDetailsItem1GameIntroLayout;

        @BindView
        TextView gameDetailsItem1GameIntroOpen;

        @BindView
        LinearLayout gameDetailsItem1GameOtherVersionLayout;

        @BindView
        CustomListView gameDetailsItem1GameOtherVersionListView;

        @BindView
        GridViewForScrollView gameDetailsItem1GameRecommendGridView;

        @BindView
        LinearLayout gameDetailsItem1GameRecommendLayout;

        @BindView
        LinearLayout gameDetailsItem1GameTagLayout;

        @BindView
        TagFlowLayout gameDetailsItem1GameTagLv;

        @BindView
        CustomListView gameDetailsItem1GameVip;

        @BindView
        LinearLayout gameDetailsItem1GameVipLayout;

        @BindView
        TextView gameDetailsItem1Language;

        @BindView
        LinearLayout gameDetailsItem1Lv;

        @BindView
        CustomListView gameDetailsItem1OpenServe;

        @BindView
        LinearLayout gameDetailsItem1OpenServeLayout;

        @BindView
        TextView gameDetailsItem1PermissionDetails;

        @BindView
        TextView gameDetailsItem1Rebate;

        @BindView
        LinearLayout gameDetailsItem1RebateLayout;

        @BindView
        TextView gameDetailsItem1RebateOpen;

        @BindView
        MyHorizontalScrollView gameDetailsItem1SV;

        @BindView
        NestedScrollView gameDetailsItem1ScrollView;

        @BindView
        TextView gameDetailsItem1Size;

        @BindView
        TextView gameDetailsItem1Type;

        @BindView
        TextView gameDetailsItem1Version;

        @BindView
        RoundedImageView gameDetailsUserIcon;

        @BindView
        LinearLayout gameDetailsUserLv;

        @BindView
        TextView gameDetailsUserName;

        ViewHolder(View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.gameDetailsItem1Lv = (LinearLayout) butterknife.c.a.c(view, R.id.game_details_item1_lv, "field 'gameDetailsItem1Lv'", LinearLayout.class);
            viewHolder.gameDetailsItem1SV = (MyHorizontalScrollView) butterknife.c.a.c(view, R.id.game_details_item1_SV, "field 'gameDetailsItem1SV'", MyHorizontalScrollView.class);
            viewHolder.gameDetailsItem1AdImage = (ImageView) butterknife.c.a.c(view, R.id.game_details_item1_ad_image, "field 'gameDetailsItem1AdImage'", ImageView.class);
            viewHolder.gameDetailsItem1ApplyRebate = (LinearLayout) butterknife.c.a.c(view, R.id.game_details_item1_ApplyRebate, "field 'gameDetailsItem1ApplyRebate'", LinearLayout.class);
            viewHolder.gameDetailsItem1EditDescription = (TextView) butterknife.c.a.c(view, R.id.game_details_item1_edit_description, "field 'gameDetailsItem1EditDescription'", TextView.class);
            viewHolder.gameDetailsItem1EditDescriptionOpen = (TextView) butterknife.c.a.c(view, R.id.game_details_item1_edit_description_open, "field 'gameDetailsItem1EditDescriptionOpen'", TextView.class);
            viewHolder.gameDetailsItem1EditDescriptionLayout = (LinearLayout) butterknife.c.a.c(view, R.id.game_details_item1_edit_description_layout, "field 'gameDetailsItem1EditDescriptionLayout'", LinearLayout.class);
            viewHolder.gameDetailsItem1GameIntro = (TextView) butterknife.c.a.c(view, R.id.game_details_item1_gameIntro, "field 'gameDetailsItem1GameIntro'", TextView.class);
            viewHolder.gameDetailsItem1GameIntroOpen = (TextView) butterknife.c.a.c(view, R.id.game_details_item1_gameIntro_open, "field 'gameDetailsItem1GameIntroOpen'", TextView.class);
            viewHolder.gameDetailsItem1GameIntroLayout = (LinearLayout) butterknife.c.a.c(view, R.id.game_details_item1_gameIntro_layout, "field 'gameDetailsItem1GameIntroLayout'", LinearLayout.class);
            viewHolder.gameDetailsItem1OpenServe = (CustomListView) butterknife.c.a.c(view, R.id.game_details_item1_openServe, "field 'gameDetailsItem1OpenServe'", CustomListView.class);
            viewHolder.gameDetailsItem1OpenServeLayout = (LinearLayout) butterknife.c.a.c(view, R.id.game_details_item1_openServe_layout, "field 'gameDetailsItem1OpenServeLayout'", LinearLayout.class);
            viewHolder.gameDetailsItem1GameVip = (CustomListView) butterknife.c.a.c(view, R.id.game_details_item1_gameVip, "field 'gameDetailsItem1GameVip'", CustomListView.class);
            viewHolder.gameDetailsItem1GameVipLayout = (LinearLayout) butterknife.c.a.c(view, R.id.game_details_item1_gameVip_layout, "field 'gameDetailsItem1GameVipLayout'", LinearLayout.class);
            viewHolder.gameDetailsItem1ApplyRebate1 = (LinearLayout) butterknife.c.a.c(view, R.id.game_details_item1_ApplyRebate1, "field 'gameDetailsItem1ApplyRebate1'", LinearLayout.class);
            viewHolder.gameDetailsItem1Rebate = (TextView) butterknife.c.a.c(view, R.id.game_details_item1_rebate, "field 'gameDetailsItem1Rebate'", TextView.class);
            viewHolder.gameDetailsItem1PermissionDetails = (TextView) butterknife.c.a.c(view, R.id.game_details_item1_permission_details, "field 'gameDetailsItem1PermissionDetails'", TextView.class);
            viewHolder.gameDetailsItem1RebateOpen = (TextView) butterknife.c.a.c(view, R.id.game_details_item1_rebate_open, "field 'gameDetailsItem1RebateOpen'", TextView.class);
            viewHolder.gameDetailsItem1RebateLayout = (LinearLayout) butterknife.c.a.c(view, R.id.game_details_item1_rebate_layout, "field 'gameDetailsItem1RebateLayout'", LinearLayout.class);
            viewHolder.gameDetailsItem1GameTagLv = (TagFlowLayout) butterknife.c.a.c(view, R.id.game_details_item1_gameTag_lv, "field 'gameDetailsItem1GameTagLv'", TagFlowLayout.class);
            viewHolder.gameDetailsItem1GameTagLayout = (LinearLayout) butterknife.c.a.c(view, R.id.game_details_item1_gameTag_layout, "field 'gameDetailsItem1GameTagLayout'", LinearLayout.class);
            viewHolder.gameDetailsItem1Type = (TextView) butterknife.c.a.c(view, R.id.game_details_item1_type, "field 'gameDetailsItem1Type'", TextView.class);
            viewHolder.gameDetailsItem1Language = (TextView) butterknife.c.a.c(view, R.id.game_details_item1_language, "field 'gameDetailsItem1Language'", TextView.class);
            viewHolder.gameDetailsItem1Free = (TextView) butterknife.c.a.c(view, R.id.game_details_item1_free, "field 'gameDetailsItem1Free'", TextView.class);
            viewHolder.gameDetailsItem1Version = (TextView) butterknife.c.a.c(view, R.id.game_details_item1_version, "field 'gameDetailsItem1Version'", TextView.class);
            viewHolder.gameDetailsItem1DataUpdated = (TextView) butterknife.c.a.c(view, R.id.game_details_item1_dataUpdated, "field 'gameDetailsItem1DataUpdated'", TextView.class);
            viewHolder.gameDetailsItem1Size = (TextView) butterknife.c.a.c(view, R.id.game_details_item1_size, "field 'gameDetailsItem1Size'", TextView.class);
            viewHolder.gameDetailsUserIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.game_details_userIcon, "field 'gameDetailsUserIcon'", RoundedImageView.class);
            viewHolder.gameDetailsUserName = (TextView) butterknife.c.a.c(view, R.id.game_details_userName, "field 'gameDetailsUserName'", TextView.class);
            viewHolder.gameDetailsDevelopUrl = (TextView) butterknife.c.a.c(view, R.id.game_details_develop_url, "field 'gameDetailsDevelopUrl'", TextView.class);
            viewHolder.gameDetailsAuthorLv = (LinearLayout) butterknife.c.a.c(view, R.id.game_details_author_lv, "field 'gameDetailsAuthorLv'", LinearLayout.class);
            viewHolder.gameDetailsUserLv = (LinearLayout) butterknife.c.a.c(view, R.id.game_details_userLv, "field 'gameDetailsUserLv'", LinearLayout.class);
            viewHolder.gameDetailsItem1GameInformationLayout = (LinearLayout) butterknife.c.a.c(view, R.id.game_details_item1_game_information_layout, "field 'gameDetailsItem1GameInformationLayout'", LinearLayout.class);
            viewHolder.gameDetailsItem1GameOtherVersionListView = (CustomListView) butterknife.c.a.c(view, R.id.game_details_item1_game_other_version_listView, "field 'gameDetailsItem1GameOtherVersionListView'", CustomListView.class);
            viewHolder.gameDetailsItem1GameOtherVersionLayout = (LinearLayout) butterknife.c.a.c(view, R.id.game_details_item1_game_other_version_layout, "field 'gameDetailsItem1GameOtherVersionLayout'", LinearLayout.class);
            viewHolder.gameDetailsItem1GameRecommendGridView = (GridViewForScrollView) butterknife.c.a.c(view, R.id.game_details_item1_game_recommend_gridView, "field 'gameDetailsItem1GameRecommendGridView'", GridViewForScrollView.class);
            viewHolder.gameDetailsItem1GameRecommendLayout = (LinearLayout) butterknife.c.a.c(view, R.id.game_details_item1_game_recommend_layout, "field 'gameDetailsItem1GameRecommendLayout'", LinearLayout.class);
            viewHolder.gameDetailsItem1ScrollView = (NestedScrollView) butterknife.c.a.c(view, R.id.game_details_item1_ScrollView, "field 'gameDetailsItem1ScrollView'", NestedScrollView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.gameDetailsItem1Lv = null;
                viewHolder.gameDetailsItem1SV = null;
                viewHolder.gameDetailsItem1AdImage = null;
                viewHolder.gameDetailsItem1ApplyRebate = null;
                viewHolder.gameDetailsItem1EditDescription = null;
                viewHolder.gameDetailsItem1EditDescriptionOpen = null;
                viewHolder.gameDetailsItem1EditDescriptionLayout = null;
                viewHolder.gameDetailsItem1GameIntro = null;
                viewHolder.gameDetailsItem1GameIntroOpen = null;
                viewHolder.gameDetailsItem1GameIntroLayout = null;
                viewHolder.gameDetailsItem1OpenServe = null;
                viewHolder.gameDetailsItem1OpenServeLayout = null;
                viewHolder.gameDetailsItem1GameVip = null;
                viewHolder.gameDetailsItem1GameVipLayout = null;
                viewHolder.gameDetailsItem1ApplyRebate1 = null;
                viewHolder.gameDetailsItem1Rebate = null;
                viewHolder.gameDetailsItem1PermissionDetails = null;
                viewHolder.gameDetailsItem1RebateOpen = null;
                viewHolder.gameDetailsItem1RebateLayout = null;
                viewHolder.gameDetailsItem1GameTagLv = null;
                viewHolder.gameDetailsItem1GameTagLayout = null;
                viewHolder.gameDetailsItem1Type = null;
                viewHolder.gameDetailsItem1Language = null;
                viewHolder.gameDetailsItem1Free = null;
                viewHolder.gameDetailsItem1Version = null;
                viewHolder.gameDetailsItem1DataUpdated = null;
                viewHolder.gameDetailsItem1Size = null;
                viewHolder.gameDetailsUserIcon = null;
                viewHolder.gameDetailsUserName = null;
                viewHolder.gameDetailsDevelopUrl = null;
                viewHolder.gameDetailsAuthorLv = null;
                viewHolder.gameDetailsUserLv = null;
                viewHolder.gameDetailsItem1GameInformationLayout = null;
                viewHolder.gameDetailsItem1GameOtherVersionListView = null;
                viewHolder.gameDetailsItem1GameOtherVersionLayout = null;
                viewHolder.gameDetailsItem1GameRecommendGridView = null;
                viewHolder.gameDetailsItem1GameRecommendLayout = null;
                viewHolder.gameDetailsItem1ScrollView = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements View.OnClickListener {
        final /* synthetic */ TextView a;
        final /* synthetic */ TextView b;

        /* renamed from: com.rtk.app.main.GameDetailsItem1$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        class RunnableC0019a implements Runnable {
            RunnableC0019a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.a.getText().equals("展开全文↓")) {
                    a.this.b.setMaxLines(100);
                    a.this.a.setText("收起全文↑");
                } else if (a.this.a.getText().equals("收起全文↑")) {
                    a.this.b.setMaxLines(4);
                    a.this.a.setText("展开全文↓");
                }
            }
        }

        a(GameDetailsItem1 gameDetailsItem1, TextView textView, TextView textView2) {
            this.a = textView;
            this.b = textView2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.post(new RunnableC0019a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements Runnable {
        final /* synthetic */ TextView a;
        final /* synthetic */ TextView b;

        b(GameDetailsItem1 gameDetailsItem1, TextView textView, TextView textView2) {
            this.a = textView;
            this.b = textView2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Layout layout = this.a.getLayout();
            this.a.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            if (layout != null) {
                if (layout.getLineCount() > 4) {
                    this.a.setMaxLines(4);
                    this.b.setVisibility(0);
                    this.b.setText("展开全文↓");
                    this.b.setSelected(true);
                    return;
                }
                this.b.setSelected(false);
                this.b.setVisibility(8);
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements TagFlowLayout.b {
        final /* synthetic */ Context a;

        c(Context context) {
            this.a = context;
        }

        public boolean a(View view, int i, FlowLayout flowLayout) {
            new Bundle();
            HashMap hashMap = new HashMap();
            hashMap.put("tags_type", ((GameDetailsBean.DataBean.GameTagListBean) GameDetailsItem1.this.n.get(i)).getTag_type() + "");
            hashMap.put("tags_id", ((GameDetailsBean.DataBean.GameTagListBean) GameDetailsItem1.this.n.get(i)).getTag_id() + "");
            com.rtk.app.tool.t.T0(this.a, ((GameDetailsBean.DataBean.GameTagListBean) GameDetailsItem1.this.n.get(i)).getTag_name() + "", hashMap);
            return true;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class d extends com.rtk.app.custom.AutoListView.b {
        final /* synthetic */ Context a;

        d(Context context) {
            this.a = context;
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.e0(this.a, new ApkInfo(((GameDetailsBean.DataBean.OtherVersionBean) GameDetailsItem1.this.q.get(i)).getGame_id(), ((GameDetailsBean.DataBean.OtherVersionBean) GameDetailsItem1.this.q.get(i)).getGame_name(), ((GameDetailsBean.DataBean.OtherVersionBean) GameDetailsItem1.this.q.get(i)).getPackage_name(), ((GameDetailsBean.DataBean.OtherVersionBean) GameDetailsItem1.this.q.get(i)).getGame_logo(), ((GameDetailsBean.DataBean.OtherVersionBean) GameDetailsItem1.this.q.get(i)).getPackage_size(), ((GameDetailsBean.DataBean.OtherVersionBean) GameDetailsItem1.this.q.get(i)).getSignaturesMD5(), ((GameDetailsBean.DataBean.OtherVersionBean) GameDetailsItem1.this.q.get(i)).getIs_apk(), ((GameDetailsBean.DataBean.OtherVersionBean) GameDetailsItem1.this.q.get(i)).getVersion_code(), ((GameDetailsBean.DataBean.OtherVersionBean) GameDetailsItem1.this.q.get(i)).getDownlist()));
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class e extends com.rtk.app.custom.AutoListView.b {
        final /* synthetic */ Context a;

        e(Context context) {
            this.a = context;
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.e0(this.a, new ApkInfo(((GameDetailsBean.DataBean.RecomGameBean) GameDetailsItem1.this.w.get(i)).getGame_id(), ((GameDetailsBean.DataBean.RecomGameBean) GameDetailsItem1.this.w.get(i)).getGame_name(), ((GameDetailsBean.DataBean.RecomGameBean) GameDetailsItem1.this.w.get(i)).getPackage_name(), ((GameDetailsBean.DataBean.RecomGameBean) GameDetailsItem1.this.w.get(i)).getGame_logo(), ((GameDetailsBean.DataBean.RecomGameBean) GameDetailsItem1.this.w.get(i)).getPackage_size(), ((GameDetailsBean.DataBean.RecomGameBean) GameDetailsItem1.this.w.get(i)).getSignaturesMD5(), ((GameDetailsBean.DataBean.RecomGameBean) GameDetailsItem1.this.w.get(i)).getIs_apk(), ((GameDetailsBean.DataBean.RecomGameBean) GameDetailsItem1.this.w.get(i)).getVersion_code(), null));
        }
    }

    public GameDetailsItem1(Context context, View view) {
        super(context, view);
        this.k = view;
        this.j = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(View view) {
        com.rtk.app.tool.t.C0(this.j, this.m.getData().getGame_pic_list(), ((Integer) view.getTag()).intValue());
    }

    public void A(GameDetailsBean gameDetailsBean) {
        x(gameDetailsBean.getData());
        this.m = gameDetailsBean;
        ViewHolder viewHolder = this.l;
        y(viewHolder.gameDetailsItem1EditDescriptionLayout, viewHolder.gameDetailsItem1EditDescription, gameDetailsBean.getData().getGame_install_bag_info(), this.l.gameDetailsItem1EditDescriptionOpen);
        ViewHolder viewHolder2 = this.l;
        y(viewHolder2.gameDetailsItem1GameIntroLayout, viewHolder2.gameDetailsItem1GameIntro, gameDetailsBean.getData().getGame_intro(), this.l.gameDetailsItem1GameIntroOpen);
        ViewHolder viewHolder3 = this.l;
        y(viewHolder3.gameDetailsItem1RebateLayout, viewHolder3.gameDetailsItem1Rebate, gameDetailsBean.getData().getGame_rebate(), this.l.gameDetailsItem1RebateOpen);
        this.n.addAll(gameDetailsBean.getData().getGame_tag_list());
        this.r.e();
        this.o.addAll(gameDetailsBean.getData().getGame_test_list());
        this.p.addAll(gameDetailsBean.getData().getVip_list());
        this.q.addAll(gameDetailsBean.getData().getOther_version());
        this.w.addAll(gameDetailsBean.getData().getRecom_game());
        z(this.l.gameDetailsItem1OpenServeLayout, this.s, this.o);
        z(this.l.gameDetailsItem1GameVipLayout, this.t, this.p);
        z(this.l.gameDetailsItem1GameOtherVersionLayout, this.u, this.q);
        z(this.l.gameDetailsItem1GameRecommendLayout, this.v, this.w);
        this.l.gameDetailsItem1Type.setText("类型：" + gameDetailsBean.getData().getGame_type());
        this.l.gameDetailsItem1Language.setText("语言：" + gameDetailsBean.getData().getGame_language());
        this.l.gameDetailsItem1Free.setText("资费：" + gameDetailsBean.getData().getGame_charge_type());
        this.l.gameDetailsItem1Version.setText("版本：V" + gameDetailsBean.getData().getGame_version());
        this.l.gameDetailsItem1DataUpdated.setText("发布：" + com.rtk.app.tool.c0.g(Long.parseLong(gameDetailsBean.getData().getGame_updated())));
        this.l.gameDetailsItem1Size.setText("大小：" + gameDetailsBean.getData().getPackage_size());
        if (com.rtk.app.tool.c0.q(gameDetailsBean.getData().getContact_QQ().getQDKF_url()) && com.rtk.app.tool.c0.q(gameDetailsBean.getData().getContact_QQ().getQDKF()) && com.rtk.app.tool.c0.q(gameDetailsBean.getData().getContact_QQ().getQQ()) && com.rtk.app.tool.c0.q(gameDetailsBean.getData().getContact_QQ().getQQgroup())) {
            this.l.gameDetailsItem1ApplyRebate.setVisibility(8);
            this.l.gameDetailsItem1ApplyRebate1.setVisibility(8);
        }
        try {
            this.l.gameDetailsAuthorLv.setVisibility(0);
            com.rtk.app.tool.t.d(this.j, gameDetailsBean.getData().getAuthor().getFace_2(), this.l.gameDetailsUserIcon);
            this.l.gameDetailsUserName.setText(gameDetailsBean.getData().getAuthor().getNickname());
            if (gameDetailsBean.getData().getAuthor().getMark() == 1 || gameDetailsBean.getData().getAuthor().getMark() == 2) {
                this.l.gameDetailsUserLv.setOnClickListener(this);
                if (gameDetailsBean.getData().getAuthor().getMark() == 1) {
                    this.l.gameDetailsDevelopUrl.setOnClickListener(this);
                }
            }
            if (gameDetailsBean.getData().getAuthor().getMark() != 1) {
                this.l.gameDetailsDevelopUrl.setVisibility(8);
            }
        } catch (Exception unused) {
            this.l.gameDetailsAuthorLv.setVisibility(8);
        }
    }

    @Override // com.rtk.app.base.g
    public void h(Context context, View view) {
        this.l.gameDetailsItem1GameTagLv.setOnTagClickListener(new c(context));
        this.l.gameDetailsItem1GameOtherVersionListView.setOnItemClickListener(new d(context));
        this.l.gameDetailsItem1GameRecommendGridView.setOnItemClickListener(new e(context));
        this.l.gameDetailsItem1ApplyRebate.setOnClickListener(this);
        this.l.gameDetailsItem1ApplyRebate1.setOnClickListener(this);
        this.l.gameDetailsItem1AdImage.setOnClickListener(this);
        this.l.gameDetailsItem1PermissionDetails.setOnClickListener(this);
    }

    @Override // com.rtk.app.base.g
    public void i(Context context, View view) {
        this.l = new ViewHolder(view);
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.w = new ArrayList();
        this.q = new ArrayList();
        this.r = new TagFlowLayoutAdapter(context, this.n);
        this.s = new GameDetailsItem1OpenServiceAdapter(context, this.o);
        this.t = new GameDetailsVipAdapter(context, this.p);
        this.u = new GameDetailsItem1OtherVersionAdapter(context, this.q);
        this.v = new GameDetailsItem1RecommentGameAdapter(context, this.w);
        this.l.gameDetailsItem1GameTagLv.setAdapter(this.r);
        this.l.gameDetailsItem1OpenServe.setAdapter((ListAdapter) this.s);
        this.l.gameDetailsItem1GameVip.setAdapter((ListAdapter) this.t);
        this.l.gameDetailsItem1GameOtherVersionListView.setAdapter((ListAdapter) this.u);
        this.l.gameDetailsItem1GameRecommendGridView.setAdapter((ListAdapter) this.v);
        HomeAdBean homeAdBean = com.rtk.app.tool.y.o;
        if (homeAdBean == null || homeAdBean.getData().get(1) == null || com.rtk.app.tool.y.o.getData().get(1).getAd_status() != 1) {
            return;
        }
        com.rtk.app.tool.c0.u("GameDetailsItem1", "添加广告1");
        com.rtk.app.tool.t.c(context, com.rtk.app.tool.y.o.getData().get(1).getAd_image(), this.l.gameDetailsItem1AdImage, true);
    }

    @Override // com.rtk.app.base.g
    public void j() {
        GameDetailsItem1OtherVersionAdapter gameDetailsItem1OtherVersionAdapter = this.u;
        if (gameDetailsItem1OtherVersionAdapter != null) {
            gameDetailsItem1OtherVersionAdapter.b();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.game_details_develop_url /* 2131297663 */:
                new DialogForOpenDeveloperUrl(this.j, this.m.getData().getAuthor().getOpen_url()).show();
                return;
            case R.id.game_details_item1_ApplyRebate /* 2131297666 */:
            case R.id.game_details_item1_ApplyRebate1 /* 2131297667 */:
                GameDetailsBean.DataBean.ContactQQBean contact_QQ = this.m.getData().getContact_QQ();
                if (!contact_QQ.getIs_QQ_show().equals("0")) {
                    new DialogAddQQ((Activity) this.j, contact_QQ).show();
                    return;
                }
                if (!com.rtk.app.tool.c0.q(contact_QQ.getQDKF_url())) {
                    com.rtk.app.tool.t.q((Activity) this.j, contact_QQ.getQDKF_url());
                    return;
                }
                if (!com.rtk.app.tool.c0.q(contact_QQ.getQDKF())) {
                    com.rtk.app.tool.t.p((Activity) this.j, contact_QQ.getQDKF());
                    return;
                } else if (!com.rtk.app.tool.c0.q(contact_QQ.getQQ())) {
                    com.rtk.app.tool.t.k((Activity) this.j, contact_QQ.getQQ(), contact_QQ.getQQ_show());
                    return;
                } else {
                    if (com.rtk.app.tool.c0.q(contact_QQ.getQQgroup())) {
                        return;
                    }
                    com.rtk.app.tool.t.j((Activity) this.j, contact_QQ.getQQgroup_key());
                    return;
                }
            case R.id.game_details_item1_ad_image /* 2131297670 */:
                com.rtk.app.tool.t.i0(this.j, com.rtk.app.tool.y.o.getData().get(1).getAd_id() + "");
                return;
            case R.id.game_details_item1_permission_details /* 2131297704 */:
                if (this.x == null) {
                    this.x = new DialogForApkPermission(this.j, this.m.getData().getGame_id(), 0);
                }
                this.x.show();
                return;
            case R.id.game_details_userLv /* 2131297736 */:
                com.rtk.app.tool.t.B0(this.j, this.m.getData().getAuthor().getId());
                return;
            default:
                return;
        }
    }

    public void w(TextView textView, TextView textView2) {
        textView.post(new b(this, textView, textView2));
    }

    public void x(GameDetailsBean.DataBean dataBean) {
        ViewGroup.LayoutParams layoutParams = this.l.gameDetailsItem1Lv.getLayoutParams();
        for (int i = 0; i < dataBean.getGame_pic_list().size(); i++) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int i2 = layoutParams.height;
            layoutParams2.height = i2;
            layoutParams2.width = (int) (i2 / 1.4d);
            AppCompatImageView recyclerImageView = new RecyclerImageView(this.j);
            recyclerImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            layoutParams2.rightMargin = 5;
            layoutParams2.leftMargin = 5;
            recyclerImageView.setLayoutParams(layoutParams2);
            com.rtk.app.tool.t.c(this.j, dataBean.getGame_pic_list().get(i), recyclerImageView, new boolean[0]);
            recyclerImageView.setTag(Integer.valueOf(i));
            recyclerImageView.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.main.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GameDetailsItem1.this.v(view);
                }
            });
            this.l.gameDetailsItem1Lv.addView(recyclerImageView);
        }
    }

    public void y(LinearLayout linearLayout, TextView textView, String str, TextView textView2) {
        try {
            if (!com.rtk.app.tool.c0.q(str)) {
                linearLayout.setVisibility(0);
                textView.setText(str);
                linearLayout.setOnClickListener(new a(this, textView2, textView));
                w(textView, textView2);
            } else {
                linearLayout.setVisibility(8);
            }
        } catch (Exception e2) {
            com.rtk.app.tool.c0.u("GameDetailsItem1", "游戏详情异常" + e2);
        }
    }

    public void z(LinearLayout linearLayout, BaseAdapter baseAdapter, List list) {
        if (list.size() == 0) {
            linearLayout.setVisibility(8);
        }
        baseAdapter.notifyDataSetChanged();
    }
}
