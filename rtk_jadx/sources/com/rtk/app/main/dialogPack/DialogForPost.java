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
import com.rtk.app.bean.PostDetailsBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForPost extends o implements h.j {

    @BindView
    ImageView dialogForCommandClose;

    @BindView
    TextView dialogForCommandDetail;

    @BindView
    RoundedImageView dialogForCommandIcon;

    @BindView
    LinearLayout dialogForCommandLV;

    @BindView
    TextView dialogForCommandNickname;

    @BindView
    RelativeLayout dialogForCommandParent;

    @BindView
    CustomTextView dialogForCommandTitle;

    @BindView
    TextView dialogForCommandTopTitle;
    private Activity k;
    private int l;
    private PostDetailsBean m;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements com.rtk.app.tool.s {
        a() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            DialogForPost.this.q(1);
        }
    }

    public DialogForPost(Activity activity, String str) {
        super(activity);
        this.k = activity;
        List<String> d = com.rtk.app.tool.c0.d(str, "-");
        d.get(0);
        this.l = Integer.parseInt(d.get(1)) - 1111110;
        i(R.layout.dialog_for_post_command_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        q(1);
        l(this.dialogForCommandLV, this.dialogForCommandTopTitle);
        setCanceledOnTouchOutside(false);
        this.dialogForCommandClose.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i) {
        if (i != 1) {
            return;
        }
        HashMap<String, String> k = com.rtk.app.tool.y.k();
        k.put("pid", this.l + "");
        k.put("di", com.rtk.app.tool.y.r(this.k));
        String z = com.rtk.app.tool.y.z("token");
        String z2 = com.rtk.app.tool.y.z("uid");
        k.put(z, com.rtk.app.tool.y.H());
        k.put(z2, com.rtk.app.tool.y.K());
        k.put("key", com.rtk.app.tool.t.L(k));
        com.rtk.app.tool.o.h.l(this.k, this, i, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(com.rtk.app.tool.y.w("bbs/detail", k)));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i != 1) {
            return;
        }
        k();
        PostDetailsBean postDetailsBean = (PostDetailsBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, PostDetailsBean.class);
        this.m = postDetailsBean;
        if (postDetailsBean != null && postDetailsBean.getData() != null && this.m.getData().getPostsBase() != null) {
            com.rtk.app.tool.t.c(this.k, this.m.getData().getPostsBase().getFace(), this.dialogForCommandIcon, new boolean[0]);
            this.dialogForCommandNickname.setText(this.m.getData().getPostsBase().getNickname());
            this.dialogForCommandTitle.setLeftText("帖子标题：");
            this.dialogForCommandTitle.setText(this.m.getData().getTitle());
            r();
            return;
        }
        com.rtk.app.tool.c0.s("DialogForPost", " postDetailsBean is null");
        dismiss();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        n(str, new a());
        com.rtk.app.tool.f.a(this.k, str, f.a.f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131297227) {
            com.rtk.app.tool.t.J0(this.k, this.l + "");
            dismiss();
            return;
        }
        dismiss();
    }

    public void r() {
        this.dialogForCommandParent.setOnClickListener(this);
    }
}
