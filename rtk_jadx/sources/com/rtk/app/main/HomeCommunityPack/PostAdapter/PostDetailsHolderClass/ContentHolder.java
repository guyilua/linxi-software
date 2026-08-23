package com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsHolderClass;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;
import com.rtk.app.bean.PostDetailsBean;
import com.rtk.app.tool.c0;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ContentHolder extends RecyclerView.ViewHolder {
    private LinearLayout a;

    public ContentHolder(View view) {
        super(view);
        LinearLayout linearLayout = (LinearLayout) view;
        this.a = linearLayout;
        ButterKnife.b(this, linearLayout);
    }

    public void b(Context context, PostDetailsBean.DataBean dataBean) {
        try {
            this.a.removeAllViews();
            try {
                if (!c0.q(dataBean.getDisplay_mode()) && !dataBean.getDisplay_mode().endsWith("2")) {
                    this.a.removeAllViews();
                    this.a.addView(a.g(context));
                    return;
                }
            } catch (NullPointerException unused) {
            }
            c0.u("ContentHolder", "帖子内容  " + dataBean.getContent());
            a.o(context, this.a, dataBean.getContent(), dataBean.getList_post_user(), dataBean.getList_post_post(), dataBean.getList_post_upfile(), dataBean.getList_post_game(), dataBean.getList_post_img(), dataBean.getList_post_video());
        } catch (Exception e) {
            c0.u("ContentHolder", "评论异常" + e.toString());
        }
    }

    public void c() {
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }
}
