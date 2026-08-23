package com.rtk.app.main.dialogPack;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.bean.OtherImformationBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForUser extends o implements h.j {

    @BindView
    CustomTextView dialogForUserCommandAttention;

    @BindView
    ImageView dialogForUserCommandClose;

    @BindView
    TextView dialogForUserCommandDetail;

    @BindView
    TextView dialogForUserCommandFans;

    @BindView
    TextView dialogForUserCommandGrade;

    @BindView
    RoundedImageView dialogForUserCommandIcon;

    @BindView
    LinearLayout dialogForUserCommandLv;

    @BindView
    TextView dialogForUserCommandNickname;

    @BindView
    RelativeLayout dialogForUserCommandParent;

    @BindView
    TextView dialogForUserCommandSexAge;

    @BindView
    TextView dialogForUserCommandTitle;
    private Activity k;
    private int l;
    private OtherImformationBean m;

    public DialogForUser(Activity activity, String str) {
        super(activity);
        this.k = activity;
        List<String> d = com.rtk.app.tool.c0.d(str, "-");
        d.get(0);
        this.l = Integer.parseInt(d.get(1)) - 1111110;
        i(R.layout.dialog_for_user_command_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        p(1);
        l(this.dialogForUserCommandLv, this.dialogForUserCommandTitle);
        setCanceledOnTouchOutside(false);
        this.dialogForUserCommandLv.setOnClickListener(this);
        this.dialogForUserCommandClose.setOnClickListener(this);
    }

    private void p(int i) {
        String sb;
        if (i != 1) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/baseInfo");
            sb2.append(com.rtk.app.tool.y.u(this.k));
            sb2.append("&uid=");
            sb2.append(this.l);
            sb2.append("&fans=");
            sb2.append(com.rtk.app.tool.y.K());
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.k, "uid=" + this.l))));
            sb = sb2.toString();
        }
        com.rtk.app.tool.o.h.l(this.k, this, i, com.rtk.app.tool.o.h.h(new String[0]).a(sb));
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
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        com.rtk.app.tool.c0.u("DialogForUser", "" + str);
        OtherImformationBean otherImformationBean = (OtherImformationBean) create.fromJson(str, OtherImformationBean.class);
        this.m = otherImformationBean;
        com.rtk.app.tool.t.c(this.k, otherImformationBean.getData().getFace(), this.dialogForUserCommandIcon, new boolean[0]);
        this.dialogForUserCommandNickname.setText(this.m.getData().getNickname());
        this.dialogForUserCommandSexAge.setText(this.m.getData().getAge() + "");
        this.dialogForUserCommandSexAge.setSelected(this.m.getData().getSex().endsWith("1"));
        this.dialogForUserCommandGrade.setText(this.m.getData().getLevel());
        this.dialogForUserCommandAttention.setText("关注(" + this.m.getData().getFollows() + ")");
        this.dialogForUserCommandFans.setText("粉丝(" + this.m.getData().getFans() + ")");
        q();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        n(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.dialogPack.i
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                DialogForUser.this.s(strArr);
            }
        });
        com.rtk.app.tool.f.a(this.k, str, f.a.f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131297271) {
            com.rtk.app.tool.t.B0(this.k, this.l + "");
            dismiss();
            return;
        }
        dismiss();
    }

    public void q() {
        this.dialogForUserCommandParent.setOnClickListener(this);
    }
}
