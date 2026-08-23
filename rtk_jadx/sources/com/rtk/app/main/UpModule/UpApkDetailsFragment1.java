package com.rtk.app.main.UpModule;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.rtk.app.R;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.UpApkDetailsBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.custom.MyHorizontalScrollView;
import com.rtk.app.custom.RecyclerImageView;
import com.rtk.app.main.dialogPack.DialogForApkPermission;
import com.rtk.app.main.dialogPack.RewardListDialog;
import com.rtk.app.main.family.FamilyInfoActivity;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpApkDetailsFragment1 extends BaseFragment {
    Unbinder o;
    private UpApkDetailsBean p;
    private DialogForApkPermission q;
    private TTAdNative r;

    @BindView
    TextView upApkDetailsFragment1Characteristic;

    @BindView
    LinearLayout upApkDetailsFragment1CharacteristicLV;

    @BindView
    TextView upApkDetailsFragment1CharacteristicOpen;

    @BindView
    LinearLayout upApkDetailsInformationAdsView;

    @BindView
    TextView upApkDetailsItem1Author;

    @BindView
    LinearLayout upApkDetailsItem1DownCoinsLv;

    @BindView
    TextView upApkDetailsItem1DownCoinsTv;

    @BindView
    TextView upApkDetailsItem1GameFamilyName;

    @BindView
    LinearLayout upApkDetailsItem1GameInformationLayout;

    @BindView
    TextView upApkDetailsItem1GameIntro;

    @BindView
    LinearLayout upApkDetailsItem1GameIntroLayout;

    @BindView
    TextView upApkDetailsItem1GameIntroOpen;

    @BindView
    TextView upApkDetailsItem1GamePermissionDetails;

    @BindView
    LinearLayout upApkDetailsItem1GameRewardLayout;

    @BindView
    LinearLayout upApkDetailsItem1GameRewardLv;

    @BindView
    LinearLayout upApkDetailsItem1GameRewardLv2;

    @BindView
    CustomTextView upApkDetailsItem1GameRewardNum;

    @BindView
    TextView upApkDetailsItem1Language;

    @BindView
    LinearLayout upApkDetailsItem1Lv;

    @BindView
    MyHorizontalScrollView upApkDetailsItem1SV;

    @BindView
    TextView upApkDetailsItem1Time;

    @BindView
    TextView upApkDetailsItem1Type;

    @BindView
    TextView upApkDetailsItem1Version;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            LinearLayout linearLayout;
            super.handleMessage(message);
            if (message.what == 10 && (linearLayout = UpApkDetailsFragment1.this.upApkDetailsInformationAdsView) != null) {
                linearLayout.addView((View) message.obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements View.OnClickListener {
        final /* synthetic */ UpApkDetailsBean.DataBean a;

        b(UpApkDetailsBean.DataBean dataBean) {
            this.a = dataBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.rtk.app.tool.t.C0(((BaseFragment) UpApkDetailsFragment1.this).e, this.a.getSourcePic(), ((Integer) view.getTag()).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class c implements View.OnClickListener {
        final /* synthetic */ TextView a;
        final /* synthetic */ TextView b;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c.this.a.getText().equals("展开全文↓")) {
                    c.this.b.setMaxLines(100);
                    c.this.a.setText("收起全文↑");
                } else if (c.this.a.getText().equals("收起全文↑")) {
                    c.this.b.setMaxLines(4);
                    c.this.a.setText("展开全文↓");
                }
            }
        }

        c(UpApkDetailsFragment1 upApkDetailsFragment1, TextView textView, TextView textView2) {
            this.a = textView;
            this.b = textView2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.post(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class d implements Runnable {
        final /* synthetic */ TextView a;
        final /* synthetic */ TextView b;

        d(UpApkDetailsFragment1 upApkDetailsFragment1, TextView textView, TextView textView2) {
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

    public UpApkDetailsFragment1() {
        new a();
    }

    private void y(int i) {
        this.upApkDetailsItem1DownCoinsLv.setVisibility(i > 0 ? 0 : 8);
        this.upApkDetailsItem1DownCoinsTv.setText(i + "金币");
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void A() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.upApkDetailsItem1Author.setOnClickListener(this);
        this.upApkDetailsItem1GameRewardLv.setOnClickListener(this);
        this.upApkDetailsItem1GamePermissionDetails.setOnClickListener(this);
        this.upApkDetailsItem1GameFamilyName.setOnClickListener(this);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    public void i() {
        UpApkDetailsBean upApkDetailsBean = (UpApkDetailsBean) getArguments().get("upApkDetails");
        this.p = upApkDetailsBean;
        w(upApkDetailsBean.getData());
        this.upApkDetailsItem1GameIntro.setText(this.p.getData().getSourceDescription());
        this.upApkDetailsItem1Type.setText(this.p.getData().getTypeName());
        this.upApkDetailsItem1Language.setText(this.p.getData().getLang());
        this.upApkDetailsItem1Time.setText(this.p.getData().getAddtime());
        this.upApkDetailsItem1Author.setText(this.p.getData().getNickname());
        this.upApkDetailsItem1Author.getPaint().setFlags(8);
        this.upApkDetailsItem1Version.setText(this.p.getData().getVersionName());
        x(this.upApkDetailsItem1GameIntroLayout, this.upApkDetailsItem1GameIntro, this.p.getData().getSourceDescription(), this.upApkDetailsItem1GameIntroOpen);
        x(this.upApkDetailsFragment1CharacteristicLV, this.upApkDetailsFragment1Characteristic, this.p.getData().getSourceCharacteristic(), this.upApkDetailsFragment1CharacteristicOpen);
        v(this.upApkDetailsFragment1Characteristic, this.upApkDetailsFragment1CharacteristicOpen);
        this.upApkDetailsItem1GameRewardLayout.setVisibility(8);
        this.upApkDetailsItem1GameRewardLv2.setVisibility(8);
        if (this.p.getData().getRewardList() != null) {
            this.upApkDetailsItem1GameRewardLv.removeAllViews();
            this.upApkDetailsItem1GameRewardLv2.setVisibility(this.p.getData().getRewardList().size() > 0 ? 0 : 8);
            this.upApkDetailsItem1GameRewardLayout.setVisibility(this.p.getData().getRewardList().size() > 0 ? 0 : 8);
            for (int i = 0; i < this.p.getData().getRewardList().size() && i < 6; i++) {
                View inflate = LayoutInflater.from(this.e).inflate(R.layout.post_details_reward_item_layout, (ViewGroup) null);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.post_details_reward_item_img);
                TextView textView = (TextView) inflate.findViewById(R.id.post_details_reward_item_num);
                com.rtk.app.tool.t.c(this.e, this.p.getData().getRewardList().get(i).getFace(), imageView, new boolean[0]);
                textView.setText(this.p.getData().getRewardList().get(i).getCoin());
                this.upApkDetailsItem1GameRewardLv.addView(inflate);
            }
            this.upApkDetailsItem1GameRewardLv.setVisibility(this.p.getData().getRewardList().size() > 0 ? 0 : 8);
            this.upApkDetailsItem1GameRewardNum.setLeftText("共有" + this.p.getData().getRewardNum() + "人次打赏了");
            this.upApkDetailsItem1GameRewardNum.setRightText("金币");
            this.upApkDetailsItem1GameRewardNum.setText(" " + this.p.getData().getCoinNum() + " ");
        }
        y(this.p.getData().getNeedCoin());
        if (this.p.getData().getFamily() != null) {
            this.upApkDetailsItem1GameFamilyName.setText(this.p.getData().getFamily().getFamily_name());
            this.upApkDetailsItem1GameFamilyName.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.up_apk_details_item1_author /* 2131300640 */:
                com.rtk.app.tool.t.B0(this.e, "" + this.p.getData().getUid());
                return;
            case R.id.up_apk_details_item1_game_family_name /* 2131300646 */:
                if (this.p.getData().getFamily() != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("family_id", this.p.getData().getFamily().getFamily_id() + "");
                    com.rtk.app.tool.c.b(getActivity(), FamilyInfoActivity.class, bundle);
                    return;
                }
                return;
            case R.id.up_apk_details_item1_game_permission_details /* 2131300648 */:
                if (this.q == null) {
                    this.q = new DialogForApkPermission(this.e, this.p.getData().getId(), 1);
                }
                this.q.show();
                return;
            case R.id.up_apk_details_item1_game_reward_lv /* 2131300650 */:
                new RewardListDialog(this.e, this.p.getData().getId() + "", "upApkReward").show();
                return;
            default:
                return;
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.up_apk_details_fragment1_layout, viewGroup, false);
            this.a = inflate;
            this.o = ButterKnife.b(this, inflate);
            b();
        } else {
            this.o = ButterKnife.b(this, view);
        }
        return this.a;
    }

    public void onDestroyView() {
        super.onDestroyView();
        com.rtk.app.tool.c0.u("UpApkDetailsFragment1", "onDestroyView");
        if (this.r != null) {
            this.r = null;
        }
        this.upApkDetailsInformationAdsView.removeAllViews();
        this.o.a();
    }

    public void v(TextView textView, TextView textView2) {
        textView.post(new d(this, textView, textView2));
    }

    public void w(UpApkDetailsBean.DataBean dataBean) {
        ViewGroup.LayoutParams layoutParams = this.upApkDetailsItem1Lv.getLayoutParams();
        this.upApkDetailsItem1Lv.removeAllViews();
        for (int i = 0; i < dataBean.getSourcePic().size(); i++) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int i2 = layoutParams.height;
            layoutParams2.height = i2;
            layoutParams2.width = (int) (i2 / 1.4d);
            AppCompatImageView recyclerImageView = new RecyclerImageView(this.e);
            recyclerImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            recyclerImageView.setPadding(0, 0, 10, 0);
            layoutParams2.leftMargin = 5;
            recyclerImageView.setLayoutParams(layoutParams2);
            com.rtk.app.tool.t.c(this.e, dataBean.getSourcePic().get(i), recyclerImageView, new boolean[0]);
            recyclerImageView.setTag(Integer.valueOf(i));
            recyclerImageView.setOnClickListener(new b(dataBean));
            this.upApkDetailsItem1Lv.addView(recyclerImageView);
        }
    }

    public void x(LinearLayout linearLayout, TextView textView, String str, TextView textView2) {
        try {
            if (!com.rtk.app.tool.c0.q(str)) {
                linearLayout.setVisibility(0);
                textView.setText(str);
                linearLayout.setOnClickListener(new c(this, textView2, textView));
                v(textView, textView2);
            } else {
                linearLayout.setVisibility(8);
            }
        } catch (Exception e) {
            com.rtk.app.tool.c0.u("UpApkDetailsFragment1", "游戏详情异常" + e);
        }
    }
}
