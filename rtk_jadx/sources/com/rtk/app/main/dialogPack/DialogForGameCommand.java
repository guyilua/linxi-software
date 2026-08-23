package com.rtk.app.main.dialogPack;

import android.app.Activity;
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
import com.rtk.app.bean.GameDetailsBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForGameCommand extends o implements h.j {

    @BindView
    RoundedImageView dialogForCommandGameLogo;

    @BindView
    LinearLayout dialogForCommandGameLv;

    @BindView
    TextView dialogForCommandGameName;

    @BindView
    RelativeLayout dialogForCommandGameParent;

    @BindView
    TextView dialogForCommandGameSize;

    @BindView
    TextView dialogForCommandGameTitle;

    @BindView
    CustomTextView dialogForCommandGameVersion;

    @BindView
    ImageView dialogForGameCommandClose;

    @BindView
    LinearLayout dialogForGameCommandLv;
    private Activity k;
    private String l;
    private GameDetailsBean m;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements com.rtk.app.tool.s {
        a() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            DialogForGameCommand.this.q(1);
        }
    }

    public DialogForGameCommand(Activity activity, String str) {
        super(activity);
        this.k = activity;
        List<String> d = com.rtk.app.tool.c0.d(str, "-");
        d.get(0);
        this.l = d.get(1);
        i(R.layout.dialog_for_game_command_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        q(1);
        setCanceledOnTouchOutside(false);
        l(this.dialogForGameCommandLv, this.dialogForCommandGameTitle);
        this.dialogForGameCommandClose.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i) {
        String sb;
        if (i != 1) {
            sb = "";
        } else {
            String str = "&uid=" + com.rtk.app.tool.y.K();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("game/gamedetails");
            sb2.append(com.rtk.app.tool.y.u(this.k));
            sb2.append("&game_id=");
            sb2.append(this.l);
            sb2.append(str);
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.k, "game_id=" + this.l))));
            sb = sb2.toString();
        }
        com.rtk.app.tool.o.h.l(this.k, this, i, com.rtk.app.tool.o.h.h(new String[0]).a(sb));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i != 1) {
            return;
        }
        k();
        GameDetailsBean gameDetailsBean = (GameDetailsBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, GameDetailsBean.class);
        this.m = gameDetailsBean;
        this.dialogForCommandGameName.setText(gameDetailsBean.getData().getGame_name());
        com.rtk.app.tool.t.c(this.k, this.m.getData().getGame_logo(), this.dialogForCommandGameLogo, new boolean[0]);
        this.dialogForCommandGameSize.setText(this.m.getData().getPackage_size());
        this.dialogForCommandGameVersion.setText(this.m.getData().getGame_version());
        r();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.k, str, f.a.f);
        n(str, new a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131297211) {
            com.rtk.app.tool.t.e0(this.k, new ApkInfo(this.m.getData()));
            dismiss();
        } else {
            dismiss();
        }
    }

    public void r() {
        this.dialogForCommandGameParent.setOnClickListener(this);
    }
}
