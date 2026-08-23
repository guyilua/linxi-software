package com.rtk.app.main.MainActivityPack;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.MarkedImageView;
import com.rtk.app.main.HomeCommunityPack.SearchPostOrUserActivity;
import com.rtk.app.main.SearchActivity;
import com.rtk.app.main.login.InformationActivity;
import com.rtk.app.tool.DownLoadTool.x;
import com.rtk.app.tool.y;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class HomeHeadTopLayout extends com.rtk.app.base.g implements View.OnClickListener {
    private com.rtk.app.tool.DownLoadTool.n j;
    private View k;
    private Context l;
    private ViewHolder m;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    protected static class ViewHolder {
        protected View a;

        @BindView
        MarkedImageView mainDownloadImg;

        @BindView
        ImageView mainHeadIcon;

        @BindView
        TextView mainHeadIconUpdataNum;

        @BindView
        TextView mainSearchTv;

        ViewHolder(View view) {
            ButterKnife.b(this, view);
            this.a = view;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.mainHeadIcon = (ImageView) butterknife.c.a.c(view, R.id.main_head_icon, "field 'mainHeadIcon'", ImageView.class);
            viewHolder.mainHeadIconUpdataNum = (TextView) butterknife.c.a.c(view, R.id.main_head_icon_updataNum, "field 'mainHeadIconUpdataNum'", TextView.class);
            viewHolder.mainSearchTv = (TextView) butterknife.c.a.c(view, R.id.main_search_tv, "field 'mainSearchTv'", TextView.class);
            viewHolder.mainDownloadImg = (MarkedImageView) butterknife.c.a.c(view, R.id.main_download_img, "field 'mainDownloadImg'", MarkedImageView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.mainHeadIcon = null;
                viewHolder.mainHeadIconUpdataNum = null;
                viewHolder.mainSearchTv = null;
                viewHolder.mainDownloadImg = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.rtk.app.tool.c.b((Activity) HomeHeadTopLayout.this.l, SearchPostOrUserActivity.class, new Bundle());
        }
    }

    public HomeHeadTopLayout(Context context, View view) {
        super(context, view);
        this.l = context;
        this.k = view;
    }

    @Override // com.rtk.app.base.g
    public void h(Context context, View view) {
        this.m.mainDownloadImg.setOnClickListener(this);
        this.m.mainSearchTv.setOnClickListener(this);
        this.m.mainHeadIcon.setOnClickListener(this);
    }

    @Override // com.rtk.app.base.g
    public void i(Context context, View view) {
        ViewHolder viewHolder = new ViewHolder(view);
        this.m = viewHolder;
        if (this.j == null) {
            this.j = new com.rtk.app.tool.DownLoadTool.n(viewHolder.mainDownloadImg);
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

    @Override // com.rtk.app.base.g
    public void k() {
        super.k();
        this.m.a.setBackgroundResource(com.rtk.app.tool.t.F(this.l, new boolean[0]));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_download_img /* 2131299014 */:
                com.rtk.app.tool.t.o0(this.l);
                return;
            case R.id.main_head_icon /* 2131299015 */:
                if (y.x(this.l)) {
                    com.rtk.app.tool.c.b((Activity) this.l, InformationActivity.class, null);
                    return;
                } else {
                    com.rtk.app.tool.t.w0(this.l);
                    return;
                }
            case R.id.main_search_tv /* 2131299022 */:
                com.rtk.app.tool.c.b((Activity) this.l, SearchActivity.class, null);
                return;
            default:
                return;
        }
    }

    public void s() {
        this.m.mainSearchTv.setText("大家都在搜  你喜欢的帖子");
        this.m.mainSearchTv.setOnClickListener(new a());
    }
}
