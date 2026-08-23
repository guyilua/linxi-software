package com.rtk.app.main.HomeCommunityPack;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.base.BaseActivity;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CommunitySettingActivity extends BaseActivity {

    @BindView
    TextView communitySettingBack;

    @BindView
    CheckBox communitySettingCloseVideoVolume;

    @BindView
    CheckBox communitySettingDeleteLineFeed;

    @BindView
    LinearLayout communitySettingLayout;

    @BindView
    CheckBox communitySettingNightOriginal;

    @BindView
    CheckBox communitySettingOpenConcise;

    @BindView
    RadioButton communitySettingPost9Concise;

    @BindView
    RadioButton communitySettingPostDetails;

    @BindView
    CheckBox communitySettingPostJustTitle;

    @BindView
    CheckBox communitySettingRule;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.communitySettingLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        this.q = com.rtk.app.tool.v.a(this.f147c, "postConciseVALUE");
        this.u = com.rtk.app.tool.v.a(this.f147c, com.rtk.app.tool.v.j);
        this.r = com.rtk.app.tool.v.a(this.f147c, "postModuleRuleVaule");
        this.s = com.rtk.app.tool.v.a(this.f147c, com.rtk.app.tool.v.i);
        this.t = com.rtk.app.tool.v.a(this.f147c, "postJustTitle");
        this.v = com.rtk.app.tool.v.a(this.f147c, com.rtk.app.tool.v.k);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.communitySettingOpenConcise.setChecked(this.q);
        this.communitySettingRule.setChecked(this.r);
        this.communitySettingDeleteLineFeed.setChecked(this.s);
        this.communitySettingNightOriginal.setChecked(this.u);
        this.communitySettingPostJustTitle.setChecked(this.t);
        this.communitySettingPost9Concise.setChecked(this.q);
        this.communitySettingPostDetails.setChecked(!this.q);
        this.communitySettingCloseVideoVolume.setChecked(this.v);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.rtk.app.R.id.community_setting_back /* 2131297037 */:
                finish();
                return;
            case com.rtk.app.R.id.community_setting_close_video_volume /* 2131297038 */:
                boolean a = com.rtk.app.tool.v.a(this.f147c, com.rtk.app.tool.v.k);
                this.v = a;
                boolean z = !a;
                this.v = z;
                com.rtk.app.tool.v.e(this.f147c, com.rtk.app.tool.v.k, Boolean.valueOf(z));
                this.communitySettingCloseVideoVolume.setChecked(this.v);
                return;
            case com.rtk.app.R.id.community_setting_concise /* 2131297039 */:
                boolean a2 = com.rtk.app.tool.v.a(this.f147c, "postConciseVALUE");
                this.q = a2;
                boolean z2 = !a2;
                this.q = z2;
                com.rtk.app.tool.v.e(this.f147c, "postConciseVALUE", Boolean.valueOf(z2));
                this.communitySettingOpenConcise.setChecked(this.q);
                return;
            case com.rtk.app.R.id.community_setting_delete_line_feed /* 2131297040 */:
                boolean a3 = com.rtk.app.tool.v.a(this.f147c, com.rtk.app.tool.v.i);
                this.s = a3;
                boolean z3 = !a3;
                this.s = z3;
                com.rtk.app.tool.v.e(this.f147c, com.rtk.app.tool.v.i, Boolean.valueOf(z3));
                this.communitySettingDeleteLineFeed.setChecked(this.s);
                return;
            case com.rtk.app.R.id.community_setting_layout /* 2131297041 */:
            default:
                return;
            case com.rtk.app.R.id.community_setting_night_original /* 2131297042 */:
                boolean a4 = com.rtk.app.tool.v.a(this.f147c, com.rtk.app.tool.v.j);
                this.u = a4;
                boolean z4 = !a4;
                this.u = z4;
                com.rtk.app.tool.v.e(this.f147c, com.rtk.app.tool.v.j, Boolean.valueOf(z4));
                this.communitySettingNightOriginal.setChecked(this.u);
                return;
            case com.rtk.app.R.id.community_setting_post_9_concise /* 2131297043 */:
                this.q = com.rtk.app.tool.v.a(this.f147c, "postConciseVALUE");
                this.q = true;
                com.rtk.app.tool.v.e(this.f147c, "postConciseVALUE", true);
                return;
            case com.rtk.app.R.id.community_setting_post_details /* 2131297044 */:
                this.q = com.rtk.app.tool.v.a(this.f147c, "postConciseVALUE");
                this.q = false;
                com.rtk.app.tool.v.e(this.f147c, "postConciseVALUE", false);
                return;
            case com.rtk.app.R.id.community_setting_post_just_title /* 2131297045 */:
                boolean a5 = com.rtk.app.tool.v.a(this.f147c, "postJustTitle");
                this.t = a5;
                boolean z5 = !a5;
                this.t = z5;
                com.rtk.app.tool.v.e(this.f147c, "postJustTitle", Boolean.valueOf(z5));
                this.communitySettingPostJustTitle.setChecked(this.t);
                return;
            case com.rtk.app.R.id.community_setting_rule /* 2131297046 */:
                boolean a6 = com.rtk.app.tool.v.a(this.f147c, "postModuleRuleVaule");
                this.r = a6;
                boolean z6 = !a6;
                this.r = z6;
                com.rtk.app.tool.v.e(this.f147c, "postModuleRuleVaule", Boolean.valueOf(z6));
                this.communitySettingRule.setChecked(this.r);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_community_setting);
        ButterKnife.a(this);
    }
}
