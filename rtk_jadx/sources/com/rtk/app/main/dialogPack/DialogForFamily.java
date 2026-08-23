package com.rtk.app.main.dialogPack;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.GsonBuilder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.bean.FamilyInfoBean;
import com.rtk.app.main.family.FamilyInfoActivity;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForFamily extends o implements h.j {

    @BindView
    ImageView dialogForUserCommandClose;

    @BindView
    TextView dialogForUserCommandDetail;

    @BindView
    RoundedImageView dialogForUserCommandIcon;

    @BindView
    TextView dialogForUserCommandId;

    @BindView
    LinearLayout dialogForUserCommandLv;

    @BindView
    TextView dialogForUserCommandName;

    @BindView
    TextView dialogForUserCommandNum;

    @BindView
    RelativeLayout dialogForUserCommandParent;

    @BindView
    TextView dialogForUserCommandTitle;
    private Activity k;
    private int l;
    private FamilyInfoBean.DataBean m;

    public DialogForFamily(Activity activity, String str) {
        super(activity);
        this.l = 0;
        this.k = activity;
        this.l = Integer.parseInt(com.rtk.app.tool.c0.d(str, "-").get(1));
        i(R.layout.dialog_for_family_command_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        p(1);
        l(this.dialogForUserCommandLv, this.dialogForUserCommandTitle);
        setCanceledOnTouchOutside(false);
        this.dialogForUserCommandLv.setOnClickListener(this);
        this.dialogForUserCommandClose.setOnClickListener(this);
        this.dialogForUserCommandDetail.setOnClickListener(this);
    }

    private void p(int i) {
        if (i != 1) {
            return;
        }
        String str = "&uid=" + com.rtk.app.tool.y.K();
        String str2 = "&token=" + com.rtk.app.tool.y.H();
        StringBuilder sb = new StringBuilder();
        sb.append("family/basic-information");
        sb.append(com.rtk.app.tool.y.u(this.k));
        sb.append(str);
        sb.append(str2);
        sb.append("&family_id=");
        sb.append(this.l);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.k, "family_id=" + this.l))));
        String sb2 = sb.toString();
        Log.d("DialogForUser", "url=" + sb2);
        com.rtk.app.tool.o.h.l(this.k, this, i, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(String[] strArr) {
        p(1);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i != 1) {
            return;
        }
        k();
        this.m = ((FamilyInfoBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, FamilyInfoBean.class)).getData();
        q();
        com.rtk.app.tool.t.c(this.k, this.m.getFamily_logo(), this.dialogForUserCommandIcon, new boolean[0]);
        this.dialogForUserCommandName.setText(this.m.getFamily_name());
        this.dialogForUserCommandId.setText(this.m.getFamily_sn());
        this.dialogForUserCommandNum.setText(this.m.getMember_num());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        n(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.dialogPack.f
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                DialogForFamily.this.s(strArr);
            }
        });
        com.rtk.app.tool.f.a(this.k, str, f.a.f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_for_family_command_close /* 2131297202 */:
                dismiss();
                return;
            case R.id.dialog_for_family_command_detail /* 2131297203 */:
                Intent intent = new Intent(this.k, (Class<?>) FamilyInfoActivity.class);
                com.rtk.app.tool.c0.u("DialogForUser", "mFamilyId:" + this.l);
                intent.putExtra("family_id", this.l + "");
                this.k.startActivity(intent);
                dismiss();
                return;
            default:
                return;
        }
    }

    public void q() {
        this.dialogForUserCommandParent.setOnClickListener(this);
    }
}
