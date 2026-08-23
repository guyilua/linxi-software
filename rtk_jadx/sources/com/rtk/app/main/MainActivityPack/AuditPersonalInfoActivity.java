package com.rtk.app.main.MainActivityPack;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.main.MainActivityPack.AuditPack.AuditIconActivity;
import com.rtk.app.main.MainActivityPack.AuditPack.AuditNickNameActivity;
import com.rtk.app.main.MainActivityPack.AuditPack.AuditPhotoActivity;
import com.rtk.app.main.MainActivityPack.AuditPack.AuditSignatureActivity;
import com.rtk.app.main.MainActivityPack.AuditPack.AuditUpAgainActivity;
import com.rtk.app.main.MainActivityPack.AuditPack.MyAuditCommentActivity;
import com.rtk.app.main.UpModule.UpCheckApkListActivity;
import com.rtk.app.main.UpModule.UpCommentAuditListActivity;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AuditPersonalInfoActivity extends BaseActivity implements h.j {

    @BindView
    TextView auditPersonalInfoAuditPostReply;

    @BindView
    TextView auditPersonalInfoFamilyPost;

    @BindView
    TextView auditPersonalInfoFamilyPostComment;

    @BindView
    TextView auditPersonalInfoFamilyUp;

    @BindView
    TextView auditPersonalInfoFamilyUpComment;

    @BindView
    TextView auditPersonalInfoIcon;

    @BindView
    TextView auditPersonalInfoMyAuditComment;

    @BindView
    TextView auditPersonalInfoNickname;

    @BindView
    TextView auditPersonalInfoPhotoAlbum;

    @BindView
    TextView auditPersonalInfoPostAudit;

    @BindView
    TextView auditPersonalInfoReAudit;

    @BindView
    TextView auditPersonalInfoSignature;

    @BindView
    TextView auditPersonalInfoTopBack;

    @BindView
    LinearLayout auditPersonalInfoTopLayout;

    @BindView
    TextView auditPersonalInfoUpAudit;

    @BindView
    TextView auditPersonalInfoUpAuditComment;

    private void L() {
        this.auditPersonalInfoNickname.setVisibility((MainActivity.p.getData().getAdmin().getUserNicknameAdmin() == 1 || MainActivity.p.getData().getAdmin().getUserNicknameAdmin() == 2) ? 0 : 8);
        this.auditPersonalInfoIcon.setVisibility((MainActivity.p.getData().getAdmin().getUserFaceAdmin() == 1 || MainActivity.p.getData().getAdmin().getUserFaceAdmin() == 2) ? 0 : 8);
        this.auditPersonalInfoSignature.setVisibility((MainActivity.p.getData().getAdmin().getUserSignatureAdmin() == 1 || MainActivity.p.getData().getAdmin().getUserSignatureAdmin() == 2) ? 0 : 8);
        this.auditPersonalInfoPhotoAlbum.setVisibility((MainActivity.p.getData().getAdmin().getUserPhotoAdmin() == 1 || MainActivity.p.getData().getAdmin().getUserPhotoAdmin() == 2) ? 0 : 8);
        this.auditPersonalInfoReAudit.setVisibility((MainActivity.p.getData().getAdmin().getUpAgainAdmin() == 1 || MainActivity.p.getData().getAdmin().getUpAgainAdmin() == 2) ? 0 : 8);
        this.auditPersonalInfoMyAuditComment.setVisibility((MainActivity.p.getData().getAdmin().getCommentadmin() == 1 || MainActivity.p.getData().getAdmin().getCommentadmin() == 2) ? 0 : 8);
        this.auditPersonalInfoUpAudit.setVisibility((MainActivity.p.getData().getAdmin().getUpAdmin() == 1 || MainActivity.p.getData().getAdmin().getUpAdmin() == 2) ? 0 : 8);
        this.auditPersonalInfoUpAuditComment.setVisibility((MainActivity.p.getData().getAdmin().getCommentadmin() == 1 || MainActivity.p.getData().getAdmin().getCommentadmin() == 2) ? 0 : 8);
        this.auditPersonalInfoPostAudit.setVisibility((MainActivity.p.getData().getAdmin().getBbsAdmin() == 1 || MainActivity.p.getData().getAdmin().getBbsAdmin() == 2) ? 0 : 8);
        this.auditPersonalInfoAuditPostReply.setVisibility((MainActivity.p.getData().getAdmin().getBbsAdmin() == 1 || MainActivity.p.getData().getAdmin().getBbsAdmin() == 2) ? 0 : 8);
        if (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getAdmin() == 2) {
            this.auditPersonalInfoNickname.setVisibility(0);
            this.auditPersonalInfoIcon.setVisibility(0);
            this.auditPersonalInfoSignature.setVisibility(0);
            this.auditPersonalInfoPhotoAlbum.setVisibility(0);
            this.auditPersonalInfoReAudit.setVisibility(0);
            this.auditPersonalInfoUpAudit.setVisibility(0);
            this.auditPersonalInfoMyAuditComment.setVisibility(0);
            this.auditPersonalInfoUpAuditComment.setVisibility(0);
            this.auditPersonalInfoPostAudit.setVisibility(0);
            this.auditPersonalInfoAuditPostReply.setVisibility(0);
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.auditPersonalInfoTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0), null);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        if (!c.d.a.d.d()) {
            com.rtk.app.tool.f.a(this.f147c, "未登录", f.a.f);
            finish();
        } else {
            L();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.rtk.app.R.id.audit_personal_info_audit_post_reply /* 2131296590 */:
                com.rtk.app.tool.t.m0(this.f147c, "0", 0, null, false);
                return;
            case com.rtk.app.R.id.audit_personal_info_family_post /* 2131296591 */:
                com.rtk.app.tool.t.E0(this.f147c, "0", true);
                return;
            case com.rtk.app.R.id.audit_personal_info_family_post_comment /* 2131296592 */:
                com.rtk.app.tool.t.m0(this.f147c, "0", 0, null, true);
                return;
            case com.rtk.app.R.id.audit_personal_info_family_up /* 2131296593 */:
                Intent intent = new Intent((Context) this.f147c, (Class<?>) UpCheckApkListActivity.class);
                intent.putExtra("isAuditInfoForFamily", true);
                startActivity(intent);
                return;
            case com.rtk.app.R.id.audit_personal_info_family_up_comment /* 2131296594 */:
                Bundle bundle = new Bundle();
                bundle.putInt("hasCommentPermission", (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getUpAdmin() == 1) ? 1 : 2);
                bundle.putBoolean("isAuditInfoForFamily", true);
                com.rtk.app.tool.c.b(this.f147c, UpCommentAuditListActivity.class, bundle);
                return;
            case com.rtk.app.R.id.audit_personal_info_icon /* 2131296595 */:
                com.rtk.app.tool.c.b(this.f147c, AuditIconActivity.class, null);
                return;
            case com.rtk.app.R.id.audit_personal_info_my_audit_comment /* 2131296596 */:
                com.rtk.app.tool.c.b(this.f147c, MyAuditCommentActivity.class, null);
                return;
            case com.rtk.app.R.id.audit_personal_info_nickname /* 2131296597 */:
                com.rtk.app.tool.c.b(this.f147c, AuditNickNameActivity.class, null);
                return;
            case com.rtk.app.R.id.audit_personal_info_photo_album /* 2131296598 */:
                com.rtk.app.tool.c.b(this.f147c, AuditPhotoActivity.class, null);
                return;
            case com.rtk.app.R.id.audit_personal_info_post_audit /* 2131296599 */:
                com.rtk.app.tool.t.E0(this.f147c, "0", false);
                return;
            case com.rtk.app.R.id.audit_personal_info_re_audit /* 2131296600 */:
                com.rtk.app.tool.c.b(this.f147c, AuditUpAgainActivity.class, null);
                return;
            case com.rtk.app.R.id.audit_personal_info_signature /* 2131296601 */:
                com.rtk.app.tool.c.b(this.f147c, AuditSignatureActivity.class, null);
                return;
            case com.rtk.app.R.id.audit_personal_info_top_back /* 2131296602 */:
                finish();
                return;
            case com.rtk.app.R.id.audit_personal_info_top_layout /* 2131296603 */:
            default:
                return;
            case com.rtk.app.R.id.audit_personal_info_up_audit /* 2131296604 */:
                com.rtk.app.tool.c.b(this.f147c, UpCheckApkListActivity.class, null);
                return;
            case com.rtk.app.R.id.audit_personal_info_up_audit_comment /* 2131296605 */:
                Bundle bundle2 = new Bundle();
                if (c.d.a.d.d()) {
                    if (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getAdmin() == 2 || MainActivity.p.getData().getAdmin().getUpAdmin() == 1 || MainActivity.p.getData().getAdmin().getUpAdmin() == 2) {
                        bundle2.putInt("hasCommentPermission", (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getUpAdmin() == 1) ? 1 : 2);
                        com.rtk.app.tool.c.b(this.f147c, UpCommentAuditListActivity.class, bundle2);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_audit_personal_info);
        ButterKnife.a(this);
    }
}
