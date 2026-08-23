package com.rtk.app.main.family;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.bean.FamilyCountPendingBean;
import com.rtk.app.bean.FamilyInfoBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.main.Home5Activity.BlacklistListActivity;
import com.rtk.app.main.family.upAudit.FamilyUpCheckApkListActivity;
import com.rtk.app.main.family.upAudit.FamilyUpCommentAuditListActivity;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyManagerActivity extends FamilyBaseActivity {

    @BindView
    View backLayout;

    @BindView
    TextView familyCoinManager;

    @BindView
    CustomTextView family_member_manager;

    @BindView
    TextView joinFamilyMessageNum;

    @BindView
    LinearLayout parentLayout;

    @BindView
    TextView postAuditMessageNum;

    @BindView
    TextView postCommentAuditMessageNum;

    @BindView
    View post_audit;

    @BindView
    View post_comment_audit;
    FamilyInfoBean.DataBean r;
    private String s;

    @BindView
    CustomTextView set_base_info;

    @BindView
    CustomTextView set_module;

    @BindView
    CustomTextView set_user_permission;

    @BindView
    TextView upAuditMessageNum;

    @BindView
    TextView upCommentAuditMessageNum;

    @BindView
    View up_audit;

    @BindView
    View up_comment_audit;

    @BindView
    CustomTextView white_list_manager;

    private void O() {
        if (this.r.isAdmin(com.rtk.app.tool.y.K())) {
            N(2);
        }
    }

    private void P() {
        N(3);
    }

    private void Q() {
        if (this.r.isLeader(com.rtk.app.tool.y.K())) {
            N(1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void N(int... iArr) {
        HashMap<String, String> l = com.rtk.app.tool.y.l();
        l.put("family_id", this.s);
        l.put("key", com.rtk.app.tool.t.L(l));
        int i = iArr[0];
        if (i == 1) {
            com.rtk.app.tool.o.h.j(this, this, com.rtk.app.tool.y.e + "family/join/total-pending", 1, l);
            return;
        }
        if (i == 2) {
            com.rtk.app.tool.o.h.j(this, this, com.rtk.app.tool.y.e + "family/count/pending", 2, l);
            return;
        }
        if (i != 3) {
            return;
        }
        com.rtk.app.tool.o.h.j(this, this, com.rtk.app.tool.y.e + "family/info/real", 3, l);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.r("FamilyManagerActivity", "mark--" + i + ",success,str:" + str);
        if (i == 1) {
            try {
                String optString = new JSONObject(str).getJSONObject("data").optString("total");
                if (!TextUtils.isEmpty(optString) && !TextUtils.equals("0", optString)) {
                    this.joinFamilyMessageNum.setVisibility(0);
                    this.joinFamilyMessageNum.setText(optString);
                } else {
                    this.joinFamilyMessageNum.setVisibility(8);
                }
                return;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
            FamilyInfoBean familyInfoBean = (FamilyInfoBean) w(str, FamilyInfoBean.class);
            this.family_member_manager.setText("家族成员管理(" + familyInfoBean.getData().getMember_num() + "人)");
            return;
        }
        FamilyCountPendingBean.DataBean data = ((FamilyCountPendingBean) w(str, FamilyCountPendingBean.class)).getData();
        if (com.rtk.app.c.a.c(data.getPostsCommentCount())) {
            this.postCommentAuditMessageNum.setVisibility(8);
        } else {
            this.postCommentAuditMessageNum.setVisibility(0);
            this.postCommentAuditMessageNum.setText(data.getPostsCommentCount());
        }
        if (com.rtk.app.c.a.c(data.getPostsCount())) {
            this.postAuditMessageNum.setVisibility(8);
        } else {
            this.postAuditMessageNum.setVisibility(0);
            this.postAuditMessageNum.setText(data.getPostsCount());
        }
        if (com.rtk.app.c.a.c(data.getUpCount())) {
            this.upAuditMessageNum.setVisibility(8);
        } else {
            this.upAuditMessageNum.setVisibility(0);
            this.upAuditMessageNum.setText(data.getUpCount());
        }
        if (com.rtk.app.c.a.c(data.getUpCommentCount())) {
            this.upCommentAuditMessageNum.setVisibility(8);
        } else {
            this.upCommentAuditMessageNum.setVisibility(0);
            this.upCommentAuditMessageNum.setText(data.getUpCommentCount());
        }
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initView() {
        String K = com.rtk.app.tool.y.K();
        if (this.r.isHeadLeader(K)) {
            this.familyCoinManager.setVisibility(0);
            return;
        }
        if (this.r.isSecondLeader(K)) {
            this.set_user_permission.setVisibility(8);
            return;
        }
        int childCount = this.parentLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.parentLayout.getChildAt(i).setVisibility(8);
        }
        if (this.r.isBbsAdmin(K)) {
            this.post_audit.setVisibility(0);
            this.post_comment_audit.setVisibility(0);
        }
        if (this.r.isUpAdmin(K)) {
            this.up_audit.setVisibility(0);
            this.up_comment_audit.setVisibility(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.rtk.app.tool.y.x(this)) {
            com.rtk.app.tool.t.w0(this);
            return;
        }
        switch (view.getId()) {
            case R.id.family_apply_join_family_list_tv_layout /* 2131297524 */:
                Bundle bundle = new Bundle();
                bundle.putString("family_id", this.s);
                com.rtk.app.tool.c.b(this, FamilyApplyJoinListActivity.class, bundle);
                return;
            case R.id.family_coin_manager /* 2131297525 */:
                Bundle bundle2 = new Bundle();
                bundle2.putString("family_id", this.s);
                com.rtk.app.tool.c.b(this.f147c, FamilyCoinManagerActivity.class, bundle2);
                return;
            case R.id.family_member_manager /* 2131297544 */:
                Intent intent = new Intent((Context) this, (Class<?>) FamilyMemberManagerActivity.class);
                intent.putExtra("family_id", this.s);
                startActivity(intent);
                return;
            case R.id.family_post_audit_layout /* 2131297552 */:
                FamilyInfoBean.DataBean.ModuleBean module = this.r.getModule();
                if (module == null) {
                    return;
                }
                com.rtk.app.tool.t.D0(this, this.s, module.getId() + "");
                return;
            case R.id.family_post_comment_audit_layout /* 2131297553 */:
                com.rtk.app.tool.t.m0(this, "0", 2, this.s, false);
                return;
            case R.id.family_up_audit_layout /* 2131297558 */:
                Bundle bundle3 = new Bundle();
                bundle3.putString("family_id", this.s);
                com.rtk.app.tool.c.b(this.f147c, FamilyUpCheckApkListActivity.class, bundle3);
                return;
            case R.id.family_up_comment_audit_layout /* 2131297559 */:
                Bundle bundle4 = new Bundle();
                bundle4.putString("family_id", this.s);
                com.rtk.app.tool.c.b(this.f147c, FamilyUpCommentAuditListActivity.class, bundle4);
                return;
            case R.id.family_white_list_manager /* 2131297560 */:
                Bundle bundle5 = new Bundle();
                bundle5.putString("family_id", this.s);
                com.rtk.app.tool.c.b(this, BlacklistListActivity.class, bundle5);
                return;
            case R.id.help /* 2131297862 */:
                Bundle bundle6 = new Bundle();
                bundle6.putString("url", "user/agreement/family/help");
                bundle6.putString("title", "家族功能使用帮助");
                com.rtk.app.tool.c.b(this, FamilyProtocolActivity.class, bundle6);
                return;
            case R.id.set_base_info /* 2131300137 */:
                Intent intent2 = new Intent((Context) this, (Class<?>) FamilySetBaseInfoActivity.class);
                intent2.putExtra("family_id", this.s);
                startActivity(intent2);
                return;
            case R.id.set_module /* 2131300150 */:
                Intent intent3 = new Intent((Context) this, (Class<?>) FamilySetModuleActivity.class);
                intent3.putExtra("family_id", this.s);
                startActivity(intent3);
                return;
            case R.id.set_user_permission /* 2131300161 */:
                Intent intent4 = new Intent((Context) this, (Class<?>) FamilySetUserPermissionActivity.class);
                intent4.putExtra("family_id", this.s);
                startActivity(intent4);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_family_manager);
        ButterKnife.a(this);
        FamilyInfoBean.DataBean dataBean = (FamilyInfoBean.DataBean) getIntent().getSerializableExtra("family_Info");
        this.r = dataBean;
        if (dataBean == null) {
            finish();
        } else {
            this.s = dataBean.getFamily_id();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        Q();
        O();
        P();
    }
}
