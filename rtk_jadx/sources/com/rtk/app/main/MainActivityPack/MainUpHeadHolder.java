package com.rtk.app.main.MainActivityPack;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.custom.MarkedImageView;
import com.rtk.app.main.login.InformationActivity;
import com.rtk.app.tool.DownLoadTool.x;
import com.rtk.app.tool.y;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MainUpHeadHolder extends com.rtk.app.base.g implements View.OnClickListener {
    private com.rtk.app.tool.DownLoadTool.n j;

    @BindView
    MarkedImageView mainDownloadImg;

    @BindView
    ImageView mainHeadIcon;

    @BindView
    TextView mainHeadIconUpdataNum;

    @BindView
    TextView mainSearchTv;

    public MainUpHeadHolder(Context context, View view) {
        super(context, view);
    }

    @Override // com.rtk.app.base.g
    public void h(Context context, View view) {
        this.mainSearchTv.setOnClickListener(this);
        this.mainHeadIcon.setOnClickListener(this);
        this.mainDownloadImg.setOnClickListener(this);
    }

    @Override // com.rtk.app.base.g
    public void i(Context context, View view) {
        ButterKnife.b(this, view);
        this.mainSearchTv.setHint("大家都在搜  你喜欢的UP");
        if (this.j == null) {
            this.j = new com.rtk.app.tool.DownLoadTool.n(this.mainDownloadImg);
        }
        x.c().b(this.j);
    }

    @Override // com.rtk.app.base.g
    public void j() {
        super.j();
        if (this.j != null) {
            x.c().n(this.j);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_download_img /* 2131299014 */:
                com.rtk.app.tool.t.o0(this.a);
                return;
            case R.id.main_head_icon /* 2131299015 */:
                if (y.x(this.a)) {
                    com.rtk.app.tool.c.b((Activity) this.a, InformationActivity.class, null);
                    return;
                } else {
                    com.rtk.app.tool.t.w0(this.a);
                    return;
                }
            case R.id.main_search_tv /* 2131299022 */:
                com.rtk.app.tool.t.h1(this.a);
                return;
            default:
                return;
        }
    }
}
