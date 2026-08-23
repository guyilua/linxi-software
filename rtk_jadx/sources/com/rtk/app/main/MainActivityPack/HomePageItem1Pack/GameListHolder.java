package com.rtk.app.main.MainActivityPack.HomePageItem1Pack;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.adapter.d3;
import com.rtk.app.bean.DataBean;
import com.rtk.app.main.MyApplication;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.DownLoadTool.r;
import com.rtk.app.tool.DownLoadTool.u;
import com.rtk.app.tool.DownLoadTool.x;
import com.rtk.app.tool.t;
import com.zhy.view.flowlayout.TagFlowLayout;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GameListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public View a;
    private DataBean b;

    @BindView
    public TextView gameListViewItemVersion;

    @BindView
    public TextView gameListviewItemDownLoad;

    @BindView
    public TextView gameListviewItemGameName;

    @BindView
    public ImageView gameListviewItemIcon;

    @BindView
    public TextView gameListviewItemLanguage;

    @BindView
    public ProgressBar gameListviewItemProgressBar;

    @BindView
    public ImageView gameListviewItemRang;

    @BindView
    public TextView gameListviewItemSize;

    @BindView
    public TagFlowLayout gameListviewItemTag;

    @BindView
    public TextView gameListviewItemType;

    public GameListHolder(View view) {
        super(view);
        ButterKnife.b(this, view);
        this.a = view;
        b();
    }

    private void b() {
        this.a.setOnClickListener(this);
        this.gameListviewItemDownLoad.setOnClickListener(this);
    }

    private void c() {
        t.d(MyApplication.b(), this.b.getGame_logo(), this.gameListviewItemIcon);
        this.gameListviewItemGameName.setText(this.b.getGame_name());
        this.gameListviewItemLanguage.setText(this.b.getLangues());
        this.gameListviewItemTag.setAdapter(new d3(this.b.getTag_name(), MyApplication.b()));
        this.gameListviewItemType.setText(this.b.getGame_type());
        this.gameListviewItemSize.setText(this.b.getPackage_size());
        this.gameListViewItemVersion.setText("V" + this.b.getGame_version());
        t.R1(this.b.getGame_level(), this.gameListviewItemRang);
        this.gameListviewItemDownLoad.setTag(Integer.valueOf(this.b.getGame_id()));
        x.c().a(new u(this.gameListviewItemProgressBar, this.b.getGame_id(), this.gameListviewItemDownLoad));
        r.h(MyApplication.b(), new ApkInfo(this.b), this.gameListviewItemDownLoad, this.gameListviewItemProgressBar);
    }

    public void e(DataBean dataBean) {
        this.b = dataBean;
        c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131297750) {
            t.e0(MyApplication.b(), new ApkInfo(this.b));
        } else {
            r.g(MyApplication.b(), new ApkInfo(this.b), (TextView) view);
        }
    }
}
