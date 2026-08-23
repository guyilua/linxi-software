package com.rtk.app.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.bean.DataBean;
import com.rtk.app.tool.ApkInfo;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home1Item1GameGridViewAdapter$GameGridViewHolder {

    @BindView
    TextView home1Item1GameGridviewItemDownLoad;

    @BindView
    RelativeLayout home1Item1GameGridviewItemDownLoadLv;

    @BindView
    ImageView home1Item1GameGridviewItemIcon;

    @BindView
    TextView home1Item1GameGridviewItemName;

    @BindView
    ProgressBar home1Item1GameGridviewItemProgressBar;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements View.OnClickListener {
        final /* synthetic */ DataBean a;
        final /* synthetic */ Context b;

        a(Home1Item1GameGridViewAdapter$GameGridViewHolder home1Item1GameGridViewAdapter$GameGridViewHolder, DataBean dataBean, Context context) {
            this.a = dataBean;
            this.b = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.rtk.app.tool.DownLoadTool.r.g(this.b, new ApkInfo(this.a), (TextView) view);
        }
    }

    public Home1Item1GameGridViewAdapter$GameGridViewHolder(View view) {
        ButterKnife.b(this, view);
    }

    public void a(Context context, DataBean dataBean) {
        com.rtk.app.tool.t.d(context, dataBean.getGame_logo(), this.home1Item1GameGridviewItemIcon);
        this.home1Item1GameGridviewItemName.setText(dataBean.getGame_name());
        this.home1Item1GameGridviewItemDownLoad.setTag(Integer.valueOf(dataBean.getGame_id()));
        this.home1Item1GameGridviewItemDownLoad.setOnClickListener(new a(this, dataBean, context));
        com.rtk.app.tool.DownLoadTool.x.c().a(new com.rtk.app.tool.DownLoadTool.u(this.home1Item1GameGridviewItemProgressBar, dataBean.getGame_id(), this.home1Item1GameGridviewItemDownLoad));
        com.rtk.app.tool.DownLoadTool.r.h(context, new ApkInfo(dataBean), this.home1Item1GameGridviewItemDownLoad, this.home1Item1GameGridviewItemProgressBar);
    }
}
